/*******************************************************************************
 * Copyright (C) 2017 Fondazione Bruno Kessler.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Alberto Debiasi - initial API and implementation
 ******************************************************************************/
package org.polarsys.chess.verificationService.ui.commands;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.service.core.exceptions.NoComponentException;
import org.polarsys.chess.service.core.model.ChessSystemModel;
import org.polarsys.chess.service.gui.utils.SelectionUtil;
import org.polarsys.chess.smvExporter.ui.services.SmvExportServiceUI;

import eu.fbk.eclipse.standardtools.ExecOcraCommands.ui.services.OCRAExecService;
import eu.fbk.eclipse.standardtools.nuXmvService.ui.services.NuXmvExecService;
import eu.fbk.eclipse.standardtools.nuXmvService.ui.utils.NuXmvDirectoryUtil;
import eu.fbk.eclipse.standardtools.utils.ui.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.utils.ui.utils.OCRADirectoryUtil;

/**
 * 
 *
 */
public class ExportModelToMonolithicSMVCommand extends AbstractJobCommand {

	private static final Logger logger = Logger.getLogger(ExportModelToMonolithicSMVCommand.class);

	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private SmvExportServiceUI smvExportService = SmvExportServiceUI.getInstance();
	private NuXmvExecService nuXmvExecService = NuXmvExecService.getInstance();
	private static NuXmvDirectoryUtil nuXmvDirectoryUtil = NuXmvDirectoryUtil.getInstance();
	private OCRADirectoryUtil ocraDirectoryUtil = OCRADirectoryUtil.getInstance();
	private OCRAExecService ocraExecService = OCRAExecService.getInstance(ChessSystemModel.getInstance());

	public ExportModelToMonolithicSMVCommand() {
		super("Monolithic SMV file generation");
	}

	private boolean isProgrExec;
	private Class umlSelectedComponent;
	private boolean showPopups;
	private boolean usexTextValidation;
	private String smvFileDirectory;
	private boolean isDiscreteTime;
	private String monolithicSMVFilePath;
	private String resultFilePath;
	private String smvMapFilepath;
	private Resource umlSelectedResource;
	private String ossFilePath;
	
	@Override
	public void execPreJobOperations(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		
		try {
			umlSelectedComponent = selectionUtil.getUmlComponentFromSelectedObject(event);
		} catch (NoComponentException e) {
			e.printStackTrace();
			return;
		}
		
		// TODO: devo prendere la root qui
		
		Package pkg = umlSelectedComponent.getNearestPackage();
		
		umlSelectedComponent = null;
		
		EList<Element>  list = pkg.getOwnedElements();
		
		for (Element element : list) {
			System.out.println("element = " + element);
			
			if(EntityUtil.getInstance().isSystem(element)) {
				System.out.println("\n\n\nfound system component\n\n\n");
				umlSelectedComponent = (Class) element;
				break;
			}
		}
		
		if (umlSelectedComponent == null) {
			return;
		}
		
		isDiscreteTime = true;
		smvFileDirectory = nuXmvDirectoryUtil.getSmvFileDirectory();
		monolithicSMVFilePath = nuXmvDirectoryUtil.getMonolithicSMVFilePath(umlSelectedComponent.getName());
		resultFilePath = nuXmvDirectoryUtil.getModelCheckingResultPath(umlSelectedComponent.getName());
		smvMapFilepath = nuXmvDirectoryUtil.getSmvMapFilePath();
		ossFilePath = ocraDirectoryUtil.getOSSFilePath();
		
		System.out.println("smvFileDirectory" + smvFileDirectory);
		System.out.println("monolithicSMVFilePath" + monolithicSMVFilePath);
		System.out.println("resultFilePath" + resultFilePath);
		System.out.println("smvMapFilepath" + smvMapFilepath);
		System.out.println("ossFilePath" + ossFilePath);
	
		
		umlSelectedResource = umlSelectedComponent.eResource();
		showPopups = false;
		usexTextValidation=true;

	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {

		logger.debug("exportSmv");
		HashMap<String, String> smvPathComponentNameMap = smvExportService.exportSmv(umlSelectedComponent,
				showPopups, smvFileDirectory, monitor);
		logger.debug("createMonolithicSMV");
		ocraExecService.createMonolithicSMV(umlSelectedComponent, umlSelectedResource, smvPathComponentNameMap,
				isDiscreteTime, usexTextValidation,showPopups, ossFilePath, smvMapFilepath, 
				monolithicSMVFilePath, isProgrExec,monitor);

		logger.debug("createMonolithicSMV done");
	}

}
