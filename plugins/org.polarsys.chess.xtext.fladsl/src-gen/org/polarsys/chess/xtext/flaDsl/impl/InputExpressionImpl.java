/**
 */
package org.polarsys.chess.xtext.flaDsl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.uml2.uml.Port;

import org.polarsys.chess.xtext.flaDsl.FlaDslPackage;
import org.polarsys.chess.xtext.flaDsl.InFailureExpr;
import org.polarsys.chess.xtext.flaDsl.InputExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Input Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.xtext.flaDsl.impl.InputExpressionImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link org.polarsys.chess.xtext.flaDsl.impl.InputExpressionImpl#getFailureExpr <em>Failure Expr</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InputExpressionImpl extends MinimalEObjectImpl.Container implements InputExpression
{
  /**
   * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected Port ref;

  /**
   * The cached value of the '{@link #getFailureExpr() <em>Failure Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFailureExpr()
   * @generated
   * @ordered
   */
  protected InFailureExpr failureExpr;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InputExpressionImpl()
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
    return FlaDslPackage.Literals.INPUT_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Port getRef()
  {
    if (ref != null && ref.eIsProxy())
    {
      InternalEObject oldRef = (InternalEObject)ref;
      ref = (Port)eResolveProxy(oldRef);
      if (ref != oldRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FlaDslPackage.INPUT_EXPRESSION__REF, oldRef, ref));
      }
    }
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Port basicGetRef()
  {
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRef(Port newRef)
  {
    Port oldRef = ref;
    ref = newRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FlaDslPackage.INPUT_EXPRESSION__REF, oldRef, ref));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InFailureExpr getFailureExpr()
  {
    return failureExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFailureExpr(InFailureExpr newFailureExpr, NotificationChain msgs)
  {
    InFailureExpr oldFailureExpr = failureExpr;
    failureExpr = newFailureExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FlaDslPackage.INPUT_EXPRESSION__FAILURE_EXPR, oldFailureExpr, newFailureExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFailureExpr(InFailureExpr newFailureExpr)
  {
    if (newFailureExpr != failureExpr)
    {
      NotificationChain msgs = null;
      if (failureExpr != null)
        msgs = ((InternalEObject)failureExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FlaDslPackage.INPUT_EXPRESSION__FAILURE_EXPR, null, msgs);
      if (newFailureExpr != null)
        msgs = ((InternalEObject)newFailureExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FlaDslPackage.INPUT_EXPRESSION__FAILURE_EXPR, null, msgs);
      msgs = basicSetFailureExpr(newFailureExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FlaDslPackage.INPUT_EXPRESSION__FAILURE_EXPR, newFailureExpr, newFailureExpr));
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
      case FlaDslPackage.INPUT_EXPRESSION__FAILURE_EXPR:
        return basicSetFailureExpr(null, msgs);
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
      case FlaDslPackage.INPUT_EXPRESSION__REF:
        if (resolve) return getRef();
        return basicGetRef();
      case FlaDslPackage.INPUT_EXPRESSION__FAILURE_EXPR:
        return getFailureExpr();
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
      case FlaDslPackage.INPUT_EXPRESSION__REF:
        setRef((Port)newValue);
        return;
      case FlaDslPackage.INPUT_EXPRESSION__FAILURE_EXPR:
        setFailureExpr((InFailureExpr)newValue);
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
      case FlaDslPackage.INPUT_EXPRESSION__REF:
        setRef((Port)null);
        return;
      case FlaDslPackage.INPUT_EXPRESSION__FAILURE_EXPR:
        setFailureExpr((InFailureExpr)null);
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
      case FlaDslPackage.INPUT_EXPRESSION__REF:
        return ref != null;
      case FlaDslPackage.INPUT_EXPRESSION__FAILURE_EXPR:
        return failureExpr != null;
    }
    return super.eIsSet(featureID);
  }

} //InputExpressionImpl
