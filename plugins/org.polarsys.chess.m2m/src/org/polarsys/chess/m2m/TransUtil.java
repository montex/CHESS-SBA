/*
-----------------------------------------------------------------------
--          			CHESS M2M plugin							 --
--                                                                   --
--                    Copyright (C) 2011-2012                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- Author: Alessandro Zovi         azovi@math.unipd.it 		         --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
*/

package org.polarsys.chess.m2m;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification;
import org.polarsys.chess.core.util.uml.UMLUtils;
import org.polarsys.chess.core.views.ViewUtils;

//import es.unican.ctr.marte2mast.Marte2mast;

public class TransUtil {	
	public static final String TRANSPATH = "/transformations/";
	
	public static final String QVTO_PIM2PSM = "platform:/plugin/" + Activator.PLUGIN_ID + TRANSPATH + "CHESS_PIM2PSM.qvto";
	
	public static final String QVTO_PIM2PSMVERDE = "platform:/plugin/" + Activator.PLUGIN_ID + TRANSPATH + "CHESS_PIM2PSM_Inst_full_VERDE.qvto";
	
	public static final String QVTO_PIM2PSM_FULL = "platform:/plugin/" + Activator.PLUGIN_ID + TRANSPATH + "CHESS_PIM2PSM_Inst_full.qvto";
	
	public static final String QVTO_CEILING = "platform:/plugin/" + Activator.PLUGIN_ID + TRANSPATH + "CHESS_CeilingAssignment.qvto";

	public static final String QVTO_MULTIINSTANCE = "platform:/plugin/" + Activator.PLUGIN_ID + TRANSPATH + "BuildMultiInstance.qvto";
	
	public static final String QVTO_REMMULTIINSTANCE = "platform:/plugin/" + Activator.PLUGIN_ID + TRANSPATH + "RemoveMultiInstance.qvto";
	
	public static final String TRANSFORMATIONS_DIR = "schedulability_analysis";
	
	public static final String TRANSFORMATIONS_FULL_DIR = "schedulability_analysis_full";
	
	public static final String CODEGEN_DIR = "src-gen";
	
	public static final String PIM_PSM_DIR = "m2m-temp";

	public static final String TRANSFORMATIONS_DIR_VERDE = "schedulability_analysis_full_VERDE";
	
	public static final String TRANSFORMATIONS_DIR_E2E= "End-To-End_schedulability_analysis";

	public static final String QVTO_PIM2PSME2E = "platform:/plugin/" + Activator.PLUGIN_ID + TRANSPATH + "CHESS_PIM2PSM_EndToEnd.qvto";

	public static final String RESULTS_DIR_E2E = "End-To-End_analysis_results";

	
	public static ModelContent loadModel(Resource inResource){
		return EmfUtil.loadModel(inResource.getURI());
	}
	
	public static ModelContent loadModel(IFile modelFile){
		return EmfUtil.loadModel(URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true));
	}
	
	public static void purgeModel(IFile modelFile) throws IOException {
		ModelContent inModel = loadModel(modelFile);
		Model m = (Model) inModel.getContent().get(0);
		purgeRTAPackage(m);
		purgeBackpropagation(m);
		m.eResource().save(null);
	}
	
	// Remove the content of the RtAnalysisPackage
	private static void purgeRTAPackage(Model m) throws IOException {
		Package rt = ViewUtils.getCHESSRtAnalysisPackage(m);
		ArrayList<Element> l = new ArrayList<Element>(); 
		for (Element e : rt.getOwnedElements()) {
			if (e instanceof Package){
				l.add(e);
			}
		}
		for (int i = 0; i < l.size(); i++) {
			l.get(i).destroy();
		}
	}
	
	
	// Remove the values of the backpropagation results 
	private static void purgeBackpropagation(Model m) throws IOException {
		Package cm = ViewUtils.getCHESSComponentPackage(m);
		for (Element el : cm.allOwnedElements()) {
			CHRtSpecification chrt = UMLUtils.getStereotypeApplication(el, CHRtSpecification.class);
			if (chrt != null){
				chrt.getRespT().clear();
				chrt.getBlockT().clear();
			}
		}
	}
}
