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
/**
 * Logic from: QVTOML/Examples/InvokeInJava
 * http://wiki.eclipse.org/QVTOML/Examples/InvokeInJava
 */

package org.polarsys.chess.fla.transformations;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.m2m.qvt.oml.util.WriterLog;
import org.polarsys.chess.core.util.CHESSProjectSupport;
import org.polarsys.chess.fla.launch.Activator;
import org.polarsys.chess.fla.flamm.FlammPackage;
import org.polarsys.chess.fla.flaxml.FlaxmlPackage;

public class QVToTransformation {
	
	private static final String SELECTED_PLATFORM_PROPERTY = "selectedPlatformQName";
	private static final String CHESS2FLAMM = "platform:/plugin/org.polarsys.chess.fla.transformations/transforms/Chess2FlaMM.qvto";
	private static final String FLAMM2FLAXML = "platform:/plugin/org.polarsys.chess.fla.transformations/transforms/FlaMM2FlaXML.qvto";
	private static final String FLAXML2FLAMM = "platform:/plugin/org.polarsys.chess.fla.transformations/transforms/FlaXML2FlaMM.qvto";
	private static final String FLAMM2CHESS = "platform:/plugin/org.polarsys.chess.fla.transformations/transforms/FlaMM2Chess_BackPropagation.qvto";
	
	boolean isChessUserAction;
	private DiagramEditPart diagramEditPart = null;
	private Resource sourceResource;
	private Resource targetResource;
	private boolean isTargetChessModel= false;
	private boolean createNewModel = true;
	private IProgressMonitor monitor;
	private String selectedElement = null;
	
	public void performChess2ConcertoFlaTransformation(
			Resource chessResource, Resource flaResource, IProgressMonitor monitor, String selectedElement) {
		FlammPackage.eINSTANCE.getClass();
		this.sourceResource = chessResource;
		this.targetResource = flaResource;
		this.monitor = monitor;
		this.selectedElement = selectedElement;
		performTransformation(CHESS2FLAMM);
	}
	
	public void performConcertoFla2ConcertoFlaXMLTransformation(
			Resource modelResource, Resource xmlResource, IProgressMonitor monitor) {
		FlaxmlPackage.eINSTANCE.getClass();
		this.sourceResource = modelResource;
		this.targetResource = xmlResource;
		this.monitor = monitor;
		performTransformation(FLAMM2FLAXML);
	}
	
	public void performConcertoFlaXml2ConcertoFlaTransformation(
			Resource xmlResource, Resource modelResource, IProgressMonitor monitor) {
		FlammPackage.eINSTANCE.getClass();
		FlaxmlPackage.eINSTANCE.getClass();
		this.sourceResource = xmlResource;
		this.targetResource = modelResource;
		this.monitor = monitor;
		performTransformation(FLAXML2FLAMM);
	}
	
	public void performConcertoFla2ChessBackPropagation(
			Resource flaResource, final Resource chessResource, IProgressMonitor monitor, String selectedElement, DiagramEditPart diagramEditPart) {
		this.sourceResource = flaResource;
		this.targetResource = chessResource;
		this.monitor = monitor;
		this.selectedElement = selectedElement;
		this.diagramEditPart = diagramEditPart;
		this.isTargetChessModel = true;
		this.createNewModel = false;
		performTransformation(FLAMM2CHESS);
	}
	
	private void performTransformation(String transformationPath) {
		URI transformationURI = URI.createURI(transformationPath);
		final TransformationExecutor executor = new TransformationExecutor(transformationURI );
		
		EList<EObject> inObjects = sourceResource.getContents();
		final ModelExtent input = new BasicModelExtent(inObjects);
		ModelExtent output;
		if (createNewModel) {
			output = new BasicModelExtent();
		} else {
			output = new BasicModelExtent(targetResource.getContents());
		}
		
		final ExecutionContextImpl context = new ExecutionContextImpl();
		
		if (selectedElement != null) {
			context.setConfigProperty(SELECTED_PLATFORM_PROPERTY, selectedElement);
		}
		
		OutputStreamWriter s = new OutputStreamWriter(CHESSProjectSupport.CHESS_CONSOLE);
		context.setLog(new WriterLog(s));
		context.setProgressMonitor(monitor);
		
		if (isTargetChessModel) {
			try {
         	final ModelExtent finalOutput = output;
				TransactionalEditingDomain editingDomain = diagramEditPart.getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
	            protected void doExecute() {
	      			ExecutionDiagnostic result = executor.execute(context, input, finalOutput);
	      			if(result.getSeverity() != Diagnostic.OK) {
	      				// turn the result diagnostic into status and send it to error log			
	      				IStatus status = BasicDiagnostic.toIStatus(result);
	      				Activator.getDefault().getLog().log(status);
	      			}
	            }
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			ExecutionDiagnostic result = executor.execute(context, input, output);

			if(result.getSeverity() == Diagnostic.OK) {
				// the output objects got captured in the output extent
				final List<EObject> outObjects = output.getContents();
				// persist them using a resource 
				targetResource.getContents().clear();
				targetResource.getContents().addAll(outObjects);

				try {
					targetResource.save(Collections.EMPTY_MAP);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				// turn the result diagnostic into status and send it to error log
				//TODO: Handle errors, abort analysis
				IStatus status = BasicDiagnostic.toIStatus(result);
				Activator.getDefault().getLog().log(status);
			}
		}
		
		
	}
	
	protected boolean saveChessResource(final Resource chessResource, final List<EObject> outObjects) {
		try {
			TransactionalEditingDomain editingDomain = diagramEditPart.getEditingDomain();
			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
            protected void doExecute() {
            	chessResource.getContents().clear();
            	chessResource.getContents().addAll(outObjects);
            }
			});
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
