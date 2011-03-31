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
 * A representation of the model object '<em><b>Sistema</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DependabilityintermediateModel.Sistema#getComponents <em>Components</em>}</li>
 *   <li>{@link DependabilityintermediateModel.Sistema#getActivities <em>Activities</em>}</li>
 *   <li>{@link DependabilityintermediateModel.Sistema#getMeasures <em>Measures</em>}</li>
 * </ul>
 * </p>
 *
 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getSistema()
 * @model
 * @generated
 */
public interface Sistema extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Components</b></em>' containment reference list.
	 * The list contents are of type {@link DependabilityintermediateModel.Component}.
	 * It is bidirectional and its opposite is '{@link DependabilityintermediateModel.Component#getIntermediateModel <em>Intermediate Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components</em>' containment reference list.
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getSistema_Components()
	 * @see DependabilityintermediateModel.Component#getIntermediateModel
	 * @model opposite="intermediateModel" containment="true"
	 * @generated
	 */
	EList<Component> getComponents();

	/**
	 * Returns the value of the '<em><b>Activities</b></em>' containment reference list.
	 * The list contents are of type {@link DependabilityintermediateModel.Activity}.
	 * It is bidirectional and its opposite is '{@link DependabilityintermediateModel.Activity#getSistema <em>Sistema</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activities</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activities</em>' containment reference list.
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getSistema_Activities()
	 * @see DependabilityintermediateModel.Activity#getSistema
	 * @model opposite="Sistema" containment="true"
	 * @generated
	 */
	EList<Activity> getActivities();

	/**
	 * Returns the value of the '<em><b>Measures</b></em>' containment reference list.
	 * The list contents are of type {@link DependabilityintermediateModel.DependabilityMeasure}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measures</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measures</em>' containment reference list.
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getSistema_Measures()
	 * @model containment="true"
	 * @generated
	 */
	EList<DependabilityMeasure> getMeasures();

} // Sistema
