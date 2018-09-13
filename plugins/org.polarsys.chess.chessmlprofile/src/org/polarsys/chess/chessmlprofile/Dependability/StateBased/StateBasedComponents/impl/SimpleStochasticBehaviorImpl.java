/**
 */
package org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Property;

import org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.SimpleStochasticBehavior;
import org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.StateBasedComponentsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Stochastic Behavior</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.SimpleStochasticBehaviorImpl#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.SimpleStochasticBehaviorImpl#getBase_Connector <em>Base Connector</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.SimpleStochasticBehaviorImpl#getBase_InstanceSpecification <em>Base Instance Specification</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.SimpleStochasticBehaviorImpl#getFailureOccurrence <em>Failure Occurrence</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.SimpleStochasticBehaviorImpl#getRepairDelay <em>Repair Delay</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.SimpleStochasticBehaviorImpl#getFailureModesDistribution <em>Failure Modes Distribution</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.StateBased.StateBasedComponents.impl.SimpleStochasticBehaviorImpl#getBase_Property <em>Base Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SimpleStochasticBehaviorImpl extends EObjectImpl implements SimpleStochasticBehavior {
	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

	/**
	 * The cached value of the '{@link #getBase_Connector() <em>Base Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Connector()
	 * @generated
	 * @ordered
	 */
	protected Connector base_Connector;

	/**
	 * The cached value of the '{@link #getBase_InstanceSpecification() <em>Base Instance Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_InstanceSpecification()
	 * @generated
	 * @ordered
	 */
	protected InstanceSpecification base_InstanceSpecification;

	/**
	 * The default value of the '{@link #getFailureOccurrence() <em>Failure Occurrence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureOccurrence()
	 * @generated
	 * @ordered
	 */
	protected static final String FAILURE_OCCURRENCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFailureOccurrence() <em>Failure Occurrence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureOccurrence()
	 * @generated
	 * @ordered
	 */
	protected String failureOccurrence = FAILURE_OCCURRENCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRepairDelay() <em>Repair Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepairDelay()
	 * @generated
	 * @ordered
	 */
	protected static final String REPAIR_DELAY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRepairDelay() <em>Repair Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepairDelay()
	 * @generated
	 * @ordered
	 */
	protected String repairDelay = REPAIR_DELAY_EDEFAULT;

	/**
	 * The default value of the '{@link #getFailureModesDistribution() <em>Failure Modes Distribution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureModesDistribution()
	 * @generated
	 * @ordered
	 */
	protected static final String FAILURE_MODES_DISTRIBUTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFailureModesDistribution() <em>Failure Modes Distribution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureModesDistribution()
	 * @generated
	 * @ordered
	 */
	protected String failureModesDistribution = FAILURE_MODES_DISTRIBUTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_Property() <em>Base Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Property()
	 * @generated
	 * @ordered
	 */
	protected Property base_Property;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleStochasticBehaviorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StateBasedComponentsPackage.Literals.SIMPLE_STOCHASTIC_BEHAVIOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if (base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject)base_Class;
			base_Class = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBase_Class);
			if (base_Class != oldBase_Class) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connector getBase_Connector() {
		if (base_Connector != null && base_Connector.eIsProxy()) {
			InternalEObject oldBase_Connector = (InternalEObject)base_Connector;
			base_Connector = (Connector)eResolveProxy(oldBase_Connector);
			if (base_Connector != oldBase_Connector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__BASE_CONNECTOR, oldBase_Connector, base_Connector));
			}
		}
		return base_Connector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connector basicGetBase_Connector() {
		return base_Connector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Connector(Connector newBase_Connector) {
		Connector oldBase_Connector = base_Connector;
		base_Connector = newBase_Connector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__BASE_CONNECTOR, oldBase_Connector, base_Connector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceSpecification getBase_InstanceSpecification() {
		if (base_InstanceSpecification != null && base_InstanceSpecification.eIsProxy()) {
			InternalEObject oldBase_InstanceSpecification = (InternalEObject)base_InstanceSpecification;
			base_InstanceSpecification = (InstanceSpecification)eResolveProxy(oldBase_InstanceSpecification);
			if (base_InstanceSpecification != oldBase_InstanceSpecification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__BASE_INSTANCE_SPECIFICATION, oldBase_InstanceSpecification, base_InstanceSpecification));
			}
		}
		return base_InstanceSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceSpecification basicGetBase_InstanceSpecification() {
		return base_InstanceSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_InstanceSpecification(InstanceSpecification newBase_InstanceSpecification) {
		InstanceSpecification oldBase_InstanceSpecification = base_InstanceSpecification;
		base_InstanceSpecification = newBase_InstanceSpecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__BASE_INSTANCE_SPECIFICATION, oldBase_InstanceSpecification, base_InstanceSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFailureOccurrence() {
		return failureOccurrence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFailureOccurrence(String newFailureOccurrence) {
		String oldFailureOccurrence = failureOccurrence;
		failureOccurrence = newFailureOccurrence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__FAILURE_OCCURRENCE, oldFailureOccurrence, failureOccurrence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRepairDelay() {
		return repairDelay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepairDelay(String newRepairDelay) {
		String oldRepairDelay = repairDelay;
		repairDelay = newRepairDelay;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__REPAIR_DELAY, oldRepairDelay, repairDelay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFailureModesDistribution() {
		return failureModesDistribution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFailureModesDistribution(String newFailureModesDistribution) {
		String oldFailureModesDistribution = failureModesDistribution;
		failureModesDistribution = newFailureModesDistribution;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__FAILURE_MODES_DISTRIBUTION, oldFailureModesDistribution, failureModesDistribution));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getBase_Property() {
		if (base_Property != null && base_Property.eIsProxy()) {
			InternalEObject oldBase_Property = (InternalEObject)base_Property;
			base_Property = (Property)eResolveProxy(oldBase_Property);
			if (base_Property != oldBase_Property) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__BASE_PROPERTY, oldBase_Property, base_Property));
			}
		}
		return base_Property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetBase_Property() {
		return base_Property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Property(Property newBase_Property) {
		Property oldBase_Property = base_Property;
		base_Property = newBase_Property;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__BASE_PROPERTY, oldBase_Property, base_Property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
			case StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__BASE_CONNECTOR:
				if (resolve) return getBase_Connector();
				return basicGetBase_Connector();
			case StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__BASE_INSTANCE_SPECIFICATION:
				if (resolve) return getBase_InstanceSpecification();
				return basicGetBase_InstanceSpecification();
			case StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__FAILURE_OCCURRENCE:
				return getFailureOccurrence();
			case StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__REPAIR_DELAY:
				return getRepairDelay();
			case StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__FAILURE_MODES_DISTRIBUTION:
				return getFailureModesDistribution();
			case StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__BASE_PROPERTY:
				if (resolve) return getBase_Property();
				return basicGetBase_Property();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
				return;
			case StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__BASE_CONNECTOR:
				setBase_Connector((Connector)newValue);
				return;
			case StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__BASE_INSTANCE_SPECIFICATION:
				setBase_InstanceSpecification((InstanceSpecification)newValue);
				return;
			case StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__FAILURE_OCCURRENCE:
				setFailureOccurrence((String)newValue);
				return;
			case StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__REPAIR_DELAY:
				setRepairDelay((String)newValue);
				return;
			case StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__FAILURE_MODES_DISTRIBUTION:
				setFailureModesDistribution((String)newValue);
				return;
			case StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__BASE_PROPERTY:
				setBase_Property((Property)newValue);
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
			case StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
				return;
			case StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__BASE_CONNECTOR:
				setBase_Connector((Connector)null);
				return;
			case StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__BASE_INSTANCE_SPECIFICATION:
				setBase_InstanceSpecification((InstanceSpecification)null);
				return;
			case StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__FAILURE_OCCURRENCE:
				setFailureOccurrence(FAILURE_OCCURRENCE_EDEFAULT);
				return;
			case StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__REPAIR_DELAY:
				setRepairDelay(REPAIR_DELAY_EDEFAULT);
				return;
			case StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__FAILURE_MODES_DISTRIBUTION:
				setFailureModesDistribution(FAILURE_MODES_DISTRIBUTION_EDEFAULT);
				return;
			case StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__BASE_PROPERTY:
				setBase_Property((Property)null);
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
			case StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__BASE_CLASS:
				return base_Class != null;
			case StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__BASE_CONNECTOR:
				return base_Connector != null;
			case StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__BASE_INSTANCE_SPECIFICATION:
				return base_InstanceSpecification != null;
			case StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__FAILURE_OCCURRENCE:
				return FAILURE_OCCURRENCE_EDEFAULT == null ? failureOccurrence != null : !FAILURE_OCCURRENCE_EDEFAULT.equals(failureOccurrence);
			case StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__REPAIR_DELAY:
				return REPAIR_DELAY_EDEFAULT == null ? repairDelay != null : !REPAIR_DELAY_EDEFAULT.equals(repairDelay);
			case StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__FAILURE_MODES_DISTRIBUTION:
				return FAILURE_MODES_DISTRIBUTION_EDEFAULT == null ? failureModesDistribution != null : !FAILURE_MODES_DISTRIBUTION_EDEFAULT.equals(failureModesDistribution);
			case StateBasedComponentsPackage.SIMPLE_STOCHASTIC_BEHAVIOR__BASE_PROPERTY:
				return base_Property != null;
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
		result.append(" (failureOccurrence: ");
		result.append(failureOccurrence);
		result.append(", repairDelay: ");
		result.append(repairDelay);
		result.append(", failureModesDistribution: ");
		result.append(failureModesDistribution);
		result.append(')');
		return result.toString();
	}

} //SimpleStochasticBehaviorImpl
