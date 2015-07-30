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

/**
 * The Class CHESSNewProjectWizard is the implementation of the wizard used to create a new CHESS project
 */
public class CHESSNewProjectWizard extends Wizard implements INewWizard, IExecutableExtension {

	/** The Constant WIZARD_NAME. */
	private static final String WIZARD_NAME = "CHESS";
	
	/** The page one. */
	private WizardNewProjectCreationPage pageOne;
	
	/** The configuration element. */
	private IConfigurationElement configurationElement;
	
	/**
	 * Instantiates a new CHESS new project wizard.
	 */
	public CHESSNewProjectWizard() {
		setWindowTitle(WIZARD_NAME);
	}
	
	/**
	 * Sets title and description of the page and adds it to the wizard 
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		super.addPages();
		pageOne = new WizardNewProjectCreationPage("CHESS Project Wizard");
		
		pageOne.setTitle("New CHESS Project");
		pageOne.setDescription("Create a new CHESS Project");
			 
		addPage(pageOne);
	}

	/**
	 * Creates the CHESS Project and updates the eclipse perspective
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
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

	/**
	 * Not Implemented
	 * 
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub

	}
	
	/** 
	 * Initializes the wizard configuration
	 * 
	 * @see org.eclipse.core.runtime.IExecutableExtension#setInitializationData(org.eclipse.core.runtime.IConfigurationElement, java.lang.String, java.lang.Object)
	 */
	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException {
		configurationElement = config;
	}
	
	

}
