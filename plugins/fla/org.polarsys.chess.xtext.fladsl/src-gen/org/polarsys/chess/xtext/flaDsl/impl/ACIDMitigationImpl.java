/**
 */
package org.polarsys.chess.xtext.flaDsl.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.polarsys.chess.xtext.flaDsl.ACIDMitigation;
import org.polarsys.chess.xtext.flaDsl.Amitigation;
import org.polarsys.chess.xtext.flaDsl.Cmitigation;
import org.polarsys.chess.xtext.flaDsl.Dmitigation;
import org.polarsys.chess.xtext.flaDsl.FlaDslPackage;
import org.polarsys.chess.xtext.flaDsl.Imitigation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ACID Mitigation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.xtext.flaDsl.impl.ACIDMitigationImpl#getA <em>A</em>}</li>
 *   <li>{@link org.polarsys.chess.xtext.flaDsl.impl.ACIDMitigationImpl#getC <em>C</em>}</li>
 *   <li>{@link org.polarsys.chess.xtext.flaDsl.impl.ACIDMitigationImpl#getI <em>I</em>}</li>
 *   <li>{@link org.polarsys.chess.xtext.flaDsl.impl.ACIDMitigationImpl#getD <em>D</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ACIDMitigationImpl extends MinimalEObjectImpl.Container implements ACIDMitigation
{
  /**
   * The default value of the '{@link #getA() <em>A</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getA()
   * @generated
   * @ordered
   */
  protected static final Amitigation A_EDEFAULT = Amitigation.ALL_OR_NOTHING;

  /**
   * The cached value of the '{@link #getA() <em>A</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getA()
   * @generated
   * @ordered
   */
  protected Amitigation a = A_EDEFAULT;

  /**
   * The default value of the '{@link #getC() <em>C</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getC()
   * @generated
   * @ordered
   */
  protected static final Cmitigation C_EDEFAULT = Cmitigation.FULL_CONSISTENCY;

  /**
   * The cached value of the '{@link #getC() <em>C</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getC()
   * @generated
   * @ordered
   */
  protected Cmitigation c = C_EDEFAULT;

  /**
   * The default value of the '{@link #getI() <em>I</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getI()
   * @generated
   * @ordered
   */
  protected static final Imitigation I_EDEFAULT = Imitigation.SERIALIZABLE;

  /**
   * The cached value of the '{@link #getI() <em>I</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getI()
   * @generated
   * @ordered
   */
  protected Imitigation i = I_EDEFAULT;

  /**
   * The default value of the '{@link #getD() <em>D</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getD()
   * @generated
   * @ordered
   */
  protected static final Dmitigation D_EDEFAULT = Dmitigation.NO_LOSS;

  /**
   * The cached value of the '{@link #getD() <em>D</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getD()
   * @generated
   * @ordered
   */
  protected Dmitigation d = D_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ACIDMitigationImpl()
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
    return FlaDslPackage.Literals.ACID_MITIGATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Amitigation getA()
  {
    return a;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setA(Amitigation newA)
  {
    Amitigation oldA = a;
    a = newA == null ? A_EDEFAULT : newA;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FlaDslPackage.ACID_MITIGATION__A, oldA, a));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Cmitigation getC()
  {
    return c;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setC(Cmitigation newC)
  {
    Cmitigation oldC = c;
    c = newC == null ? C_EDEFAULT : newC;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FlaDslPackage.ACID_MITIGATION__C, oldC, c));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Imitigation getI()
  {
    return i;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setI(Imitigation newI)
  {
    Imitigation oldI = i;
    i = newI == null ? I_EDEFAULT : newI;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FlaDslPackage.ACID_MITIGATION__I, oldI, i));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Dmitigation getD()
  {
    return d;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setD(Dmitigation newD)
  {
    Dmitigation oldD = d;
    d = newD == null ? D_EDEFAULT : newD;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FlaDslPackage.ACID_MITIGATION__D, oldD, d));
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
      case FlaDslPackage.ACID_MITIGATION__A:
        return getA();
      case FlaDslPackage.ACID_MITIGATION__C:
        return getC();
      case FlaDslPackage.ACID_MITIGATION__I:
        return getI();
      case FlaDslPackage.ACID_MITIGATION__D:
        return getD();
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
      case FlaDslPackage.ACID_MITIGATION__A:
        setA((Amitigation)newValue);
        return;
      case FlaDslPackage.ACID_MITIGATION__C:
        setC((Cmitigation)newValue);
        return;
      case FlaDslPackage.ACID_MITIGATION__I:
        setI((Imitigation)newValue);
        return;
      case FlaDslPackage.ACID_MITIGATION__D:
        setD((Dmitigation)newValue);
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
      case FlaDslPackage.ACID_MITIGATION__A:
        setA(A_EDEFAULT);
        return;
      case FlaDslPackage.ACID_MITIGATION__C:
        setC(C_EDEFAULT);
        return;
      case FlaDslPackage.ACID_MITIGATION__I:
        setI(I_EDEFAULT);
        return;
      case FlaDslPackage.ACID_MITIGATION__D:
        setD(D_EDEFAULT);
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
      case FlaDslPackage.ACID_MITIGATION__A:
        return a != A_EDEFAULT;
      case FlaDslPackage.ACID_MITIGATION__C:
        return c != C_EDEFAULT;
      case FlaDslPackage.ACID_MITIGATION__I:
        return i != I_EDEFAULT;
      case FlaDslPackage.ACID_MITIGATION__D:
        return d != D_EDEFAULT;
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
    result.append(" (a: ");
    result.append(a);
    result.append(", c: ");
    result.append(c);
    result.append(", i: ");
    result.append(i);
    result.append(", d: ");
    result.append(d);
    result.append(')');
    return result.toString();
  }

} //ACIDMitigationImpl
