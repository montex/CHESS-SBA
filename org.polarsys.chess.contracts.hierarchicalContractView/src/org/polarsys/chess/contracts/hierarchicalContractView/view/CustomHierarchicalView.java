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
package org.polarsys.chess.contracts.hierarchicalContractView.view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.UMLPackage;
import org.polarsys.chess.contracts.hierarchicalContractView.treeElements.CHESSRootNode;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;

import eu.fbk.eclipse.standardtools.hierarchicalContractView.core.treeElements.RootNode;
import eu.fbk.eclipse.standardtools.hierarchicalContractView.core.view.HierarchicalView;

public class CustomHierarchicalView extends HierarchicalView {

	public static String View_ID = "org.polarsys.chess.contracts.hierarchicalContractView.view1";
	private EntityUtil entityUtil = EntityUtil.getInstance();

	public RootNode getSystemObjects() {
		Platform.getBundle(" ");
		UmlModel umlModel = UmlUtils.getUmlModel();
		ArrayList<Object> systems = null;
		if (umlModel != null) {
			systems = new ArrayList<Object>();
			TreeIterator<EObject> allElements = umlModel.getResource().getAllContents();
			if (allElements != null) {
				Collection<org.eclipse.uml2.uml.Class> classes = EcoreUtil
						.getObjectsByType(iterator2Collection(allElements), UMLPackage.eINSTANCE.getClass_());

				for (Class c : classes) {
					if (entityUtil.isSystem(c)) {
						systems.add(c);
					}
				}

				if(systems.size()>0){
				return new CHESSRootNode(systems);
				}
			}
		}
		return null;
	}

	
	private <T> Collection<T> iterator2Collection(final Iterator<T> iter) {
		ArrayList<T> list = new ArrayList<T>();
		for (; iter.hasNext();) {
			T item = iter.next();
			list.add(item);
		}
		return list;
	}

}
