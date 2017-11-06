/*******************************************************************************
 *
 * Copyright (c) 2013, 2015 Intecs SpA 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Nicholas Pacini nicholas.pacini@intecs.it 
 * Stefano Puri stefano.puri@intecs.it
 * Laura Baracchi  laura.baracchi@intecs.it  
 * Irfan Sljivo irfan.sljivo@mdh.se
 * Initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.polarsys.chess.contracts.integration;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.URIUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Constraint;
import org.osgi.framework.Bundle;
import org.polarsys.chess.contracts.integration.Activator;
import org.polarsys.chess.contracts.integration.preferences.OcraAnalysisPreferencePage;
import org.polarsys.chess.contracts.integration.preferences.XsapAnalysisPreferencePage;

public class ToolIntegration {
	
	private String ocraPath;
	private String xsapScriptPath;
	private File cmdFile;
	private Shell shell;
	private String resultFold;
	private String result;
	private String error;
	private String tempFold;
	
	
	public ToolIntegration(Shell activeShell){
		ocraPath = Activator.getDefault().getPreferenceStore().getString(OcraAnalysisPreferencePage.OCRA_PATH);
		xsapScriptPath = Activator.getDefault().getPreferenceStore().getString(XsapAnalysisPreferencePage.XSAP_PATH);
		initCmdFile();
		this.shell = activeShell;
	}
	
	public ToolIntegration(Shell activeShell, String resultFold, String tempFold){
		ocraPath = Activator.getDefault().getPreferenceStore().getString(OcraAnalysisPreferencePage.OCRA_PATH);
		xsapScriptPath = Activator.getDefault().getPreferenceStore().getString(XsapAnalysisPreferencePage.XSAP_PATH);
		initCmdFile();
		this.shell = activeShell;
		this.resultFold = resultFold;
		this.tempFold = tempFold;
	}
	
	//to work correctly it is needed to unpack the plugin after the installation (see feature)
	private void initCmdFile() {
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		URL fileURL = bundle.getEntry("resources/cmd_source");
		try {
			fileURL = FileLocator.toFileURL(fileURL);
			cmdFile = URIUtil.toFile(URIUtil.toURI(fileURL));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String FTA(String smvPath, String extensionsPath, String conditionFTA) {
		try{
			String resultName = smvPath.substring(smvPath.lastIndexOf(File.separator)+1, smvPath.length());
			resultName = resultName.substring(0, resultName.lastIndexOf("."));
			error = resultFold + File.separator + resultName + "_log_ext.txt";
			result = resultFold + File.separator + resultName + "_result_ext.txt";
			File extendScript = new File(xsapScriptPath + File.separator + "extend_model.py");
			File computeScript = new File(xsapScriptPath + File.separator + "compute_ft.py");
			File viewScript = new File(xsapScriptPath + File.separator + "view_ft.py");
			if(extendScript.exists()){
				String[] extend_cmd = new String[] {"python", extendScript.getPath(), 
						"-v", "-x", "-d", tempFold, smvPath, extensionsPath};
				callOcraTool(extend_cmd);
				if(computeScript.exists()){
					error = resultFold + File.separator + resultName + "_log_ft.txt";
					result = resultFold + File.separator + resultName + "_result_ft.txt";
					String[] compute_cmd = new String[] {"python", computeScript.getPath(),
							"-v", "-d", tempFold, "--prop-text", conditionFTA};
					callOcraTool(compute_cmd);
					if(viewScript.exists()){
						error = resultFold + File.separator + resultName + "_log_vt.txt";
						result = resultFold + File.separator + resultName + "_result_vt.txt";
						String[] view_cmd = new String[]{"python", viewScript.getPath(), "-v", "-d", tempFold};
						callOcraTool(view_cmd);
					}else{
						displayErrorMessage("view_ft.py not found");
					}	
				}else{
					displayErrorMessage("compute_ft.py not found");
				}
			}else{
				displayErrorMessage("extend_model.py not found");
			}
		}catch (final Exception e) {
			e.printStackTrace();
			displayErrorMessage(e.getMessage());
		}
		return result;	
	}

	public String checkRefinement(String modelPath){
		
		try{
			String resultName = modelPath.substring(modelPath.lastIndexOf(File.separator)+1, modelPath.length());
			resultName = resultName.substring(0, resultName.lastIndexOf("."));
			error = resultFold + File.separator + resultName + "_error.txt";
			result = resultFold + File.separator + resultName + "_result.txt";
			PrintWriter writer = new PrintWriter(cmdFile);
			writer.println("set on_failure_script_quits");
			writer.println("ocra_check_refinement -i " + " \"" + modelPath + "\"");
			writer.println("quit");
			writer.flush();
			writer.close();
			
			String cmd[] = new String[] {ocraPath, "-source", cmdFile.getPath()};
			callOcraTool(cmd);
			
		}catch (final Exception e) {
			e.printStackTrace();
			displayErrorMessage(e.getMessage());
		}
		return result;
	}
	
	public String checkValidationProp(String modelPath){
		
		try{
			String resultName = modelPath.substring(modelPath.lastIndexOf(File.separator)+1, modelPath.length());
			resultName = resultName.substring(0, resultName.lastIndexOf("."));
			error = resultFold + File.separator + resultName + "_error.txt";
			result = resultFold + File.separator + resultName + "_consistency_result.txt";
			PrintWriter writer = new PrintWriter(cmdFile);
			writer.println("set on_failure_script_quits 1");
			writer.println("set ocra_discrete_time");
			writer.println("ocra_check_syntax -i" + " \"" + modelPath + "\"");
			writer.println("ocra_check_validation_prop -i " + " \"" + modelPath + "\"" + " -a ic3 -w -s");
			writer.println("quit");
			writer.flush();
			writer.close();
			
			String cmd[] = new String[] {ocraPath, "-source", cmdFile.getPath()};
			callOcraTool(cmd);
			
		}catch (final Exception e) {
			e.printStackTrace();
			displayErrorMessage(e.getMessage());
		}
		return result;
	}
	
	public void checkImplementation(String modelPath, String smvPath, String name){
				
		String resultName = smvPath.substring(smvPath.lastIndexOf(File.separator)+1, smvPath.length());
		resultName = resultName.substring(0, resultName.lastIndexOf("."));
		error = resultFold + File.separator + resultName + "_error.txt";
		result = resultFold + File.separator + resultName + "_result.txt";
		try{
			PrintWriter writer = new PrintWriter(cmdFile);
			writer.println("set on_failure_script_quits");
			writer.println("ocra_check_implementation -i " + " \"" + modelPath + "\"" + " -I " + "\"" + smvPath + "\"" + " -c " + name);
			writer.println("quit");
			writer.flush();
			writer.close();
			
			String cmd[] = new String[] {ocraPath, "-source", cmdFile.getPath()};
			callOcraTool(cmd);
			
		}catch (final Exception e) {
			e.printStackTrace();
			displayErrorMessage(e.getMessage());
		}
	}
	
	public boolean checkFormalProperty(Constraint formalProp){
		
		try{
			PrintWriter writer = new PrintWriter(cmdFile);
			writer.println( "set on_failure_script_quits");
			String spec = formalProp.getSpecification().stringValue();
			if(spec == null){
				writer.close();
				return false;
			}
			spec = spec.replace("\n", "").replace("\r", "").replace(";", "");
			writer.println("ocra_check_syntax -c -p " + "\"" + spec + "\"");
			writer.println("quit");
			writer.flush();
			writer.close();
			
			String cmd[] = new String[] {ocraPath, "-source", cmdFile.getPath()};

			int exitVal = callOcraTool(cmd);
			
			if(exitVal == 0){
				return true;
			}else{
				return false;
			}			
		}catch (Exception e) {
			e.printStackTrace();
			if (shell != null )
				MessageDialog.openError(shell, "Problem during analysis", e.getMessage());
			return false;
		}
	}
	
	private int callOcraTool (String[] cmd) throws IOException, InterruptedException{
		
		Runtime rt = Runtime.getRuntime();
		Process proc = rt.exec(cmd);

		InputStreamer errorStreamer;
		if(error != null){
			errorStreamer= new InputStreamer(proc.getErrorStream(), "ERROR", error);
		}else{
			errorStreamer= new InputStreamer(proc.getErrorStream(), "ERROR");
		}
		InputStreamer outputStreamer;
		if(result != null){
			outputStreamer = new InputStreamer(proc.getInputStream(), "OUTPUT", result);
		}else{
			outputStreamer = new InputStreamer(proc.getInputStream(), "OUTPUT");
		}
		errorStreamer.start();
		outputStreamer.start();

		return proc.waitFor();
	}
	
	private void displayErrorMessage(final String message) {
		shell.getDisplay().syncExec(new Runnable(){
			@Override
			public void run() {
				MessageDialog.openError(shell, "Problems found during analysis", message);
			}
		});
	}
}
