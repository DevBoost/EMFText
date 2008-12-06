// $ANTLR 3.0b7 ActionAnalysis.g 2007-04-03 12:25:48

package org.antlr.tool;
import org.antlr.runtime.*;
import org.antlr.tool.AttributeScope;
import org.antlr.tool.Grammar;
import org.antlr.tool.GrammarAST;
import org.antlr.tool.Rule;

import java.util.HashMap;
/** We need to set Rule.referencedPredefinedRuleAttributes before
 *  code generation.  This filter looks at an action in context of
 *  its rule and outer alternative number and figures out which
 *  rules have predefined prefs referenced.  I need this so I can
 *  remove unusued labels.
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
    	    this.enclosingRule = grammar.getRule(ruleName);
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

    public ActionAnalysisLexer() {;}
    public ActionAnalysisLexer(CharStream input) {
        super(input);
        ruleMemo = new HashMap[7+1];
     }
    public String getGrammarFileName() { return "ActionAnalysis.g"; }

    public Token nextToken() {
        while (true) {
            if ( input.LA(1)==CharStream.EOF ) {
                return Token.EOF_TOKEN;
            }
            token = null;
    	channel = Token.DEFAULT_CHANNEL;
            tokenStartCharIndex = input.index();
            tokenStartCharPositionInLine = input.getCharPositionInLine();
            tokenStartLine = input.getLine();
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
                    emit();
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
    }// $ANTLR start X_Y
    public final void mX_Y() throws RecognitionException {
        try {
            int _type = X_Y;
            // ActionAnalysis.g:73:7: ( '$' x= ID '.' y= ID {...}?)
            // ActionAnalysis.g:73:7: '$' x= ID '.' y= ID {...}?
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
                throw new FailedPredicateException(input, "X_Y", "enclosingRule!=null");
            }
            if ( backtracking==1 ) {

              		AttributeScope scope = null;
              		String refdRuleName = null;
              		if ( x.getText().equals(enclosingRule.name) ) {
              			// ref to enclosing rule.
              			refdRuleName = x.getText();
              			scope = enclosingRule.getLocalAttributeScope(y.getText());
              		}
              		else if ( enclosingRule.getRuleLabel(x.getText())!=null ) {
              			// ref to rule label
              			Grammar.LabelElementPair pair = enclosingRule.getRuleLabel(x.getText());
              			pair.actionReferencesLabel = true;
              			refdRuleName = pair.referencedRuleName;
              			Rule refdRule = grammar.getRule(refdRuleName);
              			scope = refdRule.getLocalAttributeScope(y.getText());
              		}
              		else if ( enclosingRule.getRuleRefsInAlt(x.getText(), outerAltNum)!=null ) {
              			// ref to rule referenced in this alt
              			refdRuleName = x.getText();
              			Rule refdRule = grammar.getRule(refdRuleName);
              			scope = refdRule.getLocalAttributeScope(y.getText());
              		}
              		if ( scope!=null &&
              			 (scope.isPredefinedRuleScope||scope.isPredefinedLexerRuleScope) )
              		{
              			grammar.referenceRuleLabelPredefinedAttribute(refdRuleName);
              			//System.out.println("referenceRuleLabelPredefinedAttribute for "+refdRuleName);
              		}

            }

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end X_Y

    // $ANTLR start X
    public final void mX() throws RecognitionException {
        try {
            int _type = X;
            // ActionAnalysis.g:106:5: ( '$' x= ID {...}?)
            // ActionAnalysis.g:106:5: '$' x= ID {...}?
            {
            match('$'); if (failed) return ;
            int xStart = getCharIndex();
            mID(); if (failed) return ;
            Token x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart, getCharIndex()-1);
            if ( !(enclosingRule!=null && enclosingRule.getRuleLabel(x.getText())!=null) ) {
                if (backtracking>0) {failed=true; return ;}
                throw new FailedPredicateException(input, "X", "enclosingRule!=null && enclosingRule.getRuleLabel($x.text)!=null");
            }
            if ( backtracking==1 ) {

              			Grammar.LabelElementPair pair = enclosingRule.getRuleLabel(x.getText());
              			pair.actionReferencesLabel = true;

            }

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end X

    // $ANTLR start Y
    public final void mY() throws RecognitionException {
        try {
            int _type = Y;
            // ActionAnalysis.g:114:5: ( '$' ID {...}?)
            // ActionAnalysis.g:114:5: '$' ID {...}?
            {
            match('$'); if (failed) return ;
            int ID1Start = getCharIndex();
            mID(); if (failed) return ;
            Token ID1 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, ID1Start, getCharIndex()-1);
            if ( !(enclosingRule!=null && enclosingRule.getLocalAttributeScope(ID1.getText())!=null) ) {
                if (backtracking>0) {failed=true; return ;}
                throw new FailedPredicateException(input, "Y", "enclosingRule!=null && enclosingRule.getLocalAttributeScope($ID.text)!=null");
            }
            if ( backtracking==1 ) {

              			AttributeScope scope = enclosingRule.getLocalAttributeScope(ID1.getText());
              			if ( scope!=null &&
              				 (scope.isPredefinedRuleScope||scope.isPredefinedLexerRuleScope) )
              			{
              				grammar.referenceRuleLabelPredefinedAttribute(enclosingRule.name);
              				//System.out.println("referenceRuleLabelPredefinedAttribute for "+ID1.getText());
              			}

            }

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Y

    // $ANTLR start ID
    public final void mID() throws RecognitionException {
        try {
            // ActionAnalysis.g:127:9: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ActionAnalysis.g:127:9: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
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

            // ActionAnalysis.g:127:33: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
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
        // ActionAnalysis.g:1:41: ( X_Y | X | Y )
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
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("1:1: Tokens options {k=1; backtrack=true; } : ( X_Y | X | Y );", 2, 1, input);

                throw nvae;
            }
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens options {k=1; backtrack=true; } : ( X_Y | X | Y );", 2, 0, input);

            throw nvae;
        }
        switch (alt2) {
            case 1 :
                // ActionAnalysis.g:1:41: X_Y
                {
                mX_Y(); if (failed) return ;

                }
                break;
            case 2 :
                // ActionAnalysis.g:1:45: X
                {
                mX(); if (failed) return ;

                }
                break;
            case 3 :
                // ActionAnalysis.g:1:47: Y
                {
                mY(); if (failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1
    public final void synpred1_fragment() throws RecognitionException {
        // ActionAnalysis.g:1:41: ( X_Y )
        // ActionAnalysis.g:1:41: X_Y
        {
        mX_Y(); if (failed) return ;

        }
    }
    // $ANTLR end synpred1

    // $ANTLR start synpred2
    public final void synpred2_fragment() throws RecognitionException {
        // ActionAnalysis.g:1:45: ( X )
        // ActionAnalysis.g:1:45: X
        {
        mX(); if (failed) return ;

        }
    }
    // $ANTLR end synpred2

    public final boolean synpred2() {
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
    public final boolean synpred1() {
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


 

}