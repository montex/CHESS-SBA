/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Schedule At Time</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DependabilityintermediateModel.ScheduleAtTime#getTime <em>Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getScheduleAtTime()
 * @model
 * @generated
 */
public interface ScheduleAtTime extends SchedulingEvent {
	/**
	 * Returns the value of the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time</em>' attribute.
	 * @see #setTime(double)
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getScheduleAtTime_Time()
	 * @model required="true"
	 * @generated
	 */
	double getTime();

	/**
	 * Sets the value of the '{@link DependabilityintermediateModel.ScheduleAtTime#getTime <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' attribute.
	 * @see #getTime()
	 * @generated
	 */
	void setTime(double value);

} // ScheduleAtTime
