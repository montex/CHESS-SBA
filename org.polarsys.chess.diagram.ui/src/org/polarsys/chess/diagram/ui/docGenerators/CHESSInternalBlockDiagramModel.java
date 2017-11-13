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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.BlockPropertyCompositeEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.FlowPortAffixedNodeEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.StructureCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.ConnectorEditPart;
import org.eclipse.papyrus.uml.diagram.common.editparts.IUMLEditPart;
import org.eclipse.papyrus.uml.diagram.composite.custom.edit.parts.CustomPropertyPartEditPartCN;
import org.eclipse.papyrus.uml.diagram.composite.custom.edit.parts.ResizablePortEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ClassCompositeCompartmentEditPart;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Port;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;

import eu.fbk.eclipse.standardtools.diagram.ui.layout.EOrientation;
import eu.fbk.eclipse.standardtools.diagram.ui.layout.EOrientation.Orientation;
import eu.fbk.eclipse.standardtools.diagram.ui.model.AbstractInternalBlockDiagramModel;

public class CHESSInternalBlockDiagramModel implements AbstractInternalBlockDiagramModel{
	
	
	private static CHESSInternalBlockDiagramModel chessModel;
	
	public static CHESSInternalBlockDiagramModel getInstance(){
		if(chessModel == null){
			chessModel = new CHESSInternalBlockDiagramModel();
		}
		return chessModel;
	}
	
	
	private EntityUtil entityUtil = EntityUtil.getInstance();
	
	@Override
	public String getGraphicalComponentId(Object graphicalComponent) {
		Element umlElement = null;
		/*
		 * if(graphicalComponent instanceof BlockCompositeEditPart){ umlElement
		 * = ((BlockCompositeEditPart)graphicalComponent).getUMLElement(); }
		 * if(graphicalComponent instanceof BlockPropertyCompositeEditPart){
		 * umlElement =
		 * ((BlockPropertyCompositeEditPart)graphicalComponent).getUMLElement();
		 * }
		 */
		if (graphicalComponent instanceof IUMLEditPart) {
			umlElement = ((IUMLEditPart) graphicalComponent).getUMLElement();
		}
		return entityUtil.getComponentID(umlElement);
	}

	@Override
	public String getGraphicalComponentName(Object graphicalComponent) {
		EObject component = ((GraphicalEditPart) graphicalComponent).resolveSemanticElement();

		// ((AppliedStereotypeEmptyEditPart)graphicalComponent).get

		return entityUtil.getComponentName(component);
	}

	@Override
	public List<GraphicalEditPart> getGraphicalSubComponents(Object graphicalComponent) {
		List<?> children = ((GraphicalEditPart) graphicalComponent).getChildren();
		List<GraphicalEditPart> graphicalSubComponent = new ArrayList<GraphicalEditPart>();
		for (Object child : children) {
			if (child instanceof StructureCompartmentEditPart) {
				for (Object componentChild : ((StructureCompartmentEditPart) child).getChildren()) {
					if (componentChild instanceof BlockPropertyCompositeEditPart) {
						graphicalSubComponent.add((GraphicalEditPart) componentChild);
					}
				}
			}
			if (child instanceof ClassCompositeCompartmentEditPart) {
				for (Object componentChild : ((ClassCompositeCompartmentEditPart) child).getChildren()) {
					if (componentChild instanceof CustomPropertyPartEditPartCN) {
						graphicalSubComponent.add((GraphicalEditPart) componentChild);
					}
				}
			}
		}
		return graphicalSubComponent;
	}

	@Override
	public Object getGraphicalOwnerComponents(Object graphicalComponent) {
		return ((GraphicalEditPart) graphicalComponent).getParent();
	}

	@Override
	public List<?> getGraphicalPorts(Object graphicalComponent) {
		List<?> children = ((GraphicalEditPart) graphicalComponent).getChildren();
		List<GraphicalEditPart> graphicalConnectors = new ArrayList<GraphicalEditPart>();
		for (Object child : children) {
			if (child instanceof FlowPortAffixedNodeEditPart) {
				graphicalConnectors.add((GraphicalEditPart) child);
			}
			if (child instanceof ResizablePortEditPart) {
				graphicalConnectors.add((GraphicalEditPart) child);
			}
		}
		return graphicalConnectors;
	}

	@Override
	public Object getGraphicalPortOwner(Object port) {
		return ((GraphicalEditPart) port).getParent();
	}

	@Override
	public Dimension getGraphicalComponentDimension(Object component) {
		org.eclipse.draw2d.geometry.Dimension domension = ((GraphicalEditPart) component).getFigure().getSize();
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

		printlnGraphicalPosition(graphicalComponent);

		// System.out.println("----------------------------");
		// System.out.println(graphicalComponent.getLocation());
		// System.out.println(component);
		// System.out.println(graphicalComponent.getContentPane().getBounds());
		// System.out.println(graphicalComponent.getFigure().getBounds());
		// System.out.println(graphicalComponent.getMainFigure().getBounds());
		// System.out.println(graphicalComponent.getBorderedFigure().getBounds());
		// System.out.println(graphicalComponent.getPrimaryShape().getBounds());
		// System.out.println(graphicalComponent.getPrimaryShape().getLocation());

		Point point = new Point(x, y);

		Point parentPoint = getOwnerPosition(graphicalComponent.getParent());

		System.out.println("parentPoint: " + parentPoint);

		point.x = point.x + parentPoint.x;
		point.y = point.y + parentPoint.y;

		return point;
	}
	
	private Object printlnGraphicalPosition(Object component) {
		if (component instanceof GraphicalEditPart) {
			GraphicalEditPart graphicalComponent = (GraphicalEditPart) component;
			System.out.println("-------printlnGraphicalPosition------------");
			System.out.println(graphicalComponent);
			System.out.println(graphicalComponent.getFigure().getBounds());
			return printlnGraphicalPosition(graphicalComponent.getParent());
		}
		return null;
	}

	/*
	 * @Override public Point getGraphicalComponentPosition(Object component) {
	 * 
	 * GraphicalEditPart graphicalComponent = (GraphicalEditPart)component;
	 * 
	 * int x =0; int y =0; if(!(component instanceof
	 * StructureCompartmentEditPart)){ x =
	 * graphicalComponent.getFigure().getBounds().x; y =
	 * graphicalComponent.getFigure().getBounds().y; }
	 * 
	 * 
	 * System.out.println("----------------------------");
	 * //System.out.println(graphicalComponent.getLocation());
	 * System.out.println(component);
	 * //System.out.println(graphicalComponent.getContentPane().getBounds());
	 * System.out.println(graphicalComponent.getFigure().getBounds());
	 * //System.out.println(graphicalComponent.getMainFigure().getBounds());
	 * //System.out.println(graphicalComponent.getBorderedFigure().getBounds());
	 * //System.out.println(graphicalComponent.getPrimaryShape().getBounds());
	 * //System.out.println(graphicalComponent.getPrimaryShape().getLocation());
	 * 
	 * 
	 * Point point = new Point(x, y);
	 * 
	 * if(graphicalComponent.getParent() instanceof GraphicalEditPart){ Point
	 * parentPoint =
	 * getGraphicalComponentPosition(graphicalComponent.getParent());
	 * point.x=point.x+parentPoint.x; point.y=point.y+parentPoint.y; } return
	 * point; }
	 */
	

	private Point getOwnerPosition(Object component) {

		if (component instanceof GraphicalEditPart) {
			GraphicalEditPart graphicalComponent = (GraphicalEditPart) component;

			int x = 0;
			int y = 0;
			if (component instanceof StructureCompartmentEditPart) {
				x = graphicalComponent.getFigure().getBounds().x;
				y = graphicalComponent.getFigure().getBounds().y;
				Point point = new Point(x, y);
				return point;
			}
			if (component instanceof ClassCompositeCompartmentEditPart) {
				x = graphicalComponent.getFigure().getBounds().x;
				y = graphicalComponent.getFigure().getBounds().y;
				Point point = new Point(x, y);
				return point;
			}

			return getOwnerPosition(graphicalComponent.getParent());
		} else {
			return new Point(0, 0);
		}
	}

	@Override
	public boolean isGraphicalPort(Object port) {
		if (port instanceof FlowPortAffixedNodeEditPart) {
			return entityUtil.isPort((Element) ((FlowPortAffixedNodeEditPart) port).getUMLElement());
		}
		if (port instanceof ResizablePortEditPart) {
			return entityUtil.isPort((Element) ((ResizablePortEditPart) port).getUMLElement());
		}
		return false;
	}

	@Override
	public boolean isGraphicalInputPort(Object port) {
		if (port instanceof FlowPortAffixedNodeEditPart) {
			return entityUtil.isInputPort((Element) ((FlowPortAffixedNodeEditPart) port).getUMLElement());
		}
		if (port instanceof ResizablePortEditPart) {
			return entityUtil.isInputPort((Element) ((ResizablePortEditPart) port).getUMLElement());
		}
		return false;
	}

	@Override
	public boolean isGraphicalOutputPort(Object port) {
		if (port instanceof FlowPortAffixedNodeEditPart) {
			return entityUtil.isOutputPort((Element) ((FlowPortAffixedNodeEditPart) port).getUMLElement());
		}
		if (port instanceof ResizablePortEditPart) {
			return entityUtil.isOutputPort((Element) ((ResizablePortEditPart) port).getUMLElement());
		}
		return false;
	}

	@Override
	public String getGraphicalPortName(Object port) {
		if (port instanceof FlowPortAffixedNodeEditPart) {
			return ((Port) ((FlowPortAffixedNodeEditPart) port).getUMLElement()).getName();
		}
		if (port instanceof ResizablePortEditPart) {
			return ((Port) ((ResizablePortEditPart) port).getUMLElement()).getName();
		}
		return null;
	}

	

	@Override
	public Object getGraphicalPortVariableType(Object port) {
		if (port instanceof FlowPortAffixedNodeEditPart) {
			return ((Port) ((FlowPortAffixedNodeEditPart) port).getUMLElement()).getType().getName();
		}
		if (port instanceof ResizablePortEditPart) {
			return ((Port) ((ResizablePortEditPart) port).getUMLElement()).getType().getName();
		}
		return null;
	}

	@Override
	public Point getGraphicalPortPosition(Object port) {

		// org.eclipse.draw2d.geometry.Point p =
		// ((FlowPortAffixedNodeEditPart)Port).getLocation();
		// org.eclipse.draw2d.geometry.Point p =
		// ((GraphicalEditPart)Port).getFigure().getBounds();
		int x = ((GraphicalEditPart) port).getFigure().getBounds().x;
		int y = ((GraphicalEditPart) port).getFigure().getBounds().y;

		// System.out.println("port bounds:
		// "+((FlowPortAffixedNodeEditPart)Port).getFigure().getBounds());
		// System.out.println("port loc: "+p);

		// Point point = new Point(p.x, p.y);
		Point point = new Point(x, y);

		// GraphicalEditPart portParent =
		// (GraphicalEditPart)((GraphicalEditPart)Port).getParent();
		// Point partentPoint =
		// getGraphicalComponentPosition(portParent.getParent());
		Point partentPoint = getOwnerPosition(port);

		point.x = point.x + partentPoint.x;
		point.y = point.y + partentPoint.y;
		return point;
	}

	@Override
	public Dimension getGraphicalPortDimension(Object port) {

		org.eclipse.draw2d.geometry.Dimension domension = ((GraphicalEditPart) port).getFigure().getSize();
		Dimension dim = new Dimension(domension.width, domension.height);

		return dim;
	}

	@Override
	public EOrientation getGraphicalPortOffsetOrientation(Object port) {

		int or = 0;
		if (port instanceof FlowPortAffixedNodeEditPart) {
			or = ((FlowPortAffixedNodeEditPart) port).getBorderItemLocator().getCurrentSideOfParent();
		}
		if (port instanceof ResizablePortEditPart) {
			or = ((ResizablePortEditPart) port).getBorderItemLocator().getCurrentSideOfParent();
		}
		//System.out.println("or: " + or);

		EOrientation eOrientation = new EOrientation();
		Point p = getGraphicalPortPosition(port);
		int offset = 0;
		Orientation orientation = Orientation.NORTH_VALUE;

		switch (or) {
		case 1:
			orientation = Orientation.NORTH_VALUE;
			offset = p.x;
			break;
		case 4:
			orientation = Orientation.SOUTH_VALUE;
			offset = p.x;
			break;
		case 8:
			orientation = Orientation.WEST_VALUE;
			offset = p.y;
			break;
		case 16:
			orientation = Orientation.EAST_VALUE;
			offset = p.y;
			break;
		}

		eOrientation.setOrientation(orientation);
		eOrientation.setOffset(offset);
		return eOrientation;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<?> getPortChannels(Object graphicalComponent) {

		List<Object> connections = new ArrayList<Object>();

		if (graphicalComponent instanceof GraphicalEditPart) {

			List<?> children = ((GraphicalEditPart) graphicalComponent).getChildren();
			for (Object child : children) {
				if (child instanceof FlowPortAffixedNodeEditPart) {
					GraphicalEditPart graphicalPort = (GraphicalEditPart) child;
					connections.addAll(graphicalPort.getSourceConnections());

				}
				if (child instanceof ResizablePortEditPart) {
					GraphicalEditPart graphicalPort = (GraphicalEditPart) child;
					connections.addAll(graphicalPort.getSourceConnections());

				}
			}

			for (Object subComponents : getGraphicalSubComponents(graphicalComponent)) {
				connections.addAll(getPortChannels(subComponents));
				/*
				 * List children
				 * =((GraphicalEditPart)subComponents).getChildren(); for(Object
				 * child : children){ if(child instanceof
				 * FlowPortAffixedNodeEditPart){ GraphicalEditPart graphicalPort
				 * = (GraphicalEditPart) child;
				 * System.out.println("child: "+child);
				 * connections.addAll(graphicalPort.getSourceConnections());
				 * connections.addAll(graphicalPort.getTargetConnections());
				 * 
				 * } }
				 */
			}

		}
		
		return connections;
	}

	@Override
	public String getChannelName(Object channel) {
		if (channel instanceof ConnectorEditPart) {
			return ((Connector) ((View) ((ConnectorEditPart) channel).getModel()).getElement()).getName();
		}
		if (channel instanceof org.eclipse.papyrus.uml.diagram.composite.edit.parts.ConnectorEditPart) {
			return ((Connector) ((View) ((org.eclipse.papyrus.uml.diagram.composite.edit.parts.ConnectorEditPart) channel)
					.getModel()).getElement()).getName();
		}
		return null;
	}

	@Override
	public Object getChannelTargetPort(Object channel) {
		if (channel instanceof ConnectorEditPart) {
			return ((ConnectorEditPart) channel).getTarget();
		}
		if (channel instanceof org.eclipse.papyrus.uml.diagram.composite.edit.parts.ConnectorEditPart) {
			return ((org.eclipse.papyrus.uml.diagram.composite.edit.parts.ConnectorEditPart) channel).getTarget();
		}
		return null;
	}

	@Override
	public Object getChannelSourcePort(Object channel) {
		if (channel instanceof ConnectorEditPart) {
			return ((ConnectorEditPart) channel).getSource();
		}
		if (channel instanceof org.eclipse.papyrus.uml.diagram.composite.edit.parts.ConnectorEditPart) {
			return ((org.eclipse.papyrus.uml.diagram.composite.edit.parts.ConnectorEditPart) channel).getSource();
		}
		return null;
	}

	@Override
	public ArrayList<?> getPortIncomingChannels(Object port) {
		return null;
	}

	@Override
	public ArrayList<?> getPortOutgoingChannels(Object port) {
		return null;
	}

	@Override
	public List<Point> getLayoutChannelPoints(Object channel) {
		int[] pointList = null;
		if (channel instanceof ConnectorEditPart) {
			pointList = ((ConnectorEditPart) channel).getConnectionFigure().getPoints().toIntArray();
		}
		if (channel instanceof org.eclipse.papyrus.uml.diagram.composite.edit.parts.ConnectorEditPart) {
			pointList = ((org.eclipse.papyrus.uml.diagram.composite.edit.parts.ConnectorEditPart) channel)
					.getConnectionFigure().getPoints().toIntArray();
		}
		List<Point> points = new ArrayList<Point>();

		for (int i = 0; i < pointList.length; i = i + 2) {
			Point p = new Point(pointList[i], pointList[i + 1]);
			points.add(p);
		}

		return points;
	}

	@Override
	public Object getChannelOwner(Object channel) {
		return ((GraphicalEditPart) channel).getParent();
	}

	

	@Override
	public String getGraphicalPortRange(Object component, Object port) {
		return "PortRange";
	}
	
}
