/*******************************************************************************
 * Copyright (c) 2018, MDH 
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/org/documents/epl-2.0/EPL-2.0.html
 *
 * SPDX-License-Identifier: EPL-2.0
 *  
 *   Contributors:
 *   Enrique Zornoza Moreno, Zulqarnain Haider
 *   Initial API and implementation and/or initial documentation
 *******************************************************************************/
/**
 */

package org.polarsys.chess.fla.faultTreeGenerator.handlers;

import java.io.File;

import javax.swing.JFileChooser;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;


import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.epsilon.emc.emf.EmfModel;



public class Transformation {
	
	private ExecutionEvent event;
	private Object result;

	/**
	 * Contructor of the class.
	 * @param event - event generated when the button is clicked.
	 */
	public Transformation(ExecutionEvent event){
		this.event=event;
	}
	/**
	 * Method that performs the transformation process from flamm to emfta.
	 * @param chooser - receives a fileChooser with has the location of the input model.
	 * @return - a path that contains the location of the output model.
	 */
	public IPath execute(JFileChooser chooser){
		
		try {
			IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		} catch (ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/*We need to create an EtlModule in which all the parameters of the transformation will be stored.*/
		EtlModule module = new EtlModule();
		
	
		/*First, we need to parse the file that contains the transformation rules and add this to our EtlModule*/
		try {
			module.parse(new File("org.polarsys.chess.fla.faultTreeGenerator/epsilon/FLA2FTA.etl"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		IPath pat = ResourcesPlugin.getWorkspace().getRoot().getLocation();
	    
	    /*If the file selected by the user doen't have the proper extension, the plug-in will notify this and won't perform any action.*/
	    String name = chooser.getSelectedFile().getName();
	    if(name.contains(".flamm")){
	    	
	    	String pathFlamm = chooser.getSelectedFile().getAbsolutePath();
	    	String flaName = chooser.getSelectedFile().getName();
	    	String flaName2 = flaName.replaceAll(".flamm", "");
	    	String pathFta = chooser.getCurrentDirectory().getAbsolutePath();
	    	
	    	
	    	/*We create are source and target model by calling a private method that receives all need parameter to do this.*/
	    	EmfModel flammModel = setEmfModel("flamm", true, false, "org.polarsys.chess.fla.faultTreeGenerator/models/flamm.ecore", pathFlamm);
	    	
	    	EmfModel emftaModel = setEmfModel("emfta",false, true, "org.polarsys.chess.fla.faultTreeGenerator/models/emfta.ecore", pathFta + "/" + flaName2 + ".emfta");
	
	    	/*Finally, we add to the EtlModule all the rules and created models so it can be excuted.*/
	    	module.getDeclaredPre();
	    	module.getTransformationRules();
	    	module.getDeclaredPost();
	    	module.getContext().getModelRepository().addModel(flammModel);
	    	module.getContext().getModelRepository().addModel(emftaModel);

	    	try {
	    		result = module.execute();
	    	}catch (EolRuntimeException e) {
			e.printStackTrace();
	    	}
	    	
	    	/*We obtain the format to deliver to the representation plugin.*/
	    	IPath ipathFta = new Path(pathFta);
	    	String pathStr = ipathFta.removeFirstSegments(pat.segmentCount()).toOSString()+"/" + flaName2 + ".emfta";
	    	IPath pathReturn = new Path(pathStr);
	    	
	    	/*This loop is done in order to refresh the worskpace of the running instance, so the user can see the target model.*/
	    	for(IProject projectos : ResourcesPlugin.getWorkspace().getRoot().getProjects()){
	    		try {
	    			projectos.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
	    		} catch (CoreException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	    	}
		
	    	
		
	    	System.out.println("Transformation process finsihed.");

	    	/*To finish, we clear both the models and the EtlModule for future transformations.*/
	    	flammModel.dispose();
	    	emftaModel.dispose();
	    	module.getContext().getModelRepository().dispose();
	    	return pathReturn;
		
		
	    }else{
	    	
	    	/*If the extension of the file selected by the user is not the correct one, we show the following message and end the plug-in.*/
			MessageDialog.openError(null, "Error in process", "The selected file is not the result of a Failure Logic Analysis. Please select a proper one.");
	    	return null;
	    	
	    }
	}
	
	/**
	 * Method used to create an EmfModel.
	 * @param name - name of the model.
	 * @param readOnLoad - if the file needs to be readed before the transformation is done: true for source model, false for target model.
	 * @param storeOnDisposal - if any changes in the model need to be store after the transformation: true for target model and false for source.
	 * @param metamodel - path of the metamodel in which the model is based.
	 * @param model - path of the model that is loaded.
	 * @return the created model
	 */
	private EmfModel setEmfModel(String name, Boolean readOnLoad, Boolean storeOnDisposal, String metamodel, String model){
		
		EmfModel emfModel= new EmfModel();
		
		emfModel.setName(name);
		emfModel.setModelFile(model);
		emfModel.setMetamodelFile(metamodel);
		emfModel.setReadOnLoad(readOnLoad);
		emfModel.setStoredOnDisposal(storeOnDisposal);
		emfModel.setCachingEnabled(true);
		emfModel.setExpand(true);
		try {
			emfModel.load();
		} catch (EolModelLoadingException e) {
			e.printStackTrace();
		} 
		return emfModel;
	}


}
