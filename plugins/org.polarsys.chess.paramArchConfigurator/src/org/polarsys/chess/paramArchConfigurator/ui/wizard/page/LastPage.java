/*******************************************************************************
 * Copyright (C) 2018 Fondazione Bruno Kessler.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *   Alberto Debiasi - initial API and implementation
 ******************************************************************************/
package org.polarsys.chess.paramArchConfigurator.ui.wizard.page;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.io.FilenameUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.tools.providers.UMLContentProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.paramArchConfigurator.ui.wizard.TreeSelector;
import org.polarsys.chess.service.core.model.ChessSystemModel;

import eu.fbk.eclipse.standardtools.ExecOcraCommands.ui.services.OCRAExecService;

import org.eclipse.uml2.uml.Package;

public class LastPage extends BasicWizardPage {

	private OCRAExecService ocraExecService = OCRAExecService.getInstance(ChessSystemModel.getInstance());

	private File newOssFile;
	private File paramListFile;

	private Composite container;
	private EObject selectedElement;
	private TreeSelector treeSelector;
	private Button checkCreatePackage;
	private Button checkImport;
	
	public LastPage(EObject selectedElement, File newOssFile, ArrayList<ArrayList<String>> prevParametersList)
			throws Exception {
		super("Arctitecture Instantiated", prevParametersList);
		setTitle("Parameterized Architecture Instantiated");
		setDescription("Instantiation Completed.");
		this.selectedElement = selectedElement;
		this.newOssFile = newOssFile;
		if ((prevParametersList != null) && (newOssFile != null)) {
			this.paramListFile = ocraExecService.prepareFinalParameterValuesFile(prevParametersList,
					"final_" + newOssFile.getName());
		}
	}

	@Override
	public void createControl(Composite parent) {

		container = new Composite(parent, SWT.BORDER);
		GridLayout containerLayout = new GridLayout(2, true);
		container.setLayout(containerLayout);

		createViewPrevParametersArea(container);
		createSelectPackageArea(container);

		container.redraw();
		// required to avoid an error in the system
		setControl(container);
		setPageComplete(true);

	}

	protected void createSelectPackageArea(Composite parent) {

		ScrolledComposite sc = new ScrolledComposite(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		sc.setLayoutData(gd);

		Composite scrolledContent = new Composite(sc, SWT.BORDER);
		scrolledContent.setLayout(new GridLayout(1, false));
		scrolledContent.setLayoutData(gd);

		Composite importArchComposite = new Composite(scrolledContent, SWT.NONE);
		importArchComposite.setLayout(new GridLayout(2, false));
		Label labelImport = new Label(importArchComposite, SWT.NONE);
		labelImport.setText("Import the instantiated architecture.");
		checkImport = new Button(importArchComposite, SWT.CHECK);
		checkImport.setSelection(true);
		Label labelCheck = new Label(scrolledContent, SWT.NONE);
		labelCheck.setText("Select the destination package of the instantiated architecture.");
		Composite createPackageComposite = new Composite(scrolledContent, SWT.NONE);
		createPackageComposite.setLayout(new GridLayout(2, false));
		checkCreatePackage = new Button(createPackageComposite, SWT.CHECK);
		checkCreatePackage.setSelection(true);
		Label newPackageLabel = new Label(createPackageComposite, SWT.NONE);
		newPackageLabel.setText("Create a nested package in the destination package.");

		createTreeSelector(scrolledContent);

		sc.setExpandHorizontal(true);
		sc.setExpandVertical(true);
		sc.setContent(scrolledContent);
		sc.setMinSize(scrolledContent.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	}

	public Package getSelectedPackage() {
		if((treeSelector!=null)&&(treeSelector.getResult()!=null)){
			return (Package) treeSelector.getResult()[0];	
		}
		return null;
	}

	public boolean createNestedPackage() {
		return checkCreatePackage.getSelection();
	}

	public boolean ImportArchitecture() {
		return checkImport.getSelection();
	}
	
	public String getNestedPackageName() {
		return FilenameUtils.removeExtension(newOssFile.getName());
	}

	public File getOSSFile() {
		return newOssFile;
	}

	public File getParamListFile() {
		return paramListFile;
	}

	private void createTreeSelector(Composite scrolledContent) {
		treeSelector = new TreeSelector(scrolledContent);
		Package pkg = EntityUtil.getInstance().getToPackage((Element) selectedElement);
		UMLContentProvider provider = new UMLContentProvider(pkg, UMLPackage.eINSTANCE.getPackage_PackagedElement());
		treeSelector.setContentProvider(provider);
		treeSelector.setLabelProvider(new UMLLabelProvider());
		treeSelector.create();

	}

}
