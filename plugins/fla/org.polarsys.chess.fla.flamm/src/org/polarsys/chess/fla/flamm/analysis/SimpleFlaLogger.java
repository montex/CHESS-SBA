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
package org.polarsys.chess.fla.flamm.analysis;

import java.util.ArrayList;
import java.util.List;

public class SimpleFlaLogger implements FlaLogger{

	protected List<String> errors = new ArrayList<String>();
	protected List<String> warnings = new ArrayList<String>();
	
	public void logError(String message) {
		errors.add(message);
	}
	
	public void logWarning(String message) {
		warnings.add(message);
	}
	
	public List<String> getErrors() {
		return errors;
	}
	
	public List<String> getWarnings() {
		return warnings;
	}
}
