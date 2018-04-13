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
package org.polarsys.chess.OSSImporter.commands;

import java.io.File;
import java.util.Collection;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.diagram.ui.OffscreenEditPartFactory;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.polarsys.chess.OSSImporter.actions.ImportOSSFileAction;
import org.polarsys.chess.OSSImporter.exceptions.ImportException;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.diagram.ui.docGenerators.CHESSBlockDefinitionDiagramModel;
import org.polarsys.chess.diagram.ui.docGenerators.CHESSInternalBlockDiagramModel;
import org.polarsys.chess.diagram.ui.services.CHESSDiagramsGeneratorService;
import org.polarsys.chess.diagramsCreator.actions.ShowBDDElementsAction;
import org.polarsys.chess.diagramsCreator.actions.ShowIBDElementsAction;
import org.polarsys.chess.service.gui.utils.SelectionUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Class;
import eu.fbk.eclipse.standardtools.utils.ui.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.utils.ui.utils.DialogUtil;
import eu.fbk.eclipse.standardtools.xtextService.ui.services.RuntimeErrorService;

/**
 * Class that starts the parsing of a file in OCRA format.
 * It is triggered by the contextual menu item on an entire package.
 * @author cristofo
 *
 */
public class ImportOSSFileCommand extends AbstractJobCommand implements IHandler {
	private static final String DIALOG_TITLE =	"OSS parser";
	private static final String IBD = "InternalBlock";
	private static final String BDD = "BlockDefinition";
	
	final DialogUtil dialogUtil = DialogUtil.getInstance();
	
	/**
	 * Constructor.
	 */
	public ImportOSSFileCommand() {
		super("Add content from OSS file");
	}
	
	/**
	 * Displays a file dialog to select the OSS file
	 * @return the selected File
	 */
	private File getOSSFile() {
		File ossFile = null;

		FileDialog dialog = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.OPEN);
		dialog.setFilterExtensions(new String [] {"*.oss", "*.OSS"});
		String result = dialog.open();
		
		if (result != null) {
			try {
				ossFile = new File(result);
			} catch (NullPointerException e) {
				e.printStackTrace();
				dialogUtil.showMessage_GenericMessage(DIALOG_TITLE, "File not valid!");
			}
		}
		return ossFile;
	}
	
	@Override
	public void execPreJobOperations(ExecutionEvent event, IProgressMonitor monitor) throws Exception {

		final ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		final SelectionUtil selectionUtil = SelectionUtil.getInstance();
		final Object umlObject = selectionUtil.getUmlSelectedObject(selection);
		final Resource modelResource = selectionUtil.getSelectedModelResource();
		final EntityUtil entityUtil = EntityUtil.getInstance();
	
		if (entityUtil.isSystemViewPackage((Element) umlObject)) {
			final File ossFile = getOSSFile();

			if (ossFile != null) {
				// Check if there are errors in the OSS file
				final boolean isValid = RuntimeErrorService.getInstance().showOSSRuntimeErrors(ossFile, modelResource, true, false, monitor);
				
				monitor.beginTask("Importing elements from OSS file", 1);
	
				final ImportOSSFileAction action = ImportOSSFileAction.getInstance();
	
				if (isValid && action != null) {
					
					// Hide the active page in order to avoid popups appearing
					final IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
					activePage.setEditorAreaVisible(false);
					try {
						final StringBuffer importErrors = action.startParsing((Package) umlObject, ossFile);
						if (importErrors.length() != 0) {
							dialogUtil.showMessage_GenericMessage(DIALOG_TITLE, importErrors.toString());
						}
					} catch (ImportException e) {
						dialogUtil.showMessage_GenericMessage(DIALOG_TITLE, e.getMessage());
						monitor.done();
						return;					
					} catch (Exception e) {
						e.printStackTrace();
						dialogUtil.showMessage_GenericMessage(DIALOG_TITLE, e.toString());
						monitor.done();
						return;
					}
										
					// Restore the active page
					activePage.setEditorAreaVisible(true);
					
					dialogUtil.showMessage_GenericMessage(DIALOG_TITLE, "Import done!");

					// Update all the diagrams of the model
					final CHESSDiagramsGeneratorService chessDiagramsGeneratorService = 
							CHESSDiagramsGeneratorService.getInstance(CHESSInternalBlockDiagramModel.getInstance(), CHESSBlockDefinitionDiagramModel.getInstance());			
					final Collection<Diagram> chessDiagrams = chessDiagramsGeneratorService.getDiagrams();
					final Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
					
					boolean showMessage = false;
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

							// Get the EditPart associated to the diagram and refresh the diagram
							final IGraphicalEditPart diagramEP = OffscreenEditPartFactory.getInstance().createDiagramEditPart(diagram, shell);
							ShowBDDElementsAction.getInstance().refreshDiagram(diagramEP);
							showMessage = true;
						} else if (diagram.getType().equals(IBD)) {

							// Get the EditPart associated to the diagram and refresh the diagram
							final IGraphicalEditPart diagramEP = OffscreenEditPartFactory.getInstance().createDiagramEditPart(diagram, shell);
							ShowIBDElementsAction.getInstance().refreshDiagram(diagramEP);
							showMessage = true;
						}
					}
					
					// Display updated diagrams message only if some diagrams were present
					if (showMessage) {
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
}
