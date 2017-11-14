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

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.sysml.portandflows.FlowDirection;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.polarsys.chess.contracts.profile.chesscontract.FormalProperty;
import org.polarsys.chess.contracts.profile.chesscontract.util.ContractEntityUtil;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.service.internal.utils.SelectionUtil;

import eu.fbk.eclipse.standardtools.propertyEditor.propertyTab.PropertyEditorTab;

public class CustomPropertyEditorTab extends PropertyEditorTab {

	private ContractEntityUtil contractEntityUtil = ContractEntityUtil.getInstance();
	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private EntityUtil entityUtil = EntityUtil.getInstance();

	@Override
	public String[] getPropertyOwnerInputPorts(Object formalProperty) {
		Element umlOwner = entityUtil.getOwner((Constraint) formalProperty);
		int direction = FlowDirection.IN_VALUE;
		return entityUtil.getPortsNames(umlOwner, direction);
	}

	@Override
	public String[] getPropertyOwnerOutputPorts(Object formalProperty) {
		Element umlOwner = entityUtil.getOwner((Constraint) formalProperty);
		int direction = FlowDirection.OUT_VALUE;
		return entityUtil.getPortsNames(umlOwner, direction);
	}

	@Override
	public String[] getPropertyOwnerInputOutputPorts(Object formalProperty) {
		Element umlOwner = entityUtil.getOwner((Constraint) formalProperty);
		int direction = FlowDirection.INOUT_VALUE;
		return entityUtil.getPortsNames(umlOwner, direction);
	}

	@Override
	public String[] getPropertyOwnerAttributes(Object property) {
		Element umlOwner = ((Constraint) property).getOwner();
		EList<String> attrArr = new BasicEList<String>();

		attrArr.addAll(entityUtil.getBooleanAttributesNamesExceptsPorts(umlOwner));

		String[] attributesStrArr = new String[attrArr.size()];
		return attrArr.toArray(attributesStrArr);

	}

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

	public String getPropertyName(Object property) {
		if (property != null) {
			return ((Constraint) property).getQualifiedName();
		}
		return null;
	}

	public String getStrFromProperty(Object property) {
		FormalProperty formalProperty = contractEntityUtil.getFormalProperty((Constraint) property);
		return contractEntityUtil.getPropertyStr(formalProperty);
	}

	@Override
	public String[] getEnumValuesFromPropertyOwnerPorts(Object formalProperty) {
		Class element = (Class) ((Constraint) formalProperty).getOwner();
		return entityUtil.getEnumValuesFromComponentPorts(element);	
	}

}