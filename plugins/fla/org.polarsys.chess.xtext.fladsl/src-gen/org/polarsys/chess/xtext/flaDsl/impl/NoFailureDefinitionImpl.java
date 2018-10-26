/**
 */
package org.polarsys.chess.xtext.flaDsl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.polarsys.chess.xtext.flaDsl.ACIDMitigation;
import org.polarsys.chess.xtext.flaDsl.FlaDslPackage;
import org.polarsys.chess.xtext.flaDsl.NoFailureDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>No Failure Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.xtext.flaDsl.impl.NoFailureDefinitionImpl#getAcidMitigation <em>Acid Mitigation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NoFailureDefinitionImpl extends DefinitionsImpl implements NoFailureDefinition
{
  /**
   * The cached value of the '{@link #getAcidMitigation() <em>Acid Mitigation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAcidMitigation()
   * @generated
   * @ordered
   */
  protected ACIDMitigation acidMitigation;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NoFailureDefinitionImpl()
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
    return FlaDslPackage.Literals.NO_FAILURE_DEFINITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ACIDMitigation getAcidMitigation()
  {
    return acidMitigation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAcidMitigation(ACIDMitigation newAcidMitigation, NotificationChain msgs)
  {
    ACIDMitigation oldAcidMitigation = acidMitigation;
    acidMitigation = newAcidMitigation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FlaDslPackage.NO_FAILURE_DEFINITION__ACID_MITIGATION, oldAcidMitigation, newAcidMitigation);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAcidMitigation(ACIDMitigation newAcidMitigation)
  {
    if (newAcidMitigation != acidMitigation)
    {
      NotificationChain msgs = null;
      if (acidMitigation != null)
        msgs = ((InternalEObject)acidMitigation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FlaDslPackage.NO_FAILURE_DEFINITION__ACID_MITIGATION, null, msgs);
      if (newAcidMitigation != null)
        msgs = ((InternalEObject)newAcidMitigation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FlaDslPackage.NO_FAILURE_DEFINITION__ACID_MITIGATION, null, msgs);
      msgs = basicSetAcidMitigation(newAcidMitigation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FlaDslPackage.NO_FAILURE_DEFINITION__ACID_MITIGATION, newAcidMitigation, newAcidMitigation));
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
      case FlaDslPackage.NO_FAILURE_DEFINITION__ACID_MITIGATION:
        return basicSetAcidMitigation(null, msgs);
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
      case FlaDslPackage.NO_FAILURE_DEFINITION__ACID_MITIGATION:
        return getAcidMitigation();
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
      case FlaDslPackage.NO_FAILURE_DEFINITION__ACID_MITIGATION:
        setAcidMitigation((ACIDMitigation)newValue);
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
      case FlaDslPackage.NO_FAILURE_DEFINITION__ACID_MITIGATION:
        setAcidMitigation((ACIDMitigation)null);
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
      case FlaDslPackage.NO_FAILURE_DEFINITION__ACID_MITIGATION:
        return acidMitigation != null;
    }
    return super.eIsSet(featureID);
  }

} //NoFailureDefinitionImpl
