/*------------------------------------------------------------------------------
 -
 - Copyright (c) 2013, 2015 Intecs SpA 
 - All rights reserved. This program and the accompanying materials
 - are made available under the terms of the Eclipse Public License v1.0
 - which accompanies this distribution, and is available at
 - http://www.eclipse.org/legal/epl-v10.html
 -
 - Contributors:
 - 
 - Stefano Puri stefano.puri@intecs.it
 -  
 - Initial API and implementation and/or initial documentation
 ------------------------------------------------------------------------------*/
package org.polarsys.chess.tabbedproperties.sections;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.openelement.service.OpenElementService;
import org.eclipse.papyrus.views.search.scope.ScopeEntry;
import org.eclipse.papyrus.views.search.utils.DefaultServiceRegistryTracker;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.PartInitException;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Stereotype;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtPortSlot;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification;
import org.polarsys.chess.chessmlprofile.util.Constants;

public class TableCellMouseListener implements MouseListener{
	
	private Table swInstanceTable;

	public TableCellMouseListener(Table swInstanceTable){
		this.swInstanceTable = swInstanceTable;
	}

	@SuppressWarnings("unchecked")
	public void mouseDoubleClick(MouseEvent event) {
		Rectangle clientArea = swInstanceTable.getClientArea();
		Point pt = new Point(event.x, event.y);
		int index = swInstanceTable.getTopIndex();
		while (index < swInstanceTable.getItemCount()) {
			boolean visible = false;
			TableItem item = swInstanceTable.getItem(index);
			for (int i = 0; i < swInstanceTable.getColumns().length; i++) {
				Rectangle rect = item.getBounds(i);
				if (rect.contains(pt)) {
					InstanceSpecification inst = ((Map.Entry<InstanceSpecification, Operation>) item.getData()).getKey();
					if(i == 0){
						//navigate inst as hyperlink (to instance - papyrus bug)
						try {
							URI umlUri = inst.eResource().getURI();
							ScopeEntry scopeEntry = new ScopeEntry(umlUri, new DefaultServiceRegistryTracker());
							OpenElementService service = scopeEntry.getServicesRegistry().getService(OpenElementService.class);
							service.openSemanticElement(inst);
						} catch (PartInitException e) {
							e.printStackTrace();
						} catch (ServiceException e) {
							e.printStackTrace();
						}
					}
					Operation op = ((Map.Entry<InstanceSpecification, Operation>) item.getData()).getValue();
					if(i == 1){
						//navigate op as hyperlink (to chrtspec - papyrus bug)
						for(Slot slot : inst.getSlots()){
							Stereotype stereo = slot.getAppliedStereotype(Constants.CH_CHRtPortSlot);
							if(stereo != null){
								CHRtPortSlot chrtPortSlot = (CHRtPortSlot) slot.getStereotypeApplication(stereo);
								for (CHRtSpecification chrt : chrtPortSlot.getCH_RtSpecification()) {
									if(chrt.getContext().equals(op)){
										try {
											Comment comm = chrt.getBase_Comment();
											URI umlUri = comm.eResource().getURI();
											ScopeEntry scopeEntry = new ScopeEntry(umlUri, new DefaultServiceRegistryTracker());
											OpenElementService service = scopeEntry.getServicesRegistry().getService(OpenElementService.class);
											service.openSemanticElement(comm);
										} catch (PartInitException e) {
											e.printStackTrace();
										} catch (ServiceException e) {
											e.printStackTrace();
										}
									}
								}
							}
						}								
					}
				}
				if (!visible && rect.intersects(clientArea)) {
					visible = true;
				}
			}
			if (!visible)
				return;
			index++;
		}		
	}

	public void mouseDown(MouseEvent e) {
		
	}

	public void mouseUp(MouseEvent e) {
		
	}

}
