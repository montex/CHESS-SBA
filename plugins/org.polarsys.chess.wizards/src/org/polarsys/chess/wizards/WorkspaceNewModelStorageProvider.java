package org.polarsys.chess.wizards;

import static org.eclipse.papyrus.uml.diagram.wizards.utils.WizardsHelper.adapt;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.papyrus.uml.diagram.wizards.pages.NewModelFilePage;
import org.eclipse.papyrus.uml.diagram.wizards.utils.WizardsHelper;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.part.FileEditorInput;
import org.polarsys.chess.wizards.InitModelWizard.NewDiagramForExistingModelPage;

public class WorkspaceNewModelStorageProvider {

	private CreateCHESSModelWizard wizard;

	private NewModelFilePage newModelFilePage;

	public WorkspaceNewModelStorageProvider() {
		super();
	}

	public boolean canHandle(IStructuredSelection initialSelection) {
		boolean result = false;

		for(Object next : initialSelection.toList()) {
			if(adapt(next, IResource.class) != null) {
				result = true;
				break;
			}
		}

		return result;
	}

	public void init(CreateCHESSModelWizard wizard, IStructuredSelection selection) {
		this.wizard = wizard;
		newModelFilePage = createNewModelFilePage(selection);
	}

	public List<? extends IWizardPage> createPages() {
		if(newModelFilePage == null) {
			return Collections.emptyList();
		}

		return Arrays.asList(newModelFilePage);
	}

	public IStatus validateDiagramCategories(String... newCategories) {
		if(newModelFilePage != null) {
			String firstCategory = newCategories.length > 0 ? newCategories[0] : null;
			if(newCategories.length > 0) {
				return newModelFilePage.diagramExtensionChanged(wizard.getDiagramFileExtension(firstCategory));
			}
		}

		return Status.OK_STATUS;
	}


	protected NewModelFilePage createNewModelFilePage(IStructuredSelection selection) {

		if(wizard.isCreateProjectWizard() || wizard.isCreateMultipleModelsWizard()) {

			return null;
		}

		//		IFile selectedFile = getSelectedFile(selection);
		URI selectedResourceURI = WizardsHelper.getSelectedResourceURI(selection);

		if(isCreateFromExistingDomainModel() && selectedResourceURI != null) {
			return new NewDiagramForExistingModelPage(selection, wizard.getModelKindName(), getDiagramFileName(selectedResourceURI) + "." + wizard.getDiagramFileExtension(null), wizard.getDiagramFileExtension(null)); //$NON-NLS-1$
		}

		return new NewModelFilePage(selection, wizard.getModelKindName());
	}

	protected String getDiagramFileName(URI domainModelURI) {
		return domainModelURI.trimFileExtension().lastSegment();
	}

	protected boolean isCreateFromExistingDomainModel() {
		return false;
	}

	public URI createNewModelURI(String categoryId) {
		IFile newFile = newModelFilePage.createNewFile();
		return (newFile == null) ? null : URI.createPlatformResourceURI(newFile.getFullPath().toString(), true);
	}
	
	public IEditorInput createEditorInput(URI uri) {
		if (uri.isPlatformResource()) {
			return new FileEditorInput(ResourcesPlugin.getWorkspace().getRoot()
				.getFile(new Path(uri.toPlatformString(true))));
		} else {
			return new URIEditorInput(uri);
		}
	}

}
