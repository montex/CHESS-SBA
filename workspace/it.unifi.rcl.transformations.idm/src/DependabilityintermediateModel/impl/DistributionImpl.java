/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel.impl;

import DependabilityintermediateModel.DependabilityintermediateModelPackage;
import DependabilityintermediateModel.Distribution;
import DependabilityintermediateModel.Sistema;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Distribution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link DependabilityintermediateModel.impl.DistributionImpl#getSistema <em>Sistema</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DistributionImpl extends EObjectImpl implements Distribution {
	/**
	 * The cached value of the '{@link #getSistema() <em>Sistema</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSistema()
	 * @generated
	 * @ordered
	 */
	protected Sistema sistema;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DistributionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DependabilityintermediateModelPackage.Literals.DISTRIBUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sistema getSistema() {
		if (sistema != null && sistema.eIsProxy()) {
			InternalEObject oldSistema = (InternalEObject)sistema;
			sistema = (Sistema)eResolveProxy(oldSistema);
			if (sistema != oldSistema) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DependabilityintermediateModelPackage.DISTRIBUTION__SISTEMA, oldSistema, sistema));
			}
		}
		return sistema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sistema basicGetSistema() {
		return sistema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSistema(Sistema newSistema) {
		Sistema oldSistema = sistema;
		sistema = newSistema;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.DISTRIBUTION__SISTEMA, oldSistema, sistema));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DependabilityintermediateModelPackage.DISTRIBUTION__SISTEMA:
				if (resolve) return getSistema();
				return basicGetSistema();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DependabilityintermediateModelPackage.DISTRIBUTION__SISTEMA:
				setSistema((Sistema)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DependabilityintermediateModelPackage.DISTRIBUTION__SISTEMA:
				setSistema((Sistema)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DependabilityintermediateModelPackage.DISTRIBUTION__SISTEMA:
				return sistema != null;
		}
		return super.eIsSet(featureID);
	}

} //DistributionImpl
