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
	//private EntityUtil entityUtil = EntityUtil.getInstance();

	/*@Override
	public String[] getOwnerInputPortsNames(Object formalProperty) {
		Element umlOwner = entityUtil.getOwner((Constraint) formalProperty);
		int direction = FlowDirection.IN_VALUE;
		return entityUtil.getPortsNames(umlOwner, direction);
	}

	@Override
	public String[] getOwnerOutputPortsNames(Object formalProperty) {
		Element umlOwner = entityUtil.getOwner((Constraint) formalProperty);
		int direction = FlowDirection.OUT_VALUE;
		return entityUtil.getPortsNames(umlOwner, direction);
	}

	@Override
	public String[] getOwnerInputOutputPortsNames(Object formalProperty) {
		Element umlOwner = entityUtil.getOwner((Constraint) formalProperty);
		int direction = FlowDirection.INOUT_VALUE;
		return entityUtil.getPortsNames(umlOwner, direction);
	}

	@Override
	public String[] getOwnerAttributesNames(Object property) {
		Element umlOwner = ((Constraint) property).getOwner();
		EList<String> attrArr = new BasicEList<String>();

		attrArr.addAll(entityUtil.getBooleanAttributesNamesExceptsPorts(umlOwner));

		String[] attributesStrArr = new String[attrArr.size()];
		return attrArr.toArray(attributesStrArr);

	}*/

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

	/*public String getPropertyName(Object property) {
		if (property != null) {
			return ((Constraint) property).getQualifiedName();
		}
		return null;
	}*/

	public String getStrFromProperty(Object property) {
		FormalProperty formalProperty = contractEntityUtil.getFormalProperty((Constraint) property);
		return contractEntityUtil.getPropertyStr(formalProperty);
	}

	

	/*@Override
	public Set<?> getOwnerPorts(Object formalProperty) {
		return entityUtil.getUmlPorts(entityUtil.getOwner((Element)formalProperty));		
	}

	@Override
	public Set<?> getOwnerVariables(Object formalProperty) {
		return entityUtil.getAttributes(entityUtil.getOwner((Element)formalProperty));
	}
*/
	/*@Override
	public String getPortName(Object port) {
		return entityUtil.getPortName((Port)port);
	}
*/
/*	@Override
	public String getAttributeName(Object attribute) {
		return entityUtil.getAttributeName((Property)attribute);
	}*/

	
	/*
	@Override
	public boolean isNumberAttribute(Object attribute) {
		// TODO Auto-generated method stub
		return false;
	}*/

	/*@Override
	public boolean isIntAttribute(Object attribute) {
		return entityUtil.isIntegerAttribute((Property)attribute);
	}

	@Override
	public boolean isEventAttribute(Object attribute) {
		return entityUtil.isEventPortAttribute((Property)attribute);
	}

	@Override
	public boolean isEnumAttribute(Object attribute) {
		return entityUtil.isEnumerationAttribute((Property)attribute);
	}

	@Override
	public boolean isBoolAttribute(Object attribute) {
		return entityUtil.isBooleanAttribute((Property)attribute);
	}*/

	/*@Override
	public boolean isContinuousAttribute(Object attribute) {
		return entityUtil.isContinuousAttribute((Property)attribute);
	}*/

	/*@Override
	public boolean isWordAttribute(Object attribute) {
		// TODO Auto-generated method stub
		return entityUtil.isStringAttribute((Property)attribute);
	}*/

	/*@Override
	public boolean isRealAttribute(Object attribute) {
		return entityUtil.isRealAttribute((Property)attribute);
	}*/

	/*@Override
	public boolean isInOutPort(Object port) {
		return entityUtil.isInOutPort((Port)port);
	}*/

	/*@Override
	public boolean isOutputPort(Object port) {
		return entityUtil.isOutputPort((Port)port);
	}*/

	/*@Override
	public boolean isInputPort(Object port) {
		return entityUtil.isInputPort((Port)port);
	}*/

	@Override
	public AbstractSystemModel getSystemModel() {
		return ChessSystemModel.getInstance();
	}

	
}
