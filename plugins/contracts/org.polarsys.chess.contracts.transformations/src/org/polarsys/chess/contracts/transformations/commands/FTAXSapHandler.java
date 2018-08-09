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
package org.polarsys.chess.contracts.transformations.commands;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Model;
import org.polarsys.chess.contracts.transformations.commands.CommandsCommon.CommandEnum;
import org.polarsys.chess.contracts.transformations.dialogs.SelectFTAAnalysisCtxDialog;
import org.polarsys.chess.core.util.uml.ResourceUtils;
import org.polarsys.chess.service.gui.utils.CHESSEditorUtils;

import eu.fbk.eclipse.standardTools.XSapExecService.services.XSapExecService;
import eu.fbk.eclipse.standardtools.utils.ui.utils.CommandBuilder;

/**
 * This class permits the generation of FTA using the xSAP tool.
 * @author cristofo
 *
 */
public class FTAXSapHandler extends AbstractHandler {
	private static String MONOLITHIC_SMV_COMMAND = "org.polarsys.chess.verificationService.commands.ExportModelToSMVCommand";
	private String systemQN;
	private String ftaCond;
	
	/**
	 * Computes the folder for xSAP material.
	 * @param editor the active editor
	 * @return
	 */
	private IFolder computeXSapFolder(IEditorPart editor) {
		final IFileEditorInput input = (IFileEditorInput) editor.getEditorInput();
		final IFile inputfile = input.getFile();		
		final IProject project = inputfile.getProject();
		IFolder folder = project.getFolder(CommandsCommon.XSAP_FOLD);
		return folder;
	}
	
	/**
	 * Computes the absolute file name for the fault tree.
	 * @param editor the active editor
	 * @param systemName the name of the system block
	 * @return
	 */
	private String computeFtFileName(IEditorPart editor, String systemName) {
		final IFolder folder = computeXSapFolder(editor);
		final IFolder tempFolder = folder.getFolder(CommandsCommon.TEMP_FOLD);
		final String tempFiles = tempFolder.getLocation().toString();
		final String fileName = tempFiles + File.separator + "extended_model_" + systemName + "ft.xml";
		return fileName;
	}
	
	/**
	 * Computes the target folder for files.
	 * @param editor the active editor
	 * @return
	 */
	private String computeFileTargetFolder(IEditorPart editor) {
		final IFolder folder = computeXSapFolder(editor);
		final IFolder files = folder.getFolder(CommandsCommon.FILES_FOLD);	
		final File target = files.getLocation().toFile();
		return target.toString(); 
	}
	
	/**
	 * Computes the absolute file name of the SMV file.
	 * @param editor the active editor
	 * @param modelSystemName the model name
	 * @return
	 */
	private String computeSmvFileName(IEditorPart editor, String modelSystemName) {
		return computeFileTargetFolder(editor) + File.separator + modelSystemName + CommandsCommon.SMV_EXT;
	}
	
	/**
	 * Computes the absolute file name of the FEI file.
	 * @param editor the active editor
	 * @param modelSystemName the model name
	 * @return
	 */
	private String computeFeiFileName(IEditorPart editor, String modelSystemName) {
		return computeFileTargetFolder(editor) + File.separator + modelSystemName + CommandsCommon.FEI_EXT;
	}
	
	public Object execute(ExecutionEvent event) throws ExecutionException {

		//TODO:
//		  - ExportModelToMonolithicSMVCommand che mi crea un file unico SMV
//		  - ExportErrorModelToFEICommand (non esiste ancora) che mi crea un file FEI
//		  - Extend_model sara' un comando di SDE
//		  - Compute_model sara' un comando di SDE
//		  - Visualize_FTA riutilizzare quello esistente


		// Generate a monolithic SMV file
		final CommandBuilder modelCheckingCommand;
		try {
			modelCheckingCommand = CommandBuilder.build(MONOLITHIC_SMV_COMMAND);
			modelCheckingCommand.execute();
		} catch (ExecutionException e) {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	
		// Generate the FEI file and call xSAP analysis
		final IEditorPart editor = HandlerUtil.getActiveEditor(event);
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		final Shell activeShell = window.getShell();

		final String filename;
		try {
			PapyrusMultiDiagramEditor editorPapyrus = CHESSEditorUtils.getCHESSEditor();
			Resource res = ResourceUtils.getUMLResource(editorPapyrus.getServicesRegistry());
			Model model = ResourceUtils.getModel(res);
			filename = model.getName();
			SelectFTAAnalysisCtxDialog dialog = new SelectFTAAnalysisCtxDialog(activeShell, model);
			dialog.create();
			if (dialog.open() == Window.OK) {
				systemQN = dialog.getSystem();
				ftaCond = dialog.getFtaCondition();
				if(systemQN == null || systemQN.isEmpty() || ftaCond == null || ftaCond.isEmpty()){
					return null;
				}
			}else{
				return null;
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			return null;
		}
			
		List<String> args = new ArrayList<String>();
		args.add(systemQN);
		String systemName = systemQN.substring(systemQN.lastIndexOf("::")+2);
		args.add(systemName);
		args.add(filename+"_"+systemName);//used by the transformation as file name
		
		CommandsCommon.TransformationJob(activeShell, editor, args, CommandEnum.FEI, null, ftaCond);
		
		// Call EST commands
		final XSapExecService xSapExecService = XSapExecService.getInstance();
		
		xSapExecService.extendModel(computeSmvFileName(editor, args.get(2)), computeFeiFileName(editor, args.get(2)));

		xSapExecService.computeFt();
		
		xSapExecService.computeFmea();
		
			
		// Visualize FTA
		xSapExecService.showFT(computeFtFileName(editor, systemName));
		
		return null;
	}
}

