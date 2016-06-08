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
package org.polarsys.chess.m2m.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.window.Window;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaAnalysisContext;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Stereotype;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtPortSlot;
import org.polarsys.chess.chessmlprofile.util.Constants;
import org.polarsys.chess.core.util.AnalysisResultData;
import org.polarsys.chess.core.util.CHESSProjectSupport;
import org.polarsys.chess.core.util.HWAnalysisResultData;
import org.polarsys.chess.core.util.uml.UMLUtils;
import org.polarsys.chess.m2m.Activator;
import org.polarsys.chess.m2m.transformations.TransUtil;
import org.polarsys.chess.m2m.ui.CompareSchedResultDialog;


/**
 * @since 0.9
 */
public class CompareAnalysisResultsHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		EList<EObject> selectedObjects = UMLUtils.getTwoSelectedElements();
		if (selectedObjects.size()!=2) {
			CHESSProjectSupport.printlnToCHESSConsole("User must select two <<SaAnalysisContext>> elements for analysis results comparison!");
			return null;
		}
		
		EObject selection1 = selectedObjects.get(0);
		EObject selection2 = selectedObjects.get(1);
		List<AnalysisResultData> listData1 = new BasicEList<AnalysisResultData>();
		List<AnalysisResultData> listData2 = new BasicEList<AnalysisResultData>();
		List<HWAnalysisResultData> listHWData1 = new BasicEList<HWAnalysisResultData>();
		List<HWAnalysisResultData> listHWData2 = new BasicEList<HWAnalysisResultData>();
		String analysisContextName1 = "";
		String analysisContextName2 = "";
				
		Element element1 = (Element)selection1;
		
		if (element1.getAppliedStereotype(Constants.MARTE_SaAnalysisContext)!=null) {
			Stereotype saAnalysisContextStereo = element1.getAppliedStereotype(Constants.MARTE_SaAnalysisContext);
			SaAnalysisContext analysisContext1 = (SaAnalysisContext) element1.getStereotypeApplication(saAnalysisContextStereo);			
			analysisContextName1 = analysisContext1.getBase_NamedElement().getName();
			//System.out.println("analysisContextName1="+analysisContextName1);
			listData1 = UMLUtils.getAnalysisResults((Class) element1);	
			listHWData1 = UMLUtils.getHWAnalysisResults((Class)element1);
		}
		else {
			CHESSProjectSupport.printlnToCHESSConsole("User must select two <<SaAnalysisContext>> elements for analysis results comparison!");
			return null;
		}
		
		Element element2 = (Element)selection2;
		if (element2.getAppliedStereotype(Constants.MARTE_SaAnalysisContext)!=null) {
			Stereotype saAnalysisContextStereo = element2.getAppliedStereotype(Constants.MARTE_SaAnalysisContext);
			SaAnalysisContext analysisContext2 = (SaAnalysisContext) element2.getStereotypeApplication(saAnalysisContextStereo);
			analysisContextName2 = analysisContext2.getBase_NamedElement().getName();
			listData2 = UMLUtils.getAnalysisResults((Class) element2);
			listHWData2 = UMLUtils.getHWAnalysisResults((Class)element2);
		}
		else {
			CHESSProjectSupport.printlnToCHESSConsole("User must select two <<SaAnalysisContext>> elements for analysis results comparison!");
			return null;
		}
		
		openComparedAnalysisReport(analysisContextName1, analysisContextName2, listData1, listData2, listHWData1, listHWData2);
				
		return null;
	}

	/**
	 * Opens a simple, user-friendly report that displays two analysis results 
	 * corresponding to the two input analysisContexts
	 * @param analysisContextName1
	 * @param analysisContextName2
	 * @param listAnalysisResult1
	 * @param listAnalysisResult2
	 * @param listHWData1
	 * @param listHWData2
	 */
	private void openComparedAnalysisReport(final String analysisContextName1, 
			final String analysisContextName2, 
			final List<AnalysisResultData> listAnalysisResult1,
			final List<AnalysisResultData> listAnalysisResult2, 
			final List<HWAnalysisResultData> listHWData1,
			final List<HWAnalysisResultData> listHWData2) {		

		if (listAnalysisResult1.size() == 0 && listAnalysisResult2.size()==0) {
			CHESSProjectSupport.printlnToCHESSConsole("User must select two <<SaAnalysisContext>> elements for analysis results comparison!");
			return;
		}
		//and open a simple, user-friendly report
		
		
		Shell activeShell = Display.getDefault().getActiveShell();
		CompareSchedResultDialog compareResultsDialog = new CompareSchedResultDialog(activeShell, analysisContextName1, 
				analysisContextName2, listAnalysisResult1, 
				listAnalysisResult2, listHWData1, listHWData2, "Compare analysis results");
		if (compareResultsDialog.open() == Window.OK) {
			
		}
	}
	
		
}
