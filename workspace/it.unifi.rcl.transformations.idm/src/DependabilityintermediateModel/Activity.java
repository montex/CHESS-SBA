/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Activity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DependabilityintermediateModel.Activity#getDuration <em>Duration</em>}</li>
 *   <li>{@link DependabilityintermediateModel.Activity#getWhen <em>When</em>}</li>
 *   <li>{@link DependabilityintermediateModel.Activity#getComponent <em>Component</em>}</li>
 *   <li>{@link DependabilityintermediateModel.Activity#getSistema <em>Sistema</em>}</li>
 * </ul>
 * </p>
 *
 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getActivity()
 * @model abstract="true"
 * @generated
 */
public interface Activity extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Duration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration</em>' containment reference.
	 * @see #setDuration(Distribution)
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getActivity_Duration()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Distribution getDuration();

	/**
	 * Sets the value of the '{@link DependabilityintermediateModel.Activity#getDuration <em>Duration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' containment reference.
	 * @see #getDuration()
	 * @generated
	 */
	void setDuration(Distribution value);

	/**
	 * Returns the value of the '<em><b>When</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link DependabilityintermediateModel.SchedulingEvent#getActivity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>When</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>When</em>' containment reference.
	 * @see #setWhen(SchedulingEvent)
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getActivity_When()
	 * @see DependabilityintermediateModel.SchedulingEvent#getActivity
	 * @model opposite="Activity" containment="true" required="true"
	 * @generated
	 */
	SchedulingEvent getWhen();

	/**
	 * Sets the value of the '{@link DependabilityintermediateModel.Activity#getWhen <em>When</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>When</em>' containment reference.
	 * @see #getWhen()
	 * @generated
	 */
	void setWhen(SchedulingEvent value);

	/**
	 * Returns the value of the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component</em>' reference.
	 * @see #setComponent(Component)
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getActivity_Component()
	 * @model
	 * @generated
	 */
	Component getComponent();

	/**
	 * Sets the value of the '{@link DependabilityintermediateModel.Activity#getComponent <em>Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component</em>' reference.
	 * @see #getComponent()
	 * @generated
	 */
	void setComponent(Component value);

	/**
	 * Returns the value of the '<em><b>Sistema</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link DependabilityintermediateModel.Sistema#getActivities <em>Activities</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sistema</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sistema</em>' container reference.
	 * @see #setSistema(Sistema)
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getActivity_Sistema()
	 * @see DependabilityintermediateModel.Sistema#getActivities
	 * @model opposite="Activities" required="true" transient="false"
	 * @generated
	 */
	Sistema getSistema();

	/**
	 * Sets the value of the '{@link DependabilityintermediateModel.Activity#getSistema <em>Sistema</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sistema</em>' container reference.
	 * @see #getSistema()
	 * @generated
	 */
	void setSistema(Sistema value);

} // Activity
