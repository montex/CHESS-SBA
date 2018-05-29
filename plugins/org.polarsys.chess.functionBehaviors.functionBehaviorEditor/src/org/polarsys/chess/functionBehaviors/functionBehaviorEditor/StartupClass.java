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
package org.polarsys.chess.functionBehaviors.functionBehaviorEditor;

import java.util.List;

import org.eclipse.papyrus.infra.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.runtime.ConfigurationManager;
import org.eclipse.ui.IStartup;

/**
 * Class used to unload the standard UML property view and load the modified CHESS view.
 * @author cristofo
 *
 */
public class StartupClass implements IStartup {
	public static final String PROPERTY_VIEW_NAME = "UML for CHESS";
	
	@Override
	public void earlyStartup() {
		
		final ConfigurationManager configurationManager = ConfigurationManager.getInstance();
		
		List<Context> contexts = new java.util.ArrayList<Context>(configurationManager.getCustomizableContexts());
		contexts.addAll(configurationManager.getMissingContexts());
		
		for(Context context : contexts) {
			final String name = context.getName();
			if(name.equals("UML")) {
				configurationManager.disableContext(context, true);			
			} else if (name.equals(PROPERTY_VIEW_NAME)) {
				configurationManager.enableContext(context, true);
			}
		}
	}
}
