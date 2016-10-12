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
 * Initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.polarsys.chess.contracts.transformations.commands;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;
import org.polarsys.chess.contracts.integration.ToolIntegration;
import org.polarsys.chess.contracts.transformations.dialogs.RefinementResultDialog;
import org.polarsys.chess.contracts.transformations.main.Generate;
import org.polarsys.chess.contracts.transformations.main.GenerateErrorModel;
import org.polarsys.chess.contracts.transformations.main.GenerateFaultExtensions;

public class CommandsCommon {

	public static final String UML_EXT = ".uml";
	public static final String OSS_EXT = ".oss";
	public static final String SMV_EXT = ".smv";
	public static final String FEI_EXT = ".fei";
	public static final String OCRA_FOLD = "NuSMV3-OCRA";
	public static final String XSAP_FOLD = "NuSMV3-XSAP";
	public static final String RES_FOLD = "Results";
	public static final String FILES_FOLD = "Files";
	public static final String TEMP_FOLD = "Temp";
	public static final int NUM_SUB_TASKS = 4;
	
	public static enum CommandEnum {REFINEMENT, IMPLEMENTATION, FTA}
	
	public static void TransformationJob(final Shell activeShell, final IEditorPart editor, final List<String> args, final CommandEnum commandType, final String blockName, final String ftaCondition){
		
		Job job = new Job("Analysis Running"){

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				
				monitor.beginTask("operation in progress ...", NUM_SUB_TASKS);
				
				monitor.subTask("setting up project folders (if needed)...");
				IFileEditorInput input = (IFileEditorInput) editor.getEditorInput();
				IFile inputfile = input.getFile();
				
				IProject project = inputfile.getProject();
				IFolder folder = null;
				IFolder tempFolder = null;
				if(commandType == CommandEnum.FTA){
					folder = project.getFolder(XSAP_FOLD);
					
				}else{
					folder = project.getFolder(OCRA_FOLD);
				}
				IFolder results = folder.getFolder(RES_FOLD);
				IFolder files = folder.getFolder(FILES_FOLD);
				try {
					if (!folder.exists()){
						folder.create(true, true, null);
					}
					if (!results.exists()){
						results.create(true, true, null);
					}
					if (!files.exists()){
						files.create(true, true, null);
					}
					if(commandType == CommandEnum.FTA){
						tempFolder = folder.getFolder(TEMP_FOLD);
						if(tempFolder.exists()){
							tempFolder.delete(true, null);;
						}
						tempFolder.create(true, true, null);
					}
					
				} catch (CoreException e) {
					e.printStackTrace();
					return Status.CANCEL_STATUS;
				}
				
				String resultFile = results.getLocation().toString();
				String tempFiles = null;
				if(commandType == CommandEnum.FTA){
					tempFiles = tempFolder.getLocation().toString();
				}
				ToolIntegration checker = new ToolIntegration(activeShell, resultFile, tempFiles);
				
				String stringToURI = inputfile.getFullPath().toString();
				stringToURI = stringToURI.substring(0, stringToURI.lastIndexOf("."));
				stringToURI = stringToURI + UML_EXT;

				URI modelURI = URI.createPlatformResourceURI(stringToURI , true);
				File target = files.getLocation().toFile();
				monitor.worked(1);
				try {
					String systemName = null;
					Generate gen = null;
					String location = null;
					String smvLocation = null;
					String feiLocation = null;
					String resultLocation = null;
					switch (commandType) {
					case REFINEMENT:
						monitor.subTask("transforming uml model...");
						systemName = args.get(0).substring(args.get(0).lastIndexOf("::")+2);
						gen = new Generate(modelURI, target, args);
						gen.doGenerate(null);
						monitor.worked(1);
						location = target + File.separator + args.get(2);
						location = location + "_" + systemName + OSS_EXT;
						monitor.subTask("performing refinement check analysis...");
						resultLocation = checker.checkRefinement(location);
						break;
					case IMPLEMENTATION:
						monitor.subTask("transforming uml model...");
						systemName = args.get(0).substring(args.get(0).lastIndexOf("::")+2);
						gen = new Generate(modelURI, target, args);
						gen.doGenerate(null);
						monitor.worked(1);
						location = target + File.separator + args.get(2);
						location = location + "_" + systemName + OSS_EXT;
//						resultLocation = null;
						monitor.subTask("performing implementation check analysis...");
						String name = blockName.substring(blockName.lastIndexOf("::")+2);
						smvLocation = target + File.separator + name + SMV_EXT;
						checker.checkImplementation(location, smvLocation, name);
						break;
					case FTA:
						systemName = args.get(0).substring(args.get(0).lastIndexOf("::")+2);
						monitor.subTask("transforming uml model... (SMV)");
						GenerateErrorModel genFTA = new GenerateErrorModel(modelURI, target, args);
						genFTA.doGenerate(null);
						monitor.worked(1);
						monitor.subTask("transforming uml model... (Fault Extensions)");
						GenerateFaultExtensions genFex = new GenerateFaultExtensions(modelURI, target, args);
						genFex.doGenerate(null);
						smvLocation = target + File.separator + args.get(2);
						feiLocation = smvLocation;
						smvLocation = smvLocation + "_" + systemName + SMV_EXT;
						feiLocation = feiLocation + "_" + systemName + FEI_EXT;
						monitor.subTask("calling xSAP");
						checker.FTA(smvLocation, feiLocation, ftaCondition);
						monitor.worked(1);
						break;

					default:
						break;
					}
					monitor.worked(1);
					
					//analysis results popup
					if(resultLocation != null){
						//read from file_result.txt
						FileInputStream fstream = new FileInputStream(resultLocation);
						DataInputStream in = new DataInputStream(fstream);
						BufferedReader br = new BufferedReader(new InputStreamReader(in));
						String text = "";
						String line = "";
						while ((line = br.readLine()) != null){
							if(!line.startsWith("*")){
								text += line;
								text += "\n";
							}
						}
						fstream.close();
						in.close();
						br.close();
						//show the dialog
						openRefinementResult(text);
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				} finally{
					try {
						monitor.subTask("refreshing...");
						project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
						monitor.worked(1);
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
				monitor.done();
				if (monitor.isCanceled())
					return Status.CANCEL_STATUS;
				return Status.OK_STATUS;
			}

		};
		
		job.setUser(true);
		job.setPriority(Job.SHORT);
		job.schedule();
	}

	private static void openRefinementResult(final String text) {

		final Display display = PlatformUI.getWorkbench().getDisplay();
		display.asyncExec(new Runnable() {
			public void run() {
				Shell shell = new Shell(display);
				RefinementResultDialog dialog = new RefinementResultDialog(shell, text);
				if (dialog.open() == Window.OK) {
				   //System.out.println("OK");
				}
			}
		});
	}
	
}
