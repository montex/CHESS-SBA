/*******************************************************************************
 *                  CHESS core plugin
 *
 *               Copyright (C) 2011-2015
 *            Mälardalen University, Sweden
 *
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License
 *  v1.0 which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.polarsys.chess.fla.launch;

import java.util.List;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.impl.DiagramImpl;

import org.polarsys.chess.fla.impl.FlaAnalysisRunner;

import org.polarsys.chess.core.notifications.ResourceNotification;
import org.polarsys.chess.core.util.uml.ResourceUtils;
import org.polarsys.chess.core.views.DiagramStatus;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.part.InternalBlockDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLDiagramEditor;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.CompositeStructureDiagramEditPart;
import org.polarsys.chess.service.utils.CHESSEditorUtils;

public class FlaAnalysisCommand extends AbstractHandler {

	private IFile modelFile;
	private URI modelURI;
	protected List<IFile> files;
	List<? extends Object> arguments;
	private Model umlModel = null;
	private IContainer targetFolder;
	
	protected UMLDiagramEditor diagramEditor=null;
	protected DiagramEditPart diagramEditPart;
	protected PapyrusMultiDiagramEditor papyrusEditor;
	
	private static final String DI_SUFFIX = ".di";
	private static final String UML_SUFFIX = ".uml";
	
	public static final String COMMAND_ID = "org.polarsys.chess.fla.analysis.command";
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final PapyrusMultiDiagramEditor editor = CHESSEditorUtils.getCHESSEditor();
		final DiagramStatus ds = CHESSEditorUtils.getDiagramStatus(editor);
		
		Classifier rootComponent = getCurrentComponent(editor, ds);
		if (rootComponent == null) {
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Cannot identify root component");
			Activator.getDefault().getLog().log(status);
			throw new ExecutionException("Error during FLA analysis");
		}
		
		
		IFileEditorInput input = (IFileEditorInput)editor.getEditorInput() ;
		
		IFile file = input.getFile();
		IProject activeProject = file.getProject();
		Path path = new Path(activeProject.getName() + "/" + changeSuffix(input.getFile().getName(), DI_SUFFIX,UML_SUFFIX));
		modelURI = URI.createPlatformResourceURI(changeSuffix(input.getFile().getFullPath().toString(), DI_SUFFIX,UML_SUFFIX), true);
		modelFile = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		
		long startTime = System.currentTimeMillis();
		Shell shell = new Shell();	
		try {
			ds.setUserAction(false);
			ProgressMonitorDialog pmDialog = new ProgressMonitorDialog(shell);
			FlaAnalysisRunner analysisRunner = new FlaAnalysisRunner();
			analysisRunner.setModelURI(modelURI);
			targetFolder = modelFile.getProject().getFolder("FLA_Analysis");
			analysisRunner.setTargetFolder(targetFolder);
			analysisRunner.setDiagramEditPart(diagramEditPart);
			Resource resource = ResourceUtils.getUMLResource(editor.getServicesRegistry());
			umlModel = (Model) EcoreUtil.getObjectByType(resource.getContents(), UMLPackage.Literals.MODEL);
			
			analysisRunner.setRootComponent(rootComponent.getQualifiedName());
			analysisRunner.setChessResource(resource);
			
			pmDialog.run(true, true, analysisRunner);
			
			activeProject.refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (InvocationTargetException e) {
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
			Activator.getDefault().getLog().log(status);
			throw new ExecutionException("Error during FLA analysis", e);
		} catch (CoreException e) {
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
			Activator.getDefault().getLog().log(status);
			throw new ExecutionException("Error during FLA analysis", e);
		} catch (InterruptedException e) {
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
			Activator.getDefault().getLog().log(status);
		} catch (ServiceException e) {
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
			Activator.getDefault().getLog().log(status);
		} finally {
			ds.setUserAction(true);
		}
		long endTime = System.currentTimeMillis();
		org.polarsys.chess.core.util.CHESSProjectSupport.printlnToCHESSConsole("*** Elapsed time " + (endTime - startTime) / 1e3 + " s ***");
		return null;
	}
	
	private String changeSuffix(String string, String oldSuffix, String newSuffix){
		String newString = string;
		if (newString.endsWith(oldSuffix)){
			newString = newString.substring(0, newString.length() - oldSuffix.length());
			newString += newSuffix;
		}
		return newString;		
	}
	
	private Classifier getCurrentComponent(PapyrusMultiDiagramEditor editor, DiagramStatus ds) {
		if (editor == null || ds == null) {
			return null;
		}
		Classifier rootComponent = null;
		try {
			Object editPart = getEditPart();
			
			if (editPart == null ||  ( !(editPart instanceof CompositeStructureDiagramEditPart) && !(editPart instanceof InternalBlockDiagramEditPart)) )
				throw new Exception("FLA analysis cannot be performed on this element");
			
			final DiagramEditPart csd_ep = (DiagramEditPart) editPart;
			diagramEditPart = csd_ep;
			
			DiagramImpl diagram = (DiagramImpl) csd_ep.getModel();
			rootComponent = (Classifier) diagram.getElement();
			
		} catch (Exception e) {
			e.printStackTrace();
			ResourceNotification.showInfo(e.getMessage());
		}
		
		return rootComponent;
	}

	private Object getEditPart() {
		Object ep = null;
		try {
				ep = CHESSEditorUtils.getDiagramGraphicalViewer().getRootEditPart().getChildren().get(0);	
		} catch (Exception e) {
			//Catch NPE
			return null;
		}
		return ep;
	}
	
	
}