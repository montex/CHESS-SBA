/**
 */
package org.polarsys.chess.contracts.profile.chesscontract.DataTypes;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 * @see org.polarsys.chess.contracts.profile.chesscontract.DataTypes.DataTypesPackage
 * @generated
 */
public interface DataTypesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	DataTypesFactory eINSTANCE = org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl.DataTypesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Othello Constraint</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Othello Constraint</em>'.
	 * @generated
	 */
	OthelloConstraint createOthelloConstraint();

	/**
	 * Returns a new object of class '<em>Continuous</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Continuous</em>'.
	 * @generated
	 */
	Continuous createContinuous();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DataTypesPackage getDataTypesPackage();

} // DataTypesFactory
