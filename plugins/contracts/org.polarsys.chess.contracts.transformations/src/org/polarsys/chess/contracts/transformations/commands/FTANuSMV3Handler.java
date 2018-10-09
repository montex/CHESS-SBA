/*******************************************************************************
 *
 * Copyright (c) 2013, 2015 Intecs SpA 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Nicholas Pacini nicholas.pacini@intecs.it 
 * Stefano Puri stefano.puri@intecs.it
 * Laura Baracchi  laura.baracchi@intecs.it  
 * Initial API and implementation and/or initial documentation
 *******************************************************************************/
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
import org.polarsys.chess.contracts.transformations.dialogs.SelectFTAFMEAAnalysisCtxDialog;
import org.polarsys.chess.core.util.uml.ResourceUtils;
import org.polarsys.chess.service.gui.utils.CHESSEditorUtils;

public class FTANuSMV3Handler extends AbstractHandler {
	
	private String systemQN;
	private String ftaCond;
	
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		final IEditorPart editor = HandlerUtil.getActiveEditor(event);
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		final Shell activeShell = window.getShell();

		final String filename;
		try {
			PapyrusMultiDiagramEditor editorPapyrus = CHESSEditorUtils.getCHESSEditor();
			Resource res = ResourceUtils.getUMLResource(editorPapyrus.getServicesRegistry());
			Model model = ResourceUtils.getModel(res);
			filename = model.getName();
			SelectFTAFMEAAnalysisCtxDialog dialog = new SelectFTAFMEAAnalysisCtxDialog(activeShell, model);
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
		CommandsCommon.TransformationJob(activeShell, editor, args, CommandEnum.FTA, null, ftaCond);

		return null;
	}

}
