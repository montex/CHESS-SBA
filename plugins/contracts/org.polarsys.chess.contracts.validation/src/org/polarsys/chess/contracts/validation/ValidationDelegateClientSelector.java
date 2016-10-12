/*******************************************************************************
 *
 * Copyright (c) 2013, 2015 Intecs SpA 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Nicholas Pacini nicholas.pacini@intecs.it 
 * Stefano Puri stefano.puri@intecs.it
 * Laura Baracchi  laura.baracchi@intecs.it  
 * Initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.polarsys.chess.contracts.validation;

import org.eclipse.emf.validation.model.IClientSelector;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;

public class ValidationDelegateClientSelector implements IClientSelector {

	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.validation.model.IClientSelector#selects(java.lang.Object)
	 */
	public boolean selects(Object object) {
		if (!(object instanceof Element))
			return false;
		if (((Element) object) instanceof Model){
			Object obj = ((Model) object).getAppliedProfile("CHESS");
			if (obj != null)
				return true;
		}
		if ( ((Element) object).getModel() == null)
			return false;
		
		if (((Element) object).getModel().getAppliedProfile("CHESS") != null)
			return true;
	
		return false;
	}

}
