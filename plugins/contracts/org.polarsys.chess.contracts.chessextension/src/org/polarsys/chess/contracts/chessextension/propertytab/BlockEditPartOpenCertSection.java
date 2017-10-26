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
import java.util.Vector;

import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.impl.CDOResourceImpl;
import org.eclipse.emf.cdo.util.CDOUtil;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.opencert.evm.evidspec.evidence.Artefact;
import org.eclipse.opencert.sam.arg.arg.Claim;
import org.eclipse.opencert.sam.arg.arg.impl.ClaimImpl;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.BlockEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.ConstraintBlockEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ComponentEditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.resources.ProjectExplorer;
import org.eclipse.ui.plugin.AbstractUIPlugin;
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
import org.polarsys.chess.service.utils.CHESSEditorUtils;


public class BlockEditPartOpenCertSection extends AbstractPropertySection{
	
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
	
	private Button removeClaimButton;
	private ClaimTreeDropAdapter claimDropAdapter;
	private TableViewer claimViewer;
	
	private Button removeSupportedArtefactButton;
	private ArtefactTreeDropAdapter artefactDropAdapter;
	private TableViewer supporterByArtefactViewer;
	

	
	public BlockEditPartOpenCertSection(){
		
		contractListListener = new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				String selection = contractList.getItem(contractList.getSelectionIndex());
				contract = getContract(selectedClass, selection);
				if(contract != null){
					setContractPropertyTab(contract);
				}
				contractLabel.setText("Selected Class");
				//contractText.setText(selectedClass.getQualifiedName());
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// nothing to do here	
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
				
				PapyrusMultiDiagramEditor editor = getEditor();
				 
					if (editor != null){ 

							TransactionalEditingDomain editingDomain = (TransactionalEditingDomain) editor.getEditingDomain();
							editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

								@Override
								protected void doExecute() {
									Stereotype stereo = contract.getAppliedStereotype(BlockEditPartOpenCertSection.CONTRACT);
								   Contract contractStereo = (Contract) contract.getStereotypeApplication(stereo);
								   contractStereo.getClaim().remove(claim);

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
		
		// make lines and header visible
		final Table table = claimViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
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
		
		
		//supportedBy property
		gd = new GridData(SWT.FILL, SWT.FILL, false, false);
		gd.horizontalSpan = 3;
		Label supportedByLabel = getWidgetFactory().createLabel(composite, "SupportedBy", SWT.NONE);
		supportedByLabel.setLayoutData(gd);
		
		removeSupportedArtefactButton = getWidgetFactory().createButton(composite, "", SWT.NONE);
		
		remImageDes= AbstractUIPlugin.imageDescriptorFromPlugin("org.polarsys.chess.contracts.chessextension", "/icons/rem_co.gif");
		removeSupportedArtefactButton.setImage(remImageDes.createImage());
		
		
		removeSupportedArtefactButton.addSelectionListener(new SelectionListener() {
		      
			@Override
			public void widgetSelected(SelectionEvent e) {

				ISelection selection = supporterByArtefactViewer.getSelection();
				
				final Artefact artefact = (Artefact) ((StructuredSelection) selection).getFirstElement();
				 PapyrusMultiDiagramEditor editor = getEditor();;
					if (editor != null){ 

							TransactionalEditingDomain editingDomain = (TransactionalEditingDomain) editor.getEditingDomain();
							editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

								@Override
								protected void doExecute() {
									Stereotype stereo = contract.getAppliedStereotype(BlockEditPartOpenCertSection.CONTRACT);
								   Contract contractStereo = (Contract) contract.getStereotypeApplication(stereo);
								   contractStereo.getSupportedBy().remove(artefact);

								}
								
							});
							supporterByArtefactViewer.refresh();
					}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}

			
		    });
		   
		 //
		gd = new GridData(SWT.END, SWT.FILL, false, false);
		gd.horizontalSpan = 1;
		
		removeSupportedArtefactButton.setLayoutData(gd);
		
		supporterByArtefactViewer = new TableViewer(composite, SWT.MULTI | SWT.H_SCROLL
                | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		
		// create the columns
		createArtefactColumns(parent,supporterByArtefactViewer);
		
		final Table tableart = supporterByArtefactViewer.getTable();
		tableart.setHeaderVisible(true);
		tableart.setLinesVisible(true);
		
		//claimViewer.setContentProvider(ArrayContentProvider.getInstance());
		supporterByArtefactViewer.setContentProvider(ClaimTreeContentProvider.getInstance());
		
		artefactDropAdapter= new ArtefactTreeDropAdapter(supporterByArtefactViewer, ArtefactTreeDropAdapter.SUPPORTEDBY);
		//Transfer[] transfers = new Transfer[] { ResourceTransfer.getInstance(), LocalSelectionTransfer.getTransfer(), PluginTransfer.getInstance() };
		transfers = new Transfer[] { LocalSelectionTransfer.getTransfer() };
		ops = DND.DROP_COPY | DND.DROP_MOVE;
		supporterByArtefactViewer.addDropSupport(ops, transfers, artefactDropAdapter);
		gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd.horizontalSpan = 4;
		
		supporterByArtefactViewer.getControl().setLayoutData(gd);
		supporterByArtefactViewer.addDoubleClickListener(new ClickListener());
		///
		
				
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
				if(clazz.getAppliedStereotype(CONTRACT) != null){
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
				if(clazz.getAppliedStereotype(CONTRACT) != null){
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
					if(clazz.getAppliedStereotype(CONTRACT) != null){
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
		
		claimDropAdapter.setContractClass(contract);
		//fill claims list
		if(contract != null){
			
			Stereotype stereo = contract.getAppliedStereotype(BlockEditPartOpenCertSection.CONTRACT);
			Contract contractStereo = (Contract) contract.getStereotypeApplication(stereo);
			claimViewer.setInput(contractStereo.getClaim());
		
		}
		
		artefactDropAdapter.setContractClass(contract);
		
		//fill supportedBy artifact list
		if(contract != null){
			
			Stereotype stereo = contract.getAppliedStereotype(BlockEditPartOpenCertSection.CONTRACT);
			Contract contractStereo = (Contract) contract.getStereotypeApplication(stereo);
			supporterByArtefactViewer.setInput(contractStereo.getSupportedBy());
		
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
//		contractLabel.setText("Selected Contract");
//		contractText.setText(clazz.getQualifiedName());
		Stereotype contrStereo = clazz.getAppliedStereotype(CONTRACT);
				
		Contract contractStereo = (Contract) contract.getStereotypeApplication(contrStereo);
		
		claimViewer.setInput(contractStereo.getClaim());
		supporterByArtefactViewer.setInput(contractStereo.getSupportedBy());
		
		claimDropAdapter.setContractClass(clazz);
		artefactDropAdapter.setContractClass(clazz);
	}

	private void cleanPropertyTab() {

		contract = null;
		claimViewer.setInput(null);
		supporterByArtefactViewer.setInput(null);
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
    
 // create the columns for the artefact table
    //TODO to be factorized together with the claim...
    private void createArtefactColumns(final Composite parent, final TableViewer viewer) {
            String[] titles = { "Artefact", "Resource"};
            int[] bounds = { 400, 200};

            // first column is for the artefact description
            TableViewerColumn col = createTableViewerColumn(viewer, titles[0], bounds[0], 0);
  
            col.setLabelProvider(new ColumnLabelProvider() {
                    @Override
                    public String getText(Object element) {
                            Artefact artefact = (Artefact) element;
                            return artefact.getId()+" "+artefact.getName();
                    }
            });
            
         // second column is for the artefact resource
            col = createTableViewerColumn(viewer, titles[1], bounds[1], 1);
            col.setLabelProvider(new ColumnLabelProvider() {
                    @Override
                    public String getText(Object element) {
                    		Artefact artefact = (Artefact) element;
                            return Utils.getPathStringFor(artefact);
                    }
            });

    }
    
    public static /*@Nullable*/PapyrusMultiDiagramEditor getEditor() {
		IEditorPart editor = null;
		try {
			editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().getActiveEditor();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		PapyrusMultiDiagramEditor r = null;
		if (editor != null && editor instanceof PapyrusMultiDiagramEditor)
			r = (PapyrusMultiDiagramEditor) editor;
		
		return r;
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
