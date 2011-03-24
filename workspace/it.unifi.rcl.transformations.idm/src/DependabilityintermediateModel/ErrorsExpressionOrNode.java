/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Errors Expression Or Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DependabilityintermediateModel.ErrorsExpressionOrNode#getErrorsExpression1 <em>Errors Expression1</em>}</li>
 *   <li>{@link DependabilityintermediateModel.ErrorsExpressionOrNode#getErrorsExpression2 <em>Errors Expression2</em>}</li>
 * </ul>
 * </p>
 *
 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getErrorsExpressionOrNode()
 * @model
 * @generated
 */
public interface ErrorsExpressionOrNode extends ErrorsExpressionNode {
	/**
	 * Returns the value of the '<em><b>Errors Expression1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Errors Expression1</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Errors Expression1</em>' containment reference.
	 * @see #setErrorsExpression1(ErrorsExpressionNode)
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getErrorsExpressionOrNode_ErrorsExpression1()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ErrorsExpressionNode getErrorsExpression1();

	/**
	 * Sets the value of the '{@link DependabilityintermediateModel.ErrorsExpressionOrNode#getErrorsExpression1 <em>Errors Expression1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Errors Expression1</em>' containment reference.
	 * @see #getErrorsExpression1()
	 * @generated
	 */
	void setErrorsExpression1(ErrorsExpressionNode value);

	/**
	 * Returns the value of the '<em><b>Errors Expression2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Errors Expression2</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Errors Expression2</em>' containment reference.
	 * @see #setErrorsExpression2(ErrorsExpressionNode)
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getErrorsExpressionOrNode_ErrorsExpression2()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ErrorsExpressionNode getErrorsExpression2();

	/**
	 * Sets the value of the '{@link DependabilityintermediateModel.ErrorsExpressionOrNode#getErrorsExpression2 <em>Errors Expression2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Errors Expression2</em>' containment reference.
	 * @see #getErrorsExpression2()
	 * @generated
	 */
	void setErrorsExpression2(ErrorsExpressionNode value);

} // ErrorsExpressionOrNode
