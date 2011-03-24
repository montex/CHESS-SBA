/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel.impl;

import DependabilityintermediateModel.DependabilityintermediateModelPackage;
import DependabilityintermediateModel.Gamma;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gamma</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link DependabilityintermediateModel.impl.GammaImpl#getAlpha <em>Alpha</em>}</li>
 *   <li>{@link DependabilityintermediateModel.impl.GammaImpl#getBeta <em>Beta</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GammaImpl extends DistributionImpl implements Gamma {
	/**
	 * The default value of the '{@link #getAlpha() <em>Alpha</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlpha()
	 * @generated
	 * @ordered
	 */
	protected static final double ALPHA_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAlpha() <em>Alpha</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlpha()
	 * @generated
	 * @ordered
	 */
	protected double alpha = ALPHA_EDEFAULT;

	/**
	 * The default value of the '{@link #getBeta() <em>Beta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBeta()
	 * @generated
	 * @ordered
	 */
	protected static final double BETA_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getBeta() <em>Beta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBeta()
	 * @generated
	 * @ordered
	 */
	protected double beta = BETA_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GammaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DependabilityintermediateModelPackage.Literals.GAMMA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAlpha() {
		return alpha;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlpha(double newAlpha) {
		double oldAlpha = alpha;
		alpha = newAlpha;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.GAMMA__ALPHA, oldAlpha, alpha));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getBeta() {
		return beta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBeta(double newBeta) {
		double oldBeta = beta;
		beta = newBeta;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.GAMMA__BETA, oldBeta, beta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DependabilityintermediateModelPackage.GAMMA__ALPHA:
				return getAlpha();
			case DependabilityintermediateModelPackage.GAMMA__BETA:
				return getBeta();
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
			case DependabilityintermediateModelPackage.GAMMA__ALPHA:
				setAlpha((Double)newValue);
				return;
			case DependabilityintermediateModelPackage.GAMMA__BETA:
				setBeta((Double)newValue);
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
			case DependabilityintermediateModelPackage.GAMMA__ALPHA:
				setAlpha(ALPHA_EDEFAULT);
				return;
			case DependabilityintermediateModelPackage.GAMMA__BETA:
				setBeta(BETA_EDEFAULT);
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
			case DependabilityintermediateModelPackage.GAMMA__ALPHA:
				return alpha != ALPHA_EDEFAULT;
			case DependabilityintermediateModelPackage.GAMMA__BETA:
				return beta != BETA_EDEFAULT;
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
		result.append(" (Alpha: ");
		result.append(alpha);
		result.append(", Beta: ");
		result.append(beta);
		result.append(')');
		return result.toString();
	}

} //GammaImpl
