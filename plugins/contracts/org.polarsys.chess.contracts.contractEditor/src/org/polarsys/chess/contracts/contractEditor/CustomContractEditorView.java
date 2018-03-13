/*******************************************************************************
 * Copyright (C) 2017 Fondazione Bruno Kessler.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Alberto Debiasi - initial API and implementation
 ******************************************************************************/
package org.polarsys.chess.contracts.contractEditor;

import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.infra.widgets.editors.TreeSelectorDialog;
import org.eclipse.papyrus.uml.diagram.composite.part.Messages;
import org.eclipse.papyrus.uml.tools.providers.UMLContentProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;
import org.polarsys.chess.contracts.profile.chesscontract.util.ContractEntityUtil;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.service.gui.utils.SelectionUtil;

import eu.fbk.eclipse.standardtools.contractEditor.view.ContractEditorView;

/**
 * This class in not used. It creates a view that contains the contract editor.
 * In our case we use the CustomContractEditorTab that creates a new tab from
 * the property view in eclipse.
 */
public class CustomContractEditorView extends ContractEditorView {

	private ContractEntityUtil contractEntityUtil = ContractEntityUtil.getInstance();
	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private EntityUtil entityUtil = EntityUtil.getInstance();

	@Override
	public String[] getContractOwnerInputPortsNames(Object contract) {
		Element umlOwner = entityUtil.getOwner((Element) contract);
		//return entityUtil.getInputPortsNames(umlOwner);
		return null;
	}

	@Override
	public String[] getContractOwnerOutputPortsNames(Object contract) {
		Element umlOwner = entityUtil.getOwner((Element) contract);
		//return entityUtil.getOutputPortsNames(umlOwner);
		return null;
	}

	@Override
	public String[] getContractOwnerInputOutputPortsNames(Object contract) {
		Element umlOwner = entityUtil.getOwner((Element) contract);
		//return entityUtil.getInputOutputPortsNames(umlOwner);
		return null;
	}

	@Override
	public Object returnComponent(ISelection selection) {

		Object selectedUmlElement = selectionUtil.getUmlSelectedObject(selection);

		if (selectedUmlElement instanceof Property) {
			if (entityUtil.isComponentInstance((Property) selectedUmlElement)) {
				Element classType = entityUtil.getUMLType((Property) selectedUmlElement);
				if (!contractEntityUtil.isContract(classType)) {
					return classType;
				}
			}
		} else if (selectedUmlElement instanceof Class) {
			if (!contractEntityUtil.isContract((Class) selectedUmlElement)) {
				return selectedUmlElement;
			}
		}

		return null;
	}

	@Override
	public Object returnContract(ISelection selection) {

		Object selectedUmlElement = selectionUtil.getUmlSelectedObject(selection);

		if (selectedUmlElement instanceof Property) {
			if (contractEntityUtil.isContractProperty((Property) selectedUmlElement)) {
				return entityUtil.getUMLType((Property) selectedUmlElement);
			}

			if (entityUtil.isComponentInstance((Property) selectedUmlElement)) {
				Element classType = entityUtil.getUMLType((Property) selectedUmlElement);
				if (contractEntityUtil.isContract(classType)) {
					return classType;
				}
			}
		} else if (selectedUmlElement instanceof Class) {
			if (contractEntityUtil.isContract((Class) selectedUmlElement)) {
				return selectedUmlElement;
			}
		}

		return null;
	}

	@Override
	public String[] getContractListStr(Object component) {
		EList<String> contractNames = new BasicEList<String>();

		for (Property prop : ((Class) component).getAttributes()) {
			if (contractEntityUtil.isContractProperty(prop)) {
				if (prop.getType() == null) {
					contractNames.add(prop.getName() + " : <TYPE NOT DEFINED>");
				} else {
					contractNames.add(prop.getName() + " : " + prop.getType().getName());
				}
			}
		}

		String[] contractNamesArr = new String[contractNames.size()];
		return contractNames.toArray(contractNamesArr);
	}

	@Override
	public Object extractContractFromComponent(Object component, String contractName) {
		return contractEntityUtil.getUmlContract((Class) component, contractName);
	}

	@Override
	public String getComponentName(Object component) {
		return ((Class) component).getQualifiedName();
	}

	@Override
	public void createAssumption(Object contract) {
		contractEntityUtil.createAssumptionToUmlContract((Class) contract);
	}

	@Override
	public String browseAssumptionButtonPressed(Object contract) {
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(contract);
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				Constraint assumeConstraint = selectProperty(contract);
				if (assumeConstraint != null) {
					contractEntityUtil.assignUmlConstraintAssumptionToUmlContract(assumeConstraint, (Class) contract);
				}
			}
		});
		return contractEntityUtil.getAssumeStrFromUmlContract((Class) contract);

	}

	@Override
	public void createGuarantee(Object contract) {
		contractEntityUtil.createGuaranteeToUmlContract((Class) contract);
	}

	@Override
	public String browseGuaranteeButtonPressed(Object contract) {
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(contract);
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				Constraint guaranteeConstraint = selectProperty(contract);
				if (guaranteeConstraint != null) {
					contractEntityUtil.assignUmlConstraintGuaranteeToUmlContract(guaranteeConstraint, (Class) contract);
				}

			}
		});
		return contractEntityUtil.getGuaranteeStrFromUmlContract((Class) contract);
	}

	@Override
	public void guaranteeEditorchanged(Object contract, String textChanged) {
		contractEntityUtil.saveFormalProperty("Guarantee", textChanged, (Class) contract);
	}

	@Override
	public void assumptionEditorchanged(Object contract, String textChanged) {
		contractEntityUtil.saveFormalProperty("Assume", textChanged, (Class) contract);
	}

	private Constraint selectProperty(Object contract) {
		TreeSelectorDialog dialog = new TreeSelectorDialog(Display.getDefault().getActiveShell());

		UMLContentProvider provider = new UMLContentProvider(entityUtil.getToPackage((Class) contract),
				// contract.getOwner(),
				UMLPackage.eINSTANCE.getPackage_PackagedElement());

		dialog.setContentProvider(provider);
		dialog.setLabelProvider(new UMLLabelProvider());
		dialog.setMessage(Messages.UMLModelingAssistantProviderMessage);
		dialog.setTitle(Messages.UMLModelingAssistantProviderTitle);
		if (dialog.open() == org.eclipse.jface.window.Window.OK) {
			Object[] result = dialog.getResult();
			if (result != null && result.length > 0 && result[0] instanceof Constraint) {
				return (Constraint) result[0];
			}
		}
		return null;
	}

	public String getContractName(Object contract) {
		if (contract != null) {
			return ((Class) contract).getQualifiedName();
		}
		return null;
	}

	public String getAssumeStrFromContract(Object contract) {
		return (contractEntityUtil.getAssumeStrFromUmlContract((Class) contract));
	}

	public String getGuaranteeStrFromContract(Object contract) {
		return (contractEntityUtil.getGuaranteeStrFromUmlContract((Class) contract));
	}

	@Override
	public String[] getEnumValuesFromContractOwnerPorts(Object contract) {
		Class element = (Class) ((Class) contract).getOwner();
		//return entityUtil.getEnumValuesFromNonStaticComponentPorts(element);
		return null;
	}

	@Override
	public EList<?> getContractOwnerPorts(Object contract) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<?> getContractOwnerAttributes(Object contract) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isNumberAttribute(Object attribute) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isIntAttribute(Object attribute) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEventAttribute(Object attribute) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnumAttribute(Object attribute) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isBoolAttribute(Object attribute) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isContinuousAttribute(Object attribute) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isWordAttribute(Object attribute) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRealAttribute(Object attribute) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInOutPort(Object port) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isOutputPort(Object port) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInputPort(Object port) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getPortName(Object port) {
		// TODO Auto-generated method stub
		return null;
	}

}
