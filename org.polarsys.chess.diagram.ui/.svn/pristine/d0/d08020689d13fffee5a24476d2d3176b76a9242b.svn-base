package org.polarsys.chess.diagram.ui.docGenerators;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.PapyrusWrappingLabel;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSDecorationNodeImpl;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockDefinitionDiagramEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.AssociationEditPart;
import org.eclipse.papyrus.sysml.diagram.common.figure.AssociationFigure;
import org.eclipse.uml2.uml.Association;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;

import eu.fbk.eclipse.standardtools.diagram.ui.model.AbstractBlockDefinitionDiagramModel;

public class CHESSBlockDefinitionDiagramModel implements AbstractBlockDefinitionDiagramModel{

	private static  CHESSBlockDefinitionDiagramModel instance;
	
	public static CHESSBlockDefinitionDiagramModel getInstance(){
		if(instance==null){
			instance = new CHESSBlockDefinitionDiagramModel();
		}
		return instance;
	}
	
	private EntityUtil entityUtil = EntityUtil.getInstance();
	
	
	@Override
	public String getGraphicalComponentName(Object graphicalComponent) {
		
		if(graphicalComponent instanceof EditPart){
			System.out.println("is instanceof EditPart");
		}
		if(graphicalComponent instanceof GraphicalEditPart){
			System.out.println("is instanceof GraphicalEditPart");
		}
		
		EObject component = ((GraphicalEditPart) graphicalComponent).resolveSemanticElement();
	return entityUtil.getComponentName(component);
	}

	@Override
	public List<?> getGraphicalComponentsOfBDD(Object graphicalComponent) {
		
		System.out.println("getGraphicalComponentsOfBDD");
		
		if(graphicalComponent instanceof EditPart){
			System.out.println("is instanceof EditPart");
		}
		if(graphicalComponent instanceof GraphicalEditPart){
			System.out.println("is instanceof GraphicalEditPart");
		}
		if(graphicalComponent instanceof BlockDefinitionDiagramEditPart){
			System.out.println("is instanceof BlockDefinitionDiagramEditPart");
			
			for(Object o : ((BlockDefinitionDiagramEditPart)graphicalComponent).getChildren()){
				System.out.println("child: "+o);
			}
			return ((BlockDefinitionDiagramEditPart)graphicalComponent).getChildren();
		}
		return null;
	}

	@Override
	public Dimension getGraphicalComponentDimension(Object graphicalComponent) {
		org.eclipse.draw2d.geometry.Dimension domension = ((GraphicalEditPart) graphicalComponent).getFigure().getSize();
		Dimension d = new Dimension(domension.width, domension.height);
		return d;
	}

	@Override
	public Point getGraphicalComponentPosition(Object component) {
		
	/*	if(component instanceof EditPart){
			for(Object o : ((EditPart)component).getChildren()){
				System.out.println("child of component: "+o);
			}
		}*/
		
		GraphicalEditPart graphicalComponent = (GraphicalEditPart) component;

		int x = 0;
		int y = 0;

		x = graphicalComponent.getFigure().getBounds().x;
		y = graphicalComponent.getFigure().getBounds().y;

			Point point = new Point(x, y);

		//Point parentPoint = getOwnerPosition(graphicalComponent.getParent());

		//System.out.println("parentPoint: " + parentPoint);

		//point.x = point.x + parentPoint.x;
		//point.y = point.y + parentPoint.y;

		return point;
	}

	@Override
	public List<?> getCompositionAssociations(Object graphicalComponent) {
		List<AssociationEditPart> compositionAssociations = new ArrayList<AssociationEditPart>();
		
		if(graphicalComponent instanceof BlockDefinitionDiagramEditPart){
			System.out.println("is instanceof BlockDefinitionDiagramEditPart");
			
			for(Object o : ((BlockDefinitionDiagramEditPart)graphicalComponent).getConnections()){
				System.out.println("connections: "+o);
				if(o instanceof AssociationEditPart){
					compositionAssociations.add((AssociationEditPart)o);
				}
			}
			//return ((BlockDefinitionDiagramEditPart)graphicalComponent).getConnections();
			return compositionAssociations;
		}
		return null;
	}

	@Override
	public String getCompositionAssociationName(Object channel) {
		AssociationEditPart association = ((AssociationEditPart)channel);
		System.out.println("association.getModel(): "+association.getModel());
		View v = ((View) association.getModel());
		System.out.println("v.getElement(): "+v.getElement());
		Association associationEleemnt = (Association)v.getElement();
		return associationEleemnt.getName();
	}

	@Override
	public List<Point> getLayoutCompositionAssociationPoints(Object channel) {
		int[] pointList = null;
		List<Point> points = new ArrayList<Point>();
		
		AssociationEditPart association = ((AssociationEditPart)channel);
		//pointList = association.getConnectionFigure().getPoints().toIntArray();
		

		AssociationFigure associationFigure = (AssociationFigure)association.getFigure();
		pointList =associationFigure.getPolygonPoints().toIntArray();
		//pointList =associationFigure.getPoints().toIntArray();
		
		System.out.println("points");
		for (int i = 0; i < pointList.length; i = i + 2) {
			Point p = new Point(pointList[i], pointList[i + 1]);
			System.out.println("p: "+p);
			points.add(p);
		}

		return points;
	}

	@Override
	public Point getCompositionAssociationLabelPosition(Object graphicalLabel) {
		
		PapyrusWrappingLabel lab = (PapyrusWrappingLabel)graphicalLabel;
		
		org.eclipse.draw2d.geometry.Point labelPoint = lab.getLocation();
		return new Point(labelPoint.x, labelPoint.y);
	/*	AssociationEditPart association = ((AssociationEditPart)graphicalAssociation);
		
		for(Object o : association.getNotationView().getVisibleChildren())
		{
			CSSDecorationNodeImpl decNode = (CSSDecorationNodeImpl)o;
			
			System.out.println("o: "+o);
			
			for(Object o2:decNode.getPersistedChildren()){
				System.out.println("getPersistedChildren: "+o2);
			}
			
			for(Object o2:decNode.getSourceEdges()){
				System.out.println("getSourceEdges: "+o2);
			}
			
			for(Object o2:decNode.getTargetEdges()){
				System.out.println("getTargetEdges: "+o2);
			}
			
			LayoutConstraint lc = decNode.getLayoutConstraint();
			
		}
		
	
		
		for(Object o : association.getConnectionFigure().getChildren())
		{
			PapyrusWrappingLabel lab = (PapyrusWrappingLabel)o;
			lab.getText();
			lab.getLocation()
			System.out.println(o.getClass());
			System.out.println("getConnectionFigure().getChildren(): "+o);
		}
		
		
		
		org.eclipse.draw2d.geometry.Point midPoint = association.getConnectionFigure().getPoints().getMidpoint();
		return new Point(midPoint.x, midPoint.y);*/
		
		
	}

	
	
	@Override
	public String getCompositionAssociationLabelText(Object graphicalLabel) {
		PapyrusWrappingLabel lab = (PapyrusWrappingLabel)graphicalLabel;
		return lab.getText();
	}

	@Override
	public List<?> getCompositionAssociationsLabels(Object graphicalAssociation) {
		AssociationEditPart association = ((AssociationEditPart)graphicalAssociation);
		
		List<PapyrusWrappingLabel> labels = new ArrayList<PapyrusWrappingLabel>();
		for(Object o : association.getConnectionFigure().getChildren())
		{
			//System.out.println("o.getClass(): "+o.getClass());
			//System.out.println("getConnectionFigure().getChildren(): "+o);
			if(o instanceof PapyrusWrappingLabel){
			PapyrusWrappingLabel lab = (PapyrusWrappingLabel)o;
			//System.out.println("lab: "+lab);
			//System.out.println("lab.text: "+lab.getText());
			//System.out.println("lab.isShowing(): "+lab.isShowing());
					//System.out.println("lab.isVisible():"+lab.isVisible());
						//	System.out.println("lab.isEnabled(): "+lab.isEnabled());
							if((lab.getText().compareTo("")!=0)&(lab.isShowing())){
							labels.add(lab);
							}
			}
			
		}
		
		return labels;
		
	}

	
	
}
