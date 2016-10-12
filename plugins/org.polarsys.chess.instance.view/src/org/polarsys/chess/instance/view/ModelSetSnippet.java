/*****************************************************************************
 * Copyright (c) 2016 Budapest University of Technology and Economics, Intecs
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/

package org.polarsys.chess.instance.view;

import org.eclipse.papyrus.infra.core.resource.IModelSetSnippet;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.PlatformUI;

public class ModelSetSnippet implements IModelSetSnippet {

	public ModelSetSnippet() {
		
	}

	
	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.core.resource.IModelSetSnippet#dispose(org.eclipse.papyrus.infra.core.resource.ModelSet)
	 */
	@Override
	public void dispose(ModelSet arg0) {
		System.out.println("model disposed");
		//clear the model connector of the InstanceViewPart, so that it can be safely created once again when the model is started later
		IViewReference[] views = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getViewReferences();
		for (IViewReference v:views){
			if (v.getId().compareTo("concerto.instance.view.iq")==0){
				IViewPart viewPart = v.getView(false);
				if (viewPart instanceof InstanceViewPart){
					((InstanceViewPart)viewPart).clearModelConnector();
				}
				
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.core.resource.IModelSetSnippet#start(org.eclipse.papyrus.infra.core.resource.ModelSet)
	 */
	@Override
	public void start(ModelSet arg0) {
		System.out.println("New model created");
	}

}
