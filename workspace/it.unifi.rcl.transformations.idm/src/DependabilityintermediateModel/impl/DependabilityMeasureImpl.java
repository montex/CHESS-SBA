/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel.impl;

import DependabilityintermediateModel.DependabilityMeasure;
import DependabilityintermediateModel.DependabilityintermediateModelPackage;
import DependabilityintermediateModel.EvaluationType;
import DependabilityintermediateModel.FailureMode;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dependability Measure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link DependabilityintermediateModel.impl.DependabilityMeasureImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link DependabilityintermediateModel.impl.DependabilityMeasureImpl#getEvaluations <em>Evaluations</em>}</li>
 *   <li>{@link DependabilityintermediateModel.impl.DependabilityMeasureImpl#getRequiredMax <em>Required Max</em>}</li>
 *   <li>{@link DependabilityintermediateModel.impl.DependabilityMeasureImpl#getRequiredMin <em>Required Min</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DependabilityMeasureImpl extends NamedElementImpl implements DependabilityMeasure {
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected EList<FailureMode> target;

	/**
	 * The cached value of the '{@link #getEvaluations() <em>Evaluations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvaluations()
	 * @generated
	 * @ordered
	 */
	protected EList<EvaluationType> evaluations;

	/**
	 * The default value of the '{@link #getRequiredMax() <em>Required Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredMax()
	 * @generated
	 * @ordered
	 */
	protected static final double REQUIRED_MAX_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getRequiredMax() <em>Required Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredMax()
	 * @generated
	 * @ordered
	 */
	protected double requiredMax = REQUIRED_MAX_EDEFAULT;

	/**
	 * The default value of the '{@link #getRequiredMin() <em>Required Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredMin()
	 * @generated
	 * @ordered
	 */
	protected static final double REQUIRED_MIN_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getRequiredMin() <em>Required Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredMin()
	 * @generated
	 * @ordered
	 */
	protected double requiredMin = REQUIRED_MIN_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DependabilityMeasureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DependabilityintermediateModelPackage.Literals.DEPENDABILITY_MEASURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FailureMode> getTarget() {
		if (target == null) {
			target = new EObjectResolvingEList<FailureMode>(FailureMode.class, this, DependabilityintermediateModelPackage.DEPENDABILITY_MEASURE__TARGET);
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EvaluationType> getEvaluations() {
		if (evaluations == null) {
			evaluations = new EObjectContainmentEList<EvaluationType>(EvaluationType.class, this, DependabilityintermediateModelPackage.DEPENDABILITY_MEASURE__EVALUATIONS);
		}
		return evaluations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRequiredMax() {
		return requiredMax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiredMax(double newRequiredMax) {
		double oldRequiredMax = requiredMax;
		requiredMax = newRequiredMax;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.DEPENDABILITY_MEASURE__REQUIRED_MAX, oldRequiredMax, requiredMax));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRequiredMin() {
		return requiredMin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiredMin(double newRequiredMin) {
		double oldRequiredMin = requiredMin;
		requiredMin = newRequiredMin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.DEPENDABILITY_MEASURE__REQUIRED_MIN, oldRequiredMin, requiredMin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DependabilityintermediateModelPackage.DEPENDABILITY_MEASURE__EVALUATIONS:
				return ((InternalEList<?>)getEvaluations()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DependabilityintermediateModelPackage.DEPENDABILITY_MEASURE__TARGET:
				return getTarget();
			case DependabilityintermediateModelPackage.DEPENDABILITY_MEASURE__EVALUATIONS:
				return getEvaluations();
			case DependabilityintermediateModelPackage.DEPENDABILITY_MEASURE__REQUIRED_MAX:
				return getRequiredMax();
			case DependabilityintermediateModelPackage.DEPENDABILITY_MEASURE__REQUIRED_MIN:
				return getRequiredMin();
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
			case DependabilityintermediateModelPackage.DEPENDABILITY_MEASURE__TARGET:
				getTarget().clear();
				getTarget().addAll((Collection<? extends FailureMode>)newValue);
				return;
			case DependabilityintermediateModelPackage.DEPENDABILITY_MEASURE__EVALUATIONS:
				getEvaluations().clear();
				getEvaluations().addAll((Collection<? extends EvaluationType>)newValue);
				return;
			case DependabilityintermediateModelPackage.DEPENDABILITY_MEASURE__REQUIRED_MAX:
				setRequiredMax((Double)newValue);
				return;
			case DependabilityintermediateModelPackage.DEPENDABILITY_MEASURE__REQUIRED_MIN:
				setRequiredMin((Double)newValue);
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
			case DependabilityintermediateModelPackage.DEPENDABILITY_MEASURE__TARGET:
				getTarget().clear();
				return;
			case DependabilityintermediateModelPackage.DEPENDABILITY_MEASURE__EVALUATIONS:
				getEvaluations().clear();
				return;
			case DependabilityintermediateModelPackage.DEPENDABILITY_MEASURE__REQUIRED_MAX:
				setRequiredMax(REQUIRED_MAX_EDEFAULT);
				return;
			case DependabilityintermediateModelPackage.DEPENDABILITY_MEASURE__REQUIRED_MIN:
				setRequiredMin(REQUIRED_MIN_EDEFAULT);
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
			case DependabilityintermediateModelPackage.DEPENDABILITY_MEASURE__TARGET:
				return target != null && !target.isEmpty();
			case DependabilityintermediateModelPackage.DEPENDABILITY_MEASURE__EVALUATIONS:
				return evaluations != null && !evaluations.isEmpty();
			case DependabilityintermediateModelPackage.DEPENDABILITY_MEASURE__REQUIRED_MAX:
				return requiredMax != REQUIRED_MAX_EDEFAULT;
			case DependabilityintermediateModelPackage.DEPENDABILITY_MEASURE__REQUIRED_MIN:
				return requiredMin != REQUIRED_MIN_EDEFAULT;
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
		result.append(" (requiredMax: ");
		result.append(requiredMax);
		result.append(", requiredMin: ");
		result.append(requiredMin);
		result.append(')');
		return result.toString();
	}

} //DependabilityMeasureImpl
