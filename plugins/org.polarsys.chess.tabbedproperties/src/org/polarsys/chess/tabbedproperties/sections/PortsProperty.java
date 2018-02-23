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

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.CompositeStructureDiagramEditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.chess.core.profiles.MARTEProfileManager;
import org.polarsys.chess.service.gui.utils.CHESSEditorUtils;

public class PortsProperty extends AbstractPropertySection {


	private static final String FLOWPORT = "MARTE::MARTE_DesignModel::GCM::FlowPort";
	private static final String CSPORT = "MARTE::MARTE_DesignModel::GCM::ClientServerPort";
	private static final String ALLOCATE = "MARTE::MARTE_Foundations::Alloc::Allocate";
	private Label msgLabel;
	private Text portText;
	private CCombo opCombo;
	private CCombo paramCombo;
	private List mapList;
	private Port port;
	private Component comp;
	private Operation op;
	private Parameter param;
	private ModifyListener modOpListener;
	private ModifyListener modParamListener;
	private SelectionListener selListener;
	private SelectionListener remMapListener;
	
	public PortsProperty() {
		
		this.modOpListener = new ModifyListener() {
			
			public void modifyText(ModifyEvent e) {			
				String opName = opCombo.getText();
				if(comp != null){
					paramCombo.removeAll();
					//search the operation among those included in required and provided interfaces
					EList<Operation> opList = getInterfaceOperations(comp);
					for (Operation operation : opList) {
						if(operation.getName().equals(opName)){ //TODO a better way to ensure that two operation ar equals
							op = operation;
							break;
						}
					}
					if(op != null){
						Type portType = port.getType();
						String portDirection = port.getValue(port.getAppliedStereotype(FLOWPORT), "direction").toString();						
						
						boolean provided = false;
						for (Operation operation : comp.getAllOperations()) {
							if(operation.getName().equals(op.getName())){ //TODO see above
								provided = true;
								break;
							}
						}
						EList<Parameter> paramList = op.getOwnedParameters();
						for (Parameter param : paramList) {
							if(param.getType().equals(portType)){
								String paramDirection =	param.getDirection().toString();
								if(provided){ //provided
									if(paramDirection.equals(portDirection) || portDirection.equals("inout") 
											|| paramDirection.equals("inout")){
										paramCombo.add(param.getName());
									}
								}else{ //required
									if(portDirection.equals("inout") || paramDirection.equals("inout")){
										paramCombo.add(param.getName());
									}else if(paramDirection.equals("out") && portDirection.equals("in")){
										paramCombo.add(param.getName());
									}else if(paramDirection.equals("in") && portDirection.equals("out")){
										paramCombo.add(param.getName());
									}
								}
							}
						}
					}
				}
				
			}
		};
		
		this.modParamListener = new ModifyListener() {
			
			public void modifyText(ModifyEvent e) {
				String paramName = paramCombo.getText();
				if(comp != null && op != null){
					param = op.getOwnedParameter(paramName, null);
//					if(param != null){
//						System.out.println(param.getLabel());
//					}
				}
				
			}
		};
		
		this.selListener = new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				if(comp != null && port != null && op != null && param != null){
					//only case in which the mapping is possible

					PapyrusMultiDiagramEditor editor = CHESSEditorUtils.getCHESSEditor();
					if (editor == null){ 
						printErrMsg("please open the model in the CHESS editor");
						return;
					}
					
					Object temp = CHESSEditorUtils.getDiagramGraphicalViewer().getRootEditPart().getChildren().get(0);
									
					if (temp == null || !(temp instanceof CompositeStructureDiagramEditPart)){
						printErrMsg("please perform the operation in a Composite Structure Diagram");
						return;
					}
					
					final CompositeStructureDiagramEditPart csd = (CompositeStructureDiagramEditPart) temp;
					TransactionalEditingDomain editingDomain = csd.getEditingDomain();
					editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
						protected void doExecute() {
							
							//create Abstraction, only if not already present
							Package owningPkg = port.allOwningPackages().get(0);
							EList<PackageableElement> pkgElments = owningPkg.getPackagedElements();
							for (PackageableElement pkgElement : pkgElments) {
								if (pkgElement instanceof Abstraction){
									Abstraction abs = (Abstraction) pkgElement;
									if(abs.getClients().contains(port) && abs.getSuppliers().contains(param)){
										Display display = Display.getCurrent();
										msgLabel.setForeground(display.getSystemColor(SWT.COLOR_DARK_YELLOW));
										msgLabel.setText("mapping already exists!");
										return;
									}
								}
							}
							Abstraction abs = UMLFactory.eINSTANCE.createAbstraction();
							abs.getClients().add(port); 
							abs.getSuppliers().add(param);
							abs.setName("map " + port.getName() +  " to " + param.getOperation().getName()+"."+param.getName());
							owningPkg.getPackagedElements().add(abs);

							//apply <<Allocate>> stereotype
							MARTEProfileManager.applyStereotypeTo("allocate", abs);
							Display display = Display.getCurrent();
							msgLabel.setForeground(display.getSystemColor(SWT.COLOR_BLUE));
							msgLabel.setText("mapping created!");				
							
							//update list of mappings
							mapList.add(abs.getName());		
							mapList.update();
						}
					});					
					
				}else{
					printErrMsg("please select Port, Operation and Parameter");
					return;
				}

			}



			public void widgetDefaultSelected(SelectionEvent e) {
				//nothing to do here
			}
			
		};
	
		this.remMapListener = new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				
				int index = mapList.getSelectionIndex();
				if(index < 0){
					printErrMsg("please select a mapping from the list below");
					return;
				}
				
				final String selected = mapList.getItem(index);
//				final Dependency dep = port.getClientDependency(selected);
				
				PapyrusMultiDiagramEditor editor = CHESSEditorUtils.getCHESSEditor();
				if (editor == null){ 
					printErrMsg("please open the model in the CHESS editor");
					return;
				}
				
				
				Object temp = CHESSEditorUtils.getDiagramGraphicalViewer().getRootEditPart().getChildren().get(0);
				
				if (temp == null || !(temp instanceof CompositeStructureDiagramEditPart)){
					printErrMsg("please perform the operation in a Composite Structure Diagram");
					return;
				}
				
				final CompositeStructureDiagramEditPart csd = (CompositeStructureDiagramEditPart) temp;
				TransactionalEditingDomain editingDomain = csd.getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					protected void doExecute() {
						
//						port.getClientDependencies().remove(dep);
						Package owningPkg = port.getNearestPackage();
						Abstraction abs = (Abstraction) owningPkg.getPackagedElement(selected);
						abs.unapplyStereotype(abs.getAppliedStereotype(ALLOCATE));
						owningPkg.getPackagedElements().remove(abs);
						abs.destroy();
						mapList.remove(selected);
						mapList.update();
						
						Display display = Display.getCurrent();
						msgLabel.setForeground(display .getSystemColor(SWT.COLOR_BLUE));
						msgLabel.setText("mapping removed!");
					}
				});
			}
			
			public void widgetDefaultSelected(SelectionEvent e) {
				//nothing to do here
			}
		};
	}

	private void printErrMsg(String msg) {
		//print some error msg in the status line
		Display display = Display.getCurrent();
		msgLabel.setForeground(display.getSystemColor(SWT.COLOR_RED));
		msgLabel.setText(msg);
		
	}
	
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
			
		Composite composite = getWidgetFactory().createComposite(parent, SWT.NONE);
		
		GridLayout gridLayout = new GridLayout(3, true);
		composite.setLayout(gridLayout);
		
		GridData gd = new GridData(SWT.FILL, SWT.FILL, false, false);
		gd.horizontalSpan = 2;
		portText = getWidgetFactory().createText(composite, "no flowport selected");
		portText.setEditable(false);
		portText.setLayoutData(gd);
		
		gd = new GridData(SWT.FILL, SWT.FILL, false, false);
		Label portLabel = getWidgetFactory().createLabel(composite, "selected flow port", SWT.NONE);
		portLabel.setLayoutData(gd);
		
		gd = new GridData(SWT.FILL, SWT.FILL, false, false);
		gd.horizontalSpan = 2;
		opCombo = getWidgetFactory().createCCombo(composite);
		opCombo.addModifyListener(modOpListener);
		opCombo.setLayoutData(gd);
		
		gd = new GridData(SWT.FILL, SWT.FILL, false, false);
		Label opLabel = getWidgetFactory().createLabel(composite, "select operation", SWT.NONE);
		opLabel.setLayoutData(gd);
		
		gd = new GridData(SWT.FILL, SWT.FILL, false, false);
		gd.horizontalSpan = 2;
		paramCombo = getWidgetFactory().createCCombo(composite);
		paramCombo.addModifyListener(modParamListener);
		paramCombo.setLayoutData(gd);
		
		gd = new GridData(SWT.FILL, SWT.FILL, false, false);
		Label paramLabel = getWidgetFactory().createLabel(composite, "select parameter", SWT.NONE);
		paramLabel.setLayoutData(gd);

		gd = new GridData(SWT.BEGINNING, SWT.FILL, false, false);
		Button mapButton = getWidgetFactory().createButton(composite, "Create Mapping", SWT.PUSH);
		mapButton.addSelectionListener(selListener);
		mapButton.setLayoutData(gd);
		
		gd = new GridData(SWT.BEGINNING, SWT.FILL, false, false);
		Button removeMapButton = getWidgetFactory().createButton(composite, "Remove Mapping", SWT.PUSH);
		removeMapButton.addSelectionListener(remMapListener);
		removeMapButton.setLayoutData(gd);
		
		gd = new GridData(SWT.FILL, SWT.FILL, true, false);
		msgLabel = getWidgetFactory().createLabel(composite, "", SWT.NONE);
		msgLabel.setLayoutData(gd);
		
		gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd.horizontalSpan = 2;
		gd.horizontalSpan = 3;
		mapList = getWidgetFactory().createList(composite, SWT.BORDER | SWT.V_SCROLL);
		mapList.setLayoutData(gd);
		
	}
	
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		mapList.removeAll();
		msgLabel.setText("");
		port = getPortFromSelection(getSelection());
		if(port != null){
			portText.setText(port.getName());
			comp = (Component) port.getFeaturingClassifiers().get(0);	
			if(comp != null){
				opCombo.removeAll();
				paramCombo.removeAll();
				//get all operations from required and provided interfaces
				EList<Operation> opList = getInterfaceOperations(comp);
				for (Operation operation : opList) {
					opCombo.add(operation.getName());
				}
			}
			EList<Dependency> dependencies = port.getClientDependencies();
			for (Dependency dep : dependencies) {
				if (dep instanceof Abstraction && dep.getAppliedStereotype(ALLOCATE) != null){
					mapList.add(dep.getName());
				}
			}
			
		}else{
			portText.setText("no flow port selected");
			comp = null;
			op = null;
			opCombo.removeAll();
			paramCombo.removeAll();
			mapList.removeAll();
		}
	}
	



	private EList<Operation> getInterfaceOperations(Component comp) {
		// returns operation included in all Provided and Required Interfaces of Component comp
		EList <Operation> ops = new BasicEList<Operation>();
		EList<Property> compAttrs = comp.getAllAttributes();
		for (Property prop : compAttrs) {
			Stereotype stereo = prop.getAppliedStereotype(CSPORT);
			if (prop instanceof Port && stereo != null){
				Port csport = (Port) prop;
				EList <Interface> provIfs = (EList<Interface>) csport.getValue(stereo, "provInterface");
				EList <Interface> reqIfs = (EList<Interface>) csport.getValue(stereo, "reqInterface");
				EList <Interface> result = new BasicEList<Interface>();
				result.addAll(provIfs);
				result.addAll(reqIfs);
				for (Interface interf : result) {
					ops.addAll(interf.getAllOperations());
				}
				
			}
		}
		return ops;
	}


	@Override
	public void refresh() {
//		System.out.println("refreshing");
		super.refresh();
	}

	private Port getPortFromSelection(ISelection selection) {
		
		if (!(selection instanceof IStructuredSelection)){	
			 return null;
		}
		java.util.List<?> selectionList = ((IStructuredSelection) selection).toList();
		
		if (selectionList.size() == 1) {
			Object selected = selectionList.get(0);
			EObject selectedEObject = EMFHelper.getEObject(selected);
			if(selectedEObject instanceof Port){
				Port port = (Port) selectedEObject;
				//check if it's a flow port
				EList<Stereotype> stereoList = port.getAppliedStereotypes();
				if(port.getAppliedStereotype(FLOWPORT) != null){
					return port;
				}
			}
		}
		return null;
	} 


}
