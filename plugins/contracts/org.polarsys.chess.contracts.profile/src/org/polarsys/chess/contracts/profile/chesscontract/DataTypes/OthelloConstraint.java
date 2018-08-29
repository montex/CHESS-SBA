/**
 */
package org.polarsys.chess.contracts.profile.chesscontract.DataTypes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Othello
 * Constraint</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.OthelloConstraint#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.DataTypesPackage#getOthelloConstraint()
 * @model
 * @generated
 */
public interface OthelloConstraint extends EObject {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Expression</em>' attribute.
	 * @see #setExpression(String)
	 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.DataTypesPackage#getOthelloConstraint_Expression()
	 * @model dataType="org.eclipse.uml2.types.String" required="true"
	 *        ordered="false"
	 * @generated
	 */
	String getExpression();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.contracts.profile.chesscontract.DataTypes.OthelloConstraint#getExpression <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' attribute.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(String value);

} // OthelloConstraint
