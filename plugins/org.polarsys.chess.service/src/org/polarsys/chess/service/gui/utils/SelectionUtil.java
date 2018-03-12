/*******************************************************************************
 * Copyright (C) 2017 Fondazione Bruno Kessler.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Alberto Debiasi - initial API and implementation
 ******************************************************************************/
package org.polarsys.chess.service.gui.utils;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.polarsys.chess.contracts.profile.chesscontract.util.ContractEntityUtil;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.service.core.exceptions.NoComponentException;





/**
 * Util class that provides methods for the object that are selected in the GUI
 * by the user.
 *
 */
public class SelectionUtil {
	
	private static final Logger logger = Logger.getLogger(SelectionUtil.class);
	
	private static SelectionUtil selectionUtil;

	private ContractEntityUtil contractEntityUtil = ContractEntityUtil.getInstance();
	private EntityUtil entityUtil = EntityUtil.getInstance();

	public static SelectionUtil getInstance() {
		if (selectionUtil == null) {
			selectionUtil = new SelectionUtil();
		}
		return selectionUtil;
	}

	public Object getUmlSelectedObject(Object selection) {

		Object selectedObject = selection;

		if ((selectedObject instanceof IStructuredSelection)) {

			List<?> selectionList = ((IStructuredSelection) selectedObject).toList();
			if (selectionList.size() == 1) {
				selectedObject = selectionList.get(0);
			}
		}
		EObject selectedEObject = EMFHelper.getEObject(selectedObject);
		if (selectedEObject != null) {
			selectedObject = selectedEObject;
		}
		if (selectedObject instanceof GraphicalEditPart) {
			selectedObject = (((GraphicalEditPart) selectedObject).resolveSemanticElement());
		}

		return selectedObject;
	}

	public GraphicalEditPart getSelectedGraphicalObject(ExecutionEvent event) {
		
		logger.debug("ExecutionEvent: "+event);
		
	ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage()
			.getSelection();
	
	logger.debug("selection: "+selection);
	return getSelectedGraphicalObject(selection);
	}

	
	private GraphicalEditPart getSelectedGraphicalObject(Object selection) {

		logger.debug("selection: " + selection);

		Object selectedObject = selection;

		EditPart editPart = (GraphicalEditPart) ((IStructuredSelection) selectedObject).getFirstElement();
		

		return (GraphicalEditPart) editPart;
	}


	
	public Class getUmlComponentFromSelectedObject(ExecutionEvent event) throws NoComponentException {

		
		ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();

		logger.debug("current selection: " + selection);

		Object selectedUmlElement = getUmlSelectedObject(selection);
		
		logger.debug("selectedUmlElement: "+selectedUmlElement);
		
		if (selectedUmlElement instanceof Property) {
			if (entityUtil.isComponentInstance((Property) selectedUmlElement)) {
				selectedUmlElement = entityUtil.getUMLType((Property) selectedUmlElement);
			}
		}

		if (selectedUmlElement instanceof Class) {
			if (!contractEntityUtil.isContract((Element) selectedUmlElement)) {
				return (Class) selectedUmlElement;
			}
		}
		
		throw new NoComponentException();

	
	}

	public Resource getSelectedModelResource() {
		UmlModel umlModel = UmlUtils.getUmlModel();
		if (umlModel != null) {
			return umlModel.getResource();
		}
		return null;
	}

	
}
