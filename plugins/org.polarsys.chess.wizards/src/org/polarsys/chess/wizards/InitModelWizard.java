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

import static org.eclipse.papyrus.uml.diagram.wizards.utils.WizardsHelper.getSelectedResourceURI;
import org.eclipse.papyrus.uml.diagram.wizards.pages.NewModelFilePage;
import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectRootElementPage;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.ui.IWorkbench;

public class InitModelWizard extends CreateCHESSModelWizard {

	private SelectRootElementPage selectRootElementPage;

	@Override
	public boolean isInitModelWizard() {
		return true;
	}
	
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		//URI uri = getSelectedResourceURI(selection);
		super.init(workbench, selection);
		selectRootElementPage = createSelectRootElementPage(selection);
	}

	protected SelectRootElementPage createSelectRootElementPage(IStructuredSelection selection) {
		return null;
	}


	@Override
	public void addPages() {
		super.addPages();
		addPageIfNotNull(selectRootElementPage);
	};

	@Override
	protected void createPapyrusModels(ModelSet modelSet, URI newURI) {
		super.createPapyrusModels(modelSet, newURI);
	}

	@Override
	protected void initDomainModel(ModelSet modelSet, final URI newURI, String diagramCategoryId) {
		super.initDomainModel(modelSet, newURI, diagramCategoryId);
	}

	@Override
	protected void initDiagrams(ModelSet modelSet, String categoryId) {
		initDiagrams(modelSet, getRoot(), categoryId);
	}

	@Override
	public String getDiagramFileExtension(String diagramCategoryId) {
		return super.getDiagramFileExtension(diagramCategoryId);
	}

	private EObject getRoot() {
		if(selectRootElementPage != null) {
			return selectRootElementPage.getModelElement();
		}
		return null;
	}

	protected static class NewDiagramForExistingModelPage extends NewModelFilePage {

		private String myDiagramFileName;

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
