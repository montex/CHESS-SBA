/*****************************************************************************
 * Copyright (c) 2011 - 2014 University of Padova, Intecs
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *
 *****************************************************************************/
package org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.CallConcurrencyKind;
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Type;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTComponentModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CH Rt Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.CHRtSpecificationImpl#getPartWithPort <em>Part With Port</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.CHRtSpecificationImpl#getWCET <em>WCET</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.CHRtSpecificationImpl#getLocalWCET <em>Local WCET</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.CHRtSpecificationImpl#getRelativePriority <em>Relative Priority</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.CHRtSpecificationImpl#getCeiling <em>Ceiling</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.CHRtSpecificationImpl#getMemorySizeFootprint <em>Memory Size Footprint</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.CHRtSpecificationImpl#getStackSize <em>Stack Size</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.CHRtSpecificationImpl#getHeapSize <em>Heap Size</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.CHRtSpecificationImpl#getSlot <em>Slot</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.CHRtSpecificationImpl#getBase_Comment <em>Base Comment</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.CHRtSpecificationImpl#getOccKind <em>Occ Kind</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.CHRtSpecificationImpl#getProtection <em>Protection</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.CHRtSpecificationImpl#getRlDl <em>Rl Dl</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.CHRtSpecificationImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.CHRtSpecificationImpl#getRespT <em>Resp T</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.CHRtSpecificationImpl#getBlockT <em>Block T</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.impl.CHRtSpecificationImpl#getOperationReqForSporadicOcc <em>Operation Req For Sporadic Occ</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CHRtSpecificationImpl extends EObjectImpl implements CHRtSpecification {
	/**
	 * The cached value of the '{@link #getPartWithPort() <em>Part With Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartWithPort()
	 * @generated
	 * @ordered
	 */
	protected Property partWithPort;

	/**
	 * The default value of the '{@link #getWCET() <em>WCET</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWCET()
	 * @generated
	 * @ordered
	 */
	protected static final String WCET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWCET() <em>WCET</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWCET()
	 * @generated
	 * @ordered
	 */
	protected String wcet = WCET_EDEFAULT;

	/**
	 * The default value of the '{@link #getLocalWCET() <em>Local WCET</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalWCET()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCAL_WCET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocalWCET() <em>Local WCET</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalWCET()
	 * @generated
	 * @ordered
	 */
	protected String localWCET = LOCAL_WCET_EDEFAULT;

	/**
	 * The default value of the '{@link #getRelativePriority() <em>Relative Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelativePriority()
	 * @generated
	 * @ordered
	 */
	protected static final String RELATIVE_PRIORITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRelativePriority() <em>Relative Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelativePriority()
	 * @generated
	 * @ordered
	 */
	protected String relativePriority = RELATIVE_PRIORITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getCeiling() <em>Ceiling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCeiling()
	 * @generated
	 * @ordered
	 */
	protected static final String CEILING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCeiling() <em>Ceiling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCeiling()
	 * @generated
	 * @ordered
	 */
	protected String ceiling = CEILING_EDEFAULT;

	/**
	 * The default value of the '{@link #getMemorySizeFootprint() <em>Memory Size Footprint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemorySizeFootprint()
	 * @generated
	 * @ordered
	 */
	protected static final String MEMORY_SIZE_FOOTPRINT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMemorySizeFootprint() <em>Memory Size Footprint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemorySizeFootprint()
	 * @generated
	 * @ordered
	 */
	protected String memorySizeFootprint = MEMORY_SIZE_FOOTPRINT_EDEFAULT;

	/**
	 * The default value of the '{@link #getStackSize() <em>Stack Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStackSize()
	 * @generated
	 * @ordered
	 */
	protected static final String STACK_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStackSize() <em>Stack Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStackSize()
	 * @generated
	 * @ordered
	 */
	protected String stackSize = STACK_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeapSize() <em>Heap Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeapSize()
	 * @generated
	 * @ordered
	 */
	protected static final String HEAP_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHeapSize() <em>Heap Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeapSize()
	 * @generated
	 * @ordered
	 */
	protected String heapSize = HEAP_SIZE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSlot() <em>Slot</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlot()
	 * @generated
	 * @ordered
	 */
	protected Slot slot;

	/**
	 * The cached value of the '{@link #getBase_Comment() <em>Base Comment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Comment()
	 * @generated
	 * @ordered
	 */
	protected Comment base_Comment;

	/**
	 * The default value of the '{@link #getOccKind() <em>Occ Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOccKind()
	 * @generated
	 * @ordered
	 */
	protected static final String OCC_KIND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOccKind() <em>Occ Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOccKind()
	 * @generated
	 * @ordered
	 */
	protected String occKind = OCC_KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getProtection() <em>Protection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtection()
	 * @generated
	 * @ordered
	 */
	protected static final CallConcurrencyKind PROTECTION_EDEFAULT = CallConcurrencyKind.SEQUENTIAL;

	/**
	 * The cached value of the '{@link #getProtection() <em>Protection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtection()
	 * @generated
	 * @ordered
	 */
	protected CallConcurrencyKind protection = PROTECTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getRlDl() <em>Rl Dl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRlDl()
	 * @generated
	 * @ordered
	 */
	protected static final String RL_DL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRlDl() <em>Rl Dl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRlDl()
	 * @generated
	 * @ordered
	 */
	protected String rlDl = RL_DL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected BehavioralFeature context;

	/**
	 * The cached value of the '{@link #getRespT() <em>Resp T</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRespT()
	 * @generated
	 * @ordered
	 */
	protected EList<String> respT;

	/**
	 * The cached value of the '{@link #getBlockT() <em>Block T</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlockT()
	 * @generated
	 * @ordered
	 */
	protected EList<String> blockT;

	/**
	 * The cached value of the '{@link #getOperationReqForSporadicOcc() <em>Operation Req For Sporadic Occ</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationReqForSporadicOcc()
	 * @generated
	 * @ordered
	 */
	protected EList<Operation> operationReqForSporadicOcc;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CHRtSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RTComponentModelPackage.Literals.CH_RT_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getPartWithPort() {
		if (partWithPort != null && partWithPort.eIsProxy()) {
			InternalEObject oldPartWithPort = (InternalEObject)partWithPort;
			partWithPort = (Property)eResolveProxy(oldPartWithPort);
			if (partWithPort != oldPartWithPort) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RTComponentModelPackage.CH_RT_SPECIFICATION__PART_WITH_PORT, oldPartWithPort, partWithPort));
			}
		}
		return partWithPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetPartWithPort() {
		return partWithPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartWithPort(Property newPartWithPort) {
		Property oldPartWithPort = partWithPort;
		partWithPort = newPartWithPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RTComponentModelPackage.CH_RT_SPECIFICATION__PART_WITH_PORT, oldPartWithPort, partWithPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWCET() {
		return wcet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWCET(String newWCET) {
		String oldWCET = wcet;
		wcet = newWCET;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RTComponentModelPackage.CH_RT_SPECIFICATION__WCET, oldWCET, wcet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocalWCET() {
		return localWCET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalWCET(String newLocalWCET) {
		String oldLocalWCET = localWCET;
		localWCET = newLocalWCET;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RTComponentModelPackage.CH_RT_SPECIFICATION__LOCAL_WCET, oldLocalWCET, localWCET));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRelativePriority() {
		return relativePriority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelativePriority(String newRelativePriority) {
		String oldRelativePriority = relativePriority;
		relativePriority = newRelativePriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RTComponentModelPackage.CH_RT_SPECIFICATION__RELATIVE_PRIORITY, oldRelativePriority, relativePriority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCeiling() {
		return ceiling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCeiling(String newCeiling) {
		String oldCeiling = ceiling;
		ceiling = newCeiling;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RTComponentModelPackage.CH_RT_SPECIFICATION__CEILING, oldCeiling, ceiling));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMemorySizeFootprint() {
		return memorySizeFootprint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMemorySizeFootprint(String newMemorySizeFootprint) {
		String oldMemorySizeFootprint = memorySizeFootprint;
		memorySizeFootprint = newMemorySizeFootprint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RTComponentModelPackage.CH_RT_SPECIFICATION__MEMORY_SIZE_FOOTPRINT, oldMemorySizeFootprint, memorySizeFootprint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStackSize() {
		return stackSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStackSize(String newStackSize) {
		String oldStackSize = stackSize;
		stackSize = newStackSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RTComponentModelPackage.CH_RT_SPECIFICATION__STACK_SIZE, oldStackSize, stackSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHeapSize() {
		return heapSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeapSize(String newHeapSize) {
		String oldHeapSize = heapSize;
		heapSize = newHeapSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RTComponentModelPackage.CH_RT_SPECIFICATION__HEAP_SIZE, oldHeapSize, heapSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Slot getSlot() {
		if (slot != null && slot.eIsProxy()) {
			InternalEObject oldSlot = (InternalEObject)slot;
			slot = (Slot)eResolveProxy(oldSlot);
			if (slot != oldSlot) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RTComponentModelPackage.CH_RT_SPECIFICATION__SLOT, oldSlot, slot));
			}
		}
		return slot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Slot basicGetSlot() {
		return slot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSlot(Slot newSlot) {
		Slot oldSlot = slot;
		slot = newSlot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RTComponentModelPackage.CH_RT_SPECIFICATION__SLOT, oldSlot, slot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Comment getBase_Comment() {
		if (base_Comment != null && base_Comment.eIsProxy()) {
			InternalEObject oldBase_Comment = (InternalEObject)base_Comment;
			base_Comment = (Comment)eResolveProxy(oldBase_Comment);
			if (base_Comment != oldBase_Comment) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RTComponentModelPackage.CH_RT_SPECIFICATION__BASE_COMMENT, oldBase_Comment, base_Comment));
			}
		}
		return base_Comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Comment basicGetBase_Comment() {
		return base_Comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Comment(Comment newBase_Comment) {
		Comment oldBase_Comment = base_Comment;
		base_Comment = newBase_Comment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RTComponentModelPackage.CH_RT_SPECIFICATION__BASE_COMMENT, oldBase_Comment, base_Comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOccKind() {
		return occKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOccKind(String newOccKind) {
		String oldOccKind = occKind;
		occKind = newOccKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RTComponentModelPackage.CH_RT_SPECIFICATION__OCC_KIND, oldOccKind, occKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallConcurrencyKind getProtection() {
		return protection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProtection(CallConcurrencyKind newProtection) {
		CallConcurrencyKind oldProtection = protection;
		protection = newProtection == null ? PROTECTION_EDEFAULT : newProtection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RTComponentModelPackage.CH_RT_SPECIFICATION__PROTECTION, oldProtection, protection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRlDl() {
		return rlDl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRlDl(String newRlDl) {
		String oldRlDl = rlDl;
		rlDl = newRlDl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RTComponentModelPackage.CH_RT_SPECIFICATION__RL_DL, oldRlDl, rlDl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehavioralFeature getContext() {
		if (context != null && context.eIsProxy()) {
			InternalEObject oldContext = (InternalEObject)context;
			context = (BehavioralFeature)eResolveProxy(oldContext);
			if (context != oldContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RTComponentModelPackage.CH_RT_SPECIFICATION__CONTEXT, oldContext, context));
			}
		}
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehavioralFeature basicGetContext() {
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(BehavioralFeature newContext) {
		BehavioralFeature oldContext = context;
		context = newContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RTComponentModelPackage.CH_RT_SPECIFICATION__CONTEXT, oldContext, context));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getRespT() {
		if (respT == null) {
			respT = new EDataTypeUniqueEList<String>(String.class, this, RTComponentModelPackage.CH_RT_SPECIFICATION__RESP_T);
		}
		return respT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getBlockT() {
		if (blockT == null) {
			blockT = new EDataTypeUniqueEList<String>(String.class, this, RTComponentModelPackage.CH_RT_SPECIFICATION__BLOCK_T);
		}
		return blockT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Operation> getOperationReqForSporadicOcc() {
		if (operationReqForSporadicOcc == null) {
			operationReqForSporadicOcc = new EObjectResolvingEList<Operation>(Operation.class, this, RTComponentModelPackage.CH_RT_SPECIFICATION__OPERATION_REQ_FOR_SPORADIC_OCC);
		}
		return operationReqForSporadicOcc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getOperationReqForSporadicOcc(String name, EList<String> ownedParameterNames, EList<Type> ownedParameterTypes) {
		return getOperationReqForSporadicOcc(name, ownedParameterNames, ownedParameterTypes, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getOperationReqForSporadicOcc(String name, EList<String> ownedParameterNames, EList<Type> ownedParameterTypes, boolean ignoreCase) {
		operationReqForSporadicOccLoop: for (Operation operationReqForSporadicOcc : getOperationReqForSporadicOcc()) {
			if (name != null && !(ignoreCase ? name.equalsIgnoreCase(operationReqForSporadicOcc.getName()) : name.equals(operationReqForSporadicOcc.getName())))
				continue operationReqForSporadicOccLoop;
			EList<Parameter> ownedParameterList = operationReqForSporadicOcc.getOwnedParameters();
			int ownedParameterListSize = ownedParameterList.size();
			if (ownedParameterNames != null && ownedParameterNames.size() != ownedParameterListSize || (ownedParameterTypes != null && ownedParameterTypes.size() != ownedParameterListSize))
				continue  operationReqForSporadicOccLoop;
			for (int j = 0; j < ownedParameterListSize; j++) {
				Parameter ownedParameter = ownedParameterList.get(j);
				if (ownedParameterNames != null && !(ignoreCase ? (ownedParameterNames.get(j)).equalsIgnoreCase(ownedParameter.getName()) : ownedParameterNames.get(j).equals(ownedParameter.getName())))
					continue operationReqForSporadicOccLoop;
				if (ownedParameterTypes != null && !ownedParameterTypes.get(j).equals(ownedParameter.getType()))
					continue operationReqForSporadicOccLoop;
			}
			return operationReqForSporadicOcc;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RTComponentModelPackage.CH_RT_SPECIFICATION__PART_WITH_PORT:
				if (resolve) return getPartWithPort();
				return basicGetPartWithPort();
			case RTComponentModelPackage.CH_RT_SPECIFICATION__WCET:
				return getWCET();
			case RTComponentModelPackage.CH_RT_SPECIFICATION__LOCAL_WCET:
				return getLocalWCET();
			case RTComponentModelPackage.CH_RT_SPECIFICATION__RELATIVE_PRIORITY:
				return getRelativePriority();
			case RTComponentModelPackage.CH_RT_SPECIFICATION__CEILING:
				return getCeiling();
			case RTComponentModelPackage.CH_RT_SPECIFICATION__MEMORY_SIZE_FOOTPRINT:
				return getMemorySizeFootprint();
			case RTComponentModelPackage.CH_RT_SPECIFICATION__STACK_SIZE:
				return getStackSize();
			case RTComponentModelPackage.CH_RT_SPECIFICATION__HEAP_SIZE:
				return getHeapSize();
			case RTComponentModelPackage.CH_RT_SPECIFICATION__SLOT:
				if (resolve) return getSlot();
				return basicGetSlot();
			case RTComponentModelPackage.CH_RT_SPECIFICATION__BASE_COMMENT:
				if (resolve) return getBase_Comment();
				return basicGetBase_Comment();
			case RTComponentModelPackage.CH_RT_SPECIFICATION__OCC_KIND:
				return getOccKind();
			case RTComponentModelPackage.CH_RT_SPECIFICATION__PROTECTION:
				return getProtection();
			case RTComponentModelPackage.CH_RT_SPECIFICATION__RL_DL:
				return getRlDl();
			case RTComponentModelPackage.CH_RT_SPECIFICATION__CONTEXT:
				if (resolve) return getContext();
				return basicGetContext();
			case RTComponentModelPackage.CH_RT_SPECIFICATION__RESP_T:
				return getRespT();
			case RTComponentModelPackage.CH_RT_SPECIFICATION__BLOCK_T:
				return getBlockT();
			case RTComponentModelPackage.CH_RT_SPECIFICATION__OPERATION_REQ_FOR_SPORADIC_OCC:
				return getOperationReqForSporadicOcc();
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
			case RTComponentModelPackage.CH_RT_SPECIFICATION__PART_WITH_PORT:
				setPartWithPort((Property)newValue);
				return;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__WCET:
				setWCET((String)newValue);
				return;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__LOCAL_WCET:
				setLocalWCET((String)newValue);
				return;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__RELATIVE_PRIORITY:
				setRelativePriority((String)newValue);
				return;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__CEILING:
				setCeiling((String)newValue);
				return;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__MEMORY_SIZE_FOOTPRINT:
				setMemorySizeFootprint((String)newValue);
				return;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__STACK_SIZE:
				setStackSize((String)newValue);
				return;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__HEAP_SIZE:
				setHeapSize((String)newValue);
				return;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__SLOT:
				setSlot((Slot)newValue);
				return;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__BASE_COMMENT:
				setBase_Comment((Comment)newValue);
				return;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__OCC_KIND:
				setOccKind((String)newValue);
				return;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__PROTECTION:
				setProtection((CallConcurrencyKind)newValue);
				return;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__RL_DL:
				setRlDl((String)newValue);
				return;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__CONTEXT:
				setContext((BehavioralFeature)newValue);
				return;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__RESP_T:
				getRespT().clear();
				getRespT().addAll((Collection<? extends String>)newValue);
				return;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__BLOCK_T:
				getBlockT().clear();
				getBlockT().addAll((Collection<? extends String>)newValue);
				return;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__OPERATION_REQ_FOR_SPORADIC_OCC:
				getOperationReqForSporadicOcc().clear();
				getOperationReqForSporadicOcc().addAll((Collection<? extends Operation>)newValue);
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
			case RTComponentModelPackage.CH_RT_SPECIFICATION__PART_WITH_PORT:
				setPartWithPort((Property)null);
				return;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__WCET:
				setWCET(WCET_EDEFAULT);
				return;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__LOCAL_WCET:
				setLocalWCET(LOCAL_WCET_EDEFAULT);
				return;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__RELATIVE_PRIORITY:
				setRelativePriority(RELATIVE_PRIORITY_EDEFAULT);
				return;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__CEILING:
				setCeiling(CEILING_EDEFAULT);
				return;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__MEMORY_SIZE_FOOTPRINT:
				setMemorySizeFootprint(MEMORY_SIZE_FOOTPRINT_EDEFAULT);
				return;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__STACK_SIZE:
				setStackSize(STACK_SIZE_EDEFAULT);
				return;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__HEAP_SIZE:
				setHeapSize(HEAP_SIZE_EDEFAULT);
				return;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__SLOT:
				setSlot((Slot)null);
				return;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__BASE_COMMENT:
				setBase_Comment((Comment)null);
				return;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__OCC_KIND:
				setOccKind(OCC_KIND_EDEFAULT);
				return;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__PROTECTION:
				setProtection(PROTECTION_EDEFAULT);
				return;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__RL_DL:
				setRlDl(RL_DL_EDEFAULT);
				return;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__CONTEXT:
				setContext((BehavioralFeature)null);
				return;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__RESP_T:
				getRespT().clear();
				return;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__BLOCK_T:
				getBlockT().clear();
				return;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__OPERATION_REQ_FOR_SPORADIC_OCC:
				getOperationReqForSporadicOcc().clear();
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
			case RTComponentModelPackage.CH_RT_SPECIFICATION__PART_WITH_PORT:
				return partWithPort != null;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__WCET:
				return WCET_EDEFAULT == null ? wcet != null : !WCET_EDEFAULT.equals(wcet);
			case RTComponentModelPackage.CH_RT_SPECIFICATION__LOCAL_WCET:
				return LOCAL_WCET_EDEFAULT == null ? localWCET != null : !LOCAL_WCET_EDEFAULT.equals(localWCET);
			case RTComponentModelPackage.CH_RT_SPECIFICATION__RELATIVE_PRIORITY:
				return RELATIVE_PRIORITY_EDEFAULT == null ? relativePriority != null : !RELATIVE_PRIORITY_EDEFAULT.equals(relativePriority);
			case RTComponentModelPackage.CH_RT_SPECIFICATION__CEILING:
				return CEILING_EDEFAULT == null ? ceiling != null : !CEILING_EDEFAULT.equals(ceiling);
			case RTComponentModelPackage.CH_RT_SPECIFICATION__MEMORY_SIZE_FOOTPRINT:
				return MEMORY_SIZE_FOOTPRINT_EDEFAULT == null ? memorySizeFootprint != null : !MEMORY_SIZE_FOOTPRINT_EDEFAULT.equals(memorySizeFootprint);
			case RTComponentModelPackage.CH_RT_SPECIFICATION__STACK_SIZE:
				return STACK_SIZE_EDEFAULT == null ? stackSize != null : !STACK_SIZE_EDEFAULT.equals(stackSize);
			case RTComponentModelPackage.CH_RT_SPECIFICATION__HEAP_SIZE:
				return HEAP_SIZE_EDEFAULT == null ? heapSize != null : !HEAP_SIZE_EDEFAULT.equals(heapSize);
			case RTComponentModelPackage.CH_RT_SPECIFICATION__SLOT:
				return slot != null;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__BASE_COMMENT:
				return base_Comment != null;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__OCC_KIND:
				return OCC_KIND_EDEFAULT == null ? occKind != null : !OCC_KIND_EDEFAULT.equals(occKind);
			case RTComponentModelPackage.CH_RT_SPECIFICATION__PROTECTION:
				return protection != PROTECTION_EDEFAULT;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__RL_DL:
				return RL_DL_EDEFAULT == null ? rlDl != null : !RL_DL_EDEFAULT.equals(rlDl);
			case RTComponentModelPackage.CH_RT_SPECIFICATION__CONTEXT:
				return context != null;
			case RTComponentModelPackage.CH_RT_SPECIFICATION__RESP_T:
				return respT != null && !respT.isEmpty();
			case RTComponentModelPackage.CH_RT_SPECIFICATION__BLOCK_T:
				return blockT != null && !blockT.isEmpty();
			case RTComponentModelPackage.CH_RT_SPECIFICATION__OPERATION_REQ_FOR_SPORADIC_OCC:
				return operationReqForSporadicOcc != null && !operationReqForSporadicOcc.isEmpty();
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
		result.append(" (WCET: ");
		result.append(wcet);
		result.append(", localWCET: ");
		result.append(localWCET);
		result.append(", relativePriority: ");
		result.append(relativePriority);
		result.append(", ceiling: ");
		result.append(ceiling);
		result.append(", memorySizeFootprint: ");
		result.append(memorySizeFootprint);
		result.append(", stackSize: ");
		result.append(stackSize);
		result.append(", heapSize: ");
		result.append(heapSize);
		result.append(", occKind: ");
		result.append(occKind);
		result.append(", protection: ");
		result.append(protection);
		result.append(", rlDl: ");
		result.append(rlDl);
		result.append(", respT: ");
		result.append(respT);
		result.append(", blockT: ");
		result.append(blockT);
		result.append(')');
		return result.toString();
	}

} //CHRtSpecificationImpl
