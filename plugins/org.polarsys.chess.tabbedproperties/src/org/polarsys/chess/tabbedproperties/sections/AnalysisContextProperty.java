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
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaEndtoEndFlow;
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
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;
import org.polarsys.chess.chessmlprofile.Core.PSMPackage;
import org.polarsys.chess.chessmlprofile.util.Constants;
import org.polarsys.chess.core.util.uml.UMLUtils;
import org.polarsys.chess.core.util.AnalysisResultData;
import org.polarsys.chess.core.util.HWAnalysisResultData;
import org.polarsys.chess.core.views.ViewUtils;
import org.polarsys.chess.core.util.EndToEndResultData;

public class AnalysisContextProperty extends AbstractPropertySection {

	private Table swInstanceTable;
	private Table hwTable;
	private Table end2endTable;

	private String[] swInstanceTableTitles = {"SW instance", "context", "arrivalPattern", "localWCET", "rldl", "priority", "ResponseTime", "blockT", "Sched"};
	private String[] hwTableTitles = {"HW instance", "Utilisation", "Res"};
	private String[] end2endTableTitles = {"Scenario", "Deadline", "Res"};
	
	private ControlAdapter resizeListener;
	
	public AnalysisContextProperty(){
		
		resizeListener = new ControlAdapter() {
			public void controlResized(ControlEvent e) {
				int d = 10; 
				int x = swInstanceTable.getSize().x - d;
				int width = x/(swInstanceTableTitles.length) - swInstanceTableTitles.length;
				TableColumn[] columns = swInstanceTable.getColumns();
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
		cleanPropertyTab();
		cleanHWPropertyTab();
		cleanEndtoEndPropertyTab();
		if(selection instanceof TreeSelection){
			TreeSelection treeSelection = (TreeSelection) selection;
			Object obj = treeSelection.getFirstElement();
			if (obj instanceof EObjectTreeElement) {
				EObject eobj = ((EObjectTreeElement) obj).getEObject();	
				if (eobj instanceof Class){
					if(((Class)eobj).getAppliedStereotype(Constants.MARTE_SaAnalysisContext) != null){
						List<AnalysisResultData> listData = UMLUtils.getAnalysisResults((Class)eobj);
						initTableFromResultData(listData);
						List<HWAnalysisResultData> listHWData = UMLUtils.getHWAnalysisResults((Class)eobj);
						initHWTableFromResultData(listHWData);
						List<EndToEndResultData> listEndtoEndData = UMLUtils.getEndtoEndAnalysisResults((Class)eobj);
						initEndtoEndTableFromResultData(listEndtoEndData);
					}
				}
			}
		}
	}

	private void cleanPropertyTab() {
		swInstanceTable.removeAll();
	
	}
	
	private void cleanHWPropertyTab() {
		hwTable.removeAll();
	}
	
	private void cleanEndtoEndPropertyTab() {
		end2endTable.removeAll();
	}


	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		Composite container = getWidgetFactory().createComposite(parent, SWT.NONE);		
		
		GridLayout gridLayout = new GridLayout(8, true);
		container.setLayout(gridLayout);
		
		GridData data = new GridData(SWT.FILL, SWT.FILL, false, false);
				
		swInstanceTable = new Table (container, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		swInstanceTable.setLinesVisible (true);
		swInstanceTable.setHeaderVisible (true);
		swInstanceTable.addControlListener(resizeListener);
		data = new GridData(SWT.FILL, SWT.FILL, true, true, 8, 8);
		swInstanceTable.setLayoutData(data);
		for (int i = 0; i < swInstanceTableTitles.length; i++) {
			TableColumn column = new TableColumn(swInstanceTable, SWT.NONE);
			column.setText(swInstanceTableTitles[i]);
		}
				
		for (int i = 0; i < swInstanceTableTitles.length; i++) {
			swInstanceTable.getColumn(i).pack();
		}
		
		//add a listener to get the cell elements containing the InstanceSpecification and the Context Operation
		swInstanceTable.addMouseListener(new TableCellMouseListener(swInstanceTable));
		
		hwTable = new Table (container, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		hwTable.setLinesVisible (true);
		hwTable.setHeaderVisible (true);
		hwTable.addControlListener(resizeListener);
		data = new GridData(SWT.FILL, SWT.FILL, true, true, 8, 8);
		hwTable.setLayoutData(data);
		for (int i = 0; i < hwTableTitles.length; i++) {
			TableColumn column = new TableColumn(hwTable, SWT.NONE);
			column.setText(hwTableTitles[i]);
		}
				
		for (int i = 0; i < hwTableTitles.length; i++) {
			hwTable.getColumn(i).pack();
		}
		
		
		end2endTable = new Table (container, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		end2endTable.setLinesVisible (true);
		end2endTable.setHeaderVisible (true);
		end2endTable.addControlListener(resizeListener);
		data = new GridData(SWT.FILL, SWT.FILL, true, true, 8, 8);
		end2endTable.setLayoutData(data);
		for (int i = 0; i < end2endTableTitles.length; i++) {
			TableColumn column = new TableColumn(end2endTable, SWT.NONE);
			column.setText(end2endTableTitles[i]);
		}
				
		for (int i = 0; i < end2endTableTitles.length; i++) {
			end2endTable.getColumn(i).pack();
		}		
	}
	
	
	
/**
 * 
 * @param contextClass <<SaAnalysisContext>> entity used to perform the end to end response time analysis
 * @return 
 */
public List<EndToEndResultData> OLDgetEndtoEndAnalysisResults(Class contextClass){
		
		List<EndToEndResultData> listData = new ArrayList<EndToEndResultData>();
		Model model = contextClass.getModel();
		Package psm = ViewUtils.getCHESSPSMPackage(model);
				
		if(contextClass.getAppliedStereotype(Constants.MARTE_SaAnalysisContext) == null
				){
			return listData;
		}
		
		String saAnalysisName = contextClass.getQualifiedName();
		Package psmPackage;
					
		for (Package pkg: psm.getNestedPackages()){
			Stereotype stereo = pkg.getAppliedStereotype(Constants.CH_PsmPackage);
			if(stereo != null){
				PSMPackage psmPkg = (PSMPackage) pkg.getStereotypeApplication(stereo);
				if(psmPkg.getAnalysisContext().getBase_NamedElement().getQualifiedName().equals(saAnalysisName)){
					psmPackage = pkg;
					
					//ASSUMPTION psmPackage owns a AnalysisContext Package
					Package psmAnalysisContextPack = (Package) psmPackage.getOwnedMember("AnalysisContext");
					Class psmAnalysisContextClass = null;
					for (Element temp : psmAnalysisContextPack.getOwnedElements()){
						if (!(temp instanceof Class))
							continue;
						psmAnalysisContextClass = (Class) temp;
											
						for (Element elem: psmAnalysisContextClass.allOwnedElements()){
							if (! (elem instanceof Activity))
								continue;
							Activity activity = (Activity) elem;
							if (elem.getAppliedStereotype(Constants.MARTE_EndtoEndFlow) == null)
								continue;						
							//check if the the current PSM endToEndFlow activity refers to a PIM endToEndFlow
							SaEndtoEndFlow pimEndtoEndFlow = null;
							//check for the constraint that binds the current endToEndFlow activity to the PIM entities
							for (Constraint constr : psmAnalysisContextClass.getOwnedRules()){
								if (!constr.getConstrainedElements().contains(activity))
									continue;				
								for (Element constrained : constr.getConstrainedElements()){
									if (constrained instanceof Activity){				
										if (constrained != activity){
											if (constrained.getAppliedStereotype(Constants.MARTE_EndtoEndFlow) != null &&
													constrained.getAppliedStereotype(Constants.GAWORKLOADBEHAVIOR) != null){
												pimEndtoEndFlow = (SaEndtoEndFlow) constrained.getStereotypeApplication(constrained.getAppliedStereotype(Constants.MARTE_EndtoEndFlow));
												break;
											}
										}
									}
								}
								if (pimEndtoEndFlow!= null)
									break;
							}
							if (pimEndtoEndFlow!= null){
								SaEndtoEndFlow psmEndtoEndFlow = (SaEndtoEndFlow) activity.getStereotypeApplication(activity.getAppliedStereotype(Constants.MARTE_EndtoEndFlow));
								
								EndToEndResultData data = new EndToEndResultData();
								data.scenarioName = activity.getName();
								data.deadline = pimEndtoEndFlow.getEnd2EndD().get(0);
								data.respTime = psmEndtoEndFlow.getEnd2EndT().get(0);
								listData.add(data);
							}
						}
					}
				}
			}
		}
		return listData;
	}	
	
	

	
	
	private void initTableFromResultData(List<AnalysisResultData> resultDataList) {
		cleanPropertyTab();
		for (AnalysisResultData res : resultDataList) {
			TableItem item = new TableItem(swInstanceTable, SWT.NONE);
			Map.Entry<InstanceSpecification, Operation> data = new AbstractMap.SimpleEntry<InstanceSpecification, Operation>(res.instSpec, res.ctxOP);
			item.setData(data);
			item.setText(0, res.instance);
			item.setText(1, res.context);
			item.setText(2, res.arrival);
			item.setText(3, res.localWCET);
			item.setText(4, res.rldl);
			item.setText(5, res.priority);	
			item.setText(6, res.respT);
			item.setText(7, res.blockT);
			item.setText(8, res.isSched);
		}
	}
	
	private void initHWTableFromResultData(List<HWAnalysisResultData> resultDataList) {
		cleanHWPropertyTab();
		for (HWAnalysisResultData res : resultDataList) {
			
			TableItem item = new TableItem(hwTable, SWT.NONE);
			item.setText(0, res.hw_instance);
			item.setText(1, res.hw_utilization);
			item.setText(2, res.hw_res);
		}
	}
	
	private void initEndtoEndTableFromResultData(List<EndToEndResultData> resultDataList) {
		cleanEndtoEndPropertyTab();
		for (EndToEndResultData res : resultDataList) {
			
			TableItem item = new TableItem(end2endTable, SWT.NONE);
			item.setText(0, res.scenarioName);
			item.setText(1, res.deadline);
			item.setText(2, res.respTime);
		}
	}
	
	


}



