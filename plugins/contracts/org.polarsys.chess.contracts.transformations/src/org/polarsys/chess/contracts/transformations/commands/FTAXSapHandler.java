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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Model;
import org.polarsys.chess.contracts.transformations.commands.CommandsCommon.CommandEnum;
import org.polarsys.chess.contracts.transformations.dialogs.SelectFTAAnalysisCtxDialog;
import org.polarsys.chess.core.util.uml.ResourceUtils;
import org.polarsys.chess.service.gui.utils.CHESSEditorUtils;

import com.google.common.util.concurrent.ExecutionError;

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

		
		
		
		
		
		// Call SDE commands
		
		XSapExecService xSapExecService = XSapExecService.getInstance();
		
		xSapExecService.extendModel();
		xSapExecService.computeFT();
		
		
		// Visualize FTA
		
		return null;
	}
}

