/*
* generated by Xtext
*/
grammar InternalFlaDsl;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package org.polarsys.chess.xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.polarsys.chess.xtext.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.polarsys.chess.xtext.services.FlaDslGrammarAccess;

}

@parser::members {

 	private FlaDslGrammarAccess grammarAccess;
 	
    public InternalFlaDslParser(TokenStream input, FlaDslGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "Behaviour";	
   	}
   	
   	@Override
   	protected FlaDslGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleBehaviour
entryRuleBehaviour returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getBehaviourRule()); }
	 iv_ruleBehaviour=ruleBehaviour 
	 { $current=$iv_ruleBehaviour.current; } 
	 EOF 
;

// Rule Behaviour
ruleBehaviour returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		{ 
	        newCompositeNode(grammarAccess.getBehaviourAccess().getRulesExpressionParserRuleCall_0()); 
	    }
		lv_rules_0_0=ruleExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getBehaviourRule());
	        }
       		add(
       			$current, 
       			"rules",
        		lv_rules_0_0, 
        		"Expression");
	        afterParserOrEnumRuleCall();
	    }

)
)+
;





// Entry rule entryRuleExpression
entryRuleExpression returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getExpressionRule()); }
	 iv_ruleExpression=ruleExpression 
	 { $current=$iv_ruleExpression.current; } 
	 EOF 
;

// Rule Expression
ruleExpression returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='FLA:' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getExpressionAccess().getFLAKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getExpressionAccess().getLhsLhsParserRuleCall_1_0()); 
	    }
		lv_lhs_1_0=ruleLhs		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getExpressionRule());
	        }
       		set(
       			$current, 
       			"lhs",
        		lv_lhs_1_0, 
        		"Lhs");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_2='->' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getExpressionAccess().getHyphenMinusGreaterThanSignKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getExpressionAccess().getRhsRhsParserRuleCall_3_0()); 
	    }
		lv_rhs_3_0=ruleRhs		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getExpressionRule());
	        }
       		set(
       			$current, 
       			"rhs",
        		lv_rhs_3_0, 
        		"Rhs");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_4=';' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getExpressionAccess().getSemicolonKeyword_4());
    }
)
;





// Entry rule entryRuleLhs
entryRuleLhs returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getLhsRule()); }
	 iv_ruleLhs=ruleLhs 
	 { $current=$iv_ruleLhs.current; } 
	 EOF 
;

// Rule Lhs
ruleLhs returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getLhsAccess().getFailuresInputExpressionParserRuleCall_0_0()); 
	    }
		lv_failures_0_0=ruleInputExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLhsRule());
	        }
       		add(
       			$current, 
       			"failures",
        		lv_failures_0_0, 
        		"InputExpression");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1=',' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getLhsAccess().getCommaKeyword_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getLhsAccess().getFailuresInputExpressionParserRuleCall_1_1_0()); 
	    }
		lv_failures_2_0=ruleInputExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLhsRule());
	        }
       		add(
       			$current, 
       			"failures",
        		lv_failures_2_0, 
        		"InputExpression");
	        afterParserOrEnumRuleCall();
	    }

)
))*)
;





// Entry rule entryRuleRhs
entryRuleRhs returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getRhsRule()); }
	 iv_ruleRhs=ruleRhs 
	 { $current=$iv_ruleRhs.current; } 
	 EOF 
;

// Rule Rhs
ruleRhs returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getRhsAccess().getFailuresOutputExpressionParserRuleCall_0_0()); 
	    }
		lv_failures_0_0=ruleOutputExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRhsRule());
	        }
       		add(
       			$current, 
       			"failures",
        		lv_failures_0_0, 
        		"OutputExpression");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1=',' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getRhsAccess().getCommaKeyword_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getRhsAccess().getFailuresOutputExpressionParserRuleCall_1_1_0()); 
	    }
		lv_failures_2_0=ruleOutputExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRhsRule());
	        }
       		add(
       			$current, 
       			"failures",
        		lv_failures_2_0, 
        		"OutputExpression");
	        afterParserOrEnumRuleCall();
	    }

)
))*)
;





// Entry rule entryRuleInputExpression
entryRuleInputExpression returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getInputExpressionRule()); }
	 iv_ruleInputExpression=ruleInputExpression 
	 { $current=$iv_ruleInputExpression.current; } 
	 EOF 
;

// Rule InputExpression
ruleInputExpression returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getInputExpressionRule());
	        }
        }
	otherlv_0=RULE_ID
	{
		newLeafNode(otherlv_0, grammarAccess.getInputExpressionAccess().getRefPortCrossReference_0_0_0()); 
	}

)
)
    |	otherlv_1='undefined' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getInputExpressionAccess().getUndefinedKeyword_0_1());
    }
)	otherlv_2='.' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getInputExpressionAccess().getFullStopKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getInputExpressionAccess().getFailureExprInFailureExprParserRuleCall_2_0()); 
	    }
		lv_failureExpr_3_0=ruleInFailureExpr		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getInputExpressionRule());
	        }
       		set(
       			$current, 
       			"failureExpr",
        		lv_failureExpr_3_0, 
        		"InFailureExpr");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleOutputExpression
entryRuleOutputExpression returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getOutputExpressionRule()); }
	 iv_ruleOutputExpression=ruleOutputExpression 
	 { $current=$iv_ruleOutputExpression.current; } 
	 EOF 
;

// Rule OutputExpression
ruleOutputExpression returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getOutputExpressionRule());
	        }
        }
	otherlv_0=RULE_ID
	{
		newLeafNode(otherlv_0, grammarAccess.getOutputExpressionAccess().getRefPortCrossReference_0_0_0()); 
	}

)
)
    |	otherlv_1='undefined' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getOutputExpressionAccess().getUndefinedKeyword_0_1());
    }
)	otherlv_2='.' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getOutputExpressionAccess().getFullStopKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getOutputExpressionAccess().getFailureExprOutFailureExprParserRuleCall_2_0()); 
	    }
		lv_failureExpr_3_0=ruleOutFailureExpr		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getOutputExpressionRule());
	        }
       		set(
       			$current, 
       			"failureExpr",
        		lv_failureExpr_3_0, 
        		"OutFailureExpr");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleInFailureExpr
entryRuleInFailureExpr returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getInFailureExprRule()); }
	 iv_ruleInFailureExpr=ruleInFailureExpr 
	 { $current=$iv_ruleInFailureExpr.current; } 
	 EOF 
;

// Rule InFailureExpr
ruleInFailureExpr returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getInFailureExprAccess().getFailuresWildcardDefinitionParserRuleCall_0_0()); 
	    }
		lv_failures_0_0=ruleWildcardDefinition		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getInFailureExprRule());
	        }
       		add(
       			$current, 
       			"failures",
        		lv_failures_0_0, 
        		"WildcardDefinition");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getInFailureExprAccess().getFailuresNoFailureDefinitionParserRuleCall_1_0()); 
	    }
		lv_failures_1_0=ruleNoFailureDefinition		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getInFailureExprRule());
	        }
       		add(
       			$current, 
       			"failures",
        		lv_failures_1_0, 
        		"NoFailureDefinition");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getInFailureExprAccess().getFailuresFailureDefinitionParserRuleCall_2_0()); 
	    }
		lv_failures_2_0=ruleFailureDefinition		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getInFailureExprRule());
	        }
       		add(
       			$current, 
       			"failures",
        		lv_failures_2_0, 
        		"FailureDefinition");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(	otherlv_3='{' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getInFailureExprAccess().getLeftCurlyBracketKeyword_3_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getInFailureExprAccess().getFailuresFailureDefinitionParserRuleCall_3_1_0()); 
	    }
		lv_failures_4_0=ruleFailureDefinition		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getInFailureExprRule());
	        }
       		add(
       			$current, 
       			"failures",
        		lv_failures_4_0, 
        		"FailureDefinition");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_5=',' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getInFailureExprAccess().getCommaKeyword_3_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getInFailureExprAccess().getFailuresFailureDefinitionParserRuleCall_3_2_1_0()); 
	    }
		lv_failures_6_0=ruleFailureDefinition		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getInFailureExprRule());
	        }
       		add(
       			$current, 
       			"failures",
        		lv_failures_6_0, 
        		"FailureDefinition");
	        afterParserOrEnumRuleCall();
	    }

)
))+	otherlv_7='}' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getInFailureExprAccess().getRightCurlyBracketKeyword_3_3());
    }
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getInFailureExprAccess().getFailuresVariableDefinitionParserRuleCall_4_0()); 
	    }
		lv_failures_8_0=ruleVariableDefinition		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getInFailureExprRule());
	        }
       		add(
       			$current, 
       			"failures",
        		lv_failures_8_0, 
        		"VariableDefinition");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleOutFailureExpr
entryRuleOutFailureExpr returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getOutFailureExprRule()); }
	 iv_ruleOutFailureExpr=ruleOutFailureExpr 
	 { $current=$iv_ruleOutFailureExpr.current; } 
	 EOF 
;

// Rule OutFailureExpr
ruleOutFailureExpr returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getOutFailureExprAccess().getFailuresNoFailureDefinitionParserRuleCall_0_0()); 
	    }
		lv_failures_0_0=ruleNoFailureDefinition		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getOutFailureExprRule());
	        }
       		add(
       			$current, 
       			"failures",
        		lv_failures_0_0, 
        		"NoFailureDefinition");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getOutFailureExprAccess().getFailuresComplexNofailureDefinitionParserRuleCall_1_0()); 
	    }
		lv_failures_1_0=ruleComplexNofailureDefinition		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getOutFailureExprRule());
	        }
       		add(
       			$current, 
       			"failures",
        		lv_failures_1_0, 
        		"ComplexNofailureDefinition");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getOutFailureExprAccess().getFailuresFailureDefinitionParserRuleCall_2_0()); 
	    }
		lv_failures_2_0=ruleFailureDefinition		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getOutFailureExprRule());
	        }
       		add(
       			$current, 
       			"failures",
        		lv_failures_2_0, 
        		"FailureDefinition");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(	otherlv_3='{' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getOutFailureExprAccess().getLeftCurlyBracketKeyword_3_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getOutFailureExprAccess().getFailuresFailureDefinitionParserRuleCall_3_1_0()); 
	    }
		lv_failures_4_0=ruleFailureDefinition		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getOutFailureExprRule());
	        }
       		add(
       			$current, 
       			"failures",
        		lv_failures_4_0, 
        		"FailureDefinition");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_5=',' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getOutFailureExprAccess().getCommaKeyword_3_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getOutFailureExprAccess().getFailuresFailureDefinitionParserRuleCall_3_2_1_0()); 
	    }
		lv_failures_6_0=ruleFailureDefinition		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getOutFailureExprRule());
	        }
       		add(
       			$current, 
       			"failures",
        		lv_failures_6_0, 
        		"FailureDefinition");
	        afterParserOrEnumRuleCall();
	    }

)
))+	otherlv_7='}' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getOutFailureExprAccess().getRightCurlyBracketKeyword_3_3());
    }
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getOutFailureExprAccess().getFailuresVariableDefinitionParserRuleCall_4_0()); 
	    }
		lv_failures_8_0=ruleVariableDefinition		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getOutFailureExprRule());
	        }
       		add(
       			$current, 
       			"failures",
        		lv_failures_8_0, 
        		"VariableDefinition");
	        afterParserOrEnumRuleCall();
	    }

)
))
;







// Entry rule entryRuleFailureDefinition
entryRuleFailureDefinition returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getFailureDefinitionRule()); }
	 iv_ruleFailureDefinition=ruleFailureDefinition 
	 { $current=$iv_ruleFailureDefinition.current; } 
	 EOF 
;

// Rule FailureDefinition
ruleFailureDefinition returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getFailureDefinitionAccess().getFailureDefinitionAction_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getFailureDefinitionAccess().getTypeActualFailureTypeEnumRuleCall_1_0()); 
	    }
		lv_type_1_0=ruleActualFailureType		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFailureDefinitionRule());
	        }
       		set(
       			$current, 
       			"type",
        		lv_type_1_0, 
        		"ActualFailureType");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_2='.' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getFailureDefinitionAccess().getFullStopKeyword_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getFailureDefinitionAccess().getAcidAvoidableACIDavoidableParserRuleCall_2_1_0()); 
	    }
		lv_acidAvoidable_3_0=ruleACIDavoidable		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFailureDefinitionRule());
	        }
       		set(
       			$current, 
       			"acidAvoidable",
        		lv_acidAvoidable_3_0, 
        		"ACIDavoidable");
	        afterParserOrEnumRuleCall();
	    }

)
))?)
;





// Entry rule entryRuleNoFailureDefinition
entryRuleNoFailureDefinition returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getNoFailureDefinitionRule()); }
	 iv_ruleNoFailureDefinition=ruleNoFailureDefinition 
	 { $current=$iv_ruleNoFailureDefinition.current; } 
	 EOF 
;

// Rule NoFailureDefinition
ruleNoFailureDefinition returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getNoFailureDefinitionAccess().getNoFailureDefinitionAction_0(),
            $current);
    }
)	otherlv_1='noFailure' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getNoFailureDefinitionAccess().getNoFailureKeyword_1());
    }
)
;





// Entry rule entryRuleComplexNofailureDefinition
entryRuleComplexNofailureDefinition returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getComplexNofailureDefinitionRule()); }
	 iv_ruleComplexNofailureDefinition=ruleComplexNofailureDefinition 
	 { $current=$iv_ruleComplexNofailureDefinition.current; } 
	 EOF 
;

// Rule ComplexNofailureDefinition
ruleComplexNofailureDefinition returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getComplexNofailureDefinitionAccess().getNoFailureDefinitionAction_0(),
            $current);
    }
)	otherlv_1='noFailure' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getComplexNofailureDefinitionAccess().getNoFailureKeyword_1());
    }
	otherlv_2='.' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getComplexNofailureDefinitionAccess().getFullStopKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getComplexNofailureDefinitionAccess().getAcidMitigationACIDMitigationParserRuleCall_3_0()); 
	    }
		lv_acidMitigation_3_0=ruleACIDMitigation		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getComplexNofailureDefinitionRule());
	        }
       		set(
       			$current, 
       			"acidMitigation",
        		lv_acidMitigation_3_0, 
        		"ACIDMitigation");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleWildcardDefinition
entryRuleWildcardDefinition returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getWildcardDefinitionRule()); }
	 iv_ruleWildcardDefinition=ruleWildcardDefinition 
	 { $current=$iv_ruleWildcardDefinition.current; } 
	 EOF 
;

// Rule WildcardDefinition
ruleWildcardDefinition returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getWildcardDefinitionAccess().getWildcardDefinitionAction_0(),
            $current);
    }
)	otherlv_1='wildcard' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getWildcardDefinitionAccess().getWildcardKeyword_1());
    }
)
;





// Entry rule entryRuleVariableDefinition
entryRuleVariableDefinition returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVariableDefinitionRule()); }
	 iv_ruleVariableDefinition=ruleVariableDefinition 
	 { $current=$iv_ruleVariableDefinition.current; } 
	 EOF 
;

// Rule VariableDefinition
ruleVariableDefinition returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getVariableDefinitionAccess().getVariableDefinitionAction_0(),
            $current);
    }
)(
(
		lv_variableName_1_0=RULE_ID
		{
			newLeafNode(lv_variableName_1_0, grammarAccess.getVariableDefinitionAccess().getVariableNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getVariableDefinitionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"variableName",
        		lv_variableName_1_0, 
        		"ID");
	    }

)
))
;





// Entry rule entryRuleACIDavoidable
entryRuleACIDavoidable returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getACIDavoidableRule()); }
	 iv_ruleACIDavoidable=ruleACIDavoidable 
	 { $current=$iv_ruleACIDavoidable.current; } 
	 EOF 
;

// Rule ACIDavoidable
ruleACIDavoidable returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getACIDavoidableAccess().getAAavoidableEnumRuleCall_0_0()); 
	    }
		lv_a_0_0=ruleAavoidable		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getACIDavoidableRule());
	        }
       		set(
       			$current, 
       			"a",
        		lv_a_0_0, 
        		"Aavoidable");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_1='.' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getACIDavoidableAccess().getFullStopKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getACIDavoidableAccess().getCCavoidableEnumRuleCall_2_0()); 
	    }
		lv_c_2_0=ruleCavoidable		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getACIDavoidableRule());
	        }
       		set(
       			$current, 
       			"c",
        		lv_c_2_0, 
        		"Cavoidable");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3='.' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getACIDavoidableAccess().getFullStopKeyword_3());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getACIDavoidableAccess().getIIavoidableEnumRuleCall_4_0()); 
	    }
		lv_i_4_0=ruleIavoidable		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getACIDavoidableRule());
	        }
       		set(
       			$current, 
       			"i",
        		lv_i_4_0, 
        		"Iavoidable");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_5='.' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getACIDavoidableAccess().getFullStopKeyword_5());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getACIDavoidableAccess().getDDavoidableEnumRuleCall_6_0()); 
	    }
		lv_d_6_0=ruleDavoidable		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getACIDavoidableRule());
	        }
       		set(
       			$current, 
       			"d",
        		lv_d_6_0, 
        		"Davoidable");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleACIDMitigation
entryRuleACIDMitigation returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getACIDMitigationRule()); }
	 iv_ruleACIDMitigation=ruleACIDMitigation 
	 { $current=$iv_ruleACIDMitigation.current; } 
	 EOF 
;

// Rule ACIDMitigation
ruleACIDMitigation returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getACIDMitigationAccess().getAAmitigationEnumRuleCall_0_0()); 
	    }
		lv_a_0_0=ruleAmitigation		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getACIDMitigationRule());
	        }
       		set(
       			$current, 
       			"a",
        		lv_a_0_0, 
        		"Amitigation");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_1='.' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getACIDMitigationAccess().getFullStopKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getACIDMitigationAccess().getCCmitigationEnumRuleCall_2_0()); 
	    }
		lv_c_2_0=ruleCmitigation		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getACIDMitigationRule());
	        }
       		set(
       			$current, 
       			"c",
        		lv_c_2_0, 
        		"Cmitigation");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3='.' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getACIDMitigationAccess().getFullStopKeyword_3());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getACIDMitigationAccess().getIImitigationEnumRuleCall_4_0()); 
	    }
		lv_i_4_0=ruleImitigation		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getACIDMitigationRule());
	        }
       		set(
       			$current, 
       			"i",
        		lv_i_4_0, 
        		"Imitigation");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_5='.' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getACIDMitigationAccess().getFullStopKeyword_5());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getACIDMitigationAccess().getDDmitigationEnumRuleCall_6_0()); 
	    }
		lv_d_6_0=ruleDmitigation		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getACIDMitigationRule());
	        }
       		set(
       			$current, 
       			"d",
        		lv_d_6_0, 
        		"Dmitigation");
	        afterParserOrEnumRuleCall();
	    }

)
))
;









// Rule ActualFailureType
ruleActualFailureType returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='early' 
	{
        $current = grammarAccess.getActualFailureTypeAccess().getEARLYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getActualFailureTypeAccess().getEARLYEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='late' 
	{
        $current = grammarAccess.getActualFailureTypeAccess().getLATEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getActualFailureTypeAccess().getLATEEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='commission' 
	{
        $current = grammarAccess.getActualFailureTypeAccess().getCOMMISSIONEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getActualFailureTypeAccess().getCOMMISSIONEnumLiteralDeclaration_2()); 
    }
)
    |(	enumLiteral_3='omission' 
	{
        $current = grammarAccess.getActualFailureTypeAccess().getOMISSIONEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_3, grammarAccess.getActualFailureTypeAccess().getOMISSIONEnumLiteralDeclaration_3()); 
    }
)
    |(	enumLiteral_4='valueSubtle' 
	{
        $current = grammarAccess.getActualFailureTypeAccess().getVALUE_SUBTLEEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_4, grammarAccess.getActualFailureTypeAccess().getVALUE_SUBTLEEnumLiteralDeclaration_4()); 
    }
)
    |(	enumLiteral_5='valueCoarse' 
	{
        $current = grammarAccess.getActualFailureTypeAccess().getVALUE_COARSEEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_5, grammarAccess.getActualFailureTypeAccess().getVALUE_COARSEEnumLiteralDeclaration_5()); 
    }
));







// Rule Aavoidable
ruleAavoidable returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='incompletion' 
	{
        $current = grammarAccess.getAavoidableAccess().getINCOMPLETIONEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getAavoidableAccess().getINCOMPLETIONEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='none' 
	{
        $current = grammarAccess.getAavoidableAccess().getNONEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getAavoidableAccess().getNONEEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='unspecified' 
	{
        $current = grammarAccess.getAavoidableAccess().getUNSPECIFIEDEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getAavoidableAccess().getUNSPECIFIEDEnumLiteralDeclaration_2()); 
    }
));



// Rule Cavoidable
ruleCavoidable returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='inconsistency' 
	{
        $current = grammarAccess.getCavoidableAccess().getINCONSISTENCYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getCavoidableAccess().getINCONSISTENCYEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='none' 
	{
        $current = grammarAccess.getCavoidableAccess().getNONEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getCavoidableAccess().getNONEEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='unspecified' 
	{
        $current = grammarAccess.getCavoidableAccess().getUNSPECIFIEDEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getCavoidableAccess().getUNSPECIFIEDEnumLiteralDeclaration_2()); 
    }
));



// Rule Iavoidable
ruleIavoidable returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='interference' 
	{
        $current = grammarAccess.getIavoidableAccess().getINTERFERENCEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getIavoidableAccess().getINTERFERENCEEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='none' 
	{
        $current = grammarAccess.getIavoidableAccess().getNONEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getIavoidableAccess().getNONEEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='unspecified' 
	{
        $current = grammarAccess.getIavoidableAccess().getUNSPECIFIEDEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getIavoidableAccess().getUNSPECIFIEDEnumLiteralDeclaration_2()); 
    }
));



// Rule Davoidable
ruleDavoidable returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='impermanence' 
	{
        $current = grammarAccess.getDavoidableAccess().getIMPERMANENCEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getDavoidableAccess().getIMPERMANENCEEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='none' 
	{
        $current = grammarAccess.getDavoidableAccess().getNONEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getDavoidableAccess().getNONEEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='unspecified' 
	{
        $current = grammarAccess.getDavoidableAccess().getUNSPECIFIEDEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getDavoidableAccess().getUNSPECIFIEDEnumLiteralDeclaration_2()); 
    }
));



// Rule Amitigation
ruleAmitigation returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='all_or_nothing' 
	{
        $current = grammarAccess.getAmitigationAccess().getALL_OR_NOTHINGEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getAmitigationAccess().getALL_OR_NOTHINGEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='all_or_compensation' 
	{
        $current = grammarAccess.getAmitigationAccess().getALL_OR_COMPENSATIONEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getAmitigationAccess().getALL_OR_COMPENSATIONEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='none' 
	{
        $current = grammarAccess.getAmitigationAccess().getNONEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getAmitigationAccess().getNONEEnumLiteralDeclaration_2()); 
    }
)
    |(	enumLiteral_3='unspecified' 
	{
        $current = grammarAccess.getAmitigationAccess().getUNSPECIFIEDEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_3, grammarAccess.getAmitigationAccess().getUNSPECIFIEDEnumLiteralDeclaration_3()); 
    }
));



// Rule Cmitigation
ruleCmitigation returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='full_consistency' 
	{
        $current = grammarAccess.getCmitigationAccess().getFULL_CONSISTENCYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getCmitigationAccess().getFULL_CONSISTENCYEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='range_violation_allowed' 
	{
        $current = grammarAccess.getCmitigationAccess().getRANGE_VIOLATION_ALLOWEDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getCmitigationAccess().getRANGE_VIOLATION_ALLOWEDEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='none' 
	{
        $current = grammarAccess.getCmitigationAccess().getNONEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getCmitigationAccess().getNONEEnumLiteralDeclaration_2()); 
    }
)
    |(	enumLiteral_3='unspecified' 
	{
        $current = grammarAccess.getCmitigationAccess().getUNSPECIFIEDEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_3, grammarAccess.getCmitigationAccess().getUNSPECIFIEDEnumLiteralDeclaration_3()); 
    }
));



// Rule Imitigation
ruleImitigation returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='serializable' 
	{
        $current = grammarAccess.getImitigationAccess().getSERIALIZABLEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getImitigationAccess().getSERIALIZABLEEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='portable_level' 
	{
        $current = grammarAccess.getImitigationAccess().getPORTABLE_LEVELEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getImitigationAccess().getPORTABLE_LEVELEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='none' 
	{
        $current = grammarAccess.getImitigationAccess().getNONEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getImitigationAccess().getNONEEnumLiteralDeclaration_2()); 
    }
)
    |(	enumLiteral_3='unspecified' 
	{
        $current = grammarAccess.getImitigationAccess().getUNSPECIFIEDEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_3, grammarAccess.getImitigationAccess().getUNSPECIFIEDEnumLiteralDeclaration_3()); 
    }
));



// Rule Dmitigation
ruleDmitigation returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='no_loss' 
	{
        $current = grammarAccess.getDmitigationAccess().getNO_LOSSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getDmitigationAccess().getNO_LOSSEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='partial_loss_allowed' 
	{
        $current = grammarAccess.getDmitigationAccess().getPARTIAL_LOSS_ALLOWEDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getDmitigationAccess().getPARTIAL_LOSS_ALLOWEDEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='none' 
	{
        $current = grammarAccess.getDmitigationAccess().getNONEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getDmitigationAccess().getNONEEnumLiteralDeclaration_2()); 
    }
)
    |(	enumLiteral_3='unspecified' 
	{
        $current = grammarAccess.getDmitigationAccess().getUNSPECIFIEDEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_3, grammarAccess.getDmitigationAccess().getUNSPECIFIEDEnumLiteralDeclaration_3()); 
    }
));



RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;

