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
package org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.MitigationMeansFactory
 * @model kind="package"
 * @generated
 */
public interface MitigationMeansPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "MitigationMeans";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://CHESS.Dependability/MitigationMeans";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "MitigationMeans";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MitigationMeansPackage eINSTANCE = org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.impl.MitigationMeansPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.impl.TransmissionWithProtocolImpl <em>Transmission With Protocol</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.impl.TransmissionWithProtocolImpl
	 * @see org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.impl.MitigationMeansPackageImpl#getTransmissionWithProtocol()
	 * @generated
	 */
	int TRANSMISSION_WITH_PROTOCOL = 0;

	/**
	 * The feature id for the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSMISSION_WITH_PROTOCOL__BASE_CONNECTOR = 0;

	/**
	 * The feature id for the '<em><b>CRC</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSMISSION_WITH_PROTOCOL__CRC = 1;

	/**
	 * The feature id for the '<em><b>Use Seq ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSMISSION_WITH_PROTOCOL__USE_SEQ_ID = 2;

	/**
	 * The number of structural features of the '<em>Transmission With Protocol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSMISSION_WITH_PROTOCOL_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.TransmissionWithProtocol <em>Transmission With Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transmission With Protocol</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.TransmissionWithProtocol
	 * @generated
	 */
	EClass getTransmissionWithProtocol();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.TransmissionWithProtocol#getBase_Connector <em>Base Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Connector</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.TransmissionWithProtocol#getBase_Connector()
	 * @see #getTransmissionWithProtocol()
	 * @generated
	 */
	EReference getTransmissionWithProtocol_Base_Connector();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.TransmissionWithProtocol#getCRC <em>CRC</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CRC</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.TransmissionWithProtocol#getCRC()
	 * @see #getTransmissionWithProtocol()
	 * @generated
	 */
	EAttribute getTransmissionWithProtocol_CRC();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.TransmissionWithProtocol#isUseSeqID <em>Use Seq ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Seq ID</em>'.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.TransmissionWithProtocol#isUseSeqID()
	 * @see #getTransmissionWithProtocol()
	 * @generated
	 */
	EAttribute getTransmissionWithProtocol_UseSeqID();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MitigationMeansFactory getMitigationMeansFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.impl.TransmissionWithProtocolImpl <em>Transmission With Protocol</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.impl.TransmissionWithProtocolImpl
		 * @see org.polarsys.chess.chessmlprofile.Dependability.MitigationMeans.impl.MitigationMeansPackageImpl#getTransmissionWithProtocol()
		 * @generated
		 */
		EClass TRANSMISSION_WITH_PROTOCOL = eINSTANCE.getTransmissionWithProtocol();

		/**
		 * The meta object literal for the '<em><b>Base Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSMISSION_WITH_PROTOCOL__BASE_CONNECTOR = eINSTANCE.getTransmissionWithProtocol_Base_Connector();

		/**
		 * The meta object literal for the '<em><b>CRC</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSMISSION_WITH_PROTOCOL__CRC = eINSTANCE.getTransmissionWithProtocol_CRC();

		/**
		 * The meta object literal for the '<em><b>Use Seq ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSMISSION_WITH_PROTOCOL__USE_SEQ_ID = eINSTANCE.getTransmissionWithProtocol_UseSeqID();

	}

} //MitigationMeansPackage
