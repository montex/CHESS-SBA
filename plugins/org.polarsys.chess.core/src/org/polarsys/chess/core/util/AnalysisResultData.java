/*******************************************************************************
 *
 * Copyright (c) 2015 Intecs SpA 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Laura Baracchi  laura.baracchi@intecs.it  - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.polarsys.chess.core.util;

import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Operation;

/**
 * Used to save and display the Schedulability Analysis result data
 * @author laura
 *
 */
public class AnalysisResultData {
		public InstanceSpecification instSpec = null;
		public Operation ctxOP = null;
		public String instance ="";
		public String context ="";
		public String arrival ="";
		public String localWCET="";
		public String rldl ="";
		public String priority="";
		public String respT ="";
		public String blockT="";
		public String isSched = "";
	}
