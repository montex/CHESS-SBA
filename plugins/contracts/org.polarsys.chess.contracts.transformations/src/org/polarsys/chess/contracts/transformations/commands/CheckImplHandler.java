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
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.polarsys.chess.contracts.transformations.commands.CommandsCommon.CommandEnum;
import org.polarsys.chess.contracts.transformations.dialogs.SelectImplementationDialog;
import org.polarsys.chess.contracts.transformations.dialogs.SelectOcraAnalysisCtxDialog;
import org.polarsys.chess.core.util.uml.ResourceUtils;
import org.polarsys.chess.service.utils.CHESSEditorUtils;

public class CheckImplHandler extends AbstractHandler{

	private static final String SYSTEM = "CHESSContract::System";
	private String systemQN;
	private String block;

	public Object execute(ExecutionEvent event) throws ExecutionException {

		final IEditorPart editorPart = HandlerUtil.getActiveEditor(event);
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		final Shell activeShell = window.getShell();
		
		String modelname="";
		try {
			if (!(CHESSEditorUtils.isCHESSProject(editorPart)))
				return null;
			
			PapyrusMultiDiagramEditor editor = (PapyrusMultiDiagramEditor)editorPart;
			Resource res = ResourceUtils.getUMLResource(editor.getServicesRegistry());
			Model model = ResourceUtils.getModel(res);
			
			SelectOcraAnalysisCtxDialog sysDialog = new SelectOcraAnalysisCtxDialog(activeShell, model);
			sysDialog.create();
			if (sysDialog.open() == Window.OK) {
				systemQN = sysDialog.getSystem();
				if(systemQN == null || systemQN.isEmpty()){
					return null;
				}
				Class sysClass = null;
				for (Element elem : model.allOwnedElements()){
					if(elem.getAppliedStereotype(SYSTEM) != null &&
							((NamedElement) elem).getQualifiedName().equals(systemQN)){
						sysClass = (Class) elem;
					}
				}
				if(sysClass != null){
					SelectImplementationDialog implDialog = new SelectImplementationDialog(activeShell, sysClass);
					if (implDialog.open() == Window.OK) {
						block = implDialog.getBlock();
						if(block == null || block.isEmpty()){
							return null;
						}
					}
					else{
						return null;
					}
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
		args.add(modelname);
		CommandsCommon.TransformationJob(activeShell, editorPart, args, CommandEnum.IMPLEMENTATION, block, null);
		
		return null;
	}

}
