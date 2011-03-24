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
 * A representation of the model object '<em><b>Internal Propagation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DependabilityintermediateModel.InternalPropagation#getSource <em>Source</em>}</li>
 *   <li>{@link DependabilityintermediateModel.InternalPropagation#getDestination <em>Destination</em>}</li>
 *   <li>{@link DependabilityintermediateModel.InternalPropagation#getPropagationDelay <em>Propagation Delay</em>}</li>
 *   <li>{@link DependabilityintermediateModel.InternalPropagation#getPropagationProbability <em>Propagation Probability</em>}</li>
 *   <li>{@link DependabilityintermediateModel.InternalPropagation#getWeight <em>Weight</em>}</li>
 * </ul>
 * </p>
 *
 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getInternalPropagation()
 * @model
 * @generated
 */
public interface InternalPropagation extends ErrorsPropagation {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference list.
	 * The list contents are of type {@link DependabilityintermediateModel.Error}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference list.
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getInternalPropagation_Source()
	 * @model required="true"
	 * @generated
	 */
	EList<DependabilityintermediateModel.Error> getSource();

	/**
	 * Returns the value of the '<em><b>Destination</b></em>' reference list.
	 * The list contents are of type {@link DependabilityintermediateModel.Error}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' reference list.
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getInternalPropagation_Destination()
	 * @model required="true"
	 * @generated
	 */
	EList<DependabilityintermediateModel.Error> getDestination();

	/**
	 * Returns the value of the '<em><b>Propagation Delay</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Propagation Delay</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Propagation Delay</em>' containment reference.
	 * @see #setPropagationDelay(Distribution)
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getInternalPropagation_PropagationDelay()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Distribution getPropagationDelay();

	/**
	 * Sets the value of the '{@link DependabilityintermediateModel.InternalPropagation#getPropagationDelay <em>Propagation Delay</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Propagation Delay</em>' containment reference.
	 * @see #getPropagationDelay()
	 * @generated
	 */
	void setPropagationDelay(Distribution value);

	/**
	 * Returns the value of the '<em><b>Propagation Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Propagation Probability</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Propagation Probability</em>' attribute.
	 * @see #setPropagationProbability(double)
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getInternalPropagation_PropagationProbability()
	 * @model required="true"
	 * @generated
	 */
	double getPropagationProbability();

	/**
	 * Sets the value of the '{@link DependabilityintermediateModel.InternalPropagation#getPropagationProbability <em>Propagation Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Propagation Probability</em>' attribute.
	 * @see #getPropagationProbability()
	 * @generated
	 */
	void setPropagationProbability(double value);

	/**
	 * Returns the value of the '<em><b>Weight</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weight</em>' attribute.
	 * @see #setWeight(double)
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getInternalPropagation_Weight()
	 * @model default="1" required="true"
	 * @generated
	 */
	double getWeight();

	/**
	 * Sets the value of the '{@link DependabilityintermediateModel.InternalPropagation#getWeight <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weight</em>' attribute.
	 * @see #getWeight()
	 * @generated
	 */
	void setWeight(double value);

} // InternalPropagation
