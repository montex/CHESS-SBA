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
package org.polarsys.chess.service.gui.utils;

import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import eu.fbk.eclipse.standardtools.utils.core.utils.DirectoryUtil;

/**
 * 
 *
 */
public class DialogUtils {

	private DirectoryUtil directoryUtils = DirectoryUtil.getInstance();
	private static DialogUtils exportDialogUtils;

	public static DialogUtils getInstance() {
		if (exportDialogUtils == null) {
			exportDialogUtils = new DialogUtils();
		}
		return exportDialogUtils;
	}

	
	
	public String getDirectoryNameFromDialog() throws Exception {
		final Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

		final DirectoryDialog directoryDialog = new DirectoryDialog(shell);
		directoryDialog.setText("Select the directory");
		directoryDialog.setFilterPath(directoryUtils.getCurrentProjectDir());
		String directoryName = directoryDialog.open();

		return directoryName;
	}


}
