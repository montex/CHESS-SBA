/**
 */
package org.polarsys.chess.patterns.profile.PatternsProfile.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.uml2.uml.Collaboration;
import org.polarsys.chess.patterns.profile.PatternsProfile.Pattern;
import org.polarsys.chess.patterns.profile.PatternsProfile.PatternsProfilePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternImpl#getBase_Collaboration <em>Base Collaboration</em>}</li>
 *   <li>{@link org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternImpl#getPatternName <em>Pattern Name</em>}</li>
 *   <li>{@link org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternImpl#getOtherNames <em>Other Names</em>}</li>
 *   <li>{@link org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternImpl#getIntent <em>Intent</em>}</li>
 *   <li>{@link org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternImpl#getProblem <em>Problem</em>}</li>
 *   <li>{@link org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternImpl#getSolution <em>Solution</em>}</li>
 *   <li>{@link org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternImpl#getConsequences <em>Consequences</em>}</li>
 *   <li>{@link org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternImpl#getPatternAssumptions <em>Pattern Assumptions</em>}</li>
 *   <li>{@link org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternImpl#getPatternGuarantees <em>Pattern Guarantees</em>}</li>
 *   <li>{@link org.polarsys.chess.patterns.profile.PatternsProfile.impl.PatternImpl#getPreview <em>Preview</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PatternImpl extends MinimalEObjectImpl.Container implements Pattern {
	/**
	 * The cached value of the '{@link #getBase_Collaboration() <em>Base Collaboration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Collaboration()
	 * @generated
	 * @ordered
	 */
	protected Collaboration base_Collaboration;

	/**
	 * The default value of the '{@link #getPatternName() <em>Pattern Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPatternName()
	 * @generated
	 * @ordered
	 */
	protected static final String PATTERN_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPatternName() <em>Pattern Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPatternName()
	 * @generated
	 * @ordered
	 */
	protected String patternName = PATTERN_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOtherNames() <em>Other Names</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOtherNames()
	 * @generated
	 * @ordered
	 */
	protected EList<String> otherNames;

	/**
	 * The default value of the '{@link #getIntent() <em>Intent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntent()
	 * @generated
	 * @ordered
	 */
	protected static final String INTENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIntent() <em>Intent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntent()
	 * @generated
	 * @ordered
	 */
	protected String intent = INTENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getProblem() <em>Problem</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProblem()
	 * @generated
	 * @ordered
	 */
	protected static final String PROBLEM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProblem() <em>Problem</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProblem()
	 * @generated
	 * @ordered
	 */
	protected String problem = PROBLEM_EDEFAULT;

	/**
	 * The default value of the '{@link #getSolution() <em>Solution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolution()
	 * @generated
	 * @ordered
	 */
	protected static final String SOLUTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSolution() <em>Solution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolution()
	 * @generated
	 * @ordered
	 */
	protected String solution = SOLUTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConsequences() <em>Consequences</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsequences()
	 * @generated
	 * @ordered
	 */
	protected EList<String> consequences;

	/**
	 * The cached value of the '{@link #getImplementation() <em>Implementation</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementation()
	 * @generated
	 * @ordered
	 */
	protected EList<String> implementation;

	/**
	 * The cached value of the '{@link #getPatternAssumptions() <em>Pattern Assumptions</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPatternAssumptions()
	 * @generated
	 * @ordered
	 */
	protected EList<String> patternAssumptions;

	/**
	 * The cached value of the '{@link #getPatternGuarantees() <em>Pattern Guarantees</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPatternGuarantees()
	 * @generated
	 * @ordered
	 */
	protected EList<String> patternGuarantees;

	/**
	 * The default value of the '{@link #getPreview() <em>Preview</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreview()
	 * @generated
	 * @ordered
	 */
	protected static final String PREVIEW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPreview() <em>Preview</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreview()
	 * @generated
	 * @ordered
	 */
	protected String preview = PREVIEW_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PatternsProfilePackage.Literals.PATTERN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collaboration getBase_Collaboration() {
		if (base_Collaboration != null && base_Collaboration.eIsProxy()) {
			InternalEObject oldBase_Collaboration = (InternalEObject)base_Collaboration;
			base_Collaboration = (Collaboration)eResolveProxy(oldBase_Collaboration);
			if (base_Collaboration != oldBase_Collaboration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PatternsProfilePackage.PATTERN__BASE_COLLABORATION, oldBase_Collaboration, base_Collaboration));
			}
		}
		return base_Collaboration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collaboration basicGetBase_Collaboration() {
		return base_Collaboration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Collaboration(Collaboration newBase_Collaboration) {
		Collaboration oldBase_Collaboration = base_Collaboration;
		base_Collaboration = newBase_Collaboration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PatternsProfilePackage.PATTERN__BASE_COLLABORATION, oldBase_Collaboration, base_Collaboration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPatternName() {
		return patternName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPatternName(String newPatternName) {
		String oldPatternName = patternName;
		patternName = newPatternName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PatternsProfilePackage.PATTERN__PATTERN_NAME, oldPatternName, patternName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getOtherNames() {
		if (otherNames == null) {
			otherNames = new EDataTypeUniqueEList<String>(String.class, this, PatternsProfilePackage.PATTERN__OTHER_NAMES);
		}
		return otherNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIntent() {
		return intent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntent(String newIntent) {
		String oldIntent = intent;
		intent = newIntent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PatternsProfilePackage.PATTERN__INTENT, oldIntent, intent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProblem() {
		return problem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProblem(String newProblem) {
		String oldProblem = problem;
		problem = newProblem;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PatternsProfilePackage.PATTERN__PROBLEM, oldProblem, problem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSolution() {
		return solution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSolution(String newSolution) {
		String oldSolution = solution;
		solution = newSolution;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PatternsProfilePackage.PATTERN__SOLUTION, oldSolution, solution));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getConsequences() {
		if (consequences == null) {
			consequences = new EDataTypeUniqueEList<String>(String.class, this, PatternsProfilePackage.PATTERN__CONSEQUENCES);
		}
		return consequences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getImplementation() {
		if (implementation == null) {
			implementation = new EDataTypeUniqueEList<String>(String.class, this, PatternsProfilePackage.PATTERN__IMPLEMENTATION);
		}
		return implementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getPatternAssumptions() {
		if (patternAssumptions == null) {
			patternAssumptions = new EDataTypeUniqueEList<String>(String.class, this, PatternsProfilePackage.PATTERN__PATTERN_ASSUMPTIONS);
		}
		return patternAssumptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getPatternGuarantees() {
		if (patternGuarantees == null) {
			patternGuarantees = new EDataTypeUniqueEList<String>(String.class, this, PatternsProfilePackage.PATTERN__PATTERN_GUARANTEES);
		}
		return patternGuarantees;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPreview() {
		return preview;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreview(String newPreview) {
		String oldPreview = preview;
		preview = newPreview;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PatternsProfilePackage.PATTERN__PREVIEW, oldPreview, preview));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PatternsProfilePackage.PATTERN__BASE_COLLABORATION:
				if (resolve) return getBase_Collaboration();
				return basicGetBase_Collaboration();
			case PatternsProfilePackage.PATTERN__PATTERN_NAME:
				return getPatternName();
			case PatternsProfilePackage.PATTERN__OTHER_NAMES:
				return getOtherNames();
			case PatternsProfilePackage.PATTERN__INTENT:
				return getIntent();
			case PatternsProfilePackage.PATTERN__PROBLEM:
				return getProblem();
			case PatternsProfilePackage.PATTERN__SOLUTION:
				return getSolution();
			case PatternsProfilePackage.PATTERN__CONSEQUENCES:
				return getConsequences();
			case PatternsProfilePackage.PATTERN__IMPLEMENTATION:
				return getImplementation();
			case PatternsProfilePackage.PATTERN__PATTERN_ASSUMPTIONS:
				return getPatternAssumptions();
			case PatternsProfilePackage.PATTERN__PATTERN_GUARANTEES:
				return getPatternGuarantees();
			case PatternsProfilePackage.PATTERN__PREVIEW:
				return getPreview();
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
			case PatternsProfilePackage.PATTERN__BASE_COLLABORATION:
				setBase_Collaboration((Collaboration)newValue);
				return;
			case PatternsProfilePackage.PATTERN__PATTERN_NAME:
				setPatternName((String)newValue);
				return;
			case PatternsProfilePackage.PATTERN__OTHER_NAMES:
				getOtherNames().clear();
				getOtherNames().addAll((Collection<? extends String>)newValue);
				return;
			case PatternsProfilePackage.PATTERN__INTENT:
				setIntent((String)newValue);
				return;
			case PatternsProfilePackage.PATTERN__PROBLEM:
				setProblem((String)newValue);
				return;
			case PatternsProfilePackage.PATTERN__SOLUTION:
				setSolution((String)newValue);
				return;
			case PatternsProfilePackage.PATTERN__CONSEQUENCES:
				getConsequences().clear();
				getConsequences().addAll((Collection<? extends String>)newValue);
				return;
			case PatternsProfilePackage.PATTERN__IMPLEMENTATION:
				getImplementation().clear();
				getImplementation().addAll((Collection<? extends String>)newValue);
				return;
			case PatternsProfilePackage.PATTERN__PATTERN_ASSUMPTIONS:
				getPatternAssumptions().clear();
				getPatternAssumptions().addAll((Collection<? extends String>)newValue);
				return;
			case PatternsProfilePackage.PATTERN__PATTERN_GUARANTEES:
				getPatternGuarantees().clear();
				getPatternGuarantees().addAll((Collection<? extends String>)newValue);
				return;
			case PatternsProfilePackage.PATTERN__PREVIEW:
				setPreview((String)newValue);
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
			case PatternsProfilePackage.PATTERN__BASE_COLLABORATION:
				setBase_Collaboration((Collaboration)null);
				return;
			case PatternsProfilePackage.PATTERN__PATTERN_NAME:
				setPatternName(PATTERN_NAME_EDEFAULT);
				return;
			case PatternsProfilePackage.PATTERN__OTHER_NAMES:
				getOtherNames().clear();
				return;
			case PatternsProfilePackage.PATTERN__INTENT:
				setIntent(INTENT_EDEFAULT);
				return;
			case PatternsProfilePackage.PATTERN__PROBLEM:
				setProblem(PROBLEM_EDEFAULT);
				return;
			case PatternsProfilePackage.PATTERN__SOLUTION:
				setSolution(SOLUTION_EDEFAULT);
				return;
			case PatternsProfilePackage.PATTERN__CONSEQUENCES:
				getConsequences().clear();
				return;
			case PatternsProfilePackage.PATTERN__IMPLEMENTATION:
				getImplementation().clear();
				return;
			case PatternsProfilePackage.PATTERN__PATTERN_ASSUMPTIONS:
				getPatternAssumptions().clear();
				return;
			case PatternsProfilePackage.PATTERN__PATTERN_GUARANTEES:
				getPatternGuarantees().clear();
				return;
			case PatternsProfilePackage.PATTERN__PREVIEW:
				setPreview(PREVIEW_EDEFAULT);
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
			case PatternsProfilePackage.PATTERN__BASE_COLLABORATION:
				return base_Collaboration != null;
			case PatternsProfilePackage.PATTERN__PATTERN_NAME:
				return PATTERN_NAME_EDEFAULT == null ? patternName != null : !PATTERN_NAME_EDEFAULT.equals(patternName);
			case PatternsProfilePackage.PATTERN__OTHER_NAMES:
				return otherNames != null && !otherNames.isEmpty();
			case PatternsProfilePackage.PATTERN__INTENT:
				return INTENT_EDEFAULT == null ? intent != null : !INTENT_EDEFAULT.equals(intent);
			case PatternsProfilePackage.PATTERN__PROBLEM:
				return PROBLEM_EDEFAULT == null ? problem != null : !PROBLEM_EDEFAULT.equals(problem);
			case PatternsProfilePackage.PATTERN__SOLUTION:
				return SOLUTION_EDEFAULT == null ? solution != null : !SOLUTION_EDEFAULT.equals(solution);
			case PatternsProfilePackage.PATTERN__CONSEQUENCES:
				return consequences != null && !consequences.isEmpty();
			case PatternsProfilePackage.PATTERN__IMPLEMENTATION:
				return implementation != null && !implementation.isEmpty();
			case PatternsProfilePackage.PATTERN__PATTERN_ASSUMPTIONS:
				return patternAssumptions != null && !patternAssumptions.isEmpty();
			case PatternsProfilePackage.PATTERN__PATTERN_GUARANTEES:
				return patternGuarantees != null && !patternGuarantees.isEmpty();
			case PatternsProfilePackage.PATTERN__PREVIEW:
				return PREVIEW_EDEFAULT == null ? preview != null : !PREVIEW_EDEFAULT.equals(preview);
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
		result.append(" (patternName: ");
		result.append(patternName);
		result.append(", otherNames: ");
		result.append(otherNames);
		result.append(", intent: ");
		result.append(intent);
		result.append(", problem: ");
		result.append(problem);
		result.append(", solution: ");
		result.append(solution);
		result.append(", consequences: ");
		result.append(consequences);
		result.append(", implementation: ");
		result.append(implementation);
		result.append(", patternAssumptions: ");
		result.append(patternAssumptions);
		result.append(", patternGuarantees: ");
		result.append(patternGuarantees);
		result.append(", preview: ");
		result.append(preview);
		result.append(')');
		return result.toString();
	}

} //PatternImpl
