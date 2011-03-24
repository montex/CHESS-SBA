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
import DependabilityintermediateModel.Fault;
import DependabilityintermediateModel.FaultsExpressionNode;
import DependabilityintermediateModel.FaultsGenerateErrors;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Faults Generate Errors</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link DependabilityintermediateModel.impl.FaultsGenerateErrorsImpl#getSource <em>Source</em>}</li>
 *   <li>{@link DependabilityintermediateModel.impl.FaultsGenerateErrorsImpl#getDestination <em>Destination</em>}</li>
 *   <li>{@link DependabilityintermediateModel.impl.FaultsGenerateErrorsImpl#getActivationDelay <em>Activation Delay</em>}</li>
 *   <li>{@link DependabilityintermediateModel.impl.FaultsGenerateErrorsImpl#getPropagationProbability <em>Propagation Probability</em>}</li>
 *   <li>{@link DependabilityintermediateModel.impl.FaultsGenerateErrorsImpl#getPropagationLogic <em>Propagation Logic</em>}</li>
 *   <li>{@link DependabilityintermediateModel.impl.FaultsGenerateErrorsImpl#getWeight <em>Weight</em>}</li>
 *   <li>{@link DependabilityintermediateModel.impl.FaultsGenerateErrorsImpl#getPropagationLogicStringFormat <em>Propagation Logic String Format</em>}</li>
 *   <li>{@link DependabilityintermediateModel.impl.FaultsGenerateErrorsImpl#getComponent <em>Component</em>}</li>
 *   <li>{@link DependabilityintermediateModel.impl.FaultsGenerateErrorsImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FaultsGenerateErrorsImpl extends EObjectImpl implements FaultsGenerateErrors {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected EList<Fault> source;

	/**
	 * The cached value of the '{@link #getDestination() <em>Destination</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestination()
	 * @generated
	 * @ordered
	 */
	protected EList<DependabilityintermediateModel.Error> destination;

	/**
	 * The cached value of the '{@link #getActivationDelay() <em>Activation Delay</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivationDelay()
	 * @generated
	 * @ordered
	 */
	protected Distribution activationDelay;

	/**
	 * The default value of the '{@link #getPropagationProbability() <em>Propagation Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropagationProbability()
	 * @generated
	 * @ordered
	 */
	protected static final double PROPAGATION_PROBABILITY_EDEFAULT = 0.0;

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
	 * The cached value of the '{@link #getPropagationLogic() <em>Propagation Logic</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropagationLogic()
	 * @generated
	 * @ordered
	 */
	protected FaultsExpressionNode propagationLogic;

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
	 * The default value of the '{@link #getPropagationLogicStringFormat() <em>Propagation Logic String Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropagationLogicStringFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String PROPAGATION_LOGIC_STRING_FORMAT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPropagationLogicStringFormat() <em>Propagation Logic String Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropagationLogicStringFormat()
	 * @generated
	 * @ordered
	 */
	protected String propagationLogicStringFormat = PROPAGATION_LOGIC_STRING_FORMAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FaultsGenerateErrorsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DependabilityintermediateModelPackage.Literals.FAULTS_GENERATE_ERRORS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Fault> getSource() {
		if (source == null) {
			source = new EObjectResolvingEList<Fault>(Fault.class, this, DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__SOURCE);
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DependabilityintermediateModel.Error> getDestination() {
		if (destination == null) {
			destination = new EObjectResolvingEList<DependabilityintermediateModel.Error>(DependabilityintermediateModel.Error.class, this, DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__DESTINATION);
		}
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Distribution getActivationDelay() {
		return activationDelay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetActivationDelay(Distribution newActivationDelay, NotificationChain msgs) {
		Distribution oldActivationDelay = activationDelay;
		activationDelay = newActivationDelay;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__ACTIVATION_DELAY, oldActivationDelay, newActivationDelay);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActivationDelay(Distribution newActivationDelay) {
		if (newActivationDelay != activationDelay) {
			NotificationChain msgs = null;
			if (activationDelay != null)
				msgs = ((InternalEObject)activationDelay).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__ACTIVATION_DELAY, null, msgs);
			if (newActivationDelay != null)
				msgs = ((InternalEObject)newActivationDelay).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__ACTIVATION_DELAY, null, msgs);
			msgs = basicSetActivationDelay(newActivationDelay, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__ACTIVATION_DELAY, newActivationDelay, newActivationDelay));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__PROPAGATION_PROBABILITY, oldPropagationProbability, propagationProbability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultsExpressionNode getPropagationLogic() {
		return propagationLogic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPropagationLogic(FaultsExpressionNode newPropagationLogic, NotificationChain msgs) {
		FaultsExpressionNode oldPropagationLogic = propagationLogic;
		propagationLogic = newPropagationLogic;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__PROPAGATION_LOGIC, oldPropagationLogic, newPropagationLogic);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropagationLogic(FaultsExpressionNode newPropagationLogic) {
		if (newPropagationLogic != propagationLogic) {
			NotificationChain msgs = null;
			if (propagationLogic != null)
				msgs = ((InternalEObject)propagationLogic).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__PROPAGATION_LOGIC, null, msgs);
			if (newPropagationLogic != null)
				msgs = ((InternalEObject)newPropagationLogic).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__PROPAGATION_LOGIC, null, msgs);
			msgs = basicSetPropagationLogic(newPropagationLogic, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__PROPAGATION_LOGIC, newPropagationLogic, newPropagationLogic));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__WEIGHT, oldWeight, weight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPropagationLogicStringFormat() {
		return propagationLogicStringFormat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropagationLogicStringFormat(String newPropagationLogicStringFormat) {
		String oldPropagationLogicStringFormat = propagationLogicStringFormat;
		propagationLogicStringFormat = newPropagationLogicStringFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__PROPAGATION_LOGIC_STRING_FORMAT, oldPropagationLogicStringFormat, propagationLogicStringFormat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component getComponent() {
		if (eContainerFeatureID() != DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__COMPONENT) return null;
		return (Component)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComponent(Component newComponent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newComponent, DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__COMPONENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponent(Component newComponent) {
		if (newComponent != eInternalContainer() || (eContainerFeatureID() != DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__COMPONENT && newComponent != null)) {
			if (EcoreUtil.isAncestor(this, newComponent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newComponent != null)
				msgs = ((InternalEObject)newComponent).eInverseAdd(this, DependabilityintermediateModelPackage.COMPONENT__FAULTS_GENERATES_ERRORS, Component.class, msgs);
			msgs = basicSetComponent(newComponent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__COMPONENT, newComponent, newComponent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__COMPONENT:
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
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__ACTIVATION_DELAY:
				return basicSetActivationDelay(null, msgs);
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__PROPAGATION_LOGIC:
				return basicSetPropagationLogic(null, msgs);
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__COMPONENT:
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
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__COMPONENT:
				return eInternalContainer().eInverseRemove(this, DependabilityintermediateModelPackage.COMPONENT__FAULTS_GENERATES_ERRORS, Component.class, msgs);
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
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__SOURCE:
				return getSource();
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__DESTINATION:
				return getDestination();
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__ACTIVATION_DELAY:
				return getActivationDelay();
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__PROPAGATION_PROBABILITY:
				return getPropagationProbability();
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__PROPAGATION_LOGIC:
				return getPropagationLogic();
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__WEIGHT:
				return getWeight();
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__PROPAGATION_LOGIC_STRING_FORMAT:
				return getPropagationLogicStringFormat();
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__COMPONENT:
				return getComponent();
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__NAME:
				return getName();
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
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__SOURCE:
				getSource().clear();
				getSource().addAll((Collection<? extends Fault>)newValue);
				return;
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__DESTINATION:
				getDestination().clear();
				getDestination().addAll((Collection<? extends DependabilityintermediateModel.Error>)newValue);
				return;
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__ACTIVATION_DELAY:
				setActivationDelay((Distribution)newValue);
				return;
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__PROPAGATION_PROBABILITY:
				setPropagationProbability((Double)newValue);
				return;
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__PROPAGATION_LOGIC:
				setPropagationLogic((FaultsExpressionNode)newValue);
				return;
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__WEIGHT:
				setWeight((Double)newValue);
				return;
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__PROPAGATION_LOGIC_STRING_FORMAT:
				setPropagationLogicStringFormat((String)newValue);
				return;
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__COMPONENT:
				setComponent((Component)newValue);
				return;
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__NAME:
				setName((String)newValue);
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
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__SOURCE:
				getSource().clear();
				return;
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__DESTINATION:
				getDestination().clear();
				return;
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__ACTIVATION_DELAY:
				setActivationDelay((Distribution)null);
				return;
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__PROPAGATION_PROBABILITY:
				setPropagationProbability(PROPAGATION_PROBABILITY_EDEFAULT);
				return;
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__PROPAGATION_LOGIC:
				setPropagationLogic((FaultsExpressionNode)null);
				return;
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__WEIGHT:
				setWeight(WEIGHT_EDEFAULT);
				return;
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__PROPAGATION_LOGIC_STRING_FORMAT:
				setPropagationLogicStringFormat(PROPAGATION_LOGIC_STRING_FORMAT_EDEFAULT);
				return;
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__COMPONENT:
				setComponent((Component)null);
				return;
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__NAME:
				setName(NAME_EDEFAULT);
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
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__SOURCE:
				return source != null && !source.isEmpty();
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__DESTINATION:
				return destination != null && !destination.isEmpty();
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__ACTIVATION_DELAY:
				return activationDelay != null;
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__PROPAGATION_PROBABILITY:
				return propagationProbability != PROPAGATION_PROBABILITY_EDEFAULT;
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__PROPAGATION_LOGIC:
				return propagationLogic != null;
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__WEIGHT:
				return weight != WEIGHT_EDEFAULT;
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__PROPAGATION_LOGIC_STRING_FORMAT:
				return PROPAGATION_LOGIC_STRING_FORMAT_EDEFAULT == null ? propagationLogicStringFormat != null : !PROPAGATION_LOGIC_STRING_FORMAT_EDEFAULT.equals(propagationLogicStringFormat);
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__COMPONENT:
				return getComponent() != null;
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (PropagationProbability: ");
		result.append(propagationProbability);
		result.append(", Weight: ");
		result.append(weight);
		result.append(", PropagationLogicStringFormat: ");
		result.append(propagationLogicStringFormat);
		result.append(", Name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //FaultsGenerateErrorsImpl
