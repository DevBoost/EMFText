// $ANTLR 3.0b5 ActionTranslator.g 2006-11-23 01:51:22

package org.antlr.codegen;
import org.antlr.runtime.*;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.tool.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class ActionTranslatorLexer extends Lexer {
    public static final int LOCAL_ATTR=17;
    public static final int SET_DYNAMIC_SCOPE_ATTR=18;
    public static final int ISOLATED_DYNAMIC_SCOPE=24;
    public static final int WS=5;
    public static final int UNKNOWN_SYNTAX=35;
    public static final int DYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR=23;
    public static final int SCOPE_INDEX_EXPR=21;
    public static final int DYNAMIC_SCOPE_ATTR=19;
    public static final int ISOLATED_TOKEN_REF=14;
    public static final int SET_ATTRIBUTE=30;
    public static final int SET_EXPR_ATTRIBUTE=29;
    public static final int ACTION=27;
    public static final int ERROR_X=34;
    public static final int TEMPLATE_INSTANCE=26;
    public static final int TOKEN_SCOPE_ATTR=10;
    public static final int ISOLATED_LEXER_RULE_REF=15;
    public static final int ESC=32;
    public static final int SET_ENCLOSING_RULE_SCOPE_ATTR=7;
    public static final int ATTR_VALUE_EXPR=6;
    public static final int RULE_SCOPE_ATTR=12;
    public static final int LABEL_REF=13;
    public static final int INT=37;
    public static final int ARG=25;
    public static final int EOF=-1;
    public static final int SET_LOCAL_ATTR=16;
    public static final int TEXT=36;
    public static final int Tokens=38;
    public static final int DYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR=22;
    public static final int SET_TOKEN_SCOPE_ATTR=9;
    public static final int ERROR_SCOPED_XY=20;
    public static final int SET_RULE_SCOPE_ATTR=11;
    public static final int ENCLOSING_RULE_SCOPE_ATTR=8;
    public static final int ERROR_XY=33;
    public static final int TEMPLATE_EXPR=31;
    public static final int INDIRECT_TEMPLATE_INSTANCE=28;
    public static final int ID=4;

    public List chunks = new ArrayList();
    Rule enclosingRule;
    int outerAltNum;
    Grammar grammar;
    CodeGenerator generator;
    antlr.Token actionToken;

	int ruleNestingLevel = 0; 

	public Token emit(int tokenType,
					  int line, int charPosition,
					  int channel,
					  int start, int stop)
	{
		Token t = new CommonToken(input, tokenType, channel, start, stop);
		t.setLine(line);
		t.setText(text);
		t.setCharPositionInLine(charPosition);
		emit(t);
		return t;
	}

		public ActionTranslatorLexer(CodeGenerator generator,
    								 String ruleName,
    								 GrammarAST actionAST)
    	{
    		this(new ANTLRStringStream(actionAST.token.getText()));
    		this.generator = generator;
    		this.grammar = generator.grammar;
    	    this.enclosingRule = grammar.getRule(ruleName);
    	    this.actionToken = actionAST.token;
    	    this.outerAltNum = actionAST.outerAltNum;
    	}

    	public ActionTranslatorLexer(CodeGenerator generator,
    								 String ruleName,
    								 antlr.Token actionToken,
    								 int outerAltNum)
    	{
    		this(new ANTLRStringStream(actionToken.getText()));
    		this.generator = generator;
    		grammar = generator.grammar;
    	    this.enclosingRule = grammar.getRule(ruleName);
    	    this.actionToken = actionToken;
    		this.outerAltNum = outerAltNum;
    	}

    /*
    public ActionTranslatorLexer(CharStream input, CodeGenerator generator,
                                 Grammar grammar, Rule enclosingRule,
                                 antlr.Token actionToken, int outerAltNum)
    {
        this(input);
        this.grammar = grammar;
        this.generator = generator;
        this.enclosingRule = enclosingRule;
        this.actionToken = actionToken;
        this.outerAltNum = outerAltNum;
    }
    */

    /** Return a list of strings and StringTemplate objects that
     *  represent the translated action.
     */
    public List translateToChunks() {
    	// System.out.println("###\naction="+action);
    	Token t;
    	do {
    		t = nextToken();
    	} while ( t.getType()!= Token.EOF );
    	return chunks;
    }

    public String translate() {
    	List theChunks = translateToChunks();
    	//System.out.println("chunks="+a.chunks);
    	StringBuffer buf = new StringBuffer();
    	for (int i = 0; i < theChunks.size(); i++) {
    		Object o = (Object) theChunks.get(i);
    		buf.append(o);
    	}
    	//System.out.println("translated: "+buf.toString());
    	return buf.toString();
    }

    public List translateAction(String action) {
        ActionTranslatorLexer translator =
            new ActionTranslatorLexer(generator,
                                      enclosingRule.name,
                                      new antlr.CommonToken(ANTLRParser.ACTION,action),outerAltNum);
        return translator.translateToChunks();
    }

    public boolean isTokenRefInAlt(String id) {
        return enclosingRule.getTokenRefsInAlt(id, outerAltNum)!=null;
    }
    public boolean isRuleRefInAlt(String id) {
        return enclosingRule.getRuleRefsInAlt(id, outerAltNum)!=null;
    }
    public Grammar.LabelElementPair getElementLabel(String id) {
        return enclosingRule.getLabel(id);
    }

    public void checkElementRefUniqueness(String ref, boolean isToken) {
    		List refs = null;
    		if ( isToken ) {
    		    refs = enclosingRule.getTokenRefsInAlt(ref, outerAltNum);
    		}
    		else {
    		    refs = enclosingRule.getRuleRefsInAlt(ref, outerAltNum);
    		}
    		if ( refs!=null && refs.size()>1 ) {
    			ErrorManager.grammarError(ErrorManager.MSG_NONUNIQUE_REF,
    									  grammar,
    									  actionToken,
    									  ref);
    		}
    }

    /** For $rulelabel.name, return the Attribute found for name.  It
     *  will be a predefined property or a return value.
     */
    public Attribute getRuleLabelAttribute(String ruleName, String attrName) {
    	Rule r = grammar.getRule(ruleName);
    	AttributeScope scope = r.getLocalAttributeScope(attrName);
    	if ( scope!=null && !scope.isParameterScope ) {
    		return scope.getAttribute(attrName);
    	}
    	return null;
    }

    AttributeScope resolveDynamicScope(String scopeName) {
    	if ( grammar.getGlobalScope(scopeName)!=null ) {
    		return grammar.getGlobalScope(scopeName);
    	}
    	Rule scopeRule = grammar.getRule(scopeName);
    	if ( scopeRule!=null ) {
    		return scopeRule.ruleScope;
    	}
    	return null; // not a valid dynamic scope
    }

    protected StringTemplate template(String name) {
    	StringTemplate st = generator.getTemplates().getInstanceOf(name);
    	chunks.add(st);
    	return st;
    }



    public ActionTranslatorLexer() {;} 
    public ActionTranslatorLexer(CharStream input) {
        super(input);
        ruleMemo = new HashMap[62+1];
     }
    public String getGrammarFileName() { return "ActionTranslator.g"; }

    public Token nextToken() {
        while (true) {
            if ( input.LA(1)==CharStream.EOF ) {
                return Token.EOF_TOKEN;
            }
            token = null;
            tokenStartCharIndex = getCharIndex();
    	text = null;
            try {
                int m = input.mark();
                backtracking=1; 
                failed=false;
                mTokens();
                backtracking=0;

                if ( failed ) {
                    input.rewind(m);
                    input.consume(); 
                }
                else {
                    return token;
                }
            }
            catch (RecognitionException re) {
                // shouldn't happen in backtracking mode, but...
                reportError(re);
                recover(re);
            }
        }
    }

    public void memoize(IntStream input,
    		int ruleIndex,
    		int ruleStartIndex)
    {
    if ( backtracking>1 ) super.memoize(input, ruleIndex, ruleStartIndex);
    }

    public boolean alreadyParsedRule(IntStream input, int ruleIndex) {
    if ( backtracking>1 ) return super.alreadyParsedRule(input, ruleIndex);
    return false;
    }// $ANTLR start SET_ENCLOSING_RULE_SCOPE_ATTR
    public void mSET_ENCLOSING_RULE_SCOPE_ATTR() throws RecognitionException {
        try {
            ruleNestingLevel++;
            int _type = SET_ENCLOSING_RULE_SCOPE_ATTR;
            int _start = getCharIndex();
            int _line = getLine();
            int _charPosition = getCharPositionInLine();
            int _channel = Token.DEFAULT_CHANNEL;
            // ActionTranslator.g:201:4: ( '$' x= ID '.' y= ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';' {...}?)
            // ActionTranslator.g:201:4: '$' x= ID '.' y= ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';' {...}?
            {
            match('$'); if (failed) return ;
            int xStart = getCharIndex();
            mID(); if (failed) return ;
            Token x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart, getCharIndex()-1);
            match('.'); if (failed) return ;
            int yStart = getCharIndex();
            mID(); if (failed) return ;
            Token y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart, getCharIndex()-1);
            // ActionTranslator.g:201:22: ( WS )?
            int alt1=2;
            int LA1_0 = input.LA(1);
            if ( ((LA1_0>='\t' && LA1_0<='\n')||LA1_0==' ') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ActionTranslator.g:201:22: WS
                    {
                    mWS(); if (failed) return ;

                    }
                    break;

            }

            match('='); if (failed) return ;
            int exprStart = getCharIndex();
            mATTR_VALUE_EXPR(); if (failed) return ;
            Token expr = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, exprStart, getCharIndex()-1);
            match(';'); if (failed) return ;
            if ( !(enclosingRule!=null &&
            	                         x.getText().equals(enclosingRule.name) &&
            	                         enclosingRule.getLocalAttributeScope(y.getText())!=null) ) {
                if (backtracking>0) {failed=true; return ;}
                throw new FailedPredicateException(input, "SET_ENCLOSING_RULE_SCOPE_ATTR", "enclosingRule!=null &&\n\t                         $x.text.equals(enclosingRule.name) &&\n\t                         enclosingRule.getLocalAttributeScope($y.text)!=null");
            }
            if ( backtracking==1 ) {

              		StringTemplate st = null;
              		AttributeScope scope = enclosingRule.getLocalAttributeScope(y.getText());
              		if ( scope.isPredefinedRuleScope ) {
              			if ( y.getText().equals("st") || y.getText().equals("tree") ) {
              				st = template("ruleSetPropertyRef_"+y.getText());
              				grammar.referenceRuleLabelPredefinedAttribute(x.getText());
              				st.setAttribute("scope", x.getText());
              				st.setAttribute("attr", y.getText());
              				st.setAttribute("expr", translateAction(expr.getText()));
              			} else {
              				ErrorManager.grammarError(ErrorManager.MSG_WRITE_TO_READONLY_ATTR,
              										  grammar,
              										  actionToken,
              										  x.getText(),
              										  y.getText());
              			}
              		}
              	    else if ( scope.isPredefinedLexerRuleScope ) {
              	    	// this is a better message to emit than the previous one...
              			ErrorManager.grammarError(ErrorManager.MSG_WRITE_TO_READONLY_ATTR,
              									  grammar,
              									  actionToken,
              									  x.getText(),
              									  y.getText());
              	    }
              		else if ( scope.isParameterScope ) {
              			st = template("parameterSetAttributeRef");
              			st.setAttribute("attr", scope.getAttribute(y.getText()));
              			st.setAttribute("expr", translateAction(expr.getText()));
              		}
              		else { // must be return value
              			st = template("returnSetAttributeRef");
              			st.setAttribute("ruleDescriptor", enclosingRule);
              			st.setAttribute("attr", scope.getAttribute(y.getText()));
              			st.setAttribute("expr", translateAction(expr.getText()));
              		}
              		
            }

            }


            if ( backtracking==1 ) {

                      if ( token==null && ruleNestingLevel==1 ) {
                          emit(_type,_line,_charPosition,_channel,_start,getCharIndex()-1);
                      }

                      
            }    }
        finally {
            ruleNestingLevel--;
        }
    }
    // $ANTLR end SET_ENCLOSING_RULE_SCOPE_ATTR

    // $ANTLR start ENCLOSING_RULE_SCOPE_ATTR
    public void mENCLOSING_RULE_SCOPE_ATTR() throws RecognitionException {
        try {
            ruleNestingLevel++;
            int _type = ENCLOSING_RULE_SCOPE_ATTR;
            int _start = getCharIndex();
            int _line = getLine();
            int _charPosition = getCharPositionInLine();
            int _channel = Token.DEFAULT_CHANNEL;
            // ActionTranslator.g:246:4: ( '$' x= ID '.' y= ID {...}?)
            // ActionTranslator.g:246:4: '$' x= ID '.' y= ID {...}?
            {
            match('$'); if (failed) return ;
            int xStart = getCharIndex();
            mID(); if (failed) return ;
            Token x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart, getCharIndex()-1);
            match('.'); if (failed) return ;
            int yStart = getCharIndex();
            mID(); if (failed) return ;
            Token y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart, getCharIndex()-1);
            if ( !(enclosingRule!=null &&
            	                         x.getText().equals(enclosingRule.name) &&
            	                         enclosingRule.getLocalAttributeScope(y.getText())!=null) ) {
                if (backtracking>0) {failed=true; return ;}
                throw new FailedPredicateException(input, "ENCLOSING_RULE_SCOPE_ATTR", "enclosingRule!=null &&\n\t                         $x.text.equals(enclosingRule.name) &&\n\t                         enclosingRule.getLocalAttributeScope($y.text)!=null");
            }
            if ( backtracking==1 ) {

              		StringTemplate st = null;
              		AttributeScope scope = enclosingRule.getLocalAttributeScope(y.getText());
              		if ( scope.isPredefinedRuleScope ) {
              			st = template("rulePropertyRef_"+y.getText());
              			grammar.referenceRuleLabelPredefinedAttribute(x.getText());
              			st.setAttribute("scope", x.getText());
              			st.setAttribute("attr", y.getText());
              		}
              	    else if ( scope.isPredefinedLexerRuleScope ) {
              	    	// perhaps not the most precise error message to use, but...
              			ErrorManager.grammarError(ErrorManager.MSG_RULE_HAS_NO_ARGS,
              									  grammar,
              									  actionToken,
              									  x.getText());
              	    }
              		else if ( scope.isParameterScope ) {
              			st = template("parameterAttributeRef");
              			st.setAttribute("attr", scope.getAttribute(y.getText()));
              		}
              		else { // must be return value
              			st = template("returnAttributeRef");
              			st.setAttribute("ruleDescriptor", enclosingRule);
              			st.setAttribute("attr", scope.getAttribute(y.getText()));
              		}
              		
            }

            }


            if ( backtracking==1 ) {

                      if ( token==null && ruleNestingLevel==1 ) {
                          emit(_type,_line,_charPosition,_channel,_start,getCharIndex()-1);
                      }

                      
            }    }
        finally {
            ruleNestingLevel--;
        }
    }
    // $ANTLR end ENCLOSING_RULE_SCOPE_ATTR

    // $ANTLR start SET_TOKEN_SCOPE_ATTR
    public void mSET_TOKEN_SCOPE_ATTR() throws RecognitionException {
        try {
            ruleNestingLevel++;
            int _type = SET_TOKEN_SCOPE_ATTR;
            int _start = getCharIndex();
            int _line = getLine();
            int _charPosition = getCharPositionInLine();
            int _channel = Token.DEFAULT_CHANNEL;
            // ActionTranslator.g:280:4: ( '$' x= ID '.' y= ID ( WS )? '=' {...}?)
            // ActionTranslator.g:280:4: '$' x= ID '.' y= ID ( WS )? '=' {...}?
            {
            match('$'); if (failed) return ;
            int xStart = getCharIndex();
            mID(); if (failed) return ;
            Token x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart, getCharIndex()-1);
            match('.'); if (failed) return ;
            int yStart = getCharIndex();
            mID(); if (failed) return ;
            Token y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart, getCharIndex()-1);
            // ActionTranslator.g:280:22: ( WS )?
            int alt2=2;
            int LA2_0 = input.LA(1);
            if ( ((LA2_0>='\t' && LA2_0<='\n')||LA2_0==' ') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ActionTranslator.g:280:22: WS
                    {
                    mWS(); if (failed) return ;

                    }
                    break;

            }

            match('='); if (failed) return ;
            if ( !(enclosingRule!=null && input.LA(1)!='=' &&
            	                         (enclosingRule.getTokenLabel(x.getText())!=null||
            	                          isTokenRefInAlt(x.getText())) &&
            	                         AttributeScope.tokenScope.getAttribute(y.getText())!=null) ) {
                if (backtracking>0) {failed=true; return ;}
                throw new FailedPredicateException(input, "SET_TOKEN_SCOPE_ATTR", "enclosingRule!=null && input.LA(1)!='=' &&\n\t                         (enclosingRule.getTokenLabel($x.text)!=null||\n\t                          isTokenRefInAlt($x.text)) &&\n\t                         AttributeScope.tokenScope.getAttribute($y.text)!=null");
            }
            if ( backtracking==1 ) {

              		ErrorManager.grammarError(ErrorManager.MSG_WRITE_TO_READONLY_ATTR,
              								  grammar,
              								  actionToken,
              								  x.getText(),
              								  y.getText());
              		
            }

            }


            if ( backtracking==1 ) {

                      if ( token==null && ruleNestingLevel==1 ) {
                          emit(_type,_line,_charPosition,_channel,_start,getCharIndex()-1);
                      }

                      
            }    }
        finally {
            ruleNestingLevel--;
        }
    }
    // $ANTLR end SET_TOKEN_SCOPE_ATTR

    // $ANTLR start TOKEN_SCOPE_ATTR
    public void mTOKEN_SCOPE_ATTR() throws RecognitionException {
        try {
            ruleNestingLevel++;
            int _type = TOKEN_SCOPE_ATTR;
            int _start = getCharIndex();
            int _line = getLine();
            int _charPosition = getCharPositionInLine();
            int _channel = Token.DEFAULT_CHANNEL;
            // ActionTranslator.g:299:4: ( '$' x= ID '.' y= ID {...}?)
            // ActionTranslator.g:299:4: '$' x= ID '.' y= ID {...}?
            {
            match('$'); if (failed) return ;
            int xStart = getCharIndex();
            mID(); if (failed) return ;
            Token x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart, getCharIndex()-1);
            match('.'); if (failed) return ;
            int yStart = getCharIndex();
            mID(); if (failed) return ;
            Token y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart, getCharIndex()-1);
            if ( !(enclosingRule!=null &&
            	                         (enclosingRule.getTokenLabel(x.getText())!=null||
            	                          isTokenRefInAlt(x.getText())) &&
            	                         AttributeScope.tokenScope.getAttribute(y.getText())!=null &&
            	                         (grammar.type!=Grammar.LEXER ||
            	                         getElementLabel(x.getText()).elementRef.token.getType()==ANTLRParser.TOKEN_REF ||
            	                         getElementLabel(x.getText()).elementRef.token.getType()==ANTLRParser.STRING_LITERAL)) ) {
                if (backtracking>0) {failed=true; return ;}
                throw new FailedPredicateException(input, "TOKEN_SCOPE_ATTR", "enclosingRule!=null &&\n\t                         (enclosingRule.getTokenLabel($x.text)!=null||\n\t                          isTokenRefInAlt($x.text)) &&\n\t                         AttributeScope.tokenScope.getAttribute($y.text)!=null &&\n\t                         (grammar.type!=Grammar.LEXER ||\n\t                         getElementLabel($x.text).elementRef.token.getType()==ANTLRParser.TOKEN_REF ||\n\t                         getElementLabel($x.text).elementRef.token.getType()==ANTLRParser.STRING_LITERAL)");
            }
            if ( backtracking==1 ) {

              		String label = x.getText();
              		if ( enclosingRule.getTokenLabel(x.getText())==null ) {
              			// $tokenref.attr  gotta get old label or compute new one
              			checkElementRefUniqueness(x.getText(), true);
              			label = enclosingRule.getElementLabel(x.getText(), outerAltNum, generator);
              			if ( label==null ) {
              				ErrorManager.grammarError(ErrorManager.MSG_FORWARD_ELEMENT_REF,
              										  grammar,
              										  actionToken,
              										  "$"+x.getText()+"."+y.getText());
              				label = x.getText();
              			}
              		}
              		StringTemplate st = template("tokenLabelPropertyRef_"+y.getText());
              		st.setAttribute("scope", label);
              		st.setAttribute("attr", AttributeScope.tokenScope.getAttribute(y.getText()));
              		
            }

            }


            if ( backtracking==1 ) {

                      if ( token==null && ruleNestingLevel==1 ) {
                          emit(_type,_line,_charPosition,_channel,_start,getCharIndex()-1);
                      }

                      
            }    }
        finally {
            ruleNestingLevel--;
        }
    }
    // $ANTLR end TOKEN_SCOPE_ATTR

    // $ANTLR start SET_RULE_SCOPE_ATTR
    public void mSET_RULE_SCOPE_ATTR() throws RecognitionException {
        try {
            ruleNestingLevel++;
            int _type = SET_RULE_SCOPE_ATTR;
            int _start = getCharIndex();
            int _line = getLine();
            int _charPosition = getCharPositionInLine();
            int _channel = Token.DEFAULT_CHANNEL;

            Grammar.LabelElementPair pair=null;
            String refdRuleName=null;

            // ActionTranslator.g:337:4: ( '$' x= ID '.' y= ID ( WS )? '=' {...}?{...}?)
            // ActionTranslator.g:337:4: '$' x= ID '.' y= ID ( WS )? '=' {...}?{...}?
            {
            match('$'); if (failed) return ;
            int xStart = getCharIndex();
            mID(); if (failed) return ;
            Token x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart, getCharIndex()-1);
            match('.'); if (failed) return ;
            int yStart = getCharIndex();
            mID(); if (failed) return ;
            Token y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart, getCharIndex()-1);
            // ActionTranslator.g:337:22: ( WS )?
            int alt3=2;
            int LA3_0 = input.LA(1);
            if ( ((LA3_0>='\t' && LA3_0<='\n')||LA3_0==' ') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ActionTranslator.g:337:22: WS
                    {
                    mWS(); if (failed) return ;

                    }
                    break;

            }

            match('='); if (failed) return ;
            if ( !(enclosingRule!=null && input.LA(1)!='=') ) {
                if (backtracking>0) {failed=true; return ;}
                throw new FailedPredicateException(input, "SET_RULE_SCOPE_ATTR", "enclosingRule!=null && input.LA(1)!='='");
            }
            if ( backtracking==1 ) {

              		pair = enclosingRule.getRuleLabel(x.getText());
              		refdRuleName = x.getText();
              		if ( pair!=null ) {
              			refdRuleName = pair.referencedRuleName;
              		}
              		
            }
            if ( !((enclosingRule.getRuleLabel(x.getText())!=null || isRuleRefInAlt(x.getText())) &&
            	      getRuleLabelAttribute(enclosingRule.getRuleLabel(x.getText())!=null?enclosingRule.getRuleLabel(x.getText()).referencedRuleName:x.getText(),y.getText())!=null) ) {
                if (backtracking>0) {failed=true; return ;}
                throw new FailedPredicateException(input, "SET_RULE_SCOPE_ATTR", "(enclosingRule.getRuleLabel($x.text)!=null || isRuleRefInAlt($x.text)) &&\n\t      getRuleLabelAttribute(enclosingRule.getRuleLabel($x.text)!=null?enclosingRule.getRuleLabel($x.text).referencedRuleName:$x.text,$y.text)!=null");
            }
            if ( backtracking==1 ) {

              		ErrorManager.grammarError(ErrorManager.MSG_WRITE_TO_READONLY_ATTR,
              								  grammar,
              								  actionToken,
              								  x.getText(),
              								  y.getText());
              		
            }

            }


            if ( backtracking==1 ) {

                      if ( token==null && ruleNestingLevel==1 ) {
                          emit(_type,_line,_charPosition,_channel,_start,getCharIndex()-1);
                      }

                      
            }    }
        finally {
            ruleNestingLevel--;
        }
    }
    // $ANTLR end SET_RULE_SCOPE_ATTR

    // $ANTLR start RULE_SCOPE_ATTR
    public void mRULE_SCOPE_ATTR() throws RecognitionException {
        try {
            ruleNestingLevel++;
            int _type = RULE_SCOPE_ATTR;
            int _start = getCharIndex();
            int _line = getLine();
            int _charPosition = getCharPositionInLine();
            int _channel = Token.DEFAULT_CHANNEL;

            Grammar.LabelElementPair pair=null;
            String refdRuleName=null;

            // ActionTranslator.g:366:4: ( '$' x= ID '.' y= ID {...}?{...}?)
            // ActionTranslator.g:366:4: '$' x= ID '.' y= ID {...}?{...}?
            {
            match('$'); if (failed) return ;
            int xStart = getCharIndex();
            mID(); if (failed) return ;
            Token x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart, getCharIndex()-1);
            match('.'); if (failed) return ;
            int yStart = getCharIndex();
            mID(); if (failed) return ;
            Token y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart, getCharIndex()-1);
            if ( !(enclosingRule!=null) ) {
                if (backtracking>0) {failed=true; return ;}
                throw new FailedPredicateException(input, "RULE_SCOPE_ATTR", "enclosingRule!=null");
            }
            if ( backtracking==1 ) {

              		pair = enclosingRule.getRuleLabel(x.getText());
              		refdRuleName = x.getText();
              		if ( pair!=null ) {
              			refdRuleName = pair.referencedRuleName;
              		}
              		
            }
            if ( !((enclosingRule.getRuleLabel(x.getText())!=null || isRuleRefInAlt(x.getText())) &&
            	      getRuleLabelAttribute(enclosingRule.getRuleLabel(x.getText())!=null?enclosingRule.getRuleLabel(x.getText()).referencedRuleName:x.getText(),y.getText())!=null) ) {
                if (backtracking>0) {failed=true; return ;}
                throw new FailedPredicateException(input, "RULE_SCOPE_ATTR", "(enclosingRule.getRuleLabel($x.text)!=null || isRuleRefInAlt($x.text)) &&\n\t      getRuleLabelAttribute(enclosingRule.getRuleLabel($x.text)!=null?enclosingRule.getRuleLabel($x.text).referencedRuleName:$x.text,$y.text)!=null");
            }
            if ( backtracking==1 ) {

              		String label = x.getText();
              		if ( pair==null ) {
              			// $ruleref.attr  gotta get old label or compute new one
              			checkElementRefUniqueness(x.getText(), false);
              			label = enclosingRule.getElementLabel(x.getText(), outerAltNum, generator);
              			if ( label==null ) {
              				ErrorManager.grammarError(ErrorManager.MSG_FORWARD_ELEMENT_REF,
              										  grammar,
              										  actionToken,
              										  "$"+x.getText()+"."+y.getText());
              				label = x.getText();
              			}
              		}
              		StringTemplate st;
              		Rule refdRule = grammar.getRule(refdRuleName);
              		AttributeScope scope = refdRule.getLocalAttributeScope(y.getText());
              		if ( scope.isPredefinedRuleScope ) {
              			st = template("ruleLabelPropertyRef_"+y.getText());
              			grammar.referenceRuleLabelPredefinedAttribute(refdRuleName);
              			st.setAttribute("scope", label);
              			st.setAttribute("attr", y.getText());
              		}
              		else if ( scope.isPredefinedLexerRuleScope ) {
              			st = template("lexerRuleLabelPropertyRef_"+y.getText());
              			grammar.referenceRuleLabelPredefinedAttribute(refdRuleName);
              			st.setAttribute("scope", label);
              			st.setAttribute("attr", y.getText());
              		}
              		else if ( scope.isParameterScope ) {
              			// TODO: error!
					  }
              		else {
              			st = template("ruleLabelRef");
              			st.setAttribute("referencedRule", refdRule);
              			st.setAttribute("scope", label);
              			st.setAttribute("attr", scope.getAttribute(y.getText()));
              		}
              		
            }

            }


            if ( backtracking==1 ) {

                      if ( token==null && ruleNestingLevel==1 ) {
                          emit(_type,_line,_charPosition,_channel,_start,getCharIndex()-1);
                      }

                      
            }    }
        finally {
            ruleNestingLevel--;
        }
    }
    // $ANTLR end RULE_SCOPE_ATTR

    // $ANTLR start LABEL_REF
    public void mLABEL_REF() throws RecognitionException {
        try {
            ruleNestingLevel++;
            int _type = LABEL_REF;
            int _start = getCharIndex();
            int _line = getLine();
            int _charPosition = getCharPositionInLine();
            int _channel = Token.DEFAULT_CHANNEL;
            // ActionTranslator.g:424:4: ( '$' ID {...}?)
            // ActionTranslator.g:424:4: '$' ID {...}?
            {
            match('$'); if (failed) return ;
            int ID1Start = getCharIndex();
            mID(); if (failed) return ;
            Token ID1 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, ID1Start, getCharIndex()-1);
            if ( !(enclosingRule!=null &&
            	            getElementLabel(ID1.getText())!=null &&
            		        enclosingRule.getRuleLabel(ID1.getText())==null) ) {
                if (backtracking>0) {failed=true; return ;}
                throw new FailedPredicateException(input, "LABEL_REF", "enclosingRule!=null &&\n\t            getElementLabel($ID.text)!=null &&\n\t\t        enclosingRule.getRuleLabel($ID.text)==null");
            }
            if ( backtracking==1 ) {

              		StringTemplate st;
              		Grammar.LabelElementPair pair = getElementLabel(ID1.getText());
              		if ( pair.type==Grammar.TOKEN_LABEL ||
             			 pair.type==Grammar.CHAR_LABEL )
					{
              			st = template("tokenLabelRef");
              		}
              		else {
              			st = template("listLabelRef");
              		}
              		st.setAttribute("label", ID1.getText());
              		
            }

            }


            if ( backtracking==1 ) {

                      if ( token==null && ruleNestingLevel==1 ) {
                          emit(_type,_line,_charPosition,_channel,_start,getCharIndex()-1);
                      }

                      
            }    }
        finally {
            ruleNestingLevel--;
        }
    }
    // $ANTLR end LABEL_REF

    // $ANTLR start ISOLATED_TOKEN_REF
    public void mISOLATED_TOKEN_REF() throws RecognitionException {
        try {
            ruleNestingLevel++;
            int _type = ISOLATED_TOKEN_REF;
            int _start = getCharIndex();
            int _line = getLine();
            int _charPosition = getCharPositionInLine();
            int _channel = Token.DEFAULT_CHANNEL;
            // ActionTranslator.g:443:4: ( '$' ID {...}?)
            // ActionTranslator.g:443:4: '$' ID {...}?
            {
            match('$'); if (failed) return ;
            int ID2Start = getCharIndex();
            mID(); if (failed) return ;
            Token ID2 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, ID2Start, getCharIndex()-1);
            if ( !(grammar.type!=Grammar.LEXER && enclosingRule!=null && isTokenRefInAlt(ID2.getText())) ) {
                if (backtracking>0) {failed=true; return ;}
                throw new FailedPredicateException(input, "ISOLATED_TOKEN_REF", "grammar.type!=Grammar.LEXER && enclosingRule!=null && isTokenRefInAlt($ID.text)");
            }
            if ( backtracking==1 ) {

              		String label = enclosingRule.getElementLabel(ID2.getText(), outerAltNum, generator);
              		checkElementRefUniqueness(ID2.getText(), true);
              		if ( label==null ) {
              			ErrorManager.grammarError(ErrorManager.MSG_FORWARD_ELEMENT_REF,
              									  grammar,
              									  actionToken,
              									  ID2.getText());
              		}
              		else {
              			StringTemplate st = template("tokenLabelRef");
              			st.setAttribute("label", label);
              		}
              		
            }

            }


            if ( backtracking==1 ) {

                      if ( token==null && ruleNestingLevel==1 ) {
                          emit(_type,_line,_charPosition,_channel,_start,getCharIndex()-1);
                      }

                      
            }    }
        finally {
            ruleNestingLevel--;
        }
    }
    // $ANTLR end ISOLATED_TOKEN_REF

    // $ANTLR start ISOLATED_LEXER_RULE_REF
    public void mISOLATED_LEXER_RULE_REF() throws RecognitionException {
        try {
            ruleNestingLevel++;
            int _type = ISOLATED_LEXER_RULE_REF;
            int _start = getCharIndex();
            int _line = getLine();
            int _charPosition = getCharPositionInLine();
            int _channel = Token.DEFAULT_CHANNEL;
            // ActionTranslator.g:463:4: ( '$' ID {...}?)
            // ActionTranslator.g:463:4: '$' ID {...}?
            {
            match('$'); if (failed) return ;
            int ID3Start = getCharIndex();
            mID(); if (failed) return ;
            Token ID3 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, ID3Start, getCharIndex()-1);
            if ( !(grammar.type==Grammar.LEXER &&
            	             enclosingRule!=null &&
            	             isRuleRefInAlt(ID3.getText())) ) {
                if (backtracking>0) {failed=true; return ;}
                throw new FailedPredicateException(input, "ISOLATED_LEXER_RULE_REF", "grammar.type==Grammar.LEXER &&\n\t             enclosingRule!=null &&\n\t             isRuleRefInAlt($ID.text)");
            }
            if ( backtracking==1 ) {

              		String label = enclosingRule.getElementLabel(ID3.getText(), outerAltNum, generator);
              		checkElementRefUniqueness(ID3.getText(), false);
              		if ( label==null ) {
              			ErrorManager.grammarError(ErrorManager.MSG_FORWARD_ELEMENT_REF,
              									  grammar,
              									  actionToken,
              									  ID3.getText());
              		}
              		else {
              			StringTemplate st = template("lexerRuleLabel");
              			st.setAttribute("label", label);
              		}
              		
            }

            }


            if ( backtracking==1 ) {

                      if ( token==null && ruleNestingLevel==1 ) {
                          emit(_type,_line,_charPosition,_channel,_start,getCharIndex()-1);
                      }

                      
            }    }
        finally {
            ruleNestingLevel--;
        }
    }
    // $ANTLR end ISOLATED_LEXER_RULE_REF

    // $ANTLR start SET_LOCAL_ATTR
    public void mSET_LOCAL_ATTR() throws RecognitionException {
        try {
            ruleNestingLevel++;
            int _type = SET_LOCAL_ATTR;
            int _start = getCharIndex();
            int _line = getLine();
            int _charPosition = getCharPositionInLine();
            int _channel = Token.DEFAULT_CHANNEL;
            // ActionTranslator.g:495:4: ( '$' ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';' {...}?)
            // ActionTranslator.g:495:4: '$' ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';' {...}?
            {
            match('$'); if (failed) return ;
            int ID4Start = getCharIndex();
            mID(); if (failed) return ;
            Token ID4 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, ID4Start, getCharIndex()-1);
            // ActionTranslator.g:495:11: ( WS )?
            int alt4=2;
            int LA4_0 = input.LA(1);
            if ( ((LA4_0>='\t' && LA4_0<='\n')||LA4_0==' ') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ActionTranslator.g:495:11: WS
                    {
                    mWS(); if (failed) return ;

                    }
                    break;

            }

            match('='); if (failed) return ;
            int exprStart = getCharIndex();
            mATTR_VALUE_EXPR(); if (failed) return ;
            Token expr = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, exprStart, getCharIndex()-1);
            match(';'); if (failed) return ;
            if ( !(enclosingRule!=null
            													&& enclosingRule.getLocalAttributeScope(ID4.getText())!=null
            													&& !enclosingRule.getLocalAttributeScope(ID4.getText()).isPredefinedLexerRuleScope) ) {
                if (backtracking>0) {failed=true; return ;}
                throw new FailedPredicateException(input, "SET_LOCAL_ATTR", "enclosingRule!=null\n\t\t\t\t\t\t\t\t\t\t\t\t\t&& enclosingRule.getLocalAttributeScope($ID.text)!=null\n\t\t\t\t\t\t\t\t\t\t\t\t\t&& !enclosingRule.getLocalAttributeScope($ID.text).isPredefinedLexerRuleScope");
            }
            if ( backtracking==1 ) {

              		StringTemplate st;
              		AttributeScope scope = enclosingRule.getLocalAttributeScope(ID4.getText());
              		if ( scope.isPredefinedRuleScope ) {
              			if (ID4.getText().equals("tree") || ID4.getText().equals("st")) {
              				st = template("ruleSetPropertyRef_"+ID4.getText());
              				grammar.referenceRuleLabelPredefinedAttribute(enclosingRule.name);
              				st.setAttribute("scope", enclosingRule.name);
              				st.setAttribute("attr", ID4.getText());
              				st.setAttribute("expr", translateAction(expr.getText()));
              			} else {
              				ErrorManager.grammarError(ErrorManager.MSG_WRITE_TO_READONLY_ATTR,
              										 grammar,
              										 actionToken,
              										 ID4.getText(),
              										 "");
              			}
              		}
              		else if ( scope.isParameterScope ) {
              			st = template("parameterSetAttributeRef");
              			st.setAttribute("attr", scope.getAttribute(ID4.getText()));
              			st.setAttribute("expr", translateAction(expr.getText()));
              		}
              		else {
              			st = template("returnSetAttributeRef");
              			st.setAttribute("ruleDescriptor", enclosingRule);
              			st.setAttribute("attr", scope.getAttribute(ID4.getText()));
              			st.setAttribute("expr", translateAction(expr.getText()));
              			}
              		
            }

            }


            if ( backtracking==1 ) {

                      if ( token==null && ruleNestingLevel==1 ) {
                          emit(_type,_line,_charPosition,_channel,_start,getCharIndex()-1);
                      }

                      
            }    }
        finally {
            ruleNestingLevel--;
        }
    }
    // $ANTLR end SET_LOCAL_ATTR

    // $ANTLR start LOCAL_ATTR
    public void mLOCAL_ATTR() throws RecognitionException {
        try {
            ruleNestingLevel++;
            int _type = LOCAL_ATTR;
            int _start = getCharIndex();
            int _line = getLine();
            int _charPosition = getCharPositionInLine();
            int _channel = Token.DEFAULT_CHANNEL;
            // ActionTranslator.g:531:4: ( '$' ID {...}?)
            // ActionTranslator.g:531:4: '$' ID {...}?
            {
            match('$'); if (failed) return ;
            int ID5Start = getCharIndex();
            mID(); if (failed) return ;
            Token ID5 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, ID5Start, getCharIndex()-1);
            if ( !(enclosingRule!=null && enclosingRule.getLocalAttributeScope(ID5.getText())!=null) ) {
                if (backtracking>0) {failed=true; return ;}
                throw new FailedPredicateException(input, "LOCAL_ATTR", "enclosingRule!=null && enclosingRule.getLocalAttributeScope($ID.text)!=null");
            }
            if ( backtracking==1 ) {

              		StringTemplate st;
              		AttributeScope scope = enclosingRule.getLocalAttributeScope(ID5.getText());
              		if ( scope.isPredefinedRuleScope ) {
              			st = template("rulePropertyRef_"+ID5.getText());
              			grammar.referenceRuleLabelPredefinedAttribute(enclosingRule.name);
              			st.setAttribute("scope", enclosingRule.name);
              			st.setAttribute("attr", ID5.getText());
              		}
              		else if ( scope.isPredefinedLexerRuleScope ) {
              			st = template("lexerRulePropertyRef_"+ID5.getText());
              			st.setAttribute("scope", enclosingRule.name);
              			st.setAttribute("attr", ID5.getText());
              		}
              		else if ( scope.isParameterScope ) {
              			st = template("parameterAttributeRef");
              			st.setAttribute("attr", scope.getAttribute(ID5.getText()));
              		}
              		else {
              			st = template("returnAttributeRef");
              			st.setAttribute("ruleDescriptor", enclosingRule);
              			st.setAttribute("attr", scope.getAttribute(ID5.getText()));
              		}
              		
            }

            }


            if ( backtracking==1 ) {

                      if ( token==null && ruleNestingLevel==1 ) {
                          emit(_type,_line,_charPosition,_channel,_start,getCharIndex()-1);
                      }

                      
            }    }
        finally {
            ruleNestingLevel--;
        }
    }
    // $ANTLR end LOCAL_ATTR

    // $ANTLR start SET_DYNAMIC_SCOPE_ATTR
    public void mSET_DYNAMIC_SCOPE_ATTR() throws RecognitionException {
        try {
            ruleNestingLevel++;
            int _type = SET_DYNAMIC_SCOPE_ATTR;
            int _start = getCharIndex();
            int _line = getLine();
            int _charPosition = getCharPositionInLine();
            int _channel = Token.DEFAULT_CHANNEL;
            // ActionTranslator.g:572:4: ( '$' x= ID '::' y= ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';' {...}?)
            // ActionTranslator.g:572:4: '$' x= ID '::' y= ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';' {...}?
            {
            match('$'); if (failed) return ;
            int xStart = getCharIndex();
            mID(); if (failed) return ;
            Token x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart, getCharIndex()-1);
            match("::"); if (failed) return ;

            int yStart = getCharIndex();
            mID(); if (failed) return ;
            Token y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart, getCharIndex()-1);
            // ActionTranslator.g:572:23: ( WS )?
            int alt5=2;
            int LA5_0 = input.LA(1);
            if ( ((LA5_0>='\t' && LA5_0<='\n')||LA5_0==' ') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ActionTranslator.g:572:23: WS
                    {
                    mWS(); if (failed) return ;

                    }
                    break;

            }

            match('='); if (failed) return ;
            int exprStart = getCharIndex();
            mATTR_VALUE_EXPR(); if (failed) return ;
            Token expr = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, exprStart, getCharIndex()-1);
            match(';'); if (failed) return ;
            if ( !(resolveDynamicScope(x.getText())!=null &&
            						     resolveDynamicScope(x.getText()).getAttribute(y.getText())!=null) ) {
                if (backtracking>0) {failed=true; return ;}
                throw new FailedPredicateException(input, "SET_DYNAMIC_SCOPE_ATTR", "resolveDynamicScope($x.text)!=null &&\n\t\t\t\t\t\t     resolveDynamicScope($x.text).getAttribute($y.text)!=null");
            }
            if ( backtracking==1 ) {

              		AttributeScope scope = resolveDynamicScope(x.getText());
              		if ( scope!=null ) {
              			StringTemplate st = template("scopeSetAttributeRef");
              			st.setAttribute("scope", x.getText());
              			st.setAttribute("attr",  scope.getAttribute(y.getText()));
              			st.setAttribute("expr",  translateAction(expr.getText()));
              		}
              		else {
              			// error: invalid dynamic attribute
              		}
              		
            }

            }


            if ( backtracking==1 ) {

                      if ( token==null && ruleNestingLevel==1 ) {
                          emit(_type,_line,_charPosition,_channel,_start,getCharIndex()-1);
                      }

                      
            }    }
        finally {
            ruleNestingLevel--;
        }
    }
    // $ANTLR end SET_DYNAMIC_SCOPE_ATTR

    // $ANTLR start DYNAMIC_SCOPE_ATTR
    public void mDYNAMIC_SCOPE_ATTR() throws RecognitionException {
        try {
            ruleNestingLevel++;
            int _type = DYNAMIC_SCOPE_ATTR;
            int _start = getCharIndex();
            int _line = getLine();
            int _charPosition = getCharPositionInLine();
            int _channel = Token.DEFAULT_CHANNEL;
            // ActionTranslator.g:591:4: ( '$' x= ID '::' y= ID {...}?)
            // ActionTranslator.g:591:4: '$' x= ID '::' y= ID {...}?
            {
            match('$'); if (failed) return ;
            int xStart = getCharIndex();
            mID(); if (failed) return ;
            Token x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart, getCharIndex()-1);
            match("::"); if (failed) return ;

            int yStart = getCharIndex();
            mID(); if (failed) return ;
            Token y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart, getCharIndex()-1);
            if ( !(resolveDynamicScope(x.getText())!=null &&
            						     resolveDynamicScope(x.getText()).getAttribute(y.getText())!=null) ) {
                if (backtracking>0) {failed=true; return ;}
                throw new FailedPredicateException(input, "DYNAMIC_SCOPE_ATTR", "resolveDynamicScope($x.text)!=null &&\n\t\t\t\t\t\t     resolveDynamicScope($x.text).getAttribute($y.text)!=null");
            }
            if ( backtracking==1 ) {

              		AttributeScope scope = resolveDynamicScope(x.getText());
              		if ( scope!=null ) {
              			StringTemplate st = template("scopeAttributeRef");
              			st.setAttribute("scope", x.getText());
              			st.setAttribute("attr",  scope.getAttribute(y.getText()));
              		}
              		else {
              			// error: invalid dynamic attribute
              		}
              		
            }

            }


            if ( backtracking==1 ) {

                      if ( token==null && ruleNestingLevel==1 ) {
                          emit(_type,_line,_charPosition,_channel,_start,getCharIndex()-1);
                      }

                      
            }    }
        finally {
            ruleNestingLevel--;
        }
    }
    // $ANTLR end DYNAMIC_SCOPE_ATTR

    // $ANTLR start ERROR_SCOPED_XY
    public void mERROR_SCOPED_XY() throws RecognitionException {
        try {
            ruleNestingLevel++;
            int _type = ERROR_SCOPED_XY;
            int _start = getCharIndex();
            int _line = getLine();
            int _charPosition = getCharPositionInLine();
            int _channel = Token.DEFAULT_CHANNEL;
            // ActionTranslator.g:610:4: ( '$' x= ID '::' y= ID )
            // ActionTranslator.g:610:4: '$' x= ID '::' y= ID
            {
            match('$'); if (failed) return ;
            int xStart = getCharIndex();
            mID(); if (failed) return ;
            Token x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart, getCharIndex()-1);
            match("::"); if (failed) return ;

            int yStart = getCharIndex();
            mID(); if (failed) return ;
            Token y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart, getCharIndex()-1);
            if ( backtracking==1 ) {

              		chunks.add(getText());
              		generator.issueInvalidScopeError(x.getText(),y.getText(),
              		                                 enclosingRule,actionToken,
              		                                 outerAltNum);		
              		
            }

            }


            if ( backtracking==1 ) {

                      if ( token==null && ruleNestingLevel==1 ) {
                          emit(_type,_line,_charPosition,_channel,_start,getCharIndex()-1);
                      }

                      
            }    }
        finally {
            ruleNestingLevel--;
        }
    }
    // $ANTLR end ERROR_SCOPED_XY

    // $ANTLR start DYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR
    public void mDYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR() throws RecognitionException {
        try {
            ruleNestingLevel++;
            int _type = DYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR;
            int _start = getCharIndex();
            int _line = getLine();
            int _charPosition = getCharPositionInLine();
            int _channel = Token.DEFAULT_CHANNEL;
            // ActionTranslator.g:628:4: ( '$' x= ID '[' '-' expr= SCOPE_INDEX_EXPR ']' '::' y= ID )
            // ActionTranslator.g:628:4: '$' x= ID '[' '-' expr= SCOPE_INDEX_EXPR ']' '::' y= ID
            {
            match('$'); if (failed) return ;
            int xStart = getCharIndex();
            mID(); if (failed) return ;
            Token x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart, getCharIndex()-1);
            match('['); if (failed) return ;
            match('-'); if (failed) return ;
            int exprStart = getCharIndex();
            mSCOPE_INDEX_EXPR(); if (failed) return ;
            Token expr = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, exprStart, getCharIndex()-1);
            match(']'); if (failed) return ;
            match("::"); if (failed) return ;

            int yStart = getCharIndex();
            mID(); if (failed) return ;
            Token y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart, getCharIndex()-1);
            if ( backtracking==1 ) {

              		StringTemplate st = template("scopeAttributeRef");
              		st.setAttribute("scope",    x.getText());
              		st.setAttribute("attr",     resolveDynamicScope(x.getText()).getAttribute(y.getText()));
              		st.setAttribute("negIndex", expr.getText());
              		
            }

            }


            if ( backtracking==1 ) {

                      if ( token==null && ruleNestingLevel==1 ) {
                          emit(_type,_line,_charPosition,_channel,_start,getCharIndex()-1);
                      }

                      
            }    }
        finally {
            ruleNestingLevel--;
        }
    }
    // $ANTLR end DYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR

    // $ANTLR start DYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR
    public void mDYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR() throws RecognitionException {
        try {
            ruleNestingLevel++;
            int _type = DYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR;
            int _start = getCharIndex();
            int _line = getLine();
            int _charPosition = getCharPositionInLine();
            int _channel = Token.DEFAULT_CHANNEL;
            // ActionTranslator.g:639:4: ( '$' x= ID '[' expr= SCOPE_INDEX_EXPR ']' '::' y= ID )
            // ActionTranslator.g:639:4: '$' x= ID '[' expr= SCOPE_INDEX_EXPR ']' '::' y= ID
            {
            match('$'); if (failed) return ;
            int xStart = getCharIndex();
            mID(); if (failed) return ;
            Token x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart, getCharIndex()-1);
            match('['); if (failed) return ;
            int exprStart = getCharIndex();
            mSCOPE_INDEX_EXPR(); if (failed) return ;
            Token expr = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, exprStart, getCharIndex()-1);
            match(']'); if (failed) return ;
            match("::"); if (failed) return ;

            int yStart = getCharIndex();
            mID(); if (failed) return ;
            Token y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart, getCharIndex()-1);
            if ( backtracking==1 ) {

              		StringTemplate st = template("scopeAttributeRef");
              		st.setAttribute("scope", x.getText());
              		st.setAttribute("attr",  resolveDynamicScope(x.getText()).getAttribute(y.getText()));
              		st.setAttribute("index", expr.getText());
              		
            }

            }


            if ( backtracking==1 ) {

                      if ( token==null && ruleNestingLevel==1 ) {
                          emit(_type,_line,_charPosition,_channel,_start,getCharIndex()-1);
                      }

                      
            }    }
        finally {
            ruleNestingLevel--;
        }
    }
    // $ANTLR end DYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR

    // $ANTLR start SCOPE_INDEX_EXPR
    public void mSCOPE_INDEX_EXPR() throws RecognitionException {
        try {
            ruleNestingLevel++;
            // ActionTranslator.g:651:4: ( (~ ']' )+ )
            // ActionTranslator.g:651:4: (~ ']' )+
            {
            // ActionTranslator.g:651:4: (~ ']' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);
                if ( ((LA6_0>='\u0000' && LA6_0<='\\')||(LA6_0>='^' && LA6_0<='\uFFFE')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ActionTranslator.g:651:5: ~ ']'
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\\')||(input.LA(1)>='^' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();
            	    failed=false;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return ;}
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
            	    if (backtracking>0) {failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

        }
        finally {
            ruleNestingLevel--;
        }
    }
    // $ANTLR end SCOPE_INDEX_EXPR

    // $ANTLR start ISOLATED_DYNAMIC_SCOPE
    public void mISOLATED_DYNAMIC_SCOPE() throws RecognitionException {
        try {
            ruleNestingLevel++;
            int _type = ISOLATED_DYNAMIC_SCOPE;
            int _start = getCharIndex();
            int _line = getLine();
            int _charPosition = getCharPositionInLine();
            int _channel = Token.DEFAULT_CHANNEL;
            // ActionTranslator.g:660:4: ( '$' ID {...}?)
            // ActionTranslator.g:660:4: '$' ID {...}?
            {
            match('$'); if (failed) return ;
            int ID6Start = getCharIndex();
            mID(); if (failed) return ;
            Token ID6 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, ID6Start, getCharIndex()-1);
            if ( !(resolveDynamicScope(ID6.getText())!=null) ) {
                if (backtracking>0) {failed=true; return ;}
                throw new FailedPredicateException(input, "ISOLATED_DYNAMIC_SCOPE", "resolveDynamicScope($ID.text)!=null");
            }
            if ( backtracking==1 ) {

              		StringTemplate st = template("isolatedDynamicScopeRef");
              		st.setAttribute("scope", ID6.getText());
              		
            }

            }


            if ( backtracking==1 ) {

                      if ( token==null && ruleNestingLevel==1 ) {
                          emit(_type,_line,_charPosition,_channel,_start,getCharIndex()-1);
                      }

                      
            }    }
        finally {
            ruleNestingLevel--;
        }
    }
    // $ANTLR end ISOLATED_DYNAMIC_SCOPE

    // $ANTLR start TEMPLATE_INSTANCE
    public void mTEMPLATE_INSTANCE() throws RecognitionException {
        try {
            ruleNestingLevel++;
            int _type = TEMPLATE_INSTANCE;
            int _start = getCharIndex();
            int _line = getLine();
            int _charPosition = getCharPositionInLine();
            int _channel = Token.DEFAULT_CHANNEL;
            // ActionTranslator.g:673:4: ( '%' ID '(' ( ( WS )? ARG ( ',' ( WS )? ARG )* ( WS )? )? ')' )
            // ActionTranslator.g:673:4: '%' ID '(' ( ( WS )? ARG ( ',' ( WS )? ARG )* ( WS )? )? ')'
            {
            match('%'); if (failed) return ;
            mID(); if (failed) return ;
            match('('); if (failed) return ;
            // ActionTranslator.g:673:15: ( ( WS )? ARG ( ',' ( WS )? ARG )* ( WS )? )?
            int alt11=2;
            int LA11_0 = input.LA(1);
            if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0==' '||(LA11_0>='A' && LA11_0<='Z')||LA11_0=='_'||(LA11_0>='a' && LA11_0<='z')) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ActionTranslator.g:673:17: ( WS )? ARG ( ',' ( WS )? ARG )* ( WS )?
                    {
                    // ActionTranslator.g:673:17: ( WS )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);
                    if ( ((LA7_0>='\t' && LA7_0<='\n')||LA7_0==' ') ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // ActionTranslator.g:673:17: WS
                            {
                            mWS(); if (failed) return ;

                            }
                            break;

                    }

                    mARG(); if (failed) return ;
                    // ActionTranslator.g:673:25: ( ',' ( WS )? ARG )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);
                        if ( (LA9_0==',') ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ActionTranslator.g:673:26: ',' ( WS )? ARG
                    	    {
                    	    match(','); if (failed) return ;
                    	    // ActionTranslator.g:673:30: ( WS )?
                    	    int alt8=2;
                    	    int LA8_0 = input.LA(1);
                    	    if ( ((LA8_0>='\t' && LA8_0<='\n')||LA8_0==' ') ) {
                    	        alt8=1;
                    	    }
                    	    switch (alt8) {
                    	        case 1 :
                    	            // ActionTranslator.g:673:30: WS
                    	            {
                    	            mWS(); if (failed) return ;

                    	            }
                    	            break;

                    	    }

                    	    mARG(); if (failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    // ActionTranslator.g:673:40: ( WS )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);
                    if ( ((LA10_0>='\t' && LA10_0<='\n')||LA10_0==' ') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ActionTranslator.g:673:40: WS
                            {
                            mWS(); if (failed) return ;

                            }
                            break;

                    }


                    }
                    break;

            }

            match(')'); if (failed) return ;
            if ( backtracking==1 ) {

              		String action = getText().substring(1,getText().length());
              		String ruleName = "<outside-of-rule>";
              		if ( enclosingRule!=null ) {
              			ruleName = enclosingRule.name;
              		}
              		StringTemplate st =
              			generator.translateTemplateConstructor(ruleName,
              												   outerAltNum,
              												   actionToken,
              												   action);
              		if ( st!=null ) {
              			chunks.add(st);
              		}
              		
            }

            }


            if ( backtracking==1 ) {

                      if ( token==null && ruleNestingLevel==1 ) {
                          emit(_type,_line,_charPosition,_channel,_start,getCharIndex()-1);
                      }

                      
            }    }
        finally {
            ruleNestingLevel--;
        }
    }
    // $ANTLR end TEMPLATE_INSTANCE

    // $ANTLR start INDIRECT_TEMPLATE_INSTANCE
    public void mINDIRECT_TEMPLATE_INSTANCE() throws RecognitionException {
        try {
            ruleNestingLevel++;
            int _type = INDIRECT_TEMPLATE_INSTANCE;
            int _start = getCharIndex();
            int _line = getLine();
            int _charPosition = getCharPositionInLine();
            int _channel = Token.DEFAULT_CHANNEL;
            // ActionTranslator.g:694:4: ( '%' '(' ACTION ')' '(' ( ( WS )? ARG ( ',' ( WS )? ARG )* ( WS )? )? ')' )
            // ActionTranslator.g:694:4: '%' '(' ACTION ')' '(' ( ( WS )? ARG ( ',' ( WS )? ARG )* ( WS )? )? ')'
            {
            match('%'); if (failed) return ;
            match('('); if (failed) return ;
            mACTION(); if (failed) return ;
            match(')'); if (failed) return ;
            match('('); if (failed) return ;
            // ActionTranslator.g:694:27: ( ( WS )? ARG ( ',' ( WS )? ARG )* ( WS )? )?
            int alt16=2;
            int LA16_0 = input.LA(1);
            if ( ((LA16_0>='\t' && LA16_0<='\n')||LA16_0==' '||(LA16_0>='A' && LA16_0<='Z')||LA16_0=='_'||(LA16_0>='a' && LA16_0<='z')) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ActionTranslator.g:694:29: ( WS )? ARG ( ',' ( WS )? ARG )* ( WS )?
                    {
                    // ActionTranslator.g:694:29: ( WS )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);
                    if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0==' ') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // ActionTranslator.g:694:29: WS
                            {
                            mWS(); if (failed) return ;

                            }
                            break;

                    }

                    mARG(); if (failed) return ;
                    // ActionTranslator.g:694:37: ( ',' ( WS )? ARG )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);
                        if ( (LA14_0==',') ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ActionTranslator.g:694:38: ',' ( WS )? ARG
                    	    {
                    	    match(','); if (failed) return ;
                    	    // ActionTranslator.g:694:42: ( WS )?
                    	    int alt13=2;
                    	    int LA13_0 = input.LA(1);
                    	    if ( ((LA13_0>='\t' && LA13_0<='\n')||LA13_0==' ') ) {
                    	        alt13=1;
                    	    }
                    	    switch (alt13) {
                    	        case 1 :
                    	            // ActionTranslator.g:694:42: WS
                    	            {
                    	            mWS(); if (failed) return ;

                    	            }
                    	            break;

                    	    }

                    	    mARG(); if (failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    // ActionTranslator.g:694:52: ( WS )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);
                    if ( ((LA15_0>='\t' && LA15_0<='\n')||LA15_0==' ') ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // ActionTranslator.g:694:52: WS
                            {
                            mWS(); if (failed) return ;

                            }
                            break;

                    }


                    }
                    break;

            }

            match(')'); if (failed) return ;
            if ( backtracking==1 ) {

              		String action = getText().substring(1,getText().length());
              		StringTemplate st =
              			generator.translateTemplateConstructor(enclosingRule.name,
              												   outerAltNum,
              												   actionToken,
              												   action);
              		chunks.add(st);
              		
            }

            }


            if ( backtracking==1 ) {

                      if ( token==null && ruleNestingLevel==1 ) {
                          emit(_type,_line,_charPosition,_channel,_start,getCharIndex()-1);
                      }

                      
            }    }
        finally {
            ruleNestingLevel--;
        }
    }
    // $ANTLR end INDIRECT_TEMPLATE_INSTANCE

    // $ANTLR start ARG
    public void mARG() throws RecognitionException {
        try {
            ruleNestingLevel++;
            // ActionTranslator.g:708:7: ( ID '=' ACTION )
            // ActionTranslator.g:708:7: ID '=' ACTION
            {
            mID(); if (failed) return ;
            match('='); if (failed) return ;
            mACTION(); if (failed) return ;

            }

        }
        finally {
            ruleNestingLevel--;
        }
    }
    // $ANTLR end ARG

    // $ANTLR start SET_EXPR_ATTRIBUTE
    public void mSET_EXPR_ATTRIBUTE() throws RecognitionException {
        try {
            ruleNestingLevel++;
            int _type = SET_EXPR_ATTRIBUTE;
            int _start = getCharIndex();
            int _line = getLine();
            int _charPosition = getCharPositionInLine();
            int _channel = Token.DEFAULT_CHANNEL;
            // ActionTranslator.g:713:4: ( '%' a= ACTION '.' ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';' )
            // ActionTranslator.g:713:4: '%' a= ACTION '.' ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';'
            {
            match('%'); if (failed) return ;
            int aStart = getCharIndex();
            mACTION(); if (failed) return ;
            Token a = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, aStart, getCharIndex()-1);
            match('.'); if (failed) return ;
            int ID7Start = getCharIndex();
            mID(); if (failed) return ;
            Token ID7 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, ID7Start, getCharIndex()-1);
            // ActionTranslator.g:713:24: ( WS )?
            int alt17=2;
            int LA17_0 = input.LA(1);
            if ( ((LA17_0>='\t' && LA17_0<='\n')||LA17_0==' ') ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ActionTranslator.g:713:24: WS
                    {
                    mWS(); if (failed) return ;

                    }
                    break;

            }

            match('='); if (failed) return ;
            int exprStart = getCharIndex();
            mATTR_VALUE_EXPR(); if (failed) return ;
            Token expr = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, exprStart, getCharIndex()-1);
            match(';'); if (failed) return ;
            if ( backtracking==1 ) {

              		StringTemplate st = template("actionSetAttribute");
              		String action = a.getText();
              		action = action.substring(1,action.length()-1); // stuff inside {...}
              		st.setAttribute("st", translateAction(action));
              		st.setAttribute("attrName", ID7.getText());
              		st.setAttribute("expr", translateAction(expr.getText()));
              		
            }

            }


            if ( backtracking==1 ) {

                      if ( token==null && ruleNestingLevel==1 ) {
                          emit(_type,_line,_charPosition,_channel,_start,getCharIndex()-1);
                      }

                      
            }    }
        finally {
            ruleNestingLevel--;
        }
    }
    // $ANTLR end SET_EXPR_ATTRIBUTE

    // $ANTLR start SET_ATTRIBUTE
    public void mSET_ATTRIBUTE() throws RecognitionException {
        try {
            ruleNestingLevel++;
            int _type = SET_ATTRIBUTE;
            int _start = getCharIndex();
            int _line = getLine();
            int _charPosition = getCharPositionInLine();
            int _channel = Token.DEFAULT_CHANNEL;
            // ActionTranslator.g:730:4: ( '%' x= ID '.' y= ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';' )
            // ActionTranslator.g:730:4: '%' x= ID '.' y= ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';'
            {
            match('%'); if (failed) return ;
            int xStart = getCharIndex();
            mID(); if (failed) return ;
            Token x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart, getCharIndex()-1);
            match('.'); if (failed) return ;
            int yStart = getCharIndex();
            mID(); if (failed) return ;
            Token y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart, getCharIndex()-1);
            // ActionTranslator.g:730:22: ( WS )?
            int alt18=2;
            int LA18_0 = input.LA(1);
            if ( ((LA18_0>='\t' && LA18_0<='\n')||LA18_0==' ') ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ActionTranslator.g:730:22: WS
                    {
                    mWS(); if (failed) return ;

                    }
                    break;

            }

            match('='); if (failed) return ;
            int exprStart = getCharIndex();
            mATTR_VALUE_EXPR(); if (failed) return ;
            Token expr = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, exprStart, getCharIndex()-1);
            match(';'); if (failed) return ;
            if ( backtracking==1 ) {

              		StringTemplate st = template("actionSetAttribute");
              		st.setAttribute("st", x.getText());
              		st.setAttribute("attrName", y.getText());
              		st.setAttribute("expr", translateAction(expr.getText()));
              		
            }

            }


            if ( backtracking==1 ) {

                      if ( token==null && ruleNestingLevel==1 ) {
                          emit(_type,_line,_charPosition,_channel,_start,getCharIndex()-1);
                      }

                      
            }    }
        finally {
            ruleNestingLevel--;
        }
    }
    // $ANTLR end SET_ATTRIBUTE

    // $ANTLR start ATTR_VALUE_EXPR
    public void mATTR_VALUE_EXPR() throws RecognitionException {
        try {
            ruleNestingLevel++;
            // ActionTranslator.g:743:4: (~ '=' (~ ';' )* )
            // ActionTranslator.g:743:4: ~ '=' (~ ';' )*
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='<')||(input.LA(1)>='>' && input.LA(1)<='\uFFFE') ) {
                input.consume();
            failed=false;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // ActionTranslator.g:743:9: (~ ';' )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);
                if ( ((LA19_0>='\u0000' && LA19_0<=':')||(LA19_0>='<' && LA19_0<='\uFFFE')) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ActionTranslator.g:743:10: ~ ';'
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<=':')||(input.LA(1)>='<' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();
            	    failed=false;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return ;}
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }

        }
        finally {
            ruleNestingLevel--;
        }
    }
    // $ANTLR end ATTR_VALUE_EXPR

    // $ANTLR start TEMPLATE_EXPR
    public void mTEMPLATE_EXPR() throws RecognitionException {
        try {
            ruleNestingLevel++;
            int _type = TEMPLATE_EXPR;
            int _start = getCharIndex();
            int _line = getLine();
            int _charPosition = getCharPositionInLine();
            int _channel = Token.DEFAULT_CHANNEL;
            // ActionTranslator.g:748:4: ( '%' a= ACTION )
            // ActionTranslator.g:748:4: '%' a= ACTION
            {
            match('%'); if (failed) return ;
            int aStart = getCharIndex();
            mACTION(); if (failed) return ;
            Token a = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, aStart, getCharIndex()-1);
            if ( backtracking==1 ) {

              		StringTemplate st = template("actionStringConstructor");
              		String action = a.getText();
              		action = action.substring(1,action.length()-1); // stuff inside {...}
              		st.setAttribute("stringExpr", translateAction(action));
              		
            }

            }


            if ( backtracking==1 ) {

                      if ( token==null && ruleNestingLevel==1 ) {
                          emit(_type,_line,_charPosition,_channel,_start,getCharIndex()-1);
                      }

                      
            }    }
        finally {
            ruleNestingLevel--;
        }
    }
    // $ANTLR end TEMPLATE_EXPR

    // $ANTLR start ACTION
    public void mACTION() throws RecognitionException {
        try {
            ruleNestingLevel++;
            // ActionTranslator.g:760:4: ( '{' ( options {greedy=false; } : . )* '}' )
            // ActionTranslator.g:760:4: '{' ( options {greedy=false; } : . )* '}'
            {
            match('{'); if (failed) return ;
            // ActionTranslator.g:760:8: ( options {greedy=false; } : . )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);
                if ( (LA20_0=='}') ) {
                    alt20=2;
                }
                else if ( ((LA20_0>='\u0000' && LA20_0<='|')||(LA20_0>='~' && LA20_0<='\uFFFE')) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ActionTranslator.g:760:33: .
            	    {
            	    matchAny(); if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            match('}'); if (failed) return ;

            }

        }
        finally {
            ruleNestingLevel--;
        }
    }
    // $ANTLR end ACTION

    // $ANTLR start ESC
    public void mESC() throws RecognitionException {
        try {
            ruleNestingLevel++;
            int _type = ESC;
            int _start = getCharIndex();
            int _line = getLine();
            int _charPosition = getCharPositionInLine();
            int _channel = Token.DEFAULT_CHANNEL;
            // ActionTranslator.g:763:9: ( '\\\\' '$' | '\\\\' '%' | '\\\\' ~ ('$'|'%'))
            int alt21=3;
            int LA21_0 = input.LA(1);
            if ( (LA21_0=='\\') ) {
                int LA21_1 = input.LA(2);
                if ( (LA21_1=='%') ) {
                    alt21=2;
                }
                else if ( (LA21_1=='$') ) {
                    alt21=1;
                }
                else if ( ((LA21_1>='\u0000' && LA21_1<='#')||(LA21_1>='&' && LA21_1<='\uFFFE')) ) {
                    alt21=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("763:1: ESC : ( '\\\\' '$' | '\\\\' '%' | '\\\\' ~ ('$'|'%'));", 21, 1, input);

                    throw nvae;
                }
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("763:1: ESC : ( '\\\\' '$' | '\\\\' '%' | '\\\\' ~ ('$'|'%'));", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ActionTranslator.g:763:9: '\\\\' '$'
                    {
                    match('\\'); if (failed) return ;
                    match('$'); if (failed) return ;
                    if ( backtracking==1 ) {
                      chunks.add("$");
                    }

                    }
                    break;
                case 2 :
                    // ActionTranslator.g:764:4: '\\\\' '%'
                    {
                    match('\\'); if (failed) return ;
                    match('%'); if (failed) return ;
                    if ( backtracking==1 ) {
                      chunks.add("%");
                    }

                    }
                    break;
                case 3 :
                    // ActionTranslator.g:765:4: '\\\\' ~ ('$'|'%')
                    {
                    match('\\'); if (failed) return ;
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='#')||(input.LA(1)>='&' && input.LA(1)<='\uFFFE') ) {
                        input.consume();
                    failed=false;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }

                    if ( backtracking==1 ) {
                      chunks.add(getText());
                    }

                    }
                    break;

            }

            if ( backtracking==1 ) {

                      if ( token==null && ruleNestingLevel==1 ) {
                          emit(_type,_line,_charPosition,_channel,_start,getCharIndex()-1);
                      }

                      
            }    }
        finally {
            ruleNestingLevel--;
        }
    }
    // $ANTLR end ESC

    // $ANTLR start ERROR_XY
    public void mERROR_XY() throws RecognitionException {
        try {
            ruleNestingLevel++;
            int _type = ERROR_XY;
            int _start = getCharIndex();
            int _line = getLine();
            int _charPosition = getCharPositionInLine();
            int _channel = Token.DEFAULT_CHANNEL;
            // ActionTranslator.g:769:4: ( '$' x= ID '.' y= ID )
            // ActionTranslator.g:769:4: '$' x= ID '.' y= ID
            {
            match('$'); if (failed) return ;
            int xStart = getCharIndex();
            mID(); if (failed) return ;
            Token x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart, getCharIndex()-1);
            match('.'); if (failed) return ;
            int yStart = getCharIndex();
            mID(); if (failed) return ;
            Token y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart, getCharIndex()-1);
            if ( backtracking==1 ) {

              		chunks.add(getText());
              		generator.issueInvalidAttributeError(x.getText(),y.getText(),
              		                                     enclosingRule,actionToken,
              		                                     outerAltNum);
              		
            }

            }


            if ( backtracking==1 ) {

                      if ( token==null && ruleNestingLevel==1 ) {
                          emit(_type,_line,_charPosition,_channel,_start,getCharIndex()-1);
                      }

                      
            }    }
        finally {
            ruleNestingLevel--;
        }
    }
    // $ANTLR end ERROR_XY

    // $ANTLR start ERROR_X
    public void mERROR_X() throws RecognitionException {
        try {
            ruleNestingLevel++;
            int _type = ERROR_X;
            int _start = getCharIndex();
            int _line = getLine();
            int _charPosition = getCharPositionInLine();
            int _channel = Token.DEFAULT_CHANNEL;
            // ActionTranslator.g:779:4: ( '$' x= ID )
            // ActionTranslator.g:779:4: '$' x= ID
            {
            match('$'); if (failed) return ;
            int xStart = getCharIndex();
            mID(); if (failed) return ;
            Token x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart, getCharIndex()-1);
            if ( backtracking==1 ) {

              		chunks.add(getText());
              		generator.issueInvalidAttributeError(x.getText(),
              		                                     enclosingRule,actionToken,
              		                                     outerAltNum);
              		
            }

            }


            if ( backtracking==1 ) {

                      if ( token==null && ruleNestingLevel==1 ) {
                          emit(_type,_line,_charPosition,_channel,_start,getCharIndex()-1);
                      }

                      
            }    }
        finally {
            ruleNestingLevel--;
        }
    }
    // $ANTLR end ERROR_X

    // $ANTLR start UNKNOWN_SYNTAX
    public void mUNKNOWN_SYNTAX() throws RecognitionException {
        try {
            ruleNestingLevel++;
            int _type = UNKNOWN_SYNTAX;
            int _start = getCharIndex();
            int _line = getLine();
            int _charPosition = getCharPositionInLine();
            int _channel = Token.DEFAULT_CHANNEL;
            // ActionTranslator.g:789:4: ( '$' | '%' ( ID | '.' | '(' | ')' | ',' | '{' | '}' | '\"' )* )
            int alt23=2;
            int LA23_0 = input.LA(1);
            if ( (LA23_0=='$') ) {
                alt23=1;
            }
            else if ( (LA23_0=='%') ) {
                alt23=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("788:1: UNKNOWN_SYNTAX : ( '$' | '%' ( ID | '.' | '(' | ')' | ',' | '{' | '}' | '\"' )* );", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ActionTranslator.g:789:4: '$'
                    {
                    match('$'); if (failed) return ;
                    if ( backtracking==1 ) {

                      		chunks.add(getText());
                      		// shouldn't need an error here.  Just accept $ if it doesn't look like anything
                      		
                    }

                    }
                    break;
                case 2 :
                    // ActionTranslator.g:794:4: '%' ( ID | '.' | '(' | ')' | ',' | '{' | '}' | '\"' )*
                    {
                    match('%'); if (failed) return ;
                    // ActionTranslator.g:794:8: ( ID | '.' | '(' | ')' | ',' | '{' | '}' | '\"' )*
                    loop22:
                    do {
                        int alt22=9;
                        switch ( input.LA(1) ) {
                        case 'A':
                        case 'B':
                        case 'C':
                        case 'D':
                        case 'E':
                        case 'F':
                        case 'G':
                        case 'H':
                        case 'I':
                        case 'J':
                        case 'K':
                        case 'L':
                        case 'M':
                        case 'N':
                        case 'O':
                        case 'P':
                        case 'Q':
                        case 'R':
                        case 'S':
                        case 'T':
                        case 'U':
                        case 'V':
                        case 'W':
                        case 'X':
                        case 'Y':
                        case 'Z':
                        case '_':
                        case 'a':
                        case 'b':
                        case 'c':
                        case 'd':
                        case 'e':
                        case 'f':
                        case 'g':
                        case 'h':
                        case 'i':
                        case 'j':
                        case 'k':
                        case 'l':
                        case 'm':
                        case 'n':
                        case 'o':
                        case 'p':
                        case 'q':
                        case 'r':
                        case 's':
                        case 't':
                        case 'u':
                        case 'v':
                        case 'w':
                        case 'x':
                        case 'y':
                        case 'z':
                            alt22=1;
                            break;
                        case '.':
                            alt22=2;
                            break;
                        case '(':
                            alt22=3;
                            break;
                        case ')':
                            alt22=4;
                            break;
                        case ',':
                            alt22=5;
                            break;
                        case '{':
                            alt22=6;
                            break;
                        case '}':
                            alt22=7;
                            break;
                        case '\"':
                            alt22=8;
                            break;

                        }

                        switch (alt22) {
                    	case 1 :
                    	    // ActionTranslator.g:794:9: ID
                    	    {
                    	    mID(); if (failed) return ;

                    	    }
                    	    break;
                    	case 2 :
                    	    // ActionTranslator.g:794:12: '.'
                    	    {
                    	    match('.'); if (failed) return ;

                    	    }
                    	    break;
                    	case 3 :
                    	    // ActionTranslator.g:794:16: '('
                    	    {
                    	    match('('); if (failed) return ;

                    	    }
                    	    break;
                    	case 4 :
                    	    // ActionTranslator.g:794:20: ')'
                    	    {
                    	    match(')'); if (failed) return ;

                    	    }
                    	    break;
                    	case 5 :
                    	    // ActionTranslator.g:794:24: ','
                    	    {
                    	    match(','); if (failed) return ;

                    	    }
                    	    break;
                    	case 6 :
                    	    // ActionTranslator.g:794:28: '{'
                    	    {
                    	    match('{'); if (failed) return ;

                    	    }
                    	    break;
                    	case 7 :
                    	    // ActionTranslator.g:794:32: '}'
                    	    {
                    	    match('}'); if (failed) return ;

                    	    }
                    	    break;
                    	case 8 :
                    	    // ActionTranslator.g:794:36: '\"'
                    	    {
                    	    match('\"'); if (failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    if ( backtracking==1 ) {

                      		chunks.add(getText());
                      		ErrorManager.grammarError(ErrorManager.MSG_INVALID_TEMPLATE_ACTION,
                      								  grammar,
                      								  actionToken,
                      								  getText());
                      		
                    }

                    }
                    break;

            }

            if ( backtracking==1 ) {

                      if ( token==null && ruleNestingLevel==1 ) {
                          emit(_type,_line,_charPosition,_channel,_start,getCharIndex()-1);
                      }

                      
            }    }
        finally {
            ruleNestingLevel--;
        }
    }
    // $ANTLR end UNKNOWN_SYNTAX

    // $ANTLR start TEXT
    public void mTEXT() throws RecognitionException {
        try {
            ruleNestingLevel++;
            int _type = TEXT;
            int _start = getCharIndex();
            int _line = getLine();
            int _charPosition = getCharPositionInLine();
            int _channel = Token.DEFAULT_CHANNEL;
            // ActionTranslator.g:804:7: ( (~ ('$'|'%'|'\\\\'))+ )
            // ActionTranslator.g:804:7: (~ ('$'|'%'|'\\\\'))+
            {
            // ActionTranslator.g:804:7: (~ ('$'|'%'|'\\\\'))+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);
                if ( ((LA24_0>='\u0000' && LA24_0<='#')||(LA24_0>='&' && LA24_0<='[')||(LA24_0>=']' && LA24_0<='\uFFFE')) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ActionTranslator.g:804:7: ~ ('$'|'%'|'\\\\')
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='#')||(input.LA(1)>='&' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();
            	    failed=false;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return ;}
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt24 >= 1 ) break loop24;
            	    if (backtracking>0) {failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
            } while (true);

            if ( backtracking==1 ) {
              chunks.add(getText());
            }

            }


            if ( backtracking==1 ) {

                      if ( token==null && ruleNestingLevel==1 ) {
                          emit(_type,_line,_charPosition,_channel,_start,getCharIndex()-1);
                      }

                      
            }    }
        finally {
            ruleNestingLevel--;
        }
    }
    // $ANTLR end TEXT

    // $ANTLR start ID
    public void mID() throws RecognitionException {
        try {
            ruleNestingLevel++;
            // ActionTranslator.g:808:9: ( ('a'..'z'|'A'..'Z'|'_') ( ('a'..'z'|'A'..'Z'|'_'|'0'..'9'))* )
            // ActionTranslator.g:808:9: ('a'..'z'|'A'..'Z'|'_') ( ('a'..'z'|'A'..'Z'|'_'|'0'..'9'))*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();
            failed=false;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // ActionTranslator.g:808:33: ( ('a'..'z'|'A'..'Z'|'_'|'0'..'9'))*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);
                if ( ((LA25_0>='0' && LA25_0<='9')||(LA25_0>='A' && LA25_0<='Z')||LA25_0=='_'||(LA25_0>='a' && LA25_0<='z')) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ActionTranslator.g:808:34: ('a'..'z'|'A'..'Z'|'_'|'0'..'9')
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();
            	    failed=false;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return ;}
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            }

        }
        finally {
            ruleNestingLevel--;
        }
    }
    // $ANTLR end ID

    // $ANTLR start INT
    public void mINT() throws RecognitionException {
        try {
            ruleNestingLevel++;
            // ActionTranslator.g:812:7: ( ( '0' .. '9' )+ )
            // ActionTranslator.g:812:7: ( '0' .. '9' )+
            {
            // ActionTranslator.g:812:7: ( '0' .. '9' )+
            int cnt26=0;
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);
                if ( ((LA26_0>='0' && LA26_0<='9')) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ActionTranslator.g:812:7: '0' .. '9'
            	    {
            	    matchRange('0','9'); if (failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt26 >= 1 ) break loop26;
            	    if (backtracking>0) {failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
            } while (true);


            }

        }
        finally {
            ruleNestingLevel--;
        }
    }
    // $ANTLR end INT

    // $ANTLR start WS
    public void mWS() throws RecognitionException {
        try {
            ruleNestingLevel++;
            // ActionTranslator.g:816:6: ( ( (' '|'\\t'|'\\n'))+ )
            // ActionTranslator.g:816:6: ( (' '|'\\t'|'\\n'))+
            {
            // ActionTranslator.g:816:6: ( (' '|'\\t'|'\\n'))+
            int cnt27=0;
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);
                if ( ((LA27_0>='\t' && LA27_0<='\n')||LA27_0==' ') ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ActionTranslator.g:816:7: (' '|'\\t'|'\\n')
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)==' ' ) {
            	        input.consume();
            	    failed=false;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return ;}
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt27 >= 1 ) break loop27;
            	    if (backtracking>0) {failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(27, input);
                        throw eee;
                }
                cnt27++;
            } while (true);


            }

        }
        finally {
            ruleNestingLevel--;
        }
    }
    // $ANTLR end WS

    public void mTokens() throws RecognitionException {
        // ActionTranslator.g:1:25: ( ( SET_ENCLOSING_RULE_SCOPE_ATTR )=> SET_ENCLOSING_RULE_SCOPE_ATTR | ( ENCLOSING_RULE_SCOPE_ATTR )=> ENCLOSING_RULE_SCOPE_ATTR | ( SET_TOKEN_SCOPE_ATTR )=> SET_TOKEN_SCOPE_ATTR | ( TOKEN_SCOPE_ATTR )=> TOKEN_SCOPE_ATTR | ( SET_RULE_SCOPE_ATTR )=> SET_RULE_SCOPE_ATTR | ( RULE_SCOPE_ATTR )=> RULE_SCOPE_ATTR | ( LABEL_REF )=> LABEL_REF | ( ISOLATED_TOKEN_REF )=> ISOLATED_TOKEN_REF | ( ISOLATED_LEXER_RULE_REF )=> ISOLATED_LEXER_RULE_REF | ( SET_LOCAL_ATTR )=> SET_LOCAL_ATTR | ( LOCAL_ATTR )=> LOCAL_ATTR | ( SET_DYNAMIC_SCOPE_ATTR )=> SET_DYNAMIC_SCOPE_ATTR | ( DYNAMIC_SCOPE_ATTR )=> DYNAMIC_SCOPE_ATTR | ( ERROR_SCOPED_XY )=> ERROR_SCOPED_XY | ( DYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR )=> DYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR | ( DYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR )=> DYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR | ( ISOLATED_DYNAMIC_SCOPE )=> ISOLATED_DYNAMIC_SCOPE | ( TEMPLATE_INSTANCE )=> TEMPLATE_INSTANCE | ( INDIRECT_TEMPLATE_INSTANCE )=> INDIRECT_TEMPLATE_INSTANCE | ( SET_EXPR_ATTRIBUTE )=> SET_EXPR_ATTRIBUTE | ( SET_ATTRIBUTE )=> SET_ATTRIBUTE | ( TEMPLATE_EXPR )=> TEMPLATE_EXPR | ( ESC )=> ESC | ( ERROR_XY )=> ERROR_XY | ( ERROR_X )=> ERROR_X | ( UNKNOWN_SYNTAX )=> UNKNOWN_SYNTAX | ( TEXT )=> TEXT )
        int alt28=27;
        int LA28_0 = input.LA(1);
        if ( (LA28_0=='$') ) {
            if ( (synpred1()) ) {
                alt28=1;
            }
            else if ( (synpred2()) ) {
                alt28=2;
            }
            else if ( (synpred3()) ) {
                alt28=3;
            }
            else if ( (synpred4()) ) {
                alt28=4;
            }
            else if ( (synpred5()) ) {
                alt28=5;
            }
            else if ( (synpred6()) ) {
                alt28=6;
            }
            else if ( (synpred7()) ) {
                alt28=7;
            }
            else if ( (synpred8()) ) {
                alt28=8;
            }
            else if ( (synpred9()) ) {
                alt28=9;
            }
            else if ( (synpred10()) ) {
                alt28=10;
            }
            else if ( (synpred11()) ) {
                alt28=11;
            }
            else if ( (synpred12()) ) {
                alt28=12;
            }
            else if ( (synpred13()) ) {
                alt28=13;
            }
            else if ( (synpred14()) ) {
                alt28=14;
            }
            else if ( (synpred15()) ) {
                alt28=15;
            }
            else if ( (synpred16()) ) {
                alt28=16;
            }
            else if ( (synpred17()) ) {
                alt28=17;
            }
            else if ( (synpred24()) ) {
                alt28=24;
            }
            else if ( (synpred25()) ) {
                alt28=25;
            }
            else if ( (synpred26()) ) {
                alt28=26;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("1:1: Tokens options {k=1; } : ( ( SET_ENCLOSING_RULE_SCOPE_ATTR )=> SET_ENCLOSING_RULE_SCOPE_ATTR | ( ENCLOSING_RULE_SCOPE_ATTR )=> ENCLOSING_RULE_SCOPE_ATTR | ( SET_TOKEN_SCOPE_ATTR )=> SET_TOKEN_SCOPE_ATTR | ( TOKEN_SCOPE_ATTR )=> TOKEN_SCOPE_ATTR | ( SET_RULE_SCOPE_ATTR )=> SET_RULE_SCOPE_ATTR | ( RULE_SCOPE_ATTR )=> RULE_SCOPE_ATTR | ( LABEL_REF )=> LABEL_REF | ( ISOLATED_TOKEN_REF )=> ISOLATED_TOKEN_REF | ( ISOLATED_LEXER_RULE_REF )=> ISOLATED_LEXER_RULE_REF | ( SET_LOCAL_ATTR )=> SET_LOCAL_ATTR | ( LOCAL_ATTR )=> LOCAL_ATTR | ( SET_DYNAMIC_SCOPE_ATTR )=> SET_DYNAMIC_SCOPE_ATTR | ( DYNAMIC_SCOPE_ATTR )=> DYNAMIC_SCOPE_ATTR | ( ERROR_SCOPED_XY )=> ERROR_SCOPED_XY | ( DYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR )=> DYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR | ( DYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR )=> DYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR | ( ISOLATED_DYNAMIC_SCOPE )=> ISOLATED_DYNAMIC_SCOPE | ( TEMPLATE_INSTANCE )=> TEMPLATE_INSTANCE | ( INDIRECT_TEMPLATE_INSTANCE )=> INDIRECT_TEMPLATE_INSTANCE | ( SET_EXPR_ATTRIBUTE )=> SET_EXPR_ATTRIBUTE | ( SET_ATTRIBUTE )=> SET_ATTRIBUTE | ( TEMPLATE_EXPR )=> TEMPLATE_EXPR | ( ESC )=> ESC | ( ERROR_XY )=> ERROR_XY | ( ERROR_X )=> ERROR_X | ( UNKNOWN_SYNTAX )=> UNKNOWN_SYNTAX | ( TEXT )=> TEXT );", 28, 1, input);

                throw nvae;
            }
        }
        else if ( (LA28_0=='%') ) {
            if ( (synpred18()) ) {
                alt28=18;
            }
            else if ( (synpred19()) ) {
                alt28=19;
            }
            else if ( (synpred20()) ) {
                alt28=20;
            }
            else if ( (synpred21()) ) {
                alt28=21;
            }
            else if ( (synpred22()) ) {
                alt28=22;
            }
            else if ( (synpred26()) ) {
                alt28=26;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("1:1: Tokens options {k=1; } : ( ( SET_ENCLOSING_RULE_SCOPE_ATTR )=> SET_ENCLOSING_RULE_SCOPE_ATTR | ( ENCLOSING_RULE_SCOPE_ATTR )=> ENCLOSING_RULE_SCOPE_ATTR | ( SET_TOKEN_SCOPE_ATTR )=> SET_TOKEN_SCOPE_ATTR | ( TOKEN_SCOPE_ATTR )=> TOKEN_SCOPE_ATTR | ( SET_RULE_SCOPE_ATTR )=> SET_RULE_SCOPE_ATTR | ( RULE_SCOPE_ATTR )=> RULE_SCOPE_ATTR | ( LABEL_REF )=> LABEL_REF | ( ISOLATED_TOKEN_REF )=> ISOLATED_TOKEN_REF | ( ISOLATED_LEXER_RULE_REF )=> ISOLATED_LEXER_RULE_REF | ( SET_LOCAL_ATTR )=> SET_LOCAL_ATTR | ( LOCAL_ATTR )=> LOCAL_ATTR | ( SET_DYNAMIC_SCOPE_ATTR )=> SET_DYNAMIC_SCOPE_ATTR | ( DYNAMIC_SCOPE_ATTR )=> DYNAMIC_SCOPE_ATTR | ( ERROR_SCOPED_XY )=> ERROR_SCOPED_XY | ( DYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR )=> DYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR | ( DYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR )=> DYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR | ( ISOLATED_DYNAMIC_SCOPE )=> ISOLATED_DYNAMIC_SCOPE | ( TEMPLATE_INSTANCE )=> TEMPLATE_INSTANCE | ( INDIRECT_TEMPLATE_INSTANCE )=> INDIRECT_TEMPLATE_INSTANCE | ( SET_EXPR_ATTRIBUTE )=> SET_EXPR_ATTRIBUTE | ( SET_ATTRIBUTE )=> SET_ATTRIBUTE | ( TEMPLATE_EXPR )=> TEMPLATE_EXPR | ( ESC )=> ESC | ( ERROR_XY )=> ERROR_XY | ( ERROR_X )=> ERROR_X | ( UNKNOWN_SYNTAX )=> UNKNOWN_SYNTAX | ( TEXT )=> TEXT );", 28, 2, input);

                throw nvae;
            }
        }
        else if ( (LA28_0=='\\') ) {
            alt28=23;
        }
        else if ( ((LA28_0>='\u0000' && LA28_0<='#')||(LA28_0>='&' && LA28_0<='[')||(LA28_0>=']' && LA28_0<='\uFFFE')) ) {
            alt28=27;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens options {k=1; } : ( ( SET_ENCLOSING_RULE_SCOPE_ATTR )=> SET_ENCLOSING_RULE_SCOPE_ATTR | ( ENCLOSING_RULE_SCOPE_ATTR )=> ENCLOSING_RULE_SCOPE_ATTR | ( SET_TOKEN_SCOPE_ATTR )=> SET_TOKEN_SCOPE_ATTR | ( TOKEN_SCOPE_ATTR )=> TOKEN_SCOPE_ATTR | ( SET_RULE_SCOPE_ATTR )=> SET_RULE_SCOPE_ATTR | ( RULE_SCOPE_ATTR )=> RULE_SCOPE_ATTR | ( LABEL_REF )=> LABEL_REF | ( ISOLATED_TOKEN_REF )=> ISOLATED_TOKEN_REF | ( ISOLATED_LEXER_RULE_REF )=> ISOLATED_LEXER_RULE_REF | ( SET_LOCAL_ATTR )=> SET_LOCAL_ATTR | ( LOCAL_ATTR )=> LOCAL_ATTR | ( SET_DYNAMIC_SCOPE_ATTR )=> SET_DYNAMIC_SCOPE_ATTR | ( DYNAMIC_SCOPE_ATTR )=> DYNAMIC_SCOPE_ATTR | ( ERROR_SCOPED_XY )=> ERROR_SCOPED_XY | ( DYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR )=> DYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR | ( DYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR )=> DYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR | ( ISOLATED_DYNAMIC_SCOPE )=> ISOLATED_DYNAMIC_SCOPE | ( TEMPLATE_INSTANCE )=> TEMPLATE_INSTANCE | ( INDIRECT_TEMPLATE_INSTANCE )=> INDIRECT_TEMPLATE_INSTANCE | ( SET_EXPR_ATTRIBUTE )=> SET_EXPR_ATTRIBUTE | ( SET_ATTRIBUTE )=> SET_ATTRIBUTE | ( TEMPLATE_EXPR )=> TEMPLATE_EXPR | ( ESC )=> ESC | ( ERROR_XY )=> ERROR_XY | ( ERROR_X )=> ERROR_X | ( UNKNOWN_SYNTAX )=> UNKNOWN_SYNTAX | ( TEXT )=> TEXT );", 28, 0, input);

            throw nvae;
        }
        switch (alt28) {
            case 1 :
                // ActionTranslator.g:1:25: ( SET_ENCLOSING_RULE_SCOPE_ATTR )=> SET_ENCLOSING_RULE_SCOPE_ATTR
                {
                mSET_ENCLOSING_RULE_SCOPE_ATTR(); if (failed) return ;

                }
                break;
            case 2 :
                // ActionTranslator.g:1:88: ( ENCLOSING_RULE_SCOPE_ATTR )=> ENCLOSING_RULE_SCOPE_ATTR
                {
                mENCLOSING_RULE_SCOPE_ATTR(); if (failed) return ;

                }
                break;
            case 3 :
                // ActionTranslator.g:1:143: ( SET_TOKEN_SCOPE_ATTR )=> SET_TOKEN_SCOPE_ATTR
                {
                mSET_TOKEN_SCOPE_ATTR(); if (failed) return ;

                }
                break;
            case 4 :
                // ActionTranslator.g:1:188: ( TOKEN_SCOPE_ATTR )=> TOKEN_SCOPE_ATTR
                {
                mTOKEN_SCOPE_ATTR(); if (failed) return ;

                }
                break;
            case 5 :
                // ActionTranslator.g:1:225: ( SET_RULE_SCOPE_ATTR )=> SET_RULE_SCOPE_ATTR
                {
                mSET_RULE_SCOPE_ATTR(); if (failed) return ;

                }
                break;
            case 6 :
                // ActionTranslator.g:1:268: ( RULE_SCOPE_ATTR )=> RULE_SCOPE_ATTR
                {
                mRULE_SCOPE_ATTR(); if (failed) return ;

                }
                break;
            case 7 :
                // ActionTranslator.g:1:303: ( LABEL_REF )=> LABEL_REF
                {
                mLABEL_REF(); if (failed) return ;

                }
                break;
            case 8 :
                // ActionTranslator.g:1:326: ( ISOLATED_TOKEN_REF )=> ISOLATED_TOKEN_REF
                {
                mISOLATED_TOKEN_REF(); if (failed) return ;

                }
                break;
            case 9 :
                // ActionTranslator.g:1:367: ( ISOLATED_LEXER_RULE_REF )=> ISOLATED_LEXER_RULE_REF
                {
                mISOLATED_LEXER_RULE_REF(); if (failed) return ;

                }
                break;
            case 10 :
                // ActionTranslator.g:1:418: ( SET_LOCAL_ATTR )=> SET_LOCAL_ATTR
                {
                mSET_LOCAL_ATTR(); if (failed) return ;

                }
                break;
            case 11 :
                // ActionTranslator.g:1:451: ( LOCAL_ATTR )=> LOCAL_ATTR
                {
                mLOCAL_ATTR(); if (failed) return ;

                }
                break;
            case 12 :
                // ActionTranslator.g:1:476: ( SET_DYNAMIC_SCOPE_ATTR )=> SET_DYNAMIC_SCOPE_ATTR
                {
                mSET_DYNAMIC_SCOPE_ATTR(); if (failed) return ;

                }
                break;
            case 13 :
                // ActionTranslator.g:1:525: ( DYNAMIC_SCOPE_ATTR )=> DYNAMIC_SCOPE_ATTR
                {
                mDYNAMIC_SCOPE_ATTR(); if (failed) return ;

                }
                break;
            case 14 :
                // ActionTranslator.g:1:566: ( ERROR_SCOPED_XY )=> ERROR_SCOPED_XY
                {
                mERROR_SCOPED_XY(); if (failed) return ;

                }
                break;
            case 15 :
                // ActionTranslator.g:1:601: ( DYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR )=> DYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR
                {
                mDYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR(); if (failed) return ;

                }
                break;
            case 16 :
                // ActionTranslator.g:1:676: ( DYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR )=> DYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR
                {
                mDYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR(); if (failed) return ;

                }
                break;
            case 17 :
                // ActionTranslator.g:1:751: ( ISOLATED_DYNAMIC_SCOPE )=> ISOLATED_DYNAMIC_SCOPE
                {
                mISOLATED_DYNAMIC_SCOPE(); if (failed) return ;

                }
                break;
            case 18 :
                // ActionTranslator.g:1:800: ( TEMPLATE_INSTANCE )=> TEMPLATE_INSTANCE
                {
                mTEMPLATE_INSTANCE(); if (failed) return ;

                }
                break;
            case 19 :
                // ActionTranslator.g:1:839: ( INDIRECT_TEMPLATE_INSTANCE )=> INDIRECT_TEMPLATE_INSTANCE
                {
                mINDIRECT_TEMPLATE_INSTANCE(); if (failed) return ;

                }
                break;
            case 20 :
                // ActionTranslator.g:1:896: ( SET_EXPR_ATTRIBUTE )=> SET_EXPR_ATTRIBUTE
                {
                mSET_EXPR_ATTRIBUTE(); if (failed) return ;

                }
                break;
            case 21 :
                // ActionTranslator.g:1:937: ( SET_ATTRIBUTE )=> SET_ATTRIBUTE
                {
                mSET_ATTRIBUTE(); if (failed) return ;

                }
                break;
            case 22 :
                // ActionTranslator.g:1:968: ( TEMPLATE_EXPR )=> TEMPLATE_EXPR
                {
                mTEMPLATE_EXPR(); if (failed) return ;

                }
                break;
            case 23 :
                // ActionTranslator.g:1:999: ( ESC )=> ESC
                {
                mESC(); if (failed) return ;

                }
                break;
            case 24 :
                // ActionTranslator.g:1:1010: ( ERROR_XY )=> ERROR_XY
                {
                mERROR_XY(); if (failed) return ;

                }
                break;
            case 25 :
                // ActionTranslator.g:1:1031: ( ERROR_X )=> ERROR_X
                {
                mERROR_X(); if (failed) return ;

                }
                break;
            case 26 :
                // ActionTranslator.g:1:1050: ( UNKNOWN_SYNTAX )=> UNKNOWN_SYNTAX
                {
                mUNKNOWN_SYNTAX(); if (failed) return ;

                }
                break;
            case 27 :
                // ActionTranslator.g:1:1083: ( TEXT )=> TEXT
                {
                mTEXT(); if (failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1
    public void synpred1_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:25: ( SET_ENCLOSING_RULE_SCOPE_ATTR )
        // ActionTranslator.g:1:26: SET_ENCLOSING_RULE_SCOPE_ATTR
        {
        mSET_ENCLOSING_RULE_SCOPE_ATTR(); if (failed) return ;

        }
    }
    // $ANTLR end synpred1

    // $ANTLR start synpred2
    public void synpred2_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:88: ( ENCLOSING_RULE_SCOPE_ATTR )
        // ActionTranslator.g:1:89: ENCLOSING_RULE_SCOPE_ATTR
        {
        mENCLOSING_RULE_SCOPE_ATTR(); if (failed) return ;

        }
    }
    // $ANTLR end synpred2

    // $ANTLR start synpred3
    public void synpred3_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:143: ( SET_TOKEN_SCOPE_ATTR )
        // ActionTranslator.g:1:144: SET_TOKEN_SCOPE_ATTR
        {
        mSET_TOKEN_SCOPE_ATTR(); if (failed) return ;

        }
    }
    // $ANTLR end synpred3

    // $ANTLR start synpred4
    public void synpred4_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:188: ( TOKEN_SCOPE_ATTR )
        // ActionTranslator.g:1:189: TOKEN_SCOPE_ATTR
        {
        mTOKEN_SCOPE_ATTR(); if (failed) return ;

        }
    }
    // $ANTLR end synpred4

    // $ANTLR start synpred5
    public void synpred5_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:225: ( SET_RULE_SCOPE_ATTR )
        // ActionTranslator.g:1:226: SET_RULE_SCOPE_ATTR
        {
        mSET_RULE_SCOPE_ATTR(); if (failed) return ;

        }
    }
    // $ANTLR end synpred5

    // $ANTLR start synpred6
    public void synpred6_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:268: ( RULE_SCOPE_ATTR )
        // ActionTranslator.g:1:269: RULE_SCOPE_ATTR
        {
        mRULE_SCOPE_ATTR(); if (failed) return ;

        }
    }
    // $ANTLR end synpred6

    // $ANTLR start synpred7
    public void synpred7_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:303: ( LABEL_REF )
        // ActionTranslator.g:1:304: LABEL_REF
        {
        mLABEL_REF(); if (failed) return ;

        }
    }
    // $ANTLR end synpred7

    // $ANTLR start synpred8
    public void synpred8_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:326: ( ISOLATED_TOKEN_REF )
        // ActionTranslator.g:1:327: ISOLATED_TOKEN_REF
        {
        mISOLATED_TOKEN_REF(); if (failed) return ;

        }
    }
    // $ANTLR end synpred8

    // $ANTLR start synpred9
    public void synpred9_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:367: ( ISOLATED_LEXER_RULE_REF )
        // ActionTranslator.g:1:368: ISOLATED_LEXER_RULE_REF
        {
        mISOLATED_LEXER_RULE_REF(); if (failed) return ;

        }
    }
    // $ANTLR end synpred9

    // $ANTLR start synpred10
    public void synpred10_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:418: ( SET_LOCAL_ATTR )
        // ActionTranslator.g:1:419: SET_LOCAL_ATTR
        {
        mSET_LOCAL_ATTR(); if (failed) return ;

        }
    }
    // $ANTLR end synpred10

    // $ANTLR start synpred11
    public void synpred11_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:451: ( LOCAL_ATTR )
        // ActionTranslator.g:1:452: LOCAL_ATTR
        {
        mLOCAL_ATTR(); if (failed) return ;

        }
    }
    // $ANTLR end synpred11

    // $ANTLR start synpred12
    public void synpred12_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:476: ( SET_DYNAMIC_SCOPE_ATTR )
        // ActionTranslator.g:1:477: SET_DYNAMIC_SCOPE_ATTR
        {
        mSET_DYNAMIC_SCOPE_ATTR(); if (failed) return ;

        }
    }
    // $ANTLR end synpred12

    // $ANTLR start synpred13
    public void synpred13_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:525: ( DYNAMIC_SCOPE_ATTR )
        // ActionTranslator.g:1:526: DYNAMIC_SCOPE_ATTR
        {
        mDYNAMIC_SCOPE_ATTR(); if (failed) return ;

        }
    }
    // $ANTLR end synpred13

    // $ANTLR start synpred14
    public void synpred14_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:566: ( ERROR_SCOPED_XY )
        // ActionTranslator.g:1:567: ERROR_SCOPED_XY
        {
        mERROR_SCOPED_XY(); if (failed) return ;

        }
    }
    // $ANTLR end synpred14

    // $ANTLR start synpred15
    public void synpred15_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:601: ( DYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR )
        // ActionTranslator.g:1:602: DYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR
        {
        mDYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR(); if (failed) return ;

        }
    }
    // $ANTLR end synpred15

    // $ANTLR start synpred16
    public void synpred16_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:676: ( DYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR )
        // ActionTranslator.g:1:677: DYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR
        {
        mDYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR(); if (failed) return ;

        }
    }
    // $ANTLR end synpred16

    // $ANTLR start synpred17
    public void synpred17_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:751: ( ISOLATED_DYNAMIC_SCOPE )
        // ActionTranslator.g:1:752: ISOLATED_DYNAMIC_SCOPE
        {
        mISOLATED_DYNAMIC_SCOPE(); if (failed) return ;

        }
    }
    // $ANTLR end synpred17

    // $ANTLR start synpred18
    public void synpred18_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:800: ( TEMPLATE_INSTANCE )
        // ActionTranslator.g:1:801: TEMPLATE_INSTANCE
        {
        mTEMPLATE_INSTANCE(); if (failed) return ;

        }
    }
    // $ANTLR end synpred18

    // $ANTLR start synpred19
    public void synpred19_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:839: ( INDIRECT_TEMPLATE_INSTANCE )
        // ActionTranslator.g:1:840: INDIRECT_TEMPLATE_INSTANCE
        {
        mINDIRECT_TEMPLATE_INSTANCE(); if (failed) return ;

        }
    }
    // $ANTLR end synpred19

    // $ANTLR start synpred20
    public void synpred20_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:896: ( SET_EXPR_ATTRIBUTE )
        // ActionTranslator.g:1:897: SET_EXPR_ATTRIBUTE
        {
        mSET_EXPR_ATTRIBUTE(); if (failed) return ;

        }
    }
    // $ANTLR end synpred20

    // $ANTLR start synpred21
    public void synpred21_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:937: ( SET_ATTRIBUTE )
        // ActionTranslator.g:1:938: SET_ATTRIBUTE
        {
        mSET_ATTRIBUTE(); if (failed) return ;

        }
    }
    // $ANTLR end synpred21

    // $ANTLR start synpred22
    public void synpred22_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:968: ( TEMPLATE_EXPR )
        // ActionTranslator.g:1:969: TEMPLATE_EXPR
        {
        mTEMPLATE_EXPR(); if (failed) return ;

        }
    }
    // $ANTLR end synpred22

    // $ANTLR start synpred24
    public void synpred24_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:1010: ( ERROR_XY )
        // ActionTranslator.g:1:1011: ERROR_XY
        {
        mERROR_XY(); if (failed) return ;

        }
    }
    // $ANTLR end synpred24

    // $ANTLR start synpred25
    public void synpred25_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:1031: ( ERROR_X )
        // ActionTranslator.g:1:1032: ERROR_X
        {
        mERROR_X(); if (failed) return ;

        }
    }
    // $ANTLR end synpred25

    // $ANTLR start synpred26
    public void synpred26_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:1050: ( UNKNOWN_SYNTAX )
        // ActionTranslator.g:1:1051: UNKNOWN_SYNTAX
        {
        mUNKNOWN_SYNTAX(); if (failed) return ;

        }
    }
    // $ANTLR end synpred26

    public boolean synpred25() {
        backtracking++;
        int start = input.mark();
        try {
            synpred25_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public boolean synpred7() {
        backtracking++;
        int start = input.mark();
        try {
            synpred7_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public boolean synpred14() {
        backtracking++;
        int start = input.mark();
        try {
            synpred14_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public boolean synpred15() {
        backtracking++;
        int start = input.mark();
        try {
            synpred15_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public boolean synpred22() {
        backtracking++;
        int start = input.mark();
        try {
            synpred22_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public boolean synpred12() {
        backtracking++;
        int start = input.mark();
        try {
            synpred12_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public boolean synpred4() {
        backtracking++;
        int start = input.mark();
        try {
            synpred4_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public boolean synpred9() {
        backtracking++;
        int start = input.mark();
        try {
            synpred9_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public boolean synpred1() {
        backtracking++;
        int start = input.mark();
        try {
            synpred1_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public boolean synpred20() {
        backtracking++;
        int start = input.mark();
        try {
            synpred20_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public boolean synpred17() {
        backtracking++;
        int start = input.mark();
        try {
            synpred17_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public boolean synpred2() {
        backtracking++;
        int start = input.mark();
        try {
            synpred2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public boolean synpred18() {
        backtracking++;
        int start = input.mark();
        try {
            synpred18_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public boolean synpred3() {
        backtracking++;
        int start = input.mark();
        try {
            synpred3_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public boolean synpred11() {
        backtracking++;
        int start = input.mark();
        try {
            synpred11_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public boolean synpred26() {
        backtracking++;
        int start = input.mark();
        try {
            synpred26_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public boolean synpred8() {
        backtracking++;
        int start = input.mark();
        try {
            synpred8_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public boolean synpred10() {
        backtracking++;
        int start = input.mark();
        try {
            synpred10_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public boolean synpred21() {
        backtracking++;
        int start = input.mark();
        try {
            synpred21_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public boolean synpred16() {
        backtracking++;
        int start = input.mark();
        try {
            synpred16_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public boolean synpred19() {
        backtracking++;
        int start = input.mark();
        try {
            synpred19_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public boolean synpred24() {
        backtracking++;
        int start = input.mark();
        try {
            synpred24_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public boolean synpred5() {
        backtracking++;
        int start = input.mark();
        try {
            synpred5_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public boolean synpred6() {
        backtracking++;
        int start = input.mark();
        try {
            synpred6_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public boolean synpred13() {
        backtracking++;
        int start = input.mark();
        try {
            synpred13_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


 

}