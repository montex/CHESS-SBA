/**
 */
package org.polarsys.chess.contracts.profile.chesscontract;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 * @see org.polarsys.chess.contracts.profile.chesscontract.CHESSContractPackage
 * @generated
 */
public interface CHESSContractFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	CHESSContractFactory eINSTANCE = org.polarsys.chess.contracts.profile.chesscontract.impl.CHESSContractFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>System</em>'.
	 * @generated
	 */
	System createSystem();

	/**
	 * Returns a new object of class '<em>Contract</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Contract</em>'.
	 * @generated
	 */
	Contract createContract();

	/**
	 * Returns a new object of class '<em>Formal Property</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Formal Property</em>'.
	 * @generated
	 */
	FormalProperty createFormalProperty();

	/**
	 * Returns a new object of class '<em>Contract Refinement Analysis Context</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Contract Refinement Analysis Context</em>'.
	 * @generated
	 */
	ContractRefinementAnalysisContext createContractRefinementAnalysisContext();

	/**
	 * Returns a new object of class '<em>Formalize</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Formalize</em>'.
	 * @generated
	 */
	Formalize createFormalize();

	/**
	 * Returns a new object of class '<em>Sub System</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub System</em>'.
	 * @generated
	 */
	SubSystem createSubSystem();

	/**
	 * Returns a new object of class '<em>CHESS Requirement</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>CHESS Requirement</em>'.
	 * @generated
	 */
	CHESSRequirement createCHESSRequirement();

	/**
	 * Returns a new object of class '<em>Contract Property</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Contract Property</em>'.
	 * @generated
	 */
	ContractProperty createContractProperty();

	/**
	 * Returns a new object of class '<em>Contract Refinement</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Contract Refinement</em>'.
	 * @generated
	 */
	ContractRefinement createContractRefinement();

	/**
	 * Returns a new object of class '<em>Delegation Constraint</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Delegation Constraint</em>'.
	 * @generated
	 */
	DelegationConstraint createDelegationConstraint();

	/**
	 * Returns a new object of class '<em>SRA Component</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>SRA Component</em>'.
	 * @generated
	 */
	SRAComponent createSRAComponent();

	/**
	 * Returns a new object of class '<em>Component Instance</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Component Instance</em>'.
	 * @generated
	 */
	ComponentInstance createComponentInstance();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CHESSContractPackage getCHESSContractPackage();

} // CHESSContractFactory
