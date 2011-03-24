/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see DependabilityintermediateModel.DependabilityintermediateModelFactory
 * @model kind="package"
 * @generated
 */
public interface DependabilityintermediateModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "DependabilityintermediateModel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://if.dsi.unifi.it/Modeling/DIM";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DependabilityintermediateModelPackage eINSTANCE = DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.NamedElementImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.SistemaImpl <em>Sistema</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.SistemaImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getSistema()
	 * @generated
	 */
	int SISTEMA = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SISTEMA__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SISTEMA__COMPONENTS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Activities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SISTEMA__ACTIVITIES = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sistema</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SISTEMA_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.ComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.ComponentImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getComponent()
	 * @generated
	 */
	int COMPONENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Intermediate Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__INTERMEDIATE_MODEL = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Failure Modes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__FAILURE_MODES = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Errors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__ERRORS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Faults</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__FAULTS = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Faults Generates Errors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__FAULTS_GENERATES_ERRORS = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Internal Propagation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__INTERNAL_PROPAGATION = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Errors Generates Failures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__ERRORS_GENERATES_FAILURES = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.ThreatImpl <em>Threat</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.ThreatImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getThreat()
	 * @generated
	 */
	int THREAT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Threat</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.FaultImpl <em>Fault</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.FaultImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getFault()
	 * @generated
	 */
	int FAULT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT__NAME = THREAT__NAME;

	/**
	 * The feature id for the '<em><b>Component</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT__COMPONENT = THREAT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Fault</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_FEATURE_COUNT = THREAT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.InternalFaultImpl <em>Internal Fault</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.InternalFaultImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getInternalFault()
	 * @generated
	 */
	int INTERNAL_FAULT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FAULT__NAME = FAULT__NAME;

	/**
	 * The feature id for the '<em><b>Component</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FAULT__COMPONENT = FAULT__COMPONENT;

	/**
	 * The feature id for the '<em><b>Occurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FAULT__OCCURRENCE = FAULT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Permanent Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FAULT__PERMANENT_PROBABILITY = FAULT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Transient Duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FAULT__TRANSIENT_DURATION = FAULT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Internal Fault</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_FAULT_FEATURE_COUNT = FAULT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.ExternalFaultImpl <em>External Fault</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.ExternalFaultImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getExternalFault()
	 * @generated
	 */
	int EXTERNAL_FAULT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_FAULT__NAME = FAULT__NAME;

	/**
	 * The feature id for the '<em><b>Component</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_FAULT__COMPONENT = FAULT__COMPONENT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_FAULT__SOURCE = FAULT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>External Fault</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_FAULT_FEATURE_COUNT = FAULT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.ErrorImpl <em>Error</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.ErrorImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getError()
	 * @generated
	 */
	int ERROR = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR__NAME = THREAT__NAME;

	/**
	 * The feature id for the '<em><b>Vanishing Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR__VANISHING_TIME = THREAT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Component</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR__COMPONENT = THREAT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Error</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_FEATURE_COUNT = THREAT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.DistributionImpl <em>Distribution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.DistributionImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getDistribution()
	 * @generated
	 */
	int DISTRIBUTION = 8;

	/**
	 * The feature id for the '<em><b>Sistema</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION__SISTEMA = 0;

	/**
	 * The number of structural features of the '<em>Distribution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.ExponentialImpl <em>Exponential</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.ExponentialImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getExponential()
	 * @generated
	 */
	int EXPONENTIAL = 9;

	/**
	 * The feature id for the '<em><b>Sistema</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPONENTIAL__SISTEMA = DISTRIBUTION__SISTEMA;

	/**
	 * The feature id for the '<em><b>Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPONENTIAL__RATE = DISTRIBUTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Exponential</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPONENTIAL_FEATURE_COUNT = DISTRIBUTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.GaussianImpl <em>Gaussian</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.GaussianImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getGaussian()
	 * @generated
	 */
	int GAUSSIAN = 10;

	/**
	 * The feature id for the '<em><b>Sistema</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN__SISTEMA = DISTRIBUTION__SISTEMA;

	/**
	 * The feature id for the '<em><b>Mean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN__MEAN = DISTRIBUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN__VARIANCE = DISTRIBUTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Gaussian</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FEATURE_COUNT = DISTRIBUTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.DeterministicImpl <em>Deterministic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.DeterministicImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getDeterministic()
	 * @generated
	 */
	int DETERMINISTIC = 11;

	/**
	 * The feature id for the '<em><b>Sistema</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC__SISTEMA = DISTRIBUTION__SISTEMA;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC__VALUE = DISTRIBUTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Deterministic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_FEATURE_COUNT = DISTRIBUTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.UniformImpl <em>Uniform</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.UniformImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getUniform()
	 * @generated
	 */
	int UNIFORM = 12;

	/**
	 * The feature id for the '<em><b>Sistema</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFORM__SISTEMA = DISTRIBUTION__SISTEMA;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFORM__LOWER = DISTRIBUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFORM__UPPER = DISTRIBUTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Uniform</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFORM_FEATURE_COUNT = DISTRIBUTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.GammaImpl <em>Gamma</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.GammaImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getGamma()
	 * @generated
	 */
	int GAMMA = 13;

	/**
	 * The feature id for the '<em><b>Sistema</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAMMA__SISTEMA = DISTRIBUTION__SISTEMA;

	/**
	 * The feature id for the '<em><b>Alpha</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAMMA__ALPHA = DISTRIBUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Beta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAMMA__BETA = DISTRIBUTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Gamma</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAMMA_FEATURE_COUNT = DISTRIBUTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.WeibullImpl <em>Weibull</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.WeibullImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getWeibull()
	 * @generated
	 */
	int WEIBULL = 14;

	/**
	 * The feature id for the '<em><b>Sistema</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEIBULL__SISTEMA = DISTRIBUTION__SISTEMA;

	/**
	 * The feature id for the '<em><b>Alpha</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEIBULL__ALPHA = DISTRIBUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Beta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEIBULL__BETA = DISTRIBUTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Weibull</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEIBULL_FEATURE_COUNT = DISTRIBUTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.FailureModeImpl <em>Failure Mode</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.FailureModeImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getFailureMode()
	 * @generated
	 */
	int FAILURE_MODE = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_MODE__NAME = THREAT__NAME;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_MODE__DOMAIN = THREAT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Detectability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_MODE__DETECTABILITY = THREAT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Consistency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_MODE__CONSISTENCY = THREAT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Consequences</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_MODE__CONSEQUENCES = THREAT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Component</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_MODE__COMPONENT = THREAT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Failure Mode</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_MODE_FEATURE_COUNT = THREAT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.FaultsExpressionNodeImpl <em>Faults Expression Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.FaultsExpressionNodeImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getFaultsExpressionNode()
	 * @generated
	 */
	int FAULTS_EXPRESSION_NODE = 16;

	/**
	 * The feature id for the '<em><b>Faults Generate Errors</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULTS_EXPRESSION_NODE__FAULTS_GENERATE_ERRORS = 0;

	/**
	 * The number of structural features of the '<em>Faults Expression Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULTS_EXPRESSION_NODE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.FaultsExpressionAndNodeImpl <em>Faults Expression And Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.FaultsExpressionAndNodeImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getFaultsExpressionAndNode()
	 * @generated
	 */
	int FAULTS_EXPRESSION_AND_NODE = 17;

	/**
	 * The feature id for the '<em><b>Faults Generate Errors</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULTS_EXPRESSION_AND_NODE__FAULTS_GENERATE_ERRORS = FAULTS_EXPRESSION_NODE__FAULTS_GENERATE_ERRORS;

	/**
	 * The feature id for the '<em><b>Faults Expression1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULTS_EXPRESSION_AND_NODE__FAULTS_EXPRESSION1 = FAULTS_EXPRESSION_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Faults Expression2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULTS_EXPRESSION_AND_NODE__FAULTS_EXPRESSION2 = FAULTS_EXPRESSION_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Faults Expression And Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULTS_EXPRESSION_AND_NODE_FEATURE_COUNT = FAULTS_EXPRESSION_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.FaultsExpressionOrNodeImpl <em>Faults Expression Or Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.FaultsExpressionOrNodeImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getFaultsExpressionOrNode()
	 * @generated
	 */
	int FAULTS_EXPRESSION_OR_NODE = 18;

	/**
	 * The feature id for the '<em><b>Faults Generate Errors</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULTS_EXPRESSION_OR_NODE__FAULTS_GENERATE_ERRORS = FAULTS_EXPRESSION_NODE__FAULTS_GENERATE_ERRORS;

	/**
	 * The feature id for the '<em><b>Faults Expression1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULTS_EXPRESSION_OR_NODE__FAULTS_EXPRESSION1 = FAULTS_EXPRESSION_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Faults Expression2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULTS_EXPRESSION_OR_NODE__FAULTS_EXPRESSION2 = FAULTS_EXPRESSION_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Faults Expression Or Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULTS_EXPRESSION_OR_NODE_FEATURE_COUNT = FAULTS_EXPRESSION_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.FaultsExpressionFaultNodeImpl <em>Faults Expression Fault Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.FaultsExpressionFaultNodeImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getFaultsExpressionFaultNode()
	 * @generated
	 */
	int FAULTS_EXPRESSION_FAULT_NODE = 19;

	/**
	 * The feature id for the '<em><b>Faults Generate Errors</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULTS_EXPRESSION_FAULT_NODE__FAULTS_GENERATE_ERRORS = FAULTS_EXPRESSION_NODE__FAULTS_GENERATE_ERRORS;

	/**
	 * The feature id for the '<em><b>Fault</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULTS_EXPRESSION_FAULT_NODE__FAULT = FAULTS_EXPRESSION_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Faults Expression Fault Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULTS_EXPRESSION_FAULT_NODE_FEATURE_COUNT = FAULTS_EXPRESSION_NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.FaultsExpressionNotNodeImpl <em>Faults Expression Not Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.FaultsExpressionNotNodeImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getFaultsExpressionNotNode()
	 * @generated
	 */
	int FAULTS_EXPRESSION_NOT_NODE = 20;

	/**
	 * The feature id for the '<em><b>Faults Generate Errors</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULTS_EXPRESSION_NOT_NODE__FAULTS_GENERATE_ERRORS = FAULTS_EXPRESSION_NODE__FAULTS_GENERATE_ERRORS;

	/**
	 * The feature id for the '<em><b>Faults Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULTS_EXPRESSION_NOT_NODE__FAULTS_EXPRESSION = FAULTS_EXPRESSION_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Faults Expression Not Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULTS_EXPRESSION_NOT_NODE_FEATURE_COUNT = FAULTS_EXPRESSION_NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.ErrorsExpressionNodeImpl <em>Errors Expression Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.ErrorsExpressionNodeImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getErrorsExpressionNode()
	 * @generated
	 */
	int ERRORS_EXPRESSION_NODE = 21;

	/**
	 * The feature id for the '<em><b>Error Propagation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERRORS_EXPRESSION_NODE__ERROR_PROPAGATION = 0;

	/**
	 * The number of structural features of the '<em>Errors Expression Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERRORS_EXPRESSION_NODE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.ErrorsExpressionErrorNodeImpl <em>Errors Expression Error Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.ErrorsExpressionErrorNodeImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getErrorsExpressionErrorNode()
	 * @generated
	 */
	int ERRORS_EXPRESSION_ERROR_NODE = 22;

	/**
	 * The feature id for the '<em><b>Error Propagation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERRORS_EXPRESSION_ERROR_NODE__ERROR_PROPAGATION = ERRORS_EXPRESSION_NODE__ERROR_PROPAGATION;

	/**
	 * The feature id for the '<em><b>Error</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERRORS_EXPRESSION_ERROR_NODE__ERROR = ERRORS_EXPRESSION_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Errors Expression Error Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERRORS_EXPRESSION_ERROR_NODE_FEATURE_COUNT = ERRORS_EXPRESSION_NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.ErrorsExpressionNotNodeImpl <em>Errors Expression Not Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.ErrorsExpressionNotNodeImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getErrorsExpressionNotNode()
	 * @generated
	 */
	int ERRORS_EXPRESSION_NOT_NODE = 23;

	/**
	 * The feature id for the '<em><b>Error Propagation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERRORS_EXPRESSION_NOT_NODE__ERROR_PROPAGATION = ERRORS_EXPRESSION_NODE__ERROR_PROPAGATION;

	/**
	 * The feature id for the '<em><b>Errors Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERRORS_EXPRESSION_NOT_NODE__ERRORS_EXPRESSION = ERRORS_EXPRESSION_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Errors Expression Not Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERRORS_EXPRESSION_NOT_NODE_FEATURE_COUNT = ERRORS_EXPRESSION_NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.ErrorsExpressionAndNodeImpl <em>Errors Expression And Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.ErrorsExpressionAndNodeImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getErrorsExpressionAndNode()
	 * @generated
	 */
	int ERRORS_EXPRESSION_AND_NODE = 24;

	/**
	 * The feature id for the '<em><b>Error Propagation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERRORS_EXPRESSION_AND_NODE__ERROR_PROPAGATION = ERRORS_EXPRESSION_NODE__ERROR_PROPAGATION;

	/**
	 * The feature id for the '<em><b>Errors Expression1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERRORS_EXPRESSION_AND_NODE__ERRORS_EXPRESSION1 = ERRORS_EXPRESSION_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Errors Expression2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERRORS_EXPRESSION_AND_NODE__ERRORS_EXPRESSION2 = ERRORS_EXPRESSION_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Errors Expression And Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERRORS_EXPRESSION_AND_NODE_FEATURE_COUNT = ERRORS_EXPRESSION_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.ErrorsExpressionOrNodeImpl <em>Errors Expression Or Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.ErrorsExpressionOrNodeImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getErrorsExpressionOrNode()
	 * @generated
	 */
	int ERRORS_EXPRESSION_OR_NODE = 25;

	/**
	 * The feature id for the '<em><b>Error Propagation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERRORS_EXPRESSION_OR_NODE__ERROR_PROPAGATION = ERRORS_EXPRESSION_NODE__ERROR_PROPAGATION;

	/**
	 * The feature id for the '<em><b>Errors Expression1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERRORS_EXPRESSION_OR_NODE__ERRORS_EXPRESSION1 = ERRORS_EXPRESSION_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Errors Expression2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERRORS_EXPRESSION_OR_NODE__ERRORS_EXPRESSION2 = ERRORS_EXPRESSION_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Errors Expression Or Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERRORS_EXPRESSION_OR_NODE_FEATURE_COUNT = ERRORS_EXPRESSION_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.FaultsGenerateErrorsImpl <em>Faults Generate Errors</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.FaultsGenerateErrorsImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getFaultsGenerateErrors()
	 * @generated
	 */
	int FAULTS_GENERATE_ERRORS = 26;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULTS_GENERATE_ERRORS__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULTS_GENERATE_ERRORS__DESTINATION = 1;

	/**
	 * The feature id for the '<em><b>Activation Delay</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULTS_GENERATE_ERRORS__ACTIVATION_DELAY = 2;

	/**
	 * The feature id for the '<em><b>Propagation Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULTS_GENERATE_ERRORS__PROPAGATION_PROBABILITY = 3;

	/**
	 * The feature id for the '<em><b>Propagation Logic</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULTS_GENERATE_ERRORS__PROPAGATION_LOGIC = 4;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULTS_GENERATE_ERRORS__WEIGHT = 5;

	/**
	 * The feature id for the '<em><b>Propagation Logic String Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULTS_GENERATE_ERRORS__PROPAGATION_LOGIC_STRING_FORMAT = 6;

	/**
	 * The feature id for the '<em><b>Component</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULTS_GENERATE_ERRORS__COMPONENT = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULTS_GENERATE_ERRORS__NAME = 8;

	/**
	 * The number of structural features of the '<em>Faults Generate Errors</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULTS_GENERATE_ERRORS_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.ErrorsPropagationImpl <em>Errors Propagation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.ErrorsPropagationImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getErrorsPropagation()
	 * @generated
	 */
	int ERRORS_PROPAGATION = 28;

	/**
	 * The feature id for the '<em><b>Propagation Logic</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERRORS_PROPAGATION__PROPAGATION_LOGIC = 0;

	/**
	 * The feature id for the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERRORS_PROPAGATION__COMPONENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERRORS_PROPAGATION__NAME = 2;

	/**
	 * The feature id for the '<em><b>Propagation Logic String Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERRORS_PROPAGATION__PROPAGATION_LOGIC_STRING_FORMAT = 3;

	/**
	 * The number of structural features of the '<em>Errors Propagation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERRORS_PROPAGATION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.InternalPropagationImpl <em>Internal Propagation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.InternalPropagationImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getInternalPropagation()
	 * @generated
	 */
	int INTERNAL_PROPAGATION = 27;

	/**
	 * The feature id for the '<em><b>Propagation Logic</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_PROPAGATION__PROPAGATION_LOGIC = ERRORS_PROPAGATION__PROPAGATION_LOGIC;

	/**
	 * The feature id for the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_PROPAGATION__COMPONENT = ERRORS_PROPAGATION__COMPONENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_PROPAGATION__NAME = ERRORS_PROPAGATION__NAME;

	/**
	 * The feature id for the '<em><b>Propagation Logic String Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_PROPAGATION__PROPAGATION_LOGIC_STRING_FORMAT = ERRORS_PROPAGATION__PROPAGATION_LOGIC_STRING_FORMAT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_PROPAGATION__SOURCE = ERRORS_PROPAGATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_PROPAGATION__DESTINATION = ERRORS_PROPAGATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Propagation Delay</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_PROPAGATION__PROPAGATION_DELAY = ERRORS_PROPAGATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Propagation Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_PROPAGATION__PROPAGATION_PROBABILITY = ERRORS_PROPAGATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_PROPAGATION__WEIGHT = ERRORS_PROPAGATION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Internal Propagation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_PROPAGATION_FEATURE_COUNT = ERRORS_PROPAGATION_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.ErrorsProduceFailuresImpl <em>Errors Produce Failures</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.ErrorsProduceFailuresImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getErrorsProduceFailures()
	 * @generated
	 */
	int ERRORS_PRODUCE_FAILURES = 29;

	/**
	 * The feature id for the '<em><b>Propagation Logic</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERRORS_PRODUCE_FAILURES__PROPAGATION_LOGIC = ERRORS_PROPAGATION__PROPAGATION_LOGIC;

	/**
	 * The feature id for the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERRORS_PRODUCE_FAILURES__COMPONENT = ERRORS_PROPAGATION__COMPONENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERRORS_PRODUCE_FAILURES__NAME = ERRORS_PROPAGATION__NAME;

	/**
	 * The feature id for the '<em><b>Propagation Logic String Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERRORS_PRODUCE_FAILURES__PROPAGATION_LOGIC_STRING_FORMAT = ERRORS_PROPAGATION__PROPAGATION_LOGIC_STRING_FORMAT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERRORS_PRODUCE_FAILURES__SOURCE = ERRORS_PROPAGATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERRORS_PRODUCE_FAILURES__DESTINATION = ERRORS_PROPAGATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Propagation Delay</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERRORS_PRODUCE_FAILURES__PROPAGATION_DELAY = ERRORS_PROPAGATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERRORS_PRODUCE_FAILURES__WEIGHT = ERRORS_PROPAGATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Propagation Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERRORS_PRODUCE_FAILURES__PROPAGATION_PROBABILITY = ERRORS_PROPAGATION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Errors Produce Failures</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERRORS_PRODUCE_FAILURES_FEATURE_COUNT = ERRORS_PROPAGATION_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.ActivityImpl <em>Activity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.ActivityImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getActivity()
	 * @generated
	 */
	int ACTIVITY = 30;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__DURATION = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>When</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__WHEN = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__COMPONENT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Activity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.MaintenanceActivityImpl <em>Maintenance Activity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.MaintenanceActivityImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getMaintenanceActivity()
	 * @generated
	 */
	int MAINTENANCE_ACTIVITY = 31;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAINTENANCE_ACTIVITY__NAME = ACTIVITY__NAME;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAINTENANCE_ACTIVITY__DURATION = ACTIVITY__DURATION;

	/**
	 * The feature id for the '<em><b>When</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAINTENANCE_ACTIVITY__WHEN = ACTIVITY__WHEN;

	/**
	 * The feature id for the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAINTENANCE_ACTIVITY__COMPONENT = ACTIVITY__COMPONENT;

	/**
	 * The feature id for the '<em><b>Success Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAINTENANCE_ACTIVITY__SUCCESS_PROBABILITY = ACTIVITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Maintenance Activity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAINTENANCE_ACTIVITY_FEATURE_COUNT = ACTIVITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.RepairActivityImpl <em>Repair Activity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.RepairActivityImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getRepairActivity()
	 * @generated
	 */
	int REPAIR_ACTIVITY = 32;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_ACTIVITY__NAME = MAINTENANCE_ACTIVITY__NAME;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_ACTIVITY__DURATION = MAINTENANCE_ACTIVITY__DURATION;

	/**
	 * The feature id for the '<em><b>When</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_ACTIVITY__WHEN = MAINTENANCE_ACTIVITY__WHEN;

	/**
	 * The feature id for the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_ACTIVITY__COMPONENT = MAINTENANCE_ACTIVITY__COMPONENT;

	/**
	 * The feature id for the '<em><b>Success Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_ACTIVITY__SUCCESS_PROBABILITY = MAINTENANCE_ACTIVITY__SUCCESS_PROBABILITY;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_ACTIVITY__TARGET = MAINTENANCE_ACTIVITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Repair Activity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_ACTIVITY_FEATURE_COUNT = MAINTENANCE_ACTIVITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.ReplaceActivityImpl <em>Replace Activity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.ReplaceActivityImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getReplaceActivity()
	 * @generated
	 */
	int REPLACE_ACTIVITY = 33;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_ACTIVITY__NAME = MAINTENANCE_ACTIVITY__NAME;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_ACTIVITY__DURATION = MAINTENANCE_ACTIVITY__DURATION;

	/**
	 * The feature id for the '<em><b>When</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_ACTIVITY__WHEN = MAINTENANCE_ACTIVITY__WHEN;

	/**
	 * The feature id for the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_ACTIVITY__COMPONENT = MAINTENANCE_ACTIVITY__COMPONENT;

	/**
	 * The feature id for the '<em><b>Success Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_ACTIVITY__SUCCESS_PROBABILITY = MAINTENANCE_ACTIVITY__SUCCESS_PROBABILITY;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_ACTIVITY__TARGET = MAINTENANCE_ACTIVITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Replacement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_ACTIVITY__REPLACEMENT = MAINTENANCE_ACTIVITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Replace Activity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_ACTIVITY_FEATURE_COUNT = MAINTENANCE_ACTIVITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.DetectionActivityImpl <em>Detection Activity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.DetectionActivityImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getDetectionActivity()
	 * @generated
	 */
	int DETECTION_ACTIVITY = 34;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETECTION_ACTIVITY__NAME = ACTIVITY__NAME;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETECTION_ACTIVITY__DURATION = ACTIVITY__DURATION;

	/**
	 * The feature id for the '<em><b>When</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETECTION_ACTIVITY__WHEN = ACTIVITY__WHEN;

	/**
	 * The feature id for the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETECTION_ACTIVITY__COMPONENT = ACTIVITY__COMPONENT;

	/**
	 * The feature id for the '<em><b>Coverage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETECTION_ACTIVITY__COVERAGE = ACTIVITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>False Positive Ratio</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETECTION_ACTIVITY__FALSE_POSITIVE_RATIO = ACTIVITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Detectable Errors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETECTION_ACTIVITY__DETECTABLE_ERRORS = ACTIVITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Detection Activity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETECTION_ACTIVITY_FEATURE_COUNT = ACTIVITY_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.SchedulingEventImpl <em>Scheduling Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.SchedulingEventImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getSchedulingEvent()
	 * @generated
	 */
	int SCHEDULING_EVENT = 35;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_EVENT__CONDITION = 0;

	/**
	 * The feature id for the '<em><b>Activity</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_EVENT__ACTIVITY = 1;

	/**
	 * The number of structural features of the '<em>Scheduling Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_EVENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.SchedulingConditionExpressionNodeImpl <em>Scheduling Condition Expression Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.SchedulingConditionExpressionNodeImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getSchedulingConditionExpressionNode()
	 * @generated
	 */
	int SCHEDULING_CONDITION_EXPRESSION_NODE = 36;

	/**
	 * The feature id for the '<em><b>Scheduling Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_CONDITION_EXPRESSION_NODE__SCHEDULING_EVENT = 0;

	/**
	 * The number of structural features of the '<em>Scheduling Condition Expression Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_CONDITION_EXPRESSION_NODE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.SchedulingConditionExpressionDetectionNodeImpl <em>Scheduling Condition Expression Detection Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.SchedulingConditionExpressionDetectionNodeImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getSchedulingConditionExpressionDetectionNode()
	 * @generated
	 */
	int SCHEDULING_CONDITION_EXPRESSION_DETECTION_NODE = 37;

	/**
	 * The feature id for the '<em><b>Scheduling Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_CONDITION_EXPRESSION_DETECTION_NODE__SCHEDULING_EVENT = SCHEDULING_CONDITION_EXPRESSION_NODE__SCHEDULING_EVENT;

	/**
	 * The feature id for the '<em><b>Error</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_CONDITION_EXPRESSION_DETECTION_NODE__ERROR = SCHEDULING_CONDITION_EXPRESSION_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Scheduling Condition Expression Detection Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_CONDITION_EXPRESSION_DETECTION_NODE_FEATURE_COUNT = SCHEDULING_CONDITION_EXPRESSION_NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.SchedulingConditionExpressionFailedNodeImpl <em>Scheduling Condition Expression Failed Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.SchedulingConditionExpressionFailedNodeImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getSchedulingConditionExpressionFailedNode()
	 * @generated
	 */
	int SCHEDULING_CONDITION_EXPRESSION_FAILED_NODE = 38;

	/**
	 * The feature id for the '<em><b>Scheduling Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_CONDITION_EXPRESSION_FAILED_NODE__SCHEDULING_EVENT = SCHEDULING_CONDITION_EXPRESSION_NODE__SCHEDULING_EVENT;

	/**
	 * The feature id for the '<em><b>Failure Mode</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_CONDITION_EXPRESSION_FAILED_NODE__FAILURE_MODE = SCHEDULING_CONDITION_EXPRESSION_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Scheduling Condition Expression Failed Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_CONDITION_EXPRESSION_FAILED_NODE_FEATURE_COUNT = SCHEDULING_CONDITION_EXPRESSION_NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.SchedulingConditionExpressionNotNodeImpl <em>Scheduling Condition Expression Not Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.SchedulingConditionExpressionNotNodeImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getSchedulingConditionExpressionNotNode()
	 * @generated
	 */
	int SCHEDULING_CONDITION_EXPRESSION_NOT_NODE = 39;

	/**
	 * The feature id for the '<em><b>Scheduling Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_CONDITION_EXPRESSION_NOT_NODE__SCHEDULING_EVENT = SCHEDULING_CONDITION_EXPRESSION_NODE__SCHEDULING_EVENT;

	/**
	 * The feature id for the '<em><b>Scheduling Condition Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_CONDITION_EXPRESSION_NOT_NODE__SCHEDULING_CONDITION_EXPRESSION = SCHEDULING_CONDITION_EXPRESSION_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Scheduling Condition Expression Not Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_CONDITION_EXPRESSION_NOT_NODE_FEATURE_COUNT = SCHEDULING_CONDITION_EXPRESSION_NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.SchedulingConditionExpressionTrueNodeImpl <em>Scheduling Condition Expression True Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.SchedulingConditionExpressionTrueNodeImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getSchedulingConditionExpressionTrueNode()
	 * @generated
	 */
	int SCHEDULING_CONDITION_EXPRESSION_TRUE_NODE = 40;

	/**
	 * The feature id for the '<em><b>Scheduling Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_CONDITION_EXPRESSION_TRUE_NODE__SCHEDULING_EVENT = SCHEDULING_CONDITION_EXPRESSION_NODE__SCHEDULING_EVENT;

	/**
	 * The number of structural features of the '<em>Scheduling Condition Expression True Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_CONDITION_EXPRESSION_TRUE_NODE_FEATURE_COUNT = SCHEDULING_CONDITION_EXPRESSION_NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.SchedulingConditionExpressionAndNodeImpl <em>Scheduling Condition Expression And Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.SchedulingConditionExpressionAndNodeImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getSchedulingConditionExpressionAndNode()
	 * @generated
	 */
	int SCHEDULING_CONDITION_EXPRESSION_AND_NODE = 41;

	/**
	 * The feature id for the '<em><b>Scheduling Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_CONDITION_EXPRESSION_AND_NODE__SCHEDULING_EVENT = SCHEDULING_CONDITION_EXPRESSION_NODE__SCHEDULING_EVENT;

	/**
	 * The feature id for the '<em><b>Scheduling Condition Expression1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_CONDITION_EXPRESSION_AND_NODE__SCHEDULING_CONDITION_EXPRESSION1 = SCHEDULING_CONDITION_EXPRESSION_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scheduling Condition Expression2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_CONDITION_EXPRESSION_AND_NODE__SCHEDULING_CONDITION_EXPRESSION2 = SCHEDULING_CONDITION_EXPRESSION_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Scheduling Condition Expression And Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_CONDITION_EXPRESSION_AND_NODE_FEATURE_COUNT = SCHEDULING_CONDITION_EXPRESSION_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.SchedulingConditionExpressionOrNodeImpl <em>Scheduling Condition Expression Or Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.SchedulingConditionExpressionOrNodeImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getSchedulingConditionExpressionOrNode()
	 * @generated
	 */
	int SCHEDULING_CONDITION_EXPRESSION_OR_NODE = 42;

	/**
	 * The feature id for the '<em><b>Scheduling Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_CONDITION_EXPRESSION_OR_NODE__SCHEDULING_EVENT = SCHEDULING_CONDITION_EXPRESSION_NODE__SCHEDULING_EVENT;

	/**
	 * The feature id for the '<em><b>Scheduling Condition Expression1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_CONDITION_EXPRESSION_OR_NODE__SCHEDULING_CONDITION_EXPRESSION1 = SCHEDULING_CONDITION_EXPRESSION_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scheduling Condition Expression2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_CONDITION_EXPRESSION_OR_NODE__SCHEDULING_CONDITION_EXPRESSION2 = SCHEDULING_CONDITION_EXPRESSION_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Scheduling Condition Expression Or Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_CONDITION_EXPRESSION_OR_NODE_FEATURE_COUNT = SCHEDULING_CONDITION_EXPRESSION_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.ScheduleImmediatelyImpl <em>Schedule Immediately</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.ScheduleImmediatelyImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getScheduleImmediately()
	 * @generated
	 */
	int SCHEDULE_IMMEDIATELY = 43;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_IMMEDIATELY__CONDITION = SCHEDULING_EVENT__CONDITION;

	/**
	 * The feature id for the '<em><b>Activity</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_IMMEDIATELY__ACTIVITY = SCHEDULING_EVENT__ACTIVITY;

	/**
	 * The feature id for the '<em><b>Before</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_IMMEDIATELY__BEFORE = SCHEDULING_EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>After</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_IMMEDIATELY__AFTER = SCHEDULING_EVENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Schedule Immediately</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_IMMEDIATELY_FEATURE_COUNT = SCHEDULING_EVENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.ScheduleAtTimeImpl <em>Schedule At Time</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.ScheduleAtTimeImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getScheduleAtTime()
	 * @generated
	 */
	int SCHEDULE_AT_TIME = 44;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_AT_TIME__CONDITION = SCHEDULING_EVENT__CONDITION;

	/**
	 * The feature id for the '<em><b>Activity</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_AT_TIME__ACTIVITY = SCHEDULING_EVENT__ACTIVITY;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_AT_TIME__TIME = SCHEDULING_EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Schedule At Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_AT_TIME_FEATURE_COUNT = SCHEDULING_EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.impl.SchedulePeriodicImpl <em>Schedule Periodic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.impl.SchedulePeriodicImpl
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getSchedulePeriodic()
	 * @generated
	 */
	int SCHEDULE_PERIODIC = 45;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_PERIODIC__CONDITION = SCHEDULING_EVENT__CONDITION;

	/**
	 * The feature id for the '<em><b>Activity</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_PERIODIC__ACTIVITY = SCHEDULING_EVENT__ACTIVITY;

	/**
	 * The feature id for the '<em><b>Before</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_PERIODIC__BEFORE = SCHEDULING_EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>After</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_PERIODIC__AFTER = SCHEDULING_EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Distribution</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_PERIODIC__DISTRIBUTION = SCHEDULING_EVENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Schedule Periodic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_PERIODIC_FEATURE_COUNT = SCHEDULING_EVENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.ConfidenceKindEnum <em>Confidence Kind Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.ConfidenceKindEnum
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getConfidenceKindEnum()
	 * @generated
	 */
	int CONFIDENCE_KIND_ENUM = 46;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.FailureDomain <em>Failure Domain</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.FailureDomain
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getFailureDomain()
	 * @generated
	 */
	int FAILURE_DOMAIN = 47;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.FailureDetectability <em>Failure Detectability</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.FailureDetectability
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getFailureDetectability()
	 * @generated
	 */
	int FAILURE_DETECTABILITY = 48;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.FailureConsequences <em>Failure Consequences</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.FailureConsequences
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getFailureConsequences()
	 * @generated
	 */
	int FAILURE_CONSEQUENCES = 49;

	/**
	 * The meta object id for the '{@link DependabilityintermediateModel.FailureConsistency <em>Failure Consistency</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DependabilityintermediateModel.FailureConsistency
	 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getFailureConsistency()
	 * @generated
	 */
	int FAILURE_CONSISTENCY = 50;


	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.Sistema <em>Sistema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sistema</em>'.
	 * @see DependabilityintermediateModel.Sistema
	 * @generated
	 */
	EClass getSistema();

	/**
	 * Returns the meta object for the containment reference list '{@link DependabilityintermediateModel.Sistema#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Components</em>'.
	 * @see DependabilityintermediateModel.Sistema#getComponents()
	 * @see #getSistema()
	 * @generated
	 */
	EReference getSistema_Components();

	/**
	 * Returns the meta object for the containment reference list '{@link DependabilityintermediateModel.Sistema#getActivities <em>Activities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Activities</em>'.
	 * @see DependabilityintermediateModel.Sistema#getActivities()
	 * @see #getSistema()
	 * @generated
	 */
	EReference getSistema_Activities();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see DependabilityintermediateModel.Component
	 * @generated
	 */
	EClass getComponent();

	/**
	 * Returns the meta object for the container reference '{@link DependabilityintermediateModel.Component#getIntermediateModel <em>Intermediate Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Intermediate Model</em>'.
	 * @see DependabilityintermediateModel.Component#getIntermediateModel()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_IntermediateModel();

	/**
	 * Returns the meta object for the containment reference list '{@link DependabilityintermediateModel.Component#getFailureModes <em>Failure Modes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Failure Modes</em>'.
	 * @see DependabilityintermediateModel.Component#getFailureModes()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_FailureModes();

	/**
	 * Returns the meta object for the containment reference list '{@link DependabilityintermediateModel.Component#getErrors <em>Errors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Errors</em>'.
	 * @see DependabilityintermediateModel.Component#getErrors()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Errors();

	/**
	 * Returns the meta object for the containment reference list '{@link DependabilityintermediateModel.Component#getFaults <em>Faults</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Faults</em>'.
	 * @see DependabilityintermediateModel.Component#getFaults()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Faults();

	/**
	 * Returns the meta object for the containment reference list '{@link DependabilityintermediateModel.Component#getFaultsGeneratesErrors <em>Faults Generates Errors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Faults Generates Errors</em>'.
	 * @see DependabilityintermediateModel.Component#getFaultsGeneratesErrors()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_FaultsGeneratesErrors();

	/**
	 * Returns the meta object for the containment reference list '{@link DependabilityintermediateModel.Component#getInternalPropagation <em>Internal Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Internal Propagation</em>'.
	 * @see DependabilityintermediateModel.Component#getInternalPropagation()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_InternalPropagation();

	/**
	 * Returns the meta object for the containment reference list '{@link DependabilityintermediateModel.Component#getErrorsGeneratesFailures <em>Errors Generates Failures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Errors Generates Failures</em>'.
	 * @see DependabilityintermediateModel.Component#getErrorsGeneratesFailures()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_ErrorsGeneratesFailures();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.Threat <em>Threat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Threat</em>'.
	 * @see DependabilityintermediateModel.Threat
	 * @generated
	 */
	EClass getThreat();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.Fault <em>Fault</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fault</em>'.
	 * @see DependabilityintermediateModel.Fault
	 * @generated
	 */
	EClass getFault();

	/**
	 * Returns the meta object for the container reference '{@link DependabilityintermediateModel.Fault#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Component</em>'.
	 * @see DependabilityintermediateModel.Fault#getComponent()
	 * @see #getFault()
	 * @generated
	 */
	EReference getFault_Component();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.InternalFault <em>Internal Fault</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Internal Fault</em>'.
	 * @see DependabilityintermediateModel.InternalFault
	 * @generated
	 */
	EClass getInternalFault();

	/**
	 * Returns the meta object for the containment reference '{@link DependabilityintermediateModel.InternalFault#getOccurrence <em>Occurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Occurrence</em>'.
	 * @see DependabilityintermediateModel.InternalFault#getOccurrence()
	 * @see #getInternalFault()
	 * @generated
	 */
	EReference getInternalFault_Occurrence();

	/**
	 * Returns the meta object for the attribute '{@link DependabilityintermediateModel.InternalFault#getPermanentProbability <em>Permanent Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Permanent Probability</em>'.
	 * @see DependabilityintermediateModel.InternalFault#getPermanentProbability()
	 * @see #getInternalFault()
	 * @generated
	 */
	EAttribute getInternalFault_PermanentProbability();

	/**
	 * Returns the meta object for the containment reference '{@link DependabilityintermediateModel.InternalFault#getTransientDuration <em>Transient Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Transient Duration</em>'.
	 * @see DependabilityintermediateModel.InternalFault#getTransientDuration()
	 * @see #getInternalFault()
	 * @generated
	 */
	EReference getInternalFault_TransientDuration();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.ExternalFault <em>External Fault</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Fault</em>'.
	 * @see DependabilityintermediateModel.ExternalFault
	 * @generated
	 */
	EClass getExternalFault();

	/**
	 * Returns the meta object for the reference '{@link DependabilityintermediateModel.ExternalFault#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see DependabilityintermediateModel.ExternalFault#getSource()
	 * @see #getExternalFault()
	 * @generated
	 */
	EReference getExternalFault_Source();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.Error <em>Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error</em>'.
	 * @see DependabilityintermediateModel.Error
	 * @generated
	 */
	EClass getError();

	/**
	 * Returns the meta object for the containment reference '{@link DependabilityintermediateModel.Error#getVanishingTime <em>Vanishing Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Vanishing Time</em>'.
	 * @see DependabilityintermediateModel.Error#getVanishingTime()
	 * @see #getError()
	 * @generated
	 */
	EReference getError_VanishingTime();

	/**
	 * Returns the meta object for the container reference '{@link DependabilityintermediateModel.Error#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Component</em>'.
	 * @see DependabilityintermediateModel.Error#getComponent()
	 * @see #getError()
	 * @generated
	 */
	EReference getError_Component();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see DependabilityintermediateModel.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link DependabilityintermediateModel.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see DependabilityintermediateModel.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.Distribution <em>Distribution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Distribution</em>'.
	 * @see DependabilityintermediateModel.Distribution
	 * @generated
	 */
	EClass getDistribution();

	/**
	 * Returns the meta object for the reference '{@link DependabilityintermediateModel.Distribution#getSistema <em>Sistema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sistema</em>'.
	 * @see DependabilityintermediateModel.Distribution#getSistema()
	 * @see #getDistribution()
	 * @generated
	 */
	EReference getDistribution_Sistema();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.Exponential <em>Exponential</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exponential</em>'.
	 * @see DependabilityintermediateModel.Exponential
	 * @generated
	 */
	EClass getExponential();

	/**
	 * Returns the meta object for the attribute '{@link DependabilityintermediateModel.Exponential#getRate <em>Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rate</em>'.
	 * @see DependabilityintermediateModel.Exponential#getRate()
	 * @see #getExponential()
	 * @generated
	 */
	EAttribute getExponential_Rate();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.Gaussian <em>Gaussian</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gaussian</em>'.
	 * @see DependabilityintermediateModel.Gaussian
	 * @generated
	 */
	EClass getGaussian();

	/**
	 * Returns the meta object for the attribute '{@link DependabilityintermediateModel.Gaussian#getMean <em>Mean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mean</em>'.
	 * @see DependabilityintermediateModel.Gaussian#getMean()
	 * @see #getGaussian()
	 * @generated
	 */
	EAttribute getGaussian_Mean();

	/**
	 * Returns the meta object for the attribute '{@link DependabilityintermediateModel.Gaussian#getVariance <em>Variance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variance</em>'.
	 * @see DependabilityintermediateModel.Gaussian#getVariance()
	 * @see #getGaussian()
	 * @generated
	 */
	EAttribute getGaussian_Variance();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.Deterministic <em>Deterministic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deterministic</em>'.
	 * @see DependabilityintermediateModel.Deterministic
	 * @generated
	 */
	EClass getDeterministic();

	/**
	 * Returns the meta object for the attribute '{@link DependabilityintermediateModel.Deterministic#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see DependabilityintermediateModel.Deterministic#getValue()
	 * @see #getDeterministic()
	 * @generated
	 */
	EAttribute getDeterministic_Value();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.Uniform <em>Uniform</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Uniform</em>'.
	 * @see DependabilityintermediateModel.Uniform
	 * @generated
	 */
	EClass getUniform();

	/**
	 * Returns the meta object for the attribute '{@link DependabilityintermediateModel.Uniform#getLower <em>Lower</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower</em>'.
	 * @see DependabilityintermediateModel.Uniform#getLower()
	 * @see #getUniform()
	 * @generated
	 */
	EAttribute getUniform_Lower();

	/**
	 * Returns the meta object for the attribute '{@link DependabilityintermediateModel.Uniform#getUpper <em>Upper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper</em>'.
	 * @see DependabilityintermediateModel.Uniform#getUpper()
	 * @see #getUniform()
	 * @generated
	 */
	EAttribute getUniform_Upper();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.Gamma <em>Gamma</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gamma</em>'.
	 * @see DependabilityintermediateModel.Gamma
	 * @generated
	 */
	EClass getGamma();

	/**
	 * Returns the meta object for the attribute '{@link DependabilityintermediateModel.Gamma#getAlpha <em>Alpha</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alpha</em>'.
	 * @see DependabilityintermediateModel.Gamma#getAlpha()
	 * @see #getGamma()
	 * @generated
	 */
	EAttribute getGamma_Alpha();

	/**
	 * Returns the meta object for the attribute '{@link DependabilityintermediateModel.Gamma#getBeta <em>Beta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Beta</em>'.
	 * @see DependabilityintermediateModel.Gamma#getBeta()
	 * @see #getGamma()
	 * @generated
	 */
	EAttribute getGamma_Beta();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.Weibull <em>Weibull</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Weibull</em>'.
	 * @see DependabilityintermediateModel.Weibull
	 * @generated
	 */
	EClass getWeibull();

	/**
	 * Returns the meta object for the attribute '{@link DependabilityintermediateModel.Weibull#getAlpha <em>Alpha</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alpha</em>'.
	 * @see DependabilityintermediateModel.Weibull#getAlpha()
	 * @see #getWeibull()
	 * @generated
	 */
	EAttribute getWeibull_Alpha();

	/**
	 * Returns the meta object for the attribute '{@link DependabilityintermediateModel.Weibull#getBeta <em>Beta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Beta</em>'.
	 * @see DependabilityintermediateModel.Weibull#getBeta()
	 * @see #getWeibull()
	 * @generated
	 */
	EAttribute getWeibull_Beta();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.FailureMode <em>Failure Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Failure Mode</em>'.
	 * @see DependabilityintermediateModel.FailureMode
	 * @generated
	 */
	EClass getFailureMode();

	/**
	 * Returns the meta object for the attribute '{@link DependabilityintermediateModel.FailureMode#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Domain</em>'.
	 * @see DependabilityintermediateModel.FailureMode#getDomain()
	 * @see #getFailureMode()
	 * @generated
	 */
	EAttribute getFailureMode_Domain();

	/**
	 * Returns the meta object for the attribute '{@link DependabilityintermediateModel.FailureMode#getDetectability <em>Detectability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Detectability</em>'.
	 * @see DependabilityintermediateModel.FailureMode#getDetectability()
	 * @see #getFailureMode()
	 * @generated
	 */
	EAttribute getFailureMode_Detectability();

	/**
	 * Returns the meta object for the attribute '{@link DependabilityintermediateModel.FailureMode#getConsistency <em>Consistency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Consistency</em>'.
	 * @see DependabilityintermediateModel.FailureMode#getConsistency()
	 * @see #getFailureMode()
	 * @generated
	 */
	EAttribute getFailureMode_Consistency();

	/**
	 * Returns the meta object for the attribute '{@link DependabilityintermediateModel.FailureMode#getConsequences <em>Consequences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Consequences</em>'.
	 * @see DependabilityintermediateModel.FailureMode#getConsequences()
	 * @see #getFailureMode()
	 * @generated
	 */
	EAttribute getFailureMode_Consequences();

	/**
	 * Returns the meta object for the container reference '{@link DependabilityintermediateModel.FailureMode#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Component</em>'.
	 * @see DependabilityintermediateModel.FailureMode#getComponent()
	 * @see #getFailureMode()
	 * @generated
	 */
	EReference getFailureMode_Component();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.FaultsExpressionNode <em>Faults Expression Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Faults Expression Node</em>'.
	 * @see DependabilityintermediateModel.FaultsExpressionNode
	 * @generated
	 */
	EClass getFaultsExpressionNode();

	/**
	 * Returns the meta object for the reference '{@link DependabilityintermediateModel.FaultsExpressionNode#getFaultsGenerateErrors <em>Faults Generate Errors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Faults Generate Errors</em>'.
	 * @see DependabilityintermediateModel.FaultsExpressionNode#getFaultsGenerateErrors()
	 * @see #getFaultsExpressionNode()
	 * @generated
	 */
	EReference getFaultsExpressionNode_FaultsGenerateErrors();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.FaultsExpressionAndNode <em>Faults Expression And Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Faults Expression And Node</em>'.
	 * @see DependabilityintermediateModel.FaultsExpressionAndNode
	 * @generated
	 */
	EClass getFaultsExpressionAndNode();

	/**
	 * Returns the meta object for the containment reference '{@link DependabilityintermediateModel.FaultsExpressionAndNode#getFaultsExpression1 <em>Faults Expression1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Faults Expression1</em>'.
	 * @see DependabilityintermediateModel.FaultsExpressionAndNode#getFaultsExpression1()
	 * @see #getFaultsExpressionAndNode()
	 * @generated
	 */
	EReference getFaultsExpressionAndNode_FaultsExpression1();

	/**
	 * Returns the meta object for the containment reference '{@link DependabilityintermediateModel.FaultsExpressionAndNode#getFaultsExpression2 <em>Faults Expression2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Faults Expression2</em>'.
	 * @see DependabilityintermediateModel.FaultsExpressionAndNode#getFaultsExpression2()
	 * @see #getFaultsExpressionAndNode()
	 * @generated
	 */
	EReference getFaultsExpressionAndNode_FaultsExpression2();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.FaultsExpressionOrNode <em>Faults Expression Or Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Faults Expression Or Node</em>'.
	 * @see DependabilityintermediateModel.FaultsExpressionOrNode
	 * @generated
	 */
	EClass getFaultsExpressionOrNode();

	/**
	 * Returns the meta object for the containment reference '{@link DependabilityintermediateModel.FaultsExpressionOrNode#getFaultsExpression1 <em>Faults Expression1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Faults Expression1</em>'.
	 * @see DependabilityintermediateModel.FaultsExpressionOrNode#getFaultsExpression1()
	 * @see #getFaultsExpressionOrNode()
	 * @generated
	 */
	EReference getFaultsExpressionOrNode_FaultsExpression1();

	/**
	 * Returns the meta object for the containment reference '{@link DependabilityintermediateModel.FaultsExpressionOrNode#getFaultsExpression2 <em>Faults Expression2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Faults Expression2</em>'.
	 * @see DependabilityintermediateModel.FaultsExpressionOrNode#getFaultsExpression2()
	 * @see #getFaultsExpressionOrNode()
	 * @generated
	 */
	EReference getFaultsExpressionOrNode_FaultsExpression2();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.FaultsExpressionFaultNode <em>Faults Expression Fault Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Faults Expression Fault Node</em>'.
	 * @see DependabilityintermediateModel.FaultsExpressionFaultNode
	 * @generated
	 */
	EClass getFaultsExpressionFaultNode();

	/**
	 * Returns the meta object for the reference '{@link DependabilityintermediateModel.FaultsExpressionFaultNode#getFault <em>Fault</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Fault</em>'.
	 * @see DependabilityintermediateModel.FaultsExpressionFaultNode#getFault()
	 * @see #getFaultsExpressionFaultNode()
	 * @generated
	 */
	EReference getFaultsExpressionFaultNode_Fault();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.FaultsExpressionNotNode <em>Faults Expression Not Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Faults Expression Not Node</em>'.
	 * @see DependabilityintermediateModel.FaultsExpressionNotNode
	 * @generated
	 */
	EClass getFaultsExpressionNotNode();

	/**
	 * Returns the meta object for the containment reference '{@link DependabilityintermediateModel.FaultsExpressionNotNode#getFaultsExpression <em>Faults Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Faults Expression</em>'.
	 * @see DependabilityintermediateModel.FaultsExpressionNotNode#getFaultsExpression()
	 * @see #getFaultsExpressionNotNode()
	 * @generated
	 */
	EReference getFaultsExpressionNotNode_FaultsExpression();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.ErrorsExpressionNode <em>Errors Expression Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Errors Expression Node</em>'.
	 * @see DependabilityintermediateModel.ErrorsExpressionNode
	 * @generated
	 */
	EClass getErrorsExpressionNode();

	/**
	 * Returns the meta object for the reference '{@link DependabilityintermediateModel.ErrorsExpressionNode#getErrorPropagation <em>Error Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Error Propagation</em>'.
	 * @see DependabilityintermediateModel.ErrorsExpressionNode#getErrorPropagation()
	 * @see #getErrorsExpressionNode()
	 * @generated
	 */
	EReference getErrorsExpressionNode_ErrorPropagation();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.ErrorsExpressionErrorNode <em>Errors Expression Error Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Errors Expression Error Node</em>'.
	 * @see DependabilityintermediateModel.ErrorsExpressionErrorNode
	 * @generated
	 */
	EClass getErrorsExpressionErrorNode();

	/**
	 * Returns the meta object for the reference '{@link DependabilityintermediateModel.ErrorsExpressionErrorNode#getError <em>Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Error</em>'.
	 * @see DependabilityintermediateModel.ErrorsExpressionErrorNode#getError()
	 * @see #getErrorsExpressionErrorNode()
	 * @generated
	 */
	EReference getErrorsExpressionErrorNode_Error();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.ErrorsExpressionNotNode <em>Errors Expression Not Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Errors Expression Not Node</em>'.
	 * @see DependabilityintermediateModel.ErrorsExpressionNotNode
	 * @generated
	 */
	EClass getErrorsExpressionNotNode();

	/**
	 * Returns the meta object for the containment reference '{@link DependabilityintermediateModel.ErrorsExpressionNotNode#getErrorsExpression <em>Errors Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Errors Expression</em>'.
	 * @see DependabilityintermediateModel.ErrorsExpressionNotNode#getErrorsExpression()
	 * @see #getErrorsExpressionNotNode()
	 * @generated
	 */
	EReference getErrorsExpressionNotNode_ErrorsExpression();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.ErrorsExpressionAndNode <em>Errors Expression And Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Errors Expression And Node</em>'.
	 * @see DependabilityintermediateModel.ErrorsExpressionAndNode
	 * @generated
	 */
	EClass getErrorsExpressionAndNode();

	/**
	 * Returns the meta object for the containment reference '{@link DependabilityintermediateModel.ErrorsExpressionAndNode#getErrorsExpression1 <em>Errors Expression1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Errors Expression1</em>'.
	 * @see DependabilityintermediateModel.ErrorsExpressionAndNode#getErrorsExpression1()
	 * @see #getErrorsExpressionAndNode()
	 * @generated
	 */
	EReference getErrorsExpressionAndNode_ErrorsExpression1();

	/**
	 * Returns the meta object for the containment reference '{@link DependabilityintermediateModel.ErrorsExpressionAndNode#getErrorsExpression2 <em>Errors Expression2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Errors Expression2</em>'.
	 * @see DependabilityintermediateModel.ErrorsExpressionAndNode#getErrorsExpression2()
	 * @see #getErrorsExpressionAndNode()
	 * @generated
	 */
	EReference getErrorsExpressionAndNode_ErrorsExpression2();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.ErrorsExpressionOrNode <em>Errors Expression Or Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Errors Expression Or Node</em>'.
	 * @see DependabilityintermediateModel.ErrorsExpressionOrNode
	 * @generated
	 */
	EClass getErrorsExpressionOrNode();

	/**
	 * Returns the meta object for the containment reference '{@link DependabilityintermediateModel.ErrorsExpressionOrNode#getErrorsExpression1 <em>Errors Expression1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Errors Expression1</em>'.
	 * @see DependabilityintermediateModel.ErrorsExpressionOrNode#getErrorsExpression1()
	 * @see #getErrorsExpressionOrNode()
	 * @generated
	 */
	EReference getErrorsExpressionOrNode_ErrorsExpression1();

	/**
	 * Returns the meta object for the containment reference '{@link DependabilityintermediateModel.ErrorsExpressionOrNode#getErrorsExpression2 <em>Errors Expression2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Errors Expression2</em>'.
	 * @see DependabilityintermediateModel.ErrorsExpressionOrNode#getErrorsExpression2()
	 * @see #getErrorsExpressionOrNode()
	 * @generated
	 */
	EReference getErrorsExpressionOrNode_ErrorsExpression2();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.FaultsGenerateErrors <em>Faults Generate Errors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Faults Generate Errors</em>'.
	 * @see DependabilityintermediateModel.FaultsGenerateErrors
	 * @generated
	 */
	EClass getFaultsGenerateErrors();

	/**
	 * Returns the meta object for the reference list '{@link DependabilityintermediateModel.FaultsGenerateErrors#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Source</em>'.
	 * @see DependabilityintermediateModel.FaultsGenerateErrors#getSource()
	 * @see #getFaultsGenerateErrors()
	 * @generated
	 */
	EReference getFaultsGenerateErrors_Source();

	/**
	 * Returns the meta object for the reference list '{@link DependabilityintermediateModel.FaultsGenerateErrors#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Destination</em>'.
	 * @see DependabilityintermediateModel.FaultsGenerateErrors#getDestination()
	 * @see #getFaultsGenerateErrors()
	 * @generated
	 */
	EReference getFaultsGenerateErrors_Destination();

	/**
	 * Returns the meta object for the containment reference '{@link DependabilityintermediateModel.FaultsGenerateErrors#getActivationDelay <em>Activation Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Activation Delay</em>'.
	 * @see DependabilityintermediateModel.FaultsGenerateErrors#getActivationDelay()
	 * @see #getFaultsGenerateErrors()
	 * @generated
	 */
	EReference getFaultsGenerateErrors_ActivationDelay();

	/**
	 * Returns the meta object for the attribute '{@link DependabilityintermediateModel.FaultsGenerateErrors#getPropagationProbability <em>Propagation Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Propagation Probability</em>'.
	 * @see DependabilityintermediateModel.FaultsGenerateErrors#getPropagationProbability()
	 * @see #getFaultsGenerateErrors()
	 * @generated
	 */
	EAttribute getFaultsGenerateErrors_PropagationProbability();

	/**
	 * Returns the meta object for the containment reference '{@link DependabilityintermediateModel.FaultsGenerateErrors#getPropagationLogic <em>Propagation Logic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Propagation Logic</em>'.
	 * @see DependabilityintermediateModel.FaultsGenerateErrors#getPropagationLogic()
	 * @see #getFaultsGenerateErrors()
	 * @generated
	 */
	EReference getFaultsGenerateErrors_PropagationLogic();

	/**
	 * Returns the meta object for the attribute '{@link DependabilityintermediateModel.FaultsGenerateErrors#getWeight <em>Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight</em>'.
	 * @see DependabilityintermediateModel.FaultsGenerateErrors#getWeight()
	 * @see #getFaultsGenerateErrors()
	 * @generated
	 */
	EAttribute getFaultsGenerateErrors_Weight();

	/**
	 * Returns the meta object for the attribute '{@link DependabilityintermediateModel.FaultsGenerateErrors#getPropagationLogicStringFormat <em>Propagation Logic String Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Propagation Logic String Format</em>'.
	 * @see DependabilityintermediateModel.FaultsGenerateErrors#getPropagationLogicStringFormat()
	 * @see #getFaultsGenerateErrors()
	 * @generated
	 */
	EAttribute getFaultsGenerateErrors_PropagationLogicStringFormat();

	/**
	 * Returns the meta object for the container reference '{@link DependabilityintermediateModel.FaultsGenerateErrors#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Component</em>'.
	 * @see DependabilityintermediateModel.FaultsGenerateErrors#getComponent()
	 * @see #getFaultsGenerateErrors()
	 * @generated
	 */
	EReference getFaultsGenerateErrors_Component();

	/**
	 * Returns the meta object for the attribute '{@link DependabilityintermediateModel.FaultsGenerateErrors#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see DependabilityintermediateModel.FaultsGenerateErrors#getName()
	 * @see #getFaultsGenerateErrors()
	 * @generated
	 */
	EAttribute getFaultsGenerateErrors_Name();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.InternalPropagation <em>Internal Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Internal Propagation</em>'.
	 * @see DependabilityintermediateModel.InternalPropagation
	 * @generated
	 */
	EClass getInternalPropagation();

	/**
	 * Returns the meta object for the reference list '{@link DependabilityintermediateModel.InternalPropagation#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Source</em>'.
	 * @see DependabilityintermediateModel.InternalPropagation#getSource()
	 * @see #getInternalPropagation()
	 * @generated
	 */
	EReference getInternalPropagation_Source();

	/**
	 * Returns the meta object for the reference list '{@link DependabilityintermediateModel.InternalPropagation#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Destination</em>'.
	 * @see DependabilityintermediateModel.InternalPropagation#getDestination()
	 * @see #getInternalPropagation()
	 * @generated
	 */
	EReference getInternalPropagation_Destination();

	/**
	 * Returns the meta object for the containment reference '{@link DependabilityintermediateModel.InternalPropagation#getPropagationDelay <em>Propagation Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Propagation Delay</em>'.
	 * @see DependabilityintermediateModel.InternalPropagation#getPropagationDelay()
	 * @see #getInternalPropagation()
	 * @generated
	 */
	EReference getInternalPropagation_PropagationDelay();

	/**
	 * Returns the meta object for the attribute '{@link DependabilityintermediateModel.InternalPropagation#getPropagationProbability <em>Propagation Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Propagation Probability</em>'.
	 * @see DependabilityintermediateModel.InternalPropagation#getPropagationProbability()
	 * @see #getInternalPropagation()
	 * @generated
	 */
	EAttribute getInternalPropagation_PropagationProbability();

	/**
	 * Returns the meta object for the attribute '{@link DependabilityintermediateModel.InternalPropagation#getWeight <em>Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight</em>'.
	 * @see DependabilityintermediateModel.InternalPropagation#getWeight()
	 * @see #getInternalPropagation()
	 * @generated
	 */
	EAttribute getInternalPropagation_Weight();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.ErrorsPropagation <em>Errors Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Errors Propagation</em>'.
	 * @see DependabilityintermediateModel.ErrorsPropagation
	 * @generated
	 */
	EClass getErrorsPropagation();

	/**
	 * Returns the meta object for the containment reference '{@link DependabilityintermediateModel.ErrorsPropagation#getPropagationLogic <em>Propagation Logic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Propagation Logic</em>'.
	 * @see DependabilityintermediateModel.ErrorsPropagation#getPropagationLogic()
	 * @see #getErrorsPropagation()
	 * @generated
	 */
	EReference getErrorsPropagation_PropagationLogic();

	/**
	 * Returns the meta object for the reference '{@link DependabilityintermediateModel.ErrorsPropagation#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Component</em>'.
	 * @see DependabilityintermediateModel.ErrorsPropagation#getComponent()
	 * @see #getErrorsPropagation()
	 * @generated
	 */
	EReference getErrorsPropagation_Component();

	/**
	 * Returns the meta object for the attribute '{@link DependabilityintermediateModel.ErrorsPropagation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see DependabilityintermediateModel.ErrorsPropagation#getName()
	 * @see #getErrorsPropagation()
	 * @generated
	 */
	EAttribute getErrorsPropagation_Name();

	/**
	 * Returns the meta object for the attribute '{@link DependabilityintermediateModel.ErrorsPropagation#getPropagationLogicStringFormat <em>Propagation Logic String Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Propagation Logic String Format</em>'.
	 * @see DependabilityintermediateModel.ErrorsPropagation#getPropagationLogicStringFormat()
	 * @see #getErrorsPropagation()
	 * @generated
	 */
	EAttribute getErrorsPropagation_PropagationLogicStringFormat();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.ErrorsProduceFailures <em>Errors Produce Failures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Errors Produce Failures</em>'.
	 * @see DependabilityintermediateModel.ErrorsProduceFailures
	 * @generated
	 */
	EClass getErrorsProduceFailures();

	/**
	 * Returns the meta object for the reference list '{@link DependabilityintermediateModel.ErrorsProduceFailures#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Source</em>'.
	 * @see DependabilityintermediateModel.ErrorsProduceFailures#getSource()
	 * @see #getErrorsProduceFailures()
	 * @generated
	 */
	EReference getErrorsProduceFailures_Source();

	/**
	 * Returns the meta object for the reference list '{@link DependabilityintermediateModel.ErrorsProduceFailures#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Destination</em>'.
	 * @see DependabilityintermediateModel.ErrorsProduceFailures#getDestination()
	 * @see #getErrorsProduceFailures()
	 * @generated
	 */
	EReference getErrorsProduceFailures_Destination();

	/**
	 * Returns the meta object for the containment reference '{@link DependabilityintermediateModel.ErrorsProduceFailures#getPropagationDelay <em>Propagation Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Propagation Delay</em>'.
	 * @see DependabilityintermediateModel.ErrorsProduceFailures#getPropagationDelay()
	 * @see #getErrorsProduceFailures()
	 * @generated
	 */
	EReference getErrorsProduceFailures_PropagationDelay();

	/**
	 * Returns the meta object for the attribute '{@link DependabilityintermediateModel.ErrorsProduceFailures#getWeight <em>Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight</em>'.
	 * @see DependabilityintermediateModel.ErrorsProduceFailures#getWeight()
	 * @see #getErrorsProduceFailures()
	 * @generated
	 */
	EAttribute getErrorsProduceFailures_Weight();

	/**
	 * Returns the meta object for the attribute '{@link DependabilityintermediateModel.ErrorsProduceFailures#getPropagationProbability <em>Propagation Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Propagation Probability</em>'.
	 * @see DependabilityintermediateModel.ErrorsProduceFailures#getPropagationProbability()
	 * @see #getErrorsProduceFailures()
	 * @generated
	 */
	EAttribute getErrorsProduceFailures_PropagationProbability();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.Activity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Activity</em>'.
	 * @see DependabilityintermediateModel.Activity
	 * @generated
	 */
	EClass getActivity();

	/**
	 * Returns the meta object for the containment reference '{@link DependabilityintermediateModel.Activity#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Duration</em>'.
	 * @see DependabilityintermediateModel.Activity#getDuration()
	 * @see #getActivity()
	 * @generated
	 */
	EReference getActivity_Duration();

	/**
	 * Returns the meta object for the containment reference '{@link DependabilityintermediateModel.Activity#getWhen <em>When</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>When</em>'.
	 * @see DependabilityintermediateModel.Activity#getWhen()
	 * @see #getActivity()
	 * @generated
	 */
	EReference getActivity_When();

	/**
	 * Returns the meta object for the reference '{@link DependabilityintermediateModel.Activity#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Component</em>'.
	 * @see DependabilityintermediateModel.Activity#getComponent()
	 * @see #getActivity()
	 * @generated
	 */
	EReference getActivity_Component();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.MaintenanceActivity <em>Maintenance Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Maintenance Activity</em>'.
	 * @see DependabilityintermediateModel.MaintenanceActivity
	 * @generated
	 */
	EClass getMaintenanceActivity();

	/**
	 * Returns the meta object for the attribute '{@link DependabilityintermediateModel.MaintenanceActivity#getSuccessProbability <em>Success Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Success Probability</em>'.
	 * @see DependabilityintermediateModel.MaintenanceActivity#getSuccessProbability()
	 * @see #getMaintenanceActivity()
	 * @generated
	 */
	EAttribute getMaintenanceActivity_SuccessProbability();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.RepairActivity <em>Repair Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Repair Activity</em>'.
	 * @see DependabilityintermediateModel.RepairActivity
	 * @generated
	 */
	EClass getRepairActivity();

	/**
	 * Returns the meta object for the reference list '{@link DependabilityintermediateModel.RepairActivity#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target</em>'.
	 * @see DependabilityintermediateModel.RepairActivity#getTarget()
	 * @see #getRepairActivity()
	 * @generated
	 */
	EReference getRepairActivity_Target();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.ReplaceActivity <em>Replace Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Replace Activity</em>'.
	 * @see DependabilityintermediateModel.ReplaceActivity
	 * @generated
	 */
	EClass getReplaceActivity();

	/**
	 * Returns the meta object for the reference '{@link DependabilityintermediateModel.ReplaceActivity#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see DependabilityintermediateModel.ReplaceActivity#getTarget()
	 * @see #getReplaceActivity()
	 * @generated
	 */
	EReference getReplaceActivity_Target();

	/**
	 * Returns the meta object for the reference '{@link DependabilityintermediateModel.ReplaceActivity#getReplacement <em>Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Replacement</em>'.
	 * @see DependabilityintermediateModel.ReplaceActivity#getReplacement()
	 * @see #getReplaceActivity()
	 * @generated
	 */
	EReference getReplaceActivity_Replacement();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.DetectionActivity <em>Detection Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Detection Activity</em>'.
	 * @see DependabilityintermediateModel.DetectionActivity
	 * @generated
	 */
	EClass getDetectionActivity();

	/**
	 * Returns the meta object for the attribute '{@link DependabilityintermediateModel.DetectionActivity#getCoverage <em>Coverage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Coverage</em>'.
	 * @see DependabilityintermediateModel.DetectionActivity#getCoverage()
	 * @see #getDetectionActivity()
	 * @generated
	 */
	EAttribute getDetectionActivity_Coverage();

	/**
	 * Returns the meta object for the attribute '{@link DependabilityintermediateModel.DetectionActivity#getFalsePositiveRatio <em>False Positive Ratio</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>False Positive Ratio</em>'.
	 * @see DependabilityintermediateModel.DetectionActivity#getFalsePositiveRatio()
	 * @see #getDetectionActivity()
	 * @generated
	 */
	EAttribute getDetectionActivity_FalsePositiveRatio();

	/**
	 * Returns the meta object for the reference list '{@link DependabilityintermediateModel.DetectionActivity#getDetectableErrors <em>Detectable Errors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Detectable Errors</em>'.
	 * @see DependabilityintermediateModel.DetectionActivity#getDetectableErrors()
	 * @see #getDetectionActivity()
	 * @generated
	 */
	EReference getDetectionActivity_DetectableErrors();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.SchedulingEvent <em>Scheduling Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scheduling Event</em>'.
	 * @see DependabilityintermediateModel.SchedulingEvent
	 * @generated
	 */
	EClass getSchedulingEvent();

	/**
	 * Returns the meta object for the containment reference '{@link DependabilityintermediateModel.SchedulingEvent#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see DependabilityintermediateModel.SchedulingEvent#getCondition()
	 * @see #getSchedulingEvent()
	 * @generated
	 */
	EReference getSchedulingEvent_Condition();

	/**
	 * Returns the meta object for the container reference '{@link DependabilityintermediateModel.SchedulingEvent#getActivity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Activity</em>'.
	 * @see DependabilityintermediateModel.SchedulingEvent#getActivity()
	 * @see #getSchedulingEvent()
	 * @generated
	 */
	EReference getSchedulingEvent_Activity();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.SchedulingConditionExpressionNode <em>Scheduling Condition Expression Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scheduling Condition Expression Node</em>'.
	 * @see DependabilityintermediateModel.SchedulingConditionExpressionNode
	 * @generated
	 */
	EClass getSchedulingConditionExpressionNode();

	/**
	 * Returns the meta object for the reference '{@link DependabilityintermediateModel.SchedulingConditionExpressionNode#getSchedulingEvent <em>Scheduling Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Scheduling Event</em>'.
	 * @see DependabilityintermediateModel.SchedulingConditionExpressionNode#getSchedulingEvent()
	 * @see #getSchedulingConditionExpressionNode()
	 * @generated
	 */
	EReference getSchedulingConditionExpressionNode_SchedulingEvent();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.SchedulingConditionExpressionDetectionNode <em>Scheduling Condition Expression Detection Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scheduling Condition Expression Detection Node</em>'.
	 * @see DependabilityintermediateModel.SchedulingConditionExpressionDetectionNode
	 * @generated
	 */
	EClass getSchedulingConditionExpressionDetectionNode();

	/**
	 * Returns the meta object for the reference '{@link DependabilityintermediateModel.SchedulingConditionExpressionDetectionNode#getError <em>Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Error</em>'.
	 * @see DependabilityintermediateModel.SchedulingConditionExpressionDetectionNode#getError()
	 * @see #getSchedulingConditionExpressionDetectionNode()
	 * @generated
	 */
	EReference getSchedulingConditionExpressionDetectionNode_Error();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.SchedulingConditionExpressionFailedNode <em>Scheduling Condition Expression Failed Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scheduling Condition Expression Failed Node</em>'.
	 * @see DependabilityintermediateModel.SchedulingConditionExpressionFailedNode
	 * @generated
	 */
	EClass getSchedulingConditionExpressionFailedNode();

	/**
	 * Returns the meta object for the reference '{@link DependabilityintermediateModel.SchedulingConditionExpressionFailedNode#getFailureMode <em>Failure Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Failure Mode</em>'.
	 * @see DependabilityintermediateModel.SchedulingConditionExpressionFailedNode#getFailureMode()
	 * @see #getSchedulingConditionExpressionFailedNode()
	 * @generated
	 */
	EReference getSchedulingConditionExpressionFailedNode_FailureMode();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.SchedulingConditionExpressionNotNode <em>Scheduling Condition Expression Not Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scheduling Condition Expression Not Node</em>'.
	 * @see DependabilityintermediateModel.SchedulingConditionExpressionNotNode
	 * @generated
	 */
	EClass getSchedulingConditionExpressionNotNode();

	/**
	 * Returns the meta object for the containment reference '{@link DependabilityintermediateModel.SchedulingConditionExpressionNotNode#getSchedulingConditionExpression <em>Scheduling Condition Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Scheduling Condition Expression</em>'.
	 * @see DependabilityintermediateModel.SchedulingConditionExpressionNotNode#getSchedulingConditionExpression()
	 * @see #getSchedulingConditionExpressionNotNode()
	 * @generated
	 */
	EReference getSchedulingConditionExpressionNotNode_SchedulingConditionExpression();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.SchedulingConditionExpressionTrueNode <em>Scheduling Condition Expression True Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scheduling Condition Expression True Node</em>'.
	 * @see DependabilityintermediateModel.SchedulingConditionExpressionTrueNode
	 * @generated
	 */
	EClass getSchedulingConditionExpressionTrueNode();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.SchedulingConditionExpressionAndNode <em>Scheduling Condition Expression And Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scheduling Condition Expression And Node</em>'.
	 * @see DependabilityintermediateModel.SchedulingConditionExpressionAndNode
	 * @generated
	 */
	EClass getSchedulingConditionExpressionAndNode();

	/**
	 * Returns the meta object for the containment reference '{@link DependabilityintermediateModel.SchedulingConditionExpressionAndNode#getSchedulingConditionExpression1 <em>Scheduling Condition Expression1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Scheduling Condition Expression1</em>'.
	 * @see DependabilityintermediateModel.SchedulingConditionExpressionAndNode#getSchedulingConditionExpression1()
	 * @see #getSchedulingConditionExpressionAndNode()
	 * @generated
	 */
	EReference getSchedulingConditionExpressionAndNode_SchedulingConditionExpression1();

	/**
	 * Returns the meta object for the containment reference '{@link DependabilityintermediateModel.SchedulingConditionExpressionAndNode#getSchedulingConditionExpression2 <em>Scheduling Condition Expression2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Scheduling Condition Expression2</em>'.
	 * @see DependabilityintermediateModel.SchedulingConditionExpressionAndNode#getSchedulingConditionExpression2()
	 * @see #getSchedulingConditionExpressionAndNode()
	 * @generated
	 */
	EReference getSchedulingConditionExpressionAndNode_SchedulingConditionExpression2();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.SchedulingConditionExpressionOrNode <em>Scheduling Condition Expression Or Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scheduling Condition Expression Or Node</em>'.
	 * @see DependabilityintermediateModel.SchedulingConditionExpressionOrNode
	 * @generated
	 */
	EClass getSchedulingConditionExpressionOrNode();

	/**
	 * Returns the meta object for the containment reference '{@link DependabilityintermediateModel.SchedulingConditionExpressionOrNode#getSchedulingConditionExpression1 <em>Scheduling Condition Expression1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Scheduling Condition Expression1</em>'.
	 * @see DependabilityintermediateModel.SchedulingConditionExpressionOrNode#getSchedulingConditionExpression1()
	 * @see #getSchedulingConditionExpressionOrNode()
	 * @generated
	 */
	EReference getSchedulingConditionExpressionOrNode_SchedulingConditionExpression1();

	/**
	 * Returns the meta object for the containment reference '{@link DependabilityintermediateModel.SchedulingConditionExpressionOrNode#getSchedulingConditionExpression2 <em>Scheduling Condition Expression2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Scheduling Condition Expression2</em>'.
	 * @see DependabilityintermediateModel.SchedulingConditionExpressionOrNode#getSchedulingConditionExpression2()
	 * @see #getSchedulingConditionExpressionOrNode()
	 * @generated
	 */
	EReference getSchedulingConditionExpressionOrNode_SchedulingConditionExpression2();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.ScheduleImmediately <em>Schedule Immediately</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Schedule Immediately</em>'.
	 * @see DependabilityintermediateModel.ScheduleImmediately
	 * @generated
	 */
	EClass getScheduleImmediately();

	/**
	 * Returns the meta object for the attribute '{@link DependabilityintermediateModel.ScheduleImmediately#getBefore <em>Before</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Before</em>'.
	 * @see DependabilityintermediateModel.ScheduleImmediately#getBefore()
	 * @see #getScheduleImmediately()
	 * @generated
	 */
	EAttribute getScheduleImmediately_Before();

	/**
	 * Returns the meta object for the attribute '{@link DependabilityintermediateModel.ScheduleImmediately#getAfter <em>After</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>After</em>'.
	 * @see DependabilityintermediateModel.ScheduleImmediately#getAfter()
	 * @see #getScheduleImmediately()
	 * @generated
	 */
	EAttribute getScheduleImmediately_After();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.ScheduleAtTime <em>Schedule At Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Schedule At Time</em>'.
	 * @see DependabilityintermediateModel.ScheduleAtTime
	 * @generated
	 */
	EClass getScheduleAtTime();

	/**
	 * Returns the meta object for the attribute '{@link DependabilityintermediateModel.ScheduleAtTime#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see DependabilityintermediateModel.ScheduleAtTime#getTime()
	 * @see #getScheduleAtTime()
	 * @generated
	 */
	EAttribute getScheduleAtTime_Time();

	/**
	 * Returns the meta object for class '{@link DependabilityintermediateModel.SchedulePeriodic <em>Schedule Periodic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Schedule Periodic</em>'.
	 * @see DependabilityintermediateModel.SchedulePeriodic
	 * @generated
	 */
	EClass getSchedulePeriodic();

	/**
	 * Returns the meta object for the attribute '{@link DependabilityintermediateModel.SchedulePeriodic#getBefore <em>Before</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Before</em>'.
	 * @see DependabilityintermediateModel.SchedulePeriodic#getBefore()
	 * @see #getSchedulePeriodic()
	 * @generated
	 */
	EAttribute getSchedulePeriodic_Before();

	/**
	 * Returns the meta object for the attribute '{@link DependabilityintermediateModel.SchedulePeriodic#getAfter <em>After</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>After</em>'.
	 * @see DependabilityintermediateModel.SchedulePeriodic#getAfter()
	 * @see #getSchedulePeriodic()
	 * @generated
	 */
	EAttribute getSchedulePeriodic_After();

	/**
	 * Returns the meta object for the containment reference '{@link DependabilityintermediateModel.SchedulePeriodic#getDistribution <em>Distribution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Distribution</em>'.
	 * @see DependabilityintermediateModel.SchedulePeriodic#getDistribution()
	 * @see #getSchedulePeriodic()
	 * @generated
	 */
	EReference getSchedulePeriodic_Distribution();

	/**
	 * Returns the meta object for enum '{@link DependabilityintermediateModel.ConfidenceKindEnum <em>Confidence Kind Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Confidence Kind Enum</em>'.
	 * @see DependabilityintermediateModel.ConfidenceKindEnum
	 * @generated
	 */
	EEnum getConfidenceKindEnum();

	/**
	 * Returns the meta object for enum '{@link DependabilityintermediateModel.FailureDomain <em>Failure Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Failure Domain</em>'.
	 * @see DependabilityintermediateModel.FailureDomain
	 * @generated
	 */
	EEnum getFailureDomain();

	/**
	 * Returns the meta object for enum '{@link DependabilityintermediateModel.FailureDetectability <em>Failure Detectability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Failure Detectability</em>'.
	 * @see DependabilityintermediateModel.FailureDetectability
	 * @generated
	 */
	EEnum getFailureDetectability();

	/**
	 * Returns the meta object for enum '{@link DependabilityintermediateModel.FailureConsequences <em>Failure Consequences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Failure Consequences</em>'.
	 * @see DependabilityintermediateModel.FailureConsequences
	 * @generated
	 */
	EEnum getFailureConsequences();

	/**
	 * Returns the meta object for enum '{@link DependabilityintermediateModel.FailureConsistency <em>Failure Consistency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Failure Consistency</em>'.
	 * @see DependabilityintermediateModel.FailureConsistency
	 * @generated
	 */
	EEnum getFailureConsistency();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DependabilityintermediateModelFactory getDependabilityintermediateModelFactory();

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
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.SistemaImpl <em>Sistema</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.SistemaImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getSistema()
		 * @generated
		 */
		EClass SISTEMA = eINSTANCE.getSistema();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SISTEMA__COMPONENTS = eINSTANCE.getSistema_Components();

		/**
		 * The meta object literal for the '<em><b>Activities</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SISTEMA__ACTIVITIES = eINSTANCE.getSistema_Activities();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.ComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.ComponentImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getComponent()
		 * @generated
		 */
		EClass COMPONENT = eINSTANCE.getComponent();

		/**
		 * The meta object literal for the '<em><b>Intermediate Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__INTERMEDIATE_MODEL = eINSTANCE.getComponent_IntermediateModel();

		/**
		 * The meta object literal for the '<em><b>Failure Modes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__FAILURE_MODES = eINSTANCE.getComponent_FailureModes();

		/**
		 * The meta object literal for the '<em><b>Errors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__ERRORS = eINSTANCE.getComponent_Errors();

		/**
		 * The meta object literal for the '<em><b>Faults</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__FAULTS = eINSTANCE.getComponent_Faults();

		/**
		 * The meta object literal for the '<em><b>Faults Generates Errors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__FAULTS_GENERATES_ERRORS = eINSTANCE.getComponent_FaultsGeneratesErrors();

		/**
		 * The meta object literal for the '<em><b>Internal Propagation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__INTERNAL_PROPAGATION = eINSTANCE.getComponent_InternalPropagation();

		/**
		 * The meta object literal for the '<em><b>Errors Generates Failures</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__ERRORS_GENERATES_FAILURES = eINSTANCE.getComponent_ErrorsGeneratesFailures();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.ThreatImpl <em>Threat</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.ThreatImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getThreat()
		 * @generated
		 */
		EClass THREAT = eINSTANCE.getThreat();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.FaultImpl <em>Fault</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.FaultImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getFault()
		 * @generated
		 */
		EClass FAULT = eINSTANCE.getFault();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAULT__COMPONENT = eINSTANCE.getFault_Component();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.InternalFaultImpl <em>Internal Fault</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.InternalFaultImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getInternalFault()
		 * @generated
		 */
		EClass INTERNAL_FAULT = eINSTANCE.getInternalFault();

		/**
		 * The meta object literal for the '<em><b>Occurrence</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERNAL_FAULT__OCCURRENCE = eINSTANCE.getInternalFault_Occurrence();

		/**
		 * The meta object literal for the '<em><b>Permanent Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERNAL_FAULT__PERMANENT_PROBABILITY = eINSTANCE.getInternalFault_PermanentProbability();

		/**
		 * The meta object literal for the '<em><b>Transient Duration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERNAL_FAULT__TRANSIENT_DURATION = eINSTANCE.getInternalFault_TransientDuration();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.ExternalFaultImpl <em>External Fault</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.ExternalFaultImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getExternalFault()
		 * @generated
		 */
		EClass EXTERNAL_FAULT = eINSTANCE.getExternalFault();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_FAULT__SOURCE = eINSTANCE.getExternalFault_Source();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.ErrorImpl <em>Error</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.ErrorImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getError()
		 * @generated
		 */
		EClass ERROR = eINSTANCE.getError();

		/**
		 * The meta object literal for the '<em><b>Vanishing Time</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR__VANISHING_TIME = eINSTANCE.getError_VanishingTime();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR__COMPONENT = eINSTANCE.getError_Component();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.NamedElementImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.DistributionImpl <em>Distribution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.DistributionImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getDistribution()
		 * @generated
		 */
		EClass DISTRIBUTION = eINSTANCE.getDistribution();

		/**
		 * The meta object literal for the '<em><b>Sistema</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISTRIBUTION__SISTEMA = eINSTANCE.getDistribution_Sistema();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.ExponentialImpl <em>Exponential</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.ExponentialImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getExponential()
		 * @generated
		 */
		EClass EXPONENTIAL = eINSTANCE.getExponential();

		/**
		 * The meta object literal for the '<em><b>Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPONENTIAL__RATE = eINSTANCE.getExponential_Rate();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.GaussianImpl <em>Gaussian</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.GaussianImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getGaussian()
		 * @generated
		 */
		EClass GAUSSIAN = eINSTANCE.getGaussian();

		/**
		 * The meta object literal for the '<em><b>Mean</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAUSSIAN__MEAN = eINSTANCE.getGaussian_Mean();

		/**
		 * The meta object literal for the '<em><b>Variance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAUSSIAN__VARIANCE = eINSTANCE.getGaussian_Variance();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.DeterministicImpl <em>Deterministic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.DeterministicImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getDeterministic()
		 * @generated
		 */
		EClass DETERMINISTIC = eINSTANCE.getDeterministic();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DETERMINISTIC__VALUE = eINSTANCE.getDeterministic_Value();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.UniformImpl <em>Uniform</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.UniformImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getUniform()
		 * @generated
		 */
		EClass UNIFORM = eINSTANCE.getUniform();

		/**
		 * The meta object literal for the '<em><b>Lower</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIFORM__LOWER = eINSTANCE.getUniform_Lower();

		/**
		 * The meta object literal for the '<em><b>Upper</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIFORM__UPPER = eINSTANCE.getUniform_Upper();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.GammaImpl <em>Gamma</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.GammaImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getGamma()
		 * @generated
		 */
		EClass GAMMA = eINSTANCE.getGamma();

		/**
		 * The meta object literal for the '<em><b>Alpha</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAMMA__ALPHA = eINSTANCE.getGamma_Alpha();

		/**
		 * The meta object literal for the '<em><b>Beta</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAMMA__BETA = eINSTANCE.getGamma_Beta();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.WeibullImpl <em>Weibull</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.WeibullImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getWeibull()
		 * @generated
		 */
		EClass WEIBULL = eINSTANCE.getWeibull();

		/**
		 * The meta object literal for the '<em><b>Alpha</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEIBULL__ALPHA = eINSTANCE.getWeibull_Alpha();

		/**
		 * The meta object literal for the '<em><b>Beta</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEIBULL__BETA = eINSTANCE.getWeibull_Beta();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.FailureModeImpl <em>Failure Mode</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.FailureModeImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getFailureMode()
		 * @generated
		 */
		EClass FAILURE_MODE = eINSTANCE.getFailureMode();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAILURE_MODE__DOMAIN = eINSTANCE.getFailureMode_Domain();

		/**
		 * The meta object literal for the '<em><b>Detectability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAILURE_MODE__DETECTABILITY = eINSTANCE.getFailureMode_Detectability();

		/**
		 * The meta object literal for the '<em><b>Consistency</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAILURE_MODE__CONSISTENCY = eINSTANCE.getFailureMode_Consistency();

		/**
		 * The meta object literal for the '<em><b>Consequences</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAILURE_MODE__CONSEQUENCES = eINSTANCE.getFailureMode_Consequences();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAILURE_MODE__COMPONENT = eINSTANCE.getFailureMode_Component();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.FaultsExpressionNodeImpl <em>Faults Expression Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.FaultsExpressionNodeImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getFaultsExpressionNode()
		 * @generated
		 */
		EClass FAULTS_EXPRESSION_NODE = eINSTANCE.getFaultsExpressionNode();

		/**
		 * The meta object literal for the '<em><b>Faults Generate Errors</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAULTS_EXPRESSION_NODE__FAULTS_GENERATE_ERRORS = eINSTANCE.getFaultsExpressionNode_FaultsGenerateErrors();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.FaultsExpressionAndNodeImpl <em>Faults Expression And Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.FaultsExpressionAndNodeImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getFaultsExpressionAndNode()
		 * @generated
		 */
		EClass FAULTS_EXPRESSION_AND_NODE = eINSTANCE.getFaultsExpressionAndNode();

		/**
		 * The meta object literal for the '<em><b>Faults Expression1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAULTS_EXPRESSION_AND_NODE__FAULTS_EXPRESSION1 = eINSTANCE.getFaultsExpressionAndNode_FaultsExpression1();

		/**
		 * The meta object literal for the '<em><b>Faults Expression2</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAULTS_EXPRESSION_AND_NODE__FAULTS_EXPRESSION2 = eINSTANCE.getFaultsExpressionAndNode_FaultsExpression2();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.FaultsExpressionOrNodeImpl <em>Faults Expression Or Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.FaultsExpressionOrNodeImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getFaultsExpressionOrNode()
		 * @generated
		 */
		EClass FAULTS_EXPRESSION_OR_NODE = eINSTANCE.getFaultsExpressionOrNode();

		/**
		 * The meta object literal for the '<em><b>Faults Expression1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAULTS_EXPRESSION_OR_NODE__FAULTS_EXPRESSION1 = eINSTANCE.getFaultsExpressionOrNode_FaultsExpression1();

		/**
		 * The meta object literal for the '<em><b>Faults Expression2</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAULTS_EXPRESSION_OR_NODE__FAULTS_EXPRESSION2 = eINSTANCE.getFaultsExpressionOrNode_FaultsExpression2();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.FaultsExpressionFaultNodeImpl <em>Faults Expression Fault Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.FaultsExpressionFaultNodeImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getFaultsExpressionFaultNode()
		 * @generated
		 */
		EClass FAULTS_EXPRESSION_FAULT_NODE = eINSTANCE.getFaultsExpressionFaultNode();

		/**
		 * The meta object literal for the '<em><b>Fault</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAULTS_EXPRESSION_FAULT_NODE__FAULT = eINSTANCE.getFaultsExpressionFaultNode_Fault();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.FaultsExpressionNotNodeImpl <em>Faults Expression Not Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.FaultsExpressionNotNodeImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getFaultsExpressionNotNode()
		 * @generated
		 */
		EClass FAULTS_EXPRESSION_NOT_NODE = eINSTANCE.getFaultsExpressionNotNode();

		/**
		 * The meta object literal for the '<em><b>Faults Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAULTS_EXPRESSION_NOT_NODE__FAULTS_EXPRESSION = eINSTANCE.getFaultsExpressionNotNode_FaultsExpression();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.ErrorsExpressionNodeImpl <em>Errors Expression Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.ErrorsExpressionNodeImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getErrorsExpressionNode()
		 * @generated
		 */
		EClass ERRORS_EXPRESSION_NODE = eINSTANCE.getErrorsExpressionNode();

		/**
		 * The meta object literal for the '<em><b>Error Propagation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERRORS_EXPRESSION_NODE__ERROR_PROPAGATION = eINSTANCE.getErrorsExpressionNode_ErrorPropagation();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.ErrorsExpressionErrorNodeImpl <em>Errors Expression Error Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.ErrorsExpressionErrorNodeImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getErrorsExpressionErrorNode()
		 * @generated
		 */
		EClass ERRORS_EXPRESSION_ERROR_NODE = eINSTANCE.getErrorsExpressionErrorNode();

		/**
		 * The meta object literal for the '<em><b>Error</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERRORS_EXPRESSION_ERROR_NODE__ERROR = eINSTANCE.getErrorsExpressionErrorNode_Error();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.ErrorsExpressionNotNodeImpl <em>Errors Expression Not Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.ErrorsExpressionNotNodeImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getErrorsExpressionNotNode()
		 * @generated
		 */
		EClass ERRORS_EXPRESSION_NOT_NODE = eINSTANCE.getErrorsExpressionNotNode();

		/**
		 * The meta object literal for the '<em><b>Errors Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERRORS_EXPRESSION_NOT_NODE__ERRORS_EXPRESSION = eINSTANCE.getErrorsExpressionNotNode_ErrorsExpression();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.ErrorsExpressionAndNodeImpl <em>Errors Expression And Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.ErrorsExpressionAndNodeImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getErrorsExpressionAndNode()
		 * @generated
		 */
		EClass ERRORS_EXPRESSION_AND_NODE = eINSTANCE.getErrorsExpressionAndNode();

		/**
		 * The meta object literal for the '<em><b>Errors Expression1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERRORS_EXPRESSION_AND_NODE__ERRORS_EXPRESSION1 = eINSTANCE.getErrorsExpressionAndNode_ErrorsExpression1();

		/**
		 * The meta object literal for the '<em><b>Errors Expression2</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERRORS_EXPRESSION_AND_NODE__ERRORS_EXPRESSION2 = eINSTANCE.getErrorsExpressionAndNode_ErrorsExpression2();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.ErrorsExpressionOrNodeImpl <em>Errors Expression Or Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.ErrorsExpressionOrNodeImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getErrorsExpressionOrNode()
		 * @generated
		 */
		EClass ERRORS_EXPRESSION_OR_NODE = eINSTANCE.getErrorsExpressionOrNode();

		/**
		 * The meta object literal for the '<em><b>Errors Expression1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERRORS_EXPRESSION_OR_NODE__ERRORS_EXPRESSION1 = eINSTANCE.getErrorsExpressionOrNode_ErrorsExpression1();

		/**
		 * The meta object literal for the '<em><b>Errors Expression2</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERRORS_EXPRESSION_OR_NODE__ERRORS_EXPRESSION2 = eINSTANCE.getErrorsExpressionOrNode_ErrorsExpression2();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.FaultsGenerateErrorsImpl <em>Faults Generate Errors</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.FaultsGenerateErrorsImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getFaultsGenerateErrors()
		 * @generated
		 */
		EClass FAULTS_GENERATE_ERRORS = eINSTANCE.getFaultsGenerateErrors();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAULTS_GENERATE_ERRORS__SOURCE = eINSTANCE.getFaultsGenerateErrors_Source();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAULTS_GENERATE_ERRORS__DESTINATION = eINSTANCE.getFaultsGenerateErrors_Destination();

		/**
		 * The meta object literal for the '<em><b>Activation Delay</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAULTS_GENERATE_ERRORS__ACTIVATION_DELAY = eINSTANCE.getFaultsGenerateErrors_ActivationDelay();

		/**
		 * The meta object literal for the '<em><b>Propagation Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAULTS_GENERATE_ERRORS__PROPAGATION_PROBABILITY = eINSTANCE.getFaultsGenerateErrors_PropagationProbability();

		/**
		 * The meta object literal for the '<em><b>Propagation Logic</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAULTS_GENERATE_ERRORS__PROPAGATION_LOGIC = eINSTANCE.getFaultsGenerateErrors_PropagationLogic();

		/**
		 * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAULTS_GENERATE_ERRORS__WEIGHT = eINSTANCE.getFaultsGenerateErrors_Weight();

		/**
		 * The meta object literal for the '<em><b>Propagation Logic String Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAULTS_GENERATE_ERRORS__PROPAGATION_LOGIC_STRING_FORMAT = eINSTANCE.getFaultsGenerateErrors_PropagationLogicStringFormat();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAULTS_GENERATE_ERRORS__COMPONENT = eINSTANCE.getFaultsGenerateErrors_Component();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAULTS_GENERATE_ERRORS__NAME = eINSTANCE.getFaultsGenerateErrors_Name();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.InternalPropagationImpl <em>Internal Propagation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.InternalPropagationImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getInternalPropagation()
		 * @generated
		 */
		EClass INTERNAL_PROPAGATION = eINSTANCE.getInternalPropagation();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERNAL_PROPAGATION__SOURCE = eINSTANCE.getInternalPropagation_Source();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERNAL_PROPAGATION__DESTINATION = eINSTANCE.getInternalPropagation_Destination();

		/**
		 * The meta object literal for the '<em><b>Propagation Delay</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERNAL_PROPAGATION__PROPAGATION_DELAY = eINSTANCE.getInternalPropagation_PropagationDelay();

		/**
		 * The meta object literal for the '<em><b>Propagation Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERNAL_PROPAGATION__PROPAGATION_PROBABILITY = eINSTANCE.getInternalPropagation_PropagationProbability();

		/**
		 * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERNAL_PROPAGATION__WEIGHT = eINSTANCE.getInternalPropagation_Weight();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.ErrorsPropagationImpl <em>Errors Propagation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.ErrorsPropagationImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getErrorsPropagation()
		 * @generated
		 */
		EClass ERRORS_PROPAGATION = eINSTANCE.getErrorsPropagation();

		/**
		 * The meta object literal for the '<em><b>Propagation Logic</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERRORS_PROPAGATION__PROPAGATION_LOGIC = eINSTANCE.getErrorsPropagation_PropagationLogic();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERRORS_PROPAGATION__COMPONENT = eINSTANCE.getErrorsPropagation_Component();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERRORS_PROPAGATION__NAME = eINSTANCE.getErrorsPropagation_Name();

		/**
		 * The meta object literal for the '<em><b>Propagation Logic String Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERRORS_PROPAGATION__PROPAGATION_LOGIC_STRING_FORMAT = eINSTANCE.getErrorsPropagation_PropagationLogicStringFormat();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.ErrorsProduceFailuresImpl <em>Errors Produce Failures</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.ErrorsProduceFailuresImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getErrorsProduceFailures()
		 * @generated
		 */
		EClass ERRORS_PRODUCE_FAILURES = eINSTANCE.getErrorsProduceFailures();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERRORS_PRODUCE_FAILURES__SOURCE = eINSTANCE.getErrorsProduceFailures_Source();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERRORS_PRODUCE_FAILURES__DESTINATION = eINSTANCE.getErrorsProduceFailures_Destination();

		/**
		 * The meta object literal for the '<em><b>Propagation Delay</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERRORS_PRODUCE_FAILURES__PROPAGATION_DELAY = eINSTANCE.getErrorsProduceFailures_PropagationDelay();

		/**
		 * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERRORS_PRODUCE_FAILURES__WEIGHT = eINSTANCE.getErrorsProduceFailures_Weight();

		/**
		 * The meta object literal for the '<em><b>Propagation Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERRORS_PRODUCE_FAILURES__PROPAGATION_PROBABILITY = eINSTANCE.getErrorsProduceFailures_PropagationProbability();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.ActivityImpl <em>Activity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.ActivityImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getActivity()
		 * @generated
		 */
		EClass ACTIVITY = eINSTANCE.getActivity();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY__DURATION = eINSTANCE.getActivity_Duration();

		/**
		 * The meta object literal for the '<em><b>When</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY__WHEN = eINSTANCE.getActivity_When();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY__COMPONENT = eINSTANCE.getActivity_Component();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.MaintenanceActivityImpl <em>Maintenance Activity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.MaintenanceActivityImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getMaintenanceActivity()
		 * @generated
		 */
		EClass MAINTENANCE_ACTIVITY = eINSTANCE.getMaintenanceActivity();

		/**
		 * The meta object literal for the '<em><b>Success Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAINTENANCE_ACTIVITY__SUCCESS_PROBABILITY = eINSTANCE.getMaintenanceActivity_SuccessProbability();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.RepairActivityImpl <em>Repair Activity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.RepairActivityImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getRepairActivity()
		 * @generated
		 */
		EClass REPAIR_ACTIVITY = eINSTANCE.getRepairActivity();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPAIR_ACTIVITY__TARGET = eINSTANCE.getRepairActivity_Target();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.ReplaceActivityImpl <em>Replace Activity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.ReplaceActivityImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getReplaceActivity()
		 * @generated
		 */
		EClass REPLACE_ACTIVITY = eINSTANCE.getReplaceActivity();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPLACE_ACTIVITY__TARGET = eINSTANCE.getReplaceActivity_Target();

		/**
		 * The meta object literal for the '<em><b>Replacement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPLACE_ACTIVITY__REPLACEMENT = eINSTANCE.getReplaceActivity_Replacement();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.DetectionActivityImpl <em>Detection Activity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.DetectionActivityImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getDetectionActivity()
		 * @generated
		 */
		EClass DETECTION_ACTIVITY = eINSTANCE.getDetectionActivity();

		/**
		 * The meta object literal for the '<em><b>Coverage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DETECTION_ACTIVITY__COVERAGE = eINSTANCE.getDetectionActivity_Coverage();

		/**
		 * The meta object literal for the '<em><b>False Positive Ratio</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DETECTION_ACTIVITY__FALSE_POSITIVE_RATIO = eINSTANCE.getDetectionActivity_FalsePositiveRatio();

		/**
		 * The meta object literal for the '<em><b>Detectable Errors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DETECTION_ACTIVITY__DETECTABLE_ERRORS = eINSTANCE.getDetectionActivity_DetectableErrors();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.SchedulingEventImpl <em>Scheduling Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.SchedulingEventImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getSchedulingEvent()
		 * @generated
		 */
		EClass SCHEDULING_EVENT = eINSTANCE.getSchedulingEvent();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULING_EVENT__CONDITION = eINSTANCE.getSchedulingEvent_Condition();

		/**
		 * The meta object literal for the '<em><b>Activity</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULING_EVENT__ACTIVITY = eINSTANCE.getSchedulingEvent_Activity();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.SchedulingConditionExpressionNodeImpl <em>Scheduling Condition Expression Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.SchedulingConditionExpressionNodeImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getSchedulingConditionExpressionNode()
		 * @generated
		 */
		EClass SCHEDULING_CONDITION_EXPRESSION_NODE = eINSTANCE.getSchedulingConditionExpressionNode();

		/**
		 * The meta object literal for the '<em><b>Scheduling Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULING_CONDITION_EXPRESSION_NODE__SCHEDULING_EVENT = eINSTANCE.getSchedulingConditionExpressionNode_SchedulingEvent();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.SchedulingConditionExpressionDetectionNodeImpl <em>Scheduling Condition Expression Detection Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.SchedulingConditionExpressionDetectionNodeImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getSchedulingConditionExpressionDetectionNode()
		 * @generated
		 */
		EClass SCHEDULING_CONDITION_EXPRESSION_DETECTION_NODE = eINSTANCE.getSchedulingConditionExpressionDetectionNode();

		/**
		 * The meta object literal for the '<em><b>Error</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULING_CONDITION_EXPRESSION_DETECTION_NODE__ERROR = eINSTANCE.getSchedulingConditionExpressionDetectionNode_Error();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.SchedulingConditionExpressionFailedNodeImpl <em>Scheduling Condition Expression Failed Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.SchedulingConditionExpressionFailedNodeImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getSchedulingConditionExpressionFailedNode()
		 * @generated
		 */
		EClass SCHEDULING_CONDITION_EXPRESSION_FAILED_NODE = eINSTANCE.getSchedulingConditionExpressionFailedNode();

		/**
		 * The meta object literal for the '<em><b>Failure Mode</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULING_CONDITION_EXPRESSION_FAILED_NODE__FAILURE_MODE = eINSTANCE.getSchedulingConditionExpressionFailedNode_FailureMode();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.SchedulingConditionExpressionNotNodeImpl <em>Scheduling Condition Expression Not Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.SchedulingConditionExpressionNotNodeImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getSchedulingConditionExpressionNotNode()
		 * @generated
		 */
		EClass SCHEDULING_CONDITION_EXPRESSION_NOT_NODE = eINSTANCE.getSchedulingConditionExpressionNotNode();

		/**
		 * The meta object literal for the '<em><b>Scheduling Condition Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULING_CONDITION_EXPRESSION_NOT_NODE__SCHEDULING_CONDITION_EXPRESSION = eINSTANCE.getSchedulingConditionExpressionNotNode_SchedulingConditionExpression();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.SchedulingConditionExpressionTrueNodeImpl <em>Scheduling Condition Expression True Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.SchedulingConditionExpressionTrueNodeImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getSchedulingConditionExpressionTrueNode()
		 * @generated
		 */
		EClass SCHEDULING_CONDITION_EXPRESSION_TRUE_NODE = eINSTANCE.getSchedulingConditionExpressionTrueNode();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.SchedulingConditionExpressionAndNodeImpl <em>Scheduling Condition Expression And Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.SchedulingConditionExpressionAndNodeImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getSchedulingConditionExpressionAndNode()
		 * @generated
		 */
		EClass SCHEDULING_CONDITION_EXPRESSION_AND_NODE = eINSTANCE.getSchedulingConditionExpressionAndNode();

		/**
		 * The meta object literal for the '<em><b>Scheduling Condition Expression1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULING_CONDITION_EXPRESSION_AND_NODE__SCHEDULING_CONDITION_EXPRESSION1 = eINSTANCE.getSchedulingConditionExpressionAndNode_SchedulingConditionExpression1();

		/**
		 * The meta object literal for the '<em><b>Scheduling Condition Expression2</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULING_CONDITION_EXPRESSION_AND_NODE__SCHEDULING_CONDITION_EXPRESSION2 = eINSTANCE.getSchedulingConditionExpressionAndNode_SchedulingConditionExpression2();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.SchedulingConditionExpressionOrNodeImpl <em>Scheduling Condition Expression Or Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.SchedulingConditionExpressionOrNodeImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getSchedulingConditionExpressionOrNode()
		 * @generated
		 */
		EClass SCHEDULING_CONDITION_EXPRESSION_OR_NODE = eINSTANCE.getSchedulingConditionExpressionOrNode();

		/**
		 * The meta object literal for the '<em><b>Scheduling Condition Expression1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULING_CONDITION_EXPRESSION_OR_NODE__SCHEDULING_CONDITION_EXPRESSION1 = eINSTANCE.getSchedulingConditionExpressionOrNode_SchedulingConditionExpression1();

		/**
		 * The meta object literal for the '<em><b>Scheduling Condition Expression2</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULING_CONDITION_EXPRESSION_OR_NODE__SCHEDULING_CONDITION_EXPRESSION2 = eINSTANCE.getSchedulingConditionExpressionOrNode_SchedulingConditionExpression2();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.ScheduleImmediatelyImpl <em>Schedule Immediately</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.ScheduleImmediatelyImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getScheduleImmediately()
		 * @generated
		 */
		EClass SCHEDULE_IMMEDIATELY = eINSTANCE.getScheduleImmediately();

		/**
		 * The meta object literal for the '<em><b>Before</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULE_IMMEDIATELY__BEFORE = eINSTANCE.getScheduleImmediately_Before();

		/**
		 * The meta object literal for the '<em><b>After</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULE_IMMEDIATELY__AFTER = eINSTANCE.getScheduleImmediately_After();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.ScheduleAtTimeImpl <em>Schedule At Time</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.ScheduleAtTimeImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getScheduleAtTime()
		 * @generated
		 */
		EClass SCHEDULE_AT_TIME = eINSTANCE.getScheduleAtTime();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULE_AT_TIME__TIME = eINSTANCE.getScheduleAtTime_Time();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.impl.SchedulePeriodicImpl <em>Schedule Periodic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.impl.SchedulePeriodicImpl
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getSchedulePeriodic()
		 * @generated
		 */
		EClass SCHEDULE_PERIODIC = eINSTANCE.getSchedulePeriodic();

		/**
		 * The meta object literal for the '<em><b>Before</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULE_PERIODIC__BEFORE = eINSTANCE.getSchedulePeriodic_Before();

		/**
		 * The meta object literal for the '<em><b>After</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULE_PERIODIC__AFTER = eINSTANCE.getSchedulePeriodic_After();

		/**
		 * The meta object literal for the '<em><b>Distribution</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULE_PERIODIC__DISTRIBUTION = eINSTANCE.getSchedulePeriodic_Distribution();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.ConfidenceKindEnum <em>Confidence Kind Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.ConfidenceKindEnum
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getConfidenceKindEnum()
		 * @generated
		 */
		EEnum CONFIDENCE_KIND_ENUM = eINSTANCE.getConfidenceKindEnum();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.FailureDomain <em>Failure Domain</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.FailureDomain
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getFailureDomain()
		 * @generated
		 */
		EEnum FAILURE_DOMAIN = eINSTANCE.getFailureDomain();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.FailureDetectability <em>Failure Detectability</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.FailureDetectability
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getFailureDetectability()
		 * @generated
		 */
		EEnum FAILURE_DETECTABILITY = eINSTANCE.getFailureDetectability();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.FailureConsequences <em>Failure Consequences</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.FailureConsequences
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getFailureConsequences()
		 * @generated
		 */
		EEnum FAILURE_CONSEQUENCES = eINSTANCE.getFailureConsequences();

		/**
		 * The meta object literal for the '{@link DependabilityintermediateModel.FailureConsistency <em>Failure Consistency</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DependabilityintermediateModel.FailureConsistency
		 * @see DependabilityintermediateModel.impl.DependabilityintermediateModelPackageImpl#getFailureConsistency()
		 * @generated
		 */
		EEnum FAILURE_CONSISTENCY = eINSTANCE.getFailureConsistency();

	}

} //DependabilityintermediateModelPackage
