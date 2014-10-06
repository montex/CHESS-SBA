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

import java.util.ArrayList;

import org.polarsys.chess.core.preferences.FilterableConstraint;

public class ConstraintList {
	private static ArrayList <FilterableConstraint> list = new ArrayList<FilterableConstraint>();
	
	public static void add(IDynamicConstraint c) {
		list.add(new FilterableConstraint(c));
	}
	
	public static ArrayList<FilterableConstraint> getList(){
		return list;
	}
}
