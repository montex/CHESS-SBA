/**
 */
package org.polarsys.chess.chessmlprofile.SystemModel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.polarsys.chess.chessmlprofile.SystemModel.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SystemModelFactoryImpl extends EFactoryImpl implements SystemModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SystemModelFactory init() {
		try {
			SystemModelFactory theSystemModelFactory = (SystemModelFactory)EPackage.Registry.INSTANCE.getEFactory(SystemModelPackage.eNS_URI);
			if (theSystemModelFactory != null) {
				return theSystemModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SystemModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemModelFactoryImpl() {
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
			case SystemModelPackage.HUMAN: return createHuman();
			case SystemModelPackage.ORGANIZATIONAL: return createOrganizational();
			case SystemModelPackage.TECHNOLOGICAL: return createTechnological();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Human createHuman() {
		HumanImpl human = new HumanImpl();
		return human;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Organizational createOrganizational() {
		OrganizationalImpl organizational = new OrganizationalImpl();
		return organizational;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Technological createTechnological() {
		TechnologicalImpl technological = new TechnologicalImpl();
		return technological;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemModelPackage getSystemModelPackage() {
		return (SystemModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SystemModelPackage getPackage() {
		return SystemModelPackage.eINSTANCE;
	}

} //SystemModelFactoryImpl
