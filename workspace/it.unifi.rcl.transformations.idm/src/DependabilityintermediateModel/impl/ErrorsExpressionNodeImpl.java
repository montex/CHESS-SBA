/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel.impl;

import DependabilityintermediateModel.DependabilityintermediateModelPackage;
import DependabilityintermediateModel.ErrorPropagation;
import DependabilityintermediateModel.ErrorsExpressionNode;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Errors Expression Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link DependabilityintermediateModel.impl.ErrorsExpressionNodeImpl#getErrorPropagation <em>Error Propagation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ErrorsExpressionNodeImpl extends EObjectImpl implements ErrorsExpressionNode {
	/**
	 * The cached value of the '{@link #getErrorPropagation() <em>Error Propagation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorPropagation()
	 * @generated
	 * @ordered
	 */
	protected ErrorPropagation errorPropagation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ErrorsExpressionNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DependabilityintermediateModelPackage.Literals.ERRORS_EXPRESSION_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorPropagation getErrorPropagation() {
		if (errorPropagation != null && errorPropagation.eIsProxy()) {
			InternalEObject oldErrorPropagation = (InternalEObject)errorPropagation;
			errorPropagation = (ErrorPropagation)eResolveProxy(oldErrorPropagation);
			if (errorPropagation != oldErrorPropagation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DependabilityintermediateModelPackage.ERRORS_EXPRESSION_NODE__ERROR_PROPAGATION, oldErrorPropagation, errorPropagation));
			}
		}
		return errorPropagation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorPropagation basicGetErrorPropagation() {
		return errorPropagation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setErrorPropagation(ErrorPropagation newErrorPropagation) {
		ErrorPropagation oldErrorPropagation = errorPropagation;
		errorPropagation = newErrorPropagation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.ERRORS_EXPRESSION_NODE__ERROR_PROPAGATION, oldErrorPropagation, errorPropagation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DependabilityintermediateModelPackage.ERRORS_EXPRESSION_NODE__ERROR_PROPAGATION:
				if (resolve) return getErrorPropagation();
				return basicGetErrorPropagation();
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
			case DependabilityintermediateModelPackage.ERRORS_EXPRESSION_NODE__ERROR_PROPAGATION:
				setErrorPropagation((ErrorPropagation)newValue);
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
			case DependabilityintermediateModelPackage.ERRORS_EXPRESSION_NODE__ERROR_PROPAGATION:
				setErrorPropagation((ErrorPropagation)null);
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
			case DependabilityintermediateModelPackage.ERRORS_EXPRESSION_NODE__ERROR_PROPAGATION:
				return errorPropagation != null;
		}
		return super.eIsSet(featureID);
	}

} //ErrorsExpressionNodeImpl
