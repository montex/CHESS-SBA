/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel.impl;

import DependabilityintermediateModel.Component;
import DependabilityintermediateModel.DependabilityintermediateModelPackage;
import DependabilityintermediateModel.ErrorsProduceFailures;
import DependabilityintermediateModel.FailureMode;
import DependabilityintermediateModel.Fault;
import DependabilityintermediateModel.FaultsGenerateErrors;
import DependabilityintermediateModel.InternalPropagation;
import DependabilityintermediateModel.Sistema;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link DependabilityintermediateModel.impl.ComponentImpl#getIntermediateModel <em>Intermediate Model</em>}</li>
 *   <li>{@link DependabilityintermediateModel.impl.ComponentImpl#getFailureModes <em>Failure Modes</em>}</li>
 *   <li>{@link DependabilityintermediateModel.impl.ComponentImpl#getErrors <em>Errors</em>}</li>
 *   <li>{@link DependabilityintermediateModel.impl.ComponentImpl#getFaults <em>Faults</em>}</li>
 *   <li>{@link DependabilityintermediateModel.impl.ComponentImpl#getFaultsGeneratesErrors <em>Faults Generates Errors</em>}</li>
 *   <li>{@link DependabilityintermediateModel.impl.ComponentImpl#getInternalPropagation <em>Internal Propagation</em>}</li>
 *   <li>{@link DependabilityintermediateModel.impl.ComponentImpl#getErrorsGeneratesFailures <em>Errors Generates Failures</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentImpl extends NamedElementImpl implements Component {
	/**
	 * The cached value of the '{@link #getFailureModes() <em>Failure Modes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureModes()
	 * @generated
	 * @ordered
	 */
	protected EList<FailureMode> failureModes;

	/**
	 * The cached value of the '{@link #getErrors() <em>Errors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrors()
	 * @generated
	 * @ordered
	 */
	protected EList<DependabilityintermediateModel.Error> errors;

	/**
	 * The cached value of the '{@link #getFaults() <em>Faults</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaults()
	 * @generated
	 * @ordered
	 */
	protected EList<Fault> faults;

	/**
	 * The cached value of the '{@link #getFaultsGeneratesErrors() <em>Faults Generates Errors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultsGeneratesErrors()
	 * @generated
	 * @ordered
	 */
	protected EList<FaultsGenerateErrors> faultsGeneratesErrors;

	/**
	 * The cached value of the '{@link #getInternalPropagation() <em>Internal Propagation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalPropagation()
	 * @generated
	 * @ordered
	 */
	protected EList<InternalPropagation> internalPropagation;

	/**
	 * The cached value of the '{@link #getErrorsGeneratesFailures() <em>Errors Generates Failures</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorsGeneratesFailures()
	 * @generated
	 * @ordered
	 */
	protected EList<ErrorsProduceFailures> errorsGeneratesFailures;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DependabilityintermediateModelPackage.Literals.COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sistema getIntermediateModel() {
		if (eContainerFeatureID() != DependabilityintermediateModelPackage.COMPONENT__INTERMEDIATE_MODEL) return null;
		return (Sistema)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIntermediateModel(Sistema newIntermediateModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newIntermediateModel, DependabilityintermediateModelPackage.COMPONENT__INTERMEDIATE_MODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntermediateModel(Sistema newIntermediateModel) {
		if (newIntermediateModel != eInternalContainer() || (eContainerFeatureID() != DependabilityintermediateModelPackage.COMPONENT__INTERMEDIATE_MODEL && newIntermediateModel != null)) {
			if (EcoreUtil.isAncestor(this, newIntermediateModel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newIntermediateModel != null)
				msgs = ((InternalEObject)newIntermediateModel).eInverseAdd(this, DependabilityintermediateModelPackage.SISTEMA__COMPONENTS, Sistema.class, msgs);
			msgs = basicSetIntermediateModel(newIntermediateModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityintermediateModelPackage.COMPONENT__INTERMEDIATE_MODEL, newIntermediateModel, newIntermediateModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FailureMode> getFailureModes() {
		if (failureModes == null) {
			failureModes = new EObjectContainmentWithInverseEList<FailureMode>(FailureMode.class, this, DependabilityintermediateModelPackage.COMPONENT__FAILURE_MODES, DependabilityintermediateModelPackage.FAILURE_MODE__COMPONENT);
		}
		return failureModes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DependabilityintermediateModel.Error> getErrors() {
		if (errors == null) {
			errors = new EObjectContainmentWithInverseEList<DependabilityintermediateModel.Error>(DependabilityintermediateModel.Error.class, this, DependabilityintermediateModelPackage.COMPONENT__ERRORS, DependabilityintermediateModelPackage.ERROR__COMPONENT);
		}
		return errors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Fault> getFaults() {
		if (faults == null) {
			faults = new EObjectContainmentWithInverseEList<Fault>(Fault.class, this, DependabilityintermediateModelPackage.COMPONENT__FAULTS, DependabilityintermediateModelPackage.FAULT__COMPONENT);
		}
		return faults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FaultsGenerateErrors> getFaultsGeneratesErrors() {
		if (faultsGeneratesErrors == null) {
			faultsGeneratesErrors = new EObjectContainmentWithInverseEList<FaultsGenerateErrors>(FaultsGenerateErrors.class, this, DependabilityintermediateModelPackage.COMPONENT__FAULTS_GENERATES_ERRORS, DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS__COMPONENT);
		}
		return faultsGeneratesErrors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InternalPropagation> getInternalPropagation() {
		if (internalPropagation == null) {
			internalPropagation = new EObjectContainmentEList<InternalPropagation>(InternalPropagation.class, this, DependabilityintermediateModelPackage.COMPONENT__INTERNAL_PROPAGATION);
		}
		return internalPropagation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ErrorsProduceFailures> getErrorsGeneratesFailures() {
		if (errorsGeneratesFailures == null) {
			errorsGeneratesFailures = new EObjectContainmentEList<ErrorsProduceFailures>(ErrorsProduceFailures.class, this, DependabilityintermediateModelPackage.COMPONENT__ERRORS_GENERATES_FAILURES);
		}
		return errorsGeneratesFailures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DependabilityintermediateModelPackage.COMPONENT__INTERMEDIATE_MODEL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetIntermediateModel((Sistema)otherEnd, msgs);
			case DependabilityintermediateModelPackage.COMPONENT__FAILURE_MODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFailureModes()).basicAdd(otherEnd, msgs);
			case DependabilityintermediateModelPackage.COMPONENT__ERRORS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getErrors()).basicAdd(otherEnd, msgs);
			case DependabilityintermediateModelPackage.COMPONENT__FAULTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFaults()).basicAdd(otherEnd, msgs);
			case DependabilityintermediateModelPackage.COMPONENT__FAULTS_GENERATES_ERRORS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFaultsGeneratesErrors()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DependabilityintermediateModelPackage.COMPONENT__INTERMEDIATE_MODEL:
				return basicSetIntermediateModel(null, msgs);
			case DependabilityintermediateModelPackage.COMPONENT__FAILURE_MODES:
				return ((InternalEList<?>)getFailureModes()).basicRemove(otherEnd, msgs);
			case DependabilityintermediateModelPackage.COMPONENT__ERRORS:
				return ((InternalEList<?>)getErrors()).basicRemove(otherEnd, msgs);
			case DependabilityintermediateModelPackage.COMPONENT__FAULTS:
				return ((InternalEList<?>)getFaults()).basicRemove(otherEnd, msgs);
			case DependabilityintermediateModelPackage.COMPONENT__FAULTS_GENERATES_ERRORS:
				return ((InternalEList<?>)getFaultsGeneratesErrors()).basicRemove(otherEnd, msgs);
			case DependabilityintermediateModelPackage.COMPONENT__INTERNAL_PROPAGATION:
				return ((InternalEList<?>)getInternalPropagation()).basicRemove(otherEnd, msgs);
			case DependabilityintermediateModelPackage.COMPONENT__ERRORS_GENERATES_FAILURES:
				return ((InternalEList<?>)getErrorsGeneratesFailures()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case DependabilityintermediateModelPackage.COMPONENT__INTERMEDIATE_MODEL:
				return eInternalContainer().eInverseRemove(this, DependabilityintermediateModelPackage.SISTEMA__COMPONENTS, Sistema.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DependabilityintermediateModelPackage.COMPONENT__INTERMEDIATE_MODEL:
				return getIntermediateModel();
			case DependabilityintermediateModelPackage.COMPONENT__FAILURE_MODES:
				return getFailureModes();
			case DependabilityintermediateModelPackage.COMPONENT__ERRORS:
				return getErrors();
			case DependabilityintermediateModelPackage.COMPONENT__FAULTS:
				return getFaults();
			case DependabilityintermediateModelPackage.COMPONENT__FAULTS_GENERATES_ERRORS:
				return getFaultsGeneratesErrors();
			case DependabilityintermediateModelPackage.COMPONENT__INTERNAL_PROPAGATION:
				return getInternalPropagation();
			case DependabilityintermediateModelPackage.COMPONENT__ERRORS_GENERATES_FAILURES:
				return getErrorsGeneratesFailures();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DependabilityintermediateModelPackage.COMPONENT__INTERMEDIATE_MODEL:
				setIntermediateModel((Sistema)newValue);
				return;
			case DependabilityintermediateModelPackage.COMPONENT__FAILURE_MODES:
				getFailureModes().clear();
				getFailureModes().addAll((Collection<? extends FailureMode>)newValue);
				return;
			case DependabilityintermediateModelPackage.COMPONENT__ERRORS:
				getErrors().clear();
				getErrors().addAll((Collection<? extends DependabilityintermediateModel.Error>)newValue);
				return;
			case DependabilityintermediateModelPackage.COMPONENT__FAULTS:
				getFaults().clear();
				getFaults().addAll((Collection<? extends Fault>)newValue);
				return;
			case DependabilityintermediateModelPackage.COMPONENT__FAULTS_GENERATES_ERRORS:
				getFaultsGeneratesErrors().clear();
				getFaultsGeneratesErrors().addAll((Collection<? extends FaultsGenerateErrors>)newValue);
				return;
			case DependabilityintermediateModelPackage.COMPONENT__INTERNAL_PROPAGATION:
				getInternalPropagation().clear();
				getInternalPropagation().addAll((Collection<? extends InternalPropagation>)newValue);
				return;
			case DependabilityintermediateModelPackage.COMPONENT__ERRORS_GENERATES_FAILURES:
				getErrorsGeneratesFailures().clear();
				getErrorsGeneratesFailures().addAll((Collection<? extends ErrorsProduceFailures>)newValue);
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
			case DependabilityintermediateModelPackage.COMPONENT__INTERMEDIATE_MODEL:
				setIntermediateModel((Sistema)null);
				return;
			case DependabilityintermediateModelPackage.COMPONENT__FAILURE_MODES:
				getFailureModes().clear();
				return;
			case DependabilityintermediateModelPackage.COMPONENT__ERRORS:
				getErrors().clear();
				return;
			case DependabilityintermediateModelPackage.COMPONENT__FAULTS:
				getFaults().clear();
				return;
			case DependabilityintermediateModelPackage.COMPONENT__FAULTS_GENERATES_ERRORS:
				getFaultsGeneratesErrors().clear();
				return;
			case DependabilityintermediateModelPackage.COMPONENT__INTERNAL_PROPAGATION:
				getInternalPropagation().clear();
				return;
			case DependabilityintermediateModelPackage.COMPONENT__ERRORS_GENERATES_FAILURES:
				getErrorsGeneratesFailures().clear();
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
			case DependabilityintermediateModelPackage.COMPONENT__INTERMEDIATE_MODEL:
				return getIntermediateModel() != null;
			case DependabilityintermediateModelPackage.COMPONENT__FAILURE_MODES:
				return failureModes != null && !failureModes.isEmpty();
			case DependabilityintermediateModelPackage.COMPONENT__ERRORS:
				return errors != null && !errors.isEmpty();
			case DependabilityintermediateModelPackage.COMPONENT__FAULTS:
				return faults != null && !faults.isEmpty();
			case DependabilityintermediateModelPackage.COMPONENT__FAULTS_GENERATES_ERRORS:
				return faultsGeneratesErrors != null && !faultsGeneratesErrors.isEmpty();
			case DependabilityintermediateModelPackage.COMPONENT__INTERNAL_PROPAGATION:
				return internalPropagation != null && !internalPropagation.isEmpty();
			case DependabilityintermediateModelPackage.COMPONENT__ERRORS_GENERATES_FAILURES:
				return errorsGeneratesFailures != null && !errorsGeneratesFailures.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ComponentImpl
