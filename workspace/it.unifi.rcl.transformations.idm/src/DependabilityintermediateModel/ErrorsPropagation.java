/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package DependabilityintermediateModel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Errors Propagation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DependabilityintermediateModel.ErrorsPropagation#getPropagationLogic <em>Propagation Logic</em>}</li>
 *   <li>{@link DependabilityintermediateModel.ErrorsPropagation#getComponent <em>Component</em>}</li>
 *   <li>{@link DependabilityintermediateModel.ErrorsPropagation#getName <em>Name</em>}</li>
 *   <li>{@link DependabilityintermediateModel.ErrorsPropagation#getPropagationLogicStringFormat <em>Propagation Logic String Format</em>}</li>
 * </ul>
 * </p>
 *
 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getErrorsPropagation()
 * @model
 * @generated
 */
public interface ErrorsPropagation extends EObject {
	/**
	 * Returns the value of the '<em><b>Propagation Logic</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Propagation Logic</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Propagation Logic</em>' containment reference.
	 * @see #setPropagationLogic(ErrorsExpressionNode)
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getErrorsPropagation_PropagationLogic()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ErrorsExpressionNode getPropagationLogic();

	/**
	 * Sets the value of the '{@link DependabilityintermediateModel.ErrorsPropagation#getPropagationLogic <em>Propagation Logic</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Propagation Logic</em>' containment reference.
	 * @see #getPropagationLogic()
	 * @generated
	 */
	void setPropagationLogic(ErrorsExpressionNode value);

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
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getErrorsPropagation_Component()
	 * @model required="true"
	 * @generated
	 */
	Component getComponent();

	/**
	 * Sets the value of the '{@link DependabilityintermediateModel.ErrorsPropagation#getComponent <em>Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component</em>' reference.
	 * @see #getComponent()
	 * @generated
	 */
	void setComponent(Component value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getErrorsPropagation_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link DependabilityintermediateModel.ErrorsPropagation#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Propagation Logic String Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Propagation Logic String Format</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Propagation Logic String Format</em>' attribute.
	 * @see #setPropagationLogicStringFormat(String)
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getErrorsPropagation_PropagationLogicStringFormat()
	 * @model required="true"
	 * @generated
	 */
	String getPropagationLogicStringFormat();

	/**
	 * Sets the value of the '{@link DependabilityintermediateModel.ErrorsPropagation#getPropagationLogicStringFormat <em>Propagation Logic String Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Propagation Logic String Format</em>' attribute.
	 * @see #getPropagationLogicStringFormat()
	 * @generated
	 */
	void setPropagationLogicStringFormat(String value);

} // ErrorsPropagation
