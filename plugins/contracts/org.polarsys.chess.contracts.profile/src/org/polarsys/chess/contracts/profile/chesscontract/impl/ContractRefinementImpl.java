/**
 */
package org.polarsys.chess.contracts.profile.chesscontract.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Property;

import org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage;
import org.polarsys.chess.contracts.profile.chesscontract.ContractProperty;
import org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Contract Refinement</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.impl.ContractRefinementImpl#getBase_DataType <em>Base Data Type</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.impl.ContractRefinementImpl#getInstance <em>Instance</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.impl.ContractRefinementImpl#getContract <em>Contract</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.impl.ContractRefinementImpl#getInstanceSpec <em>Instance Spec</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.impl.ContractRefinementImpl#getUpperIndexOfInstance <em>Upper Index Of Instance</em>}</li>
 *   <li>{@link org.polarsys.chess.contracts.profile.chesscontract.impl.ContractRefinementImpl#getLowerIndexOfInstance <em>Lower Index Of Instance</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ContractRefinementImpl extends MinimalEObjectImpl.Container implements ContractRefinement {
	/**
	 * The cached value of the '{@link #getBase_DataType() <em>Base Data Type</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getBase_DataType()
	 * @generated
	 * @ordered
	 */
	protected DataType base_DataType;

	/**
	 * The cached value of the '{@link #getInstance() <em>Instance</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInstance()
	 * @generated
	 * @ordered
	 */
	protected Property instance;

	/**
	 * The cached value of the '{@link #getContract() <em>Contract</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getContract()
	 * @generated
	 * @ordered
	 */
	protected ContractProperty contract;

	/**
	 * The cached value of the '{@link #getInstanceSpec() <em>Instance Spec</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInstanceSpec()
	 * @generated
	 * @ordered
	 */
	protected InstanceSpecification instanceSpec;

	/**
	 * The default value of the '{@link #getUpperIndexOfInstance() <em>Upper Index Of Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpperIndexOfInstance()
	 * @generated
	 * @ordered
	 */
	protected static final String UPPER_INDEX_OF_INSTANCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUpperIndexOfInstance() <em>Upper Index Of Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpperIndexOfInstance()
	 * @generated
	 * @ordered
	 */
	protected String upperIndexOfInstance = UPPER_INDEX_OF_INSTANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLowerIndexOfInstance() <em>Lower Index Of Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerIndexOfInstance()
	 * @generated
	 * @ordered
	 */
	protected static final String LOWER_INDEX_OF_INSTANCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLowerIndexOfInstance() <em>Lower Index Of Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerIndexOfInstance()
	 * @generated
	 * @ordered
	 */
	protected String lowerIndexOfInstance = LOWER_INDEX_OF_INSTANCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ContractRefinementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CHESSContractPackage.Literals.CONTRACT_REFINEMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getBase_DataType() {
		if (base_DataType != null && base_DataType.eIsProxy()) {
			InternalEObject oldBase_DataType = (InternalEObject)base_DataType;
			base_DataType = (DataType)eResolveProxy(oldBase_DataType);
			if (base_DataType != oldBase_DataType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CHESSContractPackage.CONTRACT_REFINEMENT__BASE_DATA_TYPE, oldBase_DataType, base_DataType));
			}
		}
		return base_DataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DataType basicGetBase_DataType() {
		return base_DataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_DataType(DataType newBase_DataType) {
		DataType oldBase_DataType = base_DataType;
		base_DataType = newBase_DataType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CHESSContractPackage.CONTRACT_REFINEMENT__BASE_DATA_TYPE, oldBase_DataType, base_DataType));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Property getInstance() {
		if (instance != null && instance.eIsProxy()) {
			InternalEObject oldInstance = (InternalEObject)instance;
			instance = (Property)eResolveProxy(oldInstance);
			if (instance != oldInstance) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CHESSContractPackage.CONTRACT_REFINEMENT__INSTANCE, oldInstance, instance));
			}
		}
		return instance;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetInstance() {
		return instance;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstance(Property newInstance) {
		Property oldInstance = instance;
		instance = newInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CHESSContractPackage.CONTRACT_REFINEMENT__INSTANCE, oldInstance, instance));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ContractProperty getContract() {
		if (contract != null && contract.eIsProxy()) {
			InternalEObject oldContract = (InternalEObject)contract;
			contract = (ContractProperty)eResolveProxy(oldContract);
			if (contract != oldContract) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CHESSContractPackage.CONTRACT_REFINEMENT__CONTRACT, oldContract, contract));
			}
		}
		return contract;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ContractProperty basicGetContract() {
		return contract;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setContract(ContractProperty newContract) {
		ContractProperty oldContract = contract;
		contract = newContract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CHESSContractPackage.CONTRACT_REFINEMENT__CONTRACT, oldContract, contract));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceSpecification getInstanceSpec() {
		if (instanceSpec != null && instanceSpec.eIsProxy()) {
			InternalEObject oldInstanceSpec = (InternalEObject)instanceSpec;
			instanceSpec = (InstanceSpecification)eResolveProxy(oldInstanceSpec);
			if (instanceSpec != oldInstanceSpec) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CHESSContractPackage.CONTRACT_REFINEMENT__INSTANCE_SPEC, oldInstanceSpec, instanceSpec));
			}
		}
		return instanceSpec;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceSpecification basicGetInstanceSpec() {
		return instanceSpec;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstanceSpec(InstanceSpecification newInstanceSpec) {
		InstanceSpecification oldInstanceSpec = instanceSpec;
		instanceSpec = newInstanceSpec;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CHESSContractPackage.CONTRACT_REFINEMENT__INSTANCE_SPEC, oldInstanceSpec, instanceSpec));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUpperIndexOfInstance() {
		return upperIndexOfInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperIndexOfInstance(String newUpperIndexOfInstance) {
		String oldUpperIndexOfInstance = upperIndexOfInstance;
		upperIndexOfInstance = newUpperIndexOfInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CHESSContractPackage.CONTRACT_REFINEMENT__UPPER_INDEX_OF_INSTANCE, oldUpperIndexOfInstance, upperIndexOfInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLowerIndexOfInstance() {
		return lowerIndexOfInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerIndexOfInstance(String newLowerIndexOfInstance) {
		String oldLowerIndexOfInstance = lowerIndexOfInstance;
		lowerIndexOfInstance = newLowerIndexOfInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CHESSContractPackage.CONTRACT_REFINEMENT__LOWER_INDEX_OF_INSTANCE, oldLowerIndexOfInstance, lowerIndexOfInstance));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CHESSContractPackage.CONTRACT_REFINEMENT__BASE_DATA_TYPE:
				if (resolve) return getBase_DataType();
				return basicGetBase_DataType();
			case CHESSContractPackage.CONTRACT_REFINEMENT__INSTANCE:
				if (resolve) return getInstance();
				return basicGetInstance();
			case CHESSContractPackage.CONTRACT_REFINEMENT__CONTRACT:
				if (resolve) return getContract();
				return basicGetContract();
			case CHESSContractPackage.CONTRACT_REFINEMENT__INSTANCE_SPEC:
				if (resolve) return getInstanceSpec();
				return basicGetInstanceSpec();
			case CHESSContractPackage.CONTRACT_REFINEMENT__UPPER_INDEX_OF_INSTANCE:
				return getUpperIndexOfInstance();
			case CHESSContractPackage.CONTRACT_REFINEMENT__LOWER_INDEX_OF_INSTANCE:
				return getLowerIndexOfInstance();
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
			case CHESSContractPackage.CONTRACT_REFINEMENT__BASE_DATA_TYPE:
				setBase_DataType((DataType)newValue);
				return;
			case CHESSContractPackage.CONTRACT_REFINEMENT__INSTANCE:
				setInstance((Property)newValue);
				return;
			case CHESSContractPackage.CONTRACT_REFINEMENT__CONTRACT:
				setContract((ContractProperty)newValue);
				return;
			case CHESSContractPackage.CONTRACT_REFINEMENT__INSTANCE_SPEC:
				setInstanceSpec((InstanceSpecification)newValue);
				return;
			case CHESSContractPackage.CONTRACT_REFINEMENT__UPPER_INDEX_OF_INSTANCE:
				setUpperIndexOfInstance((String)newValue);
				return;
			case CHESSContractPackage.CONTRACT_REFINEMENT__LOWER_INDEX_OF_INSTANCE:
				setLowerIndexOfInstance((String)newValue);
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
			case CHESSContractPackage.CONTRACT_REFINEMENT__BASE_DATA_TYPE:
				setBase_DataType((DataType)null);
				return;
			case CHESSContractPackage.CONTRACT_REFINEMENT__INSTANCE:
				setInstance((Property)null);
				return;
			case CHESSContractPackage.CONTRACT_REFINEMENT__CONTRACT:
				setContract((ContractProperty)null);
				return;
			case CHESSContractPackage.CONTRACT_REFINEMENT__INSTANCE_SPEC:
				setInstanceSpec((InstanceSpecification)null);
				return;
			case CHESSContractPackage.CONTRACT_REFINEMENT__UPPER_INDEX_OF_INSTANCE:
				setUpperIndexOfInstance(UPPER_INDEX_OF_INSTANCE_EDEFAULT);
				return;
			case CHESSContractPackage.CONTRACT_REFINEMENT__LOWER_INDEX_OF_INSTANCE:
				setLowerIndexOfInstance(LOWER_INDEX_OF_INSTANCE_EDEFAULT);
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
			case CHESSContractPackage.CONTRACT_REFINEMENT__BASE_DATA_TYPE:
				return base_DataType != null;
			case CHESSContractPackage.CONTRACT_REFINEMENT__INSTANCE:
				return instance != null;
			case CHESSContractPackage.CONTRACT_REFINEMENT__CONTRACT:
				return contract != null;
			case CHESSContractPackage.CONTRACT_REFINEMENT__INSTANCE_SPEC:
				return instanceSpec != null;
			case CHESSContractPackage.CONTRACT_REFINEMENT__UPPER_INDEX_OF_INSTANCE:
				return UPPER_INDEX_OF_INSTANCE_EDEFAULT == null ? upperIndexOfInstance != null : !UPPER_INDEX_OF_INSTANCE_EDEFAULT.equals(upperIndexOfInstance);
			case CHESSContractPackage.CONTRACT_REFINEMENT__LOWER_INDEX_OF_INSTANCE:
				return LOWER_INDEX_OF_INSTANCE_EDEFAULT == null ? lowerIndexOfInstance != null : !LOWER_INDEX_OF_INSTANCE_EDEFAULT.equals(lowerIndexOfInstance);
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
		result.append(" (UpperIndexOfInstance: ");
		result.append(upperIndexOfInstance);
		result.append(", LowerIndexOfInstance: ");
		result.append(lowerIndexOfInstance);
		result.append(')');
		return result.toString();
	}

} // ContractRefinementImpl
