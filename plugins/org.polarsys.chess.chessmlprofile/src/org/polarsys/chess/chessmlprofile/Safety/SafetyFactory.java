/**
 */
package org.polarsys.chess.chessmlprofile.Safety;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.chessmlprofile.Safety.SafetyPackage
 * @generated
 */
public interface SafetyFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SafetyFactory eINSTANCE = org.polarsys.chess.chessmlprofile.Safety.impl.SafetyFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Criticality Interface Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Criticality Interface Specification</em>'.
	 * @generated
	 */
	CriticalityInterfaceSpecification createCriticalityInterfaceSpecification();

	/**
	 * Returns a new object of class '<em>Criticality Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Criticality Specification</em>'.
	 * @generated
	 */
	CriticalitySpecification createCriticalitySpecification();

	/**
	 * Returns a new object of class '<em>Criticality Level</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Criticality Level</em>'.
	 * @generated
	 */
	CriticalityLevel createCriticalityLevel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SafetyPackage getSafetyPackage();

} //SafetyFactory
