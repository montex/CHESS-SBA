/*******************************************************************************
 *                  CHESS core plugin
 *
 *               Copyright (C) 2011-2015
 *            Mälardalen University, Sweden
 *
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License
 *  v1.0 which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.polarsys.chess.fla.common;

public class FlaAnalysisException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1695277209180788662L;

	public FlaAnalysisException() {
	}
	
	public FlaAnalysisException(Exception e) {
		super(e);
	}
	
	public FlaAnalysisException(String message) {
		super(message);
	}
	
}
