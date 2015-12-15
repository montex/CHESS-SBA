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

package org.polarsys.chess.contracts.chessextension.popup.actions;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.ConstraintPropertyChildLabelEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PropertyForClassEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PropertyForComponentEditPart;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.chess.contracts.chessextension.dialogs.SetContractRefinementDialog;
import org.polarsys.chess.contracts.chessextension.managers.CHESSContractProfileManager;
import org.polarsys.chess.contracts.profile.chesscontract.ContractProperty;
import org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement;


public class SetContractRefinement implements IObjectActionDelegate {

	public static final String CONTRACT_PROPERTY = "CHESSContract::ContractProperty";
	protected static final String CONTRACT_REFINEMENt = "CHESSContract::ContractRefinement";
	public static final String COMPONENT_INSTANCE = "CHESSContract::ComponentInstance";
	private Shell shell;
	private ConstraintPropertyChildLabelEditPart sysmlEditPart;
	private PropertyForClassEditPart umlClassEditPart;
	private PropertyForComponentEditPart umlCompEditPart;
	private TransactionalEditingDomain editdomain;

	public SetContractRefinement() {
		super();
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	public void run(IAction action) {

		setSelection();
		Property contrProp = null;
		if(sysmlEditPart != null){
			Node notationNode = (Node) sysmlEditPart.getModel();
			contrProp = (Property) notationNode.getElement();
			editdomain = sysmlEditPart.getEditingDomain();
		}else if(umlClassEditPart != null){
			Node notationNode = (Node) umlClassEditPart.getModel();
			contrProp = (Property) notationNode.getElement();
			editdomain = umlClassEditPart.getEditingDomain();
		}else if (umlCompEditPart != null) {
			Node notationNode = (Node) umlCompEditPart.getModel();
			contrProp = (Property) notationNode.getElement();
			editdomain = umlCompEditPart.getEditingDomain();
		}
		if(contrProp != null){
			Stereotype contrPropStereo = contrProp.getAppliedStereotype(CONTRACT_PROPERTY);
			Object temp = contrProp.getValue(contrPropStereo, "RefinedBy");
			if(temp instanceof EList<?>){
				@SuppressWarnings("unchecked")
				final EList<ContractRefinement> refineList = (EList<ContractRefinement>) temp;
				final Class ownerClass = (Class) contrProp.getOwner();
				final SetContractRefinementDialog dialog = new SetContractRefinementDialog(shell, ownerClass);
				dialog.create();
				if (dialog.open() == Window.OK) {
					if(dialog.getSelected() != null){
						final String[] selection = dialog.getSelected();
						editdomain.getCommandStack().execute(
								new RecordingCommand(editdomain) {
									protected void doExecute() {
										for (int i = 0; i < selection.length; i++) {
											String stringRef = selection[i];
											Classifier present = ownerClass.getNestedClassifier(stringRef);
											if(present == null){
												DataType dt = UMLFactory.eINSTANCE.createDataType();
												ownerClass.getNestedClassifiers().add(dt);
												dt.setName(stringRef);
												Stereotype st = CHESSContractProfileManager.getContractRefinement();
												dt.applyStereotype(st);
												String partName = stringRef.substring(0, stringRef.indexOf("."));
												String contrName = stringRef.substring(stringRef.indexOf(".") + 1, stringRef.length());
												ContractRefinement contRef = (ContractRefinement) dt.getStereotypeApplication(st);
												Property instance = ownerClass.getPart(partName, null);
												contRef.setInstance(instance);
												Property contrProp = ((Classifier) instance.getType()).getAttribute(contrName, null);
												ContractProperty contract = (ContractProperty) contrProp.getStereotypeApplication(contrProp.getAppliedStereotype(CONTRACT_PROPERTY));
												contRef.setContract(contract);
												refineList.add(contRef);
											}else{
												ContractRefinement cr = (ContractRefinement) present.getStereotypeApplication(present.getAppliedStereotype(CONTRACT_REFINEMENt));
												refineList.add(cr);
											}
										}
									}
								});
					} 
				}

			}else{
				//do nothing
			}
		}
	}


	private void setSelection() {

		ISelection selection = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getSelectionService()
				.getSelection();
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection strucSelection = (IStructuredSelection) selection;
			if (strucSelection.size() == 1) {
				Object partSelected = strucSelection.iterator().next();
				if(partSelected instanceof ConstraintPropertyChildLabelEditPart){
					sysmlEditPart = (ConstraintPropertyChildLabelEditPart) partSelected;
				}else if(partSelected instanceof PropertyForClassEditPart){
					umlClassEditPart = (PropertyForClassEditPart) partSelected;
				}else if(partSelected instanceof PropertyForComponentEditPart){
					umlCompEditPart = (PropertyForComponentEditPart) partSelected;
				}
			}
		}

	}

	public void selectionChanged(IAction action, ISelection selection) {
	}

}
