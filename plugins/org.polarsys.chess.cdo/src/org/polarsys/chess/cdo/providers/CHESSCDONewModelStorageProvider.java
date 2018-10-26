package org.polarsys.chess.cdo.providers;

import static org.eclipse.papyrus.uml.diagram.wizards.utils.WizardsHelper.adapt;
import static org.eclipse.papyrus.uml.diagram.wizards.utils.WizardsHelper.getSelectedResourceURI;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.explorer.CDOExplorerUtil;
import org.eclipse.emf.cdo.explorer.checkouts.CDOCheckout;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.papyrus.cdo.internal.ui.editors.PapyrusCDOEditorInput;
import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectDiagramCategoryPage;
import org.eclipse.papyrus.uml.diagram.wizards.providers.AbstractNewModelStorageProvider;
import org.eclipse.papyrus.uml.diagram.wizards.wizards.CreateModelWizard;
import org.eclipse.papyrus.uml.diagram.wizards.wizards.InitModelWizard;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.INewWizard;
import org.polarsys.chess.cdo.pages.NewCHESSModelPage;
import org.polarsys.chess.cdo.wizards.CreateCDOCHESSModelWizard;
import org.polarsys.chess.wizards.wizards.CreateCHESSModelWizard;

import com.google.common.eventbus.EventBus;


public class CHESSCDONewModelStorageProvider extends AbstractNewModelStorageProvider {

	private final EventBus bus = new EventBus("NewCDOModelWizard"); //$NON-NLS-1$

	private CreateCDOCHESSModelWizard wizard;

	private SelectDiagramCategoryPage newDiagramCategoryPage;

	private NewCHESSModelPage newModelPage;

	private IStructuredSelection selection;

	public CHESSCDONewModelStorageProvider() {
		super();
	}

	@Override
	public boolean canHandle(IStructuredSelection initialSelection) {
		for (Object next : initialSelection.toList()) {
			if (CDOUtils.isCDOObject(adapt(next, EObject.class))) {
				return true;
			}

			if (adapt(next, CDOCheckout.class) != null) {
				return true;
			}
		}

		return false;
	}

	public void init(CreateCDOCHESSModelWizard wizard, IStructuredSelection selection) {
//		super.init(wizard, selection);

		this.wizard = wizard;
		this.selection = selection;
		newModelPage = createNewModelPage(selection);
		createSelectProviderPart();

		CDOCheckout checkout = getRepository(selection);
		if (checkout != null) {
			bus.post(checkout);
		}

//		newDiagramCategoryPage = createNewDiagramCategoryPage(selection);
	}

	/**
	 * Gets the contextual repository, if any, from a selection.
	 *
	 * @param selection
	 *            a selection
	 *
	 * @return the repository that is or contains the {@code selection}
	 */
	static CDOCheckout getRepository(IStructuredSelection selection) {
		CDOCheckout result = null;

		if (!selection.isEmpty()) {
			result = adapt(selection.getFirstElement(), CDOCheckout.class);
			if (result == null) {
				CDOResourceNode node = adapt(selection.getFirstElement(), CDOResourceNode.class);
				if (node == null) {
					EObject object = adapt(selection.getFirstElement(), EObject.class);
					if (object != null) {
						CDOObject cdo = CDOUtils.getCDOObject(object);
						if (cdo != null) {
							node = cdo.cdoResource();
						}
					}
				}

				if (node != null) {
					result = CDOExplorerUtil.getCheckout(node.getURI());
				}
			}
		}

		return result;
	}

	@Override
	public List<? extends IWizardPage> createPages() {
		if (newModelPage == null && newDiagramCategoryPage == null) {
			return Collections.emptyList();
		}

		return Arrays.asList(newDiagramCategoryPage, newModelPage);
	}

	@Override
	public SelectDiagramCategoryPage getDiagramCategoryPage() {
		return newDiagramCategoryPage;
	}

	@Override
	public IStatus validateDiagramCategories(String... newCategories) {
		if (newModelPage != null && newModelPage.getNewResourceName() != null) {
			String firstCategory = newCategories.length > 0 ? newCategories[0] : null;
			if (newCategories.length > 0) {
				// 316943 - [Wizard] Wrong suffix for file name when creating a
				// profile model
				return newModelPage.diagramExtensionChanged(wizard.getDiagramFileExtension(firstCategory));
			}
		}

		return super.validateDiagramCategories(newCategories);
	}

	/**
	 * Creates the new model page, if required.
	 *
	 * @param selection
	 *            the selection
	 *
	 * @return the new model page, or {@code null} if none
	 */
	protected NewCHESSModelPage createNewModelPage(IStructuredSelection selection) {
		if (wizard.isCreateProjectWizard() || wizard.isCreateMultipleModelsWizard()) {

			return null;
		}

		if (isCreateFromExistingDomainModel()) {
			URI uri = getSelectedResourceURI(selection);
			if (uri != null) {
				uri = uri.trimFileExtension().appendFileExtension(wizard.getDiagramFileExtension(null));
				return new NewDiagramForExistingModelPage(selection, wizard.getModelKindName(), bus, uri.lastSegment());
			}
		}

		return new NewCHESSModelPage(selection, bus, wizard.getModelKindName());
	}

	protected boolean isCreateFromExistingDomainModel() {
		return false;
	}

	@Override
	public URI createNewModelURI(String categoryId) {
		return newModelPage.createNewModelResourceURI();
	}

	@Override
	public IEditorInput createEditorInput(URI uri) {
		return new PapyrusCDOEditorInput(uri, uri.trimFileExtension().lastSegment());
	}

//	private SelectDiagramCategoryPage createNewDiagramCategoryPage(IStructuredSelection selection) {
//		if (wizard.isCreateProjectWizard() || wizard.isCreateMultipleModelsWizard() || !wizard.isPapyrusRootWizard()) {
//			return null;
//		}
//
//		return new SelectDiagramCategoryPage();
//	}


	//
	// Nested types
	//

	/**
	 * This is the NewDiagramForExistingModelPage type. Enjoy.
	 */
	protected static class NewDiagramForExistingModelPage extends NewCHESSModelPage {

		/** The my diagram resource name. */
		private final String myDiagramResourceName;

		/**
		 * Instantiates a new new diagram for existing model page.
		 *
		 * @param selection
		 *            the selection
		 * @param modelKindName
		 *            the user-presentable (translatable) name of the kind of
		 *            model to create
		 * @param bus
		 *            an event bus for posting events
		 * @param defaultResourceName
		 *            the default resource name
		 */
		public NewDiagramForExistingModelPage(IStructuredSelection selection, String modelKindName, EventBus bus, String defaultResourceName) {

			super(selection, bus, modelKindName);

			myDiagramResourceName = defaultResourceName;
			setTitle("Init a new Papyrus model");
			setDescription("Init a new Papyrus model from the existing domain model");
		}

		@Override
		public void createControl(Composite parent) {
			super.createControl(parent);

			setNewResourceName(myDiagramResourceName);
		}

		@Override
		protected void validatePage() {
			super.validatePage();

			if (getMessageType() < ERROR) {
				if (!myDiagramResourceName.equals(getNewResourceName())) {
					setMessage(NLS.bind(org.eclipse.papyrus.uml.diagram.wizards.Messages.InitModelWizard_diagram_name_is_different_from_domain_model, myDiagramResourceName), ERROR);
					setPageComplete(false);
				}
			}
		};
	}
	
	public String getFolderRelativePath(){
		return newModelPage.getFolderRelativePath();		
	}
	
	public String getProjectName(){
		return newModelPage.getProjectName();		
	}
}
