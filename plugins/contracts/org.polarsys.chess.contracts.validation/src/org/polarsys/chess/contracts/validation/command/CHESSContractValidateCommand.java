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

package org.polarsys.chess.contracts.validation.command;


import org.eclipse.emf.ecore.EObject;
import org.polarsys.chess.validator.command.ChessGenericValidateCommand;

public class CHESSContractValidateCommand extends ChessGenericValidateCommand  {

	public CHESSContractValidateCommand(String label, String pluginId,
			EObject selectedElement) {
		super(label, pluginId, selectedElement);
	}
	
//	@Override
//	protected Diagnostic validate(IProgressMonitor progressMonitor, EObject validateElement)
//	{
//		//System.err.println("This is the ChessGenericValidationCommand Override for validate(IProgressMonitor,EObject) from AbstractValidateCommand");
//		
//		int count = 0;
//		for (Iterator<?> i = validateElement.eAllContents(); i.hasNext(); i.next()) {
//			++count;
//		}
//
//		progressMonitor.beginTask("", count);
//
//		// validate only error severity and worse
//		IConstraintFilter constraintFilter = new IConstraintFilter() {
//			@Override
//			public boolean accept(IConstraintDescriptor constraint, EObject target) {
//				// Check only constraints defined in the plugin using this generic command
//				//System.err.println("Evaluating constraint " + constraint.getName()+ " provided by " + constraint.getPluginId());
//				return pluginIds.contains(constraint.getPluginId());
//			}
//		};
//	
//		IConstraintDescriptor foreverConstraint = ConstraintRegistry.getInstance().getDescriptor("org.intecs.forever.validation.constraints.ForeverConstraints.ID");
//		
//		if (foreverConstraint != null)
//			foreverConstraint.setEnabled(true);
//		
//		AdapterFactory adapterFactory = 
//			domain instanceof AdapterFactoryEditingDomain ? ((AdapterFactoryEditingDomain)domain).getAdapterFactory() : null;
//		ChessGenericDiagnostician diagnostician = createChessGenericDiagnostician(adapterFactory, progressMonitor, constraintFilter);
//	    
//		BasicDiagnostic diagnostic = diagnostician.createDefaultDiagnostic(validateElement);
//		Map<Object, Object> context = diagnostician.createDefaultContext();
//		
//		progressMonitor.setTaskName(EMFEditUIPlugin.INSTANCE.getString("_UI_Validating_message", new Object [] {diagnostician.getObjectLabel(validateElement)}));
//		diagnostician.validate(validateElement, diagnostic, context);
//
//		
//		/*if (foreverConstraint != null)
//			foreverConstraint.setEnabled(false);*/
//		return diagnostic;
//	}
}
