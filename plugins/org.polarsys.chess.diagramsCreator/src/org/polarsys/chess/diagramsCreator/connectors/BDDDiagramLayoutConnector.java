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
import org.eclipse.elk.core.options.CoreOptions;
import org.eclipse.elk.core.options.Direction;
import org.eclipse.elk.core.service.LayoutMapping;
import org.eclipse.elk.graph.ElkNode;
import org.eclipse.ui.IWorkbenchPart;

/**
 * This class extends the default connector adding specific settings for the BDD diagram.
 * @author cristofo
 *
 */
public class BDDDiagramLayoutConnector extends GmfDiagramLayoutConnector {

	/**
	 * Adjusts some parameters of the layout.
	 * @param mapping the layout mapping to be modified
	 */
	private void adjustLayout(LayoutMapping mapping) {
		ElkNode node = mapping.getLayoutGraph();	

		// Set the direction for the node elements
		node.setProperty(CoreOptions.DIRECTION, Direction.DOWN);

		// Set the space between two layers
		node.setProperty(org.eclipse.elk.alg.layered.options.LayeredOptions.SPACING_EDGE_NODE_BETWEEN_LAYERS, 30.0);		
		node.setProperty(org.eclipse.elk.alg.layered.options.LayeredOptions.SPACING_NODE_NODE_BETWEEN_LAYERS, 50.0);		
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

