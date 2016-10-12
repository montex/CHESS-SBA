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

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Stereotype;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwProcessor;
import org.polarsys.chess.chessmlprofile.util.Constants;
import org.polarsys.chess.core.util.uml.UMLUtils;

/**
 * Used to save and display the HW data from Schedulability Analysis result data 
 * @author laura
 *
 */
public class HWAnalysisResultData {
	public InstanceSpecification hwInstSpec = null; 
	public String hw_instance="";
	public String hw_utilization="";
	public String hw_res="";

	public String getResultString() {
		String theResult = "";
		String theHwUtilizationPerc = UMLUtils.getValue(hw_utilization, "value");
		if(theHwUtilizationPerc != null && !theHwUtilizationPerc.isEmpty()){
			if(Float.parseFloat(theHwUtilizationPerc) <= 100) {
				theResult = "OK";		
			} 
			else {
				theResult = "NOT OK";
			}
		}
		return theResult;
	}
	
	/**
	 * Returns the CH_HWProcessor of the hwInstanceSpecification
	 * @return
	 */
	public CH_HwProcessor getProcessor() {
		CH_HwProcessor chHwProc = null;
		Element element = hwInstSpec;
			if((element.getAppliedStereotype(Constants.CH_HWPROCESSOR)!=null)) {
				Stereotype chHwProcStereo = element.getAppliedStereotype(Constants.CH_HWPROCESSOR);
				chHwProc = (CH_HwProcessor) element.getStereotypeApplication(chHwProcStereo);
		}
		return chHwProc;
	}
}

