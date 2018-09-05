package org.polarsys.chess.paramArchConfigurator.ui.wizard;


import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;
import org.eclipse.papyrus.infra.widgets.providers.IAdaptableContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IGraphicalContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IHierarchicContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;


public class TreeSelector {

	private ILabelProvider labelProvider;

	private ITreeContentProvider contentProvider;

	private TreeViewer treeViewer;

	private Composite composite;

	private Object input = null;

	// the final collection of selected elements, or null if this dialog was
		// canceled
		private Object[] result;

	
	private final Set<ICommitListener> commitListeners = new HashSet<ICommitListener>();

	/**
	 *
	 * Constructor.
	 *
	 * @param parentShell
	 *            The parent shell in which this dialog will be opened
	 */
	public TreeSelector(Composite composite) {
		this.composite = composite;
	}

	/**
	 * Sets the label provider for this dialog
	 *
	 * @param provider
	 */
	
	public void setLabelProvider(ILabelProvider provider) {
		labelProvider = provider;
		if (treeViewer != null) {
			treeViewer.setLabelProvider(labelProvider);
		}
	}

	/**
	 * Sets the ContentProvider for this dialog
	 * The ContentProvider may be a {@link IHierarchicContentProvider}
	 *
	 * @param provider
	 *            The content provider for this dialog. May be a {@link IHierarchicContentProvider}
	 */
	
	public void setContentProvider(ITreeContentProvider provider) {
		contentProvider = provider;
		if (treeViewer != null) {
			initViewerAndProvider();
		}
		if (contentProvider instanceof ICommitListener) {
			commitListeners.add((ICommitListener) contentProvider);
		}
	}

	protected void initViewerAndProvider() {
		treeViewer.setContentProvider(contentProvider);
		if (treeViewer.getInput() == null) {
			doSetInput();
		}
	}

	
	protected Composite getDialogArea() {
		return (Composite) composite;
	}

	
	public void create() {
	

	
		treeViewer = new TreeViewer(getDialogArea(), SWT.BORDER);
		// treeViewer.setFilters(new ViewerFilter[]{ new PatternFilter() });

		if (labelProvider != null) {
			treeViewer.setLabelProvider(labelProvider);
		}
		if (contentProvider != null) {
			initViewerAndProvider();
		}
		treeViewer.addFilter(new PackageViewFilter());
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = event.getSelection();

				Object selectedElement = null;
				if (selection instanceof IStructuredSelection && !selection.isEmpty()) {
					IStructuredSelection sSelection = (IStructuredSelection) selection;
					selectedElement = sSelection.getFirstElement();
				}

				if (contentProvider instanceof IHierarchicContentProvider) {
					boolean isValidValue = ((IHierarchicContentProvider) contentProvider).isValidValue(selectedElement);
					if (contentProvider instanceof IAdaptableContentProvider) {
						selectedElement = ((IAdaptableContentProvider) contentProvider).getAdaptedValue(selectedElement);
					}
				if (isValidValue) {
						setResult(Collections.singletonList(selectedElement));
					} else {
						setResult(Collections.emptyList());
					}
					//getOkButton().setEnabled(isValidValue);*/
				}
			}
		});

		treeViewer.addDoubleClickListener(new IDoubleClickListener() {

			@Override
			public void doubleClick(DoubleClickEvent event) {
			/*	if (getOkButton().isEnabled()) {
					okPressed();
				}*/
			}

		});

		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.minimumHeight = 300;
		data.minimumWidth = 300;
		treeViewer.getTree().setLayoutData(data);

		if (contentProvider instanceof IGraphicalContentProvider) {
			IGraphicalContentProvider graphicalContentProvider = (IGraphicalContentProvider) contentProvider;

			Composite beforeTreeComposite = new Composite(getDialogArea(), SWT.NONE);
			beforeTreeComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
			beforeTreeComposite.setLayout(new FillLayout());
			graphicalContentProvider.createBefore(beforeTreeComposite);

			beforeTreeComposite.moveAbove(treeViewer.getTree());

			//Composite afterTreeComposite = new Composite(getDialogArea(), SWT.NONE);
			//afterTreeComposite.setLayout(new FillLayout());
			//afterTreeComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
			//graphicalContentProvider.createAfter(afterTreeComposite);
		}

	/*	List<?> initialSelection = new ArrayList<String>();
		if (contentProvider instanceof IRevealSemanticElement) {
			((IRevealSemanticElement) contentProvider).revealSemanticElement(initialSelection);
		} else if (!initialSelection.isEmpty()) {
			// even if the encapsulated provider is not a IRevealSemanticElement
			treeViewer.setSelection(new StructuredSelection(initialSelection.get(0)), true);
		}*/

		
	}


	/**
	 * Get the TreeViewer used by this dialog
	 *
	 * @return
	 *         The TreeViewer associated to this dialog
	 */
	protected TreeViewer getViewer() {
		return treeViewer;
	}

	/**
	 * Sets the input object for this dialog's TreeViewer
	 *
	 * @param input
	 */

	public void setInput(Object input) {
		this.input = input;
	}

	private void doSetInput() {
		if (input == null) {
			// Default non-null input for IStaticContentProvider (input-independent)
			treeViewer.setInput(""); //$NON-NLS-1$
		} else {
			treeViewer.setInput(input);
		}
	}

	
	protected void setResult(List<Object> newResult) {
		if (newResult == null) {
			result = null;
		} else {
			result = new Object[newResult.size()];
			newResult.toArray(result);
		}
	}

	public Object[] getResult() {
		return result;
	}

	
	
}
