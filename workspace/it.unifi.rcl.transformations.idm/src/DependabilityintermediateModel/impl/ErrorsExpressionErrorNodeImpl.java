/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel.impl;

import DependabilityintermediateModel.DependabilityintermediateModelPackage;
import DependabilityintermediateModel.ErrorsExpressionErrorNode;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Errors Expression Error Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link DependabilityintermediateModel.impl.ErrorsExpressionErrorNodeImpl#getError <em>Error</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ErrorsExpressionErrorNodeImpl extends ErrorsExpressionNodeImpl implements ErrorsExpressionErrorNode {
	/**
	 * The cached value of the '{@link #getError() <em>Error</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getError()
	 * @generated
	 * @ordered
	 */
	protected DependabilityintermediateModel.Error error;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ErrorsExpressionErrorNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DependabilityintermediateModelPackage.Literals.ERRORS_EXPRESSION_ERROR_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependabilityintermediateModel.Error getError() {
		if (error != null && error.eIsProxy()) {
			InternalEObject oldError = (InternalEObject)error;
			error = (DependabilityintermediateModel.Error)eResolveProxy(oldError);
			if (error != oldError) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DependabilityintermediateModelPackage.ERRORS_EXPRESSION_ERROR_NODE__ERROR, oldError, error));
			}
		}
		return error;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependabilityintermediateModel.Error basicGetError() {
		return error;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setError(DependabilityintermediateModel.Error newError) {
		DependabilityintermediateModel.Error oldError = error;
		error = newError;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.ERRORS_EXPRESSION_ERROR_NODE__ERROR, oldError, error));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DependabilityintermediateModelPackage.ERRORS_EXPRESSION_ERROR_NODE__ERROR:
				if (resolve) return getError();
				return basicGetError();
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
			case DependabilityintermediateModelPackage.ERRORS_EXPRESSION_ERROR_NODE__ERROR:
				setError((DependabilityintermediateModel.Error)newValue);
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
			case DependabilityintermediateModelPackage.ERRORS_EXPRESSION_ERROR_NODE__ERROR:
				setError((DependabilityintermediateModel.Error)null);
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
			case DependabilityintermediateModelPackage.ERRORS_EXPRESSION_ERROR_NODE__ERROR:
				return error != null;
		}
		return super.eIsSet(featureID);
	}

} //ErrorsExpressionErrorNodeImpl
