/**
 */
package org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.uml2.uml.Comment;

import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTComponentModelPackage;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RunTimeSupport;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Run Time Support</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.RunTimeSupportImpl#isMonitoring <em>Monitoring</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.RunTimeSupportImpl#isVerification <em>Verification</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.RunTimeSupportImpl#getBase_Comment <em>Base Comment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RunTimeSupportImpl extends EObjectImpl implements RunTimeSupport {
	/**
	 * The default value of the '{@link #isMonitoring() <em>Monitoring</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMonitoring()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MONITORING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMonitoring() <em>Monitoring</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMonitoring()
	 * @generated
	 * @ordered
	 */
	protected boolean monitoring = MONITORING_EDEFAULT;

	/**
	 * The default value of the '{@link #isVerification() <em>Verification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVerification()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VERIFICATION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isVerification() <em>Verification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVerification()
	 * @generated
	 * @ordered
	 */
	protected boolean verification = VERIFICATION_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RunTimeSupportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RTComponentModelPackage.Literals.RUN_TIME_SUPPORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMonitoring() {
		return monitoring;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMonitoring(boolean newMonitoring) {
		boolean oldMonitoring = monitoring;
		monitoring = newMonitoring;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RTComponentModelPackage.RUN_TIME_SUPPORT__MONITORING, oldMonitoring, monitoring));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isVerification() {
		return verification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVerification(boolean newVerification) {
		boolean oldVerification = verification;
		verification = newVerification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RTComponentModelPackage.RUN_TIME_SUPPORT__VERIFICATION, oldVerification, verification));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RTComponentModelPackage.RUN_TIME_SUPPORT__BASE_COMMENT, oldBase_Comment, base_Comment));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RTComponentModelPackage.RUN_TIME_SUPPORT__BASE_COMMENT, oldBase_Comment, base_Comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RTComponentModelPackage.RUN_TIME_SUPPORT__MONITORING:
				return isMonitoring();
			case RTComponentModelPackage.RUN_TIME_SUPPORT__VERIFICATION:
				return isVerification();
			case RTComponentModelPackage.RUN_TIME_SUPPORT__BASE_COMMENT:
				if (resolve) return getBase_Comment();
				return basicGetBase_Comment();
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
			case RTComponentModelPackage.RUN_TIME_SUPPORT__MONITORING:
				setMonitoring((Boolean)newValue);
				return;
			case RTComponentModelPackage.RUN_TIME_SUPPORT__VERIFICATION:
				setVerification((Boolean)newValue);
				return;
			case RTComponentModelPackage.RUN_TIME_SUPPORT__BASE_COMMENT:
				setBase_Comment((Comment)newValue);
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
			case RTComponentModelPackage.RUN_TIME_SUPPORT__MONITORING:
				setMonitoring(MONITORING_EDEFAULT);
				return;
			case RTComponentModelPackage.RUN_TIME_SUPPORT__VERIFICATION:
				setVerification(VERIFICATION_EDEFAULT);
				return;
			case RTComponentModelPackage.RUN_TIME_SUPPORT__BASE_COMMENT:
				setBase_Comment((Comment)null);
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
			case RTComponentModelPackage.RUN_TIME_SUPPORT__MONITORING:
				return monitoring != MONITORING_EDEFAULT;
			case RTComponentModelPackage.RUN_TIME_SUPPORT__VERIFICATION:
				return verification != VERIFICATION_EDEFAULT;
			case RTComponentModelPackage.RUN_TIME_SUPPORT__BASE_COMMENT:
				return base_Comment != null;
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
		result.append(" (monitoring: ");
		result.append(monitoring);
		result.append(", verification: ");
		result.append(verification);
		result.append(')');
		return result.toString();
	}

} //RunTimeSupportImpl
