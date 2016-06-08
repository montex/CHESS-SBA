/*****************************************************************************
 * Copyright (c) 2011 - 2015 University of Padova.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Alessandro Zovi
 *
 *****************************************************************************/

package org.polarsys.chess.codegen.ada.transformations;

import java.io.IOException;
import java.util.HashMap;

import monitoringxml.AnalysisContext;
import monitoringxml.Monitoring;
import monitoringxml.MonitoringFactory;
import monitoringxml.MonitoringPackage;
import monitoringxml.Thread;

import org.polarsys.chess.multicore.model.CHTask;
import org.polarsys.chess.multicore.utils.QueryUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Model;
import org.polarsys.chess.codegen.ada.Activator;
import org.polarsys.chess.core.util.CHESSProjectSupport;
import org.polarsys.chess.core.util.uml.UMLUtils;
import org.polarsys.chess.m2m.transformations.QVToTransformation;
import org.polarsys.chess.m2m.transformations.TransUtil;

/**
 * The Class Transformations.
 */
@SuppressWarnings("restriction")
public class Transformations {
	
	
	/**
	 * Load the model, sets up the environment and performs the Ada code generation.
	 *
	 * @param editor the editor
	 * @param model the model
	 * @param monitor the monitor
	 * @throws Exception the exception
	 */
	public static void performCodeGeneration(final PapyrusMultiDiagramEditor editor, IFile model, IProgressMonitor monitor) throws Exception {

		ModelContent mc = TransUtil.loadModel(model);
		final Model mi = (Model) mc.getContent().get(0);
		
		String codeGenDir = TransUtil.CODEGEN_DIR + "_" + mi.getName();

		IFolder srcDir = model.getProject().getFolder(codeGenDir);
		
		CHESSProjectSupport.bundleToProjectCopy(org.polarsys.chess.codegen.ada.Activator.PLUGIN_ID, org.polarsys.chess.codegen.ada.Activator.getDefault(), "src-lib", model.getProject(), codeGenDir, false);
  		
  	CHESSProjectSupport.createFolder(model.getProject().getFolder(codeGenDir + "/obj"));

		AcceleoCodeGen.runCodegen(model/*Copy*/, srcDir, monitor);
	}

	public static void performXMLGeneration(IFile inputFile, String saAnalysisName, IProgressMonitor monitor) throws Exception {
		ModelContent mc = TransUtil.loadModel(inputFile);
		final Model model = (Model) mc.getContent().get(0);
		
		String codeGenDir = TransUtil.CODEGEN_DIR + "_" + model.getName();
		IFolder srcDir = inputFile.getProject().getFolder(codeGenDir);
		try {
			srcDir.create(false, true, null);
		} catch (Exception e1) {
			//TODO this error usually referes to the directory already created->no problems
		}
		
		// Retrieve the default factory singleton
		MonitoringFactory factory = MonitoringFactory.eINSTANCE;
		// create an instance of myWeb
		Monitoring mon = factory.createMonitoring();
		AnalysisContext analysisContext = factory.createAnalysisContext();
		analysisContext.setName(saAnalysisName);
		mon.setAnalysisContext(analysisContext);
		
		
		EList<InstanceSpecification> instances = UMLUtils.getAllComponentInstances(model, false);
		EList<CHTask> tasks = QueryUtils.getCHTasksList(instances);
		String taskName ="";
		for (CHTask chTask : tasks) {
			Thread thread = factory.createThread();
			
			//TODO in CHESS tasks names are generated with "_task" at the end
			//the current monitoring facilities does not have this assumption
			//so here the "_task" sub string is removed from the task name, the latter as assumed by CHESS
			//
			taskName = chTask.getName();
			if (taskName.endsWith("_task")){
				int ind = taskName.lastIndexOf("_task");
				taskName=taskName.substring(0, ind);
			}
			thread.setName(taskName);
			mon.getThreadNames().add(thread);
		}
		    
		ResourceSet resourceSet = new ResourceSetImpl();
		/*
		* Register XML Factory implementation using DEFAULT_EXTENSION
		*/
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
		    "*", new  XMLResourceFactoryImpl());

		Resource resource = resourceSet.createResource(URI.createURI(srcDir.getLocationURI()+"/monitoring.xml"));

		/*
		* Add bookStoreObject to contents list of the resource 
		*/
		resource.getContents().add(mon);

		try{
		    /*
		    * Save the resource
		    */
		      resource.save(null);
		   }catch (IOException e) {
		      e.printStackTrace();
		   }
		
	}
}