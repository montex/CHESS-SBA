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
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DependabilityintermediateModel.Component#getIntermediateModel <em>Intermediate Model</em>}</li>
 *   <li>{@link DependabilityintermediateModel.Component#getFailureModes <em>Failure Modes</em>}</li>
 *   <li>{@link DependabilityintermediateModel.Component#getErrors <em>Errors</em>}</li>
 *   <li>{@link DependabilityintermediateModel.Component#getFaults <em>Faults</em>}</li>
 *   <li>{@link DependabilityintermediateModel.Component#getFaultsGeneratesErrors <em>Faults Generates Errors</em>}</li>
 *   <li>{@link DependabilityintermediateModel.Component#getInternalPropagation <em>Internal Propagation</em>}</li>
 *   <li>{@link DependabilityintermediateModel.Component#getErrorsGeneratesFailures <em>Errors Generates Failures</em>}</li>
 * </ul>
 * </p>
 *
 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getComponent()
 * @model
 * @generated
 */
public interface Component extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Intermediate Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link DependabilityintermediateModel.Sistema#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Intermediate Model</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intermediate Model</em>' container reference.
	 * @see #setIntermediateModel(Sistema)
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getComponent_IntermediateModel()
	 * @see DependabilityintermediateModel.Sistema#getComponents
	 * @model opposite="components" required="true" transient="false"
	 * @generated
	 */
	Sistema getIntermediateModel();

	/**
	 * Sets the value of the '{@link DependabilityintermediateModel.Component#getIntermediateModel <em>Intermediate Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intermediate Model</em>' container reference.
	 * @see #getIntermediateModel()
	 * @generated
	 */
	void setIntermediateModel(Sistema value);

	/**
	 * Returns the value of the '<em><b>Failure Modes</b></em>' containment reference list.
	 * The list contents are of type {@link DependabilityintermediateModel.FailureMode}.
	 * It is bidirectional and its opposite is '{@link DependabilityintermediateModel.FailureMode#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Failure Modes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Failure Modes</em>' containment reference list.
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getComponent_FailureModes()
	 * @see DependabilityintermediateModel.FailureMode#getComponent
	 * @model opposite="Component" containment="true" required="true"
	 * @generated
	 */
	EList<FailureMode> getFailureModes();

	/**
	 * Returns the value of the '<em><b>Errors</b></em>' containment reference list.
	 * The list contents are of type {@link DependabilityintermediateModel.Error}.
	 * It is bidirectional and its opposite is '{@link DependabilityintermediateModel.Error#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Errors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Errors</em>' containment reference list.
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getComponent_Errors()
	 * @see DependabilityintermediateModel.Error#getComponent
	 * @model opposite="Component" containment="true"
	 * @generated
	 */
	EList<DependabilityintermediateModel.Error> getErrors();

	/**
	 * Returns the value of the '<em><b>Faults</b></em>' containment reference list.
	 * The list contents are of type {@link DependabilityintermediateModel.Fault}.
	 * It is bidirectional and its opposite is '{@link DependabilityintermediateModel.Fault#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Faults</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Faults</em>' containment reference list.
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getComponent_Faults()
	 * @see DependabilityintermediateModel.Fault#getComponent
	 * @model opposite="Component" containment="true" required="true"
	 * @generated
	 */
	EList<Fault> getFaults();

	/**
	 * Returns the value of the '<em><b>Faults Generates Errors</b></em>' containment reference list.
	 * The list contents are of type {@link DependabilityintermediateModel.FaultsGenerateErrors}.
	 * It is bidirectional and its opposite is '{@link DependabilityintermediateModel.FaultsGenerateErrors#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Faults Generates Errors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Faults Generates Errors</em>' containment reference list.
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getComponent_FaultsGeneratesErrors()
	 * @see DependabilityintermediateModel.FaultsGenerateErrors#getComponent
	 * @model opposite="component" containment="true" required="true"
	 * @generated
	 */
	EList<FaultsGenerateErrors> getFaultsGeneratesErrors();

	/**
	 * Returns the value of the '<em><b>Internal Propagation</b></em>' containment reference list.
	 * The list contents are of type {@link DependabilityintermediateModel.InternalPropagation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Internal Propagation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal Propagation</em>' containment reference list.
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getComponent_InternalPropagation()
	 * @model containment="true"
	 * @generated
	 */
	EList<InternalPropagation> getInternalPropagation();

	/**
	 * Returns the value of the '<em><b>Errors Generates Failures</b></em>' containment reference list.
	 * The list contents are of type {@link DependabilityintermediateModel.ErrorsProduceFailures}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Errors Generates Failures</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Errors Generates Failures</em>' containment reference list.
	 * @see DependabilityintermediateModel.DependabilityintermediateModelPackage#getComponent_ErrorsGeneratesFailures()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ErrorsProduceFailures> getErrorsGeneratesFailures();

} // Component
