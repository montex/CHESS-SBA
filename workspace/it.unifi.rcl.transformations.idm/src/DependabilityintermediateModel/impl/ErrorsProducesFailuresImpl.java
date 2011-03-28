/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel.impl;

import DependabilityintermediateModel.Component;
import DependabilityintermediateModel.DependabilityintermediateModelPackage;
import DependabilityintermediateModel.Distribution;
import DependabilityintermediateModel.ErrorsProducesFailures;
import DependabilityintermediateModel.FailureMode;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Errors Produces Failures</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link DependabilityintermediateModel.impl.ErrorsProducesFailuresImpl#getSource <em>Source</em>}</li>
 *   <li>{@link DependabilityintermediateModel.impl.ErrorsProducesFailuresImpl#getDestination <em>Destination</em>}</li>
 *   <li>{@link DependabilityintermediateModel.impl.ErrorsProducesFailuresImpl#getPropagationDelay <em>Propagation Delay</em>}</li>
 *   <li>{@link DependabilityintermediateModel.impl.ErrorsProducesFailuresImpl#getWeight <em>Weight</em>}</li>
 *   <li>{@link DependabilityintermediateModel.impl.ErrorsProducesFailuresImpl#getPropagationProbability <em>Propagation Probability</em>}</li>
 *   <li>{@link DependabilityintermediateModel.impl.ErrorsProducesFailuresImpl#getComponent <em>Component</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ErrorsProducesFailuresImpl extends ErrorPropagationImpl implements ErrorsProducesFailures {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected EList<DependabilityintermediateModel.Error> source;

	/**
	 * The cached value of the '{@link #getDestination() <em>Destination</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestination()
	 * @generated
	 * @ordered
	 */
	protected EList<FailureMode> destination;

	/**
	 * The cached value of the '{@link #getPropagationDelay() <em>Propagation Delay</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropagationDelay()
	 * @generated
	 * @ordered
	 */
	protected Distribution propagationDelay;

	/**
	 * The default value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected static final double WEIGHT_EDEFAULT = 1.0;

	/**
	 * The cached value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected double weight = WEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getPropagationProbability() <em>Propagation Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropagationProbability()
	 * @generated
	 * @ordered
	 */
	protected static final double PROPAGATION_PROBABILITY_EDEFAULT = 1.0;

	/**
	 * The cached value of the '{@link #getPropagationProbability() <em>Propagation Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropagationProbability()
	 * @generated
	 * @ordered
	 */
	protected double propagationProbability = PROPAGATION_PROBABILITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ErrorsProducesFailuresImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DependabilityintermediateModelPackage.Literals.ERRORS_PRODUCES_FAILURES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DependabilityintermediateModel.Error> getSource() {
		if (source == null) {
			source = new EObjectResolvingEList<DependabilityintermediateModel.Error>(DependabilityintermediateModel.Error.class, this, DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__SOURCE);
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FailureMode> getDestination() {
		if (destination == null) {
			destination = new EObjectResolvingEList<FailureMode>(FailureMode.class, this, DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__DESTINATION);
		}
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Distribution getPropagationDelay() {
		return propagationDelay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPropagationDelay(Distribution newPropagationDelay, NotificationChain msgs) {
		Distribution oldPropagationDelay = propagationDelay;
		propagationDelay = newPropagationDelay;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__PROPAGATION_DELAY, oldPropagationDelay, newPropagationDelay);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropagationDelay(Distribution newPropagationDelay) {
		if (newPropagationDelay != propagationDelay) {
			NotificationChain msgs = null;
			if (propagationDelay != null)
				msgs = ((InternalEObject)propagationDelay).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__PROPAGATION_DELAY, null, msgs);
			if (newPropagationDelay != null)
				msgs = ((InternalEObject)newPropagationDelay).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__PROPAGATION_DELAY, null, msgs);
			msgs = basicSetPropagationDelay(newPropagationDelay, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__PROPAGATION_DELAY, newPropagationDelay, newPropagationDelay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWeight(double newWeight) {
		double oldWeight = weight;
		weight = newWeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__WEIGHT, oldWeight, weight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPropagationProbability() {
		return propagationProbability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropagationProbability(double newPropagationProbability) {
		double oldPropagationProbability = propagationProbability;
		propagationProbability = newPropagationProbability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__PROPAGATION_PROBABILITY, oldPropagationProbability, propagationProbability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component getComponent() {
		if (eContainerFeatureID() != DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__COMPONENT) return null;
		return (Component)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComponent(Component newComponent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newComponent, DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__COMPONENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponent(Component newComponent) {
		if (newComponent != eInternalContainer() || (eContainerFeatureID() != DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__COMPONENT && newComponent != null)) {
			if (EcoreUtil.isAncestor(this, newComponent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newComponent != null)
				msgs = ((InternalEObject)newComponent).eInverseAdd(this, DependabilityintermediateModelPackage.COMPONENT__ERRORS_GENERATES_FAILURES, Component.class, msgs);
			msgs = basicSetComponent(newComponent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__COMPONENT, newComponent, newComponent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__COMPONENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetComponent((Component)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__PROPAGATION_DELAY:
				return basicSetPropagationDelay(null, msgs);
			case DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__COMPONENT:
				return basicSetComponent(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__COMPONENT:
				return eInternalContainer().eInverseRemove(this, DependabilityintermediateModelPackage.COMPONENT__ERRORS_GENERATES_FAILURES, Component.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__SOURCE:
				return getSource();
			case DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__DESTINATION:
				return getDestination();
			case DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__PROPAGATION_DELAY:
				return getPropagationDelay();
			case DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__WEIGHT:
				return getWeight();
			case DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__PROPAGATION_PROBABILITY:
				return getPropagationProbability();
			case DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__COMPONENT:
				return getComponent();
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
			case DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__SOURCE:
				getSource().clear();
				getSource().addAll((Collection<? extends DependabilityintermediateModel.Error>)newValue);
				return;
			case DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__DESTINATION:
				getDestination().clear();
				getDestination().addAll((Collection<? extends FailureMode>)newValue);
				return;
			case DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__PROPAGATION_DELAY:
				setPropagationDelay((Distribution)newValue);
				return;
			case DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__WEIGHT:
				setWeight((Double)newValue);
				return;
			case DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__PROPAGATION_PROBABILITY:
				setPropagationProbability((Double)newValue);
				return;
			case DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__COMPONENT:
				setComponent((Component)newValue);
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
			case DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__SOURCE:
				getSource().clear();
				return;
			case DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__DESTINATION:
				getDestination().clear();
				return;
			case DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__PROPAGATION_DELAY:
				setPropagationDelay((Distribution)null);
				return;
			case DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__WEIGHT:
				setWeight(WEIGHT_EDEFAULT);
				return;
			case DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__PROPAGATION_PROBABILITY:
				setPropagationProbability(PROPAGATION_PROBABILITY_EDEFAULT);
				return;
			case DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__COMPONENT:
				setComponent((Component)null);
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
			case DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__SOURCE:
				return source != null && !source.isEmpty();
			case DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__DESTINATION:
				return destination != null && !destination.isEmpty();
			case DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__PROPAGATION_DELAY:
				return propagationDelay != null;
			case DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__WEIGHT:
				return weight != WEIGHT_EDEFAULT;
			case DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__PROPAGATION_PROBABILITY:
				return propagationProbability != PROPAGATION_PROBABILITY_EDEFAULT;
			case DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES__COMPONENT:
				return getComponent() != null;
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
		result.append(" (Weight: ");
		result.append(weight);
		result.append(", PropagationProbability: ");
		result.append(propagationProbability);
		result.append(')');
		return result.toString();
	}

} //ErrorsProducesFailuresImpl
