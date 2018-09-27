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
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAnalysisContext;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Model;
import org.polarsys.chess.contracts.transformations.commands.CommandsCommon.CommandEnum;
import org.polarsys.chess.contracts.transformations.dialogs.SelectFTAFMEAAnalysisCtxDialog;
import org.polarsys.chess.contracts.transformations.utils.AnalysisResultUtil;
import org.polarsys.chess.contracts.transformations.utils.FileNamesUtil;
import org.polarsys.chess.core.util.uml.ResourceUtils;
import org.polarsys.chess.service.gui.utils.CHESSEditorUtils;
import org.polarsys.chess.smvExporter.ui.services.CHESSSmvExporterService;

import eu.fbk.eclipse.standardTools.XSapExecService.services.XSapExecService;

/**
 * Abstract handler to process xSAP commands.
 * @author cristofo
 *
 */
public abstract class AbstractXSapHandler extends AbstractHandler {
	private String systemQN;
	private Shell activeShell;
	private List<String> args;
	private String smvFileName;
	private String feiFileName;
	private String expandedFeiFileName;
	protected String ftaCond;
	protected String modelName;
	protected IEditorPart editor;
	protected String extendedSmvFileName;
	protected String fmsFileName;
	protected GaAnalysisContext analysisContext;
	protected final FileNamesUtil fileNamesUtil = FileNamesUtil.getInstance();
	protected final XSapExecService xSapExecService = XSapExecService.getInstance();
	protected final AnalysisResultUtil analysisResultUtil = AnalysisResultUtil.getInstance();
	
	/**
	 * Computes all the file names for the commands.
	 * @throws ExecutionException 
	 */
	private boolean computeFileNames(ExecutionEvent event) throws ExecutionException {
		
		final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		editor = HandlerUtil.getActiveEditor(event);
		activeShell = window.getShell();
		final String fileName;

		try {
			final PapyrusMultiDiagramEditor editorPapyrus = CHESSEditorUtils.getCHESSEditor();
			final Resource res = ResourceUtils.getUMLResource(editorPapyrus.getServicesRegistry());
			final Model model = ResourceUtils.getModel(res);
			final SelectFTAFMEAAnalysisCtxDialog dialog = new SelectFTAFMEAAnalysisCtxDialog(activeShell, model);
			fileName = model.getName();
			dialog.create();
			if (dialog.open() == Window.OK) {
				systemQN = dialog.getSystem();
				ftaCond = dialog.getFtaCondition();
				analysisContext = dialog.getAnalysisContext();
				if(systemQN == null || systemQN.isEmpty() || ftaCond == null || ftaCond.isEmpty()) {
					return false;
				}
			}else {
				return false;
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			return false;
		}
		
		args = new ArrayList<String>();
		args.add(systemQN);
		final String systemName = systemQN.substring(systemQN.lastIndexOf("::") + 2);
		args.add(systemName);
		modelName = fileName + "_" + systemName; // Used by the transformation as file name
		args.add(modelName);
		
		smvFileName = fileNamesUtil.computeSmvFileName(editor, modelName);
		feiFileName = fileNamesUtil.computeFeiFileName(editor, modelName);
		expandedFeiFileName = fileNamesUtil.computeExpandedFeiFileName(editor, modelName);
		extendedSmvFileName = fileNamesUtil.computeExtendedSmvFileName(editor, modelName);
		fmsFileName = fileNamesUtil.computeFmsFileName(editor, modelName);
		
		return true;
	}
	
	/**
	 * Prepares all the needed files for the following analysis
	 * @param event the event
	 * @return true if all the files were generated
	 * @throws ExecutionException
	 */
	protected boolean prepareExpandedFiles(ExecutionEvent event) throws ExecutionException {
				
		// Prepare the file names for all the commands
		if (!computeFileNames(event)) {
			return false;
		}
		
		// Generate the FEI file
		CommandsCommon.TransformationJob(activeShell, editor, args, CommandEnum.FEI, null, ftaCond);
		
		// Generate the monolithic SMV file
		final CHESSSmvExporterService smvExporterService = CHESSSmvExporterService.getInstance();
		if (!smvExporterService.createMonolithicSmvFile(smvFileName)){
			return false;
		}
		
		// Expand the FEI file
		if(!xSapExecService.expandFaultExtensions(feiFileName, expandedFeiFileName, true)) {
			return false;
		}
		
		// Extend the SMV model
		if (!xSapExecService.extendModel(smvFileName, expandedFeiFileName, fmsFileName, extendedSmvFileName, true)) {
			return false;
		}
		
		return true;
	}
}
