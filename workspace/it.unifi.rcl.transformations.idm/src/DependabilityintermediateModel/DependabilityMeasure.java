/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dependability Measure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DependabilityintermediateModel.DependabilityMeasure#getTarget <em>Target</em>}</li>
 *   <li>{@link DependabilityintermediateModel.DependabilityMeasure#getEvaluations <em>Evaluations</em>}</li>
 *   <li>{@link DependabilityintermediateModel.DependabilityMeasure#getRequiredMax <em>Required Max</em>}</li>
 *   <li>{@link DependabilityintermediateModel.DependabilityMeasure#getRequiredMin <em>Required Min</em>}</li>
 * </ul>
 * </p>
 *
 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getDependabilityMeasure()
 * @model
 * @generated
 */
public interface DependabilityMeasure extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference list.
	 * The list contents are of type {@link DependabilityintermediateModel.FailureMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference list.
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getDependabilityMeasure_Target()
	 * @model required="true"
	 * @generated
	 */
	EList<FailureMode> getTarget();

	/**
	 * Returns the value of the '<em><b>Evaluations</b></em>' containment reference list.
	 * The list contents are of type {@link DependabilityintermediateModel.EvaluationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Evaluations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Evaluations</em>' containment reference list.
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getDependabilityMeasure_Evaluations()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<EvaluationType> getEvaluations();

	/**
	 * Returns the value of the '<em><b>Required Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Max</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Max</em>' attribute.
	 * @see #setRequiredMax(double)
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getDependabilityMeasure_RequiredMax()
	 * @model
	 * @generated
	 */
	double getRequiredMax();

	/**
	 * Sets the value of the '{@link DependabilityintermediateModel.DependabilityMeasure#getRequiredMax <em>Required Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Max</em>' attribute.
	 * @see #getRequiredMax()
	 * @generated
	 */
	void setRequiredMax(double value);

	/**
	 * Returns the value of the '<em><b>Required Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Min</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Min</em>' attribute.
	 * @see #setRequiredMin(double)
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getDependabilityMeasure_RequiredMin()
	 * @model
	 * @generated
	 */
	double getRequiredMin();

	/**
	 * Sets the value of the '{@link DependabilityintermediateModel.DependabilityMeasure#getRequiredMin <em>Required Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Min</em>' attribute.
	 * @see #getRequiredMin()
	 * @generated
	 */
	void setRequiredMin(double value);

} // DependabilityMeasure
