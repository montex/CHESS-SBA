/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel.util;

import DependabilityintermediateModel.Activity;
import DependabilityintermediateModel.Component;
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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage
 * @generated
 */
public class DependabilityintermediateModelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DependabilityintermediateModelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependabilityintermediateModelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DependabilityintermediateModelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DependabilityintermediateModelSwitch<Adapter> modelSwitch =
		new DependabilityintermediateModelSwitch<Adapter>() {
			@Override
			public Adapter caseSistema(Sistema object) {
				return createSistemaAdapter();
			}
			@Override
			public Adapter caseComponent(Component object) {
				return createComponentAdapter();
			}
			@Override
			public Adapter caseThreat(Threat object) {
				return createThreatAdapter();
			}
			@Override
			public Adapter caseFault(Fault object) {
				return createFaultAdapter();
			}
			@Override
			public Adapter caseInternalFault(InternalFault object) {
				return createInternalFaultAdapter();
			}
			@Override
			public Adapter caseExternalFault(ExternalFault object) {
				return createExternalFaultAdapter();
			}
			@Override
			public Adapter caseError(DependabilityintermediateModel.Error object) {
				return createErrorAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseDistribution(Distribution object) {
				return createDistributionAdapter();
			}
			@Override
			public Adapter caseExponential(Exponential object) {
				return createExponentialAdapter();
			}
			@Override
			public Adapter caseGaussian(Gaussian object) {
				return createGaussianAdapter();
			}
			@Override
			public Adapter caseDeterministic(Deterministic object) {
				return createDeterministicAdapter();
			}
			@Override
			public Adapter caseUniform(Uniform object) {
				return createUniformAdapter();
			}
			@Override
			public Adapter caseGamma(Gamma object) {
				return createGammaAdapter();
			}
			@Override
			public Adapter caseWeibull(Weibull object) {
				return createWeibullAdapter();
			}
			@Override
			public Adapter caseFailureMode(FailureMode object) {
				return createFailureModeAdapter();
			}
			@Override
			public Adapter caseFaultsExpressionNode(FaultsExpressionNode object) {
				return createFaultsExpressionNodeAdapter();
			}
			@Override
			public Adapter caseFaultsExpressionAndNode(FaultsExpressionAndNode object) {
				return createFaultsExpressionAndNodeAdapter();
			}
			@Override
			public Adapter caseFaultsExpressionOrNode(FaultsExpressionOrNode object) {
				return createFaultsExpressionOrNodeAdapter();
			}
			@Override
			public Adapter caseFaultsExpressionFaultNode(FaultsExpressionFaultNode object) {
				return createFaultsExpressionFaultNodeAdapter();
			}
			@Override
			public Adapter caseFaultsExpressionNotNode(FaultsExpressionNotNode object) {
				return createFaultsExpressionNotNodeAdapter();
			}
			@Override
			public Adapter caseErrorsExpressionNode(ErrorsExpressionNode object) {
				return createErrorsExpressionNodeAdapter();
			}
			@Override
			public Adapter caseErrorsExpressionErrorNode(ErrorsExpressionErrorNode object) {
				return createErrorsExpressionErrorNodeAdapter();
			}
			@Override
			public Adapter caseErrorsExpressionNotNode(ErrorsExpressionNotNode object) {
				return createErrorsExpressionNotNodeAdapter();
			}
			@Override
			public Adapter caseErrorsExpressionAndNode(ErrorsExpressionAndNode object) {
				return createErrorsExpressionAndNodeAdapter();
			}
			@Override
			public Adapter caseErrorsExpressionOrNode(ErrorsExpressionOrNode object) {
				return createErrorsExpressionOrNodeAdapter();
			}
			@Override
			public Adapter caseFaultsGenerateErrors(FaultsGenerateErrors object) {
				return createFaultsGenerateErrorsAdapter();
			}
			@Override
			public Adapter caseInternalPropagation(InternalPropagation object) {
				return createInternalPropagationAdapter();
			}
			@Override
			public Adapter caseErrorsPropagation(ErrorsPropagation object) {
				return createErrorsPropagationAdapter();
			}
			@Override
			public Adapter caseErrorsProduceFailures(ErrorsProduceFailures object) {
				return createErrorsProduceFailuresAdapter();
			}
			@Override
			public Adapter caseActivity(Activity object) {
				return createActivityAdapter();
			}
			@Override
			public Adapter caseMaintenanceActivity(MaintenanceActivity object) {
				return createMaintenanceActivityAdapter();
			}
			@Override
			public Adapter caseRepairActivity(RepairActivity object) {
				return createRepairActivityAdapter();
			}
			@Override
			public Adapter caseReplaceActivity(ReplaceActivity object) {
				return createReplaceActivityAdapter();
			}
			@Override
			public Adapter caseDetectionActivity(DetectionActivity object) {
				return createDetectionActivityAdapter();
			}
			@Override
			public Adapter caseSchedulingEvent(SchedulingEvent object) {
				return createSchedulingEventAdapter();
			}
			@Override
			public Adapter caseSchedulingConditionExpressionNode(SchedulingConditionExpressionNode object) {
				return createSchedulingConditionExpressionNodeAdapter();
			}
			@Override
			public Adapter caseSchedulingConditionExpressionDetectionNode(SchedulingConditionExpressionDetectionNode object) {
				return createSchedulingConditionExpressionDetectionNodeAdapter();
			}
			@Override
			public Adapter caseSchedulingConditionExpressionFailedNode(SchedulingConditionExpressionFailedNode object) {
				return createSchedulingConditionExpressionFailedNodeAdapter();
			}
			@Override
			public Adapter caseSchedulingConditionExpressionNotNode(SchedulingConditionExpressionNotNode object) {
				return createSchedulingConditionExpressionNotNodeAdapter();
			}
			@Override
			public Adapter caseSchedulingConditionExpressionTrueNode(SchedulingConditionExpressionTrueNode object) {
				return createSchedulingConditionExpressionTrueNodeAdapter();
			}
			@Override
			public Adapter caseSchedulingConditionExpressionAndNode(SchedulingConditionExpressionAndNode object) {
				return createSchedulingConditionExpressionAndNodeAdapter();
			}
			@Override
			public Adapter caseSchedulingConditionExpressionOrNode(SchedulingConditionExpressionOrNode object) {
				return createSchedulingConditionExpressionOrNodeAdapter();
			}
			@Override
			public Adapter caseScheduleImmediately(ScheduleImmediately object) {
				return createScheduleImmediatelyAdapter();
			}
			@Override
			public Adapter caseScheduleAtTime(ScheduleAtTime object) {
				return createScheduleAtTimeAdapter();
			}
			@Override
			public Adapter caseSchedulePeriodic(SchedulePeriodic object) {
				return createSchedulePeriodicAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.Sistema <em>Sistema</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.Sistema
	 * @generated
	 */
	public Adapter createSistemaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.Component
	 * @generated
	 */
	public Adapter createComponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.Threat <em>Threat</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.Threat
	 * @generated
	 */
	public Adapter createThreatAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.Fault <em>Fault</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.Fault
	 * @generated
	 */
	public Adapter createFaultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.InternalFault <em>Internal Fault</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.InternalFault
	 * @generated
	 */
	public Adapter createInternalFaultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.ExternalFault <em>External Fault</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.ExternalFault
	 * @generated
	 */
	public Adapter createExternalFaultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.Error <em>Error</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.Error
	 * @generated
	 */
	public Adapter createErrorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.Distribution <em>Distribution</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.Distribution
	 * @generated
	 */
	public Adapter createDistributionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.Exponential <em>Exponential</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.Exponential
	 * @generated
	 */
	public Adapter createExponentialAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.Gaussian <em>Gaussian</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.Gaussian
	 * @generated
	 */
	public Adapter createGaussianAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.Deterministic <em>Deterministic</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.Deterministic
	 * @generated
	 */
	public Adapter createDeterministicAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.Uniform <em>Uniform</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.Uniform
	 * @generated
	 */
	public Adapter createUniformAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.Gamma <em>Gamma</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.Gamma
	 * @generated
	 */
	public Adapter createGammaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.Weibull <em>Weibull</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.Weibull
	 * @generated
	 */
	public Adapter createWeibullAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.FailureMode <em>Failure Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.FailureMode
	 * @generated
	 */
	public Adapter createFailureModeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.FaultsExpressionNode <em>Faults Expression Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.FaultsExpressionNode
	 * @generated
	 */
	public Adapter createFaultsExpressionNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.FaultsExpressionAndNode <em>Faults Expression And Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.FaultsExpressionAndNode
	 * @generated
	 */
	public Adapter createFaultsExpressionAndNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.FaultsExpressionOrNode <em>Faults Expression Or Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.FaultsExpressionOrNode
	 * @generated
	 */
	public Adapter createFaultsExpressionOrNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.FaultsExpressionFaultNode <em>Faults Expression Fault Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.FaultsExpressionFaultNode
	 * @generated
	 */
	public Adapter createFaultsExpressionFaultNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.FaultsExpressionNotNode <em>Faults Expression Not Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.FaultsExpressionNotNode
	 * @generated
	 */
	public Adapter createFaultsExpressionNotNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.ErrorsExpressionNode <em>Errors Expression Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.ErrorsExpressionNode
	 * @generated
	 */
	public Adapter createErrorsExpressionNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.ErrorsExpressionErrorNode <em>Errors Expression Error Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.ErrorsExpressionErrorNode
	 * @generated
	 */
	public Adapter createErrorsExpressionErrorNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.ErrorsExpressionNotNode <em>Errors Expression Not Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.ErrorsExpressionNotNode
	 * @generated
	 */
	public Adapter createErrorsExpressionNotNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.ErrorsExpressionAndNode <em>Errors Expression And Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.ErrorsExpressionAndNode
	 * @generated
	 */
	public Adapter createErrorsExpressionAndNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.ErrorsExpressionOrNode <em>Errors Expression Or Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.ErrorsExpressionOrNode
	 * @generated
	 */
	public Adapter createErrorsExpressionOrNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.FaultsGenerateErrors <em>Faults Generate Errors</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.FaultsGenerateErrors
	 * @generated
	 */
	public Adapter createFaultsGenerateErrorsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.InternalPropagation <em>Internal Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.InternalPropagation
	 * @generated
	 */
	public Adapter createInternalPropagationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.ErrorsPropagation <em>Errors Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.ErrorsPropagation
	 * @generated
	 */
	public Adapter createErrorsPropagationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.ErrorsProduceFailures <em>Errors Produce Failures</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.ErrorsProduceFailures
	 * @generated
	 */
	public Adapter createErrorsProduceFailuresAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.Activity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.Activity
	 * @generated
	 */
	public Adapter createActivityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.MaintenanceActivity <em>Maintenance Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.MaintenanceActivity
	 * @generated
	 */
	public Adapter createMaintenanceActivityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.RepairActivity <em>Repair Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.RepairActivity
	 * @generated
	 */
	public Adapter createRepairActivityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.ReplaceActivity <em>Replace Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.ReplaceActivity
	 * @generated
	 */
	public Adapter createReplaceActivityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.DetectionActivity <em>Detection Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.DetectionActivity
	 * @generated
	 */
	public Adapter createDetectionActivityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.SchedulingEvent <em>Scheduling Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.SchedulingEvent
	 * @generated
	 */
	public Adapter createSchedulingEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.SchedulingConditionExpressionNode <em>Scheduling Condition Expression Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.SchedulingConditionExpressionNode
	 * @generated
	 */
	public Adapter createSchedulingConditionExpressionNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.SchedulingConditionExpressionDetectionNode <em>Scheduling Condition Expression Detection Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.SchedulingConditionExpressionDetectionNode
	 * @generated
	 */
	public Adapter createSchedulingConditionExpressionDetectionNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.SchedulingConditionExpressionFailedNode <em>Scheduling Condition Expression Failed Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.SchedulingConditionExpressionFailedNode
	 * @generated
	 */
	public Adapter createSchedulingConditionExpressionFailedNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.SchedulingConditionExpressionNotNode <em>Scheduling Condition Expression Not Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.SchedulingConditionExpressionNotNode
	 * @generated
	 */
	public Adapter createSchedulingConditionExpressionNotNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.SchedulingConditionExpressionTrueNode <em>Scheduling Condition Expression True Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.SchedulingConditionExpressionTrueNode
	 * @generated
	 */
	public Adapter createSchedulingConditionExpressionTrueNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.SchedulingConditionExpressionAndNode <em>Scheduling Condition Expression And Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.SchedulingConditionExpressionAndNode
	 * @generated
	 */
	public Adapter createSchedulingConditionExpressionAndNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.SchedulingConditionExpressionOrNode <em>Scheduling Condition Expression Or Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.SchedulingConditionExpressionOrNode
	 * @generated
	 */
	public Adapter createSchedulingConditionExpressionOrNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.ScheduleImmediately <em>Schedule Immediately</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.ScheduleImmediately
	 * @generated
	 */
	public Adapter createScheduleImmediatelyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.ScheduleAtTime <em>Schedule At Time</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.ScheduleAtTime
	 * @generated
	 */
	public Adapter createScheduleAtTimeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DependabilityintermediateModel.SchedulePeriodic <em>Schedule Periodic</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DependabilityintermediateModel.SchedulePeriodic
	 * @generated
	 */
	public Adapter createSchedulePeriodicAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //DependabilityintermediateModelAdapterFactory
