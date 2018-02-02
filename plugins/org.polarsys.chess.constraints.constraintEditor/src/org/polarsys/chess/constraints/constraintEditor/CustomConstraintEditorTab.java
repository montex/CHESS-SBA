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
package org.polarsys.chess.constraints.constraintEditor;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.uml2.uml.Constraint;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.service.internal.model.ChessSystemModel;
import org.polarsys.chess.service.utils.SelectionUtil;

import eu.fbk.eclipse.standardtools.constraintEditor.constraintTab.ConstraintEditorTab;
import eu.fbk.eclipse.standardtools.model.AbstractSystemModel;

/**
 * This is the constraint editor designed for the CHESS platform. It extends the
 * ConstraintEditorTab that is designed to be extended and contains standard
 * methods not related to specific technologies. The only rule is that it works
 * for Eclipse based platforms.
 *
 */
public class CustomConstraintEditorTab extends ConstraintEditorTab {

	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private EntityUtil entityUtil = EntityUtil.getInstance();

	
	
	@Override
	public Resource getResourceFromConstraint(Object constraint) {

		return ((Constraint) constraint).eResource();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.fbk.eclipse.standardtools.constraintEditor.constraintTab.
	 * ConstraintEditorTab#getSubComponentsName(java.lang.Object)
	 */
/*	@Override
	public String[] getSubComponentsName(Object constraint) {
		Element umlElement = ((Constraint) constraint).getOwner();
		Set<String> subCompArr = entityUtil.getSubComponentsNames((Class) umlElement);
		String[] subComStrArr = new String[subCompArr.size()];
		return subCompArr.toArray(subComStrArr);

	}*/

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.fbk.eclipse.standardtools.constraintEditor.constraintTab.
	 * ConstraintEditorTab#getSubComponent(java.lang.Object, java.lang.String)
	 */
	/*@Override
	public Object getSubComponent(Object constraint, String componentName) {
		Element element = ((Constraint) constraint).getOwner();

		for (Property umlProperty : entityUtil.getSubComponentsInstances((Class) element)) {
			if (umlProperty.getName().compareTo(componentName) == 0) {
				return entityUtil.getUmlType(umlProperty);
			}
		}

		return null;
	}*/

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.fbk.eclipse.standardtools.constraintEditor.constraintTab.
	 * ConstraintEditorTab#getInputOutputPorts(java.lang.Object)
	 
	@Override
	public String[] getInputOutputPortsNames(Object component) {
		return entityUtil.getPortsNames((Element) component, FlowDirection.INOUT_VALUE);
	}

	
	 * (non-Javadoc)
	 * 
	 * @see eu.fbk.eclipse.standardtools.constraintEditor.constraintTab.
	 * ConstraintEditorTab#getInputPorts(java.lang.Object)
	 
	@Override
	public String[] getInputPortsNames(Object component) {
		return entityUtil.getPortsNames((Element) component, FlowDirection.IN_VALUE);
	}

	
	 * (non-Javadoc)
	 * 
	 * @see eu.fbk.eclipse.standardtools.constraintEditor.constraintTab.
	 * ConstraintEditorTab#getOutputPorts(java.lang.Object)
	 
	@Override
	public String[] getOutputPortsNames(Object component) {
		return entityUtil.getPortsNames((Element) component, FlowDirection.OUT_VALUE);
	}

	
	 * (non-Javadoc)
	 * 
	 * @see eu.fbk.eclipse.standardtools.constraintEditor.constraintTab.
	 * ConstraintEditorTab#getConstraintOwnerInputPorts(java.lang.Object)
	 
	@Override
	public String[] getConstraintOwnerInputPortsNames(Object constraint) {
		Element element = ((Constraint) constraint).getOwner();
		return getInputPortsNames(element);
	}

	
	 * (non-Javadoc)
	 * 
	 * @see eu.fbk.eclipse.standardtools.constraintEditor.constraintTab.
	 * ConstraintEditorTab#getConstraintOwnerOutputPorts(java.lang.Object)
	 
	@Override
	public String[] getConstraintOwnerOutputPortsNames(Object constraint) {
		Element element = ((Constraint) constraint).getOwner();
		return getOutputPortsNames(element);

	}

	
	 * (non-Javadoc)
	 * 
	 * @see eu.fbk.eclipse.standardtools.constraintEditor.constraintTab.
	 * ConstraintEditorTab#getConstraintOwnerInputOutputPorts(java.lang.Object)
	 
	@Override
	public String[] getConstraintOwnerInputOutputPorts(Object constraint) {
		Element element = ((Constraint) constraint).getOwner();
		return getInputOutputPortsNames(element);
	}

	
	 * (non-Javadoc)
	 * 
	 * @see eu.fbk.eclipse.standardtools.constraintEditor.constraintTab.
	 * ConstraintEditorTab#getConstraintOwnerProperties(java.lang.Object)
	 
	@Override
	public String[] getConstraintOwnerPropertiesNames(Object constraint) {
		Class element = (Class) ((Constraint) constraint).getOwner();
		EList<String> attrArr = new BasicEList<String>();
		attrArr.addAll(entityUtil.getBooleanAttributesNamesExceptsPorts(element));

		String[] attributesStrArr = new String[attrArr.size()];
		return attrArr.toArray(attributesStrArr);
	}
*/
	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.fbk.eclipse.standardtools.constraintEditor.constraintTab.
	 * ConstraintEditorTab#returnConstraint(org.eclipse.jface.viewers.
	 * ISelection)
	 */
	@Override
	public Object returnConstraint(ISelection selection) {
		/*
		 * Object selected = null; if ((selection instanceof
		 * IStructuredSelection)) {
		 * 
		 * List<?> selectionList = ((IStructuredSelection) selection).toList();
		 * if (selectionList.size() == 1) { selected = selectionList.get(0); } }
		 * EObject selectedEObject = EMFHelper.getEObject(selected); if
		 * (selectedEObject != null) { selected = selectedEObject; } if
		 * (selected instanceof GraphicalEditPart) { selected =
		 * (((GraphicalEditPart) selected).resolveSemanticElement()); }
		 */

		Object selectedUmlElement = selectionUtil.getUmlSelectedObject(selection);

		if (selectedUmlElement instanceof Constraint) {
			return (Constraint) selectedUmlElement;
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.fbk.eclipse.standardtools.constraintEditor.constraintTab.
	 * ConstraintEditorTab#constraintEditorchanged(java.lang.Object,
	 * java.lang.String)
	 */
	@Override
	public void constraintEditorchanged(Object constraint, String textChanged) {
		entityUtil.saveConstraint(((Constraint) constraint), textChanged);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.fbk.eclipse.standardtools.constraintEditor.constraintTab.
	 * ConstraintEditorTab#getConstraintName(java.lang.Object)
	 */
	public String getConstraintName(Object constraint) {
		if (constraint != null) {
			return ((Constraint) constraint).getQualifiedName();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.fbk.eclipse.standardtools.constraintEditor.constraintTab.
	 * ConstraintEditorTab#getStrFromConstraint(java.lang.Object)
	 */
	public String getStrFromConstraint(Object constraint) {
		return ((Constraint) constraint).getSpecification().stringValue();
	}
/*
	@Override
	public String[] getEnumValuesFromConstraintOwnerPorts(Object constraint) {
		Class element = (Class) ((Constraint) constraint).getOwner();
		return entityUtil.getEnumValuesFromComponentPorts(element);		
	}

	
	
	@Override
	public Set<?> getConstraintOwnerPorts(Object formalProperty) {
		return entityUtil.getUmlPorts(entityUtil.getOwner((Element)formalProperty));		
	}

	@Override
	public Set<?> getConstraintOwnerAttributes(Object formalProperty) {
		return entityUtil.getAttributes(entityUtil.getOwner((Element)formalProperty));
	}

	@Override
	public String getPortName(Object port) {
		return entityUtil.getPortName((Port)port);
	}

	@Override
	public String getAttributeName(Object attribute) {
		return entityUtil.getAttributeName((Property)attribute);
	}

	
	
	@Override
	public boolean isNumberAttribute(Object attribute) {
		return false;
	}

	@Override
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
	}

	@Override
	public boolean isContinuousAttribute(Object attribute) {
		return entityUtil.isContinuousAttribute((Property)attribute);
	}

	@Override
	public boolean isWordAttribute(Object attribute) {
		return false;
	}

	@Override
	public boolean isRealAttribute(Object attribute) {
		return entityUtil.isRealAttribute((Property)attribute);
	}

	@Override
	public boolean isInOutPort(Object port) {
		return entityUtil.isInOutPort((Port)port);
	}

	@Override
	public boolean isOutputPort(Object port) {
		return entityUtil.isOutputPort((Port)port);
	}

	@Override
	public boolean isInputPort(Object port) {
		return entityUtil.isInputPort((Port)port);
	}
*/
	/*@Override
	public Set<?> getComponentPorts(Object component) {
		return entityUtil.getUmlPorts((Element)component);
	}*/

	@Override
	public AbstractSystemModel getSystemModel() {
		return ChessSystemModel.getInstance();
	}

	
	

}
