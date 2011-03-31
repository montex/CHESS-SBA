/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Safety</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DependabilityintermediateModel.Safety#getHazardousLevel <em>Hazardous Level</em>}</li>
 * </ul>
 * </p>
 *
 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getSafety()
 * @model
 * @generated
 */
public interface Safety extends DependabilityMeasure {
	/**
	 * Returns the value of the '<em><b>Hazardous Level</b></em>' attribute.
	 * The literals are from the enumeration {@link DependabilityintermediateModel.FailureConsequences}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hazardous Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hazardous Level</em>' attribute.
	 * @see DependabilityintermediateModel.FailureConsequences
	 * @see #setHazardousLevel(FailureConsequences)
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getSafety_HazardousLevel()
	 * @model required="true"
	 * @generated
	 */
	FailureConsequences getHazardousLevel();

	/**
	 * Sets the value of the '{@link DependabilityintermediateModel.Safety#getHazardousLevel <em>Hazardous Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hazardous Level</em>' attribute.
	 * @see DependabilityintermediateModel.FailureConsequences
	 * @see #getHazardousLevel()
	 * @generated
	 */
	void setHazardousLevel(FailureConsequences value);

} // Safety
