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
package org.polarsys.chess.contracts.refinementView.treeElements;

import java.util.List;

import org.polarsys.chess.contracts.profile.chesscontract.ContractProperty;
import org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement;
import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ContractTypes;

import eu.fbk.contracts.refinementview.treeElements.ContractNode;
import eu.fbk.contracts.refinementview.treeElements.ITreeNode;
import eu.fbk.contracts.refinementview.treeElements.TreeNode;

public class CHESSContractNode extends ContractNode {

	public CHESSContractNode(Object contractProperty, String compInstance) {
		super(contractProperty, compInstance);
	}

	public CHESSContractNode(ITreeNode parent, Object contractProperty, String compInstance) {
		super(parent, contractProperty, compInstance);
	}

	@Override
	public String getName(Object contractProperty, String compInstance) {
		String contrName = ((ContractProperty) contractProperty).getBase_Property().getName();
		return compInstance + "." + contrName;
	}

	@Override
	public void createChilden(Object contractProperty, String compInstance, List<TreeNode> children) {
		for (ContractRefinement cr : ((ContractProperty) contractProperty).getRefinedBy()) {

			ContractProperty cp = cr.getContract();
			if (true) {
				if (cr.getInstance() != null) {
					String compoInstance = cr.getInstance().getName();
					children.add(new CHESSContractNode(this, cp, compoInstance));
				}
			}
		}

	}

	@Override
	public boolean isWeak(Object contractProperty) {
		return !((ContractProperty) contractProperty).getContractType().equals(ContractTypes.STRONG);
	}

}
