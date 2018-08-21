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
package org.polarsys.chess.contracts.transformations.utils;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Utility class to display a dialog message.
 * @author cristofo
 *
 */
public class FMEAGenerationDialogUtil {
	private static FMEAGenerationDialogUtil fmeaGenerationDialogUtil;

	public static FMEAGenerationDialogUtil getInstance() {
		if (fmeaGenerationDialogUtil == null) {
			fmeaGenerationDialogUtil = new FMEAGenerationDialogUtil();
		}
		return fmeaGenerationDialogUtil;
	}

	/**
	 * Displays a message.
	 * @param filePath the name of the generated file
	 */
	public void showMessage_FmeaGenerationDone(final String filePath) {

		final Display defaultDisplay = Display.getDefault();

		defaultDisplay.syncExec(new Runnable() {
			public void run() {
				Shell currShell = defaultDisplay.getActiveShell();
				MessageDialog.openInformation(currShell, "Info",
						"The FMEA table is exported as .xml file in " + filePath + ".");
			}
		});
	}
}
