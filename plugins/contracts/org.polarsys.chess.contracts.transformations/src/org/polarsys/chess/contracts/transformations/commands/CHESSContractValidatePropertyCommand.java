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
 * Reused and adapted by:
 * Irfan Sljivo irfan.sljivo@mdh.se
 *******************************************************************************/
package org.polarsys.chess.contracts.transformations.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.markerlistener.util.MarkerListenerUtils;
import org.eclipse.papyrus.infra.services.validation.ValidationTool;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Model;
import org.polarsys.chess.contracts.transformations.commands.CommandsCommon.CommandEnum;
import org.polarsys.chess.contracts.transformations.dialogs.SelectOcraAnalysisCtxDialog;
import org.polarsys.chess.core.util.uml.ResourceUtils;
import org.polarsys.chess.validator.command.ChessGenericValidateCommand;

public class CHESSContractValidatePropertyCommand extends ChessGenericValidateCommand  {

	private String systemQN;
	private Shell activeShell;
	private Boolean checkWeakContracts;
	private PapyrusMultiDiagramEditor editor;

	public CHESSContractValidatePropertyCommand(String label, String pluginId,
			EObject selectedElement) {
		super(label, pluginId, selectedElement);
	}

	public void setEditor(PapyrusMultiDiagramEditor editor) {
		this.editor = editor;		
	}

	public void setActiveShell(Shell activeShell) {
		this.activeShell = activeShell;
	}

	@Override
	protected void handleDiagnostic(IProgressMonitor monitor, Diagnostic diagnostic, final EObject validateElement, final Shell shell){
		Resource resource = getValidationResource();
		if (resource != null) {
			if (selectedElement != null) {
				ValidationTool vt = new ValidationTool(selectedElement);
				vt.deleteSubMarkers();
			}
			boolean marker = false;
			for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
				// We have to filter on the source
				if (pluginIds.contains(childDiagnostic.getSource())) {
					MarkerListenerUtils.eclipseResourcesUtil.createMarkers(resource, childDiagnostic);
					//if we create at least one marker report it
					marker = true;
				}
			}
			//set the result to report
			boolean go = false;
			if(marker){
				go = MessageDialog.openQuestion(activeShell, "Validation Problems", "Errors found while validating the Model. Check Validation Properties won't be performed correctly. Do you still want to continue?");

				if (go){
					performValidationProp();
				}else{
					//don't refine and exit
					return;
				}
			}else{
				performValidationProp();
			}
		}
	}

	private void performValidationProp(){

		String modelname;
		try {			
			Resource res = ResourceUtils.getUMLResource(editor.getServicesRegistry());
			Model model = ResourceUtils.getModel(res);
			modelname = model.getName();
			SelectOcraAnalysisCtxDialog dialog = new SelectOcraAnalysisCtxDialog(activeShell, model);
			dialog.create();
			if (dialog.open() == Window.OK) {
				systemQN = dialog.getSystem();
				checkWeakContracts=dialog.getCheckWeakContracts();
				if(systemQN == null || systemQN.isEmpty()){
					return;
				}
			}else{
				return;
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			return;
		}

		List<String> args = new ArrayList<String>();
		args.add(systemQN);
		String systemName = systemQN.substring(systemQN.lastIndexOf("::")+2);
		args.add(systemName);
		args.add(modelname);
		args.add(checkWeakContracts.toString());	
		CommandsCommon.TransformationJob(activeShell, editor, args, CommandEnum.VALIDPROP, null, null);

		return;
	}

}

