/**
 */
package org.polarsys.chess.contracts.profile.chesscontract.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementImpl;

import org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage;
import org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement;

import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqMaturities;
import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqPriorities;
import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqRisks;
import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqStatuses;
import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.ReqTypes;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>CHESS
 * Requirement</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSRequirementImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSRequirementImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSRequirementImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSRequirementImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSRequirementImpl#getPerformance <em>Performance</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSRequirementImpl#getTolerance <em>Tolerance</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSRequirementImpl#getSeverity <em>Severity</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSRequirementImpl#getMaturity <em>Maturity</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSRequirementImpl#getRisk <em>Risk</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CHESSRequirementImpl extends RequirementImpl implements CHESSRequirement {
	/**
	 * The default value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected static final String AUTHOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected String author = AUTHOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final ReqStatuses STATUS_EDEFAULT = ReqStatuses.INITIAL;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected ReqStatuses status = STATUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final ReqTypes TYPE_EDEFAULT = ReqTypes.FUNCTIONAL;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected ReqTypes type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final ReqPriorities PRIORITY_EDEFAULT = ReqPriorities.HIGH;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected ReqPriorities priority = PRIORITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getPerformance() <em>Performance</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPerformance()
	 * @generated
	 * @ordered
	 */
	protected static final String PERFORMANCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPerformance() <em>Performance</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPerformance()
	 * @generated
	 * @ordered
	 */
	protected String performance = PERFORMANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTolerance() <em>Tolerance</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTolerance()
	 * @generated
	 * @ordered
	 */
	protected static final String TOLERANCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTolerance() <em>Tolerance</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTolerance()
	 * @generated
	 * @ordered
	 */
	protected String tolerance = TOLERANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected static final String SEVERITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected String severity = SEVERITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaturity() <em>Maturity</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMaturity()
	 * @generated
	 * @ordered
	 */
	protected static final ReqMaturities MATURITY_EDEFAULT = ReqMaturities.TBC;

	/**
	 * The cached value of the '{@link #getMaturity() <em>Maturity</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMaturity()
	 * @generated
	 * @ordered
	 */
	protected ReqMaturities maturity = MATURITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getRisk() <em>Risk</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRisk()
	 * @generated
	 * @ordered
	 */
	protected static final ReqRisks RISK_EDEFAULT = ReqRisks.HIGH;

	/**
	 * The cached value of the '{@link #getRisk() <em>Risk</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRisk()
	 * @generated
	 * @ordered
	 */
	protected ReqRisks risk = RISK_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CHESSRequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CHESSContractPackage.Literals.CHESS_REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuthor(String newAuthor) {
		String oldAuthor = author;
		author = newAuthor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CHESSContractPackage.CHESS_REQUIREMENT__AUTHOR, oldAuthor, author));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ReqStatuses getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(ReqStatuses newStatus) {
		ReqStatuses oldStatus = status;
		status = newStatus == null ? STATUS_EDEFAULT : newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CHESSContractPackage.CHESS_REQUIREMENT__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ReqTypes getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ReqTypes newType) {
		ReqTypes oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CHESSContractPackage.CHESS_REQUIREMENT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ReqPriorities getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriority(ReqPriorities newPriority) {
		ReqPriorities oldPriority = priority;
		priority = newPriority == null ? PRIORITY_EDEFAULT : newPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CHESSContractPackage.CHESS_REQUIREMENT__PRIORITY, oldPriority, priority));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getPerformance() {
		return performance;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPerformance(String newPerformance) {
		String oldPerformance = performance;
		performance = newPerformance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CHESSContractPackage.CHESS_REQUIREMENT__PERFORMANCE, oldPerformance, performance));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getTolerance() {
		return tolerance;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTolerance(String newTolerance) {
		String oldTolerance = tolerance;
		tolerance = newTolerance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CHESSContractPackage.CHESS_REQUIREMENT__TOLERANCE, oldTolerance, tolerance));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getSeverity() {
		return severity;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeverity(String newSeverity) {
		String oldSeverity = severity;
		severity = newSeverity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CHESSContractPackage.CHESS_REQUIREMENT__SEVERITY, oldSeverity, severity));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ReqMaturities getMaturity() {
		return maturity;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaturity(ReqMaturities newMaturity) {
		ReqMaturities oldMaturity = maturity;
		maturity = newMaturity == null ? MATURITY_EDEFAULT : newMaturity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CHESSContractPackage.CHESS_REQUIREMENT__MATURITY, oldMaturity, maturity));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ReqRisks getRisk() {
		return risk;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRisk(ReqRisks newRisk) {
		ReqRisks oldRisk = risk;
		risk = newRisk == null ? RISK_EDEFAULT : newRisk;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CHESSContractPackage.CHESS_REQUIREMENT__RISK, oldRisk, risk));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CHESSContractPackage.CHESS_REQUIREMENT__AUTHOR:
				return getAuthor();
			case CHESSContractPackage.CHESS_REQUIREMENT__STATUS:
				return getStatus();
			case CHESSContractPackage.CHESS_REQUIREMENT__TYPE:
				return getType();
			case CHESSContractPackage.CHESS_REQUIREMENT__PRIORITY:
				return getPriority();
			case CHESSContractPackage.CHESS_REQUIREMENT__PERFORMANCE:
				return getPerformance();
			case CHESSContractPackage.CHESS_REQUIREMENT__TOLERANCE:
				return getTolerance();
			case CHESSContractPackage.CHESS_REQUIREMENT__SEVERITY:
				return getSeverity();
			case CHESSContractPackage.CHESS_REQUIREMENT__MATURITY:
				return getMaturity();
			case CHESSContractPackage.CHESS_REQUIREMENT__RISK:
				return getRisk();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CHESSContractPackage.CHESS_REQUIREMENT__AUTHOR:
				setAuthor((String)newValue);
				return;
			case CHESSContractPackage.CHESS_REQUIREMENT__STATUS:
				setStatus((ReqStatuses)newValue);
				return;
			case CHESSContractPackage.CHESS_REQUIREMENT__TYPE:
				setType((ReqTypes)newValue);
				return;
			case CHESSContractPackage.CHESS_REQUIREMENT__PRIORITY:
				setPriority((ReqPriorities)newValue);
				return;
			case CHESSContractPackage.CHESS_REQUIREMENT__PERFORMANCE:
				setPerformance((String)newValue);
				return;
			case CHESSContractPackage.CHESS_REQUIREMENT__TOLERANCE:
				setTolerance((String)newValue);
				return;
			case CHESSContractPackage.CHESS_REQUIREMENT__SEVERITY:
				setSeverity((String)newValue);
				return;
			case CHESSContractPackage.CHESS_REQUIREMENT__MATURITY:
				setMaturity((ReqMaturities)newValue);
				return;
			case CHESSContractPackage.CHESS_REQUIREMENT__RISK:
				setRisk((ReqRisks)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CHESSContractPackage.CHESS_REQUIREMENT__AUTHOR:
				setAuthor(AUTHOR_EDEFAULT);
				return;
			case CHESSContractPackage.CHESS_REQUIREMENT__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case CHESSContractPackage.CHESS_REQUIREMENT__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case CHESSContractPackage.CHESS_REQUIREMENT__PRIORITY:
				setPriority(PRIORITY_EDEFAULT);
				return;
			case CHESSContractPackage.CHESS_REQUIREMENT__PERFORMANCE:
				setPerformance(PERFORMANCE_EDEFAULT);
				return;
			case CHESSContractPackage.CHESS_REQUIREMENT__TOLERANCE:
				setTolerance(TOLERANCE_EDEFAULT);
				return;
			case CHESSContractPackage.CHESS_REQUIREMENT__SEVERITY:
				setSeverity(SEVERITY_EDEFAULT);
				return;
			case CHESSContractPackage.CHESS_REQUIREMENT__MATURITY:
				setMaturity(MATURITY_EDEFAULT);
				return;
			case CHESSContractPackage.CHESS_REQUIREMENT__RISK:
				setRisk(RISK_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CHESSContractPackage.CHESS_REQUIREMENT__AUTHOR:
				return AUTHOR_EDEFAULT == null ? author != null : !AUTHOR_EDEFAULT.equals(author);
			case CHESSContractPackage.CHESS_REQUIREMENT__STATUS:
				return status != STATUS_EDEFAULT;
			case CHESSContractPackage.CHESS_REQUIREMENT__TYPE:
				return type != TYPE_EDEFAULT;
			case CHESSContractPackage.CHESS_REQUIREMENT__PRIORITY:
				return priority != PRIORITY_EDEFAULT;
			case CHESSContractPackage.CHESS_REQUIREMENT__PERFORMANCE:
				return PERFORMANCE_EDEFAULT == null ? performance != null : !PERFORMANCE_EDEFAULT.equals(performance);
			case CHESSContractPackage.CHESS_REQUIREMENT__TOLERANCE:
				return TOLERANCE_EDEFAULT == null ? tolerance != null : !TOLERANCE_EDEFAULT.equals(tolerance);
			case CHESSContractPackage.CHESS_REQUIREMENT__SEVERITY:
				return SEVERITY_EDEFAULT == null ? severity != null : !SEVERITY_EDEFAULT.equals(severity);
			case CHESSContractPackage.CHESS_REQUIREMENT__MATURITY:
				return maturity != MATURITY_EDEFAULT;
			case CHESSContractPackage.CHESS_REQUIREMENT__RISK:
				return risk != RISK_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (Author: ");
		result.append(author);
		result.append(", Status: ");
		result.append(status);
		result.append(", Type: ");
		result.append(type);
		result.append(", Priority: ");
		result.append(priority);
		result.append(", Performance: ");
		result.append(performance);
		result.append(", Tolerance: ");
		result.append(tolerance);
		result.append(", Severity: ");
		result.append(severity);
		result.append(", Maturity: ");
		result.append(maturity);
		result.append(", Risk: ");
		result.append(risk);
		result.append(')');
		return result.toString();
	}

} // CHESSRequirementImpl
