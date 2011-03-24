/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Faults Expression Or Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DependabilityintermediateModel.FaultsExpressionOrNode#getFaultsExpression1 <em>Faults Expression1</em>}</li>
 *   <li>{@link DependabilityintermediateModel.FaultsExpressionOrNode#getFaultsExpression2 <em>Faults Expression2</em>}</li>
 * </ul>
 * </p>
 *
 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getFaultsExpressionOrNode()
 * @model
 * @generated
 */
public interface FaultsExpressionOrNode extends FaultsExpressionNode {
	/**
	 * Returns the value of the '<em><b>Faults Expression1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Faults Expression1</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Faults Expression1</em>' containment reference.
	 * @see #setFaultsExpression1(FaultsExpressionNode)
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getFaultsExpressionOrNode_FaultsExpression1()
	 * @model containment="true" required="true"
	 * @generated
	 */
	FaultsExpressionNode getFaultsExpression1();

	/**
	 * Sets the value of the '{@link DependabilityintermediateModel.FaultsExpressionOrNode#getFaultsExpression1 <em>Faults Expression1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Faults Expression1</em>' containment reference.
	 * @see #getFaultsExpression1()
	 * @generated
	 */
	void setFaultsExpression1(FaultsExpressionNode value);

	/**
	 * Returns the value of the '<em><b>Faults Expression2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Faults Expression2</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Faults Expression2</em>' containment reference.
	 * @see #setFaultsExpression2(FaultsExpressionNode)
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getFaultsExpressionOrNode_FaultsExpression2()
	 * @model containment="true" required="true"
	 * @generated
	 */
	FaultsExpressionNode getFaultsExpression2();

	/**
	 * Sets the value of the '{@link DependabilityintermediateModel.FaultsExpressionOrNode#getFaultsExpression2 <em>Faults Expression2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Faults Expression2</em>' containment reference.
	 * @see #getFaultsExpression2()
	 * @generated
	 */
	void setFaultsExpression2(FaultsExpressionNode value);

} // FaultsExpressionOrNode
