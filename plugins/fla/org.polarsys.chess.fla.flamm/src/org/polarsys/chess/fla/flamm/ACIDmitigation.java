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
import org.polarsys.chess.fla.flamm.FailureTypes.A_mitigation;
import org.polarsys.chess.fla.flamm.FailureTypes.C_mitigation;
import org.polarsys.chess.fla.flamm.FailureTypes.D_mitigation;
import org.polarsys.chess.fla.flamm.FailureTypes.I_mitigation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ACI Dmitigation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.fla.flamm.ACIDmitigation#getA <em>A</em>}</li>
 *   <li>{@link org.polarsys.chess.fla.flamm.ACIDmitigation#getC <em>C</em>}</li>
 *   <li>{@link org.polarsys.chess.fla.flamm.ACIDmitigation#getI <em>I</em>}</li>
 *   <li>{@link org.polarsys.chess.fla.flamm.ACIDmitigation#getD <em>D</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.fla.flamm.FlammPackage#getACIDmitigation()
 * @model kind="class"
 * @generated
 */
public class ACIDmitigation extends MinimalEObjectImpl.Container implements EObject {
	/**
	 * The default value of the '{@link #getA() <em>A</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getA()
	 * @generated
	 * @ordered
	 */
	protected static final A_mitigation A_EDEFAULT = A_mitigation.UNSPECIFIED;

	/**
	 * The cached value of the '{@link #getA() <em>A</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getA()
	 * @generated
	 * @ordered
	 */
	protected A_mitigation a = A_EDEFAULT;

	/**
	 * The default value of the '{@link #getC() <em>C</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getC()
	 * @generated
	 * @ordered
	 */
	protected static final C_mitigation C_EDEFAULT = C_mitigation.UNSPECIFIED;

	/**
	 * The cached value of the '{@link #getC() <em>C</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getC()
	 * @generated
	 * @ordered
	 */
	protected C_mitigation c = C_EDEFAULT;

	/**
	 * The default value of the '{@link #getI() <em>I</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getI()
	 * @generated
	 * @ordered
	 */
	protected static final I_mitigation I_EDEFAULT = I_mitigation.UNSPECIFIED;

	/**
	 * The cached value of the '{@link #getI() <em>I</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getI()
	 * @generated
	 * @ordered
	 */
	protected I_mitigation i = I_EDEFAULT;

	/**
	 * The default value of the '{@link #getD() <em>D</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getD()
	 * @generated
	 * @ordered
	 */
	protected static final D_mitigation D_EDEFAULT = D_mitigation.UNSPECIFIED;

	/**
	 * The cached value of the '{@link #getD() <em>D</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getD()
	 * @generated
	 * @ordered
	 */
	protected D_mitigation d = D_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ACIDmitigation() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FlammPackage.Literals.ACI_DMITIGATION;
	}

	/**
	 * Returns the value of the '<em><b>A</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polarsys.chess.fla.flamm.FailureTypes.A_mitigation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>A</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>A</em>' attribute.
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.A_mitigation
	 * @see #setA(A_mitigation)
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getACIDmitigation_A()
	 * @model
	 * @generated
	 */
	public A_mitigation getA() {
		return a;
	}

	/**
	 * Sets the value of the '{@link org.polarsys.chess.fla.flamm.ACIDmitigation#getA <em>A</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>A</em>' attribute.
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.A_mitigation
	 * @see #getA()
	 * @generated
	 */
	public void setA(A_mitigation newA) {
		A_mitigation oldA = a;
		a = newA == null ? A_EDEFAULT : newA;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlammPackage.ACI_DMITIGATION__A, oldA, a));
	}

	/**
	 * Returns the value of the '<em><b>C</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polarsys.chess.fla.flamm.FailureTypes.C_mitigation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>C</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>C</em>' attribute.
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.C_mitigation
	 * @see #setC(C_mitigation)
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getACIDmitigation_C()
	 * @model
	 * @generated
	 */
	public C_mitigation getC() {
		return c;
	}

	/**
	 * Sets the value of the '{@link org.polarsys.chess.fla.flamm.ACIDmitigation#getC <em>C</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>C</em>' attribute.
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.C_mitigation
	 * @see #getC()
	 * @generated
	 */
	public void setC(C_mitigation newC) {
		C_mitigation oldC = c;
		c = newC == null ? C_EDEFAULT : newC;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlammPackage.ACI_DMITIGATION__C, oldC, c));
	}

	/**
	 * Returns the value of the '<em><b>I</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polarsys.chess.fla.flamm.FailureTypes.I_mitigation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>I</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>I</em>' attribute.
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.I_mitigation
	 * @see #setI(I_mitigation)
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getACIDmitigation_I()
	 * @model
	 * @generated
	 */
	public I_mitigation getI() {
		return i;
	}

	/**
	 * Sets the value of the '{@link org.polarsys.chess.fla.flamm.ACIDmitigation#getI <em>I</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>I</em>' attribute.
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.I_mitigation
	 * @see #getI()
	 * @generated
	 */
	public void setI(I_mitigation newI) {
		I_mitigation oldI = i;
		i = newI == null ? I_EDEFAULT : newI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlammPackage.ACI_DMITIGATION__I, oldI, i));
	}

	/**
	 * Returns the value of the '<em><b>D</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polarsys.chess.fla.flamm.FailureTypes.D_mitigation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>D</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>D</em>' attribute.
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.D_mitigation
	 * @see #setD(D_mitigation)
	 * @see org.polarsys.chess.fla.flamm.FlammPackage#getACIDmitigation_D()
	 * @model
	 * @generated
	 */
	public D_mitigation getD() {
		return d;
	}

	/**
	 * Sets the value of the '{@link org.polarsys.chess.fla.flamm.ACIDmitigation#getD <em>D</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>D</em>' attribute.
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.D_mitigation
	 * @see #getD()
	 * @generated
	 */
	public void setD(D_mitigation newD) {
		D_mitigation oldD = d;
		d = newD == null ? D_EDEFAULT : newD;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlammPackage.ACI_DMITIGATION__D, oldD, d));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FlammPackage.ACI_DMITIGATION__A:
				return getA();
			case FlammPackage.ACI_DMITIGATION__C:
				return getC();
			case FlammPackage.ACI_DMITIGATION__I:
				return getI();
			case FlammPackage.ACI_DMITIGATION__D:
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
			case FlammPackage.ACI_DMITIGATION__A:
				setA((A_mitigation)newValue);
				return;
			case FlammPackage.ACI_DMITIGATION__C:
				setC((C_mitigation)newValue);
				return;
			case FlammPackage.ACI_DMITIGATION__I:
				setI((I_mitigation)newValue);
				return;
			case FlammPackage.ACI_DMITIGATION__D:
				setD((D_mitigation)newValue);
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
			case FlammPackage.ACI_DMITIGATION__A:
				setA(A_EDEFAULT);
				return;
			case FlammPackage.ACI_DMITIGATION__C:
				setC(C_EDEFAULT);
				return;
			case FlammPackage.ACI_DMITIGATION__I:
				setI(I_EDEFAULT);
				return;
			case FlammPackage.ACI_DMITIGATION__D:
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
			case FlammPackage.ACI_DMITIGATION__A:
				return a != A_EDEFAULT;
			case FlammPackage.ACI_DMITIGATION__C:
				return c != C_EDEFAULT;
			case FlammPackage.ACI_DMITIGATION__I:
				return i != I_EDEFAULT;
			case FlammPackage.ACI_DMITIGATION__D:
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

} // ACIDmitigation
