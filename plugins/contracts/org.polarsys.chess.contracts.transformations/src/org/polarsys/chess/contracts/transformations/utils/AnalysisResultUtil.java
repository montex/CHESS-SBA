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
package org.polarsys.chess.contracts.transformations.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAnalysisContext;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.ResultElement;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.core.util.uml.UMLUtils;
import org.polarsys.chess.service.gui.utils.SelectionUtil;

import eu.fbk.eclipse.standardtools.utils.ui.utils.DialogUtil;
import eu.fbk.eclipse.standardtools.utils.ui.utils.DirectoryUtil;
import eu.fbk.eclipse.standardtools.utils.ui.utils.ErrorsDialogUtil;

/**
 * Utility class to store the results of an analysis. 
 * @author cristofo
 *
 */
public class AnalysisResultUtil {
	private static final String RESULT_ELEMENT = "CHESS::Dependability::DependableComponent::ResultElement";
	private static final String DEPENDABILITY_ANALYSIS_VIEW = "CHESS::Core::CHESSViews::DependabilityAnalysisView";
	private static final String RESULTS_FILE_PATH = File.separator+"VerificationResults";

	private static AnalysisResultUtil packageUtilInstance;
	private final EntityUtil entityUtil = EntityUtil.getInstance();
	private final ErrorsDialogUtil errorsDialogUtil = ErrorsDialogUtil.getInstance();
	private final DialogUtil dialogUtil = DialogUtil.getInstance();
		
	/**
	 * Creates the directory structure. 
	 */
	public AnalysisResultUtil() {
		createResultDir();
	}

	public static AnalysisResultUtil getInstance() {
		if (packageUtilInstance == null) {
			packageUtilInstance = new AnalysisResultUtil();
		}
		return packageUtilInstance;
	}

	/** 
	 * Converts an Iterator to a Collection
	 */
	private <T> Collection<T> iterator2Collection(final Iterator<T> iter) {
		ArrayList<T> list = new ArrayList<T>();
		for (; iter.hasNext();) {
			T item = iter.next();
			list.add(item);
		}
		return list;
	}
	
	/**
	 * Returns the requested view.
	 * @return
	 */
	public Package getDependabilityView() {
		final UmlModel umlModel = UmlUtils.getUmlModel();
		
		//FIXME: qui va indicata la mia view se presente, oppure creata...
		
		final TreeIterator<EObject> allElements = umlModel.getResource().getAllContents();
		if (allElements != null) {
			final Collection<Package> packages = EcoreUtil.getObjectsByType(iterator2Collection(allElements), 
					UMLPackage.eINSTANCE.getPackage());

			for (Package p : packages) {
				if(p.getAppliedStereotype(DEPENDABILITY_ANALYSIS_VIEW) != null) {
					return p;
				}
			}
		}
		errorsDialogUtil.showMessage_GenericError("Error: DependabilityView not found!");
		return null;
	}
	
	/**
	 * Applies the ResultElement stereotype to the given element.
	 * 
	 * @param element  the element
	 * @return  the stereotype applied
	 */
	public Stereotype applyResultElementStereotype(Component element) {
		return UMLUtils.applyStereotype(element, RESULT_ELEMENT);
	}
	
	/**
	 * Creates a ResultElement and store the given result.
	 * @param name the name of the analysis
	 * @param conditions the specified conditions
	 * @param filePath the path of the result file 
	 * @param rootComponent the root component of the architecture
	 * @return true if succeded
	 */
	public boolean storeResult(final String name, final String conditions, 
			final String filePath, final Class rootComponent, final GaAnalysisContext contextAnalysis) {
			
		// Select the correct view where to store the result
		final Package pkg = getDependabilityView();
		
		if (pkg == null) {
			return false;
		}

		// Start a transaction to modify the package content
		final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(pkg);
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {

				// FIXME: qui andrebbe fatta una struttura gerarchica come nella SystemView
				// al momento la fa flat
				
				// Get the correct package, or create it if needed
				final String componentPackageName = rootComponent.getNearestPackage().getName();
				Package dependabilityPackage = pkg.getNestedPackage(componentPackageName, 
						false, UMLPackage.eINSTANCE.getPackage(), true);
				
				// Check if the result is already present in the package
				final Element element = dependabilityPackage.getPackagedElement(name);			
				if (element != null && element instanceof Component && 
						(element.getAppliedStereotype(RESULT_ELEMENT) != null)) {
					
					// There is an element with the same name, check to see if it is possible to reuse it
					final Stereotype appliedStereotype = element.getAppliedStereotype(RESULT_ELEMENT);
					final ResultElement resultElement = 
							(ResultElement) element.getStereotypeApplication(appliedStereotype);
					
					if (resultElement.getName().equals(name) && resultElement.getRoot() == rootComponent) {
						if (resultElement.getConditions() != null && 
								resultElement.getConditions().equals(conditions)) {
							
							// Same analysis, can be updated with the new values
							resultElement.setDate(new Date().toString());
							resultElement.setValid(true);
							resultElement.setFile(filePath);
							return;
						}
					}
				}
					
				// Create a new result element
				final Component umlComponent = (Component) dependabilityPackage.createPackagedElement(
						name, UMLPackage.eINSTANCE.getComponent());
				final Stereotype appliedStereotype = applyResultElementStereotype(umlComponent);
				final ResultElement resultElement = 
						(ResultElement) umlComponent.getStereotypeApplication(appliedStereotype);

				resultElement.setName(name);
				resultElement.setDate(new Date().toString());
				resultElement.setConditions(conditions);
				resultElement.setValid(true);
				resultElement.setFile(filePath);
				resultElement.setRoot(rootComponent);
				resultElement.setContextAnalysis(contextAnalysis);
			}
		});
		return true;
	}
	
	/**
	 * Returns the selected package, if any.
	 * @param event the event
	 * @return the selected package
	 */
	private Package getPackageFromSelectedObject(ExecutionEvent event) {	
		final ISelection selection = 
				HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		final Object selectedUmlElement = SelectionUtil.getInstance().getUmlSelectedObject(selection);
		
		if (selectedUmlElement instanceof Package) {
			return (Package) selectedUmlElement;
		}
		return null;		
	}
	
	/**
	 * Gets the System component from the selected event, if any.
	 * @param event the event
	 * @return the System component
	 * @throws ExecutionException
	 */
	public Class getSystemComponentFromEvent(ExecutionEvent event) throws ExecutionException {		
		final Package pkg = getPackageFromSelectedObject(event);
		if (pkg == null || !entityUtil.isSystemViewPackage(pkg)) {
			final ExecutionException e = 
					new ExecutionException("Please select a package from <<SystemView>>");
			dialogUtil.showMessage_ExceptionError(e);
			throw e;
		}

		final Class systemComponent = EntityUtil.getInstance().getSystemComponent(pkg);		
		if (systemComponent == null) {
			final ExecutionException e = 
					new ExecutionException("The package does not have a <<System>> block or it has more than one. Please check.");
			dialogUtil.showMessage_ExceptionError(e);
			throw e;
		}
		return systemComponent;
	}
	
	/**
	 * Returns the directory where validation result files are stored.
	 * @return the string containing the directory
	 */
	public String getResultDir() {
		try {
			return DirectoryUtil.getInstance().getCurrentProjectDir() + RESULTS_FILE_PATH;
		} catch (Exception e) {
			dialogUtil.showMessage_ExceptionError(e);
		}
		return null;
	}
	
	/**
	 * Creates the directory where to store validation results.
	 * @return the string containing the directory
	 */
	private String createResultDir() {
		try {
			final String filePath = getResultDir();
			final File theFile = new File(filePath); 
	        theFile.mkdirs();
	        return filePath;
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
