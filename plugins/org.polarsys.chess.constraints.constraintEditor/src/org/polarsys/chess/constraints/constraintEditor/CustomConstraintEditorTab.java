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
import org.polarsys.chess.service.core.model.ChessSystemModel;
import org.polarsys.chess.service.gui.utils.SelectionUtil;

import eu.fbk.eclipse.standardtools.constraintEditor.constraintTab.ConstraintEditorTab;
import eu.fbk.eclipse.standardtools.utils.core.model.AbstractSystemModel;

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
	 * ConstraintEditorTab#returnConstraint(org.eclipse.jface.viewers.
	 * ISelection)
	 */
	@Override
	public Object returnConstraint(ISelection selection) {

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
		String strContraint = ((Constraint) constraint).getSpecification().stringValue();
		if (strContraint == null) {
			return "";
		}
		return strContraint;
	}

	@Override
	public AbstractSystemModel getSystemModel() {
		return ChessSystemModel.getInstance();
	}

}
