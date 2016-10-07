/*****************************************************************************
 * Copyright (c) 2016 Budapest University of Technology and Economics, Intecs
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/

package org.polarsys.chess.instance.view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IModelConnectorTypeEnum;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.tooling.ui.queryexplorer.adapters.EMFModelConnector;
import org.eclipse.incquery.viewers.runtime.extensions.SelectionHelper;
import org.eclipse.incquery.viewers.runtime.model.IncQueryViewerDataModel;
import org.eclipse.incquery.viewers.runtime.model.ViewerDataFilter;
import org.eclipse.incquery.viewers.runtime.model.ViewerState;
import org.eclipse.incquery.viewers.runtime.model.ViewerState.ViewerStateFeature;
import org.eclipse.incquery.viewers.runtime.sources.QueryLabelProvider;
import org.eclipse.incquery.viewers.runtime.sources.TreeContentProvider;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.openelement.service.OpenElementService;
import org.eclipse.papyrus.views.search.scope.ScopeEntry;
import org.eclipse.papyrus.views.search.utils.DefaultServiceRegistryTracker;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.uml2.uml.Slot;
import org.polarsys.chess.instance.view.util.ChildCHRTSpecItemQuerySpecification;
import org.polarsys.chess.instance.view.util.ChildCHRTSpecQuerySpecification;
import org.polarsys.chess.instance.view.util.ChildPortSlotsOperationItemQuerySpecification;
import org.polarsys.chess.instance.view.util.ChildPortSlotsOperationQuerySpecification;
import org.polarsys.chess.instance.view.util.ChildPortSlotsQuerySpecification;
import org.polarsys.chess.instance.view.util.ChildPrivCHRTSpecItemQuerySpecification;
import org.polarsys.chess.instance.view.util.ChildPrivCHRTSpecQuerySpecification;
import org.polarsys.chess.instance.view.util.ChildPrivateOperationsQuerySpecification;
import org.polarsys.chess.instance.view.util.SwSystemCHGaResourcePlatformQuerySpecification;
import org.polarsys.chess.instance.view.util.SwSystemChild2ItemQuerySpecification;
import org.polarsys.chess.instance.view.util.SwSystemChild2QuerySpecification;
import org.polarsys.chess.instance.view.util.SwSystemRootQuerySpecification;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;


public class InstanceViewPart extends ViewPart implements IPartListener2, ISelectionProvider, ITabbedPropertySheetPageContributor {

	TreeViewer viewer;
	SelectionHelper helper = new SelectionHelper();
	AdvancedIncQueryEngine engine = null;
	EMFModelConnector modelConnector;
    IEditorPart editor;
	ViewerState state;
	
	
	
	public InstanceViewPart() {
		IWorkbenchPage workbenchPage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		workbenchPage.addPartListener(this);		
	}
	
	@Override
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent){
			@Override
			protected void updateSelection(ISelection selection) {
//				//SelectionChangedEvent event = new SelectionChangedEvent(this, selection);
//				//fireSelectionChanged(event);
//				Object first = ((TreeSelection) selection).getFirstElement();
//				Object umlobj = ((org.eclipse.incquery.viewers.runtime.model.Item)  first).getParamObject();
//				
//				List list = new ArrayList();
//				list.add(umlobj);
//				StructuredSelection structsel = new StructuredSelection(list, getComparer());
				
				//super.updateSelection(structsel);
			}
			
			/**
			 * Handles a post select event from the widget.
			 * <p>
			 * This method is internal to the framework; subclassers should not call
			 * this method.
			 * </p>
			 * 
			 * @param e the SWT selection event
			 */
			@Override
			protected void handlePostSelect(SelectionEvent e) {
				//change the current selection from incquery tree item to uml object, so the other views can properly switch their content. this is useful in order to have a tree selection fired, with the current selection and the path in the tree
				ISelection selection = getSelection();
				Object first = ((TreeSelection) selection).getFirstElement();
				Object umlobj = ((org.eclipse.incquery.viewers.runtime.model.Item)  first).getParamObject();
				
				List list = new ArrayList();
				list.add(umlobj);
				StructuredSelection structsel = new StructuredSelection(list, getComparer());
				SelectionChangedEvent event = new SelectionChangedEvent(this, structsel);
				firePostSelectionChanged(event);
			}
		};
		viewer.setUseHashlookup(true);  
        viewer.addSelectionChangedListener(helper.trickyListener);    
        editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        if(editor != null)
        	loadModel(editor);
             
        // Create a menu manager and create context menu
        MenuManager menuManager = new MenuManager();
        Menu menu = menuManager.createContextMenu(viewer.getControl());
        // set the menu on the SWT widget
        viewer.getTree().setMenu(menu);
        // register the menu with the framework
        getSite().registerContextMenu(menuManager, viewer);
        
        getSite().setSelectionProvider(viewer);
        
        viewer.addDoubleClickListener(new IDoubleClickListener() {
        	  @Override
        	  public void doubleClick(DoubleClickEvent event) {
        	    TreeViewer viewer = (TreeViewer) event.getViewer();
        	    IStructuredSelection thisSelection = (IStructuredSelection) event.getSelection(); 
        	    Object selectedNode = thisSelection.getFirstElement(); 
        	    viewer.setExpandedState(selectedNode,
        	        !viewer.getExpandedState(selectedNode));
        	  //navigate inst as hyperlink (to instance - papyrus bug)
        		try {
        			EObject umlobj = (EObject) ((org.eclipse.incquery.viewers.runtime.model.Item)  selectedNode).getParamObject();
        			if (umlobj instanceof Slot){
        				//select the defining feature
        				umlobj = ((Slot)umlobj).getDefiningFeature();
        			}
        			URI umlUri = umlobj.eResource().getURI();
        			ScopeEntry scopeEntry = new ScopeEntry(umlUri, new DefaultServiceRegistryTracker());
        			OpenElementService service = scopeEntry.getServicesRegistry().getService(OpenElementService.class);
        			service.openSemanticElement(umlobj);
        		} catch (PartInitException e) {
        			e.printStackTrace();
        		} catch (ServiceException e) {
        			e.printStackTrace();
        		}
        	  }
        	}); 

        
    }

	@Override
	public void setFocus() {
	    viewer.getControl().setFocus();	 	
	}

	protected Collection<IQuerySpecification<?>> getSpecifications() throws IncQueryException {
		Builder<IQuerySpecification<?>> builder = ImmutableSet.<IQuerySpecification<?>>builder();
		
		builder.add(SwSystemCHGaResourcePlatformQuerySpecification.instance());
		builder.add(SwSystemRootQuerySpecification.instance());
		builder.add(SwSystemChild2ItemQuerySpecification.instance());
		builder.add(SwSystemChild2QuerySpecification.instance());
		builder.add(ChildPortSlotsQuerySpecification.instance());
		builder.add(ChildPortSlotsOperationItemQuerySpecification.instance());
		builder.add(ChildPortSlotsOperationQuerySpecification.instance());
		builder.add(ChildCHRTSpecItemQuerySpecification.instance());
		builder.add(ChildCHRTSpecQuerySpecification.instance());
		builder.add(ChildPrivCHRTSpecItemQuerySpecification.instance());
		builder.add(ChildPrivCHRTSpecQuerySpecification.instance());
		builder.add(ChildPrivateOperationsQuerySpecification.instance());
		return builder.build();
	}
	
	
	protected IncQueryEngine getEngine() {
		return engine;
	}
	
	protected void engineUpdated() {
        try {
        	state = IncQueryViewerDataModel.newViewerState(engine, getSpecifications(), ViewerDataFilter.UNFILTERED, ImmutableSet.of(ViewerStateFeature.CONTAINMENT, ViewerStateFeature.EDGE));
            bind(viewer, state);            
        } catch (IncQueryException e) {
            e.printStackTrace();
        }
    }

	@SuppressWarnings("deprecation")
	@Override
	public void partActivated(IWorkbenchPartReference partRef) {
		IWorkbenchPart part = partRef.getPart(false);
		if(part instanceof IEditorPart) {
			IEditorPart activeEditor = (IEditorPart) part; //PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			loadModel(activeEditor);
		}
	}

	private void loadModel(IEditorPart activeEditor) {
		if(modelConnector != null) {
			EMFModelConnector temp = new EMFModelConnector(activeEditor);
			Notifier oldNotifier = null;
			try{
				oldNotifier = modelConnector.getNotifier(IModelConnectorTypeEnum.RESOURCESET);
			}catch (Exception ex){
				ex.printStackTrace();
			}
			Notifier newNotifier = temp.getNotifier(IModelConnectorTypeEnum.RESOURCESET);
			if(newNotifier == oldNotifier) return;
			modelConnector = temp;
		} else {
			modelConnector = new EMFModelConnector(activeEditor);
		}
		modelConnector.loadModel(IModelConnectorTypeEnum.RESOURCESET);
		if(modelConnector.getKey() != null) {
			try {
				engine = (AdvancedIncQueryEngine) AdvancedIncQueryEngine.on(modelConnector.getKey().getNotifier());
			} catch (IncQueryException e) {
				e.printStackTrace();
			}
			modelConnector.getKey().setEngine(engine);
			engineUpdated();
		}
	}

	@Override
	public void partBroughtToTop(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub
	}

	@Override
	public void partClosed(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void partDeactivated(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void partOpened(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void partHidden(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void partVisible(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void partInputChanged(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void dispose() {
		super.dispose();
//		engine.dispose();
	}

	@Override
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		helper.selectionChangedListeners.add(listener);
		System.out.println(listener.toString());
	}

	@Override
	public ISelection getSelection() {
		return helper.unwrapElements_ViewersElementsToEObjects(viewer.getSelection());
	}

	@Override
	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		helper.selectionChangedListeners.remove(listener);
	}

	@Override
	public void setSelection(ISelection selection) {
		this.viewer.setSelection(helper.unwrapElements_EObjectsToViewersElements(selection, state));
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class key) {
		if (key.equals(IPropertySheetPage.class)) {
			return new TabbedPropertySheetPage(this);
		}
		return super.getAdapter(key);
	}

	@Override
	public String getContributorId() {
		return "TreeOutlinePage";
	}
	
	public static void bind(AbstractTreeViewer viewer, ViewerState state) {
		// this seems to be necessary to avoid a databinding-related exception 
		// which comes when the viewer already had some contents before the current run
		if (viewer.getInput()!=null) {
			viewer.setInput(null);
		}
		
		if (viewer.getContentProvider()!=null && viewer.getContentProvider() instanceof TreeContentProvider) {
			// dispose already existing content provider
			((TreeContentProvider)viewer.getContentProvider()).dispose();
		}
		
		if (viewer.getLabelProvider()!=null && viewer.getLabelProvider() instanceof QueryLabelProvider) {
			// dispose already existing label provider
			((QueryLabelProvider)viewer.getLabelProvider()).dispose();
		}
				
		viewer.setContentProvider(new TreeContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider(state));
		viewer.setInput(state);	
		viewer.refresh();
	}
	
	public void clearModelConnector(){
		modelConnector = null;
	}
	
	
	
}
