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
package org.polarsys.chess.smvExporter.ui.utils;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Utility class to display a dialog message.
 * @author cristofo
 *
 */
public class SMVGenerationDialogUtil {
	private static SMVGenerationDialogUtil smvGenerationDialogUtil;

	public static SMVGenerationDialogUtil getInstance() {
		if (smvGenerationDialogUtil == null) {
			smvGenerationDialogUtil = new SMVGenerationDialogUtil();
		}
		return smvGenerationDialogUtil;
	}

	/**
	 * Displays a message.
	 * @param filePath the name of the generated file
	 */
	public void showMessage_SmvGenerationDone(String filePath) {

		final Display defaultDisplay = Display.getDefault();

		defaultDisplay.syncExec(new Runnable() {
			public void run() {
				Shell currShell = defaultDisplay.getActiveShell();
				MessageDialog.openInformation(currShell, "Info",
						"The single SMV is exported as .smv file in " + filePath + ".");
			}
		});
	}
}
