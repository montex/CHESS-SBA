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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// TODO: Auto-generated Javadoc
/**
 * The Class StringParser.
 */
public class StringParser {
	//String value = "PeriodicPattern(period(value=40,unit=ms),..)";
	// ex: WCET -> "(value=40, unit=ms)"
	
/**
	 * Gets the value pattern.
	 *
	 * @param value the value
	 * @param toSearch the to search
	 * @return the value pattern
	 */
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
	
	/**
	 * Gets the unit pattern.
	 *
	 * @param value the value
	 * @param toSearch the to search
	 * @return the value pattern
	 * @since 0.10
	 */
	public String getUnitPattern(String value, String toSearch) {
		
		String[] array = value.split("[()=, ]");
		for(int i=0; i<array.length-1; i++) {
			for(int j=i+1; j<array.length; j++) {
				if(array[i].equalsIgnoreCase(toSearch) && array[j].equalsIgnoreCase("unit")) {
					String d = array[j+1];
					return d.trim();			
				}
			}
		}
		return "INVALID"; 
	}
	
	/**
	 * Gets the complex value pattern.
	 *
	 * @param value the value
	 * @param toSearch the to search
	 * @param delimiter the delimiter
	 * @return the complex value pattern
	 */
	public String getComplexValuePattern(String value, String toSearch, String delimiter) {
		String[] array = value.split("[()=, ]");
		Pattern p = Pattern.compile(".*"+toSearch+".*value.*"+delimiter+"(.*)"+delimiter+"", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(value);
		String group = "";
		if(m.find()){
			group = m.group(1);
		}
		
		return group;
	}

	/**
	 * Gets the value nfp.
	 *
	 * @param value the value
	 * @return the value nfp
	 */
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
	
	/**
	 * Gets the unit nfp.
	 *
	 * @param value the value
	 * @return the value nfp
	 * @since 0.10
	 */
	public String getUnitNFP(String value) {
		String[] array = value.split("[()=,]");
		for(int i=0; i<array.length-1; i++) {
			if(array[i].trim().equalsIgnoreCase("unit")) {
				String d = array[i+1].trim();
				return d;			
			}
		}
		return "INVALID"; 
	}
	
	
	/**
	 * Gets the value of the input string.
	 *
	 * @param value the value
	 * @return the value as double
	 * @since 0.10
	 */
	public double getDoubleValue(String value) {
		try {
			value = value.trim();	
			return Double.valueOf(value);			
		} 
		catch (Exception e) {
			return -1; 
		}
	}
}
