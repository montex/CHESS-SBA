package org.polarsys.chess.cdo.pages;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.cdo.CDOElement;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.CDOResourceLeaf;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.explorer.CDOExplorerUtil;
import org.eclipse.emf.cdo.explorer.checkouts.CDOCheckout;
import org.eclipse.emf.cdo.explorer.ui.checkouts.CDOCheckoutContentProvider;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.uml.diagram.wizards.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.google.common.base.Strings;
import com.google.common.eventbus.EventBus;

/**
 * This is the NewCHESSModelPage type. Enjoy.
 */
public class NewCHESSModelPage extends WizardPage {

	public static final String PAGE_ID = "NewCDOModel"; //$NON-NLS-1$

	private String resourceType = "model";

	private Text folderText;

	private TreeViewer folderViewer;

	private Text nameText;

	private boolean synchronizingFolderSelection;

	private Object selectedElement;

	private boolean selectedElementRevealed;

	private URI newModelResourceURI;

	private String folderRelativePath;

	private String projectName;

	public NewCHESSModelPage(IStructuredSelection selection, EventBus bus, String modelKindName) {
		super(PAGE_ID);

		setTitle(NLS.bind("New CHESS Model", modelKindName));
		setDescription(NLS.bind("Create a new CHESS model", modelKindName));
		setSelection(selection);

		bus.register(this);
	}

	@Override
	public void createControl(Composite parentControl) {
		Composite container = new Composite(parentControl, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(container);
		container.setLayout(new GridLayout(2, false));

		Label label = new Label(container, SWT.NONE);
		label.setText("Enter or select the parent folder:");
		GridDataFactory.swtDefaults().span(2, 1).applyTo(label);

		folderText = new Text(container, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).span(2, 1).applyTo(folderText);
		updateFolderText();

		folderViewer = CDOCheckoutContentProvider.createTreeViewer(container);
		folderViewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		folderViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				if (selectedElementRevealed) {
					IStructuredSelection selection = (IStructuredSelection) event.getSelection();
					setSelection(selection);
				}

				validatePage();
			}
		});

		new Label(container, SWT.NONE).setText("Resource name:");

		nameText = new Text(container, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(nameText);
		nameText.setText(getUniqueName("di")); //$NON-NLS-1$

		setControl(container);

		folderText.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				// TODO: set parent then revealParent()
				validatePage();
			}
		});

		folderViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				setSelection(selection);
				updateFolderText();
				validatePage();
			}
		});

		nameText.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				validatePage();
			}
		});

		parentControl.getShell().getDisplay().asyncExec(new Runnable() {
			@Override
			public void run() {
				revealSelectedElement();
				validatePage();
			}
		});
	}

	public String getNewResourceName() {
		return (nameText == null) ? null : nameText.getText().trim();
	}

	public URI createNewModelResourceURI() {
		return newModelResourceURI;
	}

	public URI createSelectedElementURI() {
		if (selectedElement instanceof CDOCheckout) {
			CDOCheckout checkout = (CDOCheckout) selectedElement;
			return checkout.getURI();
		}

		if (selectedElement instanceof CDOResourceNode) {
			CDOResourceNode resourceNode = (CDOResourceNode) selectedElement;
			return resourceNode.getURI();
		}

		return null;
	}

	/**
	 * Diagram extension changed.
	 *
	 * @param newExtension
	 *            the new extension
	 * @return result of validation of the new extension
	 */
	public IStatus diagramExtensionChanged(String newExtension) {
		String currentExtension = getExtension();
		if (!newExtension.equals(currentExtension)) {

			String oldFileName = getNewResourceName();
			String base = oldFileName;
			if (currentExtension != null) {
				// take one off for the '.'
				base = base.substring(0, base.length() - currentExtension.length() - 1);
			}
			String newFileName = getUniqueName(newExtension);

			setNewResourceName(newFileName);

			String message1 = org.eclipse.papyrus.uml.diagram.wizards.Messages.NewModelFilePage_new_diagram_category_needs_specific_extension;
			String message2 = NLS.bind(org.eclipse.papyrus.uml.diagram.wizards.Messages.NewModelFilePage_diagram_file_was_renamed, oldFileName, newFileName);
			String message = message1 + message2;
			Status resultStatus = new Status(IStatus.INFO, Activator.PLUGIN_ID, message);

			String errorMessage = getErrorMessage();
			if (errorMessage != null) {
				resultStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, errorMessage);
			}
			return resultStatus;
		}
		return Status.OK_STATUS;
	}

	protected void setNewResourceName(String newName) {
		nameText.setText(newName.trim());
	}

	protected void validatePage() {
		newModelResourceURI = null;
		setMessage(null, NONE);
		setPageComplete(true);

		String folder = folderText.getText().trim();
		if (Strings.isNullOrEmpty(folder)) {
			setPageComplete(false);
			return;
		}

		String[] segments = getSegments(folder);
		CDOCheckout checkout = CDOExplorerUtil.getCheckoutManager().getCheckoutByLabel(segments[0]);
		if (checkout == null) {
			setMessage(NLS.bind("The selected checkout does not exist.", segments[0]), ERROR);
			setPageComplete(false);
			return;
		}

		CDOView view = checkout.getView();
		String path = "";
		SegmentType segmentType = SegmentType.FOLDER; // The checkout is treated like a folder.

		for (int i = 1; i < segments.length; i++) {
			String segment = segments[i];
			path += "/";
			path += segment;

			segmentType = SegmentType.of(view, path);
			if (segmentType == SegmentType.OTHER) {
				setMessage("The specified folder cannot be created.", ERROR);
				setPageComplete(false);
				return;
			}
		}

		String name = getNewResourceName();
		if (Strings.isNullOrEmpty(name)) {
			setMessage("The new model resource name is required.", ERROR);
			setPageComplete(false);
			return;
		}
		
		if (segmentType != SegmentType.MISSING) {
			String fullPath = path + "/" + name;
			if (SegmentType.of(view, fullPath) != SegmentType.MISSING) {
				setMessage(NLS.bind("The resource already exists.", fullPath), ERROR);
				setPageComplete(false);
				return;
			}
		}
		//TODO work in progress!!
		String folderName = name.substring(0, name.lastIndexOf("."));
		path = path.concat("/" + folderName.substring(0, 1).toUpperCase() + folderName.substring(1)); 
		
		newModelResourceURI = checkout.createResourceURI(path).appendSegment(name);
		folderRelativePath = path;
		projectName = folderName;

		if (segmentType == SegmentType.MISSING) {
			setMessage("The specified folder does not exist and will be created.", WARNING);
		}
	}

	private String[] getSegments(String folder) {
		while (folder.startsWith("/")) {
			folder = folder.substring(1);
		}

		while (folder.endsWith("/")) {
			folder = folder.substring(0, folder.length() - 1);
		}

		return folder.split("/");
	}

	private String getExtension() {
		String result = null;
		String name = getNewResourceName();

		if (name != null) {
			// the proper extension is whatever follows the *last* '.',
			// but for our purposes we need e.g. "profile.uml" to be
			// an extension
			int dot = name.indexOf('.');
			if (dot >= 0) {
				result = name.substring(dot + 1);
			}
		}

		return result;
	}

	private void setSelection(IStructuredSelection selection) {
		selectedElement = null;

		if (!selection.isEmpty()) {
			Object element = selection.getFirstElement();
			if (element instanceof CDOElement) {
				element = ((CDOElement) element).getDelegate();
			}

			if (element instanceof CDOCheckout) {
				selectedElement = element;
			} else if (element instanceof CDOResourceLeaf) {
				selectedElement = ((CDOResourceLeaf) element).getFolder();
			} else if (element instanceof CDOResourceFolder) {
				selectedElement = (CDOResourceFolder) element;
			} else if (element instanceof EObject) {
				Resource resource = ((EObject) element).eResource();
				if (resource instanceof CDOResource) {
					selectedElement = ((CDOResource) resource).getFolder();
				}
			}
		}
	}

	private void updateFolderText() {
		if (!synchronizingFolderSelection) {
			synchronizingFolderSelection = true;

			try {
				if (selectedElement == null) {
					folderText.setText(""); //$NON-NLS-1$
				} else {
					StringBuilder builder = new StringBuilder();
					for (Object node : getSelectedSegments()) {
						builder.append('/');
						builder.append(CDOExplorerUtil.getName(node));
					}

					String path = builder.toString();
					folderText.setText(path);
				}
			} finally {
				synchronizingFolderSelection = false;
			}
		}
	}

	private void revealSelectedElement() {
		if (selectedElement != null) {
			List<Object> segments = getSelectedSegments();
			for (int i = 0; i < segments.size() - 1; i++) {
				Object segment = segments.get(i);
				folderViewer.setExpandedState(segment, true);
			}

			selectedElementRevealed = true;
			folderViewer.setSelection(new StructuredSelection(selectedElement), true);
		}
	}

	private List<Object> getSelectedSegments() {
		List<Object> segments = new ArrayList<Object>();
		fillSegments(segments, selectedElement);
		return segments;
	}

	private void fillSegments(List<Object> segments, Object element) {
		if (element instanceof CDOCheckout) {
			segments.add(element);
			return;
		}

		if (element instanceof CDOResourceFolder) {
			CDOResourceFolder folder = (CDOResourceFolder) element;

			Adapter adapter = EcoreUtil.getAdapter(folder.eAdapters(), CDOCheckout.class);
			if (adapter != null) {
				fillSegments(segments, adapter);
			} else {
				Object parent = folder.getFolder();
				if (parent == null) {
					parent = EcoreUtil.getAdapter(folder.cdoView().getRootResource().eAdapters(), CDOCheckout.class);
				}

				fillSegments(segments, parent);
			}
		}

		segments.add(element);
	}

	private EList<EObject> getChildrenOfSelectedElement() {
		if (selectedElement instanceof CDOCheckout) {
			CDOCheckout checkout = (CDOCheckout) selectedElement;
			return checkout.getRootObject().eContents();
		}

		if (selectedElement instanceof CDOResourceFolder) {
			CDOResourceFolder folder = (CDOResourceFolder) selectedElement;
			return folder.eContents();
		}

		return ECollections.emptyEList();
	}

	private String getUniqueName(String extension) {
		Set<String> names = new HashSet<String>();
		for (EObject eObject : getChildrenOfSelectedElement()) {
			if (eObject instanceof CDOResourceNode) {
				CDOResourceNode node = (CDOResourceNode) eObject;
				String name = node.getName();
				if (name.startsWith(resourceType)) {
					names.add(name);
				}
			}
		}

		for (int i = 1; i < Integer.MAX_VALUE; i++) {
			String name = resourceType + (i > 1 ? i : "") + "." + extension;
			if (!names.contains(name)) {
				return name;
			}
		}

		throw new IllegalStateException("Too many children");
	}

	/**
	 * @author Stepper
	 */
	private enum SegmentType {
		MISSING, FOLDER, OTHER;

		public static SegmentType of(CDOView view, String path) {
			CDOResourceNode resourceNode;
			try {
				resourceNode = view.getResourceNode(path);
				if (resourceNode != null) {
					if (resourceNode instanceof CDOResourceFolder) {
						return SegmentType.FOLDER;
					}

					return SegmentType.OTHER;
				}
			} catch (Exception ex) {
				//$FALL-THROUGH$
			}

			return SegmentType.MISSING;
		}

		private static SegmentType of(CDOResourceNode resourceNode) {
			if (resourceNode == null) {
				return SegmentType.MISSING;
			}

			if (resourceNode instanceof CDOResourceFolder) {
				return SegmentType.FOLDER;
			}

			return SegmentType.OTHER;
		}
	}

	public String getFolderRelativePath() {
		return folderRelativePath;
	}
	
	public String getProjectName() {
		return projectName;
	}
}
