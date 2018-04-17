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
package org.polarsys.chess.contracts.profile.chesscontract.util;

import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;
import org.polarsys.chess.contracts.profile.chesscontract.Contract;
import org.polarsys.chess.contracts.profile.chesscontract.ContractProperty;
import org.polarsys.chess.contracts.profile.chesscontract.FormalProperty;
import org.polarsys.chess.core.util.uml.UMLUtils;
import org.polarsys.chess.contracts.profile.chesscontract.util.Constants;

/**
 * Util class that provides methods to manage contracts.
 *
 */
public class ContractEntityUtil {

	private static ContractEntityUtil contractEntityUtilInstance;
	private EntityUtil entityUtil = EntityUtil.getInstance();

	public static ContractEntityUtil getInstance() {
		if (contractEntityUtilInstance == null) {
			contractEntityUtilInstance = new ContractEntityUtil();
		}
		return contractEntityUtilInstance;
	}

	public String convertContractPropertyInStr(Property contractProperty) throws Exception {

		Property baseProperty = contractProperty; 
				//contractProperty.getBase_Property();

		String basePropertyName = baseProperty.getName();
		Class umlContract = (Class) baseProperty.getType();

		if (umlContract == null) {
			throw new Exception("The contract instance '" + basePropertyName + "' of '"
					+ ((Class) entityUtil.getOwner(baseProperty)).getName() + "' does not have a contract.");
		}

		String contractName = umlContract.getName();
		
		if(contractName.contains(" ")){
			throw new Exception("The name of the contract '" + contractName + "' of '"
					+ ((Class) entityUtil.getOwner(baseProperty)).getName() + "' has empty spaces. Please remove them from the name.");
		}
		
		String assume = getAssumeStrFromUmlContract(umlContract);
		String guarantee = getGuaranteeStrFromUmlContract(umlContract);

		String contractBody = "CONTRACT " + contractName + " assume : " + assume + " ; guarantee : " + guarantee + " ;";

		return contractBody;
	}

	public FormalProperty getAssumeFromUmlContract(Class umlContract) {
		Stereotype contractStereotype = UMLUtil.getAppliedStereotype(umlContract, Constants.CONTRACT, false);
		return (FormalProperty) umlContract.getValue(contractStereotype, "Assume");
	}

	public FormalProperty getGuaranteeFromUmlContract(Class umlContract) {
		Stereotype contractStereotype = UMLUtil.getAppliedStereotype(umlContract, Constants.CONTRACT, false);
		return (FormalProperty) umlContract.getValue(contractStereotype, "Guarantee");

	}

	public Contract getContract(Class umlContract) {
		Stereotype contractStereotype = UMLUtil.getAppliedStereotype(umlContract, Constants.CONTRACT, false);
		return (Contract) umlContract.getStereotypeApplication(contractStereotype);
	}

	public String getContractQualifiedName(Class contract) {
		if (contract != null) {
			return (contract).getQualifiedName();
		}
		return null;
	}

	public String getAssumeStrFromUmlContract(Class umlContract) {
		FormalProperty assumeFormalProperty = getAssumeFromUmlContract(umlContract);
		return entityUtil.getFormalPropertyStr(assumeFormalProperty);

	}

	public String getGuaranteeStrFromUmlContract(Class umlContract) {
		FormalProperty guaranteeFormalProperty = getGuaranteeFromUmlContract(umlContract);
		return entityUtil.getFormalPropertyStr(guaranteeFormalProperty);
	}

	public boolean isContract(Element umlElement) {
		return ((umlElement instanceof Class) && (UMLUtil.getAppliedStereotype(umlElement, Constants.CONTRACT, false) != null));
	}

	public void applyContractStereotype(Class umlElement) {
		UMLUtils.applyStereotype(umlElement, Constants.CONTRACT);
	}

	public void createAssumptionToUmlContract(final Class umlContract) {

		if (entityUtil.getOwner(umlContract) != null) {

			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(umlContract);
			domain.getCommandStack().execute(new RecordingCommand(domain) {

				@Override
				protected void doExecute() {
					Constraint assumeFormalProperty = createFormalPropertyInContractOwner("Assumption", umlContract);
					Contract contract = getContract(umlContract);
					contract.setAssume(entityUtil.getFormalProperty(assumeFormalProperty));
				}
			});

		}
	}

	private Constraint createFormalPropertyInContractOwner(String formalPropertyType, Class umlContract) {
		Element umlContractOwner = entityUtil.getOwner(umlContract);
		String propertyName = formalPropertyType + "_" + umlContract.getName();
		
		//FormalProperty assumeFormalProperty = createFormalProperty((Namespace) umlContractOwner, propertyName);
		Constraint assumeFormalProperty = createFormalProperty((Namespace) umlContractOwner, propertyName);
		
		LiteralString newLs = UMLFactory.eINSTANCE.createLiteralString();
		ValueSpecification vs = assumeFormalProperty.createSpecification("ConstraintSpec", null,
				newLs.eClass());
		((LiteralString) vs).setValue("TRUE");
		assumeFormalProperty.setSpecification(vs);

		return assumeFormalProperty;
	}
	
	//private FormalProperty createFormalProperty
	
	public void createGuaranteeToUmlContract(final Class umlContract) {

		if (entityUtil.getOwner(umlContract) != null) {

			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(umlContract);
			domain.getCommandStack().execute(new RecordingCommand(domain) {

				@Override
				protected void doExecute() {
					Constraint guaranteeFormalProperty = createFormalPropertyInContractOwner("Guarantee", umlContract);
					Contract contract = getContract(umlContract);
					contract.setGuarantee(entityUtil.getFormalProperty(guaranteeFormalProperty));
				}
			});
		}
	}

	public void createContractPropertyToUmlComponent(final Class umlComponent, final String propertyName) {

		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(umlComponent);
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				Property newUmlProperty = umlComponent.createOwnedAttribute(propertyName, null);
				UMLUtils.applyStereotype(newUmlProperty, Constants.CONTRACT_PROP);

			}
		});

	}

	public Class getUmlContract(Class umlComponent, String extContractPropertyName) {
		String[] splittedPropertyName = extContractPropertyName.split(":");
		String contractPropertyName = splittedPropertyName[0].trim();
		return (Class) getUmlContractPropertyOfUmlComponent(umlComponent, contractPropertyName).getType();

	}

	public Property getUmlContractPropertyOfUmlComponentFromContractPropertyType(Class umlComponent,
			String contractPropertyType) {

		EList<Property> attributes = umlComponent.getAttributes();
		Iterator<Property> itAttributes = attributes.iterator();
		Property umlContractProperty = null;
		boolean found = false;
		while (itAttributes.hasNext() && !found) {
			Property umlProperty = (Property) itAttributes.next();

			if (umlProperty.getType().getName().equals(contractPropertyType)
					&& umlProperty.getAppliedStereotype(Constants.CONTRACT_PROP) != null) {
				found = true;
				umlContractProperty = umlProperty;
			}
		}
		if (umlContractProperty == null) {
			return null;
		}
		return umlContractProperty;
	}

	public Property getUmlContractPropertyOfUmlComponent(Class umlComponent, String contractPropertyName) {

		EList<Property> attributes = umlComponent.getAttributes();
		Iterator<Property> itAttributes = attributes.iterator();
		Property umlContractProperty = null;
		boolean found = false;
		while (itAttributes.hasNext() && !found) {
			Property umlProperty = (Property) itAttributes.next();
			if (umlProperty.getName().equals(contractPropertyName)
					&& umlProperty.getAppliedStereotype(Constants.CONTRACT_PROP) != null) {
				found = true;
				umlContractProperty = umlProperty;
			}
		}
		if (umlContractProperty == null) {
			return null;
		}
		return umlContractProperty;
	}

	public void assignUmlConstraintAssumptionToUmlContract(Constraint umlAssumeConstraint, Class umlContract) {
		FormalProperty assumeFormalProperty = entityUtil.getFormalProperty(umlAssumeConstraint);
		Contract contract = getContract(umlContract);
		contract.setAssume(assumeFormalProperty);
	}

	public void assignUmlConstraintGuaranteeToUmlContract(Constraint umlGuaranteeConstraint, Class umlContract) {
		FormalProperty guaranteeFormalProperty = entityUtil.getFormalProperty(umlGuaranteeConstraint);
		Contract contract = getContract(umlContract);
		contract.setGuarantee(guaranteeFormalProperty);
	}

	public Constraint createFormalProperty(final Namespace formalPropertyOwner, 
			//Class umlContract,
			//String prefix_name) {
			String formalPropertyName) {

		//Contract contract = getContract(umlContract);
		//final String formalPropertyName = prefix_name + "_" + umlContract.getName();
		final String propertyName = formalPropertyName;
		
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(formalPropertyOwner);
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				Constraint umlNewConstraint = formalPropertyOwner.createOwnedRule(propertyName);
				UMLUtils.applyStereotype(umlNewConstraint, Constants.FORMAL_PROP);
			}
		});
		return formalPropertyOwner.getOwnedRule(propertyName);
		//Constraint umlContraint = formalPropertyOwner.getOwnedRule(propertyName);
		//return entityUtil.getFormalProperty(umlContraint);
	}
	
	public void saveFormalProperty(final String guarantee_or_assumption, final String formalPropertyText,
			final Class umlContract) {

		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(umlContract);
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				// rivedere questo codice
				Stereotype contractStereotype = UMLUtil.getAppliedStereotype(umlContract, Constants.CONTRACT, false);
				FormalProperty guarantee_or_assumptionFormalProperty = (FormalProperty) umlContract
						.getValue(contractStereotype, guarantee_or_assumption);

				if (guarantee_or_assumptionFormalProperty == null) {
					if (guarantee_or_assumption.compareTo("Guarantee") == 0) {
						createGuaranteeToUmlContract(umlContract);
					} else if (guarantee_or_assumption.compareTo("Assume") == 0) {
						createAssumptionToUmlContract(umlContract);
					}
					guarantee_or_assumptionFormalProperty = (FormalProperty) umlContract.getValue(contractStereotype,
							guarantee_or_assumption);
				}
				saveFormalProperty(guarantee_or_assumptionFormalProperty.getBase_Constraint(), formalPropertyText);
			}
		});
	}

	public void saveFormalProperty(final Constraint umlConstraint, final String formalPropertyText) {
		
		logger.debug("saveFormalProperty: "+formalPropertyText);
		
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(umlConstraint);
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {

				//Constraint umlConstraint = formalProperty.getBase_Constraint();
				if(umlConstraint.getSpecification() instanceof LiteralString){
					//logger.debug("saveFormalProperty LiteralString");
				LiteralString litString = (LiteralString) umlConstraint.getSpecification();
				litString.setValue(formalPropertyText);
				umlConstraint.setSpecification(litString);
				}else if(umlConstraint.getSpecification() instanceof OpaqueExpression){
					//logger.debug("saveFormalProperty OpaqueExpression");
					OpaqueExpression opaqueExpr = (OpaqueExpression) umlConstraint.getSpecification();	
					//opaqueExpr.getLanguages().
					setOpaqueExpressionBodyForLanguage(opaqueExpr, "OCRA", formalPropertyText);
					
				}
			}
		});
	}
	
	/*public void saveFormalProperty(final FormalProperty formalProperty, final String formalPropertyText) {
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(formalProperty);
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {

				Constraint umlConstraint = formalProperty.getBase_Constraint();
				LiteralString litString = (LiteralString) umlConstraint.getSpecification();
				litString.setValue(formalPropertyText);
				umlConstraint.setSpecification(litString);
			}
		});
	}*/

	public EList<ContractProperty> getContractProperties(Class umlComponent) {
		EList<ContractProperty> contractProperties = new BasicEList<ContractProperty>();
		for (Property umlProperty : ((Class) umlComponent).getAttributes()) {
			if (isContractProperty(umlProperty)) {
				contractProperties.add(getContractProperty(umlProperty));
			}
		}

		return contractProperties;
	}
	
	public EList<Property> getContractPropertiesAsUMLProperties(Class umlComponent) {
		EList<Property> contractProperties = new BasicEList<Property>();
		for (Property umlProperty : ((Class) umlComponent).getAttributes()) {
			if (isContractProperty(umlProperty)) {
				contractProperties.add(umlProperty);
			}
		}

		return contractProperties;
	}

	

	public boolean isContractProperty(Element umlProperty) {
		return ((umlProperty instanceof Property) && (UMLUtil.getAppliedStereotype(umlProperty, Constants.CONTRACT_PROP, false) != null));
	}

	

	public ContractProperty getContractProperty(Property umlContractProperty) {
		Stereotype contractPropertyStereotype = UMLUtil.getAppliedStereotype(umlContractProperty,
				Constants.CONTRACT_PROP, false);
		return (ContractProperty) umlContractProperty.getStereotypeApplication(contractPropertyStereotype);
	}

}
