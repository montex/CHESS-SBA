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

import eu.fbk.contracts.refinementview.treeElements.ITreeNode;
import eu.fbk.contracts.refinementview.treeElements.RootNode;
import eu.fbk.contracts.refinementview.treeElements.TreeNode;

public class CHESSRootNode extends RootNode {

	public CHESSRootNode(ITreeNode parent, List<Object> allContracts, List<String> contractsUsedForRefinement,
			List<String> compInstances) {
		super(parent, allContracts, contractsUsedForRefinement, compInstances);
	}

	public CHESSRootNode(List<Object> allContracts, List<String> contractsUsedForRefinement,
			List<String> compInstances) {
		super(allContracts, contractsUsedForRefinement, compInstances);
	}

	@Override
	public void createChildren(List<Object> allContracts, List<String> contractsUsedForRefinement,
			List<String> compInstances, List<TreeNode> children) {
		for (int i = 0; i < allContracts.size(); i++) {
			ContractProperty p = (ContractProperty) allContracts.get(i);
			String compInstance = compInstances.get(i);
			if (!isUsedForRefinememt(p, contractsUsedForRefinement, compInstance)) {
				children.add(new CHESSContractNode(p, compInstance));
			}
		}

	}

	private boolean isUsedForRefinememt(ContractProperty p, List<String> contractsUsedForRefinement,
			String compInstance) {
		String contrRef = compInstance + "." + p.getBase_Property().getName();
		return contractsUsedForRefinement.contains(contrRef);
	}
}
