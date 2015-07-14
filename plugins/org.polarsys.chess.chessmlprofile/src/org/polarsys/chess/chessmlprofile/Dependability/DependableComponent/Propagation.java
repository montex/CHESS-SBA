/*****************************************************************************
 * Copyright (c) 2011, 2015 University of Padova, Intecs
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *
 *****************************************************************************/
package org.polarsys.chess.chessmlprofile.Dependability.DependableComponent;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Transition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Propagation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * To be deleted???
 * ExternalFault and InternalFault has been renamed (CH as prefix) to avoid conflict with the anonymous concepts introduced in the new dependability profile
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getProb <em>Prob</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getPropDelay <em>Prop Delay</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getBase_Abstraction <em>Base Abstraction</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getBase_Comment <em>Base Comment</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getBase_Connector <em>Base Connector</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getBase_InstanceSpecification <em>Base Instance Specification</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getTransfFunct <em>Transf Funct</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getBase_Transition <em>Base Transition</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getWeight <em>Weight</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage#getPropagation()
 * @model
 * @generated
 */
public interface Propagation extends EObject {
	/**
	 * Returns the value of the '<em><b>Prob</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prob</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prob</em>' attribute.
	 * @see #setProb(String)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage#getPropagation_Prob()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Real" required="true" ordered="false"
	 * @generated
	 */
	String getProb();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getProb <em>Prob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prob</em>' attribute.
	 * @see #getProb()
	 * @generated
	 */
	void setProb(String value);

	/**
	 * Returns the value of the '<em><b>Prop Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prop Delay</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prop Delay</em>' attribute.
	 * @see #setPropDelay(String)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage#getPropagation_PropDelay()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Duration" required="true" ordered="false"
	 * @generated
	 */
	String getPropDelay();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getPropDelay <em>Prop Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prop Delay</em>' attribute.
	 * @see #getPropDelay()
	 * @generated
	 */
	void setPropDelay(String value);

	/**
	 * Returns the value of the '<em><b>Base Abstraction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Abstraction</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Abstraction</em>' reference.
	 * @see #setBase_Abstraction(Abstraction)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage#getPropagation_Base_Abstraction()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Abstraction getBase_Abstraction();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getBase_Abstraction <em>Base Abstraction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Abstraction</em>' reference.
	 * @see #getBase_Abstraction()
	 * @generated
	 */
	void setBase_Abstraction(Abstraction value);

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
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage#getPropagation_Base_Comment()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Comment getBase_Comment();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getBase_Comment <em>Base Comment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Comment</em>' reference.
	 * @see #getBase_Comment()
	 * @generated
	 */
	void setBase_Comment(Comment value);

	/**
	 * Returns the value of the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Connector</em>' reference.
	 * @see #setBase_Connector(Connector)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage#getPropagation_Base_Connector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Connector getBase_Connector();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getBase_Connector <em>Base Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Connector</em>' reference.
	 * @see #getBase_Connector()
	 * @generated
	 */
	void setBase_Connector(Connector value);

	/**
	 * Returns the value of the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Instance Specification</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Instance Specification</em>' reference.
	 * @see #setBase_InstanceSpecification(InstanceSpecification)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage#getPropagation_Base_InstanceSpecification()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	InstanceSpecification getBase_InstanceSpecification();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getBase_InstanceSpecification <em>Base Instance Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Instance Specification</em>' reference.
	 * @see #getBase_InstanceSpecification()
	 * @generated
	 */
	void setBase_InstanceSpecification(InstanceSpecification value);

	/**
	 * Returns the value of the '<em><b>Transf Funct</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transf Funct</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transf Funct</em>' attribute list.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage#getPropagation_TransfFunct()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	EList<String> getTransfFunct();

	/**
	 * Returns the value of the '<em><b>Base Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Transition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Transition</em>' reference.
	 * @see #setBase_Transition(Transition)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage#getPropagation_Base_Transition()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Transition getBase_Transition();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getBase_Transition <em>Base Transition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Transition</em>' reference.
	 * @see #getBase_Transition()
	 * @generated
	 */
	void setBase_Transition(Transition value);

	/**
	 * Returns the value of the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weight</em>' attribute.
	 * @see #setWeight(String)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage#getPropagation_Weight()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Real" ordered="false"
	 * @generated
	 */
	String getWeight();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.Propagation#getWeight <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weight</em>' attribute.
	 * @see #getWeight()
	 * @generated
	 */
	void setWeight(String value);

} // Propagation
