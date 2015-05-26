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

package org.polarsys.chess.m2m.transformations;

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
import org.polarsys.chess.m2m.Activator;


/**
 * Utility class for the QVT transformations
 */
public class TransUtil {	
	
	/** The Constant TRANSPATH. */
	public static final String TRANSPATH = "/transformations/";
	
	/** The Constant QVTO_PIM2PSM. */
	public static final String QVTO_PIM2PSM = "platform:/plugin/" + Activator.PLUGIN_ID + TRANSPATH + "CHESS_PIM2PSM.qvto";
	
	/** The Constant QVTO_PIM2PSMVERDE. */
	public static final String QVTO_PIM2PSMVERDE = "platform:/plugin/" + Activator.PLUGIN_ID + TRANSPATH + "CHESS_PIM2PSM_Inst_full_VERDE.qvto";
	
	/** The Constant QVTO_PIM2PSM_FULL. */
	public static final String QVTO_PIM2PSM_FULL = "platform:/plugin/" + Activator.PLUGIN_ID + TRANSPATH + "CHESS_PIM2PSM_Inst_full.qvto";
	
	/** The Constant QVTO_CEILING. */
	public static final String QVTO_CEILING = "platform:/plugin/" + Activator.PLUGIN_ID + TRANSPATH + "CHESS_CeilingAssignment.qvto";

	/** The Constant QVTO_MULTIINSTANCE. */
	public static final String QVTO_MULTIINSTANCE = "platform:/plugin/" + Activator.PLUGIN_ID + TRANSPATH + "BuildMultiInstance.qvto";
	
	/** The Constant QVTO_REMMULTIINSTANCE. */
	public static final String QVTO_REMMULTIINSTANCE = "platform:/plugin/" + Activator.PLUGIN_ID + TRANSPATH + "RemoveMultiInstance.qvto";
	
	/** The Constant TRANSFORMATIONS_DIR. */
	public static final String TRANSFORMATIONS_DIR = "schedulability_analysis";
	
	/** The Constant TRANSFORMATIONS_FULL_DIR. */
	public static final String TRANSFORMATIONS_FULL_DIR = "schedulability_analysis_full";
	
	/** The Constant CODEGEN_DIR. */
	public static final String CODEGEN_DIR = "src-gen";
	
	/** The Constant PIM_PSM_DIR. */
	public static final String PIM_PSM_DIR = "m2m-temp";

	/** The Constant TRANSFORMATIONS_DIR_VERDE. */
	public static final String TRANSFORMATIONS_DIR_VERDE = "schedulability_analysis_full_VERDE";
	
	/** The Constant TRANSFORMATIONS_DIR_E2E. */
	public static final String TRANSFORMATIONS_DIR_E2E= "End-To-End_schedulability_analysis";

	/** The Constant QVTO_PIM2PSME2E. */
	public static final String QVTO_PIM2PSME2E = "platform:/plugin/" + Activator.PLUGIN_ID + TRANSPATH + "CHESS_PIM2PSM_EndToEnd.qvto";

	/** The Constant RESULTS_DIR_E2E. */
	public static final String RESULTS_DIR_E2E = "End-To-End_analysis_results";
	
	/** The Constant SA_ANALYSIS_CTX. */
	public static final String SA_ANALYSIS_CTX = "MARTE::MARTE_AnalysisModel::SAM::SaAnalysisContext";

	
	
	/**
	 * Load mode as QVT ModelContent.
	 *
	 * @param modelFile the model file
	 * @return the QVT ModelContent stored in the given model file
	 * 
	 * @see org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent
	 */
	public static ModelContent loadModel(IFile modelFile){
		return EmfUtil.loadModel(URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true));
	}
	
	/**
	 * Purge the model.
	 *
	 * @param modelFile the model file
	 * @param saAnalysisQN the qualified name of MARTE <<SaAnalysisContext>> Class on which the purge needs to be applied
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see #purgeModel(Model, String)
	 */
	public static void purgeModel(IFile modelFile, String saAnalysisQN) throws IOException {
		ModelContent inModel = loadModel(modelFile);
		Model m = (Model) inModel.getContent().get(0);
		purgeModel(m, saAnalysisQN);
	}
	
	/**
	 * Purge the model
	 *
	 * @param the CHESS model file
	 * @param saAnalysisQN the qualified name of MARTE <<SaAnalysisContext>> Class on which the purge needs to be applied
	 * @throws IOException Signals that an I/O exception has occurred during saving the model resource.
	 */
	public static void purgeModel(Model model, String saAnalysisQN) throws IOException {
		
		//get the correct PSM package and platform...
		Package psmPackage = null;
		Package platform = null;
		Class saAnalysisClass = null;
		CHESS chess = (CHESS) model.getStereotypeApplication(model.getAppliedStereotype("CHESS::Core::CHESS"));
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
			psmPackage.destroy();
			purgeBackpropagation(model, platform);
		}
		
		if(saAnalysisClass != null){
			purgeE2EResults(model, saAnalysisClass);
		}
		
	}
	
	
	
	//Remove the values of the backpropagation results 
	/**
	 * Purge backpropagation data.
	 * The back propagation of analysis results to CHRtSpecification stereotype is deprecated.
	 *
	 * @param m the m
	 * @param platform the platform
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Deprecated
	private static void purgeBackpropagation(Model m, Package platform)  {
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
	
	/**
	 * Purge e2 e results.
	 *
	 * @param m the m
	 * @param saAnalysisClass the sa analysis class
	 */
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
