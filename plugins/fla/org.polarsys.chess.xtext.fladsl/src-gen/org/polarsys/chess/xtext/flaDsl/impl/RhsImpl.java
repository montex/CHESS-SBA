/**
 */
package org.polarsys.chess.xtext.flaDsl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.polarsys.chess.xtext.flaDsl.FlaDslPackage;
import org.polarsys.chess.xtext.flaDsl.OutputExpression;
import org.polarsys.chess.xtext.flaDsl.Rhs;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rhs</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.xtext.flaDsl.impl.RhsImpl#getFailures <em>Failures</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RhsImpl extends MinimalEObjectImpl.Container implements Rhs
{
  /**
   * The cached value of the '{@link #getFailures() <em>Failures</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFailures()
   * @generated
   * @ordered
   */
  protected EList<OutputExpression> failures;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RhsImpl()
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
    return FlaDslPackage.Literals.RHS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<OutputExpression> getFailures()
  {
    if (failures == null)
    {
      failures = new EObjectContainmentEList<OutputExpression>(OutputExpression.class, this, FlaDslPackage.RHS__FAILURES);
    }
    return failures;
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
      case FlaDslPackage.RHS__FAILURES:
        return ((InternalEList<?>)getFailures()).basicRemove(otherEnd, msgs);
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
      case FlaDslPackage.RHS__FAILURES:
        return getFailures();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case FlaDslPackage.RHS__FAILURES:
        getFailures().clear();
        getFailures().addAll((Collection<? extends OutputExpression>)newValue);
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
      case FlaDslPackage.RHS__FAILURES:
        getFailures().clear();
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
      case FlaDslPackage.RHS__FAILURES:
        return failures != null && !failures.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //RhsImpl
