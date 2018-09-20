/**
 */
package org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.AttackType;
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Threat;

import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.ThreatType;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Attack;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.ThreatsPropagationPackage;
import org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.Vulnerability;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attack</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.AttackImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.AttackImpl#getSeverity <em>Severity</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.AttackImpl#getLikelihood <em>Likelihood</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.AttackImpl#getVulnerability <em>Vulnerability</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.ThreatsPropagation.impl.AttackImpl#getThreat <em>Threat</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttackImpl extends InternalPropagationImpl implements Attack {
	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final AttackType KIND_EDEFAULT = AttackType.MASQUERADE_ATTACK;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected AttackType kind = KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected static final String SEVERITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected String severity = SEVERITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getLikelihood() <em>Likelihood</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLikelihood()
	 * @generated
	 * @ordered
	 */
	protected static final String LIKELIHOOD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLikelihood() <em>Likelihood</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLikelihood()
	 * @generated
	 * @ordered
	 */
	protected String likelihood = LIKELIHOOD_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVulnerability() <em>Vulnerability</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVulnerability()
	 * @generated
	 * @ordered
	 */
	protected Vulnerability vulnerability;

	/**
	 * The default value of the '{@link #getThreat() <em>Threat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThreat()
	 * @generated
	 * @ordered
	 */
	protected static final ThreatType THREAT_EDEFAULT = ThreatType.UNAUTHORIZED_ACCESS_OF_SERVICE;

	/**
	 * The cached value of the '{@link #getThreat() <em>Threat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThreat()
	 * @generated
	 * @ordered
	 */
	protected ThreatType threat = THREAT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttackImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ThreatsPropagationPackage.Literals.ATTACK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttackType getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(AttackType newKind) {
		AttackType oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ThreatsPropagationPackage.ATTACK__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSeverity() {
		return severity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeverity(String newSeverity) {
		String oldSeverity = severity;
		severity = newSeverity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ThreatsPropagationPackage.ATTACK__SEVERITY, oldSeverity, severity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLikelihood() {
		return likelihood;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLikelihood(String newLikelihood) {
		String oldLikelihood = likelihood;
		likelihood = newLikelihood;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ThreatsPropagationPackage.ATTACK__LIKELIHOOD, oldLikelihood, likelihood));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vulnerability getVulnerability() {
		if (vulnerability != null && vulnerability.eIsProxy()) {
			InternalEObject oldVulnerability = (InternalEObject)vulnerability;
			vulnerability = (Vulnerability)eResolveProxy(oldVulnerability);
			if (vulnerability != oldVulnerability) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ThreatsPropagationPackage.ATTACK__VULNERABILITY, oldVulnerability, vulnerability));
			}
		}
		return vulnerability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vulnerability basicGetVulnerability() {
		return vulnerability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVulnerability(Vulnerability newVulnerability) {
		Vulnerability oldVulnerability = vulnerability;
		vulnerability = newVulnerability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ThreatsPropagationPackage.ATTACK__VULNERABILITY, oldVulnerability, vulnerability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreatType getThreat() {
		return threat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThreat(ThreatType newThreat) {
		ThreatType oldThreat = threat;
		threat = newThreat == null ? THREAT_EDEFAULT : newThreat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ThreatsPropagationPackage.ATTACK__THREAT, oldThreat, threat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ThreatsPropagationPackage.ATTACK__KIND:
				return getKind();
			case ThreatsPropagationPackage.ATTACK__SEVERITY:
				return getSeverity();
			case ThreatsPropagationPackage.ATTACK__LIKELIHOOD:
				return getLikelihood();
			case ThreatsPropagationPackage.ATTACK__VULNERABILITY:
				if (resolve) return getVulnerability();
				return basicGetVulnerability();
			case ThreatsPropagationPackage.ATTACK__THREAT:
				return getThreat();
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
			case ThreatsPropagationPackage.ATTACK__KIND:
				setKind((AttackType)newValue);
				return;
			case ThreatsPropagationPackage.ATTACK__SEVERITY:
				setSeverity((String)newValue);
				return;
			case ThreatsPropagationPackage.ATTACK__LIKELIHOOD:
				setLikelihood((String)newValue);
				return;
			case ThreatsPropagationPackage.ATTACK__VULNERABILITY:
				setVulnerability((Vulnerability)newValue);
				return;
			case ThreatsPropagationPackage.ATTACK__THREAT:
				setThreat((ThreatType)newValue);
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
			case ThreatsPropagationPackage.ATTACK__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case ThreatsPropagationPackage.ATTACK__SEVERITY:
				setSeverity(SEVERITY_EDEFAULT);
				return;
			case ThreatsPropagationPackage.ATTACK__LIKELIHOOD:
				setLikelihood(LIKELIHOOD_EDEFAULT);
				return;
			case ThreatsPropagationPackage.ATTACK__VULNERABILITY:
				setVulnerability((Vulnerability)null);
				return;
			case ThreatsPropagationPackage.ATTACK__THREAT:
				setThreat(THREAT_EDEFAULT);
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
			case ThreatsPropagationPackage.ATTACK__KIND:
				return kind != KIND_EDEFAULT;
			case ThreatsPropagationPackage.ATTACK__SEVERITY:
				return SEVERITY_EDEFAULT == null ? severity != null : !SEVERITY_EDEFAULT.equals(severity);
			case ThreatsPropagationPackage.ATTACK__LIKELIHOOD:
				return LIKELIHOOD_EDEFAULT == null ? likelihood != null : !LIKELIHOOD_EDEFAULT.equals(likelihood);
			case ThreatsPropagationPackage.ATTACK__VULNERABILITY:
				return vulnerability != null;
			case ThreatsPropagationPackage.ATTACK__THREAT:
				return threat != THREAT_EDEFAULT;
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
		result.append(" (kind: ");
		result.append(kind);
		result.append(", severity: ");
		result.append(severity);
		result.append(", likelihood: ");
		result.append(likelihood);
		result.append(", threat: ");
		result.append(threat);
		result.append(')');
		return result.toString();
	}

} //AttackImpl
