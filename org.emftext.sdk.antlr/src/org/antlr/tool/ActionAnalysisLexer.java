/*
 [The "BSD licence"]
 Copyright (c) 2005-2008 Terence Parr
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
// $ANTLR 3.1b1 ActionAnalysis.g 2007-12-11 15:11:24

package org.antlr.tool;
import org.antlr.runtime.*;

import java.util.HashMap;
/** We need to set Rule.referencedPredefinedRuleAttributes before
 *  code generation.  This filter looks at an action in context of
 *  its rule and outer alternative number and figures out which
 *  rules have predefined prefs referenced.  I need this so I can
 *  remove unusued labels.  This also tracks, for labeled rules,
 *  which are referenced by actions.
 */
public class ActionAnalysisLexer extends Lexer {
    public static final int X_Y=5;
    public static final int EOF=-1;
    public static final int Tokens=8;
    public static final int Y=7;
    public static final int ID=4;
    public static final int X=6;

    Rule enclosingRule;
    Grammar grammar;
    antlr.Token actionToken;
    int outerAltNum = 0;

    	public ActionAnalysisLexer(Grammar grammar, String ruleName, GrammarAST actionAST)
    	{
    		this(new ANTLRStringStream(actionAST.token.getText()));
    		this.grammar = grammar;
    	    this.enclosingRule = grammar.getLocallyDefinedRule(ruleName);
    	    this.actionToken = actionAST.token;
    	    this.outerAltNum = actionAST.outerAltNum;
    	}

    public void analyze() {
    	// System.out.println("###\naction="+actionToken);
    	Token t;
    	do {
    		t = nextToken();
    	} while ( t.getType()!= Token.EOF );
    }


    // delegates
    // delegators

    public ActionAnalysisLexer() {;}
    public ActionAnalysisLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public ActionAnalysisLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
        this.state.ruleMemo = new HashMap[7+1];

    }
    public String getGrammarFileName() { return "ActionAnalysis.g"; }

    public Token nextToken() {
        while (true) {
            if ( input.LA(1)==CharStream.EOF ) {
                return Token.EOF_TOKEN;
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
    }// $ANTLR start X_Y
    public final void mX_Y() throws RecognitionException {
        try {
            int _type = X_Y;
            Token x=null;
            Token y=null;

            // ActionAnalysis.g:74:5: ( '$' x= ID '.' y= ID {...}?)
            // ActionAnalysis.g:74:7: '$' x= ID '.' y= ID {...}?
            {
            match('$'); if (state.failed) return ;
            int xStart48 = getCharIndex();
            mID(); if (state.failed) return ;
            x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart48, getCharIndex()-1);
            match('.'); if (state.failed) return ;
            int yStart54 = getCharIndex();
            mID(); if (state.failed) return ;
            y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart54, getCharIndex()-1);
            if ( !(enclosingRule!=null) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "X_Y", "enclosingRule!=null");
            }
            if ( state.backtracking==1 ) {

              		AttributeScope scope = null;
              		String refdRuleName = null;
              		if ( (x!=null?x.getText():null).equals(enclosingRule.name) ) {
              			// ref to enclosing rule.
              			refdRuleName = (x!=null?x.getText():null);
              			scope = enclosingRule.getLocalAttributeScope((y!=null?y.getText():null));
              		}
              		else if ( enclosingRule.getRuleLabel((x!=null?x.getText():null))!=null ) {
              			// ref to rule label
              			Grammar.LabelElementPair pair = enclosingRule.getRuleLabel((x!=null?x.getText():null));
              			pair.actionReferencesLabel = true;
              			refdRuleName = pair.referencedRuleName;
              			Rule refdRule = grammar.getRule(refdRuleName);
              			if ( refdRule!=null ) {
              				scope = refdRule.getLocalAttributeScope((y!=null?y.getText():null));
              			}
              		}
              		else if ( enclosingRule.getRuleRefsInAlt(x.getText(), outerAltNum)!=null ) {
              			// ref to rule referenced in this alt
              			refdRuleName = (x!=null?x.getText():null);
              			Rule refdRule = grammar.getRule(refdRuleName);
              			if ( refdRule!=null ) {
              				scope = refdRule.getLocalAttributeScope((y!=null?y.getText():null));
              			}
              		}
              		if ( scope!=null &&
              			 (scope.isPredefinedRuleScope||scope.isPredefinedLexerRuleScope) )
              		{
              			grammar.referenceRuleLabelPredefinedAttribute(refdRuleName);
              			//System.out.println("referenceRuleLabelPredefinedAttribute for "+refdRuleName);
              		}

            }

            }

            state.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end X_Y

    // $ANTLR start X
    public final void mX() throws RecognitionException {
        try {
            int _type = X;
            Token x=null;

            // ActionAnalysis.g:111:3: ( '$' x= ID {...}?)
            // ActionAnalysis.g:111:5: '$' x= ID {...}?
            {
            match('$'); if (state.failed) return ;
            int xStart76 = getCharIndex();
            mID(); if (state.failed) return ;
            x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart76, getCharIndex()-1);
            if ( !(enclosingRule!=null && enclosingRule.getRuleLabel((x!=null?x.getText():null))!=null) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "X", "enclosingRule!=null && enclosingRule.getRuleLabel($x.text)!=null");
            }
            if ( state.backtracking==1 ) {

              			Grammar.LabelElementPair pair = enclosingRule.getRuleLabel((x!=null?x.getText():null));
              			pair.actionReferencesLabel = true;

            }

            }

            state.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end X

    // $ANTLR start Y
    public final void mY() throws RecognitionException {
        try {
            int _type = Y;
            Token ID1=null;

            // ActionAnalysis.g:119:3: ( '$' ID {...}?)
            // ActionAnalysis.g:119:5: '$' ID {...}?
            {
            match('$'); if (state.failed) return ;
            int ID1Start97 = getCharIndex();
            mID(); if (state.failed) return ;
            ID1 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, ID1Start97, getCharIndex()-1);
            if ( !(enclosingRule!=null && enclosingRule.getLocalAttributeScope((ID1!=null?ID1.getText():null))!=null) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "Y", "enclosingRule!=null && enclosingRule.getLocalAttributeScope($ID.text)!=null");
            }
            if ( state.backtracking==1 ) {

              			AttributeScope scope = enclosingRule.getLocalAttributeScope((ID1!=null?ID1.getText():null));
              			if ( scope!=null &&
              				 (scope.isPredefinedRuleScope||scope.isPredefinedLexerRuleScope) )
              			{
              				grammar.referenceRuleLabelPredefinedAttribute(enclosingRule.name);
              				//System.out.println("referenceRuleLabelPredefinedAttribute for "+(ID1!=null?ID1.getText():null));
              			}

            }

            }

            state.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Y

    // $ANTLR start ID
    public final void mID() throws RecognitionException {
        try {
            // ActionAnalysis.g:132:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ActionAnalysis.g:132:9: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // ActionAnalysis.g:132:33: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ActionAnalysis.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end ID

    public void mTokens() throws RecognitionException {
        // ActionAnalysis.g:1:39: ( X_Y | X | Y )
        int alt2=3;
        int LA2_0 = input.LA(1);

        if ( (LA2_0=='$') ) {
            int LA2_1 = input.LA(2);

            if ( (synpred1()) ) {
                alt2=1;
            }
            else if ( (synpred2()) ) {
                alt2=2;
            }
            else if ( (true) ) {
                alt2=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("1:1: Tokens options {k=1; backtrack=true; } : ( X_Y | X | Y );", 2, 1, input);

                throw nvae;
            }
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens options {k=1; backtrack=true; } : ( X_Y | X | Y );", 2, 0, input);

            throw nvae;
        }
        switch (alt2) {
            case 1 :
                // ActionAnalysis.g:1:41: X_Y
                {
                mX_Y(); if (state.failed) return ;

                }
                break;
            case 2 :
                // ActionAnalysis.g:1:45: X
                {
                mX(); if (state.failed) return ;

                }
                break;
            case 3 :
                // ActionAnalysis.g:1:47: Y
                {
                mY(); if (state.failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1
    public final void synpred1_fragment() throws RecognitionException {
        // ActionAnalysis.g:1:41: ( X_Y )
        // ActionAnalysis.g:1:41: X_Y
        {
        mX_Y(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1

    // $ANTLR start synpred2
    public final void synpred2_fragment() throws RecognitionException {
        // ActionAnalysis.g:1:45: ( X )
        // ActionAnalysis.g:1:45: X
        {
        mX(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2

    public final boolean synpred2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

}