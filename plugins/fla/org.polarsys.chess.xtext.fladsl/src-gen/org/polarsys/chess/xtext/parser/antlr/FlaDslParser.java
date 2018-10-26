/*
* generated by Xtext
*/
package org.polarsys.chess.xtext.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.polarsys.chess.xtext.services.FlaDslGrammarAccess;

public class FlaDslParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private FlaDslGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected org.polarsys.chess.xtext.parser.antlr.internal.InternalFlaDslParser createParser(XtextTokenStream stream) {
		return new org.polarsys.chess.xtext.parser.antlr.internal.InternalFlaDslParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "Behaviour";
	}
	
	public FlaDslGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(FlaDslGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
