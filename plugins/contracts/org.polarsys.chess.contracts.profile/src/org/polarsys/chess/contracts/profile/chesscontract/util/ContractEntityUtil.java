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

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;
import org.polarsys.chess.contracts.profile.chesscontract.Contract;
import org.polarsys.chess.contracts.profile.chesscontract.ContractProperty;
import org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement;
import org.polarsys.chess.contracts.profile.chesscontract.FormalProperty;
import org.polarsys.chess.core.util.uml.UMLUtils;

import eu.fbk.eclipse.standardtools.utils.core.utils.StringArrayUtil;

/**
 * Util class that provides methods to manage contracts.
 *
 */
public class ContractEntityUtil {

	public static final String CONTRACT =				"CHESSContract::Contract";
	public static final String CONTRACT_PROP =			"CHESSContract::ContractProperty";	
	public static final String CONTRACT_REFINEMENT =	"CHESSContract::ContractRefinement";
	
	
	
	private static ContractEntityUtil contractEntityUtilInstance;
	private EntityUtil entityUtil = EntityUtil.getInstance();
	
	private static final Logger logger = Logger.getLogger(ContractEntityUtil.class);

	public static ContractEntityUtil getInstance() {
		if (contractEntityUtilInstance == null) {
			contractEntityUtilInstance = new ContractEntityUtil();
		}
		return contractEntityUtilInstance;
	}

	/**
	 * Creates a ContractRefinement for the given owner component. The
	 * refinement should specify the component instance that contains the
	 * original contract property and the contract property itself
	 * 
	 * @param owner
	 *            the container of the refinement
	 * @param componentInstanceName
	 *            the component instance containing the contract property
	 * @param contractName
	 *            the type of the contract
	 * @return the created DataType
	 */
	public DataType getOrCreateContractRefinement(Class owner, String componentInstanceName, String[] componentInstanceRange, String componentInstanceIndex, String contractName,Stereotype contractRefinementStereotype) {

		logger.debug("\n\n\n Creating contract refinement for componentName = " + componentInstanceName + " of contract "
				+ contractName);
		
		logger.debug("\n\n\n");

		// The component instance containing the refining contract
		final Property refiningComponentInstance = entityUtil.getUmlComponentInstance(owner, componentInstanceName);

		// The component type where the contract property is defined
		final Class refiningComponent = (Class) refiningComponentInstance.getType();

		// The instance of the refining contract
		// final ContractProperty refiningContractProperty =
		// getContractPropertyFromContract(refiningComponent, contractName);
		final Property umlContractProperty = getPropertyOfUmlComponentWithContractPropertyType(refiningComponent, contractName);
		final ContractProperty refiningContractProperty = getContractProperty(umlContractProperty);

		String refinementNameOptSuffix = "";
		
		if(!StringArrayUtil.isUndefined(componentInstanceRange)){
			logger.debug("!isUndefined"+componentInstanceRange[0]+" - "+componentInstanceRange[1]);
			refinementNameOptSuffix=refinementNameOptSuffix.concat("."+componentInstanceRange[0]+"."+componentInstanceRange[1]);
		}else if(componentInstanceIndex!=null){
			logger.debug("componentInstanceIndex: "+componentInstanceIndex);
			refinementNameOptSuffix=refinementNameOptSuffix.concat("."+componentInstanceIndex);
		}
		
		// Compose the correct name of the contract refinement
				final String refinementName = componentInstanceName + "." + umlContractProperty.getName()+refinementNameOptSuffix;

				
		
		// Check if the refinement is already present
		final DataType umlRefinement = getExistingUmlContractRefinement(owner, refinementName);

		if (umlRefinement != null) {
			return umlRefinement;
		} else {
			logger.debug("\n\n Creating contract refinement " + refinementName + " for owner " + owner.getName());
			logger.debug("\n\n");

			return createContractRefinement(refinementName, refiningComponentInstance, componentInstanceRange,componentInstanceIndex, refiningContractProperty, owner,contractRefinementStereotype);

		}

	}

	/**
	 * Creates a Contract element.
	 * 
	 * @param owner
	 *            the Class that will contain the element
	 * @param contractName
	 *            the name of the new Contract
	 * @return the newly created Class
	 */
	public Class createContract(Class owner, String contractName, Stereotype contractStereotype) {

		logger.debug("\n\n\n Creating contract " + contractName + " for owner " + owner);
		logger.debug("\n\n\n");

		Class newUmlClass = UMLFactory.eINSTANCE.createClass();
		Classifier newClass = owner.createNestedClassifier(contractName, newUmlClass.eClass());
		newClass.applyStereotype(contractStereotype);

		logger.debug("\n\nCreated " + contractName + " Property\n\n");
		return (Class) newClass;
	}

	/**
	 * Creates and adds a Contract Property to the model.
	 * 
	 * @param owner
	 *            the parent Class
	 * @param elementName
	 *            the name of the property to create
	 * @param elementType
	 *            the type of the property to create
	 * @return the created Property
	 */
	public Property createContractProperty(Class owner, String elementName, Type elementType, Stereotype contractPropertyStereotype) {

		logger.debug("\n\n\n Creating contract property " + elementName + " for owner " + owner + " with type "
				+ elementType);
		logger.debug("\n\n\n");

		Property newUMLProperty = owner.createOwnedAttribute(elementName, elementType);
		newUMLProperty.applyStereotype(contractPropertyStereotype);

		logger.debug("\n\nCreated " + elementName + " Property\n\n");
		return newUMLProperty;
	}
	
	private DataType createContractRefinement(String refinementName, Property refiningComponentInstance,String[] refiningComponentInstanceRange,String refiningComponentInstanceIndex,
			ContractProperty refiningContractProperty, Class owner, Stereotype contractRefinementStereotype) {
		final DataType newUmlDataType = UMLFactory.eINSTANCE.createDataType();
		final Classifier newClass = owner.createNestedClassifier(refinementName, newUmlDataType.eClass());
		newClass.applyStereotype(contractRefinementStereotype);
		final ContractRefinement contractRefinement = (ContractRefinement) newClass
				.getStereotypeApplication(contractRefinementStereotype);

		// Set the correct links for the refinement
		contractRefinement.setInstance(refiningComponentInstance); // The
																	// component
																	// instance
																	// containing
																	// the
																	// definition
		contractRefinement.setContract(refiningContractProperty); // The
																	// contract
																	// property
																	// that
																	// refines
																	// the
																	// contract

		if(refiningComponentInstanceRange!=null){
		contractRefinement.setLowerIndexOfInstance(refiningComponentInstanceRange[0]);
		contractRefinement.setUpperIndexOfInstance(refiningComponentInstanceRange[1]);
		}else if(refiningComponentInstanceIndex !=null){
			contractRefinement.setLowerIndexOfInstance(refiningComponentInstanceIndex);
			contractRefinement.setUpperIndexOfInstance(refiningComponentInstanceIndex);	
		}
		
		
		logger.debug("\n\nCreated " + refinementName + " Contract Refinement\n\n");
		return (DataType) newClass;
	}

	
	public String convertContractPropertyInStr(Property contractProperty) throws Exception {

		Property baseProperty = contractProperty;
		// contractProperty.getBase_Property();

		String basePropertyName = baseProperty.getName();
		Class umlContract = (Class) baseProperty.getType();

		if (umlContract == null) {
			throw new Exception("The contract instance '" + basePropertyName + "' of '"
					+ ((Class) entityUtil.getOwner(baseProperty)).getName() + "' does not have a contract.");
		}

		String contractName = umlContract.getName();

		if (contractName.contains(" ")) {
			throw new Exception("The name of the contract '" + contractName + "' of '"
					+ ((Class) entityUtil.getOwner(baseProperty)).getName()
					+ "' has empty spaces. Please remove them from the name.");
		}

//		String assume = getAssumeStrFromUmlContract(umlContract);
//		String guarantee = getGuaranteeStrFromUmlContract(umlContract);

		String assume = getAssumeFormalPropertyStrFromUmlContract(umlContract);
		String guarantee = getGuaranteeFormalPropertyStrFromUmlContract(umlContract);

		
		String contractBody = "CONTRACT " + contractName + " assume : " + assume + " ; guarantee : " + guarantee + " ;";

		return contractBody;
	}

	public FormalProperty getAssumeFromUmlContract(Class umlContract) {
		Stereotype contractStereotype = UMLUtil.getAppliedStereotype(umlContract, CONTRACT, false);
		return (FormalProperty) umlContract.getValue(contractStereotype, "Assume");
	}

	public FormalProperty getGuaranteeFromUmlContract(Class umlContract) {
		Stereotype contractStereotype = UMLUtil.getAppliedStereotype(umlContract, CONTRACT, false);
		return (FormalProperty) umlContract.getValue(contractStereotype, "Guarantee");

	}

	public Contract getContract(Class umlContract) {
		Stereotype contractStereotype = UMLUtil.getAppliedStereotype(umlContract, CONTRACT, false);
		return (Contract) umlContract.getStereotypeApplication(contractStereotype);
	}

	public String getContractQualifiedName(Class contract) {
		if (contract != null) {
			return (contract).getQualifiedName();
		}
		return null;
	}

	/**
	 * Returns a string representing the expression of the assume of a contract.
	 * @param umlContract the UML contract 			
	 * @return the formal property as string
	 */
	public String getAssumeStrFromUmlContract(Class umlContract) {
		FormalProperty assumeFormalProperty = getAssumeFromUmlContract(umlContract);
		return entityUtil.getFormalPropertyStr(assumeFormalProperty);
	}

	/**
	 * Returns the assume formal property of a contract. If it is an assertion
	 * defined in the block, returns its name, otherwise returns the expression.
	 * @param umlContract the UML contract 			
	 * @return the formal property as string
	 */
	public String getAssumeFormalPropertyStrFromUmlContract(Class umlContract) {
		FormalProperty assumeFormalProperty = getAssumeFromUmlContract(umlContract);
		
		if (assumeFormalProperty == null) {
			return null;
		} else if (assumeFormalProperty.getBase_Constraint().getOwner() == umlContract) {
			return entityUtil.getFormalPropertyStr(assumeFormalProperty);
		} else {
			return assumeFormalProperty.getBase_Constraint().getName();
		}
	}
	
	/**
	 * Returns a string representing the expression of the guarantee of a contract.
	 * @param umlContract the UML contract 			
	 * @return the formal property as string
	 */
	public String getGuaranteeStrFromUmlContract(Class umlContract) {
		FormalProperty guaranteeFormalProperty = getGuaranteeFromUmlContract(umlContract);
		return entityUtil.getFormalPropertyStr(guaranteeFormalProperty);
	}

	/**
	 * Returns the guarantee formal property of a contract. If it is an assertion
	 * defined in the block, returns its name, otherwise returns the expression.
	 * @param umlContract the UML contract 			
	 * @return the formal property as string
	 */
	public String getGuaranteeFormalPropertyStrFromUmlContract(Class umlContract) {
		FormalProperty guaranteeFormalProperty = getGuaranteeFromUmlContract(umlContract);
		
		if (guaranteeFormalProperty == null) {
			return null;
		} else if (guaranteeFormalProperty.getBase_Constraint().getOwner() == umlContract) {
			return entityUtil.getFormalPropertyStr(guaranteeFormalProperty);
		} else {
			return guaranteeFormalProperty.getBase_Constraint().getName();
		}
	}
	
	public boolean isContract(Element umlElement) {
		return ((umlElement instanceof Class)
				&& (UMLUtil.getAppliedStereotype(umlElement, CONTRACT, false) != null));
	}

	public void applyContractStereotype(Class umlElement) {
		UMLUtils.applyStereotype(umlElement, CONTRACT);
	}

	public void createAssumptionToUmlContract(final Class umlContract) {

		if (entityUtil.getOwner(umlContract) != null) {
/*
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(umlContract);
			domain.getCommandStack().execute(new RecordingCommand(domain) {

				@Override
				protected void doExecute() {
		*/			Constraint assumeFormalProperty = createFormalPropertyInContract("Assumption", umlContract);
					Contract contract = getContract(umlContract);
					contract.setAssume(entityUtil.getFormalProperty(assumeFormalProperty));
		/*		}
			});
*/
		}
	}

	private Constraint createFormalPropertyInContract(String formalPropertyType, Class umlContract) {
		String propertyName = formalPropertyType + "_" + umlContract.getName();


		// FormalProperty assumeFormalProperty =
		// createFormalProperty((Namespace) umlContractOwner, propertyName);
		Constraint assumeFormalProperty = entityUtil.createFormalProperty((Namespace) umlContract, propertyName);


		LiteralString newLs = UMLFactory.eINSTANCE.createLiteralString();
		ValueSpecification vs = assumeFormalProperty.createSpecification("ConstraintSpec", null, newLs.eClass());
		((LiteralString) vs).setValue("TRUE");
		assumeFormalProperty.setSpecification(vs);

		return assumeFormalProperty;
	}

	// private FormalProperty createFormalProperty

	public void createGuaranteeToUmlContract(final Class umlContract) {

		if (entityUtil.getOwner(umlContract) != null) {

	/*		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(umlContract);
			domain.getCommandStack().execute(new RecordingCommand(domain) {

				@Override
				protected void doExecute() {*/
					Constraint guaranteeFormalProperty = createFormalPropertyInContract("Guarantee", umlContract);
					Contract contract = getContract(umlContract);
					contract.setGuarantee(entityUtil.getFormalProperty(guaranteeFormalProperty));
				/*}
			});*/
		}
	}

	public void createContractPropertyToUmlComponent(final Class umlComponent, final String propertyName) {

	/*	TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(umlComponent);
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {*/
				Property newUmlProperty = umlComponent.createOwnedAttribute(propertyName, null);
				UMLUtils.applyStereotype(newUmlProperty, CONTRACT_PROP);
/*
			}
		});
*/
	}

	public Class getUmlContract(Class umlComponent, String extContractPropertyName) {
		String[] splittedPropertyName = extContractPropertyName.split(":");
		String contractPropertyName = splittedPropertyName[0].trim();
		return (Class) getUmlContractPropertyOfUmlComponent(umlComponent, contractPropertyName).getType();

	}

	public Property getPropertyOfUmlComponentWithContractPropertyType(Class umlComponent,
			String contractPropertyType) {

		EList<Property> attributes = umlComponent.getAttributes();
		Iterator<Property> itAttributes = attributes.iterator();
		Property umlContractProperty = null;
		boolean found = false;
		while (itAttributes.hasNext() && !found) {
			Property umlProperty = (Property) itAttributes.next();

			if (umlProperty.getType().getName().equals(contractPropertyType)
					&& umlProperty.getAppliedStereotype(CONTRACT_PROP) != null) {
				found = true;
				umlContractProperty = umlProperty;
			}
		}
		if (umlContractProperty == null) {
			return null;
		}
		return umlContractProperty;
	}
	
	
	public ContractProperty getUmlContractPropertyOfUmlComponentFromContractPropertyType(Class umlComponent,
			String contractPropertyType) {
		Property umlProperty = getPropertyOfUmlComponentWithContractPropertyType(umlComponent, contractPropertyType);
	return getContractProperty(umlProperty);
	
	}

	public Property getUmlContractPropertyOfUmlComponent(Class umlComponent, String contractPropertyName) {

		EList<Property> attributes = umlComponent.getAttributes();
		Iterator<Property> itAttributes = attributes.iterator();
		Property umlContractProperty = null;
		boolean found = false;
		while (itAttributes.hasNext() && !found) {
			Property umlProperty = (Property) itAttributes.next();
			if (umlProperty.getName().equals(contractPropertyName)
					&& umlProperty.getAppliedStereotype(CONTRACT_PROP) != null) {
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
	
	/*public void saveFormalProperty(final String guarantee_or_assumption, final String formalPropertyText,
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
					if (guarantee_or_assumption.compareTo(CONTRACT_GUARANTEE) == 0) {
						createGuaranteeToUmlContract(umlContract);
					} else if (guarantee_or_assumption.compareTo(CONTRACT_ASSUME) == 0) {
						createAssumptionToUmlContract(umlContract);
					}
					guarantee_or_assumptionFormalProperty = (FormalProperty) umlContract.getValue(contractStereotype,
							guarantee_or_assumption);
				}
				entityUtil.setTextInUMLConstraint(guarantee_or_assumptionFormalProperty.getBase_Constraint(),
						formalPropertyText);
			}
		});
	}*/


	/** 
	 * Adds a contract refinement to a contract property.
	 * @param contractProperty the property to be enriched
	 * @param umlRefinement the refinement to add
	 */
	public void addContractRefinementToContractProperty(ContractProperty contractProperty, DataType umlRefinement) {
		final Stereotype stereotype = umlRefinement.getAppliedStereotype(CONTRACT_REFINEMENT);	
		final ContractRefinement contractRefinement = (ContractRefinement) umlRefinement.getStereotypeApplication(stereotype);
		
		// Add the new refinement to the list
		contractProperty.getRefinedBy().add(contractRefinement);
	}
	
	public void setTextToGuaranteeOrCreateGuarantee(final String formalPropertyText, final Class umlContract) {

	/*	TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(umlContract);
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {*/
				// rivedere questo codice
				FormalProperty guaranteeFormalProperty = getGuaranteeFromUmlContract(umlContract);

				if (guaranteeFormalProperty == null) {
					createGuaranteeToUmlContract(umlContract);
					guaranteeFormalProperty = getGuaranteeFromUmlContract(umlContract);
				}
				entityUtil.setTextInUMLConstraint(guaranteeFormalProperty.getBase_Constraint(), formalPropertyText, "OCRA");
			/*}
		});*/
	}

	public void setTextToAssumeOrCreateAssume(final String formalPropertyText, final Class umlContract) {

	/*	TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(umlContract.getModel());
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {*/
				// rivedere questo codice
				FormalProperty assumptionFormalProperty = getAssumeFromUmlContract(umlContract);

				if (assumptionFormalProperty == null) {
					createAssumptionToUmlContract(umlContract);
					assumptionFormalProperty = getAssumeFromUmlContract(umlContract);
				}
				entityUtil.setTextInUMLConstraint(assumptionFormalProperty.getBase_Constraint(), formalPropertyText, "OCRA");
	/*		}
		});*/
	}

	/*
	 * public void saveFormalProperty(final FormalProperty formalProperty, final
	 * String formalPropertyText) { TransactionalEditingDomain domain =
	 * TransactionUtil.getEditingDomain(formalProperty);
	 * domain.getCommandStack().execute(new RecordingCommand(domain) {
	 * 
	 * @Override protected void doExecute() {
	 * 
	 * Constraint umlConstraint = formalProperty.getBase_Constraint();
	 * if(umlConstraint.getSpecification() instanceof LiteralString){
	 * logger.debug("saveFormalProperty LiteralString"); LiteralString litString
	 * = (LiteralString) umlConstraint.getSpecification();
	 * litString.setValue(formalPropertyText);
	 * umlConstraint.setSpecification(litString); }else
	 * if(umlConstraint.getSpecification() instanceof OpaqueExpression){
	 * logger.debug("saveFormalProperty OpaqueExpression"); OpaqueExpression
	 * opaqueExpr = (OpaqueExpression) umlConstraint.getSpecification();
	 * //opaqueExpr.getLanguages().
	 * setOpaqueExpressionBodyForLanguage(opaqueExpr, "OCRA",
	 * formalPropertyText);
	 * 
	 * } } }); }
	 */

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
		return ((umlProperty instanceof Property)
				&& (UMLUtil.getAppliedStereotype(umlProperty, CONTRACT_PROP, false) != null));
	}

	public ContractProperty getContractProperty(Property umlContractProperty) {
		Stereotype contractPropertyStereotype = UMLUtil.getAppliedStereotype(umlContractProperty,
				CONTRACT_PROP, false);
		return (ContractProperty) umlContractProperty.getStereotypeApplication(contractPropertyStereotype);
	}

	

	

	
	/**
	 * Removes a contract property from the list.
	 * @param members the list of members
	 * @param qualifiedElement the qualified name of the contract property to remove
	 */
	public void removeContractProperty(EList<ContractProperty> members, String qualifiedElement) {
		for (ContractProperty element : members) {
			if (element.getBase_Property().getQualifiedName().equals(qualifiedElement)) {
				try {
//					((Element) element.getBase_Property()).destroy();	//TODO: investigate this line!
					entityUtil.deleteElementInTheModel(element.getBase_Property());
				} catch (Exception e) {
					e.printStackTrace();
				}
				members.remove(element);
				break;
			}
		}
	}
	

	/**
	 * Removes a contract refinement from the list.
	 * @param members the list of members
	 * @param qualifiedElement the qualified name of the contract refinement to remove
	 */
	public void removeContractRefinement(EList<DataType> members, String qualifiedElement) {
		entityUtil.removeNamedElement(members, qualifiedElement);
	}


	
	
	
	/**
	 *  Returns the contract refinement associated to the component.
	 *  @param owner of the contract refinement
	 *  @param refinementName the name of the contract refinement
	 *  @return the UML contract refinement
	 */
	public DataType getExistingUmlContractRefinement(Class owner, String refinementName) {
		return (DataType) owner.getNestedClassifier(refinementName);
	}

	

}
