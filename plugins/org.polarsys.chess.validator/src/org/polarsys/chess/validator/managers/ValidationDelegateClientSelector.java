/*
-----------------------------------------------------------------------
--                CHESS Live/Batch Validator plugin                  --
--                                                                   --
--                    Copyright (C) 2011-2012                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- Author: Alessandro Zovi         azovi@math.unipd.it               --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
*/
package org.polarsys.chess.validator.managers;

import org.eclipse.emf.validation.model.IClientSelector;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;

// TODO: Auto-generated Javadoc
/**
 * The Class ValidationDelegateClientSelector.
 */
public class ValidationDelegateClientSelector


	implements IClientSelector {
	
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
