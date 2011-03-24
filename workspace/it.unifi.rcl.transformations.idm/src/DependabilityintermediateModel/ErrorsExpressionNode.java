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
 * A representation of the model object '<em><b>Errors Expression Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DependabilityintermediateModel.ErrorsExpressionNode#getErrorPropagation <em>Error Propagation</em>}</li>
 * </ul>
 * </p>
 *
 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getErrorsExpressionNode()
 * @model abstract="true"
 * @generated
 */
public interface ErrorsExpressionNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Error Propagation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Propagation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Propagation</em>' reference.
	 * @see #setErrorPropagation(ErrorsPropagation)
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getErrorsExpressionNode_ErrorPropagation()
	 * @model required="true"
	 * @generated
	 */
	ErrorsPropagation getErrorPropagation();

	/**
	 * Sets the value of the '{@link DependabilityintermediateModel.ErrorsExpressionNode#getErrorPropagation <em>Error Propagation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error Propagation</em>' reference.
	 * @see #getErrorPropagation()
	 * @generated
	 */
	void setErrorPropagation(ErrorsPropagation value);

} // ErrorsExpressionNode
