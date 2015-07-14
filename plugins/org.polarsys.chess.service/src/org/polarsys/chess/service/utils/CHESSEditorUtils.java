/*
-----------------------------------------------------------------------
--          			CHESS Service plug-in						 --
--                                                                   --
--                    Copyright (C) 2011-2015                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- Author: Alessandro Zovi         azovi@math.unipd.it 		         --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
 */

package org.polarsys.chess.service.utils;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.EditorPart;
import org.polarsys.chess.core.natures.CHESSNature;
import org.polarsys.chess.core.views.DiagramStatus;
import org.polarsys.chess.service.internal.Activator;
import org.polarsys.chess.service.internal.service.CHESSService;
import org.polarsys.chess.service.internal.utils.CHESSInternalEditorUtils;

public class CHESSEditorUtils {

	/**
	 * If the active editor's input belongs to a project with the CHESS nature then return the 
	 * editor.
	 * @return the editor if it is a CHESS editor, null otherwise.
	 */
	public static /*@Nullable*/ PapyrusMultiDiagramEditor getCHESSEditor() {
		IEditorPart editor = CHESSInternalEditorUtils.getEditor();
		PapyrusMultiDiagramEditor r = null;
		if (editor != null && editor instanceof PapyrusMultiDiagramEditor
				&& isCHESSProject(editor))
			r = (PapyrusMultiDiagramEditor) editor;
		return r;
	}

	/**
	 * Get the current active diagram from the active editor.
	 * It uses the org.eclipse.papyrus.infra.core.utils.EditorUtils.getMultiDiagramEditor()
	 * utility method.
	 * @return the active Diagram object. It can be null.
	 */
	static public /*@Nullable*/ Diagram getDiagram() {
		IMultiDiagramEditor editor = EditorUtils.getMultiDiagramEditor();
		return (Diagram) editor.getAdapter(Diagram.class);
	}

	/**
	 * Get the current active diagram given the editor.
	 * @param the editor. It should be not null.
	 * @return the active Diagram object. It can be null.
	 */
	public static /*@Nullable*/ Diagram getDiagram(/*@NunNull*/PapyrusMultiDiagramEditor editor) {
		Object model = editor.getISashWindowsContainer()
				.getActiveSashWindowsPage().getRawModel();
		Diagram diagram = null;
		if (model instanceof PageRef) {
			EObject diagramEObj = ((PageRef) model).getEmfPageIdentifier();
			if (diagramEObj instanceof Diagram) {
				diagram = (Diagram) diagramEObj;
			}

		}
		return diagram;
	}

	

	/**
	 * Return the DiagramEditPart from the active workbench page.
	 * @return the DiagramCommandStack. It can be null.
	 */
	static public /*@Nullable*/ DiagramCommandStack getDiagramCommandStack() {
		try {
			Object stack = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().getActivePart()
					.getAdapter(CommandStack.class);
			return (stack instanceof DiagramCommandStack) ? (DiagramCommandStack) stack
					: null;
		} catch (Exception e) {
			Activator.error("Unexpected error", e);
		}
		return null;
	}

	/**
	 * Return the DiagramEditPart from the active editor. It uses the 
	 * org.eclipse.papyrus.infra.core.utils.EditorUtils.getMultiDiagramEditor()
	 * utility method.
	 * @return the DiagramEditPart. It can be null.
	 */
	static public /*@Nullable*/ DiagramEditPart getDiagramEditPart() {
		IMultiDiagramEditor editor = EditorUtils.getMultiDiagramEditor();
		if (editor != null)
			return (DiagramEditPart) editor.getAdapter(DiagramEditPart.class);
		else
			return null;
	}

	/**
	 * Return the graphical viewer from the active editor. It uses the 
	 * org.eclipse.papyrus.infra.core.utils.EditorUtils.getMultiDiagramEditor()
	 * utility method.
	 * @return the IDiagramGraphicalViewer. It can be null.
	 */
	static public /*@Nullable*/ IDiagramGraphicalViewer getDiagramGraphicalViewer() {
		DiagramEditPart diagramEP = getDiagramEditPart();
		if (diagramEP != null)
			return (IDiagramGraphicalViewer) diagramEP.getViewer();
		else
			return null;
	}

	/**
	 * Get the DiagramStatus object of the CHESS Service given the Papyrus editor.
	 * @param the editor It should be not null.
	 * @return the DiagramStatus object. It can be null.
	 */
	public static /*@Nullable*/ DiagramStatus getDiagramStatus(
			/* @NonNull */ final PapyrusMultiDiagramEditor editor) {
		DiagramStatus ds = null;
		try {
			ServicesRegistry servicesRegistry = editor.getServicesRegistry();
			CHESSService cs = servicesRegistry.getService(
					CHESSService.class);
			
			ds = cs.getDiagramStatus();
		} catch (ServiceException e) {
			Activator.error("CHESS service does not exist.", e);
		}  catch (NullPointerException e) {
			Activator.error("DiagramStatus does not exist", e);
		}
		return ds;
	}

	/**
	 * Get the DiagramStatus object of the CHESS Service given the Papyrus service registry. 
	 * @param registry. It should be not null.
	 * @return the DiagramStatus object. It can be null.
	 */
	public static /*@Nullable*/DiagramStatus getDiagramStatus(/* @NonNull */final ServicesRegistry registry) {
		DiagramStatus ds = null;
		CHESSService cs;
		try {
			cs = registry.getService(CHESSService.class);
			ds = cs.getDiagramStatus();
		} catch (ServiceException e) {
			Activator.error("CHESS service does not exist.", e);
		} catch (NullPointerException e) {
			Activator.error("DiagramStatus does not exist", e);
		}
		return ds;
	}

	/**
	 * Check if the editor passed as a parameter is a CHESS editor; that is if
	 * the input of the editor belongs to a project with the CHESS nature
	 * 
	 * @param the
	 *            editor. It should be not null.
	 * @return true if it is a CHESS editor, false otherwise.
	 */
	public static boolean isCHESSProject(/* @NonNull */final IEditorPart editor) {
		IEditorInput x = editor.getEditorInput();

		IProjectNature nature = null;
		IFile f = null;
		if (x instanceof URIEditorInput) {
			URIEditorInput input = (URIEditorInput) x;
			f = ResourcesPlugin.getWorkspace().getRoot()
					.getFile(new Path(input.getURI().toPlatformString(true)));
		} else if (x instanceof IFileEditorInput) {
			f = ((IFileEditorInput) x).getFile();
		} else {
			// TODO are there other types of input?
		}

		try {
			if (f != null)
				nature = f.getProject().getNature(CHESSNature.NATURE_ID);
		} catch (CoreException e) {
			System.err.println(e.getStackTrace());
		}

		return nature != null;
	}

	/**
	 * Reopen the Papyrus Editor specified in the parameter. Optionally the
	 * editor input can be saved before reopening.
	 * 
	 * @param editor
	 *            the Editor to reopen. It should be not null.
	 * @param save
	 *            set this parameter to true to save the input
	 */
	public static void reopenEditor(/* @NonNull */final IEditorPart editor,
			final Boolean save) {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				IWorkbenchPage page = editor.getEditorSite().getPage();
				IEditorInput input = editor.getEditorInput();
				page.closeEditor(editor, save);
				try {
					page.openEditor(input, PapyrusMultiDiagramEditor.EDITOR_ID,
							save);
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Utility function to create a confirmation Dialog with "OK", "no" and
	 * "cancel" buttons.
	 * 
	 * @param editor
	 *            the editor the dialog belongs to. It should be not null.
	 * @param dialogTitle
	 *            the title of the dialog
	 * @param dialogMessage
	 *            the message to display
	 * @return the MessageDialog created.
	 */
	public static /* @NonNull */ MessageDialog showConfirmDialog(
	/* @NonNull */final EditorPart editor, String dialogTitle,
			String dialogMessage) {
		MessageDialog md = new MessageDialog(editor.getSite().getShell(),
				dialogTitle, null, dialogMessage, MessageDialog.CONFIRM,
				new String[] { "OK", "No", "Cancel" }, 0);
		md.setBlockOnOpen(true);
		return md;
	}
}
