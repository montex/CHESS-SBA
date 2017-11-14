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

import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.sysml.portandflows.FlowDirection;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.service.internal.utils.SelectionUtil;

import eu.fbk.eclipse.standardtools.constraintEditor.constraintTab.ConstraintEditorTab;

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
	@Override
	public String[] getSubComponentsName(Object constraint) {
		Element umlElement = ((Constraint) constraint).getOwner();
		Set<String> subCompArr = entityUtil.getSubComponentsNames((Class) umlElement);
		String[] subComStrArr = new String[subCompArr.size()];
		return subCompArr.toArray(subComStrArr);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.fbk.eclipse.standardtools.constraintEditor.constraintTab.
	 * ConstraintEditorTab#getSubComponent(java.lang.Object, java.lang.String)
	 */
	@Override
	public Object getSubComponent(Object constraint, String componentName) {
		Element element = ((Constraint) constraint).getOwner();

		for (Property umlProperty : entityUtil.getSubComponents((Class) element)) {
			if (umlProperty.getName().compareTo(componentName) == 0) {
				return entityUtil.getUmlType(umlProperty);
			}
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.fbk.eclipse.standardtools.constraintEditor.constraintTab.
	 * ConstraintEditorTab#getInputOutputPorts(java.lang.Object)
	 */
	@Override
	public String[] getInputOutputPorts(Object component) {
		return entityUtil.getPortsNames((Element) component, FlowDirection.INOUT_VALUE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.fbk.eclipse.standardtools.constraintEditor.constraintTab.
	 * ConstraintEditorTab#getInputPorts(java.lang.Object)
	 */
	@Override
	public String[] getInputPorts(Object component) {
		return entityUtil.getPortsNames((Element) component, FlowDirection.IN_VALUE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.fbk.eclipse.standardtools.constraintEditor.constraintTab.
	 * ConstraintEditorTab#getOutputPorts(java.lang.Object)
	 */
	@Override
	public String[] getOutputPorts(Object component) {
		return entityUtil.getPortsNames((Element) component, FlowDirection.OUT_VALUE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.fbk.eclipse.standardtools.constraintEditor.constraintTab.
	 * ConstraintEditorTab#getConstraintOwnerInputPorts(java.lang.Object)
	 */
	@Override
	public String[] getConstraintOwnerInputPorts(Object constraint) {
		Element element = ((Constraint) constraint).getOwner();
		return getInputPorts(element);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.fbk.eclipse.standardtools.constraintEditor.constraintTab.
	 * ConstraintEditorTab#getConstraintOwnerOutputPorts(java.lang.Object)
	 */
	@Override
	public String[] getConstraintOwnerOutputPorts(Object constraint) {
		Element element = ((Constraint) constraint).getOwner();
		return getOutputPorts(element);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.fbk.eclipse.standardtools.constraintEditor.constraintTab.
	 * ConstraintEditorTab#getConstraintOwnerInputOutputPorts(java.lang.Object)
	 */
	@Override
	public String[] getConstraintOwnerInputOutputPorts(Object constraint) {
		Element element = ((Constraint) constraint).getOwner();
		return getInputOutputPorts(element);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.fbk.eclipse.standardtools.constraintEditor.constraintTab.
	 * ConstraintEditorTab#getConstraintOwnerProperties(java.lang.Object)
	 */
	@Override
	public String[] getConstraintOwnerProperties(Object constraint) {
		Class element = (Class) ((Constraint) constraint).getOwner();
		EList<String> attrArr = new BasicEList<String>();
		attrArr.addAll(entityUtil.getBooleanAttributesNamesExceptsPorts(element));

		String[] attributesStrArr = new String[attrArr.size()];
		return attrArr.toArray(attributesStrArr);
	}

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

	@Override
	public String[] getEnumValuesFromConstraintOwnerPorts(Object constraint) {
		Class element = (Class) ((Constraint) constraint).getOwner();
		return entityUtil.getEnumValuesFromComponentPorts(element);		
	}
	
	

}