/*------------------------------------------------------------------------------
  -
  - Copyright (c) 2015-2016 University of Padova, ITALY -  Intecs SpA 
  - All rights reserved. This program and the accompanying materials
  - are made available under the terms of the Eclipse Public License v1.0
  - which accompanies this distribution, and is available at
  - http://www.eclipse.org/legal/epl-v10.html
  -
  - Contributors:
  -
  - Alessandro Zovi azovi@math.unipd.it
  - Stefano Puri stefano.puri@intecs.it
  - Laura Baracchi laura.baracchi@intecs.it
  - Nicholas Pacini nicholas.pacini@intecs.it  
  -
  - Initial API and implementation and/or initial documentation
  ------------------------------------------------------------------------------*/package org.polarsys.chess.multicore.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VSLUtils {


	
	
	public static int[] getBounds(String value) {
		String regex = "\\s*\\[\\s*(\\d+)\\s*\\.*\\s*(\\d+)\\]\\s*";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(value);
		int[] b = new int[2];

		if (matcher.find() && matcher.groupCount() == 2) {
			String begin_ = matcher.group(1);
			String end_ = matcher.group(2);
			b[0] = Integer.parseInt(begin_);
			b[1] = Integer.parseInt(end_);
			return b;
		}
		
		regex = "\\s*\\[\\s*(\\d+)\\s*\\]\\s*";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(value);
		if (matcher.find() && matcher.groupCount() == 1) {
			String begin_ = matcher.group(1);
			b[0] = Integer.parseInt(begin_);
			b[1] = b[0];
			return b;
		}
		
		regex = "\\s*(\\d+)\\s*";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(value);
		if (matcher.find() && matcher.groupCount() == 1) {
			String begin_ = matcher.group(1);
			b[0] = Integer.parseInt(begin_);
			b[1] = b[0];
			return b;
		}
		
		return null;
	}
	
	public static Boolean isInBounds(int id, java.util.List<int[]> bounds) {
		for (int[] b : bounds) {
			if (isInBounds(id, b))
				return true;
		}
		return false;
	}
	
	private static Boolean isInBounds(int id, int[] bounds) {
		return id >= bounds[0] && id <= bounds[1];
	}
	
	
}
