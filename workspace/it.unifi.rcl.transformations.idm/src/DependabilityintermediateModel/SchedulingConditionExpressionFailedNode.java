/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scheduling Condition Expression Failed Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DependabilityintermediateModel.SchedulingConditionExpressionFailedNode#getFailureMode <em>Failure Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getSchedulingConditionExpressionFailedNode()
 * @model
 * @generated
 */
public interface SchedulingConditionExpressionFailedNode extends SchedulingConditionExpressionNode {
	/**
	 * Returns the value of the '<em><b>Failure Mode</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Failure Mode</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Failure Mode</em>' reference.
	 * @see #setFailureMode(FailureMode)
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getSchedulingConditionExpressionFailedNode_FailureMode()
	 * @model required="true"
	 * @generated
	 */
	FailureMode getFailureMode();

	/**
	 * Sets the value of the '{@link DependabilityintermediateModel.SchedulingConditionExpressionFailedNode#getFailureMode <em>Failure Mode</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Failure Mode</em>' reference.
	 * @see #getFailureMode()
	 * @generated
	 */
	void setFailureMode(FailureMode value);

} // SchedulingConditionExpressionFailedNode
