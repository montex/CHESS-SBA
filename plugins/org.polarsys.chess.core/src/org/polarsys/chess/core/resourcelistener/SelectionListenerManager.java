/*
-----------------------------------------------------------------------
--          			CHESS core plugin							 --
--                                                                   --
--                    Copyright (C) 2011-2012                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- Author: Alessandro Zovi         azovi@math.unipd.it 		         --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
*/

package org.polarsys.chess.core.resourcelistener;

import java.util.Enumeration;
import java.util.Hashtable;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.ui.IWorkbenchPart;
import org.osgi.framework.Bundle;

/**
 * Manages the extension-point 'org.polarsys.chess.selectionListener'.
 *
 */
public class SelectionListenerManager extends SelectionListenerExtra{

	// list of of listener
	private Hashtable<String, SelectionListenerExtra> listenerRegistry;

	// extension point ID
	private String LISTENERID_EXTENSION_ID = "org.polarsys.chess.selectionListener";

	private String NAME_ID = "name";

	private String REALIZATION_ID = "realization";

	/**
	 * Constructor
	 * 
	 * @param servicesRegistry  the Papyrus service registry 
	 */
	public SelectionListenerManager(ServicesRegistry serviceRegistry) {
		super();
		// init stack
		listenerRegistry = new Hashtable<String, SelectionListenerExtra>();
		setRegistry(serviceRegistry);
		initializeListenerList();
	}

	/**
	 * Loads all listeners of the model
	 */
	private void initializeListenerList() {
		// Reading data from plugins
				IExtensionRegistry reg = Platform.getExtensionRegistry();
		
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(LISTENERID_EXTENSION_ID);
		
		for(int i = 0; i < configElements.length; i++) {
			inializeOneRule(configElements[i]);
		}
	}

	/**
	 * Loads one listener
	 * 
	 * @param element
	 *        the extension point
	 */
	private void inializeOneRule(IConfigurationElement element) {
		String listenerName = element.getAttribute(NAME_ID);
		try {
			SelectionListenerExtra listener = (SelectionListenerExtra)createExtension(element, element.getAttribute(REALIZATION_ID));
			listener.setRegistry(getRegistry());
			listenerRegistry.put(listenerName, listener);
		} catch (Exception e) {
			//Activator.log.error("- " + listenerName + " can not be loaded: "+e.getLocalizedMessage(), e);
		}

	}

	private static Object createExtension(final IConfigurationElement element, final String classAttribute) throws Exception {
		try {
			Bundle extensionBundle = Platform.getBundle(element.getDeclaringExtension().getNamespaceIdentifier());
			Class clazz = extensionBundle.loadClass(classAttribute);
			Object obj = clazz.newInstance();
			return obj;
			// return element.createExecutableExtension(classAttribute);
		} catch (Exception e) {
			throw new Exception("unable to create Extension " + e);
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String out = "ModelListener: \n";
		Enumeration<String> keyenum = listenerRegistry.keys();
		// we will call to string in each class
		while(keyenum.hasMoreElements()) {
			String aKey = keyenum.nextElement();
			out = out + "- " + aKey + " (" + listenerRegistry.get(aKey).toString() + ")\n";
		}
		return out;
	}

	/* (non-Javadoc)
	 * @see org.polarsys.chess.core.resourcelistener.SelectionListenerExtra#selectionChanged(org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		Enumeration<SelectionListenerExtra> listenersEnum = listenerRegistry.elements();
		while(listenersEnum.hasMoreElements()) {
			listenersEnum.nextElement().selectionChanged(part, selection);
		}
	}
}
