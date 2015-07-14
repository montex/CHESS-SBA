package org.polarsys.chess.codegen.ada.util;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;

public class AdaGenUtil {
	
	/**
	 * Utility method to get the active Eclipse project.
	 *
	 * @param editor the editor
	 * @return the active project
	 */
	public static IProject getActiveProject(IEditorPart editor) {
		IFileEditorInput input = (IFileEditorInput) editor.getEditorInput();
		IFile file = input.getFile();
		return file.getProject();
	}

}
