/**
 */
package org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.ARINCComponentModelPackage
 * @generated
 */
public interface ARINCComponentModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ARINCComponentModelFactory eINSTANCE = org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.impl.ARINCComponentModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>ARINC Component Impl</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ARINC Component Impl</em>'.
	 * @generated
	 */
	ARINCComponentImpl createARINCComponentImpl();

	/**
	 * Returns a new object of class '<em>ARINC Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ARINC Process</em>'.
	 * @generated
	 */
	ARINCProcess createARINCProcess();

	/**
	 * Returns a new object of class '<em>ARINC Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ARINC Function</em>'.
	 * @generated
	 */
	ARINCFunction createARINCFunction();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ARINCComponentModelPackage getARINCComponentModelPackage();

} //ARINCComponentModelFactory
