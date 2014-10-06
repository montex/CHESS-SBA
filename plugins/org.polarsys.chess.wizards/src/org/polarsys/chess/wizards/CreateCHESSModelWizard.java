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



package org.polarsys.chess.wizards;

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
import org.eclipse.papyrus.infra.core.extension.commands.IModelCreationCommand;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModelUtils;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.services.ExtensionServicesRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.uml.diagram.wizards.SettingsHelper;
import org.eclipse.papyrus.uml.diagram.wizards.category.DiagramCategoryDescriptor;
import org.eclipse.papyrus.uml.diagram.wizards.category.DiagramCategoryRegistry;
import org.eclipse.papyrus.uml.diagram.wizards.category.NewPapyrusModelCommand;
import org.eclipse.papyrus.uml.diagram.wizards.pages.NewModelFilePage;
import org.eclipse.papyrus.uml.tools.listeners.PapyrusStereotypeListener;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.polarsys.chess.core.util.commands.InitCHESSModelCommand;


public class CreateCHESSModelWizard extends Wizard implements INewWizard {

	public static final String WIZARD_ID = "org.eclipse.papyrus.uml.diagram.wizards.createmodel"; //$NON-NLS-1$

	public static final String NEW_MODEL_SETTINGS = "NewModelWizard"; //$NON-NLS-1$

	private IWorkbench workbench;

	private WorkspaceNewModelStorageProvider selectedStorageProvider; 
	
	private Map<WorkspaceNewModelStorageProvider, List<IWizardPage>> providerPages = new java.util.HashMap<WorkspaceNewModelStorageProvider, List<IWizardPage>>();
	private Map<IWizardPage, WorkspaceNewModelStorageProvider> providersByPage = new java.util.HashMap<IWizardPage, WorkspaceNewModelStorageProvider>();
	private int startProviderPageIndex;
	private int endProviderPageIndex; 
	
	public CreateCHESSModelWizard() {
		super();
		setWindowTitle("New CHESS Model");
	}

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

	protected final void addPageIfNotNull(IWizardPage page) {
		if(page != null) {
			addPage(page);
		}
	}

	public boolean isInitModelWizard() {
		return false;
	}
	
	public boolean isCreateProjectWizard() {
		return false;
	}
	
	public boolean isCreateMultipleModelsWizard() {
		return false;
	}
	
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

	protected URI createNewModelURI(String diagramCategoryID) {
		return selectedStorageProvider.createNewModelURI(diagramCategoryID);
	}
	
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

	protected String[] getDiagramCategoryIds() {
		return new String[]{"uml"};
	}

	public String getDiagramFileExtension(String diagramCategoryId) {
		return getDiagramFileExtension(diagramCategoryId, NewModelFilePage.DEFAULT_DIAGRAM_EXTENSION);
	}

	public String getDiagramFileExtension(String categoryId, String defaultExtension) {
		DiagramCategoryDescriptor diagramCategory = getDiagramCategoryMap().get(categoryId);
		String extensionPrefix = diagramCategory != null ? diagramCategory.getExtensionPrefix() : null;
		return (extensionPrefix != null) ? extensionPrefix + "." + defaultExtension : defaultExtension; //$NON-NLS-1$
	}

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

	protected void initDomainModelFromTemplate(ModelSet modelSet) {
		//TODO Use a template for the CHESS model as an alternative
	}

	protected void createEmptyDomainModel(ModelSet modelSet, String diagramCategoryId) {
		try {
			IModelCreationCommand creationCommand = getDiagramCategoryMap().get(diagramCategoryId).getCommand();
			creationCommand.createModel(modelSet);
		} catch (BackboneException e) {
			log.error(e);
		}
	}

	protected void createPapyrusModels(ModelSet modelSet, URI newURI) {
		RecordingCommand command = new NewPapyrusModelCommand(modelSet, newURI);
		getCommandStack(modelSet).execute(command);
	}

	protected void saveDiagramCategorySettings() {
		IDialogSettings settings = getDialogSettings();
		if(settings != null) {
			SettingsHelper settingsHelper = new SettingsHelper(settings);
			settingsHelper.saveDefaultDiagramCategory(getDiagramCategoryIds());
		}
	}

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

	protected IEditorInput createEditorInput(URI uri) {
		return selectedStorageProvider.createEditorInput(uri);
	}

	protected void initDiagramModel(ModelSet modelSet, String categoryId) {
		initDiagrams(modelSet, categoryId);
		saveDiagram(modelSet);
	}

	private void saveDiagram(ModelSet modelSet) {
		try {
			modelSet.save(new NullProgressMonitor());
		} catch (IOException e) {
			log.error(e);
		}
	}

	protected void initDiagrams(ModelSet modelSet, String categoryId) {
		initDiagrams(modelSet, null, categoryId);
	}

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

	protected final CommandStack getCommandStack(ModelSet modelSet) {
		return modelSet.getTransactionalEditingDomain().getCommandStack();
	}

	protected Map<String, DiagramCategoryDescriptor> getDiagramCategoryMap() {
		return DiagramCategoryRegistry.getInstance().getDiagramCategoryMap();
	}

	public IStatus diagramCategoryChanged(String... newCategories) {
		return selectedStorageProvider.validateDiagramCategories(
			newCategories);
	}
	
	protected void initStorageProvider(IWorkbench workbench,
			IStructuredSelection selection) {
		selectedStorageProvider = new WorkspaceNewModelStorageProvider();
	}

	
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

	public String getModelKindName() {
		return "Papyrus";
	}

}
