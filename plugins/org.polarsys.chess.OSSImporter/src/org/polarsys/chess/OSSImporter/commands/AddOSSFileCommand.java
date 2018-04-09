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

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.polarsys.chess.OSSImporter.actions.ImportOSSFileAction;
import org.polarsys.chess.OSSImporter.exceptions.ImportException;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.service.gui.utils.SelectionUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import eu.fbk.eclipse.standardtools.utils.ui.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.utils.ui.utils.DialogUtil;
import eu.fbk.eclipse.standardtools.xtextService.ui.services.RuntimeErrorService;

public class AddOSSFileCommand extends AbstractJobCommand implements IHandler {
	private static final String DIALOG_TITLE =	"OSS parser";
	
	final DialogUtil dialogUtil = DialogUtil.getInstance();
	
	/**
	 * Constructor.
	 */
	public AddOSSFileCommand() {
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
					IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
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
