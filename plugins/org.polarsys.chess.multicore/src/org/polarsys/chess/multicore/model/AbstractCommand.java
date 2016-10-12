/*------------------------------------------------------------------------------
  -
  - Copyright (c) 2015-2016 University of Padova, ITALY -  Intecs SpA 
  - All rights reserved. This program and the accompanying materials
  - are made available under the terms of the Eclipse Public License v1.0
  - which accompanies this distribution, and is available at
  - http://www.eclipse.org/legal/epl-v10.html
  -
  - Contributors:
  -
  - Alessandro Zovi azovi@math.unipd.it
  - Stefano Puri stefano.puri@intecs.it
  - Laura Baracchi laura.baracchi@intecs.it
  - Nicholas Pacini nicholas.pacini@intecs.it  
  -
  - Initial API and implementation and/or initial documentation
  ------------------------------------------------------------------------------*/package org.polarsys.chess.multicore.model;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.uml2.uml.Model;
import org.polarsys.chess.core.notifications.ResourceNotification;
import org.polarsys.chess.core.util.uml.ModelError;
import org.polarsys.chess.core.util.uml.ResourceUtils;
import org.polarsys.chess.core.views.DiagramStatus;
import org.polarsys.chess.service.utils.CHESSEditorUtils;

public abstract class AbstractCommand extends AbstractHandler {
	protected Model umlModel;
	protected ExecutionEvent event;
	protected DiagramStatus diagramStatus;
	protected PapyrusMultiDiagramEditor editor;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		this.event = event;

		editor = CHESSEditorUtils.getCHESSEditor();
		diagramStatus = CHESSEditorUtils.getDiagramStatus(editor);
		if (editor == null || diagramStatus == null)
			return null;
		try {
			Resource res = ResourceUtils.getUMLResource(editor
					.getServicesRegistry());
			umlModel = ResourceUtils.getModel(res);
			if (umlModel != null) {
				
				try {
					execute();
				} catch (ModelError e) {
					ResourceNotification.showInfo("Problems with the model. " + e.getCause() + ": " + e.getMessage());
				} catch (Exception e) {
					e.printStackTrace();
					ResourceNotification.showError("Unexpected error: " + e.toString());
				}
				
				
				
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return null;
	}

	public abstract void execute() throws ModelError, Exception;

}
