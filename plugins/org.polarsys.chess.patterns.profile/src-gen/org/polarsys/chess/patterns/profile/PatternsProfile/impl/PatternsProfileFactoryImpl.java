/**
 */
package org.polarsys.chess.patterns.profile.PatternsProfile.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.polarsys.chess.patterns.profile.PatternsProfile.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PatternsProfileFactoryImpl extends EFactoryImpl implements PatternsProfileFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PatternsProfileFactory init() {
		try {
			PatternsProfileFactory thePatternsProfileFactory = (PatternsProfileFactory)EPackage.Registry.INSTANCE.getEFactory(PatternsProfilePackage.eNS_URI);
			if (thePatternsProfileFactory != null) {
				return thePatternsProfileFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PatternsProfileFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternsProfileFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case PatternsProfilePackage.PATTERN: return createPattern();
			case PatternsProfilePackage.PATTERN_APPLICATION: return createPatternApplication();
			case PatternsProfilePackage.PATTERN_ROLE: return createPatternRole();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern createPattern() {
		PatternImpl pattern = new PatternImpl();
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternApplication createPatternApplication() {
		PatternApplicationImpl patternApplication = new PatternApplicationImpl();
		return patternApplication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternRole createPatternRole() {
		PatternRoleImpl patternRole = new PatternRoleImpl();
		return patternRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternsProfilePackage getPatternsProfilePackage() {
		return (PatternsProfilePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PatternsProfilePackage getPackage() {
		return PatternsProfilePackage.eINSTANCE;
	}

} //PatternsProfileFactoryImpl
