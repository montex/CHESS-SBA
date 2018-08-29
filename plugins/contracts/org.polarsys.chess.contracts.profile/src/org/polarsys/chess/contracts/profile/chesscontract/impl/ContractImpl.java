/**
 */
package org.polarsys.chess.contracts.profile.chesscontract.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.sysml.constraints.internal.impl.ConstraintBlockImpl;
import org.eclipse.papyrus.sysml.requirements.Requirement;
import org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage;
import org.polarsys.chess.contracts.profile.chesscontract.Contract;
import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.Languages;
import org.polarsys.chess.contracts.profile.chesscontract.FormalProperty;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Contract</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.impl.ContractImpl#getAssume <em>Assume</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.impl.ContractImpl#getGuarantee <em>Guarantee</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.impl.ContractImpl#getFormalize <em>Formalize</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.impl.ContractImpl#getLanguage <em>Language</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.impl.ContractImpl#getContextStatement <em>Context Statement</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.impl.ContractImpl#getArtefactStatement <em>Artefact Statement</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ContractImpl extends ConstraintBlockImpl implements Contract {
	/**
	 * The cached value of the '{@link #getAssume() <em>Assume</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAssume()
	 * @generated
	 * @ordered
	 */
	protected FormalProperty assume;

	/**
	 * The cached value of the '{@link #getGuarantee() <em>Guarantee</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getGuarantee()
	 * @generated
	 * @ordered
	 */
	protected FormalProperty guarantee;

	/**
	 * The cached value of the '{@link #getFormalize() <em>Formalize</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFormalize()
	 * @generated
	 * @ordered
	 */
	protected EList<Requirement> formalize;

	/**
	 * The default value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final Languages LANGUAGE_EDEFAULT = Languages.OCRA;

	/**
	 * The cached value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected Languages language = LANGUAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getContextStatement() <em>Context Statement</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getContextStatement()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTEXT_STATEMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContextStatement() <em>Context Statement</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getContextStatement()
	 * @generated
	 * @ordered
	 */
	protected String contextStatement = CONTEXT_STATEMENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getArtefactStatement() <em>Artefact Statement</em>}' attribute list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getArtefactStatement()
	 * @generated
	 * @ordered
	 */
	protected EList<String> artefactStatement;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ContractImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CHESSContractPackage.Literals.CONTRACT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FormalProperty getAssume() {
		if (assume != null && assume.eIsProxy()) {
			InternalEObject oldAssume = (InternalEObject)assume;
			assume = (FormalProperty)eResolveProxy(oldAssume);
			if (assume != oldAssume) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CHESSContractPackage.CONTRACT__ASSUME, oldAssume, assume));
			}
		}
		return assume;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FormalProperty basicGetAssume() {
		return assume;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssume(FormalProperty newAssume) {
		FormalProperty oldAssume = assume;
		assume = newAssume;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CHESSContractPackage.CONTRACT__ASSUME, oldAssume, assume));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FormalProperty getGuarantee() {
		if (guarantee != null && guarantee.eIsProxy()) {
			InternalEObject oldGuarantee = (InternalEObject)guarantee;
			guarantee = (FormalProperty)eResolveProxy(oldGuarantee);
			if (guarantee != oldGuarantee) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CHESSContractPackage.CONTRACT__GUARANTEE, oldGuarantee, guarantee));
			}
		}
		return guarantee;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FormalProperty basicGetGuarantee() {
		return guarantee;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuarantee(FormalProperty newGuarantee) {
		FormalProperty oldGuarantee = guarantee;
		guarantee = newGuarantee;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CHESSContractPackage.CONTRACT__GUARANTEE, oldGuarantee, guarantee));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Requirement> getFormalize() {
		if (formalize == null) {
			formalize = new EObjectResolvingEList<Requirement>(Requirement.class, this, CHESSContractPackage.CONTRACT__FORMALIZE);
		}
		return formalize;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Languages getLanguage() {
		return language;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLanguage(Languages newLanguage) {
		Languages oldLanguage = language;
		language = newLanguage == null ? LANGUAGE_EDEFAULT : newLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CHESSContractPackage.CONTRACT__LANGUAGE, oldLanguage, language));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getContextStatement() {
		return contextStatement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextStatement(String newContextStatement) {
		String oldContextStatement = contextStatement;
		contextStatement = newContextStatement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CHESSContractPackage.CONTRACT__CONTEXT_STATEMENT, oldContextStatement, contextStatement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getArtefactStatement() {
		if (artefactStatement == null) {
			artefactStatement = new EDataTypeUniqueEList<String>(String.class, this, CHESSContractPackage.CONTRACT__ARTEFACT_STATEMENT);
		}
		return artefactStatement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CHESSContractPackage.CONTRACT__ASSUME:
				if (resolve) return getAssume();
				return basicGetAssume();
			case CHESSContractPackage.CONTRACT__GUARANTEE:
				if (resolve) return getGuarantee();
				return basicGetGuarantee();
			case CHESSContractPackage.CONTRACT__FORMALIZE:
				return getFormalize();
			case CHESSContractPackage.CONTRACT__LANGUAGE:
				return getLanguage();
			case CHESSContractPackage.CONTRACT__CONTEXT_STATEMENT:
				return getContextStatement();
			case CHESSContractPackage.CONTRACT__ARTEFACT_STATEMENT:
				return getArtefactStatement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CHESSContractPackage.CONTRACT__ASSUME:
				setAssume((FormalProperty)newValue);
				return;
			case CHESSContractPackage.CONTRACT__GUARANTEE:
				setGuarantee((FormalProperty)newValue);
				return;
			case CHESSContractPackage.CONTRACT__FORMALIZE:
				getFormalize().clear();
				getFormalize().addAll((Collection<? extends Requirement>)newValue);
				return;
			case CHESSContractPackage.CONTRACT__LANGUAGE:
				setLanguage((Languages)newValue);
				return;
			case CHESSContractPackage.CONTRACT__CONTEXT_STATEMENT:
				setContextStatement((String)newValue);
				return;
			case CHESSContractPackage.CONTRACT__ARTEFACT_STATEMENT:
				getArtefactStatement().clear();
				getArtefactStatement().addAll((Collection<? extends String>)newValue);
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
			case CHESSContractPackage.CONTRACT__ASSUME:
				setAssume((FormalProperty)null);
				return;
			case CHESSContractPackage.CONTRACT__GUARANTEE:
				setGuarantee((FormalProperty)null);
				return;
			case CHESSContractPackage.CONTRACT__FORMALIZE:
				getFormalize().clear();
				return;
			case CHESSContractPackage.CONTRACT__LANGUAGE:
				setLanguage(LANGUAGE_EDEFAULT);
				return;
			case CHESSContractPackage.CONTRACT__CONTEXT_STATEMENT:
				setContextStatement(CONTEXT_STATEMENT_EDEFAULT);
				return;
			case CHESSContractPackage.CONTRACT__ARTEFACT_STATEMENT:
				getArtefactStatement().clear();
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
			case CHESSContractPackage.CONTRACT__ASSUME:
				return assume != null;
			case CHESSContractPackage.CONTRACT__GUARANTEE:
				return guarantee != null;
			case CHESSContractPackage.CONTRACT__FORMALIZE:
				return formalize != null && !formalize.isEmpty();
			case CHESSContractPackage.CONTRACT__LANGUAGE:
				return language != LANGUAGE_EDEFAULT;
			case CHESSContractPackage.CONTRACT__CONTEXT_STATEMENT:
				return CONTEXT_STATEMENT_EDEFAULT == null ? contextStatement != null : !CONTEXT_STATEMENT_EDEFAULT.equals(contextStatement);
			case CHESSContractPackage.CONTRACT__ARTEFACT_STATEMENT:
				return artefactStatement != null && !artefactStatement.isEmpty();
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
		result.append(" (Language: ");
		result.append(language);
		result.append(", contextStatement: ");
		result.append(contextStatement);
		result.append(", artefactStatement: ");
		result.append(artefactStatement);
		result.append(')');
		return result.toString();
	}

} // ContractImpl
