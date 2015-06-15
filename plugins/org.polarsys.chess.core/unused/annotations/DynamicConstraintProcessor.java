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
import java.lang.reflect.Field;
import java.util.ArrayList;

public class DynamicConstraintProcessor {
	public static ArrayList<IEl> list = new ArrayList<IEl>();

	public void parse(Class<?> clazz) throws Exception {
		Field[] fields = clazz.getFields();

		for (Field field : fields) {
			if (field.isAnnotationPresent(DynamicConstraint.class)) {

				DynamicConstraint test = field
						.getAnnotation(DynamicConstraint.class);
				String name = test.name();

				try {
					if (field.get(null) instanceof IEl) {
						IEl obj = (IEl) field.get(null);
						list.add(obj);
					}
				} catch (Exception e) {
					System.err.println("Error during the parsing of annotation: " + name);
				}
			}
		}
	}

	public static void main(String[] args) {
		DynamicConstraintProcessor parser = new DynamicConstraintProcessor();
		try {
			parser.parse(Class.forName("LibExample"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (IEl iEl : list) {
			System.out.println(iEl);
		}
	}
}
