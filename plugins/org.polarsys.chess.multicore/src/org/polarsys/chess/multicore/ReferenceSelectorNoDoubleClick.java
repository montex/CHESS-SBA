/*------------------------------------------------------------------------------
  -
  - Copyright (c) 2015-2016 University of Padova, ITALY -  Intecs SpA 
  - All rights reserved. This program and the accompanying materials
  - are made available under the terms of the Eclipse Public License v1.0
  - which accompanies this distribution, and is available at
  - http://www.eclipse.org/legal/epl-v10.html
  -
  - Contributors:
  -
  - Alessandro Zovi azovi@math.unipd.it
  - Stefano Puri stefano.puri@intecs.it
  - Laura Baracchi laura.baracchi@intecs.it
  - Nicholas Pacini nicholas.pacini@intecs.it  
  -
  - Initial API and implementation and/or initial documentation
  ------------------------------------------------------------------------------*/package org.polarsys.chess.multicore;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;
import org.eclipse.papyrus.infra.widgets.providers.EncapsulatedContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IGraphicalContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.selectors.ReferenceSelector;
import org.eclipse.papyrus.infra.widgets.strategy.ProviderBasedBrowseStrategy;
import org.eclipse.papyrus.infra.widgets.strategy.StrategyBasedContentProvider;
import org.eclipse.papyrus.infra.widgets.strategy.TreeBrowseStrategy;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.polarsys.chess.multicore.model.CHTask;


/**
 * A copy of the ReferenceSelector class where the treeViewer does not have
 * 
 * any IDoubleClickListener instance
 * 
 * @author Alessandro Zovi
 * 
 */
public class ReferenceSelectorNoDoubleClick extends ReferenceSelector {
	private EList<InstanceSpecification> instSpecNotYetAssignedToPartition;
	private EList<CHTask> taskNotYetAssignedToPartition;
	
	public ReferenceSelectorNoDoubleClick(boolean unique) {
		super(unique);
	}
	
	public ReferenceSelectorNoDoubleClick(boolean unique,
			EList<InstanceSpecification> instSpecNotYetAssignedToPartition,
			EList<CHTask> taskNotYetAssignedToPartition) {
		super(unique);
		this.instSpecNotYetAssignedToPartition = instSpecNotYetAssignedToPartition;
		this.taskNotYetAssignedToPartition = taskNotYetAssignedToPartition;
	}
	
	/**
	 * Refreshes this selector's {@link org.eclipse.swt.widgets.List}
	 */
	@Override
	public void refresh() {
		((CustomSelectionFilteredBrowseStrategy) contentProvider.getBrowseStrategy()).refresh();
		treeViewer.refresh();
	}
	
	@Override
	public void setContentProvider(IStaticContentProvider staticContentProvider) {
		ITreeContentProvider provider = new EncapsulatedContentProvider(staticContentProvider);

		TreeBrowseStrategy filteredBrowseStrategy = new CustomSelectionFilteredBrowseStrategy(provider);

		TreeBrowseStrategy revealBrowseStrategy = new ProviderBasedBrowseStrategy(provider);

		this.contentProvider = new StrategyBasedContentProvider(filteredBrowseStrategy, revealBrowseStrategy);

		if (treeViewer != null) {
			treeViewer.setContentProvider(contentProvider);
			treeViewer.setInput(""); //$NON-NLS-1$
		}

		if (contentProvider instanceof ICommitListener) {
			commitListeners.add(contentProvider);
		}
	}
	
	/* LB 20150708
	 * CustomSelectionFilteredBrowseStrategy was introduced for managing correctly the 
	 * visualization in the selector of only Inst Specs or Tasks that are not 
	 * already assigned to partitions or cores (even the first time the panel is opened)
	 */
	private class CustomSelectionFilteredBrowseStrategy extends ProviderBasedBrowseStrategy {

		public CustomSelectionFilteredBrowseStrategy(ITreeContentProvider provider) {
			super(provider);
		}

		@Override
		public boolean isValidValue(Object element) {
			if (!unique) {
				return super.isValidValue(element);
			}

			if (!super.isValidValue(element)) {
				return false;
			}
			
			if(instSpecNotYetAssignedToPartition!=null && !instSpecNotYetAssignedToPartition.contains(element)){								
				instSpecNotYetAssignedToPartition.add((InstanceSpecification) element);
				selectedElements.add((InstanceSpecification) element);
				return false;				
			}
			if(taskNotYetAssignedToPartition!=null && !taskNotYetAssignedToPartition.contains(element)){								
				taskNotYetAssignedToPartition.add((CHTask) element);
				selectedElements.add((CHTask) element);
				return false;				
			}
			return !selectedElements.contains(getAdaptedValue(element));
		}

		public void refresh() {
			if (unique) {
				clearCache();
			}
		}
	}
	
	
	@Override
	public void createControls(Composite parent) {
		Composite content = new Composite(parent, SWT.NONE);
		content.setLayout(new GridLayout(1, true));

		treeViewer = new TreeViewer(content, SWT.BORDER | SWT.MULTI);
		treeViewer.setFilters(new ViewerFilter[]{ new PatternFilter() });

		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.minimumHeight = 300;
		data.minimumWidth = 300;
		treeViewer.getTree().setLayoutData(data);

		if(labelProvider != null) {
			treeViewer.setLabelProvider(labelProvider);
		}

		if(contentProvider != null) {
			treeViewer.setContentProvider(contentProvider);
			treeViewer.setInput(""); //$NON-NLS-1$
		}

		if(contentProvider instanceof IGraphicalContentProvider) {
			IGraphicalContentProvider graphicalContentProvider = contentProvider;

			Composite beforeTreeComposite = new Composite(content, SWT.NONE);
			beforeTreeComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
			FillLayout layout = new FillLayout();
			layout.marginHeight = 0;
			layout.marginWidth = 0;
			beforeTreeComposite.setLayout(layout);
			graphicalContentProvider.createBefore(beforeTreeComposite);

			beforeTreeComposite.moveAbove(treeViewer.getTree());

			Composite afterTreeComposite = new Composite(content, SWT.NONE);
			layout = new FillLayout();
			layout.marginHeight = 0;
			layout.marginWidth = 0;
			afterTreeComposite.setLayout(layout);
			afterTreeComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
			graphicalContentProvider.createAfter(afterTreeComposite);
		}
	}
}
