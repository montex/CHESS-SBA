/*
-----------------------------------------------------------------------
--          			CHESS editor plugin							 --
--                                                                   --
--                    Copyright (C) 2011-2012                        --
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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.uml2.uml.Port;
import org.polarsys.chess.core.natures.CHESSNature;
import org.polarsys.chess.core.views.DiagramStatus;
import org.polarsys.chess.service.CHESSService;

public class CHESSEditorUtils {
	static public DiagramCommandStack getDiagramCommandStack() {
		try {
			Object stack = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().getActivePart()
					.getAdapter(CommandStack.class);
			return (stack instanceof DiagramCommandStack) ? (DiagramCommandStack) stack
					: null;
		} catch (Exception e) {
		}
		return null;
	}

	static public Diagram getDiagram() {
		IMultiDiagramEditor editor = EditorUtils.getMultiDiagramEditor();
		return (Diagram) editor.getAdapter(Diagram.class);
	}

	static public DiagramEditPart getDiagramEditPart() {
		IMultiDiagramEditor editor = EditorUtils.getMultiDiagramEditor();
		return (DiagramEditPart) editor.getAdapter(DiagramEditPart.class);
	}

	static public IDiagramGraphicalViewer getDiagramGraphicalViewer() {
		DiagramEditPart diagramEP = getDiagramEditPart();
		return (IDiagramGraphicalViewer) diagramEP.getViewer();
	}

	static public List<View> getDiagramAllVisiblePort(final View diagram) {
		return getDiagramAllVisiblePortRecur(new ArrayList<View>(), diagram);
	}

	static private List<View> getDiagramAllVisiblePortRecur(List<View> list,
			View view) {
		for (Object v : view.getVisibleChildren()) {
			if (!(v instanceof View))
				continue;
			if (((View) v).getElement() instanceof Port)
				list.add((View) v);
			getDiagramAllVisiblePortRecur(list, (View) v);
		}
		return list;

	}

	public static IEditorPart getEditor() {
		IEditorPart editor;
		try {
			editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().getActiveEditor();
		} catch (Exception e) {
			editor = null;
		}
		return editor;
	}

	public static PapyrusMultiDiagramEditor getCHESSEditor() {
		IEditorPart editor = getEditor();
		PapyrusMultiDiagramEditor r = null;
		if (editor != null && editor instanceof PapyrusMultiDiagramEditor
				&& isCHESSProject(editor))
			r = (PapyrusMultiDiagramEditor) editor;
		return r;
	}

	public static DiagramStatus getDiagramStatus(
			PapyrusMultiDiagramEditor editor) {
		DiagramStatus ds = null;
		try {
			CHESSService cs = editor.getServicesRegistry().getService(CHESSService.class);
			ds = cs.getDiagramStatus();
		} catch (ServiceException e) {
		}
		return ds;
	}

	public static MessageDialog showConfirmDialog(EditorPart editor,
			String dialogTitle, String dialogMessage) {
		MessageDialog md = new MessageDialog(editor.getSite().getShell(),
				dialogTitle, null, dialogMessage, MessageDialog.CONFIRM,
				new String[] { "OK", "No", "Cancel" }, 0);
		md.setBlockOnOpen(true);
		return md;
	}

	public static MessageDialog showYesNoDialog(EditorPart editor,
			String dialogTitle, String dialogMessage) {
		MessageDialog md = new MessageDialog(editor.getSite().getShell(),
				dialogTitle, null, dialogMessage, MessageDialog.CONFIRM,
				new String[] { "Yes", "No" }, 0);
		md.setBlockOnOpen(true);
		return md;
	}

	public static int StatusDialog(EditorPart editor, String dialogTitle,
			String dialogMessage, IStatus st) {
		// return ErrorDialog.openError(editor.getSite().getShell(),
		// dialogTitle, dialogMessage, st);
		ErrorDialog er = new ErrorDialog(editor.getSite().getShell(),
				dialogTitle, dialogMessage, st, IStatus.ERROR) {

			protected void createButtonsForButtonBar(Composite parent) {
				// create OK and Details buttons
				createButton(parent, IDialogConstants.YES_ID,
						IDialogConstants.YES_LABEL, true);
				createButton(parent, IDialogConstants.NO_ID,
						IDialogConstants.NO_LABEL, true);
				createDetailsButton(parent);
			}

			protected void buttonPressed(int id) {
				if (id == IDialogConstants.YES_ID)
					id = IDialogConstants.OK_ID;
				if (id == IDialogConstants.NO_ID) {
					setReturnCode(5);
					close();
				} else {
					super.buttonPressed(id);
				}
			}
		};
		return er.open();
		// md = new
		// MessageDialog mm = new MessageDialog(
		// editor.getSite().getShell(),
		// dialogTitle,
		// null,
		// dialogMessage,
		// MessageDialog.CONFIRM, new String[] { "Yes", "No" }, 0);
		// md.setBlockOnOpen(true);
		// return md;
	}

	public static void reopenEditor(final IEditorPart editor, final Boolean save) {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				IWorkbenchPage page = editor.getEditorSite().getPage();
				IEditorInput input = editor.getEditorInput();
				page.closeEditor(editor, save);

				// IEditorDescriptor desc =
				// page.getWorkbenchWindow().getWorkbench().getEditorRegistry().findEditor(CHESSEditor.ID);

				// IEditorDescriptor desc =
				// page.getWorkbenchWindow().getWorkbench().getEditorRegistry().getDefaultEditor(input.getName());
				try {
					page.openEditor(input, PapyrusMultiDiagramEditor.EDITOR_ID, save);
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static boolean isCHESSProject(IEditorPart editor) {
		IEditorInput x = editor.getEditorInput();
		
		IProjectNature nature = null;
		
		if (x instanceof URIEditorInput) {
			URIEditorInput h = (URIEditorInput) x;
			IFile f = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(h.getURI().toPlatformString(true)));
			try {
				nature = f.getProject().getNature(CHESSNature.NATURE_ID);
			} catch (CoreException e) {
				System.err.println(e.getStackTrace());
			}
		}else
		
		
		if (x instanceof IFileEditorInput) {
			IFile y = ((IFileEditorInput) x).getFile();

			try {
				nature = y.getProject().getNature(CHESSNature.NATURE_ID);
			} catch (CoreException e) {
				System.err.println(e.getStackTrace());
			}
		}
		return nature != null;
	}
	
	public static Diagram getDiagram(PapyrusMultiDiagramEditor editor) {
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

	public static DiagramStatus getDiagramStatus(ServicesRegistry registry) {
		DiagramStatus ds = null;
		CHESSService cs;
		try {
			cs = registry.getService(CHESSService.class);
			ds = cs.getDiagramStatus();
		} catch (ServiceException e) {
		}
		return ds;
	}

}
