/**
 */
package org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAnalysisContext;

import org.eclipse.uml2.uml.Component;

import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage;
import org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.ResultElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Result Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.ResultElementImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.ResultElementImpl#getDate <em>Date</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.ResultElementImpl#getConditions <em>Conditions</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.ResultElementImpl#isValid <em>Valid</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.ResultElementImpl#getFile <em>File</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.ResultElementImpl#getRoot <em>Root</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.ResultElementImpl#getContextAnalysis <em>Context Analysis</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.impl.ResultElementImpl#getBase_Component <em>Base Component</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResultElementImpl extends EObjectImpl implements ResultElement {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final String DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected String date = DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getConditions() <em>Conditions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditions()
	 * @generated
	 * @ordered
	 */
	protected static final String CONDITIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConditions() <em>Conditions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditions()
	 * @generated
	 * @ordered
	 */
	protected String conditions = CONDITIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #isValid() <em>Valid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValid()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VALID_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isValid() <em>Valid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValid()
	 * @generated
	 * @ordered
	 */
	protected boolean valid = VALID_EDEFAULT;

	/**
	 * The default value of the '{@link #getFile() <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFile()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFile() <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFile()
	 * @generated
	 * @ordered
	 */
	protected String file = FILE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRoot() <em>Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoot()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class root;

	/**
	 * The cached value of the '{@link #getContextAnalysis() <em>Context Analysis</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextAnalysis()
	 * @generated
	 * @ordered
	 */
	protected GaAnalysisContext contextAnalysis;

	/**
	 * The cached value of the '{@link #getBase_Component() <em>Base Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Component()
	 * @generated
	 * @ordered
	 */
	protected Component base_Component;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResultElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DependableComponentPackage.Literals.RESULT_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependableComponentPackage.RESULT_ELEMENT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(String newDate) {
		String oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependableComponentPackage.RESULT_ELEMENT__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConditions() {
		return conditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConditions(String newConditions) {
		String oldConditions = conditions;
		conditions = newConditions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependableComponentPackage.RESULT_ELEMENT__CONDITIONS, oldConditions, conditions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isValid() {
		return valid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValid(boolean newValid) {
		boolean oldValid = valid;
		valid = newValid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependableComponentPackage.RESULT_ELEMENT__VALID, oldValid, valid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFile() {
		return file;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFile(String newFile) {
		String oldFile = file;
		file = newFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependableComponentPackage.RESULT_ELEMENT__FILE, oldFile, file));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getRoot() {
		if (root != null && root.eIsProxy()) {
			InternalEObject oldRoot = (InternalEObject)root;
			root = (org.eclipse.uml2.uml.Class)eResolveProxy(oldRoot);
			if (root != oldRoot) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DependableComponentPackage.RESULT_ELEMENT__ROOT, oldRoot, root));
			}
		}
		return root;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetRoot() {
		return root;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoot(org.eclipse.uml2.uml.Class newRoot) {
		org.eclipse.uml2.uml.Class oldRoot = root;
		root = newRoot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependableComponentPackage.RESULT_ELEMENT__ROOT, oldRoot, root));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GaAnalysisContext getContextAnalysis() {
		if (contextAnalysis != null && contextAnalysis.eIsProxy()) {
			InternalEObject oldContextAnalysis = (InternalEObject)contextAnalysis;
			contextAnalysis = (GaAnalysisContext)eResolveProxy(oldContextAnalysis);
			if (contextAnalysis != oldContextAnalysis) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DependableComponentPackage.RESULT_ELEMENT__CONTEXT_ANALYSIS, oldContextAnalysis, contextAnalysis));
			}
		}
		return contextAnalysis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GaAnalysisContext basicGetContextAnalysis() {
		return contextAnalysis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextAnalysis(GaAnalysisContext newContextAnalysis) {
		GaAnalysisContext oldContextAnalysis = contextAnalysis;
		contextAnalysis = newContextAnalysis;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependableComponentPackage.RESULT_ELEMENT__CONTEXT_ANALYSIS, oldContextAnalysis, contextAnalysis));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component getBase_Component() {
		if (base_Component != null && base_Component.eIsProxy()) {
			InternalEObject oldBase_Component = (InternalEObject)base_Component;
			base_Component = (Component)eResolveProxy(oldBase_Component);
			if (base_Component != oldBase_Component) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DependableComponentPackage.RESULT_ELEMENT__BASE_COMPONENT, oldBase_Component, base_Component));
			}
		}
		return base_Component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component basicGetBase_Component() {
		return base_Component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Component(Component newBase_Component) {
		Component oldBase_Component = base_Component;
		base_Component = newBase_Component;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependableComponentPackage.RESULT_ELEMENT__BASE_COMPONENT, oldBase_Component, base_Component));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DependableComponentPackage.RESULT_ELEMENT__TYPE:
				return getType();
			case DependableComponentPackage.RESULT_ELEMENT__DATE:
				return getDate();
			case DependableComponentPackage.RESULT_ELEMENT__CONDITIONS:
				return getConditions();
			case DependableComponentPackage.RESULT_ELEMENT__VALID:
				return isValid();
			case DependableComponentPackage.RESULT_ELEMENT__FILE:
				return getFile();
			case DependableComponentPackage.RESULT_ELEMENT__ROOT:
				if (resolve) return getRoot();
				return basicGetRoot();
			case DependableComponentPackage.RESULT_ELEMENT__CONTEXT_ANALYSIS:
				if (resolve) return getContextAnalysis();
				return basicGetContextAnalysis();
			case DependableComponentPackage.RESULT_ELEMENT__BASE_COMPONENT:
				if (resolve) return getBase_Component();
				return basicGetBase_Component();
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
			case DependableComponentPackage.RESULT_ELEMENT__TYPE:
				setType((String)newValue);
				return;
			case DependableComponentPackage.RESULT_ELEMENT__DATE:
				setDate((String)newValue);
				return;
			case DependableComponentPackage.RESULT_ELEMENT__CONDITIONS:
				setConditions((String)newValue);
				return;
			case DependableComponentPackage.RESULT_ELEMENT__VALID:
				setValid((Boolean)newValue);
				return;
			case DependableComponentPackage.RESULT_ELEMENT__FILE:
				setFile((String)newValue);
				return;
			case DependableComponentPackage.RESULT_ELEMENT__ROOT:
				setRoot((org.eclipse.uml2.uml.Class)newValue);
				return;
			case DependableComponentPackage.RESULT_ELEMENT__CONTEXT_ANALYSIS:
				setContextAnalysis((GaAnalysisContext)newValue);
				return;
			case DependableComponentPackage.RESULT_ELEMENT__BASE_COMPONENT:
				setBase_Component((Component)newValue);
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
			case DependableComponentPackage.RESULT_ELEMENT__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case DependableComponentPackage.RESULT_ELEMENT__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case DependableComponentPackage.RESULT_ELEMENT__CONDITIONS:
				setConditions(CONDITIONS_EDEFAULT);
				return;
			case DependableComponentPackage.RESULT_ELEMENT__VALID:
				setValid(VALID_EDEFAULT);
				return;
			case DependableComponentPackage.RESULT_ELEMENT__FILE:
				setFile(FILE_EDEFAULT);
				return;
			case DependableComponentPackage.RESULT_ELEMENT__ROOT:
				setRoot((org.eclipse.uml2.uml.Class)null);
				return;
			case DependableComponentPackage.RESULT_ELEMENT__CONTEXT_ANALYSIS:
				setContextAnalysis((GaAnalysisContext)null);
				return;
			case DependableComponentPackage.RESULT_ELEMENT__BASE_COMPONENT:
				setBase_Component((Component)null);
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
			case DependableComponentPackage.RESULT_ELEMENT__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case DependableComponentPackage.RESULT_ELEMENT__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case DependableComponentPackage.RESULT_ELEMENT__CONDITIONS:
				return CONDITIONS_EDEFAULT == null ? conditions != null : !CONDITIONS_EDEFAULT.equals(conditions);
			case DependableComponentPackage.RESULT_ELEMENT__VALID:
				return valid != VALID_EDEFAULT;
			case DependableComponentPackage.RESULT_ELEMENT__FILE:
				return FILE_EDEFAULT == null ? file != null : !FILE_EDEFAULT.equals(file);
			case DependableComponentPackage.RESULT_ELEMENT__ROOT:
				return root != null;
			case DependableComponentPackage.RESULT_ELEMENT__CONTEXT_ANALYSIS:
				return contextAnalysis != null;
			case DependableComponentPackage.RESULT_ELEMENT__BASE_COMPONENT:
				return base_Component != null;
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
		result.append(" (type: ");
		result.append(type);
		result.append(", date: ");
		result.append(date);
		result.append(", conditions: ");
		result.append(conditions);
		result.append(", valid: ");
		result.append(valid);
		result.append(", file: ");
		result.append(file);
		result.append(')');
		return result.toString();
	}

} //ResultElementImpl
