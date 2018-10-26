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

package org.polarsys.chess.cdo.wizards;

import org.eclipse.papyrus.uml.diagram.wizards.pages.NewModelFilePage;
import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectRootElementPage;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.ui.IWorkbench;

/**
 * The Class InitCDOModelWizard extends the create CHESS wizard adding the initialization
 */
public class InitCDOModelWizard extends CreateCDOCHESSModelWizard {

	/** The select root element page. */
	private SelectRootElementPage selectRootElementPage;

	/**
	 * Checks if the wizard initializes the model.
	 * 
	 * @return true
	 * 
	 * @see org.polarsys.chess.wizards.wizards.CreateCHESSModelWizard#isInitModelWizard()
	 */
	@Override
	public boolean isInitModelWizard() {
		return true;
	}
	
	/**
	 * Initializes the wizard.
	 * 
	 * @param workbench the current workbench
	 * @param selection the current structured selection
	 * 
	 * @see org.polarsys.chess.wizards.wizards.CreateCHESSModelWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		//URI uri = getSelectedResourceURI(selection);
		super.init(workbench, selection);
		selectRootElementPage = createSelectRootElementPage(selection);
	}

	/**
	 * Creates the select root element page as null.
	 *
	 * @param selection the current structured selection
	 * @return null
	 */
	protected SelectRootElementPage createSelectRootElementPage(IStructuredSelection selection) {
		return null;
	}


	/**
	 * 
	 * Adds pages to the wizard.
	 * 
	 * @see org.polarsys.chess.wizards.wizards.CreateCHESSModelWizard#addPages()
	 */
	@Override
	public void addPages() {
		super.addPages();
		addPageIfNotNull(selectRootElementPage);
	};

	/* (non-Javadoc)
	 * @see org.polarsys.chess.wizards.CreateCHESSModelWizard#createPapyrusModels(org.eclipse.papyrus.infra.core.resource.ModelSet, org.eclipse.emf.common.util.URI)
	 */
	@Override
	protected void createPapyrusModels(ModelSet modelSet, URI newURI) {
		super.createPapyrusModels(modelSet, newURI);
	}

	/* (non-Javadoc)
	 * @see org.polarsys.chess.wizards.CreateCHESSModelWizard#initDomainModel(org.eclipse.papyrus.infra.core.resource.ModelSet, org.eclipse.emf.common.util.URI, java.lang.String)
	 */
	@Override
	protected void initDomainModel(ModelSet modelSet, final URI newURI, String diagramCategoryId) {
		super.initDomainModel(modelSet, newURI, diagramCategoryId);
	}

	/* (non-Javadoc)
	 * @see org.polarsys.chess.wizards.CreateCHESSModelWizard#initDiagrams(org.eclipse.papyrus.infra.core.resource.ModelSet, java.lang.String)
	 */
	@Override
	protected void initDiagrams(ModelSet modelSet, String categoryId) {
		initDiagrams(modelSet, getRoot(), categoryId);
	}

	/* (non-Javadoc)
	 * @see org.polarsys.chess.wizards.CreateCHESSModelWizard#getDiagramFileExtension(java.lang.String)
	 */
	@Override
	public String getDiagramFileExtension(String diagramCategoryId) {
		return super.getDiagramFileExtension(diagramCategoryId);
	}

	/**
	 * Gets the root element.
	 *
	 * @return the root
	 */
	private EObject getRoot() {
		if(selectRootElementPage != null) {
			return selectRootElementPage.getModelElement();
		}
		return null;
	}

	/**
	 * The Class NewDiagramForExistingModelPage can create an empty .uml file.
	 */
	public static class NewDiagramForExistingModelPage extends NewModelFilePage {

		/** The my diagram file name. */
		private String myDiagramFileName;

		/**
		 * Instantiates a new new diagram for existing model page.
		 *
		 * @param selection the current structured selection
		 * @param modelKindName the model kind name
		 * @param defaultFileName the default file name
		 * @param diagramExtension the diagram extension
		 */
		public NewDiagramForExistingModelPage(IStructuredSelection selection,
				String modelKindName, String defaultFileName,
				String diagramExtension) {
			
			super(selection, modelKindName);
			
			myDiagramFileName = defaultFileName;
			setFileName(defaultFileName);
			setFileExtension(diagramExtension);
			setTitle("Init a new CHESS model");
			setDescription("Init a new CHESS model from the existing domain model");
		}

		/* (non-Javadoc)
		 * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage#validatePage()
		 */
		@Override
		protected boolean validatePage() {
			if(!super.validatePage()) {
				return false;
			}
			if(!myDiagramFileName.equals(getFileName())) {
				setErrorMessage("Diagram file name should be the same as domain model file name ("+myDiagramFileName+")" );
				return false;
			}
			return true;
		};

	}

}
