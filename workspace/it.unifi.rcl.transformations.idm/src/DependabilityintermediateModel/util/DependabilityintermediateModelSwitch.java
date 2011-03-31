/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel.util;

import DependabilityintermediateModel.Activity;
import DependabilityintermediateModel.Availability;
import DependabilityintermediateModel.Component;
import DependabilityintermediateModel.DependabilityMeasure;
import DependabilityintermediateModel.DependabilityintermediateModelPackage;
import DependabilityintermediateModel.DetectionActivity;
import DependabilityintermediateModel.Deterministic;
import DependabilityintermediateModel.Distribution;
import DependabilityintermediateModel.ErrorPropagation;
import DependabilityintermediateModel.ErrorsExpressionAndNode;
import DependabilityintermediateModel.ErrorsExpressionErrorNode;
import DependabilityintermediateModel.ErrorsExpressionNode;
import DependabilityintermediateModel.ErrorsExpressionNotNode;
import DependabilityintermediateModel.ErrorsExpressionOrNode;
import DependabilityintermediateModel.ErrorsProducesFailures;
import DependabilityintermediateModel.EvaluationType;
import DependabilityintermediateModel.Exponential;
import DependabilityintermediateModel.ExternalFault;
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
import DependabilityintermediateModel.InstantOfTime;
import DependabilityintermediateModel.InternalFault;
import DependabilityintermediateModel.InternalPropagation;
import DependabilityintermediateModel.IntervalOfTime;
import DependabilityintermediateModel.MaintenanceActivity;
import DependabilityintermediateModel.NamedElement;
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
import DependabilityintermediateModel.SchedulingConditionExpressionNode;
import DependabilityintermediateModel.SchedulingConditionExpressionNotNode;
import DependabilityintermediateModel.SchedulingConditionExpressionOrNode;
import DependabilityintermediateModel.SchedulingConditionExpressionTrueNode;
import DependabilityintermediateModel.SchedulingEvent;
import DependabilityintermediateModel.Sistema;
import DependabilityintermediateModel.SteadyState;
import DependabilityintermediateModel.Threat;
import DependabilityintermediateModel.Uniform;
import DependabilityintermediateModel.Weibull;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage
 * @generated
 */
public class DependabilityintermediateModelSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DependabilityintermediateModelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependabilityintermediateModelSwitch() {
		if (modelPackage == null) {
			modelPackage = DependabilityintermediateModelPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case DependabilityintermediateModelPackage.SISTEMA: {
				Sistema sistema = (Sistema)theEObject;
				T result = caseSistema(sistema);
				if (result == null) result = caseNamedElement(sistema);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.COMPONENT: {
				Component component = (Component)theEObject;
				T result = caseComponent(component);
				if (result == null) result = caseNamedElement(component);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.THREAT: {
				Threat threat = (Threat)theEObject;
				T result = caseThreat(threat);
				if (result == null) result = caseNamedElement(threat);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.FAULT: {
				Fault fault = (Fault)theEObject;
				T result = caseFault(fault);
				if (result == null) result = caseThreat(fault);
				if (result == null) result = caseNamedElement(fault);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.INTERNAL_FAULT: {
				InternalFault internalFault = (InternalFault)theEObject;
				T result = caseInternalFault(internalFault);
				if (result == null) result = caseFault(internalFault);
				if (result == null) result = caseThreat(internalFault);
				if (result == null) result = caseNamedElement(internalFault);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.EXTERNAL_FAULT: {
				ExternalFault externalFault = (ExternalFault)theEObject;
				T result = caseExternalFault(externalFault);
				if (result == null) result = caseFault(externalFault);
				if (result == null) result = caseThreat(externalFault);
				if (result == null) result = caseNamedElement(externalFault);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.ERROR: {
				DependabilityintermediateModel.Error error = (DependabilityintermediateModel.Error)theEObject;
				T result = caseError(error);
				if (result == null) result = caseThreat(error);
				if (result == null) result = caseNamedElement(error);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.NAMED_ELEMENT: {
				NamedElement namedElement = (NamedElement)theEObject;
				T result = caseNamedElement(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.DISTRIBUTION: {
				Distribution distribution = (Distribution)theEObject;
				T result = caseDistribution(distribution);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.EXPONENTIAL: {
				Exponential exponential = (Exponential)theEObject;
				T result = caseExponential(exponential);
				if (result == null) result = caseDistribution(exponential);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.GAUSSIAN: {
				Gaussian gaussian = (Gaussian)theEObject;
				T result = caseGaussian(gaussian);
				if (result == null) result = caseDistribution(gaussian);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.DETERMINISTIC: {
				Deterministic deterministic = (Deterministic)theEObject;
				T result = caseDeterministic(deterministic);
				if (result == null) result = caseDistribution(deterministic);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.UNIFORM: {
				Uniform uniform = (Uniform)theEObject;
				T result = caseUniform(uniform);
				if (result == null) result = caseDistribution(uniform);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.GAMMA: {
				Gamma gamma = (Gamma)theEObject;
				T result = caseGamma(gamma);
				if (result == null) result = caseDistribution(gamma);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.WEIBULL: {
				Weibull weibull = (Weibull)theEObject;
				T result = caseWeibull(weibull);
				if (result == null) result = caseDistribution(weibull);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.FAILURE_MODE: {
				FailureMode failureMode = (FailureMode)theEObject;
				T result = caseFailureMode(failureMode);
				if (result == null) result = caseThreat(failureMode);
				if (result == null) result = caseNamedElement(failureMode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.FAULTS_EXPRESSION_NODE: {
				FaultsExpressionNode faultsExpressionNode = (FaultsExpressionNode)theEObject;
				T result = caseFaultsExpressionNode(faultsExpressionNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.FAULTS_EXPRESSION_AND_NODE: {
				FaultsExpressionAndNode faultsExpressionAndNode = (FaultsExpressionAndNode)theEObject;
				T result = caseFaultsExpressionAndNode(faultsExpressionAndNode);
				if (result == null) result = caseFaultsExpressionNode(faultsExpressionAndNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.FAULTS_EXPRESSION_OR_NODE: {
				FaultsExpressionOrNode faultsExpressionOrNode = (FaultsExpressionOrNode)theEObject;
				T result = caseFaultsExpressionOrNode(faultsExpressionOrNode);
				if (result == null) result = caseFaultsExpressionNode(faultsExpressionOrNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.FAULTS_EXPRESSION_FAULT_NODE: {
				FaultsExpressionFaultNode faultsExpressionFaultNode = (FaultsExpressionFaultNode)theEObject;
				T result = caseFaultsExpressionFaultNode(faultsExpressionFaultNode);
				if (result == null) result = caseFaultsExpressionNode(faultsExpressionFaultNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.FAULTS_EXPRESSION_NOT_NODE: {
				FaultsExpressionNotNode faultsExpressionNotNode = (FaultsExpressionNotNode)theEObject;
				T result = caseFaultsExpressionNotNode(faultsExpressionNotNode);
				if (result == null) result = caseFaultsExpressionNode(faultsExpressionNotNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.ERRORS_EXPRESSION_NODE: {
				ErrorsExpressionNode errorsExpressionNode = (ErrorsExpressionNode)theEObject;
				T result = caseErrorsExpressionNode(errorsExpressionNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.ERRORS_EXPRESSION_ERROR_NODE: {
				ErrorsExpressionErrorNode errorsExpressionErrorNode = (ErrorsExpressionErrorNode)theEObject;
				T result = caseErrorsExpressionErrorNode(errorsExpressionErrorNode);
				if (result == null) result = caseErrorsExpressionNode(errorsExpressionErrorNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.ERRORS_EXPRESSION_NOT_NODE: {
				ErrorsExpressionNotNode errorsExpressionNotNode = (ErrorsExpressionNotNode)theEObject;
				T result = caseErrorsExpressionNotNode(errorsExpressionNotNode);
				if (result == null) result = caseErrorsExpressionNode(errorsExpressionNotNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.ERRORS_EXPRESSION_AND_NODE: {
				ErrorsExpressionAndNode errorsExpressionAndNode = (ErrorsExpressionAndNode)theEObject;
				T result = caseErrorsExpressionAndNode(errorsExpressionAndNode);
				if (result == null) result = caseErrorsExpressionNode(errorsExpressionAndNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.ERRORS_EXPRESSION_OR_NODE: {
				ErrorsExpressionOrNode errorsExpressionOrNode = (ErrorsExpressionOrNode)theEObject;
				T result = caseErrorsExpressionOrNode(errorsExpressionOrNode);
				if (result == null) result = caseErrorsExpressionNode(errorsExpressionOrNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.FAULTS_GENERATE_ERRORS: {
				FaultsGenerateErrors faultsGenerateErrors = (FaultsGenerateErrors)theEObject;
				T result = caseFaultsGenerateErrors(faultsGenerateErrors);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.INTERNAL_PROPAGATION: {
				InternalPropagation internalPropagation = (InternalPropagation)theEObject;
				T result = caseInternalPropagation(internalPropagation);
				if (result == null) result = caseErrorPropagation(internalPropagation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.ERROR_PROPAGATION: {
				ErrorPropagation errorPropagation = (ErrorPropagation)theEObject;
				T result = caseErrorPropagation(errorPropagation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.ERRORS_PRODUCES_FAILURES: {
				ErrorsProducesFailures errorsProducesFailures = (ErrorsProducesFailures)theEObject;
				T result = caseErrorsProducesFailures(errorsProducesFailures);
				if (result == null) result = caseErrorPropagation(errorsProducesFailures);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.ACTIVITY: {
				Activity activity = (Activity)theEObject;
				T result = caseActivity(activity);
				if (result == null) result = caseNamedElement(activity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.MAINTENANCE_ACTIVITY: {
				MaintenanceActivity maintenanceActivity = (MaintenanceActivity)theEObject;
				T result = caseMaintenanceActivity(maintenanceActivity);
				if (result == null) result = caseActivity(maintenanceActivity);
				if (result == null) result = caseNamedElement(maintenanceActivity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.REPAIR_ACTIVITY: {
				RepairActivity repairActivity = (RepairActivity)theEObject;
				T result = caseRepairActivity(repairActivity);
				if (result == null) result = caseMaintenanceActivity(repairActivity);
				if (result == null) result = caseActivity(repairActivity);
				if (result == null) result = caseNamedElement(repairActivity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.REPLACE_ACTIVITY: {
				ReplaceActivity replaceActivity = (ReplaceActivity)theEObject;
				T result = caseReplaceActivity(replaceActivity);
				if (result == null) result = caseMaintenanceActivity(replaceActivity);
				if (result == null) result = caseActivity(replaceActivity);
				if (result == null) result = caseNamedElement(replaceActivity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.DETECTION_ACTIVITY: {
				DetectionActivity detectionActivity = (DetectionActivity)theEObject;
				T result = caseDetectionActivity(detectionActivity);
				if (result == null) result = caseActivity(detectionActivity);
				if (result == null) result = caseNamedElement(detectionActivity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.SCHEDULING_EVENT: {
				SchedulingEvent schedulingEvent = (SchedulingEvent)theEObject;
				T result = caseSchedulingEvent(schedulingEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.SCHEDULING_CONDITION_EXPRESSION_NODE: {
				SchedulingConditionExpressionNode schedulingConditionExpressionNode = (SchedulingConditionExpressionNode)theEObject;
				T result = caseSchedulingConditionExpressionNode(schedulingConditionExpressionNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.SCHEDULING_CONDITION_EXPRESSION_DETECTION_NODE: {
				SchedulingConditionExpressionDetectionNode schedulingConditionExpressionDetectionNode = (SchedulingConditionExpressionDetectionNode)theEObject;
				T result = caseSchedulingConditionExpressionDetectionNode(schedulingConditionExpressionDetectionNode);
				if (result == null) result = caseSchedulingConditionExpressionNode(schedulingConditionExpressionDetectionNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.SCHEDULING_CONDITION_EXPRESSION_FAILED_NODE: {
				SchedulingConditionExpressionFailedNode schedulingConditionExpressionFailedNode = (SchedulingConditionExpressionFailedNode)theEObject;
				T result = caseSchedulingConditionExpressionFailedNode(schedulingConditionExpressionFailedNode);
				if (result == null) result = caseSchedulingConditionExpressionNode(schedulingConditionExpressionFailedNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.SCHEDULING_CONDITION_EXPRESSION_NOT_NODE: {
				SchedulingConditionExpressionNotNode schedulingConditionExpressionNotNode = (SchedulingConditionExpressionNotNode)theEObject;
				T result = caseSchedulingConditionExpressionNotNode(schedulingConditionExpressionNotNode);
				if (result == null) result = caseSchedulingConditionExpressionNode(schedulingConditionExpressionNotNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.SCHEDULING_CONDITION_EXPRESSION_TRUE_NODE: {
				SchedulingConditionExpressionTrueNode schedulingConditionExpressionTrueNode = (SchedulingConditionExpressionTrueNode)theEObject;
				T result = caseSchedulingConditionExpressionTrueNode(schedulingConditionExpressionTrueNode);
				if (result == null) result = caseSchedulingConditionExpressionNode(schedulingConditionExpressionTrueNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.SCHEDULING_CONDITION_EXPRESSION_AND_NODE: {
				SchedulingConditionExpressionAndNode schedulingConditionExpressionAndNode = (SchedulingConditionExpressionAndNode)theEObject;
				T result = caseSchedulingConditionExpressionAndNode(schedulingConditionExpressionAndNode);
				if (result == null) result = caseSchedulingConditionExpressionNode(schedulingConditionExpressionAndNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.SCHEDULING_CONDITION_EXPRESSION_OR_NODE: {
				SchedulingConditionExpressionOrNode schedulingConditionExpressionOrNode = (SchedulingConditionExpressionOrNode)theEObject;
				T result = caseSchedulingConditionExpressionOrNode(schedulingConditionExpressionOrNode);
				if (result == null) result = caseSchedulingConditionExpressionNode(schedulingConditionExpressionOrNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.SCHEDULE_IMMEDIATELY: {
				ScheduleImmediately scheduleImmediately = (ScheduleImmediately)theEObject;
				T result = caseScheduleImmediately(scheduleImmediately);
				if (result == null) result = caseSchedulingEvent(scheduleImmediately);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.SCHEDULE_AT_TIME: {
				ScheduleAtTime scheduleAtTime = (ScheduleAtTime)theEObject;
				T result = caseScheduleAtTime(scheduleAtTime);
				if (result == null) result = caseSchedulingEvent(scheduleAtTime);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.SCHEDULE_PERIODIC: {
				SchedulePeriodic schedulePeriodic = (SchedulePeriodic)theEObject;
				T result = caseSchedulePeriodic(schedulePeriodic);
				if (result == null) result = caseSchedulingEvent(schedulePeriodic);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.DEPENDABILITY_MEASURE: {
				DependabilityMeasure dependabilityMeasure = (DependabilityMeasure)theEObject;
				T result = caseDependabilityMeasure(dependabilityMeasure);
				if (result == null) result = caseNamedElement(dependabilityMeasure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.EVALUATION_TYPE: {
				EvaluationType evaluationType = (EvaluationType)theEObject;
				T result = caseEvaluationType(evaluationType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.STEADY_STATE: {
				SteadyState steadyState = (SteadyState)theEObject;
				T result = caseSteadyState(steadyState);
				if (result == null) result = caseEvaluationType(steadyState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.INSTANT_OF_TIME: {
				InstantOfTime instantOfTime = (InstantOfTime)theEObject;
				T result = caseInstantOfTime(instantOfTime);
				if (result == null) result = caseEvaluationType(instantOfTime);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.INTERVAL_OF_TIME: {
				IntervalOfTime intervalOfTime = (IntervalOfTime)theEObject;
				T result = caseIntervalOfTime(intervalOfTime);
				if (result == null) result = caseEvaluationType(intervalOfTime);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.RELIABILITY: {
				Reliability reliability = (Reliability)theEObject;
				T result = caseReliability(reliability);
				if (result == null) result = caseDependabilityMeasure(reliability);
				if (result == null) result = caseNamedElement(reliability);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.AVAILABILITY: {
				Availability availability = (Availability)theEObject;
				T result = caseAvailability(availability);
				if (result == null) result = caseDependabilityMeasure(availability);
				if (result == null) result = caseNamedElement(availability);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DependabilityintermediateModelPackage.SAFETY: {
				Safety safety = (Safety)theEObject;
				T result = caseSafety(safety);
				if (result == null) result = caseDependabilityMeasure(safety);
				if (result == null) result = caseNamedElement(safety);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sistema</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sistema</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSistema(Sistema object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponent(Component object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Threat</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Threat</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThreat(Threat object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fault</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fault</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFault(Fault object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Internal Fault</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Internal Fault</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInternalFault(InternalFault object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>External Fault</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Fault</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExternalFault(ExternalFault object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Error</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Error</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseError(DependabilityintermediateModel.Error object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Distribution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Distribution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDistribution(Distribution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exponential</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exponential</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExponential(Exponential object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gaussian</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gaussian</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGaussian(Gaussian object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deterministic</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deterministic</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeterministic(Deterministic object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Uniform</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Uniform</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUniform(Uniform object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gamma</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gamma</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGamma(Gamma object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Weibull</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Weibull</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWeibull(Weibull object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Failure Mode</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Failure Mode</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFailureMode(FailureMode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Faults Expression Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Faults Expression Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFaultsExpressionNode(FaultsExpressionNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Faults Expression And Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Faults Expression And Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFaultsExpressionAndNode(FaultsExpressionAndNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Faults Expression Or Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Faults Expression Or Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFaultsExpressionOrNode(FaultsExpressionOrNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Faults Expression Fault Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Faults Expression Fault Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFaultsExpressionFaultNode(FaultsExpressionFaultNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Faults Expression Not Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Faults Expression Not Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFaultsExpressionNotNode(FaultsExpressionNotNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Errors Expression Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Errors Expression Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseErrorsExpressionNode(ErrorsExpressionNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Errors Expression Error Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Errors Expression Error Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseErrorsExpressionErrorNode(ErrorsExpressionErrorNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Errors Expression Not Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Errors Expression Not Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseErrorsExpressionNotNode(ErrorsExpressionNotNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Errors Expression And Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Errors Expression And Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseErrorsExpressionAndNode(ErrorsExpressionAndNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Errors Expression Or Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Errors Expression Or Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseErrorsExpressionOrNode(ErrorsExpressionOrNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Faults Generate Errors</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Faults Generate Errors</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFaultsGenerateErrors(FaultsGenerateErrors object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Internal Propagation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Internal Propagation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInternalPropagation(InternalPropagation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Error Propagation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Error Propagation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseErrorPropagation(ErrorPropagation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Errors Produces Failures</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Errors Produces Failures</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseErrorsProducesFailures(ErrorsProducesFailures object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivity(Activity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Maintenance Activity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Maintenance Activity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMaintenanceActivity(MaintenanceActivity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Repair Activity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Repair Activity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRepairActivity(RepairActivity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Replace Activity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Replace Activity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReplaceActivity(ReplaceActivity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Detection Activity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Detection Activity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDetectionActivity(DetectionActivity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scheduling Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scheduling Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSchedulingEvent(SchedulingEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scheduling Condition Expression Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scheduling Condition Expression Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSchedulingConditionExpressionNode(SchedulingConditionExpressionNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scheduling Condition Expression Detection Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scheduling Condition Expression Detection Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSchedulingConditionExpressionDetectionNode(SchedulingConditionExpressionDetectionNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scheduling Condition Expression Failed Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scheduling Condition Expression Failed Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSchedulingConditionExpressionFailedNode(SchedulingConditionExpressionFailedNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scheduling Condition Expression Not Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scheduling Condition Expression Not Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSchedulingConditionExpressionNotNode(SchedulingConditionExpressionNotNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scheduling Condition Expression True Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scheduling Condition Expression True Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSchedulingConditionExpressionTrueNode(SchedulingConditionExpressionTrueNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scheduling Condition Expression And Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scheduling Condition Expression And Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSchedulingConditionExpressionAndNode(SchedulingConditionExpressionAndNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scheduling Condition Expression Or Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scheduling Condition Expression Or Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSchedulingConditionExpressionOrNode(SchedulingConditionExpressionOrNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Schedule Immediately</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Schedule Immediately</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScheduleImmediately(ScheduleImmediately object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Schedule At Time</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Schedule At Time</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScheduleAtTime(ScheduleAtTime object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Schedule Periodic</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Schedule Periodic</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSchedulePeriodic(SchedulePeriodic object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dependability Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dependability Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDependabilityMeasure(DependabilityMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Evaluation Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Evaluation Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvaluationType(EvaluationType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Steady State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Steady State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSteadyState(SteadyState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instant Of Time</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instant Of Time</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstantOfTime(InstantOfTime object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interval Of Time</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interval Of Time</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntervalOfTime(IntervalOfTime object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reliability</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reliability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReliability(Reliability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Availability</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Availability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAvailability(Availability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Safety</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Safety</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSafety(Safety object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //DependabilityintermediateModelSwitch
