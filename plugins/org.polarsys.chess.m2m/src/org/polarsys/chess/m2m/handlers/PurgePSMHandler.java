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

package org.polarsys.chess.m2m.handlers;

import static org.polarsys.chess.core.util.CHESSProjectSupport.printlnToCHESSConsole;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaAnalysisContext;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaEndtoEndFlow;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwBus;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwProcessor;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification;
import org.polarsys.chess.core.util.CHESSProjectSupport;
import org.polarsys.chess.core.util.uml.ResourceUtils;
import org.polarsys.chess.core.util.uml.UMLUtils;
import org.polarsys.chess.core.views.DiagramStatus;
import org.polarsys.chess.core.views.ViewUtils;
import org.polarsys.chess.m2m.transformations.TransUtil;
import org.polarsys.chess.m2m.ui.AnalysisContextSelectionDialog;
import org.polarsys.chess.service.utils.CHESSEditorUtils;



/**
 * This class allows to purge the model, in particular by removing the information attached to a given analysisContext, 
 * in particular the generated PSM package.
 * @since 0.9
 */
public class PurgePSMHandler extends AbstractHandler {
	
	@Inject Shell activeShell;
	
	/** The editor. */
	protected IEditorPart editor;

	
	/**
	 *  
	 * From the current active editor, first retrieves the CHESS model and then asks the user which analysis context, if any, has to be purged.
	 * The purge applies to the PSM and the analysis results referred by the user-selected analysis context.
	 *
	 * @param event the event
	 * @return :
	 * 		null if the model does not contain any analysis context then the method return, or the Status of the 
	 * 		Status.ERROR in case of any error during purging
	 * 		Status.CANCEL_STATUS in case the monitor is canceled during purging
	 * 		Status.OK_STATUS in case the purge executes successfully
	 *      
	 * @throws ExecutionException the execution exception
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * @see #removeRtAnalysis(Model, Package)
	 * @see org.eclipse.core.runtime.Status
	 * @see org.polarsys.chess.m2m.transformations.TransUtil#purgeModel(Model, String)
	 */
	@Override
	public Status execute(final ExecutionEvent event) throws ExecutionException {
		editor = HandlerUtil.getActiveEditor(event);
		Class contextClass = null;
		final String saAnalysisName;
		//SaAnalysisContext saAnalysisCtx;
		
		if (!(CHESSEditorUtils.isCHESSProject(editor)))
			return null;
		
		Resource inResource = null;
		try {
			inResource = ResourceUtils.getUMLResource(((PapyrusMultiDiagramEditor) editor).getServicesRegistry());
		} catch (ServiceException e) {
			e.printStackTrace();
			MessageDialog.openError(activeShell, "CHESS", "Unable to load the model");
		}
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		activeShell = window.getShell();
			
		IFile modelFile = CHESSProjectSupport.resourceToFile(inResource);
		//ModelContent inModel = ExtendedEmfUtil.loadModel(new EclipseFile(inputFile));
		ModelContent inModel = TransUtil.loadModel(modelFile);
		Model m = (Model) inModel.getContent().get(0);
		
		//open a dialog to select the analysis context to be analyzed
		//first get all the classes stereotyped as SaAnalysisContext
		final List<Class> selection = new ArrayList<Class>();
		final Model model = (Model) inResource.getContents().get(0);
		EList<Element> elemList = model.allOwnedElements();
		for (Element elem : elemList) {
			//we're looking for a class stereotyped <<saAnalysisContext>> and NOT in PSM
			if(elem instanceof Class && elem.getAppliedStereotype(TransUtil.SA_ANALYSIS_CTX) != null 
					&& !ViewUtils.isPSMView(ViewUtils.getView(elem))){
				selection.add((Class) elem);
			}
		}
		if(selection.size() == 0){
			activeShell.getDisplay().syncExec(new Runnable() {
				@Override
				public void run() {
					MessageDialog.openWarning(activeShell, "CHESS", "no suitable analysis contexts in the model");
				}
			});
			return null;
		}
		
		String contextQN = null;
		AnalysisContextSelectionDialog dialog = new AnalysisContextSelectionDialog(activeShell, selection, "Select Analysis Context to purge");
		if (dialog.open() == Window.OK) {
			contextQN = dialog.getContext();
		}
		for (Element elem : model.allOwnedElements()){
			if(elem.getAppliedStereotype(TransUtil.SA_ANALYSIS_CTX) != null &&
					((NamedElement) elem).getQualifiedName().equals(contextQN)){
				contextClass = (Class) elem;
			}
		}
		
		if(contextClass == null){
			return null;
		}
		saAnalysisName = contextClass.getQualifiedName();
		//saAnalysisCtx = (SaAnalysisContext) contextClass.getStereotypeApplication(contextClass.getAppliedStereotype(TransUtil.SA_ANALYSIS_CTX));
		
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(contextClass);
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			protected void doExecute() {
					
				try {
					
					PapyrusMultiDiagramEditor editor = CHESSEditorUtils.getCHESSEditor();
					DiagramStatus ds = CHESSEditorUtils.getDiagramStatus(editor);
					ds.setUserAction(false);
					TransUtil.purgeModel(model, saAnalysisName);

				} catch (Exception e) {
					
					e.printStackTrace();
					MessageDialog.openError(null, "CHESS", "Problems while executing purge command: " + e.getMessage());
				}
			}
		});

		return null;
	}

	
	/**
	 * Reset stereotype values which have been previously set by back-annotation.
	 *
	 * @param m the CHESS model
	 * @param platform the Package owning the instance view
	 *
	private void resetStereotypeValues(Model m, Package platform) {
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
		if(compPlatform  != null){
			for (Element el : compPlatform.getOwnedComments()) {
				CHRtSpecification chrt = UMLUtils.getStereotypeApplication(el, CHRtSpecification.class);
				if (chrt != null){
					printlnToCHESSConsole("Resetting:" + el);
					chrt.getRespT().clear();
					chrt.getBlockT().clear();
				}
			}
		}
		
		//TODO: should reset only CH_HwProcessor with sw instances allocated on it
		Package pkg = ViewUtils.getCHESSDeploymentPackage(m);
		for (Element e : pkg.allOwnedElements()) {
			if (e instanceof InstanceSpecification){
				CH_HwProcessor pr = UMLUtils.getStereotypeApplication(e, CH_HwProcessor.class);
				if (pr != null){
					pr.setUtilization(null);
					printlnToCHESSConsole("Resetting:" + e);
				}
				
				CH_HwBus bu = UMLUtils.getStereotypeApplication(e, CH_HwBus.class);
				if (bu != null){
					bu.setUtilization(null);
					printlnToCHESSConsole("Resetting:" + e);
				}
			}
		}
		
		pkg = (Package) ViewUtils.getCHESSRtAnalysisPackage(m);
		for (Element e : pkg.allOwnedElements()) {
			if (e instanceof org.eclipse.uml2.uml.Class){
				
				SaAnalysisContext s = UMLUtils.getStereotypeApplication(e, SaAnalysisContext.class);
				if (s != null){
					printlnToCHESSConsole("Resetting:" + e);
					s.setIsSched("");
					if(s.getWorkload().size() > 0){
						SaEndtoEndFlow e2e = UMLUtils.getStereotypeApplication(s.getWorkload().get(0).getBase_NamedElement(), SaEndtoEndFlow.class);
						e2e.getEnd2EndT().clear();
					}
				}
			}
		}
	}*/
}
