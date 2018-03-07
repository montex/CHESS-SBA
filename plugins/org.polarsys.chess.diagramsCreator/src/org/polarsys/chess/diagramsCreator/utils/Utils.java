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
package org.polarsys.chess.diagramsCreator.utils;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;

public class Utils {

	/**
	 * Utility dialog to display a message on screen
	 * @param title the title of the dialog
	 * @param message the text to display
	 */
	public static void showMessage(String title, String message) {
		MessageDialog.openInformation(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),title, message);
	}
	
	/**
	 * Prints a message on the console.
	 * @param message the message to print
	 */
	public static void printMessageOnOut(String message) {
//		System.out.println(message);	// Comment to avoid printing
	}
}
