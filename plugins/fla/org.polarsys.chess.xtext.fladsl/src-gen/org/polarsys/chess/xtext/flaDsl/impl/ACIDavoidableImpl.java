/**
 */
package org.polarsys.chess.xtext.flaDsl.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.polarsys.chess.xtext.flaDsl.ACIDavoidable;
import org.polarsys.chess.xtext.flaDsl.Aavoidable;
import org.polarsys.chess.xtext.flaDsl.Cavoidable;
import org.polarsys.chess.xtext.flaDsl.Davoidable;
import org.polarsys.chess.xtext.flaDsl.FlaDslPackage;
import org.polarsys.chess.xtext.flaDsl.Iavoidable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ACI Davoidable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.xtext.flaDsl.impl.ACIDavoidableImpl#getA <em>A</em>}</li>
 *   <li>{@link org.polarsys.chess.xtext.flaDsl.impl.ACIDavoidableImpl#getC <em>C</em>}</li>
 *   <li>{@link org.polarsys.chess.xtext.flaDsl.impl.ACIDavoidableImpl#getI <em>I</em>}</li>
 *   <li>{@link org.polarsys.chess.xtext.flaDsl.impl.ACIDavoidableImpl#getD <em>D</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ACIDavoidableImpl extends MinimalEObjectImpl.Container implements ACIDavoidable
{
  /**
   * The default value of the '{@link #getA() <em>A</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getA()
   * @generated
   * @ordered
   */
  protected static final Aavoidable A_EDEFAULT = Aavoidable.INCOMPLETION;

  /**
   * The cached value of the '{@link #getA() <em>A</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getA()
   * @generated
   * @ordered
   */
  protected Aavoidable a = A_EDEFAULT;

  /**
   * The default value of the '{@link #getC() <em>C</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getC()
   * @generated
   * @ordered
   */
  protected static final Cavoidable C_EDEFAULT = Cavoidable.INCONSISTENCY;

  /**
   * The cached value of the '{@link #getC() <em>C</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getC()
   * @generated
   * @ordered
   */
  protected Cavoidable c = C_EDEFAULT;

  /**
   * The default value of the '{@link #getI() <em>I</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getI()
   * @generated
   * @ordered
   */
  protected static final Iavoidable I_EDEFAULT = Iavoidable.INTERFERENCE;

  /**
   * The cached value of the '{@link #getI() <em>I</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getI()
   * @generated
   * @ordered
   */
  protected Iavoidable i = I_EDEFAULT;

  /**
   * The default value of the '{@link #getD() <em>D</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getD()
   * @generated
   * @ordered
   */
  protected static final Davoidable D_EDEFAULT = Davoidable.IMPERMANENCE;

  /**
   * The cached value of the '{@link #getD() <em>D</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getD()
   * @generated
   * @ordered
   */
  protected Davoidable d = D_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ACIDavoidableImpl()
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
    return FlaDslPackage.Literals.ACI_DAVOIDABLE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Aavoidable getA()
  {
    return a;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setA(Aavoidable newA)
  {
    Aavoidable oldA = a;
    a = newA == null ? A_EDEFAULT : newA;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FlaDslPackage.ACI_DAVOIDABLE__A, oldA, a));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Cavoidable getC()
  {
    return c;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setC(Cavoidable newC)
  {
    Cavoidable oldC = c;
    c = newC == null ? C_EDEFAULT : newC;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FlaDslPackage.ACI_DAVOIDABLE__C, oldC, c));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Iavoidable getI()
  {
    return i;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setI(Iavoidable newI)
  {
    Iavoidable oldI = i;
    i = newI == null ? I_EDEFAULT : newI;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FlaDslPackage.ACI_DAVOIDABLE__I, oldI, i));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Davoidable getD()
  {
    return d;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setD(Davoidable newD)
  {
    Davoidable oldD = d;
    d = newD == null ? D_EDEFAULT : newD;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FlaDslPackage.ACI_DAVOIDABLE__D, oldD, d));
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
      case FlaDslPackage.ACI_DAVOIDABLE__A:
        return getA();
      case FlaDslPackage.ACI_DAVOIDABLE__C:
        return getC();
      case FlaDslPackage.ACI_DAVOIDABLE__I:
        return getI();
      case FlaDslPackage.ACI_DAVOIDABLE__D:
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
      case FlaDslPackage.ACI_DAVOIDABLE__A:
        setA((Aavoidable)newValue);
        return;
      case FlaDslPackage.ACI_DAVOIDABLE__C:
        setC((Cavoidable)newValue);
        return;
      case FlaDslPackage.ACI_DAVOIDABLE__I:
        setI((Iavoidable)newValue);
        return;
      case FlaDslPackage.ACI_DAVOIDABLE__D:
        setD((Davoidable)newValue);
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
      case FlaDslPackage.ACI_DAVOIDABLE__A:
        setA(A_EDEFAULT);
        return;
      case FlaDslPackage.ACI_DAVOIDABLE__C:
        setC(C_EDEFAULT);
        return;
      case FlaDslPackage.ACI_DAVOIDABLE__I:
        setI(I_EDEFAULT);
        return;
      case FlaDslPackage.ACI_DAVOIDABLE__D:
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
      case FlaDslPackage.ACI_DAVOIDABLE__A:
        return a != A_EDEFAULT;
      case FlaDslPackage.ACI_DAVOIDABLE__C:
        return c != C_EDEFAULT;
      case FlaDslPackage.ACI_DAVOIDABLE__I:
        return i != I_EDEFAULT;
      case FlaDslPackage.ACI_DAVOIDABLE__D:
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

} //ACIDavoidableImpl
