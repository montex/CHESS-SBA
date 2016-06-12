/*******************************************************************************
 *                  CHESS core plugin
 *
 *               Copyright (C) 2011-2015
 *            Mälardalen University, Sweden
 *
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License
 *  v1.0 which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.polarsys.chess.fla.flamm;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.polarsys.chess.fla.flamm.FailureTypes.A_avoidable;
import org.polarsys.chess.fla.flamm.FailureTypes.C_avoidable;
import org.polarsys.chess.fla.flamm.FailureTypes.D_avoidable;
import org.polarsys.chess.fla.flamm.FailureTypes.I_avoidable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ACI Davoidable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.fla.flamm.ACIDavoidable#getA <em>A</em>}</li>
 *   <li>{@link org.polarsys.chess.fla.flamm.ACIDavoidable#getC <em>C</em>}</li>
 *   <li>{@link org.polarsys.chess.fla.flamm.ACIDavoidable#getI <em>I</em>}</li>
 *   <li>{@link org.polarsys.chess.fla.flamm.ACIDavoidable#getD <em>D</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.fla.flamm.FlammPackage#getACIDavoidable()
 * @model kind="class"
 * @generated
 */
public class ACIDavoidable extends MinimalEObjectImpl.Container implements EObject {
	/**
	 * The default value of the '{@link #getA() <em>A</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getA()
	 * @generated
	 * @ordered
	 */
	protected static final A_avoidable A_EDEFAULT = A_avoidable.UNSPECIFIED;

	/**
	 * The cached value of the '{@link #getA() <em>A</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getA()
	 * @generated
	 * @ordered
	 */
	protected A_avoidable a = A_EDEFAULT;

	/**
	 * The default value of the '{@link #getC() <em>C</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getC()
	 * @generated
	 * @ordered
	 */
	protected static final C_avoidable C_EDEFAULT = C_avoidable.UNSPECIFIED;

	/**
	 * The cached value of the '{@link #getC() <em>C</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getC()
	 * @generated
	 * @ordered
	 */
	protected C_avoidable c = C_EDEFAULT;

	/**
	 * The default value of the '{@link #getI() <em>I</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getI()
	 * @generated
	 * @ordered
	 */
	protected static final I_avoidable I_EDEFAULT = I_avoidable.UNSPECIFIED;

	/**
	 * The cached value of the '{@link #getI() <em>I</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getI()
	 * @generated
	 * @ordered
	 */
	protected I_avoidable i = I_EDEFAULT;

	/**
	 * The default value of the '{@link #getD() <em>D</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getD()
	 * @generated
	 * @ordered
	 */
	protected static final D_avoidable D_EDEFAULT = D_avoidable.UNSPECIFIED;

	/**
	 * The cached value of the '{@link #getD() <em>D</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getD()
	 * @generated
	 * @ordered
	 */
	protected D_avoidable d = D_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ACIDavoidable() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FlammPackage.Literals.ACI_DAVOIDABLE;
	}

	/**
	 * Returns the value of the '<em><b>A</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polarsys.chess.fla.flamm.FailureTypes.A_avoidable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>A</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>A</em>' attribute.
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.A_avoidable
	 * @see #setA(A_avoidable)
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getACIDavoidable_A()
	 * @model
	 * @generated
	 */
	public A_avoidable getA() {
		return a;
	}

	/**
	 * Sets the value of the '{@link org.polarsys.chess.fla.flamm.ACIDavoidable#getA <em>A</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>A</em>' attribute.
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.A_avoidable
	 * @see #getA()
	 * @generated
	 */
	public void setA(A_avoidable newA) {
		A_avoidable oldA = a;
		a = newA == null ? A_EDEFAULT : newA;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlammPackage.ACI_DAVOIDABLE__A, oldA, a));
	}

	/**
	 * Returns the value of the '<em><b>C</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polarsys.chess.fla.flamm.FailureTypes.C_avoidable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>C</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>C</em>' attribute.
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.C_avoidable
	 * @see #setC(C_avoidable)
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getACIDavoidable_C()
	 * @model
	 * @generated
	 */
	public C_avoidable getC() {
		return c;
	}

	/**
	 * Sets the value of the '{@link org.polarsys.chess.fla.flamm.ACIDavoidable#getC <em>C</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>C</em>' attribute.
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.C_avoidable
	 * @see #getC()
	 * @generated
	 */
	public void setC(C_avoidable newC) {
		C_avoidable oldC = c;
		c = newC == null ? C_EDEFAULT : newC;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlammPackage.ACI_DAVOIDABLE__C, oldC, c));
	}

	/**
	 * Returns the value of the '<em><b>I</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polarsys.chess.fla.flamm.FailureTypes.I_avoidable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>I</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>I</em>' attribute.
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.I_avoidable
	 * @see #setI(I_avoidable)
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getACIDavoidable_I()
	 * @model
	 * @generated
	 */
	public I_avoidable getI() {
		return i;
	}

	/**
	 * Sets the value of the '{@link org.polarsys.chess.fla.flamm.ACIDavoidable#getI <em>I</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>I</em>' attribute.
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.I_avoidable
	 * @see #getI()
	 * @generated
	 */
	public void setI(I_avoidable newI) {
		I_avoidable oldI = i;
		i = newI == null ? I_EDEFAULT : newI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlammPackage.ACI_DAVOIDABLE__I, oldI, i));
	}

	/**
	 * Returns the value of the '<em><b>D</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polarsys.chess.fla.flamm.FailureTypes.D_avoidable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>D</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>D</em>' attribute.
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.D_avoidable
	 * @see #setD(D_avoidable)
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getACIDavoidable_D()
	 * @model
	 * @generated
	 */
	public D_avoidable getD() {
		return d;
	}

	/**
	 * Sets the value of the '{@link org.polarsys.chess.fla.flamm.ACIDavoidable#getD <em>D</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>D</em>' attribute.
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.D_avoidable
	 * @see #getD()
	 * @generated
	 */
	public void setD(D_avoidable newD) {
		D_avoidable oldD = d;
		d = newD == null ? D_EDEFAULT : newD;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlammPackage.ACI_DAVOIDABLE__D, oldD, d));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FlammPackage.ACI_DAVOIDABLE__A:
				return getA();
			case FlammPackage.ACI_DAVOIDABLE__C:
				return getC();
			case FlammPackage.ACI_DAVOIDABLE__I:
				return getI();
			case FlammPackage.ACI_DAVOIDABLE__D:
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FlammPackage.ACI_DAVOIDABLE__A:
				setA((A_avoidable)newValue);
				return;
			case FlammPackage.ACI_DAVOIDABLE__C:
				setC((C_avoidable)newValue);
				return;
			case FlammPackage.ACI_DAVOIDABLE__I:
				setI((I_avoidable)newValue);
				return;
			case FlammPackage.ACI_DAVOIDABLE__D:
				setD((D_avoidable)newValue);
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
			case FlammPackage.ACI_DAVOIDABLE__A:
				setA(A_EDEFAULT);
				return;
			case FlammPackage.ACI_DAVOIDABLE__C:
				setC(C_EDEFAULT);
				return;
			case FlammPackage.ACI_DAVOIDABLE__I:
				setI(I_EDEFAULT);
				return;
			case FlammPackage.ACI_DAVOIDABLE__D:
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FlammPackage.ACI_DAVOIDABLE__A:
				return a != A_EDEFAULT;
			case FlammPackage.ACI_DAVOIDABLE__C:
				return c != C_EDEFAULT;
			case FlammPackage.ACI_DAVOIDABLE__I:
				return i != I_EDEFAULT;
			case FlammPackage.ACI_DAVOIDABLE__D:
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
	public String toString() {
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

} // ACIDavoidable
