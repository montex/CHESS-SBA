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


import org.eclipse.uml2.uml.Constraint;
import org.polarsys.chess.contracts.profile.chesscontract.util.ContractEntityUtil;
import org.polarsys.chess.service.internal.utils.SelectionUtil;
/**
 * It Filters the selected objects that are constraints. *
 */
public class ConstraintEditorFilter implements org.eclipse.jface.viewers.IFilter {

	private ContractEntityUtil contractEntityUtil = ContractEntityUtil.getInstance();
	private SelectionUtil selectionUtil = SelectionUtil.getInstance();

	@Override
	public boolean select(Object selected) {

	
		Object selectedUmlElement = selectionUtil.getUmlSelectedObject(selected);

		if (selectedUmlElement instanceof Constraint) {
			if (!contractEntityUtil.isFormalProperty((Constraint) selectedUmlElement)) {
				return true;
			}
		}
		return false;
	}
}