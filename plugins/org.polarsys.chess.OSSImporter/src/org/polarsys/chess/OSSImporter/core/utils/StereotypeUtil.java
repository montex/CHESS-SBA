/*******************************************************************************
 * Copyright (C) 2018 Fondazione Bruno Kessler.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *   Alberto Debiasi - initial API and implementation
 *   Luca Cristoforetti - initial API and implementation
 ******************************************************************************/
package org.polarsys.chess.OSSImporter.core.utils;


import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;
import org.polarsys.chess.contracts.profile.chesscontract.util.ContractEntityUtil;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;

public class StereotypeUtil {

	
	 private static StereotypeUtil stereotypeUtilInstance =
			 StereotypeUtil.getInstance();

			public static StereotypeUtil getInstance() {
				if (stereotypeUtilInstance == null) {
					stereotypeUtilInstance = new StereotypeUtil();
				}
				return stereotypeUtilInstance;
			}
	
	
			private final EntityUtil entityUtil = EntityUtil.getInstance();
	
	
	// Stereotype objects needed to customize the elements
		public Stereotype contractPropertyStereotype;
		public Stereotype delegationConstraintStereotype;
		public Stereotype contractRefinementStereotype;
		public Stereotype flowPortStereotype;
		public Stereotype contractStereotype;
		public Stereotype boundedTypeStereotype;
		public Stereotype blockStereotype;
		public Stereotype systemStereotype;
	
		
		
	
		
	/**
	 * Collects the needed stereotypes from the given package.
	 * @param pkg the package in which to look for the stereotypes
	 */
	public void refreshStereotypes(Package pkg) {
		
				contractPropertyStereotype = entityUtil.findStereotype(pkg, ContractEntityUtil.CONTRACT_PROP);
				delegationConstraintStereotype = entityUtil.findStereotype(pkg, EntityUtil.DELEGATION_CONST);
				contractRefinementStereotype = entityUtil.findStereotype(pkg, ContractEntityUtil.CONTRACT_REFINEMENT);
				boundedTypeStereotype = entityUtil.findStereotype(pkg, EntityUtil.BOUNDED_TYPE);
				flowPortStereotype = entityUtil.findStereotype(pkg, EntityUtil.FLOW_Port);
				blockStereotype = entityUtil.findStereotype(pkg, EntityUtil.BLOCK);
				systemStereotype = entityUtil.findStereotype(pkg, EntityUtil.SYSTEM);
				contractStereotype = entityUtil.findStereotype(pkg, ContractEntityUtil.CONTRACT);
	
	}
	
}
