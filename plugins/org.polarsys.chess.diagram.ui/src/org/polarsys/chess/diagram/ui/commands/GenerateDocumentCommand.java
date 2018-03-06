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

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Class;
import org.polarsys.chess.diagram.ui.docGenerators.CHESSBlockDefinitionDiagramModel;
import org.polarsys.chess.diagram.ui.docGenerators.CHESSInternalBlockDiagramModel;
import org.polarsys.chess.diagram.ui.services.CHESSDiagramsGeneratorService;
import org.polarsys.chess.diagram.ui.utils.ExportDialogUtils;
import org.polarsys.chess.service.core.model.ChessSystemModel;
import org.polarsys.chess.service.gui.utils.DialogUtils;
import org.polarsys.chess.service.gui.utils.SelectionUtil;

import eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.core.services.OSSTranslatorServiceAPI;
import eu.fbk.eclipse.standardtools.diagram.DiagramDescriptor;
import eu.fbk.eclipse.standardtools.diagram.DocumentGenerator;
import eu.fbk.eclipse.standardtools.diagram.ui.dialog.ModelToDocumentDialog;
import eu.fbk.eclipse.standardtools.diagram.ui.docGenerators.DocumentGeneratorServiceFromOssModel;
import eu.fbk.eclipse.standardtools.utils.core.utils.DirectoryUtil;
import eu.fbk.eclipse.standardtools.utils.ui.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.utils.ui.dialogs.MessageTimeModelDialog;
import eu.fbk.tools.editor.oss.oss.OSS;

public class GenerateDocumentCommand extends AbstractJobCommand {

	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private ChessSystemModel chessToOCRAModelTranslator = ChessSystemModel.getInstance();
	private OSSTranslatorServiceAPI ocraTranslatorService = OSSTranslatorServiceAPI.getInstance(chessToOCRAModelTranslator);
	private ExportDialogUtils exportDialogUtils = ExportDialogUtils.getInstance();
	private DialogUtils dialogUtils = DialogUtils.getInstance();
	private CHESSDiagramsGeneratorService chessDiagramsGeneratorService = CHESSDiagramsGeneratorService
			.getInstance(CHESSInternalBlockDiagramModel.getInstance(), CHESSBlockDefinitionDiagramModel.getInstance());
	private DirectoryUtil directoryUtils = DirectoryUtil.getInstance();

	private DocumentGeneratorServiceFromOssModel documentGeneratorService;

	/**
	 * @param commandName
	 */
	public GenerateDocumentCommand() {
		super("Generate Documentation");
	}

	private Class umlSelectedComponent;
	private boolean isDiscreteTime;
	private ModelToDocumentDialog parameterDialog;
	private String outputDirectoryName;
	private String currentProjectName;
	private Collection<Diagram> chessDiagrams;
	private String imageExtension;
	private String docFormat;

	@Override
	public void execPreJobOperations(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		umlSelectedComponent = selectionUtil.getUmlComponentFromSelectedObject(event);
		isDiscreteTime = MessageTimeModelDialog.openQuestion(false);
		outputDirectoryName = dialogUtils.getDirectoryNameFromDialog();
		currentProjectName = directoryUtils.getCurrentProjectName();
		chessDiagrams = chessDiagramsGeneratorService.getDiagrams();

		parameterDialog = exportDialogUtils.getCompiledModelToDocumentDialog();
		parameterDialog.open();

		if (!parameterDialog.goAhead()) {
			return;
		}

		docFormat = parameterDialog.getDocumentFormat();
		imageExtension = ".svg";
		if (docFormat.equals("tex")) {
			imageExtension = ".png";
		}

		if ((outputDirectoryName == null) || outputDirectoryName.isEmpty()) {
			return;
		}

	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {

		OSS ossModel = ocraTranslatorService.exportRootComponentToOssModel(umlSelectedComponent, isDiscreteTime, monitor);

		Display defaultDisplay = Display.getDefault();

		documentGeneratorService = new DocumentGeneratorServiceFromOssModel(ossModel);
		documentGeneratorService.setParametersBeforeDocumentGeneration(outputDirectoryName, imageExtension,
				parameterDialog.getShowLeafComponents());
		DocumentGenerator documentGenerator = documentGeneratorService.createDocumentFile(currentProjectName, docFormat,
				ossModel.getSystem(), monitor);

		chessDiagramsGeneratorService.setParametersBeforeDiagramsGenerator(outputDirectoryName, imageExtension,
				parameterDialog.getShowPortLabels(), parameterDialog.getAutomaticPortLabelLayout());

		defaultDisplay.syncExec(new Runnable() {
			@Override
			public void run() {
				Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				Set<DiagramDescriptor> diagramDescriptors = new HashSet<DiagramDescriptor>();
				for (Diagram diagram : chessDiagrams) {
					// chessDiagramsGeneratorService.createDiagram(diagram,
					// monitor);
					DiagramDescriptor dd = chessDiagramsGeneratorService.createDiagramWithDescriptor(diagram, shell,
							monitor);
					if (dd != null) {
						diagramDescriptors.add(dd);
					}
				}
				documentGeneratorService.addDiagramDescriptors(diagramDescriptors, documentGenerator);
				documentGeneratorService.generateDocument(documentGenerator);
			}
		});

	}

}
