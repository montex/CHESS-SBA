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

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.polarsys.chess.contracts.transformations.commands.CommandsCommon;

/**
 * Utility class for generating transformations file names.
 * @author cristofo
 *
 */
public class FileNamesUtil {
	private static FileNamesUtil fileNamesUtil;

	public static FileNamesUtil getInstance() {
		if (fileNamesUtil == null) {
			fileNamesUtil = new FileNamesUtil();
		}
		return fileNamesUtil;
	}

	/**
	 * Computes the folder for xSAP material.
	 * @param editor the active editor
	 * @return
	 */
	public IFolder computeXSapFolder(IEditorPart editor) {
		final IFileEditorInput input = (IFileEditorInput) editor.getEditorInput();
		final IFile inputfile = input.getFile();		
		final IProject project = inputfile.getProject();
		IFolder folder = project.getFolder(CommandsCommon.XSAP_FOLD);
		return folder;
	}
	
	/**
	 * Computes the absolute file name for the fault tree.
	 * @param editor the active editor
	 * @param modelSystemName the model name
	 * @return
	 */
	public String computeFtFileName(IEditorPart editor, String modelSystemName) {
		final IFolder folder = computeXSapFolder(editor);
		final IFolder resFolder = folder.getFolder(CommandsCommon.RES_FOLD);
		final String tempFiles = resFolder.getLocation().toString();
		final String fileName = tempFiles + File.separator + "extended_" + modelSystemName + "_ft.xml";
		return fileName;
	}

	/**
	 * Computes the absolute file name for the FMEA table.
	 * @param editor the active editor
	 * @param modelSystemName the model name
	 * @return
	 */
	public String computeFmeaFileName(IEditorPart editor, String modelSystemName) {
		final IFolder folder = computeXSapFolder(editor);
		final IFolder resFolder = folder.getFolder(CommandsCommon.RES_FOLD);
		final String tempFiles = resFolder.getLocation().toString();
		final String fileName = tempFiles + File.separator + modelSystemName + "_fmea_table.xml";
		return fileName;
	}

	/**
	 * Computes the absolute file name for the extended SMV.
	 * @param editor the active editor
	 * @param modelSystemName the model name
	 * @return
	 */
	public String computeExtendedSmvFileName(IEditorPart editor, String modelSystemName) {
		final IFolder folder = computeXSapFolder(editor);
		final IFolder tempFolder = folder.getFolder(CommandsCommon.TEMP_FOLD);
		final String tempFiles = tempFolder.getLocation().toString();
		final String fileName = tempFiles + File.separator + "extended_" + modelSystemName + CommandsCommon.SMV_EXT;
		return fileName;
	}
	
	/**
	 * Computes the absolute file name for the fms.
	 * @param editor the active editor
	 * @param modelSystemName the model name
	 * @return
	 */
	public String computeFmsFileName(IEditorPart editor, String modelSystemName) {
		final IFolder folder = computeXSapFolder(editor);
		final IFolder tempFolder = folder.getFolder(CommandsCommon.TEMP_FOLD);
		final String tempFiles = tempFolder.getLocation().toString();
		final String fileName = tempFiles + File.separator + "fms_" + modelSystemName + ".xml";
		return fileName;
	}
	
	/**
	 * Computes the target folder for files.
	 * @param editor the active editor
	 * @return
	 */
	public String computeFileTargetFolder(IEditorPart editor) {
		final IFolder folder = computeXSapFolder(editor);
		final IFolder files = folder.getFolder(CommandsCommon.FILES_FOLD);
		final File target = files.getLocation().toFile();
		return target.toString(); 
	}
	
	/**
	 * Computes the absolute file name of the SMV.
	 * @param editor the active editor
	 * @param modelSystemName the model name
	 * @return
	 */
	public String computeSmvFileName(IEditorPart editor, String modelSystemName) {
		return computeFileTargetFolder(editor) + File.separator + modelSystemName + CommandsCommon.SMV_EXT;
	}
	
	/**
	 * Computes the absolute file name of the FEI.
	 * @param editor the active editor
	 * @param modelSystemName the model name
	 * @return
	 */
	public String computeFeiFileName(IEditorPart editor, String modelSystemName) {
		return computeFileTargetFolder(editor) + File.separator + modelSystemName + CommandsCommon.FEI_EXT;
	}
}
