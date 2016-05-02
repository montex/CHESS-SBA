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
  ------------------------------------------------------------------------------*/package org.polarsys.chess.multicore.dialogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign;
import org.eclipse.papyrus.infra.widgets.Activator;
import org.eclipse.papyrus.infra.widgets.editors.IElementSelectionListener;
import org.eclipse.papyrus.infra.widgets.messages.Messages;
import org.eclipse.papyrus.infra.widgets.providers.CollectionContentProvider;
import org.eclipse.papyrus.infra.widgets.selectors.ReferenceSelector;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.polarsys.chess.multicore.model.CHCore;
import org.polarsys.chess.multicore.utils.QueryUtils;

public class CoreSelectorDialog extends TrayDialog implements
		SelectionListener, ISelectionChangedListener, IDoubleClickListener, IElementSelectionListener {

	public static final int PARTITIONS_TO_CORES = 0;
	public static final int COMPONENTS_TO_CORES = 1;
	public static final int TASKS_TO_CORES = 2;
	
	private EList<CHCore> cores;
	Map<CHCore,  LinkedHashSet<Object>> map;
	private Composite selectorSection;
	private Composite buttonsSection;
	private Button add;
	private Button remove;
	private Button addAll;
	private Button removeAll;
	private Tree selectedElements;
	//private TreeViewer selectedElementsViewer;
	private ILabelProvider labelProvider;
	//@Deprecated
	//protected final Collection<Object> allElements;
	//private TreeViewer treeViewer;
	private ReferenceSelector selector;
	private CHCore partitionSelected;
	private HashMap<CHCore, TreeViewer> selectedElementsViewers;
	private Map<CHCore, LinkedHashSet<Object>> result;

	/**
	 * Open core selector dialog for Assign partition to cores or assign components to cores or assign tasks to cores
	 * @param parentShell
	 * @param referenceSelector
	 * @param cores
	 * @param pack
	 * @param assignments
	 * @param mode PARTITIONS_TO_CORES | COMPONENTS_TO_CORES | TASKS_TO_CORES 
	 * @param title
	 */
	public CoreSelectorDialog(Shell parentShell,
			ReferenceSelector referenceSelector,
			EList<CHCore> cores, org.eclipse.uml2.uml.Package pack, EList<Assign> assignments, int mode, String title) {
		// super(parentShell, selector, title, unique, ordered, upperBound);
		super(parentShell);
		this.cores = cores;
		this.selector = referenceSelector;
		map = new HashMap<CHCore,  LinkedHashSet<Object>>();
		if(mode==PARTITIONS_TO_CORES) {
			for (CHCore core : cores) {
				// LB 20150708 look at assignments that already exist in the model before opening the selector
				LinkedHashSet<Object> theCoresPartitions = QueryUtils.getPartitionsAssigned2Core(core, assignments);
				map.put(core, theCoresPartitions);
				//map.put(core, new LinkedHashSet<Object>());
			}
		}
		if(mode==COMPONENTS_TO_CORES) {
			for (CHCore core : cores) {
				// LB 20150708 look at assignments that already exist in the model before opening the selector
				LinkedHashSet<Object> theCoresComponents = QueryUtils.getComponentsAssigned2Core(core, assignments);
				map.put(core, theCoresComponents);
			}
		}
		if(mode==TASKS_TO_CORES) {
			for (CHCore core : cores) {
				// LB 20150708 look at assignments that already exist in the model before opening the selector
				LinkedHashSet<Object> theCoresTasks = QueryUtils.getTasksAssigned2Core(core, pack, assignments);
				map.put(core, theCoresTasks);
			}
		}
		//this.allElements = new LinkedHashSet<Object>();
		
		selector.addElementSelectionListener(this);
		
		selectedElementsViewers = new HashMap<CHCore, TreeViewer>();
		setTitle(title);
	}

	public static Display getDisplay() {
		Display display = Display.getCurrent();
		// may be null if outside the UI thread
		if (display == null)
			display = Display.getDefault();
		return display;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		GridLayout layout = (GridLayout) parent.getLayout();
		layout.numColumns = 2;
		layout.makeColumnsEqualWidth = true;
		
		

		Composite selectorPane = new Composite(parent, SWT.NONE);
		selectorPane.setLayout(new GridLayout(1, false));
		selectorPane
				.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		final ScrolledComposite sc2 = new ScrolledComposite(parent,
				SWT.V_SCROLL | SWT.BORDER);
		sc2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		sc2.setExpandHorizontal(true);
		sc2.setExpandVertical(true);

		final Composite selectedPane = new Composite(sc2, SWT.NONE);
		selectedPane.setLayout(new GridLayout(1,false));
		selectedPane
				.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, true, true));
		for (CHCore object : cores) {
			Composite selectedPane_ = new Composite(selectedPane, SWT.NONE);
			selectedPane_.setLayout(new GridLayout(2, false));
			selectedPane_.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

			createListSection(object, selectedPane_);
		}
		
		sc2.setContent(selectedPane);
		sc2.setMinSize(sc2.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		

		sc2.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				sc2.setMinSize(sc2.computeSize(SWT.DEFAULT, SWT.DEFAULT));
			}
		});

		createSelectorSection(selectorPane);
		

		return super.createDialogArea(parent);
	}

	private void createSelectorSection(Composite parent) {
		selectorSection = new Composite(parent, SWT.NONE);
		selectorSection.setLayout(new FillLayout());
		selectorSection.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true));
		
		selector.createControls(selectorSection);
		//selector.setSelectedElements(allElements.toArray());

		
	}

	private void createControlsSection(CHCore partition,
			Composite parent) {
		buttonsSection = new Composite(parent, SWT.NONE);
		buttonsSection.setLayout(new GridLayout(1, true));

		add = new Button(buttonsSection, SWT.PUSH);
		add.setImage(Activator.getDefault().getImage("/icons/arrow_right.gif")); //$NON-NLS-1$
		add.addSelectionListener(this);
		add.setToolTipText(Messages.MultipleValueSelectorDialog_AddSelectedElements);
		add.setData(new WidgetData(WidgetData.ADD, partition));

		remove = new Button(buttonsSection, SWT.PUSH);
		remove.setImage(Activator.getDefault()
				.getImage("/icons/arrow_left.gif")); //$NON-NLS-1$
		remove.addSelectionListener(this);
		remove.setToolTipText(Messages.MultipleValueEditor_RemoveSelectedElements);
		remove.setData(new WidgetData(WidgetData.REMOVE, partition));

		addAll = new Button(buttonsSection, SWT.PUSH);
		addAll.setImage(Activator.getDefault().getImage(
				"/icons/arrow_double.gif")); //$NON-NLS-1$
		addAll.addSelectionListener(this);
		addAll.setToolTipText(Messages.MultipleValueSelectorDialog_AddAllElements);
		addAll.setData(new WidgetData(WidgetData.AALL, partition));

		removeAll = new Button(buttonsSection, SWT.PUSH);
		removeAll.setImage(Activator.getDefault().getImage(
				"/icons/arrow_left_double.gif")); //$NON-NLS-1$
		removeAll.addSelectionListener(this);
		removeAll
				.setToolTipText(Messages.MultipleValueSelectorDialog_RemoveAllElements);
		removeAll.setData(new WidgetData(WidgetData.RALL, partition));
	}

	private String getInstanceSpecificationName(
			CHCore instanceSpecification) {
		
		return instanceSpecification.toString();
	}

	private void createListSection(CHCore core,
			Composite parent) {
		
		Label lbl = new Label(parent, SWT.NONE);
		lbl.setText(getInstanceSpecificationName(core));

		GridData lLbl = new GridData(SWT.CENTER, SWT.TOP, true, true, 2, 1);
		// gd_lblNewLabel.horizontalIndent = 1;
		lbl.setLayoutData(lLbl);
		
		createControlsSection(core, parent);

		selectedElements = new Tree(parent, SWT.MULTI | SWT.BORDER
				| SWT.V_SCROLL | SWT.H_SCROLL);
		// selectedElements.addSelectionListener(this);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		selectedElements.setLayoutData(data);
		
		
		TreeViewer selectedElementsViewer = new TreeViewer(selectedElements);

		selectedElementsViewer.addSelectionChangedListener(this);
		selectedElementsViewer.addDoubleClickListener(this);

		selectedElementsViewer
				.setContentProvider(CollectionContentProvider.instance);

		if (labelProvider != null) {
			selectedElementsViewer.setLabelProvider(labelProvider);
		}
		
		selectedElementsViewer.setInput(map.get(core));
		
		selectedElementsViewers.put(core, selectedElementsViewer);

		
		//selector.setSelectedElements(allElements.toArray());

	}

	class WidgetData {
		int type;
		CHCore partition;
		final static int ADD = 1, REMOVE = 2, RALL = 3, AALL = 4;

		public WidgetData(int type, CHCore partition) {
			this.partition = partition;
			this.type = type;
		}
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		Object data = e.widget.getData();
		if (data != null && data instanceof WidgetData) {
			WidgetData wData = (WidgetData) data;
			if (wData.type == WidgetData.ADD) {
				addAction(wData.partition);
			} else if (wData.type == WidgetData.REMOVE) {
				removeAction(wData.partition);
			} else if (wData.type == WidgetData.AALL) {
				addAllAction(wData.partition);
			} else if (wData.type == WidgetData.RALL) {
				removeAllAction(wData.partition);
			}
		}
	}

	

	private void removeAllAction(CHCore partition) {
		TreeViewer selectedElementsViewer = selectedElementsViewers.get(partition);
		
		LinkedHashSet<Object> el = new LinkedHashSet<Object>();
		for (LinkedHashSet<Object> values : map.values()) {
			el.addAll(values);
		}

		
		
		LinkedHashSet<Object> el1 = map.get(partition);			
		
		for(Object element : el1.toArray()) {
			el.remove(element);
			el1.remove(element);
		}
		
		selector.setSelectedElements(el.toArray());
		selectedElementsViewer.setSelection(null);
		selectedElementsViewer.refresh();
	}

	private void addAllAction(CHCore partition) {
		Object[] elements = selector.getAllElements();
		partitionSelected = partition;
		addElements(elements);
	}

	private void removeAction(CHCore partition) {
		TreeViewer selectedElementsViewer = selectedElementsViewers.get(partition);
		
		LinkedHashSet<Object> el = new LinkedHashSet<Object>();
		for (LinkedHashSet<Object> values : map.values()) {
			el.addAll(values);
		}

		IStructuredSelection selection = (IStructuredSelection)selectedElementsViewer.getSelection();
		if(selection.isEmpty()) {
			return;
		}
		
		LinkedHashSet<Object> el1 = map.get(partition);			
		
		for(Object element : selection.toArray()) {
			el.remove(element);
			el1.remove(element);
		}
		
		selector.setSelectedElements(el.toArray());
		selectedElementsViewer.setSelection(null);
		selectedElementsViewer.refresh();
	}

	private void addAction(CHCore partition) {
		Object[] elements = selector.getSelectedElements();
		partitionSelected = partition;
		addElements(elements);
	}
	
	private InstanceSpecification[] getSelectedElements() {
		return null;
		/*ISelection selection = treeViewer.getSelection();

		if(selection instanceof IStructuredSelection) {
			Object[] containerElementsToMove = getElementsToMove(((IStructuredSelection)selection).toArray());
			Object[] semanticElementsToMove = getSemanticElements(containerElementsToMove);
			addSelectedElements(semanticElementsToMove);
			return semanticElementsToMove;
		}

		return new Object[0];*/
	}


	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doubleClick(DoubleClickEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		// TODO Auto-generated method stub

	}

	public void setLabelProvider(ILabelProvider serv) {
		labelProvider = serv;
	}

	public void setMessage(String string) {
		// TODO Auto-generated method stub
	}

	public void setTitle(String string) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addElements(Object[] elements) {
		if(elements != null && partitionSelected != null) {
			
			
			Collection<InstanceSpecification> t = new ArrayList<InstanceSpecification>();
			LinkedHashSet<Object> l = map.get(partitionSelected);
			
			l.addAll(Arrays.asList(elements));
			
			TreeViewer selectedElementsViewer = selectedElementsViewers.get(partitionSelected);
			selectedElementsViewer.refresh();
			
		}		
	}
	
	
	@Override
	protected void okPressed() {
		setResult(map);

		super.okPressed();
	}

	
	protected void setResult(Map<CHCore, LinkedHashSet<Object>> map_) {
		result = map_;
	}

	
	public Map<CHCore, LinkedHashSet<Object>> getResult() {
		return result;
	}
}
