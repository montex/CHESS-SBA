/*****************************************************************************
 * Copyright (c) 2016 Intecs
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/

package org.polarsys.chess.instance.view;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.incquery.viewers.runtime.model.Item;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtPortSlot;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification;
import org.polarsys.chess.chessmlprofile.util.Constants;
import org.polarsys.chess.core.util.CHESSProjectSupport;
import org.polarsys.chess.core.util.uml.UMLUtils;


/**
 * @author stefano
 *	This class implement a specific handler to allow creation of CHRrSpecification through the InstanceView
 */
public class AddCHRtSpecHandler extends AbstractHandler {

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
				
		ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event)
		        .getActivePage().getSelection();
		if (selection != null & selection instanceof TreeSelection) {
			TreeSelection treeSelection = (TreeSelection) selection;
			if (treeSelection.size() > 1)
				return null;
			TreePath path = null;
			try{
				path = treeSelection.getPaths()[0];
			}catch (Exception ex){
				ex.printStackTrace();
				return null;
			}
			
			Object obj = path.getLastSegment();
			if (!(obj instanceof Item))
				return null;
			Item item = (Item) obj;
			obj = item.getParamObject();
			if (!(obj instanceof Operation))
				return null;
			final Operation op = (Operation) obj;
			
			obj = path.getSegment(path.getSegmentCount()-2);
			if (!(obj instanceof Item))
				return null;
			item = (Item) obj;
			if (item.getParamObject() instanceof Slot){
				final Slot slot = (Slot) item.getParamObject();
				final String occKind = this.getOccKind();
				//assumption: slot is an instance of Port
				if (! (slot.getDefiningFeature() instanceof Port))
					return null;
				
				TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(op);
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					protected void doExecute() {
						//ds.setUserAction(false);
						
						Comment comment = UMLFactory.eINSTANCE.createComment();
						op.getOwnedComments().add(comment);
						comment.getAnnotatedElements().add(slot.getDefiningFeature());
						Stereotype chrtstereo = UMLUtils.applyStereotype(comment, Constants.CHRT_SPECIFICATION);
						CHRtSpecification chrt = (CHRtSpecification) comment.getStereotypeApplication(chrtstereo);
						chrt.setContext(op);
						chrt.setOccKind(occKind);
						
						Stereotype portslotstereo = slot.getApplicableStereotype(Constants.CH_CHRtPortSlot);
						CHRtPortSlot chrtportslot = (CHRtPortSlot) slot.getStereotypeApplication(portslotstereo);
						if (chrtportslot == null){
							//then create
							chrtportslot = (CHRtPortSlot) slot.applyStereotype(portslotstereo);
						}
						chrtportslot.getCH_RtSpecification().add(chrt);
						
					}
						
				});
			}else
				if (item.getParamObject() instanceof InstanceSpecification){
					final InstanceSpecification instance = (InstanceSpecification) item.getParamObject();
					final String occKind = this.getOccKind();
					//assumption: instance is an instance of Component
					TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(op);
					editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
						protected void doExecute() {
							//ds.setUserAction(false);
							
							Comment comment = UMLFactory.eINSTANCE.createComment();
							op.getOwnedComments().add(comment);
							Classifier classif = instance.getClassifiers().get(0);
							if (classif == null){
								CHESSProjectSupport.printlnToCHESSConsole("ERROR: class not found for instance "+instance.getName());
							}else 
								comment.getAnnotatedElements().add(classif);
							Stereotype chrtstereo = UMLUtils.applyStereotype(comment, Constants.CHRT_SPECIFICATION);
							CHRtSpecification chrt = (CHRtSpecification) comment.getStereotypeApplication(chrtstereo);
							chrt.setContext(op);
							chrt.setOccKind(occKind);
							Stereotype portslotstereo = instance.getApplicableStereotype(Constants.CH_CHRtPortSlot);
							CHRtPortSlot chrtportslot = (CHRtPortSlot) instance.getStereotypeApplication(portslotstereo);
							if (chrtportslot == null){
								//then create
								chrtportslot = (CHRtPortSlot) instance.applyStereotype(portslotstereo);
							}
							chrtportslot.getCH_RtSpecification().add(chrt);
							
						}
							
					});
				}
			
			
		}
		return null;
	}
	/*
	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isHandled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}*/
	
	
	/**
	 * this method is supposed to be overridden
	 * @return value for CHRtSpecification occKind property
	 */
	protected  String getOccKind(){
		return "";
	}

}
