package org.polarsys.chess.xtext.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.polarsys.chess.xtext.flaDsl.ACIDMitigation;
import org.polarsys.chess.xtext.flaDsl.ACIDavoidable;
import org.polarsys.chess.xtext.flaDsl.Behaviour;
import org.polarsys.chess.xtext.flaDsl.Expression;
import org.polarsys.chess.xtext.flaDsl.FailureDefinition;
import org.polarsys.chess.xtext.flaDsl.FlaDslPackage;
import org.polarsys.chess.xtext.flaDsl.InFailureExpr;
import org.polarsys.chess.xtext.flaDsl.InputExpression;
import org.polarsys.chess.xtext.flaDsl.Lhs;
import org.polarsys.chess.xtext.flaDsl.NoFailureDefinition;
import org.polarsys.chess.xtext.flaDsl.OutFailureExpr;
import org.polarsys.chess.xtext.flaDsl.OutputExpression;
import org.polarsys.chess.xtext.flaDsl.Rhs;
import org.polarsys.chess.xtext.flaDsl.VariableDefinition;
import org.polarsys.chess.xtext.flaDsl.WildcardDefinition;
import org.polarsys.chess.xtext.services.FlaDslGrammarAccess;

@SuppressWarnings("all")
public class FlaDslSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private FlaDslGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == FlaDslPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case FlaDslPackage.ACID_MITIGATION:
				if(context == grammarAccess.getACIDMitigationRule()) {
					sequence_ACIDMitigation(context, (ACIDMitigation) semanticObject); 
					return; 
				}
				else break;
			case FlaDslPackage.ACI_DAVOIDABLE:
				if(context == grammarAccess.getACIDavoidableRule()) {
					sequence_ACIDavoidable(context, (ACIDavoidable) semanticObject); 
					return; 
				}
				else break;
			case FlaDslPackage.BEHAVIOUR:
				if(context == grammarAccess.getBehaviourRule()) {
					sequence_Behaviour(context, (Behaviour) semanticObject); 
					return; 
				}
				else break;
			case FlaDslPackage.EXPRESSION:
				if(context == grammarAccess.getExpressionRule()) {
					sequence_Expression(context, (Expression) semanticObject); 
					return; 
				}
				else break;
			case FlaDslPackage.FAILURE_DEFINITION:
				if(context == grammarAccess.getDefinitionsRule() ||
				   context == grammarAccess.getFailureDefinitionRule()) {
					sequence_FailureDefinition(context, (FailureDefinition) semanticObject); 
					return; 
				}
				else break;
			case FlaDslPackage.IN_FAILURE_EXPR:
				if(context == grammarAccess.getInFailureExprRule()) {
					sequence_InFailureExpr(context, (InFailureExpr) semanticObject); 
					return; 
				}
				else break;
			case FlaDslPackage.INPUT_EXPRESSION:
				if(context == grammarAccess.getInputExpressionRule()) {
					sequence_InputExpression(context, (InputExpression) semanticObject); 
					return; 
				}
				else break;
			case FlaDslPackage.LHS:
				if(context == grammarAccess.getLhsRule()) {
					sequence_Lhs(context, (Lhs) semanticObject); 
					return; 
				}
				else break;
			case FlaDslPackage.NO_FAILURE_DEFINITION:
				if(context == grammarAccess.getComplexNofailureDefinitionRule() ||
				   context == grammarAccess.getDefinitionsRule()) {
					sequence_ComplexNofailureDefinition(context, (NoFailureDefinition) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getNoFailureDefinitionRule()) {
					sequence_NoFailureDefinition(context, (NoFailureDefinition) semanticObject); 
					return; 
				}
				else break;
			case FlaDslPackage.OUT_FAILURE_EXPR:
				if(context == grammarAccess.getOutFailureExprRule()) {
					sequence_OutFailureExpr(context, (OutFailureExpr) semanticObject); 
					return; 
				}
				else break;
			case FlaDslPackage.OUTPUT_EXPRESSION:
				if(context == grammarAccess.getOutputExpressionRule()) {
					sequence_OutputExpression(context, (OutputExpression) semanticObject); 
					return; 
				}
				else break;
			case FlaDslPackage.RHS:
				if(context == grammarAccess.getRhsRule()) {
					sequence_Rhs(context, (Rhs) semanticObject); 
					return; 
				}
				else break;
			case FlaDslPackage.VARIABLE_DEFINITION:
				if(context == grammarAccess.getDefinitionsRule() ||
				   context == grammarAccess.getVariableDefinitionRule()) {
					sequence_VariableDefinition(context, (VariableDefinition) semanticObject); 
					return; 
				}
				else break;
			case FlaDslPackage.WILDCARD_DEFINITION:
				if(context == grammarAccess.getDefinitionsRule() ||
				   context == grammarAccess.getWildcardDefinitionRule()) {
					sequence_WildcardDefinition(context, (WildcardDefinition) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (a=Amitigation c=Cmitigation i=Imitigation d=Dmitigation)
	 */
	protected void sequence_ACIDMitigation(EObject context, ACIDMitigation semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FlaDslPackage.Literals.ACID_MITIGATION__A) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FlaDslPackage.Literals.ACID_MITIGATION__A));
			if(transientValues.isValueTransient(semanticObject, FlaDslPackage.Literals.ACID_MITIGATION__C) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FlaDslPackage.Literals.ACID_MITIGATION__C));
			if(transientValues.isValueTransient(semanticObject, FlaDslPackage.Literals.ACID_MITIGATION__I) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FlaDslPackage.Literals.ACID_MITIGATION__I));
			if(transientValues.isValueTransient(semanticObject, FlaDslPackage.Literals.ACID_MITIGATION__D) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FlaDslPackage.Literals.ACID_MITIGATION__D));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getACIDMitigationAccess().getAAmitigationEnumRuleCall_0_0(), semanticObject.getA());
		feeder.accept(grammarAccess.getACIDMitigationAccess().getCCmitigationEnumRuleCall_2_0(), semanticObject.getC());
		feeder.accept(grammarAccess.getACIDMitigationAccess().getIImitigationEnumRuleCall_4_0(), semanticObject.getI());
		feeder.accept(grammarAccess.getACIDMitigationAccess().getDDmitigationEnumRuleCall_6_0(), semanticObject.getD());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (a=Aavoidable c=Cavoidable i=Iavoidable d=Davoidable)
	 */
	protected void sequence_ACIDavoidable(EObject context, ACIDavoidable semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FlaDslPackage.Literals.ACI_DAVOIDABLE__A) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FlaDslPackage.Literals.ACI_DAVOIDABLE__A));
			if(transientValues.isValueTransient(semanticObject, FlaDslPackage.Literals.ACI_DAVOIDABLE__C) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FlaDslPackage.Literals.ACI_DAVOIDABLE__C));
			if(transientValues.isValueTransient(semanticObject, FlaDslPackage.Literals.ACI_DAVOIDABLE__I) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FlaDslPackage.Literals.ACI_DAVOIDABLE__I));
			if(transientValues.isValueTransient(semanticObject, FlaDslPackage.Literals.ACI_DAVOIDABLE__D) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FlaDslPackage.Literals.ACI_DAVOIDABLE__D));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getACIDavoidableAccess().getAAavoidableEnumRuleCall_0_0(), semanticObject.getA());
		feeder.accept(grammarAccess.getACIDavoidableAccess().getCCavoidableEnumRuleCall_2_0(), semanticObject.getC());
		feeder.accept(grammarAccess.getACIDavoidableAccess().getIIavoidableEnumRuleCall_4_0(), semanticObject.getI());
		feeder.accept(grammarAccess.getACIDavoidableAccess().getDDavoidableEnumRuleCall_6_0(), semanticObject.getD());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     rules+=Expression+
	 */
	protected void sequence_Behaviour(EObject context, Behaviour semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     acidMitigation=ACIDMitigation
	 */
	protected void sequence_ComplexNofailureDefinition(EObject context, NoFailureDefinition semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FlaDslPackage.Literals.NO_FAILURE_DEFINITION__ACID_MITIGATION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FlaDslPackage.Literals.NO_FAILURE_DEFINITION__ACID_MITIGATION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getComplexNofailureDefinitionAccess().getAcidMitigationACIDMitigationParserRuleCall_3_0(), semanticObject.getAcidMitigation());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (lhs=Lhs rhs=Rhs)
	 */
	protected void sequence_Expression(EObject context, Expression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FlaDslPackage.Literals.EXPRESSION__LHS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FlaDslPackage.Literals.EXPRESSION__LHS));
			if(transientValues.isValueTransient(semanticObject, FlaDslPackage.Literals.EXPRESSION__RHS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FlaDslPackage.Literals.EXPRESSION__RHS));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getExpressionAccess().getLhsLhsParserRuleCall_1_0(), semanticObject.getLhs());
		feeder.accept(grammarAccess.getExpressionAccess().getRhsRhsParserRuleCall_3_0(), semanticObject.getRhs());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (type=ActualFailureType acidAvoidable=ACIDavoidable?)
	 */
	protected void sequence_FailureDefinition(EObject context, FailureDefinition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         failures+=WildcardDefinition | 
	 *         failures+=NoFailureDefinition | 
	 *         failures+=FailureDefinition | 
	 *         (failures+=FailureDefinition failures+=FailureDefinition+) | 
	 *         failures+=VariableDefinition
	 *     )
	 */
	protected void sequence_InFailureExpr(EObject context, InFailureExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ref=[Port|ID]? failureExpr=InFailureExpr)
	 */
	protected void sequence_InputExpression(EObject context, InputExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (failures+=InputExpression failures+=InputExpression*)
	 */
	protected void sequence_Lhs(EObject context, Lhs semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {NoFailureDefinition}
	 */
	protected void sequence_NoFailureDefinition(EObject context, NoFailureDefinition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         failures+=NoFailureDefinition | 
	 *         failures+=ComplexNofailureDefinition | 
	 *         failures+=FailureDefinition | 
	 *         (failures+=FailureDefinition failures+=FailureDefinition+) | 
	 *         failures+=VariableDefinition
	 *     )
	 */
	protected void sequence_OutFailureExpr(EObject context, OutFailureExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ref=[Port|ID]? failureExpr=OutFailureExpr)
	 */
	protected void sequence_OutputExpression(EObject context, OutputExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (failures+=OutputExpression failures+=OutputExpression*)
	 */
	protected void sequence_Rhs(EObject context, Rhs semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     variableName=ID
	 */
	protected void sequence_VariableDefinition(EObject context, VariableDefinition semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FlaDslPackage.Literals.VARIABLE_DEFINITION__VARIABLE_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FlaDslPackage.Literals.VARIABLE_DEFINITION__VARIABLE_NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getVariableDefinitionAccess().getVariableNameIDTerminalRuleCall_1_0(), semanticObject.getVariableName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     {WildcardDefinition}
	 */
	protected void sequence_WildcardDefinition(EObject context, WildcardDefinition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
