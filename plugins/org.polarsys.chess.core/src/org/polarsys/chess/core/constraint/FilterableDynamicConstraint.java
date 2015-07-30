/*
-----------------------------------------------------------------------
--          			CHESS core plugin							 --
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

package org.polarsys.chess.core.constraint;


/**
 * 
 * @deprecated use the super class {@link DynamicConstraint} instead.
 */
@Deprecated
public abstract class FilterableDynamicConstraint extends DynamicConstraint {

	@Deprecated
	public FilterableDynamicConstraint(String name, int severity, String messagePattern){
		super(name, severity, messagePattern);
	}

}
