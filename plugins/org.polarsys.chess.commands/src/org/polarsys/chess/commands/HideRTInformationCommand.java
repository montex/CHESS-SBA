/*******************************************************************************
 * Copyright (c) 2011 -2014 Intecs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Stefano Puri, Nicholas Pacini - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.chess.commands;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.uml.diagram.common.editparts.NamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ClassCompositeEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ComponentCompositeEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.CompositeStructureDiagramEditPart;
import org.polarsys.chess.core.notifications.ResourceNotification;
import org.polarsys.chess.core.views.DiagramStatus;
import org.polarsys.chess.service.gui.utils.CHESSEditorUtils;


/**
 * Allows to hide the CHRtSpecification Comments available on the selected Papyrus diagram
 */
public class HideRTInformationCommand extends AbstractHandler{

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * hides CHRtSpecification Comment on the current diagram
	 */
	public Object hide() throws ExecutionException {
		final PapyrusMultiDiagramEditor editor = CHESSEditorUtils.getCHESSEditor();
		final DiagramStatus ds = CHESSEditorUtils.getDiagramStatus(editor);
		if (editor == null || ds == null) 
			return null;
		try {
			
				
			Object temp = CHESSEditorUtils.getDiagramGraphicalViewer().getRootEditPart().getChildren().get(0);
			
			if (temp == null || !(temp instanceof CompositeStructureDiagramEditPart))
				return null;
			
			final CompositeStructureDiagramEditPart csd_ep = (CompositeStructureDiagramEditPart) temp;
			TransactionalEditingDomain editingDomain = csd_ep.getEditingDomain();
			
			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
				protected void doExecute() {
					
					List l = csd_ep.getChildren();
					EditPart epTemp = null;
					NamedElementEditPart compositeEP = null;
					for (int i=0; i< l.size(); i++){
						epTemp = (EditPart) l.get(i);
						if (epTemp instanceof ComponentCompositeEditPart){
							compositeEP = (ComponentCompositeEditPart) epTemp;
							break;
						}
						if (epTemp instanceof ClassCompositeEditPart){
							compositeEP = (ClassCompositeEditPart) epTemp;
							break;
						}
						
					}
					
					if (ShowRTInformationCommand.showHideRT((Shape)compositeEP.getModel(), false)){
						ds.setUserAction(false);
					}
				}
			});
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
				ResourceNotification.showInfo(e.getMessage());
				ds.setUserAction(true);
			}
			ds.setUserAction(true);
			return null;
		}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub
		return hide();
	}
}
