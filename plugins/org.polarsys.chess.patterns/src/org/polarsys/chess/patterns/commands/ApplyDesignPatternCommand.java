package org.polarsys.chess.patterns.commands;

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EObjectTreeElement;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.polarsys.chess.core.util.uml.ResourceUtils;
import org.polarsys.chess.patterns.apply.ApplyPattern;
import org.polarsys.chess.patterns.dialogs.AbstractMappingDialog;
import org.polarsys.chess.patterns.dialogs.ConnectorMappingDialog;
import org.polarsys.chess.patterns.dialogs.PortMappingDialog;
import org.polarsys.chess.patterns.dialogs.PropertyMappingDialog;
import org.polarsys.chess.patterns.dialogs.SelectDesignPatternDialog;
import org.polarsys.chess.patterns.dialogs.TypeMappingDialog;
import org.polarsys.chess.patterns.profile.PatternsProfile.Pattern;
import org.polarsys.chess.service.gui.utils.CHESSEditorUtils;

public class ApplyDesignPatternCommand extends AbstractHandler {
	
	private final static String[] STEPS = {"selection", "types", "ports", "properties", "connectors"};

	private int currentStep = 0;
	
	private Pattern pattern = null;
	private Class modelCtx = null;
	private Image patternPreview = null;
	
	private Map<NamedElement,NamedElement> mappings = null;
	private boolean cancelled = false;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		final Shell shell = HandlerUtil.getActiveShell(event);
		
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		

		if(selection instanceof StructuredSelection){
			if(((StructuredSelection) selection).size() == 1){
				Object selectedElem = ((StructuredSelection) selection).getFirstElement();
				if(selectedElem instanceof EObjectTreeElement){
					EObject eobj = ((EObjectTreeElement)selectedElem).getEObject();
					if(eobj instanceof Class){
						modelCtx = (Class) eobj;
//						System.out.println("selection (context): " + modelCtx.getName());	
					}
				}

			}else{
				shell.getDisplay().asyncExec(new Runnable(){
					@Override
					public void run() {
						MessageDialog.openError(shell, "Select and Apply Design Pattern", " this command should be called only on a single (composed) Class");
					}
				});
				return null;
			}
		}
		
		PapyrusMultiDiagramEditor editor = CHESSEditorUtils.getCHESSEditor();
		Model chessModel = null;
		try {
			Resource chessResource = ResourceUtils.getUMLResource(editor.getServicesRegistry());
			chessModel = (Model) chessResource.getContents().get(0);

			if (chessModel != null){
				
				currentStep = 0;
				cancelled = false;
				
				while (currentStep < STEPS.length && !cancelled){
					performStep(shell, chessModel);
				}		
				
				if(currentStep ==  STEPS.length && !cancelled){
					ApplyPattern applyPattern = new ApplyPattern(mappings, pattern, modelCtx);
					applyPattern.apply();
				}
			}
		}catch (ServiceException e) {
			shell.getDisplay().asyncExec(new Runnable(){
				@Override
				public void run() {
					MessageDialog.openError(shell, "Select and Apply a Design Pattern", "Unable to open the CHESS model: " + e.getMessage());
				}
			});
		}catch (Exception e){
			shell.getDisplay().asyncExec(new Runnable(){
				@Override
				public void run() {
					MessageDialog.openError(shell, "Select and Apply Design Pattern", "Error during the execution of the command: " + e.getMessage());
				}
			});
			e.printStackTrace();
		}
			
		return null;
	}

	private void performStep(Shell shell, Model chessModel) {
		
		switch (currentStep) {
		case 0:
			SelectDesignPatternDialog selectDesignPattern = new SelectDesignPatternDialog(shell, chessModel);
			if(selectDesignPattern.open() == Window.OK){
				pattern = selectDesignPattern.getSelectedPattern();
				patternPreview = selectDesignPattern.getPatternPreview();
				currentStep++;
			}else{
				cancelled = true;
			}
			break;
		case 1:
			if(pattern != null){
				TypeMappingDialog mapTypesDialog = new TypeMappingDialog(shell, chessModel, pattern, modelCtx, patternPreview);
				int code = mapTypesDialog.open();
				if(code == Window.OK){
					mappings = mapTypesDialog.getMappings();
					currentStep++;
				}else if(code == AbstractMappingDialog.BACK){
					currentStep--;
				}else{
					cancelled = true;
				}
			}
			break;
		case 2:
			if(mappings != null && !cancelled){
				PortMappingDialog mapPortsDialog = new PortMappingDialog(shell, chessModel, pattern, modelCtx, mappings, patternPreview);
				int code = mapPortsDialog.open();
				if(code == Window.OK){
					mappings.putAll(mapPortsDialog.getMappings());
					currentStep++;
				}else if(code == AbstractMappingDialog.BACK){
					currentStep--;
				}else{
					cancelled = true;
				}
			}
			break;
		case 3:
			if(mappings != null && !cancelled){
				PropertyMappingDialog mapPropertyDialog = new PropertyMappingDialog(shell, chessModel, pattern, modelCtx, mappings, patternPreview);
				int code = mapPropertyDialog.open(); 
				if(code == Window.OK){
					mappings.putAll(mapPropertyDialog.getMappings());
					currentStep++;
				}else if(code == AbstractMappingDialog.BACK){
					currentStep--;
				}else{
					cancelled = true;
				}
			}
			break;
		case 4:
			if(mappings != null && !cancelled){
				ConnectorMappingDialog mapConnectorDialog = new ConnectorMappingDialog(shell, chessModel, pattern, modelCtx, mappings, patternPreview);
				int code =mapConnectorDialog.open(); 
				if(code == Window.OK){
					mappings.putAll(mapConnectorDialog.getMappings());
					currentStep++;
				}else if(code == AbstractMappingDialog.BACK){
					currentStep--;
				}else{
					cancelled = true;
				}
			}
			break;

		default:
			break;
		}
	}

}
