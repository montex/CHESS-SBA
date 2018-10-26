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

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.polarsys.chess.fla.impl.FlaAnalysisRunnerXml;

import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLDiagramEditor;

public class FlaAnalysisCommandXml extends AbstractHandler {

	protected IFile sourceFile;
	List<? extends Object> arguments;
	private IContainer targetFolder;
	
	protected UMLDiagramEditor diagramEditor=null;
	protected DiagramEditPart clazzdiagrameditPart;
	protected PapyrusMultiDiagramEditor papyrusEditor;
	private static JFrame frame = new JFrame();

	public static final String COMMAND_ID = "org.polarsys.chess.fla.analysis.command";
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		sourceFile = handleBrowseFile("Concerto-FLA Analysis from XML", "Please choose source XML file");
		if(sourceFile==null)
			return null;

		if(!sourceFile.getLocation().getFileExtension().equals("xml") && !sourceFile.getLocation().getFileExtension().equals("fla")){
			JOptionPane.showMessageDialog(frame, "Chosen file is not XML file. To perform Concerto-FLA Analysis please choose XML file. " ,"Concerto-FLA Analysis has failed", JOptionPane.ERROR_MESSAGE);
			return null;
		}			
		
		targetFolder = sourceFile.getParent(); 

		Shell shell = new Shell();	
		try {
			ProgressMonitorDialog pmDialog = new ProgressMonitorDialog(shell);
			FlaAnalysisRunnerXml analysisRunner = new FlaAnalysisRunnerXml();
			analysisRunner.setSelectedXmlFile(sourceFile);
			analysisRunner.setTargetFolder(targetFolder);
			pmDialog.run(true, true, analysisRunner);
			
		} catch (InvocationTargetException e) {
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
			Activator.getDefault().getLog().log(status);
			throw new ExecutionException("Error during FLA analysis", e);
		} catch (InterruptedException e) {
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
			Activator.getDefault().getLog().log(status);
		} 
		return null;
	}
	
	private IFile handleBrowseFile(String title, String message) {

		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(new Shell(), new WorkbenchLabelProvider(), new BaseWorkbenchContentProvider());

		dialog.setTitle(title);
		dialog.setMessage(message);
		dialog.setAllowMultiple(false);
		dialog.addFilter(new ViewerFilter() {
			@Override
			public boolean select(Viewer viewer, Object parentElement,
					Object element) {
				boolean ret = false;
				String[] extensions = null;
				extensions = new String[] { "xml" };
				try {
					ret = isXMLResource((IResource) element, extensions);
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return ret;
			}
		});
		dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
		dialog.open();

		if(dialog.getReturnCode() == ElementTreeSelectionDialog.CANCEL){
			return null;
		}

		Object results = dialog.getFirstResult();

		if ((results != null) && (results instanceof IFile)) {
			IFile currentFile = (IFile)results;	
			return currentFile;
		}
		else if ((results != null) && ((results instanceof IFolder) || (results instanceof IProject))) {
			JOptionPane.showMessageDialog(frame, "CHESS-FPTC Analysis failed. XML file was not chosed. ","CHESS-FPTC Analysis - Wrong input file", JOptionPane.ERROR_MESSAGE);
			return null;
		}

		return null;
	}

	private static boolean isXMLResource(IResource resource, String[] extensions)
			throws CoreException {
		if (resource instanceof IContainer) {
			if (((IContainer) resource).isAccessible()) {
				IResource[] members = ((IContainer) resource).members();
				for (IResource member : members) {
					if (isXMLResource(member, extensions)) {
						return true;
					}
				}
			}
		} else if (resource instanceof IFile) {
			IFile currentFile = (IFile) resource;
			if (extensions == null) {
				return true;
			} else if (currentFile.getFileExtension() != null) {
				for (int i = 0; i < extensions.length; i++) {
					String extension = extensions[i];
					if (currentFile.getFileExtension().toUpperCase().equals(
							extension.toUpperCase())) {
						return true;
					}
				}
			}
		}
		return false;
	}

	
}