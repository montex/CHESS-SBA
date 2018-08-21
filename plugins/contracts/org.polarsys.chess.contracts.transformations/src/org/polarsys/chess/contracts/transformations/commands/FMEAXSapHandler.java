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
import org.polarsys.chess.contracts.transformations.dialogs.SelectFTAAnalysisCtxDialog;
import org.polarsys.chess.contracts.transformations.utils.FileNamesUtil;
import org.polarsys.chess.contracts.transformations.utils.FMEAGenerationDialogUtil;
import org.polarsys.chess.core.util.uml.ResourceUtils;
import org.polarsys.chess.service.gui.utils.CHESSEditorUtils;

import eu.fbk.eclipse.standardTools.XSapExecService.services.XSapExecService;
import eu.fbk.eclipse.standardtools.utils.ui.utils.CommandBuilder;

/**
 * This class permits the generation of FMEA using the xSAP tool.
 * @author cristofo
 *
 */
public class FMEAXSapHandler extends AbstractHandler {
	private String systemQN;
	private String ftaCond;
	
	/**
	 * Creates a monolithic SMV file for the active package.
	 * @param smvFileName the name of the generated file
	 * @return false if errors occurred, true otherwise
	 */
	private Boolean createMonolithicSmvFile(String smvFileName) {		
		final String monolithicSmvCommand = "org.polarsys.chess.smvExport.commands.ExportModelToSMVCommand";
		final String fileNameParam = "file_name";
		final CommandBuilder monolithicSmv;
		
		try {
			monolithicSmv = CommandBuilder.build(monolithicSmvCommand);
			monolithicSmv.setParameter(fileNameParam, smvFileName);
			monolithicSmv.execute();
		} catch (ExecutionException e) {
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;		
	}
	
	public Object execute(ExecutionEvent event) throws ExecutionException {

		// Generate the FEI file and call xSAP analysis
		final IEditorPart editor = HandlerUtil.getActiveEditor(event);
		final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
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

//FIXME commentato per test, il file generato non e' corretto
//		CommandsCommon.TransformationJob(activeShell, editor, args, CommandEnum.FEI, null, ftaCond);
		
		final FileNamesUtil fileNamesService = FileNamesUtil.getInstance();
		
		final String modelName = args.get(2);
		final String smvFileName = fileNamesService.computeSmvFileName(editor, modelName);
		final String feiFileName = fileNamesService.computeFeiFileName(editor, modelName);
		final String extendedSmvFileName = fileNamesService.computeExtendedSmvFileName(editor, modelName);
		final String fmsFileName = fileNamesService.computeFmsFileName(editor, modelName);
		final String fmeaFileName = fileNamesService.computeFmeaFileName(editor, modelName);
		
		// Generate a monolithic SMV file
		if (!createMonolithicSmvFile(smvFileName)){
			return null;
		};
		
		// Call EST commands
		final XSapExecService xSapExecService = XSapExecService.getInstance();
		
		//FIXME: non funziona al momento, manca la parte Python
//		xSapExecService.extendModel(smvFileName, feiFileName, fmsFileName, extendedSmvFileName);

		//FIXME: mi ritorna il formato XML, andava quello .txt?
		xSapExecService.computeFmea(extendedSmvFileName, fmsFileName, ftaCond, fmeaFileName);
			
		FMEAGenerationDialogUtil fmeaGenerationDialogUtil = FMEAGenerationDialogUtil.getInstance();
		
		//TODO: il risultato va visualizzato in una tabella!
		
		fmeaGenerationDialogUtil.showMessage_FmeaGenerationDone(fmeaFileName);
		return null;
	}
}

