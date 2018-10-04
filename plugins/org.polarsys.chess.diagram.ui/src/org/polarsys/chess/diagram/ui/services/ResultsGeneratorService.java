/*******************************************************************************
 * Copyright (C) 2018 Fondazione Bruno Kessler.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *     Luca Cristoforetti - initial API and implementation
 ******************************************************************************/
package org.polarsys.chess.diagram.ui.services;

import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Class;
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.ResultElement;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.contracts.transformations.utils.AnalysisResultUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.factory.SessionFactory;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.ui.business.api.dialect.ExportFormat;
import org.eclipse.sirius.ui.business.api.dialect.ExportFormat.ExportDocumentFormat;
import org.eclipse.sirius.ui.business.api.session.IEditingSession;
import org.eclipse.sirius.ui.business.api.session.SessionUIManager;
import org.eclipse.sirius.ui.tools.api.actions.export.SizeTooLargeException;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.sirius.common.tools.api.resource.ImageFileFormat;

import eu.fbk.eclipse.standardtools.diagram.ContainerDescriptor;
import eu.fbk.eclipse.standardtools.diagram.ContractFtaResultDescriptor;
import eu.fbk.eclipse.standardtools.diagram.DocumentGenerator;
import eu.fbk.eclipse.standardtools.diagram.FmeaResultDescriptor;
import eu.fbk.eclipse.standardtools.diagram.FtaResultDescriptor;
import eu.fbk.tools.adapter.xsap.ComputeFmeaTableResultBuilder;
import eu.fbk.tools.adapter.xsap.table.FmeaTable;
import eu.fbk.tools.adapter.xsap.table.FmeaTable.Row;

/**
 * This class creates and stores the result descriptors needed by the document generation.
 * @author cristofo
 *
 */
public class ResultsGeneratorService {
	private AnalysisResultUtil analysisResultUtil = AnalysisResultUtil.getInstance();
	private boolean showAnalysisResults;
	private String outputDirectoryName;
	
	public void setParametersBeforeDocumentGeneration(String outputDirectoryName, boolean showAnalysisResults) {
		this.outputDirectoryName = outputDirectoryName;
		this.showAnalysisResults = showAnalysisResults;
	}
	
	/**
	 * Creates a FmeaResultDescriptor from the given ResultElement.
	 * @param resultElement the element containing the data
	 * @return the newly created descriptor
	 */
	private FmeaResultDescriptor createFmeaResultDescriptor(ResultElement resultElement) {
		FmeaResultDescriptor fmeaResultDescriptor = new FmeaResultDescriptor();
		
		fmeaResultDescriptor.conditions = resultElement.getConditions();
		fmeaResultDescriptor.rootClass = EntityUtil.getInstance().getName(resultElement.getRoot());
		
		// Read the result file and parse the table
		final String fmeaFileName = resultElement.getFile();
		final File fmeaFile = new File(fmeaFileName);
		final ComputeFmeaTableResultBuilder resultBuilder = new ComputeFmeaTableResultBuilder();
		final FmeaTable fmeaTable = resultBuilder.unmarshalResult(fmeaFile);
		if( fmeaTable == null || fmeaTable.getRow() == null || fmeaTable.getRow().isEmpty() ) {
			System.out.println("Internal error while unmarshalling the result. For more info see the console");
			return null;
		}

		// Parse the rows and store them
		final List<Row> rows = fmeaTable.getRow();
		for (Row row : rows) {
			final String[] line = new String[3];
			line[0] = row.getEntry();
			line[1] = row.getFailureMode();
			line[2] = row.getFailureEffects();
			fmeaResultDescriptor.lines.add(line);
		}
				
		return fmeaResultDescriptor;
	}
	
	private String getEmftaFile(String fullPath) {
		String emftaFile = fullPath.substring(fullPath.lastIndexOf("/") + 1, fullPath.length());
		
		return emftaFile + ".emfta";
	}
	
	/**
	 * Returns the full path of the current opened project.
	 * @return
	 */
	private String getCurrentPath() {
		final IWorkbench iworkbench = PlatformUI.getWorkbench();
		final IWorkbenchWindow iworkbenchwindow = iworkbench.getActiveWorkbenchWindow();
		final IWorkbenchPage iworkbenchpage = iworkbenchwindow.getActivePage();
		final IEditorPart ieditorpart = iworkbenchpage.getActiveEditor();
		final IFileEditorInput input = (IFileEditorInput) ieditorpart.getEditorInput();
		final IFile inputfile = input.getFile();
		final IProject project = inputfile.getProject();

		System.out.println("current path = " + project.getLocation().toString());
		
		return project.getLocation().toString();
	}
	
	/**
	 * Exports the Sirius diagram on disk, in the same position as other diagrams.
	 * @param diagramPath the name of the .emfta diagram
	 * @return the path of the exported image
	 */
	private String exportSiriusDiagramToFile(String diagramPath) {
		
		// Save the active sessions, if any. Otherwise fresh diagrams won't be present in the file
		final Collection<IEditingSession> s = SessionUIManager.INSTANCE.getUISessions();
		for (IEditingSession iEditingSession : s) {
			final Session openSession = iEditingSession.getSession();
			openSession.save(new NullProgressMonitor());
		}
		
		final URI sessionResourceURI = URI.createFileURI(getCurrentPath() + File.separator + "representations.aird");
		Session session = null;
		try {
			session = SessionFactory.INSTANCE.createSession(sessionResourceURI, new NullProgressMonitor());
		} catch (CoreException e) {
			return null;
		}
		session.open(new NullProgressMonitor());
		
		// Get all the representations containing the requested diagram
		final String diagramName = getEmftaFile(diagramPath);
		final List<DRepresentation> myRepresentations = new ArrayList<DRepresentation>();
		final Collection<DRepresentation> allRepresentations = DialectManager.INSTANCE.getAllRepresentations(session);
		for (DRepresentation dRepresentation : allRepresentations) {
			if (dRepresentation.getName().equals(diagramName)) {
				System.out.println("\nfound the requested representation: " + diagramName);
				myRepresentations.add(dRepresentation);
			}
		}
		
		if (myRepresentations.size() != 0) {
			
			final String fileName = outputDirectoryName + File.separator + diagramName + ".svg";
		
			// Export the first representation as SVG image
			ExportFormat exportFormat = new ExportFormat(ExportDocumentFormat.NONE, ImageFileFormat.SVG);
			try {
				//			representation = myRepresentations.get(1);
				DialectUIManager.INSTANCE.export(myRepresentations.get(0), session, new Path(fileName),
						exportFormat, new NullProgressMonitor());
			} catch (SizeTooLargeException e) {
				return null;
			}
			return fileName;
		}
		return "notFound.gif";
	}
	
	/**
	 * Creates a FtaResultDescriptor from the given ResultElement.
	 * @param resultElement the element containing the data
	 * @return the newly created descriptor
	 */
	private FtaResultDescriptor createFtaResultDescriptor(ResultElement resultElement) {
		FtaResultDescriptor ftaResultDescriptor = new FtaResultDescriptor();
		
		ftaResultDescriptor.conditions = resultElement.getConditions();
		ftaResultDescriptor.rootClass = EntityUtil.getInstance().getName(resultElement.getRoot());
		ftaResultDescriptor.url = "notFound.gif";	// Will be updated later
		ftaResultDescriptor.url = exportSiriusDiagramToFile(resultElement.getFile());

		return ftaResultDescriptor;
	}
	
	/**
	 * Creates a FtaResultDescriptor from the given ResultElement.
	 * @param resultElement the element containing the data
	 * @return the newly created descriptor
	 */
	private ContractFtaResultDescriptor createContractFtaResultDescriptor(ResultElement resultElement) {
		ContractFtaResultDescriptor contractFtaResultDescriptor = new ContractFtaResultDescriptor();
		
		contractFtaResultDescriptor.rootClass = EntityUtil.getInstance().getName(resultElement.getRoot());
		contractFtaResultDescriptor.url = exportSiriusDiagramToFile(resultElement.getFile());
		
		return contractFtaResultDescriptor;
	}
	
	/**
	 * Creates and adds the result descriptors to the given component. Only if the component is the 
	 * System component.
	 * @param selectedComponent the selected component
	 * @param activePackage the package containing the results
	 * @param documentGenerator the documentGenerator
	 */
	public void addResultsDescriptors(Class selectedComponent, Package activePackage, DocumentGenerator documentGenerator) {
		
		// Check if the selected component is the system component. If not, don't add the result section
		if (selectedComponent != EntityUtil.getInstance().getSystemComponent(activePackage)) {
			System.out.println("The selected element is not the System element, results section won't be created");
			return;
		}
		
		if (!showAnalysisResults) {
			return;
		}
		
		// Select the correct view where to find the results
		final Package dependabilityView = analysisResultUtil.getDependabilityViewFromPackage(activePackage);	
		if (dependabilityView == null) {
			return;
		}
		
		// Get the correct package containing the results
		final Package resultsPackage = dependabilityView.getNestedPackage(activePackage.getName());
		if (resultsPackage == null) {
			return;
		}
		
		final EList<NamedElement> members = resultsPackage.getOwnedMembers();
		for (NamedElement namedElement : members) {
			final ResultElement resultElement = analysisResultUtil.getResultElementFromUmlElement(namedElement);
			final ContainerDescriptor rootContainer = documentGenerator.getRootContainerDescriptor();

			if (resultElement != null) {
				final String resultType = resultElement.getType();

				if (resultType.equals(AnalysisResultUtil.FMEA_ANALYSIS)) {
					final FmeaResultDescriptor fmeaResultDescriptor = createFmeaResultDescriptor(resultElement);				
					rootContainer.fmeaResultDescriptors.add(fmeaResultDescriptor);
					
				} else if (resultType.equals(AnalysisResultUtil.FTA_ANALYSIS)) {
					final FtaResultDescriptor ftaResultDescriptor = createFtaResultDescriptor(resultElement);
					rootContainer.ftaResultDescriptors.add(ftaResultDescriptor);
				} else if (resultType.equals(AnalysisResultUtil.CONTRACT_BASED_FTA_ANALYSIS)) {
					final ContractFtaResultDescriptor contractFtaResultDescriptor = 
							createContractFtaResultDescriptor(resultElement);					
					rootContainer.contractFtaResultDescriptors.add(contractFtaResultDescriptor);
				}
				//TODO: implementare anche gli altri casi...
			}
		}
	}
}
