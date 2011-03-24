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
 * A representation of the model object '<em><b>Scheduling Condition Expression Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DependabilityintermediateModel.SchedulingConditionExpressionNode#getSchedulingEvent <em>Scheduling Event</em>}</li>
 * </ul>
 * </p>
 *
 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getSchedulingConditionExpressionNode()
 * @model abstract="true"
 * @generated
 */
public interface SchedulingConditionExpressionNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Scheduling Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scheduling Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scheduling Event</em>' reference.
	 * @see #setSchedulingEvent(SchedulingEvent)
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getSchedulingConditionExpressionNode_SchedulingEvent()
	 * @model required="true"
	 * @generated
	 */
	SchedulingEvent getSchedulingEvent();

	/**
	 * Sets the value of the '{@link DependabilityintermediateModel.SchedulingConditionExpressionNode#getSchedulingEvent <em>Scheduling Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scheduling Event</em>' reference.
	 * @see #getSchedulingEvent()
	 * @generated
	 */
	void setSchedulingEvent(SchedulingEvent value);

} // SchedulingConditionExpressionNode
