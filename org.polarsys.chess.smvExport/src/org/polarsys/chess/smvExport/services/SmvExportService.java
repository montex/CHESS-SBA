/*******************************************************************************
 * Copyright (C) 2017 Fondazione Bruno Kessler.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *   Alberto Debiasi - initial API and implementation
 ******************************************************************************/
package org.polarsys.chess.smvExport.services;

import java.io.File;
import java.util.Collection;
import java.util.Set;


import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.StateMachine;

import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.smvExport.model.UMLStateMachineModel;

import eu.fbk.eclipse.standardtools.StateMachineTranslatorToSmv.services.SMVTranslatorService;
import eu.fbk.eclipse.standardtools.exceptions.NoComponentException;
import eu.fbk.eclipse.standardtools.exceptions.NoStateMachineException;
import eu.fbk.eclipse.standardtools.utils.DialogUtil;

public class SmvExportService {

private static SmvExportService instance;
	
	//private final Logger logger = Logger.getLogger(SmvExportService.class);
	private EntityUtil entityUtil = EntityUtil.getInstance();
	//private StateMachineModelToSmvModelTranslator smTranslator = StateMachineModelToSmvModelTranslator.getInstance(UMLStateMachineModel.getInstance()); 
	private SMVTranslatorService smvTranslatorService = SMVTranslatorService.getInstance(UMLStateMachineModel.getInstance());
	private DialogUtil dialogUtil = DialogUtil.getInstance();
	
	public static SmvExportService getInstance(){
		if(instance==null){
			instance = new SmvExportService();
		}
		return instance;
	}
	
	public void exportNominalStateMachines(Collection<StateMachine> stateMachines, String selectedDirectory,boolean showPopups,  IProgressMonitor monitor) throws Exception {
		
		for(StateMachine stateMachine : stateMachines){
			smvTranslatorService.exportStateMachineToSmvFile(stateMachine,  selectedDirectory,null, monitor);
		}
		
		if(showPopups){
			dialogUtil.showMessage_ExportNominalStateMachinesDone(selectedDirectory);
	}
		
	}
	
	public File exportSmv(Class umlSelectedComponent,boolean showPopups, String selectedDirectory, IProgressMonitor monitor)
			throws Exception {
		if (umlSelectedComponent == null) {
			throw new NoComponentException();
		}
	
		File smvFile = null;
		
		StateMachine stateMachine = getNominalStateMachine(umlSelectedComponent);
		if(stateMachine!=null){
		smvFile =  smvTranslatorService.exportStateMachineToSmvFile(stateMachine, selectedDirectory,getSmvFileName(umlSelectedComponent), monitor);	
		if(showPopups){
			dialogUtil.showMessage_ExportBehaviourDone(smvFile.getAbsolutePath());			
	}
		}else{			
			throw new NoStateMachineException();
			//dialogUtil.showMessage_NoStateMachine();
		}
		
		return smvFile;
		
	}
	
	private StateMachine getNominalStateMachine(Class umlSelectedComponent) {		
		Set<StateMachine> stateMachines = entityUtil.getNominalStateMachines(umlSelectedComponent);
		if((stateMachines!=null)&&(stateMachines.size()>0)){
		return stateMachines.iterator().next();
		}else return null;
	}

	private String getSmvFileName(Class umlSelectedComponent) {
		//	String systemQN = umlSelectedComponent.getQualifiedName();
		//	String systemName = systemQN.substring(systemQN.lastIndexOf("::") + 2);
		//	return umlSelectedComponent.getModel().getName() + "_" + systemName + ".smv";
			return umlSelectedComponent.getName();
		}
	
public Collection<StateMachine> getNominalStateMachines(Class umlSelectedComponent) {
		
	
		Set<StateMachine> stateMachines =  entityUtil.getNominalStateMachines(umlSelectedComponent,true);
		System.out.println("stateMachines");
		for (StateMachine sm : stateMachines) {
			System.out.println(sm);			
		}
		return stateMachines;
	
	}

public Collection<StateMachine> getNominalStateMachines() {
	
	UmlModel umlModel = UmlUtils.getUmlModel();
		Set<StateMachine> stateMachines =  entityUtil.getNominalStateMachines(umlModel);
		System.out.println("stateMachines");
		for (StateMachine sm : stateMachines) {
			System.out.println(sm);			
		}
		return stateMachines;
	
	}







	
}
