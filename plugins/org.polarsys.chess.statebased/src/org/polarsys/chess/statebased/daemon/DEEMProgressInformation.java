/*
-----------------------------------------------------------------------
-- Copyright (C) 2011-2016                                           --
-- University of Firenze, Italy	                                     --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
--                                                                   --
-- Contributors:                                                     --
-- Leonardo Montecchi 	lmontecchi@unifi.it                          --
-----------------------------------------------------------------------
*/

package org.polarsys.chess.statebased.daemon;

import java.io.Serializable;
import java.util.Formatter;

public class DEEMProgressInformation implements Serializable {
	private int iCurrent;	//Performed batches
	private int iMin;		//Minimum batches
	private int iMax;		//Maximum batches
	
	public int getCurrent() {
		return iCurrent;
	}
	
	public int getMinimum() {
		return iMin;
	}
	
	public int getMaximum() {
		return iMax;
	}
	
	public int getMissing() {
		if(iMin - iCurrent > 0) {
			return iMin - iCurrent;
		}else {
			return 0;
		}
	}
	
	public boolean minimumReached() {
		return getMissing() == 0;
	}
	
	public float getPercentToMax() {
		return (float)iCurrent/iMax*100;
	}
	
	public String getPercentToMax(String format) {
		Formatter f = new Formatter();
		return f.format(format, (float)iCurrent/iMax*100).toString();
	}	
		
	public float getPercentToMin() {
		return (float)iCurrent/iMin*100;
	}

	public String getPercentToMin(String format) {
		Formatter f = new Formatter();
		return f.format(format, (float)iCurrent/iMin*100).toString();
	}
	
	public void setStatus(int min, int max, int current) {
		iMin = min;
		iMax = max;
		iCurrent = current;
	}
	
	public void setStatus(int current) {
		setStatus(getMinimum(), getMaximum(), current);
	}
	
	public String toString() {
		String s = getCurrent() + " of " + getMaximum() + " batches completed (";
		s += getPercentToMax("%.2f");
		s += "% of max"; 
		if(!minimumReached()) {
			s += " | " + getMissing() + " to min";
		}
		s += ")";
		return s;
	}
}
