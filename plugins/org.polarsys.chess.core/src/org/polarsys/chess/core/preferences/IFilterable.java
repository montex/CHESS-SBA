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

package org.polarsys.chess.core.preferences;

/**
 * This interface enables constraints to be checked during the model validation (activated) or skipped (deactivated).
 *
 */
public interface IFilterable {
	/**
	 * Sets the status. True for active/ false otherwise.
	 * @param active
	 */
	public void setActive(boolean active);
	
	/**
	 * @return true if active/ false otherwise
	 */
	public boolean isActive();
}
