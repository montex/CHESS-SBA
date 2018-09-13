/**
 */
package org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Type;

import org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.ARINCComponentModelPackage;
import org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.ARINCFunction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ARINC Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.impl.ARINCFunctionImpl#getBase_Operation <em>Base Operation</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.impl.ARINCFunctionImpl#getBase_Comment <em>Base Comment</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.impl.ARINCFunctionImpl#getFollowedBy <em>Followed By</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.ARINCComponentModel.impl.ARINCFunctionImpl#getRateDivider <em>Rate Divider</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ARINCFunctionImpl extends EObjectImpl implements ARINCFunction {
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
	 * The cached value of the '{@link #getFollowedBy() <em>Followed By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFollowedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<Operation> followedBy;

	/**
	 * The default value of the '{@link #getRateDivider() <em>Rate Divider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRateDivider()
	 * @generated
	 * @ordered
	 */
	protected static final int RATE_DIVIDER_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getRateDivider() <em>Rate Divider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRateDivider()
	 * @generated
	 * @ordered
	 */
	protected int rateDivider = RATE_DIVIDER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ARINCFunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ARINCComponentModelPackage.Literals.ARINC_FUNCTION;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ARINCComponentModelPackage.ARINC_FUNCTION__BASE_OPERATION, oldBase_Operation, base_Operation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ARINCComponentModelPackage.ARINC_FUNCTION__BASE_OPERATION, oldBase_Operation, base_Operation));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ARINCComponentModelPackage.ARINC_FUNCTION__BASE_COMMENT, oldBase_Comment, base_Comment));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ARINCComponentModelPackage.ARINC_FUNCTION__BASE_COMMENT, oldBase_Comment, base_Comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Operation> getFollowedBy() {
		if (followedBy == null) {
			followedBy = new EObjectResolvingEList<Operation>(Operation.class, this, ARINCComponentModelPackage.ARINC_FUNCTION__FOLLOWED_BY);
		}
		return followedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getFollowedBy(String name, EList<String> ownedParameterNames, EList<Type> ownedParameterTypes) {
		return getFollowedBy(name, ownedParameterNames, ownedParameterTypes, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getFollowedBy(String name, EList<String> ownedParameterNames, EList<Type> ownedParameterTypes, boolean ignoreCase) {
		followedByLoop: for (Operation followedBy : getFollowedBy()) {
			if (name != null && !(ignoreCase ? name.equalsIgnoreCase(followedBy.getName()) : name.equals(followedBy.getName())))
				continue followedByLoop;
			EList<Parameter> ownedParameterList = followedBy.getOwnedParameters();
			int ownedParameterListSize = ownedParameterList.size();
			if (ownedParameterNames != null && ownedParameterNames.size() != ownedParameterListSize || (ownedParameterTypes != null && ownedParameterTypes.size() != ownedParameterListSize))
				continue  followedByLoop;
			for (int j = 0; j < ownedParameterListSize; j++) {
				Parameter ownedParameter = ownedParameterList.get(j);
				if (ownedParameterNames != null && !(ignoreCase ? (ownedParameterNames.get(j)).equalsIgnoreCase(ownedParameter.getName()) : ownedParameterNames.get(j).equals(ownedParameter.getName())))
					continue followedByLoop;
				if (ownedParameterTypes != null && !ownedParameterTypes.get(j).equals(ownedParameter.getType()))
					continue followedByLoop;
			}
			return followedBy;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRateDivider() {
		return rateDivider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRateDivider(int newRateDivider) {
		int oldRateDivider = rateDivider;
		rateDivider = newRateDivider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ARINCComponentModelPackage.ARINC_FUNCTION__RATE_DIVIDER, oldRateDivider, rateDivider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ARINCComponentModelPackage.ARINC_FUNCTION__BASE_OPERATION:
				if (resolve) return getBase_Operation();
				return basicGetBase_Operation();
			case ARINCComponentModelPackage.ARINC_FUNCTION__BASE_COMMENT:
				if (resolve) return getBase_Comment();
				return basicGetBase_Comment();
			case ARINCComponentModelPackage.ARINC_FUNCTION__FOLLOWED_BY:
				return getFollowedBy();
			case ARINCComponentModelPackage.ARINC_FUNCTION__RATE_DIVIDER:
				return getRateDivider();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ARINCComponentModelPackage.ARINC_FUNCTION__BASE_OPERATION:
				setBase_Operation((Operation)newValue);
				return;
			case ARINCComponentModelPackage.ARINC_FUNCTION__BASE_COMMENT:
				setBase_Comment((Comment)newValue);
				return;
			case ARINCComponentModelPackage.ARINC_FUNCTION__FOLLOWED_BY:
				getFollowedBy().clear();
				getFollowedBy().addAll((Collection<? extends Operation>)newValue);
				return;
			case ARINCComponentModelPackage.ARINC_FUNCTION__RATE_DIVIDER:
				setRateDivider((Integer)newValue);
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
			case ARINCComponentModelPackage.ARINC_FUNCTION__BASE_OPERATION:
				setBase_Operation((Operation)null);
				return;
			case ARINCComponentModelPackage.ARINC_FUNCTION__BASE_COMMENT:
				setBase_Comment((Comment)null);
				return;
			case ARINCComponentModelPackage.ARINC_FUNCTION__FOLLOWED_BY:
				getFollowedBy().clear();
				return;
			case ARINCComponentModelPackage.ARINC_FUNCTION__RATE_DIVIDER:
				setRateDivider(RATE_DIVIDER_EDEFAULT);
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
			case ARINCComponentModelPackage.ARINC_FUNCTION__BASE_OPERATION:
				return base_Operation != null;
			case ARINCComponentModelPackage.ARINC_FUNCTION__BASE_COMMENT:
				return base_Comment != null;
			case ARINCComponentModelPackage.ARINC_FUNCTION__FOLLOWED_BY:
				return followedBy != null && !followedBy.isEmpty();
			case ARINCComponentModelPackage.ARINC_FUNCTION__RATE_DIVIDER:
				return rateDivider != RATE_DIVIDER_EDEFAULT;
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
		result.append(" (rateDivider: ");
		result.append(rateDivider);
		result.append(')');
		return result.toString();
	}

} //ARINCFunctionImpl
