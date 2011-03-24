/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel.impl;

import DependabilityintermediateModel.Activity;
import DependabilityintermediateModel.Component;
import DependabilityintermediateModel.ConfidenceKindEnum;
import DependabilityintermediateModel.DependabilityintermediateModelFactory;
import DependabilityintermediateModel.DependabilityintermediateModelPackage;
import DependabilityintermediateModel.DetectionActivity;
import DependabilityintermediateModel.Deterministic;
import DependabilityintermediateModel.Distribution;
import DependabilityintermediateModel.ErrorsExpressionAndNode;
import DependabilityintermediateModel.ErrorsExpressionErrorNode;
import DependabilityintermediateModel.ErrorsExpressionNode;
import DependabilityintermediateModel.ErrorsExpressionNotNode;
import DependabilityintermediateModel.ErrorsExpressionOrNode;
import DependabilityintermediateModel.ErrorsProduceFailures;
import DependabilityintermediateModel.ErrorsPropagation;
import DependabilityintermediateModel.Exponential;
import DependabilityintermediateModel.ExternalFault;
import DependabilityintermediateModel.FailureConsequences;
import DependabilityintermediateModel.FailureConsistency;
import DependabilityintermediateModel.FailureDetectability;
import DependabilityintermediateModel.FailureDomain;
import DependabilityintermediateModel.FailureMode;
import DependabilityintermediateModel.Fault;
import DependabilityintermediateModel.FaultsExpressionAndNode;
import DependabilityintermediateModel.FaultsExpressionFaultNode;
import DependabilityintermediateModel.FaultsExpressionNode;
import DependabilityintermediateModel.FaultsExpressionNotNode;
import DependabilityintermediateModel.FaultsExpressionOrNode;
import DependabilityintermediateModel.FaultsGenerateErrors;
import DependabilityintermediateModel.Gamma;
import DependabilityintermediateModel.Gaussian;
import DependabilityintermediateModel.InternalFault;
import DependabilityintermediateModel.InternalPropagation;
import DependabilityintermediateModel.MaintenanceActivity;
import DependabilityintermediateModel.NamedElement;
import DependabilityintermediateModel.RepairActivity;
import DependabilityintermediateModel.ReplaceActivity;
import DependabilityintermediateModel.ScheduleAtTime;
import DependabilityintermediateModel.ScheduleImmediately;
import DependabilityintermediateModel.SchedulePeriodic;
import DependabilityintermediateModel.SchedulingConditionExpressionAndNode;
import DependabilityintermediateModel.SchedulingConditionExpressionDetectionNode;
import DependabilityintermediateModel.SchedulingConditionExpressionFailedNode;
import DependabilityintermediateModel.SchedulingConditionExpressionNode;
import DependabilityintermediateModel.SchedulingConditionExpressionNotNode;
import DependabilityintermediateModel.SchedulingConditionExpressionOrNode;
import DependabilityintermediateModel.SchedulingConditionExpressionTrueNode;
import DependabilityintermediateModel.SchedulingEvent;
import DependabilityintermediateModel.Sistema;
import DependabilityintermediateModel.Threat;
import DependabilityintermediateModel.Uniform;
import DependabilityintermediateModel.Weibull;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DependabilityintermediateModelPackageImpl extends EPackageImpl implements DependabilityintermediateModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sistemaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass threatEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass faultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass internalFaultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalFaultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass errorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass distributionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exponentialEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gaussianEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deterministicEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uniformEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gammaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass weibullEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass failureModeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass faultsExpressionNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass faultsExpressionAndNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass faultsExpressionOrNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass faultsExpressionFaultNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass faultsExpressionNotNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass errorsExpressionNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass errorsExpressionErrorNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass errorsExpressionNotNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass errorsExpressionAndNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass errorsExpressionOrNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass faultsGenerateErrorsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass internalPropagationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass errorsPropagationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass errorsProduceFailuresEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass activityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass maintenanceActivityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass repairActivityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass replaceActivityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass detectionActivityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schedulingEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schedulingConditionExpressionNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schedulingConditionExpressionDetectionNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schedulingConditionExpressionFailedNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schedulingConditionExpressionNotNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schedulingConditionExpressionTrueNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schedulingConditionExpressionAndNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schedulingConditionExpressionOrNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scheduleImmediatelyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scheduleAtTimeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schedulePeriodicEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum confidenceKindEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum failureDomainEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum failureDetectabilityEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum failureConsequencesEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum failureConsistencyEEnum = null;

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
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DependabilityintermediateModelPackageImpl() {
		super(eNS_URI, DependabilityintermediateModelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DependabilityintermediateModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DependabilityintermediateModelPackage init() {
		if (isInited) return (DependabilityintermediateModelPackage)EPackage.Registry.INSTANCE.getEPackage(DependabilityintermediateModelPackage.eNS_URI);

		// Obtain or create and register package
		DependabilityintermediateModelPackageImpl theDependabilityintermediateModelPackage = (DependabilityintermediateModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DependabilityintermediateModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DependabilityintermediateModelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theDependabilityintermediateModelPackage.createPackageContents();

		// Initialize created meta-data
		theDependabilityintermediateModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDependabilityintermediateModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DependabilityintermediateModelPackage.eNS_URI, theDependabilityintermediateModelPackage);
		return theDependabilityintermediateModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSistema() {
		return sistemaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSistema_Components() {
		return (EReference)sistemaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSistema_Activities() {
		return (EReference)sistemaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponent() {
		return componentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_IntermediateModel() {
		return (EReference)componentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_FailureModes() {
		return (EReference)componentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_Errors() {
		return (EReference)componentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_Faults() {
		return (EReference)componentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_FaultsGeneratesErrors() {
		return (EReference)componentEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_InternalPropagation() {
		return (EReference)componentEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_ErrorsGeneratesFailures() {
		return (EReference)componentEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThreat() {
		return threatEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFault() {
		return faultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFault_Component() {
		return (EReference)faultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInternalFault() {
		return internalFaultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInternalFault_Occurrence() {
		return (EReference)internalFaultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInternalFault_PermanentProbability() {
		return (EAttribute)internalFaultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInternalFault_TransientDuration() {
		return (EReference)internalFaultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalFault() {
		return externalFaultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExternalFault_Source() {
		return (EReference)externalFaultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getError() {
		return errorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getError_VanishingTime() {
		return (EReference)errorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getError_Component() {
		return (EReference)errorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDistribution() {
		return distributionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDistribution_Sistema() {
		return (EReference)distributionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExponential() {
		return exponentialEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExponential_Rate() {
		return (EAttribute)exponentialEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGaussian() {
		return gaussianEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGaussian_Mean() {
		return (EAttribute)gaussianEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGaussian_Variance() {
		return (EAttribute)gaussianEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeterministic() {
		return deterministicEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeterministic_Value() {
		return (EAttribute)deterministicEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUniform() {
		return uniformEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUniform_Lower() {
		return (EAttribute)uniformEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUniform_Upper() {
		return (EAttribute)uniformEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGamma() {
		return gammaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGamma_Alpha() {
		return (EAttribute)gammaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGamma_Beta() {
		return (EAttribute)gammaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWeibull() {
		return weibullEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWeibull_Alpha() {
		return (EAttribute)weibullEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWeibull_Beta() {
		return (EAttribute)weibullEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFailureMode() {
		return failureModeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFailureMode_Domain() {
		return (EAttribute)failureModeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFailureMode_Detectability() {
		return (EAttribute)failureModeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFailureMode_Consistency() {
		return (EAttribute)failureModeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFailureMode_Consequences() {
		return (EAttribute)failureModeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFailureMode_Component() {
		return (EReference)failureModeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFaultsExpressionNode() {
		return faultsExpressionNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFaultsExpressionNode_FaultsGenerateErrors() {
		return (EReference)faultsExpressionNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFaultsExpressionAndNode() {
		return faultsExpressionAndNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFaultsExpressionAndNode_FaultsExpression1() {
		return (EReference)faultsExpressionAndNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFaultsExpressionAndNode_FaultsExpression2() {
		return (EReference)faultsExpressionAndNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFaultsExpressionOrNode() {
		return faultsExpressionOrNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFaultsExpressionOrNode_FaultsExpression1() {
		return (EReference)faultsExpressionOrNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFaultsExpressionOrNode_FaultsExpression2() {
		return (EReference)faultsExpressionOrNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFaultsExpressionFaultNode() {
		return faultsExpressionFaultNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFaultsExpressionFaultNode_Fault() {
		return (EReference)faultsExpressionFaultNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFaultsExpressionNotNode() {
		return faultsExpressionNotNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFaultsExpressionNotNode_FaultsExpression() {
		return (EReference)faultsExpressionNotNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getErrorsExpressionNode() {
		return errorsExpressionNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getErrorsExpressionNode_ErrorPropagation() {
		return (EReference)errorsExpressionNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getErrorsExpressionErrorNode() {
		return errorsExpressionErrorNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getErrorsExpressionErrorNode_Error() {
		return (EReference)errorsExpressionErrorNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getErrorsExpressionNotNode() {
		return errorsExpressionNotNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getErrorsExpressionNotNode_ErrorsExpression() {
		return (EReference)errorsExpressionNotNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getErrorsExpressionAndNode() {
		return errorsExpressionAndNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getErrorsExpressionAndNode_ErrorsExpression1() {
		return (EReference)errorsExpressionAndNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getErrorsExpressionAndNode_ErrorsExpression2() {
		return (EReference)errorsExpressionAndNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getErrorsExpressionOrNode() {
		return errorsExpressionOrNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getErrorsExpressionOrNode_ErrorsExpression1() {
		return (EReference)errorsExpressionOrNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getErrorsExpressionOrNode_ErrorsExpression2() {
		return (EReference)errorsExpressionOrNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFaultsGenerateErrors() {
		return faultsGenerateErrorsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFaultsGenerateErrors_Source() {
		return (EReference)faultsGenerateErrorsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFaultsGenerateErrors_Destination() {
		return (EReference)faultsGenerateErrorsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFaultsGenerateErrors_ActivationDelay() {
		return (EReference)faultsGenerateErrorsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultsGenerateErrors_PropagationProbability() {
		return (EAttribute)faultsGenerateErrorsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFaultsGenerateErrors_PropagationLogic() {
		return (EReference)faultsGenerateErrorsEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultsGenerateErrors_Weight() {
		return (EAttribute)faultsGenerateErrorsEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultsGenerateErrors_PropagationLogicStringFormat() {
		return (EAttribute)faultsGenerateErrorsEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFaultsGenerateErrors_Component() {
		return (EReference)faultsGenerateErrorsEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultsGenerateErrors_Name() {
		return (EAttribute)faultsGenerateErrorsEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInternalPropagation() {
		return internalPropagationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInternalPropagation_Source() {
		return (EReference)internalPropagationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInternalPropagation_Destination() {
		return (EReference)internalPropagationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInternalPropagation_PropagationDelay() {
		return (EReference)internalPropagationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInternalPropagation_PropagationProbability() {
		return (EAttribute)internalPropagationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInternalPropagation_Weight() {
		return (EAttribute)internalPropagationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getErrorsPropagation() {
		return errorsPropagationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getErrorsPropagation_PropagationLogic() {
		return (EReference)errorsPropagationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getErrorsPropagation_Component() {
		return (EReference)errorsPropagationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getErrorsPropagation_Name() {
		return (EAttribute)errorsPropagationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getErrorsPropagation_PropagationLogicStringFormat() {
		return (EAttribute)errorsPropagationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getErrorsProduceFailures() {
		return errorsProduceFailuresEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getErrorsProduceFailures_Source() {
		return (EReference)errorsProduceFailuresEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getErrorsProduceFailures_Destination() {
		return (EReference)errorsProduceFailuresEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getErrorsProduceFailures_PropagationDelay() {
		return (EReference)errorsProduceFailuresEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getErrorsProduceFailures_Weight() {
		return (EAttribute)errorsProduceFailuresEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getErrorsProduceFailures_PropagationProbability() {
		return (EAttribute)errorsProduceFailuresEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActivity() {
		return activityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivity_Duration() {
		return (EReference)activityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivity_When() {
		return (EReference)activityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivity_Component() {
		return (EReference)activityEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMaintenanceActivity() {
		return maintenanceActivityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMaintenanceActivity_SuccessProbability() {
		return (EAttribute)maintenanceActivityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRepairActivity() {
		return repairActivityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepairActivity_Target() {
		return (EReference)repairActivityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReplaceActivity() {
		return replaceActivityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReplaceActivity_Target() {
		return (EReference)replaceActivityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReplaceActivity_Replacement() {
		return (EReference)replaceActivityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDetectionActivity() {
		return detectionActivityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDetectionActivity_Coverage() {
		return (EAttribute)detectionActivityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDetectionActivity_FalsePositiveRatio() {
		return (EAttribute)detectionActivityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDetectionActivity_DetectableErrors() {
		return (EReference)detectionActivityEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchedulingEvent() {
		return schedulingEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchedulingEvent_Condition() {
		return (EReference)schedulingEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchedulingEvent_Activity() {
		return (EReference)schedulingEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchedulingConditionExpressionNode() {
		return schedulingConditionExpressionNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchedulingConditionExpressionNode_SchedulingEvent() {
		return (EReference)schedulingConditionExpressionNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchedulingConditionExpressionDetectionNode() {
		return schedulingConditionExpressionDetectionNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchedulingConditionExpressionDetectionNode_Error() {
		return (EReference)schedulingConditionExpressionDetectionNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchedulingConditionExpressionFailedNode() {
		return schedulingConditionExpressionFailedNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchedulingConditionExpressionFailedNode_FailureMode() {
		return (EReference)schedulingConditionExpressionFailedNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchedulingConditionExpressionNotNode() {
		return schedulingConditionExpressionNotNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchedulingConditionExpressionNotNode_SchedulingConditionExpression() {
		return (EReference)schedulingConditionExpressionNotNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchedulingConditionExpressionTrueNode() {
		return schedulingConditionExpressionTrueNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchedulingConditionExpressionAndNode() {
		return schedulingConditionExpressionAndNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchedulingConditionExpressionAndNode_SchedulingConditionExpression1() {
		return (EReference)schedulingConditionExpressionAndNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchedulingConditionExpressionAndNode_SchedulingConditionExpression2() {
		return (EReference)schedulingConditionExpressionAndNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchedulingConditionExpressionOrNode() {
		return schedulingConditionExpressionOrNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchedulingConditionExpressionOrNode_SchedulingConditionExpression1() {
		return (EReference)schedulingConditionExpressionOrNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchedulingConditionExpressionOrNode_SchedulingConditionExpression2() {
		return (EReference)schedulingConditionExpressionOrNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScheduleImmediately() {
		return scheduleImmediatelyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScheduleImmediately_Before() {
		return (EAttribute)scheduleImmediatelyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScheduleImmediately_After() {
		return (EAttribute)scheduleImmediatelyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScheduleAtTime() {
		return scheduleAtTimeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScheduleAtTime_Time() {
		return (EAttribute)scheduleAtTimeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchedulePeriodic() {
		return schedulePeriodicEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSchedulePeriodic_Before() {
		return (EAttribute)schedulePeriodicEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSchedulePeriodic_After() {
		return (EAttribute)schedulePeriodicEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchedulePeriodic_Distribution() {
		return (EReference)schedulePeriodicEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getConfidenceKindEnum() {
		return confidenceKindEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFailureDomain() {
		return failureDomainEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFailureDetectability() {
		return failureDetectabilityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFailureConsequences() {
		return failureConsequencesEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFailureConsistency() {
		return failureConsistencyEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependabilityintermediateModelFactory getDependabilityintermediateModelFactory() {
		return (DependabilityintermediateModelFactory)getEFactoryInstance();
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

		// Create classes and their features
		sistemaEClass = createEClass(SISTEMA);
		createEReference(sistemaEClass, SISTEMA__COMPONENTS);
		createEReference(sistemaEClass, SISTEMA__ACTIVITIES);

		componentEClass = createEClass(COMPONENT);
		createEReference(componentEClass, COMPONENT__INTERMEDIATE_MODEL);
		createEReference(componentEClass, COMPONENT__FAILURE_MODES);
		createEReference(componentEClass, COMPONENT__ERRORS);
		createEReference(componentEClass, COMPONENT__FAULTS);
		createEReference(componentEClass, COMPONENT__FAULTS_GENERATES_ERRORS);
		createEReference(componentEClass, COMPONENT__INTERNAL_PROPAGATION);
		createEReference(componentEClass, COMPONENT__ERRORS_GENERATES_FAILURES);

		threatEClass = createEClass(THREAT);

		faultEClass = createEClass(FAULT);
		createEReference(faultEClass, FAULT__COMPONENT);

		internalFaultEClass = createEClass(INTERNAL_FAULT);
		createEReference(internalFaultEClass, INTERNAL_FAULT__OCCURRENCE);
		createEAttribute(internalFaultEClass, INTERNAL_FAULT__PERMANENT_PROBABILITY);
		createEReference(internalFaultEClass, INTERNAL_FAULT__TRANSIENT_DURATION);

		externalFaultEClass = createEClass(EXTERNAL_FAULT);
		createEReference(externalFaultEClass, EXTERNAL_FAULT__SOURCE);

		errorEClass = createEClass(ERROR);
		createEReference(errorEClass, ERROR__VANISHING_TIME);
		createEReference(errorEClass, ERROR__COMPONENT);

		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		distributionEClass = createEClass(DISTRIBUTION);
		createEReference(distributionEClass, DISTRIBUTION__SISTEMA);

		exponentialEClass = createEClass(EXPONENTIAL);
		createEAttribute(exponentialEClass, EXPONENTIAL__RATE);

		gaussianEClass = createEClass(GAUSSIAN);
		createEAttribute(gaussianEClass, GAUSSIAN__MEAN);
		createEAttribute(gaussianEClass, GAUSSIAN__VARIANCE);

		deterministicEClass = createEClass(DETERMINISTIC);
		createEAttribute(deterministicEClass, DETERMINISTIC__VALUE);

		uniformEClass = createEClass(UNIFORM);
		createEAttribute(uniformEClass, UNIFORM__LOWER);
		createEAttribute(uniformEClass, UNIFORM__UPPER);

		gammaEClass = createEClass(GAMMA);
		createEAttribute(gammaEClass, GAMMA__ALPHA);
		createEAttribute(gammaEClass, GAMMA__BETA);

		weibullEClass = createEClass(WEIBULL);
		createEAttribute(weibullEClass, WEIBULL__ALPHA);
		createEAttribute(weibullEClass, WEIBULL__BETA);

		failureModeEClass = createEClass(FAILURE_MODE);
		createEAttribute(failureModeEClass, FAILURE_MODE__DOMAIN);
		createEAttribute(failureModeEClass, FAILURE_MODE__DETECTABILITY);
		createEAttribute(failureModeEClass, FAILURE_MODE__CONSISTENCY);
		createEAttribute(failureModeEClass, FAILURE_MODE__CONSEQUENCES);
		createEReference(failureModeEClass, FAILURE_MODE__COMPONENT);

		faultsExpressionNodeEClass = createEClass(FAULTS_EXPRESSION_NODE);
		createEReference(faultsExpressionNodeEClass, FAULTS_EXPRESSION_NODE__FAULTS_GENERATE_ERRORS);

		faultsExpressionAndNodeEClass = createEClass(FAULTS_EXPRESSION_AND_NODE);
		createEReference(faultsExpressionAndNodeEClass, FAULTS_EXPRESSION_AND_NODE__FAULTS_EXPRESSION1);
		createEReference(faultsExpressionAndNodeEClass, FAULTS_EXPRESSION_AND_NODE__FAULTS_EXPRESSION2);

		faultsExpressionOrNodeEClass = createEClass(FAULTS_EXPRESSION_OR_NODE);
		createEReference(faultsExpressionOrNodeEClass, FAULTS_EXPRESSION_OR_NODE__FAULTS_EXPRESSION1);
		createEReference(faultsExpressionOrNodeEClass, FAULTS_EXPRESSION_OR_NODE__FAULTS_EXPRESSION2);

		faultsExpressionFaultNodeEClass = createEClass(FAULTS_EXPRESSION_FAULT_NODE);
		createEReference(faultsExpressionFaultNodeEClass, FAULTS_EXPRESSION_FAULT_NODE__FAULT);

		faultsExpressionNotNodeEClass = createEClass(FAULTS_EXPRESSION_NOT_NODE);
		createEReference(faultsExpressionNotNodeEClass, FAULTS_EXPRESSION_NOT_NODE__FAULTS_EXPRESSION);

		errorsExpressionNodeEClass = createEClass(ERRORS_EXPRESSION_NODE);
		createEReference(errorsExpressionNodeEClass, ERRORS_EXPRESSION_NODE__ERROR_PROPAGATION);

		errorsExpressionErrorNodeEClass = createEClass(ERRORS_EXPRESSION_ERROR_NODE);
		createEReference(errorsExpressionErrorNodeEClass, ERRORS_EXPRESSION_ERROR_NODE__ERROR);

		errorsExpressionNotNodeEClass = createEClass(ERRORS_EXPRESSION_NOT_NODE);
		createEReference(errorsExpressionNotNodeEClass, ERRORS_EXPRESSION_NOT_NODE__ERRORS_EXPRESSION);

		errorsExpressionAndNodeEClass = createEClass(ERRORS_EXPRESSION_AND_NODE);
		createEReference(errorsExpressionAndNodeEClass, ERRORS_EXPRESSION_AND_NODE__ERRORS_EXPRESSION1);
		createEReference(errorsExpressionAndNodeEClass, ERRORS_EXPRESSION_AND_NODE__ERRORS_EXPRESSION2);

		errorsExpressionOrNodeEClass = createEClass(ERRORS_EXPRESSION_OR_NODE);
		createEReference(errorsExpressionOrNodeEClass, ERRORS_EXPRESSION_OR_NODE__ERRORS_EXPRESSION1);
		createEReference(errorsExpressionOrNodeEClass, ERRORS_EXPRESSION_OR_NODE__ERRORS_EXPRESSION2);

		faultsGenerateErrorsEClass = createEClass(FAULTS_GENERATE_ERRORS);
		createEReference(faultsGenerateErrorsEClass, FAULTS_GENERATE_ERRORS__SOURCE);
		createEReference(faultsGenerateErrorsEClass, FAULTS_GENERATE_ERRORS__DESTINATION);
		createEReference(faultsGenerateErrorsEClass, FAULTS_GENERATE_ERRORS__ACTIVATION_DELAY);
		createEAttribute(faultsGenerateErrorsEClass, FAULTS_GENERATE_ERRORS__PROPAGATION_PROBABILITY);
		createEReference(faultsGenerateErrorsEClass, FAULTS_GENERATE_ERRORS__PROPAGATION_LOGIC);
		createEAttribute(faultsGenerateErrorsEClass, FAULTS_GENERATE_ERRORS__WEIGHT);
		createEAttribute(faultsGenerateErrorsEClass, FAULTS_GENERATE_ERRORS__PROPAGATION_LOGIC_STRING_FORMAT);
		createEReference(faultsGenerateErrorsEClass, FAULTS_GENERATE_ERRORS__COMPONENT);
		createEAttribute(faultsGenerateErrorsEClass, FAULTS_GENERATE_ERRORS__NAME);

		internalPropagationEClass = createEClass(INTERNAL_PROPAGATION);
		createEReference(internalPropagationEClass, INTERNAL_PROPAGATION__SOURCE);
		createEReference(internalPropagationEClass, INTERNAL_PROPAGATION__DESTINATION);
		createEReference(internalPropagationEClass, INTERNAL_PROPAGATION__PROPAGATION_DELAY);
		createEAttribute(internalPropagationEClass, INTERNAL_PROPAGATION__PROPAGATION_PROBABILITY);
		createEAttribute(internalPropagationEClass, INTERNAL_PROPAGATION__WEIGHT);

		errorsPropagationEClass = createEClass(ERRORS_PROPAGATION);
		createEReference(errorsPropagationEClass, ERRORS_PROPAGATION__PROPAGATION_LOGIC);
		createEReference(errorsPropagationEClass, ERRORS_PROPAGATION__COMPONENT);
		createEAttribute(errorsPropagationEClass, ERRORS_PROPAGATION__NAME);
		createEAttribute(errorsPropagationEClass, ERRORS_PROPAGATION__PROPAGATION_LOGIC_STRING_FORMAT);

		errorsProduceFailuresEClass = createEClass(ERRORS_PRODUCE_FAILURES);
		createEReference(errorsProduceFailuresEClass, ERRORS_PRODUCE_FAILURES__SOURCE);
		createEReference(errorsProduceFailuresEClass, ERRORS_PRODUCE_FAILURES__DESTINATION);
		createEReference(errorsProduceFailuresEClass, ERRORS_PRODUCE_FAILURES__PROPAGATION_DELAY);
		createEAttribute(errorsProduceFailuresEClass, ERRORS_PRODUCE_FAILURES__WEIGHT);
		createEAttribute(errorsProduceFailuresEClass, ERRORS_PRODUCE_FAILURES__PROPAGATION_PROBABILITY);

		activityEClass = createEClass(ACTIVITY);
		createEReference(activityEClass, ACTIVITY__DURATION);
		createEReference(activityEClass, ACTIVITY__WHEN);
		createEReference(activityEClass, ACTIVITY__COMPONENT);

		maintenanceActivityEClass = createEClass(MAINTENANCE_ACTIVITY);
		createEAttribute(maintenanceActivityEClass, MAINTENANCE_ACTIVITY__SUCCESS_PROBABILITY);

		repairActivityEClass = createEClass(REPAIR_ACTIVITY);
		createEReference(repairActivityEClass, REPAIR_ACTIVITY__TARGET);

		replaceActivityEClass = createEClass(REPLACE_ACTIVITY);
		createEReference(replaceActivityEClass, REPLACE_ACTIVITY__TARGET);
		createEReference(replaceActivityEClass, REPLACE_ACTIVITY__REPLACEMENT);

		detectionActivityEClass = createEClass(DETECTION_ACTIVITY);
		createEAttribute(detectionActivityEClass, DETECTION_ACTIVITY__COVERAGE);
		createEAttribute(detectionActivityEClass, DETECTION_ACTIVITY__FALSE_POSITIVE_RATIO);
		createEReference(detectionActivityEClass, DETECTION_ACTIVITY__DETECTABLE_ERRORS);

		schedulingEventEClass = createEClass(SCHEDULING_EVENT);
		createEReference(schedulingEventEClass, SCHEDULING_EVENT__CONDITION);
		createEReference(schedulingEventEClass, SCHEDULING_EVENT__ACTIVITY);

		schedulingConditionExpressionNodeEClass = createEClass(SCHEDULING_CONDITION_EXPRESSION_NODE);
		createEReference(schedulingConditionExpressionNodeEClass, SCHEDULING_CONDITION_EXPRESSION_NODE__SCHEDULING_EVENT);

		schedulingConditionExpressionDetectionNodeEClass = createEClass(SCHEDULING_CONDITION_EXPRESSION_DETECTION_NODE);
		createEReference(schedulingConditionExpressionDetectionNodeEClass, SCHEDULING_CONDITION_EXPRESSION_DETECTION_NODE__ERROR);

		schedulingConditionExpressionFailedNodeEClass = createEClass(SCHEDULING_CONDITION_EXPRESSION_FAILED_NODE);
		createEReference(schedulingConditionExpressionFailedNodeEClass, SCHEDULING_CONDITION_EXPRESSION_FAILED_NODE__FAILURE_MODE);

		schedulingConditionExpressionNotNodeEClass = createEClass(SCHEDULING_CONDITION_EXPRESSION_NOT_NODE);
		createEReference(schedulingConditionExpressionNotNodeEClass, SCHEDULING_CONDITION_EXPRESSION_NOT_NODE__SCHEDULING_CONDITION_EXPRESSION);

		schedulingConditionExpressionTrueNodeEClass = createEClass(SCHEDULING_CONDITION_EXPRESSION_TRUE_NODE);

		schedulingConditionExpressionAndNodeEClass = createEClass(SCHEDULING_CONDITION_EXPRESSION_AND_NODE);
		createEReference(schedulingConditionExpressionAndNodeEClass, SCHEDULING_CONDITION_EXPRESSION_AND_NODE__SCHEDULING_CONDITION_EXPRESSION1);
		createEReference(schedulingConditionExpressionAndNodeEClass, SCHEDULING_CONDITION_EXPRESSION_AND_NODE__SCHEDULING_CONDITION_EXPRESSION2);

		schedulingConditionExpressionOrNodeEClass = createEClass(SCHEDULING_CONDITION_EXPRESSION_OR_NODE);
		createEReference(schedulingConditionExpressionOrNodeEClass, SCHEDULING_CONDITION_EXPRESSION_OR_NODE__SCHEDULING_CONDITION_EXPRESSION1);
		createEReference(schedulingConditionExpressionOrNodeEClass, SCHEDULING_CONDITION_EXPRESSION_OR_NODE__SCHEDULING_CONDITION_EXPRESSION2);

		scheduleImmediatelyEClass = createEClass(SCHEDULE_IMMEDIATELY);
		createEAttribute(scheduleImmediatelyEClass, SCHEDULE_IMMEDIATELY__BEFORE);
		createEAttribute(scheduleImmediatelyEClass, SCHEDULE_IMMEDIATELY__AFTER);

		scheduleAtTimeEClass = createEClass(SCHEDULE_AT_TIME);
		createEAttribute(scheduleAtTimeEClass, SCHEDULE_AT_TIME__TIME);

		schedulePeriodicEClass = createEClass(SCHEDULE_PERIODIC);
		createEAttribute(schedulePeriodicEClass, SCHEDULE_PERIODIC__BEFORE);
		createEAttribute(schedulePeriodicEClass, SCHEDULE_PERIODIC__AFTER);
		createEReference(schedulePeriodicEClass, SCHEDULE_PERIODIC__DISTRIBUTION);

		// Create enums
		confidenceKindEnumEEnum = createEEnum(CONFIDENCE_KIND_ENUM);
		failureDomainEEnum = createEEnum(FAILURE_DOMAIN);
		failureDetectabilityEEnum = createEEnum(FAILURE_DETECTABILITY);
		failureConsequencesEEnum = createEEnum(FAILURE_CONSEQUENCES);
		failureConsistencyEEnum = createEEnum(FAILURE_CONSISTENCY);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		sistemaEClass.getESuperTypes().add(this.getNamedElement());
		componentEClass.getESuperTypes().add(this.getNamedElement());
		threatEClass.getESuperTypes().add(this.getNamedElement());
		faultEClass.getESuperTypes().add(this.getThreat());
		internalFaultEClass.getESuperTypes().add(this.getFault());
		externalFaultEClass.getESuperTypes().add(this.getFault());
		errorEClass.getESuperTypes().add(this.getThreat());
		exponentialEClass.getESuperTypes().add(this.getDistribution());
		gaussianEClass.getESuperTypes().add(this.getDistribution());
		deterministicEClass.getESuperTypes().add(this.getDistribution());
		uniformEClass.getESuperTypes().add(this.getDistribution());
		gammaEClass.getESuperTypes().add(this.getDistribution());
		weibullEClass.getESuperTypes().add(this.getDistribution());
		failureModeEClass.getESuperTypes().add(this.getThreat());
		faultsExpressionAndNodeEClass.getESuperTypes().add(this.getFaultsExpressionNode());
		faultsExpressionOrNodeEClass.getESuperTypes().add(this.getFaultsExpressionNode());
		faultsExpressionFaultNodeEClass.getESuperTypes().add(this.getFaultsExpressionNode());
		faultsExpressionNotNodeEClass.getESuperTypes().add(this.getFaultsExpressionNode());
		errorsExpressionErrorNodeEClass.getESuperTypes().add(this.getErrorsExpressionNode());
		errorsExpressionNotNodeEClass.getESuperTypes().add(this.getErrorsExpressionNode());
		errorsExpressionAndNodeEClass.getESuperTypes().add(this.getErrorsExpressionNode());
		errorsExpressionOrNodeEClass.getESuperTypes().add(this.getErrorsExpressionNode());
		internalPropagationEClass.getESuperTypes().add(this.getErrorsPropagation());
		errorsProduceFailuresEClass.getESuperTypes().add(this.getErrorsPropagation());
		activityEClass.getESuperTypes().add(this.getNamedElement());
		maintenanceActivityEClass.getESuperTypes().add(this.getActivity());
		repairActivityEClass.getESuperTypes().add(this.getMaintenanceActivity());
		replaceActivityEClass.getESuperTypes().add(this.getMaintenanceActivity());
		detectionActivityEClass.getESuperTypes().add(this.getActivity());
		schedulingConditionExpressionDetectionNodeEClass.getESuperTypes().add(this.getSchedulingConditionExpressionNode());
		schedulingConditionExpressionFailedNodeEClass.getESuperTypes().add(this.getSchedulingConditionExpressionNode());
		schedulingConditionExpressionNotNodeEClass.getESuperTypes().add(this.getSchedulingConditionExpressionNode());
		schedulingConditionExpressionTrueNodeEClass.getESuperTypes().add(this.getSchedulingConditionExpressionNode());
		schedulingConditionExpressionAndNodeEClass.getESuperTypes().add(this.getSchedulingConditionExpressionNode());
		schedulingConditionExpressionOrNodeEClass.getESuperTypes().add(this.getSchedulingConditionExpressionNode());
		scheduleImmediatelyEClass.getESuperTypes().add(this.getSchedulingEvent());
		scheduleAtTimeEClass.getESuperTypes().add(this.getSchedulingEvent());
		schedulePeriodicEClass.getESuperTypes().add(this.getSchedulingEvent());

		// Initialize classes and features; add operations and parameters
		initEClass(sistemaEClass, Sistema.class, "Sistema", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSistema_Components(), this.getComponent(), this.getComponent_IntermediateModel(), "components", null, 0, -1, Sistema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSistema_Activities(), this.getActivity(), null, "Activities", null, 0, -1, Sistema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(componentEClass, Component.class, "Component", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponent_IntermediateModel(), this.getSistema(), this.getSistema_Components(), "intermediateModel", null, 1, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_FailureModes(), this.getFailureMode(), this.getFailureMode_Component(), "FailureModes", null, 1, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_Errors(), this.getError(), this.getError_Component(), "Errors", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_Faults(), this.getFault(), this.getFault_Component(), "Faults", null, 1, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_FaultsGeneratesErrors(), this.getFaultsGenerateErrors(), this.getFaultsGenerateErrors_Component(), "FaultsGeneratesErrors", null, 1, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_InternalPropagation(), this.getInternalPropagation(), null, "InternalPropagation", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_ErrorsGeneratesFailures(), this.getErrorsProduceFailures(), null, "ErrorsGeneratesFailures", null, 1, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(threatEClass, Threat.class, "Threat", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(faultEClass, Fault.class, "Fault", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFault_Component(), this.getComponent(), this.getComponent_Faults(), "Component", null, 1, 1, Fault.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(internalFaultEClass, InternalFault.class, "InternalFault", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInternalFault_Occurrence(), this.getDistribution(), null, "Occurrence", null, 1, 1, InternalFault.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInternalFault_PermanentProbability(), ecorePackage.getEDouble(), "PermanentProbability", null, 1, 1, InternalFault.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInternalFault_TransientDuration(), this.getDistribution(), null, "TransientDuration", null, 1, 1, InternalFault.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(externalFaultEClass, ExternalFault.class, "ExternalFault", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExternalFault_Source(), this.getFailureMode(), null, "Source", null, 1, 1, ExternalFault.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorEClass, DependabilityintermediateModel.Error.class, "Error", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getError_VanishingTime(), this.getDistribution(), null, "VanishingTime", null, 0, 1, DependabilityintermediateModel.Error.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getError_Component(), this.getComponent(), this.getComponent_Errors(), "Component", null, 1, 1, DependabilityintermediateModel.Error.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "Name", null, 1, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(distributionEClass, Distribution.class, "Distribution", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDistribution_Sistema(), this.getSistema(), null, "Sistema", null, 0, 1, Distribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exponentialEClass, Exponential.class, "Exponential", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExponential_Rate(), ecorePackage.getEDouble(), "Rate", null, 1, 1, Exponential.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(gaussianEClass, Gaussian.class, "Gaussian", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGaussian_Mean(), ecorePackage.getEDouble(), "Mean", null, 1, 1, Gaussian.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGaussian_Variance(), ecorePackage.getEDouble(), "Variance", null, 1, 1, Gaussian.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deterministicEClass, Deterministic.class, "Deterministic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDeterministic_Value(), ecorePackage.getEDouble(), "Value", null, 1, 1, Deterministic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(uniformEClass, Uniform.class, "Uniform", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUniform_Lower(), ecorePackage.getEDouble(), "Lower", null, 1, 1, Uniform.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUniform_Upper(), ecorePackage.getEDouble(), "Upper", null, 1, 1, Uniform.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(gammaEClass, Gamma.class, "Gamma", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGamma_Alpha(), ecorePackage.getEDouble(), "Alpha", null, 1, 1, Gamma.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGamma_Beta(), ecorePackage.getEDouble(), "Beta", null, 1, 1, Gamma.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(weibullEClass, Weibull.class, "Weibull", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWeibull_Alpha(), ecorePackage.getEDouble(), "Alpha", null, 1, 1, Weibull.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWeibull_Beta(), ecorePackage.getEDouble(), "Beta", null, 1, 1, Weibull.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(failureModeEClass, FailureMode.class, "FailureMode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFailureMode_Domain(), this.getFailureDomain(), "Domain", null, 0, 1, FailureMode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFailureMode_Detectability(), this.getFailureDetectability(), "Detectability", null, 0, 1, FailureMode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFailureMode_Consistency(), this.getFailureConsistency(), "Consistency", null, 0, 1, FailureMode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFailureMode_Consequences(), this.getFailureConsequences(), "Consequences", null, 0, 1, FailureMode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFailureMode_Component(), this.getComponent(), this.getComponent_FailureModes(), "Component", null, 1, 1, FailureMode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(faultsExpressionNodeEClass, FaultsExpressionNode.class, "FaultsExpressionNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFaultsExpressionNode_FaultsGenerateErrors(), this.getFaultsGenerateErrors(), null, "faultsGenerateErrors", null, 1, 1, FaultsExpressionNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(faultsExpressionAndNodeEClass, FaultsExpressionAndNode.class, "FaultsExpressionAndNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFaultsExpressionAndNode_FaultsExpression1(), this.getFaultsExpressionNode(), null, "FaultsExpression1", null, 1, 1, FaultsExpressionAndNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFaultsExpressionAndNode_FaultsExpression2(), this.getFaultsExpressionNode(), null, "FaultsExpression2", null, 1, 1, FaultsExpressionAndNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(faultsExpressionOrNodeEClass, FaultsExpressionOrNode.class, "FaultsExpressionOrNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFaultsExpressionOrNode_FaultsExpression1(), this.getFaultsExpressionNode(), null, "FaultsExpression1", null, 1, 1, FaultsExpressionOrNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFaultsExpressionOrNode_FaultsExpression2(), this.getFaultsExpressionNode(), null, "FaultsExpression2", null, 1, 1, FaultsExpressionOrNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(faultsExpressionFaultNodeEClass, FaultsExpressionFaultNode.class, "FaultsExpressionFaultNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFaultsExpressionFaultNode_Fault(), this.getFault(), null, "Fault", null, 1, 1, FaultsExpressionFaultNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(faultsExpressionNotNodeEClass, FaultsExpressionNotNode.class, "FaultsExpressionNotNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFaultsExpressionNotNode_FaultsExpression(), this.getFaultsExpressionNode(), null, "FaultsExpression", null, 1, 1, FaultsExpressionNotNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorsExpressionNodeEClass, ErrorsExpressionNode.class, "ErrorsExpressionNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getErrorsExpressionNode_ErrorPropagation(), this.getErrorsPropagation(), null, "errorPropagation", null, 1, 1, ErrorsExpressionNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorsExpressionErrorNodeEClass, ErrorsExpressionErrorNode.class, "ErrorsExpressionErrorNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getErrorsExpressionErrorNode_Error(), this.getError(), null, "Error", null, 1, 1, ErrorsExpressionErrorNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorsExpressionNotNodeEClass, ErrorsExpressionNotNode.class, "ErrorsExpressionNotNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getErrorsExpressionNotNode_ErrorsExpression(), this.getErrorsExpressionNode(), null, "ErrorsExpression", null, 1, 1, ErrorsExpressionNotNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorsExpressionAndNodeEClass, ErrorsExpressionAndNode.class, "ErrorsExpressionAndNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getErrorsExpressionAndNode_ErrorsExpression1(), this.getErrorsExpressionNode(), null, "ErrorsExpression1", null, 1, 1, ErrorsExpressionAndNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorsExpressionAndNode_ErrorsExpression2(), this.getErrorsExpressionNode(), null, "ErrorsExpression2", null, 1, 1, ErrorsExpressionAndNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorsExpressionOrNodeEClass, ErrorsExpressionOrNode.class, "ErrorsExpressionOrNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getErrorsExpressionOrNode_ErrorsExpression1(), this.getErrorsExpressionNode(), null, "ErrorsExpression1", null, 1, 1, ErrorsExpressionOrNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorsExpressionOrNode_ErrorsExpression2(), this.getErrorsExpressionNode(), null, "ErrorsExpression2", null, 1, 1, ErrorsExpressionOrNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(faultsGenerateErrorsEClass, FaultsGenerateErrors.class, "FaultsGenerateErrors", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFaultsGenerateErrors_Source(), this.getFault(), null, "Source", null, 1, -1, FaultsGenerateErrors.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFaultsGenerateErrors_Destination(), this.getError(), null, "Destination", null, 1, -1, FaultsGenerateErrors.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFaultsGenerateErrors_ActivationDelay(), this.getDistribution(), null, "ActivationDelay", null, 1, 1, FaultsGenerateErrors.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFaultsGenerateErrors_PropagationProbability(), ecorePackage.getEDouble(), "PropagationProbability", null, 1, 1, FaultsGenerateErrors.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFaultsGenerateErrors_PropagationLogic(), this.getFaultsExpressionNode(), null, "PropagationLogic", null, 1, 1, FaultsGenerateErrors.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFaultsGenerateErrors_Weight(), ecorePackage.getEDouble(), "Weight", "1", 1, 1, FaultsGenerateErrors.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFaultsGenerateErrors_PropagationLogicStringFormat(), ecorePackage.getEString(), "PropagationLogicStringFormat", null, 1, 1, FaultsGenerateErrors.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFaultsGenerateErrors_Component(), this.getComponent(), this.getComponent_FaultsGeneratesErrors(), "component", null, 1, 1, FaultsGenerateErrors.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFaultsGenerateErrors_Name(), ecorePackage.getEString(), "Name", null, 1, 1, FaultsGenerateErrors.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(internalPropagationEClass, InternalPropagation.class, "InternalPropagation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInternalPropagation_Source(), this.getError(), null, "Source", null, 1, -1, InternalPropagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInternalPropagation_Destination(), this.getError(), null, "Destination", null, 1, -1, InternalPropagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInternalPropagation_PropagationDelay(), this.getDistribution(), null, "PropagationDelay", null, 1, 1, InternalPropagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInternalPropagation_PropagationProbability(), ecorePackage.getEDouble(), "PropagationProbability", null, 1, 1, InternalPropagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInternalPropagation_Weight(), ecorePackage.getEDouble(), "Weight", "1", 1, 1, InternalPropagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorsPropagationEClass, ErrorsPropagation.class, "ErrorsPropagation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getErrorsPropagation_PropagationLogic(), this.getErrorsExpressionNode(), null, "PropagationLogic", null, 1, 1, ErrorsPropagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorsPropagation_Component(), this.getComponent(), null, "component", null, 1, 1, ErrorsPropagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getErrorsPropagation_Name(), ecorePackage.getEString(), "Name", null, 1, 1, ErrorsPropagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getErrorsPropagation_PropagationLogicStringFormat(), ecorePackage.getEString(), "PropagationLogicStringFormat", null, 1, 1, ErrorsPropagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorsProduceFailuresEClass, ErrorsProduceFailures.class, "ErrorsProduceFailures", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getErrorsProduceFailures_Source(), this.getError(), null, "Source", null, 1, -1, ErrorsProduceFailures.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorsProduceFailures_Destination(), this.getFailureMode(), null, "Destination", null, 1, -1, ErrorsProduceFailures.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorsProduceFailures_PropagationDelay(), this.getDistribution(), null, "PropagationDelay", null, 1, 1, ErrorsProduceFailures.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getErrorsProduceFailures_Weight(), ecorePackage.getEDouble(), "Weight", "1", 1, 1, ErrorsProduceFailures.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getErrorsProduceFailures_PropagationProbability(), ecorePackage.getEDouble(), "PropagationProbability", "1", 0, 1, ErrorsProduceFailures.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(activityEClass, Activity.class, "Activity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActivity_Duration(), this.getDistribution(), null, "Duration", null, 1, 1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActivity_When(), this.getSchedulingEvent(), this.getSchedulingEvent_Activity(), "When", null, 1, 1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActivity_Component(), this.getComponent(), null, "Component", null, 0, 1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(maintenanceActivityEClass, MaintenanceActivity.class, "MaintenanceActivity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMaintenanceActivity_SuccessProbability(), ecorePackage.getEDouble(), "SuccessProbability", null, 1, 1, MaintenanceActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(repairActivityEClass, RepairActivity.class, "RepairActivity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRepairActivity_Target(), this.getComponent(), null, "Target", null, 1, -1, RepairActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(replaceActivityEClass, ReplaceActivity.class, "ReplaceActivity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReplaceActivity_Target(), this.getComponent(), null, "Target", null, 1, 1, ReplaceActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReplaceActivity_Replacement(), this.getComponent(), null, "Replacement", null, 0, 1, ReplaceActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(detectionActivityEClass, DetectionActivity.class, "DetectionActivity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDetectionActivity_Coverage(), ecorePackage.getEDouble(), "Coverage", null, 1, 1, DetectionActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDetectionActivity_FalsePositiveRatio(), ecorePackage.getEDouble(), "FalsePositiveRatio", null, 1, 1, DetectionActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDetectionActivity_DetectableErrors(), this.getError(), null, "DetectableErrors", null, 0, -1, DetectionActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(schedulingEventEClass, SchedulingEvent.class, "SchedulingEvent", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSchedulingEvent_Condition(), this.getSchedulingConditionExpressionNode(), null, "Condition", null, 1, 1, SchedulingEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSchedulingEvent_Activity(), this.getActivity(), this.getActivity_When(), "Activity", null, 1, 1, SchedulingEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(schedulingConditionExpressionNodeEClass, SchedulingConditionExpressionNode.class, "SchedulingConditionExpressionNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSchedulingConditionExpressionNode_SchedulingEvent(), this.getSchedulingEvent(), null, "SchedulingEvent", null, 1, 1, SchedulingConditionExpressionNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(schedulingConditionExpressionDetectionNodeEClass, SchedulingConditionExpressionDetectionNode.class, "SchedulingConditionExpressionDetectionNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSchedulingConditionExpressionDetectionNode_Error(), this.getError(), null, "Error", null, 1, 1, SchedulingConditionExpressionDetectionNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(schedulingConditionExpressionFailedNodeEClass, SchedulingConditionExpressionFailedNode.class, "SchedulingConditionExpressionFailedNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSchedulingConditionExpressionFailedNode_FailureMode(), this.getFailureMode(), null, "FailureMode", null, 1, 1, SchedulingConditionExpressionFailedNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(schedulingConditionExpressionNotNodeEClass, SchedulingConditionExpressionNotNode.class, "SchedulingConditionExpressionNotNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSchedulingConditionExpressionNotNode_SchedulingConditionExpression(), this.getSchedulingConditionExpressionNode(), null, "SchedulingConditionExpression", null, 1, 1, SchedulingConditionExpressionNotNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(schedulingConditionExpressionTrueNodeEClass, SchedulingConditionExpressionTrueNode.class, "SchedulingConditionExpressionTrueNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(schedulingConditionExpressionAndNodeEClass, SchedulingConditionExpressionAndNode.class, "SchedulingConditionExpressionAndNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSchedulingConditionExpressionAndNode_SchedulingConditionExpression1(), this.getSchedulingConditionExpressionNode(), null, "SchedulingConditionExpression1", null, 1, 1, SchedulingConditionExpressionAndNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSchedulingConditionExpressionAndNode_SchedulingConditionExpression2(), this.getSchedulingConditionExpressionNode(), null, "SchedulingConditionExpression2", null, 1, 1, SchedulingConditionExpressionAndNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(schedulingConditionExpressionOrNodeEClass, SchedulingConditionExpressionOrNode.class, "SchedulingConditionExpressionOrNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSchedulingConditionExpressionOrNode_SchedulingConditionExpression1(), this.getSchedulingConditionExpressionNode(), null, "SchedulingConditionExpression1", null, 1, 1, SchedulingConditionExpressionOrNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSchedulingConditionExpressionOrNode_SchedulingConditionExpression2(), this.getSchedulingConditionExpressionNode(), null, "SchedulingConditionExpression2", null, 1, 1, SchedulingConditionExpressionOrNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scheduleImmediatelyEClass, ScheduleImmediately.class, "ScheduleImmediately", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getScheduleImmediately_Before(), ecorePackage.getEDouble(), "Before", null, 0, 1, ScheduleImmediately.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScheduleImmediately_After(), ecorePackage.getEDouble(), "After", null, 0, 1, ScheduleImmediately.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scheduleAtTimeEClass, ScheduleAtTime.class, "ScheduleAtTime", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getScheduleAtTime_Time(), ecorePackage.getEDouble(), "Time", null, 1, 1, ScheduleAtTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(schedulePeriodicEClass, SchedulePeriodic.class, "SchedulePeriodic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSchedulePeriodic_Before(), ecorePackage.getEDouble(), "Before", null, 0, 1, SchedulePeriodic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSchedulePeriodic_After(), ecorePackage.getEDouble(), "After", null, 0, 1, SchedulePeriodic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSchedulePeriodic_Distribution(), this.getDistribution(), null, "Distribution", null, 1, 1, SchedulePeriodic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(confidenceKindEnumEEnum, ConfidenceKindEnum.class, "ConfidenceKindEnum");
		addEEnumLiteral(confidenceKindEnumEEnum, ConfidenceKindEnum.RELATIVE);
		addEEnumLiteral(confidenceKindEnumEEnum, ConfidenceKindEnum.ABSOLUTE);

		initEEnum(failureDomainEEnum, FailureDomain.class, "FailureDomain");
		addEEnumLiteral(failureDomainEEnum, FailureDomain.CONTENT);
		addEEnumLiteral(failureDomainEEnum, FailureDomain.EARLY_TIMING);
		addEEnumLiteral(failureDomainEEnum, FailureDomain.LATE_TIMING);
		addEEnumLiteral(failureDomainEEnum, FailureDomain.HALT);
		addEEnumLiteral(failureDomainEEnum, FailureDomain.ERRATIC);

		initEEnum(failureDetectabilityEEnum, FailureDetectability.class, "FailureDetectability");
		addEEnumLiteral(failureDetectabilityEEnum, FailureDetectability.SIGNALED);
		addEEnumLiteral(failureDetectabilityEEnum, FailureDetectability.UNSIGNALED);

		initEEnum(failureConsequencesEEnum, FailureConsequences.class, "FailureConsequences");
		addEEnumLiteral(failureConsequencesEEnum, FailureConsequences.INSIGNIFICANT);
		addEEnumLiteral(failureConsequencesEEnum, FailureConsequences.MARGINAL);
		addEEnumLiteral(failureConsequencesEEnum, FailureConsequences.CRITICAL);
		addEEnumLiteral(failureConsequencesEEnum, FailureConsequences.CATASTROPHIC);

		initEEnum(failureConsistencyEEnum, FailureConsistency.class, "FailureConsistency");
		addEEnumLiteral(failureConsistencyEEnum, FailureConsistency.CONSISTENT);
		addEEnumLiteral(failureConsistencyEEnum, FailureConsistency.INCONSISTENT);

		// Create resource
		createResource(eNS_URI);
	}

} //DependabilityintermediateModelPackageImpl
