/*
-----------------------------------------------------------------------
--                    Copyright (C) 2016                             --
--                 University of Padova, ITALY                       --
--                                                                   --
-- Authors: Alessandro Zovi          azovi@math.unipd.it             --
--          Laura Baracchi           laura.baracchi@intecs.it        --
--          Stefano Puri             stefano.puri@intecs.it          --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
 */

package org.polarsys.chess.validator.managers;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferencePage;
import org.eclipse.jface.preference.PreferenceManager;
import org.eclipse.jface.preference.PreferenceNode;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Stereotype;
import org.polarsys.chess.chessmlprofile.Core.CHESS;
import org.polarsys.chess.chessmlprofile.Core.Domain;
import org.polarsys.chess.chessmlprofile.util.Constants;
import org.polarsys.chess.core.constraint.ConstraintList;
import org.polarsys.chess.core.constraint.DynamicConstraint;
import org.polarsys.chess.core.preferences.FilterableConstraint;
import org.polarsys.chess.core.profiles.CHESSProfileManager;
import org.polarsys.chess.core.util.CHESSProjectSupport;
import org.polarsys.chess.core.util.uml.ResourceUtils;
import org.polarsys.chess.core.views.DiagramStatus;
import org.polarsys.chess.core.views.ViewUtils;
import org.polarsys.chess.core.views.DiagramStatus.DesignView;
import org.polarsys.chess.service.internal.commands.switchers.SwitchToDependabilityCommand;
import org.polarsys.chess.service.internal.commands.switchers.SwitchToExtraFunctionalCommand;
import org.polarsys.chess.service.internal.commands.switchers.SwitchToView;
import org.polarsys.chess.service.utils.CHESSEditorUtils;
import org.polarsys.chess.validator.Activator;
import org.polarsys.chess.validator.libs.ConstraintsLib;
import org.polarsys.chess.validator.messages.Messages;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;

// TODO: Auto-generated Javadoc
/**
 * The Class ModelParser.
 */
public class ModelParser {

	/** The model outside view. */
	private IStatus modelOutsideView = new Status(IStatus.ERROR,
			Activator.PLUGIN_ID, Messages.NullViewMsg);

	private Shell activeShell = null;
	
	Domain currentDomain = getModelDomain();

	/**
	 * Gets the IPreferencePage given the id. (never used?)
	 * 
	 * @param id the id of the IPreferencePage
	 * @return the IPreferencePage corresponding to the given id, or null
	 */
	public IPreferencePage getId(String id) {
		PreferenceManager pm = PlatformUI.getWorkbench().getPreferenceManager();
		List list = pm.getElements(PreferenceManager.PRE_ORDER);

		for (int i = 0; i < list.size(); i++) {
			PreferenceNode node = (PreferenceNode) list.get(i);
			IPreferencePage p = node.getPage();

			if (p != null && node.getId().equals(id)) {
				return p;
			}
		}
		return null;
	}

	/**
	 * Instantiates a new model parser.
	 */
	public ModelParser() {


		PreferenceManager mgr = PlatformUI.getWorkbench().getPreferenceManager();


		ConstraintsLib a = new ConstraintsLib();
		//IPreferencePage pp = getId("org.polarsys.chess.preferences.constraints");


		//		PreferenceDialog dialog = PreferencesUtil.createPreferenceDialogOn(
		//			       null,
		//			      "org.polarsys.chess.preferences.constraints",
		//			       new String[] {}, null);
		//			PreferencePage selectedPage =
		//			      (PreferencePage) dialog.getSelectedPage();
		//			((ConstraintPreferencePage)selectedPage).refresh();
		//		dialog.close();

		//		for (Object o : mgr.getElements(PreferenceManager.PRE_ORDER)) {
		//			if (o instanceof IPreferenceNode) {
		//				IPreferenceNode n = (IPreferenceNode) o;
		//				if (n.getId().equals("org.polarsys.chess.preferences.constraints")){
		//					if (n.getPage() == null)
		//						n.createPage();
		//					ConstraintPreferencePage p = (ConstraintPreferencePage)n.getPage();
		//					p.refresh();
		//					break;
		//				}
		//			}
		//		}
		//		List<IPreferenceNode> preferencePageList = castList(IPreferenceNode.class, mgr.getElements(PreferenceManager.PRE_ORDER));
		//		IPreferenceNode[] rootSubNodes = mgr.getRootSubNodes();
		//			
		//		IPreferenceNode anode = rootSubNodes[7];
		//					
		//		IPreferenceNode[] installUpadteSubNode = anode.getSubNodes();
		//		//anode.remove(installUpadteSubNode[0]);
		//		PreferenceNode installNode = (PreferenceNode)installUpadteSubNode[0];
		//		IPreferencePage page = installNode.getPage();
	}

	//	//TODO manage the constraints with a priority list!
	//	static DynamicConstraint[] constraintList = {
	//		ConstraintsLib.M_A_1, 
	//		ConstraintsLib.S_S_1, 
	//		ConstraintsLib.C_A_1,
	//		ConstraintsLib.P_T_1, 
	//		ConstraintsLib.P_A_1, 
	//		ConstraintsLib.O_S_1,
	//		ConstraintsLib.AddRemoveDependency,
	//		ConstraintsLib.checkModifiedOperation};

	/**
	 * Check.
	 *
	 * @param notification the notification
	 * @param _notifier the _notifier
	 * @param currentView the current view
	 * @param superuser the superuser
	 * @return the command
	 * @throws RollbackException the rollback exception
	 */
	public Command check(Notification notification, Object _notifier, DesignView currentView, boolean superuser) throws RollbackException {
		
		currentDomain = getModelDomain();
		Object notifier = notification.getNotifier();
		Command command = null;
		if (currentView == null) {
			if (notifier instanceof Model && notification.getFeature() instanceof EAttribute && ((EAttribute)notification.getFeature()).getName().equals("name"))
				return command;
			CHESSProjectSupport.printlnToCHESSConsole(modelOutsideView.getMessage());
			//throw new RollbackException(modelOutsideView); //TODO this Rollback can bring serious problems with Papyrus (loss of data in the model), for the moment we just comment it
			return command;
		}
				
		if (!superuser && !ConstraintsLib.E_S_1_NEW.check(notification, currentView, currentDomain).isOK()){
			CHESSProjectSupport.printlnToCHESSConsole(ConstraintsLib.E_S_1_NEW.getMessage());	
			
			// If Current View has not the sufficient permissions, look for the alternative View to suggest			
			if(notification.getOldValue()!=null || notification.getNewValue()!=null) {
					String suggestedView = ""; 
					String  concurrentView ="";
					boolean changeToConcurrentView = false;
			if (currentView.getName().equals(CHESSProfileManager.COMPONENT_VIEW)) {			
				suggestedView = CHESSProfileManager.EXTRAFUNCTIONAL_VIEW;
				concurrentView = CHESSProfileManager.EXTRAFUNCTIONAL_VIEW;
				changeToConcurrentView = false;
			}
			else {
				if(currentView.getName().equals(CHESSProfileManager.DEPLOYMENT_VIEW)) {					
					suggestedView = CHESSProfileManager.DEPENDABILITY_VIEW;
					concurrentView = CHESSProfileManager.DEPENDABILITY_VIEW;
					changeToConcurrentView = false;
				}
				else {
					if(currentView.getName().equals(CHESSProfileManager.DEPENDABILITY_VIEW)) {
						suggestedView = CHESSProfileManager.DEPLOYMENT_VIEW;
						concurrentView = CHESSProfileManager.DEPENDABILITY_VIEW;
						changeToConcurrentView = true;
					}
					else {
						if(currentView.getName().equals(CHESSProfileManager.EXTRAFUNCTIONAL_VIEW)) {
							suggestedView = CHESSProfileManager.COMPONENT_VIEW;
							concurrentView = CHESSProfileManager.EXTRAFUNCTIONAL_VIEW;
							changeToConcurrentView = true;
						}
						else {
							throw new RollbackException(ConstraintsLib.E_S_1_NEW.getStatus());
						}
					}
				}
			}		

			// Verify if the alternative View that would be suggested has the needed permission
			if (!ViewUtils.isElementWritable_((EObject)notifier, notification.getFeature(),suggestedView, currentView, currentDomain)) {				
				throw new RollbackException(ConstraintsLib.E_S_1_NEW.getStatus());
			}

			Boolean go = false;
			String permissionErrorMsg = "The view \""+currentView.getName()+"\" has no write access on the element \""+((EObject)notifier).eClass().getName()+"\", therefore it cannot be modified.";			
			permissionErrorMsg +=" Do you want to continue moving automatically to the \""+suggestedView+"\" view?";
			// Require user to confirm if move to more suitable view
			go = MessageDialog.openQuestion(activeShell, "Permission error", permissionErrorMsg);
			if (!go) {
				throw new RollbackException(ConstraintsLib.E_S_1_NEW.getStatus());				
			}
			else {
				SwitchToView switcher = new SwitchToView(concurrentView, changeToConcurrentView, null);
				try {					
					switcher.execute();
				} 
				catch (ExecutionException e) {					
					e.printStackTrace();
					throw new RollbackException(ConstraintsLib.E_S_1_NEW.getStatus());
				}
			}			
		}
	}

	//		for (FilterableConstraint f: ConstraintList.getList()){
	//			System.out.println(f.getConstraint().getName()+" "+f.isActive());
	//		}

	for (FilterableConstraint fC: ConstraintList.getList()){
		if (!fC.isActive())
			continue;
		DynamicConstraint constr = (DynamicConstraint) fC.getConstraint();
		if (constr.getName().compareTo("E_S_1")==0)//no need to check ConstraintsLib.E_S_1_NEW again
			continue;
		if (!constr.check(notification, currentView, currentDomain).isOK()){
			CHESSProjectSupport.printlnToCHESSConsole(constr.getMessage());
			throw new RollbackException(constr.getStatus());
		}
	}

	//		for (DynamicConstraint constr : constraintList) {
	//			if (!constr.check(notification, currentView).isOK()){
	//				CHESSProjectSupport.printlnToCHESSConsole(constr.getMessage());
	//				throw new RollbackException(constr.getStatus());
	//			}
	//		}		

	return command;
}
	
	
	/** 
	 * Reads the domain from the model 
	 * @return
	 */
	private Domain getModelDomain() {			
		
		// Read the domain from the model
		PapyrusMultiDiagramEditor editor = CHESSEditorUtils.getCHESSEditor();
		Model umlModel;
		Domain theDomain;
		try {
			Resource res = ResourceUtils.getUMLResource(editor
					.getServicesRegistry());
			umlModel = ResourceUtils.getModel(res);
			if (umlModel.getAppliedStereotype(Constants.CHESS_MODEL_STEREOTYPE) != null) {
				Stereotype chessModelStereo = umlModel.getAppliedStereotype(Constants.CHESS_MODEL_STEREOTYPE);
				CHESS chessModel = (CHESS) umlModel.getStereotypeApplication(chessModelStereo);
				theDomain = chessModel.getDomain();
			}
			else {
				theDomain = Domain.CROSS_DOMAIN;
			}
		}
		catch (Exception exc) {
			theDomain = Domain.CROSS_DOMAIN;
		}
		return theDomain;			
	}
	
}
