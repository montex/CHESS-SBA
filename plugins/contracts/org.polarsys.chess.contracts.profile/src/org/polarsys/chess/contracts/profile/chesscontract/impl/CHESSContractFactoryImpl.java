/**
 */
package org.polarsys.chess.contracts.profile.chesscontract.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polarsys.chess.contracts.profile.chesscontract.CHESSContractFactory;
import org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage;
import org.polarsys.chess.contracts.profile.chesscontract.CHESSRequirement;
import org.polarsys.chess.contracts.profile.chesscontract.ComponentInstance;
import org.polarsys.chess.contracts.profile.chesscontract.Contract;
import org.polarsys.chess.contracts.profile.chesscontract.ContractProperty;
import org.polarsys.chess.contracts.profile.chesscontract.ContractRefinement;
import org.polarsys.chess.contracts.profile.chesscontract.ContractRefinementAnalysisContext;
import org.polarsys.chess.contracts.profile.chesscontract.DelegationConstraint;
import org.polarsys.chess.contracts.profile.chesscontract.FormalProperty;
import org.polarsys.chess.contracts.profile.chesscontract.Formalize;
import org.polarsys.chess.contracts.profile.chesscontract.SRAComponent;
import org.polarsys.chess.contracts.profile.chesscontract.SubSystem;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class CHESSContractFactoryImpl extends EFactoryImpl implements CHESSContractFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static CHESSContractFactory init() {
		try {
			CHESSContractFactory theCHESSContractFactory = (CHESSContractFactory)EPackage.Registry.INSTANCE.getEFactory(CHESSContractPackage.eNS_URI);
			if (theCHESSContractFactory != null) {
				return theCHESSContractFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CHESSContractFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public CHESSContractFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CHESSContractPackage.COMPONENT_INSTANCE: return createComponentInstance();
			case CHESSContractPackage.CONTRACT_PROPERTY: return createContractProperty();
			case CHESSContractPackage.CONTRACT_REFINEMENT: return createContractRefinement();
			case CHESSContractPackage.FORMAL_PROPERTY: return createFormalProperty();
			case CHESSContractPackage.CONTRACT_REFINEMENT_ANALYSIS_CONTEXT: return createContractRefinementAnalysisContext();
			case CHESSContractPackage.SYSTEM: return createSystem();
			case CHESSContractPackage.CONTRACT: return createContract();
			case CHESSContractPackage.FORMALIZE: return createFormalize();
			case CHESSContractPackage.SUB_SYSTEM: return createSubSystem();
			case CHESSContractPackage.CHESS_REQUIREMENT: return createCHESSRequirement();
			case CHESSContractPackage.DELEGATION_CONSTRAINT: return createDelegationConstraint();
			case CHESSContractPackage.SRA_COMPONENT: return createSRAComponent();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public org.polarsys.chess.contracts.profile.chesscontract.System createSystem() {
		SystemImpl system = new SystemImpl();
		return system;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Contract createContract() {
		ContractImpl contract = new ContractImpl();
		return contract;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FormalProperty createFormalProperty() {
		FormalPropertyImpl formalProperty = new FormalPropertyImpl();
		return formalProperty;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ContractRefinementAnalysisContext createContractRefinementAnalysisContext() {
		ContractRefinementAnalysisContextImpl contractRefinementAnalysisContext = new ContractRefinementAnalysisContextImpl();
		return contractRefinementAnalysisContext;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Formalize createFormalize() {
		FormalizeImpl formalize = new FormalizeImpl();
		return formalize;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SubSystem createSubSystem() {
		SubSystemImpl subSystem = new SubSystemImpl();
		return subSystem;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CHESSRequirement createCHESSRequirement() {
		CHESSRequirementImpl chessRequirement = new CHESSRequirementImpl();
		return chessRequirement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ContractProperty createContractProperty() {
		ContractPropertyImpl contractProperty = new ContractPropertyImpl();
		return contractProperty;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ContractRefinement createContractRefinement() {
		ContractRefinementImpl contractRefinement = new ContractRefinementImpl();
		return contractRefinement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DelegationConstraint createDelegationConstraint() {
		DelegationConstraintImpl delegationConstraint = new DelegationConstraintImpl();
		return delegationConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SRAComponent createSRAComponent() {
		SRAComponentImpl sraComponent = new SRAComponentImpl();
		return sraComponent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentInstance createComponentInstance() {
		ComponentInstanceImpl componentInstance = new ComponentInstanceImpl();
		return componentInstance;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CHESSContractPackage getCHESSContractPackage() {
		return (CHESSContractPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CHESSContractPackage getPackage() {
		return CHESSContractPackage.eINSTANCE;
	}

} // CHESSContractFactoryImpl
