/*******************************************************************************
 * Copyright (C) 2018 Fondazione Bruno Kessler.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Luca Cristoforetti - initial API and implementation
 ******************************************************************************/
package org.polarsys.chess.verificationService.ui.commands;

import java.util.HashMap;
import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
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
import eu.fbk.eclipse.standardtools.nuXmvService.ui.utils.NuXmvDirectoryUtil;
import eu.fbk.eclipse.standardtools.utils.ui.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.utils.ui.utils.DialogUtil;
import eu.fbk.eclipse.standardtools.utils.ui.utils.OCRADirectoryUtil;

/**
 * Command that generates a monolithic SMV file.
 * @author cristofo
 *
 */
public class ExportModelToMonolithicSMVCommand extends AbstractJobCommand {

	private static final Logger logger = Logger.getLogger(ExportModelToMonolithicSMVCommand.class);

	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private SmvExportServiceUI smvExportService = SmvExportServiceUI.getInstance();
	private static NuXmvDirectoryUtil nuXmvDirectoryUtil = NuXmvDirectoryUtil.getInstance();
	private OCRADirectoryUtil ocraDirectoryUtil = OCRADirectoryUtil.getInstance();
	private OCRAExecService ocraExecService = OCRAExecService.getInstance(ChessSystemModel.getInstance());
	private boolean isProgrExec;
	private Class umlSelectedComponent;
	private boolean showPopups;
	private boolean usexTextValidation;
	private String smvFileDirectory;
	private boolean isDiscreteTime;
	private String monolithicSMVFilePath;
	private String smvMapFilepath;
	private Resource umlSelectedResource;
	private String ossFilePath;
	private Boolean process;

	public ExportModelToMonolithicSMVCommand() {
		super("Monolithic SMV file generation");
	}
	
	@Override
	public void execPreJobOperations(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		
		try {
			umlSelectedComponent = selectionUtil.getUmlComponentFromSelectedObject(event);
		} catch (NoComponentException e) {
			DialogUtil.getInstance().showMessage_ExceptionError(e);
			throw new ExecutionException(e.getMessage());
		}
	
		final Package pkg = umlSelectedComponent.getNearestPackage();
		
		umlSelectedComponent = null;
		
		final EList<Element> list = pkg.getOwnedElements();
		
		for (Element element : list) {
			if(EntityUtil.getInstance().isSystem(element)) {
				logger.debug("System block found: " + element);
				umlSelectedComponent = (Class) element;
				break;
			}
		}
		
		if (umlSelectedComponent == null) {
			logger.debug("System block not found, aborting.");			
			final ExecutionException e = 
					new ExecutionException("The model does not have a <<System>> block. Please add one.");
			DialogUtil.getInstance().showMessage_ExceptionError(e);
			throw e;
		}
		
		isDiscreteTime = true;
		smvFileDirectory = nuXmvDirectoryUtil.getSmvFileDirectory();
		monolithicSMVFilePath = nuXmvDirectoryUtil.getMonolithicSMVFilePath(umlSelectedComponent.getName());
		smvMapFilepath = nuXmvDirectoryUtil.getSmvMapFilePath();
		ossFilePath = ocraDirectoryUtil.getOSSFilePath();
		umlSelectedResource = umlSelectedComponent.eResource();
		showPopups = false;
		usexTextValidation = true;
		process = true;
	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {

		if (process) {
			logger.debug("exportSmv");
			HashMap<String, String> smvPathComponentNameMap = smvExportService.exportSmv(umlSelectedComponent,
					showPopups, smvFileDirectory, monitor);

			logger.debug("createMonolithicSMV");
			ocraExecService.createMonolithicSMV(umlSelectedComponent, umlSelectedResource, smvPathComponentNameMap,
					isDiscreteTime, usexTextValidation, showPopups, ossFilePath, smvMapFilepath, 
					monolithicSMVFilePath, isProgrExec, monitor);
			logger.debug("createMonolithicSMV done");
		}
	}
}
