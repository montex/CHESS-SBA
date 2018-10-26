/**
 */
package org.polarsys.chess.patterns.profile.PatternsProfile;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.patterns.profile.PatternsProfile.PatternsProfilePackage
 * @generated
 */
public interface PatternsProfileFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PatternsProfileFactory eINSTANCE = org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternsProfileFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pattern</em>'.
	 * @generated
	 */
	Pattern createPattern();

	/**
	 * Returns a new object of class '<em>Pattern Application</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pattern Application</em>'.
	 * @generated
	 */
	PatternApplication createPatternApplication();

	/**
	 * Returns a new object of class '<em>Pattern Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pattern Role</em>'.
	 * @generated
	 */
	PatternRole createPatternRole();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PatternsProfilePackage getPatternsProfilePackage();

} //PatternsProfileFactory
