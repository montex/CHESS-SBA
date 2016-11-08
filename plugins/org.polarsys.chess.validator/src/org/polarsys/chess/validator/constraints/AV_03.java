/*
-----------------------------------------------------------------------
--                CHESS Live/Batch Validator plugin                  --
--                                                                   --
--                    Copyright (C) 2011-2015                        --
--                 University of Padova, ITALY                       --  
--                        Intecs, Italy   											 --
--                                                                   --
-- Author: Stefano Puri								                 --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
 */
package org.polarsys.chess.validator.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaResourcesPlatform;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaAnalysisContext;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.polarsys.chess.chessmlprofile.Core.CHGaResourcePlatform;
import org.polarsys.chess.chessmlprofile.util.Constants;
import org.polarsys.chess.core.profiles.CHESSProfileManager;


/**
 * The Class AV_03.
 * This class implements the following constraint (invoked by the EMF validation framework):
 * the SaAnalysisContext classifier in the Analysis View must have its “Platform” property 
 * valued with a CHGaResourcePlatform that is a Package in the Component View.
 * @since 0.10
 */
public class AV_03 extends AbstractModelConstraint {

	/* (non-Javadoc)
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObject = ctx.getTarget();
		Classifier cl = (Classifier) eObject;
		IStatus success = ctx.createSuccessStatus();

		String classifierName = "";
		classifierName = cl.getName();

		String errorMsg = null;

		IStatus failure = ctx.createFailureStatus(
				classifierName,			  		
				errorMsg	
				); 
		
		Stereotype marteSaAnalysisContextStereo = cl.getAppliedStereotype(Constants.MARTE_SaAnalysisContext);
		
		if (marteSaAnalysisContextStereo!=null) {
			// we only want to make this validation on the SaAnalysisContext that are inside the Analysis View
			Model umlModel = cl.getModel();
			Package analysisViewPack = CHESSProfileManager.getViewByStereotype(umlModel, Constants.ANALYSIS_VIEW_NAME);
			EList<Element> allAnalysisView = analysisViewPack.allOwnedElements();
			boolean isInAnalysisView = false;
			for (Element element : allAnalysisView) {
				if (element.equals(cl)) {
					isInAnalysisView = true;
					break;
				}				
			}
			if (!isInAnalysisView) {
				return success;
			}						
			
			SaAnalysisContext saAnalysisCont = (SaAnalysisContext)cl.getStereotypeApplication(marteSaAnalysisContextStereo);
			// look at its "Platform" property
			boolean isChgaResPlat = false;
			EList<GaResourcesPlatform> platforms = saAnalysisCont.getPlatform();
			for (GaResourcesPlatform platform: platforms) {				
				if(platform instanceof CHGaResourcePlatform) {	
					isChgaResPlat = true;
					CHGaResourcePlatform chgaResPlat = (CHGaResourcePlatform) platform;										
					//now we look for this chgaResourcePlatform in the Packages of the Component View
					Package componentViewPack = CHESSProfileManager.getViewByStereotype(umlModel, Constants.COMPONENT_VIEW_NAME);
					EList<Element> all = componentViewPack.allOwnedElements();					
					for (Element element : all) {
						if (element instanceof org.eclipse.uml2.uml.Package) {							
							if (element.getAppliedStereotype(Constants.CHGARESOURCEPLATFORM)!=null) {
								Stereotype chgaResPlatStereo = element.getAppliedStereotype(Constants.CHGARESOURCEPLATFORM);
								EObject eobj = element.getStereotypeApplication(chgaResPlatStereo);
								CHGaResourcePlatform chgaResPlatPackage = (CHGaResourcePlatform)eobj;								
								if (chgaResPlatPackage.equals(chgaResPlat)) {
									return success;
								}
							}
						}
					}								
				}								
			}
			
			if (platforms.size()==0) {
				errorMsg = "The property Platform is empty";
			}
			else {
				if (!isChgaResPlat) {
					errorMsg = "The property Platform is not stereotyped as CHGaResourcePlatform";
				}
				else {
					errorMsg = "The property Platform is not a Package in Component View";
				}
			}

			failure = ctx.createFailureStatus(
					classifierName,			  		
					errorMsg
					);
			return failure;
		}
		// the Classifier we are looking at is not a SaAnalysisContext
		return success;
	}
}




