/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scheduling Condition Expression Detection Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DependabilityintermediateModel.SchedulingConditionExpressionDetectionNode#getError <em>Error</em>}</li>
 * </ul>
 * </p>
 *
 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getSchedulingConditionExpressionDetectionNode()
 * @model
 * @generated
 */
public interface SchedulingConditionExpressionDetectionNode extends SchedulingConditionExpressionNode {
	/**
	 * Returns the value of the '<em><b>Error</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error</em>' reference.
	 * @see #setError(DependabilityintermediateModel.Error)
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getSchedulingConditionExpressionDetectionNode_Error()
	 * @model required="true"
	 * @generated
	 */
	DependabilityintermediateModel.Error getError();

	/**
	 * Sets the value of the '{@link DependabilityintermediateModel.SchedulingConditionExpressionDetectionNode#getError <em>Error</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error</em>' reference.
	 * @see #getError()
	 * @generated
	 */
	void setError(DependabilityintermediateModel.Error value);

} // SchedulingConditionExpressionDetectionNode
