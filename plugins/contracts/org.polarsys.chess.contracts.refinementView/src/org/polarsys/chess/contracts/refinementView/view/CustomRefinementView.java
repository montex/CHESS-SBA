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
package org.polarsys.chess.contracts.refinementView.view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;
import org.polarsys.chess.contracts.profile.chesscontract.ContractProperty;
import org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement;
import org.polarsys.chess.contracts.profile.chesscontract.util.ContractEntityUtil;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.contracts.refinementView.treeElements.CHESSRootNode;

import eu.fbk.contracts.refinementview.treeElements.RootNode;
import eu.fbk.contracts.refinementview.view.RefinementView;

public class CustomRefinementView extends RefinementView {
	public static String View_ID = "org.polarsys.chess.contracts.refinementView.view1";
	private ContractEntityUtil contractEntityUtil = ContractEntityUtil.getInstance();
	private EntityUtil entityUtil = EntityUtil.getInstance();

	@Override
	public RootNode getModelObjects(ArrayList<Object> allContracts, ArrayList<String> componentInstances,
			ArrayList<String> contractsUsedForRefinement) {
		UmlModel umlModel = UmlUtils.getUmlModel();

		if (umlModel != null) {

			TreeIterator<EObject> allElements = umlModel.getResource().getAllContents();

			if (allElements != null) {
				Collection<org.eclipse.uml2.uml.Class> umlClasses = EcoreUtil
						.getObjectsByType(iterator2Collection(allElements), UMLPackage.eINSTANCE.getClass_());

				for (Class umlClass : umlClasses) {

					if (entityUtil.isSystem(umlClass)) {

						for (Property ummlProperty : umlClass.getAttributes()) {

							if (contractEntityUtil.isContractProperty(ummlProperty)) {
								ContractProperty contractProperty = contractEntityUtil
										.getContractProperty(ummlProperty);
								// if
								// (cp.getContractType().equals(ContractTypes.STRONG)){
								if (true) {
									allContracts.add(contractProperty);
									componentInstances.add(umlClass.getName());
								}
								for (ContractRefinement refinedContr : contractProperty.getRefinedBy()) {
									String contractName = refinedContr.getBase_DataType().getName();
									if (!contractsUsedForRefinement.contains(contractName)) {
										contractsUsedForRefinement.add(contractName);
									}
								}
							}
						}

					}

					for (Property part : umlClass.getParts()) {
						if (!(part instanceof Port)) {
							Class partUmlClass = (Class) part.getType();
							if (partUmlClass != null) {
								for (Property umlProperty : partUmlClass.getAttributes()) {

									if (contractEntityUtil.isContractProperty(umlProperty)) {
										ContractProperty contractProperty = contractEntityUtil
												.getContractProperty(umlProperty);
										// if
										// (cp.getContractType().equals(ContractTypes.STRONG)){
										if (true) {
											allContracts.add(contractProperty);
											componentInstances.add(part.getName());
										}
										for (ContractRefinement refinedContr : contractProperty.getRefinedBy()) {
											String contractName = refinedContr.getBase_DataType().getName();
											if (!contractsUsedForRefinement.contains(contractName)) {
												contractsUsedForRefinement.add(contractName);
											}
										}
									}
								}
							}
						}
					}

				}

			}
		}

		if (allContracts.size() > 0) {
			return new CHESSRootNode(allContracts, contractsUsedForRefinement, componentInstances);
		}
		return null;
	}

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
	}

	@Override
	public void setFocus() {
		super.setFocus();
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
