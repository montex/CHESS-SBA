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



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalFlaDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'FLA:'", "'->'", "';'", "','", "'undefined'", "'.'", "'{'", "'}'", "'noFailure'", "'wildcard'", "'early'", "'late'", "'commission'", "'omission'", "'valueSubtle'", "'valueCoarse'", "'incompletion'", "'none'", "'unspecified'", "'inconsistency'", "'interference'", "'impermanence'", "'all_or_nothing'", "'all_or_compensation'", "'full_consistency'", "'range_violation_allowed'", "'serializable'", "'portable_level'", "'no_loss'", "'partial_loss_allowed'"
    };
    public static final int RULE_ID=4;
    public static final int T__40=40;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=6;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int T__37=37;
    public static final int T__12=12;
    public static final int T__38=38;
    public static final int T__11=11;
    public static final int T__39=39;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalFlaDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalFlaDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalFlaDslParser.tokenNames; }
    public String getGrammarFileName() { return "../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g"; }



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



    // $ANTLR start "entryRuleBehaviour"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:68:1: entryRuleBehaviour returns [EObject current=null] : iv_ruleBehaviour= ruleBehaviour EOF ;
    public final EObject entryRuleBehaviour() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviour = null;


        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:69:2: (iv_ruleBehaviour= ruleBehaviour EOF )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:70:2: iv_ruleBehaviour= ruleBehaviour EOF
            {
             newCompositeNode(grammarAccess.getBehaviourRule()); 
            pushFollow(FOLLOW_ruleBehaviour_in_entryRuleBehaviour75);
            iv_ruleBehaviour=ruleBehaviour();

            state._fsp--;

             current =iv_ruleBehaviour; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBehaviour85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBehaviour"


    // $ANTLR start "ruleBehaviour"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:77:1: ruleBehaviour returns [EObject current=null] : ( (lv_rules_0_0= ruleExpression ) )+ ;
    public final EObject ruleBehaviour() throws RecognitionException {
        EObject current = null;

        EObject lv_rules_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:80:28: ( ( (lv_rules_0_0= ruleExpression ) )+ )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:81:1: ( (lv_rules_0_0= ruleExpression ) )+
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:81:1: ( (lv_rules_0_0= ruleExpression ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:82:1: (lv_rules_0_0= ruleExpression )
            	    {
            	    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:82:1: (lv_rules_0_0= ruleExpression )
            	    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:83:3: lv_rules_0_0= ruleExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getBehaviourAccess().getRulesExpressionParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleExpression_in_ruleBehaviour130);
            	    lv_rules_0_0=ruleExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getBehaviourRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"rules",
            	            		lv_rules_0_0, 
            	            		"Expression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBehaviour"


    // $ANTLR start "entryRuleExpression"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:107:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:108:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:109:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression166);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression176); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:116:1: ruleExpression returns [EObject current=null] : (otherlv_0= 'FLA:' ( (lv_lhs_1_0= ruleLhs ) ) otherlv_2= '->' ( (lv_rhs_3_0= ruleRhs ) ) otherlv_4= ';' ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_lhs_1_0 = null;

        EObject lv_rhs_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:119:28: ( (otherlv_0= 'FLA:' ( (lv_lhs_1_0= ruleLhs ) ) otherlv_2= '->' ( (lv_rhs_3_0= ruleRhs ) ) otherlv_4= ';' ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:120:1: (otherlv_0= 'FLA:' ( (lv_lhs_1_0= ruleLhs ) ) otherlv_2= '->' ( (lv_rhs_3_0= ruleRhs ) ) otherlv_4= ';' )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:120:1: (otherlv_0= 'FLA:' ( (lv_lhs_1_0= ruleLhs ) ) otherlv_2= '->' ( (lv_rhs_3_0= ruleRhs ) ) otherlv_4= ';' )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:120:3: otherlv_0= 'FLA:' ( (lv_lhs_1_0= ruleLhs ) ) otherlv_2= '->' ( (lv_rhs_3_0= ruleRhs ) ) otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleExpression213); 

                	newLeafNode(otherlv_0, grammarAccess.getExpressionAccess().getFLAKeyword_0());
                
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:124:1: ( (lv_lhs_1_0= ruleLhs ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:125:1: (lv_lhs_1_0= ruleLhs )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:125:1: (lv_lhs_1_0= ruleLhs )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:126:3: lv_lhs_1_0= ruleLhs
            {
             
            	        newCompositeNode(grammarAccess.getExpressionAccess().getLhsLhsParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleLhs_in_ruleExpression234);
            lv_lhs_1_0=ruleLhs();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"lhs",
                    		lv_lhs_1_0, 
                    		"Lhs");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleExpression246); 

                	newLeafNode(otherlv_2, grammarAccess.getExpressionAccess().getHyphenMinusGreaterThanSignKeyword_2());
                
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:146:1: ( (lv_rhs_3_0= ruleRhs ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:147:1: (lv_rhs_3_0= ruleRhs )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:147:1: (lv_rhs_3_0= ruleRhs )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:148:3: lv_rhs_3_0= ruleRhs
            {
             
            	        newCompositeNode(grammarAccess.getExpressionAccess().getRhsRhsParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleRhs_in_ruleExpression267);
            lv_rhs_3_0=ruleRhs();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"rhs",
                    		lv_rhs_3_0, 
                    		"Rhs");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleExpression279); 

                	newLeafNode(otherlv_4, grammarAccess.getExpressionAccess().getSemicolonKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleLhs"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:176:1: entryRuleLhs returns [EObject current=null] : iv_ruleLhs= ruleLhs EOF ;
    public final EObject entryRuleLhs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLhs = null;


        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:177:2: (iv_ruleLhs= ruleLhs EOF )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:178:2: iv_ruleLhs= ruleLhs EOF
            {
             newCompositeNode(grammarAccess.getLhsRule()); 
            pushFollow(FOLLOW_ruleLhs_in_entryRuleLhs315);
            iv_ruleLhs=ruleLhs();

            state._fsp--;

             current =iv_ruleLhs; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLhs325); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLhs"


    // $ANTLR start "ruleLhs"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:185:1: ruleLhs returns [EObject current=null] : ( ( (lv_failures_0_0= ruleInputExpression ) ) (otherlv_1= ',' ( (lv_failures_2_0= ruleInputExpression ) ) )* ) ;
    public final EObject ruleLhs() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_failures_0_0 = null;

        EObject lv_failures_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:188:28: ( ( ( (lv_failures_0_0= ruleInputExpression ) ) (otherlv_1= ',' ( (lv_failures_2_0= ruleInputExpression ) ) )* ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:189:1: ( ( (lv_failures_0_0= ruleInputExpression ) ) (otherlv_1= ',' ( (lv_failures_2_0= ruleInputExpression ) ) )* )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:189:1: ( ( (lv_failures_0_0= ruleInputExpression ) ) (otherlv_1= ',' ( (lv_failures_2_0= ruleInputExpression ) ) )* )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:189:2: ( (lv_failures_0_0= ruleInputExpression ) ) (otherlv_1= ',' ( (lv_failures_2_0= ruleInputExpression ) ) )*
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:189:2: ( (lv_failures_0_0= ruleInputExpression ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:190:1: (lv_failures_0_0= ruleInputExpression )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:190:1: (lv_failures_0_0= ruleInputExpression )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:191:3: lv_failures_0_0= ruleInputExpression
            {
             
            	        newCompositeNode(grammarAccess.getLhsAccess().getFailuresInputExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleInputExpression_in_ruleLhs371);
            lv_failures_0_0=ruleInputExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLhsRule());
            	        }
                   		add(
                   			current, 
                   			"failures",
                    		lv_failures_0_0, 
                    		"InputExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:207:2: (otherlv_1= ',' ( (lv_failures_2_0= ruleInputExpression ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:207:4: otherlv_1= ',' ( (lv_failures_2_0= ruleInputExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleLhs384); 

            	        	newLeafNode(otherlv_1, grammarAccess.getLhsAccess().getCommaKeyword_1_0());
            	        
            	    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:211:1: ( (lv_failures_2_0= ruleInputExpression ) )
            	    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:212:1: (lv_failures_2_0= ruleInputExpression )
            	    {
            	    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:212:1: (lv_failures_2_0= ruleInputExpression )
            	    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:213:3: lv_failures_2_0= ruleInputExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLhsAccess().getFailuresInputExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleInputExpression_in_ruleLhs405);
            	    lv_failures_2_0=ruleInputExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getLhsRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"failures",
            	            		lv_failures_2_0, 
            	            		"InputExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLhs"


    // $ANTLR start "entryRuleRhs"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:237:1: entryRuleRhs returns [EObject current=null] : iv_ruleRhs= ruleRhs EOF ;
    public final EObject entryRuleRhs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRhs = null;


        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:238:2: (iv_ruleRhs= ruleRhs EOF )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:239:2: iv_ruleRhs= ruleRhs EOF
            {
             newCompositeNode(grammarAccess.getRhsRule()); 
            pushFollow(FOLLOW_ruleRhs_in_entryRuleRhs443);
            iv_ruleRhs=ruleRhs();

            state._fsp--;

             current =iv_ruleRhs; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRhs453); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRhs"


    // $ANTLR start "ruleRhs"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:246:1: ruleRhs returns [EObject current=null] : ( ( (lv_failures_0_0= ruleOutputExpression ) ) (otherlv_1= ',' ( (lv_failures_2_0= ruleOutputExpression ) ) )* ) ;
    public final EObject ruleRhs() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_failures_0_0 = null;

        EObject lv_failures_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:249:28: ( ( ( (lv_failures_0_0= ruleOutputExpression ) ) (otherlv_1= ',' ( (lv_failures_2_0= ruleOutputExpression ) ) )* ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:250:1: ( ( (lv_failures_0_0= ruleOutputExpression ) ) (otherlv_1= ',' ( (lv_failures_2_0= ruleOutputExpression ) ) )* )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:250:1: ( ( (lv_failures_0_0= ruleOutputExpression ) ) (otherlv_1= ',' ( (lv_failures_2_0= ruleOutputExpression ) ) )* )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:250:2: ( (lv_failures_0_0= ruleOutputExpression ) ) (otherlv_1= ',' ( (lv_failures_2_0= ruleOutputExpression ) ) )*
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:250:2: ( (lv_failures_0_0= ruleOutputExpression ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:251:1: (lv_failures_0_0= ruleOutputExpression )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:251:1: (lv_failures_0_0= ruleOutputExpression )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:252:3: lv_failures_0_0= ruleOutputExpression
            {
             
            	        newCompositeNode(grammarAccess.getRhsAccess().getFailuresOutputExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleOutputExpression_in_ruleRhs499);
            lv_failures_0_0=ruleOutputExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRhsRule());
            	        }
                   		add(
                   			current, 
                   			"failures",
                    		lv_failures_0_0, 
                    		"OutputExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:268:2: (otherlv_1= ',' ( (lv_failures_2_0= ruleOutputExpression ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:268:4: otherlv_1= ',' ( (lv_failures_2_0= ruleOutputExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleRhs512); 

            	        	newLeafNode(otherlv_1, grammarAccess.getRhsAccess().getCommaKeyword_1_0());
            	        
            	    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:272:1: ( (lv_failures_2_0= ruleOutputExpression ) )
            	    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:273:1: (lv_failures_2_0= ruleOutputExpression )
            	    {
            	    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:273:1: (lv_failures_2_0= ruleOutputExpression )
            	    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:274:3: lv_failures_2_0= ruleOutputExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRhsAccess().getFailuresOutputExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleOutputExpression_in_ruleRhs533);
            	    lv_failures_2_0=ruleOutputExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRhsRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"failures",
            	            		lv_failures_2_0, 
            	            		"OutputExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRhs"


    // $ANTLR start "entryRuleInputExpression"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:298:1: entryRuleInputExpression returns [EObject current=null] : iv_ruleInputExpression= ruleInputExpression EOF ;
    public final EObject entryRuleInputExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInputExpression = null;


        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:299:2: (iv_ruleInputExpression= ruleInputExpression EOF )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:300:2: iv_ruleInputExpression= ruleInputExpression EOF
            {
             newCompositeNode(grammarAccess.getInputExpressionRule()); 
            pushFollow(FOLLOW_ruleInputExpression_in_entryRuleInputExpression571);
            iv_ruleInputExpression=ruleInputExpression();

            state._fsp--;

             current =iv_ruleInputExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInputExpression581); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInputExpression"


    // $ANTLR start "ruleInputExpression"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:307:1: ruleInputExpression returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) | otherlv_1= 'undefined' ) otherlv_2= '.' ( (lv_failureExpr_3_0= ruleInFailureExpr ) ) ) ;
    public final EObject ruleInputExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_failureExpr_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:310:28: ( ( ( ( (otherlv_0= RULE_ID ) ) | otherlv_1= 'undefined' ) otherlv_2= '.' ( (lv_failureExpr_3_0= ruleInFailureExpr ) ) ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:311:1: ( ( ( (otherlv_0= RULE_ID ) ) | otherlv_1= 'undefined' ) otherlv_2= '.' ( (lv_failureExpr_3_0= ruleInFailureExpr ) ) )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:311:1: ( ( ( (otherlv_0= RULE_ID ) ) | otherlv_1= 'undefined' ) otherlv_2= '.' ( (lv_failureExpr_3_0= ruleInFailureExpr ) ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:311:2: ( ( (otherlv_0= RULE_ID ) ) | otherlv_1= 'undefined' ) otherlv_2= '.' ( (lv_failureExpr_3_0= ruleInFailureExpr ) )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:311:2: ( ( (otherlv_0= RULE_ID ) ) | otherlv_1= 'undefined' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            else if ( (LA4_0==15) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:311:3: ( (otherlv_0= RULE_ID ) )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:311:3: ( (otherlv_0= RULE_ID ) )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:312:1: (otherlv_0= RULE_ID )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:312:1: (otherlv_0= RULE_ID )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:313:3: otherlv_0= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getInputExpressionRule());
                    	        }
                            
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInputExpression627); 

                    		newLeafNode(otherlv_0, grammarAccess.getInputExpressionAccess().getRefPortCrossReference_0_0_0()); 
                    	

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:325:7: otherlv_1= 'undefined'
                    {
                    otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleInputExpression645); 

                        	newLeafNode(otherlv_1, grammarAccess.getInputExpressionAccess().getUndefinedKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleInputExpression658); 

                	newLeafNode(otherlv_2, grammarAccess.getInputExpressionAccess().getFullStopKeyword_1());
                
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:333:1: ( (lv_failureExpr_3_0= ruleInFailureExpr ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:334:1: (lv_failureExpr_3_0= ruleInFailureExpr )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:334:1: (lv_failureExpr_3_0= ruleInFailureExpr )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:335:3: lv_failureExpr_3_0= ruleInFailureExpr
            {
             
            	        newCompositeNode(grammarAccess.getInputExpressionAccess().getFailureExprInFailureExprParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleInFailureExpr_in_ruleInputExpression679);
            lv_failureExpr_3_0=ruleInFailureExpr();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInputExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"failureExpr",
                    		lv_failureExpr_3_0, 
                    		"InFailureExpr");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInputExpression"


    // $ANTLR start "entryRuleOutputExpression"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:359:1: entryRuleOutputExpression returns [EObject current=null] : iv_ruleOutputExpression= ruleOutputExpression EOF ;
    public final EObject entryRuleOutputExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutputExpression = null;


        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:360:2: (iv_ruleOutputExpression= ruleOutputExpression EOF )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:361:2: iv_ruleOutputExpression= ruleOutputExpression EOF
            {
             newCompositeNode(grammarAccess.getOutputExpressionRule()); 
            pushFollow(FOLLOW_ruleOutputExpression_in_entryRuleOutputExpression715);
            iv_ruleOutputExpression=ruleOutputExpression();

            state._fsp--;

             current =iv_ruleOutputExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOutputExpression725); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOutputExpression"


    // $ANTLR start "ruleOutputExpression"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:368:1: ruleOutputExpression returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) | otherlv_1= 'undefined' ) otherlv_2= '.' ( (lv_failureExpr_3_0= ruleOutFailureExpr ) ) ) ;
    public final EObject ruleOutputExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_failureExpr_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:371:28: ( ( ( ( (otherlv_0= RULE_ID ) ) | otherlv_1= 'undefined' ) otherlv_2= '.' ( (lv_failureExpr_3_0= ruleOutFailureExpr ) ) ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:372:1: ( ( ( (otherlv_0= RULE_ID ) ) | otherlv_1= 'undefined' ) otherlv_2= '.' ( (lv_failureExpr_3_0= ruleOutFailureExpr ) ) )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:372:1: ( ( ( (otherlv_0= RULE_ID ) ) | otherlv_1= 'undefined' ) otherlv_2= '.' ( (lv_failureExpr_3_0= ruleOutFailureExpr ) ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:372:2: ( ( (otherlv_0= RULE_ID ) ) | otherlv_1= 'undefined' ) otherlv_2= '.' ( (lv_failureExpr_3_0= ruleOutFailureExpr ) )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:372:2: ( ( (otherlv_0= RULE_ID ) ) | otherlv_1= 'undefined' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            else if ( (LA5_0==15) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:372:3: ( (otherlv_0= RULE_ID ) )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:372:3: ( (otherlv_0= RULE_ID ) )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:373:1: (otherlv_0= RULE_ID )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:373:1: (otherlv_0= RULE_ID )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:374:3: otherlv_0= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getOutputExpressionRule());
                    	        }
                            
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOutputExpression771); 

                    		newLeafNode(otherlv_0, grammarAccess.getOutputExpressionAccess().getRefPortCrossReference_0_0_0()); 
                    	

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:386:7: otherlv_1= 'undefined'
                    {
                    otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleOutputExpression789); 

                        	newLeafNode(otherlv_1, grammarAccess.getOutputExpressionAccess().getUndefinedKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleOutputExpression802); 

                	newLeafNode(otherlv_2, grammarAccess.getOutputExpressionAccess().getFullStopKeyword_1());
                
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:394:1: ( (lv_failureExpr_3_0= ruleOutFailureExpr ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:395:1: (lv_failureExpr_3_0= ruleOutFailureExpr )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:395:1: (lv_failureExpr_3_0= ruleOutFailureExpr )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:396:3: lv_failureExpr_3_0= ruleOutFailureExpr
            {
             
            	        newCompositeNode(grammarAccess.getOutputExpressionAccess().getFailureExprOutFailureExprParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleOutFailureExpr_in_ruleOutputExpression823);
            lv_failureExpr_3_0=ruleOutFailureExpr();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOutputExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"failureExpr",
                    		lv_failureExpr_3_0, 
                    		"OutFailureExpr");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOutputExpression"


    // $ANTLR start "entryRuleInFailureExpr"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:420:1: entryRuleInFailureExpr returns [EObject current=null] : iv_ruleInFailureExpr= ruleInFailureExpr EOF ;
    public final EObject entryRuleInFailureExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInFailureExpr = null;


        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:421:2: (iv_ruleInFailureExpr= ruleInFailureExpr EOF )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:422:2: iv_ruleInFailureExpr= ruleInFailureExpr EOF
            {
             newCompositeNode(grammarAccess.getInFailureExprRule()); 
            pushFollow(FOLLOW_ruleInFailureExpr_in_entryRuleInFailureExpr859);
            iv_ruleInFailureExpr=ruleInFailureExpr();

            state._fsp--;

             current =iv_ruleInFailureExpr; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInFailureExpr869); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInFailureExpr"


    // $ANTLR start "ruleInFailureExpr"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:429:1: ruleInFailureExpr returns [EObject current=null] : ( ( (lv_failures_0_0= ruleWildcardDefinition ) ) | ( (lv_failures_1_0= ruleNoFailureDefinition ) ) | ( (lv_failures_2_0= ruleFailureDefinition ) ) | (otherlv_3= '{' ( (lv_failures_4_0= ruleFailureDefinition ) ) (otherlv_5= ',' ( (lv_failures_6_0= ruleFailureDefinition ) ) )+ otherlv_7= '}' ) | ( (lv_failures_8_0= ruleVariableDefinition ) ) ) ;
    public final EObject ruleInFailureExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_failures_0_0 = null;

        EObject lv_failures_1_0 = null;

        EObject lv_failures_2_0 = null;

        EObject lv_failures_4_0 = null;

        EObject lv_failures_6_0 = null;

        EObject lv_failures_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:432:28: ( ( ( (lv_failures_0_0= ruleWildcardDefinition ) ) | ( (lv_failures_1_0= ruleNoFailureDefinition ) ) | ( (lv_failures_2_0= ruleFailureDefinition ) ) | (otherlv_3= '{' ( (lv_failures_4_0= ruleFailureDefinition ) ) (otherlv_5= ',' ( (lv_failures_6_0= ruleFailureDefinition ) ) )+ otherlv_7= '}' ) | ( (lv_failures_8_0= ruleVariableDefinition ) ) ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:433:1: ( ( (lv_failures_0_0= ruleWildcardDefinition ) ) | ( (lv_failures_1_0= ruleNoFailureDefinition ) ) | ( (lv_failures_2_0= ruleFailureDefinition ) ) | (otherlv_3= '{' ( (lv_failures_4_0= ruleFailureDefinition ) ) (otherlv_5= ',' ( (lv_failures_6_0= ruleFailureDefinition ) ) )+ otherlv_7= '}' ) | ( (lv_failures_8_0= ruleVariableDefinition ) ) )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:433:1: ( ( (lv_failures_0_0= ruleWildcardDefinition ) ) | ( (lv_failures_1_0= ruleNoFailureDefinition ) ) | ( (lv_failures_2_0= ruleFailureDefinition ) ) | (otherlv_3= '{' ( (lv_failures_4_0= ruleFailureDefinition ) ) (otherlv_5= ',' ( (lv_failures_6_0= ruleFailureDefinition ) ) )+ otherlv_7= '}' ) | ( (lv_failures_8_0= ruleVariableDefinition ) ) )
            int alt7=5;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt7=1;
                }
                break;
            case 19:
                {
                alt7=2;
                }
                break;
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
                {
                alt7=3;
                }
                break;
            case 17:
                {
                alt7=4;
                }
                break;
            case RULE_ID:
                {
                alt7=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:433:2: ( (lv_failures_0_0= ruleWildcardDefinition ) )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:433:2: ( (lv_failures_0_0= ruleWildcardDefinition ) )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:434:1: (lv_failures_0_0= ruleWildcardDefinition )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:434:1: (lv_failures_0_0= ruleWildcardDefinition )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:435:3: lv_failures_0_0= ruleWildcardDefinition
                    {
                     
                    	        newCompositeNode(grammarAccess.getInFailureExprAccess().getFailuresWildcardDefinitionParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleWildcardDefinition_in_ruleInFailureExpr915);
                    lv_failures_0_0=ruleWildcardDefinition();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInFailureExprRule());
                    	        }
                           		add(
                           			current, 
                           			"failures",
                            		lv_failures_0_0, 
                            		"WildcardDefinition");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:452:6: ( (lv_failures_1_0= ruleNoFailureDefinition ) )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:452:6: ( (lv_failures_1_0= ruleNoFailureDefinition ) )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:453:1: (lv_failures_1_0= ruleNoFailureDefinition )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:453:1: (lv_failures_1_0= ruleNoFailureDefinition )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:454:3: lv_failures_1_0= ruleNoFailureDefinition
                    {
                     
                    	        newCompositeNode(grammarAccess.getInFailureExprAccess().getFailuresNoFailureDefinitionParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleNoFailureDefinition_in_ruleInFailureExpr942);
                    lv_failures_1_0=ruleNoFailureDefinition();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInFailureExprRule());
                    	        }
                           		add(
                           			current, 
                           			"failures",
                            		lv_failures_1_0, 
                            		"NoFailureDefinition");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:471:6: ( (lv_failures_2_0= ruleFailureDefinition ) )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:471:6: ( (lv_failures_2_0= ruleFailureDefinition ) )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:472:1: (lv_failures_2_0= ruleFailureDefinition )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:472:1: (lv_failures_2_0= ruleFailureDefinition )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:473:3: lv_failures_2_0= ruleFailureDefinition
                    {
                     
                    	        newCompositeNode(grammarAccess.getInFailureExprAccess().getFailuresFailureDefinitionParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFailureDefinition_in_ruleInFailureExpr969);
                    lv_failures_2_0=ruleFailureDefinition();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInFailureExprRule());
                    	        }
                           		add(
                           			current, 
                           			"failures",
                            		lv_failures_2_0, 
                            		"FailureDefinition");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:490:6: (otherlv_3= '{' ( (lv_failures_4_0= ruleFailureDefinition ) ) (otherlv_5= ',' ( (lv_failures_6_0= ruleFailureDefinition ) ) )+ otherlv_7= '}' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:490:6: (otherlv_3= '{' ( (lv_failures_4_0= ruleFailureDefinition ) ) (otherlv_5= ',' ( (lv_failures_6_0= ruleFailureDefinition ) ) )+ otherlv_7= '}' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:490:8: otherlv_3= '{' ( (lv_failures_4_0= ruleFailureDefinition ) ) (otherlv_5= ',' ( (lv_failures_6_0= ruleFailureDefinition ) ) )+ otherlv_7= '}'
                    {
                    otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleInFailureExpr988); 

                        	newLeafNode(otherlv_3, grammarAccess.getInFailureExprAccess().getLeftCurlyBracketKeyword_3_0());
                        
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:494:1: ( (lv_failures_4_0= ruleFailureDefinition ) )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:495:1: (lv_failures_4_0= ruleFailureDefinition )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:495:1: (lv_failures_4_0= ruleFailureDefinition )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:496:3: lv_failures_4_0= ruleFailureDefinition
                    {
                     
                    	        newCompositeNode(grammarAccess.getInFailureExprAccess().getFailuresFailureDefinitionParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFailureDefinition_in_ruleInFailureExpr1009);
                    lv_failures_4_0=ruleFailureDefinition();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInFailureExprRule());
                    	        }
                           		add(
                           			current, 
                           			"failures",
                            		lv_failures_4_0, 
                            		"FailureDefinition");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:512:2: (otherlv_5= ',' ( (lv_failures_6_0= ruleFailureDefinition ) ) )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==14) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:512:4: otherlv_5= ',' ( (lv_failures_6_0= ruleFailureDefinition ) )
                    	    {
                    	    otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleInFailureExpr1022); 

                    	        	newLeafNode(otherlv_5, grammarAccess.getInFailureExprAccess().getCommaKeyword_3_2_0());
                    	        
                    	    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:516:1: ( (lv_failures_6_0= ruleFailureDefinition ) )
                    	    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:517:1: (lv_failures_6_0= ruleFailureDefinition )
                    	    {
                    	    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:517:1: (lv_failures_6_0= ruleFailureDefinition )
                    	    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:518:3: lv_failures_6_0= ruleFailureDefinition
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getInFailureExprAccess().getFailuresFailureDefinitionParserRuleCall_3_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFailureDefinition_in_ruleInFailureExpr1043);
                    	    lv_failures_6_0=ruleFailureDefinition();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getInFailureExprRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"failures",
                    	            		lv_failures_6_0, 
                    	            		"FailureDefinition");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt6 >= 1 ) break loop6;
                                EarlyExitException eee =
                                    new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
                    } while (true);

                    otherlv_7=(Token)match(input,18,FOLLOW_18_in_ruleInFailureExpr1057); 

                        	newLeafNode(otherlv_7, grammarAccess.getInFailureExprAccess().getRightCurlyBracketKeyword_3_3());
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:539:6: ( (lv_failures_8_0= ruleVariableDefinition ) )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:539:6: ( (lv_failures_8_0= ruleVariableDefinition ) )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:540:1: (lv_failures_8_0= ruleVariableDefinition )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:540:1: (lv_failures_8_0= ruleVariableDefinition )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:541:3: lv_failures_8_0= ruleVariableDefinition
                    {
                     
                    	        newCompositeNode(grammarAccess.getInFailureExprAccess().getFailuresVariableDefinitionParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVariableDefinition_in_ruleInFailureExpr1085);
                    lv_failures_8_0=ruleVariableDefinition();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInFailureExprRule());
                    	        }
                           		add(
                           			current, 
                           			"failures",
                            		lv_failures_8_0, 
                            		"VariableDefinition");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInFailureExpr"


    // $ANTLR start "entryRuleOutFailureExpr"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:565:1: entryRuleOutFailureExpr returns [EObject current=null] : iv_ruleOutFailureExpr= ruleOutFailureExpr EOF ;
    public final EObject entryRuleOutFailureExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutFailureExpr = null;


        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:566:2: (iv_ruleOutFailureExpr= ruleOutFailureExpr EOF )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:567:2: iv_ruleOutFailureExpr= ruleOutFailureExpr EOF
            {
             newCompositeNode(grammarAccess.getOutFailureExprRule()); 
            pushFollow(FOLLOW_ruleOutFailureExpr_in_entryRuleOutFailureExpr1121);
            iv_ruleOutFailureExpr=ruleOutFailureExpr();

            state._fsp--;

             current =iv_ruleOutFailureExpr; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOutFailureExpr1131); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOutFailureExpr"


    // $ANTLR start "ruleOutFailureExpr"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:574:1: ruleOutFailureExpr returns [EObject current=null] : ( ( (lv_failures_0_0= ruleNoFailureDefinition ) ) | ( (lv_failures_1_0= ruleComplexNofailureDefinition ) ) | ( (lv_failures_2_0= ruleFailureDefinition ) ) | (otherlv_3= '{' ( (lv_failures_4_0= ruleFailureDefinition ) ) (otherlv_5= ',' ( (lv_failures_6_0= ruleFailureDefinition ) ) )+ otherlv_7= '}' ) | ( (lv_failures_8_0= ruleVariableDefinition ) ) ) ;
    public final EObject ruleOutFailureExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_failures_0_0 = null;

        EObject lv_failures_1_0 = null;

        EObject lv_failures_2_0 = null;

        EObject lv_failures_4_0 = null;

        EObject lv_failures_6_0 = null;

        EObject lv_failures_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:577:28: ( ( ( (lv_failures_0_0= ruleNoFailureDefinition ) ) | ( (lv_failures_1_0= ruleComplexNofailureDefinition ) ) | ( (lv_failures_2_0= ruleFailureDefinition ) ) | (otherlv_3= '{' ( (lv_failures_4_0= ruleFailureDefinition ) ) (otherlv_5= ',' ( (lv_failures_6_0= ruleFailureDefinition ) ) )+ otherlv_7= '}' ) | ( (lv_failures_8_0= ruleVariableDefinition ) ) ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:578:1: ( ( (lv_failures_0_0= ruleNoFailureDefinition ) ) | ( (lv_failures_1_0= ruleComplexNofailureDefinition ) ) | ( (lv_failures_2_0= ruleFailureDefinition ) ) | (otherlv_3= '{' ( (lv_failures_4_0= ruleFailureDefinition ) ) (otherlv_5= ',' ( (lv_failures_6_0= ruleFailureDefinition ) ) )+ otherlv_7= '}' ) | ( (lv_failures_8_0= ruleVariableDefinition ) ) )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:578:1: ( ( (lv_failures_0_0= ruleNoFailureDefinition ) ) | ( (lv_failures_1_0= ruleComplexNofailureDefinition ) ) | ( (lv_failures_2_0= ruleFailureDefinition ) ) | (otherlv_3= '{' ( (lv_failures_4_0= ruleFailureDefinition ) ) (otherlv_5= ',' ( (lv_failures_6_0= ruleFailureDefinition ) ) )+ otherlv_7= '}' ) | ( (lv_failures_8_0= ruleVariableDefinition ) ) )
            int alt9=5;
            switch ( input.LA(1) ) {
            case 19:
                {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==16) ) {
                    alt9=2;
                }
                else if ( (LA9_1==EOF||(LA9_1>=13 && LA9_1<=14)) ) {
                    alt9=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
                }
                break;
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
                {
                alt9=3;
                }
                break;
            case 17:
                {
                alt9=4;
                }
                break;
            case RULE_ID:
                {
                alt9=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:578:2: ( (lv_failures_0_0= ruleNoFailureDefinition ) )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:578:2: ( (lv_failures_0_0= ruleNoFailureDefinition ) )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:579:1: (lv_failures_0_0= ruleNoFailureDefinition )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:579:1: (lv_failures_0_0= ruleNoFailureDefinition )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:580:3: lv_failures_0_0= ruleNoFailureDefinition
                    {
                     
                    	        newCompositeNode(grammarAccess.getOutFailureExprAccess().getFailuresNoFailureDefinitionParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleNoFailureDefinition_in_ruleOutFailureExpr1177);
                    lv_failures_0_0=ruleNoFailureDefinition();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOutFailureExprRule());
                    	        }
                           		add(
                           			current, 
                           			"failures",
                            		lv_failures_0_0, 
                            		"NoFailureDefinition");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:597:6: ( (lv_failures_1_0= ruleComplexNofailureDefinition ) )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:597:6: ( (lv_failures_1_0= ruleComplexNofailureDefinition ) )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:598:1: (lv_failures_1_0= ruleComplexNofailureDefinition )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:598:1: (lv_failures_1_0= ruleComplexNofailureDefinition )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:599:3: lv_failures_1_0= ruleComplexNofailureDefinition
                    {
                     
                    	        newCompositeNode(grammarAccess.getOutFailureExprAccess().getFailuresComplexNofailureDefinitionParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleComplexNofailureDefinition_in_ruleOutFailureExpr1204);
                    lv_failures_1_0=ruleComplexNofailureDefinition();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOutFailureExprRule());
                    	        }
                           		add(
                           			current, 
                           			"failures",
                            		lv_failures_1_0, 
                            		"ComplexNofailureDefinition");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:616:6: ( (lv_failures_2_0= ruleFailureDefinition ) )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:616:6: ( (lv_failures_2_0= ruleFailureDefinition ) )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:617:1: (lv_failures_2_0= ruleFailureDefinition )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:617:1: (lv_failures_2_0= ruleFailureDefinition )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:618:3: lv_failures_2_0= ruleFailureDefinition
                    {
                     
                    	        newCompositeNode(grammarAccess.getOutFailureExprAccess().getFailuresFailureDefinitionParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFailureDefinition_in_ruleOutFailureExpr1231);
                    lv_failures_2_0=ruleFailureDefinition();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOutFailureExprRule());
                    	        }
                           		add(
                           			current, 
                           			"failures",
                            		lv_failures_2_0, 
                            		"FailureDefinition");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:635:6: (otherlv_3= '{' ( (lv_failures_4_0= ruleFailureDefinition ) ) (otherlv_5= ',' ( (lv_failures_6_0= ruleFailureDefinition ) ) )+ otherlv_7= '}' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:635:6: (otherlv_3= '{' ( (lv_failures_4_0= ruleFailureDefinition ) ) (otherlv_5= ',' ( (lv_failures_6_0= ruleFailureDefinition ) ) )+ otherlv_7= '}' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:635:8: otherlv_3= '{' ( (lv_failures_4_0= ruleFailureDefinition ) ) (otherlv_5= ',' ( (lv_failures_6_0= ruleFailureDefinition ) ) )+ otherlv_7= '}'
                    {
                    otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleOutFailureExpr1250); 

                        	newLeafNode(otherlv_3, grammarAccess.getOutFailureExprAccess().getLeftCurlyBracketKeyword_3_0());
                        
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:639:1: ( (lv_failures_4_0= ruleFailureDefinition ) )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:640:1: (lv_failures_4_0= ruleFailureDefinition )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:640:1: (lv_failures_4_0= ruleFailureDefinition )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:641:3: lv_failures_4_0= ruleFailureDefinition
                    {
                     
                    	        newCompositeNode(grammarAccess.getOutFailureExprAccess().getFailuresFailureDefinitionParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFailureDefinition_in_ruleOutFailureExpr1271);
                    lv_failures_4_0=ruleFailureDefinition();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOutFailureExprRule());
                    	        }
                           		add(
                           			current, 
                           			"failures",
                            		lv_failures_4_0, 
                            		"FailureDefinition");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:657:2: (otherlv_5= ',' ( (lv_failures_6_0= ruleFailureDefinition ) ) )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==14) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:657:4: otherlv_5= ',' ( (lv_failures_6_0= ruleFailureDefinition ) )
                    	    {
                    	    otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleOutFailureExpr1284); 

                    	        	newLeafNode(otherlv_5, grammarAccess.getOutFailureExprAccess().getCommaKeyword_3_2_0());
                    	        
                    	    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:661:1: ( (lv_failures_6_0= ruleFailureDefinition ) )
                    	    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:662:1: (lv_failures_6_0= ruleFailureDefinition )
                    	    {
                    	    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:662:1: (lv_failures_6_0= ruleFailureDefinition )
                    	    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:663:3: lv_failures_6_0= ruleFailureDefinition
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getOutFailureExprAccess().getFailuresFailureDefinitionParserRuleCall_3_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFailureDefinition_in_ruleOutFailureExpr1305);
                    	    lv_failures_6_0=ruleFailureDefinition();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getOutFailureExprRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"failures",
                    	            		lv_failures_6_0, 
                    	            		"FailureDefinition");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);

                    otherlv_7=(Token)match(input,18,FOLLOW_18_in_ruleOutFailureExpr1319); 

                        	newLeafNode(otherlv_7, grammarAccess.getOutFailureExprAccess().getRightCurlyBracketKeyword_3_3());
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:684:6: ( (lv_failures_8_0= ruleVariableDefinition ) )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:684:6: ( (lv_failures_8_0= ruleVariableDefinition ) )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:685:1: (lv_failures_8_0= ruleVariableDefinition )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:685:1: (lv_failures_8_0= ruleVariableDefinition )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:686:3: lv_failures_8_0= ruleVariableDefinition
                    {
                     
                    	        newCompositeNode(grammarAccess.getOutFailureExprAccess().getFailuresVariableDefinitionParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVariableDefinition_in_ruleOutFailureExpr1347);
                    lv_failures_8_0=ruleVariableDefinition();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOutFailureExprRule());
                    	        }
                           		add(
                           			current, 
                           			"failures",
                            		lv_failures_8_0, 
                            		"VariableDefinition");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOutFailureExpr"


    // $ANTLR start "entryRuleFailureDefinition"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:712:1: entryRuleFailureDefinition returns [EObject current=null] : iv_ruleFailureDefinition= ruleFailureDefinition EOF ;
    public final EObject entryRuleFailureDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFailureDefinition = null;


        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:713:2: (iv_ruleFailureDefinition= ruleFailureDefinition EOF )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:714:2: iv_ruleFailureDefinition= ruleFailureDefinition EOF
            {
             newCompositeNode(grammarAccess.getFailureDefinitionRule()); 
            pushFollow(FOLLOW_ruleFailureDefinition_in_entryRuleFailureDefinition1385);
            iv_ruleFailureDefinition=ruleFailureDefinition();

            state._fsp--;

             current =iv_ruleFailureDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFailureDefinition1395); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFailureDefinition"


    // $ANTLR start "ruleFailureDefinition"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:721:1: ruleFailureDefinition returns [EObject current=null] : ( () ( (lv_type_1_0= ruleActualFailureType ) ) (otherlv_2= '.' ( (lv_acidAvoidable_3_0= ruleACIDavoidable ) ) )? ) ;
    public final EObject ruleFailureDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Enumerator lv_type_1_0 = null;

        EObject lv_acidAvoidable_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:724:28: ( ( () ( (lv_type_1_0= ruleActualFailureType ) ) (otherlv_2= '.' ( (lv_acidAvoidable_3_0= ruleACIDavoidable ) ) )? ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:725:1: ( () ( (lv_type_1_0= ruleActualFailureType ) ) (otherlv_2= '.' ( (lv_acidAvoidable_3_0= ruleACIDavoidable ) ) )? )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:725:1: ( () ( (lv_type_1_0= ruleActualFailureType ) ) (otherlv_2= '.' ( (lv_acidAvoidable_3_0= ruleACIDavoidable ) ) )? )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:725:2: () ( (lv_type_1_0= ruleActualFailureType ) ) (otherlv_2= '.' ( (lv_acidAvoidable_3_0= ruleACIDavoidable ) ) )?
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:725:2: ()
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:726:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getFailureDefinitionAccess().getFailureDefinitionAction_0(),
                        current);
                

            }

            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:731:2: ( (lv_type_1_0= ruleActualFailureType ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:732:1: (lv_type_1_0= ruleActualFailureType )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:732:1: (lv_type_1_0= ruleActualFailureType )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:733:3: lv_type_1_0= ruleActualFailureType
            {
             
            	        newCompositeNode(grammarAccess.getFailureDefinitionAccess().getTypeActualFailureTypeEnumRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleActualFailureType_in_ruleFailureDefinition1450);
            lv_type_1_0=ruleActualFailureType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFailureDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_1_0, 
                    		"ActualFailureType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:749:2: (otherlv_2= '.' ( (lv_acidAvoidable_3_0= ruleACIDavoidable ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==16) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:749:4: otherlv_2= '.' ( (lv_acidAvoidable_3_0= ruleACIDavoidable ) )
                    {
                    otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleFailureDefinition1463); 

                        	newLeafNode(otherlv_2, grammarAccess.getFailureDefinitionAccess().getFullStopKeyword_2_0());
                        
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:753:1: ( (lv_acidAvoidable_3_0= ruleACIDavoidable ) )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:754:1: (lv_acidAvoidable_3_0= ruleACIDavoidable )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:754:1: (lv_acidAvoidable_3_0= ruleACIDavoidable )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:755:3: lv_acidAvoidable_3_0= ruleACIDavoidable
                    {
                     
                    	        newCompositeNode(grammarAccess.getFailureDefinitionAccess().getAcidAvoidableACIDavoidableParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleACIDavoidable_in_ruleFailureDefinition1484);
                    lv_acidAvoidable_3_0=ruleACIDavoidable();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getFailureDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"acidAvoidable",
                            		lv_acidAvoidable_3_0, 
                            		"ACIDavoidable");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFailureDefinition"


    // $ANTLR start "entryRuleNoFailureDefinition"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:779:1: entryRuleNoFailureDefinition returns [EObject current=null] : iv_ruleNoFailureDefinition= ruleNoFailureDefinition EOF ;
    public final EObject entryRuleNoFailureDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNoFailureDefinition = null;


        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:780:2: (iv_ruleNoFailureDefinition= ruleNoFailureDefinition EOF )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:781:2: iv_ruleNoFailureDefinition= ruleNoFailureDefinition EOF
            {
             newCompositeNode(grammarAccess.getNoFailureDefinitionRule()); 
            pushFollow(FOLLOW_ruleNoFailureDefinition_in_entryRuleNoFailureDefinition1522);
            iv_ruleNoFailureDefinition=ruleNoFailureDefinition();

            state._fsp--;

             current =iv_ruleNoFailureDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNoFailureDefinition1532); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNoFailureDefinition"


    // $ANTLR start "ruleNoFailureDefinition"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:788:1: ruleNoFailureDefinition returns [EObject current=null] : ( () otherlv_1= 'noFailure' ) ;
    public final EObject ruleNoFailureDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:791:28: ( ( () otherlv_1= 'noFailure' ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:792:1: ( () otherlv_1= 'noFailure' )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:792:1: ( () otherlv_1= 'noFailure' )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:792:2: () otherlv_1= 'noFailure'
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:792:2: ()
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:793:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNoFailureDefinitionAccess().getNoFailureDefinitionAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleNoFailureDefinition1578); 

                	newLeafNode(otherlv_1, grammarAccess.getNoFailureDefinitionAccess().getNoFailureKeyword_1());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNoFailureDefinition"


    // $ANTLR start "entryRuleComplexNofailureDefinition"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:810:1: entryRuleComplexNofailureDefinition returns [EObject current=null] : iv_ruleComplexNofailureDefinition= ruleComplexNofailureDefinition EOF ;
    public final EObject entryRuleComplexNofailureDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexNofailureDefinition = null;


        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:811:2: (iv_ruleComplexNofailureDefinition= ruleComplexNofailureDefinition EOF )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:812:2: iv_ruleComplexNofailureDefinition= ruleComplexNofailureDefinition EOF
            {
             newCompositeNode(grammarAccess.getComplexNofailureDefinitionRule()); 
            pushFollow(FOLLOW_ruleComplexNofailureDefinition_in_entryRuleComplexNofailureDefinition1614);
            iv_ruleComplexNofailureDefinition=ruleComplexNofailureDefinition();

            state._fsp--;

             current =iv_ruleComplexNofailureDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComplexNofailureDefinition1624); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComplexNofailureDefinition"


    // $ANTLR start "ruleComplexNofailureDefinition"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:819:1: ruleComplexNofailureDefinition returns [EObject current=null] : ( () otherlv_1= 'noFailure' otherlv_2= '.' ( (lv_acidMitigation_3_0= ruleACIDMitigation ) ) ) ;
    public final EObject ruleComplexNofailureDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_acidMitigation_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:822:28: ( ( () otherlv_1= 'noFailure' otherlv_2= '.' ( (lv_acidMitigation_3_0= ruleACIDMitigation ) ) ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:823:1: ( () otherlv_1= 'noFailure' otherlv_2= '.' ( (lv_acidMitigation_3_0= ruleACIDMitigation ) ) )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:823:1: ( () otherlv_1= 'noFailure' otherlv_2= '.' ( (lv_acidMitigation_3_0= ruleACIDMitigation ) ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:823:2: () otherlv_1= 'noFailure' otherlv_2= '.' ( (lv_acidMitigation_3_0= ruleACIDMitigation ) )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:823:2: ()
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:824:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getComplexNofailureDefinitionAccess().getNoFailureDefinitionAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleComplexNofailureDefinition1670); 

                	newLeafNode(otherlv_1, grammarAccess.getComplexNofailureDefinitionAccess().getNoFailureKeyword_1());
                
            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleComplexNofailureDefinition1682); 

                	newLeafNode(otherlv_2, grammarAccess.getComplexNofailureDefinitionAccess().getFullStopKeyword_2());
                
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:837:1: ( (lv_acidMitigation_3_0= ruleACIDMitigation ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:838:1: (lv_acidMitigation_3_0= ruleACIDMitigation )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:838:1: (lv_acidMitigation_3_0= ruleACIDMitigation )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:839:3: lv_acidMitigation_3_0= ruleACIDMitigation
            {
             
            	        newCompositeNode(grammarAccess.getComplexNofailureDefinitionAccess().getAcidMitigationACIDMitigationParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleACIDMitigation_in_ruleComplexNofailureDefinition1703);
            lv_acidMitigation_3_0=ruleACIDMitigation();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getComplexNofailureDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"acidMitigation",
                    		lv_acidMitigation_3_0, 
                    		"ACIDMitigation");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComplexNofailureDefinition"


    // $ANTLR start "entryRuleWildcardDefinition"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:863:1: entryRuleWildcardDefinition returns [EObject current=null] : iv_ruleWildcardDefinition= ruleWildcardDefinition EOF ;
    public final EObject entryRuleWildcardDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcardDefinition = null;


        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:864:2: (iv_ruleWildcardDefinition= ruleWildcardDefinition EOF )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:865:2: iv_ruleWildcardDefinition= ruleWildcardDefinition EOF
            {
             newCompositeNode(grammarAccess.getWildcardDefinitionRule()); 
            pushFollow(FOLLOW_ruleWildcardDefinition_in_entryRuleWildcardDefinition1739);
            iv_ruleWildcardDefinition=ruleWildcardDefinition();

            state._fsp--;

             current =iv_ruleWildcardDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWildcardDefinition1749); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWildcardDefinition"


    // $ANTLR start "ruleWildcardDefinition"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:872:1: ruleWildcardDefinition returns [EObject current=null] : ( () otherlv_1= 'wildcard' ) ;
    public final EObject ruleWildcardDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:875:28: ( ( () otherlv_1= 'wildcard' ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:876:1: ( () otherlv_1= 'wildcard' )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:876:1: ( () otherlv_1= 'wildcard' )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:876:2: () otherlv_1= 'wildcard'
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:876:2: ()
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:877:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getWildcardDefinitionAccess().getWildcardDefinitionAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleWildcardDefinition1795); 

                	newLeafNode(otherlv_1, grammarAccess.getWildcardDefinitionAccess().getWildcardKeyword_1());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWildcardDefinition"


    // $ANTLR start "entryRuleVariableDefinition"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:894:1: entryRuleVariableDefinition returns [EObject current=null] : iv_ruleVariableDefinition= ruleVariableDefinition EOF ;
    public final EObject entryRuleVariableDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDefinition = null;


        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:895:2: (iv_ruleVariableDefinition= ruleVariableDefinition EOF )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:896:2: iv_ruleVariableDefinition= ruleVariableDefinition EOF
            {
             newCompositeNode(grammarAccess.getVariableDefinitionRule()); 
            pushFollow(FOLLOW_ruleVariableDefinition_in_entryRuleVariableDefinition1831);
            iv_ruleVariableDefinition=ruleVariableDefinition();

            state._fsp--;

             current =iv_ruleVariableDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDefinition1841); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableDefinition"


    // $ANTLR start "ruleVariableDefinition"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:903:1: ruleVariableDefinition returns [EObject current=null] : ( () ( (lv_variableName_1_0= RULE_ID ) ) ) ;
    public final EObject ruleVariableDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_variableName_1_0=null;

         enterRule(); 
            
        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:906:28: ( ( () ( (lv_variableName_1_0= RULE_ID ) ) ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:907:1: ( () ( (lv_variableName_1_0= RULE_ID ) ) )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:907:1: ( () ( (lv_variableName_1_0= RULE_ID ) ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:907:2: () ( (lv_variableName_1_0= RULE_ID ) )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:907:2: ()
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:908:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getVariableDefinitionAccess().getVariableDefinitionAction_0(),
                        current);
                

            }

            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:913:2: ( (lv_variableName_1_0= RULE_ID ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:914:1: (lv_variableName_1_0= RULE_ID )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:914:1: (lv_variableName_1_0= RULE_ID )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:915:3: lv_variableName_1_0= RULE_ID
            {
            lv_variableName_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableDefinition1892); 

            			newLeafNode(lv_variableName_1_0, grammarAccess.getVariableDefinitionAccess().getVariableNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVariableDefinitionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"variableName",
                    		lv_variableName_1_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableDefinition"


    // $ANTLR start "entryRuleACIDavoidable"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:939:1: entryRuleACIDavoidable returns [EObject current=null] : iv_ruleACIDavoidable= ruleACIDavoidable EOF ;
    public final EObject entryRuleACIDavoidable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleACIDavoidable = null;


        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:940:2: (iv_ruleACIDavoidable= ruleACIDavoidable EOF )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:941:2: iv_ruleACIDavoidable= ruleACIDavoidable EOF
            {
             newCompositeNode(grammarAccess.getACIDavoidableRule()); 
            pushFollow(FOLLOW_ruleACIDavoidable_in_entryRuleACIDavoidable1933);
            iv_ruleACIDavoidable=ruleACIDavoidable();

            state._fsp--;

             current =iv_ruleACIDavoidable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleACIDavoidable1943); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleACIDavoidable"


    // $ANTLR start "ruleACIDavoidable"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:948:1: ruleACIDavoidable returns [EObject current=null] : ( ( (lv_a_0_0= ruleAavoidable ) ) otherlv_1= '.' ( (lv_c_2_0= ruleCavoidable ) ) otherlv_3= '.' ( (lv_i_4_0= ruleIavoidable ) ) otherlv_5= '.' ( (lv_d_6_0= ruleDavoidable ) ) ) ;
    public final EObject ruleACIDavoidable() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Enumerator lv_a_0_0 = null;

        Enumerator lv_c_2_0 = null;

        Enumerator lv_i_4_0 = null;

        Enumerator lv_d_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:951:28: ( ( ( (lv_a_0_0= ruleAavoidable ) ) otherlv_1= '.' ( (lv_c_2_0= ruleCavoidable ) ) otherlv_3= '.' ( (lv_i_4_0= ruleIavoidable ) ) otherlv_5= '.' ( (lv_d_6_0= ruleDavoidable ) ) ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:952:1: ( ( (lv_a_0_0= ruleAavoidable ) ) otherlv_1= '.' ( (lv_c_2_0= ruleCavoidable ) ) otherlv_3= '.' ( (lv_i_4_0= ruleIavoidable ) ) otherlv_5= '.' ( (lv_d_6_0= ruleDavoidable ) ) )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:952:1: ( ( (lv_a_0_0= ruleAavoidable ) ) otherlv_1= '.' ( (lv_c_2_0= ruleCavoidable ) ) otherlv_3= '.' ( (lv_i_4_0= ruleIavoidable ) ) otherlv_5= '.' ( (lv_d_6_0= ruleDavoidable ) ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:952:2: ( (lv_a_0_0= ruleAavoidable ) ) otherlv_1= '.' ( (lv_c_2_0= ruleCavoidable ) ) otherlv_3= '.' ( (lv_i_4_0= ruleIavoidable ) ) otherlv_5= '.' ( (lv_d_6_0= ruleDavoidable ) )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:952:2: ( (lv_a_0_0= ruleAavoidable ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:953:1: (lv_a_0_0= ruleAavoidable )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:953:1: (lv_a_0_0= ruleAavoidable )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:954:3: lv_a_0_0= ruleAavoidable
            {
             
            	        newCompositeNode(grammarAccess.getACIDavoidableAccess().getAAavoidableEnumRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleAavoidable_in_ruleACIDavoidable1989);
            lv_a_0_0=ruleAavoidable();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getACIDavoidableRule());
            	        }
                   		set(
                   			current, 
                   			"a",
                    		lv_a_0_0, 
                    		"Aavoidable");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleACIDavoidable2001); 

                	newLeafNode(otherlv_1, grammarAccess.getACIDavoidableAccess().getFullStopKeyword_1());
                
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:974:1: ( (lv_c_2_0= ruleCavoidable ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:975:1: (lv_c_2_0= ruleCavoidable )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:975:1: (lv_c_2_0= ruleCavoidable )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:976:3: lv_c_2_0= ruleCavoidable
            {
             
            	        newCompositeNode(grammarAccess.getACIDavoidableAccess().getCCavoidableEnumRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleCavoidable_in_ruleACIDavoidable2022);
            lv_c_2_0=ruleCavoidable();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getACIDavoidableRule());
            	        }
                   		set(
                   			current, 
                   			"c",
                    		lv_c_2_0, 
                    		"Cavoidable");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,16,FOLLOW_16_in_ruleACIDavoidable2034); 

                	newLeafNode(otherlv_3, grammarAccess.getACIDavoidableAccess().getFullStopKeyword_3());
                
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:996:1: ( (lv_i_4_0= ruleIavoidable ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:997:1: (lv_i_4_0= ruleIavoidable )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:997:1: (lv_i_4_0= ruleIavoidable )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:998:3: lv_i_4_0= ruleIavoidable
            {
             
            	        newCompositeNode(grammarAccess.getACIDavoidableAccess().getIIavoidableEnumRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleIavoidable_in_ruleACIDavoidable2055);
            lv_i_4_0=ruleIavoidable();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getACIDavoidableRule());
            	        }
                   		set(
                   			current, 
                   			"i",
                    		lv_i_4_0, 
                    		"Iavoidable");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleACIDavoidable2067); 

                	newLeafNode(otherlv_5, grammarAccess.getACIDavoidableAccess().getFullStopKeyword_5());
                
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1018:1: ( (lv_d_6_0= ruleDavoidable ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1019:1: (lv_d_6_0= ruleDavoidable )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1019:1: (lv_d_6_0= ruleDavoidable )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1020:3: lv_d_6_0= ruleDavoidable
            {
             
            	        newCompositeNode(grammarAccess.getACIDavoidableAccess().getDDavoidableEnumRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_ruleDavoidable_in_ruleACIDavoidable2088);
            lv_d_6_0=ruleDavoidable();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getACIDavoidableRule());
            	        }
                   		set(
                   			current, 
                   			"d",
                    		lv_d_6_0, 
                    		"Davoidable");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleACIDavoidable"


    // $ANTLR start "entryRuleACIDMitigation"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1044:1: entryRuleACIDMitigation returns [EObject current=null] : iv_ruleACIDMitigation= ruleACIDMitigation EOF ;
    public final EObject entryRuleACIDMitigation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleACIDMitigation = null;


        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1045:2: (iv_ruleACIDMitigation= ruleACIDMitigation EOF )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1046:2: iv_ruleACIDMitigation= ruleACIDMitigation EOF
            {
             newCompositeNode(grammarAccess.getACIDMitigationRule()); 
            pushFollow(FOLLOW_ruleACIDMitigation_in_entryRuleACIDMitigation2124);
            iv_ruleACIDMitigation=ruleACIDMitigation();

            state._fsp--;

             current =iv_ruleACIDMitigation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleACIDMitigation2134); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleACIDMitigation"


    // $ANTLR start "ruleACIDMitigation"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1053:1: ruleACIDMitigation returns [EObject current=null] : ( ( (lv_a_0_0= ruleAmitigation ) ) otherlv_1= '.' ( (lv_c_2_0= ruleCmitigation ) ) otherlv_3= '.' ( (lv_i_4_0= ruleImitigation ) ) otherlv_5= '.' ( (lv_d_6_0= ruleDmitigation ) ) ) ;
    public final EObject ruleACIDMitigation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Enumerator lv_a_0_0 = null;

        Enumerator lv_c_2_0 = null;

        Enumerator lv_i_4_0 = null;

        Enumerator lv_d_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1056:28: ( ( ( (lv_a_0_0= ruleAmitigation ) ) otherlv_1= '.' ( (lv_c_2_0= ruleCmitigation ) ) otherlv_3= '.' ( (lv_i_4_0= ruleImitigation ) ) otherlv_5= '.' ( (lv_d_6_0= ruleDmitigation ) ) ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1057:1: ( ( (lv_a_0_0= ruleAmitigation ) ) otherlv_1= '.' ( (lv_c_2_0= ruleCmitigation ) ) otherlv_3= '.' ( (lv_i_4_0= ruleImitigation ) ) otherlv_5= '.' ( (lv_d_6_0= ruleDmitigation ) ) )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1057:1: ( ( (lv_a_0_0= ruleAmitigation ) ) otherlv_1= '.' ( (lv_c_2_0= ruleCmitigation ) ) otherlv_3= '.' ( (lv_i_4_0= ruleImitigation ) ) otherlv_5= '.' ( (lv_d_6_0= ruleDmitigation ) ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1057:2: ( (lv_a_0_0= ruleAmitigation ) ) otherlv_1= '.' ( (lv_c_2_0= ruleCmitigation ) ) otherlv_3= '.' ( (lv_i_4_0= ruleImitigation ) ) otherlv_5= '.' ( (lv_d_6_0= ruleDmitigation ) )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1057:2: ( (lv_a_0_0= ruleAmitigation ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1058:1: (lv_a_0_0= ruleAmitigation )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1058:1: (lv_a_0_0= ruleAmitigation )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1059:3: lv_a_0_0= ruleAmitigation
            {
             
            	        newCompositeNode(grammarAccess.getACIDMitigationAccess().getAAmitigationEnumRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleAmitigation_in_ruleACIDMitigation2180);
            lv_a_0_0=ruleAmitigation();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getACIDMitigationRule());
            	        }
                   		set(
                   			current, 
                   			"a",
                    		lv_a_0_0, 
                    		"Amitigation");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleACIDMitigation2192); 

                	newLeafNode(otherlv_1, grammarAccess.getACIDMitigationAccess().getFullStopKeyword_1());
                
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1079:1: ( (lv_c_2_0= ruleCmitigation ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1080:1: (lv_c_2_0= ruleCmitigation )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1080:1: (lv_c_2_0= ruleCmitigation )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1081:3: lv_c_2_0= ruleCmitigation
            {
             
            	        newCompositeNode(grammarAccess.getACIDMitigationAccess().getCCmitigationEnumRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleCmitigation_in_ruleACIDMitigation2213);
            lv_c_2_0=ruleCmitigation();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getACIDMitigationRule());
            	        }
                   		set(
                   			current, 
                   			"c",
                    		lv_c_2_0, 
                    		"Cmitigation");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,16,FOLLOW_16_in_ruleACIDMitigation2225); 

                	newLeafNode(otherlv_3, grammarAccess.getACIDMitigationAccess().getFullStopKeyword_3());
                
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1101:1: ( (lv_i_4_0= ruleImitigation ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1102:1: (lv_i_4_0= ruleImitigation )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1102:1: (lv_i_4_0= ruleImitigation )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1103:3: lv_i_4_0= ruleImitigation
            {
             
            	        newCompositeNode(grammarAccess.getACIDMitigationAccess().getIImitigationEnumRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleImitigation_in_ruleACIDMitigation2246);
            lv_i_4_0=ruleImitigation();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getACIDMitigationRule());
            	        }
                   		set(
                   			current, 
                   			"i",
                    		lv_i_4_0, 
                    		"Imitigation");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleACIDMitigation2258); 

                	newLeafNode(otherlv_5, grammarAccess.getACIDMitigationAccess().getFullStopKeyword_5());
                
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1123:1: ( (lv_d_6_0= ruleDmitigation ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1124:1: (lv_d_6_0= ruleDmitigation )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1124:1: (lv_d_6_0= ruleDmitigation )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1125:3: lv_d_6_0= ruleDmitigation
            {
             
            	        newCompositeNode(grammarAccess.getACIDMitigationAccess().getDDmitigationEnumRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_ruleDmitigation_in_ruleACIDMitigation2279);
            lv_d_6_0=ruleDmitigation();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getACIDMitigationRule());
            	        }
                   		set(
                   			current, 
                   			"d",
                    		lv_d_6_0, 
                    		"Dmitigation");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleACIDMitigation"


    // $ANTLR start "ruleActualFailureType"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1153:1: ruleActualFailureType returns [Enumerator current=null] : ( (enumLiteral_0= 'early' ) | (enumLiteral_1= 'late' ) | (enumLiteral_2= 'commission' ) | (enumLiteral_3= 'omission' ) | (enumLiteral_4= 'valueSubtle' ) | (enumLiteral_5= 'valueCoarse' ) ) ;
    public final Enumerator ruleActualFailureType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;

         enterRule(); 
        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1155:28: ( ( (enumLiteral_0= 'early' ) | (enumLiteral_1= 'late' ) | (enumLiteral_2= 'commission' ) | (enumLiteral_3= 'omission' ) | (enumLiteral_4= 'valueSubtle' ) | (enumLiteral_5= 'valueCoarse' ) ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1156:1: ( (enumLiteral_0= 'early' ) | (enumLiteral_1= 'late' ) | (enumLiteral_2= 'commission' ) | (enumLiteral_3= 'omission' ) | (enumLiteral_4= 'valueSubtle' ) | (enumLiteral_5= 'valueCoarse' ) )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1156:1: ( (enumLiteral_0= 'early' ) | (enumLiteral_1= 'late' ) | (enumLiteral_2= 'commission' ) | (enumLiteral_3= 'omission' ) | (enumLiteral_4= 'valueSubtle' ) | (enumLiteral_5= 'valueCoarse' ) )
            int alt11=6;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt11=1;
                }
                break;
            case 22:
                {
                alt11=2;
                }
                break;
            case 23:
                {
                alt11=3;
                }
                break;
            case 24:
                {
                alt11=4;
                }
                break;
            case 25:
                {
                alt11=5;
                }
                break;
            case 26:
                {
                alt11=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1156:2: (enumLiteral_0= 'early' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1156:2: (enumLiteral_0= 'early' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1156:4: enumLiteral_0= 'early'
                    {
                    enumLiteral_0=(Token)match(input,21,FOLLOW_21_in_ruleActualFailureType2333); 

                            current = grammarAccess.getActualFailureTypeAccess().getEARLYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getActualFailureTypeAccess().getEARLYEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1162:6: (enumLiteral_1= 'late' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1162:6: (enumLiteral_1= 'late' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1162:8: enumLiteral_1= 'late'
                    {
                    enumLiteral_1=(Token)match(input,22,FOLLOW_22_in_ruleActualFailureType2350); 

                            current = grammarAccess.getActualFailureTypeAccess().getLATEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getActualFailureTypeAccess().getLATEEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1168:6: (enumLiteral_2= 'commission' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1168:6: (enumLiteral_2= 'commission' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1168:8: enumLiteral_2= 'commission'
                    {
                    enumLiteral_2=(Token)match(input,23,FOLLOW_23_in_ruleActualFailureType2367); 

                            current = grammarAccess.getActualFailureTypeAccess().getCOMMISSIONEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getActualFailureTypeAccess().getCOMMISSIONEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1174:6: (enumLiteral_3= 'omission' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1174:6: (enumLiteral_3= 'omission' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1174:8: enumLiteral_3= 'omission'
                    {
                    enumLiteral_3=(Token)match(input,24,FOLLOW_24_in_ruleActualFailureType2384); 

                            current = grammarAccess.getActualFailureTypeAccess().getOMISSIONEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getActualFailureTypeAccess().getOMISSIONEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1180:6: (enumLiteral_4= 'valueSubtle' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1180:6: (enumLiteral_4= 'valueSubtle' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1180:8: enumLiteral_4= 'valueSubtle'
                    {
                    enumLiteral_4=(Token)match(input,25,FOLLOW_25_in_ruleActualFailureType2401); 

                            current = grammarAccess.getActualFailureTypeAccess().getVALUE_SUBTLEEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getActualFailureTypeAccess().getVALUE_SUBTLEEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1186:6: (enumLiteral_5= 'valueCoarse' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1186:6: (enumLiteral_5= 'valueCoarse' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1186:8: enumLiteral_5= 'valueCoarse'
                    {
                    enumLiteral_5=(Token)match(input,26,FOLLOW_26_in_ruleActualFailureType2418); 

                            current = grammarAccess.getActualFailureTypeAccess().getVALUE_COARSEEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getActualFailureTypeAccess().getVALUE_COARSEEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActualFailureType"


    // $ANTLR start "ruleAavoidable"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1200:1: ruleAavoidable returns [Enumerator current=null] : ( (enumLiteral_0= 'incompletion' ) | (enumLiteral_1= 'none' ) | (enumLiteral_2= 'unspecified' ) ) ;
    public final Enumerator ruleAavoidable() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1202:28: ( ( (enumLiteral_0= 'incompletion' ) | (enumLiteral_1= 'none' ) | (enumLiteral_2= 'unspecified' ) ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1203:1: ( (enumLiteral_0= 'incompletion' ) | (enumLiteral_1= 'none' ) | (enumLiteral_2= 'unspecified' ) )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1203:1: ( (enumLiteral_0= 'incompletion' ) | (enumLiteral_1= 'none' ) | (enumLiteral_2= 'unspecified' ) )
            int alt12=3;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt12=1;
                }
                break;
            case 28:
                {
                alt12=2;
                }
                break;
            case 29:
                {
                alt12=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1203:2: (enumLiteral_0= 'incompletion' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1203:2: (enumLiteral_0= 'incompletion' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1203:4: enumLiteral_0= 'incompletion'
                    {
                    enumLiteral_0=(Token)match(input,27,FOLLOW_27_in_ruleAavoidable2467); 

                            current = grammarAccess.getAavoidableAccess().getINCOMPLETIONEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getAavoidableAccess().getINCOMPLETIONEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1209:6: (enumLiteral_1= 'none' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1209:6: (enumLiteral_1= 'none' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1209:8: enumLiteral_1= 'none'
                    {
                    enumLiteral_1=(Token)match(input,28,FOLLOW_28_in_ruleAavoidable2484); 

                            current = grammarAccess.getAavoidableAccess().getNONEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getAavoidableAccess().getNONEEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1215:6: (enumLiteral_2= 'unspecified' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1215:6: (enumLiteral_2= 'unspecified' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1215:8: enumLiteral_2= 'unspecified'
                    {
                    enumLiteral_2=(Token)match(input,29,FOLLOW_29_in_ruleAavoidable2501); 

                            current = grammarAccess.getAavoidableAccess().getUNSPECIFIEDEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getAavoidableAccess().getUNSPECIFIEDEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAavoidable"


    // $ANTLR start "ruleCavoidable"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1225:1: ruleCavoidable returns [Enumerator current=null] : ( (enumLiteral_0= 'inconsistency' ) | (enumLiteral_1= 'none' ) | (enumLiteral_2= 'unspecified' ) ) ;
    public final Enumerator ruleCavoidable() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1227:28: ( ( (enumLiteral_0= 'inconsistency' ) | (enumLiteral_1= 'none' ) | (enumLiteral_2= 'unspecified' ) ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1228:1: ( (enumLiteral_0= 'inconsistency' ) | (enumLiteral_1= 'none' ) | (enumLiteral_2= 'unspecified' ) )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1228:1: ( (enumLiteral_0= 'inconsistency' ) | (enumLiteral_1= 'none' ) | (enumLiteral_2= 'unspecified' ) )
            int alt13=3;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt13=1;
                }
                break;
            case 28:
                {
                alt13=2;
                }
                break;
            case 29:
                {
                alt13=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1228:2: (enumLiteral_0= 'inconsistency' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1228:2: (enumLiteral_0= 'inconsistency' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1228:4: enumLiteral_0= 'inconsistency'
                    {
                    enumLiteral_0=(Token)match(input,30,FOLLOW_30_in_ruleCavoidable2546); 

                            current = grammarAccess.getCavoidableAccess().getINCONSISTENCYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getCavoidableAccess().getINCONSISTENCYEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1234:6: (enumLiteral_1= 'none' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1234:6: (enumLiteral_1= 'none' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1234:8: enumLiteral_1= 'none'
                    {
                    enumLiteral_1=(Token)match(input,28,FOLLOW_28_in_ruleCavoidable2563); 

                            current = grammarAccess.getCavoidableAccess().getNONEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getCavoidableAccess().getNONEEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1240:6: (enumLiteral_2= 'unspecified' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1240:6: (enumLiteral_2= 'unspecified' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1240:8: enumLiteral_2= 'unspecified'
                    {
                    enumLiteral_2=(Token)match(input,29,FOLLOW_29_in_ruleCavoidable2580); 

                            current = grammarAccess.getCavoidableAccess().getUNSPECIFIEDEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getCavoidableAccess().getUNSPECIFIEDEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCavoidable"


    // $ANTLR start "ruleIavoidable"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1250:1: ruleIavoidable returns [Enumerator current=null] : ( (enumLiteral_0= 'interference' ) | (enumLiteral_1= 'none' ) | (enumLiteral_2= 'unspecified' ) ) ;
    public final Enumerator ruleIavoidable() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1252:28: ( ( (enumLiteral_0= 'interference' ) | (enumLiteral_1= 'none' ) | (enumLiteral_2= 'unspecified' ) ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1253:1: ( (enumLiteral_0= 'interference' ) | (enumLiteral_1= 'none' ) | (enumLiteral_2= 'unspecified' ) )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1253:1: ( (enumLiteral_0= 'interference' ) | (enumLiteral_1= 'none' ) | (enumLiteral_2= 'unspecified' ) )
            int alt14=3;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt14=1;
                }
                break;
            case 28:
                {
                alt14=2;
                }
                break;
            case 29:
                {
                alt14=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1253:2: (enumLiteral_0= 'interference' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1253:2: (enumLiteral_0= 'interference' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1253:4: enumLiteral_0= 'interference'
                    {
                    enumLiteral_0=(Token)match(input,31,FOLLOW_31_in_ruleIavoidable2625); 

                            current = grammarAccess.getIavoidableAccess().getINTERFERENCEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getIavoidableAccess().getINTERFERENCEEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1259:6: (enumLiteral_1= 'none' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1259:6: (enumLiteral_1= 'none' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1259:8: enumLiteral_1= 'none'
                    {
                    enumLiteral_1=(Token)match(input,28,FOLLOW_28_in_ruleIavoidable2642); 

                            current = grammarAccess.getIavoidableAccess().getNONEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getIavoidableAccess().getNONEEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1265:6: (enumLiteral_2= 'unspecified' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1265:6: (enumLiteral_2= 'unspecified' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1265:8: enumLiteral_2= 'unspecified'
                    {
                    enumLiteral_2=(Token)match(input,29,FOLLOW_29_in_ruleIavoidable2659); 

                            current = grammarAccess.getIavoidableAccess().getUNSPECIFIEDEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getIavoidableAccess().getUNSPECIFIEDEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIavoidable"


    // $ANTLR start "ruleDavoidable"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1275:1: ruleDavoidable returns [Enumerator current=null] : ( (enumLiteral_0= 'impermanence' ) | (enumLiteral_1= 'none' ) | (enumLiteral_2= 'unspecified' ) ) ;
    public final Enumerator ruleDavoidable() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1277:28: ( ( (enumLiteral_0= 'impermanence' ) | (enumLiteral_1= 'none' ) | (enumLiteral_2= 'unspecified' ) ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1278:1: ( (enumLiteral_0= 'impermanence' ) | (enumLiteral_1= 'none' ) | (enumLiteral_2= 'unspecified' ) )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1278:1: ( (enumLiteral_0= 'impermanence' ) | (enumLiteral_1= 'none' ) | (enumLiteral_2= 'unspecified' ) )
            int alt15=3;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt15=1;
                }
                break;
            case 28:
                {
                alt15=2;
                }
                break;
            case 29:
                {
                alt15=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1278:2: (enumLiteral_0= 'impermanence' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1278:2: (enumLiteral_0= 'impermanence' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1278:4: enumLiteral_0= 'impermanence'
                    {
                    enumLiteral_0=(Token)match(input,32,FOLLOW_32_in_ruleDavoidable2704); 

                            current = grammarAccess.getDavoidableAccess().getIMPERMANENCEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getDavoidableAccess().getIMPERMANENCEEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1284:6: (enumLiteral_1= 'none' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1284:6: (enumLiteral_1= 'none' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1284:8: enumLiteral_1= 'none'
                    {
                    enumLiteral_1=(Token)match(input,28,FOLLOW_28_in_ruleDavoidable2721); 

                            current = grammarAccess.getDavoidableAccess().getNONEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getDavoidableAccess().getNONEEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1290:6: (enumLiteral_2= 'unspecified' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1290:6: (enumLiteral_2= 'unspecified' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1290:8: enumLiteral_2= 'unspecified'
                    {
                    enumLiteral_2=(Token)match(input,29,FOLLOW_29_in_ruleDavoidable2738); 

                            current = grammarAccess.getDavoidableAccess().getUNSPECIFIEDEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getDavoidableAccess().getUNSPECIFIEDEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDavoidable"


    // $ANTLR start "ruleAmitigation"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1300:1: ruleAmitigation returns [Enumerator current=null] : ( (enumLiteral_0= 'all_or_nothing' ) | (enumLiteral_1= 'all_or_compensation' ) | (enumLiteral_2= 'none' ) | (enumLiteral_3= 'unspecified' ) ) ;
    public final Enumerator ruleAmitigation() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1302:28: ( ( (enumLiteral_0= 'all_or_nothing' ) | (enumLiteral_1= 'all_or_compensation' ) | (enumLiteral_2= 'none' ) | (enumLiteral_3= 'unspecified' ) ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1303:1: ( (enumLiteral_0= 'all_or_nothing' ) | (enumLiteral_1= 'all_or_compensation' ) | (enumLiteral_2= 'none' ) | (enumLiteral_3= 'unspecified' ) )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1303:1: ( (enumLiteral_0= 'all_or_nothing' ) | (enumLiteral_1= 'all_or_compensation' ) | (enumLiteral_2= 'none' ) | (enumLiteral_3= 'unspecified' ) )
            int alt16=4;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt16=1;
                }
                break;
            case 34:
                {
                alt16=2;
                }
                break;
            case 28:
                {
                alt16=3;
                }
                break;
            case 29:
                {
                alt16=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1303:2: (enumLiteral_0= 'all_or_nothing' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1303:2: (enumLiteral_0= 'all_or_nothing' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1303:4: enumLiteral_0= 'all_or_nothing'
                    {
                    enumLiteral_0=(Token)match(input,33,FOLLOW_33_in_ruleAmitigation2783); 

                            current = grammarAccess.getAmitigationAccess().getALL_OR_NOTHINGEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getAmitigationAccess().getALL_OR_NOTHINGEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1309:6: (enumLiteral_1= 'all_or_compensation' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1309:6: (enumLiteral_1= 'all_or_compensation' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1309:8: enumLiteral_1= 'all_or_compensation'
                    {
                    enumLiteral_1=(Token)match(input,34,FOLLOW_34_in_ruleAmitigation2800); 

                            current = grammarAccess.getAmitigationAccess().getALL_OR_COMPENSATIONEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getAmitigationAccess().getALL_OR_COMPENSATIONEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1315:6: (enumLiteral_2= 'none' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1315:6: (enumLiteral_2= 'none' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1315:8: enumLiteral_2= 'none'
                    {
                    enumLiteral_2=(Token)match(input,28,FOLLOW_28_in_ruleAmitigation2817); 

                            current = grammarAccess.getAmitigationAccess().getNONEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getAmitigationAccess().getNONEEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1321:6: (enumLiteral_3= 'unspecified' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1321:6: (enumLiteral_3= 'unspecified' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1321:8: enumLiteral_3= 'unspecified'
                    {
                    enumLiteral_3=(Token)match(input,29,FOLLOW_29_in_ruleAmitigation2834); 

                            current = grammarAccess.getAmitigationAccess().getUNSPECIFIEDEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getAmitigationAccess().getUNSPECIFIEDEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAmitigation"


    // $ANTLR start "ruleCmitigation"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1331:1: ruleCmitigation returns [Enumerator current=null] : ( (enumLiteral_0= 'full_consistency' ) | (enumLiteral_1= 'range_violation_allowed' ) | (enumLiteral_2= 'none' ) | (enumLiteral_3= 'unspecified' ) ) ;
    public final Enumerator ruleCmitigation() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1333:28: ( ( (enumLiteral_0= 'full_consistency' ) | (enumLiteral_1= 'range_violation_allowed' ) | (enumLiteral_2= 'none' ) | (enumLiteral_3= 'unspecified' ) ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1334:1: ( (enumLiteral_0= 'full_consistency' ) | (enumLiteral_1= 'range_violation_allowed' ) | (enumLiteral_2= 'none' ) | (enumLiteral_3= 'unspecified' ) )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1334:1: ( (enumLiteral_0= 'full_consistency' ) | (enumLiteral_1= 'range_violation_allowed' ) | (enumLiteral_2= 'none' ) | (enumLiteral_3= 'unspecified' ) )
            int alt17=4;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt17=1;
                }
                break;
            case 36:
                {
                alt17=2;
                }
                break;
            case 28:
                {
                alt17=3;
                }
                break;
            case 29:
                {
                alt17=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1334:2: (enumLiteral_0= 'full_consistency' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1334:2: (enumLiteral_0= 'full_consistency' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1334:4: enumLiteral_0= 'full_consistency'
                    {
                    enumLiteral_0=(Token)match(input,35,FOLLOW_35_in_ruleCmitigation2879); 

                            current = grammarAccess.getCmitigationAccess().getFULL_CONSISTENCYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getCmitigationAccess().getFULL_CONSISTENCYEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1340:6: (enumLiteral_1= 'range_violation_allowed' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1340:6: (enumLiteral_1= 'range_violation_allowed' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1340:8: enumLiteral_1= 'range_violation_allowed'
                    {
                    enumLiteral_1=(Token)match(input,36,FOLLOW_36_in_ruleCmitigation2896); 

                            current = grammarAccess.getCmitigationAccess().getRANGE_VIOLATION_ALLOWEDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getCmitigationAccess().getRANGE_VIOLATION_ALLOWEDEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1346:6: (enumLiteral_2= 'none' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1346:6: (enumLiteral_2= 'none' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1346:8: enumLiteral_2= 'none'
                    {
                    enumLiteral_2=(Token)match(input,28,FOLLOW_28_in_ruleCmitigation2913); 

                            current = grammarAccess.getCmitigationAccess().getNONEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getCmitigationAccess().getNONEEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1352:6: (enumLiteral_3= 'unspecified' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1352:6: (enumLiteral_3= 'unspecified' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1352:8: enumLiteral_3= 'unspecified'
                    {
                    enumLiteral_3=(Token)match(input,29,FOLLOW_29_in_ruleCmitigation2930); 

                            current = grammarAccess.getCmitigationAccess().getUNSPECIFIEDEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getCmitigationAccess().getUNSPECIFIEDEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCmitigation"


    // $ANTLR start "ruleImitigation"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1362:1: ruleImitigation returns [Enumerator current=null] : ( (enumLiteral_0= 'serializable' ) | (enumLiteral_1= 'portable_level' ) | (enumLiteral_2= 'none' ) | (enumLiteral_3= 'unspecified' ) ) ;
    public final Enumerator ruleImitigation() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1364:28: ( ( (enumLiteral_0= 'serializable' ) | (enumLiteral_1= 'portable_level' ) | (enumLiteral_2= 'none' ) | (enumLiteral_3= 'unspecified' ) ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1365:1: ( (enumLiteral_0= 'serializable' ) | (enumLiteral_1= 'portable_level' ) | (enumLiteral_2= 'none' ) | (enumLiteral_3= 'unspecified' ) )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1365:1: ( (enumLiteral_0= 'serializable' ) | (enumLiteral_1= 'portable_level' ) | (enumLiteral_2= 'none' ) | (enumLiteral_3= 'unspecified' ) )
            int alt18=4;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt18=1;
                }
                break;
            case 38:
                {
                alt18=2;
                }
                break;
            case 28:
                {
                alt18=3;
                }
                break;
            case 29:
                {
                alt18=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1365:2: (enumLiteral_0= 'serializable' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1365:2: (enumLiteral_0= 'serializable' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1365:4: enumLiteral_0= 'serializable'
                    {
                    enumLiteral_0=(Token)match(input,37,FOLLOW_37_in_ruleImitigation2975); 

                            current = grammarAccess.getImitigationAccess().getSERIALIZABLEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getImitigationAccess().getSERIALIZABLEEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1371:6: (enumLiteral_1= 'portable_level' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1371:6: (enumLiteral_1= 'portable_level' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1371:8: enumLiteral_1= 'portable_level'
                    {
                    enumLiteral_1=(Token)match(input,38,FOLLOW_38_in_ruleImitigation2992); 

                            current = grammarAccess.getImitigationAccess().getPORTABLE_LEVELEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getImitigationAccess().getPORTABLE_LEVELEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1377:6: (enumLiteral_2= 'none' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1377:6: (enumLiteral_2= 'none' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1377:8: enumLiteral_2= 'none'
                    {
                    enumLiteral_2=(Token)match(input,28,FOLLOW_28_in_ruleImitigation3009); 

                            current = grammarAccess.getImitigationAccess().getNONEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getImitigationAccess().getNONEEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1383:6: (enumLiteral_3= 'unspecified' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1383:6: (enumLiteral_3= 'unspecified' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1383:8: enumLiteral_3= 'unspecified'
                    {
                    enumLiteral_3=(Token)match(input,29,FOLLOW_29_in_ruleImitigation3026); 

                            current = grammarAccess.getImitigationAccess().getUNSPECIFIEDEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getImitigationAccess().getUNSPECIFIEDEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImitigation"


    // $ANTLR start "ruleDmitigation"
    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1393:1: ruleDmitigation returns [Enumerator current=null] : ( (enumLiteral_0= 'no_loss' ) | (enumLiteral_1= 'partial_loss_allowed' ) | (enumLiteral_2= 'none' ) | (enumLiteral_3= 'unspecified' ) ) ;
    public final Enumerator ruleDmitigation() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1395:28: ( ( (enumLiteral_0= 'no_loss' ) | (enumLiteral_1= 'partial_loss_allowed' ) | (enumLiteral_2= 'none' ) | (enumLiteral_3= 'unspecified' ) ) )
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1396:1: ( (enumLiteral_0= 'no_loss' ) | (enumLiteral_1= 'partial_loss_allowed' ) | (enumLiteral_2= 'none' ) | (enumLiteral_3= 'unspecified' ) )
            {
            // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1396:1: ( (enumLiteral_0= 'no_loss' ) | (enumLiteral_1= 'partial_loss_allowed' ) | (enumLiteral_2= 'none' ) | (enumLiteral_3= 'unspecified' ) )
            int alt19=4;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt19=1;
                }
                break;
            case 40:
                {
                alt19=2;
                }
                break;
            case 28:
                {
                alt19=3;
                }
                break;
            case 29:
                {
                alt19=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1396:2: (enumLiteral_0= 'no_loss' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1396:2: (enumLiteral_0= 'no_loss' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1396:4: enumLiteral_0= 'no_loss'
                    {
                    enumLiteral_0=(Token)match(input,39,FOLLOW_39_in_ruleDmitigation3071); 

                            current = grammarAccess.getDmitigationAccess().getNO_LOSSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getDmitigationAccess().getNO_LOSSEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1402:6: (enumLiteral_1= 'partial_loss_allowed' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1402:6: (enumLiteral_1= 'partial_loss_allowed' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1402:8: enumLiteral_1= 'partial_loss_allowed'
                    {
                    enumLiteral_1=(Token)match(input,40,FOLLOW_40_in_ruleDmitigation3088); 

                            current = grammarAccess.getDmitigationAccess().getPARTIAL_LOSS_ALLOWEDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getDmitigationAccess().getPARTIAL_LOSS_ALLOWEDEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1408:6: (enumLiteral_2= 'none' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1408:6: (enumLiteral_2= 'none' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1408:8: enumLiteral_2= 'none'
                    {
                    enumLiteral_2=(Token)match(input,28,FOLLOW_28_in_ruleDmitigation3105); 

                            current = grammarAccess.getDmitigationAccess().getNONEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getDmitigationAccess().getNONEEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1414:6: (enumLiteral_3= 'unspecified' )
                    {
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1414:6: (enumLiteral_3= 'unspecified' )
                    // ../org.polarsys.chess.xtext.fladsl/src-gen/org/polarsys/chess/xtext/parser/antlr/internal/InternalFlaDsl.g:1414:8: enumLiteral_3= 'unspecified'
                    {
                    enumLiteral_3=(Token)match(input,29,FOLLOW_29_in_ruleDmitigation3122); 

                            current = grammarAccess.getDmitigationAccess().getUNSPECIFIEDEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getDmitigationAccess().getUNSPECIFIEDEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDmitigation"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleBehaviour_in_entryRuleBehaviour75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBehaviour85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleBehaviour130 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleExpression213 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleLhs_in_ruleExpression234 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleExpression246 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleRhs_in_ruleExpression267 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleExpression279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLhs_in_entryRuleLhs315 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLhs325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInputExpression_in_ruleLhs371 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleLhs384 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleInputExpression_in_ruleLhs405 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleRhs_in_entryRuleRhs443 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRhs453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOutputExpression_in_ruleRhs499 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleRhs512 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleOutputExpression_in_ruleRhs533 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleInputExpression_in_entryRuleInputExpression571 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInputExpression581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInputExpression627 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_15_in_ruleInputExpression645 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleInputExpression658 = new BitSet(new long[]{0x0000000007FA0010L});
    public static final BitSet FOLLOW_ruleInFailureExpr_in_ruleInputExpression679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOutputExpression_in_entryRuleOutputExpression715 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOutputExpression725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOutputExpression771 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_15_in_ruleOutputExpression789 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleOutputExpression802 = new BitSet(new long[]{0x0000000007FA0010L});
    public static final BitSet FOLLOW_ruleOutFailureExpr_in_ruleOutputExpression823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInFailureExpr_in_entryRuleInFailureExpr859 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInFailureExpr869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcardDefinition_in_ruleInFailureExpr915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNoFailureDefinition_in_ruleInFailureExpr942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFailureDefinition_in_ruleInFailureExpr969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleInFailureExpr988 = new BitSet(new long[]{0x0000000007E00000L});
    public static final BitSet FOLLOW_ruleFailureDefinition_in_ruleInFailureExpr1009 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleInFailureExpr1022 = new BitSet(new long[]{0x0000000007E00000L});
    public static final BitSet FOLLOW_ruleFailureDefinition_in_ruleInFailureExpr1043 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_18_in_ruleInFailureExpr1057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_ruleInFailureExpr1085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOutFailureExpr_in_entryRuleOutFailureExpr1121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOutFailureExpr1131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNoFailureDefinition_in_ruleOutFailureExpr1177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComplexNofailureDefinition_in_ruleOutFailureExpr1204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFailureDefinition_in_ruleOutFailureExpr1231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleOutFailureExpr1250 = new BitSet(new long[]{0x0000000007E00000L});
    public static final BitSet FOLLOW_ruleFailureDefinition_in_ruleOutFailureExpr1271 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleOutFailureExpr1284 = new BitSet(new long[]{0x0000000007E00000L});
    public static final BitSet FOLLOW_ruleFailureDefinition_in_ruleOutFailureExpr1305 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_18_in_ruleOutFailureExpr1319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_ruleOutFailureExpr1347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFailureDefinition_in_entryRuleFailureDefinition1385 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFailureDefinition1395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActualFailureType_in_ruleFailureDefinition1450 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleFailureDefinition1463 = new BitSet(new long[]{0x0000000038000000L});
    public static final BitSet FOLLOW_ruleACIDavoidable_in_ruleFailureDefinition1484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNoFailureDefinition_in_entryRuleNoFailureDefinition1522 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNoFailureDefinition1532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleNoFailureDefinition1578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComplexNofailureDefinition_in_entryRuleComplexNofailureDefinition1614 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComplexNofailureDefinition1624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleComplexNofailureDefinition1670 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleComplexNofailureDefinition1682 = new BitSet(new long[]{0x0000000630000000L});
    public static final BitSet FOLLOW_ruleACIDMitigation_in_ruleComplexNofailureDefinition1703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcardDefinition_in_entryRuleWildcardDefinition1739 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWildcardDefinition1749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleWildcardDefinition1795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_entryRuleVariableDefinition1831 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDefinition1841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableDefinition1892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleACIDavoidable_in_entryRuleACIDavoidable1933 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleACIDavoidable1943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAavoidable_in_ruleACIDavoidable1989 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleACIDavoidable2001 = new BitSet(new long[]{0x0000000070000000L});
    public static final BitSet FOLLOW_ruleCavoidable_in_ruleACIDavoidable2022 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleACIDavoidable2034 = new BitSet(new long[]{0x00000000B0000000L});
    public static final BitSet FOLLOW_ruleIavoidable_in_ruleACIDavoidable2055 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleACIDavoidable2067 = new BitSet(new long[]{0x0000000130000000L});
    public static final BitSet FOLLOW_ruleDavoidable_in_ruleACIDavoidable2088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleACIDMitigation_in_entryRuleACIDMitigation2124 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleACIDMitigation2134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAmitigation_in_ruleACIDMitigation2180 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleACIDMitigation2192 = new BitSet(new long[]{0x0000001830000000L});
    public static final BitSet FOLLOW_ruleCmitigation_in_ruleACIDMitigation2213 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleACIDMitigation2225 = new BitSet(new long[]{0x0000006030000000L});
    public static final BitSet FOLLOW_ruleImitigation_in_ruleACIDMitigation2246 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleACIDMitigation2258 = new BitSet(new long[]{0x0000018030000000L});
    public static final BitSet FOLLOW_ruleDmitigation_in_ruleACIDMitigation2279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleActualFailureType2333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleActualFailureType2350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleActualFailureType2367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleActualFailureType2384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleActualFailureType2401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleActualFailureType2418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleAavoidable2467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleAavoidable2484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleAavoidable2501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleCavoidable2546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleCavoidable2563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleCavoidable2580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleIavoidable2625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleIavoidable2642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleIavoidable2659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleDavoidable2704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleDavoidable2721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleDavoidable2738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleAmitigation2783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleAmitigation2800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleAmitigation2817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleAmitigation2834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleCmitigation2879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleCmitigation2896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleCmitigation2913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleCmitigation2930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleImitigation2975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleImitigation2992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleImitigation3009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleImitigation3026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleDmitigation3071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleDmitigation3088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleDmitigation3105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleDmitigation3122 = new BitSet(new long[]{0x0000000000000002L});

}