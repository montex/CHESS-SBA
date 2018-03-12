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

import eu.fbk.eclipse.standardtools.hierarchicalContractView.core.treeElements.ComponentNode;
import eu.fbk.eclipse.standardtools.hierarchicalContractView.core.treeElements.ContractNode;
import eu.fbk.eclipse.standardtools.hierarchicalContractView.core.treeElements.ITreeNode;
import eu.fbk.eclipse.standardtools.hierarchicalContractView.core.treeElements.TreeNode;

public class CHESSComponentNode extends ComponentNode {

	private ContractEntityUtil contractEntityUtil = ContractEntityUtil.getInstance();
	private EntityUtil entityUtil = EntityUtil.getInstance();

	public CHESSComponentNode(ITreeNode parent, Object associatedObject) {
		super(parent, associatedObject);
	}

	@Override
	public void createChildren(Object associatedObject, List<TreeNode> children) {
		for (Property umlProperty : ((Class) entityUtil.getUMLType((Property) associatedObject)).getAttributes()) {
			if (contractEntityUtil.isContractProperty(umlProperty)) {
				children.add(new ContractNode(this, ((Class) entityUtil.getUMLType(umlProperty)).getName()));
			} else if (entityUtil.isComponentInstance(umlProperty)) {
				children.add(new CHESSComponentNode(this, umlProperty));
			}
		}

	}

	@Override
	public String getName(Object associatedObject) {
		String typeName = ((Class) entityUtil.getUMLType((Property) associatedObject)).getName();
		String propertyName = ((Property) associatedObject).getName();
		return propertyName + ":" + typeName;
	}

}
