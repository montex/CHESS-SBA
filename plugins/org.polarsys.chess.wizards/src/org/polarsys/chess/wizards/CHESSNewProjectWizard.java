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

import java.net.URI;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;
import org.polarsys.chess.core.util.CHESSProjectSupport;

public class CHESSNewProjectWizard extends Wizard implements INewWizard, IExecutableExtension {

	private static final String WIZARD_NAME = "CHESS";
	private WizardNewProjectCreationPage pageOne;
	private IConfigurationElement configurationElement;
	
	public CHESSNewProjectWizard() {
		setWindowTitle(WIZARD_NAME);
	}
	
	@Override
	public void addPages() {
		// TODO Auto-generated method stub
		super.addPages();
		pageOne = new WizardNewProjectCreationPage("CHESS Project Wizard");
		
		pageOne.setTitle("New CHESS Project");
		pageOne.setDescription("Create a new CHESS Project");
			 
		addPage(pageOne);
	}

	@Override
	public boolean performFinish() {
		String name = pageOne.getProjectName();
		URI location = null;
		if (!pageOne.useDefaults()){
			location = pageOne.getLocationURI();
			System.err.println("location: " + location.toString());//$NON-NLS-1$
		}
		CHESSProjectSupport.createProject(name, location);
		BasicNewProjectResourceWizard.updatePerspective(configurationElement);
		return true;
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub

	}
	
	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException {
		configurationElement = config;
	}
	
	

}
