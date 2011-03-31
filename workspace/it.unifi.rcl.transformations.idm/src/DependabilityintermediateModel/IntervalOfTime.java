/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interval Of Time</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DependabilityintermediateModel.IntervalOfTime#getBegin <em>Begin</em>}</li>
 *   <li>{@link DependabilityintermediateModel.IntervalOfTime#getEnd <em>End</em>}</li>
 * </ul>
 * </p>
 *
 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getIntervalOfTime()
 * @model
 * @generated
 */
public interface IntervalOfTime extends EvaluationType {
	/**
	 * Returns the value of the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Begin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Begin</em>' attribute.
	 * @see #setBegin(double)
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getIntervalOfTime_Begin()
	 * @model required="true"
	 * @generated
	 */
	double getBegin();

	/**
	 * Sets the value of the '{@link DependabilityintermediateModel.IntervalOfTime#getBegin <em>Begin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Begin</em>' attribute.
	 * @see #getBegin()
	 * @generated
	 */
	void setBegin(double value);

	/**
	 * Returns the value of the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End</em>' attribute.
	 * @see #setEnd(double)
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getIntervalOfTime_End()
	 * @model required="true"
	 * @generated
	 */
	double getEnd();

	/**
	 * Sets the value of the '{@link DependabilityintermediateModel.IntervalOfTime#getEnd <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End</em>' attribute.
	 * @see #getEnd()
	 * @generated
	 */
	void setEnd(double value);

} // IntervalOfTime
