/**
 */
package org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ARINCComponentModelFactoryImpl extends EFactoryImpl implements ARINCComponentModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ARINCComponentModelFactory init() {
		try {
			ARINCComponentModelFactory theARINCComponentModelFactory = (ARINCComponentModelFactory)EPackage.Registry.INSTANCE.getEFactory(ARINCComponentModelPackage.eNS_URI);
			if (theARINCComponentModelFactory != null) {
				return theARINCComponentModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ARINCComponentModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ARINCComponentModelFactoryImpl() {
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
			case ARINCComponentModelPackage.ARINC_COMPONENT_IMPL: return createARINCComponentImpl();
			case ARINCComponentModelPackage.ARINC_PROCESS: return createARINCProcess();
			case ARINCComponentModelPackage.ARINC_FUNCTION: return createARINCFunction();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ARINCComponentImpl createARINCComponentImpl() {
		ARINCComponentImplImpl arincComponentImpl = new ARINCComponentImplImpl();
		return arincComponentImpl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ARINCProcess createARINCProcess() {
		ARINCProcessImpl arincProcess = new ARINCProcessImpl();
		return arincProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ARINCFunction createARINCFunction() {
		ARINCFunctionImpl arincFunction = new ARINCFunctionImpl();
		return arincFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ARINCComponentModelPackage getARINCComponentModelPackage() {
		return (ARINCComponentModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ARINCComponentModelPackage getPackage() {
		return ARINCComponentModelPackage.eINSTANCE;
	}

} //ARINCComponentModelFactoryImpl
