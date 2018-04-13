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
package org.polarsys.chess.OSSImporter.actions;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.FunctionBehavior;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Constraint;
import org.polarsys.chess.OSSImporter.exceptions.ImportException;
import org.polarsys.chess.OSSImporter.utils.CHESSElementsUtil;
import org.polarsys.chess.OSSImporter.utils.TypesUtil;
import org.polarsys.chess.contracts.profile.chesscontract.ContractProperty;
import org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement;
import org.polarsys.chess.contracts.profile.chesscontract.FormalProperty;
import org.polarsys.chess.contracts.profile.chesscontract.util.ContractEntityUtil;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.service.core.model.ChessSystemModel;

import com.google.common.collect.Maps;
import eu.fbk.eclipse.standardtools.ModelTranslatorToOcra.core.services.OSSModelFactory;
import eu.fbk.tools.editor.basetype.baseType.*;
import eu.fbk.tools.editor.contract.contract.Assumption;
import eu.fbk.tools.editor.contract.contract.Contract;
import eu.fbk.tools.editor.contract.contract.Guarantee;
import eu.fbk.tools.editor.contract.expression.expression.*;
import eu.fbk.tools.editor.oss.oss.SystemComponent;
import eu.fbk.tools.editor.oss.oss.Variable;
import eu.fbk.tools.editor.oss.oss.AbstractComponent;
import eu.fbk.tools.editor.oss.oss.Component;
import eu.fbk.tools.editor.oss.oss.Connection;
import eu.fbk.tools.editor.oss.oss.ContractId;
import eu.fbk.tools.editor.oss.oss.InputPort;
import eu.fbk.tools.editor.oss.oss.Interface;
import eu.fbk.tools.editor.oss.oss.InterfaceInstance;
import eu.fbk.tools.editor.oss.oss.OSS;
import eu.fbk.tools.editor.oss.oss.OutputPort;
import eu.fbk.tools.editor.oss.oss.Port;
import eu.fbk.tools.editor.oss.oss.RefinedBy;
import eu.fbk.tools.editor.oss.oss.Operation;
import eu.fbk.tools.editor.oss.oss.Parameter;
import eu.fbk.tools.editor.oss.oss.Refinement;
import eu.fbk.tools.editor.oss.oss.RefinementInstance;

import org.eclipse.papyrus.sysml.portandflows.FlowDirection;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;

/**
 * This class takes as input a file in OCRA format and creates the equivalent CHESS model.
 * @author cristofo
 *
 */
public class ImportOSSFileAction {

	// The instance of this class
	private static ImportOSSFileAction classInstance;

	private final ChessSystemModel chessSystemModel = ChessSystemModel.getInstance();
	private final ContractEntityUtil contractEntityUtil = ContractEntityUtil.getInstance();
	private final EntityUtil entityUtil = EntityUtil.getInstance();
	private final TypesUtil typeUtil = TypesUtil.getInstance();
	private final CHESSElementsUtil chessElementsUtil = CHESSElementsUtil.getInstance();
	
	// Will contain elements being added to the model, big enough
	private final EList<Element> addedElements = new BasicEList<>(2000);	 
	
	private Package sysView = null;

	// Map the name of the component with the Component object
	private Map<String, Class> dslTypeToComponent;

	// A possible exception that could happen during parsing
	private ImportException importException;

	// Logger for messages
	private static final Logger logger = Logger.getLogger(ImportOSSFileAction.class);
	
	// Error messages during parsing
	private StringBuffer importErrors;
	
	/**
	 * Gets an instance of the class if already present, or a new one if not.
	 * @return the instance of this class
	 */
	public static ImportOSSFileAction getInstance() {
		if (classInstance == null) {
			classInstance = new ImportOSSFileAction();
		}
		return classInstance;
	}
		
	/**
	 * Returns the list of contract refinements associated to a Class
	 * @param owner the owner Class
	 * @return the list of contract refinements
	 */
	private EList<DataType> getContractRefinementsOfClass(Class owner) {
		EList<DataType> contractRefinements = new BasicEList<DataType>();
		
		for (Classifier classifier : owner.getNestedClassifiers()) {
			if (classifier instanceof DataType) {
				contractRefinements.add((DataType) classifier);
			}
		}
		return contractRefinements;
	}
	
	/**
	 * Creates an end to the given connector.
	 * @param owner the owner element
	 * @param connector the owner Connector
	 * @param sourceOwner the name of component instance owning the port
	 * @param sourcePort the name of the port to be connected
	 * @return the Connector End
	 */
	private ConnectorEnd createConnectorEnd(Class owner, Connector connector, String sourceOwner, String sourcePort) {		
		ConnectableElement role;
		Property partWithPort;
		
		if (sourceOwner == null) {

			// I'm the owner of the port
			role = owner.getOwnedPort(sourcePort, null);
			partWithPort = null;
		} else {

			// Retrieve the component instance containing the port and set it
			partWithPort = entityUtil.getUMLComponentInstance(owner, sourceOwner);

			// Now I have to get the port object from the owning element
			// Get the component type
			final String typeName = partWithPort.getType().getName();

			// Get the component object containing the definition of the port
			final Class portOwner = dslTypeToComponent.get(typeName);

			// Get the port and set it
			role = portOwner.getOwnedPort(sourcePort, null);
		}

		return chessElementsUtil.createConnectorEnd(connector, partWithPort, role);
	}
	
	/** 
	 * Parses the Refinements of the component.
	 * @param dslParentComponent the AST Component owning the refinement
	 * @param dslComponentRefinement the Refinement element to be parsed
	 * @throws ImportException 
	 */
	private void parseRefinements(AbstractComponent dslParentComponent, Refinement dslComponentRefinement) throws ImportException {
		
		// Get all the RefinementInstances of the Refinement
		final EList<RefinementInstance> dslRefInstances = dslComponentRefinement.getRefinements(); 

		final Class owner = dslTypeToComponent.get(dslParentComponent.getType());
		
		// Get all the existing component instances of the element
		EList<Property> existingComponentInstances = (EList<Property>) chessSystemModel.getSubComponentsInstances(owner);

		// Prepare the map to mark existing component instances 
		HashMap<String, Boolean> mapComponentInstances = Maps.newHashMapWithExpectedSize(existingComponentInstances.size());
		for (Property componentInstance : existingComponentInstances) {
			mapComponentInstances.put(componentInstance.getQualifiedName(), null);
		}
		
		// Get all the existing connectors of the element
		// Doing a copy because the list will otherwise increase as soon as a connector is created
		EList<Connector> existingConnectors = new BasicEList<Connector>(owner.getOwnedConnectors());
//		EList<Connector> connectors = owner.getOwnedConnectors();
		
		// Prepare the map to mark existing connectors 
		HashMap<String, Boolean> mapConnectors = Maps.newHashMapWithExpectedSize(existingConnectors.size());
		for (Connector connector : existingConnectors) {
			mapConnectors.put(connector.getQualifiedName(), null);
		}
		
		// Get all the existing delegation contraints of the element
		EList<Constraint> existingDelegationConstraints = contractEntityUtil.getConstraintsProperties(owner);
		
		// Prepare the map to mark existing delegation contraints 
		HashMap<String, Boolean> mapDelegationContraints = Maps.newHashMapWithExpectedSize(existingDelegationConstraints.size());
		for (Constraint delegationConstraint : existingDelegationConstraints) {
			mapDelegationContraints.put(delegationConstraint.getQualifiedName(), null);
		}
		
		// Get all the contract refinements of the element
		EList<DataType> existingContractRefinements = getContractRefinementsOfClass(owner);
		
		// Prepare the map to mark existing contract refinements
		HashMap<String, Boolean> mapContractRefinements = Maps.newHashMapWithExpectedSize(existingContractRefinements.size());
		for (Classifier contractRefinement : existingContractRefinements) {
			mapContractRefinements.put(contractRefinement.getQualifiedName(), null);
		}
		
		// If some RefinementInstances are present, loop on them
		if ((dslRefInstances != null) && !dslRefInstances.isEmpty()) {
			for (RefinementInstance dslRefInstance : dslRefInstances) {

				// Process the different types of refinements
				if (dslRefInstance != null && dslRefInstance.getSubcomponent() != null) {

					// SUB processing
					final String subName = dslRefInstance.getSubcomponent().getName();					
					final String subType = dslRefInstance.getSubcomponent().getType();

					logger.debug("\tsubcomponent name = " + subName);
					logger.debug("\tsubcomponent type = " + subType);

					// Retrieve the component instance from the owner, if any
					final Property componentInstance = entityUtil.getSubComponentInstance(owner, subName);

					if (componentInstance == null) {
						logger.debug("componentInstance not found, creating one");
						
						// I should create an Association between the elements and not a Component Instance!
						addedElements.add(chessElementsUtil.createAssociation(owner, subName, (Type) dslTypeToComponent.get(subType))); 
					}  else {
						logger.debug("componentInstance already present");

						// The component instance is already present, update its type if needed
						if (!componentInstance.getType().getName().equals(subType)) {
							componentInstance.setType(dslTypeToComponent.get(subType));
							
							// Add the association to the list of changes, it needs to be redrawn
							addedElements.add(componentInstance.getAssociation());
						}
						
						// Set the flag to signal the componentInstance is still used
						mapComponentInstances.put(componentInstance.getQualifiedName(), Boolean.TRUE);						
					}
				} else if (dslRefInstance != null && dslRefInstance.getConnection() != null) {
					
					// CONNECTION processing
					final Connection connection = dslRefInstance.getConnection();
					final VariableId variable = connection.getVariable();
					final Expression constraint = connection.getConstraint();
					Connector connector = null;
										
					if ((connector = chessElementsUtil.getExistingConnector(existingConnectors, variable, constraint)) != null) {
						logger.debug("connector already present");
						
						// Set the flag to signal the connector is still used
						mapConnectors.put(connector.getQualifiedName(), Boolean.TRUE);
						continue;
					} else if (constraint instanceof Expression && !(constraint instanceof PortId)) {
						
						// It could be a delegation constraint, check it
						Constraint delegationConstraint = null;

						if ((delegationConstraint = chessElementsUtil.getExistingDelegationConstraint(existingDelegationConstraints, variable, constraint)) != null) {
							logger.debug("delegation constraint already present");

							// Set the flag to signal the delegation constraint is still used
							mapDelegationContraints.put(delegationConstraint.getQualifiedName(), Boolean.TRUE);
							continue;
						} else {
							logger.debug("delegation constraint is not present");

							// Create a delegation constraint, can be a LogicalExpression, IntegerLiteral, AddSubExpression, ...
							addedElements.add(chessElementsUtil.createDelegationConstraint(owner, variable, constraint));
							continue;
						}						
					}
					
					logger.debug("connector is not present");

					// Create the source end
					if (constraint instanceof PortId) {
						
						// Create a connector, but only after I'm sure it isn't a delegation constraint
						connector = chessElementsUtil.createConnector(owner);
						
						String portOwner = null;
						
						// Get the component name, should be at max one
						final EList<String> componentNames = ((PortId) constraint).getComponentNames();
						if (componentNames != null && componentNames.size() != 0) {
							portOwner = componentNames.get(0);
						}

						final String portName = ((PortId) constraint).getName();
						logger.debug("Creating source end " + portOwner + ":" + portName);
						createConnectorEnd(owner, connector, portOwner, portName);
					}

					// Create the target end
					if (variable instanceof PortId) {						
						String portOwner = null;
						
						// Get the component name, should be at max one
						final EList<String> componentNames = ((PortId) variable).getComponentNames();
						if (componentNames != null && componentNames.size() != 0) {
							portOwner = componentNames.get(0);
						}
						
						final String portName = ((PortId) variable).getName();					
						logger.debug("Creating target end " + portOwner + ":" + portName);
						createConnectorEnd(owner, connector, portOwner, portName);
					} else if (variable instanceof ParameterId) {
						
						// ParameterId not handled
						final String message = "Found ParameterId, don't know how to handle it!";
						logger.error("Import Error: " + message);
						importErrors.append(message + "\n");
					}
					
					// At last, add the connector to the owner
					chessElementsUtil.addConnector(owner, connector);
					
					// Store the new connector
					addedElements.add(connector);

				} else if (dslRefInstance != null && dslRefInstance.getRefinedby() != null) {
					
					// REFINEDBY processing
					final RefinedBy refinement = dslRefInstance.getRefinedby();
					final String refinedContract = refinement.getName();
					
					logger.debug("\n\n\nContract name = " + refinedContract + " from " + owner.getName());

//					final ContractProperty contractProperty = getContractPropertyFromContract(owner, refinedContract);
					
					// Get the instance of the contract, using a library function
					final Property umlProperty = contractEntityUtil.getUmlContractPropertyOfUmlComponentFromContractPropertyType(owner, refinedContract);
					final ContractProperty contractProperty = contractEntityUtil.getContractProperty(umlProperty);

					// Get the refinements linked to that contract property
					final EList<ContractRefinement> contractPropertyRefinements = chessSystemModel.getContractRefinements(contractProperty);
					
					// Loop on all the refinements to see if they already exist
					final EList<ContractId> contractIds = refinement.getContractIds();					
					for (ContractId contractId : contractIds) {
						
						// The component instance containing the refining contract
						final Property refiningComponentInstance = entityUtil.getUMLComponentInstance(owner, contractId.getComponentName());

						// The component type where the contract property is defined
						final Class refiningComponent = (Class) refiningComponentInstance.getType();
						
						// The refining contract property
						final Property refiningProperty = contractEntityUtil.getUmlContractPropertyOfUmlComponentFromContractPropertyType(refiningComponent, contractId.getName()); 
												
						// Compose the name that the contract refinement should have
						final String refinementName = contractId.getComponentName() + "." + refiningProperty.getName();
												
						// Check to see if the refinement is already linked to the contract property
						boolean alreadyLinked = false;
						for (ContractRefinement contractRefinement : contractPropertyRefinements) {
							if (contractRefinement.getBase_DataType().getName().equals(refinementName)) {
								logger.debug("refinement already defined for the contract");
								
								// Set the flag to signal the contract refinement is still used
								mapContractRefinements.put(contractRefinement.getBase_DataType().getQualifiedName(), Boolean.TRUE);
								alreadyLinked = true;
								break;
							}
						}
						
						if (alreadyLinked) {
							continue;	// Go to the next refinement
						} else {						
							logger.debug("refinement not present");

							// Create a new refinement and add it to the contract property
							final DataType umlRefinement = chessElementsUtil.createContractRefinement(owner, contractId.getComponentName(), contractId.getName());
							chessElementsUtil.addContractRefinementToContractProperty(contractProperty, umlRefinement);

							// Store the new refinement
							addedElements.add(umlRefinement);
						}
					}
					
				} else if (dslRefInstance != null && dslRefInstance.getFormula() != null) {
					
					// CONSTRAINT processing
					final String message = "Found a CONSTRAINT tag, don't know how to handle it!";
					logger.error("Import Error: " + message);
					importErrors.append(message + "\n");
				} else if (dslRefInstance != null && dslRefInstance.getProp() != null) {

					// PROP processing
					final String message = "Found a PROP tag, don't know how to handle it!";
					logger.error("Import Error: " + message);
					importErrors.append(message + "\n");
				}
			}
		}
		
		// Component instances cleanup time, associations will be removed automatically
		for (String qualifiedElement : mapComponentInstances.keySet()) {
			if (mapComponentInstances.get(qualifiedElement) == null) {
//				System.out.println("component instance " + qualifiedElement + " should be removed");
				chessElementsUtil.removeProperty(existingComponentInstances, qualifiedElement);
			}
		}
		
		// Connectors cleanup time
		for (String qualifiedElement : mapConnectors.keySet()) {
			if (mapConnectors.get(qualifiedElement) == null) {
//				System.out.println("connector " + qualifiedElement + " should be removed");
				chessElementsUtil.removeConnector(existingConnectors, qualifiedElement);
			}
		}
		
		// Delegation constraints cleanup time
		for (String qualifiedElement : mapDelegationContraints.keySet()) {
			if (mapDelegationContraints.get(qualifiedElement) == null) {
//				System.out.println("delegation constraint " + qualifiedElement + " should be removed");
				chessElementsUtil.removeDelegationConstraint(existingDelegationConstraints, qualifiedElement);
			}
		}

		// Contract refinements cleanup time
		for (String qualifiedElement : mapContractRefinements.keySet()) {
			if (mapContractRefinements.get(qualifiedElement) == null) {
//				System.out.println("contract refinement " + qualifiedElement + " should be removed");
				chessElementsUtil.removeContractRefinement(existingContractRefinements, qualifiedElement);
			}
		}
	}
	
	/** 
	 * Parses the Interfaces of the component.
	 * @param dslParentComponent the AST Component owning the refinement
	 * @param dslComponentInterface the Interface element to be parsed
	 * @throws ImportException 
	 */
	@SuppressWarnings("unchecked")
	private void parseInterfaces(AbstractComponent dslParentComponent, Interface dslComponentInterface) throws ImportException {

		// Get all the InterfaceInstances of the Interface
		final EList<InterfaceInstance> dslIntInstances = dslComponentInterface.getInterfaces();

		final Class owner = dslTypeToComponent.get(dslParentComponent.getType());
		
		// Get all the existing ports of the element, static or not
		final EList<NamedElement> existingPorts = (EList<NamedElement>) chessSystemModel.getNonStaticPorts(owner);
		existingPorts.addAll((Collection<? extends NamedElement>) chessSystemModel.getStaticPorts(owner));

		// Prepare the map to mark existing ports 
		final HashMap<String, Boolean> mapPorts = Maps.newHashMapWithExpectedSize(existingPorts.size());
		for (NamedElement port : existingPorts) {
			mapPorts.put(port.getQualifiedName(), null);
		}

		// Get all the existing contract properties
		final EList<ContractProperty> existingContractProperties = (EList<ContractProperty>) chessSystemModel.getContractsOfComponent(owner);
		
		// Prepare the map to mark existing contracts
		final HashMap<String, Boolean> mapContractProperties = Maps.newHashMapWithExpectedSize(existingContractProperties.size());
		for (ContractProperty contractProperty : existingContractProperties) {
			mapContractProperties.put(contractProperty.getBase_Property().getQualifiedName(), null);
		}
		
		// Get all the functionBehaviors
		final EList<Behavior> existingFunctionBehaviors = owner.getOwnedBehaviors();
		
		// Prepare the map to mark existing functionBehaviors
		final HashMap<String, Boolean> mapFunctionBehaviors = Maps.newHashMapWithExpectedSize(existingFunctionBehaviors.size());
		for (Behavior behavior : existingFunctionBehaviors) {
			mapFunctionBehaviors.put(behavior.getQualifiedName(), null);
		}
		
		// If some InterfaceInstances are present, loop on them
		if ((dslIntInstances != null) && !dslIntInstances.isEmpty()) {
			for (InterfaceInstance dslIntInstance : dslIntInstances) {

				// Process the different types of interfaces
				if (dslIntInstance != null && dslIntInstance.getVariable() != null) {

					final Variable dslVariable = dslIntInstance.getVariable();

					if (dslVariable instanceof Port) {

						// PORT processing
						final VariableId dslVariableID = dslVariable.getId();
						final SimpleType dslVariableType = dslVariable.getType();
						
						// Version that updates the port
						// Loop on all the ports to see if it is already existing
						org.eclipse.uml2.uml.Port port = null;
						for (Object object : existingPorts) {
							final org.eclipse.uml2.uml.Port tmpPort = (org.eclipse.uml2.uml.Port) object;
							if (tmpPort.getName().equals(dslVariableID.getName())) {
								
								// Port found, update its direction if needed
								final FlowPort flowPort = (FlowPort) tmpPort.getStereotypeApplication(typeUtil.flowPortStereotype);
								if (dslVariable instanceof InputPort && flowPort.getDirection() != FlowDirection.IN) {
									flowPort.setDirection(FlowDirection.IN);
								} else if (dslVariable instanceof OutputPort && flowPort.getDirection() != FlowDirection.OUT) {
									flowPort.setDirection(FlowDirection.OUT);
								}

								// Update its type if needed
								final Type newType = chessElementsUtil.getTypeFromDSLType(dslVariableType, owner.getNearestPackage());
								if (!tmpPort.getType().getName().equals(newType.getName())) {
									tmpPort.setType(newType);
								}

								// Set the flag to signal the port is still used
								mapPorts.put(tmpPort.getQualifiedName(), Boolean.TRUE);
								port = tmpPort;
								
								// Add the port to the list of changes NOT NEEDED BECAUSE DIAGRAMS ARE AUTO-UPDATING
//								addedElements.add(port);

								break;	// Port found
							}
						}
						
						if (port == null) {
							logger.debug("Port not found, creating it");

							if (dslVariable instanceof InputPort) {
								addedElements.add(chessElementsUtil.createNonStaticPort(owner, dslVariableID, dslVariableType, true));
							} else if (dslVariable instanceof OutputPort) {
								addedElements.add(chessElementsUtil.createNonStaticPort(owner, dslVariableID, dslVariableType, false));
							}
						}
												
					} else if (dslVariable instanceof Parameter) {
						
						// PARAMETER processing
						final VariableId dslVariableID = dslVariable.getId();
						final SimpleType dslVariableType = dslVariable.getType();

						// Check if there are optional parameters to detect how to handle it
						final EList<SimpleType> parameters = ((Parameter) dslVariable).getParameters();
						if (parameters.size() != 0) {
							
							// Check if the functionBehavior is already present
							FunctionBehavior functionBehavior = (FunctionBehavior) owner.getOwnedBehavior(dslVariableID.getName());
							
							if (functionBehavior == null) {
								logger.debug("functionBehavior not found, creating one");
								
								// Create an empty functionBehavior
								functionBehavior = chessElementsUtil.createFunctionBehavior(owner, dslVariableID.getName());
								
								// Create the input parameters
								for (SimpleType parameterType : parameters) {
									chessElementsUtil.createFunctionBehaviorParameter(functionBehavior, parameterType, true);
								}

								// Create the output parameter
								chessElementsUtil.createFunctionBehaviorParameter(functionBehavior, dslVariableType, false);
																
								addedElements.add(functionBehavior);
							} else {
								logger.debug("functionBehavior already present");
								
								// Get all the existing parameters of the functionBehavior
								final EList<org.eclipse.uml2.uml.Parameter> existingFunctionBehaviorParameters = functionBehavior.getOwnedParameters(); 
								
								// Prepare the map to mark existing parameters
								final HashMap<String, Boolean> mapFunctionBehaviorParameters = Maps.newHashMapWithExpectedSize(existingFunctionBehaviorParameters.size());
								for (org.eclipse.uml2.uml.Parameter parameter : existingFunctionBehaviorParameters) {
									mapFunctionBehaviorParameters.put(parameter.getQualifiedName(), null);
								}

								org.eclipse.uml2.uml.Parameter parameter = null;
								
								// Check the input parameters
								for (SimpleType parameterType : parameters) {
									if ((parameter = chessElementsUtil.getExistingFunctionBehaviorParameter(existingFunctionBehaviorParameters, parameterType, true)) != null) {
										mapFunctionBehaviorParameters.put(parameter.getQualifiedName(), Boolean.TRUE);
										logger.debug("functionBehavior input parameter already present");
									} else {
										logger.debug("functionBehavior input parameter is not present");
										
										// Create the input parameter
										chessElementsUtil.createFunctionBehaviorParameter(functionBehavior, parameterType, true);
									}
								}
									
								// Check the output parameter
								if ((parameter = chessElementsUtil.getExistingFunctionBehaviorParameter(existingFunctionBehaviorParameters, dslVariableType, false)) != null) {
									logger.debug("functionBehavior output parameter already present");
									mapFunctionBehaviorParameters.put(parameter.getQualifiedName(), Boolean.TRUE);
								} else {
									logger.debug("functionBehavior output parameter is not present");

									// Create the output parameter
									chessElementsUtil.createFunctionBehaviorParameter(functionBehavior, dslVariableType, false);
								}
								
								//FIXME: i parametri non hanno il nome e vengono se hanno il tipo uguale 
								// vengono salvati allo stesso modo. Figurano poi mancanti quando li marco. 
								
								// Parameters cleanup time
								for (String qualifiedElement : mapFunctionBehaviorParameters.keySet()) {
									if (mapFunctionBehaviorParameters.get(qualifiedElement) == null) {
										System.out.println("functionBehaviorParameter " + qualifiedElement + " should be removed");
										chessElementsUtil.removeFunctionBehaviorParameter(existingFunctionBehaviorParameters, qualifiedElement);
									}
								}
								
								// Set the flag to signal the functionBehavior is still used
								mapFunctionBehaviors.put(functionBehavior.getQualifiedName(), Boolean.TRUE);
							}
						} else {
							
							// Convert the parameter to a static port
							// Check if the port is already present
							org.eclipse.uml2.uml.Port port = null;
							for (Object object : existingPorts) {
								final org.eclipse.uml2.uml.Port tmpPort = (org.eclipse.uml2.uml.Port) object;
								if (tmpPort.getName().equals(dslVariableID.getName()) && 
										tmpPort.getType().getName().equals(chessElementsUtil.getTypeFromDSLType(dslVariableType, owner.getNearestPackage()).getName())) {
									port = tmpPort;
									break;	// Port found
								}
							}

							if (port != null) {
								logger.debug("Port already present");

								// Set the flag to signal the port is still used
								mapPorts.put(port.getQualifiedName(), Boolean.TRUE);
								continue;
							} else {

								// Create the port and mark it
								addedElements.add(chessElementsUtil.createStaticPort(owner, dslVariableID, dslVariableType));
								continue;
							}
						}
					} else if (dslVariable instanceof Operation) {
						
						// PROVIDED OPERATION processing
						final String message = "Found a OPERATION tag, don't know how to handle it!";
						logger.error("Import Error: " + message);
						importErrors.append(message + "\n");
					}
				} else if (dslIntInstance != null && dslIntInstance.getDefine() != null) {
				
					// DEFINE processing
					final String message = "Found a DEFINE tag, don't know how to handle it!";
					logger.error("Import Error: " + message);
					importErrors.append(message + "\n");
				} else if (dslIntInstance != null && dslIntInstance.getContract() != null) {
					
					// CONTRACT processing					
					final Contract dslContract = dslIntInstance.getContract();					
					final Assumption dslAssumption = dslContract.getAssumption();
					final Guarantee dslGuarantee = dslContract.getGuarantee();

					// Retrieve the contract type from the owner, if any
					Class contract = (Class) owner.getOwnedMember(dslContract.getName(), false, UMLFactory.eINSTANCE.createClass().eClass());

					if (contract == null) {
						logger.debug("contract not found, creating one");
						
						// Create an empty Contract
						contract = chessElementsUtil.createContract(owner, dslContract.getName());
	
						// Add the two Formal Properties
						contractEntityUtil.saveFormalProperty("Assume", chessElementsUtil.getConstraintText(dslAssumption.getConstraint()), contract);
						contractEntityUtil.saveFormalProperty("Guarantee", chessElementsUtil.getConstraintText(dslGuarantee.getConstraint()), contract);
	
						// Create a Contract Property
						final String contractPropertyName = chessElementsUtil.createContractPropertyNameFromContract(contract);
						chessElementsUtil.createContractProperty(owner, contractPropertyName, (Type) contract);
						
						addedElements.add(contract);
					}  else {
						logger.debug("Contract already present");

						// The contract type is already present, update the formal properties if needed
						final String assumeString = contractEntityUtil.getAssumeStrFromUmlContract(contract);
						if (chessElementsUtil.getConstraintText(dslAssumption.getConstraint()).equals(assumeString)) {
						} else {
							
							// Change the text of the assume property
							final FormalProperty assumeFormalProperty = contractEntityUtil.getAssumeFromUmlContract(contract);
							final ValueSpecification vs = assumeFormalProperty.getBase_Constraint().getSpecification();
							((LiteralString) vs).setValue(chessElementsUtil.getConstraintText(dslAssumption.getConstraint()));
							assumeFormalProperty.getBase_Constraint().setSpecification(vs);
						}
						
						final String guaranteeString = contractEntityUtil.getGuaranteeStrFromUmlContract(contract);
						if (chessElementsUtil.getConstraintText(dslGuarantee.getConstraint()).equals(guaranteeString)) {
						} else {
							
							// Change the text of the guarantee property
							final FormalProperty guaranteeFormalProperty = contractEntityUtil.getGuaranteeFromUmlContract(contract);
							final ValueSpecification vs = guaranteeFormalProperty.getBase_Constraint().getSpecification();
							((LiteralString) vs).setValue(chessElementsUtil.getConstraintText(dslGuarantee.getConstraint()));
							guaranteeFormalProperty.getBase_Constraint().setSpecification(vs);
						}
						
						// Set the flag to signal the contractProperty is still used
						final ContractProperty contractProperty = (ContractProperty) chessSystemModel.getContract(owner, dslContract.getName());
						mapContractProperties.put(contractProperty.getBase_Property().getQualifiedName(), Boolean.TRUE);
					}
				}
			}
		}
		
		// Ports cleanup time 
		for (String qualifiedElement : mapPorts.keySet()) {
			if (mapPorts.get(qualifiedElement) == null) {
//				System.out.println("port " + qualifiedElement + " should be removed");
				chessElementsUtil.removePort(existingPorts, qualifiedElement);
			}
		}
		
		// Contracts cleanup time
		// ** Contract instances and contract types are removed, but not their formal properties and refinements!
		for (String qualifiedElement : mapContractProperties.keySet()) {
			if (mapContractProperties.get(qualifiedElement) == null) {
//				System.out.println("contractProperty " + qualifiedElement + " should be removed");
				chessElementsUtil.removeContractProperty(existingContractProperties, qualifiedElement);
			}
		}
		
		// FunctionBehavior cleanup time
		for (String qualifiedElement : mapFunctionBehaviors.keySet()) {
			if (mapFunctionBehaviors.get(qualifiedElement) == null) {
				System.out.println("functionBehavior " + qualifiedElement + " should be removed");
				chessElementsUtil.removeFunctionBehavior(existingFunctionBehaviors, qualifiedElement);
			}
		}
	}
	
	/** Navigates the component and processes its interfaces.
	 * @param dslParentComponent the element in the tree
	 * @throws ImportException 
	 */
	private void parseComponentInterfaces(AbstractComponent dslParentComponent) throws ImportException {

		logger.debug("\n\n\nParsing Interfaces for  " + dslParentComponent.getType() + "\n");
		
		// Get the Interfaces, if any
		final Interface dslComponentInterface = dslParentComponent.getInterface();
		if (dslComponentInterface != null) {
			parseInterfaces(dslParentComponent, dslComponentInterface);
		}
	}

	/** Navigates the component and processes its refinements.
	 * @param dslParentComponent the element in the tree
	 * @throws ImportException 
	 */
	private void parseComponentRefinements(AbstractComponent dslParentComponent) throws ImportException {

		logger.debug("\n\n\nParsing Refinements for " + dslParentComponent.getType() + "\n");

		// Get the Refinement, if any
		final Refinement dslComponentRefinement = dslParentComponent.getRefinement();
		if (dslComponentRefinement != null) {
			parseRefinements(dslParentComponent, dslComponentRefinement);
		}
	}
	
	/**
	 * Main method to be invoked to parse an OSS file.
	 * @throws Exception
	 */
	public StringBuffer startParsing(Package pkg, File ossFile) throws Exception, ImportException, IOException {	
		OSS ocraOssFile;
		sysView = pkg;	// Set the given package as working package
		
		importErrors = new StringBuffer();

		// Retrieve the needed stereotypes 
		typeUtil.refreshStereotypes(sysView);
		
		long startTime = System.currentTimeMillis();
		
		if (ossFile != null) {
			ocraOssFile = OSSModelFactory.getInstance().createOssModel(ossFile);
		} else {
			return importErrors;
		}

		// Retrieve the SystemComponent
		SystemComponent dslSystemComponent = ocraOssFile.getSystem();
		
		if (dslSystemComponent == null) {
			logger.error("Import Error: System component is missing");
			throw new ImportException("System component is missing");
		}

		// If the OCRA system component type is not defined, set it to 'System'
		final String dslSystemComponentName = dslSystemComponent.getType() == null ? "System" : dslSystemComponent.getType();
		dslSystemComponent.setType(dslSystemComponentName);

		logger.debug("dslSystemComponent.type = " + dslSystemComponentName);

		// Get all the existing members
		EList<NamedElement> existingMembers = sysView.getOwnedMembers();
		EList<Class> existingBlocks = new BasicEList<Class>(existingMembers.size());
		
		// Prepare the map to mark existing blocks
		HashMap<String, Boolean> mapBlocks = Maps.newHashMapWithExpectedSize(existingMembers.size());
		for (Element member : existingMembers) {
			if (entityUtil.isBlock(member) && !contractEntityUtil.isContract(member)) {
				mapBlocks.put(((Class) member).getQualifiedName(), null);
				existingBlocks.add((Class) member);
			}
		}
		
		// New elements that will be added to the model
		addedElements.clear();
		
		// A map used to connect block names to their implementation
		dslTypeToComponent = new HashMap<String, Class>();

		// Clear the exception before starting the import
		importException = null;
		
		// Start a transaction to modify the package content 
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(pkg);
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {

				String blockQualifiedName = pkg.getQualifiedName() + "::" + dslSystemComponentName;			
				Class systemComponent = null;
				if (!mapBlocks.containsKey(blockQualifiedName)) {
					logger.debug("block not present: " + blockQualifiedName);

					// Add a new systemComponent to the package
					systemComponent = chessElementsUtil.createSystemBlock(sysView, dslSystemComponent.getType());
					
					// Add the component to the list of changes
					addedElements.add(systemComponent);
					
				} else {
					logger.debug("block already present");
					
					// Should retrieve the old one from the package
					systemComponent = (Class) sysView.getOwnedMember(dslSystemComponentName, false, UMLFactory.eINSTANCE.createClass().eClass());
					
					// Set the flag to signal the block is still used
					mapBlocks.put(blockQualifiedName, Boolean.TRUE);
				}
				
				// Store the systemComponent in a hash with its name
				dslTypeToComponent.put(dslSystemComponentName, systemComponent);

				// Populate the map and the package with the other Component elements 
				for (Component dslComponent : ocraOssFile.getComponents()) {
					
					blockQualifiedName = pkg.getQualifiedName() + "::" + dslComponent.getType();
					
					Class component = null;
					if(!mapBlocks.containsKey(blockQualifiedName)) {

						logger.debug("block not present: " + blockQualifiedName);

						// Add a new block to the package
						component = chessElementsUtil.createBlock(sysView, dslComponent.getType());

						// Add the component to the list of changes
						addedElements.add(component);
					} else {
					
						logger.debug("block already present: " + blockQualifiedName);
						
						// Retrieve the old one
						component = (Class) sysView.getOwnedMember(dslComponent.getType(), false, UMLFactory.eINSTANCE.createClass().eClass());

						// Set the flag to signal the block is still used
						mapBlocks.put(blockQualifiedName, Boolean.TRUE);
					}

					// Store the component in a hash with its name
					dslTypeToComponent.put(dslComponent.getType(), component);
				}

				// Now I have created all the Blocks in the package, loop on them, but not getting them from 
				// the package (it may be polluted with other blocks), but from the OSS model again.
				try {
				
					// Parse the system component
					parseComponentInterfaces(dslSystemComponent);
	
					// Parse all the other components 
					for (Component dslComponent : ocraOssFile.getComponents()) {
						parseComponentInterfaces(dslComponent);
					}
	
					// Parse the system component
					parseComponentRefinements(dslSystemComponent);
	
					// Parse all the other components 
					for (Component dslComponent : ocraOssFile.getComponents()) {
						parseComponentRefinements(dslComponent);
					}
				} catch (ImportException e) {
					importException = e;
					return;
				}

				// Blocks cleanup time, remove blocks no more needed
				for (String qualifiedElement : mapBlocks.keySet()) {
					if (mapBlocks.get(qualifiedElement) == null) {
//						System.out.println("block " + qualifiedElement + " should be removed");
						chessElementsUtil.removeElement(existingBlocks, qualifiedElement);
					}
				}
				
				logger.debug("Total time = " + (System.currentTimeMillis() - startTime));
//				System.out.println("Total time = " + (System.currentTimeMillis() - startTime));
			}
		});
		
		// addedElements contains all the elements that have been added or modified 
		logger.debug("addedElements size = " + addedElements.size());
		for (Element element : addedElements) {
			logger.debug("modified element = " + element);
		}
				
		// Propagate the exception, if any
		if (importException != null) {
			throw importException;
		}
		
		return importErrors;
	}
}

//TODO: andrebbero rimossi anche i tipi creati, signal, enumeration, boundedsubtype, formal properties, ...
