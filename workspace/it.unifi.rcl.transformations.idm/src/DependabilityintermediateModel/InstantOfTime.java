/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instant Of Time</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DependabilityintermediateModel.InstantOfTime#getTimePoint <em>Time Point</em>}</li>
 * </ul>
 * </p>
 *
 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getInstantOfTime()
 * @model
 * @generated
 */
public interface InstantOfTime extends EvaluationType {
	/**
	 * Returns the value of the '<em><b>Time Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Point</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Point</em>' attribute.
	 * @see #setTimePoint(double)
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getInstantOfTime_TimePoint()
	 * @model required="true"
	 * @generated
	 */
	double getTimePoint();

	/**
	 * Sets the value of the '{@link DependabilityintermediateModel.InstantOfTime#getTimePoint <em>Time Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Point</em>' attribute.
	 * @see #getTimePoint()
	 * @generated
	 */
	void setTimePoint(double value);

} // InstantOfTime
