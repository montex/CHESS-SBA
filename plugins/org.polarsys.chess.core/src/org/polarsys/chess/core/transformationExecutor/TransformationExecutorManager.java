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

package org.polarsys.chess.core.transformationExecutor;

import java.util.Hashtable;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

/**
 * Manages the extension-point 'org.polarsys.chess.transformationExecutor'
 *
 */
public class TransformationExecutorManager {

	// list of of listener
	private Hashtable<String, ITransformationExecutor> executorRegistry;

	// extension point ID
	private String LISTENERID_EXTENSION_ID = "org.polarsys.chess.transformationExecutor";

	private String NAME_ID = "name";

	private String REALIZATION_ID = "realization";
	
	private static TransformationExecutorManager instance; 

	
	/**
	 * Creates the singleton instance of the manager.
	 * @return
	 */
	public static TransformationExecutorManager instance(){
		if (instance == null)
			instance = new TransformationExecutorManager();
		return instance;
	}
	
	private TransformationExecutorManager() {
		super();
		executorRegistry = new Hashtable<String, ITransformationExecutor>();
		initializeExecutorList();
	}

	/**
	 * Loads all listeners of the model
	 */
	private void initializeExecutorList() {
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
			ITransformationExecutor listener = (ITransformationExecutor)createExtension(element, element.getAttribute(REALIZATION_ID));
			executorRegistry.put(listenerName, listener);
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
	
	/**
	 * Retrieves the transformation to execute given its name.
	 * 
	 * @param name  the name of the transformation
	 * @return  the executor
	 */
	public ITransformationExecutor getExecutor(final String name){
		return executorRegistry.get(name);
	}
	
	/**
	 * Initializes the manager. 
	 */
	public static void init() {
		instance();
	}
}
