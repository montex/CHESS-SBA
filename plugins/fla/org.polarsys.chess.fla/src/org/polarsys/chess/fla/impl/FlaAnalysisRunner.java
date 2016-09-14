/*******************************************************************************
 *                  CHESS core plugin
 *
 *               Copyright (C) 2011-2015
 *            Mälardalen University, Sweden
 *
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License
 *  v1.0 which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.polarsys.chess.fla.impl;

import static org.polarsys.chess.core.util.CHESSProjectSupport.printlnToCHESSConsole;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.jface.operation.IRunnableWithProgress;

import org.polarsys.chess.fla.common.FlaAnalysisException;
import org.polarsys.chess.fla.common.FlaLogger;
import org.polarsys.chess.fla.common.TransformationException;
import org.polarsys.chess.fla.flamm.Component;
import org.polarsys.chess.fla.flamm.FlammPackage;
import org.polarsys.chess.fla.flamm.analysis.FlaSystem;
import org.polarsys.chess.fla.preferences.FlaParameters;
import org.polarsys.chess.fla.transformations.QVToTransformation;

public class FlaAnalysisRunner implements IRunnableWithProgress{

	protected static final String FLA_MM_EXTENSION = "flamm";
	protected static final String FLA_XML_EXTENSION = "flaxml";

	protected IContainer targetFolder;
	protected FlaSystem analyzedSystem;
	protected URI chessModelUri;
	protected Resource chessResource;
	protected Resource flaResource;
	protected String rootComponentQualifiedName = "";
	protected DiagramEditPart diagramEditPart;
	
	public IContainer getTargetFolder() {
		return targetFolder;
	}

	public void setTargetFolder(IContainer targetFolder) {
		this.targetFolder = targetFolder;
	}

	public URI getModelURI() {
		return chessModelUri;
	}

	public void setModelURI(URI modelURI) {
		this.chessModelUri = modelURI;
	}
	
	public void setRootComponent(String rootComponentQualifiedName) {
		this.rootComponentQualifiedName = rootComponentQualifiedName;
	}

	public Resource getChessResource() {
		return chessResource;
	}

	public void setChessResource(Resource chessResource) {
		this.chessResource = chessResource;
	}

	public void setDiagramEditPart(DiagramEditPart diagramEditPart) {
		this.diagramEditPart = diagramEditPart;
	}

	@Override
	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
		final int numSubTasks = 4;
			
		try {
			monitor.beginTask("Running Failure Logic Analysis...",numSubTasks );
			if (monitor.isCanceled()) {
				throw new InterruptedException();
			}

			monitor.subTask("Performing model transformations...");
			runInput2FlaTransformation(monitor);
			monitor.worked(1);
			
			if (monitor.isCanceled()) {
				throw new InterruptedException();
			}

			monitor.subTask("Applying failure propagation...");
			analyzeModel(flaResource);
			monitor.worked(1);
			
			if (monitor.isCanceled()) {
				throw new InterruptedException();
			}

			monitor.subTask("Propagating analysis results to the model...");
			backpropagateAnalysisResults(this.analyzedSystem, monitor);
			createOutputXmlFile(this.analyzedSystem, monitor);
			monitor.worked(1);

			Thread.sleep(1000);
		} catch (TransformationException e) {
			printlnToCHESSConsole("*** Error running FLA transformation ***");
			showErrorMessage("FLA Analysis", "Error during FLA transformation");
			return;
		} catch (FlaAnalysisException e) {
			printlnToCHESSConsole("*** Error running FLA Analysis ***");
			printlnToCHESSConsole(e.toString());
			showErrorMessage("FLA Analysis", "Error during FLA analysis");
			return;
		}

		printlnToCHESSConsole("*** Concerto-FLA analysis was performed successfully ***");
		monitor.done();
	}
	
	protected void analyzeModel(Resource resource) throws FlaAnalysisException {
		analyzeModel((org.polarsys.chess.fla.flamm.Component) resource.getContents().get(0));
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			throw new FlaAnalysisException(e);
		}
	}
	
	protected void analyzeModel(Component component) throws FlaAnalysisException {
		FlaSystem system = new FlaSystem(component);
		analyzeModel(system);
	}
	
	protected void analyzeModel(FlaSystem system) throws FlaAnalysisException {
		setPreferences(system);
		
		org.polarsys.chess.fla.flamm.analysis.FlaLogger logger = new FlaLogger();
		system.performAnalysis(logger);
		if (!logger.getWarnings().isEmpty()) {
			showErrorMessages("Warnings during analysis", logger.getWarnings());
		}
		analyzedSystem = system;
	}
	
	protected void setPreferences(FlaSystem system) {
		FlaParameters params = FlaParameters.getCurrentParameters();
		system.initializeNoFailure(params.getInitNoFailure());
		system.propagateUnmatchedFailures(params.getPropagateUnmatchedFailures());
		system.treatUnmentionedPortsAsWildcards(params.getTreatUnmentionedPortsAsWildcards());
	}
	
	protected void createOutputXmlFile(FlaSystem system, IProgressMonitor monitor) {
		String xmlPath = getOutputXmlPath();
		File outputFile = new File(xmlPath);
		outputFile.delete();
		
//		FlaXmlWriter writer = new FlaXmlWriter(outputFile);
//		writer.printSystem(system);
		
		try {
			runFla2XmlTransformation(monitor);
		} catch (TransformationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void backpropagateAnalysisResults(FlaSystem system, IProgressMonitor monitor) {
		try {
			runBackpropagationTransformation(monitor);
		} catch (TransformationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void runInput2FlaTransformation(IProgressMonitor monitor) throws TransformationException{
		FlammPackage.eINSTANCE.getClass();
		ResourceSet resourceSet = new ResourceSetImpl();
		URI flaMMuri = createFlaModelUri().appendFileExtension(FLA_MM_EXTENSION);
		new File(flaMMuri.path()).delete();
		flaResource = resourceSet.createResource(flaMMuri);
		
		QVToTransformation transformation = new QVToTransformation();
		transformation.performChess2ConcertoFlaTransformation(chessResource, flaResource, monitor, rootComponentQualifiedName + "_instSpec");
		if (flaResource.getContents() == null || flaResource.getContents().isEmpty()) {
			throw new TransformationException();
		}
	}
	
	protected void runFla2XmlTransformation(IProgressMonitor monitor) throws TransformationException{
		ResourceSet resourceSet = new ResourceSetImpl();
		
		URI xmlUri = createFlaModelUri().appendFileExtension(FLA_XML_EXTENSION);
		
		Resource xmlResource = resourceSet.createResource(xmlUri);
		xmlResource.setURI(xmlUri.trimFileExtension().appendFileExtension("xml"));
		QVToTransformation transformation = new QVToTransformation();
		transformation.performConcertoFla2ConcertoFlaXMLTransformation(flaResource, xmlResource, monitor);
	}
	
	protected void runBackpropagationTransformation(IProgressMonitor monitor) throws TransformationException{
		QVToTransformation transformation = new QVToTransformation();
		transformation.performConcertoFla2ChessBackPropagation(flaResource, chessResource, monitor, rootComponentQualifiedName + "_instSpec", diagramEditPart);
	}
	
	protected URI createFlaModelUri() {
		String modelName = getModelName();
		String flaPath = targetFolder.getFullPath().toString() + "/" + modelName + "." + rootComponentQualifiedName.replaceAll("::", ".") + "_result";
		return URI.createPlatformResourceURI(flaPath, false);
	}

	protected String getOutputXmlPath() {
		String modelName = getModelName();
		return targetFolder.getLocation().append(modelName + "_result.xml").toString();
	}
	
	protected String getModelName() {
		return chessModelUri.lastSegment().substring(0, chessModelUri.lastSegment().lastIndexOf('.'));
	}
	
	protected void showErrorMessages(String title, List<String> messages) {
		StringBuilder sb = new StringBuilder();
		for (String message : messages) {
			sb.append(message + "\n");
		}
		showErrorMessage(title, sb.toString());
	}
	
	protected void showErrorMessage(String title, String message) {
		JOptionPane.showMessageDialog(
				new JFrame(),
				message,
				title, JOptionPane.ERROR_MESSAGE);

	}
	
}

	



