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
package org.polarsys.chess.diagramsCreator.commands;

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSDecorationNodeImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSShapeImpl;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.CustomFlowPortAppliedStereotypeEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.FlowPortAffixedLabelNameEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.ConnectorLinkLabelEditPart;
import org.polarsys.chess.service.gui.utils.SelectionUtil;

public class AdjustConnectorsHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		long start = System.currentTimeMillis();
		
		final GraphicalEditPart selectedEditPart = SelectionUtil.getInstance().getSelectedGraphicalObject(event);
		
		// Get all the EditParts 
		final Map<?, ?> elements = selectedEditPart.getViewer().getEditPartRegistry();
		
		Object[] values = elements.values().toArray();

		final TransactionalEditingDomain domain = 
				TransactionUtil.getEditingDomain(((IGraphicalEditPart) selectedEditPart).getNotationView());
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {

				// Loop on the array to find the connections
				for (int i = 0; i < values.length; i++) {
					System.out.println("Values[i] = " + values[i]);
					
					if (values[i] instanceof ConnectorLinkLabelEditPart) {

						// This will hide the name of the connector
						((IGraphicalEditPart) values[i]).getNotationView().setVisible(false);
					} else if (values[i] instanceof FlowPortAffixedLabelNameEditPart) {
						
						// Label containing the name of the port
						FlowPortAffixedLabelNameEditPart editPart = (FlowPortAffixedLabelNameEditPart) values[i];
						CSSDecorationNodeImpl view = (CSSDecorationNodeImpl) editPart.getNotationView();
						org.eclipse.gmf.runtime.notation.impl.LocationImpl layout = (org.eclipse.gmf.runtime.notation.impl.LocationImpl) view.getLayoutConstraint();
						
						layout.setX(layout.getX() + 20);

					} else if (values[i] instanceof CustomFlowPortAppliedStereotypeEditPart) {

						// Label containing <<flowport>>
						CustomFlowPortAppliedStereotypeEditPart editPart = (CustomFlowPortAppliedStereotypeEditPart) values[i];
						CSSDecorationNodeImpl view = (CSSDecorationNodeImpl) editPart.getNotationView();
						org.eclipse.gmf.runtime.notation.impl.LocationImpl layout = (org.eclipse.gmf.runtime.notation.impl.LocationImpl) view.getLayoutConstraint();

						layout.setX(layout.getX() + 20);
						layout.setY(layout.getY() - 15);
					}
					
//					if (childView instanceof CSSShapeImpl) {
//						final CSSShapeImpl viewShape = (CSSShapeImpl) childView;
//						final Bounds layout = (Bounds) viewShape.getLayoutConstraint();
//
//						final int[] size = getSize(semanticElement);
//						layout.setWidth(size[0]);
//						layout.setHeight(size[1]);
//					}

					
					
				}
			}
		});
		
		System.out.println("tempo = " + (System.currentTimeMillis() - start));
		return null;
	}
}
