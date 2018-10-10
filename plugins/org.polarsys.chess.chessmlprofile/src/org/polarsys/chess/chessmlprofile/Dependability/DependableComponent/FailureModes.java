/**
 */
package org.polarsys.chess.chessmlprofile.Dependability.DependableComponent;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Slot;

import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTCSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Failure Modes</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * allows to decorate a port\instance with information regarding the failureModes/threats possibly affecting the port\instance itself
 * if applied at the same time on the same entity, than each FailureMode referred by Threats.failureMode must be referred also by FailureModes.failureMode
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureModes#getBase_Slot <em>Base Slot</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureModes#getBase_Port <em>Base Port</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureModes#getFailureMode <em>Failure Mode</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureModes#getFPTCSpecification <em>FPTC Specification</em>}</li>
 * </ul>
 *
 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage#getFailureModes()
 * @model
 * @generated
 */
public interface FailureModes extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Slot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Slot</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Slot</em>' reference.
	 * @see #setBase_Slot(Slot)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage#getFailureModes_Base_Slot()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Slot getBase_Slot();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureModes#getBase_Slot <em>Base Slot</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Slot</em>' reference.
	 * @see #getBase_Slot()
	 * @generated
	 */
	void setBase_Slot(Slot value);

	/**
	 * Returns the value of the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Port</em>' reference.
	 * @see #setBase_Port(Port)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage#getFailureModes_Base_Port()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Port getBase_Port();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureModes#getBase_Port <em>Base Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Port</em>' reference.
	 * @see #getBase_Port()
	 * @generated
	 */
	void setBase_Port(Port value);

	/**
	 * Returns the value of the '<em><b>Failure Mode</b></em>' reference list.
	 * The list contents are of type {@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Failure Mode</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Failure Mode</em>' reference list.
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage#getFailureModes_FailureMode()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<FailureMode> getFailureMode();

	/**
	 * Returns the value of the '<em><b>FPTC Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>FPTC Specification</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>FPTC Specification</em>' reference.
	 * @see #setFPTCSpecification(FPTCSpecification)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage#getFailureModes_FPTCSpecification()
	 * @model ordered="false"
	 * @generated
	 */
	FPTCSpecification getFPTCSpecification();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.FailureModes#getFPTCSpecification <em>FPTC Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>FPTC Specification</em>' reference.
	 * @see #getFPTCSpecification()
	 * @generated
	 */
	void setFPTCSpecification(FPTCSpecification value);

} // FailureModes
