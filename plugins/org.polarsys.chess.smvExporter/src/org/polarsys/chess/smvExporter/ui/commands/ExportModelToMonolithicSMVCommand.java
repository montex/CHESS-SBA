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
package org.polarsys.chess.smvExporter.ui.commands;

import java.util.HashMap;
import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.service.core.exceptions.NoComponentException;
import org.polarsys.chess.service.core.model.ChessSystemModel;
import org.polarsys.chess.service.core.model.UMLStateMachineModel;
import org.polarsys.chess.service.gui.utils.SelectionUtil;
import org.polarsys.chess.smvExporter.ui.utils.SMVGenerationDialogUtil;

import eu.fbk.eclipse.standardtools.ExecOcraCommands.ui.services.OCRAExecService;
import eu.fbk.eclipse.standardtools.StateMachineTranslatorToSmv.ui.services.SmvExportServiceUI;
import eu.fbk.eclipse.standardtools.nuXmvService.ui.utils.NuXmvDirectoryUtil;
import eu.fbk.eclipse.standardtools.utils.ui.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.utils.ui.utils.DialogUtil;
import eu.fbk.eclipse.standardtools.utils.ui.utils.OCRADirectoryUtil;

/**
 * Command that generates a monolithic SMV file for the active package.
 * @author cristofo
 *
 */
public class ExportModelToMonolithicSMVCommand extends AbstractJobCommand {
	private static final Logger logger = Logger.getLogger(ExportModelToMonolithicSMVCommand.class);
	private SelectionUtil selectionUtil = SelectionUtil.getInstance();

	public ExportModelToMonolithicSMVCommand() {
		super("Monolithic SMV file generation");
	}
	
	/**
	 * Returns the selected package, if any.
	 * @param event the event
	 * @return the selected package
	 * @throws NoComponentException
	 */
	private Package getPackageFromSelectedObject(ExecutionEvent event) throws NoComponentException {
		
		ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();

		logger.debug("current selection: " + selection);

		Object selectedUmlElement = selectionUtil.getUmlSelectedObject(selection);
		
		logger.debug("selectedUmlElement: "+selectedUmlElement);
		
		if (selectedUmlElement instanceof Package) {
			return (Package) selectedUmlElement;
		}
		
		throw new NoComponentException();	
	}

	@Override
	public void execPreJobOperations(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		final SmvExportServiceUI smvExportServiceUI = SmvExportServiceUI.getInstance(ChessSystemModel.getInstance(),UMLStateMachineModel.getInstance());
		final NuXmvDirectoryUtil nuXmvDirectoryUtil = NuXmvDirectoryUtil.getInstance();
		final OCRADirectoryUtil ocraDirectoryUtil = OCRADirectoryUtil.getInstance();
		final OCRAExecService ocraExecService = OCRAExecService.getInstance(ChessSystemModel.getInstance());
		Class umlSelectedComponent = null;
		Package pkg = null;
		
		// Try to get the package containing the active element
		try {
			umlSelectedComponent = selectionUtil.getUmlComponentFromSelectedObject(event);
		} catch (NoComponentException e) {
			try {
				pkg = getPackageFromSelectedObject(event);
			} catch (NoComponentException ex) {
				DialogUtil.getInstance().showMessage_ExceptionError(ex);
				throw new ExecutionException(ex.getMessage());
			}
		}
		if (pkg == null) {
			pkg = umlSelectedComponent.getNearestPackage();
		}
		
		// Try to find the system block
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
		
		final boolean isDiscreteTime = true;
		final String smvFileDirectory = nuXmvDirectoryUtil.getSmvFileDirectory();
		
		// If specified, set the given file name, otherwise compute it
		String monolithicSMVFilePath = event.getParameter("file_name");

		if( monolithicSMVFilePath == null ) {
			monolithicSMVFilePath = nuXmvDirectoryUtil.getMonolithicSMVFilePath(umlSelectedComponent.getName());
		}
		final String smvMapFilepath = nuXmvDirectoryUtil.getSmvMapFilePath();
		final String ossFilePath = ocraDirectoryUtil.getOSSFilePath();
		final Resource umlSelectedResource = umlSelectedComponent.eResource();
		final boolean showPopups = false;
		final boolean usexTextValidation = true;
		final boolean isProgrExec = false;

		// Commands cannot be executed in the execJobCommand() method, they need to be synchronous
		logger.debug("exportSmv");
		HashMap<String, String> smvPathComponentNameMap = smvExportServiceUI.exportSmv(umlSelectedComponent,
				showPopups, smvFileDirectory, monitor);

		logger.debug("createMonolithicSMV");
		ocraExecService.createMonolithicSMV(umlSelectedComponent, umlSelectedResource, smvPathComponentNameMap,
				isDiscreteTime, usexTextValidation, showPopups, ossFilePath, smvMapFilepath, 
				monolithicSMVFilePath, isProgrExec, monitor);
		logger.debug("createMonolithicSMV done");
		
		// If requested, show a message at the end of the file generation
		final String showPopup = event.getParameter("show_popup");
		if (showPopup != null && showPopup.equals("true")) {
			SMVGenerationDialogUtil smvGenerationDialogUtil = SMVGenerationDialogUtil.getInstance(); 
			smvGenerationDialogUtil.showMessage_SmvGenerationDone(monolithicSMVFilePath);
		}
	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
	}
}
