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

package org.polarsys.chess.m2m.backpropagation;

import static org.polarsys.chess.core.util.CHESSProjectSupport.printlnToCHESSConsole;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
import org.eclipse.m2m.internal.qvt.oml.trace.EMappingContext;
import org.eclipse.m2m.internal.qvt.oml.trace.EMappingResults;
import org.eclipse.m2m.internal.qvt.oml.trace.Trace;
import org.eclipse.m2m.internal.qvt.oml.trace.TraceRecord;
import org.eclipse.m2m.internal.qvt.oml.trace.VarParameterValue;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaResourcesPlatform;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaAnalysisContext;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaCommHost;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaEndtoEndFlow;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaExecHost;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwMutualExclusionResource;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Slot;
import org.polarsys.chess.chessmlprofile.Core.CHGaResourcePlatform;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwBus;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwComputingResource;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwProcessor;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification;
import org.polarsys.chess.core.util.uml.UMLUtils;
import org.polarsys.chess.m2m.transformations.TransUtil;



/**
 * The Class implements the back propagation of timing analysis results.
 * The back annotation of results to CHRtSpecifications is no more required;
 * currently it is used only to allow visualization of analysis results in the dedicated dialogs;
 * The way dialogs retrieve the information should be changed; then this class could be removed.
 * @deprecated
 */
@Deprecated
public class BackpropagationFullVERDE{

	/** The rules. */
	protected static List<BackpropagationRule> rules = new ArrayList<BackpropagationRule>();

	/**
	 * Process qvto trace file.
	 *
	 * @param editor the current active editor
	 * @param model the model analyzed with MAST
	 * @throws Exception the exception
	 */
	public static void processQVTOTraceFile(PapyrusMultiDiagramEditor editor, IFile model) throws Exception {
		printlnToCHESSConsole("*** CHESS PSM->PIM backpropagation ***");
		ModelContent inModel = TransUtil.loadModel(model);		
		Resource inResource = inModel.getResourceSet().getResource(URI.createURI(model.getLocationURI().toString()), true);
		
		String modelURI = URI.createPlatformResourceURI(model.getFullPath().toString(), true).toString();
		String strTraceUri = modelURI.substring(0,modelURI.lastIndexOf('.') + 1) + "qvtotrace";
		
		inResource = inModel.getResourceSet().getResource(URI.createURI(strTraceUri), true);
		ModelContent traceModel = new ModelContent(inResource.getContents());
		
		Trace trace = (Trace) traceModel.getContent().get(0);
		for (TraceRecord rec: trace.getTraceRecords()) {
			EMappingContext ctx = rec.getContext();
			//printlnToCHESSConsole("Parsing trace: " + rec.getMappingOperation().getName());
			EMappingResults res = rec.getResult();
			EList<VarParameterValue> ress = res.getResult();
			EObject outEl = null;
			if (ress.isEmpty()){
				// if the mapping has no output, i.e. it is a INOUT mapping
				continue;
			}else{ 
				outEl = ress.get(0).getValue().getModelElement();
			}
			EObject inEl = ctx.getContext().getValue().getModelElement();
				
			for (BackpropagationRule rule : rules) {
				if (rule.getInputType().isInstance(inEl) && rule.getOutputType().isInstance(outEl)){
					rule.rule(inEl, outEl, rec);
				}
			}
			Resource inputResource = inEl.eResource();
			inputResource.save(null);
			}
		
		printlnToCHESSConsole("*** End of CHESS PSM->PIM backpropagation   ***");
	}
	
	/**
	 * The Class BackpropagationRule.
	 *
	 * @param <I> the generic type
	 * @param <O> the generic type
	 */
	static public abstract class BackpropagationRule<I, O> {
		
		/** The input type. */
		private Class<I> inputType;
		
		/** The output type. */
		private Class<O> outputType;
		
		/**
		 * Gets the input type.
		 *
		 * @return the input type
		 */
		public Class<I> getInputType() {
			return inputType;
		}
		
		/**
		 * Gets the output type.
		 *
		 * @return the output type
		 */
		public Class<O> getOutputType() {
			return outputType;
		}
		
		/**
		 * Instantiates a new backpropagation rule.
		 *
		 * @param inputType the input type
		 * @param outputType the output type
		 */
		public BackpropagationRule(Class<I> inputType, Class<O> outputType) {
			this.inputType = inputType;
			this.outputType = outputType;
			rules.add(this);
		}
		
		/**
		 * Prints the status.
		 *
		 * @param property the property
		 * @param theElement the the element
		 * @param value the value
		 */
		public void printStatus(final String property, final Element theElement, final String value){
			if (value == null || theElement ==null)
				return;
			if ( value.isEmpty())
				return;
			
			String elName = theElement instanceof NamedElement?((NamedElement)theElement).getQualifiedName():theElement.toString();
			StringBuilder s = new StringBuilder(20);
			s.append(property).append(" updated for ").append(elName).append(": ").append(value);
			printlnToCHESSConsole(s.toString());
		}	
		
		/**
		 * Rule.
		 *
		 * @param inEl the in el
		 * @param outEl the out el
		 * @param rec the rec
		 */
		abstract void rule(I inEl, O outEl, TraceRecord rec);
	}
	
		
	/** The CHRT comment2 sa step. */
	/* analysis results are no more propagated to CHRtSpecification
	static BackpropagationRule<InstanceSpecification, Operation> CHRTComment2SaStep = new BackpropagationRule<InstanceSpecification, Operation>(InstanceSpecification.class, Operation.class) {
		@Override
		void rule(InstanceSpecification inEl, Operation outEl, TraceRecord rec) {
			Comment chrt = null;
			Slot slot = null;
			try {
				VarParameterValue v = rec.getParameters().getParameters().get(0); 
				chrt = (Comment) v.getValue().getModelElement();
				
				v = rec.getParameters().getParameters().get(1); 
				slot = (Slot) v.getValue().getModelElement();
			} catch (Exception e) {
				return;
			}
			
			CHRtSpecification in = UMLUtils.getStereotypeApplication(chrt, CHRtSpecification.class);
			SaStep out = UMLUtils.getStereotypeApplication(outEl, SaStep.class);
			IdentifInstance id = UMLUtils.getStereotypeApplication(slot.getOwningInstance(), IdentifInstance.class);
			if (out == null || in == null || id == null)
				return;
			String blockT = out.getBlockT() != null ? "(instance=" + id.getId() + ", " + out.getBlockT().substring(1) : "";
			String respT = !out.getRespT().isEmpty() ? "(instance=" + id.getId() + ", " + out.getRespT().get(0).substring(1) : "";
			
			if (blockT != "")
				in.getBlockT().add(blockT);
			
			if (respT != "")
				in.getRespT().add(respT);
			
			printStatus("'blockT'", in.getContext(), blockT);
			printStatus("'respT'", in.getContext(), respT);
		}
	};*/
	
	/** The Hw computing resource2 sa exec host. */
	static BackpropagationRule<InstanceSpecification, org.eclipse.uml2.uml.Class> HwComputingResource2SaExecHost = new BackpropagationRule<InstanceSpecification, org.eclipse.uml2.uml.Class>(InstanceSpecification.class, org.eclipse.uml2.uml.Class.class) {
		@Override
		void rule(InstanceSpecification inEl, org.eclipse.uml2.uml.Class outEl, TraceRecord rec) {
			CH_HwComputingResource in = UMLUtils.getStereotypeApplication(inEl, CH_HwComputingResource.class);
			SaExecHost out = UMLUtils.getStereotypeApplication(outEl, SaExecHost.class);
			if (in == null || out == null)
				return;
			//String slack = out.getSchSlack();
			String util = !out.getUtilization().isEmpty() ? out.getUtilization().get(0) : "";
			in.setUtilization(util);
			printStatus("'utilization'", inEl, util);
		}
	};
	
	/** The Hw processor2 sa exec host. */
	static BackpropagationRule<InstanceSpecification, org.eclipse.uml2.uml.Class> HwProcessor2SaExecHost = new BackpropagationRule<InstanceSpecification, org.eclipse.uml2.uml.Class>(InstanceSpecification.class, org.eclipse.uml2.uml.Class.class) {
		@Override
		void rule(InstanceSpecification inEl, org.eclipse.uml2.uml.Class outEl, TraceRecord rec) {
			CH_HwProcessor in = UMLUtils.getStereotypeApplication(inEl, CH_HwProcessor.class);
			SaExecHost out = UMLUtils.getStereotypeApplication(outEl, SaExecHost.class);
			if (in == null || out == null)
				return;
			//String slack = out.getSchSlack();
			String util = !out.getUtilization().isEmpty() ? out.getUtilization().get(0) : "";
			in.setUtilization(util);
			printStatus("'utilization'", inEl, util);
		}
	};
	
	/** The Hw bus2 sa comm host. */
	static BackpropagationRule<InstanceSpecification, org.eclipse.uml2.uml.Class> HwBus2SaCommHost = new BackpropagationRule<InstanceSpecification, org.eclipse.uml2.uml.Class>(InstanceSpecification.class, org.eclipse.uml2.uml.Class.class) {
		@Override
		void rule(InstanceSpecification inEl, org.eclipse.uml2.uml.Class outEl, TraceRecord rec) {
			CH_HwBus in = UMLUtils.getStereotypeApplication(inEl, CH_HwBus.class);
			SaCommHost out = UMLUtils.getStereotypeApplication(outEl, SaCommHost.class);
			if (in == null || out == null)
				return;
			//String slack = out.getSchSlack();
			String util = !out.getUtilization().isEmpty() ? out.getUtilization().get(0) : "";
			in.setUtilization(util);
			printStatus("'utilization'", inEl, util);
		}
	};
	
	/** The CH ga resource platform2 sa analysis context. */
	static BackpropagationRule<Component, org.eclipse.uml2.uml.Class> CHGaResourcePlatform2SaAnalysisContext = new BackpropagationRule<Component, org.eclipse.uml2.uml.Class>(Component.class, org.eclipse.uml2.uml.Class.class) {
		@Override
		void rule(Component inEl, org.eclipse.uml2.uml.Class outEl, TraceRecord rec) {
			GaResourcesPlatform in = UMLUtils.getStereotypeApplication(inEl, CHGaResourcePlatform.class);
			SaAnalysisContext out = UMLUtils.getStereotypeApplication(outEl, SaAnalysisContext.class);
			if (in == null || out == null)
				return;
			//String slack = out.getIsSched();
		}
	};
	
	/** The Operation2 sa shared resource. */
	static BackpropagationRule<InstanceSpecification, org.eclipse.uml2.uml.Class> Operation2SaSharedResource = new BackpropagationRule<InstanceSpecification, org.eclipse.uml2.uml.Class>(InstanceSpecification.class, org.eclipse.uml2.uml.Class.class) {
		@Override
		void rule(InstanceSpecification inEl, org.eclipse.uml2.uml.Class outEl, TraceRecord rec) {
			
			Comment chrt = null;
			Slot slot = null;
			try {
				VarParameterValue v = rec.getParameters().getParameters().get(0); 
				chrt = (Comment) v.getValue().getModelElement();
				
				v = rec.getParameters().getParameters().get(1); 
				slot = (Slot) v.getValue().getModelElement();
			} catch (Exception e) {
				return;
			}
			if(chrt == null)
				return;
			
			CHRtSpecification in = UMLUtils.getStereotypeApplication(chrt, CHRtSpecification.class);
			SwMutualExclusionResource out = UMLUtils.getStereotypeApplication(outEl, SwMutualExclusionResource.class);
			if (in == null || out == null)
				return;
			String ceiling = out.getCeiling(); 
			in.setCeiling(ceiling);
			printStatus("'ceiling'", in.getContext(), ceiling);
			//in.setStackSize(out.getCapacity());
		}
	};
	
	
	/** The slot2 end to end work flow. */
	static BackpropagationRule<InstanceSpecification, org.eclipse.uml2.uml.Activity> slot2EndToEndWorkFlow = new BackpropagationRule<InstanceSpecification, org.eclipse.uml2.uml.Activity>(InstanceSpecification.class, org.eclipse.uml2.uml.Activity.class) {
		@Override
		void rule(InstanceSpecification inEl, org.eclipse.uml2.uml.Activity outEl, TraceRecord rec) {
			
			
			Comment chrt = null;
			Slot slot = null;
			try {
				VarParameterValue v = rec.getParameters().getParameters().get(0); 
				chrt = (Comment) v.getValue().getModelElement();
				
				v = rec.getParameters().getParameters().get(1); 
				slot = (Slot) v.getValue().getModelElement();
			} catch (Exception e) {
				return;
			}
			
			CHRtSpecification in = UMLUtils.getStereotypeApplication(chrt, CHRtSpecification.class);
			SaEndtoEndFlow out = UMLUtils.getStereotypeApplication(outEl, SaEndtoEndFlow.class);
			if (in == null || out == null)
				return;
			EList<String> e2e = out.getEnd2EndT(); 
			if (e2e != null && !e2e.isEmpty()){
				//check if respT is already added by CHRTComment2SaStep...
				if (in.getRespT().isEmpty()){
						in.getRespT().add(e2e.get(0));
						printStatus("'respT'", in.getContext(), e2e.get(0));
				}
				else
					printStatus("'respT not updated'", in.getContext(), e2e.get(0));
			}	
			//in.setStackSize(out.getCapacity());
		}
	};
	
	/** The Interaction2 end to end work flow. */
	static BackpropagationRule<Interaction, Activity> Interaction2EndToEndWorkFlow = new BackpropagationRule<Interaction, Activity>(Interaction.class, Activity.class) {
		@Override
		void rule(Interaction inEl, Activity outEl, TraceRecord rec) {
			
			//get the end2end worst completion time from PSM end2end flow
			SaEndtoEndFlow psmE2EFlow = UMLUtils.getStereotypeApplication(outEl, SaEndtoEndFlow.class);
			EList<String> end2endT = psmE2EFlow.getEnd2EndT();
			
			//get the analysis result (true/false) from PSM analysis context
			VarParameterValue param = rec.getParameters().getParameters().get(0);
			org.eclipse.uml2.uml.Class psmContext = (org.eclipse.uml2.uml.Class) param.getValue().getModelElement();
			SaAnalysisContext psmAnalysisCtx = UMLUtils.getStereotypeApplication(psmContext, SaAnalysisContext.class);
			String isSched = psmAnalysisCtx.getIsSched();
			
			//update isSched for PIM analysis context
			param = rec.getParameters().getParameters().get(1);
			org.eclipse.uml2.uml.Class pimContext = (org.eclipse.uml2.uml.Class) param.getValue().getModelElement();
			SaAnalysisContext pimAnalysisCtx = UMLUtils.getStereotypeApplication(pimContext, SaAnalysisContext.class);
			pimAnalysisCtx.setIsSched(isSched);
			printStatus("isSched", pimContext, isSched);
			
			//update end2EndT for PIM e2e flow
			param = rec.getParameters().getParameters().get(2);
			Activity pimActivity = (Activity) param.getValue().getModelElement();
			SaEndtoEndFlow pimE2EFlow = UMLUtils.getStereotypeApplication(pimActivity, SaEndtoEndFlow.class);
			pimE2EFlow.getEnd2EndT().clear();
			pimE2EFlow.getEnd2EndT().add(end2endT.get(0));
			printStatus("endToEndT", pimActivity, end2endT.get(0));
		}
	};
}