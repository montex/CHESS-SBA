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

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.polarsys.chess.diagram.ui.docGenerators.CHESSInternalBlockDiagramModel;
import org.polarsys.chess.diagram.ui.utils.ExportDialogUtils;

import eu.fbk.eclipse.standardtools.commands.AbstractAsyncJobCommand;
import eu.fbk.eclipse.standardtools.diagram.ui.dialog.ComponentToImageDialog;
import eu.fbk.eclipse.standardtools.diagram.ui.docGenerators.InternalBlockDiagramGeneratorService;
import eu.fbk.eclipse.standardtools.utils.DirectoryUtil;
import org.polarsys.chess.service.utils.SelectionUtil;

/**
 * 
 * @author Alberto
 */
public class ExportComponentToImageCommand extends AbstractAsyncJobCommand {

	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private DirectoryUtil directoryUtils = DirectoryUtil.getInstance();
	private ExportDialogUtils exportDialogUtils = ExportDialogUtils.getInstance();	
	
	//private OCRAComponentToImage ocraComponentToImage = OCRAComponentToImage.getInstance();
	//private DocumentGeneratorService ocraComponentToImage = DocumentGeneratorService.getInstance(CHESSGraphicalModel.getInstance());
	private InternalBlockDiagramGeneratorService diagramGeneratorService = InternalBlockDiagramGeneratorService.getInstance(CHESSInternalBlockDiagramModel.getInstance());
	
	
	public ExportComponentToImageCommand() {
		super("Export Component To Image Command");
	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		
		System.out.println();
		
		GraphicalEditPart selectedGraphicalComponent = selectionUtil
				.getSelectedGraphicalObject(event);

		System.out.println("selectedGraphicalComponent: "+selectedGraphicalComponent);
		
		if (selectedGraphicalComponent != null) {

			final ComponentToImageDialog parameterDialog = exportDialogUtils
					.getCompiledComponentToImageDialog();

			if (!parameterDialog.goAhead()) {
				return;
			}

			String projectDir = directoryUtils.getCurrentProjectDir();
			String imageName = diagramGeneratorService.getImageName(
					selectedGraphicalComponent)+ "." + parameterDialog.getImageFormat() ;

			String imageFilePath = exportDialogUtils.openImageDialog(projectDir, imageName);
			if ((imageFilePath == null) || imageFilePath.isEmpty()) {
				return;
			}

			diagramGeneratorService.setParametersBeforeDiagramGenerator
			//setParametersBeforeExport
			(parameterDialog.getShowPortLabels(),
					parameterDialog.getAutomaticPortLabelLayout());
			diagramGeneratorService.createDiagramFile(imageFilePath, selectedGraphicalComponent,monitor);
			exportDialogUtils.showMessage_ExportDone(imageFilePath);
		}
	
	}

	

}
