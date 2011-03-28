/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel.impl;

import DependabilityintermediateModel.DependabilityintermediateModelPackage;
import DependabilityintermediateModel.ErrorPropagation;
import DependabilityintermediateModel.ErrorsExpressionNode;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Propagation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link DependabilityintermediateModel.impl.ErrorPropagationImpl#getPropagationLogic <em>Propagation Logic</em>}</li>
 *   <li>{@link DependabilityintermediateModel.impl.ErrorPropagationImpl#getName <em>Name</em>}</li>
 *   <li>{@link DependabilityintermediateModel.impl.ErrorPropagationImpl#getPropagationLogicStringFormat <em>Propagation Logic String Format</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ErrorPropagationImpl extends EObjectImpl implements ErrorPropagation {
	/**
	 * The cached value of the '{@link #getPropagationLogic() <em>Propagation Logic</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropagationLogic()
	 * @generated
	 * @ordered
	 */
	protected ErrorsExpressionNode propagationLogic;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ErrorPropagationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DependabilityintermediateModelPackage.Literals.ERROR_PROPAGATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorsExpressionNode getPropagationLogic() {
		return propagationLogic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPropagationLogic(ErrorsExpressionNode newPropagationLogic, NotificationChain msgs) {
		ErrorsExpressionNode oldPropagationLogic = propagationLogic;
		propagationLogic = newPropagationLogic;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.ERROR_PROPAGATION__PROPAGATION_LOGIC, oldPropagationLogic, newPropagationLogic);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropagationLogic(ErrorsExpressionNode newPropagationLogic) {
		if (newPropagationLogic != propagationLogic) {
			NotificationChain msgs = null;
			if (propagationLogic != null)
				msgs = ((InternalEObject)propagationLogic).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DependabilityintermediateModelPackage.ERROR_PROPAGATION__PROPAGATION_LOGIC, null, msgs);
			if (newPropagationLogic != null)
				msgs = ((InternalEObject)newPropagationLogic).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DependabilityintermediateModelPackage.ERROR_PROPAGATION__PROPAGATION_LOGIC, null, msgs);
			msgs = basicSetPropagationLogic(newPropagationLogic, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.ERROR_PROPAGATION__PROPAGATION_LOGIC, newPropagationLogic, newPropagationLogic));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.ERROR_PROPAGATION__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.ERROR_PROPAGATION__PROPAGATION_LOGIC_STRING_FORMAT, oldPropagationLogicStringFormat, propagationLogicStringFormat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DependabilityintermediateModelPackage.ERROR_PROPAGATION__PROPAGATION_LOGIC:
				return basicSetPropagationLogic(null, msgs);
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
			case DependabilityintermediateModelPackage.ERROR_PROPAGATION__PROPAGATION_LOGIC:
				return getPropagationLogic();
			case DependabilityintermediateModelPackage.ERROR_PROPAGATION__NAME:
				return getName();
			case DependabilityintermediateModelPackage.ERROR_PROPAGATION__PROPAGATION_LOGIC_STRING_FORMAT:
				return getPropagationLogicStringFormat();
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
			case DependabilityintermediateModelPackage.ERROR_PROPAGATION__PROPAGATION_LOGIC:
				setPropagationLogic((ErrorsExpressionNode)newValue);
				return;
			case DependabilityintermediateModelPackage.ERROR_PROPAGATION__NAME:
				setName((String)newValue);
				return;
			case DependabilityintermediateModelPackage.ERROR_PROPAGATION__PROPAGATION_LOGIC_STRING_FORMAT:
				setPropagationLogicStringFormat((String)newValue);
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
			case DependabilityintermediateModelPackage.ERROR_PROPAGATION__PROPAGATION_LOGIC:
				setPropagationLogic((ErrorsExpressionNode)null);
				return;
			case DependabilityintermediateModelPackage.ERROR_PROPAGATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DependabilityintermediateModelPackage.ERROR_PROPAGATION__PROPAGATION_LOGIC_STRING_FORMAT:
				setPropagationLogicStringFormat(PROPAGATION_LOGIC_STRING_FORMAT_EDEFAULT);
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
			case DependabilityintermediateModelPackage.ERROR_PROPAGATION__PROPAGATION_LOGIC:
				return propagationLogic != null;
			case DependabilityintermediateModelPackage.ERROR_PROPAGATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DependabilityintermediateModelPackage.ERROR_PROPAGATION__PROPAGATION_LOGIC_STRING_FORMAT:
				return PROPAGATION_LOGIC_STRING_FORMAT_EDEFAULT == null ? propagationLogicStringFormat != null : !PROPAGATION_LOGIC_STRING_FORMAT_EDEFAULT.equals(propagationLogicStringFormat);
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
		result.append(" (Name: ");
		result.append(name);
		result.append(", PropagationLogicStringFormat: ");
		result.append(propagationLogicStringFormat);
		result.append(')');
		return result.toString();
	}

} //ErrorPropagationImpl
