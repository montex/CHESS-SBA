/**
 */
package org.polarsys.chess.xtext.flaDsl.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.polarsys.chess.xtext.flaDsl.FlaDslPackage;
import org.polarsys.chess.xtext.flaDsl.VariableDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.xtext.flaDsl.impl.VariableDefinitionImpl#getVariableName <em>Variable Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VariableDefinitionImpl extends DefinitionsImpl implements VariableDefinition
{
  /**
   * The default value of the '{@link #getVariableName() <em>Variable Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariableName()
   * @generated
   * @ordered
   */
  protected static final String VARIABLE_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVariableName() <em>Variable Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariableName()
   * @generated
   * @ordered
   */
  protected String variableName = VARIABLE_NAME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VariableDefinitionImpl()
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
    return FlaDslPackage.Literals.VARIABLE_DEFINITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getVariableName()
  {
    return variableName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVariableName(String newVariableName)
  {
    String oldVariableName = variableName;
    variableName = newVariableName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FlaDslPackage.VARIABLE_DEFINITION__VARIABLE_NAME, oldVariableName, variableName));
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
      case FlaDslPackage.VARIABLE_DEFINITION__VARIABLE_NAME:
        return getVariableName();
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
      case FlaDslPackage.VARIABLE_DEFINITION__VARIABLE_NAME:
        setVariableName((String)newValue);
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
      case FlaDslPackage.VARIABLE_DEFINITION__VARIABLE_NAME:
        setVariableName(VARIABLE_NAME_EDEFAULT);
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
      case FlaDslPackage.VARIABLE_DEFINITION__VARIABLE_NAME:
        return VARIABLE_NAME_EDEFAULT == null ? variableName != null : !VARIABLE_NAME_EDEFAULT.equals(variableName);
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
    result.append(" (variableName: ");
    result.append(variableName);
    result.append(')');
    return result.toString();
  }

} //VariableDefinitionImpl
