package org.chess.statebased;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;

import org.polarsys.chess.chessmlprofile.chessmlprofilePackage;
import org.polarsys.chess.core.util.CHESSProjectSupport;
import org.polarsys.chess.core.util.uml.ResourceUtils;
import org.polarsys.chess.service.utils.CHESSEditorUtils;
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
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
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
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ModelEditPart;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Stereotype;

public class StateBasedTransformationCommand extends AbstractHandler {
	
//	private static final String RESURCEPLATFORM = "CHESS::Core::CHGaResourcePlatform";

	private static final String PLUGIN_PATH = "platform:/plugin/org.chess.statebased";
	
	private static final String martePath = "http://www.eclipse.org/papyrus/MARTE/1";
	private static final String chessPath = "http://schemas/CHESS/_PfAJsMe6Ed-7etIj5eTw0Q/19";
	private static final String umlPath	= "http://www.eclipse.org/uml2/3.0.0/UML";
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
	private static final String ANALYSIS_VIEW = "modelAnalysisView";
	private static final String DEPENDABILITY_VIEW = "DependabilityAnalysisView";
	private static final String STATEBASED_ANALYSIS = "CHESS::Dependability::StateBased::StateBasedAnalysis::StateBasedAnalysis";
	private static final String RESULT = "measureEvaluationResult";
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		final PapyrusMultiDiagramEditor editor = CHESSEditorUtils.getCHESSEditor();
		final ParameterList params = DEEMClient.getParameters();

		Shell shell = new Shell();
		try{
			
			ProgressMonitorDialog pmDialog = new ProgressMonitorDialog(shell);
			pmDialog.run(true, true, new IRunnableWithProgress(){
				@Override
				public void run(IProgressMonitor monitor) {		
					//int largeStep = params.getMaximumBatches();
					int smallStep = params.getMinimumBatches();
					int numSubTasks = 3*smallStep/10 + smallStep;
					
					monitor.beginTask("Running State-Based Analysis...", numSubTasks);
					if (monitor.isCanceled())
						return;
					monitor.subTask("Rebuilding instances...");
					//TODO: CallBuildInstances(editor); //skipped at the moment
					monitor.worked(smallStep/10);

					monitor.subTask("Performing model transformations...");
					IFile tr = RunTransformations(editor, monitor);
					monitor.worked(smallStep/10);
					
					monitor.subTask("Connecting to DEEM server...");
					String res = connectToDeem(tr, monitor);
								
					monitor.subTask("Propagating analysis results to the model...");
					backPropagation(res, editor);
					monitor.worked(smallStep/10);
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					monitor.worked(1);
					monitor.done();
				}
			});
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			CHESSProjectSupport.printlnToCHESSConsole(e.toString());
		} catch (InterruptedException e) {
			e.printStackTrace();
			CHESSProjectSupport.printlnToCHESSConsole(e.toString());
		}
		
		return null;
	}


	private static IFile RunTransformations(PapyrusMultiDiagramEditor editor, IProgressMonitor monitor ){
		
		try {
			
			IFileEditorInput input = (IFileEditorInput) editor.getEditorInput();
			IFile file = input.getFile();
			IProject project= file.getProject();
			
			IFolder folder = project.getFolder(SBANALYSIS_DIR);
			CHESSProjectSupport.createFolder(folder);
			
			Resource inResource = ResourceUtils.getUMLResource(editor.getServicesRegistry());
			IFile inputFile = CHESSProjectSupport.resourceToFile(inResource);
			IFile inputCopy = CHESSProjectSupport.copyFile(inputFile, SBANALYSIS_DIR, UML);
			
			chessModelPath = inputCopy.getFullPath().toString();
			
			CoreService.registerLauncher("EMF-specific VM", EMFVMLauncher.class);
			CoreService.registerFactory("EMF", EMFModelFactory.class); 
			CoreService.registerExtractor("EMF", EMFExtractor.class);
			CoreService.registerInjector("EMF", EMFInjector.class);
			
			injector = CoreService.getInjector("EMF"); 
			extractor = CoreService.getExtractor("EMF"); 
			
			ModelFactory factory = CoreService.getModelFactory("EMF");
			
			//IReferenceModel(s) for the meta-models
			marteMetamodel = factory.newReferenceModel();
			chessMetamodel = factory.newReferenceModel();
			umlMetamodel = factory.newReferenceModel();
			imMetamodel = factory.newReferenceModel();
			
			//Register EPackages
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
			injector.inject(marteMetamodel, martePath);
			injector.inject(chessMetamodel, chessPath);
			injector.inject(umlMetamodel, umlPath);
			injector.inject(imMetamodel, imPath);
			
			// Create models
			IModel marteModel = factory.newModel(marteMetamodel);
			IModel chessModel = factory.newModel(chessMetamodel);
			IModel umlModel = factory.newModel(umlMetamodel);
			IModel imModel = factory.newModel(imMetamodel);
			
			// Load the chess model
			injector.inject(marteModel, chessModelPath);
			injector.inject(chessModel, chessModelPath);
			injector.inject(umlModel, chessModelPath);
			
			//Initialize launcher
			ILauncher launcher = null;
			launcher = (EMFVMLauncher)CoreService.getLauncher("EMF-specific VM"); 
			launcher.initialize(Collections.<String, Object> emptyMap());
			
			//Add models to launch transformation
			launcher.addInModel(chessModel, "IN1", "CHESS");
			launcher.addInModel(chessModel, "IN2", "UML2");
			launcher.addInModel(marteModel, "IN3", "MARTE");
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
			monitor.worked(1);
			
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
			monitor.worked(1);
			
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

			//Save (write to file) the result
			resultName = changeSuffix(inputFile.getName(), UML, DEEM);			
			
			String stResult = result.toString();
			stResult = stResult.substring(1, stResult.lastIndexOf(']'));
			InputStream is = new ByteArrayInputStream(stResult.getBytes("UTF-8"));
			
			IFile resultFile = folder.getFile(resultName);
			//if (!resultFile.exists()){   //overwrite previous results (otherwise they are not updated when the model changes)
				resultFile.delete(true, null);
				resultFile.create(is, IResource.FORCE, null);
			//}
			
			System.out.println("PNML -> DEEM ... DONE!");
			monitor.worked(1);
			return resultFile;
			
		//exception handling?
		} catch (ServiceException e) {
			e.printStackTrace();
			CHESSProjectSupport.printlnToCHESSConsole(e.toString());
			return null;
		} catch (ATLCoreException e) {
			e.printStackTrace();
			CHESSProjectSupport.printlnToCHESSConsole(e.toString());
			return null;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			CHESSProjectSupport.printlnToCHESSConsole(e.toString());
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			CHESSProjectSupport.printlnToCHESSConsole(e.toString());
			return null;
		} catch (CoreException e) {
			e.printStackTrace();
			CHESSProjectSupport.printlnToCHESSConsole(e.toString());
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			CHESSProjectSupport.printlnToCHESSConsole(e.toString());
			return null;
		} 
	}
	
	private static String connectToDeem(IFile resultFile, IProgressMonitor monitor){
		
		DEEMClient c = new DEEMClient();
		c.setProgressMonitor(monitor);
		String res = c.sendAndReceiveFile(resultFile.getLocation().toString(), resultFile.getParent().getLocation().toString(), monitor);
		return res;
	}
	
	private void backPropagation(String analysis, PapyrusMultiDiagramEditor editor) {
		
		try {
			String name = null;
			String value = null;
			//get data from analysis file
			FileInputStream fstream = new FileInputStream(analysis);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = br.readLine()) != null){
				if(line.startsWith(NETNAME)){
					name = line.substring(line.indexOf(" ")+1, line.length());
				}
				if(line.startsWith(MEASURE)){
					value = line.substring(line.indexOf("  ")+2, line.indexOf('[')-2);
				}
			}
			in.close();
			
			//get model file
			Resource res = ResourceUtils.getUMLResource(editor.getServicesRegistry());
			Model umlModel = ResourceUtils.getModel(res);
			
			//navigate and update the model with the analysis result
			Package anView = (Package) umlModel.getPackagedElement(ANALYSIS_VIEW);
			Package depView = (Package) anView.getPackagedElement(DEPENDABILITY_VIEW);

			EList<PackageableElement> packList = depView.getPackagedElements();
			Component comp = null;
			for (int i = 0 ; i < packList.size(); i++){
				if(packList.get(i).getName().equals(name)){
					comp = (Component) packList.get(i);
				}
			}
			
			final String finalValue = value;
			final Component com = comp;
			final Stereotype stereotype = comp.getAppliedStereotype(STATEBASED_ANALYSIS);
			TransactionalEditingDomain editingDomain = (TransactionalEditingDomain) editor.getEditingDomain();
			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
				
				protected void doExecute() {
					com.setValue(stereotype, RESULT, finalValue);
				}
			});
			
		} catch (IOException e) {
			e.printStackTrace();
			CHESSProjectSupport.printlnToCHESSConsole(e.toString());
		} catch (ServiceException e) {
			e.printStackTrace();
			CHESSProjectSupport.printlnToCHESSConsole(e.toString());
		} 
	}

	//FIXME: not aligned to Luna release (cause: unused)
//	protected void CallBuildInstances(final PapyrusMultiDiagramEditor editor) {
//
//		try {
//			//retrieve the diagrams for which the instance have to be rebuilded
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
		
}
