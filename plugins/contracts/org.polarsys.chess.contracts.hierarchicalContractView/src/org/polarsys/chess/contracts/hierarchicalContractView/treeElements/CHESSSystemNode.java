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
package org.polarsys.chess.contracts.hierarchicalContractView.treeElements;

import java.util.List;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;
import org.polarsys.chess.contracts.profile.chesscontract.util.ContractEntityUtil;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;

import eu.fbk.eclipse.standardtools.hierarchicalContractView.core.treeElements.ContractNode;
import eu.fbk.eclipse.standardtools.hierarchicalContractView.core.treeElements.SystemNode;
import eu.fbk.eclipse.standardtools.hierarchicalContractView.core.treeElements.TreeNode;

public class CHESSSystemNode extends SystemNode {

	private ContractEntityUtil contractEntityUtil = ContractEntityUtil.getInstance();
	private EntityUtil entityUtil = EntityUtil.getInstance();

	public CHESSSystemNode(Object system) {
		super(system);
	}

	@Override
	public String getName(Object system) {
		return entityUtil.getName((Class) system);
	}

	@Override
	public void createChildren(Object system, List<TreeNode> children) {
		for (Property umlProperty : ((Class) system).getAttributes()) {

			if (contractEntityUtil.isContractProperty(umlProperty)) {
				children.add(new ContractNode(this, ((Class)entityUtil.getUmlType(umlProperty)).getName()));
			} else if (entityUtil.isComponentInstance(umlProperty)) {
				children.add(new CHESSComponentNode(this, umlProperty));
			}
		}

	}

}
