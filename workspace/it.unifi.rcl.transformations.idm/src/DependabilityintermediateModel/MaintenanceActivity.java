/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Maintenance Activity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DependabilityintermediateModel.MaintenanceActivity#getSuccessProbability <em>Success Probability</em>}</li>
 * </ul>
 * </p>
 *
 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getMaintenanceActivity()
 * @model
 * @generated
 */
public interface MaintenanceActivity extends Activity {
	/**
	 * Returns the value of the '<em><b>Success Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Success Probability</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Success Probability</em>' attribute.
	 * @see #setSuccessProbability(double)
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getMaintenanceActivity_SuccessProbability()
	 * @model required="true"
	 * @generated
	 */
	double getSuccessProbability();

	/**
	 * Sets the value of the '{@link DependabilityintermediateModel.MaintenanceActivity#getSuccessProbability <em>Success Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Success Probability</em>' attribute.
	 * @see #getSuccessProbability()
	 * @generated
	 */
	void setSuccessProbability(double value);

} // MaintenanceActivity
