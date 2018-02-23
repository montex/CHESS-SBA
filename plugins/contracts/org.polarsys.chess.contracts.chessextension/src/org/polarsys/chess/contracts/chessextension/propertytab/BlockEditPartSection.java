/*******************************************************************************
 *
 * Copyright (c) 2013, 2017 Intecs SpA 
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
package org.polarsys.chess.contracts.chessextension.propertytab;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.BlockEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.ConstraintBlockEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ComponentEditPart;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.polarsys.chess.contracts.chessextension.popup.actions.SetContractRefinement;
import org.polarsys.chess.contracts.profile.chesscontract.Contract;
import org.polarsys.chess.contracts.profile.chesscontract.FormalProperty;
import org.polarsys.chess.service.gui.utils.CHESSEditorUtils;


public class BlockEditPartSection extends AbstractPropertySection{
	
	public static final String CONTRACT = "CHESSContract::Contract";
	public static final String CONTRACT_PROP = "CHESSContract::ContractProperty";

	private Text contractText;
	private Text assumeText;
	private Text guaranteeText;

	private Class contract;
	private Class selectedClass; 
	
	private FocusListener assumeFocusListener;
	private FocusListener guaranteeFocusListener;
	private SelectionListener contractListListener;
	
	private Label contractLabel;
	private CCombo contractList;
	private Label contractListLabel;
	
	public BlockEditPartSection(){
		
		contractListListener = new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				String selection = contractList.getItem(contractList.getSelectionIndex());
				contract = getContract(selectedClass, selection);
				if(contract != null){
					setContractPropertyTab(contract);
				}
				contractLabel.setText("Selected Class");
				contractText.setText(selectedClass.getQualifiedName());
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// nothing to do here	
			}
		};
		
		assumeFocusListener = new FocusListener() {
			
			private String oldAssume;

			@Override
			public void focusLost(FocusEvent e) {

				if(assumeText.getText().equals(oldAssume)){
					return;
				}

				PapyrusMultiDiagramEditor editor = CHESSEditorUtils.getCHESSEditor();
				if (editor != null){ 
						TransactionalEditingDomain editingDomain = (TransactionalEditingDomain) editor.getEditingDomain();
						editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

							@Override
							protected void doExecute() {
								//Stereotype stereo = contract.getAppliedStereotype(CONTRACT);
								Stereotype stereo = UMLUtil.getAppliedStereotype(contract, CONTRACT,false) ;
								FormalProperty assumefp = (FormalProperty) contract.getValue(stereo, "Assume");
								Constraint assumeConstr = assumefp.getBase_Constraint();
								LiteralString assumeSpec = (LiteralString) assumeConstr.getSpecification();
								assumeSpec.setValue(assumeText.getText());
								assumeConstr.setSpecification(assumeSpec);

							}
							
						});
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// this is to see if the text has been modified or not
				oldAssume = assumeText.getText();
			}
		};
		
		guaranteeFocusListener = new FocusListener() {
			
			private String oldGuarantee;

			@Override
			public void focusLost(FocusEvent e) {
				if(assumeText.getText().equals(oldGuarantee)){
					return;
				}
				PapyrusMultiDiagramEditor editor = CHESSEditorUtils.getCHESSEditor();
				if (editor != null){ 

						TransactionalEditingDomain editingDomain = (TransactionalEditingDomain) editor.getEditingDomain();
						editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

							@Override
							protected void doExecute() {
								//Stereotype stereo = contract.getAppliedStereotype(CONTRACT);
								Stereotype stereo = UMLUtil.getAppliedStereotype(contract, CONTRACT,false) ;
								
								FormalProperty guaranteefp = (FormalProperty) contract.getValue(stereo, "Guarantee");
								Constraint guaranteeConstr = guaranteefp.getBase_Constraint();
								LiteralString guaranteeSpec = (LiteralString) guaranteeConstr.getSpecification();
								guaranteeSpec.setValue(guaranteeText.getText());
								guaranteeConstr.setSpecification(guaranteeSpec);

							}
							
						});
					//}
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// this is to see if the text has been modified or not
				oldGuarantee = guaranteeText.getText();
			}
		};
			
	}
	
	private Class getContract(Class selectedClass, String selection) {
		String[] splitted = selection.split(":");
		String propName = splitted[0].trim();
		EList<Property> attributes = selectedClass.getAttributes();
		Iterator<Property> it = attributes.iterator();
		Property property = null;
		boolean found = false;
		while (it.hasNext() && !found) {
			Property attr = (Property) it.next();
			if(attr.getName().equals(propName) && attr.getAppliedStereotype(CONTRACT_PROP) != null){
				found = true;
				property = attr;
			}		
		}
		if(property == null){
			return null;
		}
		Class contract = (Class)property.getType();
		
		return contract;
	}

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		
		super.createControls(parent, aTabbedPropertySheetPage);		
		
		Composite composite = getWidgetFactory().createComposite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(4, false));
				
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, false);
		gd.horizontalSpan = 3;
		contractText = getWidgetFactory().createText(composite, "no Contract selected");
		contractText.setEditable(false);
		contractText.setLayoutData(gd);
		
		gd = new GridData(SWT.FILL, SWT.FILL, false, false);	
		contractLabel = getWidgetFactory().createLabel(composite, "Selected Contract", SWT.NONE);
		contractLabel.setLayoutData(gd);
		
		gd = new GridData(SWT.FILL, SWT.FILL, false, false);
		contractList = getWidgetFactory().createCCombo(composite, SWT.READ_ONLY | SWT.BORDER);
		contractList.setVisible(false);
		gd.horizontalSpan = 3;
		contractList.addSelectionListener(contractListListener);
		contractList.setLayoutData(gd);
		
		gd = new GridData(SWT.FILL, SWT.FILL, false, false);	
		contractListLabel = getWidgetFactory().createLabel(composite, "Contract List", SWT.NONE);
		contractListLabel.setVisible(false);
		contractListLabel.setLayoutData(gd);
		
		gd = new GridData(SWT.FILL, SWT.FILL, false, false);
		gd.horizontalSpan = 2;
		Label assumeLabel = getWidgetFactory().createLabel(composite, "Assume", SWT.NONE);
		assumeLabel.setLayoutData(gd);
		
		gd = new GridData(SWT.FILL, SWT.FILL, false, false);
		gd.horizontalSpan = 2;
		Label guaranteeLabel = getWidgetFactory().createLabel(composite, "Guarantee", SWT.NONE);
		guaranteeLabel.setLayoutData(gd);
		
		gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		assumeText = getWidgetFactory().createText(composite, "", SWT.MULTI | SWT.H_SCROLL |SWT.V_SCROLL);
		gd.horizontalSpan = 2;
		gd.verticalSpan = 25;
		assumeText.addFocusListener(assumeFocusListener);
		assumeText.setLayoutData(gd);
		
		gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		guaranteeText = getWidgetFactory().createText(composite, "", SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		gd.horizontalSpan = 2;
		gd.verticalSpan = 25;
		guaranteeText.addFocusListener(guaranteeFocusListener);
		guaranteeText.setLayoutData(gd);
		
				
	}

	@SuppressWarnings({ "rawtypes" })
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		if (!(selection instanceof IStructuredSelection)){	
			 cleanPropertyTab();
			 return;
		}
		List<?> selectionList = ((IStructuredSelection) selection).toList();
		if (selectionList.size() == 1) {
			Object selected = selectionList.get(0);
			
			EObject selectedEObject = EMFHelper.getEObject(selected);
			if (selectedEObject != null){
			    //do something
			}
			if(selected instanceof ConstraintBlockEditPart){
				Class clazz = (Class) (((ConstraintBlockEditPart)selected).resolveSemanticElement());
				//check if it's a contract
				//if(clazz.getAppliedStereotype(CONTRACT) != null){
					if(UMLUtil.getAppliedStereotype(clazz, CONTRACT,false)!=null){
					
					cleanPropertyTab();
					setContractPropertyTab(clazz);
				}
			}else if(selected instanceof BlockEditPart){;
				Class clazz = (Class) (((BlockEditPart)selected).resolveSemanticElement());
				initContractList(clazz);
			}
			else if(selected instanceof ClassEditPart){
				Class clazz = (Class) (((ClassEditPart)selected).resolveSemanticElement());
				//check if it's a contract
				//if(clazz.getAppliedStereotype(CONTRACT) != null){
				if(UMLUtil.getAppliedStereotype(clazz, CONTRACT,false)!=null){
					cleanPropertyTab();
					setContractPropertyTab(clazz);
				}else{
					initContractList(clazz);
				}
			}
			else if(selected instanceof ComponentEditPart){
				Class clazz = (Class) (((ComponentEditPart)selected).resolveSemanticElement());
				initContractList(clazz);
			}
			else if(selectedEObject instanceof Class){
				
					Class clazz = (Class) selectedEObject;
					//if(clazz.getAppliedStereotype(CONTRACT) != null){
					if(UMLUtil.getAppliedStereotype(clazz, CONTRACT,false)!=null){	
						cleanPropertyTab();
						setContractPropertyTab(clazz);
					}else{
						initContractList(clazz);
					}
				
			}
			else{
				cleanPropertyTab();
			}
		}else{
			cleanPropertyTab();
		}
		
		
		//fill claims list
		if(contract != null){
			
			//Stereotype stereo = contract.getAppliedStereotype(BlockEditPartSection.CONTRACT);
			Stereotype stereo = UMLUtil.getAppliedStereotype(contract, BlockEditPartSection.CONTRACT,false);
			Contract contractStereo = (Contract) contract.getStereotypeApplication(stereo);
			
		}
		
		//fill supportedBy artifact list
		if(contract != null){
			
			//Stereotype stereo = contract.getAppliedStereotype(BlockEditPartSection.CONTRACT);
			Stereotype stereo = UMLUtil.getAppliedStereotype(contract, BlockEditPartSection.CONTRACT,false);
			Contract contractStereo = (Contract) contract.getStereotypeApplication(stereo);
			
		}
	}
	
	private void initContractList(Class clazz) {
		cleanPropertyTab();
		selectedClass = clazz;
		contractText.setText(selectedClass.getQualifiedName());
		contractLabel.setText("Selected Class");
		contractList.setVisible(true);
		contractListLabel.setVisible(true);
		for (Property prop : selectedClass.getAttributes()) {
			if(prop.getAppliedStereotype(SetContractRefinement.CONTRACT_PROPERTY) != null){
				if(prop.getType() == null){
					contractList.add(prop.getName() + " : <TYPE NOT DEFINED>");
				}else{
					contractList.add(prop.getName() + " : " + prop.getType().getName());
				}
			}
		}
	}

	private void setContractPropertyTab(Class clazz) {
		contract = clazz;
		contractLabel.setText("Selected Contract");
		contractText.setText(clazz.getQualifiedName());
		//Stereotype contrStereo = clazz.getAppliedStereotype(CONTRACT);
		Stereotype contrStereo = UMLUtil.getAppliedStereotype(clazz, CONTRACT,false);
		FormalProperty assumefp = (FormalProperty) clazz.getValue(contrStereo, "Assume");
		FormalProperty guaranteefp = (FormalProperty) clazz.getValue(contrStereo, "Guarantee");
		String assume = "";
		if (assumefp!= null)
			assume= assumefp.getBase_Constraint().getSpecification().stringValue();
		String guarantee = "";
		if (guaranteefp != null)
			guarantee= guaranteefp.getBase_Constraint().getSpecification().stringValue();
		if(assume != null){
			assumeText.setText(assume);	
		}
		if(guarantee != null){
			guaranteeText.setText(guarantee);
		}
		
		Contract contractStereo = (Contract) contract.getStereotypeApplication(contrStereo);
		
	}

	private void cleanPropertyTab() {
		contractLabel.setText("Selected Contract");
		contractText.setText("no Contract selected");
		assumeText.setText("");
		guaranteeText.setText("");
		contract = null;
		contractList.removeAll();
		contractList.setVisible(false);
		contractListLabel.setVisible(false);
		
	}


   
    

    
}
