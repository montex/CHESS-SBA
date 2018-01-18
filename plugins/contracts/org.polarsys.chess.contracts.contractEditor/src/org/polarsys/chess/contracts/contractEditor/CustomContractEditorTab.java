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

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
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
import org.polarsys.chess.service.utils.SelectionUtil;

import eu.fbk.eclipse.standardtools.contractEditor.propertyTab.ContractEditorTab;

/**
 * This is the contract editor designed for the CHESS platform. It extends the
 * ContractEditorTab that is designed to be extended and contains standard
 * methods not related to specific technologies. The only rule is that it
 * requires Eclipse based platforms.
 *
 */
public class CustomContractEditorTab extends ContractEditorTab {

	private ContractEntityUtil contractEntityUtil = ContractEntityUtil.getInstance();
	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private EntityUtil entityUtil = EntityUtil.getInstance();

	@Override
	public Resource getResourceFromContract(Object contract) {
		return ((Class) contract).eResource();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.fbk.eclipse.standardtools.contractEditor.propertyTab.ContractEditorTab
	 * #getContractOwnerInputPorts(java.lang.Object)
	 */
	@Override
	public String[] getContractOwnerInputPorts(Object contract) {
		Element umlOwner = entityUtil.getOwner((Element) contract);
		return entityUtil.getInputPortsNames(umlOwner);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.fbk.eclipse.standardtools.contractEditor.propertyTab.ContractEditorTab
	 * #getContractOwnerOutputPorts(java.lang.Object)
	 */
	@Override
	public String[] getContractOwnerOutputPorts(Object contract) {
		Element umlOwner = entityUtil.getOwner((Element) contract);
		return entityUtil.getOutputPortsNames(umlOwner);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.fbk.eclipse.standardtools.contractEditor.propertyTab.ContractEditorTab
	 * #getContractOwnerInputOutputPorts(java.lang.Object)
	 */
	@Override
	public String[] getContractOwnerInputOutputPorts(Object contract) {
		Element umlOwner = entityUtil.getOwner((Element) contract);
		return entityUtil.getInputOutputPortsNames(umlOwner);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.fbk.eclipse.standardtools.contractEditor.propertyTab.ContractEditorTab
	 * #getContractOwnerAttributes(java.lang.Object)
	 */
	@Override
	public String[] getContractOwnerAttributes(Object contract) {
		Element element = ((Class) contract).getOwner();
		EList<String> attrArr = new BasicEList<String>();

		attrArr.addAll(entityUtil.getBooleanAttributesNamesExceptsPorts(element));
		String[] attributesStrArr = new String[attrArr.size()];
		return attrArr.toArray(attributesStrArr);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.fbk.eclipse.standardtools.contractEditor.propertyTab.ContractEditorTab
	 * #returnComponent(org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public Object returnComponent(ISelection selection) {

		Object selectedUmlElement = selectionUtil.getUmlSelectedObject(selection);

		if (selectedUmlElement instanceof Property) {
			if (entityUtil.isComponentInstance((Property) selectedUmlElement)) {
				Element umlClass = entityUtil.getUmlType((Property) selectedUmlElement);

				if (!contractEntityUtil.isContract(umlClass)) {
					return umlClass;
				}
			}
		} else if (selectedUmlElement instanceof Class) {
			if (!contractEntityUtil.isContract((Class) selectedUmlElement)) {
				return selectedUmlElement;
			}
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.fbk.eclipse.standardtools.contractEditor.propertyTab.ContractEditorTab
	 * #returnContract(org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public Object returnContract(ISelection selection) {

	
		Object selectedUmlElement = selectionUtil.getUmlSelectedObject(selection);

		if (selectedUmlElement instanceof Property) {
			if (contractEntityUtil.isContractProperty((Property) selectedUmlElement)) {
				return entityUtil.getUmlType((Property) selectedUmlElement);
			}

			if (entityUtil.isComponentInstance((Property) selectedUmlElement)) {
				Element classType = entityUtil.getUmlType((Property) selectedUmlElement);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.fbk.eclipse.standardtools.contractEditor.propertyTab.ContractEditorTab
	 * #getContractListStr(java.lang.Object)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.fbk.eclipse.standardtools.contractEditor.propertyTab.ContractEditorTab
	 * #extractContractFromComponent(java.lang.Object, java.lang.String)
	 */
	@Override
	public Object extractContractFromComponent(Object component, String contractName) {
		return contractEntityUtil.getUmlContract((Class) component, contractName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.fbk.eclipse.standardtools.contractEditor.propertyTab.ContractEditorTab
	 * #getComponentName(java.lang.Object)
	 */
	@Override
	public String getComponentName(Object component) {
		return ((Class) component).getQualifiedName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.fbk.eclipse.standardtools.contractEditor.propertyTab.ContractEditorTab
	 * #createAssumption(java.lang.Object)
	 */
	@Override
	public void createAssumption(Object contract) {
		contractEntityUtil.createAssumptionToUmlContract((Class) contract);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.fbk.eclipse.standardtools.contractEditor.propertyTab.ContractEditorTab
	 * #browseAssumptionButtonPressed(java.lang.Object)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.fbk.eclipse.standardtools.contractEditor.propertyTab.ContractEditorTab
	 * #createGuarantee(java.lang.Object)
	 */
	@Override
	public void createGuarantee(Object contract) {
		contractEntityUtil.createGuaranteeToUmlContract((Class) contract);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.fbk.eclipse.standardtools.contractEditor.propertyTab.ContractEditorTab
	 * #browseGuaranteeButtonPressed(java.lang.Object)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.fbk.eclipse.standardtools.contractEditor.propertyTab.ContractEditorTab
	 * #guaranteeEditorchanged(java.lang.Object, java.lang.String)
	 */
	@Override
	public void guaranteeEditorchanged(Object contract, String textChanged) {
		contractEntityUtil.saveFormalProperty("Guarantee", textChanged, (Class) contract);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.fbk.eclipse.standardtools.contractEditor.propertyTab.ContractEditorTab
	 * #assumptionEditorchanged(java.lang.Object, java.lang.String)
	 */
	@Override
	public void assumptionEditorchanged(Object contract, String textChanged) {
		contractEntityUtil.saveFormalProperty("Assume", textChanged, (Class) contract);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.fbk.eclipse.standardtools.contractEditor.propertyTab.ContractEditorTab
	 * #getContractName(java.lang.Object)
	 */
	public String getContractName(Object contract) {
		if (contract != null) {
			return ((Class) contract).getQualifiedName();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.fbk.eclipse.standardtools.contractEditor.propertyTab.ContractEditorTab
	 * #getAssumeStrFromContract(java.lang.Object)
	 */
	public String getAssumeStrFromContract(Object contract) {
		return (contractEntityUtil.getAssumeStrFromUmlContract((Class) contract));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.fbk.eclipse.standardtools.contractEditor.propertyTab.ContractEditorTab
	 * #getGuaranteeStrFromContract(java.lang.Object)
	 */
	public String getGuaranteeStrFromContract(Object contract) {
		return (contractEntityUtil.getGuaranteeStrFromUmlContract((Class) contract));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.fbk.eclipse.standardtools.contractEditor.propertyTab.ContractEditorTab
	 * #createContractProperty(java.lang.Object, java.lang.String)
	 */
	@Override
	public void createContractProperty(Object component, String propertyName) {
		contractEntityUtil.createContractPropertyToUmlComponent((Class) component, propertyName);
	}

	/**
	 * It allows the user to select a formal property to be used as assumption
	 * or guarantee of a contract.
	 * 
	 * @param contract
	 *            the contract
	 * @return the formal property selected
	 */
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

	@Override
	public String[] getEnumValuesFromContractOwnerPorts(Object contract) {
		Class element = (Class) ((Class) contract).getOwner();
		return entityUtil.getEnumValuesFromComponentPorts(element);		
	}

}
