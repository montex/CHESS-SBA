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
package org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.CallConcurrencyKind;

import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CH Rt Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getPartWithPort <em>Part With Port</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getWCET <em>WCET</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getLocalWCET <em>Local WCET</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getRelativePriority <em>Relative Priority</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getCeiling <em>Ceiling</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getMemorySizeFootprint <em>Memory Size Footprint</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getStackSize <em>Stack Size</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getHeapSize <em>Heap Size</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getSlot <em>Slot</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getBase_Comment <em>Base Comment</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getOccKind <em>Occ Kind</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getProtection <em>Protection</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getRlDl <em>Rl Dl</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getContext <em>Context</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getRespT <em>Resp T</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getBlockT <em>Block T</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTComponentModelPackage#getCHRtSpecification()
 * @model
 * @generated
 */
public interface CHRtSpecification extends EObject {
	/**
	 * Returns the value of the '<em><b>Part With Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part With Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part With Port</em>' reference.
	 * @see #setPartWithPort(Property)
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTComponentModelPackage#getCHRtSpecification_PartWithPort()
	 * @model ordered="false"
	 * @generated
	 */
	Property getPartWithPort();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getPartWithPort <em>Part With Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Part With Port</em>' reference.
	 * @see #getPartWithPort()
	 * @generated
	 */
	void setPartWithPort(Property value);

	/**
	 * Returns the value of the '<em><b>WCET</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>WCET</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>WCET</em>' attribute.
	 * @see #setWCET(String)
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTComponentModelPackage#getCHRtSpecification_WCET()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Duration" required="true" ordered="false"
	 * @generated
	 */
	String getWCET();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getWCET <em>WCET</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>WCET</em>' attribute.
	 * @see #getWCET()
	 * @generated
	 */
	void setWCET(String value);

	/**
	 * Returns the value of the '<em><b>Local WCET</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local WCET</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local WCET</em>' attribute.
	 * @see #setLocalWCET(String)
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTComponentModelPackage#getCHRtSpecification_LocalWCET()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Duration" ordered="false"
	 * @generated
	 */
	String getLocalWCET();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getLocalWCET <em>Local WCET</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local WCET</em>' attribute.
	 * @see #getLocalWCET()
	 * @generated
	 */
	void setLocalWCET(String value);

	/**
	 * Returns the value of the '<em><b>Relative Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relative Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relative Priority</em>' attribute.
	 * @see #setRelativePriority(String)
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTComponentModelPackage#getCHRtSpecification_RelativePriority()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Integer" ordered="false"
	 * @generated
	 */
	String getRelativePriority();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getRelativePriority <em>Relative Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relative Priority</em>' attribute.
	 * @see #getRelativePriority()
	 * @generated
	 */
	void setRelativePriority(String value);

	/**
	 * Returns the value of the '<em><b>Ceiling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ceiling</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ceiling</em>' attribute.
	 * @see #setCeiling(String)
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTComponentModelPackage#getCHRtSpecification_Ceiling()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Integer" ordered="false"
	 * @generated
	 */
	String getCeiling();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getCeiling <em>Ceiling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ceiling</em>' attribute.
	 * @see #getCeiling()
	 * @generated
	 */
	void setCeiling(String value);

	/**
	 * Returns the value of the '<em><b>Memory Size Footprint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Memory Size Footprint</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Memory Size Footprint</em>' attribute.
	 * @see #setMemorySizeFootprint(String)
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTComponentModelPackage#getCHRtSpecification_MemorySizeFootprint()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_DataSize" ordered="false"
	 * @generated
	 */
	String getMemorySizeFootprint();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getMemorySizeFootprint <em>Memory Size Footprint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Memory Size Footprint</em>' attribute.
	 * @see #getMemorySizeFootprint()
	 * @generated
	 */
	void setMemorySizeFootprint(String value);

	/**
	 * Returns the value of the '<em><b>Stack Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stack Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stack Size</em>' attribute.
	 * @see #setStackSize(String)
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTComponentModelPackage#getCHRtSpecification_StackSize()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_DataSize" ordered="false"
	 * @generated
	 */
	String getStackSize();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getStackSize <em>Stack Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stack Size</em>' attribute.
	 * @see #getStackSize()
	 * @generated
	 */
	void setStackSize(String value);

	/**
	 * Returns the value of the '<em><b>Heap Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Heap Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Heap Size</em>' attribute.
	 * @see #setHeapSize(String)
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTComponentModelPackage#getCHRtSpecification_HeapSize()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_DataSize" ordered="false"
	 * @generated
	 */
	String getHeapSize();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getHeapSize <em>Heap Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Heap Size</em>' attribute.
	 * @see #getHeapSize()
	 * @generated
	 */
	void setHeapSize(String value);

	/**
	 * Returns the value of the '<em><b>Slot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slot</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slot</em>' reference.
	 * @see #setSlot(Slot)
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTComponentModelPackage#getCHRtSpecification_Slot()
	 * @model ordered="false"
	 * @generated
	 */
	Slot getSlot();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getSlot <em>Slot</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slot</em>' reference.
	 * @see #getSlot()
	 * @generated
	 */
	void setSlot(Slot value);

	/**
	 * Returns the value of the '<em><b>Base Comment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Comment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Comment</em>' reference.
	 * @see #setBase_Comment(Comment)
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTComponentModelPackage#getCHRtSpecification_Base_Comment()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Comment getBase_Comment();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getBase_Comment <em>Base Comment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Comment</em>' reference.
	 * @see #getBase_Comment()
	 * @generated
	 */
	void setBase_Comment(Comment value);

	/**
	 * Returns the value of the '<em><b>Occ Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Occ Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Occ Kind</em>' attribute.
	 * @see #setOccKind(String)
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTComponentModelPackage#getCHRtSpecification_OccKind()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.ArrivalPattern" ordered="false"
	 * @generated
	 */
	String getOccKind();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getOccKind <em>Occ Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Occ Kind</em>' attribute.
	 * @see #getOccKind()
	 * @generated
	 */
	void setOccKind(String value);

	/**
	 * Returns the value of the '<em><b>Protection</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.CallConcurrencyKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Protection</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protection</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.CallConcurrencyKind
	 * @see #setProtection(CallConcurrencyKind)
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTComponentModelPackage#getCHRtSpecification_Protection()
	 * @model ordered="false"
	 * @generated
	 */
	CallConcurrencyKind getProtection();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getProtection <em>Protection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Protection</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.CallConcurrencyKind
	 * @see #getProtection()
	 * @generated
	 */
	void setProtection(CallConcurrencyKind value);

	/**
	 * Returns the value of the '<em><b>Rl Dl</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rl Dl</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rl Dl</em>' attribute.
	 * @see #setRlDl(String)
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTComponentModelPackage#getCHRtSpecification_RlDl()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Duration" ordered="false"
	 * @generated
	 */
	String getRlDl();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getRlDl <em>Rl Dl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rl Dl</em>' attribute.
	 * @see #getRlDl()
	 * @generated
	 */
	void setRlDl(String value);

	/**
	 * Returns the value of the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' reference.
	 * @see #setContext(BehavioralFeature)
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTComponentModelPackage#getCHRtSpecification_Context()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	BehavioralFeature getContext();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification#getContext <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(BehavioralFeature value);

	/**
	 * Returns the value of the '<em><b>Resp T</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resp T</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resp T</em>' attribute list.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTComponentModelPackage#getCHRtSpecification_RespT()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Duration" ordered="false"
	 * @generated
	 */
	EList<String> getRespT();

	/**
	 * Returns the value of the '<em><b>Block T</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Block T</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Block T</em>' attribute list.
	 * @see org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.RTComponentModelPackage#getCHRtSpecification_BlockT()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Duration" ordered="false"
	 * @generated
	 */
	EList<String> getBlockT();

} // CHRtSpecification
