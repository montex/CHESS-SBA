/*------------------------------------------------------------------------------
 -
 - Copyright (c) 2013, 2015 Intecs SpA 
 - All rights reserved. This program and the accompanying materials
 - are made available under the terms of the Eclipse Public License v1.0
 - which accompanies this distribution, and is available at
 - http://www.eclipse.org/legal/epl-v10.html
 -
 - Contributors:
 - 
 - Stefano Puri stefano.puri@intecs.it
 -  
 - Initial API and implementation and/or initial documentation
 ------------------------------------------------------------------------------*/
package org.polarsys.chess.tabbedproperties.sections;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EObjectTreeElement;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Stereotype;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtPortSlot;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification;
import org.polarsys.chess.chessmlprofile.util.Constants;

public class CHRtSpecificationProperty extends AbstractPropertySection {
	
//	private Button addChrtButton;
//	private Button removeChrtButton;
	private Table chrtTable;
	private String[] chrtTitles = {"instance", "context", "arrivalPattern", "localWCET", "rldl", "priority"};
//	private int CONTEXT_COLUMN = 0;
//	private int WCET_COLUMN = 1;
//	private int RLDL_COLUMN = 2;
//	private int PATTERN_COLUMN = 3;
//	private int PRI_COLUMN = 4;
	
	private ControlAdapter resizeListener;
//	private SelectionListener selectionListener;
	
	public CHRtSpecificationProperty(){
				
		resizeListener = new ControlAdapter() {
			public void controlResized(ControlEvent e) {
				int d = 10; 
				int x = chrtTable.getSize().x - d;
				int width = x/(chrtTitles.length) - chrtTitles.length;
				TableColumn[] columns = chrtTable.getColumns();
				for (int i = 0; i < columns.length; i++) {
					TableColumn tc = columns[i];
					tc.setWidth(width);
				}
			}
		};
	}
		
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
//		System.out.println(selection);
		refresh();
		cleanPropertyTab();
		List<CHRtPortSlot> chrtList = new ArrayList<CHRtPortSlot>();
		Object obj = null;
		if(selection instanceof TreeSelection){
			TreeSelection treeSelection = (TreeSelection) selection;
			obj = treeSelection.getFirstElement();
		}else if(selection instanceof StructuredSelection){
			StructuredSelection structSelection = (StructuredSelection) selection;
			if(structSelection.toArray().length == 1){
				obj = structSelection.toArray()[0];;
			}else{
				//does not work for a selection of multiple objects
			}
		}
		EObject eobj = null;
		if (obj instanceof EObjectTreeElement) {
			 eobj = ((EObjectTreeElement) obj).getEObject();
		}else if(obj instanceof EObject){
			eobj = (EObject) obj;
		}
		if(eobj instanceof Slot && ((Slot)eobj).getAppliedStereotype(Constants.CH_CHRtPortSlot) != null){
			Slot slot = (Slot)eobj;
			Stereotype stereo = slot.getAppliedStereotype(Constants.CH_CHRtPortSlot);
			CHRtPortSlot chrtSlot = (CHRtPortSlot) slot.getStereotypeApplication(stereo);
			chrtList.add(chrtSlot);
			initTable(chrtList);
		}
		if (eobj instanceof InstanceSpecification){
			InstanceSpecification inst = (InstanceSpecification)eobj;
			for (Slot slot : inst.getSlots()) {
				if(slot.getAppliedStereotype(Constants.CH_CHRtPortSlot) != null){
					Stereotype stereo = slot.getAppliedStereotype(Constants.CH_CHRtPortSlot);
					CHRtPortSlot chrtSlot = (CHRtPortSlot) slot.getStereotypeApplication(stereo);
					chrtList.add(chrtSlot);
				}
			}
			if(chrtList.size() > 0){
				initTable(chrtList);
			}
		}
		if(eobj instanceof Package){
			Package pkg = (Package)eobj;
			for (PackageableElement elem : pkg.getPackagedElements()) {
				if(elem instanceof InstanceSpecification){
					InstanceSpecification inst = (InstanceSpecification)elem;
					for (Slot slot : inst.getSlots()) {
						if(slot.getAppliedStereotype(Constants.CH_CHRtPortSlot) != null){
							Stereotype stereo = slot.getAppliedStereotype(Constants.CH_CHRtPortSlot);
							CHRtPortSlot chrtSlot = (CHRtPortSlot) slot.getStereotypeApplication(stereo);
							chrtList.add(chrtSlot);
						}
					}
				}
			}
			if(chrtList.size() > 0){
				initTable(chrtList);
			}
		}
	}




	private void initTable(List<CHRtPortSlot> chrtSlotList) {
		cleanPropertyTab();
		for (CHRtPortSlot chrtSlot : chrtSlotList) {
			String instanceName = chrtSlot.getBase_Slot().getOwningInstance().getName();
			for (CHRtSpecification chrtspec : chrtSlot.getCH_RtSpecification()){
				TableItem item = new TableItem(chrtTable, SWT.NONE);
				InstanceSpecification inst = chrtSlot.getBase_Slot().getOwningInstance();
				Operation op = (Operation) chrtspec.getContext();
				Map.Entry<InstanceSpecification, Operation> data = new AbstractMap.SimpleEntry<InstanceSpecification, Operation>(inst, op);
				item.setData(data);
				
				item.setText(0, instanceName);
				
				if(chrtspec.getContext() != null){
					item.setText(1, chrtspec.getContext().getName());
				}
				
				if(chrtspec.getOccKind() != null){
					item.setText(2, chrtspec.getOccKind());
				}
				if(chrtspec.getLocalWCET() != null){
					item.setText(3, chrtspec.getLocalWCET());
				}
				if(chrtspec.getRlDl() != null){
					item.setText(4, chrtspec.getRlDl());
				}
				
				if(chrtspec.getRelativePriority() != null){
					item.setText(5, chrtspec.getRelativePriority());
				}
				
			}
		}
	}

	private void cleanPropertyTab() {
		chrtTable.removeAll();
	}


	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		Composite container = getWidgetFactory().createComposite(parent, SWT.NONE);		
		
		GridLayout gridLayout = new GridLayout(8, true);
		container.setLayout(gridLayout);
		
		GridData data = new GridData(SWT.FILL, SWT.FILL, false, false);
		/*
		addChrtButton = new Button(container, SWT.PUSH);
		addChrtButton.setLayoutData(data);
		addChrtButton.setText("Add New Line");

		removeChrtButton = new Button(container, SWT.PUSH);
		data = new GridData(SWT.FILL, SWT.FILL, false, false);
		removeChrtButton.setLayoutData(data);
		removeChrtButton.setText("Remove Line");*/
		
		chrtTable = new Table (container, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		chrtTable.setLinesVisible (true);
		chrtTable.setHeaderVisible (true);
		chrtTable.addControlListener(resizeListener);
		data = new GridData(SWT.FILL, SWT.FILL, true, true, 8, 8);
		chrtTable.setLayoutData(data);
		for (int i = 0; i < chrtTitles.length; i++) {
			TableColumn column = new TableColumn(chrtTable, SWT.NONE);
			column.setText(chrtTitles[i]);
		}
				
		for (int i = 0; i < chrtTitles.length; i++) {
			chrtTable.getColumn(i).pack();
		}
		
		chrtTable.addMouseListener(new TableCellMouseListener(chrtTable));
		
//		final TableEditor editor = new TableEditor(chrtTable);
//		editor.horizontalAlignment = SWT.LEFT;
//		editor.grabHorizontal = true;
//		editor.minimumWidth = 50;
//		
//		selectionListener = new SelectionListener(){
//
//			public void widgetSelected(SelectionEvent e) {
//				// Clean up any previous editor control
//				Control oldEditor = editor.getEditor();
//				if (oldEditor != null) oldEditor.dispose();
//		
//				// Identify the selected row
//				TableItem item = (TableItem)e.item;
//				if (item == null) return;
//		
//				// The control that will be the editor must be a child of the Table
//				Text newEditor = new Text(chrtTable, SWT.NONE);
//				newEditor.setText(item.getText(CONTEXT_COLUMN));
//				newEditor.addModifyListener(new ModifyListener() {
//					public void modifyText(ModifyEvent me) {
//						Text text = (Text)editor.getEditor();
//						editor.getItem().setText(CONTEXT_COLUMN, text.getText());
//					}
//				});
//				newEditor.selectAll();
//				newEditor.setFocus();
//				editor.setEditor(newEditor, item, CONTEXT_COLUMN);
//			}
//
//			public void widgetDefaultSelected(SelectionEvent e) {
//				widgetSelected(e);
//			}
//			
//		};
//		
//		chrtTable.addSelectionListener(selectionListener);
		
	}
	
}


