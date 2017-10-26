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

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.cdo.transfer.CDOTransfer;
import org.eclipse.emf.cdo.transfer.CDOTransferSystem;
import org.eclipse.emf.cdo.util.CDOUtil;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.celleditor.FeatureEditorDialog;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.opencert.evm.evidspec.evidence.Artefact;
import org.eclipse.opencert.sam.arg.arg.Claim;
import org.eclipse.opencert.sam.arg.arg.impl.ClaimImpl;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.widgets.editors.IElementSelector;
import org.eclipse.papyrus.infra.widgets.editors.MultipleValueSelectionDialog;
import org.eclipse.papyrus.infra.widgets.editors.MultipleValueSelectorDialog;
import org.eclipse.papyrus.infra.widgets.selectors.ReferenceSelector;
import org.eclipse.papyrus.sysml.diagram.common.Activator;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.BlockEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.ConstraintBlockEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.custom.edit.part.CustomConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ComponentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ConstraintEditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.DragDetectEvent;
import org.eclipse.swt.events.DragDetectListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.ui.part.PluginTransfer;
import org.eclipse.ui.part.ResourceTransfer;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.polarsys.chess.contracts.chessextension.popup.actions.SetContractRefinement;
import org.polarsys.chess.contracts.profile.chesscontract.Contract;
import org.polarsys.chess.contracts.profile.chesscontract.FormalProperty;
import org.polarsys.chess.service.utils.CHESSEditorUtils;


public class FormalPropertyEditPartSection extends AbstractPropertySection{
	
	public static final String CONTRACT = "CHESSContract::Contract";
	public  static final String CONTRACT_PROP = "CHESSContract::ContractProperty";
	public static final String FORMAL_PROP = "CHESSContract::FormalProperty";

	
	private Constraint constraint;

	private Button removeClaimButton;
	private ClaimTreeDropAdapter claimDropAdapter;
	private TableViewer claimViewer;
	

	
	public FormalPropertyEditPartSection(){
		
			
	}
	
	

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		
		super.createControls(parent, aTabbedPropertySheetPage);		
		
		Composite composite = getWidgetFactory().createComposite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(4, false));
				
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, false);
		gd.horizontalSpan = 3;
		
		//claim property
		gd = new GridData(SWT.FILL, SWT.FILL, false, false);
		gd.horizontalSpan = 3;
		Label claimLabel = getWidgetFactory().createLabel(composite, "Claim", SWT.NONE);
		claimLabel.setLayoutData(gd);
		
		removeClaimButton = getWidgetFactory().createButton(composite, "", SWT.NONE);
		
		ImageDescriptor remImageDes= AbstractUIPlugin.imageDescriptorFromPlugin("org.polarsys.chess.contracts.chessextension", "/icons/rem_co.gif");
		removeClaimButton.setImage(remImageDes.createImage());
		
		
		removeClaimButton.addSelectionListener(new SelectionListener() {
		      
			@Override
			public void widgetSelected(SelectionEvent e) {

				ISelection selection = claimViewer.getSelection();
				
				final Claim claim = (Claim) ((StructuredSelection) selection).getFirstElement();
				 PapyrusMultiDiagramEditor editor = CHESSEditorUtils.getCHESSEditor();
					if (editor != null){ 

							TransactionalEditingDomain editingDomain = (TransactionalEditingDomain) editor.getEditingDomain();
							editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

								@Override
								protected void doExecute() {
									Stereotype stereo = constraint.getAppliedStereotype(FormalPropertyEditPartSection.FORMAL_PROP);
								   FormalProperty formalPropStereo = (FormalProperty) constraint.getStereotypeApplication(stereo);
								   formalPropStereo.getClaim().remove(claim);

								}
								
							});
							claimViewer.refresh();
					}
				
				/*
				@SuppressWarnings("deprecation")
				ReferenceSelector selector = new ReferenceSelector(true);
				org.eclipse.papyrus.infra.widgets.providers.StaticContentProvider prov = new org.eclipse.papyrus.infra.widgets.providers.StaticContentProvider(null);
				
				
				org.eclipse.papyrus.uml.tools.providers.UMLContentProvider prov2 = new org.eclipse.papyrus.uml.tools.providers.UMLContentProvider(contract,
						UMLPackage.eINSTANCE.getPackage_PackagedElement());
				
				Object obj =CDOUtil.getCDOObject(contract);
				
				
				selector.setContentProvider(prov2);
				MultipleValueSelectionDialog vDialog = new MultipleValueSelectionDialog(shell, selector, "zzzz");
				int result = vDialog.open();*/
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		    });
		   
		 //
		gd = new GridData(SWT.END, SWT.FILL, false, false);
		gd.horizontalSpan = 1;
		
		removeClaimButton.setLayoutData(gd);
		
		

		claimViewer = new TableViewer(composite, SWT.MULTI | SWT.H_SCROLL
                | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		
		// create the columns
		createClaimColumns(parent,claimViewer);
		
		final Table tableclaim = claimViewer.getTable();
		tableclaim.setHeaderVisible(true);
		tableclaim.setLinesVisible(true);
		
		//claimViewer.setContentProvider(ArrayContentProvider.getInstance());
		claimViewer.setContentProvider(ClaimTreeContentProvider.getInstance());
		
		claimDropAdapter = new ClaimTreeDropAdapter(claimViewer);
		//Transfer[] transfers = new Transfer[] { ResourceTransfer.getInstance(), LocalSelectionTransfer.getTransfer(), PluginTransfer.getInstance() };
		Transfer[] transfers = new Transfer[] { LocalSelectionTransfer.getTransfer() };
		int ops = DND.DROP_COPY | DND.DROP_MOVE;
		claimViewer.addDropSupport(ops, transfers, claimDropAdapter);
		gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd.horizontalSpan = 4;
		
		claimViewer.getControl().setLayoutData(gd);
		claimViewer.addDoubleClickListener(new ClickListener());
				
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
			if(selected instanceof CustomConstraintEditPart){
				Constraint constr = (Constraint) (((CustomConstraintEditPart)selected).resolveSemanticElement());
				//check if it's a contract
				if(constr.getAppliedStereotype(FORMAL_PROP) != null){
					cleanPropertyTab();
					setContractPropertyTab(constr);
				}
			}
			
			else{
				cleanPropertyTab();
			}
		}else{
			cleanPropertyTab();
		}
		
		claimDropAdapter.setConstraint(constraint);
		//fill claims list
		if(constraint != null){
			
			Stereotype stereo = constraint.getAppliedStereotype(FormalPropertyEditPartSection.FORMAL_PROP);
			FormalProperty formalPropStereo = (FormalProperty) constraint.getStereotypeApplication(stereo);
			claimViewer.setInput(formalPropStereo.getClaim());
		
		}
		
		
	}
	
	

	private void setContractPropertyTab(Constraint constr) {
		constraint = constr;
		
		Stereotype formalProp = constr.getAppliedStereotype(FORMAL_PROP);
		
		FormalProperty foprmalPropStereo = (FormalProperty) constraint.getStereotypeApplication(formalProp);
		
		claimViewer.setInput(foprmalPropStereo.getClaim());
		
		
		
	}

	private void cleanPropertyTab() {

		claimViewer.setInput(null);
	}

	
	// create the columns for the claim table
    private void createClaimColumns(final Composite parent, final TableViewer viewer) {
            String[] titles = { "Claim", "Resource"};
            int[] bounds = { 400, 200};

            // first column is for the claim description
            TableViewerColumn col = createTableViewerColumn(viewer, titles[0], bounds[0], 0);
            col.setLabelProvider(new ColumnLabelProvider() {
                    @Override
                    public String getText(Object element) {
                            Claim claim = (Claim) element;
                            return claim.getId()+" "+claim.getName();
                    }
            });
            
            // second column is for the claim resource
            col = createTableViewerColumn(viewer, titles[1], bounds[1], 1);
            col.setLabelProvider(new ColumnLabelProvider() {
                    @Override
                    public String getText(Object element) {
                            ClaimImpl claim = (ClaimImpl) element;
                            return Utils.getPathStringFor(claim);
                    }
            });

    }

    private TableViewerColumn createTableViewerColumn(TableViewer viewer, String title, int bound, final int colNumber) {
            final TableViewerColumn viewerColumn = new TableViewerColumn(viewer,
                            SWT.NONE);
            final TableColumn column = viewerColumn.getColumn();
            column.setText(title);
            column.setWidth(bound);
            column.setResizable(true);
            column.setMoveable(true);
            return viewerColumn;
    }
    
    private class ClickListener implements IDoubleClickListener {


		@Override
		public void doubleClick(DoubleClickEvent event) {
			// TODO Auto-generated method stub
			EObject sel = (EObject) ((StructuredSelection) event.getSelection()).getFirstElement();
			Utils.selectCDOObjectInProjectExplorer(sel);
			
		}
		
	}
    
}
