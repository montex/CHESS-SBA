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

public class ParameterList implements Serializable {

	//Simulator parameters
	private int minBatches = 1000;
	private int maxBatches = 1000000;
	private int dispUpdate = 100;
	private int measUpdate = 100;
	private double confidenceLevel = 0.99;
	private double confidenceInterval = 0.1;
	private int seed = 6657;
	
	public int getMinimumBatches() {
		return minBatches;
	}
	
	public int getMaximumBatches() {
		return maxBatches;
	}
	
	public int getDisplayUpdateInterval() {
		return dispUpdate;
	}
	
	public int getMeasureUpdateInterval() {
		return measUpdate;
	}
	
	public double getConfidenceLevel() {
		return confidenceLevel;
	}
	
	public double getConfidenceInterval() {
		return confidenceInterval;
	}
	
	public int getSeed() {
		return seed;
	}
	
	public void setMinimumBatches(int batches) {
		minBatches = batches;
	}
	
	public void setMaximumBatches(int batches) {
		maxBatches = batches;
	}
	
	public void setDisplayUpdateInterval(int batches) {
		dispUpdate = batches;
	}
	
	public void setMeasureUpdateInterval(int batches) {
		measUpdate = batches;
	}
	
	public void setConfidenceLevel(double cl) {
		confidenceLevel = cl;
	}
	
	public void setConfidenceInterval(double ci) {
		confidenceInterval = ci;
	}
	
	public void setSeed(int s) {
		seed = s;
	}
}
