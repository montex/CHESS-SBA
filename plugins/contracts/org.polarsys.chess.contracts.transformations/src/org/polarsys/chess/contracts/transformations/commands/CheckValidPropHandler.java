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
 * 
 * Reused and adapted by:
 * Irfan Sljivo irfan.sljivo@mdh.se
 *******************************************************************************/

package org.polarsys.chess.contracts.transformations.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.polarsys.chess.service.gui.utils.CHESSEditorUtils;


public class CheckValidPropHandler extends AbstractHandler {


	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		IEditorPart editorPart = HandlerUtil.getActiveEditor(event);
//		if (!(CHESSEditorUtils.isCHESSProject(editorPart)))
//			return null;
		
		PapyrusMultiDiagramEditor editor = (PapyrusMultiDiagramEditor)editorPart;
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		Shell activeShell = window.getShell();
		
		//run the validation and handle its results
		CHESSContractValidatePropertyHandler handler = new CHESSContractValidatePropertyHandler(editor, activeShell);
		Command command = handler.getCommand();
		if(command != null){
			command.execute();
		}else{
			MessageDialog.openError(activeShell, "Check all validation properties", "Problems while perfoming analysis");
		}
		return null;
	}

}
