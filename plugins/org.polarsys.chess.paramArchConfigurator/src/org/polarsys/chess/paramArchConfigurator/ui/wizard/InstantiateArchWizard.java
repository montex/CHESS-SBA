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
package org.polarsys.chess.paramArchConfigurator.ui.wizard;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.wizard.Wizard;
import org.polarsys.chess.paramArchConfigurator.ui.wizard.page.LastPage;
import org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.InstantiatedArchitecture;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.paramArchConfigurator.ui.wizard.page.AssignValuesPage;
import org.polarsys.chess.service.core.model.ChessSystemModel;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;

import eu.fbk.eclipse.standardtools.ExecOcraCommands.ui.services.OCRAExecService;
import eu.fbk.eclipse.standardtools.utils.ui.utils.DialogUtil;

public class InstantiateArchWizard extends Wizard {

	protected AssignValuesPage one;
	protected LastPage lastPage;

	private static final Logger logger = Logger.getLogger(InstantiateArchWizard.class);
	private OCRAExecService ocraExecService = OCRAExecService.getInstance(ChessSystemModel.getInstance());
	private File ossFile;
	private IProgressMonitor monitor;
	private boolean isDiscrete;
	private EObject selectedElement;
	private Package seletedPackage;
	private boolean createNestedPackage;
	private boolean importArch;
	private String nestedPackageName;
	private File finalOssFile;
	private File finalParamListFile;

	private DialogUtil dialogUtil = DialogUtil.getInstance();

	public InstantiateArchWizard(File ossFile, EObject selectedElement, boolean isDiscrete, IProgressMonitor monitor) {
		super();
		this.ossFile = ossFile;
		this.monitor = monitor;
		this.isDiscrete = isDiscrete;
		this.selectedElement = selectedElement;
		setNeedsProgressMonitor(true);
	}

	@Override
	public String getWindowTitle() {
		return "Export My Data";
	}

	@Override
	public void addPages() {

		try {
			Map<String, String> parametersList = ocraExecService.executeGetParameters(ossFile, isDiscrete, monitor);

			if ((parametersList != null) && (!parametersList.isEmpty())) {

				Map<String, Map<String, String>> existingParametersLists = getExistingParametersLists(selectedElement);

				String currentDate = getCurrentDateAsStr();
				String prefixName = FilenameUtils.removeExtension(ossFile.getName());
				// TODO uncomment when OCRA commands will be ready
				// +"_"+currentDate;
				one = new AssignValuesPage(true, prefixName, selectedElement, ossFile, null, null,
						existingParametersLists, parametersList, new ArrayList<ArrayList<String>>(), 1, isDiscrete,
						monitor, this);
				addPage(one);
			}

			lastPage = new LastPage(selectedElement, null, new ArrayList<ArrayList<String>>());
			addPage(lastPage);
		} catch (Exception e) {
			e.printStackTrace();
			dialogUtil.showMessage_ExceptionError(e);
			performCancel();
		}
	}

	private Map<String, Map<String, String>> getExistingParametersLists(EObject selectedElement) {

		Set<Property> instantiatedArchitectureList = EntityUtil.getInstance()
				.getInstantiatedArchitecureElements((Class) selectedElement);
		Map<String, Map<String, String>> res = new HashMap<String, Map<String, String>>();

		if ((instantiatedArchitectureList != null) && (instantiatedArchitectureList.size() != 0)) {
			for (Property property : instantiatedArchitectureList) {
				InstantiatedArchitecture instantiatedArchitecture  = EntityUtil.getInstance().getInstantiatedArchitecture(property);
				Map<String, String> temp = new HashMap<String, String>();
				for (String param : instantiatedArchitecture.getParameterList()) {
					logger.debug("param: "+param);
					String[] paramTerms = param.split("=");
					logger.debug("paramTerms[0]: "+paramTerms[0]);
					logger.debug("paramTerms[1]: "+paramTerms[1]);
					temp.put(paramTerms[0], paramTerms[1]);
				}
				logger.debug("dependency.getQualifiedName(): "+property.getQualifiedName());
				res.put(property.getQualifiedName(),temp);
			}
		}

		return res;
	}

	private String getCurrentDateAsStr() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date date = new Date();
		return (dateFormat.format(date));
	}

	@Override
	public boolean canFinish() {
		if (getContainer().getCurrentPage() instanceof AssignValuesPage)
			return false;
		else
			return true;
	}

	public Package getSelectedPackage() {
		return seletedPackage;
	}

	public boolean createNestedPackage() {
		return createNestedPackage;
	}

	public boolean importArch() {
		return importArch;
	}
	
	public String getNestedPackageName() {
		return nestedPackageName;
	}

	public File getOSSFile() {
		return finalOssFile;
	}

	public File getParamsListFile() {
		return finalParamListFile;
	}

	@Override
	public boolean performFinish() {
		seletedPackage = ((LastPage) getContainer().getCurrentPage()).getSelectedPackage();
		createNestedPackage = ((LastPage) getContainer().getCurrentPage()).createNestedPackage();
		nestedPackageName = ((LastPage) getContainer().getCurrentPage()).getNestedPackageName();
		importArch = ((LastPage) getContainer().getCurrentPage()).ImportArchitecture();
		finalOssFile = ((LastPage) getContainer().getCurrentPage()).getOSSFile();
		finalParamListFile = ((LastPage) getContainer().getCurrentPage()).getParamListFile();
		return true;
	}

}
