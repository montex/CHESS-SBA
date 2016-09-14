/*******************************************************************************
 *                  CHESS core plugin
 *
 *               Copyright (C) 2011-2015
 *            Mälardalen University, Sweden
 *
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License
 *  v1.0 which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.polarsys.chess.fla.flamm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polarsys.chess.fla.flamm.analysis.FlaSystem;

import com.google.common.collect.Sets;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.fla.flamm.SimpleComponent#getRules <em>Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleComponent extends Component {
	/**
	 * The cached value of the '{@link #getRules() <em>Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRules()
	 * @generated
	 * @ordered
	 */
	protected EList<Rule> rules;

	List<Set<PortFailureTuple>> propagatedInputPortFailures = null;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleComponent() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FlammPackage.Literals.SIMPLE_COMPONENT;
	}

	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
	 * The list contents are of type {@link org.polarsys.chess.fla.flamm.Rule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference list.
	 * @generated
	 */
	public List<Rule> getRules() {
		if (rules == null) {
			rules = new BasicInternalEList<Rule>(Rule.class);
		}
		return rules;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FlammPackage.SIMPLE_COMPONENT__INPUT_PORTS:
				return ((InternalEList<?>)getInputPorts()).basicRemove(otherEnd, msgs);
			case FlammPackage.SIMPLE_COMPONENT__OUTPUT_PORTS:
				return ((InternalEList<?>)getOutputPorts()).basicRemove(otherEnd, msgs);
			case FlammPackage.SIMPLE_COMPONENT__PARENT:
				return basicSetParent(null, msgs);
			case FlammPackage.SIMPLE_COMPONENT__RULES:
				return ((InternalEList<?>)getRules()).basicRemove(otherEnd, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
	}

	private List<Set<PortFailureTuple>> getPropagatedInputPortFailures() {
		if (propagatedInputPortFailures == null) {
			propagatedInputPortFailures = new ArrayList<Set<PortFailureTuple>>();
			for (int i = 0; i < getInputPorts().size(); i++) {
				propagatedInputPortFailures.add(new HashSet<PortFailureTuple>());
			}
		}
		return propagatedInputPortFailures;
	}
	
	@Override
	public void propagateFailures() {
		propagateInputFailures();
		propagateOutputFailures();
	}
	
	/**
	 * Calculates Cartesian product (cross product / all combinations) for the input ports failures.<br/>
	 * These combinations are used to match and fire transformation rules.
	 * <p>The combinations of propagated combinations are updated.
	 */
	void propagateInputFailures() {
		
		for (int i = 0; i < inputPorts.size(); i++) {
			Port port = inputPorts.get(i);
			Set<PortFailureTuple> newPortFailures = PortFailureTuple.fromCollection(port, port.getNewFailures());
			Set<PortFailureTuple> oldPortFailures = getPropagatedInputPortFailures().get(i);
			propagatedInputPortFailures.set(i, newPortFailures);
			Set<List<PortFailureTuple>> newFailureCombinations = getNewInputFailureCombinations(propagatedInputPortFailures);
			for (List<PortFailureTuple> portFailureCombination : newFailureCombinations) {
				propagateFailureCombination(portFailureCombination);
			}
			port.clearNewFailures();
			propagatedInputPortFailures.set(i, Sets.union(oldPortFailures, newPortFailures));
		}
	}
	
	/**
	 * New failures on output ports are propagated to all connected ports.
	 */
	protected void propagateOutputFailures() {
		for (Port port : outputPorts) {
			for (Failure failure : port.getNewFailures()) {
				for (Port connectedPort : port.getConnectedPorts()) {
					if (connectedPort.addFailure(failure, failure)) {
						FlaSystem.addUpdatedComponent(connectedPort.getOwner());
					}
				}
			}
			port.clearNewFailures();
		}
	}
	
	Set<List<PortFailureTuple>> getNewInputFailureCombinations(List<Set<PortFailureTuple>> failures) {
		Set<List<PortFailureTuple>> failureCombinations = Sets.cartesianProduct(failures);
		return failureCombinations;
	}
	
	/**
	 * Propagates a list of port-failure combinations via transformation rules to corresponding output ports.
	 * <p>If no rule matches {@link #HandleUnmatchedFailureCombination} is called.
	 * @param failuresetToMatch
	 */
	void propagateFailureCombination(List<PortFailureTuple> failuresetToMatch) {
		List<Rule> rules = getMostSpecificMatchingRules(failuresetToMatch);
		if (rules != null && !rules.isEmpty()) {
			List<Failure> previousFailures = portfailuresToFailureList(failuresetToMatch);
			for(Rule rule : rules) {
				rule.fire(previousFailures);
			}
		} else {
			HandleUnmatchedFailureCombination(failuresetToMatch);
		}
	}
	
	List<Failure> portfailuresToFailureList(List<PortFailureTuple> failureSet) {
		List<Failure> failures = new ArrayList<Failure>();
		for (PortFailureTuple portFailure : failureSet) {
			failures.add(portFailure.getFailure());
		}
		return failures;
	}

	protected void HandleUnmatchedFailureCombination(List<PortFailureTuple> failuresetToMatch) {
		if (FlaSystem.propagateUnmatchedFailures()) {
			for (Port port : outputPorts) {
				for (PortFailureTuple portFailure : failuresetToMatch) {
					port.addFailure(portFailure.getFailure(), portFailure.getFailure());
				}
			}
		} else {
			// TODO: alert user
			log("Unmatched failure set: " + failuresetToMatch);
		}
	}

	List<Rule> getMostSpecificMatchingRules(List<PortFailureTuple> failuresetToMatch) {
		List<Rule> matchingRules = getAllMatchingRules(failuresetToMatch);
		if (matchingRules == null || matchingRules.isEmpty()) {
			return null;
		}
		
		int highestSpecificity = matchingRules.get(0).getSpecificity();
		for (Rule matchingRule : matchingRules) {
			if (matchingRule.getSpecificity() > highestSpecificity) {
				highestSpecificity = matchingRule.getSpecificity();
			}
		}
		
		List<Rule> mostSpecificRules = new ArrayList<Rule>();
		for (Rule matchingRule : matchingRules) {
			if (matchingRule.getSpecificity() == highestSpecificity) {
				mostSpecificRules.add(matchingRule);
			}
		}
		return mostSpecificRules;
	}
	
	List<Rule> getAllMatchingRules(List<PortFailureTuple> failuresetToMatch) {
		List<Rule> matchingRules = new ArrayList<Rule>();
		if (this.rules != null) {
			for (Rule rule : rules) {
				if (rule.matchFailure(failuresetToMatch)) {
					matchingRules.add(rule);
				}
			}
		}
		
		return matchingRules;
	}
	
	protected void log(String message) {
		// TODO: implement
//		if (logger != null) {
//			logger.logWarning(message);
//		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FlammPackage.SIMPLE_COMPONENT__ID:
				return getId();
			case FlammPackage.SIMPLE_COMPONENT__NAME:
				return getName();
			case FlammPackage.SIMPLE_COMPONENT__INPUT_PORTS:
				return getInputPorts();
			case FlammPackage.SIMPLE_COMPONENT__OUTPUT_PORTS:
				return getOutputPorts();
			case FlammPackage.SIMPLE_COMPONENT__PARENT:
				return getParent();
			case FlammPackage.SIMPLE_COMPONENT__RULES:
				return getRules();
		}
		return eDynamicGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FlammPackage.SIMPLE_COMPONENT__ID:
				setId((String)newValue);
				return;
			case FlammPackage.SIMPLE_COMPONENT__NAME:
				setName((String)newValue);
				return;
			case FlammPackage.SIMPLE_COMPONENT__INPUT_PORTS:
				getInputPorts().clear();
				getInputPorts().addAll((Collection<? extends Port>)newValue);
				return;
			case FlammPackage.SIMPLE_COMPONENT__OUTPUT_PORTS:
				getOutputPorts().clear();
				getOutputPorts().addAll((Collection<? extends Port>)newValue);
				return;
			case FlammPackage.SIMPLE_COMPONENT__PARENT:
				setParent((CompositeComponent)newValue);
				return;
			case FlammPackage.SIMPLE_COMPONENT__RULES:
				getRules().clear();
				getRules().addAll((Collection<? extends Rule>)newValue);
				return;
		}
		eDynamicSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case FlammPackage.SIMPLE_COMPONENT__ID:
				setId(ID_EDEFAULT);
				return;
			case FlammPackage.SIMPLE_COMPONENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case FlammPackage.SIMPLE_COMPONENT__INPUT_PORTS:
				getInputPorts().clear();
				return;
			case FlammPackage.SIMPLE_COMPONENT__OUTPUT_PORTS:
				getOutputPorts().clear();
				return;
			case FlammPackage.SIMPLE_COMPONENT__PARENT:
				setParent((CompositeComponent)null);
				return;
			case FlammPackage.SIMPLE_COMPONENT__RULES:
				getRules().clear();
				return;
		}
		eDynamicUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FlammPackage.SIMPLE_COMPONENT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case FlammPackage.SIMPLE_COMPONENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FlammPackage.SIMPLE_COMPONENT__INPUT_PORTS:
				return inputPorts != null && !inputPorts.isEmpty();
			case FlammPackage.SIMPLE_COMPONENT__OUTPUT_PORTS:
				return outputPorts != null && !outputPorts.isEmpty();
			case FlammPackage.SIMPLE_COMPONENT__PARENT:
				return getParent() != null;
			case FlammPackage.SIMPLE_COMPONENT__RULES:
				return rules != null && !rules.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

} // SimpleComponent
