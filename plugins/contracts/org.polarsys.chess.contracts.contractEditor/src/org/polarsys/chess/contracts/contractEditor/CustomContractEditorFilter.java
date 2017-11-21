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
package org.polarsys.chess.contracts.contractEditor;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;
import org.polarsys.chess.contracts.profile.chesscontract.util.ContractEntityUtil;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.service.utils.SelectionUtil;

/**
 * It filters the selected objects that are contracts or components. *
 */
public class CustomContractEditorFilter implements org.eclipse.jface.viewers.IFilter {

	private ContractEntityUtil contractEntityUtil = ContractEntityUtil.getInstance();
	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private EntityUtil entityUtil = EntityUtil.getInstance();

	@Override
	public boolean select(Object selection) {
	

		Object selectedUmlElement = selectionUtil.getUmlSelectedObject(selection);

		if (selectedUmlElement instanceof Property) {
			if (entityUtil.isComponentInstance((Property) selectedUmlElement)) {
				return true;
			}
			if (contractEntityUtil.isContractProperty((Property) selectedUmlElement)) {
				return true;
			}
		} else if (selectedUmlElement instanceof Class) {
			return true;
		}

		return false;
	}
}
