/*******************************************************************************
 * Copyright (C) 2017 Fondazione Bruno Kessler.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Alberto Debiasi - initial API and implementation
 ******************************************************************************/
package org.polarsys.chess.diagram.ui.utils;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import eu.fbk.eclipse.standardtools.diagram.ui.dialog.ComponentToImageDialog;
import eu.fbk.eclipse.standardtools.diagram.ui.dialog.ModelToDocumentDialog;
import eu.fbk.eclipse.standardtools.utils.DirectoryUtil;

/**
 * 
 *
 */
public class ExportDialogUtils {

	private DirectoryUtil directoryUtils = DirectoryUtil.getInstance();
	private static ExportDialogUtils exportDialogUtils;

	public static ExportDialogUtils getInstance() {
		if (exportDialogUtils == null) {
			exportDialogUtils = new ExportDialogUtils();
		}
		return exportDialogUtils;
	}

	public void showMessage_ExportDone(String filePath) {

		Display defaultDisplay = Display.getDefault();

		defaultDisplay.syncExec(new Runnable() {
					@Override
					public void run() {		
					Shell currShell=defaultDisplay.getActiveShell();
					MessageDialog.openInformation(currShell, "Info",
							"The model is exported in " + filePath + ".");
					}
				});
			}
	
	public String getDirectoryNameFromDialog() throws Exception {
		final Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

		final DirectoryDialog directoryDialog = new DirectoryDialog(shell);
		directoryDialog.setText("Select the directory");
		// try {
		directoryDialog.setFilterPath(directoryUtils.getCurrentProjectDir());
		/*
		 * } catch(Exception e) { e.printStackTrace(); }
		 */
		// dd.setFilterPath(getWorkspace().getRoot().getLocation().toString());

		String directoryName = directoryDialog.open();

		return directoryName;
	}

	public String openImageDialog(String projectDir, String imageName) {
		//Shell shell2 = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		
		Shell shell = Display.getDefault().getActiveShell();

		//System.out.println("shell2: "+shell2);
		System.out.println("shell: "+shell);
		
		final FileDialog fd = new FileDialog(shell, SWT.SAVE);
		fd.setText("Set target file");
		// try {
		fd.setFilterPath(projectDir);
		/*
		 * } catch(Exception e) { e.printStackTrace(); }
		 */
		// fd.setFilterPath(getWorkspace().getRoot().getLocation().toString());

		final String[] filterExt = { "*.svg", "*.png", "*.pdf" };
		fd.setFilterExtensions(filterExt);

		fd.setFileName(imageName);

		final String fileName = fd.open();
		return fileName;
	}

	public ModelToDocumentDialog getCompiledModelToDocumentDialog() {
		final Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

		final ModelToDocumentDialog parameterDialog = new ModelToDocumentDialog(shell);		
		return parameterDialog;
	}

	public ComponentToImageDialog getCompiledComponentToImageDialog() {
		final Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

		final ComponentToImageDialog parameterDialog = new ComponentToImageDialog(shell);
		parameterDialog.open();
		return parameterDialog;
	}
}
