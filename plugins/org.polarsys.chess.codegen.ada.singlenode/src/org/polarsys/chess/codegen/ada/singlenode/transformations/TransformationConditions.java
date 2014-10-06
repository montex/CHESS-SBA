/*****************************************************************************
 * Copyright (c) 2011 - 2014 University of Padova.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Alessandro Zovi
 *
 *****************************************************************************/
package org.polarsys.chess.codegen.ada.singlenode.transformations;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Model;
import org.polarsys.chess.codegen.ada.singlenode.service.UML2Service;

public class TransformationConditions {

	public static void check(Model model) throws Exception {
		//if the model is single node, then proceed
		//else stop the generation
		UML2Service service = new UML2Service();
		boolean r = service.isSingleNodeSystem(getAllInstanceSpecification(model), "CHESS::Predictability::DeploymentConfiguration::HardwareBaseline::CH_HwProcessor");
		if (!r)
			throw new Exception("The code generation supports only single node system: the system must not be distributed.");
	}

	private static List<InstanceSpecification> getAllInstanceSpecification(Model model) {
		//TODO rewrite query: very inefficient
		List<InstanceSpecification> l = new ArrayList<InstanceSpecification>();
		for (Element e : model.allOwnedElements()) {
			if (e instanceof InstanceSpecification) {
				InstanceSpecification is = (InstanceSpecification) e;
				l.add(is);
			}
		} 
		return l;
	}

	
	
}
