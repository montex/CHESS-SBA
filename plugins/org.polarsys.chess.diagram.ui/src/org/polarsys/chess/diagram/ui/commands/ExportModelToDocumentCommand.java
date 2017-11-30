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
package org.polarsys.chess.diagram.ui.commands;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.polarsys.chess.diagram.ui.docGenerators.CHESSInternalBlockDiagramModel;
import org.polarsys.chess.diagram.ui.utils.ExportDialogUtils;
import org.polarsys.chess.service.utils.SelectionUtil;

import eu.fbk.eclipse.standardtools.commands.AbstractAsyncJobCommand;
import eu.fbk.eclipse.standardtools.diagram.ui.dialog.ModelToDocumentDialog;
import eu.fbk.eclipse.standardtools.diagram.ui.docGenerators.DocumentGeneratorService;
import eu.fbk.eclipse.standardtools.utils.DirectoryUtil;

/**
 * 
 * @author Alberto
 */
public class ExportModelToDocumentCommand extends AbstractAsyncJobCommand {

	public ExportModelToDocumentCommand() {
		super("Export Model To Document");
	}

	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private DirectoryUtil directoryUtils = DirectoryUtil.getInstance();
	private ExportDialogUtils exportDialogUtils = ExportDialogUtils.getInstance();
	//private OCRAComponentToImage ocraComponentToImage = OCRAComponentToImage.getInstance();
	private DocumentGeneratorService documentGeneratorService = DocumentGeneratorService.getInstance(CHESSInternalBlockDiagramModel.getInstance());
	
	private static final Logger logger = Logger.getLogger(ExportComponentToImageCommand.class);
	
	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {

		GraphicalEditPart selectedGraphicalComponent = selectionUtil.getSelectedGraphicalObject(event);

		if (selectedGraphicalComponent != null) {

			logger.debug("selectedGraphicalComponent: " + selectedGraphicalComponent);

			ModelToDocumentDialog parameterDialog = exportDialogUtils.getCompiledModelToDocumentDialog();

			if (!parameterDialog.goAhead()) {
				return;
			}

			String docFormat = parameterDialog.getDocumentFormat();
			String imageExtension = ".svg";
			if (docFormat.equals("tex")) {
				imageExtension = ".png";
			}
	
			// setShowLeafComponents(showLeafComponents);
			String outputDirectoryName = exportDialogUtils.getDirectoryNameFromDialog();
			// setDirectoryName(directoryName);
			if ((outputDirectoryName == null) || outputDirectoryName.isEmpty()) {
				return;
			}

			String currentProjectName = directoryUtils.getCurrentProjectName();
	
			documentGeneratorService.setParametersBeforeDocumentGeneration
			//setParametersBeforeExport
			(parameterDialog.getShowPortLabels(), parameterDialog.getAutomaticPortLabelLayout(),
					outputDirectoryName, imageExtension,parameterDialog.getShowLeafComponents());

			// ocraComponentToImage.setXTranslation(150);
			// ocraComponentToImage.setYTranslation(100);

			documentGeneratorService.createDocumentFile(currentProjectName, docFormat, selectedGraphicalComponent,
					 monitor);

			exportDialogUtils.showMessage_ExportDone(outputDirectoryName);

		}

	}


}
