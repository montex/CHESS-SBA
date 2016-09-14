/*******************************************************************************
 *                  CHESS core plugin
 *
 *               Copyright (C) 2011-2015
 *            Mälardalen University, Sweden
 *
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License
 *  v1.0 which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.polarsys.chess.fla.flamm.util;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.polarsys.chess.fla.flamm.Component;
import org.polarsys.chess.fla.flamm.FlammPackage;

public class FlammReader {
	
	private URI uri;
	private Resource resource = null;
	private Component rootComponent = null;
	
	public FlammReader(URI uri) {
		this.uri = uri;
	}

	private boolean readModel() {
		try {
			// Initialize and register the .flamm extension to use XMI resource factory
			FlammPackage.eINSTANCE.eClass();
			Resource.Factory.Registry registry = Resource.Factory.Registry.INSTANCE;
			Map<String, Object> extensionMap = registry.getExtensionToFactoryMap();
			extensionMap.put("flamm", new XMIResourceFactoryImpl());

			// Get the root component from the uri resource
			ResourceSet resourceSet = new ResourceSetImpl();
			resource = resourceSet.getResource(uri, true);
			rootComponent = (Component) resource.getContents().get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Resource getResource() {
		if (this.resource == null) {
			readModel();
		}
		return this.resource;
	}

	public Component getRootComponent() {
		if (this.rootComponent == null) {
			readModel();
		}
		return this.rootComponent;
	}

	public boolean saveModel() {
		try {
			resource.save(Collections.EMPTY_MAP);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
