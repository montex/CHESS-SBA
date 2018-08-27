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
package org.polarsys.chess.contracts.chessextension.propertytab;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.BlockPropertyCompositeEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.PropertyPartEditPartCN;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.polarsys.chess.contracts.profile.chesscontract.ComponentInstance;
import org.polarsys.chess.contracts.profile.chesscontract.ContractProperty;
import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ContractTypes;

public class BlockPropertyCompositeEditPartSection extends AbstractPropertySection {

	private static final String CONTRACT_PROP = "CHESSContract::ContractProperty";
	private static final String COMP_INST = "CHESSContract::ComponentInstance";
	private Text propertyText;
	private Label propertyLabel;
	private Property currentProperty;
	private Class currentClassType;
	private Table weakTable;
	private Table strongTable;
	private SelectionListener weakTableListener;
	
	public BlockPropertyCompositeEditPartSection() {
		weakTableListener = new SelectionListener(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(e.detail == SWT.CHECK){
					final TableItem item  = (TableItem) e.item;
					final ContractProperty dataContrProp = (ContractProperty) item.getData();
					Stereotype compInstStereo = currentProperty.getAppliedStereotype(COMP_INST);
					if(compInstStereo != null){
						final ComponentInstance compInst = (ComponentInstance) currentProperty.getStereotypeApplication(compInstStereo);
						TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(dataContrProp.eResource());
						editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
							@Override
							protected void doExecute() {
								if(item.getChecked() && !compInst.getWeakGuarantees().contains(dataContrProp)){
									compInst.getWeakGuarantees().add(dataContrProp);
								}
								else if(!item.getChecked() && compInst.getWeakGuarantees().contains(dataContrProp)){
									compInst.getWeakGuarantees().remove(dataContrProp);
								}
							}
						});
					}
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// nothing to do here
			}
			
		};
	}


	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		
		Composite composite = getWidgetFactory().createComposite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(4, false));
			
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, false);
		gd.horizontalSpan = 2;
		propertyText = getWidgetFactory().createText(composite, "no Property selected");
		propertyText.setEditable(false);
		propertyText.setLayoutData(gd);
		
		gd = new GridData(SWT.FILL, SWT.FILL, false, false);
		gd.horizontalSpan = 2;
		propertyLabel = getWidgetFactory().createLabel(composite, "Selected Property", SWT.NONE);
		propertyLabel.setLayoutData(gd);
		
		gd = new GridData(SWT.FILL, SWT.FILL, false, false);
		gd.horizontalSpan = 2;
		Label weakLabel = getWidgetFactory().createLabel(composite, "Weak Contracts", SWT.NONE);
		weakLabel.setLayoutData(gd);
		
		gd = new GridData(SWT.FILL, SWT.FILL, false, false);
		gd.horizontalSpan = 2;
		Label strongLabel = getWidgetFactory().createLabel(composite, "Strong Contracts", SWT.NONE);
		strongLabel.setLayoutData(gd);
		
		gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		weakTable = getWidgetFactory().createTable(composite, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.CHECK);
		gd.horizontalSpan = 2;
		gd.verticalSpan = 25;
		weakTable.addSelectionListener(weakTableListener);
		weakTable.setLayoutData(gd);
		
		gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		strongTable = getWidgetFactory().createTable(composite, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		gd.horizontalSpan = 2;
		gd.verticalSpan = 25;
		strongTable.setLayoutData(gd);
	}
	
	
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		if (!(selection instanceof IStructuredSelection)){	
			 return;
		}
		List<?> selectionList = ((IStructuredSelection) selection).toList();
		if (selectionList.size() == 1) {
			Object selected = selectionList.get(0);
			if(selected instanceof BlockPropertyCompositeEditPart){
				Property prop = (Property) (((BlockPropertyCompositeEditPart)selected).resolveSemanticElement());
				initContractLists(prop);
			}
			if(selected instanceof PropertyPartEditPartCN){
				Property prop = (Property) (((PropertyPartEditPartCN)selected).resolveSemanticElement());
				initContractLists(prop);
			}
		}
	}

	private void initContractLists(Property prop) {
		currentProperty = prop;
		List<ContractProperty> weakList = new ArrayList<ContractProperty>();
		List<ContractProperty> strongList = new ArrayList<ContractProperty>();
		propertyText.setText(currentProperty.getQualifiedName());
		Type type = currentProperty.getType();
		if(type != null && type instanceof Class){
			Class classType = (Class) type;
			if(classType != currentClassType){
				weakTable.removeAll();
				strongTable.removeAll();
				currentClassType = classType;
				TableItem tabItem;
				for (Property attr : currentClassType.getOwnedAttributes()) {
					Stereotype stereo = attr.getAppliedStereotype(CONTRACT_PROP);
					if(stereo != null){
						ContractProperty contrProp = (ContractProperty) attr.getStereotypeApplication(stereo);
						ContractTypes contractType = contrProp.getContractType();
						if(contractType.equals(ContractTypes.STRONG)){
							strongList.add(contrProp);
						}else{ //it must be weak
							weakList.add(contrProp);
						}
					}
				}
				for (ContractProperty strongProp : strongList) {
					tabItem = new TableItem(strongTable, 0);
					tabItem.setData(strongProp);
					tabItem.setText(strongProp.getBase_Property().getName());
				}
				for (ContractProperty weakProp :weakList) {
					tabItem = new TableItem(weakTable, 0);
					tabItem.setData(weakProp);
					tabItem.setText(weakProp.getBase_Property().getName());
				}
				
				Stereotype compInstStereo = currentProperty.getAppliedStereotype(COMP_INST);
				if(compInstStereo != null){
					ComponentInstance compInst = (ComponentInstance) currentProperty.getStereotypeApplication(compInstStereo);
					for (ContractProperty weakProp : compInst.getWeakGuarantees()) {
						for (TableItem tItem : weakTable.getItems()) {
							if(tItem.getData().equals(weakProp)){
								tItem.setChecked(true);
							}
						}
					}
				}
			}
		}
	}
}
