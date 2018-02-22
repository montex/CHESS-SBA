package org.polarsys.chess.OSSImporter.utils;

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
}
