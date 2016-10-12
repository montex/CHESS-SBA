/*
* generated by Xtext
*/
package org.polarsys.chess.xtext.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.polarsys.chess.xtext.services.FlaDslGrammarAccess;

public class FlaDslParser extends AbstractContentAssistParser {
	
	@Inject
	private FlaDslGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.polarsys.chess.xtext.ui.contentassist.antlr.internal.InternalFlaDslParser createParser() {
		org.polarsys.chess.xtext.ui.contentassist.antlr.internal.InternalFlaDslParser result = new org.polarsys.chess.xtext.ui.contentassist.antlr.internal.InternalFlaDslParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getInputExpressionAccess().getAlternatives_0(), "rule__InputExpression__Alternatives_0");
					put(grammarAccess.getOutputExpressionAccess().getAlternatives_0(), "rule__OutputExpression__Alternatives_0");
					put(grammarAccess.getInFailureExprAccess().getAlternatives(), "rule__InFailureExpr__Alternatives");
					put(grammarAccess.getOutFailureExprAccess().getAlternatives(), "rule__OutFailureExpr__Alternatives");
					put(grammarAccess.getDefinitionsAccess().getAlternatives(), "rule__Definitions__Alternatives");
					put(grammarAccess.getFailureTypeAccess().getAlternatives(), "rule__FailureType__Alternatives");
					put(grammarAccess.getActualFailureTypeAccess().getAlternatives(), "rule__ActualFailureType__Alternatives");
					put(grammarAccess.getAavoidableAccess().getAlternatives(), "rule__Aavoidable__Alternatives");
					put(grammarAccess.getCavoidableAccess().getAlternatives(), "rule__Cavoidable__Alternatives");
					put(grammarAccess.getIavoidableAccess().getAlternatives(), "rule__Iavoidable__Alternatives");
					put(grammarAccess.getDavoidableAccess().getAlternatives(), "rule__Davoidable__Alternatives");
					put(grammarAccess.getAmitigationAccess().getAlternatives(), "rule__Amitigation__Alternatives");
					put(grammarAccess.getCmitigationAccess().getAlternatives(), "rule__Cmitigation__Alternatives");
					put(grammarAccess.getImitigationAccess().getAlternatives(), "rule__Imitigation__Alternatives");
					put(grammarAccess.getDmitigationAccess().getAlternatives(), "rule__Dmitigation__Alternatives");
					put(grammarAccess.getExpressionAccess().getGroup(), "rule__Expression__Group__0");
					put(grammarAccess.getLhsAccess().getGroup(), "rule__Lhs__Group__0");
					put(grammarAccess.getLhsAccess().getGroup_1(), "rule__Lhs__Group_1__0");
					put(grammarAccess.getRhsAccess().getGroup(), "rule__Rhs__Group__0");
					put(grammarAccess.getRhsAccess().getGroup_1(), "rule__Rhs__Group_1__0");
					put(grammarAccess.getInputExpressionAccess().getGroup(), "rule__InputExpression__Group__0");
					put(grammarAccess.getOutputExpressionAccess().getGroup(), "rule__OutputExpression__Group__0");
					put(grammarAccess.getInFailureExprAccess().getGroup_3(), "rule__InFailureExpr__Group_3__0");
					put(grammarAccess.getInFailureExprAccess().getGroup_3_2(), "rule__InFailureExpr__Group_3_2__0");
					put(grammarAccess.getOutFailureExprAccess().getGroup_3(), "rule__OutFailureExpr__Group_3__0");
					put(grammarAccess.getOutFailureExprAccess().getGroup_3_2(), "rule__OutFailureExpr__Group_3_2__0");
					put(grammarAccess.getFailureDefinitionAccess().getGroup(), "rule__FailureDefinition__Group__0");
					put(grammarAccess.getFailureDefinitionAccess().getGroup_2(), "rule__FailureDefinition__Group_2__0");
					put(grammarAccess.getNoFailureDefinitionAccess().getGroup(), "rule__NoFailureDefinition__Group__0");
					put(grammarAccess.getComplexNofailureDefinitionAccess().getGroup(), "rule__ComplexNofailureDefinition__Group__0");
					put(grammarAccess.getWildcardDefinitionAccess().getGroup(), "rule__WildcardDefinition__Group__0");
					put(grammarAccess.getVariableDefinitionAccess().getGroup(), "rule__VariableDefinition__Group__0");
					put(grammarAccess.getACIDavoidableAccess().getGroup(), "rule__ACIDavoidable__Group__0");
					put(grammarAccess.getACIDMitigationAccess().getGroup(), "rule__ACIDMitigation__Group__0");
					put(grammarAccess.getFQNAccess().getGroup(), "rule__FQN__Group__0");
					put(grammarAccess.getFQNAccess().getGroup_1(), "rule__FQN__Group_1__0");
					put(grammarAccess.getBehaviourAccess().getRulesAssignment(), "rule__Behaviour__RulesAssignment");
					put(grammarAccess.getExpressionAccess().getLhsAssignment_1(), "rule__Expression__LhsAssignment_1");
					put(grammarAccess.getExpressionAccess().getRhsAssignment_3(), "rule__Expression__RhsAssignment_3");
					put(grammarAccess.getLhsAccess().getFailuresAssignment_0(), "rule__Lhs__FailuresAssignment_0");
					put(grammarAccess.getLhsAccess().getFailuresAssignment_1_1(), "rule__Lhs__FailuresAssignment_1_1");
					put(grammarAccess.getRhsAccess().getFailuresAssignment_0(), "rule__Rhs__FailuresAssignment_0");
					put(grammarAccess.getRhsAccess().getFailuresAssignment_1_1(), "rule__Rhs__FailuresAssignment_1_1");
					put(grammarAccess.getInputExpressionAccess().getRefAssignment_0_0(), "rule__InputExpression__RefAssignment_0_0");
					put(grammarAccess.getInputExpressionAccess().getFailureExprAssignment_2(), "rule__InputExpression__FailureExprAssignment_2");
					put(grammarAccess.getOutputExpressionAccess().getRefAssignment_0_0(), "rule__OutputExpression__RefAssignment_0_0");
					put(grammarAccess.getOutputExpressionAccess().getFailureExprAssignment_2(), "rule__OutputExpression__FailureExprAssignment_2");
					put(grammarAccess.getInFailureExprAccess().getFailuresAssignment_0(), "rule__InFailureExpr__FailuresAssignment_0");
					put(grammarAccess.getInFailureExprAccess().getFailuresAssignment_1(), "rule__InFailureExpr__FailuresAssignment_1");
					put(grammarAccess.getInFailureExprAccess().getFailuresAssignment_2(), "rule__InFailureExpr__FailuresAssignment_2");
					put(grammarAccess.getInFailureExprAccess().getFailuresAssignment_3_1(), "rule__InFailureExpr__FailuresAssignment_3_1");
					put(grammarAccess.getInFailureExprAccess().getFailuresAssignment_3_2_1(), "rule__InFailureExpr__FailuresAssignment_3_2_1");
					put(grammarAccess.getInFailureExprAccess().getFailuresAssignment_4(), "rule__InFailureExpr__FailuresAssignment_4");
					put(grammarAccess.getOutFailureExprAccess().getFailuresAssignment_0(), "rule__OutFailureExpr__FailuresAssignment_0");
					put(grammarAccess.getOutFailureExprAccess().getFailuresAssignment_1(), "rule__OutFailureExpr__FailuresAssignment_1");
					put(grammarAccess.getOutFailureExprAccess().getFailuresAssignment_2(), "rule__OutFailureExpr__FailuresAssignment_2");
					put(grammarAccess.getOutFailureExprAccess().getFailuresAssignment_3_1(), "rule__OutFailureExpr__FailuresAssignment_3_1");
					put(grammarAccess.getOutFailureExprAccess().getFailuresAssignment_3_2_1(), "rule__OutFailureExpr__FailuresAssignment_3_2_1");
					put(grammarAccess.getOutFailureExprAccess().getFailuresAssignment_4(), "rule__OutFailureExpr__FailuresAssignment_4");
					put(grammarAccess.getFailureDefinitionAccess().getTypeAssignment_1(), "rule__FailureDefinition__TypeAssignment_1");
					put(grammarAccess.getFailureDefinitionAccess().getAcidAvoidableAssignment_2_1(), "rule__FailureDefinition__AcidAvoidableAssignment_2_1");
					put(grammarAccess.getComplexNofailureDefinitionAccess().getAcidMitigationAssignment_3(), "rule__ComplexNofailureDefinition__AcidMitigationAssignment_3");
					put(grammarAccess.getVariableDefinitionAccess().getVariableNameAssignment_1(), "rule__VariableDefinition__VariableNameAssignment_1");
					put(grammarAccess.getACIDavoidableAccess().getAAssignment_0(), "rule__ACIDavoidable__AAssignment_0");
					put(grammarAccess.getACIDavoidableAccess().getCAssignment_2(), "rule__ACIDavoidable__CAssignment_2");
					put(grammarAccess.getACIDavoidableAccess().getIAssignment_4(), "rule__ACIDavoidable__IAssignment_4");
					put(grammarAccess.getACIDavoidableAccess().getDAssignment_6(), "rule__ACIDavoidable__DAssignment_6");
					put(grammarAccess.getACIDMitigationAccess().getAAssignment_0(), "rule__ACIDMitigation__AAssignment_0");
					put(grammarAccess.getACIDMitigationAccess().getCAssignment_2(), "rule__ACIDMitigation__CAssignment_2");
					put(grammarAccess.getACIDMitigationAccess().getIAssignment_4(), "rule__ACIDMitigation__IAssignment_4");
					put(grammarAccess.getACIDMitigationAccess().getDAssignment_6(), "rule__ACIDMitigation__DAssignment_6");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.polarsys.chess.xtext.ui.contentassist.antlr.internal.InternalFlaDslParser typedParser = (org.polarsys.chess.xtext.ui.contentassist.antlr.internal.InternalFlaDslParser) parser;
			typedParser.entryRuleBehaviour();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public FlaDslGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(FlaDslGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
