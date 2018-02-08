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
package org.polarsys.chess.properties.propertyEditor;


import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.uml2.uml.Constraint;
import org.polarsys.chess.contracts.profile.chesscontract.FormalProperty;
import org.polarsys.chess.contracts.profile.chesscontract.util.ContractEntityUtil;
import org.polarsys.chess.service.internal.model.ChessSystemModel;
import org.polarsys.chess.service.utils.SelectionUtil;

import eu.fbk.eclipse.standardtools.model.AbstractSystemModel;
import eu.fbk.eclipse.standardtools.propertyEditor.propertyTab.PropertyEditorTab;

public class CustomPropertyEditorTab extends PropertyEditorTab {

	private ContractEntityUtil contractEntityUtil = ContractEntityUtil.getInstance();
	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	

	@Override
	public Object returnProperty(ISelection selection) {
	

		Object selectedUmlElement = selectionUtil.getUmlSelectedObject(selection);

		if (selectedUmlElement instanceof Constraint) {
			Constraint umlConstraint = (Constraint) selectedUmlElement;
			if (contractEntityUtil.isFormalProperty(umlConstraint)) {
				return umlConstraint;
			}
		}

		return null;
	}

	@Override
	public Resource getResourceFromProperty(Object formalProperty) {

		return ((Constraint) formalProperty).eResource();
	}

	@Override
	public void propertyEditorchanged(Object property, String textChanged) {
		contractEntityUtil.saveFormalProperty(contractEntityUtil.getFormalProperty((Constraint) property), textChanged);
	}

	public String getStrFromProperty(Object property) {
		FormalProperty formalProperty = contractEntityUtil.getFormalProperty((Constraint) property);
		return contractEntityUtil.getPropertyStr(formalProperty);
	}

	@Override
	public AbstractSystemModel getSystemModel() {
		return ChessSystemModel.getInstance();
	}

	
}
