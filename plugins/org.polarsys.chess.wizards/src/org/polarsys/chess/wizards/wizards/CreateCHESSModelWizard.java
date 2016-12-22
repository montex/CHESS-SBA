/*
-----------------------------------------------------------------------
--          			CHESS core plugin							 --
--                                                                   --
--                    Copyright (C) 2011-2012                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- Author: Alessandro Zovi         azovi@math.unipd.it 		         --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------

*/



package org.polarsys.chess.wizards.wizards;

import static org.polarsys.chess.wizards.Activator.log;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.editor.BackboneException;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModelUtils;
import org.eclipse.papyrus.infra.core.sashwindows.di.service.IPageManager;
import org.eclipse.papyrus.infra.core.services.ExtensionServicesRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.ui.extension.commands.IModelCreationCommand;
import org.eclipse.papyrus.infra.ui.util.EditorUtils;
import org.eclipse.papyrus.uml.diagram.wizards.category.DiagramCategoryDescriptor;
import org.eclipse.papyrus.uml.diagram.wizards.category.DiagramCategoryRegistry;
import org.eclipse.papyrus.uml.diagram.wizards.category.NewPapyrusModelCommand;
import org.eclipse.papyrus.uml.diagram.wizards.pages.NewModelFilePage;
import org.eclipse.papyrus.uml.diagram.wizards.utils.SettingsHelper;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.polarsys.chess.core.util.commands.InitCHESSModelCommand;
import org.polarsys.chess.wizards.Activator;
import org.polarsys.chess.wizards.providers.WorkspaceNewModelStorageProvider;

/**
 * The Class CreateCHESSModelWizard is the implementation of the wizard used to create a new CHESS model
 */
public class CreateCHESSModelWizard extends Wizard implements INewWizard {

	/** The Constant WIZARD_ID. */
	public static final String WIZARD_ID = "org.eclipse.papyrus.uml.diagram.wizards.createmodel"; //$NON-NLS-1$

	/** The Constant NEW_MODEL_SETTINGS. */
	public static final String NEW_MODEL_SETTINGS = "NewModelWizard"; //$NON-NLS-1$

	/** The workbench. */
	private IWorkbench workbench;

	/** The selected storage provider. */
	private WorkspaceNewModelStorageProvider selectedStorageProvider; 
	
	/** The provider pages. */
	private Map<WorkspaceNewModelStorageProvider, List<IWizardPage>> providerPages = new java.util.HashMap<WorkspaceNewModelStorageProvider, List<IWizardPage>>();
	
	/** The providers by page. */
	private Map<IWizardPage, WorkspaceNewModelStorageProvider> providersByPage = new java.util.HashMap<IWizardPage, WorkspaceNewModelStorageProvider>();
	
	/** The start provider page index. */
	private int startProviderPageIndex;
	
	/** The end provider page index. */
	private int endProviderPageIndex; 
	
	/**
	 * Creates a new chess model wizard.
	 */
	public CreateCHESSModelWizard() {
		super();
		setWindowTitle("New CHESS Model");
	}

	/**
	 * Adds pages to the wizard 
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		startProviderPageIndex = getPageCount() - 1;
			List<IWizardPage> pageList = new java.util.ArrayList<IWizardPage>(3);
			for (IWizardPage page : selectedStorageProvider.createPages()) {
				if (page != null)  {
					pageList.add(page);
					providersByPage.put(page, selectedStorageProvider);
					addPage(page);
				}
			}
			providerPages.put(selectedStorageProvider, pageList);
		endProviderPageIndex = getPageCount();
	}

	/**
	 * Adds the page to the wizards if it is not null.
	 *
	 * @param page the page to be added
	 */
	protected final void addPageIfNotNull(IWizardPage page) {
		if(page != null) {
			addPage(page);
		}
	}

	/**
	 * Checks if is the wizard initializes the model.
	 *
	 * @return always false
	 */
	public boolean isInitModelWizard() {
		return false;
	}
	
	/**
	 * Checks if is the wizard creates the project.
	 *
	 * @return always false
	 */
	public boolean isCreateProjectWizard() {
		return false;
	}
	
	/**
	 * Checks if is the wizard creates multiple models.
	 *
	 * @return always false
	 */
	public boolean isCreateMultipleModelsWizard() {
		return false;
	}
	
	/**
	 * 
	 * 
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;

		initStorageProvider(workbench, selection);
		
		IDialogSettings workbenchSettings = Activator.getDefault()
			.getDialogSettings();
		IDialogSettings section = workbenchSettings
			.getSection(NEW_MODEL_SETTINGS);
		if (section == null) {
			section = workbenchSettings.addNewSection(NEW_MODEL_SETTINGS);
		}
		setDialogSettings(section);

		
		selectedStorageProvider.init(this, selection);
	}

	/**
	 * 
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		String[] diagramCategoryIds = getDiagramCategoryIds();
		if (diagramCategoryIds.length == 0) {
			return false;
		}
		String diagramCategoryId = diagramCategoryIds[0];
		final URI newURI = createNewModelURI(diagramCategoryId);

		createAndOpenCHESSModel(newURI, diagramCategoryId);

		return true;
	}

	/**
	 * Creates the new model URI.
	 *
	 * @param diagramCategoryID the diagram category id
	 * @return the URI of the new model
	 */
	protected URI createNewModelURI(String diagramCategoryID) {
		return selectedStorageProvider.createNewModelURI(diagramCategoryID);
	}
	
	/**
	 * Creates and opens the CHESS model.
	 *
	 * @param newURI the URI of the CHESS model to be created
	 * @param diagramCategoryId the diagram category id
	 * @return true, if successful
	 */
	protected boolean createAndOpenCHESSModel(URI newURI, String diagramCategoryId) {
		
		if (newURI == null) {
			return false;
		}
		
		ServicesRegistry registry = createServicesRegistry();
		if (registry == null) {
			return false;
		}

		try {
			ModelSet modelSet = registry.getService(ModelSet.class);
			
			createPapyrusModels(modelSet, newURI);
	
			initServicesRegistry(registry);
			
			initDomainModel(modelSet, newURI, diagramCategoryId);
	
			initDiagramModel(modelSet, diagramCategoryId);
	
			openDiagram(newURI);
		} catch (ServiceException e) {
			Activator.log.error(e);
			return false;
		} finally {
			try {
				registry.disposeRegistry();
			} catch (ServiceException ex) {
				// Ignore
			}
		}
		
		return true;
	}

	/**
	 * Creates the services registry.
	 *
	 * @return the new services registry
	 */
	protected ServicesRegistry createServicesRegistry() {
		ServicesRegistry result = null;
		
		try {
			result = new ExtensionServicesRegistry(org.eclipse.papyrus.infra.core.Activator.PLUGIN_ID);
		} catch (ServiceException e) {
			// couldn't create the registry? Fatal problem
			Activator.log.error(e);
		}
		
		try {
			// have to create the model set and populate it with the DI model
			// before initializing other services that actually need the DI
			// model, such as the SashModel Manager service
			result.startServicesByClassKeys(ModelSet.class);
		} catch (ServiceException ex) {
			// Ignore this exception: some services may not have been loaded,
			// which is probably normal at this point
		}
		
		return result;
	}
	
	/**
	 * Initializes the services registry.
	 *
	 * @param registry the registry
	 * @throws ServiceException the service exception
	 */
	protected void initServicesRegistry(ServicesRegistry registry)
			throws ServiceException {
		try {
			registry.startRegistry();
		} catch (ServiceException ex) {
			// Ignore this exception: some services may not have been loaded,
			// which is probably normal at this point
		}

		registry.getService(IPageManager.class);
	}

	/**
	 * Gets the IDs of the diagram category.
	 *
	 * @return the diagram category id, "uml"
	 */
	protected String[] getDiagramCategoryIds() {
		return new String[]{"uml"};
	}

	/**
	 * Gets the diagram file extension.
	 *
	 * @param diagramCategoryId the diagram category id
	 * @return the diagram file extension, "di"
	 */
	public String getDiagramFileExtension(String diagramCategoryId) {
		return getDiagramFileExtension(diagramCategoryId, NewModelFilePage.DEFAULT_DIAGRAM_EXTENSION);
	}

	/**
	 * Gets the diagram file extension.
	 *
	 * @param categoryId the category id
	 * @param defaultExtension the default extension
	 * @return the diagram file extension
	 */
	public String getDiagramFileExtension(String categoryId, String defaultExtension) {
		DiagramCategoryDescriptor diagramCategory = getDiagramCategoryMap().get(categoryId);
		String extensionPrefix = diagramCategory != null ? diagramCategory.getExtensionPrefix() : null;
		return (extensionPrefix != null) ? extensionPrefix + "." + defaultExtension : defaultExtension; //$NON-NLS-1$
	}

	/**
	 * Initializes the domain model.
	 *
	 * @param modelSet the model set
	 * @param newURI the URI of the new model
	 * @param diagramCategoryId the diagram category id
	 */
	protected void initDomainModel(ModelSet modelSet, final URI newURI,
			String diagramCategoryId) {
		
		boolean isToInitFromTemplate = false;//TODO use CHESS model template
		if (isToInitFromTemplate) {
			initDomainModelFromTemplate(modelSet);
		} else {
			createEmptyDomainModel(modelSet, diagramCategoryId);
			getCommandStack(modelSet).execute(null);
			getCommandStack(modelSet).execute(new InitCHESSModelCommand(modelSet.getTransactionalEditingDomain(), modelSet));
		}
	}

	/**
	 * Inits the domain model from template. Not implemented
	 *
	 * @param modelSet the model set
	 */
	protected void initDomainModelFromTemplate(ModelSet modelSet) {
		//TODO Use a template for the CHESS model as an alternative
	}

	/**
	 * Creates the empty domain model.
	 *
	 * @param modelSet the model set
	 * @param diagramCategoryId the diagram category id
	 */
	protected void createEmptyDomainModel(ModelSet modelSet, String diagramCategoryId) {
		try {
			IModelCreationCommand creationCommand = getDiagramCategoryMap().get(diagramCategoryId).getCommand();
			creationCommand.createModel(modelSet);
		} catch (BackboneException e) {
			log.error(e);
		}
	}

	/**
	 * Creates the Papyrus model.
	 *
	 * @param modelSet the model set
	 * @param newURI the URI of the new model
	 */
	protected void createPapyrusModels(ModelSet modelSet, URI newURI) {
		RecordingCommand command = new NewPapyrusModelCommand(modelSet, newURI);
		getCommandStack(modelSet).execute(command);
	}

	/**
	 * Saves the diagram category settings.
	 */
	protected void saveDiagramCategorySettings() {
		IDialogSettings settings = getDialogSettings();
		if(settings != null) {
			SettingsHelper settingsHelper = new SettingsHelper(settings);
			settingsHelper.saveDefaultDiagramCategory(getDiagramCategoryIds());
		}
	}

	/**
	 * Opens a diagram.
	 *
	 * @param newURI the URI
	 */
	protected void openDiagram(final URI newURI) {
		IWorkbenchPage page = workbench.getActiveWorkbenchWindow()
			.getActivePage();
		if (page != null) {
			try {
				IEditorInput editorInput = createEditorInput(newURI);
				IDE.openEditor(page, editorInput, PapyrusMultiDiagramEditor.EDITOR_ID, true);
			} catch (PartInitException e) {
				log.error(e);
			}
		}
	}

	/**
	 * Creates the editor input.
	 *
	 * @param uri the URI
	 * @return the editor input
	 */
	protected IEditorInput createEditorInput(URI uri) {
		return selectedStorageProvider.createEditorInput(uri);
	}

	/**
	 * Initializes the diagram model.
	 *
	 * @param modelSet the model set
	 * @param categoryId the category id
	 */
	protected void initDiagramModel(ModelSet modelSet, String categoryId) {
		initDiagrams(modelSet, categoryId);
		saveDiagram(modelSet);
	}

	/**
	 * Saves the diagram.
	 *
	 * @param modelSet the model set
	 */
	private void saveDiagram(ModelSet modelSet) {
		try {
			modelSet.save(new NullProgressMonitor());
		} catch (IOException e) {
			log.error(e);
		}
	}

	/**
	 * Initializes the diagrams.
	 *
	 * @param modelSet the model set
	 * @param categoryId the category id
	 */
	protected void initDiagrams(ModelSet modelSet, String categoryId) {
		initDiagrams(modelSet, null, categoryId);
	}

	/**
	 * Initializes the diagrams.
	 *
	 * @param resourceSet the resource set
	 * @param root the root of the model
	 * @param categoryId the category id
	 */
	protected void initDiagrams(ModelSet resourceSet, EObject root, String categoryId) {
		List<ICreationCommand> creationCommands = Collections.emptyList();//getDiagramKindsFor(categoryId);
		String diagramName = "diagram";//selectDiagramKindPage.getDiagramName();
		if(creationCommands.isEmpty()) {
			createEmptyDiagramEditor(resourceSet);
		} else {
			for(int i = 0; i < creationCommands.size(); i++) {
				creationCommands.get(i).createDiagram(resourceSet, root, diagramName);
			}
		}
	}


	/**
	 * Creates an empty diagram editor.
	 *
	 * @param modelSet the model set
	 */
	private void createEmptyDiagramEditor(ModelSet modelSet) {
		// Create an empty editor (no diagrams opened)
		// Geting an IPageMngr is enough to initialize the
		// SashSystem.
		
		EditorUtils.getIPageMngr(DiModelUtils.getDiResource(modelSet));
		/*try {
			ServiceUtilsForResource.getInstance().getServiceRegistry(DiModelUtils.getDiResource(modelSet));
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	/**
	 * Gets the command stack.
	 *
	 * @param modelSet the model set
	 * @return the command stack
	 */
	protected final CommandStack getCommandStack(ModelSet modelSet) {
		return modelSet.getTransactionalEditingDomain().getCommandStack();
	}

	/**
	 * Gets the diagram category map.
	 *
	 * @return the diagram category map
	 */
	protected Map<String, DiagramCategoryDescriptor> getDiagramCategoryMap() {
		return DiagramCategoryRegistry.getInstance().getDiagramCategoryMap();
	}

	/**
	 * Updates the diagram category.
	 *
	 * @param newCategories the new categories
	 * @return the changed status
	 */
	public IStatus diagramCategoryChanged(String... newCategories) {
		return selectedStorageProvider.validateDiagramCategories(
			newCategories);
	}
	
	/**
	 * Initializes the storage provider.
	 *
	 * @param workbench the workbench
	 * @param selection the current selection
	 */
	protected void initStorageProvider(IWorkbench workbench,
			IStructuredSelection selection) {
		selectedStorageProvider = new WorkspaceNewModelStorageProvider();
	}

	
	/**
	 * Gets the next page of the wizards, i.e the page that follows the given page
	 * @param the given page
	 * @return the next page of the wizard 
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#getNextPage(org.eclipse.jface.wizard.IWizardPage)
	 */
	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		final List<IWizardPage> allPages = Arrays.asList(getPages());
		IWizardPage result = null;

		 WorkspaceNewModelStorageProvider provider = providersByPage.get(page);
		if (provider != null) {
			// it's contributed by a provider. Get the next in the list
			List<IWizardPage> pages = providerPages.get(provider);
			int index = pages.indexOf(page);
			if ((index >= 0) && (index < (pages.size() - 1))) {
				result = pages.get(index + 1);
			} else {
				// get the first page after the provider pages
				if (endProviderPageIndex < allPages.size()) {
					result = allPages.get(endProviderPageIndex);
				}
			}
		} else if (allPages.indexOf(page) == startProviderPageIndex) {
			// get the first page of the selected provider
			List<IWizardPage> pages = providerPages.get(selectedStorageProvider);
			if (!pages.isEmpty()) {
				result = pages.get(0);
			} else {
				// get the first page after the provider pages
				if (endProviderPageIndex < allPages.size()) {
					result = allPages.get(endProviderPageIndex);
				}
			}
		} else {
			// somewhere away from the boundary of the provider pages
			result = super.getNextPage(page);
		}
		return result;
	}
	
	/**
	 * Gets the previous page of the wizards, i.e the page that precedes the given page
	 * @param the given page
	 * @return the next page of the wizard 
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#getPreviousPage(org.eclipse.jface.wizard.IWizardPage)
	 */
	@Override
	public IWizardPage getPreviousPage(IWizardPage page) {
		final List<IWizardPage> allPages = Arrays.asList(getPages());
		IWizardPage result = null;

		WorkspaceNewModelStorageProvider provider = providersByPage.get(page);
		if (provider != null) {
			// it's contributed by a provider. Get the previous in the list
			List<IWizardPage> pages = providerPages.get(provider);
			int index = pages.indexOf(page);
			if (index > 0) {
				result = pages.get(index - 1);
			} else {
				// get the last page before the provider pages
				if (startProviderPageIndex >= 0) {
					result = allPages.get(startProviderPageIndex);
				}
			}
		} else if (allPages.indexOf(page) == endProviderPageIndex) {
			// get the last page of the selected provider
			List<IWizardPage> pages = providerPages.get(selectedStorageProvider);
			if (!pages.isEmpty()) {
				result = pages.get(pages.size() - 1);
			} else {
				// get the last page before the provider pages
				if (startProviderPageIndex >= 0) {
					result = allPages.get(startProviderPageIndex);
				}
			}
		} else {
			// somewhere away from the boundary of the provider pages
			result = super.getPreviousPage(page);
		}
		
		return result;
	}
	
	/** Checks if the wizard creation can be finished successfully.
	 * @return true if all the pages are completed, false otherwise
	 *  
	 * @see org.eclipse.jface.wizard.Wizard#canFinish()
	 */
	@Override
	public boolean canFinish() {
		boolean result = true;
		final IWizardPage[] allPages = getPages();

		// only look at the universal pages and those contributed by the current
		// storage provider

		for (int i = 0; result && (i <= startProviderPageIndex); i++) {
			result = allPages[i].isPageComplete();
		}
		
		if (result) {
			for (IWizardPage next : providerPages.get(selectedStorageProvider)) {
				if (!next.isPageComplete()) {
					result = false;
					break;
				}
			}
		}
		
		for (int i = endProviderPageIndex; result && (i < allPages.length); i++) {
			result = allPages[i].isPageComplete();
		}

		return result;
	}

	/**
	 * Gets the kind of the model as a string.
	 *
	 * @return the string representing the kind of the model
	 */
	public String getModelKindName() {
		return "Papyrus";
	}

}
