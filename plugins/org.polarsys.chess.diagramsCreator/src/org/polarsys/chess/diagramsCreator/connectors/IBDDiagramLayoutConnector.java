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
package org.polarsys.chess.diagramsCreator.connectors;

import org.eclipse.elk.conn.gmf.GmfDiagramLayoutConnector;
import org.eclipse.elk.core.math.ElkPadding;
import org.eclipse.elk.core.options.CoreOptions;
import org.eclipse.elk.core.options.PortConstraints;
import org.eclipse.elk.core.options.PortLabelPlacement;
import org.eclipse.elk.core.service.LayoutMapping;
import org.eclipse.elk.graph.ElkGraphElement;
import org.eclipse.elk.graph.ElkNode;
import org.eclipse.ui.IWorkbenchPart;

/**
 * This class extends the default connector adding specific settings for the IBD diagram.
 * @author cristofo
 *
 */
public class IBDDiagramLayoutConnector extends GmfDiagramLayoutConnector {
	
	private static final double paddingTop = 30, paddingBottom = 50, paddingRight = 50, paddingLeft = 50;

	/**
	 * Adjusts some parameters of the layout.
	 * @param mapping the layout mapping to be modified
	 */
	private void adjustLayout(LayoutMapping mapping) {
		for (ElkGraphElement graphElement : mapping.getGraphMap().keySet()) {
			
			// Set position of the port labels
			if (graphElement instanceof ElkNode) {
				ElkNode node = (ElkNode) graphElement;
				if (node.isHierarchical() && node.getParent() != null) {
					
					// This is the root node
					node.setProperty(CoreOptions.PORT_LABELS_PLACEMENT, PortLabelPlacement.OUTSIDE);
				} else {
					
					// This is a common node
					node.setProperty(CoreOptions.PORT_LABELS_PLACEMENT, PortLabelPlacement.INSIDE);
				}
			}
			
			// Routing is orthogonal by default
//			graphElement.setProperty(CoreOptions.EDGE_ROUTING, EdgeRouting.POLYLINE);
			
			// Some padding between root element and inner elements
			graphElement.setProperty(CoreOptions.PADDING, new ElkPadding(paddingTop, paddingRight, paddingBottom, paddingLeft));
		
			// Tries to keep input ports on the left side and output ports on the right side
			graphElement.setProperty(CoreOptions.PORT_CONSTRAINTS, PortConstraints.FIXED_SIDE);			
		}	
	}
    
    /**
     * {@inheritDoc}
     */
    public LayoutMapping buildLayoutGraph(final IWorkbenchPart workbenchPart, final Object diagramPart) {
       
    	final LayoutMapping mapping = super.buildLayoutGraph(workbenchPart, diagramPart);
        
        adjustLayout(mapping);
        
        return mapping;
    }
}
