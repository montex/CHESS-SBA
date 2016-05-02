/*------------------------------------------------------------------------------
  -
  - Copyright (c) 2015-2016 University of Padova, ITALY -  Intecs SpA 
  - All rights reserved. This program and the accompanying materials
  - are made available under the terms of the Eclipse Public License v1.0
  - which accompanies this distribution, and is available at
  - http://www.eclipse.org/legal/epl-v10.html
  -
  - Contributors:
  -
  - Alessandro Zovi azovi@math.unipd.it
  - Stefano Puri stefano.puri@intecs.it
  - Laura Baracchi laura.baracchi@intecs.it
  - Nicholas Pacini nicholas.pacini@intecs.it  
  -
  - Initial API and implementation and/or initial documentation
  ------------------------------------------------------------------------------*/package org.polarsys.chess.multicore.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.widgets.providers.FilteredContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.StaticContentProvider;
import org.eclipse.papyrus.infra.widgets.selectors.ReferenceSelector;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwProcessor;
import org.polarsys.chess.core.profiles.CHESSProfileManager;
import org.polarsys.chess.core.util.uml.ModelError;
import org.polarsys.chess.core.util.uml.UMLUtils;
import org.polarsys.chess.multicore.ReferenceSelectorNoDoubleClick;
import org.polarsys.chess.multicore.dialogs.CoreSelectorDialog;
import org.polarsys.chess.multicore.dialogs.SystemSelectionDialog;
import org.polarsys.chess.multicore.model.AbstractCommand;
import org.polarsys.chess.multicore.model.CHCore;
import org.polarsys.chess.multicore.utils.QueryUtils;

public class AssignComponents2CoresCommand extends
AbstractCommand {

	private EList<CHCore> cores;
	private EList<InstanceSpecification> components;
	private Map<CHCore, LinkedHashSet<Object>> result;
	private EList<InstanceSpecification> processors;
	private static Component hwSystem;
	private Map<Package, EList<InstanceSpecification>> processorsMap =  new HashMap<Package, EList<InstanceSpecification>>();
	private Map<InstanceSpecification, EList<CHCore>> coresMap = new HashMap<InstanceSpecification, EList<CHCore>>();
	private EList<InstanceSpecification> hwSystemsList = new BasicEList<InstanceSpecification>();

	private EList<Assign> assignments;


	/**
	 * Open selector to choose HW system where assign components
	 * @param umlModel
	 * @param hwSystemsList
	 * @return
	 */
	private static InstanceSpecification openSystemSelector (Model umlModel, 
			EList<InstanceSpecification> hwSystemsList) {

		// First of all show selector to select HwSystem
		List<InstanceSpecification> systemSelection = new ArrayList<InstanceSpecification>();
		for (InstanceSpecification syst : hwSystemsList) {
			systemSelection.add(syst);
		}

		Shell activeShell = Display.getDefault().getActiveShell();
		SystemSelectionDialog systemDialog = new SystemSelectionDialog(activeShell, systemSelection, "Select System where to assign tasks");
		if (systemDialog.open() == Window.OK) {
			String selectedSystemQN = systemDialog.getSystemName();
			EList<Element> allElems = umlModel.allOwnedElements();
			for (Element elem : allElems) {
				InstanceSpecification theSystem;
				if (elem instanceof InstanceSpecification) {
					theSystem = (InstanceSpecification)elem;
					if (theSystem.getQualifiedName()!=null && theSystem.getQualifiedName().equals(selectedSystemQN)) {							
						Classifier classif = theSystem.getClassifiers().get(0);
						hwSystem = (Component)classif;
						return theSystem;
					}				
				}
			}
		}
		return null;
	}


	/**
	 * Open wizard to assign components to cores
	 * @param components
	 * @param pack
	 * @param cores
	 * @param assignments
	 * @return
	 */
	private static Map<CHCore, LinkedHashSet<Object>> openWizard(
			final EList<InstanceSpecification> components,
			Package pack, 
			EList<CHCore> cores,
			EList<Assign> assignments) {

		final ServicesRegistry servicesRegistry = ((IMultiDiagramEditor) (PlatformUI
				.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getActiveEditor())).getServicesRegistry();

		// LB 20150713 Show components in the left side 
		// Only show the components that are not assigned to a Processor 
		EList<InstanceSpecification> instSpecNotYetAssignedToCore = new BasicEList<InstanceSpecification>();
		for (InstanceSpecification i : components) {
			if (!(QueryUtils.isAssigned2Core(i, pack, assignments))) {
				instSpecNotYetAssignedToCore.add(i);			
			}
		}	
		final ReferenceSelector referenceSelector = new ReferenceSelectorNoDoubleClick(
				true, instSpecNotYetAssignedToCore, null);

		final IStaticContentProvider semanticProvider = new StaticContentProvider(
				components.toArray());

		final FilteredContentProvider filteredProvider = new FilteredContentProvider(
				semanticProvider);		
		referenceSelector.setContentProvider(filteredProvider);
		///

		CoreSelectorDialog dialog = null;

		ILabelProvider serv = null;
		try {
			serv = servicesRegistry.getService(LabelProviderService.class)
					.getLabelProvider();
		} catch (final ServiceException e) {
			// Activator.log.error("LabelProviderServiceNotFound", e);
		}

//		org.eclipse.uml2.uml.Package pack;
		referenceSelector.setLabelProvider(serv);
		dialog = new CoreSelectorDialog(Display.getDefault()
				.getActiveShell(), referenceSelector, cores, pack,
				assignments,
				CoreSelectorDialog.COMPONENTS_TO_CORES,
				"Assign Software Components to Cores");

		dialog.setLabelProvider(serv);
		//dialog.setMessage("Messages.CreateDiagramImage_LifelineDialogMessage");
		//dialog.setTitle("Messages.CreateDiagramImage_LifelineDialogTitle");
		// dialog.setInitialElementSelections(insts2);

		if (dialog.open() == org.eclipse.jface.window.Window.OK) {
			Map<CHCore, LinkedHashSet<Object>> result = dialog
					.getResult();
			if (result != null)
				return result;
		}
		return null;
	}

	@Override
	public void execute() throws ModelError {
		queryContent(umlModel);
		printContent();

		int howMany = hwSystemsList.size();

		InstanceSpecification theSystem = null;
		if (howMany > 1) {
			theSystem = openSystemSelector(umlModel, hwSystemsList);
		}
		else {
			theSystem = hwSystemsList.get(0);
		}
		if (theSystem!=null) {
			Package pack = QueryUtils.getOwnerCHGaResourcePlatformPackage(umlModel, theSystem);

			EList<InstanceSpecification> processorList = processorsMap.get(pack);

			EList<CHCore> cores =  new BasicEList<CHCore>();
			if (processorList!=null) {						
				for (InstanceSpecification proc : processorList) {
					EList<CHCore> coreList = coresMap.get(proc);
					for (CHCore core : coreList) {
						cores.add(core);
					}
				}
			}

			result = openWizard(components, pack, cores, assignments);
			if (result != null) {
				updateModel();
			}
		}
	}

	private void printContent() {
		System.out.println("Components:");
		for (InstanceSpecification component : components) {
			System.out.println(component.getQualifiedName());
		}
		
		Set<Package> packs = processorsMap.keySet();
		for (Package pack: packs) {
			System.out.println("Package: "+pack.getName());
			EList<InstanceSpecification> procList = processorsMap.get(pack);
			for (InstanceSpecification theProc : procList) {
				System.out.println("Processor: "+theProc.getName());				 
				EList<CHCore> coreList = coresMap.get(theProc);
				for (CHCore theCore : coreList) {
					System.out.println("Core: "+theCore.getName());
				}
			}
		}
	}

	private void updateModel() {
		TransactionalEditingDomain editingDomain = TransactionUtil
				.getEditingDomain(umlModel);
		editingDomain.getCommandStack().execute(new Com(editingDomain));
	}

	private void queryContent(Model umlModel) throws ModelError {

		hwSystem = UMLUtils.getResourcePlatformComponent(umlModel, CHESSProfileManager.DEPLOYMENT_VIEW);
		
		// Look for Packages stereotyped as CHGAResourcePlatform in the Deployment View
		EList<Package> packages = QueryUtils.getResourcePlatformPackages(umlModel, CHESSProfileManager.DEPLOYMENT_VIEW);		

		if (packages.size()==0) {
			ModelError me = new ModelError("Error in model: no Package stereotyped as CHGAResourcePlatform in the Deployment View!");
			throw me;
		}
		hwSystemsList = new BasicEList<InstanceSpecification>();
 		for(Package pack : packages) {		
			EList<InstanceSpecification> processors = new BasicEList<InstanceSpecification>();
			for (CH_HwProcessor ch_processor : QueryUtils.getAllProcessorInstancesInPackage(pack)) {
				InstanceSpecification instSpec = ch_processor.getBase_InstanceSpecification();
				processors.add(instSpec);				
				EList<CHCore> theCores = QueryUtils.getCores(ch_processor);
				coresMap.put(instSpec, theCores);				
			}
			InstanceSpecification theSystem = UMLUtils.getRootInstanceInPackage(pack);
			hwSystemsList.add(theSystem);
			processorsMap.put(pack, processors);
		}
 		
 		if (hwSystemsList.isEmpty()) {
 			ModelError me = new ModelError("Error in model: no System in the Deployment View!");
			throw me;
 		}
		

//		processors = new BasicEList<InstanceSpecification>();
//		cores = new BasicEList<CHCore>();
//		for (CH_HwProcessor ch_processor : QueryUtils.getAllProcessorInstances(umlModel)) {
//			processors.add(ch_processor.getBase_InstanceSpecification());
//			cores.addAll(QueryUtils.getCores(ch_processor));
//		}
		components = UMLUtils.getAllComponentInstances(umlModel);
		assignments = UMLUtils.getComponent2CoreAssignments(umlModel, CHESSProfileManager.DEPLOYMENT_VIEW);
	}

	class Com extends RecordingCommand {

		public Com(TransactionalEditingDomain domain) {
			super(domain);
		}

		@Override
		protected void doExecute() {
			QueryUtils.deleteComponent2CoreAssociations(hwSystem);
			QueryUtils.buildInstance2CoreAssignments(hwSystem, result);
		}
	}
}
