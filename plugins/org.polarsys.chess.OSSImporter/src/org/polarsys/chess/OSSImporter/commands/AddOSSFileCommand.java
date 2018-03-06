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
package org.polarsys.chess.OSSImporter.commands;

import java.io.File;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.edit.ui.action.ValidateAction.EclipseResourcesUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.polarsys.chess.OSSImporter.actions.ImportOSSFileAction;
import org.polarsys.chess.service.gui.utils.SelectionUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import eu.fbk.eclipse.standardtools.utils.core.exceptions.NoResourceException;
import eu.fbk.eclipse.standardtools.utils.ui.commands.AbstractJobCommand;
import eu.fbk.eclipse.standardtools.utils.ui.utils.ErrorsDialogUtil;

public class AddOSSFileCommand extends AbstractJobCommand implements IHandler {
	private static final String SYSVIEW =	"CHESS::Core::CHESSViews::SystemView";
	private static final String PROBLEMS_VIEW = "org.eclipse.ui.views.ProblemView";
	private static final String DIALOG_TITLE =	"OSS parser";
	
	private ImportOSSFileAction sampleView;
	private Object umlObject;
	private File ossFile;
	private Resource modelResource;
	private boolean showNoErrorPopup = true;
	private ErrorsDialogUtil ocraRuntimeErrorsDialogUtil = ErrorsDialogUtil.getInstance();
	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	
	/**
	 * Constructor.
	 */
	public AddOSSFileCommand() {
		super("Add content from OSS file");
	}
	
	/**
	 * Utility dialog to display a message on screen.
	 * @param title the title of the dialog
	 * @param message the text to display
	 */
	private void showMessage(String title, String message) {
		MessageDialog.openInformation(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),title, message);
	}
	
	
	//TODO try to reuse existing methods
	private String[] showOSSRuntimeErrors(Resource resource, File file, boolean showNoErrorPopup, IProgressMonitor monitor) throws NoResourceException {
		if (resource != null) {
			if (file != null) {
				if (file.exists()) {
					monitor.subTask("show Runtime Errors");
					String[] errors = showRuntimeErrors(resource, file);
					ocraRuntimeErrorsDialogUtil.showMessage_RuntimeErrors(file.getName(), errors, showNoErrorPopup);
					monitor.worked(1);
					
					return errors;
				}
			}
		} else {
			throw new NoResourceException();
		}
		return null;
	}
	
	/**
	 * Visualizes all the errors in the error view of Eclipse.
	 */
	private String[] showRuntimeErrors(Resource resource, File ossFile) {

		XtextResource xTextRes = getXtextResourceFromFile(ossFile.getPath());

		EclipseResourcesUtil eclipseResourcesUtil = new EclipseResourcesUtil();
		eclipseResourcesUtil.deleteMarkers(resource);
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(xTextRes.getContents().get(0));
		if (diagnostic.getChildren().size() > 0) {

			for (Diagnostic d : diagnostic.getChildren()) {
				eclipseResourcesUtil.createMarkers(resource, d);
			}

			openProblemsView();

			return getErrorsString(diagnostic);
		}
		return null;
	}

	private void openProblemsView() {
		Display defaultDisplay = Display.getDefault();

		defaultDisplay.syncExec(new Runnable() {
			@Override
			public void run() {
				try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(PROBLEMS_VIEW);
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		});
	}

	private String[] getErrorsString(Diagnostic diagnostic) {
		String[] errors = new String[diagnostic.getChildren().size()];
		int i = 0;
		for (Diagnostic d : diagnostic.getChildren()) {
			errors[i] = d.getMessage();
			i++;
		}
		return errors;
	}

	/**
	 * @param path
	 *            the path of the oss file
	 * @return the XTextResource of the oss model
	 */
	private XtextResource getXtextResourceFromFile(String path) {
		final XtextResourceSet resourceSet = new XtextResourceSet();
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		return (XtextResource) resourceSet.getResource(URI.createFileURI(path), true);
	}
	
	/**
	 * Checks if the given OSS file is valid or contains errors
	 */
	private String[] showRuntimeErrors(Resource resource, File ossFile, boolean showNoErrorPopup, IProgressMonitor monitor) throws Exception {

		monitor.beginTask("Show Runtime Errors", 1);
		
		String[] errors = showOSSRuntimeErrors(resource, ossFile,showNoErrorPopup, monitor);

		monitor.done();
		
		return errors;
	}

	//TODO this method already exist in another plugin 
	/**
	 * Displays a file dialog to select the OSS file
	 * @return the selected File
	 */
	private File getOSSFile() {
		File ossFile = null;

		FileDialog dialog = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.OPEN);
		dialog.setFilterExtensions(new String [] {"*.oss", "*.OSS"});
		String result = dialog.open();
		
		try {
			ossFile = new File(result);
		} catch (NullPointerException e) {
			e.printStackTrace();
			showMessage(DIALOG_TITLE, "File not valid!");
		}
		return ossFile;
	}
	
	
	/**
	 * Checks if the selected object is a package in the <<SystemView>> branch 
	 * @param pkg the selected object 
	 * @return true if the package is valid
	 */
	private boolean isSystemViewPackage(Element obj) {
		if (obj instanceof Package) {
			final Package pkg = (Package) obj;
			if(pkg.getAppliedStereotype(SYSVIEW) != null) {
				return true;
			} else {
				EList<Package> owningPackages = pkg.allOwningPackages();
				for (Package owningPackage : owningPackages) {
					if (owningPackage.getAppliedStereotype(SYSVIEW) != null) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public void execPreJobOperations(ExecutionEvent event, IProgressMonitor monitor) throws Exception {

		final ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		umlObject = selectionUtil.getUmlSelectedObject(selection);
		modelResource = selectionUtil.getSelectedModelResource();
	
//		System.out.println("selectedUmlElement: " + umlObject);
		
		if (isSystemViewPackage((Element) umlObject)) {
			ossFile = getOSSFile();

			final String[] errors = showRuntimeErrors(modelResource, ossFile, showNoErrorPopup, monitor);
			
			monitor.beginTask("Importing elements from OSS file", 1);

			sampleView = ImportOSSFileAction.getInstance();

			if (errors == null && sampleView != null) {
				IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				activePage.setEditorAreaVisible(false);
				try {
					sampleView.startParsing((Package) umlObject, ossFile);
				} catch (Exception e) {
					showMessage(DIALOG_TITLE, e.getMessage());
					monitor.done();
					return;
				}
				activePage.setEditorAreaVisible(true);
				showMessage(DIALOG_TITLE, "Import done!");
			}
			monitor.done();
			return;
		}
		showMessage(DIALOG_TITLE, "Please select a package from <<SystemView>>");
	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		
//		String[] errors = showRuntimeErrors(modelResource, ossFile, showNoErrorPopup, monitor);
//		
//		monitor.beginTask("Importing elements from OSS file", 1);
//		
//		if (errors == null && sampleView != null) {
//			sampleView.startParsing((Package) umlObject, ossFile);
//		}
//		
//		monitor.done();
	}
}
