/*******************************************************************************
 * Copyright (c) 2015 Intecs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicholas Pacini
 *******************************************************************************/
package org.polarsys.chess.test.runtime.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Model;
import org.junit.runners.Suite.SuiteClasses;
import org.polarsys.chess.core.util.uml.ResourceUtils;

public class TestUtil {

	public static Model loadTestModel(String projectName, String fileName) {
		IWorkspaceRoot wRoot = ResourcesPlugin.getWorkspace().getRoot();		
		IProject proj = wRoot.getProject(projectName);
		IFile file = proj.getFile(fileName);			
		IPath loc = file.getLocation();
		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet.getResource(URI
				.createFileURI(loc.toString()), true);
		Model model = ResourceUtils.getModel(resource);
		return model;
	}

	public static List<String> extractQNamesFromSuite(SuiteClasses suite) {
		List<String> allTests = new ArrayList<String>();
		String str = suite.toString();
		str = str.substring(str.indexOf("[")+1, str.indexOf("]"));
		String[] tokens = str.split("class");
		for (String token : tokens) {
			token = token.trim();
			if (token.endsWith(",")){
				token = token.substring(0, token.lastIndexOf(","));
			}
			if(!token.isEmpty()){
				allTests.add(token);
			}
		}
		
		return allTests;
		
	}

}
