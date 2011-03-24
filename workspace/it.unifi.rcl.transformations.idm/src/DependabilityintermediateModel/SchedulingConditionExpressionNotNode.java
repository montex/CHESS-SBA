/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scheduling Condition Expression Not Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DependabilityintermediateModel.SchedulingConditionExpressionNotNode#getSchedulingConditionExpression <em>Scheduling Condition Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getSchedulingConditionExpressionNotNode()
 * @model
 * @generated
 */
public interface SchedulingConditionExpressionNotNode extends SchedulingConditionExpressionNode {
	/**
	 * Returns the value of the '<em><b>Scheduling Condition Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scheduling Condition Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scheduling Condition Expression</em>' containment reference.
	 * @see #setSchedulingConditionExpression(SchedulingConditionExpressionNode)
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getSchedulingConditionExpressionNotNode_SchedulingConditionExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	SchedulingConditionExpressionNode getSchedulingConditionExpression();

	/**
	 * Sets the value of the '{@link DependabilityintermediateModel.SchedulingConditionExpressionNotNode#getSchedulingConditionExpression <em>Scheduling Condition Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scheduling Condition Expression</em>' containment reference.
	 * @see #getSchedulingConditionExpression()
	 * @generated
	 */
	void setSchedulingConditionExpression(SchedulingConditionExpressionNode value);

} // SchedulingConditionExpressionNotNode
