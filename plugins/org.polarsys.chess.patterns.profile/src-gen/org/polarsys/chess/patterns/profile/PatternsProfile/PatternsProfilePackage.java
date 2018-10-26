/**
 */
package org.polarsys.chess.patterns.profile.PatternsProfile;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.patterns.profile.PatternsProfile.PatternsProfileFactory
 * @model kind="package"
 * @generated
 */
public interface PatternsProfilePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "PatternsProfile";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///PatternsProfile.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "PatternsProfile";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PatternsProfilePackage eINSTANCE = org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternsProfilePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternImpl <em>Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternImpl
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternsProfilePackageImpl#getPattern()
	 * @generated
	 */
	int PATTERN = 0;

	/**
	 * The feature id for the '<em><b>Base Collaboration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__BASE_COLLABORATION = 0;

	/**
	 * The feature id for the '<em><b>Pattern Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__PATTERN_NAME = 1;

	/**
	 * The feature id for the '<em><b>Other Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__OTHER_NAMES = 2;

	/**
	 * The feature id for the '<em><b>Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__INTENT = 3;

	/**
	 * The feature id for the '<em><b>Problem</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__PROBLEM = 4;

	/**
	 * The feature id for the '<em><b>Solution</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__SOLUTION = 5;

	/**
	 * The feature id for the '<em><b>Consequences</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__CONSEQUENCES = 6;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__IMPLEMENTATION = 7;

	/**
	 * The feature id for the '<em><b>Pattern Assumptions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__PATTERN_ASSUMPTIONS = 8;

	/**
	 * The feature id for the '<em><b>Pattern Guarantees</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__PATTERN_GUARANTEES = 9;

	/**
	 * The feature id for the '<em><b>Preview</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__PREVIEW = 10;

	/**
	 * The number of structural features of the '<em>Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_FEATURE_COUNT = 11;

	/**
	 * The number of operations of the '<em>Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternApplicationImpl <em>Pattern Application</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternApplicationImpl
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternsProfilePackageImpl#getPatternApplication()
	 * @generated
	 */
	int PATTERN_APPLICATION = 1;

	/**
	 * The feature id for the '<em><b>Applied Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_APPLICATION__APPLIED_PATTERN = 0;

	/**
	 * The feature id for the '<em><b>Base Collaboration Use</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_APPLICATION__BASE_COLLABORATION_USE = 1;

	/**
	 * The number of structural features of the '<em>Pattern Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_APPLICATION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Pattern Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_APPLICATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternRoleImpl <em>Pattern Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternRoleImpl
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternsProfilePackageImpl#getPatternRole()
	 * @generated
	 */
	int PATTERN_ROLE = 2;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_ROLE__BASE_NAMED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Applied Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_ROLE__APPLIED_PATTERN = 1;

	/**
	 * The feature id for the '<em><b>Mapped Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_ROLE__MAPPED_ROLE = 2;

	/**
	 * The number of structural features of the '<em>Pattern Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_ROLE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Pattern Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_ROLE_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.patterns.profile.PatternsProfile.Pattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern</em>'.
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.Pattern
	 * @generated
	 */
	EClass getPattern();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getBase_Collaboration <em>Base Collaboration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Collaboration</em>'.
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getBase_Collaboration()
	 * @see #getPattern()
	 * @generated
	 */
	EReference getPattern_Base_Collaboration();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getPatternName <em>Pattern Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pattern Name</em>'.
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getPatternName()
	 * @see #getPattern()
	 * @generated
	 */
	EAttribute getPattern_PatternName();

	/**
	 * Returns the meta object for the attribute list '{@link org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getOtherNames <em>Other Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Other Names</em>'.
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getOtherNames()
	 * @see #getPattern()
	 * @generated
	 */
	EAttribute getPattern_OtherNames();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getIntent <em>Intent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Intent</em>'.
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getIntent()
	 * @see #getPattern()
	 * @generated
	 */
	EAttribute getPattern_Intent();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getProblem <em>Problem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Problem</em>'.
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getProblem()
	 * @see #getPattern()
	 * @generated
	 */
	EAttribute getPattern_Problem();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getSolution <em>Solution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Solution</em>'.
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getSolution()
	 * @see #getPattern()
	 * @generated
	 */
	EAttribute getPattern_Solution();

	/**
	 * Returns the meta object for the attribute list '{@link org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getConsequences <em>Consequences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Consequences</em>'.
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getConsequences()
	 * @see #getPattern()
	 * @generated
	 */
	EAttribute getPattern_Consequences();

	/**
	 * Returns the meta object for the attribute list '{@link org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getImplementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Implementation</em>'.
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getImplementation()
	 * @see #getPattern()
	 * @generated
	 */
	EAttribute getPattern_Implementation();

	/**
	 * Returns the meta object for the attribute list '{@link org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getPatternAssumptions <em>Pattern Assumptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Pattern Assumptions</em>'.
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getPatternAssumptions()
	 * @see #getPattern()
	 * @generated
	 */
	EAttribute getPattern_PatternAssumptions();

	/**
	 * Returns the meta object for the attribute list '{@link org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getPatternGuarantees <em>Pattern Guarantees</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Pattern Guarantees</em>'.
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getPatternGuarantees()
	 * @see #getPattern()
	 * @generated
	 */
	EAttribute getPattern_PatternGuarantees();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getPreview <em>Preview</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Preview</em>'.
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.Pattern#getPreview()
	 * @see #getPattern()
	 * @generated
	 */
	EAttribute getPattern_Preview();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.patterns.profile.PatternsProfile.PatternApplication <em>Pattern Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Application</em>'.
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.PatternApplication
	 * @generated
	 */
	EClass getPatternApplication();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.patterns.profile.PatternsProfile.PatternApplication#getAppliedPattern <em>Applied Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Applied Pattern</em>'.
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.PatternApplication#getAppliedPattern()
	 * @see #getPatternApplication()
	 * @generated
	 */
	EAttribute getPatternApplication_AppliedPattern();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.patterns.profile.PatternsProfile.PatternApplication#getBase_CollaborationUse <em>Base Collaboration Use</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Collaboration Use</em>'.
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.PatternApplication#getBase_CollaborationUse()
	 * @see #getPatternApplication()
	 * @generated
	 */
	EReference getPatternApplication_Base_CollaborationUse();

	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.patterns.profile.PatternsProfile.PatternRole <em>Pattern Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Role</em>'.
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.PatternRole
	 * @generated
	 */
	EClass getPatternRole();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.patterns.profile.PatternsProfile.PatternRole#getBase_NamedElement <em>Base Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Named Element</em>'.
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.PatternRole#getBase_NamedElement()
	 * @see #getPatternRole()
	 * @generated
	 */
	EReference getPatternRole_Base_NamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.patterns.profile.PatternsProfile.PatternRole#getAppliedPattern <em>Applied Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Applied Pattern</em>'.
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.PatternRole#getAppliedPattern()
	 * @see #getPatternRole()
	 * @generated
	 */
	EAttribute getPatternRole_AppliedPattern();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.patterns.profile.PatternsProfile.PatternRole#getMappedRole <em>Mapped Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mapped Role</em>'.
	 * @see org.polarsys.chess.patterns.profile.PatternsProfile.PatternRole#getMappedRole()
	 * @see #getPatternRole()
	 * @generated
	 */
	EAttribute getPatternRole_MappedRole();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PatternsProfileFactory getPatternsProfileFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternImpl <em>Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternImpl
		 * @see org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternsProfilePackageImpl#getPattern()
		 * @generated
		 */
		EClass PATTERN = eINSTANCE.getPattern();

		/**
		 * The meta object literal for the '<em><b>Base Collaboration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN__BASE_COLLABORATION = eINSTANCE.getPattern_Base_Collaboration();

		/**
		 * The meta object literal for the '<em><b>Pattern Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN__PATTERN_NAME = eINSTANCE.getPattern_PatternName();

		/**
		 * The meta object literal for the '<em><b>Other Names</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN__OTHER_NAMES = eINSTANCE.getPattern_OtherNames();

		/**
		 * The meta object literal for the '<em><b>Intent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN__INTENT = eINSTANCE.getPattern_Intent();

		/**
		 * The meta object literal for the '<em><b>Problem</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN__PROBLEM = eINSTANCE.getPattern_Problem();

		/**
		 * The meta object literal for the '<em><b>Solution</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN__SOLUTION = eINSTANCE.getPattern_Solution();

		/**
		 * The meta object literal for the '<em><b>Consequences</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN__CONSEQUENCES = eINSTANCE.getPattern_Consequences();

		/**
		 * The meta object literal for the '<em><b>Implementation</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN__IMPLEMENTATION = eINSTANCE.getPattern_Implementation();

		/**
		 * The meta object literal for the '<em><b>Pattern Assumptions</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN__PATTERN_ASSUMPTIONS = eINSTANCE.getPattern_PatternAssumptions();

		/**
		 * The meta object literal for the '<em><b>Pattern Guarantees</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN__PATTERN_GUARANTEES = eINSTANCE.getPattern_PatternGuarantees();

		/**
		 * The meta object literal for the '<em><b>Preview</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN__PREVIEW = eINSTANCE.getPattern_Preview();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternApplicationImpl <em>Pattern Application</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternApplicationImpl
		 * @see org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternsProfilePackageImpl#getPatternApplication()
		 * @generated
		 */
		EClass PATTERN_APPLICATION = eINSTANCE.getPatternApplication();

		/**
		 * The meta object literal for the '<em><b>Applied Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN_APPLICATION__APPLIED_PATTERN = eINSTANCE.getPatternApplication_AppliedPattern();

		/**
		 * The meta object literal for the '<em><b>Base Collaboration Use</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_APPLICATION__BASE_COLLABORATION_USE = eINSTANCE.getPatternApplication_Base_CollaborationUse();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternRoleImpl <em>Pattern Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternRoleImpl
		 * @see org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternsProfilePackageImpl#getPatternRole()
		 * @generated
		 */
		EClass PATTERN_ROLE = eINSTANCE.getPatternRole();

		/**
		 * The meta object literal for the '<em><b>Base Named Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_ROLE__BASE_NAMED_ELEMENT = eINSTANCE.getPatternRole_Base_NamedElement();

		/**
		 * The meta object literal for the '<em><b>Applied Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN_ROLE__APPLIED_PATTERN = eINSTANCE.getPatternRole_AppliedPattern();

		/**
		 * The meta object literal for the '<em><b>Mapped Role</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN_ROLE__MAPPED_ROLE = eINSTANCE.getPatternRole_MappedRole();

	}

} //PatternsProfilePackage
