/**
 */
package org.polarsys.chess.chessmlprofile.Dependability.DependableComponent;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAnalysisContext;

import org.eclipse.uml2.uml.Component;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This stereotype is used to 
 * store the result of a V&V check.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.ResultElement#getType <em>Type</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.ResultElement#getDate <em>Date</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.ResultElement#getConditions <em>Conditions</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.ResultElement#isValid <em>Valid</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.ResultElement#getFile <em>File</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.ResultElement#getRoot <em>Root</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.ResultElement#getContextAnalysis <em>Context Analysis</em>}</li>
 *   <li>{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.ResultElement#getBase_Component <em>Base Component</em>}</li>
 * </ul>
 *
 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage#getResultElement()
 * @model
 * @generated
 */
public interface ResultElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage#getResultElement_Type()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.ResultElement#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(String)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage#getResultElement_Date()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.MARTE_PrimitivesTypes.DateTime" required="true" ordered="false"
	 * @generated
	 */
	String getDate();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.ResultElement#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(String value);

	/**
	 * Returns the value of the '<em><b>Conditions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conditions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conditions</em>' attribute.
	 * @see #setConditions(String)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage#getResultElement_Conditions()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getConditions();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.ResultElement#getConditions <em>Conditions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conditions</em>' attribute.
	 * @see #getConditions()
	 * @generated
	 */
	void setConditions(String value);

	/**
	 * Returns the value of the '<em><b>Valid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Valid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Valid</em>' attribute.
	 * @see #setValid(boolean)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage#getResultElement_Valid()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isValid();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.ResultElement#isValid <em>Valid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Valid</em>' attribute.
	 * @see #isValid()
	 * @generated
	 */
	void setValid(boolean value);

	/**
	 * Returns the value of the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File</em>' attribute.
	 * @see #setFile(String)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage#getResultElement_File()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getFile();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.ResultElement#getFile <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File</em>' attribute.
	 * @see #getFile()
	 * @generated
	 */
	void setFile(String value);

	/**
	 * Returns the value of the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' reference.
	 * @see #setRoot(org.eclipse.uml2.uml.Class)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage#getResultElement_Root()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getRoot();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.ResultElement#getRoot <em>Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' reference.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Context Analysis</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Analysis</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Analysis</em>' reference.
	 * @see #setContextAnalysis(GaAnalysisContext)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage#getResultElement_ContextAnalysis()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	GaAnalysisContext getContextAnalysis();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.ResultElement#getContextAnalysis <em>Context Analysis</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Analysis</em>' reference.
	 * @see #getContextAnalysis()
	 * @generated
	 */
	void setContextAnalysis(GaAnalysisContext value);

	/**
	 * Returns the value of the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Component</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Component</em>' reference.
	 * @see #setBase_Component(Component)
	 * @see org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.DependableComponentPackage#getResultElement_Base_Component()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Component getBase_Component();

	/**
	 * Sets the value of the '{@link org.polarsys.chess.chessmlprofile.Dependability.DependableComponent.ResultElement#getBase_Component <em>Base Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Component</em>' reference.
	 * @see #getBase_Component()
	 * @generated
	 */
	void setBase_Component(Component value);

} // ResultElement
