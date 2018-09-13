/**
 */
package org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Operation;

import org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.ARINCComponentModelPackage;
import org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.ARINCProcess;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ARINC Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.impl.ARINCProcessImpl#getBase_Operation <em>Base Operation</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.impl.ARINCProcessImpl#getBase_Comment <em>Base Comment</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.impl.ARINCProcessImpl#getOperationsGroups <em>Operations Groups</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ARINCProcessImpl extends EObjectImpl implements ARINCProcess {
	/**
	 * The cached value of the '{@link #getBase_Operation() <em>Base Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Operation()
	 * @generated
	 * @ordered
	 */
	protected Operation base_Operation;

	/**
	 * The cached value of the '{@link #getBase_Comment() <em>Base Comment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Comment()
	 * @generated
	 * @ordered
	 */
	protected Comment base_Comment;

	/**
	 * The default value of the '{@link #getOperationsGroups() <em>Operations Groups</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationsGroups()
	 * @generated
	 * @ordered
	 */
	protected static final String OPERATIONS_GROUPS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOperationsGroups() <em>Operations Groups</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationsGroups()
	 * @generated
	 * @ordered
	 */
	protected String operationsGroups = OPERATIONS_GROUPS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ARINCProcessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ARINCComponentModelPackage.Literals.ARINC_PROCESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getBase_Operation() {
		if (base_Operation != null && base_Operation.eIsProxy()) {
			InternalEObject oldBase_Operation = (InternalEObject)base_Operation;
			base_Operation = (Operation)eResolveProxy(oldBase_Operation);
			if (base_Operation != oldBase_Operation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ARINCComponentModelPackage.ARINC_PROCESS__BASE_OPERATION, oldBase_Operation, base_Operation));
			}
		}
		return base_Operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetBase_Operation() {
		return base_Operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Operation(Operation newBase_Operation) {
		Operation oldBase_Operation = base_Operation;
		base_Operation = newBase_Operation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ARINCComponentModelPackage.ARINC_PROCESS__BASE_OPERATION, oldBase_Operation, base_Operation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Comment getBase_Comment() {
		if (base_Comment != null && base_Comment.eIsProxy()) {
			InternalEObject oldBase_Comment = (InternalEObject)base_Comment;
			base_Comment = (Comment)eResolveProxy(oldBase_Comment);
			if (base_Comment != oldBase_Comment) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ARINCComponentModelPackage.ARINC_PROCESS__BASE_COMMENT, oldBase_Comment, base_Comment));
			}
		}
		return base_Comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Comment basicGetBase_Comment() {
		return base_Comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Comment(Comment newBase_Comment) {
		Comment oldBase_Comment = base_Comment;
		base_Comment = newBase_Comment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ARINCComponentModelPackage.ARINC_PROCESS__BASE_COMMENT, oldBase_Comment, base_Comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOperationsGroups() {
		return operationsGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperationsGroups(String newOperationsGroups) {
		String oldOperationsGroups = operationsGroups;
		operationsGroups = newOperationsGroups;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ARINCComponentModelPackage.ARINC_PROCESS__OPERATIONS_GROUPS, oldOperationsGroups, operationsGroups));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ARINCComponentModelPackage.ARINC_PROCESS__BASE_OPERATION:
				if (resolve) return getBase_Operation();
				return basicGetBase_Operation();
			case ARINCComponentModelPackage.ARINC_PROCESS__BASE_COMMENT:
				if (resolve) return getBase_Comment();
				return basicGetBase_Comment();
			case ARINCComponentModelPackage.ARINC_PROCESS__OPERATIONS_GROUPS:
				return getOperationsGroups();
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
			case ARINCComponentModelPackage.ARINC_PROCESS__BASE_OPERATION:
				setBase_Operation((Operation)newValue);
				return;
			case ARINCComponentModelPackage.ARINC_PROCESS__BASE_COMMENT:
				setBase_Comment((Comment)newValue);
				return;
			case ARINCComponentModelPackage.ARINC_PROCESS__OPERATIONS_GROUPS:
				setOperationsGroups((String)newValue);
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
			case ARINCComponentModelPackage.ARINC_PROCESS__BASE_OPERATION:
				setBase_Operation((Operation)null);
				return;
			case ARINCComponentModelPackage.ARINC_PROCESS__BASE_COMMENT:
				setBase_Comment((Comment)null);
				return;
			case ARINCComponentModelPackage.ARINC_PROCESS__OPERATIONS_GROUPS:
				setOperationsGroups(OPERATIONS_GROUPS_EDEFAULT);
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
			case ARINCComponentModelPackage.ARINC_PROCESS__BASE_OPERATION:
				return base_Operation != null;
			case ARINCComponentModelPackage.ARINC_PROCESS__BASE_COMMENT:
				return base_Comment != null;
			case ARINCComponentModelPackage.ARINC_PROCESS__OPERATIONS_GROUPS:
				return OPERATIONS_GROUPS_EDEFAULT == null ? operationsGroups != null : !OPERATIONS_GROUPS_EDEFAULT.equals(operationsGroups);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (operationsGroups: ");
		result.append(operationsGroups);
		result.append(')');
		return result.toString();
	}

} //ARINCProcessImpl
