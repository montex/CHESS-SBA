/**
 */
package org.polarsys.chess.contracts.profile.chesscontract.DataTypes.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.polarsys.chess.contracts.profile.chesscontract.DataTypes.*;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class DataTypesFactoryImpl extends EFactoryImpl implements DataTypesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static DataTypesFactory init() {
		try {
			DataTypesFactory theDataTypesFactory = (DataTypesFactory)EPackage.Registry.INSTANCE.getEFactory(DataTypesPackage.eNS_URI);
			if (theDataTypesFactory != null) {
				return theDataTypesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DataTypesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public DataTypesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DataTypesPackage.OTHELLO_CONSTRAINT: return createOthelloConstraint();
			case DataTypesPackage.CONTINUOUS: return createContinuous();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case DataTypesPackage.REQ_STATUSES:
				return createReqStatusesFromString(eDataType, initialValue);
			case DataTypesPackage.REQ_TYPES:
				return createReqTypesFromString(eDataType, initialValue);
			case DataTypesPackage.REQ_PRIORITIES:
				return createReqPrioritiesFromString(eDataType, initialValue);
			case DataTypesPackage.REQ_MATURITIES:
				return createReqMaturitiesFromString(eDataType, initialValue);
			case DataTypesPackage.REQ_RISKS:
				return createReqRisksFromString(eDataType, initialValue);
			case DataTypesPackage.LANGUAGES:
				return createLanguagesFromString(eDataType, initialValue);
			case DataTypesPackage.CONTRACT_STATUS:
				return createContractStatusFromString(eDataType, initialValue);
			case DataTypesPackage.CONCERNS:
				return createConcernsFromString(eDataType, initialValue);
			case DataTypesPackage.CONTRACT_TYPES:
				return createContractTypesFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case DataTypesPackage.REQ_STATUSES:
				return convertReqStatusesToString(eDataType, instanceValue);
			case DataTypesPackage.REQ_TYPES:
				return convertReqTypesToString(eDataType, instanceValue);
			case DataTypesPackage.REQ_PRIORITIES:
				return convertReqPrioritiesToString(eDataType, instanceValue);
			case DataTypesPackage.REQ_MATURITIES:
				return convertReqMaturitiesToString(eDataType, instanceValue);
			case DataTypesPackage.REQ_RISKS:
				return convertReqRisksToString(eDataType, instanceValue);
			case DataTypesPackage.LANGUAGES:
				return convertLanguagesToString(eDataType, instanceValue);
			case DataTypesPackage.CONTRACT_STATUS:
				return convertContractStatusToString(eDataType, instanceValue);
			case DataTypesPackage.CONCERNS:
				return convertConcernsToString(eDataType, instanceValue);
			case DataTypesPackage.CONTRACT_TYPES:
				return convertContractTypesToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OthelloConstraint createOthelloConstraint() {
		OthelloConstraintImpl othelloConstraint = new OthelloConstraintImpl();
		return othelloConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Continuous createContinuous() {
		ContinuousImpl continuous = new ContinuousImpl();
		return continuous;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ReqStatuses createReqStatusesFromString(EDataType eDataType, String initialValue) {
		ReqStatuses result = ReqStatuses.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertReqStatusesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ReqTypes createReqTypesFromString(EDataType eDataType, String initialValue) {
		ReqTypes result = ReqTypes.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertReqTypesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ReqPriorities createReqPrioritiesFromString(EDataType eDataType, String initialValue) {
		ReqPriorities result = ReqPriorities.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertReqPrioritiesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ReqMaturities createReqMaturitiesFromString(EDataType eDataType, String initialValue) {
		ReqMaturities result = ReqMaturities.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertReqMaturitiesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ReqRisks createReqRisksFromString(EDataType eDataType, String initialValue) {
		ReqRisks result = ReqRisks.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertReqRisksToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Languages createLanguagesFromString(EDataType eDataType, String initialValue) {
		Languages result = Languages.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLanguagesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ContractStatus createContractStatusFromString(EDataType eDataType, String initialValue) {
		ContractStatus result = ContractStatus.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertContractStatusToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Concerns createConcernsFromString(EDataType eDataType, String initialValue) {
		Concerns result = Concerns.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConcernsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ContractTypes createContractTypesFromString(EDataType eDataType, String initialValue) {
		ContractTypes result = ContractTypes.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertContractTypesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypesPackage getDataTypesPackage() {
		return (DataTypesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DataTypesPackage getPackage() {
		return DataTypesPackage.eINSTANCE;
	}

} // DataTypesFactoryImpl
