/**
 */
package org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.polarsys.chess.chessmlprofile.ParameterizedArchitecture.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ParameterizedArchitectureFactoryImpl extends EFactoryImpl implements ParameterizedArchitectureFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ParameterizedArchitectureFactory init() {
		try {
			ParameterizedArchitectureFactory theParameterizedArchitectureFactory = (ParameterizedArchitectureFactory)EPackage.Registry.INSTANCE.getEFactory(ParameterizedArchitecturePackage.eNS_URI);
			if (theParameterizedArchitectureFactory != null) {
				return theParameterizedArchitectureFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ParameterizedArchitectureFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterizedArchitectureFactoryImpl() {
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
			case ParameterizedArchitecturePackage.INSTANTIATED_BY: return createInstantiatedBy();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstantiatedBy createInstantiatedBy() {
		InstantiatedByImpl instantiatedBy = new InstantiatedByImpl();
		return instantiatedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterizedArchitecturePackage getParameterizedArchitecturePackage() {
		return (ParameterizedArchitecturePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ParameterizedArchitecturePackage getPackage() {
		return ParameterizedArchitecturePackage.eINSTANCE;
	}

} //ParameterizedArchitectureFactoryImpl
