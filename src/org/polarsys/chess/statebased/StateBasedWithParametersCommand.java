/*
-----------------------------------------------------------------------
-- Copyright (C) 2011-2016                                           --
-- University of Firenze, Italy	                                     --
-- Intecs S.p.A., Italy                                              --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
--                                                                   --
-- Contributors:                                                     --
-- Leonardo Montecchi 	lmontecchi@unifi.it                          --
-----------------------------------------------------------------------
*/

package org.polarsys.chess.statebased;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;

import org.polarsys.chess.chessmlprofile.chessmlprofilePackage;
import org.polarsys.chess.chessmlprofile.Core.CHESS;
import org.polarsys.chess.core.util.CHESSProjectSupport;
import org.polarsys.chess.core.util.uml.ResourceUtils;
import org.polarsys.chess.service.utils.CHESSEditorUtils;
import org.polarsys.chess.statebased.daemon.ParameterList;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.wizard.ProgressMonitorPart;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFExtractor;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.core.service.CoreService;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Stereotype;

public class StateBasedWithParametersCommand extends AbstractHandler implements Runnable {
	
//	private static final String RESURCEPLATFORM = "CHESS::Core::CHGaResourcePlatform";

	private static final String PLUGIN_PATH = "platform:/plugin/org.polarsys.chess.statebased";
	
	private static final String sysmlPath = "http://www.eclipse.org/papyrus/0.7.0/SysML";
	private static final String martePath = "http://www.eclipse.org/papyrus/MARTE/1";
//	private static final String chessPath = "http://schemas/CHESS/_PfAJsMe6Ed-7etIj5eTw0Q/19";
	private static final String chessPath = "ttp://CHESS";
	private static final String umlPath	= "http://www.eclipse.org/uml2/4.0.0/UML";
	private static final String imPath = PLUGIN_PATH + "/metamodels/IM2.ecore";
	private static final String pnmlPath = PLUGIN_PATH + "/metamodels/placeTransition.ecore";
	
	private static final String STEP1_PATH = PLUGIN_PATH + "/transformations/CHESS2IM.asm";
	private static final String STEP2_PATH = PLUGIN_PATH + "/transformations/IDM2PNML.asm";
	private static final String STEP3_PATH = PLUGIN_PATH + "/transformations/PNML2DEEM.asm";

	public static final String COMMAND_ID = "org.chess.stateBasedTransformationCommandID";
	
	private static final String SBANALYSIS_DIR = "StateBasedAnalysis";
	private static final String UML = ".uml";
	private static final String IM = ".idm";
	private static final String PNML = ".pnml";
	private static final String DEEM = ".deem";
	
	private static IInjector injector;
	private static IExtractor extractor;
	
	private static IReferenceModel sysmlMetamodel;
	private static IReferenceModel marteMetamodel;
	private static IReferenceModel chessMetamodel;
	private static IReferenceModel umlMetamodel;
	private static IReferenceModel imMetamodel;
	private static IReferenceModel pnmlMetamodel;

	
	private static String chessModelPath;
	private static String imModelPath;
	private static String pnmlModelPath;
	private static String resultName;
	
	private static final String NETNAME = "NET_NAME";
	private static final String MEASURE = " ->";
	private static final String CHESS_QN = "CHESS::Core::CHESS";
	private static final String STATEBASED_ANALYSIS_QN = "CHESS::Dependability::StateBased::StateBasedAnalysis::StateBasedAnalysis";
	private static final String RESULT = "measureEvaluationResult";

	private static Shell shell = new Shell();
	private static final String ERROR_MSG = "Problems while perfoming State-Based Analysis: ";
	
	static PapyrusMultiDiagramEditor editor;
	static ParameterList params;
	static PeriodicExecutionDialog periodicDialog;
	
	static IFile inputFile;
	static String paramFilePath;
	static String resultsFilePath;
	static IFolder folder;
	
	static DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
	
	@Override
	/**
	 * Execute the command from the Eclipse menu
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		acquireModel();
		
		periodicDialog = new PeriodicExecutionDialog(shell);
		
		periodicDialog.open();
		
		return null;
	}
	
	
	/**
	 * Runs the state based analysis
	 * @param modelPath the absolute path of the CHESS model file
	 * @param resultAnalysisPathFile the absolute path of the analysis result file
	 * @return the textual result from the analysis
	 * @throws IOException 
	 */
	public String runStateBased (String modelPath, String parametersFilePath, String resultAnalysisPathFile) throws IOException{

		IProgressMonitor monitor = null;
		if(periodicDialog != null)
			monitor = periodicDialog.getMonitor();

		InputStream is = RunTransformations(modelPath, parametersFilePath, monitor);
		
		byte[] buffer = new byte[is.available()];
	    is.read(buffer);
	 
	    File targetFile = new File(resultAnalysisPathFile);
	    OutputStream outStream = new FileOutputStream(targetFile);
	    outStream.write(buffer);
	    outStream.close();
		
		System.out.println("Connecting to DEEM server...");
		String res = connectToDeem(targetFile.getAbsolutePath(), targetFile.getParent(), monitor);
		return res;
	}
	
	
	protected void setEditor(PapyrusMultiDiagramEditor ed) {
		editor = ed;
	}
	
	protected void setParameters(ParameterList p) {
		params = p;
	}
	
	protected static void runStateBased() {
		//make a copy of the chess model
		IFile inputCopy;
		try {
			inputCopy = CHESSProjectSupport.copyFile(inputFile, SBANALYSIS_DIR, inputFile.getName());
		} catch (Exception e) {
			e.printStackTrace();
			CHESSProjectSupport.printlnToCHESSConsole(e.toString());
			displayMessage(shell, ERROR_MSG + e.toString(), MessageDialog.ERROR);
			return;
		}
				
		//run model transformations
		InputStream is = RunTransformations(inputCopy.getLocation().toString(), paramFilePath, periodicDialog.getMonitor());
		
		//Save (write to file) the result
		resultName = changeSuffix(inputFile.getName(), UML, DEEM);			
		
		IFile resultFile = folder.getFile(resultName);
		//if (!resultFile.exists()){   //overwrite previous results (otherwise they are not updated when the model changes)
			try {
				resultFile.delete(true, null);
				resultFile.create(is, IResource.FORCE, null);
			} catch (CoreException e) {
				e.printStackTrace();
				CHESSProjectSupport.printlnToCHESSConsole(e.toString());
				displayMessage(shell, ERROR_MSG + e.toString(), MessageDialog.ERROR);
				return;
			}
			
		//}
		
		String res = connectToDeem(resultFile.getLocation().toString(), resultFile.getParent().getLocation().toString(), periodicDialog.getMonitor());
		if(res != null && !res.isEmpty()){
			backPropagation(res, editor);
		}
		
		periodicDialog.stopMonitor();
	}

	protected static void acquireModel() {
		try {
			editor = CHESSEditorUtils.getCHESSEditor();
			params = DEEMClient.getParameters();
			
			IFileEditorInput input = (IFileEditorInput) editor.getEditorInput();
			IFile file = input.getFile();
			IProject project = file.getProject();
			
			folder = project.getFolder(SBANALYSIS_DIR);
			CHESSProjectSupport.createFolder(folder);
			
			Resource inResource = ResourceUtils.getUMLResource(editor.getServicesRegistry());
			inputFile = CHESSProjectSupport.resourceToFile(inResource);
		} catch (CoreException e) {
			e.printStackTrace();
			CHESSProjectSupport.printlnToCHESSConsole(e.toString());
			displayMessage(shell, ERROR_MSG + e.toString(), MessageDialog.ERROR);
		} catch (ServiceException e) {
			e.printStackTrace();
			CHESSProjectSupport.printlnToCHESSConsole(e.toString());
			displayMessage(shell, ERROR_MSG + e.toString(), MessageDialog.ERROR);
		}
	}
	
	protected static void setParamsFilePath(String path) {
		paramFilePath = path;
	}
	
	protected static void setResultsFilePath(String path) {
		resultsFilePath = path;
	}
	
	/**
	 * 
	 * @param chessModelFullPath the absolute path in the local file system to the chess model
	 * @param parametersFilePath the absolute path in the local file system to the parameters file
	 * @return the inputStream of the resulting transformed deem model file
	 */
	private static InputStream RunTransformations(String chessModelFullPath, String parametersFilePath, IProgressMonitor monitor){
		
		try {
					
			chessModelPath = chessModelFullPath;
			// Begin: Read parameters
		
			File fParams = new File(parametersFilePath);
			
			HashMap<String, String> mapParameters = new HashMap<String, String>();
			FileReader fr = new FileReader(fParams);
            String s;
            String[] sSplit;
            try {
            	BufferedReader br = new BufferedReader(fr);
            	
                while ((s = br.readLine()) != null) {
                    sSplit = s.split("\\s+");
                    mapParameters.put(sSplit[0], sSplit[1]);
                }
            }catch(Exception e) {
            	e.printStackTrace();
            	System.out.println(e.getMessage());
            }finally{
            	fr.close();
            }
			// End: Read parameters
            // Begin: Replace parameters in .uml file
            //URI uri = new URI("file:///"+chessModelFullPath);
            File fCHESSModel = new File(chessModelFullPath);
            FileReader frModel = new FileReader(fCHESSModel);
            String sModelContent = "";
            try {
            	BufferedReader brModel = new BufferedReader(frModel);
            	while ((s = brModel.readLine()) != null) {
            		sModelContent += s + "\r\n";
            	}
            }catch(Exception e) {
            	e.printStackTrace();
            	System.out.println(e.getMessage());
			}finally{
				frModel.close();
			}
            Iterator<String> itParams = mapParameters.keySet().iterator();
            String sCurrentKey = null;
            while(itParams.hasNext()) {
            	sCurrentKey = itParams.next();
            	sModelContent = sModelContent.replaceAll("\\" + sCurrentKey, mapParameters.get(sCurrentKey));
            }
            FileWriter fwModel = new FileWriter(fCHESSModel);
            try {
            	fwModel.write(sModelContent);
            }catch(Exception e) {
            	e.printStackTrace();
            	System.out.println(e.getMessage());
            }finally{
            	fwModel.close();
            }
            
            // End: Replace parameters in .uml file
			
			CoreService.registerLauncher("EMF-specific VM", EMFVMLauncher.class);
			CoreService.registerFactory("EMF", EMFModelFactory.class); 
			CoreService.registerExtractor("EMF", EMFExtractor.class);
			CoreService.registerInjector("EMF", EMFInjector.class);
			
			injector = CoreService.getInjector("EMF"); 
			extractor = CoreService.getExtractor("EMF"); 
			
			ModelFactory factory = CoreService.getModelFactory("EMF");
			
			//IReferenceModel(s) for the meta-models
			sysmlMetamodel = factory.newReferenceModel();
			marteMetamodel = factory.newReferenceModel();
			chessMetamodel = factory.newReferenceModel();
			umlMetamodel = factory.newReferenceModel();
			imMetamodel = factory.newReferenceModel();
			
			//Register EPackages
			EPackage.Registry.INSTANCE.put(sysmlPath, org.eclipse.papyrus.sysml.SysmlPackage.eINSTANCE);
			EPackage.Registry.INSTANCE.put(martePath, org.eclipse.papyrus.MARTE.MARTEPackage.eINSTANCE);
			EPackage.Registry.INSTANCE.put(chessPath, chessmlprofilePackage.eINSTANCE);
			EPackage.Registry.INSTANCE.put(umlPath, org.eclipse.uml2.uml.UMLPackage.eINSTANCE);
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
			
			/** 
			 * run CHESS -> IM transformation:
			 * module CHESS2IM;
			 * create OUT: IM from IN1: CHESS, IN2: UML2, IN3: MARTE;
			 */
			
			//Load meta-models
			injector.inject(sysmlMetamodel, sysmlPath);
			injector.inject(marteMetamodel, martePath);
			injector.inject(chessMetamodel, chessPath);
			injector.inject(umlMetamodel, umlPath);
			injector.inject(imMetamodel, imPath);
			
			// Create models
			IModel sysmlModel = factory.newModel(sysmlMetamodel);
			IModel marteModel = factory.newModel(marteMetamodel);
			IModel chessModel = factory.newModel(chessMetamodel);
			IModel umlModel = factory.newModel(umlMetamodel);
			IModel imModel = factory.newModel(imMetamodel);
			
			// Load the chess model
			chessModelPath = "file:///"+chessModelPath;
			injector.inject(sysmlModel, chessModelPath);
			injector.inject(marteModel, chessModelPath);
			injector.inject(chessModel, chessModelPath);
			injector.inject(umlModel, chessModelPath);
			
			//Initialize launcher
			ILauncher launcher = null;
			launcher = (EMFVMLauncher)CoreService.getLauncher("EMF-specific VM"); 
			launcher.initialize(Collections.<String, Object> emptyMap());
			
			//Add models to launch transformation
			launcher.addInModel(chessModel, "IN1", "CHESS");
			launcher.addInModel(chessModel, "IN2", "UML");
			launcher.addInModel(marteModel, "IN3", "MARTE");
			launcher.addInModel(sysmlModel, "IN4", "SYSML");
			launcher.addOutModel(imModel, "OUT", "IM");
			
			//Create a module of the CHESS2IM transformation
			URL asmTransformation = new URL(STEP1_PATH);
			Object loadedModule = launcher.loadModule(asmTransformation.openStream());
			
			//Launch
			launcher.launch(ILauncher.RUN_MODE, new NullProgressMonitor(), Collections
					.<String, Object> emptyMap(), loadedModule);
			
			//Save model
			imModelPath = changeSuffix(chessModelPath, UML, IM);
			extractor.extract(imModel, imModelPath);
			
			System.out.println("CHESS -> IM ... DONE!");
			progress(1);
			
			/** 
			 * run IM -> PNML transformation:
			 * module IDM2PNML;
			 * create OUT : PNML from IN : IDM;
			 */
			
			//IReferenceModel for PNML Metamodel
			pnmlMetamodel = factory.newReferenceModel();
			
			//inject PNML Metamodel
			injector.inject(pnmlMetamodel, pnmlPath);
			
			//create IModels from PNML Metamodel
			IModel pnmlModel = factory.newModel(pnmlMetamodel);
			
			// reset the launcher
			launcher = null;
			launcher = (EMFVMLauncher)CoreService.getLauncher("EMF-specific VM"); 
			launcher.initialize(Collections.<String, Object> emptyMap());
			
			//Add in and out Models to the launcher
			launcher.addInModel(imModel, "IN", "IDM");
			launcher.addOutModel(pnmlModel, "OUT", "PNML");
			//launcher.addOutModel(measuresModel, "out2", "MOI");
			
			//create a module of the IDM2PNML.asm transformation
			asmTransformation = new URL(STEP2_PATH);
			loadedModule = launcher.loadModule(asmTransformation.openStream());
			
			//launch transformation
			launcher.launch(ILauncher.RUN_MODE, new NullProgressMonitor(), Collections
					.<String, Object> emptyMap(), loadedModule);

			//save pnml model
			pnmlModelPath = changeSuffix(chessModelPath, UML, PNML);
			extractor.extract(pnmlModel, pnmlModelPath);
			
			System.out.println("IM -> PNML ... DONE!");
			progress(1);
			
			/** 
			 * run PNML -> DEEM transformation:
			 * module PNML2DEEM;
			 */
			
			// reset the launcher
			launcher = null;
			launcher = (EMFVMLauncher)CoreService.getLauncher("EMF-specific VM"); 
			launcher.initialize(Collections.<String, Object> emptyMap());
			
			//Add in Model to the launcher
			launcher.addInModel(pnmlModel, "IN", "PNML");
			//launcher.addOutModel(deemModel, "out1", "DEEM");
			
			//create a module of the PNML2DEEM.asm transformation
			asmTransformation = new URL(STEP3_PATH);
			loadedModule = launcher.loadModule(asmTransformation.openStream());
		
			//launch transformation
			Object result = launcher.launch(ILauncher.RUN_MODE, new NullProgressMonitor(), Collections
					.<String, Object> emptyMap(), loadedModule);

		
			String stResult = result.toString();
			stResult = stResult.substring(1, stResult.lastIndexOf(']'));
			InputStream is = new ByteArrayInputStream(stResult.getBytes("UTF-8"));
			
			System.out.println("PNML -> DEEM ... DONE!");
			progress(1);
			return is;
			
		//exception handling?
		} catch (ATLCoreException e) {
			e.printStackTrace();
			CHESSProjectSupport.printlnToCHESSConsole(e.toString());
			displayMessage(shell, ERROR_MSG + e.toString(), MessageDialog.ERROR);
			return null;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			CHESSProjectSupport.printlnToCHESSConsole(e.toString());
			displayMessage(shell, ERROR_MSG + e.toString(), MessageDialog.ERROR);
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			CHESSProjectSupport.printlnToCHESSConsole(e.toString());
			displayMessage(shell, ERROR_MSG + e.toString(), MessageDialog.ERROR);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			CHESSProjectSupport.printlnToCHESSConsole(e.toString());
			displayMessage(shell, ERROR_MSG + e.toString(), MessageDialog.ERROR);
			return null;
		} 
	}
	
	/**
	 * 
	 * @param model the full path of the deem model
	 * @param folder the folder where the deem model is located
	 * @return
	 */
	private static String connectToDeem(String modelPath, String modelFolderPath, IProgressMonitor monitor){
		try{
			DEEMClient c = new DEEMClient();
			c.setProgressMonitor(monitor);
			String res = c.sendAndReceiveFile(modelPath, modelFolderPath);
			return res;
		} catch (UnknownHostException e) {
			e.printStackTrace();
			CHESSProjectSupport.printlnToCHESSConsole(e.toString());
			displayMessage(shell, ERROR_MSG + e.toString(), MessageDialog.ERROR);
			return null;
		} catch (SocketTimeoutException e) {
			e.printStackTrace();
			CHESSProjectSupport.printlnToCHESSConsole(e.toString());
			displayMessage(shell, ERROR_MSG + e.toString(), MessageDialog.ERROR);
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			CHESSProjectSupport.printlnToCHESSConsole(e.toString());
			displayMessage(shell, ERROR_MSG + e.toString(), MessageDialog.ERROR);
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			CHESSProjectSupport.printlnToCHESSConsole(e.toString());
			displayMessage(shell, ERROR_MSG + e.toString(), MessageDialog.ERROR);
			return null;
		}
	}
	
	private static void backPropagation(String analysis, PapyrusMultiDiagramEditor editor) {
		
		try {
			String name = null;
			String value = null;
			//get data from analysis file
			FileInputStream fstream = new FileInputStream(analysis);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line;
			String[] lineSplit;
			Map<String, String> results = new HashMap<String, String>();
			while ((line = br.readLine()) != null){
				if(line.startsWith(MEASURE)){
					lineSplit = line.split("\\s+");
					name = lineSplit[2];
					value = lineSplit[3];
					if(lineSplit[4].equals("(*)")) {
						value = value + " " + lineSplit[4];
					}
					
					results.put(name, value);
				}
			}
			in.close();
			
			if(results.size() > 0) {
				//get model file
				Resource res = ResourceUtils.getUMLResource(editor.getServicesRegistry());
				Model umlModel = ResourceUtils.getModel(res);
				
				//get the CHESS stereotype
				CHESS chess = (CHESS) umlModel.getStereotypeApplication(umlModel.getAppliedStereotype(CHESS_QN));
				//navigate and update the model with the analysis result
				Package depView = chess.getAnalysisView().getDepanalysisview().getBase_Package();
	
				EList<PackageableElement> packList = depView.getPackagedElements();
				Component comp = null;
				
				Iterator<String> it = results.keySet().iterator();
				String key = null;
	
				File fResults = new File(resultsFilePath);
	            FileWriter fwModel = new FileWriter(fResults);
				
	            dateFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
				while(it.hasNext()) {
					key = it.next();
	
					for (int i = 0 ; i < packList.size(); i++){
						if(packList.get(i).getName().equals(key)){
							comp = (Component) packList.get(i);
						}
					}
					
					final String finalValue = results.get(key);
					final Component com = comp;
					final Stereotype stereotype = comp.getAppliedStereotype(STATEBASED_ANALYSIS_QN);
					TransactionalEditingDomain editingDomain = (TransactionalEditingDomain) editor.getEditingDomain();
					editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
						
						protected void doExecute() {
							com.setValue(stereotype, RESULT, finalValue);
						}
					});
					
					//Write the result in the result file
		            fwModel.write(finalValue);
		            fwModel.write("\t");
		            fwModel.write(key);
		            fwModel.write("\t");
		            fwModel.write(dateFormatter.format(new Date()));
		            fwModel.write("\r\n");
				}
	            fwModel.close();
			}else{
				System.out.println("Error: Unable to retrieve results from DEEM server.");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			CHESSProjectSupport.printlnToCHESSConsole(e.toString());
			displayMessage(shell, ERROR_MSG + e.toString(), MessageDialog.ERROR);
		} catch (ServiceException e) {
			e.printStackTrace();
			CHESSProjectSupport.printlnToCHESSConsole(e.toString());
			displayMessage(shell, ERROR_MSG + e.toString(), MessageDialog.ERROR);
		} 
	}

	//FIXME: not aligned to Luna release (cause: unused)
//	protected void CallBuildInstances(final PapyrusMultiDiagramEditor editor) {
//
//		try {
//			//retrieve the diagrams for which the instance have to be rebuildt
//			Resource notation = ResourceUtils.getNotationResource(editor.getServicesRegistry());
//			
//			EList <EObject> tmp = notation.getContents();
//			for (int i = 0; i < tmp.size(); i++){
//				Diagram di = (Diagram) tmp.get(i);
//				if(di.getType().equals("CompositeStructure")){
//					Element e = (Element)di.getElement();
//					if(e.getAppliedStereotype(RESURCEPLATFORM) != null){
//						
//						final CompositeStructureDiagramEditPart csd_ep = (CompositeStructureDiagramEditPart) di;
//						TransactionalEditingDomain editingDomain = csd_ep.getEditingDomain();
//						editingDomain.getCommandStack().execute(
//								new RecordingCommand(editingDomain) {
//									protected void doExecute() {
//										if (BuildInstanceCommand.buildPrototypeInstanceRestoringAssigns(editor, csd_ep, new StringBuffer()) != null){
//											editor.getDiagramStatus().setUserAction(false);
//										}
//									}
//								});
//					}
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			CHESSProjectSupport.printlnToCHESSConsole(e.toString());
//		}
//		
//	}


	private static String changeSuffix(String str, String oldsfx, String newsfx){
		
		if (str.endsWith(oldsfx)){
			str = str.substring(0, str.lastIndexOf("."));
			str += newsfx;
		}
		return str;		
	}
	
	public static void displayMessage(final Shell parent, final String message, final int kind){
		
		final String title = "State-Based Analysis";
		parent.getDisplay().syncExec(new Runnable() {
			@Override
			public void run() {
				MessageDialog.open(kind, parent, title, message, SWT.NONE);
			}
		});
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		runStateBased();
	}


	public static String getModelPath() {
		return inputFile.getFullPath().toString();
	}
	
	private static void progress(int work) {
		if(periodicDialog != null)
			periodicDialog.progress(work);
	}
}
