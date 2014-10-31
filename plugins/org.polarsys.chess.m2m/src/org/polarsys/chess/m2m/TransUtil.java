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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaAnalysisContext;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaEndtoEndFlow;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;
import org.polarsys.chess.chessmlprofile.Core.CHESS;
import org.polarsys.chess.chessmlprofile.Core.CHGaResourcePlatform;
import org.polarsys.chess.chessmlprofile.Core.PSMPackage;
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
	
	public static final String SA_ANALYSIS_CTX = "MARTE::MARTE_AnalysisModel::SAM::SaAnalysisContext";

	
	public static ModelContent loadModel(Resource inResource){
		return EmfUtil.loadModel(inResource.getURI());
	}
	
	public static ModelContent loadModel(IFile modelFile){
		return EmfUtil.loadModel(URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true));
	}
	
	public static void purgeModel(IFile modelFile, String saAnalysisQN) throws IOException {
		ModelContent inModel = loadModel(modelFile);
		Model m = (Model) inModel.getContent().get(0);
		//get the correct PSM package and platform...
		Package psmPackage = null;
		Package platform = null;
		Class saAnalysisClass = null;
		CHESS chess = (CHESS) m.getStereotypeApplication(m.getAppliedStereotype("CHESS::Core::CHESS"));
		for (Package pkg : chess.getPsmView().getBase_Package().getNestedPackages()) {
			Stereotype stereo = pkg.getAppliedStereotype("CHESS::Core::PSMPackage");
			if(stereo != null){
				PSMPackage psmPkg = (PSMPackage) pkg.getStereotypeApplication(stereo);
				if(psmPkg.getAnalysisContext().getBase_NamedElement().getQualifiedName().equals(saAnalysisQN)){
					psmPackage = pkg;
					platform = ((CHGaResourcePlatform) psmPkg.getAnalysisContext().getPlatform().get(0)).getBase_Package();
				}
			}
		}
		//...get the analysis context...
		for(Element elem : chess.getAnalysisView().getRtanalysisview().getBase_Package().allOwnedElements()){
			if(elem instanceof Class && ((Class)elem).getQualifiedName().equals(saAnalysisQN)){
				saAnalysisClass = (Class) elem;
			}
		}
		
		//...and remove the PSM package and clear the backpropagation (platform & context)
		if(psmPackage != null && platform != null){
			purgeRTAPackage(m, psmPackage);
			purgeBackpropagation(m, platform);
		}
		
		if(saAnalysisClass != null){
			System.out.println(saAnalysisClass.getName());
			purgeE2EResults(m, saAnalysisClass);
		}
		m.eResource().save(null);
	}
	
	// Remove the content of the RtAnalysisPackage
	private static void purgeRTAPackage(Model m, Package psmPackage) throws IOException {
		psmPackage.destroy();
	}
	
	
	//Remove the values of the backpropagation results 
	private static void purgeBackpropagation(Model m, Package platform) throws IOException {
		String name = platform.getName();
		name = name.substring(0, name.lastIndexOf('_'));
		Component compPlatform = null;
		for (Element el : m.allOwnedElements()) {
			if(el instanceof Component){
				if(((Component) el).getName().equals(name)){
					compPlatform = (Component) el;
				}
			}
		}
		if(compPlatform != null){
			for (Element el : compPlatform.getOwnedComments()) {
				CHRtSpecification chrt = UMLUtils.getStereotypeApplication(el, CHRtSpecification.class);
				if (chrt != null){
					chrt.getRespT().clear();
					chrt.getBlockT().clear();
				}
			}
		}
	}
	
	private static void purgeE2EResults(Model m, Class saAnalysisClass) {
		SaAnalysisContext saCtx = UMLUtils.getStereotypeApplication(saAnalysisClass, SaAnalysisContext.class);
		saCtx.setIsSched("");
		if(saCtx.getWorkload().size() > 0){
			Activity act = (Activity) saCtx.getWorkload().get(0).getBase_NamedElement();
			SaEndtoEndFlow e2eflow = UMLUtils.getStereotypeApplication(act, SaEndtoEndFlow.class);
			e2eflow.getEnd2EndT().clear();
		}
	}
}
