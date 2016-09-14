/**
 */
package org.polarsys.chess.xtext.flaDsl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.polarsys.chess.xtext.flaDsl.ACIDavoidable;
import org.polarsys.chess.xtext.flaDsl.FailureDefinition;
import org.polarsys.chess.xtext.flaDsl.FailureType;
import org.polarsys.chess.xtext.flaDsl.FlaDslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Failure Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.xtext.flaDsl.impl.FailureDefinitionImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.polarsys.chess.xtext.flaDsl.impl.FailureDefinitionImpl#getAcidAvoidable <em>Acid Avoidable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FailureDefinitionImpl extends DefinitionsImpl implements FailureDefinition
{
  /**
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final FailureType TYPE_EDEFAULT = FailureType.NO_FAILURE;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected FailureType type = TYPE_EDEFAULT;

  /**
   * The cached value of the '{@link #getAcidAvoidable() <em>Acid Avoidable</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAcidAvoidable()
   * @generated
   * @ordered
   */
  protected ACIDavoidable acidAvoidable;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FailureDefinitionImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return FlaDslPackage.Literals.FAILURE_DEFINITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FailureType getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(FailureType newType)
  {
    FailureType oldType = type;
    type = newType == null ? TYPE_EDEFAULT : newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FlaDslPackage.FAILURE_DEFINITION__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ACIDavoidable getAcidAvoidable()
  {
    return acidAvoidable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAcidAvoidable(ACIDavoidable newAcidAvoidable, NotificationChain msgs)
  {
    ACIDavoidable oldAcidAvoidable = acidAvoidable;
    acidAvoidable = newAcidAvoidable;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FlaDslPackage.FAILURE_DEFINITION__ACID_AVOIDABLE, oldAcidAvoidable, newAcidAvoidable);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAcidAvoidable(ACIDavoidable newAcidAvoidable)
  {
    if (newAcidAvoidable != acidAvoidable)
    {
      NotificationChain msgs = null;
      if (acidAvoidable != null)
        msgs = ((InternalEObject)acidAvoidable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FlaDslPackage.FAILURE_DEFINITION__ACID_AVOIDABLE, null, msgs);
      if (newAcidAvoidable != null)
        msgs = ((InternalEObject)newAcidAvoidable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FlaDslPackage.FAILURE_DEFINITION__ACID_AVOIDABLE, null, msgs);
      msgs = basicSetAcidAvoidable(newAcidAvoidable, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FlaDslPackage.FAILURE_DEFINITION__ACID_AVOIDABLE, newAcidAvoidable, newAcidAvoidable));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case FlaDslPackage.FAILURE_DEFINITION__ACID_AVOIDABLE:
        return basicSetAcidAvoidable(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case FlaDslPackage.FAILURE_DEFINITION__TYPE:
        return getType();
      case FlaDslPackage.FAILURE_DEFINITION__ACID_AVOIDABLE:
        return getAcidAvoidable();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case FlaDslPackage.FAILURE_DEFINITION__TYPE:
        setType((FailureType)newValue);
        return;
      case FlaDslPackage.FAILURE_DEFINITION__ACID_AVOIDABLE:
        setAcidAvoidable((ACIDavoidable)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case FlaDslPackage.FAILURE_DEFINITION__TYPE:
        setType(TYPE_EDEFAULT);
        return;
      case FlaDslPackage.FAILURE_DEFINITION__ACID_AVOIDABLE:
        setAcidAvoidable((ACIDavoidable)null);
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case FlaDslPackage.FAILURE_DEFINITION__TYPE:
        return type != TYPE_EDEFAULT;
      case FlaDslPackage.FAILURE_DEFINITION__ACID_AVOIDABLE:
        return acidAvoidable != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (type: ");
    result.append(type);
    result.append(')');
    return result.toString();
  }

} //FailureDefinitionImpl
