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
package org.polarsys.chess.fla.impl;

import java.io.File;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.polarsys.chess.fla.common.TransformationException;
import org.polarsys.chess.fla.flamm.FlammPackage;
import org.polarsys.chess.fla.flamm.analysis.FlaSystem;
import org.polarsys.chess.fla.flaxml.FlaxmlPackage;
import org.polarsys.chess.fla.flaxml.util.FlaxmlResourceFactoryImpl;
import org.polarsys.chess.fla.transformations.QVToTransformation;

public class FlaAnalysisRunnerXml extends FlaAnalysisRunner {
	protected IFile selectedXmlFile;
	
	public void setSelectedXmlFile(IFile file) {
		this.selectedXmlFile = file;
	}
	
	@Override
	protected void runInput2FlaTransformation(IProgressMonitor monitor) throws TransformationException{
		Resource xmlResource = readXml(iFileToUri(selectedXmlFile));
		
		URI flaMMUri = createFlaModelUri().appendFileExtension(FLA_MM_EXTENSION);
		ResourceSet resourceSet = new ResourceSetImpl();
		new File(flaMMUri.path()).delete();
		flaResource = resourceSet.createResource(flaMMUri);
		
		QVToTransformation transformation = new QVToTransformation();
		transformation.performConcertoFlaXml2ConcertoFlaTransformation(xmlResource, flaResource, monitor);
	}
	
	@Override
	protected void backpropagateAnalysisResults(FlaSystem system, IProgressMonitor monitor) {};
	
	@Override
	protected String getModelName() {
		return selectedXmlFile.getName().substring(0, selectedXmlFile.getName().lastIndexOf('.'));
	}

	protected Resource readXml(URI uri) {
		// Initialize the model
	    FlaxmlPackage.eINSTANCE.eClass();
	    FlammPackage.eINSTANCE.eClass();
	    
	    // Register the resource factory for the .flaxml extension

	    Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
	    Map<String, Object> m = reg.getExtensionToFactoryMap();
	    m.put("xml", new FlaxmlResourceFactoryImpl());

	    // Obtain a new resource set
	    ResourceSet resSet = new ResourceSetImpl();

	    // Get the resource
	    Resource resource = resSet.getResource(uri, true);
	    return resource;
	}
	
	URI iFileToUri(IFile iFile) {
		// according to 
		// http://wiki.eclipse.org/index.php/EMF/FAQ#How_do_I_map_between_an_EMF_Resource_and_an_Eclipse_IFile.3F
		return URI.createPlatformResourceURI(iFile.getFullPath().toString(), true);
	}
	
}
