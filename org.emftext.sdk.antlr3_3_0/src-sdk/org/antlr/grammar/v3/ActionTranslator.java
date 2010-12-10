// $ANTLR 3.3 Nov 30, 2010 12:45:30 ActionTranslator.g 2010-12-10 19:30:29

package org.antlr.grammar.v3;
import java.util.ArrayList;
import java.util.List;

import org.antlr.codegen.CodeGenerator;
import org.antlr.grammar.v2.ANTLRParser;
import org.antlr.runtime3_3_0.ANTLRStringStream;
import org.antlr.runtime3_3_0.BaseRecognizer;
import org.antlr.runtime3_3_0.CharStream;
import org.antlr.runtime3_3_0.CommonToken;
import org.antlr.runtime3_3_0.DFA;
import org.antlr.runtime3_3_0.EarlyExitException;
import org.antlr.runtime3_3_0.FailedPredicateException;
import org.antlr.runtime3_3_0.IntStream;
import org.antlr.runtime3_3_0.Lexer;
import org.antlr.runtime3_3_0.MismatchedSetException;
import org.antlr.runtime3_3_0.NoViableAltException;
import org.antlr.runtime3_3_0.RecognitionException;
import org.antlr.runtime3_3_0.RecognizerSharedState;
import org.antlr.runtime3_3_0.Token;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.tool.Attribute;
import org.antlr.tool.AttributeScope;
import org.antlr.tool.ErrorManager;
import org.antlr.tool.Grammar;
import org.antlr.tool.GrammarAST;
import org.antlr.tool.Rule;
public class ActionTranslator extends Lexer {
    public static final int EOF=-1;
    public static final int ID=4;
    public static final int WS=5;
    public static final int ATTR_VALUE_EXPR=6;
    public static final int SET_ENCLOSING_RULE_SCOPE_ATTR=7;
    public static final int ENCLOSING_RULE_SCOPE_ATTR=8;
    public static final int SET_TOKEN_SCOPE_ATTR=9;
    public static final int TOKEN_SCOPE_ATTR=10;
    public static final int SET_RULE_SCOPE_ATTR=11;
    public static final int RULE_SCOPE_ATTR=12;
    public static final int LABEL_REF=13;
    public static final int ISOLATED_TOKEN_REF=14;
    public static final int ISOLATED_LEXER_RULE_REF=15;
    public static final int SET_LOCAL_ATTR=16;
    public static final int LOCAL_ATTR=17;
    public static final int SET_DYNAMIC_SCOPE_ATTR=18;
    public static final int DYNAMIC_SCOPE_ATTR=19;
    public static final int ERROR_SCOPED_XY=20;
    public static final int SCOPE_INDEX_EXPR=21;
    public static final int DYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR=22;
    public static final int DYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR=23;
    public static final int ISOLATED_DYNAMIC_SCOPE=24;
    public static final int ARG=25;
    public static final int TEMPLATE_INSTANCE=26;
    public static final int ACTION=27;
    public static final int INDIRECT_TEMPLATE_INSTANCE=28;
    public static final int SET_EXPR_ATTRIBUTE=29;
    public static final int SET_ATTRIBUTE=30;
    public static final int TEMPLATE_EXPR=31;
    public static final int ESC=32;
    public static final int ERROR_XY=33;
    public static final int ERROR_X=34;
    public static final int UNKNOWN_SYNTAX=35;
    public static final int TEXT=36;
    public static final int INT=37;

    public List chunks = new ArrayList();
    Rule enclosingRule;
    int outerAltNum;
    Grammar grammar;
    CodeGenerator generator;
    antlr.Token actionToken;

    	public ActionTranslator(CodeGenerator generator,
    								 String ruleName,
    								 GrammarAST actionAST)
    	{
    		this(new ANTLRStringStream(actionAST.token.getText()));
    		this.generator = generator;
    		this.grammar = generator.grammar;
    	    this.enclosingRule = grammar.getLocallyDefinedRule(ruleName);
    	    this.actionToken = actionAST.token;
    	    this.outerAltNum = actionAST.outerAltNum;
    	}

    	public ActionTranslator(CodeGenerator generator,
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
    	String rname = null;
    	if ( enclosingRule!=null ) {
    		rname = enclosingRule.name;
    	}
    	ActionTranslator translator =
    		new ActionTranslator(generator,
    								  rname,
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




    // delegates
    // delegators

    public ActionTranslator() {;} 
    public ActionTranslator(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public ActionTranslator(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "ActionTranslator.g"; }

    public Token nextToken() {
        while (true) {
            if ( input.LA(1)==CharStream.EOF ) {
                Token eof = new CommonToken((CharStream)input,Token.EOF,
                                            Token.DEFAULT_CHANNEL,
                                            input.index(),input.index());
                eof.setLine(getLine());
                eof.setCharPositionInLine(getCharPositionInLine());
                return eof;
            }
            state.token = null;
    	state.channel = Token.DEFAULT_CHANNEL;
            state.tokenStartCharIndex = input.index();
            state.tokenStartCharPositionInLine = input.getCharPositionInLine();
            state.tokenStartLine = input.getLine();
    	state.text = null;
            try {
                int m = input.mark();
                state.backtracking=1; 
                state.failed=false;
                mTokens();
                state.backtracking=0;

                if ( state.failed ) {
                    input.rewind(m);
                    input.consume(); 
                }
                else {
                    emit();
                    return state.token;
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
    if ( state.backtracking>1 ) super.memoize(input, ruleIndex, ruleStartIndex);
    }

    public boolean alreadyParsedRule(IntStream input, int ruleIndex) {
    if ( state.backtracking>1 ) return super.alreadyParsedRule(input, ruleIndex);
    return false;
    }// $ANTLR start "SET_ENCLOSING_RULE_SCOPE_ATTR"
    public final void mSET_ENCLOSING_RULE_SCOPE_ATTR() throws RecognitionException {
        try {
            int _type = SET_ENCLOSING_RULE_SCOPE_ATTR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken x=null;
            CommonToken y=null;
            CommonToken expr=null;

            // ActionTranslator.g:183:2: ( '$' x= ID '.' y= ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';' {...}?)
            // ActionTranslator.g:183:4: '$' x= ID '.' y= ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';' {...}?
            {
            match('$'); if (state.failed) return ;
            int xStart49 = getCharIndex();
            int xStartLine49 = getLine();
            int xStartCharPos49 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart49, getCharIndex()-1);
            x.setLine(xStartLine49);
            x.setCharPositionInLine(xStartCharPos49);
            match('.'); if (state.failed) return ;
            int yStart55 = getCharIndex();
            int yStartLine55 = getLine();
            int yStartCharPos55 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart55, getCharIndex()-1);
            y.setLine(yStartLine55);
            y.setCharPositionInLine(yStartCharPos55);
            // ActionTranslator.g:183:22: ( WS )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>='\t' && LA1_0<='\n')||LA1_0=='\r'||LA1_0==' ') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ActionTranslator.g:183:22: WS
                    {
                    mWS(); if (state.failed) return ;

                    }
                    break;

            }

            match('='); if (state.failed) return ;
            int exprStart64 = getCharIndex();
            int exprStartLine64 = getLine();
            int exprStartCharPos64 = getCharPositionInLine();
            mATTR_VALUE_EXPR(); if (state.failed) return ;
            expr = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, exprStart64, getCharIndex()-1);
            expr.setLine(exprStartLine64);
            expr.setCharPositionInLine(exprStartCharPos64);
            match(';'); if (state.failed) return ;
            if ( !((enclosingRule!=null &&
            	                         (x!=null?x.getText():null).equals(enclosingRule.name) &&
            	                         enclosingRule.getLocalAttributeScope((y!=null?y.getText():null))!=null)) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "SET_ENCLOSING_RULE_SCOPE_ATTR", "enclosingRule!=null &&\n\t                         $x.text.equals(enclosingRule.name) &&\n\t                         enclosingRule.getLocalAttributeScope($y.text)!=null");
            }
            if ( state.backtracking==1 ) {

              		StringTemplate st = null;
              		AttributeScope scope = enclosingRule.getLocalAttributeScope((y!=null?y.getText():null));
              		if ( scope.isPredefinedRuleScope ) {
              			if ( (y!=null?y.getText():null).equals("st") || (y!=null?y.getText():null).equals("tree") ) {
              				st = template("ruleSetPropertyRef_"+(y!=null?y.getText():null));
              				grammar.referenceRuleLabelPredefinedAttribute((x!=null?x.getText():null));
              				st.setAttribute("scope", (x!=null?x.getText():null));
              				st.setAttribute("attr", (y!=null?y.getText():null));
              				st.setAttribute("expr", translateAction((expr!=null?expr.getText():null)));
              			} else {
              				ErrorManager.grammarError(ErrorManager.MSG_WRITE_TO_READONLY_ATTR,
              										  grammar,
              										  actionToken,
              										  (x!=null?x.getText():null),
              										  (y!=null?y.getText():null));
              			}
              		}
              	    else if ( scope.isPredefinedLexerRuleScope ) {
              	    	// this is a better message to emit than the previous one...
              			ErrorManager.grammarError(ErrorManager.MSG_WRITE_TO_READONLY_ATTR,
              									  grammar,
              									  actionToken,
              									  (x!=null?x.getText():null),
              									  (y!=null?y.getText():null));
              	    }
              		else if ( scope.isParameterScope ) {
              			st = template("parameterSetAttributeRef");
              			st.setAttribute("attr", scope.getAttribute((y!=null?y.getText():null)));
              			st.setAttribute("expr", translateAction((expr!=null?expr.getText():null)));
              		}
              		else { // must be return value
              			st = template("returnSetAttributeRef");
              			st.setAttribute("ruleDescriptor", enclosingRule);
              			st.setAttribute("attr", scope.getAttribute((y!=null?y.getText():null)));
              			st.setAttribute("expr", translateAction((expr!=null?expr.getText():null)));
              		}
              		
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SET_ENCLOSING_RULE_SCOPE_ATTR"

    // $ANTLR start "ENCLOSING_RULE_SCOPE_ATTR"
    public final void mENCLOSING_RULE_SCOPE_ATTR() throws RecognitionException {
        try {
            int _type = ENCLOSING_RULE_SCOPE_ATTR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken x=null;
            CommonToken y=null;

            // ActionTranslator.g:228:2: ( '$' x= ID '.' y= ID {...}?)
            // ActionTranslator.g:228:4: '$' x= ID '.' y= ID {...}?
            {
            match('$'); if (state.failed) return ;
            int xStart96 = getCharIndex();
            int xStartLine96 = getLine();
            int xStartCharPos96 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart96, getCharIndex()-1);
            x.setLine(xStartLine96);
            x.setCharPositionInLine(xStartCharPos96);
            match('.'); if (state.failed) return ;
            int yStart102 = getCharIndex();
            int yStartLine102 = getLine();
            int yStartCharPos102 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart102, getCharIndex()-1);
            y.setLine(yStartLine102);
            y.setCharPositionInLine(yStartCharPos102);
            if ( !((enclosingRule!=null &&
            	                         (x!=null?x.getText():null).equals(enclosingRule.name) &&
            	                         enclosingRule.getLocalAttributeScope((y!=null?y.getText():null))!=null)) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "ENCLOSING_RULE_SCOPE_ATTR", "enclosingRule!=null &&\n\t                         $x.text.equals(enclosingRule.name) &&\n\t                         enclosingRule.getLocalAttributeScope($y.text)!=null");
            }
            if ( state.backtracking==1 ) {

              		if ( isRuleRefInAlt((x!=null?x.getText():null))  ) {
              			ErrorManager.grammarError(ErrorManager.MSG_RULE_REF_AMBIG_WITH_RULE_IN_ALT,
              									  grammar,
              									  actionToken,
              									  (x!=null?x.getText():null));
              		}
              		StringTemplate st = null;
              		AttributeScope scope = enclosingRule.getLocalAttributeScope((y!=null?y.getText():null));
              		if ( scope.isPredefinedRuleScope ) {
              			st = template("rulePropertyRef_"+(y!=null?y.getText():null));
              			grammar.referenceRuleLabelPredefinedAttribute((x!=null?x.getText():null));
              			st.setAttribute("scope", (x!=null?x.getText():null));
              			st.setAttribute("attr", (y!=null?y.getText():null));
              		}
              	    else if ( scope.isPredefinedLexerRuleScope ) {
              	    	// perhaps not the most precise error message to use, but...
              			ErrorManager.grammarError(ErrorManager.MSG_RULE_HAS_NO_ARGS,
              									  grammar,
              									  actionToken,
              									  (x!=null?x.getText():null));
              	    }
              		else if ( scope.isParameterScope ) {
              			st = template("parameterAttributeRef");
              			st.setAttribute("attr", scope.getAttribute((y!=null?y.getText():null)));
              		}
              		else { // must be return value
              			st = template("returnAttributeRef");
              			st.setAttribute("ruleDescriptor", enclosingRule);
              			st.setAttribute("attr", scope.getAttribute((y!=null?y.getText():null)));
              		}
              		
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENCLOSING_RULE_SCOPE_ATTR"

    // $ANTLR start "SET_TOKEN_SCOPE_ATTR"
    public final void mSET_TOKEN_SCOPE_ATTR() throws RecognitionException {
        try {
            int _type = SET_TOKEN_SCOPE_ATTR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken x=null;
            CommonToken y=null;

            // ActionTranslator.g:268:2: ( '$' x= ID '.' y= ID ( WS )? '=' {...}?)
            // ActionTranslator.g:268:4: '$' x= ID '.' y= ID ( WS )? '=' {...}?
            {
            match('$'); if (state.failed) return ;
            int xStart128 = getCharIndex();
            int xStartLine128 = getLine();
            int xStartCharPos128 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart128, getCharIndex()-1);
            x.setLine(xStartLine128);
            x.setCharPositionInLine(xStartCharPos128);
            match('.'); if (state.failed) return ;
            int yStart134 = getCharIndex();
            int yStartLine134 = getLine();
            int yStartCharPos134 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart134, getCharIndex()-1);
            y.setLine(yStartLine134);
            y.setCharPositionInLine(yStartCharPos134);
            // ActionTranslator.g:268:22: ( WS )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>='\t' && LA2_0<='\n')||LA2_0=='\r'||LA2_0==' ') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ActionTranslator.g:268:22: WS
                    {
                    mWS(); if (state.failed) return ;

                    }
                    break;

            }

            match('='); if (state.failed) return ;
            if ( !((enclosingRule!=null && input.LA(1)!='=' &&
            	                         (enclosingRule.getTokenLabel((x!=null?x.getText():null))!=null||
            	                          isTokenRefInAlt((x!=null?x.getText():null))) &&
            	                         AttributeScope.tokenScope.getAttribute((y!=null?y.getText():null))!=null)) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "SET_TOKEN_SCOPE_ATTR", "enclosingRule!=null && input.LA(1)!='=' &&\n\t                         (enclosingRule.getTokenLabel($x.text)!=null||\n\t                          isTokenRefInAlt($x.text)) &&\n\t                         AttributeScope.tokenScope.getAttribute($y.text)!=null");
            }
            if ( state.backtracking==1 ) {

              		ErrorManager.grammarError(ErrorManager.MSG_WRITE_TO_READONLY_ATTR,
              								  grammar,
              								  actionToken,
              								  (x!=null?x.getText():null),
              								  (y!=null?y.getText():null));
              		
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SET_TOKEN_SCOPE_ATTR"

    // $ANTLR start "TOKEN_SCOPE_ATTR"
    public final void mTOKEN_SCOPE_ATTR() throws RecognitionException {
        try {
            int _type = TOKEN_SCOPE_ATTR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken x=null;
            CommonToken y=null;

            // ActionTranslator.g:287:2: ( '$' x= ID '.' y= ID {...}?)
            // ActionTranslator.g:287:4: '$' x= ID '.' y= ID {...}?
            {
            match('$'); if (state.failed) return ;
            int xStart173 = getCharIndex();
            int xStartLine173 = getLine();
            int xStartCharPos173 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart173, getCharIndex()-1);
            x.setLine(xStartLine173);
            x.setCharPositionInLine(xStartCharPos173);
            match('.'); if (state.failed) return ;
            int yStart179 = getCharIndex();
            int yStartLine179 = getLine();
            int yStartCharPos179 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart179, getCharIndex()-1);
            y.setLine(yStartLine179);
            y.setCharPositionInLine(yStartCharPos179);
            if ( !((enclosingRule!=null &&
            	                         (enclosingRule.getTokenLabel((x!=null?x.getText():null))!=null||
            	                          isTokenRefInAlt((x!=null?x.getText():null))) &&
            	                         AttributeScope.tokenScope.getAttribute((y!=null?y.getText():null))!=null &&
            	                         (grammar.type!=Grammar.LEXER ||
            	                         getElementLabel((x!=null?x.getText():null)).elementRef.token.getType()==ANTLRParser.TOKEN_REF ||
            	                         getElementLabel((x!=null?x.getText():null)).elementRef.token.getType()==ANTLRParser.STRING_LITERAL))) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "TOKEN_SCOPE_ATTR", "enclosingRule!=null &&\n\t                         (enclosingRule.getTokenLabel($x.text)!=null||\n\t                          isTokenRefInAlt($x.text)) &&\n\t                         AttributeScope.tokenScope.getAttribute($y.text)!=null &&\n\t                         (grammar.type!=Grammar.LEXER ||\n\t                         getElementLabel($x.text).elementRef.token.getType()==ANTLRParser.TOKEN_REF ||\n\t                         getElementLabel($x.text).elementRef.token.getType()==ANTLRParser.STRING_LITERAL)");
            }
            if ( state.backtracking==1 ) {

              		String label = (x!=null?x.getText():null);
              		if ( enclosingRule.getTokenLabel((x!=null?x.getText():null))==null ) {
              			// $tokenref.attr  gotta get old label or compute new one
              			checkElementRefUniqueness((x!=null?x.getText():null), true);
              			label = enclosingRule.getElementLabel((x!=null?x.getText():null), outerAltNum, generator);
              			if ( label==null ) {
              				ErrorManager.grammarError(ErrorManager.MSG_FORWARD_ELEMENT_REF,
              										  grammar,
              										  actionToken,
              										  "$"+(x!=null?x.getText():null)+"."+(y!=null?y.getText():null));
              				label = (x!=null?x.getText():null);
              			}
              		}
              		StringTemplate st = template("tokenLabelPropertyRef_"+(y!=null?y.getText():null));
              		st.setAttribute("scope", label);
              		st.setAttribute("attr", AttributeScope.tokenScope.getAttribute((y!=null?y.getText():null)));
              		
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TOKEN_SCOPE_ATTR"

    // $ANTLR start "SET_RULE_SCOPE_ATTR"
    public final void mSET_RULE_SCOPE_ATTR() throws RecognitionException {
        try {
            int _type = SET_RULE_SCOPE_ATTR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken x=null;
            CommonToken y=null;


            Grammar.LabelElementPair pair=null;
            String refdRuleName=null;

            // ActionTranslator.g:325:2: ( '$' x= ID '.' y= ID ( WS )? '=' {...}?{...}?)
            // ActionTranslator.g:325:4: '$' x= ID '.' y= ID ( WS )? '=' {...}?{...}?
            {
            match('$'); if (state.failed) return ;
            int xStart210 = getCharIndex();
            int xStartLine210 = getLine();
            int xStartCharPos210 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart210, getCharIndex()-1);
            x.setLine(xStartLine210);
            x.setCharPositionInLine(xStartCharPos210);
            match('.'); if (state.failed) return ;
            int yStart216 = getCharIndex();
            int yStartLine216 = getLine();
            int yStartCharPos216 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart216, getCharIndex()-1);
            y.setLine(yStartLine216);
            y.setCharPositionInLine(yStartCharPos216);
            // ActionTranslator.g:325:22: ( WS )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>='\t' && LA3_0<='\n')||LA3_0=='\r'||LA3_0==' ') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ActionTranslator.g:325:22: WS
                    {
                    mWS(); if (state.failed) return ;

                    }
                    break;

            }

            match('='); if (state.failed) return ;
            if ( !((enclosingRule!=null && input.LA(1)!='=')) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "SET_RULE_SCOPE_ATTR", "enclosingRule!=null && input.LA(1)!='='");
            }
            if ( state.backtracking==1 ) {

              		pair = enclosingRule.getRuleLabel((x!=null?x.getText():null));
              		refdRuleName = (x!=null?x.getText():null);
              		if ( pair!=null ) {
              			refdRuleName = pair.referencedRuleName;
              		}
              		
            }
            if ( !(((enclosingRule.getRuleLabel((x!=null?x.getText():null))!=null || isRuleRefInAlt((x!=null?x.getText():null))) &&
            	      getRuleLabelAttribute(enclosingRule.getRuleLabel((x!=null?x.getText():null))!=null?enclosingRule.getRuleLabel((x!=null?x.getText():null)).referencedRuleName:(x!=null?x.getText():null),(y!=null?y.getText():null))!=null)) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "SET_RULE_SCOPE_ATTR", "(enclosingRule.getRuleLabel($x.text)!=null || isRuleRefInAlt($x.text)) &&\n\t      getRuleLabelAttribute(enclosingRule.getRuleLabel($x.text)!=null?enclosingRule.getRuleLabel($x.text).referencedRuleName:$x.text,$y.text)!=null");
            }
            if ( state.backtracking==1 ) {

              		ErrorManager.grammarError(ErrorManager.MSG_WRITE_TO_READONLY_ATTR,
              								  grammar,
              								  actionToken,
              								  (x!=null?x.getText():null),
              								  (y!=null?y.getText():null));
              		
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SET_RULE_SCOPE_ATTR"

    // $ANTLR start "RULE_SCOPE_ATTR"
    public final void mRULE_SCOPE_ATTR() throws RecognitionException {
        try {
            int _type = RULE_SCOPE_ATTR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken x=null;
            CommonToken y=null;


            Grammar.LabelElementPair pair=null;
            String refdRuleName=null;

            // ActionTranslator.g:354:2: ( '$' x= ID '.' y= ID {...}?{...}?)
            // ActionTranslator.g:354:4: '$' x= ID '.' y= ID {...}?{...}?
            {
            match('$'); if (state.failed) return ;
            int xStart269 = getCharIndex();
            int xStartLine269 = getLine();
            int xStartCharPos269 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart269, getCharIndex()-1);
            x.setLine(xStartLine269);
            x.setCharPositionInLine(xStartCharPos269);
            match('.'); if (state.failed) return ;
            int yStart275 = getCharIndex();
            int yStartLine275 = getLine();
            int yStartCharPos275 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart275, getCharIndex()-1);
            y.setLine(yStartLine275);
            y.setCharPositionInLine(yStartCharPos275);
            if ( !((enclosingRule!=null)) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "RULE_SCOPE_ATTR", "enclosingRule!=null");
            }
            if ( state.backtracking==1 ) {

              		pair = enclosingRule.getRuleLabel((x!=null?x.getText():null));
              		refdRuleName = (x!=null?x.getText():null);
              		if ( pair!=null ) {
              			refdRuleName = pair.referencedRuleName;
              		}
              		
            }
            if ( !(((enclosingRule.getRuleLabel((x!=null?x.getText():null))!=null || isRuleRefInAlt((x!=null?x.getText():null))) &&
            	      getRuleLabelAttribute(enclosingRule.getRuleLabel((x!=null?x.getText():null))!=null?enclosingRule.getRuleLabel((x!=null?x.getText():null)).referencedRuleName:(x!=null?x.getText():null),(y!=null?y.getText():null))!=null)) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "RULE_SCOPE_ATTR", "(enclosingRule.getRuleLabel($x.text)!=null || isRuleRefInAlt($x.text)) &&\n\t      getRuleLabelAttribute(enclosingRule.getRuleLabel($x.text)!=null?enclosingRule.getRuleLabel($x.text).referencedRuleName:$x.text,$y.text)!=null");
            }
            if ( state.backtracking==1 ) {

              		String label = (x!=null?x.getText():null);
              		if ( pair==null ) {
              			// $ruleref.attr  gotta get old label or compute new one
              			checkElementRefUniqueness((x!=null?x.getText():null), false);
              			label = enclosingRule.getElementLabel((x!=null?x.getText():null), outerAltNum, generator);
              			if ( label==null ) {
              				ErrorManager.grammarError(ErrorManager.MSG_FORWARD_ELEMENT_REF,
              										  grammar,
              										  actionToken,
              										  "$"+(x!=null?x.getText():null)+"."+(y!=null?y.getText():null));
              				label = (x!=null?x.getText():null);
              			}
              		}
              		StringTemplate st;
              		Rule refdRule = grammar.getRule(refdRuleName);
              		AttributeScope scope = refdRule.getLocalAttributeScope((y!=null?y.getText():null));
              		if ( scope.isPredefinedRuleScope ) {
              			st = template("ruleLabelPropertyRef_"+(y!=null?y.getText():null));
              			grammar.referenceRuleLabelPredefinedAttribute(refdRuleName);
              			st.setAttribute("scope", label);
              			st.setAttribute("attr", (y!=null?y.getText():null));
              		}
              		else if ( scope.isPredefinedLexerRuleScope ) {
              			st = template("lexerRuleLabelPropertyRef_"+(y!=null?y.getText():null));
              			grammar.referenceRuleLabelPredefinedAttribute(refdRuleName);
              			st.setAttribute("scope", label);
              			st.setAttribute("attr", (y!=null?y.getText():null));
              		}
              		else if ( scope.isParameterScope ) {
              			// TODO: error!
              		}
              		else {
              			st = template("ruleLabelRef");
              			st.setAttribute("referencedRule", refdRule);
              			st.setAttribute("scope", label);
              			st.setAttribute("attr", scope.getAttribute((y!=null?y.getText():null)));
              		}
              		
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SCOPE_ATTR"

    // $ANTLR start "LABEL_REF"
    public final void mLABEL_REF() throws RecognitionException {
        try {
            int _type = LABEL_REF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken ID1=null;

            // ActionTranslator.g:412:2: ( '$' ID {...}?)
            // ActionTranslator.g:412:4: '$' ID {...}?
            {
            match('$'); if (state.failed) return ;
            int ID1Start317 = getCharIndex();
            int ID1StartLine317 = getLine();
            int ID1StartCharPos317 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            ID1 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, ID1Start317, getCharIndex()-1);
            ID1.setLine(ID1StartLine317);
            ID1.setCharPositionInLine(ID1StartCharPos317);
            if ( !((enclosingRule!=null &&
            	            getElementLabel((ID1!=null?ID1.getText():null))!=null &&
            		        enclosingRule.getRuleLabel((ID1!=null?ID1.getText():null))==null)) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "LABEL_REF", "enclosingRule!=null &&\n\t            getElementLabel($ID.text)!=null &&\n\t\t        enclosingRule.getRuleLabel($ID.text)==null");
            }
            if ( state.backtracking==1 ) {

              		StringTemplate st;
              		Grammar.LabelElementPair pair = getElementLabel((ID1!=null?ID1.getText():null));
              		if ( pair.type==Grammar.RULE_LIST_LABEL ||
                           pair.type==Grammar.TOKEN_LIST_LABEL ||
                           pair.type==Grammar.WILDCARD_TREE_LIST_LABEL )
                      {
              			st = template("listLabelRef");
              		}
              		else {
              			st = template("tokenLabelRef");
              		}
              		st.setAttribute("label", (ID1!=null?ID1.getText():null));
              		
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LABEL_REF"

    // $ANTLR start "ISOLATED_TOKEN_REF"
    public final void mISOLATED_TOKEN_REF() throws RecognitionException {
        try {
            int _type = ISOLATED_TOKEN_REF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken ID2=null;

            // ActionTranslator.g:434:2: ( '$' ID {...}?)
            // ActionTranslator.g:434:4: '$' ID {...}?
            {
            match('$'); if (state.failed) return ;
            int ID2Start341 = getCharIndex();
            int ID2StartLine341 = getLine();
            int ID2StartCharPos341 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            ID2 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, ID2Start341, getCharIndex()-1);
            ID2.setLine(ID2StartLine341);
            ID2.setCharPositionInLine(ID2StartCharPos341);
            if ( !((grammar.type!=Grammar.LEXER && enclosingRule!=null && isTokenRefInAlt((ID2!=null?ID2.getText():null)))) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "ISOLATED_TOKEN_REF", "grammar.type!=Grammar.LEXER && enclosingRule!=null && isTokenRefInAlt($ID.text)");
            }
            if ( state.backtracking==1 ) {

              		String label = enclosingRule.getElementLabel((ID2!=null?ID2.getText():null), outerAltNum, generator);
              		checkElementRefUniqueness((ID2!=null?ID2.getText():null), true);
              		if ( label==null ) {
              			ErrorManager.grammarError(ErrorManager.MSG_FORWARD_ELEMENT_REF,
              									  grammar,
              									  actionToken,
              									  (ID2!=null?ID2.getText():null));
              		}
              		else {
              			StringTemplate st = template("tokenLabelRef");
              			st.setAttribute("label", label);
              		}
              		
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ISOLATED_TOKEN_REF"

    // $ANTLR start "ISOLATED_LEXER_RULE_REF"
    public final void mISOLATED_LEXER_RULE_REF() throws RecognitionException {
        try {
            int _type = ISOLATED_LEXER_RULE_REF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken ID3=null;

            // ActionTranslator.g:454:2: ( '$' ID {...}?)
            // ActionTranslator.g:454:4: '$' ID {...}?
            {
            match('$'); if (state.failed) return ;
            int ID3Start365 = getCharIndex();
            int ID3StartLine365 = getLine();
            int ID3StartCharPos365 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            ID3 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, ID3Start365, getCharIndex()-1);
            ID3.setLine(ID3StartLine365);
            ID3.setCharPositionInLine(ID3StartCharPos365);
            if ( !((grammar.type==Grammar.LEXER &&
            	             enclosingRule!=null &&
            	             isRuleRefInAlt((ID3!=null?ID3.getText():null)))) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "ISOLATED_LEXER_RULE_REF", "grammar.type==Grammar.LEXER &&\n\t             enclosingRule!=null &&\n\t             isRuleRefInAlt($ID.text)");
            }
            if ( state.backtracking==1 ) {

              		String label = enclosingRule.getElementLabel((ID3!=null?ID3.getText():null), outerAltNum, generator);
              		checkElementRefUniqueness((ID3!=null?ID3.getText():null), false);
              		if ( label==null ) {
              			ErrorManager.grammarError(ErrorManager.MSG_FORWARD_ELEMENT_REF,
              									  grammar,
              									  actionToken,
              									  (ID3!=null?ID3.getText():null));
              		}
              		else {
              			StringTemplate st = template("lexerRuleLabel");
              			st.setAttribute("label", label);
              		}
              		
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ISOLATED_LEXER_RULE_REF"

    // $ANTLR start "SET_LOCAL_ATTR"
    public final void mSET_LOCAL_ATTR() throws RecognitionException {
        try {
            int _type = SET_LOCAL_ATTR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken expr=null;
            CommonToken ID4=null;

            // ActionTranslator.g:486:2: ( '$' ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';' {...}?)
            // ActionTranslator.g:486:4: '$' ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';' {...}?
            {
            match('$'); if (state.failed) return ;
            int ID4Start389 = getCharIndex();
            int ID4StartLine389 = getLine();
            int ID4StartCharPos389 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            ID4 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, ID4Start389, getCharIndex()-1);
            ID4.setLine(ID4StartLine389);
            ID4.setCharPositionInLine(ID4StartCharPos389);
            // ActionTranslator.g:486:11: ( WS )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>='\t' && LA4_0<='\n')||LA4_0=='\r'||LA4_0==' ') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ActionTranslator.g:486:11: WS
                    {
                    mWS(); if (state.failed) return ;

                    }
                    break;

            }

            match('='); if (state.failed) return ;
            int exprStart398 = getCharIndex();
            int exprStartLine398 = getLine();
            int exprStartCharPos398 = getCharPositionInLine();
            mATTR_VALUE_EXPR(); if (state.failed) return ;
            expr = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, exprStart398, getCharIndex()-1);
            expr.setLine(exprStartLine398);
            expr.setCharPositionInLine(exprStartCharPos398);
            match(';'); if (state.failed) return ;
            if ( !((enclosingRule!=null
            													&& enclosingRule.getLocalAttributeScope((ID4!=null?ID4.getText():null))!=null
            													&& !enclosingRule.getLocalAttributeScope((ID4!=null?ID4.getText():null)).isPredefinedLexerRuleScope)) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "SET_LOCAL_ATTR", "enclosingRule!=null\n\t\t\t\t\t\t\t\t\t\t\t\t\t&& enclosingRule.getLocalAttributeScope($ID.text)!=null\n\t\t\t\t\t\t\t\t\t\t\t\t\t&& !enclosingRule.getLocalAttributeScope($ID.text).isPredefinedLexerRuleScope");
            }
            if ( state.backtracking==1 ) {

              		StringTemplate st;
              		AttributeScope scope = enclosingRule.getLocalAttributeScope((ID4!=null?ID4.getText():null));
              		if ( scope.isPredefinedRuleScope ) {
              			if ((ID4!=null?ID4.getText():null).equals("tree") || (ID4!=null?ID4.getText():null).equals("st")) {
              				st = template("ruleSetPropertyRef_"+(ID4!=null?ID4.getText():null));
              				grammar.referenceRuleLabelPredefinedAttribute(enclosingRule.name);
              				st.setAttribute("scope", enclosingRule.name);
              				st.setAttribute("attr", (ID4!=null?ID4.getText():null));
              				st.setAttribute("expr", translateAction((expr!=null?expr.getText():null)));
              			} else {
              				ErrorManager.grammarError(ErrorManager.MSG_WRITE_TO_READONLY_ATTR,
              										 grammar,
              										 actionToken,
              										 (ID4!=null?ID4.getText():null),
              										 "");
              			}
              		}
              		else if ( scope.isParameterScope ) {
              			st = template("parameterSetAttributeRef");
              			st.setAttribute("attr", scope.getAttribute((ID4!=null?ID4.getText():null)));
              			st.setAttribute("expr", translateAction((expr!=null?expr.getText():null)));
              		}
              		else {
              			st = template("returnSetAttributeRef");
              			st.setAttribute("ruleDescriptor", enclosingRule);
              			st.setAttribute("attr", scope.getAttribute((ID4!=null?ID4.getText():null)));
              			st.setAttribute("expr", translateAction((expr!=null?expr.getText():null)));
              			}
              		
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SET_LOCAL_ATTR"

    // $ANTLR start "LOCAL_ATTR"
    public final void mLOCAL_ATTR() throws RecognitionException {
        try {
            int _type = LOCAL_ATTR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken ID5=null;

            // ActionTranslator.g:522:2: ( '$' ID {...}?)
            // ActionTranslator.g:522:4: '$' ID {...}?
            {
            match('$'); if (state.failed) return ;
            int ID5Start421 = getCharIndex();
            int ID5StartLine421 = getLine();
            int ID5StartCharPos421 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            ID5 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, ID5Start421, getCharIndex()-1);
            ID5.setLine(ID5StartLine421);
            ID5.setCharPositionInLine(ID5StartCharPos421);
            if ( !((enclosingRule!=null && enclosingRule.getLocalAttributeScope((ID5!=null?ID5.getText():null))!=null)) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "LOCAL_ATTR", "enclosingRule!=null && enclosingRule.getLocalAttributeScope($ID.text)!=null");
            }
            if ( state.backtracking==1 ) {

              		StringTemplate st;
              		AttributeScope scope = enclosingRule.getLocalAttributeScope((ID5!=null?ID5.getText():null));
              		if ( scope.isPredefinedRuleScope ) {
              			st = template("rulePropertyRef_"+(ID5!=null?ID5.getText():null));
              			grammar.referenceRuleLabelPredefinedAttribute(enclosingRule.name);
              			st.setAttribute("scope", enclosingRule.name);
              			st.setAttribute("attr", (ID5!=null?ID5.getText():null));
              		}
              		else if ( scope.isPredefinedLexerRuleScope ) {
              			st = template("lexerRulePropertyRef_"+(ID5!=null?ID5.getText():null));
              			st.setAttribute("scope", enclosingRule.name);
              			st.setAttribute("attr", (ID5!=null?ID5.getText():null));
              		}
              		else if ( scope.isParameterScope ) {
              			st = template("parameterAttributeRef");
              			st.setAttribute("attr", scope.getAttribute((ID5!=null?ID5.getText():null)));
              		}
              		else {
              			st = template("returnAttributeRef");
              			st.setAttribute("ruleDescriptor", enclosingRule);
              			st.setAttribute("attr", scope.getAttribute((ID5!=null?ID5.getText():null)));
              		}
              		
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LOCAL_ATTR"

    // $ANTLR start "SET_DYNAMIC_SCOPE_ATTR"
    public final void mSET_DYNAMIC_SCOPE_ATTR() throws RecognitionException {
        try {
            int _type = SET_DYNAMIC_SCOPE_ATTR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken x=null;
            CommonToken y=null;
            CommonToken expr=null;

            // ActionTranslator.g:563:2: ( '$' x= ID '::' y= ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';' {...}?)
            // ActionTranslator.g:563:4: '$' x= ID '::' y= ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';' {...}?
            {
            match('$'); if (state.failed) return ;
            int xStart447 = getCharIndex();
            int xStartLine447 = getLine();
            int xStartCharPos447 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart447, getCharIndex()-1);
            x.setLine(xStartLine447);
            x.setCharPositionInLine(xStartCharPos447);
            match("::"); if (state.failed) return ;

            int yStart453 = getCharIndex();
            int yStartLine453 = getLine();
            int yStartCharPos453 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart453, getCharIndex()-1);
            y.setLine(yStartLine453);
            y.setCharPositionInLine(yStartCharPos453);
            // ActionTranslator.g:563:23: ( WS )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>='\t' && LA5_0<='\n')||LA5_0=='\r'||LA5_0==' ') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ActionTranslator.g:563:23: WS
                    {
                    mWS(); if (state.failed) return ;

                    }
                    break;

            }

            match('='); if (state.failed) return ;
            int exprStart462 = getCharIndex();
            int exprStartLine462 = getLine();
            int exprStartCharPos462 = getCharPositionInLine();
            mATTR_VALUE_EXPR(); if (state.failed) return ;
            expr = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, exprStart462, getCharIndex()-1);
            expr.setLine(exprStartLine462);
            expr.setCharPositionInLine(exprStartCharPos462);
            match(';'); if (state.failed) return ;
            if ( !((resolveDynamicScope((x!=null?x.getText():null))!=null &&
            						     resolveDynamicScope((x!=null?x.getText():null)).getAttribute((y!=null?y.getText():null))!=null)) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "SET_DYNAMIC_SCOPE_ATTR", "resolveDynamicScope($x.text)!=null &&\n\t\t\t\t\t\t     resolveDynamicScope($x.text).getAttribute($y.text)!=null");
            }
            if ( state.backtracking==1 ) {

              		AttributeScope scope = resolveDynamicScope((x!=null?x.getText():null));
              		if ( scope!=null ) {
              			StringTemplate st = template("scopeSetAttributeRef");
              			st.setAttribute("scope", (x!=null?x.getText():null));
              			st.setAttribute("attr",  scope.getAttribute((y!=null?y.getText():null)));
              			st.setAttribute("expr",  translateAction((expr!=null?expr.getText():null)));
              		}
              		else {
              			// error: invalid dynamic attribute
              		}
              		
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SET_DYNAMIC_SCOPE_ATTR"

    // $ANTLR start "DYNAMIC_SCOPE_ATTR"
    public final void mDYNAMIC_SCOPE_ATTR() throws RecognitionException {
        try {
            int _type = DYNAMIC_SCOPE_ATTR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken x=null;
            CommonToken y=null;

            // ActionTranslator.g:582:2: ( '$' x= ID '::' y= ID {...}?)
            // ActionTranslator.g:582:4: '$' x= ID '::' y= ID {...}?
            {
            match('$'); if (state.failed) return ;
            int xStart497 = getCharIndex();
            int xStartLine497 = getLine();
            int xStartCharPos497 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart497, getCharIndex()-1);
            x.setLine(xStartLine497);
            x.setCharPositionInLine(xStartCharPos497);
            match("::"); if (state.failed) return ;

            int yStart503 = getCharIndex();
            int yStartLine503 = getLine();
            int yStartCharPos503 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart503, getCharIndex()-1);
            y.setLine(yStartLine503);
            y.setCharPositionInLine(yStartCharPos503);
            if ( !((resolveDynamicScope((x!=null?x.getText():null))!=null &&
            						     resolveDynamicScope((x!=null?x.getText():null)).getAttribute((y!=null?y.getText():null))!=null)) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "DYNAMIC_SCOPE_ATTR", "resolveDynamicScope($x.text)!=null &&\n\t\t\t\t\t\t     resolveDynamicScope($x.text).getAttribute($y.text)!=null");
            }
            if ( state.backtracking==1 ) {

              		AttributeScope scope = resolveDynamicScope((x!=null?x.getText():null));
              		if ( scope!=null ) {
              			StringTemplate st = template("scopeAttributeRef");
              			st.setAttribute("scope", (x!=null?x.getText():null));
              			st.setAttribute("attr",  scope.getAttribute((y!=null?y.getText():null)));
              		}
              		else {
              			// error: invalid dynamic attribute
              		}
              		
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DYNAMIC_SCOPE_ATTR"

    // $ANTLR start "ERROR_SCOPED_XY"
    public final void mERROR_SCOPED_XY() throws RecognitionException {
        try {
            int _type = ERROR_SCOPED_XY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken x=null;
            CommonToken y=null;

            // ActionTranslator.g:601:2: ( '$' x= ID '::' y= ID )
            // ActionTranslator.g:601:4: '$' x= ID '::' y= ID
            {
            match('$'); if (state.failed) return ;
            int xStart537 = getCharIndex();
            int xStartLine537 = getLine();
            int xStartCharPos537 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart537, getCharIndex()-1);
            x.setLine(xStartLine537);
            x.setCharPositionInLine(xStartCharPos537);
            match("::"); if (state.failed) return ;

            int yStart543 = getCharIndex();
            int yStartLine543 = getLine();
            int yStartCharPos543 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart543, getCharIndex()-1);
            y.setLine(yStartLine543);
            y.setCharPositionInLine(yStartCharPos543);
            if ( state.backtracking==1 ) {

              		chunks.add(getText());
              		generator.issueInvalidScopeError((x!=null?x.getText():null),(y!=null?y.getText():null),
              		                                 enclosingRule,actionToken,
              		                                 outerAltNum);		
              		
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ERROR_SCOPED_XY"

    // $ANTLR start "DYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR"
    public final void mDYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR() throws RecognitionException {
        try {
            int _type = DYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken x=null;
            CommonToken expr=null;
            CommonToken y=null;

            // ActionTranslator.g:619:2: ( '$' x= ID '[' '-' expr= SCOPE_INDEX_EXPR ']' '::' y= ID )
            // ActionTranslator.g:619:4: '$' x= ID '[' '-' expr= SCOPE_INDEX_EXPR ']' '::' y= ID
            {
            match('$'); if (state.failed) return ;
            int xStart565 = getCharIndex();
            int xStartLine565 = getLine();
            int xStartCharPos565 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart565, getCharIndex()-1);
            x.setLine(xStartLine565);
            x.setCharPositionInLine(xStartCharPos565);
            match('['); if (state.failed) return ;
            match('-'); if (state.failed) return ;
            int exprStart573 = getCharIndex();
            int exprStartLine573 = getLine();
            int exprStartCharPos573 = getCharPositionInLine();
            mSCOPE_INDEX_EXPR(); if (state.failed) return ;
            expr = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, exprStart573, getCharIndex()-1);
            expr.setLine(exprStartLine573);
            expr.setCharPositionInLine(exprStartCharPos573);
            match(']'); if (state.failed) return ;
            match("::"); if (state.failed) return ;

            int yStart581 = getCharIndex();
            int yStartLine581 = getLine();
            int yStartCharPos581 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart581, getCharIndex()-1);
            y.setLine(yStartLine581);
            y.setCharPositionInLine(yStartCharPos581);
            if ( state.backtracking==1 ) {

              		StringTemplate st = template("scopeAttributeRef");
              		st.setAttribute("scope",    (x!=null?x.getText():null));
              		st.setAttribute("attr",     resolveDynamicScope((x!=null?x.getText():null)).getAttribute((y!=null?y.getText():null)));
              		st.setAttribute("negIndex", (expr!=null?expr.getText():null));
              		
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR"

    // $ANTLR start "DYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR"
    public final void mDYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR() throws RecognitionException {
        try {
            int _type = DYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken x=null;
            CommonToken expr=null;
            CommonToken y=null;

            // ActionTranslator.g:630:2: ( '$' x= ID '[' expr= SCOPE_INDEX_EXPR ']' '::' y= ID )
            // ActionTranslator.g:630:4: '$' x= ID '[' expr= SCOPE_INDEX_EXPR ']' '::' y= ID
            {
            match('$'); if (state.failed) return ;
            int xStart605 = getCharIndex();
            int xStartLine605 = getLine();
            int xStartCharPos605 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart605, getCharIndex()-1);
            x.setLine(xStartLine605);
            x.setCharPositionInLine(xStartCharPos605);
            match('['); if (state.failed) return ;
            int exprStart611 = getCharIndex();
            int exprStartLine611 = getLine();
            int exprStartCharPos611 = getCharPositionInLine();
            mSCOPE_INDEX_EXPR(); if (state.failed) return ;
            expr = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, exprStart611, getCharIndex()-1);
            expr.setLine(exprStartLine611);
            expr.setCharPositionInLine(exprStartCharPos611);
            match(']'); if (state.failed) return ;
            match("::"); if (state.failed) return ;

            int yStart619 = getCharIndex();
            int yStartLine619 = getLine();
            int yStartCharPos619 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart619, getCharIndex()-1);
            y.setLine(yStartLine619);
            y.setCharPositionInLine(yStartCharPos619);
            if ( state.backtracking==1 ) {

              		StringTemplate st = template("scopeAttributeRef");
              		st.setAttribute("scope", (x!=null?x.getText():null));
              		st.setAttribute("attr",  resolveDynamicScope((x!=null?x.getText():null)).getAttribute((y!=null?y.getText():null)));
              		st.setAttribute("index", (expr!=null?expr.getText():null));
              		
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR"

    // $ANTLR start "SCOPE_INDEX_EXPR"
    public final void mSCOPE_INDEX_EXPR() throws RecognitionException {
        try {
            // ActionTranslator.g:642:2: ( (~ ']' )+ )
            // ActionTranslator.g:642:4: (~ ']' )+
            {
            // ActionTranslator.g:642:4: (~ ']' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\u0000' && LA6_0<='\\')||(LA6_0>='^' && LA6_0<='\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ActionTranslator.g:642:5: ~ ']'
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\\')||(input.LA(1)>='^' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "SCOPE_INDEX_EXPR"

    // $ANTLR start "ISOLATED_DYNAMIC_SCOPE"
    public final void mISOLATED_DYNAMIC_SCOPE() throws RecognitionException {
        try {
            int _type = ISOLATED_DYNAMIC_SCOPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken ID6=null;

            // ActionTranslator.g:651:2: ( '$' ID {...}?)
            // ActionTranslator.g:651:4: '$' ID {...}?
            {
            match('$'); if (state.failed) return ;
            int ID6Start662 = getCharIndex();
            int ID6StartLine662 = getLine();
            int ID6StartCharPos662 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            ID6 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, ID6Start662, getCharIndex()-1);
            ID6.setLine(ID6StartLine662);
            ID6.setCharPositionInLine(ID6StartCharPos662);
            if ( !((resolveDynamicScope((ID6!=null?ID6.getText():null))!=null)) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "ISOLATED_DYNAMIC_SCOPE", "resolveDynamicScope($ID.text)!=null");
            }
            if ( state.backtracking==1 ) {

              		StringTemplate st = template("isolatedDynamicScopeRef");
              		st.setAttribute("scope", (ID6!=null?ID6.getText():null));
              		
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ISOLATED_DYNAMIC_SCOPE"

    // $ANTLR start "TEMPLATE_INSTANCE"
    public final void mTEMPLATE_INSTANCE() throws RecognitionException {
        try {
            int _type = TEMPLATE_INSTANCE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ActionTranslator.g:664:2: ( '%' ID '(' ( ( WS )? ARG ( ',' ( WS )? ARG )* ( WS )? )? ')' )
            // ActionTranslator.g:664:4: '%' ID '(' ( ( WS )? ARG ( ',' ( WS )? ARG )* ( WS )? )? ')'
            {
            match('%'); if (state.failed) return ;
            mID(); if (state.failed) return ;
            match('('); if (state.failed) return ;
            // ActionTranslator.g:664:15: ( ( WS )? ARG ( ',' ( WS )? ARG )* ( WS )? )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' '||(LA11_0>='A' && LA11_0<='Z')||LA11_0=='_'||(LA11_0>='a' && LA11_0<='z')) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ActionTranslator.g:664:17: ( WS )? ARG ( ',' ( WS )? ARG )* ( WS )?
                    {
                    // ActionTranslator.g:664:17: ( WS )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( ((LA7_0>='\t' && LA7_0<='\n')||LA7_0=='\r'||LA7_0==' ') ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // ActionTranslator.g:664:17: WS
                            {
                            mWS(); if (state.failed) return ;

                            }
                            break;

                    }

                    mARG(); if (state.failed) return ;
                    // ActionTranslator.g:664:25: ( ',' ( WS )? ARG )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==',') ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ActionTranslator.g:664:26: ',' ( WS )? ARG
                    	    {
                    	    match(','); if (state.failed) return ;
                    	    // ActionTranslator.g:664:30: ( WS )?
                    	    int alt8=2;
                    	    int LA8_0 = input.LA(1);

                    	    if ( ((LA8_0>='\t' && LA8_0<='\n')||LA8_0=='\r'||LA8_0==' ') ) {
                    	        alt8=1;
                    	    }
                    	    switch (alt8) {
                    	        case 1 :
                    	            // ActionTranslator.g:664:30: WS
                    	            {
                    	            mWS(); if (state.failed) return ;

                    	            }
                    	            break;

                    	    }

                    	    mARG(); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    // ActionTranslator.g:664:40: ( WS )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( ((LA10_0>='\t' && LA10_0<='\n')||LA10_0=='\r'||LA10_0==' ') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ActionTranslator.g:664:40: WS
                            {
                            mWS(); if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;

            }

            match(')'); if (state.failed) return ;
            if ( state.backtracking==1 ) {

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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TEMPLATE_INSTANCE"

    // $ANTLR start "INDIRECT_TEMPLATE_INSTANCE"
    public final void mINDIRECT_TEMPLATE_INSTANCE() throws RecognitionException {
        try {
            int _type = INDIRECT_TEMPLATE_INSTANCE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ActionTranslator.g:685:2: ( '%' '(' ACTION ')' '(' ( ( WS )? ARG ( ',' ( WS )? ARG )* ( WS )? )? ')' )
            // ActionTranslator.g:685:4: '%' '(' ACTION ')' '(' ( ( WS )? ARG ( ',' ( WS )? ARG )* ( WS )? )? ')'
            {
            match('%'); if (state.failed) return ;
            match('('); if (state.failed) return ;
            mACTION(); if (state.failed) return ;
            match(')'); if (state.failed) return ;
            match('('); if (state.failed) return ;
            // ActionTranslator.g:685:27: ( ( WS )? ARG ( ',' ( WS )? ARG )* ( WS )? )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>='\t' && LA16_0<='\n')||LA16_0=='\r'||LA16_0==' '||(LA16_0>='A' && LA16_0<='Z')||LA16_0=='_'||(LA16_0>='a' && LA16_0<='z')) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ActionTranslator.g:685:29: ( WS )? ARG ( ',' ( WS )? ARG )* ( WS )?
                    {
                    // ActionTranslator.g:685:29: ( WS )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // ActionTranslator.g:685:29: WS
                            {
                            mWS(); if (state.failed) return ;

                            }
                            break;

                    }

                    mARG(); if (state.failed) return ;
                    // ActionTranslator.g:685:37: ( ',' ( WS )? ARG )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==',') ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ActionTranslator.g:685:38: ',' ( WS )? ARG
                    	    {
                    	    match(','); if (state.failed) return ;
                    	    // ActionTranslator.g:685:42: ( WS )?
                    	    int alt13=2;
                    	    int LA13_0 = input.LA(1);

                    	    if ( ((LA13_0>='\t' && LA13_0<='\n')||LA13_0=='\r'||LA13_0==' ') ) {
                    	        alt13=1;
                    	    }
                    	    switch (alt13) {
                    	        case 1 :
                    	            // ActionTranslator.g:685:42: WS
                    	            {
                    	            mWS(); if (state.failed) return ;

                    	            }
                    	            break;

                    	    }

                    	    mARG(); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    // ActionTranslator.g:685:52: ( WS )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( ((LA15_0>='\t' && LA15_0<='\n')||LA15_0=='\r'||LA15_0==' ') ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // ActionTranslator.g:685:52: WS
                            {
                            mWS(); if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;

            }

            match(')'); if (state.failed) return ;
            if ( state.backtracking==1 ) {

              		String action = getText().substring(1,getText().length());
              		StringTemplate st =
              			generator.translateTemplateConstructor(enclosingRule.name,
              												   outerAltNum,
              												   actionToken,
              												   action);
              		chunks.add(st);
              		
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INDIRECT_TEMPLATE_INSTANCE"

    // $ANTLR start "ARG"
    public final void mARG() throws RecognitionException {
        try {
            // ActionTranslator.g:699:5: ( ID '=' ACTION )
            // ActionTranslator.g:699:7: ID '=' ACTION
            {
            mID(); if (state.failed) return ;
            match('='); if (state.failed) return ;
            mACTION(); if (state.failed) return ;

            }

        }
        finally {
        }
    }
    // $ANTLR end "ARG"

    // $ANTLR start "SET_EXPR_ATTRIBUTE"
    public final void mSET_EXPR_ATTRIBUTE() throws RecognitionException {
        try {
            int _type = SET_EXPR_ATTRIBUTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken a=null;
            CommonToken expr=null;
            CommonToken ID7=null;

            // ActionTranslator.g:704:2: ( '%' a= ACTION '.' ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';' )
            // ActionTranslator.g:704:4: '%' a= ACTION '.' ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';'
            {
            match('%'); if (state.failed) return ;
            int aStart812 = getCharIndex();
            int aStartLine812 = getLine();
            int aStartCharPos812 = getCharPositionInLine();
            mACTION(); if (state.failed) return ;
            a = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, aStart812, getCharIndex()-1);
            a.setLine(aStartLine812);
            a.setCharPositionInLine(aStartCharPos812);
            match('.'); if (state.failed) return ;
            int ID7Start816 = getCharIndex();
            int ID7StartLine816 = getLine();
            int ID7StartCharPos816 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            ID7 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, ID7Start816, getCharIndex()-1);
            ID7.setLine(ID7StartLine816);
            ID7.setCharPositionInLine(ID7StartCharPos816);
            // ActionTranslator.g:704:24: ( WS )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>='\t' && LA17_0<='\n')||LA17_0=='\r'||LA17_0==' ') ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ActionTranslator.g:704:24: WS
                    {
                    mWS(); if (state.failed) return ;

                    }
                    break;

            }

            match('='); if (state.failed) return ;
            int exprStart825 = getCharIndex();
            int exprStartLine825 = getLine();
            int exprStartCharPos825 = getCharPositionInLine();
            mATTR_VALUE_EXPR(); if (state.failed) return ;
            expr = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, exprStart825, getCharIndex()-1);
            expr.setLine(exprStartLine825);
            expr.setCharPositionInLine(exprStartCharPos825);
            match(';'); if (state.failed) return ;
            if ( state.backtracking==1 ) {

              		StringTemplate st = template("actionSetAttribute");
              		String action = (a!=null?a.getText():null);
              		action = action.substring(1,action.length()-1); // stuff inside {...}
              		st.setAttribute("st", translateAction(action));
              		st.setAttribute("attrName", (ID7!=null?ID7.getText():null));
              		st.setAttribute("expr", translateAction((expr!=null?expr.getText():null)));
              		
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SET_EXPR_ATTRIBUTE"

    // $ANTLR start "SET_ATTRIBUTE"
    public final void mSET_ATTRIBUTE() throws RecognitionException {
        try {
            int _type = SET_ATTRIBUTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken x=null;
            CommonToken y=null;
            CommonToken expr=null;

            // ActionTranslator.g:721:2: ( '%' x= ID '.' y= ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';' )
            // ActionTranslator.g:721:4: '%' x= ID '.' y= ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';'
            {
            match('%'); if (state.failed) return ;
            int xStart852 = getCharIndex();
            int xStartLine852 = getLine();
            int xStartCharPos852 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart852, getCharIndex()-1);
            x.setLine(xStartLine852);
            x.setCharPositionInLine(xStartCharPos852);
            match('.'); if (state.failed) return ;
            int yStart858 = getCharIndex();
            int yStartLine858 = getLine();
            int yStartCharPos858 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart858, getCharIndex()-1);
            y.setLine(yStartLine858);
            y.setCharPositionInLine(yStartCharPos858);
            // ActionTranslator.g:721:22: ( WS )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>='\t' && LA18_0<='\n')||LA18_0=='\r'||LA18_0==' ') ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ActionTranslator.g:721:22: WS
                    {
                    mWS(); if (state.failed) return ;

                    }
                    break;

            }

            match('='); if (state.failed) return ;
            int exprStart867 = getCharIndex();
            int exprStartLine867 = getLine();
            int exprStartCharPos867 = getCharPositionInLine();
            mATTR_VALUE_EXPR(); if (state.failed) return ;
            expr = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, exprStart867, getCharIndex()-1);
            expr.setLine(exprStartLine867);
            expr.setCharPositionInLine(exprStartCharPos867);
            match(';'); if (state.failed) return ;
            if ( state.backtracking==1 ) {

              		StringTemplate st = template("actionSetAttribute");
              		st.setAttribute("st", (x!=null?x.getText():null));
              		st.setAttribute("attrName", (y!=null?y.getText():null));
              		st.setAttribute("expr", translateAction((expr!=null?expr.getText():null)));
              		
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SET_ATTRIBUTE"

    // $ANTLR start "ATTR_VALUE_EXPR"
    public final void mATTR_VALUE_EXPR() throws RecognitionException {
        try {
            // ActionTranslator.g:734:2: (~ '=' (~ ';' )* )
            // ActionTranslator.g:734:4: ~ '=' (~ ';' )*
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='<')||(input.LA(1)>='>' && input.LA(1)<='\uFFFF') ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ActionTranslator.g:734:9: (~ ';' )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>='\u0000' && LA19_0<=':')||(LA19_0>='<' && LA19_0<='\uFFFF')) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ActionTranslator.g:734:10: ~ ';'
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<=':')||(input.LA(1)>='<' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "ATTR_VALUE_EXPR"

    // $ANTLR start "TEMPLATE_EXPR"
    public final void mTEMPLATE_EXPR() throws RecognitionException {
        try {
            int _type = TEMPLATE_EXPR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken a=null;

            // ActionTranslator.g:739:2: ( '%' a= ACTION )
            // ActionTranslator.g:739:4: '%' a= ACTION
            {
            match('%'); if (state.failed) return ;
            int aStart916 = getCharIndex();
            int aStartLine916 = getLine();
            int aStartCharPos916 = getCharPositionInLine();
            mACTION(); if (state.failed) return ;
            a = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, aStart916, getCharIndex()-1);
            a.setLine(aStartLine916);
            a.setCharPositionInLine(aStartCharPos916);
            if ( state.backtracking==1 ) {

              		StringTemplate st = template("actionStringConstructor");
              		String action = (a!=null?a.getText():null);
              		action = action.substring(1,action.length()-1); // stuff inside {...}
              		st.setAttribute("stringExpr", translateAction(action));
              		
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TEMPLATE_EXPR"

    // $ANTLR start "ACTION"
    public final void mACTION() throws RecognitionException {
        try {
            // ActionTranslator.g:751:2: ( '{' ( options {greedy=false; } : . )* '}' )
            // ActionTranslator.g:751:4: '{' ( options {greedy=false; } : . )* '}'
            {
            match('{'); if (state.failed) return ;
            // ActionTranslator.g:751:8: ( options {greedy=false; } : . )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0=='}') ) {
                    alt20=2;
                }
                else if ( ((LA20_0>='\u0000' && LA20_0<='|')||(LA20_0>='~' && LA20_0<='\uFFFF')) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ActionTranslator.g:751:33: .
            	    {
            	    matchAny(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            match('}'); if (state.failed) return ;

            }

        }
        finally {
        }
    }
    // $ANTLR end "ACTION"

    // $ANTLR start "ESC"
    public final void mESC() throws RecognitionException {
        try {
            int _type = ESC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ActionTranslator.g:754:5: ( '\\\\' '$' | '\\\\' '%' | '\\\\' ~ ( '$' | '%' ) )
            int alt21=3;
            int LA21_0 = input.LA(1);

            if ( (LA21_0=='\\') ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1=='$') ) {
                    alt21=1;
                }
                else if ( (LA21_1=='%') ) {
                    alt21=2;
                }
                else if ( ((LA21_1>='\u0000' && LA21_1<='#')||(LA21_1>='&' && LA21_1<='\uFFFF')) ) {
                    alt21=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ActionTranslator.g:754:9: '\\\\' '$'
                    {
                    match('\\'); if (state.failed) return ;
                    match('$'); if (state.failed) return ;
                    if ( state.backtracking==1 ) {
                      chunks.add("$");
                    }

                    }
                    break;
                case 2 :
                    // ActionTranslator.g:755:4: '\\\\' '%'
                    {
                    match('\\'); if (state.failed) return ;
                    match('%'); if (state.failed) return ;
                    if ( state.backtracking==1 ) {
                      chunks.add("%");
                    }

                    }
                    break;
                case 3 :
                    // ActionTranslator.g:756:4: '\\\\' ~ ( '$' | '%' )
                    {
                    match('\\'); if (state.failed) return ;
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='#')||(input.LA(1)>='&' && input.LA(1)<='\uFFFF') ) {
                        input.consume();
                    state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    if ( state.backtracking==1 ) {
                      chunks.add(getText());
                    }

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ESC"

    // $ANTLR start "ERROR_XY"
    public final void mERROR_XY() throws RecognitionException {
        try {
            int _type = ERROR_XY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken x=null;
            CommonToken y=null;

            // ActionTranslator.g:760:2: ( '$' x= ID '.' y= ID )
            // ActionTranslator.g:760:4: '$' x= ID '.' y= ID
            {
            match('$'); if (state.failed) return ;
            int xStart1016 = getCharIndex();
            int xStartLine1016 = getLine();
            int xStartCharPos1016 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart1016, getCharIndex()-1);
            x.setLine(xStartLine1016);
            x.setCharPositionInLine(xStartCharPos1016);
            match('.'); if (state.failed) return ;
            int yStart1022 = getCharIndex();
            int yStartLine1022 = getLine();
            int yStartCharPos1022 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart1022, getCharIndex()-1);
            y.setLine(yStartLine1022);
            y.setCharPositionInLine(yStartCharPos1022);
            if ( state.backtracking==1 ) {

              		chunks.add(getText());
              		generator.issueInvalidAttributeError((x!=null?x.getText():null),(y!=null?y.getText():null),
              		                                     enclosingRule,actionToken,
              		                                     outerAltNum);
              		
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ERROR_XY"

    // $ANTLR start "ERROR_X"
    public final void mERROR_X() throws RecognitionException {
        try {
            int _type = ERROR_X;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken x=null;

            // ActionTranslator.g:770:2: ( '$' x= ID )
            // ActionTranslator.g:770:4: '$' x= ID
            {
            match('$'); if (state.failed) return ;
            int xStart1042 = getCharIndex();
            int xStartLine1042 = getLine();
            int xStartCharPos1042 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart1042, getCharIndex()-1);
            x.setLine(xStartLine1042);
            x.setCharPositionInLine(xStartCharPos1042);
            if ( state.backtracking==1 ) {

              		chunks.add(getText());
              		generator.issueInvalidAttributeError((x!=null?x.getText():null),
              		                                     enclosingRule,actionToken,
              		                                     outerAltNum);
              		
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ERROR_X"

    // $ANTLR start "UNKNOWN_SYNTAX"
    public final void mUNKNOWN_SYNTAX() throws RecognitionException {
        try {
            int _type = UNKNOWN_SYNTAX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ActionTranslator.g:780:2: ( '$' | '%' ( ID | '.' | '(' | ')' | ',' | '{' | '}' | '\"' )* )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0=='$') ) {
                alt23=1;
            }
            else if ( (LA23_0=='%') ) {
                alt23=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ActionTranslator.g:780:4: '$'
                    {
                    match('$'); if (state.failed) return ;
                    if ( state.backtracking==1 ) {

                      		chunks.add(getText());
                      		// shouldn't need an error here.  Just accept $ if it doesn't look like anything
                      		
                    }

                    }
                    break;
                case 2 :
                    // ActionTranslator.g:785:4: '%' ( ID | '.' | '(' | ')' | ',' | '{' | '}' | '\"' )*
                    {
                    match('%'); if (state.failed) return ;
                    // ActionTranslator.g:785:8: ( ID | '.' | '(' | ')' | ',' | '{' | '}' | '\"' )*
                    loop22:
                    do {
                        int alt22=9;
                        alt22 = dfa22.predict(input);
                        switch (alt22) {
                    	case 1 :
                    	    // ActionTranslator.g:785:9: ID
                    	    {
                    	    mID(); if (state.failed) return ;

                    	    }
                    	    break;
                    	case 2 :
                    	    // ActionTranslator.g:785:12: '.'
                    	    {
                    	    match('.'); if (state.failed) return ;

                    	    }
                    	    break;
                    	case 3 :
                    	    // ActionTranslator.g:785:16: '('
                    	    {
                    	    match('('); if (state.failed) return ;

                    	    }
                    	    break;
                    	case 4 :
                    	    // ActionTranslator.g:785:20: ')'
                    	    {
                    	    match(')'); if (state.failed) return ;

                    	    }
                    	    break;
                    	case 5 :
                    	    // ActionTranslator.g:785:24: ','
                    	    {
                    	    match(','); if (state.failed) return ;

                    	    }
                    	    break;
                    	case 6 :
                    	    // ActionTranslator.g:785:28: '{'
                    	    {
                    	    match('{'); if (state.failed) return ;

                    	    }
                    	    break;
                    	case 7 :
                    	    // ActionTranslator.g:785:32: '}'
                    	    {
                    	    match('}'); if (state.failed) return ;

                    	    }
                    	    break;
                    	case 8 :
                    	    // ActionTranslator.g:785:36: '\"'
                    	    {
                    	    match('\"'); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    if ( state.backtracking==1 ) {

                      		chunks.add(getText());
                      		ErrorManager.grammarError(ErrorManager.MSG_INVALID_TEMPLATE_ACTION,
                      								  grammar,
                      								  actionToken,
                      								  getText());
                      		
                    }

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UNKNOWN_SYNTAX"

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ActionTranslator.g:795:5: ( (~ ( '$' | '%' | '\\\\' ) )+ )
            // ActionTranslator.g:795:7: (~ ( '$' | '%' | '\\\\' ) )+
            {
            // ActionTranslator.g:795:7: (~ ( '$' | '%' | '\\\\' ) )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>='\u0000' && LA24_0<='#')||(LA24_0>='&' && LA24_0<='[')||(LA24_0>=']' && LA24_0<='\uFFFF')) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ActionTranslator.g:795:7: ~ ( '$' | '%' | '\\\\' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='#')||(input.LA(1)>='&' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt24 >= 1 ) break loop24;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
            } while (true);

            if ( state.backtracking==1 ) {
              chunks.add(getText());
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TEXT"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            // ActionTranslator.g:799:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ActionTranslator.g:799:9: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ActionTranslator.g:799:33: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>='0' && LA25_0<='9')||(LA25_0>='A' && LA25_0<='Z')||LA25_0=='_'||(LA25_0>='a' && LA25_0<='z')) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ActionTranslator.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            // ActionTranslator.g:803:5: ( ( '0' .. '9' )+ )
            // ActionTranslator.g:803:7: ( '0' .. '9' )+
            {
            // ActionTranslator.g:803:7: ( '0' .. '9' )+
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
            	    // ActionTranslator.g:803:7: '0' .. '9'
            	    {
            	    matchRange('0','9'); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt26 >= 1 ) break loop26;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            // ActionTranslator.g:807:4: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
            // ActionTranslator.g:807:6: ( ' ' | '\\t' | '\\n' | '\\r' )+
            {
            // ActionTranslator.g:807:6: ( ' ' | '\\t' | '\\n' | '\\r' )+
            int cnt27=0;
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>='\t' && LA27_0<='\n')||LA27_0=='\r'||LA27_0==' ') ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ActionTranslator.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt27 >= 1 ) break loop27;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(27, input);
                        throw eee;
                }
                cnt27++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // ActionTranslator.g:1:39: ( SET_ENCLOSING_RULE_SCOPE_ATTR | ENCLOSING_RULE_SCOPE_ATTR | SET_TOKEN_SCOPE_ATTR | TOKEN_SCOPE_ATTR | SET_RULE_SCOPE_ATTR | RULE_SCOPE_ATTR | LABEL_REF | ISOLATED_TOKEN_REF | ISOLATED_LEXER_RULE_REF | SET_LOCAL_ATTR | LOCAL_ATTR | SET_DYNAMIC_SCOPE_ATTR | DYNAMIC_SCOPE_ATTR | ERROR_SCOPED_XY | DYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR | DYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR | ISOLATED_DYNAMIC_SCOPE | TEMPLATE_INSTANCE | INDIRECT_TEMPLATE_INSTANCE | SET_EXPR_ATTRIBUTE | SET_ATTRIBUTE | TEMPLATE_EXPR | ESC | ERROR_XY | ERROR_X | UNKNOWN_SYNTAX | TEXT )
        int alt28=27;
        alt28 = dfa28.predict(input);
        switch (alt28) {
            case 1 :
                // ActionTranslator.g:1:41: SET_ENCLOSING_RULE_SCOPE_ATTR
                {
                mSET_ENCLOSING_RULE_SCOPE_ATTR(); if (state.failed) return ;

                }
                break;
            case 2 :
                // ActionTranslator.g:1:71: ENCLOSING_RULE_SCOPE_ATTR
                {
                mENCLOSING_RULE_SCOPE_ATTR(); if (state.failed) return ;

                }
                break;
            case 3 :
                // ActionTranslator.g:1:97: SET_TOKEN_SCOPE_ATTR
                {
                mSET_TOKEN_SCOPE_ATTR(); if (state.failed) return ;

                }
                break;
            case 4 :
                // ActionTranslator.g:1:118: TOKEN_SCOPE_ATTR
                {
                mTOKEN_SCOPE_ATTR(); if (state.failed) return ;

                }
                break;
            case 5 :
                // ActionTranslator.g:1:135: SET_RULE_SCOPE_ATTR
                {
                mSET_RULE_SCOPE_ATTR(); if (state.failed) return ;

                }
                break;
            case 6 :
                // ActionTranslator.g:1:155: RULE_SCOPE_ATTR
                {
                mRULE_SCOPE_ATTR(); if (state.failed) return ;

                }
                break;
            case 7 :
                // ActionTranslator.g:1:171: LABEL_REF
                {
                mLABEL_REF(); if (state.failed) return ;

                }
                break;
            case 8 :
                // ActionTranslator.g:1:181: ISOLATED_TOKEN_REF
                {
                mISOLATED_TOKEN_REF(); if (state.failed) return ;

                }
                break;
            case 9 :
                // ActionTranslator.g:1:200: ISOLATED_LEXER_RULE_REF
                {
                mISOLATED_LEXER_RULE_REF(); if (state.failed) return ;

                }
                break;
            case 10 :
                // ActionTranslator.g:1:224: SET_LOCAL_ATTR
                {
                mSET_LOCAL_ATTR(); if (state.failed) return ;

                }
                break;
            case 11 :
                // ActionTranslator.g:1:239: LOCAL_ATTR
                {
                mLOCAL_ATTR(); if (state.failed) return ;

                }
                break;
            case 12 :
                // ActionTranslator.g:1:250: SET_DYNAMIC_SCOPE_ATTR
                {
                mSET_DYNAMIC_SCOPE_ATTR(); if (state.failed) return ;

                }
                break;
            case 13 :
                // ActionTranslator.g:1:273: DYNAMIC_SCOPE_ATTR
                {
                mDYNAMIC_SCOPE_ATTR(); if (state.failed) return ;

                }
                break;
            case 14 :
                // ActionTranslator.g:1:292: ERROR_SCOPED_XY
                {
                mERROR_SCOPED_XY(); if (state.failed) return ;

                }
                break;
            case 15 :
                // ActionTranslator.g:1:308: DYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR
                {
                mDYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR(); if (state.failed) return ;

                }
                break;
            case 16 :
                // ActionTranslator.g:1:344: DYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR
                {
                mDYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR(); if (state.failed) return ;

                }
                break;
            case 17 :
                // ActionTranslator.g:1:380: ISOLATED_DYNAMIC_SCOPE
                {
                mISOLATED_DYNAMIC_SCOPE(); if (state.failed) return ;

                }
                break;
            case 18 :
                // ActionTranslator.g:1:403: TEMPLATE_INSTANCE
                {
                mTEMPLATE_INSTANCE(); if (state.failed) return ;

                }
                break;
            case 19 :
                // ActionTranslator.g:1:421: INDIRECT_TEMPLATE_INSTANCE
                {
                mINDIRECT_TEMPLATE_INSTANCE(); if (state.failed) return ;

                }
                break;
            case 20 :
                // ActionTranslator.g:1:448: SET_EXPR_ATTRIBUTE
                {
                mSET_EXPR_ATTRIBUTE(); if (state.failed) return ;

                }
                break;
            case 21 :
                // ActionTranslator.g:1:467: SET_ATTRIBUTE
                {
                mSET_ATTRIBUTE(); if (state.failed) return ;

                }
                break;
            case 22 :
                // ActionTranslator.g:1:481: TEMPLATE_EXPR
                {
                mTEMPLATE_EXPR(); if (state.failed) return ;

                }
                break;
            case 23 :
                // ActionTranslator.g:1:495: ESC
                {
                mESC(); if (state.failed) return ;

                }
                break;
            case 24 :
                // ActionTranslator.g:1:499: ERROR_XY
                {
                mERROR_XY(); if (state.failed) return ;

                }
                break;
            case 25 :
                // ActionTranslator.g:1:508: ERROR_X
                {
                mERROR_X(); if (state.failed) return ;

                }
                break;
            case 26 :
                // ActionTranslator.g:1:516: UNKNOWN_SYNTAX
                {
                mUNKNOWN_SYNTAX(); if (state.failed) return ;

                }
                break;
            case 27 :
                // ActionTranslator.g:1:531: TEXT
                {
                mTEXT(); if (state.failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1_ActionTranslator
    public final void synpred1_ActionTranslator_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:41: ( SET_ENCLOSING_RULE_SCOPE_ATTR )
        // ActionTranslator.g:1:41: SET_ENCLOSING_RULE_SCOPE_ATTR
        {
        mSET_ENCLOSING_RULE_SCOPE_ATTR(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_ActionTranslator

    // $ANTLR start synpred2_ActionTranslator
    public final void synpred2_ActionTranslator_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:71: ( ENCLOSING_RULE_SCOPE_ATTR )
        // ActionTranslator.g:1:71: ENCLOSING_RULE_SCOPE_ATTR
        {
        mENCLOSING_RULE_SCOPE_ATTR(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_ActionTranslator

    // $ANTLR start synpred3_ActionTranslator
    public final void synpred3_ActionTranslator_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:97: ( SET_TOKEN_SCOPE_ATTR )
        // ActionTranslator.g:1:97: SET_TOKEN_SCOPE_ATTR
        {
        mSET_TOKEN_SCOPE_ATTR(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_ActionTranslator

    // $ANTLR start synpred4_ActionTranslator
    public final void synpred4_ActionTranslator_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:118: ( TOKEN_SCOPE_ATTR )
        // ActionTranslator.g:1:118: TOKEN_SCOPE_ATTR
        {
        mTOKEN_SCOPE_ATTR(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_ActionTranslator

    // $ANTLR start synpred5_ActionTranslator
    public final void synpred5_ActionTranslator_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:135: ( SET_RULE_SCOPE_ATTR )
        // ActionTranslator.g:1:135: SET_RULE_SCOPE_ATTR
        {
        mSET_RULE_SCOPE_ATTR(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_ActionTranslator

    // $ANTLR start synpred6_ActionTranslator
    public final void synpred6_ActionTranslator_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:155: ( RULE_SCOPE_ATTR )
        // ActionTranslator.g:1:155: RULE_SCOPE_ATTR
        {
        mRULE_SCOPE_ATTR(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_ActionTranslator

    // $ANTLR start synpred7_ActionTranslator
    public final void synpred7_ActionTranslator_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:171: ( LABEL_REF )
        // ActionTranslator.g:1:171: LABEL_REF
        {
        mLABEL_REF(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_ActionTranslator

    // $ANTLR start synpred8_ActionTranslator
    public final void synpred8_ActionTranslator_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:181: ( ISOLATED_TOKEN_REF )
        // ActionTranslator.g:1:181: ISOLATED_TOKEN_REF
        {
        mISOLATED_TOKEN_REF(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_ActionTranslator

    // $ANTLR start synpred9_ActionTranslator
    public final void synpred9_ActionTranslator_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:200: ( ISOLATED_LEXER_RULE_REF )
        // ActionTranslator.g:1:200: ISOLATED_LEXER_RULE_REF
        {
        mISOLATED_LEXER_RULE_REF(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_ActionTranslator

    // $ANTLR start synpred10_ActionTranslator
    public final void synpred10_ActionTranslator_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:224: ( SET_LOCAL_ATTR )
        // ActionTranslator.g:1:224: SET_LOCAL_ATTR
        {
        mSET_LOCAL_ATTR(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_ActionTranslator

    // $ANTLR start synpred11_ActionTranslator
    public final void synpred11_ActionTranslator_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:239: ( LOCAL_ATTR )
        // ActionTranslator.g:1:239: LOCAL_ATTR
        {
        mLOCAL_ATTR(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_ActionTranslator

    // $ANTLR start synpred12_ActionTranslator
    public final void synpred12_ActionTranslator_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:250: ( SET_DYNAMIC_SCOPE_ATTR )
        // ActionTranslator.g:1:250: SET_DYNAMIC_SCOPE_ATTR
        {
        mSET_DYNAMIC_SCOPE_ATTR(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred12_ActionTranslator

    // $ANTLR start synpred13_ActionTranslator
    public final void synpred13_ActionTranslator_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:273: ( DYNAMIC_SCOPE_ATTR )
        // ActionTranslator.g:1:273: DYNAMIC_SCOPE_ATTR
        {
        mDYNAMIC_SCOPE_ATTR(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_ActionTranslator

    // $ANTLR start synpred14_ActionTranslator
    public final void synpred14_ActionTranslator_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:292: ( ERROR_SCOPED_XY )
        // ActionTranslator.g:1:292: ERROR_SCOPED_XY
        {
        mERROR_SCOPED_XY(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_ActionTranslator

    // $ANTLR start synpred15_ActionTranslator
    public final void synpred15_ActionTranslator_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:308: ( DYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR )
        // ActionTranslator.g:1:308: DYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR
        {
        mDYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_ActionTranslator

    // $ANTLR start synpred16_ActionTranslator
    public final void synpred16_ActionTranslator_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:344: ( DYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR )
        // ActionTranslator.g:1:344: DYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR
        {
        mDYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_ActionTranslator

    // $ANTLR start synpred17_ActionTranslator
    public final void synpred17_ActionTranslator_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:380: ( ISOLATED_DYNAMIC_SCOPE )
        // ActionTranslator.g:1:380: ISOLATED_DYNAMIC_SCOPE
        {
        mISOLATED_DYNAMIC_SCOPE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_ActionTranslator

    // $ANTLR start synpred18_ActionTranslator
    public final void synpred18_ActionTranslator_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:403: ( TEMPLATE_INSTANCE )
        // ActionTranslator.g:1:403: TEMPLATE_INSTANCE
        {
        mTEMPLATE_INSTANCE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_ActionTranslator

    // $ANTLR start synpred19_ActionTranslator
    public final void synpred19_ActionTranslator_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:421: ( INDIRECT_TEMPLATE_INSTANCE )
        // ActionTranslator.g:1:421: INDIRECT_TEMPLATE_INSTANCE
        {
        mINDIRECT_TEMPLATE_INSTANCE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_ActionTranslator

    // $ANTLR start synpred20_ActionTranslator
    public final void synpred20_ActionTranslator_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:448: ( SET_EXPR_ATTRIBUTE )
        // ActionTranslator.g:1:448: SET_EXPR_ATTRIBUTE
        {
        mSET_EXPR_ATTRIBUTE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred20_ActionTranslator

    // $ANTLR start synpred21_ActionTranslator
    public final void synpred21_ActionTranslator_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:467: ( SET_ATTRIBUTE )
        // ActionTranslator.g:1:467: SET_ATTRIBUTE
        {
        mSET_ATTRIBUTE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_ActionTranslator

    // $ANTLR start synpred22_ActionTranslator
    public final void synpred22_ActionTranslator_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:481: ( TEMPLATE_EXPR )
        // ActionTranslator.g:1:481: TEMPLATE_EXPR
        {
        mTEMPLATE_EXPR(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred22_ActionTranslator

    // $ANTLR start synpred24_ActionTranslator
    public final void synpred24_ActionTranslator_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:499: ( ERROR_XY )
        // ActionTranslator.g:1:499: ERROR_XY
        {
        mERROR_XY(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred24_ActionTranslator

    // $ANTLR start synpred25_ActionTranslator
    public final void synpred25_ActionTranslator_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:508: ( ERROR_X )
        // ActionTranslator.g:1:508: ERROR_X
        {
        mERROR_X(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_ActionTranslator

    // $ANTLR start synpred26_ActionTranslator
    public final void synpred26_ActionTranslator_fragment() throws RecognitionException {   
        // ActionTranslator.g:1:516: ( UNKNOWN_SYNTAX )
        // ActionTranslator.g:1:516: UNKNOWN_SYNTAX
        {
        mUNKNOWN_SYNTAX(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_ActionTranslator

    public final boolean synpred18_ActionTranslator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_ActionTranslator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_ActionTranslator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_ActionTranslator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_ActionTranslator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_ActionTranslator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_ActionTranslator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_ActionTranslator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_ActionTranslator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_ActionTranslator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_ActionTranslator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_ActionTranslator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_ActionTranslator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_ActionTranslator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_ActionTranslator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_ActionTranslator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_ActionTranslator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_ActionTranslator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_ActionTranslator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_ActionTranslator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_ActionTranslator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_ActionTranslator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_ActionTranslator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_ActionTranslator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_ActionTranslator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_ActionTranslator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_ActionTranslator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_ActionTranslator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_ActionTranslator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_ActionTranslator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_ActionTranslator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_ActionTranslator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_ActionTranslator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_ActionTranslator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_ActionTranslator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_ActionTranslator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_ActionTranslator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_ActionTranslator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_ActionTranslator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_ActionTranslator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_ActionTranslator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_ActionTranslator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_ActionTranslator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_ActionTranslator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_ActionTranslator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_ActionTranslator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_ActionTranslator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_ActionTranslator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_ActionTranslator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_ActionTranslator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA22 dfa22 = new DFA22(this);
    protected DFA28 dfa28 = new DFA28(this);
    static final String DFA22_eotS =
        "\1\1\11\uffff";
    static final String DFA22_eofS =
        "\12\uffff";
    static final String DFA22_minS =
        "\1\42\11\uffff";
    static final String DFA22_maxS =
        "\1\175\11\uffff";
    static final String DFA22_acceptS =
        "\1\uffff\1\11\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10";
    static final String DFA22_specialS =
        "\12\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\11\5\uffff\1\4\1\5\2\uffff\1\6\1\uffff\1\3\22\uffff\32\2"+
            "\4\uffff\1\2\1\uffff\32\2\1\7\1\uffff\1\10",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "()* loopback of 785:8: ( ID | '.' | '(' | ')' | ',' | '{' | '}' | '\"' )*";
        }
    }
    static final String DFA28_eotS =
        "\36\uffff";
    static final String DFA28_eofS =
        "\36\uffff";
    static final String DFA28_minS =
        "\2\0\24\uffff\1\0\7\uffff";
    static final String DFA28_maxS =
        "\1\uffff\1\0\24\uffff\1\0\7\uffff";
    static final String DFA28_acceptS =
        "\2\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1"+
        "\15\1\16\1\17\1\20\1\21\1\30\1\31\1\32\1\uffff\1\22\1\23\1\24\1"+
        "\25\1\26\1\27\1\33";
    static final String DFA28_specialS =
        "\1\0\1\1\24\uffff\1\2\7\uffff}>";
    static final String[] DFA28_transitionS = {
            "\44\35\1\1\1\26\66\35\1\34\uffa3\35",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
    static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
    static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
    static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
    static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
    static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
    static final short[][] DFA28_transition;

    static {
        int numStates = DFA28_transitionS.length;
        DFA28_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = DFA28_eot;
            this.eof = DFA28_eof;
            this.min = DFA28_min;
            this.max = DFA28_max;
            this.accept = DFA28_accept;
            this.special = DFA28_special;
            this.transition = DFA28_transition;
        }
        public String getDescription() {
            return "1:1: Tokens options {k=1; backtrack=true; } : ( SET_ENCLOSING_RULE_SCOPE_ATTR | ENCLOSING_RULE_SCOPE_ATTR | SET_TOKEN_SCOPE_ATTR | TOKEN_SCOPE_ATTR | SET_RULE_SCOPE_ATTR | RULE_SCOPE_ATTR | LABEL_REF | ISOLATED_TOKEN_REF | ISOLATED_LEXER_RULE_REF | SET_LOCAL_ATTR | LOCAL_ATTR | SET_DYNAMIC_SCOPE_ATTR | DYNAMIC_SCOPE_ATTR | ERROR_SCOPED_XY | DYNAMIC_NEGATIVE_INDEXED_SCOPE_ATTR | DYNAMIC_ABSOLUTE_INDEXED_SCOPE_ATTR | ISOLATED_DYNAMIC_SCOPE | TEMPLATE_INSTANCE | INDIRECT_TEMPLATE_INSTANCE | SET_EXPR_ATTRIBUTE | SET_ATTRIBUTE | TEMPLATE_EXPR | ESC | ERROR_XY | ERROR_X | UNKNOWN_SYNTAX | TEXT );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA28_0 = input.LA(1);

                        s = -1;
                        if ( (LA28_0=='$') ) {s = 1;}

                        else if ( (LA28_0=='%') ) {s = 22;}

                        else if ( (LA28_0=='\\') ) {s = 28;}

                        else if ( ((LA28_0>='\u0000' && LA28_0<='#')||(LA28_0>='&' && LA28_0<='[')||(LA28_0>=']' && LA28_0<='\uFFFF')) ) {s = 29;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA28_1 = input.LA(1);

                         
                        int index28_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_ActionTranslator()) ) {s = 2;}

                        else if ( (synpred2_ActionTranslator()) ) {s = 3;}

                        else if ( (synpred3_ActionTranslator()) ) {s = 4;}

                        else if ( (synpred4_ActionTranslator()) ) {s = 5;}

                        else if ( (synpred5_ActionTranslator()) ) {s = 6;}

                        else if ( (synpred6_ActionTranslator()) ) {s = 7;}

                        else if ( (synpred7_ActionTranslator()) ) {s = 8;}

                        else if ( (synpred8_ActionTranslator()) ) {s = 9;}

                        else if ( (synpred9_ActionTranslator()) ) {s = 10;}

                        else if ( (synpred10_ActionTranslator()) ) {s = 11;}

                        else if ( (synpred11_ActionTranslator()) ) {s = 12;}

                        else if ( (synpred12_ActionTranslator()) ) {s = 13;}

                        else if ( (synpred13_ActionTranslator()) ) {s = 14;}

                        else if ( (synpred14_ActionTranslator()) ) {s = 15;}

                        else if ( (synpred15_ActionTranslator()) ) {s = 16;}

                        else if ( (synpred16_ActionTranslator()) ) {s = 17;}

                        else if ( (synpred17_ActionTranslator()) ) {s = 18;}

                        else if ( (synpred24_ActionTranslator()) ) {s = 19;}

                        else if ( (synpred25_ActionTranslator()) ) {s = 20;}

                        else if ( (synpred26_ActionTranslator()) ) {s = 21;}

                         
                        input.seek(index28_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA28_22 = input.LA(1);

                         
                        int index28_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_ActionTranslator()) ) {s = 23;}

                        else if ( (synpred19_ActionTranslator()) ) {s = 24;}

                        else if ( (synpred20_ActionTranslator()) ) {s = 25;}

                        else if ( (synpred21_ActionTranslator()) ) {s = 26;}

                        else if ( (synpred22_ActionTranslator()) ) {s = 27;}

                        else if ( (synpred26_ActionTranslator()) ) {s = 21;}

                         
                        input.seek(index28_22);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 28, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}