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

package org.polarsys.chess.core.annotations;
@DynamicConstraintLib
public class LibExample {
	@DynamicConstraint(name = "a")
	public static IEl a = new IEl("a");
	@DynamicConstraint(name = "b")
	public static IEl b = new IEl("b");
	@DynamicConstraint(name = "c")
	public static IEl c = new IEl("c");
	@DynamicConstraint(name = "d")
	public IEl d = new IEl("d");

}
