/*******************************************************************************
 * Copyright (C) 2018 Fondazione Bruno Kessler.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *     Luca Cristoforetti - initial API and implementation
 ******************************************************************************/
package org.polarsys.chess.diagram.ui.services;

import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Class;
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.ResultElement;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.contracts.transformations.utils.AnalysisResultUtil;

import java.io.File;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import eu.fbk.eclipse.standardtools.diagram.ContainerDescriptor;
import eu.fbk.eclipse.standardtools.diagram.ContractFtaResultDescriptor;
import eu.fbk.eclipse.standardtools.diagram.DocumentGenerator;
import eu.fbk.eclipse.standardtools.diagram.FmeaResultDescriptor;
import eu.fbk.eclipse.standardtools.diagram.FtaResultDescriptor;
import eu.fbk.tools.adapter.xsap.ComputeFmeaTableResultBuilder;
import eu.fbk.tools.adapter.xsap.table.FmeaTable;
import eu.fbk.tools.adapter.xsap.table.FmeaTable.Row;

/**
 * This class creates and stores the result descriptors needed by the document generation.
 * @author cristofo
 *
 */
public class ResultsGeneratorService {
	private AnalysisResultUtil analysisResultUtil = AnalysisResultUtil.getInstance();
	private boolean showAnalysisResults;
	
	public void setParametersBeforeDocumentGeneration(boolean showAnalysisResults) {
		this.showAnalysisResults = showAnalysisResults;
	}
	
	/**
	 * Creates a FmeaResultDescriptor from the given ResultElement.
	 * @param resultElement the element containing the data
	 * @return the newly created descriptor
	 */
	private FmeaResultDescriptor createFmeaResultDescriptor(ResultElement resultElement) {
		FmeaResultDescriptor fmeaResultDescriptor = new FmeaResultDescriptor();
		
		fmeaResultDescriptor.conditions = resultElement.getConditions();
		fmeaResultDescriptor.rootClass = EntityUtil.getInstance().getName(resultElement.getRoot());
		
		// Read the result file and parse the table
		final String fmeaFileName = resultElement.getFile();
		final File fmeaFile = new File(fmeaFileName);
		final ComputeFmeaTableResultBuilder resultBuilder = new ComputeFmeaTableResultBuilder();
		final FmeaTable fmeaTable = resultBuilder.unmarshalResult(fmeaFile);
		if( fmeaTable == null || fmeaTable.getRow() == null || fmeaTable.getRow().isEmpty() ) {
			System.out.println("Internal error while unmarshalling the result. For more info see the console");
			return null;
		}

		// Parse the rows and store them
		final List<Row> rows = fmeaTable.getRow();
		for (Row row : rows) {
			final String[] line = new String[3];
			line[0] = row.getEntry();
			line[1] = row.getFailureMode();
			line[2] = row.getFailureEffects();
			fmeaResultDescriptor.lines.add(line);
		}
				
		return fmeaResultDescriptor;
	}
	
	/**
	 * Creates a FtaResultDescriptor from the given ResultElement.
	 * @param resultElement the element containing the data
	 * @return the newly created descriptor
	 */
	private FtaResultDescriptor createFtaResultDescriptor(ResultElement resultElement) {
		FtaResultDescriptor ftaResultDescriptor = new FtaResultDescriptor();
		
		ftaResultDescriptor.conditions = resultElement.getConditions();
		ftaResultDescriptor.rootClass = EntityUtil.getInstance().getName(resultElement.getRoot());
		
		//TODO: qui va messo il path dell'immagine.
		// ho solo il nome del file di partenza, devo trovare l'EMFTA corrispondente, ecc.
		// Devo esportare l'immagine qui...
		ftaResultDescriptor.url = "image.gif";
		
		return ftaResultDescriptor;
	}
	
	/**
	 * Creates a FtaResultDescriptor from the given ResultElement.
	 * @param resultElement the element containing the data
	 * @return the newly created descriptor
	 */
	private ContractFtaResultDescriptor createContractFtaResultDescriptor(ResultElement resultElement) {
		ContractFtaResultDescriptor contractFtaResultDescriptor = new ContractFtaResultDescriptor();
		
		contractFtaResultDescriptor.rootClass = EntityUtil.getInstance().getName(resultElement.getRoot());
		
		//TODO: qui va messo il path dell'immagine.
		// ho solo il nome del file di partenza, devo trovare l'EMFTA corrispondente, ecc.
		// Devo esportare l'immagine qui...
		contractFtaResultDescriptor.url = "image.gif";
		
		return contractFtaResultDescriptor;
	}
	
	/**
	 * Creates and adds the result descriptors to the given component. Only if the component is the 
	 * System component.
	 * @param selectedComponent the selected component
	 * @param activePackage the package containing the results
	 * @param documentGenerator the documentGenerator
	 */
	public void addResultsDescriptors(Class selectedComponent, Package activePackage, DocumentGenerator documentGenerator) {
		
		// Check if the selected component is the system component. If not, don't add the result section
		if (selectedComponent != EntityUtil.getInstance().getSystemComponent(activePackage)) {
			System.out.println("The selected element is not the System element, results section won't be created");
			return;
		}
		
		if (!showAnalysisResults) {
			return;
		}
		
		// Select the correct view where to find the results
		final Package dependabilityView = analysisResultUtil.getDependabilityViewFromPackage(activePackage);	
		if (dependabilityView == null) {
			return;
		}
		
		// Get the correct package containing the results
		final Package resultsPackage = dependabilityView.getNestedPackage(activePackage.getName());
		if (resultsPackage == null) {
			return;
		}
		
		final EList<NamedElement> members = resultsPackage.getOwnedMembers();
		for (NamedElement namedElement : members) {
			final ResultElement resultElement = analysisResultUtil.getResultElementFromUmlElement(namedElement);
			final ContainerDescriptor rootContainer = documentGenerator.getRootContainerDescriptor();

			if (resultElement != null) {
				final String resultType = resultElement.getType();

				if (resultType.equals(AnalysisResultUtil.FMEA_ANALYSIS)) {
					final FmeaResultDescriptor fmeaResultDescriptor = createFmeaResultDescriptor(resultElement);				
					rootContainer.fmeaResultDescriptors.add(fmeaResultDescriptor);
					
				} else if (resultType.equals(AnalysisResultUtil.FTA_ANALYSIS)) {
					final FtaResultDescriptor ftaResultDescriptor = createFtaResultDescriptor(resultElement);
					rootContainer.ftaResultDescriptors.add(ftaResultDescriptor);
				} else if (resultType.equals(AnalysisResultUtil.CONTRACT_BASED_FTA_ANALYSIS)) {
					final ContractFtaResultDescriptor contractFtaResultDescriptor = 
							createContractFtaResultDescriptor(resultElement);					
					rootContainer.contractFtaResultDescriptors.add(contractFtaResultDescriptor);
				}
				//TODO: implementare anche gli altri casi...
			}
		}
	}
}
