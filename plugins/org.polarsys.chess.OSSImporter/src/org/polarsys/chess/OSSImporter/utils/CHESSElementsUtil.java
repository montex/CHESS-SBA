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
package org.polarsys.chess.OSSImporter.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.sysml.portandflows.FlowDirection;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.utils.ElementUtil;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPage;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerView;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.FunctionBehavior;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.xtext.serializer.ISerializer;
import org.polarsys.chess.OSSImporter.exceptions.ImportException;
import org.polarsys.chess.contracts.profile.chesscontract.ContractProperty;
import org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement;
import org.polarsys.chess.contracts.profile.chesscontract.util.ContractEntityUtil;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;

import com.google.inject.Injector;

import eu.fbk.eclipse.standardtools.xtextService.core.utils.XTextResourceUtil;
import eu.fbk.tools.editor.basetype.baseType.BooleanType;
import eu.fbk.tools.editor.basetype.baseType.BoundedArrayType;
import eu.fbk.tools.editor.basetype.baseType.ContinuousType;
import eu.fbk.tools.editor.basetype.baseType.EnumType;
import eu.fbk.tools.editor.basetype.baseType.EventType;
import eu.fbk.tools.editor.basetype.baseType.Expression;
import eu.fbk.tools.editor.basetype.baseType.FixedSizeArrayType;
import eu.fbk.tools.editor.basetype.baseType.IntegerType;
import eu.fbk.tools.editor.basetype.baseType.RangeType;
import eu.fbk.tools.editor.basetype.baseType.RealType;
import eu.fbk.tools.editor.basetype.baseType.SignedWordType;
import eu.fbk.tools.editor.basetype.baseType.SimpleType;
import eu.fbk.tools.editor.basetype.baseType.UnboundedArrayType;
import eu.fbk.tools.editor.basetype.baseType.UnsignedWordType;
import eu.fbk.tools.editor.basetype.baseType.WordArrayType;
import eu.fbk.tools.editor.basetype.baseType.WordType;
import eu.fbk.tools.editor.contract.contract.Contract;
import eu.fbk.tools.editor.contract.expression.expression.PortId;
import eu.fbk.tools.editor.contract.expression.expression.VariableId;

/**
 * A class that contains some utility methods to create CHESS elements.
 * @author cristofo
 *
 */
public class CHESSElementsUtil {

	// The instance of this class
	private static CHESSElementsUtil classInstance;
	
	private final TypesUtil typeUtil = TypesUtil.getInstance();
	private final EntityUtil entityUtil = EntityUtil.getInstance();
	private final ContractEntityUtil contractEntityUtil = ContractEntityUtil.getInstance();

	// Logger for messages
	private static final Logger logger = Logger.getLogger(CHESSElementsUtil.class);

	private static final String DELEGATION_PREFIX = "Define_";
	private static final String DELEGATION_CONSTRAINT_NAME = "constraintSpec";
	private static final String CONNECTOR_NAME = "connector";
	private static final String ASSOCIATION_NAME = "association";
	private static final String PARAMETER_IN_NAME = "parameterIn";
	private static final String PARAMETER_OUT_NAME = "parameterOut";
	
	private static final String DELETE_COMMAND_ID = "org.eclipse.ui.edit.delete";
	private static final String MODELEXPLORER_VIEW_ID = "org.eclipse.papyrus.views.modelexplorer.modelexplorer";
	
	private final Injector injector = XTextResourceUtil.getInstance().getOssInjector();
	private final ISerializer serializer = injector.getInstance(ISerializer.class);

	
	/**
	 * Gets an instance of the class if already present, or a new one if not.
	 * @return the instance of this class
	 */
	public static CHESSElementsUtil getInstance() {
		if (classInstance == null) {
			classInstance = new CHESSElementsUtil();
		}
		return classInstance;
	}

	/** 
	 * Returns the correct Type given the DSL SimpleType.
	 * @param dslSimpleType the type from OSS
	 * @param pkg the package where the types could be
	 * @return the UML Type
	 */
	public Type getTypeFromDSLType(SimpleType dslSimpleType, Package pkg) {
		
		if (dslSimpleType instanceof BooleanType) {
			logger.debug("BooleanType");
			return typeUtil.getPrimitiveType("Boolean");
		} else if (dslSimpleType instanceof IntegerType) {
			logger.debug("IntegerType");
			return typeUtil.getPrimitiveType("Integer");
		} else if (dslSimpleType instanceof RealType) {
			logger.debug("RealType");
			return typeUtil.getPrimitiveType("Real");
		} else if (dslSimpleType instanceof WordType) {
			logger.debug("WordType");
		} else if (dslSimpleType instanceof UnsignedWordType) {
			logger.debug("UnsignedWordType");
		} else if (dslSimpleType instanceof SignedWordType) {
			logger.debug("SignedWordType");
		} else if (dslSimpleType instanceof ContinuousType) {
			logger.debug("ContinuousType");
			return typeUtil.getContinuousType("Continuous");
		} else if (dslSimpleType instanceof EventType) {
			logger.debug("EventType");
			return typeUtil.getSignalType(pkg);
		} else if (dslSimpleType instanceof RangeType) {
			logger.debug("RangeType");
			return typeUtil.getBoundedSubType((RangeType) dslSimpleType, pkg);
		} else if (dslSimpleType instanceof EnumType) {
			logger.debug("EnumType");
			return typeUtil.getEnumerationType((EnumType) dslSimpleType, pkg);
		} else if (dslSimpleType instanceof FixedSizeArrayType) {
			logger.debug("FixedSizeArrayType");
		} else if (dslSimpleType instanceof BoundedArrayType) {
			logger.debug("BoundedArrayType");
		} else if (dslSimpleType instanceof UnboundedArrayType) {
			logger.debug("UnboundedArrayType");
		} else if (dslSimpleType instanceof WordArrayType) {
			logger.debug("WordArrayType");
		}
		logger.error("Not able to map the requested DSL type!");
		return null;
	}
	
	/** 
	 * Creates a System Block element in the given package.
	 * @param owner the Package that will contain the element
	 * @param elementName the name of the new System Block
	 * @return the created Class
	 */
	public Class createSystemBlock(Package owner, final String elementName) {

		Class sysBlock = owner.createOwnedClass(elementName, false);
		sysBlock.applyStereotype(typeUtil.blockStereotype);
		sysBlock.applyStereotype(typeUtil.systemStereotype);
		
		logger.debug("\n\nCreated " + elementName + " System Block\n\n");
		return sysBlock;
	}
	
	/** 
	 * Creates a Block element in the given package.
	 * @param owner the Package that will contain the element
	 * @param elementName the name of the new Block
	 * @return the newly created Class
	 */
	public Class createBlock(Package owner, final String elementName) {

		Class umlClass = owner.createOwnedClass(elementName, false);
		umlClass.applyStereotype(typeUtil.blockStereotype);
		
//		owner.createPackagedElement(elementName, newUMLClass.eClass()); This also works...
//		owner.getPackagedElements().add(newUMLClass);	// This works too!
		
		logger.debug("\n\nCreated " + elementName + " Block\n\n");
		return umlClass;	// Return the first occurence
	}

	/** 
	 * Creates and adds a non-static Port to the model.
	 * @param owner the parent Class
	 * @param elementName the name of the port to create
	 * @param elementType the type of the port to create
	 * @param isInput tells the direction of the flow
	 * @return the created Port
	 * @throws ImportException 
	 */
	public org.eclipse.uml2.uml.Port createNonStaticPort(Class owner, VariableId elementName, SimpleType elementType, boolean isInput) throws ImportException {
		final String portName = elementName.getName();
		final Type portType = getTypeFromDSLType(elementType, owner.getNearestPackage());
		
		if(portType == null) {
			throw new ImportException("Not able to map the requested type for port : " + portName);
//			return null;	// Create the port anyway, without type
		}
		
		org.eclipse.uml2.uml.Port umlPort = UMLFactory.eINSTANCE.createPort();
		umlPort.setName(portName);
		umlPort.setType(portType);
		owner.getOwnedPorts().add(umlPort);
//		Stereotype stereotype = UMLUtils.applyStereotype(umlPort, FLOWPORT);
		umlPort.applyStereotype(typeUtil.flowPortStereotype);
		umlPort.setAggregation(AggregationKind.get(AggregationKind.COMPOSITE));
//		FlowPort flowPort = (FlowPort) umlPort.getStereotypeApplication(stereotype);
		FlowPort flowPort = (FlowPort) umlPort.getStereotypeApplication(typeUtil.flowPortStereotype);
		flowPort.setDirection(isInput? FlowDirection.IN: FlowDirection.OUT);
		
		// This version is nicer but a little slower
//		org.eclipse.uml2.uml.Port umlPort = owner.createOwnedPort(portName, portType);
//		Stereotype stereotype = UMLUtils.applyStereotype(umlPort, FLOWPORT);
//		umlPort.setAggregation(AggregationKind.get(AggregationKind.COMPOSITE));
//		FlowPort flowPort = (FlowPort) umlPort.getStereotypeApplication(stereotype);
//		flowPort.setDirection(isInput? FlowDirection.IN: FlowDirection.OUT);
		
		logger.debug("\n\nCreated " + portName + " Port\n\n");
		return umlPort;
	}
	
	/** 
	 * Creates and adds a static Port to the model.
	 * @param owner the parent Class
	 * @param elementName the name of the port to create
	 * @param elementType the type of the port to create
	 * @return the created Port
	 * @throws ImportException 
	 */
	public org.eclipse.uml2.uml.Port createStaticPort(Class owner, VariableId elementName, SimpleType elementType) throws ImportException {
		final String portName = elementName.getName();
		final Type portType = getTypeFromDSLType(elementType, owner.getNearestPackage());
		
		if(portType == null) {
			throw new ImportException("Not able to map the requested type for port : " + portName);
		}
		
		org.eclipse.uml2.uml.Port umlPort = UMLFactory.eINSTANCE.createPort();
		umlPort.setName(portName);
		umlPort.setType(portType);
		owner.getOwnedPorts().add(umlPort);
//		Stereotype stereotype = UMLUtils.applyStereotype(umlPort, FLOWPORT);
		umlPort.applyStereotype(typeUtil.flowPortStereotype);
		umlPort.setAggregation(AggregationKind.get(AggregationKind.COMPOSITE));
//		FlowPort flowPort = (FlowPort) umlPort.getStereotypeApplication(stereotype);
		FlowPort flowPort = (FlowPort) umlPort.getStereotypeApplication(typeUtil.flowPortStereotype);
		flowPort.setDirection(FlowDirection.INOUT);
		umlPort.setIsStatic(true);
		
		logger.debug("\n\nCreated " + portName + " Port\n\n");
		return umlPort;
	}
	
	/** 
	 * Creates a Contract element.
	 * @param owner the Class that will contain the element
	 * @param contractName the name of the new Contract
	 * @return the newly created Class
	 */
	public Class createContract(Class owner, String contractName) {

		logger.debug("\n\n\n Creating contract " + contractName + " for owner " + owner);
		logger.debug("\n\n\n");

		Class newUmlClass = UMLFactory.eINSTANCE.createClass();
		Classifier newClass = owner.createNestedClassifier(contractName, newUmlClass.eClass());
		newClass.applyStereotype(typeUtil.contractStereotype);
		
		logger.debug("\n\nCreated " + contractName + " Property\n\n");
		return (Class) newClass;
	}
	
	/** 
	 * Returns a name for the ContractProperty, deriving it from the Contract type.
	 * @param contract the contract from which it derives
	 * @return a derived name, going lowercase
	 */
	public String createContractPropertyNameFromContract(Class contract) {
		final String contractName = contract.getName();
		
		if (contractName.length() > 0) {
			return contractName.toLowerCase();
		} else {
			return ((Contract) contract).getName().toLowerCase();
		}
	}
	
	/** 
	 * Creates and adds a Contract Property to the model.
	 * @param owner the parent Class
	 * @param elementName the name of the property to create
	 * @param elementType the type of the property to create
	 * @return the created Property
	 */
	public Property createContractProperty(Class owner, String elementName, Type elementType) {
		
		logger.debug("\n\n\n Creating contract property " + elementName + " for owner " + owner + " with type " + elementType);
		logger.debug("\n\n\n");

		Property newUMLProperty = owner.createOwnedAttribute(elementName, elementType);
		newUMLProperty.applyStereotype(typeUtil.contractPropertyStereotype);
		
		logger.debug("\n\nCreated " + elementName + " Property\n\n");
		return newUMLProperty;
	}
	
	/**
	 * Returns the number or defined associations for the given package.
	 * @param pkg the package to analyze
	 * @return the number of associations found in package
	 */
	private int countPackageAssociations(Package pkg) {
		int counter = 0;
		
		EList<NamedElement> namedList = pkg.getOwnedMembers();
		for (NamedElement namedElement : namedList) {
			if (namedElement instanceof Association) {
				counter++;
			}
		}
		return counter;
	}
	
	/**
	 * Creates an association between the given owner and element. It will also create the relative
	 * component instance inside the owner element.
	 * @param owner the parent Class
	 * @param elementName the name of the end element
	 * @param elementType the type of the end element
	 * @return the created Association
	 */
	public Association createAssociation(Class owner, String elementName, Type elementType) {
		
		// Create the name using an incremental value
		final String associationName = ASSOCIATION_NAME + (countPackageAssociations(owner.getNearestPackage()) + 1);

		logger.debug("\n\n\n Creating association " + associationName + " for owner " + owner);
		logger.debug("elementName = " + elementName + " with type " + elementType);
		logger.debug("\n\n\n");
	
		// Create the association and adds it to the owning package
		final Association association = owner.createAssociation(
				true, AggregationKind.get(AggregationKind.COMPOSITE), elementName, 1, 1, elementType, 
				false, AggregationKind.get(AggregationKind.NONE), owner.getName().toLowerCase(), 1, 1);

		association.setName(associationName);
		
		// Add SysML Nature on the new Association
		ElementUtil.addNature(association, SysMLElementTypes.SYSML_NATURE);
		
		logger.debug("\n\nCreated " + associationName + " Association\n\n");
		return association;
	}
	
	/** 
	 * Gets the expression string from the Expression constraint.
	 * @param constraint the expression to convert
	 */
	public String getConstraintText(Expression constraint) {
		final String text = serializer.serialize(constraint);

		return text.trim();
	}
	
	/**
	 * Creates the Delegation Constraint value.
	 * @param variable the left part of the expression
	 * @param constraint the right part of the expression
	 * @return a string with the expression
	 */
	private String createDelegationConstraintText(VariableId variable, Expression constraint) {
		final StringBuffer delegationText = new StringBuffer();
		final EList<String> componentNames = variable.getComponentNames();
		
		if (componentNames != null && componentNames.size() != 0) {
			delegationText.append(componentNames.get(0) + ".");
		}
		
		delegationText.append(variable.getName() + " := " + getConstraintText(constraint));
		return delegationText.toString();
	}
			
	/**
	 * Returns the delegation constraint with the given specs from a list
	 * @param delegationConstraints the list of delegation constraints to scan
	 * @param variable variable part
	 * @param constraint costraint part
	 * @return the delegation constraint, if found
	 */
	public Constraint getExistingDelegationConstraint(EList<Constraint> delegationConstraints, VariableId variable, Expression constraint) {

		// Text of the delegation constraint
		final String formalPropertyText = createDelegationConstraintText(variable, constraint);
		
		// Loop on all the delegation constraints to find one with same text
		for (Constraint delegationConstraint : delegationConstraints) {
			final LiteralString specification = (LiteralString) delegationConstraint.getSpecification();
			if (specification.getValue().equals(formalPropertyText)) {
				return delegationConstraint;
			}
		}
		return null;
	}
	
	/** 
	 * Creates and adds a Delegation Constraint to the model.
	 * @param owner the parent Class
	 * @param connection the Connection defining the delegation
	 * @param variable the target of the connection
	 * @param constraint the source of the connection
	 * @return the created delegation constraint 
	 */
	public Constraint createDelegationConstraint(Class owner, VariableId variable, Expression constraint) {		
		final StringBuffer delegationName = new StringBuffer(DELEGATION_PREFIX);
		
		final EList<String> componentNames = variable.getComponentNames();
		
		if (componentNames != null && componentNames.size() != 0) {
			delegationName.append(componentNames.get(0) + ".");
		}

		delegationName.append(variable.getName());
		
		logger.debug("\n\n\n Creating delegation constraint " + delegationName + " for owner " + owner);
		logger.debug("\n\n\n");

		final Constraint newUMLConstraint = owner.createOwnedRule(delegationName.toString());
		newUMLConstraint.applyStereotype(typeUtil.delegationConstraintStereotype);
		
		final LiteralString literalString = UMLFactory.eINSTANCE.createLiteralString();
		literalString.setName(DELEGATION_CONSTRAINT_NAME);
		final String formalPropertyText = createDelegationConstraintText(variable, constraint);
		literalString.setValue(formalPropertyText);
		newUMLConstraint.setSpecification(literalString);

		logger.debug("\n\nCreated " + delegationName + " Delegation Constraint\n\n");
		return newUMLConstraint;
	}

	/**
	 * Adds a connector to the given element.
	 * @param owner the owner element
	 * @param connector the conne
	 */
	public void addConnector(Class owner, Connector connector) {
		
		// Add the new connector to the list
		owner.getOwnedConnectors().add(connector);
	}
	
	/**
	 * Creates a connector, but doesn't add it to the owner.
	 * @param owner the owner element
	 * @return the created Connector
	 */
	public Connector createConnector(Class owner) {
		
		// Create the name using an incremental value
		final String connectorName = CONNECTOR_NAME + (owner.getOwnedConnectors().size() + 1);
		
		logger.debug("\n\n\n Creating connector " + connectorName + " for owner " + owner);
		logger.debug("\n\n\n");

		Connector connector = UMLFactory.eINSTANCE.createConnector();
		connector.setName(connectorName);
		
		logger.debug("\n\nCreated " + connectorName + " Connector\n\n");
		return connector;	
	}
	
	/**
	 * Creates an end to the given connector.
	 * @param connector the owner Connector
	 * @param sourceOwner the component instance owning the port
	 * @param sourcePort the port to be connected
	 * @return
	 */
	public ConnectorEnd createConnectorEnd(Connector connector, Property sourceOwner, ConnectableElement sourcePort) {
		final ConnectorEnd end = connector.createEnd();

		end.setRole(sourcePort);
		end.setPartWithPort(sourceOwner);
		return end;
	}

	/**
	 *  Returns the contract refinement associated to the component.
	 *  @param owner of the contract refinement
	 *  @param refinementName the name of the contract refinement
	 *  @return the UML contract refinement
	 */
	private DataType getExistingUMLContractRefinement(Class owner, String refinementName) {
		return (DataType) owner.getNestedClassifier(refinementName);
	}

	/** 
	 * Creates a ContractRefinement for the given owner component.
	 * The refinement should specify the component instance that contains the original contract property
	 * and the contract property itself 
	 *  
	 * @param owner the container of the refinement
	 * @param componentName the component instance containing the contract property
	 * @param contractName the type of the contract
	 * @return the created DataType 
	 */
	public DataType createContractRefinement(Class owner, String componentName, String contractName) {
					
		logger.debug("\n\n\n Creating contract refinement for componentName = " + componentName + " of contract " + contractName);
		logger.debug("\n\n\n");
				
		// The component instance containing the refining contract
		final Property refiningComponentInstance = entityUtil.getUMLComponentInstance(owner, componentName);

		// The component type where the contract property is defined
		final Class refiningComponent = (Class) refiningComponentInstance.getType();
		
		// The instance of the refining contract
		//final ContractProperty refiningContractProperty = getContractPropertyFromContract(refiningComponent, contractName);
		final Property umlContractProperty = contractEntityUtil.getUmlContractPropertyOfUmlComponentFromContractPropertyType(refiningComponent, contractName);
		final ContractProperty refiningContractProperty = contractEntityUtil.getContractProperty(umlContractProperty);

		// Compose the correct name of the contract refinement 
		final String refinementName = componentName + "." + umlContractProperty.getName();
		
		// Check if the refinement is already present
		final DataType umlRefinement = getExistingUMLContractRefinement(owner, refinementName);
		
		if (umlRefinement != null) {
			return umlRefinement;
		} else {
			logger.debug("\n\n Creating contract refinement " + refinementName + " for owner " + owner.getName());
			logger.debug("\n\n");
	
			final DataType newUmlDataType = UMLFactory.eINSTANCE.createDataType();
			final Classifier newClass = owner.createNestedClassifier(refinementName, newUmlDataType.eClass());
			newClass.applyStereotype(typeUtil.contractRefinementStereotype);
			final ContractRefinement contractRefinement = (ContractRefinement) newClass.getStereotypeApplication(typeUtil.contractRefinementStereotype);

			// Set the correct links for the refinement
			contractRefinement.setInstance(refiningComponentInstance); // The component instance containing the definition
			contractRefinement.setContract(refiningContractProperty);  // The contract property that refines the contract
					
			logger.debug("\n\nCreated " + refinementName + " Contract Refinement\n\n");
			return (DataType) newClass;
		}
	}

	/** 
	 * Adds a contract refinement to a contract property.
	 * @param contractProperty the property to be enriched
	 * @param umlRefinement the refinement to add
	 */
	public void addContractRefinementToContractProperty(ContractProperty contractProperty, DataType umlRefinement) {
		final Stereotype stereotype = umlRefinement.getAppliedStereotype(TypesUtil.CONTRACT_REFINEMENT);	
		final ContractRefinement contractRefinement = (ContractRefinement) umlRefinement.getStereotypeApplication(stereotype);
		
		// Add the new refinement to the list
		contractProperty.getRefinedBy().add(contractRefinement);
	}
	
	// Needed to bring out a reference from the inner class...
	ModelExplorerView modelExplorerView;
	
	/**
	 * Returns the ModelExplorerView.
	 * @return
	 */
	private ModelExplorerView getModelExplorerView() {

		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				final IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

				// we look for the modelexplorer
				IViewPart modelexplorer;
				try {
					modelexplorer = activeWorkbenchWindow.getActivePage().showView(MODELEXPLORER_VIEW_ID);
				} catch (PartInitException ex) {
					ex.printStackTrace(System.out);
					return;
				}
				final ModelExplorerPageBookView view = (ModelExplorerPageBookView) modelexplorer;
				final ModelExplorerPage page = (ModelExplorerPage) view.getCurrentPage();
				final IViewPart viewer = page.getViewer();
				modelExplorerView = (ModelExplorerView) viewer;
			}
		});
		return modelExplorerView;
	}

	/**
	 * Returns the handler for the given command.
	 * @param commandId the command
	 * @return the handler
	 */
	private IHandler getActiveHandlerFor(final String commandId) {
		final ICommandService commandService = 
				(ICommandService) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getService(ICommandService.class);
		commandService.refreshElements(commandId, null);
		final Command cmd = commandService.getCommand(commandId);
		return cmd.getHandler();
	}

	/**
	 * Deletes an element from the model.
	 * @param element the element to remove
	 * @throws Exception
	 */
	private void deleteElementInTheModel(NamedElement element) throws Exception {
		
		// Give the focus to the ModelExplorerView
		ModelExplorerView modelExplorerView = getModelExplorerView();
		modelExplorerView.setFocus();

		// Select the requested element
		List<Object> elements = new ArrayList<Object>();
		elements.add(element);
		modelExplorerView.revealSemanticElement(elements);

		IHandler deleteHandler = getActiveHandlerFor(DELETE_COMMAND_ID);
		deleteHandler.execute(new ExecutionEvent());
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
					deleteElementInTheModel(element.getBase_Property());
				} catch (Exception e) {
					e.printStackTrace();
				}
				members.remove(element);
				break;
			}
		}
	}

	/**
	 * Removes a named element from the given list.
	 * @param members the list of members
	 * @param qualifiedElement the qualified name of the element to remove
	 */
	private void removeNamedElement(EList<?> members, String qualifiedElement) {
		for (Object object : members) {
			NamedElement element = (NamedElement) object;
			if (element.getQualifiedName().equals (qualifiedElement)) {
				try {
//					((Element) element).destroy();	//TODO: investigate this line!
					deleteElementInTheModel(element);
				} catch (Exception e) {
					e.printStackTrace();
				}
				members.remove(element);
				break;
			}
		}		
	}

	/**
	 * Removes a property from the list.
	 * @param members the list of members
	 * @param qualifiedElement the qualified name of the  property to remove
	 */
	public void removeProperty(EList<Property> members, String qualifiedElement) {
		removeNamedElement(members, qualifiedElement);
	}

	/**
	 * Removes a property from the list.
	 * @param members the list of members
	 * @param qualifiedElement the qualified name of the  property to remove
	 */
	public void removeConnector(EList<Connector> members, String qualifiedElement) {
		removeNamedElement(members, qualifiedElement);
	}
	
	/**
	 * Removes a port from the list.
	 * @param members the list of members
	 * @param qualifiedElement the qualified name of the port to remove
	 */
	public void removePort(EList<NamedElement> members, String qualifiedElement) {
		removeNamedElement(members, qualifiedElement);
	}
	
	/**
	 * Removes a delegation constraint from the list.
	 * @param members the list of members
	 * @param qualifiedElement the qualified name of the delegation constraint to remove
	 */
	public void removeDelegationConstraint(EList<Constraint> members, String qualifiedElement) {
		removeNamedElement(members, qualifiedElement);
	}

	/**
	 * Removes a contract refinement from the list.
	 * @param members the list of members
	 * @param qualifiedElement the qualified name of the contract refinement to remove
	 */
	public void removeContractRefinement(EList<DataType> members, String qualifiedElement) {
		removeNamedElement(members, qualifiedElement);
	}

	/**
	 * Removes an element from the list.
	 * @param members the list of members
	 * @param qualifiedElement the qualified name of the element to remove
	 */
	public void removeElement(EList<Class> members, String qualifiedElement) {
		removeNamedElement(members, qualifiedElement);
	}

	/**
	 * Removes a function behavior from the list.
	 * @param members the list of members
	 * @param qualifiedElement the qualified name of the function behavior to remove
	 */
	public void removeFunctionBehavior(EList<Behavior> members, String qualifiedElement) {
		removeNamedElement(members, qualifiedElement);
	}
	
	/**
	 * Removes a FunctionBehavior parameter from the list.
	 * @param members the list of members
	 * @param qualifiedElement the qualified name of the function behavior parameter to remove
	 */
	public void removeFunctionBehaviorParameter(EList<Parameter> members, String qualifiedElement) {
		removeNamedElement(members, qualifiedElement);
	}
	
	/**
	 * Removes a formal property from the list.
	 * @param members the list of members
	 * @param qualifiedElement the qualified name of the formal property to remove
	 */
	public void removeFormalProperty(EList<Constraint> members, String qualifiedElement) {
		removeNamedElement(members, qualifiedElement);
	}

	/**
	 * Creates an empty FunctionBehavior belonging to the given owner
	 * @param owner the owner class of the functionBehavior
	 * @param functionBehaviorName the name of the functionBehavior 
	 * @return the newly created FunctionBehavior
	 */
	public FunctionBehavior createFunctionBehavior(Class owner, String functionBehaviorName) {
		
		logger.debug("\n\n\n Creating functionBehavior " + functionBehaviorName + " for owner " + owner);
		logger.debug("\n\n\n");

		final FunctionBehavior functionBehavior = (FunctionBehavior) owner.createOwnedBehavior(functionBehaviorName, UMLPackage.eINSTANCE.getFunctionBehavior());
		
		logger.debug("\n\nCreated " + functionBehaviorName + " FunctionBehavior\n\n");		
		return functionBehavior;
	}
	
	/**
	 * Returns the input Parameters of the given FunctionBehavior
	 * @param owner the FunctionBehavior to analyze
	 * @return the list of input Parameters
	 */
	private EList<Parameter> getOwnedInputParameters(FunctionBehavior owner) {
		EList<Parameter> inputParameters = new BasicEList<Parameter>();
		
		for (Parameter parameter : owner.getOwnedParameters()) {
			if (parameter.getDirection() == ParameterDirectionKind.IN_LITERAL) {
				inputParameters.add(parameter);
			}
		}
		return inputParameters;
	}
	
	/**
	 * Creates a parameter for the given FunctionBehavior
	 * @param owner the owning FunctionBehavior
	 * @param type the type of the parameter
	 * @param isInput the direction of the parameter
	 * @return the newly created Parameter
	 */
	public Parameter createFunctionBehaviorParameter(FunctionBehavior owner, SimpleType type, boolean isInput) {
		final Type parameterType = getTypeFromDSLType(type, owner.getNearestPackage());
		
		// Create the name
		String parameterName = null;
		if (isInput) {
			parameterName = PARAMETER_IN_NAME + (getOwnedInputParameters(owner).size() + 1);	// Incremental name
		} else {
			parameterName = PARAMETER_OUT_NAME;	// There could be only one output
		}

		logger.debug("\n\n\n Creating functionBehaviorParameter " + parameterName + " for owner " + owner);
		logger.debug("\n\n\n");

		final Parameter parameter = owner.createOwnedParameter(parameterName, parameterType);
		parameter.setDirection(isInput? ParameterDirectionKind.IN_LITERAL : ParameterDirectionKind.OUT_LITERAL);
		logger.debug("\n\nCreated " + parameterName + " functionBehaviorParameter\n\n");
		return parameter;
	}

	/**
	 * Create a public formal property 
	 * @param owner the owner of the property
	 * @param assertionName the name of the formal property
	 * @param assertionText the text of the formal property
	 * @return the newly created formal property
	 */
	public Constraint createInterfaceFormalProperty(Class owner, String assertionName, String assertionText) {	

		final Constraint umlConstraint = contractEntityUtil.createFormalProperty(owner, assertionName);
		final LiteralString newLs = UMLFactory.eINSTANCE.createLiteralString();
		final ValueSpecification vs = umlConstraint.createSpecification("ConstraintSpec", null, newLs.eClass());
		umlConstraint.setSpecification(vs);
		
		contractEntityUtil.saveFormalProperty(umlConstraint, assertionText);
		
		return umlConstraint;	
	}
	
	/**
	 * Create a private formal property
	 * @param owner the owner of the property
	 * @param assertionName the name of the formal property
	 * @param assertionText the text of the formal property
	 * @return the newly created formal property
	 */
	public Constraint createRefinementFormalProperty(Class owner, String assertionName, String assertionText) {

		final Constraint umlConstraint = contractEntityUtil.createFormalProperty(owner, assertionName);
		final LiteralString newLs = UMLFactory.eINSTANCE.createLiteralString();
		final ValueSpecification vs = umlConstraint.createSpecification("ConstraintSpec", null, newLs.eClass());
		umlConstraint.setSpecification(vs);
		umlConstraint.setVisibility(VisibilityKind.PRIVATE_LITERAL);
		
		contractEntityUtil.saveFormalProperty(umlConstraint, assertionText);
		
		return umlConstraint;
	}
	
	/**
	 * Return the Parameter with the given speccs if present among a list of Parameters
	 * @param parameters the list of Parameters to scan
	 * @param type the type of the Parameter
	 * @param isInput the direction of the Parameter
	 * @return the Parameter, if found
	 */
	public Parameter getExistingFunctionBehaviorParameter(EList<Parameter> parameters, SimpleType type, boolean isInput) {
		for (Parameter parameter : parameters) {
			if (parameter.getType() == getTypeFromDSLType(type, parameter.getNearestPackage())) {
				if ((isInput && parameter.getDirection() == ParameterDirectionKind.IN_LITERAL) || 
						(!isInput && parameter.getDirection() == ParameterDirectionKind.OUT_LITERAL)) {
					return parameter;
				}
			}
		}
		return null;
	}
	
	/**
	 * Returns the Connector with the given ends if present among a list of Connectors
	 * @param connectors the list of Connectors to scan
	 * @param variable the first end of the Connector
	 * @param constraint the second end of the Connector
	 * @return the Connector, if found
	 */
	public Connector getExistingConnector(EList<Connector> connectors, VariableId variable, Expression constraint) {

		// Details of the connector ends
		String variablePortOwner = null;
		String variablePortName = null;
		String constraintPortOwner = null;
		String constraintPortName = null;
		
		if (variable instanceof PortId) {
			
			// Get the component name, should be at max one
			EList<String> componentNames = ((PortId) variable).getComponentNames();
			if (componentNames != null && componentNames.size() != 0) {
				variablePortOwner = componentNames.get(0);
			}
			variablePortName = ((PortId) variable).getName();					
		} else {
			return null;
		}

		if (constraint instanceof PortId) {
			
			// Get the component name, should be at max one
			EList<String> componentNames = ((PortId) constraint).getComponentNames();
			if (componentNames != null && componentNames.size() != 0) {
				constraintPortOwner = componentNames.get(0);
			}
			constraintPortName = ((PortId) constraint).getName();
		} else {
			return null;
		}
		
		// Loop on all the connectors to find one with same values
		for (Connector connector : connectors) {
			final EList<ConnectorEnd> ends = connector.getEnds();
			if (ends.size() == 2) {
				
				// Check the first end
				final Property sourceOwner = ends.get(0).getPartWithPort();	// Should be the owner of the port
				final org.eclipse.uml2.uml.Port sourcePort = (org.eclipse.uml2.uml.Port) ends.get(0).getRole();	// Should be the port

				if (sourcePort.getName().equals(constraintPortName)) {
					if (sourceOwner != null && sourceOwner.getName().equals(constraintPortOwner)) {
					} else if (sourceOwner == null && constraintPortOwner == null) {
					} else {
						continue;					
					}
				} else {
					continue;
				}

				// One end is correct, go on with the second
				final Property targetOwner = ends.get(1).getPartWithPort();	// Should be the owner of the port
				final org.eclipse.uml2.uml.Port targetPort = (org.eclipse.uml2.uml.Port) ends.get(1).getRole();	// Should be the port

				if (targetPort.getName().equals(variablePortName)) {
					if (targetOwner != null && targetOwner.getName().equals(variablePortOwner)) {
					} else if (targetOwner == null && variablePortOwner == null) {
					} else {
						continue;
					}
				} else {
					continue;
				}
				
				// Connector found
				return connector;
			}
		}
		return null;
	}
}
