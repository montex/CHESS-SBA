package org.polarsys.chess.diagram.ui.commands;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.uml2.uml.Class;
import org.polarsys.chess.diagram.ui.docGenerators.CHESSBlockDefinitionDiagramModel;
import org.polarsys.chess.diagram.ui.docGenerators.CHESSInternalBlockDiagramModel;
import org.polarsys.chess.diagram.ui.services.CHESSDiagramsGeneratorService;
import org.polarsys.chess.diagram.ui.utils.ExportDialogUtils;
import org.polarsys.chess.service.internal.utils.SelectionUtil;
import org.polarsys.chess.verificationService.model.ChessSystemModel;

import eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.services.OCRATranslatorService;
import eu.fbk.eclipse.standardtools.commands.AbstractAsyncJobCommand;
import eu.fbk.eclipse.standardtools.diagram.DiagramDescriptor;
import eu.fbk.eclipse.standardtools.diagram.DocumentGenerator;
import eu.fbk.eclipse.standardtools.diagram.ui.dialog.ModelToDocumentDialog;
import eu.fbk.eclipse.standardtools.diagram.ui.docGenerators.DocumentGeneratorServiceFromOssModel;
import eu.fbk.eclipse.standardtools.diagram.ui.services.DiagramDialogUtil;
import eu.fbk.eclipse.standardtools.dialogs.MessageTimeModelDialog;
import eu.fbk.eclipse.standardtools.utils.DirectoryUtil;
import eu.fbk.tools.editor.oss.oss.OSS;

public class GenerateDocumentCommand extends AbstractAsyncJobCommand {

	
	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private ChessSystemModel chessToOCRAModelTranslator = ChessSystemModel.getInstance();
	private OCRATranslatorService ocraTranslatorService = OCRATranslatorService.getInstance(chessToOCRAModelTranslator);
	private ExportDialogUtils exportDialogUtils = ExportDialogUtils.getInstance();
	private CHESSDiagramsGeneratorService chessDiagramsGeneratorService = CHESSDiagramsGeneratorService.getInstance(CHESSInternalBlockDiagramModel.getInstance(),CHESSBlockDefinitionDiagramModel.getInstance());
	
	
	private DirectoryUtil directoryUtils = DirectoryUtil.getInstance();
	
	private DocumentGeneratorServiceFromOssModel documentGeneratorService ;
	/**
	 * @param commandName
	 */
	public GenerateDocumentCommand() {
		super("Generate Documentation");
	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		
		
		Class umlSelectedComponent = selectionUtil.getUmlComponentFromSelectedObject(event);
		boolean isDiscreteTime = MessageTimeModelDialog.openQuestion();
		
		OSS ossModel = ocraTranslatorService.getOssModel(umlSelectedComponent, isDiscreteTime, monitor);
		
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
		System.out.println("currentProjectName: "+currentProjectName);
		
		
		//documentGeneratorService = DocumentGeneratorServiceFromOssModel.getInstance(CHESSDiagramModel.getInstance(), ossModel);
		documentGeneratorService = new DocumentGeneratorServiceFromOssModel(ossModel);
		documentGeneratorService.setParametersBeforeDocumentGeneration(
				//parameterDialog.getShowPortLabels(), parameterDialog.getAutomaticPortLabelLayout(),
				outputDirectoryName, imageExtension, parameterDialog.getShowLeafComponents());
		DocumentGenerator documentGenerator = documentGeneratorService.createDocumentFile(currentProjectName, docFormat, ossModel.getSystem(), monitor);
		
		
		//documentGeneratorService.setParametersBeforeDiagramsGenerator(
			//	outputDirectoryName, imageExtension,parameterDialog.getShowPortLabels(), parameterDialog.getAutomaticPortLabelLayout());
	
		
		
		chessDiagramsGeneratorService.setParametersBeforeDiagramsGenerator(outputDirectoryName, 
				imageExtension, 
				parameterDialog.getShowPortLabels(), 
				parameterDialog.getAutomaticPortLabelLayout());
		
		Set<DiagramDescriptor> diagramDescriptors = new HashSet<DiagramDescriptor>();		
		for(Diagram diagram : chessDiagramsGeneratorService.getDiagrams()){			
		//chessDiagramsGeneratorService.createDiagram(diagram, monitor);
			DiagramDescriptor dd = chessDiagramsGeneratorService.createDiagramWithDescriptor(diagram, monitor);
			if(dd!=null){
			diagramDescriptors.add(dd);
			}
		}
		
													   
		documentGeneratorService.addDiagramDescriptors(diagramDescriptors, documentGenerator);
		documentGeneratorService.generateDocument(documentGenerator);
		
	}

}
