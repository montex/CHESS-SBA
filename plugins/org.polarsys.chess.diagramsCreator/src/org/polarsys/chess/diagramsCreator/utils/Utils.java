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

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

public class Utils {
	private static final String SYSVIEW =	"CHESS::Core::CHESSViews::SystemView";

	/**
	 * Utility dialog to display a message on screen
	 * @param title the title of the dialog
	 * @param message the text to display
	 */
	public static void showMessage(String title, String message) {
		MessageDialog.openInformation(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),title, message);
	}
	
	/**
	 * Checks if the selected object is a package in the <<SystemView>> branch.
	 * @param pkg the selected object 
	 * @return true if the package is valid
	 */
	public static boolean isSystemViewPackage(Element obj) {
		if (obj instanceof Package) {
			final Package pkg = (Package) obj;
			if(pkg.getAppliedStereotype(SYSVIEW) != null) {
				return true;
			} else {
				EList<Package> owningPackages = pkg.allOwningPackages();
				for (Package owningPackage : owningPackages) {
					if (owningPackage.getAppliedStereotype(SYSVIEW) != null) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Prints a message on the console.
	 * @param message the message to print
	 */
	public static void printMessageOnOut(String message) {
//		System.out.println(message);	// Comment to avoid printing
	}
}
