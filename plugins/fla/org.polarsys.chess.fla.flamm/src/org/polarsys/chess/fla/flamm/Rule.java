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

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polarsys.chess.fla.flamm.FailureTypes.FailureType;
import org.polarsys.chess.fla.flamm.analysis.FlaSystem;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.fla.flamm.Rule#getInputExpression <em>Input Expression</em>}</li>
 *   <li>{@link org.polarsys.chess.fla.flamm.Rule#getOutputExpression <em>Output Expression</em>}</li>
 *   <li>{@link org.polarsys.chess.fla.flamm.Rule#getSpecificity <em>Specificity</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.fla.flamm.FlammPackage#getRule()
 * @model kind="class"
 * @generated
 */
public class Rule extends MinimalEObjectImpl.Container implements EObject {
	/**
	 * The cached value of the '{@link #getInputExpression() <em>Input Expression</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputExpression()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> inputExpression;

	/**
	 * The cached value of the '{@link #getOutputExpression() <em>Output Expression</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputExpression()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> outputExpression;
	
	/**
	 * Used to keep information about failure types matched to variables.
	 */
	private transient Map<String, Failure> variableAssignments = new HashMap<String, Failure>();
	
	/**
	 * The default value of the '{@link #getSpecificity() <em>Specificity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecificity()
	 * @generated
	 * @ordered
	 */
	protected static final int SPECIFICITY_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getSpecificity() <em>Specificity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecificity()
	 * @generated
	 * @ordered
	 */
	protected int specificity = SPECIFICITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FlammPackage.Literals.RULE;
	}

	/**
	 * Returns the value of the '<em><b>Input Expression</b></em>' containment reference list.
	 * The list contents are of type {@link org.polarsys.chess.fla.flamm.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Expression</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Expression</em>' containment reference list.
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getRule_InputExpression()
	 * @model containment="true"
	 * @generated
	 */
	public List<Expression> getInputExpression() {
		if (inputExpression == null) {
			inputExpression = new EObjectContainmentEList<Expression>(Expression.class, this, FlammPackage.RULE__INPUT_EXPRESSION);
		}
		return inputExpression;
	}

	/**
	 * Returns the value of the '<em><b>Output Expression</b></em>' containment reference list.
	 * The list contents are of type {@link org.polarsys.chess.fla.flamm.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Expression</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Expression</em>' containment reference list.
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getRule_OutputExpression()
	 * @model containment="true"
	 * @generated
	 */
	public List<Expression> getOutputExpression() {
		if (outputExpression == null) {
			outputExpression = new EObjectContainmentEList<Expression>(Expression.class, this, FlammPackage.RULE__OUTPUT_EXPRESSION);
		}
		return outputExpression;
	}

	/**
	 * Returns the value of the '<em><b>Specificity</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specificity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specificity</em>' attribute.
	 * @see #setSpecificity(int)
	 * @generated NOT
	 */
	public int getSpecificity() {
		if (specificity == -1) {
			calculateSpecificity();
		}
		return specificity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FlammPackage.RULE__INPUT_EXPRESSION:
				return ((InternalEList<?>)getInputExpression()).basicRemove(otherEnd, msgs);
			case FlammPackage.RULE__OUTPUT_EXPRESSION:
				return ((InternalEList<?>)getOutputExpression()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	protected void calculateSpecificity() {
		int calculatedSpecificity = 0;
		for (Expression inputExpression : inputExpression) {
			if (!expressionContainsVariableOrWildcard(inputExpression)) {
				calculatedSpecificity++;
			}
		}
		this.specificity = calculatedSpecificity;
	}
	
	private boolean expressionContainsVariableOrWildcard(Expression expression) {
		for (Failure failure : expression.getFailures()) {
			if (FailureType.WILDCARD == failure.getType() || FailureType.VARIABLE == failure.getType()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Check if the list of failures are matched by this rule.
	 * @param failuresetToMatch list of PortFailureTuples to check
	 * @return <code>true</code> if this rule is covering the failuresetToMatch failures
	 */
	public boolean matchFailure(List<PortFailureTuple> failuresetToMatch) {
		variableAssignments.clear();
		for (PortFailureTuple failureTupleToMatch : failuresetToMatch) {
			Expression portInputExpression = getInputExpressionForPort(failureTupleToMatch.getPort());
			if (portInputExpression == null || portInputExpression.getFailures().isEmpty()) {
				// port not present in this transformation rule
				// treat as wildcard
				if (FlaSystem.treatUnmentionedPortsAsWildcards()){
					continue;
				} else {
					// TODO: warn user
					return false;
				}
			}
			
			List<Failure> rulePortFailures = portInputExpression.getFailures();
			boolean match = false;
			for (Failure ruleFailure : rulePortFailures) {
				if (ruleFailure.getType() == FailureType.WILDCARD) {
					match = true;
					break;
				} else if (ruleFailure.getType() == FailureType.VARIABLE) {
					Failure prevVariableAssignment = variableAssignments.get(ruleFailure.getId());
					if (prevVariableAssignment != null && ! prevVariableAssignment.isSameFailure(failureTupleToMatch.getFailure())) {
						// The same variable cannot map to different failure types simultaneously
						continue;
					}
					variableAssignments.put(ruleFailure.getId(), failureTupleToMatch.getFailure());
					match = true;
					break;
				} else if (ruleFailure.isSameFailure(failureTupleToMatch.getFailure())) {
					match = true;
					break;
				}
			}
			if (!match) {
				// Failure is not matched with rule for current port.
				return false;
			}
		}
		return true;
	}
	
	protected Expression getInputExpressionForPort(Port port) {
		return getExpressionForPort(inputExpression, port);
	}
	
	protected Expression getOutputExpressionForPort(Port port) {
		return getExpressionForPort(outputExpression, port);
	}
	
	private Expression getExpressionForPort(List<Expression> expressions, Port port) {
		if (port != null) {
			for (Expression expression : expressions) {
				if (port.equals(expression.getPort())) {
					return expression;
				}
			}
		}
		return null;
	}
	
	/**
	 * Transform and propagate failures to the output ports according to this rule.
	 */
	public void fire() {
		for (Expression expression : getOutputExpression()) {
			Port port = expression.getPort();
			for (Failure failure : expression.getFailures()) {
				if (failure.getType() == FailureType.VARIABLE) {
					port.addFailure(variableAssignments.get(failure.getId()));
				} else {
					port.addFailure(failure);
				}
			}
		}
	}

	/**
	 * Transform and propagate failures to the output ports according to this rule.
	 */
	public void fire(Collection<Failure> previousFailures) {
		for (Expression expression : getOutputExpression()) {
			Port port = expression.getPort();
			for (Failure failure : expression.getFailures()) {
				if (failure.getType() == FailureType.VARIABLE) {
					port.addFailure(variableAssignments.get(failure.getId()), previousFailures);
				} else {
					port.addFailure(failure, previousFailures);
				}
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FlammPackage.RULE__INPUT_EXPRESSION:
				return getInputExpression();
			case FlammPackage.RULE__OUTPUT_EXPRESSION:
				return getOutputExpression();
			case FlammPackage.RULE__SPECIFICITY:
				return getSpecificity();
		}
		return super.eGet(featureID, resolve, coreType);
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
			case FlammPackage.RULE__INPUT_EXPRESSION:
				getInputExpression().clear();
				getInputExpression().addAll((Collection<? extends Expression>)newValue);
				return;
			case FlammPackage.RULE__OUTPUT_EXPRESSION:
				getOutputExpression().clear();
				getOutputExpression().addAll((Collection<? extends Expression>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case FlammPackage.RULE__INPUT_EXPRESSION:
				getInputExpression().clear();
				return;
			case FlammPackage.RULE__OUTPUT_EXPRESSION:
				getOutputExpression().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FlammPackage.RULE__INPUT_EXPRESSION:
				return inputExpression != null && !inputExpression.isEmpty();
			case FlammPackage.RULE__OUTPUT_EXPRESSION:
				return outputExpression != null && !outputExpression.isEmpty();
			case FlammPackage.RULE__SPECIFICITY:
				return specificity != SPECIFICITY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (specificity: ");
		result.append(specificity);
		result.append(')');
		return result.toString();
	}

} // Rule
