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

import java.util.List;

public interface FlaLogger {

	public void logError(String message);
	
	public void logWarning(String message);
	
	public List<String> getErrors();
	
	public List<String> getWarnings();
}
