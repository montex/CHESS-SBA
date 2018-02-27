/*******************************************************************************
 * Copyright (C) 2017 Fondazione Bruno Kessler.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Alberto Debiasi - initial API and implementation
 ******************************************************************************/
package org.polarsys.chess.diagram.ui.docGenerators;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.PapyrusWrappingLabel;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockDefinitionDiagramEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.AssociationEditPart;
import org.eclipse.papyrus.sysml.diagram.common.figure.AssociationFigure;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Element;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;

import eu.fbk.eclipse.standardtools.diagram.ui.model.AbstractBlockDefinitionDiagramModel;

public class CHESSBlockDefinitionDiagramModel implements AbstractBlockDefinitionDiagramModel {

	private static CHESSBlockDefinitionDiagramModel instance;

	public static CHESSBlockDefinitionDiagramModel getInstance() {
		if (instance == null) {
			instance = new CHESSBlockDefinitionDiagramModel();
		}
		return instance;
	}

	private static final Logger logger = Logger.getLogger(CHESSBlockDefinitionDiagramModel.class);

	private EntityUtil entityUtil = EntityUtil.getInstance();

	@Override
	public Point getDiagramPoint(Object diagram) {
		Rectangle diagramBounds = ((GraphicalEditPart) diagram).getFigure().getBounds();
		logger.debug("diagramBounds: " + diagramBounds);
		Point p = new Point(diagramBounds.x, diagramBounds.y);
		return p;
	}

	@Override
	public String getGraphicalComponentName(Object graphicalComponent) {

		if (graphicalComponent instanceof EditPart) {
			logger.debug("is instanceof EditPart");
		}
		if (graphicalComponent instanceof GraphicalEditPart) {
			logger.debug("is instanceof GraphicalEditPart");
		}

		EObject component = ((GraphicalEditPart) graphicalComponent).resolveSemanticElement();
		return entityUtil.getComponentName((Element)component);
	}

	@Override
	public List<?> getGraphicalComponentsOfBDD(Object graphicalComponent) {

		logger.debug("getGraphicalComponentsOfBDD");

		if (graphicalComponent instanceof EditPart) {
			logger.debug("is instanceof EditPart");
		}
		if (graphicalComponent instanceof GraphicalEditPart) {
			logger.debug("is instanceof GraphicalEditPart");
		}
		if (graphicalComponent instanceof BlockDefinitionDiagramEditPart) {
			logger.debug("is instanceof BlockDefinitionDiagramEditPart");

			for (Object o : ((BlockDefinitionDiagramEditPart) graphicalComponent).getChildren()) {
				logger.debug("child: " + o);
			}
			return ((BlockDefinitionDiagramEditPart) graphicalComponent).getChildren();
		}
		return null;
	}

	@Override
	public Dimension getGraphicalComponentDimension(Object graphicalComponent) {
		org.eclipse.draw2d.geometry.Dimension domension = ((GraphicalEditPart) graphicalComponent).getFigure()
				.getSize();
		Dimension d = new Dimension(domension.width, domension.height);
		return d;
	}

	@Override
	public Point getGraphicalComponentPosition(Object component) {

		GraphicalEditPart graphicalComponent = (GraphicalEditPart) component;

		int x = 0;
		int y = 0;

		x = graphicalComponent.getFigure().getBounds().x;
		y = graphicalComponent.getFigure().getBounds().y;

		Point point = new Point(x, y);

		return point;
	}

	@Override
	public List<?> getCompositionAssociations(Object graphicalComponent) {
		List<AssociationEditPart> compositionAssociations = new ArrayList<AssociationEditPart>();

		if (graphicalComponent instanceof BlockDefinitionDiagramEditPart) {

			for (Object o : ((BlockDefinitionDiagramEditPart) graphicalComponent).getConnections()) {
				if (o instanceof AssociationEditPart) {
					compositionAssociations.add((AssociationEditPart) o);
				}
			}
			// return
			// ((BlockDefinitionDiagramEditPart)graphicalComponent).getConnections();
			return compositionAssociations;
		}
		return null;
	}

	@Override
	public String getCompositionAssociationName(Object channel) {
		AssociationEditPart association = ((AssociationEditPart) channel);
		View v = ((View) association.getModel());
		Association associationEleemnt = (Association) v.getElement();
		return associationEleemnt.getName();
	}

	@Override
	public List<Point> getLayoutCompositionAssociationPoints(Object channel) {
		int[] pointList = null;
		List<Point> points = new ArrayList<Point>();

		AssociationEditPart association = ((AssociationEditPart) channel);

		AssociationFigure associationFigure = (AssociationFigure) association.getFigure();
		pointList = associationFigure.getPolygonPoints().toIntArray();

		for (int i = 0; i < pointList.length; i = i + 2) {
			Point p = new Point(pointList[i], pointList[i + 1]);
			points.add(p);
		}

		return points;
	}

	@Override
	public Point getCompositionAssociationLabelPosition(Object graphicalLabel) {

		PapyrusWrappingLabel lab = (PapyrusWrappingLabel) graphicalLabel;

		org.eclipse.draw2d.geometry.Point labelPoint = lab.getLocation();
		return new Point(labelPoint.x, labelPoint.y);
		/*
		 * AssociationEditPart association =
		 * ((AssociationEditPart)graphicalAssociation);
		 * 
		 * for(Object o : association.getNotationView().getVisibleChildren()) {
		 * CSSDecorationNodeImpl decNode = (CSSDecorationNodeImpl)o;
		 * 
		 * System.out.println("o: "+o);
		 * 
		 * for(Object o2:decNode.getPersistedChildren()){
		 * System.out.println("getPersistedChildren: "+o2); }
		 * 
		 * for(Object o2:decNode.getSourceEdges()){
		 * System.out.println("getSourceEdges: "+o2); }
		 * 
		 * for(Object o2:decNode.getTargetEdges()){
		 * System.out.println("getTargetEdges: "+o2); }
		 * 
		 * LayoutConstraint lc = decNode.getLayoutConstraint();
		 * 
		 * }
		 * 
		 * 
		 * 
		 * for(Object o : association.getConnectionFigure().getChildren()) {
		 * PapyrusWrappingLabel lab = (PapyrusWrappingLabel)o; lab.getText();
		 * lab.getLocation() System.out.println(o.getClass());
		 * System.out.println("getConnectionFigure().getChildren(): "+o); }
		 * 
		 * 
		 * 
		 * org.eclipse.draw2d.geometry.Point midPoint =
		 * association.getConnectionFigure().getPoints().getMidpoint(); return
		 * new Point(midPoint.x, midPoint.y);
		 */

	}

	@Override
	public String getCompositionAssociationLabelText(Object graphicalLabel) {
		PapyrusWrappingLabel lab = (PapyrusWrappingLabel) graphicalLabel;
		return lab.getText();
	}

	@Override
	public List<?> getCompositionAssociationsLabels(Object graphicalAssociation) {
		AssociationEditPart association = ((AssociationEditPart) graphicalAssociation);

		List<PapyrusWrappingLabel> labels = new ArrayList<PapyrusWrappingLabel>();
		for (Object o : association.getConnectionFigure().getChildren()) {
			// System.out.println("o.getClass(): "+o.getClass());
			// System.out.println("getConnectionFigure().getChildren(): "+o);
			if (o instanceof PapyrusWrappingLabel) {
				PapyrusWrappingLabel lab = (PapyrusWrappingLabel) o;
				// System.out.println("lab: "+lab);
				// System.out.println("lab.text: "+lab.getText());
				// System.out.println("lab.isShowing(): "+lab.isShowing());
				// System.out.println("lab.isVisible():"+lab.isVisible());
				// System.out.println("lab.isEnabled(): "+lab.isEnabled());
				if ((lab.getText().compareTo("") != 0) & (lab.isShowing())) {
					labels.add(lab);
				}
			}

		}

		return labels;

	}

}
