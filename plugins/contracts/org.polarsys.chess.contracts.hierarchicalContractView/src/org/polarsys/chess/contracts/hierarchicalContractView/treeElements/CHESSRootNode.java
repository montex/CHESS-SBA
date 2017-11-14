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

import java.util.ArrayList;
import java.util.List;

import eu.fbk.eclipse.standardtools.hierarchicalContractView.core.treeElements.RootNode;
import eu.fbk.eclipse.standardtools.hierarchicalContractView.core.treeElements.TreeNode;

public class CHESSRootNode extends RootNode {

	public CHESSRootNode(ArrayList<Object> systems) {
		super(systems);
	}

	@Override
	public void createChildren(ArrayList<Object> systems, List<TreeNode> children) {
		for (Object s : systems) {
			children.add(new CHESSSystemNode(s));
		}
	}

}
