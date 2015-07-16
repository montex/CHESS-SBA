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

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.impl.BasicCompartmentImpl;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.uml.diagram.common.editparts.NamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ClassCompositeEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ComponentCompositeEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.CompositeStructureDiagramEditPart;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Port;
import org.polarsys.chess.core.notifications.ResourceNotification;
import org.polarsys.chess.core.profiles.CHESSProfileManager;
import org.polarsys.chess.core.views.DiagramStatus;
import org.polarsys.chess.service.utils.CHESSEditorUtils;


/**
 * Allows to show the CHRtSpecification Comments available on the selected Papyrus diagram
 */
public class ShowRTInformationCommand extends AbstractHandler{

	/* (non-Javadoc)
	 * Allows to show the CHRtSpecification Comments available on the selected Papyrus diagram
	 */ 
	public Object show() throws ExecutionException {
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
				
				// LB 20150701 porting to MARTE added casting to compositeEP (following Eclipse's suggestion)
				//if (showHideRT((Shape)compositeEP.getModel(), true)){
				if (showHideRT((Shape)((EditPart) compositeEP).getModel(), true)){
					ds.setUserAction(false);
				}
				
				// LB 20150701 porting to MARTE added parenthesis around cast and casting to EditPart (following Eclipse's suggestion)
				//EditPart mainEditPart = (EditPart)(compositeEP.getRoot().getChildren().get(0));
				EditPart mainEditPart = (EditPart) (((EditPart) compositeEP).getRoot().getChildren().get(0));
				CanonicalEditPolicy cep = (CanonicalEditPolicy)mainEditPart.getEditPolicy(EditPolicyRoles.CANONICAL_ROLE);
				if (cep!=null)
					cep.refresh();
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
	
	/**
	 * Sets the visibility on the given Comment CHRtSpecification shape
	 *
	 * @param shape the Comment CHRtSpecification shape
	 * @param visibility the visibility
	 * @return true, if successful
	 */
	public static boolean showHideRT(Shape shape, boolean visibility){
		if (shape.getElement() instanceof Port)
			return false;
		if (shape.getElement() instanceof Comment){
			Comment comm = (Comment) shape.getElement();
			if (comm.isStereotypeApplied(CHESSProfileManager.getCHRTSpecification(comm)))
				shape.setVisible(visibility);
		}
		
		
		
		Iterator iter = shape.getPersistedChildren().iterator();
		Object temp = null;
		while (iter.hasNext()){
			temp = iter.next();
			if (temp instanceof BasicCompartmentImpl){
				Iterator iter2 = ((BasicCompartmentImpl) temp).getPersistedChildren().iterator();
				while (iter2.hasNext()){
					showHideRT((Shape)iter2.next(), visibility);
				}
			}
		}		
		return true;
	}
	
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		return show();
	}
	
}
