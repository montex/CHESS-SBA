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
package org.polarsys.chess.validator.constraints;

public class StringParser {
	//String value = "PeriodicPattern(period(value=40,unit=ms),..)";
	// ex: WCET -> "(value=40, unit=ms)"
	
public double getValuePattern(String value, String toSearch) {
		
		String[] array = value.split("[()=, ]");
		for(int i=0; i<array.length-1; i++) {
			for(int j=i+1; j<array.length; j++) {
				if(array[i].equalsIgnoreCase(toSearch) && array[j].equalsIgnoreCase("value")) {
					String d = array[j+1];
					return Double.valueOf(d.trim());			
				}
			}
		}
		return -1; 
	}
	
	public double getValueNFP(String value) {
		String[] array = value.split("[()=,]");
		for(int i=0; i<array.length-1; i++) {
			if(array[i].trim().equalsIgnoreCase("value")) {
				String d = array[i+1].trim();
				return Double.valueOf(d);			
			}
		}
		return -1; 
	}
	
}
