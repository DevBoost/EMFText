// $ANTLR 3.3 Nov 30, 2010 12:46:29 org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g 2011-08-25 14:59:48

package org.antlr.grammar.v3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.antlr.runtime3_4_0.BaseRecognizer;
import org.antlr.runtime3_4_0.BitSet;
import org.antlr.runtime3_4_0.DFA;
import org.antlr.runtime3_4_0.EarlyExitException;
import org.antlr.runtime3_4_0.FailedPredicateException;
import org.antlr.runtime3_4_0.IntStream;
import org.antlr.runtime3_4_0.MismatchedSetException;
import org.antlr.runtime3_4_0.NoViableAltException;
import org.antlr.runtime3_4_0.RecognitionException;
import org.antlr.runtime3_4_0.RecognizerSharedState;
import org.antlr.runtime3_4_0.Token;
import org.antlr.runtime3_4_0.tree.CommonTree;
import org.antlr.runtime3_4_0.tree.TreeNodeStream;
import org.antlr.runtime3_4_0.tree.TreeParser;
import org.antlr.runtime3_4_0.tree.TreeRuleReturnScope;
import org.antlr.tool.AttributeScope;
import org.antlr.tool.ErrorManager;
import org.antlr.tool.Grammar;
import org.antlr.tool.GrammarAST;
import org.antlr.tool.Rule;
public class DefineGrammarItemsWalker extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "LEXER", "PARSER", "CATCH", "FINALLY", "GRAMMAR", "PRIVATE", "PROTECTED", "PUBLIC", "RETURNS", "THROWS", "TREE", "RULE", "PREC_RULE", "RECURSIVE_RULE_REF", "BLOCK", "OPTIONAL", "CLOSURE", "POSITIVE_CLOSURE", "SYNPRED", "RANGE", "CHAR_RANGE", "EPSILON", "ALT", "EOR", "EOB", "EOA", "ID", "ARG", "ARGLIST", "RET", "LEXER_GRAMMAR", "PARSER_GRAMMAR", "TREE_GRAMMAR", "COMBINED_GRAMMAR", "INITACTION", "FORCED_ACTION", "LABEL", "TEMPLATE", "SCOPE", "IMPORT", "GATED_SEMPRED", "SYN_SEMPRED", "BACKTRACK_SEMPRED", "FRAGMENT", "DOT", "REWRITES", "ACTION", "DOC_COMMENT", "SEMI", "AMPERSAND", "COLON", "OPTIONS", "RCURLY", "ASSIGN", "STRING_LITERAL", "CHAR_LITERAL", "INT", "STAR", "COMMA", "TOKENS", "TOKEN_REF", "BANG", "ARG_ACTION", "OR", "LPAREN", "RPAREN", "PLUS_ASSIGN", "SEMPRED", "IMPLIES", "ROOT", "WILDCARD", "RULE_REF", "NOT", "TREE_BEGIN", "QUESTION", "PLUS", "OPEN_ELEMENT_OPTION", "CLOSE_ELEMENT_OPTION", "DOUBLE_QUOTE_STRING_LITERAL", "DOUBLE_ANGLE_STRING_LITERAL", "REWRITE", "ETC", "DOLLAR", "WS", "SL_COMMENT", "ML_COMMENT", "COMMENT", "SRC", "STRAY_BRACKET", "ESC", "DIGIT", "XDIGIT", "NESTED_ARG_ACTION", "ACTION_STRING_LITERAL", "ACTION_CHAR_LITERAL", "NESTED_ACTION", "ACTION_ESC", "WS_LOOP", "WS_OPT"
    };
    public static final int EOF=-1;
    public static final int LEXER=4;
    public static final int PARSER=5;
    public static final int CATCH=6;
    public static final int FINALLY=7;
    public static final int GRAMMAR=8;
    public static final int PRIVATE=9;
    public static final int PROTECTED=10;
    public static final int PUBLIC=11;
    public static final int RETURNS=12;
    public static final int THROWS=13;
    public static final int TREE=14;
    public static final int RULE=15;
    public static final int PREC_RULE=16;
    public static final int RECURSIVE_RULE_REF=17;
    public static final int BLOCK=18;
    public static final int OPTIONAL=19;
    public static final int CLOSURE=20;
    public static final int POSITIVE_CLOSURE=21;
    public static final int SYNPRED=22;
    public static final int RANGE=23;
    public static final int CHAR_RANGE=24;
    public static final int EPSILON=25;
    public static final int ALT=26;
    public static final int EOR=27;
    public static final int EOB=28;
    public static final int EOA=29;
    public static final int ID=30;
    public static final int ARG=31;
    public static final int ARGLIST=32;
    public static final int RET=33;
    public static final int LEXER_GRAMMAR=34;
    public static final int PARSER_GRAMMAR=35;
    public static final int TREE_GRAMMAR=36;
    public static final int COMBINED_GRAMMAR=37;
    public static final int INITACTION=38;
    public static final int FORCED_ACTION=39;
    public static final int LABEL=40;
    public static final int TEMPLATE=41;
    public static final int SCOPE=42;
    public static final int IMPORT=43;
    public static final int GATED_SEMPRED=44;
    public static final int SYN_SEMPRED=45;
    public static final int BACKTRACK_SEMPRED=46;
    public static final int FRAGMENT=47;
    public static final int DOT=48;
    public static final int REWRITES=49;
    public static final int ACTION=50;
    public static final int DOC_COMMENT=51;
    public static final int SEMI=52;
    public static final int AMPERSAND=53;
    public static final int COLON=54;
    public static final int OPTIONS=55;
    public static final int RCURLY=56;
    public static final int ASSIGN=57;
    public static final int STRING_LITERAL=58;
    public static final int CHAR_LITERAL=59;
    public static final int INT=60;
    public static final int STAR=61;
    public static final int COMMA=62;
    public static final int TOKENS=63;
    public static final int TOKEN_REF=64;
    public static final int BANG=65;
    public static final int ARG_ACTION=66;
    public static final int OR=67;
    public static final int LPAREN=68;
    public static final int RPAREN=69;
    public static final int PLUS_ASSIGN=70;
    public static final int SEMPRED=71;
    public static final int IMPLIES=72;
    public static final int ROOT=73;
    public static final int WILDCARD=74;
    public static final int RULE_REF=75;
    public static final int NOT=76;
    public static final int TREE_BEGIN=77;
    public static final int QUESTION=78;
    public static final int PLUS=79;
    public static final int OPEN_ELEMENT_OPTION=80;
    public static final int CLOSE_ELEMENT_OPTION=81;
    public static final int DOUBLE_QUOTE_STRING_LITERAL=82;
    public static final int DOUBLE_ANGLE_STRING_LITERAL=83;
    public static final int REWRITE=84;
    public static final int ETC=85;
    public static final int DOLLAR=86;
    public static final int WS=87;
    public static final int SL_COMMENT=88;
    public static final int ML_COMMENT=89;
    public static final int COMMENT=90;
    public static final int SRC=91;
    public static final int STRAY_BRACKET=92;
    public static final int ESC=93;
    public static final int DIGIT=94;
    public static final int XDIGIT=95;
    public static final int NESTED_ARG_ACTION=96;
    public static final int ACTION_STRING_LITERAL=97;
    public static final int ACTION_CHAR_LITERAL=98;
    public static final int NESTED_ACTION=99;
    public static final int ACTION_ESC=100;
    public static final int WS_LOOP=101;
    public static final int WS_OPT=102;

    // delegates
    // delegators

    protected static class AttributeScopeActions_scope {
        HashMap<GrammarAST, GrammarAST> actions;
    }
    protected Stack AttributeScopeActions_stack = new Stack();


        public DefineGrammarItemsWalker(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public DefineGrammarItemsWalker(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return DefineGrammarItemsWalker.tokenNames; }
    public String getGrammarFileName() { return "org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g"; }


    protected Grammar grammar;
    protected GrammarAST root;
    protected String currentRuleName;
    protected GrammarAST currentRewriteBlock;
    protected GrammarAST currentRewriteRule;
    protected int outerAltNum = 0;
    protected int blockLevel = 0;

    public final int countAltsForRule( CommonTree t ) {
        CommonTree block = (CommonTree)t.getFirstChildWithType(BLOCK);
        int altCount = 0;
        for (int i = 0; i < block.getChildCount(); i++) {
            if (block.getChild(i).getType() == ALT)
                altCount++;
        }
        return altCount;
    }

    protected final void finish() {
        trimGrammar();
    }

    /** Remove any lexer rules from a COMBINED; already passed to lexer */
    protected final void trimGrammar() {
        if ( grammar.type != Grammar.COMBINED ) {
            return;
        }
        // form is (header ... ) ( grammar ID (scope ...) ... ( rule ... ) ( rule ... ) ... )
        GrammarAST p = root;
        // find the grammar spec
        while ( !p.getText().equals( "grammar" ) ) {
            p = (GrammarAST)p.getNextSibling();
        }
        for ( int i = 0; i < p.getChildCount(); i++ ) {
            if ( p.getChild( i ).getType() != RULE )
                continue;

            String ruleName = p.getChild(i).getChild(0).getText();
            //Console.Out.WriteLine( "rule " + ruleName + " prev=" + prev.getText() );
            if (Rule.getRuleType(ruleName) == Grammar.LEXER) {
                // remove lexer rule
                p.deleteChild( i );
                i--;
            }
        }
        //Console.Out.WriteLine( "root after removal is: " + root.ToStringList() );
    }

    protected final void trackInlineAction( GrammarAST actionAST ) {
        Rule r = grammar.getRule( currentRuleName );
        if ( r != null ) {
            r.trackInlineAction( actionAST );
        }
    }


    public static class grammar__return extends TreeRuleReturnScope {
    };

    // $ANTLR start "grammar_"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:107:1: public grammar_[Grammar g] : ( ^( LEXER_GRAMMAR grammarSpec ) | ^( PARSER_GRAMMAR grammarSpec ) | ^( TREE_GRAMMAR grammarSpec ) | ^( COMBINED_GRAMMAR grammarSpec ) );
    public final DefineGrammarItemsWalker.grammar__return grammar_(Grammar g) throws RecognitionException {
        DefineGrammarItemsWalker.grammar__return retval = new DefineGrammarItemsWalker.grammar__return();
        retval.start = input.LT(1);


        grammar = g;
        root = ((GrammarAST)retval.start);

        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:118:2: ( ^( LEXER_GRAMMAR grammarSpec ) | ^( PARSER_GRAMMAR grammarSpec ) | ^( TREE_GRAMMAR grammarSpec ) | ^( COMBINED_GRAMMAR grammarSpec ) )
            int alt1=4;
            switch ( input.LA(1) ) {
            case LEXER_GRAMMAR:
                {
                alt1=1;
                }
                break;
            case PARSER_GRAMMAR:
                {
                alt1=2;
                }
                break;
            case TREE_GRAMMAR:
                {
                alt1=3;
                }
                break;
            case COMBINED_GRAMMAR:
                {
                alt1=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:118:4: ^( LEXER_GRAMMAR grammarSpec )
                    {
                    match(input,LEXER_GRAMMAR,FOLLOW_LEXER_GRAMMAR_in_grammar_70); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {
                      grammar.type = Grammar.LEXER;
                    }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_grammarSpec_in_grammar_76);
                    grammarSpec();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:119:4: ^( PARSER_GRAMMAR grammarSpec )
                    {
                    match(input,PARSER_GRAMMAR,FOLLOW_PARSER_GRAMMAR_in_grammar_85); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {
                      grammar.type = Grammar.PARSER;
                    }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_grammarSpec_in_grammar_90);
                    grammarSpec();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:120:4: ^( TREE_GRAMMAR grammarSpec )
                    {
                    match(input,TREE_GRAMMAR,FOLLOW_TREE_GRAMMAR_in_grammar_99); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {
                      grammar.type = Grammar.TREE_PARSER;
                    }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_grammarSpec_in_grammar_104);
                    grammarSpec();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    }
                    break;
                case 4 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:121:4: ^( COMBINED_GRAMMAR grammarSpec )
                    {
                    match(input,COMBINED_GRAMMAR,FOLLOW_COMBINED_GRAMMAR_in_grammar_113); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {
                      grammar.type = Grammar.COMBINED;
                    }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_grammarSpec_in_grammar_118);
                    grammarSpec();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    }
                    break;

            }
            if ( state.backtracking==0 ) {

              finish();

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "grammar_"


    // $ANTLR start "attrScope"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:124:1: attrScope : ^( 'scope' name= ID ( attrScopeAction )* attrs= ACTION ) ;
    public final void attrScope() throws RecognitionException {
        AttributeScopeActions_stack.push(new AttributeScopeActions_scope());

        GrammarAST name=null;
        GrammarAST attrs=null;


        	((AttributeScopeActions_scope)AttributeScopeActions_stack.peek()).actions = new HashMap<GrammarAST, GrammarAST>();

        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:130:2: ( ^( 'scope' name= ID ( attrScopeAction )* attrs= ACTION ) )
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:130:4: ^( 'scope' name= ID ( attrScopeAction )* attrs= ACTION )
            {
            match(input,SCOPE,FOLLOW_SCOPE_in_attrScope143); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            name=(GrammarAST)match(input,ID,FOLLOW_ID_in_attrScope147); if (state.failed) return ;
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:130:23: ( attrScopeAction )*
            loop2:
            do {
                int alt2=2;
                switch ( input.LA(1) ) {
                case AMPERSAND:
                    {
                    alt2=1;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:130:23: attrScopeAction
            	    {
            	    pushFollow(FOLLOW_attrScopeAction_in_attrScope149);
            	    attrScopeAction();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            attrs=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_attrScope154); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			AttributeScope scope = grammar.defineGlobalScope((name!=null?name.getText():null),attrs.getToken());
              			scope.isDynamicGlobalScope = true;
              			scope.addAttributes((attrs!=null?attrs.getText():null), ';');
              			for (GrammarAST action : ((AttributeScopeActions_scope)AttributeScopeActions_stack.peek()).actions.keySet())
              				scope.defineNamedAction(action, ((AttributeScopeActions_scope)AttributeScopeActions_stack.peek()).actions.get(action));
              		
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            AttributeScopeActions_stack.pop();

        }
        return ;
    }
    // $ANTLR end "attrScope"


    // $ANTLR start "attrScopeAction"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:140:1: attrScopeAction : ^( AMPERSAND ID ACTION ) ;
    public final void attrScopeAction() throws RecognitionException {
        GrammarAST ID1=null;
        GrammarAST ACTION2=null;

        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:141:2: ( ^( AMPERSAND ID ACTION ) )
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:141:4: ^( AMPERSAND ID ACTION )
            {
            match(input,AMPERSAND,FOLLOW_AMPERSAND_in_attrScopeAction172); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            ID1=(GrammarAST)match(input,ID,FOLLOW_ID_in_attrScopeAction174); if (state.failed) return ;
            ACTION2=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_attrScopeAction176); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			((AttributeScopeActions_scope)AttributeScopeActions_stack.peek()).actions.put( ID1, ACTION2 );
              		
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "attrScopeAction"


    // $ANTLR start "grammarSpec"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:147:1: grammarSpec : id= ID (cmt= DOC_COMMENT )? ( optionsSpec )? ( delegateGrammars )? ( tokensSpec )? ( attrScope )* ( actions )? rules ;
    public final void grammarSpec() throws RecognitionException {
        GrammarAST id=null;
        GrammarAST cmt=null;

        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:148:2: (id= ID (cmt= DOC_COMMENT )? ( optionsSpec )? ( delegateGrammars )? ( tokensSpec )? ( attrScope )* ( actions )? rules )
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:148:4: id= ID (cmt= DOC_COMMENT )? ( optionsSpec )? ( delegateGrammars )? ( tokensSpec )? ( attrScope )* ( actions )? rules
            {
            id=(GrammarAST)match(input,ID,FOLLOW_ID_in_grammarSpec194); if (state.failed) return ;
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:149:3: (cmt= DOC_COMMENT )?
            int alt3=2;
            switch ( input.LA(1) ) {
                case DOC_COMMENT:
                    {
                    alt3=1;
                    }
                    break;
            }

            switch (alt3) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:149:4: cmt= DOC_COMMENT
                    {
                    cmt=(GrammarAST)match(input,DOC_COMMENT,FOLLOW_DOC_COMMENT_in_grammarSpec201); if (state.failed) return ;

                    }
                    break;

            }

            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:150:3: ( optionsSpec )?
            int alt4=2;
            switch ( input.LA(1) ) {
                case OPTIONS:
                    {
                    alt4=1;
                    }
                    break;
            }

            switch (alt4) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:150:5: optionsSpec
                    {
                    pushFollow(FOLLOW_optionsSpec_in_grammarSpec209);
                    optionsSpec();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:151:3: ( delegateGrammars )?
            int alt5=2;
            switch ( input.LA(1) ) {
                case IMPORT:
                    {
                    alt5=1;
                    }
                    break;
            }

            switch (alt5) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:151:4: delegateGrammars
                    {
                    pushFollow(FOLLOW_delegateGrammars_in_grammarSpec217);
                    delegateGrammars();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:152:3: ( tokensSpec )?
            int alt6=2;
            switch ( input.LA(1) ) {
                case TOKENS:
                    {
                    alt6=1;
                    }
                    break;
            }

            switch (alt6) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:152:4: tokensSpec
                    {
                    pushFollow(FOLLOW_tokensSpec_in_grammarSpec224);
                    tokensSpec();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:153:3: ( attrScope )*
            loop7:
            do {
                int alt7=2;
                switch ( input.LA(1) ) {
                case SCOPE:
                    {
                    alt7=1;
                    }
                    break;

                }

                switch (alt7) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:153:4: attrScope
            	    {
            	    pushFollow(FOLLOW_attrScope_in_grammarSpec231);
            	    attrScope();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:154:3: ( actions )?
            int alt8=2;
            switch ( input.LA(1) ) {
                case AMPERSAND:
                    {
                    alt8=1;
                    }
                    break;
            }

            switch (alt8) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:154:4: actions
                    {
                    pushFollow(FOLLOW_actions_in_grammarSpec238);
                    actions();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            pushFollow(FOLLOW_rules_in_grammarSpec244);
            rules();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "grammarSpec"


    // $ANTLR start "actions"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:158:1: actions : ( action )+ ;
    public final void actions() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:159:2: ( ( action )+ )
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:159:4: ( action )+
            {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:159:4: ( action )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                switch ( input.LA(1) ) {
                case AMPERSAND:
                    {
                    alt9=1;
                    }
                    break;

                }

                switch (alt9) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:159:6: action
            	    {
            	    pushFollow(FOLLOW_action_in_actions257);
            	    action();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "actions"


    // $ANTLR start "action"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:162:1: action : ^(amp= AMPERSAND id1= ID (id2= ID a1= ACTION | a2= ACTION ) ) ;
    public final void action() throws RecognitionException {
        GrammarAST amp=null;
        GrammarAST id1=null;
        GrammarAST id2=null;
        GrammarAST a1=null;
        GrammarAST a2=null;


        	String scope=null;
        	GrammarAST nameAST=null, actionAST=null;

        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:168:2: ( ^(amp= AMPERSAND id1= ID (id2= ID a1= ACTION | a2= ACTION ) ) )
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:168:4: ^(amp= AMPERSAND id1= ID (id2= ID a1= ACTION | a2= ACTION ) )
            {
            amp=(GrammarAST)match(input,AMPERSAND,FOLLOW_AMPERSAND_in_action279); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            id1=(GrammarAST)match(input,ID,FOLLOW_ID_in_action283); if (state.failed) return ;
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:169:4: (id2= ID a1= ACTION | a2= ACTION )
            int alt10=2;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt10=1;
                }
                break;
            case ACTION:
                {
                alt10=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:169:6: id2= ID a1= ACTION
                    {
                    id2=(GrammarAST)match(input,ID,FOLLOW_ID_in_action292); if (state.failed) return ;
                    a1=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_action296); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      scope=(id1!=null?id1.getText():null); nameAST=id2; actionAST=a1;
                    }

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:171:6: a2= ACTION
                    {
                    a2=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_action312); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      scope=null; nameAST=id1; actionAST=a2;
                    }

                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              		 grammar.defineNamedAction(amp,scope,nameAST,actionAST);
              		 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "action"


    // $ANTLR start "optionsSpec"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:180:1: optionsSpec : ^( OPTIONS ( . )* ) ;
    public final void optionsSpec() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:181:2: ( ^( OPTIONS ( . )* ) )
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:181:4: ^( OPTIONS ( . )* )
            {
            match(input,OPTIONS,FOLLOW_OPTIONS_in_optionsSpec346); if (state.failed) return ;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return ;
                // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:181:14: ( . )*
                loop11:
                do {
                    int alt11=2;
                    switch ( input.LA(1) ) {
                    case LEXER:
                    case PARSER:
                    case CATCH:
                    case FINALLY:
                    case GRAMMAR:
                    case PRIVATE:
                    case PROTECTED:
                    case PUBLIC:
                    case RETURNS:
                    case THROWS:
                    case TREE:
                    case RULE:
                    case PREC_RULE:
                    case RECURSIVE_RULE_REF:
                    case BLOCK:
                    case OPTIONAL:
                    case CLOSURE:
                    case POSITIVE_CLOSURE:
                    case SYNPRED:
                    case RANGE:
                    case CHAR_RANGE:
                    case EPSILON:
                    case ALT:
                    case EOR:
                    case EOB:
                    case EOA:
                    case ID:
                    case ARG:
                    case ARGLIST:
                    case RET:
                    case LEXER_GRAMMAR:
                    case PARSER_GRAMMAR:
                    case TREE_GRAMMAR:
                    case COMBINED_GRAMMAR:
                    case INITACTION:
                    case FORCED_ACTION:
                    case LABEL:
                    case TEMPLATE:
                    case SCOPE:
                    case IMPORT:
                    case GATED_SEMPRED:
                    case SYN_SEMPRED:
                    case BACKTRACK_SEMPRED:
                    case FRAGMENT:
                    case DOT:
                    case REWRITES:
                    case ACTION:
                    case DOC_COMMENT:
                    case SEMI:
                    case AMPERSAND:
                    case COLON:
                    case OPTIONS:
                    case RCURLY:
                    case ASSIGN:
                    case STRING_LITERAL:
                    case CHAR_LITERAL:
                    case INT:
                    case STAR:
                    case COMMA:
                    case TOKENS:
                    case TOKEN_REF:
                    case BANG:
                    case ARG_ACTION:
                    case OR:
                    case LPAREN:
                    case RPAREN:
                    case PLUS_ASSIGN:
                    case SEMPRED:
                    case IMPLIES:
                    case ROOT:
                    case WILDCARD:
                    case RULE_REF:
                    case NOT:
                    case TREE_BEGIN:
                    case QUESTION:
                    case PLUS:
                    case OPEN_ELEMENT_OPTION:
                    case CLOSE_ELEMENT_OPTION:
                    case DOUBLE_QUOTE_STRING_LITERAL:
                    case DOUBLE_ANGLE_STRING_LITERAL:
                    case REWRITE:
                    case ETC:
                    case DOLLAR:
                    case WS:
                    case SL_COMMENT:
                    case ML_COMMENT:
                    case COMMENT:
                    case SRC:
                    case STRAY_BRACKET:
                    case ESC:
                    case DIGIT:
                    case XDIGIT:
                    case NESTED_ARG_ACTION:
                    case ACTION_STRING_LITERAL:
                    case ACTION_CHAR_LITERAL:
                    case NESTED_ACTION:
                    case ACTION_ESC:
                    case WS_LOOP:
                    case WS_OPT:
                        {
                        alt11=1;
                        }
                        break;
                    case UP:
                        {
                        alt11=2;
                        }
                        break;

                    }

                    switch (alt11) {
                	case 1 :
                	    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:181:14: .
                	    {
                	    matchAny(input); if (state.failed) return ;

                	    }
                	    break;

                	default :
                	    break loop11;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return ;
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "optionsSpec"


    // $ANTLR start "delegateGrammars"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:184:1: delegateGrammars : ^( 'import' ( ^( ASSIGN ID ID ) | ID )+ ) ;
    public final void delegateGrammars() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:185:2: ( ^( 'import' ( ^( ASSIGN ID ID ) | ID )+ ) )
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:185:4: ^( 'import' ( ^( ASSIGN ID ID ) | ID )+ )
            {
            match(input,IMPORT,FOLLOW_IMPORT_in_delegateGrammars363); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:185:16: ( ^( ASSIGN ID ID ) | ID )+
            int cnt12=0;
            loop12:
            do {
                int alt12=3;
                switch ( input.LA(1) ) {
                case ASSIGN:
                    {
                    alt12=1;
                    }
                    break;
                case ID:
                    {
                    alt12=2;
                    }
                    break;

                }

                switch (alt12) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:185:18: ^( ASSIGN ID ID )
            	    {
            	    match(input,ASSIGN,FOLLOW_ASSIGN_in_delegateGrammars368); if (state.failed) return ;

            	    match(input, Token.DOWN, null); if (state.failed) return ;
            	    match(input,ID,FOLLOW_ID_in_delegateGrammars370); if (state.failed) return ;
            	    match(input,ID,FOLLOW_ID_in_delegateGrammars372); if (state.failed) return ;

            	    match(input, Token.UP, null); if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:185:36: ID
            	    {
            	    match(input,ID,FOLLOW_ID_in_delegateGrammars377); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "delegateGrammars"


    // $ANTLR start "tokensSpec"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:188:1: tokensSpec : ^( TOKENS ( tokenSpec )* ) ;
    public final void tokensSpec() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:189:2: ( ^( TOKENS ( tokenSpec )* ) )
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:189:4: ^( TOKENS ( tokenSpec )* )
            {
            match(input,TOKENS,FOLLOW_TOKENS_in_tokensSpec394); if (state.failed) return ;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return ;
                // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:189:13: ( tokenSpec )*
                loop13:
                do {
                    int alt13=2;
                    switch ( input.LA(1) ) {
                    case ASSIGN:
                    case TOKEN_REF:
                        {
                        alt13=1;
                        }
                        break;

                    }

                    switch (alt13) {
                	case 1 :
                	    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:189:13: tokenSpec
                	    {
                	    pushFollow(FOLLOW_tokenSpec_in_tokensSpec396);
                	    tokenSpec();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }
                	    break;

                	default :
                	    break loop13;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return ;
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "tokensSpec"


    // $ANTLR start "tokenSpec"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:192:1: tokenSpec : (t= TOKEN_REF | ^( ASSIGN TOKEN_REF ( STRING_LITERAL | CHAR_LITERAL ) ) );
    public final void tokenSpec() throws RecognitionException {
        GrammarAST t=null;

        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:193:2: (t= TOKEN_REF | ^( ASSIGN TOKEN_REF ( STRING_LITERAL | CHAR_LITERAL ) ) )
            int alt14=2;
            switch ( input.LA(1) ) {
            case TOKEN_REF:
                {
                alt14=1;
                }
                break;
            case ASSIGN:
                {
                alt14=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:193:4: t= TOKEN_REF
                    {
                    t=(GrammarAST)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_tokenSpec411); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:194:4: ^( ASSIGN TOKEN_REF ( STRING_LITERAL | CHAR_LITERAL ) )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_tokenSpec418); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_tokenSpec423); if (state.failed) return ;
                    if ( (input.LA(1)>=STRING_LITERAL && input.LA(1)<=CHAR_LITERAL) ) {
                        input.consume();
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "tokenSpec"


    // $ANTLR start "rules"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:202:1: rules : ( rule | ^( PREC_RULE ( . )* ) )+ ;
    public final void rules() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:203:2: ( ( rule | ^( PREC_RULE ( . )* ) )+ )
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:203:4: ( rule | ^( PREC_RULE ( . )* ) )+
            {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:203:4: ( rule | ^( PREC_RULE ( . )* ) )+
            int cnt16=0;
            loop16:
            do {
                int alt16=3;
                switch ( input.LA(1) ) {
                case RULE:
                    {
                    alt16=1;
                    }
                    break;
                case PREC_RULE:
                    {
                    alt16=2;
                    }
                    break;

                }

                switch (alt16) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:203:5: rule
            	    {
            	    pushFollow(FOLLOW_rule_in_rules459);
            	    rule();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:203:12: ^( PREC_RULE ( . )* )
            	    {
            	    match(input,PREC_RULE,FOLLOW_PREC_RULE_in_rules464); if (state.failed) return ;

            	    if ( input.LA(1)==Token.DOWN ) {
            	        match(input, Token.DOWN, null); if (state.failed) return ;
            	        // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:203:24: ( . )*
            	        loop15:
            	        do {
            	            int alt15=2;
            	            switch ( input.LA(1) ) {
            	            case LEXER:
            	            case PARSER:
            	            case CATCH:
            	            case FINALLY:
            	            case GRAMMAR:
            	            case PRIVATE:
            	            case PROTECTED:
            	            case PUBLIC:
            	            case RETURNS:
            	            case THROWS:
            	            case TREE:
            	            case RULE:
            	            case PREC_RULE:
            	            case RECURSIVE_RULE_REF:
            	            case BLOCK:
            	            case OPTIONAL:
            	            case CLOSURE:
            	            case POSITIVE_CLOSURE:
            	            case SYNPRED:
            	            case RANGE:
            	            case CHAR_RANGE:
            	            case EPSILON:
            	            case ALT:
            	            case EOR:
            	            case EOB:
            	            case EOA:
            	            case ID:
            	            case ARG:
            	            case ARGLIST:
            	            case RET:
            	            case LEXER_GRAMMAR:
            	            case PARSER_GRAMMAR:
            	            case TREE_GRAMMAR:
            	            case COMBINED_GRAMMAR:
            	            case INITACTION:
            	            case FORCED_ACTION:
            	            case LABEL:
            	            case TEMPLATE:
            	            case SCOPE:
            	            case IMPORT:
            	            case GATED_SEMPRED:
            	            case SYN_SEMPRED:
            	            case BACKTRACK_SEMPRED:
            	            case FRAGMENT:
            	            case DOT:
            	            case REWRITES:
            	            case ACTION:
            	            case DOC_COMMENT:
            	            case SEMI:
            	            case AMPERSAND:
            	            case COLON:
            	            case OPTIONS:
            	            case RCURLY:
            	            case ASSIGN:
            	            case STRING_LITERAL:
            	            case CHAR_LITERAL:
            	            case INT:
            	            case STAR:
            	            case COMMA:
            	            case TOKENS:
            	            case TOKEN_REF:
            	            case BANG:
            	            case ARG_ACTION:
            	            case OR:
            	            case LPAREN:
            	            case RPAREN:
            	            case PLUS_ASSIGN:
            	            case SEMPRED:
            	            case IMPLIES:
            	            case ROOT:
            	            case WILDCARD:
            	            case RULE_REF:
            	            case NOT:
            	            case TREE_BEGIN:
            	            case QUESTION:
            	            case PLUS:
            	            case OPEN_ELEMENT_OPTION:
            	            case CLOSE_ELEMENT_OPTION:
            	            case DOUBLE_QUOTE_STRING_LITERAL:
            	            case DOUBLE_ANGLE_STRING_LITERAL:
            	            case REWRITE:
            	            case ETC:
            	            case DOLLAR:
            	            case WS:
            	            case SL_COMMENT:
            	            case ML_COMMENT:
            	            case COMMENT:
            	            case SRC:
            	            case STRAY_BRACKET:
            	            case ESC:
            	            case DIGIT:
            	            case XDIGIT:
            	            case NESTED_ARG_ACTION:
            	            case ACTION_STRING_LITERAL:
            	            case ACTION_CHAR_LITERAL:
            	            case NESTED_ACTION:
            	            case ACTION_ESC:
            	            case WS_LOOP:
            	            case WS_OPT:
            	                {
            	                alt15=1;
            	                }
            	                break;
            	            case UP:
            	                {
            	                alt15=2;
            	                }
            	                break;

            	            }

            	            switch (alt15) {
            	        	case 1 :
            	        	    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:203:24: .
            	        	    {
            	        	    matchAny(input); if (state.failed) return ;

            	        	    }
            	        	    break;

            	        	default :
            	        	    break loop15;
            	            }
            	        } while (true);


            	        match(input, Token.UP, null); if (state.failed) return ;
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "rules"

    public static class rule_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "rule"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:206:1: rule : ^( RULE id= ID ( modifier )? ^( ARG (args= ARG_ACTION )? ) ^( RET (ret= ARG_ACTION )? ) ( throwsSpec )? ( optionsSpec )? ( ruleScopeSpec[r] )? ( ruleAction[r] )* b= block ( exceptionGroup )? EOR ) ;
    public final DefineGrammarItemsWalker.rule_return rule() throws RecognitionException {
        DefineGrammarItemsWalker.rule_return retval = new DefineGrammarItemsWalker.rule_return();
        retval.start = input.LT(1);

        GrammarAST id=null;
        GrammarAST args=null;
        GrammarAST ret=null;
        GrammarAST RULE3=null;
        DefineGrammarItemsWalker.block_return b = null;

        DefineGrammarItemsWalker.modifier_return modifier4 = null;

        HashSet<String> throwsSpec5 = null;



        	String name=null;
        	Map<String, Object> opts=null;
        	Rule r = null;

        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:213:2: ( ^( RULE id= ID ( modifier )? ^( ARG (args= ARG_ACTION )? ) ^( RET (ret= ARG_ACTION )? ) ( throwsSpec )? ( optionsSpec )? ( ruleScopeSpec[r] )? ( ruleAction[r] )* b= block ( exceptionGroup )? EOR ) )
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:213:5: ^( RULE id= ID ( modifier )? ^( ARG (args= ARG_ACTION )? ) ^( RET (ret= ARG_ACTION )? ) ( throwsSpec )? ( optionsSpec )? ( ruleScopeSpec[r] )? ( ruleAction[r] )* b= block ( exceptionGroup )? EOR )
            {
            RULE3=(GrammarAST)match(input,RULE,FOLLOW_RULE_in_rule489); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            id=(GrammarAST)match(input,ID,FOLLOW_ID_in_rule493); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              opts = RULE3.getBlockOptions();
            }
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:214:4: ( modifier )?
            int alt17=2;
            switch ( input.LA(1) ) {
                case PRIVATE:
                case PROTECTED:
                case PUBLIC:
                case FRAGMENT:
                    {
                    alt17=1;
                    }
                    break;
            }

            switch (alt17) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:214:5: modifier
                    {
                    pushFollow(FOLLOW_modifier_in_rule501);
                    modifier4=modifier();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }

            match(input,ARG,FOLLOW_ARG_in_rule510); if (state.failed) return retval;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:215:11: (args= ARG_ACTION )?
                int alt18=2;
                switch ( input.LA(1) ) {
                    case ARG_ACTION:
                        {
                        alt18=1;
                        }
                        break;
                }

                switch (alt18) {
                    case 1 :
                        // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:215:12: args= ARG_ACTION
                        {
                        args=(GrammarAST)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rule515); if (state.failed) return retval;

                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            match(input,RET,FOLLOW_RET_in_rule526); if (state.failed) return retval;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:216:11: (ret= ARG_ACTION )?
                int alt19=2;
                switch ( input.LA(1) ) {
                    case ARG_ACTION:
                        {
                        alt19=1;
                        }
                        break;
                }

                switch (alt19) {
                    case 1 :
                        // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:216:12: ret= ARG_ACTION
                        {
                        ret=(GrammarAST)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rule531); if (state.failed) return retval;

                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:217:4: ( throwsSpec )?
            int alt20=2;
            switch ( input.LA(1) ) {
                case THROWS:
                    {
                    alt20=1;
                    }
                    break;
            }

            switch (alt20) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:217:5: throwsSpec
                    {
                    pushFollow(FOLLOW_throwsSpec_in_rule541);
                    throwsSpec5=throwsSpec();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }

            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:218:4: ( optionsSpec )?
            int alt21=2;
            switch ( input.LA(1) ) {
                case OPTIONS:
                    {
                    alt21=1;
                    }
                    break;
            }

            switch (alt21) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:218:5: optionsSpec
                    {
                    pushFollow(FOLLOW_optionsSpec_in_rule549);
                    optionsSpec();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              				name = (id!=null?id.getText():null);
              				currentRuleName = name;
              				if ( Rule.getRuleType(name) == Grammar.LEXER && grammar.type==Grammar.COMBINED )
              				{
              					// a merged grammar spec, track lexer rules and send to another grammar
              					grammar.defineLexerRuleFoundInParser(id.getToken(), ((GrammarAST)retval.start));
              				}
              				else
              				{
              					int numAlts = countAltsForRule(((GrammarAST)retval.start));
              					grammar.defineRule(id.getToken(), (modifier4!=null?modifier4.mod:null), opts, ((GrammarAST)retval.start), args, numAlts);
              					r = grammar.getRule(name);
              					if ( args!=null )
              					{
              						r.parameterScope = grammar.createParameterScope(name,args.getToken());
              						r.parameterScope.addAttributes((args!=null?args.getText():null), ',');
              					}
              					if ( ret!=null )
              					{
              						r.returnScope = grammar.createReturnScope(name,ret.getToken());
              						r.returnScope.addAttributes((ret!=null?ret.getText():null), ',');
              					}
              					if ( throwsSpec5 != null )
              					{
              						for (String exception : throwsSpec5)
              							r.throwsSpec.add( exception );
              					}
              				}
              			
            }
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:249:4: ( ruleScopeSpec[r] )?
            int alt22=2;
            switch ( input.LA(1) ) {
                case SCOPE:
                    {
                    alt22=1;
                    }
                    break;
            }

            switch (alt22) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:249:5: ruleScopeSpec[r]
                    {
                    pushFollow(FOLLOW_ruleScopeSpec_in_rule562);
                    ruleScopeSpec(r);

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }

            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:250:4: ( ruleAction[r] )*
            loop23:
            do {
                int alt23=2;
                switch ( input.LA(1) ) {
                case AMPERSAND:
                    {
                    alt23=1;
                    }
                    break;

                }

                switch (alt23) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:250:5: ruleAction[r]
            	    {
            	    pushFollow(FOLLOW_ruleAction_in_rule571);
            	    ruleAction(r);

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               this.blockLevel=0; 
            }
            pushFollow(FOLLOW_block_in_rule586);
            b=block();

            state._fsp--;
            if (state.failed) return retval;
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:253:4: ( exceptionGroup )?
            int alt24=2;
            switch ( input.LA(1) ) {
                case CATCH:
                case FINALLY:
                    {
                    alt24=1;
                    }
                    break;
            }

            switch (alt24) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:253:5: exceptionGroup
                    {
                    pushFollow(FOLLOW_exceptionGroup_in_rule592);
                    exceptionGroup();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }

            match(input,EOR,FOLLOW_EOR_in_rule599); if (state.failed) return retval;
            if ( state.backtracking==0 ) {

              				// copy rule options into the block AST, which is where
              				// the analysis will look for k option etc...
              				(b!=null?((GrammarAST)b.start):null).setBlockOptions(opts);
              			
            }

            match(input, Token.UP, null); if (state.failed) return retval;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rule"


    // $ANTLR start "ruleAction"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:263:1: ruleAction[Rule r] : ^(amp= AMPERSAND id= ID a= ACTION ) ;
    public final void ruleAction(Rule r) throws RecognitionException {
        GrammarAST amp=null;
        GrammarAST id=null;
        GrammarAST a=null;

        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:264:2: ( ^(amp= AMPERSAND id= ID a= ACTION ) )
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:264:4: ^(amp= AMPERSAND id= ID a= ACTION )
            {
            amp=(GrammarAST)match(input,AMPERSAND,FOLLOW_AMPERSAND_in_ruleAction623); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            id=(GrammarAST)match(input,ID,FOLLOW_ID_in_ruleAction627); if (state.failed) return ;
            a=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_ruleAction631); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              if (r!=null) r.defineNamedAction(amp,id,a);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleAction"

    public static class modifier_return extends TreeRuleReturnScope {
        public String mod;
    };

    // $ANTLR start "modifier"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:267:1: modifier returns [String mod] : ( 'protected' | 'public' | 'private' | 'fragment' );
    public final DefineGrammarItemsWalker.modifier_return modifier() throws RecognitionException {
        DefineGrammarItemsWalker.modifier_return retval = new DefineGrammarItemsWalker.modifier_return();
        retval.start = input.LT(1);


        	retval.mod = ((GrammarAST)retval.start).getToken().getText();

        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:272:2: ( 'protected' | 'public' | 'private' | 'fragment' )
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:
            {
            if ( (input.LA(1)>=PRIVATE && input.LA(1)<=PUBLIC)||input.LA(1)==FRAGMENT ) {
                input.consume();
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "modifier"


    // $ANTLR start "throwsSpec"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:278:1: throwsSpec returns [HashSet<String> exceptions] : ^( 'throws' ( ID )+ ) ;
    public final HashSet<String> throwsSpec() throws RecognitionException {
        HashSet<String> exceptions = null;

        GrammarAST ID6=null;


        	exceptions = new HashSet<String>();

        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:283:2: ( ^( 'throws' ( ID )+ ) )
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:283:4: ^( 'throws' ( ID )+ )
            {
            match(input,THROWS,FOLLOW_THROWS_in_throwsSpec691); if (state.failed) return exceptions;

            match(input, Token.DOWN, null); if (state.failed) return exceptions;
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:283:15: ( ID )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                switch ( input.LA(1) ) {
                case ID:
                    {
                    alt25=1;
                    }
                    break;

                }

                switch (alt25) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:283:16: ID
            	    {
            	    ID6=(GrammarAST)match(input,ID,FOLLOW_ID_in_throwsSpec694); if (state.failed) return exceptions;
            	    if ( state.backtracking==0 ) {
            	      exceptions.add((ID6!=null?ID6.getText():null));
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt25 >= 1 ) break loop25;
            	    if (state.backtracking>0) {state.failed=true; return exceptions;}
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return exceptions;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return exceptions;
    }
    // $ANTLR end "throwsSpec"


    // $ANTLR start "ruleScopeSpec"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:286:1: ruleScopeSpec[Rule r] : ^( 'scope' ( ( attrScopeAction )* attrs= ACTION )? (uses= ID )* ) ;
    public final void ruleScopeSpec(Rule r) throws RecognitionException {
        AttributeScopeActions_stack.push(new AttributeScopeActions_scope());

        GrammarAST attrs=null;
        GrammarAST uses=null;


        	((AttributeScopeActions_scope)AttributeScopeActions_stack.peek()).actions = new HashMap<GrammarAST, GrammarAST>();

        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:292:2: ( ^( 'scope' ( ( attrScopeAction )* attrs= ACTION )? (uses= ID )* ) )
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:292:4: ^( 'scope' ( ( attrScopeAction )* attrs= ACTION )? (uses= ID )* )
            {
            match(input,SCOPE,FOLLOW_SCOPE_in_ruleScopeSpec724); if (state.failed) return ;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return ;
                // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:293:4: ( ( attrScopeAction )* attrs= ACTION )?
                int alt27=2;
                switch ( input.LA(1) ) {
                    case ACTION:
                    case AMPERSAND:
                        {
                        alt27=1;
                        }
                        break;
                }

                switch (alt27) {
                    case 1 :
                        // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:293:6: ( attrScopeAction )* attrs= ACTION
                        {
                        // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:293:6: ( attrScopeAction )*
                        loop26:
                        do {
                            int alt26=2;
                            switch ( input.LA(1) ) {
                            case AMPERSAND:
                                {
                                alt26=1;
                                }
                                break;

                            }

                            switch (alt26) {
                        	case 1 :
                        	    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:293:6: attrScopeAction
                        	    {
                        	    pushFollow(FOLLOW_attrScopeAction_in_ruleScopeSpec731);
                        	    attrScopeAction();

                        	    state._fsp--;
                        	    if (state.failed) return ;

                        	    }
                        	    break;

                        	default :
                        	    break loop26;
                            }
                        } while (true);

                        attrs=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_ruleScopeSpec736); if (state.failed) return ;
                        if ( state.backtracking==0 ) {

                          					r.ruleScope = grammar.createRuleScope(r.name,attrs.getToken());
                          					r.ruleScope.isDynamicRuleScope = true;
                          					r.ruleScope.addAttributes((attrs!=null?attrs.getText():null), ';');
                          					for (GrammarAST action : ((AttributeScopeActions_scope)AttributeScopeActions_stack.peek()).actions.keySet())
                          						r.ruleScope.defineNamedAction(action, ((AttributeScopeActions_scope)AttributeScopeActions_stack.peek()).actions.get(action));
                          				
                        }

                        }
                        break;

                }

                // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:302:4: (uses= ID )*
                loop28:
                do {
                    int alt28=2;
                    switch ( input.LA(1) ) {
                    case ID:
                        {
                        alt28=1;
                        }
                        break;

                    }

                    switch (alt28) {
                	case 1 :
                	    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:302:6: uses= ID
                	    {
                	    uses=(GrammarAST)match(input,ID,FOLLOW_ID_in_ruleScopeSpec757); if (state.failed) return ;
                	    if ( state.backtracking==0 ) {

                	      					if ( grammar.getGlobalScope((uses!=null?uses.getText():null))==null ) {
                	      					ErrorManager.grammarError(ErrorManager.MSG_UNKNOWN_DYNAMIC_SCOPE,
                	      					grammar,
                	      					uses.getToken(),
                	      					(uses!=null?uses.getText():null));
                	      					}
                	      					else {
                	      					if ( r.useScopes==null ) {r.useScopes=new ArrayList<String>();}
                	      					r.useScopes.add((uses!=null?uses.getText():null));
                	      					}
                	      				
                	    }

                	    }
                	    break;

                	default :
                	    break loop28;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return ;
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            AttributeScopeActions_stack.pop();

        }
        return ;
    }
    // $ANTLR end "ruleScopeSpec"

    public static class block_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "block"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:319:1: block : ^( BLOCK ( optionsSpec )? ( blockAction )* ( alternative rewrite )+ EOB ) ;
    public final DefineGrammarItemsWalker.block_return block() throws RecognitionException {
        DefineGrammarItemsWalker.block_return retval = new DefineGrammarItemsWalker.block_return();
        retval.start = input.LT(1);


        	// must run during backtracking
        	this.blockLevel++;
        	if ( blockLevel == 1 )
        		this.outerAltNum=1;

        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:327:2: ( ^( BLOCK ( optionsSpec )? ( blockAction )* ( alternative rewrite )+ EOB ) )
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:327:4: ^( BLOCK ( optionsSpec )? ( blockAction )* ( alternative rewrite )+ EOB )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_block791); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:328:4: ( optionsSpec )?
            int alt29=2;
            switch ( input.LA(1) ) {
                case OPTIONS:
                    {
                    alt29=1;
                    }
                    break;
            }

            switch (alt29) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:328:5: optionsSpec
                    {
                    pushFollow(FOLLOW_optionsSpec_in_block797);
                    optionsSpec();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }

            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:329:4: ( blockAction )*
            loop30:
            do {
                int alt30=2;
                switch ( input.LA(1) ) {
                case AMPERSAND:
                    {
                    alt30=1;
                    }
                    break;

                }

                switch (alt30) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:329:5: blockAction
            	    {
            	    pushFollow(FOLLOW_blockAction_in_block805);
            	    blockAction();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:330:4: ( alternative rewrite )+
            int cnt31=0;
            loop31:
            do {
                int alt31=2;
                switch ( input.LA(1) ) {
                case ALT:
                    {
                    alt31=1;
                    }
                    break;

                }

                switch (alt31) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:330:6: alternative rewrite
            	    {
            	    pushFollow(FOLLOW_alternative_in_block814);
            	    alternative();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    pushFollow(FOLLOW_rewrite_in_block816);
            	    rewrite();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    					if ( this.blockLevel == 1 )
            	    						this.outerAltNum++;
            	    				

            	    }
            	    break;

            	default :
            	    if ( cnt31 >= 1 ) break loop31;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(31, input);
                        throw eee;
                }
                cnt31++;
            } while (true);

            match(input,EOB,FOLLOW_EOB_in_block833); if (state.failed) return retval;

            match(input, Token.UP, null); if (state.failed) return retval;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
             blockLevel--; 
        }
        return retval;
    }
    // $ANTLR end "block"


    // $ANTLR start "blockAction"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:342:1: blockAction : ^(amp= AMPERSAND id= ID a= ACTION ) ;
    public final void blockAction() throws RecognitionException {
        GrammarAST amp=null;
        GrammarAST id=null;
        GrammarAST a=null;

        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:343:2: ( ^(amp= AMPERSAND id= ID a= ACTION ) )
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:343:4: ^(amp= AMPERSAND id= ID a= ACTION )
            {
            amp=(GrammarAST)match(input,AMPERSAND,FOLLOW_AMPERSAND_in_blockAction857); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            id=(GrammarAST)match(input,ID,FOLLOW_ID_in_blockAction861); if (state.failed) return ;
            a=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_blockAction865); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "blockAction"


    // $ANTLR start "alternative"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:346:1: alternative : ^( ALT ( element )+ EOA ) ;
    public final void alternative() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:369:2: ( ^( ALT ( element )+ EOA ) )
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:369:4: ^( ALT ( element )+ EOA )
            {
            match(input,ALT,FOLLOW_ALT_in_alternative903); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:369:11: ( element )+
            int cnt32=0;
            loop32:
            do {
                int alt32=2;
                switch ( input.LA(1) ) {
                case BLOCK:
                case OPTIONAL:
                case CLOSURE:
                case POSITIVE_CLOSURE:
                case SYNPRED:
                case RANGE:
                case CHAR_RANGE:
                case EPSILON:
                case FORCED_ACTION:
                case GATED_SEMPRED:
                case SYN_SEMPRED:
                case BACKTRACK_SEMPRED:
                case DOT:
                case ACTION:
                case ASSIGN:
                case STRING_LITERAL:
                case CHAR_LITERAL:
                case TOKEN_REF:
                case BANG:
                case PLUS_ASSIGN:
                case SEMPRED:
                case ROOT:
                case WILDCARD:
                case RULE_REF:
                case NOT:
                case TREE_BEGIN:
                    {
                    alt32=1;
                    }
                    break;

                }

                switch (alt32) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:369:12: element
            	    {
            	    pushFollow(FOLLOW_element_in_alternative906);
            	    element();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt32 >= 1 ) break loop32;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(32, input);
                        throw eee;
                }
                cnt32++;
            } while (true);

            match(input,EOA,FOLLOW_EOA_in_alternative910); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "alternative"


    // $ANTLR start "exceptionGroup"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:372:1: exceptionGroup : ( ( exceptionHandler )+ ( finallyClause )? | finallyClause );
    public final void exceptionGroup() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:373:2: ( ( exceptionHandler )+ ( finallyClause )? | finallyClause )
            int alt35=2;
            switch ( input.LA(1) ) {
            case CATCH:
                {
                alt35=1;
                }
                break;
            case FINALLY:
                {
                alt35=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:373:4: ( exceptionHandler )+ ( finallyClause )?
                    {
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:373:4: ( exceptionHandler )+
                    int cnt33=0;
                    loop33:
                    do {
                        int alt33=2;
                        switch ( input.LA(1) ) {
                        case CATCH:
                            {
                            alt33=1;
                            }
                            break;

                        }

                        switch (alt33) {
                    	case 1 :
                    	    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:373:6: exceptionHandler
                    	    {
                    	    pushFollow(FOLLOW_exceptionHandler_in_exceptionGroup925);
                    	    exceptionHandler();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt33 >= 1 ) break loop33;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(33, input);
                                throw eee;
                        }
                        cnt33++;
                    } while (true);

                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:373:26: ( finallyClause )?
                    int alt34=2;
                    switch ( input.LA(1) ) {
                        case FINALLY:
                            {
                            alt34=1;
                            }
                            break;
                    }

                    switch (alt34) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:373:27: finallyClause
                            {
                            pushFollow(FOLLOW_finallyClause_in_exceptionGroup931);
                            finallyClause();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:374:4: finallyClause
                    {
                    pushFollow(FOLLOW_finallyClause_in_exceptionGroup938);
                    finallyClause();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "exceptionGroup"


    // $ANTLR start "exceptionHandler"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:377:1: exceptionHandler : ^( 'catch' ARG_ACTION ACTION ) ;
    public final void exceptionHandler() throws RecognitionException {
        GrammarAST ACTION7=null;

        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:378:2: ( ^( 'catch' ARG_ACTION ACTION ) )
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:378:6: ^( 'catch' ARG_ACTION ACTION )
            {
            match(input,CATCH,FOLLOW_CATCH_in_exceptionHandler952); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_exceptionHandler954); if (state.failed) return ;
            ACTION7=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_exceptionHandler956); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              trackInlineAction(ACTION7);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "exceptionHandler"


    // $ANTLR start "finallyClause"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:381:1: finallyClause : ^( 'finally' ACTION ) ;
    public final void finallyClause() throws RecognitionException {
        GrammarAST ACTION8=null;

        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:382:2: ( ^( 'finally' ACTION ) )
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:382:7: ^( 'finally' ACTION )
            {
            match(input,FINALLY,FOLLOW_FINALLY_in_finallyClause974); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            ACTION8=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_finallyClause976); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              trackInlineAction(ACTION8);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "finallyClause"

    public static class element_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "element"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:385:1: element : ( ^( ROOT element ) | ^( BANG element ) | atom[null] | ^( NOT element ) | ^( RANGE atom[null] atom[null] ) | ^( CHAR_RANGE atom[null] atom[null] ) | ^( ASSIGN id= ID el= element ) | ^( PLUS_ASSIGN id2= ID a2= element ) | ebnf | tree_ | ^( SYNPRED block ) | act= ACTION | act2= FORCED_ACTION | SEMPRED | SYN_SEMPRED | ^( BACKTRACK_SEMPRED ( . )* ) | GATED_SEMPRED | EPSILON );
    public final DefineGrammarItemsWalker.element_return element() throws RecognitionException {
        DefineGrammarItemsWalker.element_return retval = new DefineGrammarItemsWalker.element_return();
        retval.start = input.LT(1);

        GrammarAST id=null;
        GrammarAST id2=null;
        GrammarAST act=null;
        GrammarAST act2=null;
        GrammarAST SEMPRED9=null;
        GrammarAST GATED_SEMPRED10=null;
        DefineGrammarItemsWalker.element_return el = null;

        DefineGrammarItemsWalker.element_return a2 = null;


        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:386:2: ( ^( ROOT element ) | ^( BANG element ) | atom[null] | ^( NOT element ) | ^( RANGE atom[null] atom[null] ) | ^( CHAR_RANGE atom[null] atom[null] ) | ^( ASSIGN id= ID el= element ) | ^( PLUS_ASSIGN id2= ID a2= element ) | ebnf | tree_ | ^( SYNPRED block ) | act= ACTION | act2= FORCED_ACTION | SEMPRED | SYN_SEMPRED | ^( BACKTRACK_SEMPRED ( . )* ) | GATED_SEMPRED | EPSILON )
            int alt37=18;
            alt37 = dfa37.predict(input);
            switch (alt37) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:386:6: ^( ROOT element )
                    {
                    match(input,ROOT,FOLLOW_ROOT_in_element993); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_element_in_element995);
                    element();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:387:6: ^( BANG element )
                    {
                    match(input,BANG,FOLLOW_BANG_in_element1004); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_element_in_element1006);
                    element();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:388:6: atom[null]
                    {
                    pushFollow(FOLLOW_atom_in_element1014);
                    atom(null);

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;
                case 4 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:389:6: ^( NOT element )
                    {
                    match(input,NOT,FOLLOW_NOT_in_element1023); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_element_in_element1025);
                    element();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    }
                    break;
                case 5 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:390:6: ^( RANGE atom[null] atom[null] )
                    {
                    match(input,RANGE,FOLLOW_RANGE_in_element1034); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_atom_in_element1036);
                    atom(null);

                    state._fsp--;
                    if (state.failed) return retval;
                    pushFollow(FOLLOW_atom_in_element1039);
                    atom(null);

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    }
                    break;
                case 6 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:391:6: ^( CHAR_RANGE atom[null] atom[null] )
                    {
                    match(input,CHAR_RANGE,FOLLOW_CHAR_RANGE_in_element1049); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_atom_in_element1051);
                    atom(null);

                    state._fsp--;
                    if (state.failed) return retval;
                    pushFollow(FOLLOW_atom_in_element1054);
                    atom(null);

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    }
                    break;
                case 7 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:392:4: ^( ASSIGN id= ID el= element )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_element1063); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    id=(GrammarAST)match(input,ID,FOLLOW_ID_in_element1067); if (state.failed) return retval;
                    pushFollow(FOLLOW_element_in_element1071);
                    el=element();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      				GrammarAST e = (el!=null?((GrammarAST)el.start):null);
                      				if ( e.getType()==ANTLRParser.ROOT || e.getType()==ANTLRParser.BANG )
                      				{
                      					e = (GrammarAST)e.getChild(0);
                      				}
                      				if ( e.getType()==RULE_REF)
                      				{
                      					grammar.defineRuleRefLabel(currentRuleName,id.getToken(),e);
                      				}
                      				else if ( e.getType()==WILDCARD && grammar.type==Grammar.TREE_PARSER )
                      				{
                      					grammar.defineWildcardTreeLabel(currentRuleName,id.getToken(),e);
                      				}
                      				else
                      				{
                      					grammar.defineTokenRefLabel(currentRuleName,id.getToken(),e);
                      				}
                      			
                    }

                    }
                    break;
                case 8 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:412:4: ^( PLUS_ASSIGN id2= ID a2= element )
                    {
                    match(input,PLUS_ASSIGN,FOLLOW_PLUS_ASSIGN_in_element1084); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    id2=(GrammarAST)match(input,ID,FOLLOW_ID_in_element1088); if (state.failed) return retval;
                    pushFollow(FOLLOW_element_in_element1092);
                    a2=element();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      				GrammarAST a = (a2!=null?((GrammarAST)a2.start):null);
                      				if ( a.getType()==ANTLRParser.ROOT || a.getType()==ANTLRParser.BANG )
                      				{
                      					a = (GrammarAST)a.getChild(0);
                      				}
                      				if ( a.getType()==RULE_REF )
                      				{
                      					grammar.defineRuleListLabel(currentRuleName,id2.getToken(),a);
                      				}
                      				else if ( a.getType() == WILDCARD && grammar.type == Grammar.TREE_PARSER )
                      				{
                      					grammar.defineWildcardTreeListLabel( currentRuleName, id2.getToken(), a );
                      				}
                      				else
                      				{
                      					grammar.defineTokenListLabel(currentRuleName,id2.getToken(),a);
                      				}
                      			
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;

                    }
                    break;
                case 9 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:433:6: ebnf
                    {
                    pushFollow(FOLLOW_ebnf_in_element1109);
                    ebnf();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;
                case 10 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:434:6: tree_
                    {
                    pushFollow(FOLLOW_tree__in_element1116);
                    tree_();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;
                case 11 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:435:6: ^( SYNPRED block )
                    {
                    match(input,SYNPRED,FOLLOW_SYNPRED_in_element1125); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_block_in_element1127);
                    block();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    }
                    break;
                case 12 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:436:6: act= ACTION
                    {
                    act=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_element1138); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      			act.outerAltNum = this.outerAltNum;
                      			trackInlineAction(act);
                      		
                    }

                    }
                    break;
                case 13 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:441:6: act2= FORCED_ACTION
                    {
                    act2=(GrammarAST)match(input,FORCED_ACTION,FOLLOW_FORCED_ACTION_in_element1151); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      			act2.outerAltNum = this.outerAltNum;
                      			trackInlineAction(act2);
                      		
                    }

                    }
                    break;
                case 14 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:446:6: SEMPRED
                    {
                    SEMPRED9=(GrammarAST)match(input,SEMPRED,FOLLOW_SEMPRED_in_element1162); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      			SEMPRED9.outerAltNum = this.outerAltNum;
                      			trackInlineAction(SEMPRED9);
                      		
                    }

                    }
                    break;
                case 15 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:451:6: SYN_SEMPRED
                    {
                    match(input,SYN_SEMPRED,FOLLOW_SYN_SEMPRED_in_element1173); if (state.failed) return retval;

                    }
                    break;
                case 16 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:452:6: ^( BACKTRACK_SEMPRED ( . )* )
                    {
                    match(input,BACKTRACK_SEMPRED,FOLLOW_BACKTRACK_SEMPRED_in_element1181); if (state.failed) return retval;

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:452:26: ( . )*
                        loop36:
                        do {
                            int alt36=2;
                            switch ( input.LA(1) ) {
                            case LEXER:
                            case PARSER:
                            case CATCH:
                            case FINALLY:
                            case GRAMMAR:
                            case PRIVATE:
                            case PROTECTED:
                            case PUBLIC:
                            case RETURNS:
                            case THROWS:
                            case TREE:
                            case RULE:
                            case PREC_RULE:
                            case RECURSIVE_RULE_REF:
                            case BLOCK:
                            case OPTIONAL:
                            case CLOSURE:
                            case POSITIVE_CLOSURE:
                            case SYNPRED:
                            case RANGE:
                            case CHAR_RANGE:
                            case EPSILON:
                            case ALT:
                            case EOR:
                            case EOB:
                            case EOA:
                            case ID:
                            case ARG:
                            case ARGLIST:
                            case RET:
                            case LEXER_GRAMMAR:
                            case PARSER_GRAMMAR:
                            case TREE_GRAMMAR:
                            case COMBINED_GRAMMAR:
                            case INITACTION:
                            case FORCED_ACTION:
                            case LABEL:
                            case TEMPLATE:
                            case SCOPE:
                            case IMPORT:
                            case GATED_SEMPRED:
                            case SYN_SEMPRED:
                            case BACKTRACK_SEMPRED:
                            case FRAGMENT:
                            case DOT:
                            case REWRITES:
                            case ACTION:
                            case DOC_COMMENT:
                            case SEMI:
                            case AMPERSAND:
                            case COLON:
                            case OPTIONS:
                            case RCURLY:
                            case ASSIGN:
                            case STRING_LITERAL:
                            case CHAR_LITERAL:
                            case INT:
                            case STAR:
                            case COMMA:
                            case TOKENS:
                            case TOKEN_REF:
                            case BANG:
                            case ARG_ACTION:
                            case OR:
                            case LPAREN:
                            case RPAREN:
                            case PLUS_ASSIGN:
                            case SEMPRED:
                            case IMPLIES:
                            case ROOT:
                            case WILDCARD:
                            case RULE_REF:
                            case NOT:
                            case TREE_BEGIN:
                            case QUESTION:
                            case PLUS:
                            case OPEN_ELEMENT_OPTION:
                            case CLOSE_ELEMENT_OPTION:
                            case DOUBLE_QUOTE_STRING_LITERAL:
                            case DOUBLE_ANGLE_STRING_LITERAL:
                            case REWRITE:
                            case ETC:
                            case DOLLAR:
                            case WS:
                            case SL_COMMENT:
                            case ML_COMMENT:
                            case COMMENT:
                            case SRC:
                            case STRAY_BRACKET:
                            case ESC:
                            case DIGIT:
                            case XDIGIT:
                            case NESTED_ARG_ACTION:
                            case ACTION_STRING_LITERAL:
                            case ACTION_CHAR_LITERAL:
                            case NESTED_ACTION:
                            case ACTION_ESC:
                            case WS_LOOP:
                            case WS_OPT:
                                {
                                alt36=1;
                                }
                                break;
                            case UP:
                                {
                                alt36=2;
                                }
                                break;

                            }

                            switch (alt36) {
                        	case 1 :
                        	    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:452:26: .
                        	    {
                        	    matchAny(input); if (state.failed) return retval;

                        	    }
                        	    break;

                        	default :
                        	    break loop36;
                            }
                        } while (true);


                        match(input, Token.UP, null); if (state.failed) return retval;
                    }

                    }
                    break;
                case 17 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:453:6: GATED_SEMPRED
                    {
                    GATED_SEMPRED10=(GrammarAST)match(input,GATED_SEMPRED,FOLLOW_GATED_SEMPRED_in_element1192); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      			GATED_SEMPRED10.outerAltNum = this.outerAltNum;
                      			trackInlineAction(GATED_SEMPRED10);
                      		
                    }

                    }
                    break;
                case 18 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:458:6: EPSILON
                    {
                    match(input,EPSILON,FOLLOW_EPSILON_in_element1203); if (state.failed) return retval;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "element"


    // $ANTLR start "ebnf"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:461:1: ebnf : ( ( dotLoop )=> dotLoop | block | ^( OPTIONAL block ) | ^( CLOSURE block ) | ^( POSITIVE_CLOSURE block ) );
    public final void ebnf() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:462:2: ( ( dotLoop )=> dotLoop | block | ^( OPTIONAL block ) | ^( CLOSURE block ) | ^( POSITIVE_CLOSURE block ) )
            int alt38=5;
            alt38 = dfa38.predict(input);
            switch (alt38) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:462:4: ( dotLoop )=> dotLoop
                    {
                    pushFollow(FOLLOW_dotLoop_in_ebnf1221);
                    dotLoop();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:463:4: block
                    {
                    pushFollow(FOLLOW_block_in_ebnf1227);
                    block();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:464:4: ^( OPTIONAL block )
                    {
                    match(input,OPTIONAL,FOLLOW_OPTIONAL_in_ebnf1234); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_block_in_ebnf1236);
                    block();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:465:4: ^( CLOSURE block )
                    {
                    match(input,CLOSURE,FOLLOW_CLOSURE_in_ebnf1245); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_block_in_ebnf1247);
                    block();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:466:4: ^( POSITIVE_CLOSURE block )
                    {
                    match(input,POSITIVE_CLOSURE,FOLLOW_POSITIVE_CLOSURE_in_ebnf1256); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_block_in_ebnf1258);
                    block();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ebnf"

    public static class dotLoop_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "dotLoop"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:469:1: dotLoop : ( ^( CLOSURE dotBlock ) | ^( POSITIVE_CLOSURE dotBlock ) ) ;
    public final DefineGrammarItemsWalker.dotLoop_return dotLoop() throws RecognitionException {
        DefineGrammarItemsWalker.dotLoop_return retval = new DefineGrammarItemsWalker.dotLoop_return();
        retval.start = input.LT(1);

        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:472:2: ( ( ^( CLOSURE dotBlock ) | ^( POSITIVE_CLOSURE dotBlock ) ) )
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:472:4: ( ^( CLOSURE dotBlock ) | ^( POSITIVE_CLOSURE dotBlock ) )
            {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:472:4: ( ^( CLOSURE dotBlock ) | ^( POSITIVE_CLOSURE dotBlock ) )
            int alt39=2;
            switch ( input.LA(1) ) {
            case CLOSURE:
                {
                alt39=1;
                }
                break;
            case POSITIVE_CLOSURE:
                {
                alt39=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:472:6: ^( CLOSURE dotBlock )
                    {
                    match(input,CLOSURE,FOLLOW_CLOSURE_in_dotLoop1277); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_dotBlock_in_dotLoop1279);
                    dotBlock();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:473:5: ^( POSITIVE_CLOSURE dotBlock )
                    {
                    match(input,POSITIVE_CLOSURE,FOLLOW_POSITIVE_CLOSURE_in_dotLoop1289); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_dotBlock_in_dotLoop1291);
                    dotBlock();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			GrammarAST block = (GrammarAST)((GrammarAST)retval.start).getChild(0);
              			Map<String, Object> opts = new HashMap<String, Object>();
              			opts.put("greedy", "false");
              			if ( grammar.type!=Grammar.LEXER )
              			{
              				// parser grammars assume k=1 for .* loops
              				// otherwise they (analysis?) look til EOF!
              				opts.put("k", 1);
              			}
              			block.setOptions(grammar,opts);
              		
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "dotLoop"


    // $ANTLR start "dotBlock"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:489:1: dotBlock : ^( BLOCK ^( ALT WILDCARD EOA ) EOB ) ;
    public final void dotBlock() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:490:2: ( ^( BLOCK ^( ALT WILDCARD EOA ) EOB ) )
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:490:4: ^( BLOCK ^( ALT WILDCARD EOA ) EOB )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_dotBlock1314); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            match(input,ALT,FOLLOW_ALT_in_dotBlock1318); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            match(input,WILDCARD,FOLLOW_WILDCARD_in_dotBlock1320); if (state.failed) return ;
            match(input,EOA,FOLLOW_EOA_in_dotBlock1322); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;
            match(input,EOB,FOLLOW_EOB_in_dotBlock1326); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "dotBlock"


    // $ANTLR start "tree_"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:493:1: tree_ : ^( TREE_BEGIN ( element )+ ) ;
    public final void tree_() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:494:2: ( ^( TREE_BEGIN ( element )+ ) )
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:494:4: ^( TREE_BEGIN ( element )+ )
            {
            match(input,TREE_BEGIN,FOLLOW_TREE_BEGIN_in_tree_1340); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:494:17: ( element )+
            int cnt40=0;
            loop40:
            do {
                int alt40=2;
                switch ( input.LA(1) ) {
                case BLOCK:
                case OPTIONAL:
                case CLOSURE:
                case POSITIVE_CLOSURE:
                case SYNPRED:
                case RANGE:
                case CHAR_RANGE:
                case EPSILON:
                case FORCED_ACTION:
                case GATED_SEMPRED:
                case SYN_SEMPRED:
                case BACKTRACK_SEMPRED:
                case DOT:
                case ACTION:
                case ASSIGN:
                case STRING_LITERAL:
                case CHAR_LITERAL:
                case TOKEN_REF:
                case BANG:
                case PLUS_ASSIGN:
                case SEMPRED:
                case ROOT:
                case WILDCARD:
                case RULE_REF:
                case NOT:
                case TREE_BEGIN:
                    {
                    alt40=1;
                    }
                    break;

                }

                switch (alt40) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:494:17: element
            	    {
            	    pushFollow(FOLLOW_element_in_tree_1342);
            	    element();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt40 >= 1 ) break loop40;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(40, input);
                        throw eee;
                }
                cnt40++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "tree_"


    // $ANTLR start "atom"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:497:1: atom[GrammarAST scope_] : ( ^(rr= RULE_REF (rarg= ARG_ACTION )? ) | ^(t= TOKEN_REF (targ= ARG_ACTION )? ) | c= CHAR_LITERAL | s= STRING_LITERAL | WILDCARD | ^( DOT ID atom[$ID] ) );
    public final void atom(GrammarAST scope_) throws RecognitionException {
        GrammarAST rr=null;
        GrammarAST rarg=null;
        GrammarAST t=null;
        GrammarAST targ=null;
        GrammarAST c=null;
        GrammarAST s=null;
        GrammarAST ID11=null;

        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:498:2: ( ^(rr= RULE_REF (rarg= ARG_ACTION )? ) | ^(t= TOKEN_REF (targ= ARG_ACTION )? ) | c= CHAR_LITERAL | s= STRING_LITERAL | WILDCARD | ^( DOT ID atom[$ID] ) )
            int alt43=6;
            switch ( input.LA(1) ) {
            case RULE_REF:
                {
                alt43=1;
                }
                break;
            case TOKEN_REF:
                {
                alt43=2;
                }
                break;
            case CHAR_LITERAL:
                {
                alt43=3;
                }
                break;
            case STRING_LITERAL:
                {
                alt43=4;
                }
                break;
            case WILDCARD:
                {
                alt43=5;
                }
                break;
            case DOT:
                {
                alt43=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:498:4: ^(rr= RULE_REF (rarg= ARG_ACTION )? )
                    {
                    rr=(GrammarAST)match(input,RULE_REF,FOLLOW_RULE_REF_in_atom1360); if (state.failed) return ;

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return ;
                        // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:498:19: (rarg= ARG_ACTION )?
                        int alt41=2;
                        switch ( input.LA(1) ) {
                            case ARG_ACTION:
                                {
                                alt41=1;
                                }
                                break;
                        }

                        switch (alt41) {
                            case 1 :
                                // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:498:20: rarg= ARG_ACTION
                                {
                                rarg=(GrammarAST)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_atom1365); if (state.failed) return ;

                                }
                                break;

                        }


                        match(input, Token.UP, null); if (state.failed) return ;
                    }
                    if ( state.backtracking==0 ) {

                      			grammar.altReferencesRule( currentRuleName, scope_, rr, this.outerAltNum );
                      			if ( rarg != null )
                      			{
                      				rarg.outerAltNum = this.outerAltNum;
                      				trackInlineAction(rarg);
                      			}
                      		
                    }

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:507:4: ^(t= TOKEN_REF (targ= ARG_ACTION )? )
                    {
                    t=(GrammarAST)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_atom1382); if (state.failed) return ;

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return ;
                        // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:507:19: (targ= ARG_ACTION )?
                        int alt42=2;
                        switch ( input.LA(1) ) {
                            case ARG_ACTION:
                                {
                                alt42=1;
                                }
                                break;
                        }

                        switch (alt42) {
                            case 1 :
                                // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:507:20: targ= ARG_ACTION
                                {
                                targ=(GrammarAST)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_atom1387); if (state.failed) return ;

                                }
                                break;

                        }


                        match(input, Token.UP, null); if (state.failed) return ;
                    }
                    if ( state.backtracking==0 ) {

                      			if ( targ != null )
                      			{
                      				targ.outerAltNum = this.outerAltNum;
                      				trackInlineAction(targ);
                      			}
                      			if ( grammar.type == Grammar.LEXER )
                      			{
                      				grammar.altReferencesRule( currentRuleName, scope_, t, this.outerAltNum );
                      			}
                      			else
                      			{
                      				grammar.altReferencesTokenID( currentRuleName, t, this.outerAltNum );
                      			}
                      		
                    }

                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:523:4: c= CHAR_LITERAL
                    {
                    c=(GrammarAST)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_atom1403); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			if ( grammar.type != Grammar.LEXER )
                      			{
                      				Rule rule = grammar.getRule(currentRuleName);
                      				if ( rule != null )
                      					rule.trackTokenReferenceInAlt(c, outerAltNum);
                      			}
                      		
                    }

                    }
                    break;
                case 4 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:532:4: s= STRING_LITERAL
                    {
                    s=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_atom1414); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			if ( grammar.type != Grammar.LEXER )
                      			{
                      				Rule rule = grammar.getRule(currentRuleName);
                      				if ( rule!=null )
                      					rule.trackTokenReferenceInAlt(s, outerAltNum);
                      			}
                      		
                    }

                    }
                    break;
                case 5 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:541:4: WILDCARD
                    {
                    match(input,WILDCARD,FOLLOW_WILDCARD_in_atom1424); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:542:4: ^( DOT ID atom[$ID] )
                    {
                    match(input,DOT,FOLLOW_DOT_in_atom1430); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    ID11=(GrammarAST)match(input,ID,FOLLOW_ID_in_atom1432); if (state.failed) return ;
                    pushFollow(FOLLOW_atom_in_atom1434);
                    atom(ID11);

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "atom"


    // $ANTLR start "ast_suffix"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:545:1: ast_suffix : ( ROOT | BANG );
    public final void ast_suffix() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:546:2: ( ROOT | BANG )
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:
            {
            if ( input.LA(1)==BANG||input.LA(1)==ROOT ) {
                input.consume();
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ast_suffix"

    public static class rewrite_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "rewrite"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:550:1: rewrite : ( ^( REWRITES ( ^( REWRITE (pred= SEMPRED )? rewrite_alternative ) )* ) | );
    public final DefineGrammarItemsWalker.rewrite_return rewrite() throws RecognitionException {
        DefineGrammarItemsWalker.rewrite_return retval = new DefineGrammarItemsWalker.rewrite_return();
        retval.start = input.LT(1);

        GrammarAST pred=null;


        	// track top level REWRITES node, store stuff there
        	currentRewriteRule = ((GrammarAST)retval.start); // has to execute during backtracking
        	if ( state.backtracking == 0 )
        	{
        		if ( grammar.buildAST() )
        			currentRewriteRule.rewriteRefsDeep = new HashSet<GrammarAST>();
        	}

        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:561:2: ( ^( REWRITES ( ^( REWRITE (pred= SEMPRED )? rewrite_alternative ) )* ) | )
            int alt46=2;
            switch ( input.LA(1) ) {
            case REWRITES:
                {
                alt46=1;
                }
                break;
            case ALT:
            case EOB:
                {
                alt46=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:561:4: ^( REWRITES ( ^( REWRITE (pred= SEMPRED )? rewrite_alternative ) )* )
                    {
                    match(input,REWRITES,FOLLOW_REWRITES_in_rewrite1471); if (state.failed) return retval;

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:562:4: ( ^( REWRITE (pred= SEMPRED )? rewrite_alternative ) )*
                        loop45:
                        do {
                            int alt45=2;
                            switch ( input.LA(1) ) {
                            case REWRITE:
                                {
                                alt45=1;
                                }
                                break;

                            }

                            switch (alt45) {
                        	case 1 :
                        	    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:562:6: ^( REWRITE (pred= SEMPRED )? rewrite_alternative )
                        	    {
                        	    match(input,REWRITE,FOLLOW_REWRITE_in_rewrite1480); if (state.failed) return retval;

                        	    match(input, Token.DOWN, null); if (state.failed) return retval;
                        	    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:562:17: (pred= SEMPRED )?
                        	    int alt44=2;
                        	    switch ( input.LA(1) ) {
                        	        case SEMPRED:
                        	            {
                        	            alt44=1;
                        	            }
                        	            break;
                        	    }

                        	    switch (alt44) {
                        	        case 1 :
                        	            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:562:18: pred= SEMPRED
                        	            {
                        	            pred=(GrammarAST)match(input,SEMPRED,FOLLOW_SEMPRED_in_rewrite1485); if (state.failed) return retval;

                        	            }
                        	            break;

                        	    }

                        	    pushFollow(FOLLOW_rewrite_alternative_in_rewrite1489);
                        	    rewrite_alternative();

                        	    state._fsp--;
                        	    if (state.failed) return retval;

                        	    match(input, Token.UP, null); if (state.failed) return retval;
                        	    if ( state.backtracking==0 ) {

                        	      					if ( pred != null )
                        	      					{
                        	      						pred.outerAltNum = this.outerAltNum;
                        	      						trackInlineAction(pred);
                        	      					}
                        	      				
                        	    }

                        	    }
                        	    break;

                        	default :
                        	    break loop45;
                            }
                        } while (true);


                        match(input, Token.UP, null); if (state.failed) return retval;
                    }

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:574:2: 
                    {
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rewrite"

    public static class rewrite_block_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "rewrite_block"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:576:1: rewrite_block : ^( BLOCK rewrite_alternative EOB ) ;
    public final DefineGrammarItemsWalker.rewrite_block_return rewrite_block() throws RecognitionException {
        DefineGrammarItemsWalker.rewrite_block_return retval = new DefineGrammarItemsWalker.rewrite_block_return();
        retval.start = input.LT(1);


        	GrammarAST enclosingBlock = currentRewriteBlock;
        	if ( state.backtracking == 0 )
        	{
        		// don't do if guessing
        		currentRewriteBlock=((GrammarAST)retval.start); // pts to BLOCK node
        		currentRewriteBlock.rewriteRefsShallow = new HashSet<GrammarAST>();
        		currentRewriteBlock.rewriteRefsDeep = new HashSet<GrammarAST>();
        	}

        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:588:2: ( ^( BLOCK rewrite_alternative EOB ) )
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:588:6: ^( BLOCK rewrite_alternative EOB )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_rewrite_block1533); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            pushFollow(FOLLOW_rewrite_alternative_in_rewrite_block1535);
            rewrite_alternative();

            state._fsp--;
            if (state.failed) return retval;
            match(input,EOB,FOLLOW_EOB_in_rewrite_block1537); if (state.failed) return retval;

            match(input, Token.UP, null); if (state.failed) return retval;
            if ( state.backtracking==0 ) {

              			// copy the element refs in this block to the surrounding block
              			if ( enclosingBlock != null )
              			{
              				for (GrammarAST item : currentRewriteBlock.rewriteRefsShallow)
              					enclosingBlock.rewriteRefsDeep.add( item );
              			}
              			//currentRewriteBlock = enclosingBlock; // restore old BLOCK ptr
              		
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
             currentRewriteBlock = enclosingBlock; 
        }
        return retval;
    }
    // $ANTLR end "rewrite_block"


    // $ANTLR start "rewrite_alternative"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:602:1: rewrite_alternative : ({...}? => ^(a= ALT ( ( rewrite_element )+ | EPSILON ) EOA ) | {...}? => rewrite_template | ETC {...}?);
    public final void rewrite_alternative() throws RecognitionException {
        GrammarAST a=null;

        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:603:2: ({...}? => ^(a= ALT ( ( rewrite_element )+ | EPSILON ) EOA ) | {...}? => rewrite_template | ETC {...}?)
            int alt49=3;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==ALT) && (((grammar.buildAST())||(grammar.buildTemplate())))) {
                int LA49_1 = input.LA(2);

                if ( (LA49_1==DOWN) && (((grammar.buildAST())||(grammar.buildTemplate())))) {
                    int LA49_4 = input.LA(3);

                    if ( (LA49_4==EPSILON) && (((grammar.buildAST())||(grammar.buildTemplate())))) {
                        int LA49_5 = input.LA(4);

                        if ( (LA49_5==EOA) && (((grammar.buildAST())||(grammar.buildTemplate())))) {
                            int LA49_7 = input.LA(5);

                            if ( (LA49_7==UP) && (((grammar.buildAST())||(grammar.buildTemplate())))) {
                                int LA49_8 = input.LA(6);

                                if ( ((grammar.buildAST())) ) {
                                    alt49=1;
                                }
                                else if ( ((grammar.buildTemplate())) ) {
                                    alt49=2;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return ;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 49, 8, input);

                                    throw nvae;
                                }
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 49, 7, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 49, 5, input);

                            throw nvae;
                        }
                    }
                    else if ( ((LA49_4>=OPTIONAL && LA49_4<=POSITIVE_CLOSURE)||LA49_4==LABEL||LA49_4==ACTION||(LA49_4>=STRING_LITERAL && LA49_4<=CHAR_LITERAL)||LA49_4==TOKEN_REF||LA49_4==RULE_REF||LA49_4==TREE_BEGIN) && ((grammar.buildAST()))) {
                        alt49=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 49, 4, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA49_0==TEMPLATE||LA49_0==ACTION) && ((grammar.buildTemplate()))) {
                alt49=2;
            }
            else if ( (LA49_0==ETC) ) {
                alt49=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:603:4: {...}? => ^(a= ALT ( ( rewrite_element )+ | EPSILON ) EOA )
                    {
                    if ( !((grammar.buildAST())) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rewrite_alternative", "grammar.buildAST()");
                    }
                    a=(GrammarAST)match(input,ALT,FOLLOW_ALT_in_rewrite_alternative1569); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:603:38: ( ( rewrite_element )+ | EPSILON )
                    int alt48=2;
                    switch ( input.LA(1) ) {
                    case OPTIONAL:
                    case CLOSURE:
                    case POSITIVE_CLOSURE:
                    case LABEL:
                    case ACTION:
                    case STRING_LITERAL:
                    case CHAR_LITERAL:
                    case TOKEN_REF:
                    case RULE_REF:
                    case TREE_BEGIN:
                        {
                        alt48=1;
                        }
                        break;
                    case EPSILON:
                        {
                        alt48=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 48, 0, input);

                        throw nvae;
                    }

                    switch (alt48) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:603:40: ( rewrite_element )+
                            {
                            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:603:40: ( rewrite_element )+
                            int cnt47=0;
                            loop47:
                            do {
                                int alt47=2;
                                switch ( input.LA(1) ) {
                                case OPTIONAL:
                                case CLOSURE:
                                case POSITIVE_CLOSURE:
                                case LABEL:
                                case ACTION:
                                case STRING_LITERAL:
                                case CHAR_LITERAL:
                                case TOKEN_REF:
                                case RULE_REF:
                                case TREE_BEGIN:
                                    {
                                    alt47=1;
                                    }
                                    break;

                                }

                                switch (alt47) {
                            	case 1 :
                            	    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:603:42: rewrite_element
                            	    {
                            	    pushFollow(FOLLOW_rewrite_element_in_rewrite_alternative1575);
                            	    rewrite_element();

                            	    state._fsp--;
                            	    if (state.failed) return ;

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt47 >= 1 ) break loop47;
                            	    if (state.backtracking>0) {state.failed=true; return ;}
                                        EarlyExitException eee =
                                            new EarlyExitException(47, input);
                                        throw eee;
                                }
                                cnt47++;
                            } while (true);


                            }
                            break;
                        case 2 :
                            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:603:63: EPSILON
                            {
                            match(input,EPSILON,FOLLOW_EPSILON_in_rewrite_alternative1582); if (state.failed) return ;

                            }
                            break;

                    }

                    match(input,EOA,FOLLOW_EOA_in_rewrite_alternative1586); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:604:4: {...}? => rewrite_template
                    {
                    if ( !((grammar.buildTemplate())) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rewrite_alternative", "grammar.buildTemplate()");
                    }
                    pushFollow(FOLLOW_rewrite_template_in_rewrite_alternative1597);
                    rewrite_template();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:605:4: ETC {...}?
                    {
                    match(input,ETC,FOLLOW_ETC_in_rewrite_alternative1602); if (state.failed) return ;
                    if ( !((this.blockLevel==1)) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rewrite_alternative", "this.blockLevel==1");
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "rewrite_alternative"


    // $ANTLR start "rewrite_element"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:608:1: rewrite_element : ( rewrite_atom | rewrite_ebnf | rewrite_tree );
    public final void rewrite_element() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:609:2: ( rewrite_atom | rewrite_ebnf | rewrite_tree )
            int alt50=3;
            switch ( input.LA(1) ) {
            case LABEL:
            case ACTION:
            case STRING_LITERAL:
            case CHAR_LITERAL:
            case TOKEN_REF:
            case RULE_REF:
                {
                alt50=1;
                }
                break;
            case OPTIONAL:
            case CLOSURE:
            case POSITIVE_CLOSURE:
                {
                alt50=2;
                }
                break;
            case TREE_BEGIN:
                {
                alt50=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:609:4: rewrite_atom
                    {
                    pushFollow(FOLLOW_rewrite_atom_in_rewrite_element1616);
                    rewrite_atom();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:610:4: rewrite_ebnf
                    {
                    pushFollow(FOLLOW_rewrite_ebnf_in_rewrite_element1621);
                    rewrite_ebnf();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:611:4: rewrite_tree
                    {
                    pushFollow(FOLLOW_rewrite_tree_in_rewrite_element1626);
                    rewrite_tree();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "rewrite_element"


    // $ANTLR start "rewrite_ebnf"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:614:1: rewrite_ebnf : ( ^( OPTIONAL rewrite_block ) | ^( CLOSURE rewrite_block ) | ^( POSITIVE_CLOSURE rewrite_block ) );
    public final void rewrite_ebnf() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:615:2: ( ^( OPTIONAL rewrite_block ) | ^( CLOSURE rewrite_block ) | ^( POSITIVE_CLOSURE rewrite_block ) )
            int alt51=3;
            switch ( input.LA(1) ) {
            case OPTIONAL:
                {
                alt51=1;
                }
                break;
            case CLOSURE:
                {
                alt51=2;
                }
                break;
            case POSITIVE_CLOSURE:
                {
                alt51=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:615:4: ^( OPTIONAL rewrite_block )
                    {
                    match(input,OPTIONAL,FOLLOW_OPTIONAL_in_rewrite_ebnf1639); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_rewrite_block_in_rewrite_ebnf1641);
                    rewrite_block();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:616:4: ^( CLOSURE rewrite_block )
                    {
                    match(input,CLOSURE,FOLLOW_CLOSURE_in_rewrite_ebnf1650); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_rewrite_block_in_rewrite_ebnf1652);
                    rewrite_block();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:617:4: ^( POSITIVE_CLOSURE rewrite_block )
                    {
                    match(input,POSITIVE_CLOSURE,FOLLOW_POSITIVE_CLOSURE_in_rewrite_ebnf1661); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_rewrite_block_in_rewrite_ebnf1663);
                    rewrite_block();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "rewrite_ebnf"


    // $ANTLR start "rewrite_tree"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:620:1: rewrite_tree : ^( TREE_BEGIN rewrite_atom ( rewrite_element )* ) ;
    public final void rewrite_tree() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:621:2: ( ^( TREE_BEGIN rewrite_atom ( rewrite_element )* ) )
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:621:6: ^( TREE_BEGIN rewrite_atom ( rewrite_element )* )
            {
            match(input,TREE_BEGIN,FOLLOW_TREE_BEGIN_in_rewrite_tree1680); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            pushFollow(FOLLOW_rewrite_atom_in_rewrite_tree1682);
            rewrite_atom();

            state._fsp--;
            if (state.failed) return ;
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:621:33: ( rewrite_element )*
            loop52:
            do {
                int alt52=2;
                switch ( input.LA(1) ) {
                case OPTIONAL:
                case CLOSURE:
                case POSITIVE_CLOSURE:
                case LABEL:
                case ACTION:
                case STRING_LITERAL:
                case CHAR_LITERAL:
                case TOKEN_REF:
                case RULE_REF:
                case TREE_BEGIN:
                    {
                    alt52=1;
                    }
                    break;

                }

                switch (alt52) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:621:35: rewrite_element
            	    {
            	    pushFollow(FOLLOW_rewrite_element_in_rewrite_tree1686);
            	    rewrite_element();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);


            match(input, Token.UP, null); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "rewrite_tree"

    public static class rewrite_atom_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "rewrite_atom"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:624:1: rewrite_atom : ( RULE_REF | ( ^( TOKEN_REF ( ARG_ACTION )? ) | CHAR_LITERAL | STRING_LITERAL ) | LABEL | ACTION );
    public final DefineGrammarItemsWalker.rewrite_atom_return rewrite_atom() throws RecognitionException {
        DefineGrammarItemsWalker.rewrite_atom_return retval = new DefineGrammarItemsWalker.rewrite_atom_return();
        retval.start = input.LT(1);

        GrammarAST ARG_ACTION12=null;
        GrammarAST ACTION13=null;


        	if ( state.backtracking == 0 )
        	{
        		Rule r = grammar.getRule(currentRuleName);
        		Set tokenRefsInAlt = r.getTokenRefsInAlt(outerAltNum);
        		boolean imaginary =
        			((GrammarAST)retval.start).getType()==TOKEN_REF &&
        			!tokenRefsInAlt.contains(((GrammarAST)retval.start).getText());
        		if ( !imaginary && grammar.buildAST() &&
        			 (((GrammarAST)retval.start).getType()==RULE_REF ||
        			  ((GrammarAST)retval.start).getType()==LABEL ||
        			  ((GrammarAST)retval.start).getType()==TOKEN_REF ||
        			  ((GrammarAST)retval.start).getType()==CHAR_LITERAL ||
        			  ((GrammarAST)retval.start).getType()==STRING_LITERAL) )
        		{
        			// track per block and for entire rewrite rule
        			if ( currentRewriteBlock!=null )
        			{
        				currentRewriteBlock.rewriteRefsShallow.add(((GrammarAST)retval.start));
        				currentRewriteBlock.rewriteRefsDeep.add(((GrammarAST)retval.start));
        			}

        			//System.out.println("adding "+((GrammarAST)retval.start).getText()+" to "+currentRewriteRule.getText());
        			currentRewriteRule.rewriteRefsDeep.add(((GrammarAST)retval.start));
        		}
        	}

        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:653:2: ( RULE_REF | ( ^( TOKEN_REF ( ARG_ACTION )? ) | CHAR_LITERAL | STRING_LITERAL ) | LABEL | ACTION )
            int alt55=4;
            switch ( input.LA(1) ) {
            case RULE_REF:
                {
                alt55=1;
                }
                break;
            case STRING_LITERAL:
            case CHAR_LITERAL:
            case TOKEN_REF:
                {
                alt55=2;
                }
                break;
            case LABEL:
                {
                alt55=3;
                }
                break;
            case ACTION:
                {
                alt55=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:653:4: RULE_REF
                    {
                    match(input,RULE_REF,FOLLOW_RULE_REF_in_rewrite_atom1707); if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:654:4: ( ^( TOKEN_REF ( ARG_ACTION )? ) | CHAR_LITERAL | STRING_LITERAL )
                    {
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:654:4: ( ^( TOKEN_REF ( ARG_ACTION )? ) | CHAR_LITERAL | STRING_LITERAL )
                    int alt54=3;
                    switch ( input.LA(1) ) {
                    case TOKEN_REF:
                        {
                        alt54=1;
                        }
                        break;
                    case CHAR_LITERAL:
                        {
                        alt54=2;
                        }
                        break;
                    case STRING_LITERAL:
                        {
                        alt54=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 54, 0, input);

                        throw nvae;
                    }

                    switch (alt54) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:654:6: ^( TOKEN_REF ( ARG_ACTION )? )
                            {
                            match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_rewrite_atom1717); if (state.failed) return retval;

                            if ( input.LA(1)==Token.DOWN ) {
                                match(input, Token.DOWN, null); if (state.failed) return retval;
                                // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:655:5: ( ARG_ACTION )?
                                int alt53=2;
                                switch ( input.LA(1) ) {
                                    case ARG_ACTION:
                                        {
                                        alt53=1;
                                        }
                                        break;
                                }

                                switch (alt53) {
                                    case 1 :
                                        // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:655:7: ARG_ACTION
                                        {
                                        ARG_ACTION12=(GrammarAST)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rewrite_atom1725); if (state.failed) return retval;
                                        if ( state.backtracking==0 ) {

                                          						ARG_ACTION12.outerAltNum = this.outerAltNum;
                                          						trackInlineAction(ARG_ACTION12);
                                          					
                                        }

                                        }
                                        break;

                                }


                                match(input, Token.UP, null); if (state.failed) return retval;
                            }

                            }
                            break;
                        case 2 :
                            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:662:5: CHAR_LITERAL
                            {
                            match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_rewrite_atom1750); if (state.failed) return retval;

                            }
                            break;
                        case 3 :
                            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:663:5: STRING_LITERAL
                            {
                            match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_rewrite_atom1756); if (state.failed) return retval;

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:665:4: LABEL
                    {
                    match(input,LABEL,FOLLOW_LABEL_in_rewrite_atom1765); if (state.failed) return retval;

                    }
                    break;
                case 4 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:666:4: ACTION
                    {
                    ACTION13=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_rewrite_atom1770); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      			ACTION13.outerAltNum = this.outerAltNum;
                      			trackInlineAction(ACTION13);
                      		
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rewrite_atom"


    // $ANTLR start "rewrite_template"
    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:673:1: rewrite_template : ( ^( ALT EPSILON EOA ) | ^( TEMPLATE (id= ID | ind= ACTION ) ^( ARGLIST ( ^( ARG arg= ID a= ACTION ) )* ) ( DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL )? ) | act= ACTION );
    public final void rewrite_template() throws RecognitionException {
        GrammarAST id=null;
        GrammarAST ind=null;
        GrammarAST arg=null;
        GrammarAST a=null;
        GrammarAST act=null;

        try {
            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:674:2: ( ^( ALT EPSILON EOA ) | ^( TEMPLATE (id= ID | ind= ACTION ) ^( ARGLIST ( ^( ARG arg= ID a= ACTION ) )* ) ( DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL )? ) | act= ACTION )
            int alt59=3;
            switch ( input.LA(1) ) {
            case ALT:
                {
                alt59=1;
                }
                break;
            case TEMPLATE:
                {
                alt59=2;
                }
                break;
            case ACTION:
                {
                alt59=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }

            switch (alt59) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:674:4: ^( ALT EPSILON EOA )
                    {
                    match(input,ALT,FOLLOW_ALT_in_rewrite_template1787); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    match(input,EPSILON,FOLLOW_EPSILON_in_rewrite_template1789); if (state.failed) return ;
                    match(input,EOA,FOLLOW_EOA_in_rewrite_template1791); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:675:4: ^( TEMPLATE (id= ID | ind= ACTION ) ^( ARGLIST ( ^( ARG arg= ID a= ACTION ) )* ) ( DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL )? )
                    {
                    match(input,TEMPLATE,FOLLOW_TEMPLATE_in_rewrite_template1800); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:675:16: (id= ID | ind= ACTION )
                    int alt56=2;
                    switch ( input.LA(1) ) {
                    case ID:
                        {
                        alt56=1;
                        }
                        break;
                    case ACTION:
                        {
                        alt56=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 56, 0, input);

                        throw nvae;
                    }

                    switch (alt56) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:675:17: id= ID
                            {
                            id=(GrammarAST)match(input,ID,FOLLOW_ID_in_rewrite_template1805); if (state.failed) return ;

                            }
                            break;
                        case 2 :
                            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:675:23: ind= ACTION
                            {
                            ind=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_rewrite_template1809); if (state.failed) return ;

                            }
                            break;

                    }

                    match(input,ARGLIST,FOLLOW_ARGLIST_in_rewrite_template1817); if (state.failed) return ;

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return ;
                        // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:677:5: ( ^( ARG arg= ID a= ACTION ) )*
                        loop57:
                        do {
                            int alt57=2;
                            switch ( input.LA(1) ) {
                            case ARG:
                                {
                                alt57=1;
                                }
                                break;

                            }

                            switch (alt57) {
                        	case 1 :
                        	    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:677:7: ^( ARG arg= ID a= ACTION )
                        	    {
                        	    match(input,ARG,FOLLOW_ARG_in_rewrite_template1827); if (state.failed) return ;

                        	    match(input, Token.DOWN, null); if (state.failed) return ;
                        	    arg=(GrammarAST)match(input,ID,FOLLOW_ID_in_rewrite_template1831); if (state.failed) return ;
                        	    a=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_rewrite_template1835); if (state.failed) return ;

                        	    match(input, Token.UP, null); if (state.failed) return ;
                        	    if ( state.backtracking==0 ) {

                        	      						a.outerAltNum = this.outerAltNum;
                        	      						trackInlineAction(a);
                        	      					
                        	    }

                        	    }
                        	    break;

                        	default :
                        	    break loop57;
                            }
                        } while (true);


                        match(input, Token.UP, null); if (state.failed) return ;
                    }
                    if ( state.backtracking==0 ) {

                      				if ( ind!=null )
                      				{
                      					ind.outerAltNum = this.outerAltNum;
                      					trackInlineAction(ind);
                      				}
                      			
                    }
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:691:4: ( DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL )?
                    int alt58=2;
                    switch ( input.LA(1) ) {
                        case DOUBLE_QUOTE_STRING_LITERAL:
                        case DOUBLE_ANGLE_STRING_LITERAL:
                            {
                            alt58=1;
                            }
                            break;
                    }

                    switch (alt58) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:
                            {
                            if ( (input.LA(1)>=DOUBLE_QUOTE_STRING_LITERAL && input.LA(1)<=DOUBLE_ANGLE_STRING_LITERAL) ) {
                                input.consume();
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }


                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:695:4: act= ACTION
                    {
                    act=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_rewrite_template1892); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			act.outerAltNum = this.outerAltNum;
                      			trackInlineAction(act);
                      		
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "rewrite_template"

    // $ANTLR start synpred1_DefineGrammarItemsWalker
    public final void synpred1_DefineGrammarItemsWalker_fragment() throws RecognitionException {   
        // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:462:4: ( dotLoop )
        // org\\antlr\\grammar\\v3\\DefineGrammarItemsWalker.g:462:5: dotLoop
        {
        pushFollow(FOLLOW_dotLoop_in_synpred1_DefineGrammarItemsWalker1216);
        dotLoop();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_DefineGrammarItemsWalker

    // Delegated rules

    public final boolean synpred1_DefineGrammarItemsWalker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_DefineGrammarItemsWalker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA37 dfa37 = new DFA37(this);
    protected DFA38 dfa38 = new DFA38(this);
    static final String DFA37_eotS =
        "\23\uffff";
    static final String DFA37_eofS =
        "\23\uffff";
    static final String DFA37_minS =
        "\1\22\22\uffff";
    static final String DFA37_maxS =
        "\1\115\22\uffff";
    static final String DFA37_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1"+
        "\15\1\16\1\17\1\20\1\21\1\22";
    static final String DFA37_specialS =
        "\23\uffff}>";
    static final String[] DFA37_transitionS = {
            "\4\11\1\13\1\5\1\6\1\22\15\uffff\1\15\4\uffff\1\21\1\17\1\20"+
            "\1\uffff\1\3\1\uffff\1\14\6\uffff\1\7\2\3\4\uffff\1\3\1\2\4"+
            "\uffff\1\10\1\16\1\uffff\1\1\2\3\1\4\1\12",
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
            ""
    };

    static final short[] DFA37_eot = DFA.unpackEncodedString(DFA37_eotS);
    static final short[] DFA37_eof = DFA.unpackEncodedString(DFA37_eofS);
    static final char[] DFA37_min = DFA.unpackEncodedStringToUnsignedChars(DFA37_minS);
    static final char[] DFA37_max = DFA.unpackEncodedStringToUnsignedChars(DFA37_maxS);
    static final short[] DFA37_accept = DFA.unpackEncodedString(DFA37_acceptS);
    static final short[] DFA37_special = DFA.unpackEncodedString(DFA37_specialS);
    static final short[][] DFA37_transition;

    static {
        int numStates = DFA37_transitionS.length;
        DFA37_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA37_transition[i] = DFA.unpackEncodedString(DFA37_transitionS[i]);
        }
    }

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = DFA37_eot;
            this.eof = DFA37_eof;
            this.min = DFA37_min;
            this.max = DFA37_max;
            this.accept = DFA37_accept;
            this.special = DFA37_special;
            this.transition = DFA37_transition;
        }
        public String getDescription() {
            return "385:1: element : ( ^( ROOT element ) | ^( BANG element ) | atom[null] | ^( NOT element ) | ^( RANGE atom[null] atom[null] ) | ^( CHAR_RANGE atom[null] atom[null] ) | ^( ASSIGN id= ID el= element ) | ^( PLUS_ASSIGN id2= ID a2= element ) | ebnf | tree_ | ^( SYNPRED block ) | act= ACTION | act2= FORCED_ACTION | SEMPRED | SYN_SEMPRED | ^( BACKTRACK_SEMPRED ( . )* ) | GATED_SEMPRED | EPSILON );";
        }
    }
    static final String DFA38_eotS =
        "\36\uffff";
    static final String DFA38_eofS =
        "\36\uffff";
    static final String DFA38_minS =
        "\1\22\2\2\2\uffff\2\22\2\2\2\32\1\2\1\uffff\1\2\1\uffff\4\22\2"+
        "\3\2\32\4\3\2\0\1\uffff";
    static final String DFA38_maxS =
        "\1\25\2\2\2\uffff\2\22\2\2\2\67\1\2\1\uffff\1\2\1\uffff\4\115\2"+
        "\3\2\61\4\3\2\0\1\uffff";
    static final String DFA38_acceptS =
        "\3\uffff\1\2\1\3\7\uffff\1\4\1\uffff\1\5\16\uffff\1\1";
    static final String DFA38_specialS =
        "\33\uffff\1\0\1\1\1\uffff}>";
    static final String[] DFA38_transitionS = {
            "\1\3\1\4\1\1\1\2",
            "\1\5",
            "\1\6",
            "",
            "",
            "\1\7",
            "\1\10",
            "\1\11",
            "\1\12",
            "\1\13\32\uffff\1\14\1\uffff\1\14",
            "\1\15\32\uffff\1\16\1\uffff\1\16",
            "\1\17",
            "",
            "\1\20",
            "",
            "\10\14\15\uffff\1\14\4\uffff\3\14\1\uffff\1\14\1\uffff\1\14"+
            "\6\uffff\3\14\4\uffff\2\14\4\uffff\2\14\1\uffff\1\14\1\21\3"+
            "\14",
            "\10\16\15\uffff\1\16\4\uffff\3\16\1\uffff\1\16\1\uffff\1\16"+
            "\6\uffff\3\16\4\uffff\2\16\4\uffff\2\16\1\uffff\1\16\1\22\3"+
            "\16",
            "\10\14\3\uffff\1\23\11\uffff\1\14\4\uffff\3\14\1\uffff\1\14"+
            "\1\uffff\1\14\6\uffff\3\14\4\uffff\2\14\4\uffff\2\14\1\uffff"+
            "\5\14",
            "\10\16\3\uffff\1\24\11\uffff\1\16\4\uffff\3\16\1\uffff\1\16"+
            "\1\uffff\1\16\6\uffff\3\16\4\uffff\2\16\4\uffff\2\16\1\uffff"+
            "\5\16",
            "\1\25",
            "\1\26",
            "\1\14\1\uffff\1\27\24\uffff\1\14",
            "\1\16\1\uffff\1\30\24\uffff\1\16",
            "\1\31",
            "\1\32",
            "\1\33",
            "\1\34",
            "\1\uffff",
            "\1\uffff",
            ""
    };

    static final short[] DFA38_eot = DFA.unpackEncodedString(DFA38_eotS);
    static final short[] DFA38_eof = DFA.unpackEncodedString(DFA38_eofS);
    static final char[] DFA38_min = DFA.unpackEncodedStringToUnsignedChars(DFA38_minS);
    static final char[] DFA38_max = DFA.unpackEncodedStringToUnsignedChars(DFA38_maxS);
    static final short[] DFA38_accept = DFA.unpackEncodedString(DFA38_acceptS);
    static final short[] DFA38_special = DFA.unpackEncodedString(DFA38_specialS);
    static final short[][] DFA38_transition;

    static {
        int numStates = DFA38_transitionS.length;
        DFA38_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA38_transition[i] = DFA.unpackEncodedString(DFA38_transitionS[i]);
        }
    }

    class DFA38 extends DFA {

        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = DFA38_eot;
            this.eof = DFA38_eof;
            this.min = DFA38_min;
            this.max = DFA38_max;
            this.accept = DFA38_accept;
            this.special = DFA38_special;
            this.transition = DFA38_transition;
        }
        public String getDescription() {
            return "461:1: ebnf : ( ( dotLoop )=> dotLoop | block | ^( OPTIONAL block ) | ^( CLOSURE block ) | ^( POSITIVE_CLOSURE block ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TreeNodeStream input = (TreeNodeStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA38_27 = input.LA(1);

                         
                        int index38_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_DefineGrammarItemsWalker()) ) {s = 29;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index38_27);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA38_28 = input.LA(1);

                         
                        int index38_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_DefineGrammarItemsWalker()) ) {s = 29;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index38_28);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 38, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_LEXER_GRAMMAR_in_grammar_70 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_grammarSpec_in_grammar_76 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARSER_GRAMMAR_in_grammar_85 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_grammarSpec_in_grammar_90 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TREE_GRAMMAR_in_grammar_99 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_grammarSpec_in_grammar_104 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COMBINED_GRAMMAR_in_grammar_113 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_grammarSpec_in_grammar_118 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SCOPE_in_attrScope143 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_attrScope147 = new BitSet(new long[]{0x0024000000000000L});
    public static final BitSet FOLLOW_attrScopeAction_in_attrScope149 = new BitSet(new long[]{0x0024000000000000L});
    public static final BitSet FOLLOW_ACTION_in_attrScope154 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AMPERSAND_in_attrScopeAction172 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_attrScopeAction174 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_ACTION_in_attrScopeAction176 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_grammarSpec194 = new BitSet(new long[]{0x80A80C0000018000L});
    public static final BitSet FOLLOW_DOC_COMMENT_in_grammarSpec201 = new BitSet(new long[]{0x80A80C0000018000L});
    public static final BitSet FOLLOW_optionsSpec_in_grammarSpec209 = new BitSet(new long[]{0x80A80C0000018000L});
    public static final BitSet FOLLOW_delegateGrammars_in_grammarSpec217 = new BitSet(new long[]{0x80A80C0000018000L});
    public static final BitSet FOLLOW_tokensSpec_in_grammarSpec224 = new BitSet(new long[]{0x80A80C0000018000L});
    public static final BitSet FOLLOW_attrScope_in_grammarSpec231 = new BitSet(new long[]{0x80A80C0000018000L});
    public static final BitSet FOLLOW_actions_in_grammarSpec238 = new BitSet(new long[]{0x80A80C0000018000L});
    public static final BitSet FOLLOW_rules_in_grammarSpec244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_action_in_actions257 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_AMPERSAND_in_action279 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_action283 = new BitSet(new long[]{0x0004000040000000L});
    public static final BitSet FOLLOW_ID_in_action292 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_ACTION_in_action296 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ACTION_in_action312 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OPTIONS_in_optionsSpec346 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IMPORT_in_delegateGrammars363 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ASSIGN_in_delegateGrammars368 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_delegateGrammars370 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ID_in_delegateGrammars372 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_delegateGrammars377 = new BitSet(new long[]{0x0200000040000008L});
    public static final BitSet FOLLOW_TOKENS_in_tokensSpec394 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tokenSpec_in_tokensSpec396 = new BitSet(new long[]{0x0200000000000008L,0x0000000000000001L});
    public static final BitSet FOLLOW_TOKEN_REF_in_tokenSpec411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_tokenSpec418 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TOKEN_REF_in_tokenSpec423 = new BitSet(new long[]{0x0C00000000000000L});
    public static final BitSet FOLLOW_set_in_tokenSpec428 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rule_in_rules459 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_PREC_RULE_in_rules464 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_RULE_in_rule489 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_rule493 = new BitSet(new long[]{0x0000800080000E00L});
    public static final BitSet FOLLOW_modifier_in_rule501 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ARG_in_rule510 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_rule515 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RET_in_rule526 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_rule531 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_throwsSpec_in_rule541 = new BitSet(new long[]{0x00A0040000040000L});
    public static final BitSet FOLLOW_optionsSpec_in_rule549 = new BitSet(new long[]{0x00A0040000040000L});
    public static final BitSet FOLLOW_ruleScopeSpec_in_rule562 = new BitSet(new long[]{0x00A0040000040000L});
    public static final BitSet FOLLOW_ruleAction_in_rule571 = new BitSet(new long[]{0x00A0040000040000L});
    public static final BitSet FOLLOW_block_in_rule586 = new BitSet(new long[]{0x00000000080000C0L});
    public static final BitSet FOLLOW_exceptionGroup_in_rule592 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_EOR_in_rule599 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AMPERSAND_in_ruleAction623 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_ruleAction627 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_ACTION_in_ruleAction631 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_modifier0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THROWS_in_throwsSpec691 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_throwsSpec694 = new BitSet(new long[]{0x0000000040000008L});
    public static final BitSet FOLLOW_SCOPE_in_ruleScopeSpec724 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attrScopeAction_in_ruleScopeSpec731 = new BitSet(new long[]{0x0024000000000000L});
    public static final BitSet FOLLOW_ACTION_in_ruleScopeSpec736 = new BitSet(new long[]{0x0000000040000008L});
    public static final BitSet FOLLOW_ID_in_ruleScopeSpec757 = new BitSet(new long[]{0x0000000040000008L});
    public static final BitSet FOLLOW_BLOCK_in_block791 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_optionsSpec_in_block797 = new BitSet(new long[]{0x0020000004000000L});
    public static final BitSet FOLLOW_blockAction_in_block805 = new BitSet(new long[]{0x0020000004000000L});
    public static final BitSet FOLLOW_alternative_in_block814 = new BitSet(new long[]{0x0022000014000000L});
    public static final BitSet FOLLOW_rewrite_in_block816 = new BitSet(new long[]{0x0020000014000000L});
    public static final BitSet FOLLOW_EOB_in_block833 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AMPERSAND_in_blockAction857 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_blockAction861 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_ACTION_in_blockAction865 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ALT_in_alternative903 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_alternative906 = new BitSet(new long[]{0x0EA5748023FC0000L,0x0000000000003EC3L});
    public static final BitSet FOLLOW_EOA_in_alternative910 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_exceptionHandler_in_exceptionGroup925 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_finallyClause_in_exceptionGroup931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_finallyClause_in_exceptionGroup938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CATCH_in_exceptionHandler952 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_exceptionHandler954 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_ACTION_in_exceptionHandler956 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FINALLY_in_finallyClause974 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ACTION_in_finallyClause976 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ROOT_in_element993 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_element995 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BANG_in_element1004 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_element1006 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_atom_in_element1014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_element1023 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_element1025 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RANGE_in_element1034 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_atom_in_element1036 = new BitSet(new long[]{0x0C01000000000000L,0x0000000000000C01L});
    public static final BitSet FOLLOW_atom_in_element1039 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CHAR_RANGE_in_element1049 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_atom_in_element1051 = new BitSet(new long[]{0x0C01000000000000L,0x0000000000000C01L});
    public static final BitSet FOLLOW_atom_in_element1054 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSIGN_in_element1063 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_element1067 = new BitSet(new long[]{0x0EA5748023FC0000L,0x0000000000003EC3L});
    public static final BitSet FOLLOW_element_in_element1071 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_ASSIGN_in_element1084 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_element1088 = new BitSet(new long[]{0x0EA5748023FC0000L,0x0000000000003EC3L});
    public static final BitSet FOLLOW_element_in_element1092 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ebnf_in_element1109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tree__in_element1116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYNPRED_in_element1125 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_element1127 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ACTION_in_element1138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FORCED_ACTION_in_element1151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMPRED_in_element1162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYN_SEMPRED_in_element1173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BACKTRACK_SEMPRED_in_element1181 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_GATED_SEMPRED_in_element1192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EPSILON_in_element1203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dotLoop_in_ebnf1221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_ebnf1227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPTIONAL_in_ebnf1234 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_ebnf1236 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CLOSURE_in_ebnf1245 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_ebnf1247 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POSITIVE_CLOSURE_in_ebnf1256 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_ebnf1258 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CLOSURE_in_dotLoop1277 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_dotBlock_in_dotLoop1279 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POSITIVE_CLOSURE_in_dotLoop1289 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_dotBlock_in_dotLoop1291 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BLOCK_in_dotBlock1314 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ALT_in_dotBlock1318 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_WILDCARD_in_dotBlock1320 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_EOA_in_dotBlock1322 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EOB_in_dotBlock1326 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TREE_BEGIN_in_tree_1340 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_tree_1342 = new BitSet(new long[]{0x0EA5748023FC0008L,0x0000000000003EC3L});
    public static final BitSet FOLLOW_RULE_REF_in_atom1360 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_atom1365 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TOKEN_REF_in_atom1382 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_atom1387 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_atom1403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_atom1414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WILDCARD_in_atom1424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_atom1430 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_atom1432 = new BitSet(new long[]{0x0C01000000000000L,0x0000000000000C01L});
    public static final BitSet FOLLOW_atom_in_atom1434 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_ast_suffix0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REWRITES_in_rewrite1471 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_REWRITE_in_rewrite1480 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SEMPRED_in_rewrite1485 = new BitSet(new long[]{0x0004020004000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_rewrite_alternative_in_rewrite1489 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BLOCK_in_rewrite_block1533 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rewrite_alternative_in_rewrite_block1535 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_EOB_in_rewrite_block1537 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ALT_in_rewrite_alternative1569 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rewrite_element_in_rewrite_alternative1575 = new BitSet(new long[]{0x0C04010020380000L,0x0000000000002801L});
    public static final BitSet FOLLOW_EPSILON_in_rewrite_alternative1582 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_EOA_in_rewrite_alternative1586 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rewrite_template_in_rewrite_alternative1597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ETC_in_rewrite_alternative1602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rewrite_atom_in_rewrite_element1616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rewrite_ebnf_in_rewrite_element1621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rewrite_tree_in_rewrite_element1626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPTIONAL_in_rewrite_ebnf1639 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rewrite_block_in_rewrite_ebnf1641 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CLOSURE_in_rewrite_ebnf1650 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rewrite_block_in_rewrite_ebnf1652 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POSITIVE_CLOSURE_in_rewrite_ebnf1661 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rewrite_block_in_rewrite_ebnf1663 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TREE_BEGIN_in_rewrite_tree1680 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rewrite_atom_in_rewrite_tree1682 = new BitSet(new long[]{0x0C04010020380008L,0x0000000000002801L});
    public static final BitSet FOLLOW_rewrite_element_in_rewrite_tree1686 = new BitSet(new long[]{0x0C04010020380008L,0x0000000000002801L});
    public static final BitSet FOLLOW_RULE_REF_in_rewrite_atom1707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOKEN_REF_in_rewrite_atom1717 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_rewrite_atom1725 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_rewrite_atom1750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_rewrite_atom1756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LABEL_in_rewrite_atom1765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_rewrite_atom1770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALT_in_rewrite_template1787 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EPSILON_in_rewrite_template1789 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_EOA_in_rewrite_template1791 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TEMPLATE_in_rewrite_template1800 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_rewrite_template1805 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_ACTION_in_rewrite_template1809 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_ARGLIST_in_rewrite_template1817 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_in_rewrite_template1827 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_rewrite_template1831 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_ACTION_in_rewrite_template1835 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_rewrite_template1866 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ACTION_in_rewrite_template1892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dotLoop_in_synpred1_DefineGrammarItemsWalker1216 = new BitSet(new long[]{0x0000000000000002L});

}