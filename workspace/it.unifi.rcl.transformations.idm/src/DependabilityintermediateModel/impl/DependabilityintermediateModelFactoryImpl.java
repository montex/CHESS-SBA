/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel.impl;

import DependabilityintermediateModel.Availability;
import DependabilityintermediateModel.Component;
import DependabilityintermediateModel.DependabilityMeasure;
import DependabilityintermediateModel.DependabilityintermediateModelFactory;
import DependabilityintermediateModel.DependabilityintermediateModelPackage;
import DependabilityintermediateModel.DetectionActivity;
import DependabilityintermediateModel.Deterministic;
import DependabilityintermediateModel.ErrorPropagation;
import DependabilityintermediateModel.ErrorsExpressionAndNode;
import DependabilityintermediateModel.ErrorsExpressionErrorNode;
import DependabilityintermediateModel.ErrorsExpressionNotNode;
import DependabilityintermediateModel.ErrorsExpressionOrNode;
import DependabilityintermediateModel.ErrorsProducesFailures;
import DependabilityintermediateModel.Exponential;
import DependabilityintermediateModel.ExternalFault;
import DependabilityintermediateModel.FailureConsequences;
import DependabilityintermediateModel.FailureConsistency;
import DependabilityintermediateModel.FailureDetectability;
import DependabilityintermediateModel.FailureDomain;
import DependabilityintermediateModel.FailureMode;
import DependabilityintermediateModel.FaultsExpressionAndNode;
import DependabilityintermediateModel.FaultsExpressionFaultNode;
import DependabilityintermediateModel.FaultsExpressionNotNode;
import DependabilityintermediateModel.FaultsExpressionOrNode;
import DependabilityintermediateModel.FaultsGenerateErrors;
import DependabilityintermediateModel.Gamma;
import DependabilityintermediateModel.Gaussian;
import DependabilityintermediateModel.InstantOfTime;
import DependabilityintermediateModel.InternalFault;
import DependabilityintermediateModel.InternalPropagation;
import DependabilityintermediateModel.IntervalOfTime;
import DependabilityintermediateModel.MaintenanceActivity;
import DependabilityintermediateModel.Reliability;
import DependabilityintermediateModel.RepairActivity;
import DependabilityintermediateModel.ReplaceActivity;
import DependabilityintermediateModel.Safety;
import DependabilityintermediateModel.ScheduleAtTime;
import DependabilityintermediateModel.ScheduleImmediately;
import DependabilityintermediateModel.SchedulePeriodic;
import DependabilityintermediateModel.SchedulingConditionExpressionAndNode;
import DependabilityintermediateModel.SchedulingConditionExpressionDetectionNode;
import DependabilityintermediateModel.SchedulingConditionExpressionFailedNode;
import DependabilityintermediateModel.SchedulingConditionExpressionNotNode;
import DependabilityintermediateModel.SchedulingConditionExpressionOrNode;
import DependabilityintermediateModel.SchedulingConditionExpressionTrueNode;
import DependabilityintermediateModel.Sistema;
import DependabilityintermediateModel.SteadyState;
import DependabilityintermediateModel.Uniform;
import DependabilityintermediateModel.Weibull;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DependabilityintermediateModelFactoryImpl extends EFactoryImpl implements DependabilityintermediateModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DependabilityintermediateModelFactory init() {
		try {
			DependabilityintermediateModelFactory theDependabilityintermediateModelFactory = (DependabilityintermediateModelFactory)EPackage.Registry.INSTANCE.getEFactory("http://if.dsi.unifi.it/Modeling/DIM"); 
			if (theDependabilityintermediateModelFactory != null) {
				return theDependabilityintermediateModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DependabilityintermediateModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependabilityintermediateModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DependabilityintermediateModelPackage.SISTEMA: return createSistema();
			case DependabilityintermediateModelPackage.COMPONENT: return createComponent();
			case DependabilityintermediateModelPackage.INTERNAL_FAULT: return createInternalFault();
			case DependabilityintermediateModelPackage.EXTERNAL_FAULT: return createExternalFault();
			case DependabilityintermediateModelPackage.ERROR: return createError();
			case DependabilityintermediateModelPackage.EXPONENTIAL: return createExponential();
			case DependabilityintermediateModelPackage.GAUSSIAN: return createGaussian();
			case DependabilityintermediateModelPackage.DETERMINISTIC: return createDeterministic();
			case DependabilityintermediateModelPackage.UNIFORM: return createUniform();
			case DependabilityintermediateModelPackage.GAMMA: return createGamma();
			case DependabilityintermediateModelPackage.WEIBULL: return createWeibull();
			case DependabilityintermediateModelPackage.FAILURE_MODE: return createFailureMode();
			case DependabilityintermediateModelPackage.FAULTS_EXPRESSION_AND_NODE: return createFaultsExpressionAndNode();
			case DependabilityintermediateModelPackage.FAULTS_EXPRESSION_OR_NODE: return createFaultsExpressionOrNode();
			case DependabilityintermediateModelPackage.FAULTS_EXPRESSION_FAULT_NODE: return createFaultsExpressionFaultNode();
			case DependabilityintermediateModelPackage.FAULTS_EXPRESSION_NOT_NODE: return createFaultsExpressionNotNode();
			case DependabilityintermediateModelPackage.ERRORS_EXPRESSION_ERROR_NODE: return createErrorsExpressionErrorNode();
			case DependabilityintermediateModelPackage.ERRORS_EXPRESSION_NOT_NODE: return createErrorsExpressionNotNode();
			case DependabilityintermediateModelPackage.ERRORS_EXPRESSION_AND_NODE: return createErrorsExpressionAndNode();
			case DependabilityintermediateModelPackage.ERRORS_EXPRESSION_OR_NODE: return createErrorsExpressionOrNode();
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS: return createFaultsGenerateErrors();
			case DependabilityintermediateModelPackage.INTERNAL_PROPAGATION: return createInternalPropagation();
			case DependabilityintermediateModelPackage.ERROR_PROPAGATION: return createErrorPropagation();
			case DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES: return createErrorsProducesFailures();
			case DependabilityintermediateModelPackage.MAINTENANCE_ACTIVITY: return createMaintenanceActivity();
			case DependabilityintermediateModelPackage.REPAIR_ACTIVITY: return createRepairActivity();
			case DependabilityintermediateModelPackage.REPLACE_ACTIVITY: return createReplaceActivity();
			case DependabilityintermediateModelPackage.DETECTION_ACTIVITY: return createDetectionActivity();
			case DependabilityintermediateModelPackage.SCHEDULING_CONDITION_EXPRESSION_DETECTION_NODE: return createSchedulingConditionExpressionDetectionNode();
			case DependabilityintermediateModelPackage.SCHEDULING_CONDITION_EXPRESSION_FAILED_NODE: return createSchedulingConditionExpressionFailedNode();
			case DependabilityintermediateModelPackage.SCHEDULING_CONDITION_EXPRESSION_NOT_NODE: return createSchedulingConditionExpressionNotNode();
			case DependabilityintermediateModelPackage.SCHEDULING_CONDITION_EXPRESSION_TRUE_NODE: return createSchedulingConditionExpressionTrueNode();
			case DependabilityintermediateModelPackage.SCHEDULING_CONDITION_EXPRESSION_AND_NODE: return createSchedulingConditionExpressionAndNode();
			case DependabilityintermediateModelPackage.SCHEDULING_CONDITION_EXPRESSION_OR_NODE: return createSchedulingConditionExpressionOrNode();
			case DependabilityintermediateModelPackage.SCHEDULE_IMMEDIATELY: return createScheduleImmediately();
			case DependabilityintermediateModelPackage.SCHEDULE_AT_TIME: return createScheduleAtTime();
			case DependabilityintermediateModelPackage.SCHEDULE_PERIODIC: return createSchedulePeriodic();
			case DependabilityintermediateModelPackage.DEPENDABILITY_MEASURE: return createDependabilityMeasure();
			case DependabilityintermediateModelPackage.STEADY_STATE: return createSteadyState();
			case DependabilityintermediateModelPackage.INSTANT_OF_TIME: return createInstantOfTime();
			case DependabilityintermediateModelPackage.INTERVAL_OF_TIME: return createIntervalOfTime();
			case DependabilityintermediateModelPackage.RELIABILITY: return createReliability();
			case DependabilityintermediateModelPackage.AVAILABILITY: return createAvailability();
			case DependabilityintermediateModelPackage.SAFETY: return createSafety();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case DependabilityintermediateModelPackage.FAILURE_DOMAIN:
				return createFailureDomainFromString(eDataType, initialValue);
			case DependabilityintermediateModelPackage.FAILURE_DETECTABILITY:
				return createFailureDetectabilityFromString(eDataType, initialValue);
			case DependabilityintermediateModelPackage.FAILURE_CONSEQUENCES:
				return createFailureConsequencesFromString(eDataType, initialValue);
			case DependabilityintermediateModelPackage.FAILURE_CONSISTENCY:
				return createFailureConsistencyFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case DependabilityintermediateModelPackage.FAILURE_DOMAIN:
				return convertFailureDomainToString(eDataType, instanceValue);
			case DependabilityintermediateModelPackage.FAILURE_DETECTABILITY:
				return convertFailureDetectabilityToString(eDataType, instanceValue);
			case DependabilityintermediateModelPackage.FAILURE_CONSEQUENCES:
				return convertFailureConsequencesToString(eDataType, instanceValue);
			case DependabilityintermediateModelPackage.FAILURE_CONSISTENCY:
				return convertFailureConsistencyToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sistema createSistema() {
		SistemaImpl sistema = new SistemaImpl();
		return sistema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component createComponent() {
		ComponentImpl component = new ComponentImpl();
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalFault createInternalFault() {
		InternalFaultImpl internalFault = new InternalFaultImpl();
		return internalFault;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalFault createExternalFault() {
		ExternalFaultImpl externalFault = new ExternalFaultImpl();
		return externalFault;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependabilityintermediateModel.Error createError() {
		ErrorImpl error = new ErrorImpl();
		return error;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Exponential createExponential() {
		ExponentialImpl exponential = new ExponentialImpl();
		return exponential;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gaussian createGaussian() {
		GaussianImpl gaussian = new GaussianImpl();
		return gaussian;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Deterministic createDeterministic() {
		DeterministicImpl deterministic = new DeterministicImpl();
		return deterministic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Uniform createUniform() {
		UniformImpl uniform = new UniformImpl();
		return uniform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gamma createGamma() {
		GammaImpl gamma = new GammaImpl();
		return gamma;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Weibull createWeibull() {
		WeibullImpl weibull = new WeibullImpl();
		return weibull;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FailureMode createFailureMode() {
		FailureModeImpl failureMode = new FailureModeImpl();
		return failureMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultsExpressionAndNode createFaultsExpressionAndNode() {
		FaultsExpressionAndNodeImpl faultsExpressionAndNode = new FaultsExpressionAndNodeImpl();
		return faultsExpressionAndNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultsExpressionOrNode createFaultsExpressionOrNode() {
		FaultsExpressionOrNodeImpl faultsExpressionOrNode = new FaultsExpressionOrNodeImpl();
		return faultsExpressionOrNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultsExpressionFaultNode createFaultsExpressionFaultNode() {
		FaultsExpressionFaultNodeImpl faultsExpressionFaultNode = new FaultsExpressionFaultNodeImpl();
		return faultsExpressionFaultNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultsExpressionNotNode createFaultsExpressionNotNode() {
		FaultsExpressionNotNodeImpl faultsExpressionNotNode = new FaultsExpressionNotNodeImpl();
		return faultsExpressionNotNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorsExpressionErrorNode createErrorsExpressionErrorNode() {
		ErrorsExpressionErrorNodeImpl errorsExpressionErrorNode = new ErrorsExpressionErrorNodeImpl();
		return errorsExpressionErrorNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorsExpressionNotNode createErrorsExpressionNotNode() {
		ErrorsExpressionNotNodeImpl errorsExpressionNotNode = new ErrorsExpressionNotNodeImpl();
		return errorsExpressionNotNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorsExpressionAndNode createErrorsExpressionAndNode() {
		ErrorsExpressionAndNodeImpl errorsExpressionAndNode = new ErrorsExpressionAndNodeImpl();
		return errorsExpressionAndNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorsExpressionOrNode createErrorsExpressionOrNode() {
		ErrorsExpressionOrNodeImpl errorsExpressionOrNode = new ErrorsExpressionOrNodeImpl();
		return errorsExpressionOrNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultsGenerateErrors createFaultsGenerateErrors() {
		FaultsGenerateErrorsImpl faultsGenerateErrors = new FaultsGenerateErrorsImpl();
		return faultsGenerateErrors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalPropagation createInternalPropagation() {
		InternalPropagationImpl internalPropagation = new InternalPropagationImpl();
		return internalPropagation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorPropagation createErrorPropagation() {
		ErrorPropagationImpl errorPropagation = new ErrorPropagationImpl();
		return errorPropagation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorsProducesFailures createErrorsProducesFailures() {
		ErrorsProducesFailuresImpl errorsProducesFailures = new ErrorsProducesFailuresImpl();
		return errorsProducesFailures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MaintenanceActivity createMaintenanceActivity() {
		MaintenanceActivityImpl maintenanceActivity = new MaintenanceActivityImpl();
		return maintenanceActivity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepairActivity createRepairActivity() {
		RepairActivityImpl repairActivity = new RepairActivityImpl();
		return repairActivity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReplaceActivity createReplaceActivity() {
		ReplaceActivityImpl replaceActivity = new ReplaceActivityImpl();
		return replaceActivity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DetectionActivity createDetectionActivity() {
		DetectionActivityImpl detectionActivity = new DetectionActivityImpl();
		return detectionActivity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingConditionExpressionDetectionNode createSchedulingConditionExpressionDetectionNode() {
		SchedulingConditionExpressionDetectionNodeImpl schedulingConditionExpressionDetectionNode = new SchedulingConditionExpressionDetectionNodeImpl();
		return schedulingConditionExpressionDetectionNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingConditionExpressionFailedNode createSchedulingConditionExpressionFailedNode() {
		SchedulingConditionExpressionFailedNodeImpl schedulingConditionExpressionFailedNode = new SchedulingConditionExpressionFailedNodeImpl();
		return schedulingConditionExpressionFailedNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingConditionExpressionNotNode createSchedulingConditionExpressionNotNode() {
		SchedulingConditionExpressionNotNodeImpl schedulingConditionExpressionNotNode = new SchedulingConditionExpressionNotNodeImpl();
		return schedulingConditionExpressionNotNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingConditionExpressionTrueNode createSchedulingConditionExpressionTrueNode() {
		SchedulingConditionExpressionTrueNodeImpl schedulingConditionExpressionTrueNode = new SchedulingConditionExpressionTrueNodeImpl();
		return schedulingConditionExpressionTrueNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingConditionExpressionAndNode createSchedulingConditionExpressionAndNode() {
		SchedulingConditionExpressionAndNodeImpl schedulingConditionExpressionAndNode = new SchedulingConditionExpressionAndNodeImpl();
		return schedulingConditionExpressionAndNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingConditionExpressionOrNode createSchedulingConditionExpressionOrNode() {
		SchedulingConditionExpressionOrNodeImpl schedulingConditionExpressionOrNode = new SchedulingConditionExpressionOrNodeImpl();
		return schedulingConditionExpressionOrNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScheduleImmediately createScheduleImmediately() {
		ScheduleImmediatelyImpl scheduleImmediately = new ScheduleImmediatelyImpl();
		return scheduleImmediately;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScheduleAtTime createScheduleAtTime() {
		ScheduleAtTimeImpl scheduleAtTime = new ScheduleAtTimeImpl();
		return scheduleAtTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulePeriodic createSchedulePeriodic() {
		SchedulePeriodicImpl schedulePeriodic = new SchedulePeriodicImpl();
		return schedulePeriodic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependabilityMeasure createDependabilityMeasure() {
		DependabilityMeasureImpl dependabilityMeasure = new DependabilityMeasureImpl();
		return dependabilityMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SteadyState createSteadyState() {
		SteadyStateImpl steadyState = new SteadyStateImpl();
		return steadyState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstantOfTime createInstantOfTime() {
		InstantOfTimeImpl instantOfTime = new InstantOfTimeImpl();
		return instantOfTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntervalOfTime createIntervalOfTime() {
		IntervalOfTimeImpl intervalOfTime = new IntervalOfTimeImpl();
		return intervalOfTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reliability createReliability() {
		ReliabilityImpl reliability = new ReliabilityImpl();
		return reliability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Availability createAvailability() {
		AvailabilityImpl availability = new AvailabilityImpl();
		return availability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Safety createSafety() {
		SafetyImpl safety = new SafetyImpl();
		return safety;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FailureDomain createFailureDomainFromString(EDataType eDataType, String initialValue) {
		FailureDomain result = FailureDomain.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFailureDomainToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FailureDetectability createFailureDetectabilityFromString(EDataType eDataType, String initialValue) {
		FailureDetectability result = FailureDetectability.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFailureDetectabilityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FailureConsequences createFailureConsequencesFromString(EDataType eDataType, String initialValue) {
		FailureConsequences result = FailureConsequences.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFailureConsequencesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FailureConsistency createFailureConsistencyFromString(EDataType eDataType, String initialValue) {
		FailureConsistency result = FailureConsistency.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFailureConsistencyToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependabilityintermediateModelPackage getDependabilityintermediateModelPackage() {
		return (DependabilityintermediateModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DependabilityintermediateModelPackage getPackage() {
		return DependabilityintermediateModelPackage.eINSTANCE;
	}

} //DependabilityintermediateModelFactoryImpl
