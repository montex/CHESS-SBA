/*******************************************************************************
 * Copyright (C) 2018 Fondazione Bruno Kessler.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *     Luca Cristoforetti - initial API and implementation
 *     Alberto Debiasi - some updates
 ******************************************************************************/
package org.polarsys.chess.OSSImporter.commands;

import java.io.File;
import java.util.Collection;
import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.diagram.ui.OffscreenEditPartFactory;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.polarsys.chess.OSSImporter.core.actions.ImportOSSFileAction;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.diagram.ui.docGenerators.CHESSBlockDefinitionDiagramModel;
import org.polarsys.chess.diagram.ui.docGenerators.CHESSInternalBlockDiagramModel;
import org.polarsys.chess.diagram.ui.services.CHESSDiagramsGeneratorService;
import org.polarsys.chess.diagramsCreator.actions.ShowBDDElementsAction;
import org.polarsys.chess.diagramsCreator.actions.ShowIBDElementsAction;
import org.polarsys.chess.service.gui.utils.SelectionUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Class;
import eu.fbk.eclipse.standardtools.utils.ui.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.utils.ui.utils.DialogUtil;
import eu.fbk.eclipse.standardtools.xtextService.ui.services.RuntimeErrorService;

/**
 * Class that starts the parsing of a file in OCRA format. It is triggered by
 * the contextual menu item on an entire package.
 * 
 * @author cristofo
 *
 */
public class ImportOSSFileCommand extends AbstractJobCommand implements IHandler {

	private static final Logger logger = Logger.getLogger(ImportOSSFileCommand.class);

	private static final String DIALOG_TITLE = "OSS parser";
	private static final String IBD = "InternalBlock";
	private static final String BDD = "BlockDefinition";

	final DialogUtil dialogUtil = DialogUtil.getInstance();

	/**
	 * Constructor.
	 */
	public ImportOSSFileCommand() {
		super("Add content from OSS file");
	}

	@Override
	public void execPreJobOperations(ExecutionEvent event, IProgressMonitor monitor) throws Exception {

		final EntityUtil entityUtil = EntityUtil.getInstance();
		final SelectionUtil selectionUtil = SelectionUtil.getInstance();

		// get the parameters
		String packageURI = event.getParameter("packageURI");	
		String ossFilePath = event.getParameter("ossFilePath");

		logger.debug("packageURI: " + packageURI);
		logger.debug("ossFilePath: " + ossFilePath);

		final Object umlPackage;
		final Resource resource;

		// if parameters == null then take them from current CHESS session
		if (packageURI == null) {
			umlPackage = selectionUtil.getUmlSelectedObject(event);
			resource = selectionUtil.getSelectedUmlModel().getResource();
		} else {
			// umlPackage = (Package) entityUtil.getElement(projectName,
			// umlFileModelName, packageURI);
			Resource modelRes = SelectionUtil.getInstance().getSelectedModelResource();
			Model model = (org.eclipse.uml2.uml.Model) modelRes.getContents().get(0);
			umlPackage = (Package) EntityUtil.getInstance().getElement(model, packageURI);
			logger.debug("umlPackage: " + umlPackage);

			resource = ((Package) umlPackage).eResource();
		}

		if (entityUtil.isSystemViewPackage((Element) umlPackage)) {

			final File ossFile;

			if (ossFilePath != null) {
				ossFile = new File(ossFilePath);
			} else {
				ossFile = getOSSFileFromDialog();
			}

			if (ossFile != null) {
				// Check if there are errors in the OSS file
				final boolean isValid = RuntimeErrorService.getInstance().showOSSRuntimeErrors(ossFile, resource, true,
						false, monitor);

				monitor.beginTask("Importing elements from OSS file", 1);

				final ImportOSSFileAction action = ImportOSSFileAction.getInstance();

				if (isValid && action != null) {

					// Hide the active page in order to avoid popups appearing
					final IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
							.getActivePage();
					activePage.setEditorAreaVisible(false);
				
					final StringBuffer importErrors = action.startParsing((Package) umlPackage, ossFile);
					if (importErrors.length() != 0) {
						dialogUtil.showMessage_GenericMessage(DIALOG_TITLE, importErrors.toString());
					}
			
					// Restore the active page
					activePage.setEditorAreaVisible(true);
					dialogUtil.showMessage_GenericMessage(DIALOG_TITLE, "Import done!");

					boolean oneOrMoreDiagramsUpdated = updateDiagrams(umlPackage);

					// Display updated diagrams message only if some diagrams
					// were present
					if (oneOrMoreDiagramsUpdated) {
						dialogUtil.showMessage_GenericMessage(DIALOG_TITLE, "Diagrams updated!");
					}
				}
			}
			monitor.done();
			return;
		}
		dialogUtil.showMessage_GenericMessage(DIALOG_TITLE, "Please select a package from <<SystemView>>");
	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
	}

	private boolean updateDiagrams(Object umlObject) {

		// Update all the diagrams of the model
		final CHESSDiagramsGeneratorService chessDiagramsGeneratorService = CHESSDiagramsGeneratorService.getInstance(
				CHESSInternalBlockDiagramModel.getInstance(), CHESSBlockDefinitionDiagramModel.getInstance());
		final Collection<Diagram> chessDiagrams = chessDiagramsGeneratorService.getDiagrams();
		final Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

		boolean oneOrMoreDiagramsUpdated = false;

		for (Diagram diagram : chessDiagrams) {

			// Get the package owner of the diagram
			Package activePackage = null;
			final EObject diagramElement = diagram.getElement();
			if (diagramElement instanceof Package) {
				activePackage = (Package) diagramElement;
			} else if (diagramElement instanceof Class) {
				activePackage = ((Class) diagramElement).getPackage();
			}

			// Check to see if the diagram is of the same package
			if (activePackage != umlObject) {
				continue;
			}

			if (diagram.getType().equals(BDD)) {

				// Get the EditPart associated to the diagram and refresh the
				// diagram
				final IGraphicalEditPart diagramEP = OffscreenEditPartFactory.getInstance()
						.createDiagramEditPart(diagram, shell);
				ShowBDDElementsAction.getInstance().refreshDiagram(diagramEP);
				oneOrMoreDiagramsUpdated = true;
			} else if (diagram.getType().equals(IBD)) {

				// Get the EditPart associated to the diagram and refresh the
				// diagram
				final IGraphicalEditPart diagramEP = OffscreenEditPartFactory.getInstance()
						.createDiagramEditPart(diagram, shell);
				ShowIBDElementsAction.getInstance().refreshDiagram(diagramEP);
				oneOrMoreDiagramsUpdated = true;
			}
		}

		return oneOrMoreDiagramsUpdated;
	}

	/**
	 * Displays a file dialog to select the OSS file
	 * 
	 * @return the selected File
	 * @throws Exception
	 */
	private File getOSSFileFromDialog() throws Exception {
		File ossFile = null;

		FileDialog dialog = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.OPEN);
		dialog.setFilterExtensions(new String[] { "*.oss", "*.OSS" });
		String result = dialog.open();

		if (result != null) {
			try {
				ossFile = new File(result);
			} catch (NullPointerException e) {
				throw new Exception("File not valid!");
			}
		}
		return ossFile;
	}
}
