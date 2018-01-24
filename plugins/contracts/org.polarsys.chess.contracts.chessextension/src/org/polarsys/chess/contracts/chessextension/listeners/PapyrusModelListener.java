/*******************************************************************************
 *
 * Copyright (c) 2013, 2015 Intecs SpA 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Nicholas Pacini nicholas.pacini@intecs.it 
 * Stefano Puri stefano.puri@intecs.it
 * Laura Baracchi  laura.baracchi@intecs.it  
 * Initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.chess.contracts.chessextension.listeners;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.uml.tools.listeners.StereotypeElementListener.StereotypeExtensionNotification;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.chess.contracts.chessextension.Activator;
import org.polarsys.chess.contracts.chessextension.managers.CHESSContractProfileManager;
import org.polarsys.chess.contracts.profile.chesscontract.FormalProperty;


public class PapyrusModelListener implements IPapyrusListener {

	private static final String CONTRACT = "CHESSContract::Contract";
	private static final String ASSUME = "Assume";
	private static final String GUARANTEE = "Guarantee";
	private static final Object FEATURE_NAME = "name";

	public PapyrusModelListener() {
	}

	@Override
	public void notifyChanged(Notification notification) {
		Object notifier = notification.getNotifier();
		
		if((notifier instanceof Class)&(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().isEditorAreaVisible())){
			Class cblock = (Class) notifier;
			
			if(notification.getEventType() == StereotypeExtensionNotification.STEREOTYPE_APPLIED_TO_ELEMENT){
				if(cblock.getAppliedStereotype(CONTRACT) != null){
					
					
					IEditorPart editor = null;
					try {
						editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
								.getActivePage().getActiveEditor();
					} catch (Exception e) {
						
					}
					if (editor != null){
						AbstractUIPlugin plugin = Activator.getDefault();
						ImageRegistry imageRegistry = plugin.getImageRegistry();
						Image chessImage = imageRegistry.get(Activator.CHESS_IMAGE_ID);
						MessageDialog md = new MessageDialog(editor.getSite().getShell(),
								"Create Contract", chessImage, "Do you want to create a contract with predefined empty Assume and Guarantee FormalProperty?", MessageDialog.CONFIRM,
								new String[] { "Yes", "No"}, 0);
						md.setBlockOnOpen(true);
						int res = md.open();
						
						if (res ==0){ //OK
							Constraint assumeConst = cblock.createOwnedRule(cblock.getName() + "_" + ASSUME);
							Constraint guaranteeConst = cblock.createOwnedRule(cblock.getName() + "_" + GUARANTEE);
							
							LiteralString assumeValue = UMLFactory.eINSTANCE.createLiteralString();
							assumeValue.setName(assumeConst.getName());
							assumeConst.setSpecification(assumeValue);
							
							LiteralString guaranteeValue = UMLFactory.eINSTANCE.createLiteralString();
							guaranteeValue.setName(guaranteeConst.getName());
							guaranteeConst.setSpecification(guaranteeValue);
							
							try {
								
								Stereotype fpStereotype = CHESSContractProfileManager.getFormalProperty(cblock.eResource().getResourceSet());
								FormalProperty assume = (FormalProperty) assumeConst.applyStereotype(fpStereotype);
								FormalProperty guarantee = (FormalProperty) guaranteeConst.applyStereotype(fpStereotype);
								
								Stereotype contrStereo = cblock.getAppliedStereotype(CONTRACT);
								cblock.setValue(contrStereo, ASSUME, assume);
								cblock.setValue(contrStereo, GUARANTEE, guarantee);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					
					
				}
			}
			
			if(notification.getEventType() == Notification.SET && notification.getFeature() instanceof EAttribute){
				if(cblock.getAppliedStereotype(CONTRACT) != null){
					EAttribute attr = (EAttribute) notification.getFeature();
					if(attr.getName().equals(FEATURE_NAME)){
						EList<Constraint> rules = cblock.getOwnedRules();
						for (Constraint constraint : rules) {
							if(constraint.getName().contains(ASSUME)){
								constraint.setName(notification.getNewStringValue() + "_" + ASSUME);
							}
							if(constraint.getName().contains(GUARANTEE)){
								constraint.setName(notification.getNewStringValue() + "_" + GUARANTEE);
							}
							constraint.getSpecification().setName(constraint.getName());
						}
					}
				}
			}
		}
	}

}
