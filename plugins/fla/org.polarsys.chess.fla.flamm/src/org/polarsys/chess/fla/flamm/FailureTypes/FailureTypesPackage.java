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
package org.polarsys.chess.fla.flamm.FailureTypes;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.polarsys.chess.fla.flamm.FlammPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.polarsys.chess.fla.flamm.FailureTypes.FailureTypesFactory
 * @model kind="package"
 * @generated
 */
public class FailureTypesPackage extends EPackageImpl {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNAME = "FailureTypes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_URI = "http://www.polarsys.org/chess/fla/flamm/FailureTypes";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_PREFIX = "FailureTypes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final FailureTypesPackage eINSTANCE = org.polarsys.chess.fla.flamm.FailureTypes.FailureTypesPackage.init();

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flamm.FailureTypes.FailureType <em>Failure Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.FailureType
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.FailureTypesPackage#getFailureType()
	 * @generated
	 */
	public static final int FAILURE_TYPE = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flamm.FailureTypes.A_avoidable <em>Aavoidable</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.A_avoidable
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.FailureTypesPackage#getA_avoidable()
	 * @generated
	 */
	public static final int AAVOIDABLE = 1;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flamm.FailureTypes.C_avoidable <em>Cavoidable</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.C_avoidable
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.FailureTypesPackage#getC_avoidable()
	 * @generated
	 */
	public static final int CAVOIDABLE = 2;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flamm.FailureTypes.I_avoidable <em>Iavoidable</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.I_avoidable
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.FailureTypesPackage#getI_avoidable()
	 * @generated
	 */
	public static final int IAVOIDABLE = 3;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flamm.FailureTypes.D_avoidable <em>Davoidable</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.D_avoidable
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.FailureTypesPackage#getD_avoidable()
	 * @generated
	 */
	public static final int DAVOIDABLE = 4;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flamm.FailureTypes.A_mitigation <em>Amitigation</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.A_mitigation
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.FailureTypesPackage#getA_mitigation()
	 * @generated
	 */
	public static final int AMITIGATION = 5;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flamm.FailureTypes.C_mitigation <em>Cmitigation</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.C_mitigation
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.FailureTypesPackage#getC_mitigation()
	 * @generated
	 */
	public static final int CMITIGATION = 6;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flamm.FailureTypes.I_mitigation <em>Imitigation</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.I_mitigation
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.FailureTypesPackage#getI_mitigation()
	 * @generated
	 */
	public static final int IMITIGATION = 7;

	/**
	 * The meta object id for the '{@link org.polarsys.chess.fla.flamm.FailureTypes.D_mitigation <em>Dmitigation</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.D_mitigation
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.FailureTypesPackage#getD_mitigation()
	 * @generated
	 */
	public static final int DMITIGATION = 8;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum failureTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum a_avoidableEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum c_avoidableEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum i_avoidableEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum d_avoidableEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum a_mitigationEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum c_mitigationEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum i_mitigationEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum d_mitigationEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.FailureTypesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FailureTypesPackage() {
		super(eNS_URI, FailureTypesFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link FailureTypesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FailureTypesPackage init() {
		if (isInited) return (FailureTypesPackage)EPackage.Registry.INSTANCE.getEPackage(FailureTypesPackage.eNS_URI);

		// Obtain or create and register package
		FailureTypesPackage theFailureTypesPackage = (FailureTypesPackage)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FailureTypesPackage ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FailureTypesPackage());

		isInited = true;

		// Obtain or create and register interdependencies
		FlammPackage theFlammPackage = (FlammPackage)(EPackage.Registry.INSTANCE.getEPackage(FlammPackage.eNS_URI) instanceof FlammPackage ? EPackage.Registry.INSTANCE.getEPackage(FlammPackage.eNS_URI) : FlammPackage.eINSTANCE);

		// Create package meta-data objects
		theFailureTypesPackage.createPackageContents();
		theFlammPackage.createPackageContents();

		// Initialize created meta-data
		theFailureTypesPackage.initializePackageContents();
		theFlammPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFailureTypesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FailureTypesPackage.eNS_URI, theFailureTypesPackage);
		return theFailureTypesPackage;
	}


	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.fla.flamm.FailureTypes.FailureType <em>Failure Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Failure Type</em>'.
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.FailureType
	 * @generated
	 */
	public EEnum getFailureType() {
		return failureTypeEEnum;
	}

	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.fla.flamm.FailureTypes.A_avoidable <em>Aavoidable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Aavoidable</em>'.
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.A_avoidable
	 * @generated
	 */
	public EEnum getA_avoidable() {
		return a_avoidableEEnum;
	}

	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.fla.flamm.FailureTypes.C_avoidable <em>Cavoidable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Cavoidable</em>'.
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.C_avoidable
	 * @generated
	 */
	public EEnum getC_avoidable() {
		return c_avoidableEEnum;
	}

	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.fla.flamm.FailureTypes.I_avoidable <em>Iavoidable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Iavoidable</em>'.
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.I_avoidable
	 * @generated
	 */
	public EEnum getI_avoidable() {
		return i_avoidableEEnum;
	}

	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.fla.flamm.FailureTypes.D_avoidable <em>Davoidable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Davoidable</em>'.
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.D_avoidable
	 * @generated
	 */
	public EEnum getD_avoidable() {
		return d_avoidableEEnum;
	}

	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.fla.flamm.FailureTypes.A_mitigation <em>Amitigation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Amitigation</em>'.
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.A_mitigation
	 * @generated
	 */
	public EEnum getA_mitigation() {
		return a_mitigationEEnum;
	}

	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.fla.flamm.FailureTypes.C_mitigation <em>Cmitigation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Cmitigation</em>'.
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.C_mitigation
	 * @generated
	 */
	public EEnum getC_mitigation() {
		return c_mitigationEEnum;
	}

	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.fla.flamm.FailureTypes.I_mitigation <em>Imitigation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Imitigation</em>'.
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.I_mitigation
	 * @generated
	 */
	public EEnum getI_mitigation() {
		return i_mitigationEEnum;
	}

	/**
	 * Returns the meta object for enum '{@link org.polarsys.chess.fla.flamm.FailureTypes.D_mitigation <em>Dmitigation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Dmitigation</em>'.
	 * @see org.polarsys.chess.fla.flamm.FailureTypes.D_mitigation
	 * @generated
	 */
	public EEnum getD_mitigation() {
		return d_mitigationEEnum;
	}

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	public FailureTypesFactory getFailureTypesFactory() {
		return (FailureTypesFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create enums
		failureTypeEEnum = createEEnum(FAILURE_TYPE);
		a_avoidableEEnum = createEEnum(AAVOIDABLE);
		c_avoidableEEnum = createEEnum(CAVOIDABLE);
		i_avoidableEEnum = createEEnum(IAVOIDABLE);
		d_avoidableEEnum = createEEnum(DAVOIDABLE);
		a_mitigationEEnum = createEEnum(AMITIGATION);
		c_mitigationEEnum = createEEnum(CMITIGATION);
		i_mitigationEEnum = createEEnum(IMITIGATION);
		d_mitigationEEnum = createEEnum(DMITIGATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Initialize enums and add enum literals
		initEEnum(failureTypeEEnum, FailureType.class, "FailureType");
		addEEnumLiteral(failureTypeEEnum, FailureType.NO_FAILURE);
		addEEnumLiteral(failureTypeEEnum, FailureType.FAILURE);
		addEEnumLiteral(failureTypeEEnum, FailureType.VARIABLE);
		addEEnumLiteral(failureTypeEEnum, FailureType.WILDCARD);

		initEEnum(a_avoidableEEnum, A_avoidable.class, "A_avoidable");
		addEEnumLiteral(a_avoidableEEnum, A_avoidable.UNSPECIFIED);
		addEEnumLiteral(a_avoidableEEnum, A_avoidable.INCOMPLETION);
		addEEnumLiteral(a_avoidableEEnum, A_avoidable.NONE);

		initEEnum(c_avoidableEEnum, C_avoidable.class, "C_avoidable");
		addEEnumLiteral(c_avoidableEEnum, C_avoidable.UNSPECIFIED);
		addEEnumLiteral(c_avoidableEEnum, C_avoidable.INCONSISTENCY);
		addEEnumLiteral(c_avoidableEEnum, C_avoidable.NONE);

		initEEnum(i_avoidableEEnum, I_avoidable.class, "I_avoidable");
		addEEnumLiteral(i_avoidableEEnum, I_avoidable.UNSPECIFIED);
		addEEnumLiteral(i_avoidableEEnum, I_avoidable.INTERFERENCE);
		addEEnumLiteral(i_avoidableEEnum, I_avoidable.NONE);

		initEEnum(d_avoidableEEnum, D_avoidable.class, "D_avoidable");
		addEEnumLiteral(d_avoidableEEnum, D_avoidable.UNSPECIFIED);
		addEEnumLiteral(d_avoidableEEnum, D_avoidable.IMPERMANENCE);
		addEEnumLiteral(d_avoidableEEnum, D_avoidable.NONE);

		initEEnum(a_mitigationEEnum, A_mitigation.class, "A_mitigation");
		addEEnumLiteral(a_mitigationEEnum, A_mitigation.UNSPECIFIED);
		addEEnumLiteral(a_mitigationEEnum, A_mitigation.ALL_OR_NOTHING);
		addEEnumLiteral(a_mitigationEEnum, A_mitigation.ALL_OR_COMPENSATION);
		addEEnumLiteral(a_mitigationEEnum, A_mitigation.NONE);

		initEEnum(c_mitigationEEnum, C_mitigation.class, "C_mitigation");
		addEEnumLiteral(c_mitigationEEnum, C_mitigation.UNSPECIFIED);
		addEEnumLiteral(c_mitigationEEnum, C_mitigation.FULL_CONSISTENCY);
		addEEnumLiteral(c_mitigationEEnum, C_mitigation.RANGE_VIOLATION_ALLOWED);
		addEEnumLiteral(c_mitigationEEnum, C_mitigation.NONE);

		initEEnum(i_mitigationEEnum, I_mitigation.class, "I_mitigation");
		addEEnumLiteral(i_mitigationEEnum, I_mitigation.UNSPECIFIED);
		addEEnumLiteral(i_mitigationEEnum, I_mitigation.PORTABLE_LEVEL);
		addEEnumLiteral(i_mitigationEEnum, I_mitigation.SERIALIZABLE);
		addEEnumLiteral(i_mitigationEEnum, I_mitigation.NONE);

		initEEnum(d_mitigationEEnum, D_mitigation.class, "D_mitigation");
		addEEnumLiteral(d_mitigationEEnum, D_mitigation.UNSPECIFIED);
		addEEnumLiteral(d_mitigationEEnum, D_mitigation.NO_LOSS);
		addEEnumLiteral(d_mitigationEEnum, D_mitigation.PARTIAL_LOSS_ALLOWED);
		addEEnumLiteral(d_mitigationEEnum, D_mitigation.NONE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public interface Literals {
		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flamm.FailureTypes.FailureType <em>Failure Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flamm.FailureTypes.FailureType
		 * @see org.polarsys.chess.fla.flamm.FailureTypes.FailureTypesPackage#getFailureType()
		 * @generated
		 */
		public static final EEnum FAILURE_TYPE = eINSTANCE.getFailureType();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flamm.FailureTypes.A_avoidable <em>Aavoidable</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flamm.FailureTypes.A_avoidable
		 * @see org.polarsys.chess.fla.flamm.FailureTypes.FailureTypesPackage#getA_avoidable()
		 * @generated
		 */
		public static final EEnum AAVOIDABLE = eINSTANCE.getA_avoidable();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flamm.FailureTypes.C_avoidable <em>Cavoidable</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flamm.FailureTypes.C_avoidable
		 * @see org.polarsys.chess.fla.flamm.FailureTypes.FailureTypesPackage#getC_avoidable()
		 * @generated
		 */
		public static final EEnum CAVOIDABLE = eINSTANCE.getC_avoidable();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flamm.FailureTypes.I_avoidable <em>Iavoidable</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flamm.FailureTypes.I_avoidable
		 * @see org.polarsys.chess.fla.flamm.FailureTypes.FailureTypesPackage#getI_avoidable()
		 * @generated
		 */
		public static final EEnum IAVOIDABLE = eINSTANCE.getI_avoidable();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flamm.FailureTypes.D_avoidable <em>Davoidable</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flamm.FailureTypes.D_avoidable
		 * @see org.polarsys.chess.fla.flamm.FailureTypes.FailureTypesPackage#getD_avoidable()
		 * @generated
		 */
		public static final EEnum DAVOIDABLE = eINSTANCE.getD_avoidable();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flamm.FailureTypes.A_mitigation <em>Amitigation</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flamm.FailureTypes.A_mitigation
		 * @see org.polarsys.chess.fla.flamm.FailureTypes.FailureTypesPackage#getA_mitigation()
		 * @generated
		 */
		public static final EEnum AMITIGATION = eINSTANCE.getA_mitigation();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flamm.FailureTypes.C_mitigation <em>Cmitigation</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flamm.FailureTypes.C_mitigation
		 * @see org.polarsys.chess.fla.flamm.FailureTypes.FailureTypesPackage#getC_mitigation()
		 * @generated
		 */
		public static final EEnum CMITIGATION = eINSTANCE.getC_mitigation();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flamm.FailureTypes.I_mitigation <em>Imitigation</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flamm.FailureTypes.I_mitigation
		 * @see org.polarsys.chess.fla.flamm.FailureTypes.FailureTypesPackage#getI_mitigation()
		 * @generated
		 */
		public static final EEnum IMITIGATION = eINSTANCE.getI_mitigation();

		/**
		 * The meta object literal for the '{@link org.polarsys.chess.fla.flamm.FailureTypes.D_mitigation <em>Dmitigation</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.chess.fla.flamm.FailureTypes.D_mitigation
		 * @see org.polarsys.chess.fla.flamm.FailureTypes.FailureTypesPackage#getD_mitigation()
		 * @generated
		 */
		public static final EEnum DMITIGATION = eINSTANCE.getD_mitigation();

	}

} //FailureTypesPackage
