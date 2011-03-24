/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage
 * @generated
 */
public interface DependabilityintermediateModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DependabilityintermediateModelFactory eINSTANCE = DependabilityintermediateModel.impl.DependabilityintermediateModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Sistema</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sistema</em>'.
	 * @generated
	 */
	Sistema createSistema();

	/**
	 * Returns a new object of class '<em>Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component</em>'.
	 * @generated
	 */
	Component createComponent();

	/**
	 * Returns a new object of class '<em>Internal Fault</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Internal Fault</em>'.
	 * @generated
	 */
	InternalFault createInternalFault();

	/**
	 * Returns a new object of class '<em>External Fault</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>External Fault</em>'.
	 * @generated
	 */
	ExternalFault createExternalFault();

	/**
	 * Returns a new object of class '<em>Error</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Error</em>'.
	 * @generated
	 */
	Error createError();

	/**
	 * Returns a new object of class '<em>Exponential</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exponential</em>'.
	 * @generated
	 */
	Exponential createExponential();

	/**
	 * Returns a new object of class '<em>Gaussian</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gaussian</em>'.
	 * @generated
	 */
	Gaussian createGaussian();

	/**
	 * Returns a new object of class '<em>Deterministic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deterministic</em>'.
	 * @generated
	 */
	Deterministic createDeterministic();

	/**
	 * Returns a new object of class '<em>Uniform</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Uniform</em>'.
	 * @generated
	 */
	Uniform createUniform();

	/**
	 * Returns a new object of class '<em>Gamma</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gamma</em>'.
	 * @generated
	 */
	Gamma createGamma();

	/**
	 * Returns a new object of class '<em>Weibull</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Weibull</em>'.
	 * @generated
	 */
	Weibull createWeibull();

	/**
	 * Returns a new object of class '<em>Failure Mode</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Failure Mode</em>'.
	 * @generated
	 */
	FailureMode createFailureMode();

	/**
	 * Returns a new object of class '<em>Faults Expression And Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Faults Expression And Node</em>'.
	 * @generated
	 */
	FaultsExpressionAndNode createFaultsExpressionAndNode();

	/**
	 * Returns a new object of class '<em>Faults Expression Or Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Faults Expression Or Node</em>'.
	 * @generated
	 */
	FaultsExpressionOrNode createFaultsExpressionOrNode();

	/**
	 * Returns a new object of class '<em>Faults Expression Fault Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Faults Expression Fault Node</em>'.
	 * @generated
	 */
	FaultsExpressionFaultNode createFaultsExpressionFaultNode();

	/**
	 * Returns a new object of class '<em>Faults Expression Not Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Faults Expression Not Node</em>'.
	 * @generated
	 */
	FaultsExpressionNotNode createFaultsExpressionNotNode();

	/**
	 * Returns a new object of class '<em>Errors Expression Error Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Errors Expression Error Node</em>'.
	 * @generated
	 */
	ErrorsExpressionErrorNode createErrorsExpressionErrorNode();

	/**
	 * Returns a new object of class '<em>Errors Expression Not Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Errors Expression Not Node</em>'.
	 * @generated
	 */
	ErrorsExpressionNotNode createErrorsExpressionNotNode();

	/**
	 * Returns a new object of class '<em>Errors Expression And Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Errors Expression And Node</em>'.
	 * @generated
	 */
	ErrorsExpressionAndNode createErrorsExpressionAndNode();

	/**
	 * Returns a new object of class '<em>Errors Expression Or Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Errors Expression Or Node</em>'.
	 * @generated
	 */
	ErrorsExpressionOrNode createErrorsExpressionOrNode();

	/**
	 * Returns a new object of class '<em>Faults Generate Errors</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Faults Generate Errors</em>'.
	 * @generated
	 */
	FaultsGenerateErrors createFaultsGenerateErrors();

	/**
	 * Returns a new object of class '<em>Internal Propagation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Internal Propagation</em>'.
	 * @generated
	 */
	InternalPropagation createInternalPropagation();

	/**
	 * Returns a new object of class '<em>Errors Propagation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Errors Propagation</em>'.
	 * @generated
	 */
	ErrorsPropagation createErrorsPropagation();

	/**
	 * Returns a new object of class '<em>Errors Produce Failures</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Errors Produce Failures</em>'.
	 * @generated
	 */
	ErrorsProduceFailures createErrorsProduceFailures();

	/**
	 * Returns a new object of class '<em>Maintenance Activity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Maintenance Activity</em>'.
	 * @generated
	 */
	MaintenanceActivity createMaintenanceActivity();

	/**
	 * Returns a new object of class '<em>Repair Activity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Repair Activity</em>'.
	 * @generated
	 */
	RepairActivity createRepairActivity();

	/**
	 * Returns a new object of class '<em>Replace Activity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Replace Activity</em>'.
	 * @generated
	 */
	ReplaceActivity createReplaceActivity();

	/**
	 * Returns a new object of class '<em>Detection Activity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Detection Activity</em>'.
	 * @generated
	 */
	DetectionActivity createDetectionActivity();

	/**
	 * Returns a new object of class '<em>Scheduling Condition Expression Detection Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scheduling Condition Expression Detection Node</em>'.
	 * @generated
	 */
	SchedulingConditionExpressionDetectionNode createSchedulingConditionExpressionDetectionNode();

	/**
	 * Returns a new object of class '<em>Scheduling Condition Expression Failed Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scheduling Condition Expression Failed Node</em>'.
	 * @generated
	 */
	SchedulingConditionExpressionFailedNode createSchedulingConditionExpressionFailedNode();

	/**
	 * Returns a new object of class '<em>Scheduling Condition Expression Not Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scheduling Condition Expression Not Node</em>'.
	 * @generated
	 */
	SchedulingConditionExpressionNotNode createSchedulingConditionExpressionNotNode();

	/**
	 * Returns a new object of class '<em>Scheduling Condition Expression True Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scheduling Condition Expression True Node</em>'.
	 * @generated
	 */
	SchedulingConditionExpressionTrueNode createSchedulingConditionExpressionTrueNode();

	/**
	 * Returns a new object of class '<em>Scheduling Condition Expression And Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scheduling Condition Expression And Node</em>'.
	 * @generated
	 */
	SchedulingConditionExpressionAndNode createSchedulingConditionExpressionAndNode();

	/**
	 * Returns a new object of class '<em>Scheduling Condition Expression Or Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scheduling Condition Expression Or Node</em>'.
	 * @generated
	 */
	SchedulingConditionExpressionOrNode createSchedulingConditionExpressionOrNode();

	/**
	 * Returns a new object of class '<em>Schedule Immediately</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Schedule Immediately</em>'.
	 * @generated
	 */
	ScheduleImmediately createScheduleImmediately();

	/**
	 * Returns a new object of class '<em>Schedule At Time</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Schedule At Time</em>'.
	 * @generated
	 */
	ScheduleAtTime createScheduleAtTime();

	/**
	 * Returns a new object of class '<em>Schedule Periodic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Schedule Periodic</em>'.
	 * @generated
	 */
	SchedulePeriodic createSchedulePeriodic();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DependabilityintermediateModelPackage getDependabilityintermediateModelPackage();

} //DependabilityintermediateModelFactory
