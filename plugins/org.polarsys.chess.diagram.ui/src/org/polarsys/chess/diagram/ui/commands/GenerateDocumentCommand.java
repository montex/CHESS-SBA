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
import org.polarsys.chess.service.internal.model.ChessSystemModel;
import org.polarsys.chess.service.utils.SelectionUtil;

import eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.services.OCRATranslatorService;
import eu.fbk.eclipse.standardtools.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.diagram.DiagramDescriptor;
import eu.fbk.eclipse.standardtools.diagram.DocumentGenerator;
import eu.fbk.eclipse.standardtools.diagram.ui.dialog.ModelToDocumentDialog;
import eu.fbk.eclipse.standardtools.diagram.ui.docGenerators.DocumentGeneratorServiceFromOssModel;
import eu.fbk.eclipse.standardtools.dialogs.MessageTimeModelDialog;
import eu.fbk.eclipse.standardtools.utils.DirectoryUtil;
import eu.fbk.tools.editor.oss.oss.OSS;

public class GenerateDocumentCommand extends AbstractJobCommand {

	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private ChessSystemModel chessToOCRAModelTranslator = ChessSystemModel.getInstance();
	private OCRATranslatorService ocraTranslatorService = OCRATranslatorService.getInstance(chessToOCRAModelTranslator);
	private ExportDialogUtils exportDialogUtils = ExportDialogUtils.getInstance();
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
	public void execGUIOperations(ExecutionEvent event,IProgressMonitor monitor) throws Exception {
		umlSelectedComponent = selectionUtil.getUmlComponentFromSelectedObject(event);
		isDiscreteTime = MessageTimeModelDialog.openQuestion();
		outputDirectoryName = exportDialogUtils.getDirectoryNameFromDialog();
		currentProjectName = directoryUtils.getCurrentProjectName();
		chessDiagrams = chessDiagramsGeneratorService.getDiagrams();

		//Display defaultDisplay = Display.getDefault();
		//defaultDisplay.syncExec(new Runnable() {
		//	@Override
		//	public void run() {
				parameterDialog = exportDialogUtils.getCompiledModelToDocumentDialog();
				parameterDialog.open();
		//	}
		//});

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

		OSS ossModel = ocraTranslatorService.getOssModel(umlSelectedComponent, isDiscreteTime, monitor);

		Display defaultDisplay = Display.getDefault();
		/*defaultDisplay.syncExec(new Runnable() {
			@Override
			public void run() {
				parameterDialog = exportDialogUtils.getCompiledModelToDocumentDialog();
				parameterDialog.open();
			}
		});

		if (!parameterDialog.goAhead()) {
			return;
		}

		String docFormat = parameterDialog.getDocumentFormat();
		String imageExtension = ".svg";
		if (docFormat.equals("tex")) {
			imageExtension = ".png";
		}

		if ((outputDirectoryName == null) || outputDirectoryName.isEmpty()) {
			return;
		}
*/
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
