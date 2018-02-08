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
package org.polarsys.chess.smvExport.model;

import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.sysml.portandflows.FlowDirection;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.Vertex;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;

import eu.fbk.eclipse.standardtools.StateMachineTranslatorToSmv.stateMachineModel.AbstractStateMachineModel;

public class UMLStateMachineModel implements AbstractStateMachineModel {

	private static UMLStateMachineModel umlStateMachineModel;
	private EntityUtil entityUtil = EntityUtil.getInstance();

	public static UMLStateMachineModel getInstance() {
		if (umlStateMachineModel == null) {
			umlStateMachineModel = new UMLStateMachineModel();
		}
		return umlStateMachineModel;
	}

	@Override
	public EList<Port> getOwnerInputPortsExceptEvents(Object stateMachine) {
		Element owner = ((StateMachine) stateMachine).getOwner();
		return new BasicEList<Port>(entityUtil.getUmlPortsExceptEvents(owner, FlowDirection.IN_VALUE));
	}

	@Override
	public EList<Port> getOwnerOutputPortsExceptEvents(Object stateMachine) {
		Element owner = ((StateMachine) stateMachine).getOwner();
		return new BasicEList<Port>(entityUtil.getUmlPortsExceptEvents(owner, FlowDirection.OUT_VALUE));
	}

	@Override
	public EList<Element> getOwnerAttributes(Object stateMachine) {
		Element owner = ((StateMachine) stateMachine).getOwner();
		return new BasicEList<Element>(entityUtil.getAttributesExceptPorts(owner));
	}

	@Override
	public EList<String> getTransitionsNameList(Object stateMachine) throws Exception {
		return entityUtil.getTransitionNameList(entityUtil.getTranstitions((StateMachine) stateMachine));
	}

	@Override
	public EList<String> getEventsNameList(Object stateMachine) {
		EList<Port> events = entityUtil.getEventPorts(((StateMachine) stateMachine).getOwner());

		return (entityUtil.getPortsName(events));
	}

	@Override
	public String getStateMachineName(Object stateMachine) {
		return (entityUtil.getStateMachineName((StateMachine) stateMachine));
	}

	@Override
	public EList<Transition> getStartTransitions(Object stateMachine) throws Exception {
		return entityUtil.getInitialTransitions((StateMachine) stateMachine);
	}

	@Override
	public EList<Transition> getNonStartTransitions(Object stateMachine) {
		return entityUtil.getNonInitialTransitions((StateMachine) stateMachine);
	}

	@Override
	public EList<String> getIntermediateStatesNameList(Object stateMachine) {
		EList<Vertex> states = entityUtil.getIntermediateStates((StateMachine) stateMachine);
		return entityUtil.getStatesNameList(states);
	}

	@Override
	public String getTransitionName(Object transition) {
		return entityUtil.getTransitionName((Transition) transition);
	}

	@Override
	public String getTransitionNextStateName(Object transition) {
		Vertex nextState = entityUtil.getTransitionNextState((Transition) transition);
		return entityUtil.getStateName(nextState);
	}

	@Override
	public String getTransitionStartStateName(Object transition) {
		Vertex sourceState = entityUtil.getTransitionSourceState((Transition) transition);
		return entityUtil.getStateName(sourceState);
	}

	@Override
	public EList<String> getTransitionEventsName(Object transition) {
		EList<Port> events = entityUtil.getTransitionEvents((Transition) transition);
		if (events != null) {
			return entityUtil.getPortsName(events);
		}
		return null;
	}

	@Override
	public String getTransitionGuardCondition(Object transition) {
		Constraint condition = entityUtil.getTransitionGuard((Transition) transition);
		if (condition != null) {
			return entityUtil.getConditionExpression(condition);
		}
		return null;
	}

	@Override
	public boolean isFinalTransition(Object transition) {
		return entityUtil.isFinalTransition((Transition) transition);

	}

	@Override
	public boolean isTransitionWithNoEvent(Object transition) {
		return entityUtil.isTransitionWithNoEvent((Transition) transition);
	}

	@Override
	public String getVariableName(Object variable) {
		return ((Property) variable).getName();
	}

	@Override
	public Object getVariableType(Object variable) {
		return entityUtil.getUmlType((Property) variable);
	}

	@Override
	public boolean isBooleanType(Object type) {
		return entityUtil.isBooleanType((Type) type);
	}

	@Override
	public boolean isIntegerType(Object type) {
		return entityUtil.isIntegerType((Type) type);
	}

	@Override
	public boolean isRealType(Object type) {
		return entityUtil.isRealType((Type) type);
	}

	@Override
	public boolean isIntervalType(Object type) {
		return entityUtil.isRangeType((Type) type);
	}

	@Override
	public String[] getLowHighIntervalType(Object type) {
		return entityUtil.getLowerUpperBoundsForRangeType((Type) type);
	}

	@Override
	public EList<String> getEnumValues(Object type) {
		return new BasicEList<String>(entityUtil.getListValuesForEnumeratorType((Type) type));
	}

	@Override
	public boolean isEnumType(Object type) {
		return entityUtil.isEnumerationType((Type) type);
	}

	@Override
	public String getStateMachineOwnerName(Object stateMachine) {
		return ((org.eclipse.uml2.uml.Class) entityUtil.getOwner((StateMachine) stateMachine)).getName();
	}

	@Override
	public String getTransitionEffectText(Object transition) {
		return entityUtil.getTransitionEffectText((Transition) transition);
	}

	@Override
	public Set<StateMachine> getNominalStateMachinesIncludingFromSubComponents(Object umlSelectedComponent) {
		return entityUtil.getNominalStateMachines((org.eclipse.uml2.uml.Class) umlSelectedComponent, true);
	}

	@Override
	public Set<StateMachine> getAllStateMachinesFromModel(Object model) {
		return entityUtil.getNominalStateMachines((UmlModel) model);
	}

	@Override
	public Object getFirstNominalStateMachine(Object umlSelectedComponent) {
		return entityUtil.getFirstNominalStateMachine((org.eclipse.uml2.uml.Class) umlSelectedComponent);
	}

	@Override
	public Object getStateMachineOwner(Object stateMachine) {
		return entityUtil.getOwner((StateMachine) stateMachine);

	}

}
