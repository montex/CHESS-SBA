/**
 */
package org.polarsys.chess.chessmlprofile.ParameterizedArchitecture;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.ParameterizedArchitecturePackage
 * @generated
 */
public interface ParameterizedArchitectureFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ParameterizedArchitectureFactory eINSTANCE = org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.impl.ParameterizedArchitectureFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Instantiated Architecture</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instantiated Architecture</em>'.
	 * @generated
	 */
	InstantiatedArchitecture createInstantiatedArchitecture();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ParameterizedArchitecturePackage getParameterizedArchitecturePackage();

} //ParameterizedArchitectureFactory
