// $ANTLR 3.3 Nov 30, 2010 12:46:29 org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g 2011-08-25 14:59:46

package org.antlr.grammar.v3;
import java.util.StringTokenizer;

import org.antlr.runtime3_4_0.BitSet;
import org.antlr.runtime3_4_0.EarlyExitException;
import org.antlr.runtime3_4_0.MismatchedSetException;
import org.antlr.runtime3_4_0.MismatchedTokenException;
import org.antlr.runtime3_4_0.NoViableAltException;
import org.antlr.runtime3_4_0.RecognitionException;
import org.antlr.runtime3_4_0.RecognizerSharedState;
import org.antlr.runtime3_4_0.Token;
import org.antlr.runtime3_4_0.tree.CommonTreeNodeStream;
import org.antlr.runtime3_4_0.tree.TreeNodeStream;
import org.antlr.runtime3_4_0.tree.TreeParser;
import org.antlr.runtime3_4_0.tree.TreeRuleReturnScope;
import org.antlr.tool.ErrorManager;
import org.antlr.tool.Grammar;
import org.antlr.tool.GrammarAST;

/** Print out a grammar (no pretty printing).
 *
 *  Terence Parr
 *  University of San Francisco
 *  August 19, 2003
 */
public class ANTLRTreePrinter extends TreeParser {
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


        public ANTLRTreePrinter(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public ANTLRTreePrinter(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return ANTLRTreePrinter.tokenNames; }
    public String getGrammarFileName() { return "org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g"; }


    protected Grammar grammar;
    protected boolean showActions;
    protected StringBuilder buf = new StringBuilder(300);

    private ANTLRTreePrinter.block_return block(GrammarAST t, boolean forceParens) throws RecognitionException {
        ANTLRTreePrinter other = new ANTLRTreePrinter(new CommonTreeNodeStream(t));
        other.buf = buf;
        return other.block(forceParens);
    }

    public final int countAltsForBlock(GrammarAST t) {
        int n = 0;
        for ( int i = 0; i < t.getChildCount(); i++ )
        {
            if ( t.getChild(i).getType() == ALT )
                n++;
        }

        return n;
    }

    public void out(String s) {
        buf.append(s);
    }

    @Override
    public void reportError(RecognitionException ex) {
        Token token = null;
        if (ex instanceof MismatchedTokenException) {
            token = ((MismatchedTokenException)ex).token;
        } else if (ex instanceof NoViableAltException) {
            token = ((NoViableAltException)ex).token;
        }

        ErrorManager.syntaxError(
            ErrorManager.MSG_SYNTAX_ERROR,
            grammar,
            token,
            "antlr.print: " + ex.toString(),
            ex );
    }

    /** Normalize a grammar print out by removing all double spaces
     *  and trailing/beginning stuff.  FOr example, convert
     *
     *  ( A  |  B  |  C )*
     *
     *  to
     *
     *  ( A | B | C )*
     */
    public static String normalize(String g) {
        StringTokenizer st = new StringTokenizer(g, " ", false);
        StringBuffer buf = new StringBuffer();
        while ( st.hasMoreTokens() ) {
            String w = st.nextToken();
            buf.append(w);
            buf.append(" ");
        }
        return buf.toString().trim();
    }



    // $ANTLR start "toString"
    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:117:1: public toString[Grammar g, boolean showActions] returns [String s=null] : ( grammar_ | rule | alternative | element | single_rewrite | rewrite | EOR ) ;
    public final String toString(Grammar g, boolean showActions) throws RecognitionException {
        String s = null;


        	grammar = g;
        	this.showActions = showActions;

        try {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:124:2: ( ( grammar_ | rule | alternative | element | single_rewrite | rewrite | EOR ) )
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:124:4: ( grammar_ | rule | alternative | element | single_rewrite | rewrite | EOR )
            {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:124:4: ( grammar_ | rule | alternative | element | single_rewrite | rewrite | EOR )
            int alt1=7;
            switch ( input.LA(1) ) {
            case LEXER_GRAMMAR:
            case PARSER_GRAMMAR:
            case TREE_GRAMMAR:
            case COMBINED_GRAMMAR:
                {
                alt1=1;
                }
                break;
            case RULE:
                {
                alt1=2;
                }
                break;
            case ALT:
                {
                alt1=3;
                }
                break;
            case BLOCK:
            case OPTIONAL:
            case CLOSURE:
            case POSITIVE_CLOSURE:
            case SYNPRED:
            case RANGE:
            case CHAR_RANGE:
            case EPSILON:
            case FORCED_ACTION:
            case LABEL:
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
                alt1=4;
                }
                break;
            case REWRITE:
                {
                alt1=5;
                }
                break;
            case EOF:
            case REWRITES:
                {
                alt1=6;
                }
                break;
            case EOR:
                {
                alt1=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:124:6: grammar_
                    {
                    pushFollow(FOLLOW_grammar__in_toString67);
                    grammar_();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:125:5: rule
                    {
                    pushFollow(FOLLOW_rule_in_toString73);
                    rule();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:126:5: alternative
                    {
                    pushFollow(FOLLOW_alternative_in_toString79);
                    alternative();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:127:5: element
                    {
                    pushFollow(FOLLOW_element_in_toString85);
                    element();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:128:5: single_rewrite
                    {
                    pushFollow(FOLLOW_single_rewrite_in_toString91);
                    single_rewrite();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:129:5: rewrite
                    {
                    pushFollow(FOLLOW_rewrite_in_toString97);
                    rewrite();

                    state._fsp--;


                    }
                    break;
                case 7 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:130:5: EOR
                    {
                    match(input,EOR,FOLLOW_EOR_in_toString103); 

                    }
                    break;

            }

            return normalize(buf.toString());

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return s;
    }
    // $ANTLR end "toString"


    // $ANTLR start "grammar_"
    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:137:1: grammar_ : ( ^( LEXER_GRAMMAR grammarSpec[\"lexer \" ] ) | ^( PARSER_GRAMMAR grammarSpec[\"parser \"] ) | ^( TREE_GRAMMAR grammarSpec[\"tree \"] ) | ^( COMBINED_GRAMMAR grammarSpec[\"\"] ) );
    public final void grammar_() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:138:2: ( ^( LEXER_GRAMMAR grammarSpec[\"lexer \" ] ) | ^( PARSER_GRAMMAR grammarSpec[\"parser \"] ) | ^( TREE_GRAMMAR grammarSpec[\"tree \"] ) | ^( COMBINED_GRAMMAR grammarSpec[\"\"] ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case LEXER_GRAMMAR:
                {
                alt2=1;
                }
                break;
            case PARSER_GRAMMAR:
                {
                alt2=2;
                }
                break;
            case TREE_GRAMMAR:
                {
                alt2=3;
                }
                break;
            case COMBINED_GRAMMAR:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:138:4: ^( LEXER_GRAMMAR grammarSpec[\"lexer \" ] )
                    {
                    match(input,LEXER_GRAMMAR,FOLLOW_LEXER_GRAMMAR_in_grammar_127); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_grammarSpec_in_grammar_129);
                    grammarSpec("lexer ");

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:139:4: ^( PARSER_GRAMMAR grammarSpec[\"parser \"] )
                    {
                    match(input,PARSER_GRAMMAR,FOLLOW_PARSER_GRAMMAR_in_grammar_139); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_grammarSpec_in_grammar_141);
                    grammarSpec("parser ");

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:140:4: ^( TREE_GRAMMAR grammarSpec[\"tree \"] )
                    {
                    match(input,TREE_GRAMMAR,FOLLOW_TREE_GRAMMAR_in_grammar_151); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_grammarSpec_in_grammar_153);
                    grammarSpec("tree ");

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:141:4: ^( COMBINED_GRAMMAR grammarSpec[\"\"] )
                    {
                    match(input,COMBINED_GRAMMAR,FOLLOW_COMBINED_GRAMMAR_in_grammar_163); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_grammarSpec_in_grammar_165);
                    grammarSpec("");

                    state._fsp--;


                    match(input, Token.UP, null); 

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
    // $ANTLR end "grammar_"


    // $ANTLR start "attrScope"
    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:144:1: attrScope : ^( 'scope' ID ( ruleAction )* ACTION ) ;
    public final void attrScope() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:145:2: ( ^( 'scope' ID ( ruleAction )* ACTION ) )
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:145:4: ^( 'scope' ID ( ruleAction )* ACTION )
            {
            match(input,SCOPE,FOLLOW_SCOPE_in_attrScope181); 

            match(input, Token.DOWN, null); 
            match(input,ID,FOLLOW_ID_in_attrScope183); 
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:145:18: ( ruleAction )*
            loop3:
            do {
                int alt3=2;
                switch ( input.LA(1) ) {
                case AMPERSAND:
                    {
                    alt3=1;
                    }
                    break;

                }

                switch (alt3) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:145:18: ruleAction
            	    {
            	    pushFollow(FOLLOW_ruleAction_in_attrScope185);
            	    ruleAction();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match(input,ACTION,FOLLOW_ACTION_in_attrScope188); 

            match(input, Token.UP, null); 

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
    // $ANTLR end "attrScope"


    // $ANTLR start "grammarSpec"
    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:148:1: grammarSpec[String gtype] : id= ID (cmt= DOC_COMMENT )? ( optionsSpec )? ( delegateGrammars )? ( tokensSpec )? ( attrScope )* ( actions )? rules ;
    public final void grammarSpec(String gtype) throws RecognitionException {
        GrammarAST id=null;
        GrammarAST cmt=null;

        try {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:149:2: (id= ID (cmt= DOC_COMMENT )? ( optionsSpec )? ( delegateGrammars )? ( tokensSpec )? ( attrScope )* ( actions )? rules )
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:149:4: id= ID (cmt= DOC_COMMENT )? ( optionsSpec )? ( delegateGrammars )? ( tokensSpec )? ( attrScope )* ( actions )? rules
            {
            id=(GrammarAST)match(input,ID,FOLLOW_ID_in_grammarSpec204); 
            out(gtype+"grammar "+(id!=null?id.getText():null));
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:150:3: (cmt= DOC_COMMENT )?
            int alt4=2;
            switch ( input.LA(1) ) {
                case DOC_COMMENT:
                    {
                    alt4=1;
                    }
                    break;
            }

            switch (alt4) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:150:4: cmt= DOC_COMMENT
                    {
                    cmt=(GrammarAST)match(input,DOC_COMMENT,FOLLOW_DOC_COMMENT_in_grammarSpec213); 
                    out((cmt!=null?cmt.getText():null)+"\n");

                    }
                    break;

            }

            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:151:3: ( optionsSpec )?
            int alt5=2;
            switch ( input.LA(1) ) {
                case OPTIONS:
                    {
                    alt5=1;
                    }
                    break;
            }

            switch (alt5) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:151:4: optionsSpec
                    {
                    pushFollow(FOLLOW_optionsSpec_in_grammarSpec223);
                    optionsSpec();

                    state._fsp--;


                    }
                    break;

            }

            out(";\n");
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:152:3: ( delegateGrammars )?
            int alt6=2;
            switch ( input.LA(1) ) {
                case IMPORT:
                    {
                    alt6=1;
                    }
                    break;
            }

            switch (alt6) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:152:4: delegateGrammars
                    {
                    pushFollow(FOLLOW_delegateGrammars_in_grammarSpec232);
                    delegateGrammars();

                    state._fsp--;


                    }
                    break;

            }

            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:153:3: ( tokensSpec )?
            int alt7=2;
            switch ( input.LA(1) ) {
                case TOKENS:
                    {
                    alt7=1;
                    }
                    break;
            }

            switch (alt7) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:153:4: tokensSpec
                    {
                    pushFollow(FOLLOW_tokensSpec_in_grammarSpec239);
                    tokensSpec();

                    state._fsp--;


                    }
                    break;

            }

            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:154:3: ( attrScope )*
            loop8:
            do {
                int alt8=2;
                switch ( input.LA(1) ) {
                case SCOPE:
                    {
                    alt8=1;
                    }
                    break;

                }

                switch (alt8) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:154:4: attrScope
            	    {
            	    pushFollow(FOLLOW_attrScope_in_grammarSpec246);
            	    attrScope();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:155:3: ( actions )?
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
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:155:4: actions
                    {
                    pushFollow(FOLLOW_actions_in_grammarSpec253);
                    actions();

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_rules_in_grammarSpec259);
            rules();

            state._fsp--;


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
    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:159:1: actions : ( action )+ ;
    public final void actions() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:160:2: ( ( action )+ )
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:160:4: ( action )+
            {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:160:4: ( action )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                switch ( input.LA(1) ) {
                case AMPERSAND:
                    {
                    alt10=1;
                    }
                    break;

                }

                switch (alt10) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:160:6: action
            	    {
            	    pushFollow(FOLLOW_action_in_actions272);
            	    action();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
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
    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:163:1: action : ^( AMPERSAND id1= ID (id2= ID a1= ACTION | a2= ACTION ) ) ;
    public final void action() throws RecognitionException {
        GrammarAST id1=null;
        GrammarAST id2=null;
        GrammarAST a1=null;
        GrammarAST a2=null;


        	String scope=null, name=null;
        	String action=null;

        try {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:168:2: ( ^( AMPERSAND id1= ID (id2= ID a1= ACTION | a2= ACTION ) ) )
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:168:4: ^( AMPERSAND id1= ID (id2= ID a1= ACTION | a2= ACTION ) )
            {
            match(input,AMPERSAND,FOLLOW_AMPERSAND_in_action293); 

            match(input, Token.DOWN, null); 
            id1=(GrammarAST)match(input,ID,FOLLOW_ID_in_action297); 
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:169:4: (id2= ID a1= ACTION | a2= ACTION )
            int alt11=2;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt11=1;
                }
                break;
            case ACTION:
                {
                alt11=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:169:6: id2= ID a1= ACTION
                    {
                    id2=(GrammarAST)match(input,ID,FOLLOW_ID_in_action306); 
                    a1=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_action310); 
                    scope=(id1!=null?id1.getText():null); name=(a1!=null?a1.getText():null); action=(a1!=null?a1.getText():null);

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:171:6: a2= ACTION
                    {
                    a2=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_action325); 
                    scope=null; name=(id1!=null?id1.getText():null); action=(a2!=null?a2.getText():null);

                    }
                    break;

            }


            match(input, Token.UP, null); 

            			if ( showActions )
            			{
            				out("@"+(scope!=null?scope+"::":"")+name+action);
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
    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:183:1: optionsSpec : ^( OPTIONS ( option )+ ) ;
    public final void optionsSpec() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:184:2: ( ^( OPTIONS ( option )+ ) )
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:184:4: ^( OPTIONS ( option )+ )
            {
            match(input,OPTIONS,FOLLOW_OPTIONS_in_optionsSpec357); 

            out(" options {");

            match(input, Token.DOWN, null); 
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:185:4: ( option )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                switch ( input.LA(1) ) {
                case ASSIGN:
                    {
                    alt12=1;
                    }
                    break;

                }

                switch (alt12) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:185:5: option
            	    {
            	    pushFollow(FOLLOW_option_in_optionsSpec365);
            	    option();

            	    state._fsp--;

            	    out("; ");

            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);

            out("} ");

            match(input, Token.UP, null); 

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


    // $ANTLR start "option"
    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:190:1: option : ^( ASSIGN id= ID optionValue ) ;
    public final void option() throws RecognitionException {
        GrammarAST id=null;

        try {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:191:2: ( ^( ASSIGN id= ID optionValue ) )
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:191:4: ^( ASSIGN id= ID optionValue )
            {
            match(input,ASSIGN,FOLLOW_ASSIGN_in_option391); 

            match(input, Token.DOWN, null); 
            id=(GrammarAST)match(input,ID,FOLLOW_ID_in_option395); 
            out((id!=null?id.getText():null)+"=");
            pushFollow(FOLLOW_optionValue_in_option399);
            optionValue();

            state._fsp--;


            match(input, Token.UP, null); 

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
    // $ANTLR end "option"


    // $ANTLR start "optionValue"
    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:194:1: optionValue : (id= ID | s= STRING_LITERAL | c= CHAR_LITERAL | i= INT );
    public final void optionValue() throws RecognitionException {
        GrammarAST id=null;
        GrammarAST s=null;
        GrammarAST c=null;
        GrammarAST i=null;

        try {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:195:2: (id= ID | s= STRING_LITERAL | c= CHAR_LITERAL | i= INT )
            int alt13=4;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt13=1;
                }
                break;
            case STRING_LITERAL:
                {
                alt13=2;
                }
                break;
            case CHAR_LITERAL:
                {
                alt13=3;
                }
                break;
            case INT:
                {
                alt13=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:195:4: id= ID
                    {
                    id=(GrammarAST)match(input,ID,FOLLOW_ID_in_optionValue414); 
                    out((id!=null?id.getText():null));

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:196:4: s= STRING_LITERAL
                    {
                    s=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_optionValue434); 
                    out((s!=null?s.getText():null));

                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:197:4: c= CHAR_LITERAL
                    {
                    c=(GrammarAST)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_optionValue443); 
                    out((c!=null?c.getText():null));

                    }
                    break;
                case 4 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:198:4: i= INT
                    {
                    i=(GrammarAST)match(input,INT,FOLLOW_INT_in_optionValue454); 
                    out((i!=null?i.getText():null));

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
    // $ANTLR end "optionValue"


    // $ANTLR start "delegateGrammars"
    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:214:1: delegateGrammars : ^( 'import' ( ^( ASSIGN ID ID ) | ID )+ ) ;
    public final void delegateGrammars() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:215:2: ( ^( 'import' ( ^( ASSIGN ID ID ) | ID )+ ) )
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:215:4: ^( 'import' ( ^( ASSIGN ID ID ) | ID )+ )
            {
            match(input,IMPORT,FOLLOW_IMPORT_in_delegateGrammars484); 

            match(input, Token.DOWN, null); 
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:215:16: ( ^( ASSIGN ID ID ) | ID )+
            int cnt14=0;
            loop14:
            do {
                int alt14=3;
                switch ( input.LA(1) ) {
                case ASSIGN:
                    {
                    alt14=1;
                    }
                    break;
                case ID:
                    {
                    alt14=2;
                    }
                    break;

                }

                switch (alt14) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:215:18: ^( ASSIGN ID ID )
            	    {
            	    match(input,ASSIGN,FOLLOW_ASSIGN_in_delegateGrammars489); 

            	    match(input, Token.DOWN, null); 
            	    match(input,ID,FOLLOW_ID_in_delegateGrammars491); 
            	    match(input,ID,FOLLOW_ID_in_delegateGrammars493); 

            	    match(input, Token.UP, null); 

            	    }
            	    break;
            	case 2 :
            	    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:215:36: ID
            	    {
            	    match(input,ID,FOLLOW_ID_in_delegateGrammars498); 

            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


            match(input, Token.UP, null); 

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
    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:218:1: tokensSpec : ^( TOKENS ( tokenSpec )* ) ;
    public final void tokensSpec() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:219:2: ( ^( TOKENS ( tokenSpec )* ) )
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:219:4: ^( TOKENS ( tokenSpec )* )
            {
            match(input,TOKENS,FOLLOW_TOKENS_in_tokensSpec515); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:219:13: ( tokenSpec )*
                loop15:
                do {
                    int alt15=2;
                    switch ( input.LA(1) ) {
                    case ASSIGN:
                    case TOKEN_REF:
                        {
                        alt15=1;
                        }
                        break;

                    }

                    switch (alt15) {
                	case 1 :
                	    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:219:13: tokenSpec
                	    {
                	    pushFollow(FOLLOW_tokenSpec_in_tokensSpec517);
                	    tokenSpec();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop15;
                    }
                } while (true);


                match(input, Token.UP, null); 
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
    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:222:1: tokenSpec : ( TOKEN_REF | ^( ASSIGN TOKEN_REF ( STRING_LITERAL | CHAR_LITERAL ) ) );
    public final void tokenSpec() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:223:2: ( TOKEN_REF | ^( ASSIGN TOKEN_REF ( STRING_LITERAL | CHAR_LITERAL ) ) )
            int alt16=2;
            switch ( input.LA(1) ) {
            case TOKEN_REF:
                {
                alt16=1;
                }
                break;
            case ASSIGN:
                {
                alt16=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:223:4: TOKEN_REF
                    {
                    match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_tokenSpec530); 

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:224:4: ^( ASSIGN TOKEN_REF ( STRING_LITERAL | CHAR_LITERAL ) )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_tokenSpec537); 

                    match(input, Token.DOWN, null); 
                    match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_tokenSpec539); 
                    if ( (input.LA(1)>=STRING_LITERAL && input.LA(1)<=CHAR_LITERAL) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    match(input, Token.UP, null); 

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
    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:227:1: rules : ( rule | precRule )+ ;
    public final void rules() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:228:2: ( ( rule | precRule )+ )
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:228:4: ( rule | precRule )+
            {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:228:4: ( rule | precRule )+
            int cnt17=0;
            loop17:
            do {
                int alt17=3;
                switch ( input.LA(1) ) {
                case RULE:
                    {
                    alt17=1;
                    }
                    break;
                case PREC_RULE:
                    {
                    alt17=2;
                    }
                    break;

                }

                switch (alt17) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:228:6: rule
            	    {
            	    pushFollow(FOLLOW_rule_in_rules560);
            	    rule();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:228:13: precRule
            	    {
            	    pushFollow(FOLLOW_precRule_in_rules564);
            	    precRule();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
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


    // $ANTLR start "rule"
    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:231:1: rule : ^( RULE id= ID ( modifier )? ^( ARG (arg= ARG_ACTION )? ) ^( RET (ret= ARG_ACTION )? ) ( throwsSpec )? ( optionsSpec )? ( ruleScopeSpec )? ( ruleAction )* b= block[false] ( exceptionGroup )? EOR ) ;
    public final void rule() throws RecognitionException {
        GrammarAST id=null;
        GrammarAST arg=null;
        GrammarAST ret=null;
        ANTLRTreePrinter.block_return b = null;


        try {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:232:2: ( ^( RULE id= ID ( modifier )? ^( ARG (arg= ARG_ACTION )? ) ^( RET (ret= ARG_ACTION )? ) ( throwsSpec )? ( optionsSpec )? ( ruleScopeSpec )? ( ruleAction )* b= block[false] ( exceptionGroup )? EOR ) )
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:232:4: ^( RULE id= ID ( modifier )? ^( ARG (arg= ARG_ACTION )? ) ^( RET (ret= ARG_ACTION )? ) ( throwsSpec )? ( optionsSpec )? ( ruleScopeSpec )? ( ruleAction )* b= block[false] ( exceptionGroup )? EOR )
            {
            match(input,RULE,FOLLOW_RULE_in_rule580); 

            match(input, Token.DOWN, null); 
            id=(GrammarAST)match(input,ID,FOLLOW_ID_in_rule584); 
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:233:4: ( modifier )?
            int alt18=2;
            switch ( input.LA(1) ) {
                case PRIVATE:
                case PROTECTED:
                case PUBLIC:
                case FRAGMENT:
                    {
                    alt18=1;
                    }
                    break;
            }

            switch (alt18) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:233:5: modifier
                    {
                    pushFollow(FOLLOW_modifier_in_rule590);
                    modifier();

                    state._fsp--;


                    }
                    break;

            }

            out((id!=null?id.getText():null));
            match(input,ARG,FOLLOW_ARG_in_rule603); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:235:10: (arg= ARG_ACTION )?
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
                        // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:235:11: arg= ARG_ACTION
                        {
                        arg=(GrammarAST)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rule608); 
                        out("["+(arg!=null?arg.getText():null)+"]");

                        }
                        break;

                }


                match(input, Token.UP, null); 
            }
            match(input,RET,FOLLOW_RET_in_rule621); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:236:10: (ret= ARG_ACTION )?
                int alt20=2;
                switch ( input.LA(1) ) {
                    case ARG_ACTION:
                        {
                        alt20=1;
                        }
                        break;
                }

                switch (alt20) {
                    case 1 :
                        // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:236:11: ret= ARG_ACTION
                        {
                        ret=(GrammarAST)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rule626); 
                        out(" returns ["+(ret!=null?ret.getText():null)+"]");

                        }
                        break;

                }


                match(input, Token.UP, null); 
            }
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:237:4: ( throwsSpec )?
            int alt21=2;
            switch ( input.LA(1) ) {
                case THROWS:
                    {
                    alt21=1;
                    }
                    break;
            }

            switch (alt21) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:237:5: throwsSpec
                    {
                    pushFollow(FOLLOW_throwsSpec_in_rule639);
                    throwsSpec();

                    state._fsp--;


                    }
                    break;

            }

            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:238:4: ( optionsSpec )?
            int alt22=2;
            switch ( input.LA(1) ) {
                case OPTIONS:
                    {
                    alt22=1;
                    }
                    break;
            }

            switch (alt22) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:238:5: optionsSpec
                    {
                    pushFollow(FOLLOW_optionsSpec_in_rule647);
                    optionsSpec();

                    state._fsp--;


                    }
                    break;

            }

            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:239:4: ( ruleScopeSpec )?
            int alt23=2;
            switch ( input.LA(1) ) {
                case SCOPE:
                    {
                    alt23=1;
                    }
                    break;
            }

            switch (alt23) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:239:5: ruleScopeSpec
                    {
                    pushFollow(FOLLOW_ruleScopeSpec_in_rule655);
                    ruleScopeSpec();

                    state._fsp--;


                    }
                    break;

            }

            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:240:4: ( ruleAction )*
            loop24:
            do {
                int alt24=2;
                switch ( input.LA(1) ) {
                case AMPERSAND:
                    {
                    alt24=1;
                    }
                    break;

                }

                switch (alt24) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:240:5: ruleAction
            	    {
            	    pushFollow(FOLLOW_ruleAction_in_rule663);
            	    ruleAction();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            out(" :");

            				if ( input.LA(5) == NOT || input.LA(5) == ASSIGN )
            					out(" ");
            			
            pushFollow(FOLLOW_block_in_rule682);
            b=block(false);

            state._fsp--;

            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:247:4: ( exceptionGroup )?
            int alt25=2;
            switch ( input.LA(1) ) {
                case CATCH:
                case FINALLY:
                    {
                    alt25=1;
                    }
                    break;
            }

            switch (alt25) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:247:5: exceptionGroup
                    {
                    pushFollow(FOLLOW_exceptionGroup_in_rule689);
                    exceptionGroup();

                    state._fsp--;


                    }
                    break;

            }

            match(input,EOR,FOLLOW_EOR_in_rule696); 
            out(";\n");

            match(input, Token.UP, null); 

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
    // $ANTLR end "rule"


    // $ANTLR start "precRule"
    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:252:1: precRule : ^( PREC_RULE id= ID ( modifier )? ^( ARG (arg= ARG_ACTION )? ) ^( RET (ret= ARG_ACTION )? ) ( throwsSpec )? ( optionsSpec )? ( ruleScopeSpec )? ( ruleAction )* b= block[false] ( exceptionGroup )? EOR ) ;
    public final void precRule() throws RecognitionException {
        GrammarAST id=null;
        GrammarAST arg=null;
        GrammarAST ret=null;
        ANTLRTreePrinter.block_return b = null;


        try {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:253:2: ( ^( PREC_RULE id= ID ( modifier )? ^( ARG (arg= ARG_ACTION )? ) ^( RET (ret= ARG_ACTION )? ) ( throwsSpec )? ( optionsSpec )? ( ruleScopeSpec )? ( ruleAction )* b= block[false] ( exceptionGroup )? EOR ) )
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:253:4: ^( PREC_RULE id= ID ( modifier )? ^( ARG (arg= ARG_ACTION )? ) ^( RET (ret= ARG_ACTION )? ) ( throwsSpec )? ( optionsSpec )? ( ruleScopeSpec )? ( ruleAction )* b= block[false] ( exceptionGroup )? EOR )
            {
            match(input,PREC_RULE,FOLLOW_PREC_RULE_in_precRule715); 

            match(input, Token.DOWN, null); 
            id=(GrammarAST)match(input,ID,FOLLOW_ID_in_precRule719); 
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:254:4: ( modifier )?
            int alt26=2;
            switch ( input.LA(1) ) {
                case PRIVATE:
                case PROTECTED:
                case PUBLIC:
                case FRAGMENT:
                    {
                    alt26=1;
                    }
                    break;
            }

            switch (alt26) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:254:5: modifier
                    {
                    pushFollow(FOLLOW_modifier_in_precRule725);
                    modifier();

                    state._fsp--;


                    }
                    break;

            }

            out((id!=null?id.getText():null));
            match(input,ARG,FOLLOW_ARG_in_precRule738); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:256:10: (arg= ARG_ACTION )?
                int alt27=2;
                switch ( input.LA(1) ) {
                    case ARG_ACTION:
                        {
                        alt27=1;
                        }
                        break;
                }

                switch (alt27) {
                    case 1 :
                        // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:256:11: arg= ARG_ACTION
                        {
                        arg=(GrammarAST)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_precRule743); 
                        out("["+(arg!=null?arg.getText():null)+"]");

                        }
                        break;

                }


                match(input, Token.UP, null); 
            }
            match(input,RET,FOLLOW_RET_in_precRule756); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:257:10: (ret= ARG_ACTION )?
                int alt28=2;
                switch ( input.LA(1) ) {
                    case ARG_ACTION:
                        {
                        alt28=1;
                        }
                        break;
                }

                switch (alt28) {
                    case 1 :
                        // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:257:11: ret= ARG_ACTION
                        {
                        ret=(GrammarAST)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_precRule761); 
                        out(" returns ["+(ret!=null?ret.getText():null)+"]");

                        }
                        break;

                }


                match(input, Token.UP, null); 
            }
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:258:4: ( throwsSpec )?
            int alt29=2;
            switch ( input.LA(1) ) {
                case THROWS:
                    {
                    alt29=1;
                    }
                    break;
            }

            switch (alt29) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:258:5: throwsSpec
                    {
                    pushFollow(FOLLOW_throwsSpec_in_precRule774);
                    throwsSpec();

                    state._fsp--;


                    }
                    break;

            }

            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:259:4: ( optionsSpec )?
            int alt30=2;
            switch ( input.LA(1) ) {
                case OPTIONS:
                    {
                    alt30=1;
                    }
                    break;
            }

            switch (alt30) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:259:5: optionsSpec
                    {
                    pushFollow(FOLLOW_optionsSpec_in_precRule782);
                    optionsSpec();

                    state._fsp--;


                    }
                    break;

            }

            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:260:4: ( ruleScopeSpec )?
            int alt31=2;
            switch ( input.LA(1) ) {
                case SCOPE:
                    {
                    alt31=1;
                    }
                    break;
            }

            switch (alt31) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:260:5: ruleScopeSpec
                    {
                    pushFollow(FOLLOW_ruleScopeSpec_in_precRule790);
                    ruleScopeSpec();

                    state._fsp--;


                    }
                    break;

            }

            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:261:4: ( ruleAction )*
            loop32:
            do {
                int alt32=2;
                switch ( input.LA(1) ) {
                case AMPERSAND:
                    {
                    alt32=1;
                    }
                    break;

                }

                switch (alt32) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:261:5: ruleAction
            	    {
            	    pushFollow(FOLLOW_ruleAction_in_precRule798);
            	    ruleAction();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            out(" :");

            				if ( input.LA(5) == NOT || input.LA(5) == ASSIGN )
            					out(" ");
            			
            pushFollow(FOLLOW_block_in_precRule817);
            b=block(false);

            state._fsp--;

            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:268:4: ( exceptionGroup )?
            int alt33=2;
            switch ( input.LA(1) ) {
                case CATCH:
                case FINALLY:
                    {
                    alt33=1;
                    }
                    break;
            }

            switch (alt33) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:268:5: exceptionGroup
                    {
                    pushFollow(FOLLOW_exceptionGroup_in_precRule824);
                    exceptionGroup();

                    state._fsp--;


                    }
                    break;

            }

            match(input,EOR,FOLLOW_EOR_in_precRule831); 
            out(";\n");

            match(input, Token.UP, null); 

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
    // $ANTLR end "precRule"


    // $ANTLR start "ruleAction"
    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:273:1: ruleAction : ^( AMPERSAND id= ID a= ACTION ) ;
    public final void ruleAction() throws RecognitionException {
        GrammarAST id=null;
        GrammarAST a=null;

        try {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:274:2: ( ^( AMPERSAND id= ID a= ACTION ) )
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:274:4: ^( AMPERSAND id= ID a= ACTION )
            {
            match(input,AMPERSAND,FOLLOW_AMPERSAND_in_ruleAction849); 

            match(input, Token.DOWN, null); 
            id=(GrammarAST)match(input,ID,FOLLOW_ID_in_ruleAction853); 
            a=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_ruleAction857); 

            match(input, Token.UP, null); 
            if ( showActions ) out("@"+(id!=null?id.getText():null)+"{"+(a!=null?a.getText():null)+"}");

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
    };

    // $ANTLR start "modifier"
    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:278:1: modifier : ( 'protected' | 'public' | 'private' | 'fragment' );
    public final ANTLRTreePrinter.modifier_return modifier() throws RecognitionException {
        ANTLRTreePrinter.modifier_return retval = new ANTLRTreePrinter.modifier_return();
        retval.start = input.LT(1);

        out(((GrammarAST)retval.start).getText()); out(" ");
        try {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:281:2: ( 'protected' | 'public' | 'private' | 'fragment' )
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:
            {
            if ( (input.LA(1)>=PRIVATE && input.LA(1)<=PUBLIC)||input.LA(1)==FRAGMENT ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
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
    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:287:1: throwsSpec : ^( 'throws' ( ID )+ ) ;
    public final void throwsSpec() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:288:2: ( ^( 'throws' ( ID )+ ) )
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:288:4: ^( 'throws' ( ID )+ )
            {
            match(input,THROWS,FOLLOW_THROWS_in_throwsSpec906); 

            match(input, Token.DOWN, null); 
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:288:15: ( ID )+
            int cnt34=0;
            loop34:
            do {
                int alt34=2;
                switch ( input.LA(1) ) {
                case ID:
                    {
                    alt34=1;
                    }
                    break;

                }

                switch (alt34) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:288:15: ID
            	    {
            	    match(input,ID,FOLLOW_ID_in_throwsSpec908); 

            	    }
            	    break;

            	default :
            	    if ( cnt34 >= 1 ) break loop34;
                        EarlyExitException eee =
                            new EarlyExitException(34, input);
                        throw eee;
                }
                cnt34++;
            } while (true);


            match(input, Token.UP, null); 

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
    // $ANTLR end "throwsSpec"


    // $ANTLR start "ruleScopeSpec"
    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:291:1: ruleScopeSpec : ^( 'scope' ( ruleAction )* ( ACTION )? ( ID )* ) ;
    public final void ruleScopeSpec() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:292:2: ( ^( 'scope' ( ruleAction )* ( ACTION )? ( ID )* ) )
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:292:4: ^( 'scope' ( ruleAction )* ( ACTION )? ( ID )* )
            {
            match(input,SCOPE,FOLLOW_SCOPE_in_ruleScopeSpec923); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:292:15: ( ruleAction )*
                loop35:
                do {
                    int alt35=2;
                    switch ( input.LA(1) ) {
                    case AMPERSAND:
                        {
                        alt35=1;
                        }
                        break;

                    }

                    switch (alt35) {
                	case 1 :
                	    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:292:15: ruleAction
                	    {
                	    pushFollow(FOLLOW_ruleAction_in_ruleScopeSpec925);
                	    ruleAction();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop35;
                    }
                } while (true);

                // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:292:27: ( ACTION )?
                int alt36=2;
                switch ( input.LA(1) ) {
                    case ACTION:
                        {
                        alt36=1;
                        }
                        break;
                }

                switch (alt36) {
                    case 1 :
                        // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:292:28: ACTION
                        {
                        match(input,ACTION,FOLLOW_ACTION_in_ruleScopeSpec929); 

                        }
                        break;

                }

                // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:292:37: ( ID )*
                loop37:
                do {
                    int alt37=2;
                    switch ( input.LA(1) ) {
                    case ID:
                        {
                        alt37=1;
                        }
                        break;

                    }

                    switch (alt37) {
                	case 1 :
                	    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:292:39: ID
                	    {
                	    match(input,ID,FOLLOW_ID_in_ruleScopeSpec935); 

                	    }
                	    break;

                	default :
                	    break loop37;
                    }
                } while (true);


                match(input, Token.UP, null); 
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
    // $ANTLR end "ruleScopeSpec"

    public static class block_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "block"
    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:295:1: block[boolean forceParens] : ^( BLOCK ( optionsSpec )? alternative rewrite ( alternative rewrite )* EOB ) ;
    public final ANTLRTreePrinter.block_return block(boolean forceParens) throws RecognitionException {
        ANTLRTreePrinter.block_return retval = new ANTLRTreePrinter.block_return();
        retval.start = input.LT(1);


        int numAlts = countAltsForBlock(((GrammarAST)retval.start));

        try {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:300:2: ( ^( BLOCK ( optionsSpec )? alternative rewrite ( alternative rewrite )* EOB ) )
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:300:4: ^( BLOCK ( optionsSpec )? alternative rewrite ( alternative rewrite )* EOB )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_block959); 


            				if ( forceParens||numAlts>1 )
            				{
            					//for ( Antlr.Runtime.Tree.Tree parent = ((GrammarAST)retval.start).getParent(); parent != null && parent.getType() != RULE; parent = parent.getParent() )
            					//{
            					//	if ( parent.getType() == BLOCK && countAltsForBlock((GrammarAST)parent) > 1 )
            					//	{
            					//		out(" ");
            					//		break;
            					//	}
            					//}
            					out(" (");
            				}
            			

            match(input, Token.DOWN, null); 
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:315:4: ( optionsSpec )?
            int alt38=2;
            switch ( input.LA(1) ) {
                case OPTIONS:
                    {
                    alt38=1;
                    }
                    break;
            }

            switch (alt38) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:315:5: optionsSpec
                    {
                    pushFollow(FOLLOW_optionsSpec_in_block970);
                    optionsSpec();

                    state._fsp--;

                    out(" :");

                    }
                    break;

            }

            pushFollow(FOLLOW_alternative_in_block980);
            alternative();

            state._fsp--;

            pushFollow(FOLLOW_rewrite_in_block982);
            rewrite();

            state._fsp--;

            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:316:24: ( alternative rewrite )*
            loop39:
            do {
                int alt39=2;
                switch ( input.LA(1) ) {
                case ALT:
                    {
                    alt39=1;
                    }
                    break;

                }

                switch (alt39) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:316:26: alternative rewrite
            	    {
            	    out("|");
            	    pushFollow(FOLLOW_alternative_in_block988);
            	    alternative();

            	    state._fsp--;

            	    pushFollow(FOLLOW_rewrite_in_block990);
            	    rewrite();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

            match(input,EOB,FOLLOW_EOB_in_block998); 
            if ( forceParens||numAlts>1 ) out(")");

            match(input, Token.UP, null); 

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
    // $ANTLR end "block"


    // $ANTLR start "alternative"
    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:321:1: alternative : ^( ALT ( element )* EOA ) ;
    public final void alternative() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:322:2: ( ^( ALT ( element )* EOA ) )
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:322:4: ^( ALT ( element )* EOA )
            {
            match(input,ALT,FOLLOW_ALT_in_alternative1020); 

            match(input, Token.DOWN, null); 
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:322:11: ( element )*
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
                case LABEL:
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
            	    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:322:11: element
            	    {
            	    pushFollow(FOLLOW_element_in_alternative1022);
            	    element();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

            match(input,EOA,FOLLOW_EOA_in_alternative1025); 

            match(input, Token.UP, null); 

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
    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:325:1: exceptionGroup : ( ( exceptionHandler )+ ( finallyClause )? | finallyClause );
    public final void exceptionGroup() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:326:2: ( ( exceptionHandler )+ ( finallyClause )? | finallyClause )
            int alt43=2;
            switch ( input.LA(1) ) {
            case CATCH:
                {
                alt43=1;
                }
                break;
            case FINALLY:
                {
                alt43=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:326:4: ( exceptionHandler )+ ( finallyClause )?
                    {
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:326:4: ( exceptionHandler )+
                    int cnt41=0;
                    loop41:
                    do {
                        int alt41=2;
                        switch ( input.LA(1) ) {
                        case CATCH:
                            {
                            alt41=1;
                            }
                            break;

                        }

                        switch (alt41) {
                    	case 1 :
                    	    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:326:6: exceptionHandler
                    	    {
                    	    pushFollow(FOLLOW_exceptionHandler_in_exceptionGroup1040);
                    	    exceptionHandler();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt41 >= 1 ) break loop41;
                                EarlyExitException eee =
                                    new EarlyExitException(41, input);
                                throw eee;
                        }
                        cnt41++;
                    } while (true);

                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:326:26: ( finallyClause )?
                    int alt42=2;
                    switch ( input.LA(1) ) {
                        case FINALLY:
                            {
                            alt42=1;
                            }
                            break;
                    }

                    switch (alt42) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:326:27: finallyClause
                            {
                            pushFollow(FOLLOW_finallyClause_in_exceptionGroup1046);
                            finallyClause();

                            state._fsp--;


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:327:4: finallyClause
                    {
                    pushFollow(FOLLOW_finallyClause_in_exceptionGroup1053);
                    finallyClause();

                    state._fsp--;


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
    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:330:1: exceptionHandler : ^( 'catch' ARG_ACTION ACTION ) ;
    public final void exceptionHandler() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:331:2: ( ^( 'catch' ARG_ACTION ACTION ) )
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:331:4: ^( 'catch' ARG_ACTION ACTION )
            {
            match(input,CATCH,FOLLOW_CATCH_in_exceptionHandler1065); 

            match(input, Token.DOWN, null); 
            match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_exceptionHandler1067); 
            match(input,ACTION,FOLLOW_ACTION_in_exceptionHandler1069); 

            match(input, Token.UP, null); 

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
    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:334:1: finallyClause : ^( 'finally' ACTION ) ;
    public final void finallyClause() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:335:2: ( ^( 'finally' ACTION ) )
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:335:4: ^( 'finally' ACTION )
            {
            match(input,FINALLY,FOLLOW_FINALLY_in_finallyClause1082); 

            match(input, Token.DOWN, null); 
            match(input,ACTION,FOLLOW_ACTION_in_finallyClause1084); 

            match(input, Token.UP, null); 

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


    // $ANTLR start "rewrite"
    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:338:1: rewrite : ( ^( REWRITES ( single_rewrite )+ ) | REWRITES | );
    public final void rewrite() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:339:2: ( ^( REWRITES ( single_rewrite )+ ) | REWRITES | )
            int alt45=3;
            switch ( input.LA(1) ) {
            case REWRITES:
                {
                switch ( input.LA(2) ) {
                case DOWN:
                    {
                    alt45=1;
                    }
                    break;
                case EOF:
                case ALT:
                case EOB:
                    {
                    alt45=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 1, input);

                    throw nvae;
                }

                }
                break;
            case EOF:
            case ALT:
            case EOB:
                {
                alt45=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:339:4: ^( REWRITES ( single_rewrite )+ )
                    {
                    match(input,REWRITES,FOLLOW_REWRITES_in_rewrite1097); 

                    match(input, Token.DOWN, null); 
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:339:15: ( single_rewrite )+
                    int cnt44=0;
                    loop44:
                    do {
                        int alt44=2;
                        switch ( input.LA(1) ) {
                        case REWRITE:
                            {
                            alt44=1;
                            }
                            break;

                        }

                        switch (alt44) {
                    	case 1 :
                    	    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:339:15: single_rewrite
                    	    {
                    	    pushFollow(FOLLOW_single_rewrite_in_rewrite1099);
                    	    single_rewrite();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt44 >= 1 ) break loop44;
                                EarlyExitException eee =
                                    new EarlyExitException(44, input);
                                throw eee;
                        }
                        cnt44++;
                    } while (true);


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:340:4: REWRITES
                    {
                    match(input,REWRITES,FOLLOW_REWRITES_in_rewrite1106); 

                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:342:2: 
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
        return ;
    }
    // $ANTLR end "rewrite"


    // $ANTLR start "single_rewrite"
    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:344:1: single_rewrite : ^( REWRITE ( SEMPRED )? ( alternative | rewrite_template | ETC | ACTION ) ) ;
    public final void single_rewrite() throws RecognitionException {
        GrammarAST SEMPRED1=null;
        GrammarAST ACTION2=null;

        try {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:345:2: ( ^( REWRITE ( SEMPRED )? ( alternative | rewrite_template | ETC | ACTION ) ) )
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:345:4: ^( REWRITE ( SEMPRED )? ( alternative | rewrite_template | ETC | ACTION ) )
            {
            match(input,REWRITE,FOLLOW_REWRITE_in_single_rewrite1122); 

            out(" ->");

            match(input, Token.DOWN, null); 
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:346:4: ( SEMPRED )?
            int alt46=2;
            switch ( input.LA(1) ) {
                case SEMPRED:
                    {
                    alt46=1;
                    }
                    break;
            }

            switch (alt46) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:346:6: SEMPRED
                    {
                    SEMPRED1=(GrammarAST)match(input,SEMPRED,FOLLOW_SEMPRED_in_single_rewrite1131); 
                    out(" {"+(SEMPRED1!=null?SEMPRED1.getText():null)+"}?");

                    }
                    break;

            }

            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:348:4: ( alternative | rewrite_template | ETC | ACTION )
            int alt47=4;
            switch ( input.LA(1) ) {
            case ALT:
                {
                alt47=1;
                }
                break;
            case TEMPLATE:
                {
                alt47=2;
                }
                break;
            case ETC:
                {
                alt47=3;
                }
                break;
            case ACTION:
                {
                alt47=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:348:6: alternative
                    {
                    pushFollow(FOLLOW_alternative_in_single_rewrite1146);
                    alternative();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:349:6: rewrite_template
                    {
                    pushFollow(FOLLOW_rewrite_template_in_single_rewrite1153);
                    rewrite_template();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:350:6: ETC
                    {
                    match(input,ETC,FOLLOW_ETC_in_single_rewrite1160); 
                    out("...");

                    }
                    break;
                case 4 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:351:6: ACTION
                    {
                    ACTION2=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_single_rewrite1169); 
                    out(" {"+(ACTION2!=null?ACTION2.getText():null)+"}");

                    }
                    break;

            }


            match(input, Token.UP, null); 

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
    // $ANTLR end "single_rewrite"


    // $ANTLR start "rewrite_template"
    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:356:1: rewrite_template : ^( TEMPLATE (id= ID | ind= ACTION ) ^( ARGLIST ( ^( ARG arg= ID a= ACTION ) )* ) ( DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL )? ) ;
    public final void rewrite_template() throws RecognitionException {
        GrammarAST id=null;
        GrammarAST ind=null;
        GrammarAST arg=null;
        GrammarAST a=null;
        GrammarAST DOUBLE_QUOTE_STRING_LITERAL3=null;
        GrammarAST DOUBLE_ANGLE_STRING_LITERAL4=null;

        try {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:357:2: ( ^( TEMPLATE (id= ID | ind= ACTION ) ^( ARGLIST ( ^( ARG arg= ID a= ACTION ) )* ) ( DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL )? ) )
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:357:4: ^( TEMPLATE (id= ID | ind= ACTION ) ^( ARGLIST ( ^( ARG arg= ID a= ACTION ) )* ) ( DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL )? )
            {
            match(input,TEMPLATE,FOLLOW_TEMPLATE_in_rewrite_template1193); 

            match(input, Token.DOWN, null); 
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:358:4: (id= ID | ind= ACTION )
            int alt48=2;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt48=1;
                }
                break;
            case ACTION:
                {
                alt48=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:358:6: id= ID
                    {
                    id=(GrammarAST)match(input,ID,FOLLOW_ID_in_rewrite_template1202); 
                    out(" "+(id!=null?id.getText():null));

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:359:6: ind= ACTION
                    {
                    ind=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_rewrite_template1213); 
                    out(" ({"+(ind!=null?ind.getText():null)+"})");

                    }
                    break;

            }

            match(input,ARGLIST,FOLLOW_ARGLIST_in_rewrite_template1227); 

            out("(");

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:363:5: ( ^( ARG arg= ID a= ACTION ) )*
                loop49:
                do {
                    int alt49=2;
                    switch ( input.LA(1) ) {
                    case ARG:
                        {
                        alt49=1;
                        }
                        break;

                    }

                    switch (alt49) {
                	case 1 :
                	    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:363:7: ^( ARG arg= ID a= ACTION )
                	    {
                	    match(input,ARG,FOLLOW_ARG_in_rewrite_template1243); 

                	    match(input, Token.DOWN, null); 
                	    arg=(GrammarAST)match(input,ID,FOLLOW_ID_in_rewrite_template1247); 
                	    out((arg!=null?arg.getText():null)+"=");
                	    a=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_rewrite_template1259); 
                	    out((a!=null?a.getText():null));

                	    match(input, Token.UP, null); 

                	    }
                	    break;

                	default :
                	    break loop49;
                    }
                } while (true);

                out(")");

                match(input, Token.UP, null); 
            }
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:369:4: ( DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL )?
            int alt50=3;
            switch ( input.LA(1) ) {
                case DOUBLE_QUOTE_STRING_LITERAL:
                    {
                    alt50=1;
                    }
                    break;
                case DOUBLE_ANGLE_STRING_LITERAL:
                    {
                    alt50=2;
                    }
                    break;
            }

            switch (alt50) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:369:6: DOUBLE_QUOTE_STRING_LITERAL
                    {
                    DOUBLE_QUOTE_STRING_LITERAL3=(GrammarAST)match(input,DOUBLE_QUOTE_STRING_LITERAL,FOLLOW_DOUBLE_QUOTE_STRING_LITERAL_in_rewrite_template1295); 
                    out(" "+(DOUBLE_QUOTE_STRING_LITERAL3!=null?DOUBLE_QUOTE_STRING_LITERAL3.getText():null));

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:370:6: DOUBLE_ANGLE_STRING_LITERAL
                    {
                    DOUBLE_ANGLE_STRING_LITERAL4=(GrammarAST)match(input,DOUBLE_ANGLE_STRING_LITERAL,FOLLOW_DOUBLE_ANGLE_STRING_LITERAL_in_rewrite_template1304); 
                    out(" "+(DOUBLE_ANGLE_STRING_LITERAL4!=null?DOUBLE_ANGLE_STRING_LITERAL4.getText():null));

                    }
                    break;

            }


            match(input, Token.UP, null); 

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


    // $ANTLR start "element"
    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:375:1: element : ( ^( ROOT element ) | ^( BANG element ) | atom | ^( NOT element ) | ^( RANGE atom atom ) | ^( CHAR_RANGE atom atom ) | ^( ASSIGN id= ID element ) | ^( PLUS_ASSIGN id2= ID element ) | ebnf | tree_ | ^( SYNPRED block[true] ) | a= ACTION | a2= FORCED_ACTION | pred= SEMPRED | spred= SYN_SEMPRED | ^( BACKTRACK_SEMPRED ( . )* ) | gpred= GATED_SEMPRED | EPSILON );
    public final void element() throws RecognitionException {
        GrammarAST id=null;
        GrammarAST id2=null;
        GrammarAST a=null;
        GrammarAST a2=null;
        GrammarAST pred=null;
        GrammarAST spred=null;
        GrammarAST gpred=null;

        try {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:376:2: ( ^( ROOT element ) | ^( BANG element ) | atom | ^( NOT element ) | ^( RANGE atom atom ) | ^( CHAR_RANGE atom atom ) | ^( ASSIGN id= ID element ) | ^( PLUS_ASSIGN id2= ID element ) | ebnf | tree_ | ^( SYNPRED block[true] ) | a= ACTION | a2= FORCED_ACTION | pred= SEMPRED | spred= SYN_SEMPRED | ^( BACKTRACK_SEMPRED ( . )* ) | gpred= GATED_SEMPRED | EPSILON )
            int alt52=18;
            switch ( input.LA(1) ) {
            case ROOT:
                {
                alt52=1;
                }
                break;
            case BANG:
                {
                alt52=2;
                }
                break;
            case LABEL:
            case DOT:
            case STRING_LITERAL:
            case CHAR_LITERAL:
            case TOKEN_REF:
            case WILDCARD:
            case RULE_REF:
                {
                alt52=3;
                }
                break;
            case NOT:
                {
                alt52=4;
                }
                break;
            case RANGE:
                {
                alt52=5;
                }
                break;
            case CHAR_RANGE:
                {
                alt52=6;
                }
                break;
            case ASSIGN:
                {
                alt52=7;
                }
                break;
            case PLUS_ASSIGN:
                {
                alt52=8;
                }
                break;
            case BLOCK:
            case OPTIONAL:
            case CLOSURE:
            case POSITIVE_CLOSURE:
                {
                alt52=9;
                }
                break;
            case TREE_BEGIN:
                {
                alt52=10;
                }
                break;
            case SYNPRED:
                {
                alt52=11;
                }
                break;
            case ACTION:
                {
                alt52=12;
                }
                break;
            case FORCED_ACTION:
                {
                alt52=13;
                }
                break;
            case SEMPRED:
                {
                alt52=14;
                }
                break;
            case SYN_SEMPRED:
                {
                alt52=15;
                }
                break;
            case BACKTRACK_SEMPRED:
                {
                alt52=16;
                }
                break;
            case GATED_SEMPRED:
                {
                alt52=17;
                }
                break;
            case EPSILON:
                {
                alt52=18;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:376:4: ^( ROOT element )
                    {
                    match(input,ROOT,FOLLOW_ROOT_in_element1328); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_element_in_element1330);
                    element();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    out("^");

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:377:4: ^( BANG element )
                    {
                    match(input,BANG,FOLLOW_BANG_in_element1339); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_element_in_element1341);
                    element();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    out("!");

                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:378:4: atom
                    {
                    pushFollow(FOLLOW_atom_in_element1349);
                    atom();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:379:4: ^( NOT element )
                    {
                    match(input,NOT,FOLLOW_NOT_in_element1355); 

                    out("~");

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_element_in_element1359);
                    element();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 5 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:380:4: ^( RANGE atom atom )
                    {
                    match(input,RANGE,FOLLOW_RANGE_in_element1366); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_atom_in_element1368);
                    atom();

                    state._fsp--;

                    out("..");
                    pushFollow(FOLLOW_atom_in_element1372);
                    atom();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 6 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:381:4: ^( CHAR_RANGE atom atom )
                    {
                    match(input,CHAR_RANGE,FOLLOW_CHAR_RANGE_in_element1379); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_atom_in_element1381);
                    atom();

                    state._fsp--;

                    out("..");
                    pushFollow(FOLLOW_atom_in_element1385);
                    atom();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 7 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:382:4: ^( ASSIGN id= ID element )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_element1392); 

                    match(input, Token.DOWN, null); 
                    id=(GrammarAST)match(input,ID,FOLLOW_ID_in_element1396); 
                    out((id!=null?id.getText():null)+"=");
                    pushFollow(FOLLOW_element_in_element1400);
                    element();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 8 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:383:4: ^( PLUS_ASSIGN id2= ID element )
                    {
                    match(input,PLUS_ASSIGN,FOLLOW_PLUS_ASSIGN_in_element1407); 

                    match(input, Token.DOWN, null); 
                    id2=(GrammarAST)match(input,ID,FOLLOW_ID_in_element1411); 
                    out((id2!=null?id2.getText():null)+"+=");
                    pushFollow(FOLLOW_element_in_element1415);
                    element();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 9 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:384:4: ebnf
                    {
                    pushFollow(FOLLOW_ebnf_in_element1421);
                    ebnf();

                    state._fsp--;


                    }
                    break;
                case 10 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:385:4: tree_
                    {
                    pushFollow(FOLLOW_tree__in_element1426);
                    tree_();

                    state._fsp--;


                    }
                    break;
                case 11 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:386:4: ^( SYNPRED block[true] )
                    {
                    match(input,SYNPRED,FOLLOW_SYNPRED_in_element1433); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_block_in_element1435);
                    block(true);

                    state._fsp--;


                    match(input, Token.UP, null); 
                    out("=>");

                    }
                    break;
                case 12 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:387:4: a= ACTION
                    {
                    a=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_element1447); 
                    if ( showActions ) {out("{"); out((a!=null?a.getText():null)); out("}");}

                    }
                    break;
                case 13 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:388:4: a2= FORCED_ACTION
                    {
                    a2=(GrammarAST)match(input,FORCED_ACTION,FOLLOW_FORCED_ACTION_in_element1457); 
                    if ( showActions ) {out("{{"); out((a2!=null?a2.getText():null)); out("}}");}

                    }
                    break;
                case 14 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:389:4: pred= SEMPRED
                    {
                    pred=(GrammarAST)match(input,SEMPRED,FOLLOW_SEMPRED_in_element1467); 

                    			if ( showActions )
                    			{
                    				out("{");
                    				out((pred!=null?pred.getText():null));
                    				out("}?");
                    			}
                    			else
                    			{
                    				out("{...}?");
                    			}
                    		

                    }
                    break;
                case 15 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:402:4: spred= SYN_SEMPRED
                    {
                    spred=(GrammarAST)match(input,SYN_SEMPRED,FOLLOW_SYN_SEMPRED_in_element1478); 

                    			String name = (spred!=null?spred.getText():null);
                    			GrammarAST predAST=grammar.getSyntacticPredicate(name);
                    			block(predAST, true);
                    			out("=>");
                    		

                    }
                    break;
                case 16 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:409:4: ^( BACKTRACK_SEMPRED ( . )* )
                    {
                    match(input,BACKTRACK_SEMPRED,FOLLOW_BACKTRACK_SEMPRED_in_element1488); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:409:24: ( . )*
                        loop51:
                        do {
                            int alt51=2;
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
                                alt51=1;
                                }
                                break;
                            case UP:
                                {
                                alt51=2;
                                }
                                break;

                            }

                            switch (alt51) {
                        	case 1 :
                        	    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:409:24: .
                        	    {
                        	    matchAny(input); 

                        	    }
                        	    break;

                        	default :
                        	    break loop51;
                            }
                        } while (true);


                        match(input, Token.UP, null); 
                    }

                    }
                    break;
                case 17 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:410:4: gpred= GATED_SEMPRED
                    {
                    gpred=(GrammarAST)match(input,GATED_SEMPRED,FOLLOW_GATED_SEMPRED_in_element1500); 

                    		if ( showActions ) {out("{"); out((gpred!=null?gpred.getText():null)); out("}? =>");}
                    		else {out("{...}? =>");}
                    		

                    }
                    break;
                case 18 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:415:4: EPSILON
                    {
                    match(input,EPSILON,FOLLOW_EPSILON_in_element1509); 

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
    // $ANTLR end "element"


    // $ANTLR start "ebnf"
    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:418:1: ebnf : ( block[true] | ^( OPTIONAL block[true] ) | ^( CLOSURE block[true] ) | ^( POSITIVE_CLOSURE block[true] ) );
    public final void ebnf() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:419:2: ( block[true] | ^( OPTIONAL block[true] ) | ^( CLOSURE block[true] ) | ^( POSITIVE_CLOSURE block[true] ) )
            int alt53=4;
            switch ( input.LA(1) ) {
            case BLOCK:
                {
                alt53=1;
                }
                break;
            case OPTIONAL:
                {
                alt53=2;
                }
                break;
            case CLOSURE:
                {
                alt53=3;
                }
                break;
            case POSITIVE_CLOSURE:
                {
                alt53=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:419:4: block[true]
                    {
                    pushFollow(FOLLOW_block_in_ebnf1520);
                    block(true);

                    state._fsp--;

                    out(" ");

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:420:4: ^( OPTIONAL block[true] )
                    {
                    match(input,OPTIONAL,FOLLOW_OPTIONAL_in_ebnf1530); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_block_in_ebnf1532);
                    block(true);

                    state._fsp--;


                    match(input, Token.UP, null); 
                    out("? ");

                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:421:4: ^( CLOSURE block[true] )
                    {
                    match(input,CLOSURE,FOLLOW_CLOSURE_in_ebnf1544); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_block_in_ebnf1546);
                    block(true);

                    state._fsp--;


                    match(input, Token.UP, null); 
                    out("* ");

                    }
                    break;
                case 4 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:422:4: ^( POSITIVE_CLOSURE block[true] )
                    {
                    match(input,POSITIVE_CLOSURE,FOLLOW_POSITIVE_CLOSURE_in_ebnf1559); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_block_in_ebnf1561);
                    block(true);

                    state._fsp--;


                    match(input, Token.UP, null); 
                    out("+ ");

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


    // $ANTLR start "tree_"
    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:425:1: tree_ : ^( TREE_BEGIN element ( element )* ) ;
    public final void tree_() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:426:2: ( ^( TREE_BEGIN element ( element )* ) )
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:426:4: ^( TREE_BEGIN element ( element )* )
            {
            match(input,TREE_BEGIN,FOLLOW_TREE_BEGIN_in_tree_1578); 

            out(" ^(");

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_element_in_tree_1582);
            element();

            state._fsp--;

            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:426:39: ( element )*
            loop54:
            do {
                int alt54=2;
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
                case LABEL:
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
                    alt54=1;
                    }
                    break;

                }

                switch (alt54) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:426:40: element
            	    {
            	    pushFollow(FOLLOW_element_in_tree_1585);
            	    element();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);

            out(") ");

            match(input, Token.UP, null); 

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

    public static class atom_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "atom"
    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:429:1: atom : ( ( ^( RULE_REF (rarg= ARG_ACTION )? ( ast_suffix )? ) | ^( TOKEN_REF (targ= ARG_ACTION )? ( ast_suffix )? ) | ^( CHAR_LITERAL ( ast_suffix )? ) | ^( STRING_LITERAL ( ast_suffix )? ) | ^( WILDCARD ( ast_suffix )? ) ) | LABEL | ^( DOT ID atom ) );
    public final ANTLRTreePrinter.atom_return atom() throws RecognitionException {
        ANTLRTreePrinter.atom_return retval = new ANTLRTreePrinter.atom_return();
        retval.start = input.LT(1);

        GrammarAST rarg=null;
        GrammarAST targ=null;
        GrammarAST LABEL5=null;
        GrammarAST ID6=null;

        out(" ");
        try {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:432:2: ( ( ^( RULE_REF (rarg= ARG_ACTION )? ( ast_suffix )? ) | ^( TOKEN_REF (targ= ARG_ACTION )? ( ast_suffix )? ) | ^( CHAR_LITERAL ( ast_suffix )? ) | ^( STRING_LITERAL ( ast_suffix )? ) | ^( WILDCARD ( ast_suffix )? ) ) | LABEL | ^( DOT ID atom ) )
            int alt63=3;
            switch ( input.LA(1) ) {
            case STRING_LITERAL:
            case CHAR_LITERAL:
            case TOKEN_REF:
            case WILDCARD:
            case RULE_REF:
                {
                alt63=1;
                }
                break;
            case LABEL:
                {
                alt63=2;
                }
                break;
            case DOT:
                {
                alt63=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }

            switch (alt63) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:432:4: ( ^( RULE_REF (rarg= ARG_ACTION )? ( ast_suffix )? ) | ^( TOKEN_REF (targ= ARG_ACTION )? ( ast_suffix )? ) | ^( CHAR_LITERAL ( ast_suffix )? ) | ^( STRING_LITERAL ( ast_suffix )? ) | ^( WILDCARD ( ast_suffix )? ) )
                    {
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:432:4: ( ^( RULE_REF (rarg= ARG_ACTION )? ( ast_suffix )? ) | ^( TOKEN_REF (targ= ARG_ACTION )? ( ast_suffix )? ) | ^( CHAR_LITERAL ( ast_suffix )? ) | ^( STRING_LITERAL ( ast_suffix )? ) | ^( WILDCARD ( ast_suffix )? ) )
                    int alt62=5;
                    switch ( input.LA(1) ) {
                    case RULE_REF:
                        {
                        alt62=1;
                        }
                        break;
                    case TOKEN_REF:
                        {
                        alt62=2;
                        }
                        break;
                    case CHAR_LITERAL:
                        {
                        alt62=3;
                        }
                        break;
                    case STRING_LITERAL:
                        {
                        alt62=4;
                        }
                        break;
                    case WILDCARD:
                        {
                        alt62=5;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 62, 0, input);

                        throw nvae;
                    }

                    switch (alt62) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:432:6: ^( RULE_REF (rarg= ARG_ACTION )? ( ast_suffix )? )
                            {
                            match(input,RULE_REF,FOLLOW_RULE_REF_in_atom1611); 

                            out(((GrammarAST)retval.start).toString());

                            if ( input.LA(1)==Token.DOWN ) {
                                match(input, Token.DOWN, null); 
                                // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:433:5: (rarg= ARG_ACTION )?
                                int alt55=2;
                                switch ( input.LA(1) ) {
                                    case ARG_ACTION:
                                        {
                                        alt55=1;
                                        }
                                        break;
                                }

                                switch (alt55) {
                                    case 1 :
                                        // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:433:6: rarg= ARG_ACTION
                                        {
                                        rarg=(GrammarAST)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_atom1623); 
                                        out("["+rarg.toString()+"]");

                                        }
                                        break;

                                }

                                // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:434:5: ( ast_suffix )?
                                int alt56=2;
                                switch ( input.LA(1) ) {
                                    case BANG:
                                    case ROOT:
                                        {
                                        alt56=1;
                                        }
                                        break;
                                }

                                switch (alt56) {
                                    case 1 :
                                        // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:434:6: ast_suffix
                                        {
                                        pushFollow(FOLLOW_ast_suffix_in_atom1634);
                                        ast_suffix();

                                        state._fsp--;


                                        }
                                        break;

                                }


                                match(input, Token.UP, null); 
                            }

                            }
                            break;
                        case 2 :
                            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:436:5: ^( TOKEN_REF (targ= ARG_ACTION )? ( ast_suffix )? )
                            {
                            match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_atom1649); 

                            out(((GrammarAST)retval.start).toString());

                            if ( input.LA(1)==Token.DOWN ) {
                                match(input, Token.DOWN, null); 
                                // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:437:5: (targ= ARG_ACTION )?
                                int alt57=2;
                                switch ( input.LA(1) ) {
                                    case ARG_ACTION:
                                        {
                                        alt57=1;
                                        }
                                        break;
                                }

                                switch (alt57) {
                                    case 1 :
                                        // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:437:6: targ= ARG_ACTION
                                        {
                                        targ=(GrammarAST)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_atom1661); 
                                        out("["+targ.toString()+"]");

                                        }
                                        break;

                                }

                                // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:438:5: ( ast_suffix )?
                                int alt58=2;
                                switch ( input.LA(1) ) {
                                    case BANG:
                                    case ROOT:
                                        {
                                        alt58=1;
                                        }
                                        break;
                                }

                                switch (alt58) {
                                    case 1 :
                                        // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:438:6: ast_suffix
                                        {
                                        pushFollow(FOLLOW_ast_suffix_in_atom1673);
                                        ast_suffix();

                                        state._fsp--;


                                        }
                                        break;

                                }


                                match(input, Token.UP, null); 
                            }

                            }
                            break;
                        case 3 :
                            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:440:5: ^( CHAR_LITERAL ( ast_suffix )? )
                            {
                            match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_atom1688); 

                            out(((GrammarAST)retval.start).toString());

                            if ( input.LA(1)==Token.DOWN ) {
                                match(input, Token.DOWN, null); 
                                // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:441:5: ( ast_suffix )?
                                int alt59=2;
                                switch ( input.LA(1) ) {
                                    case BANG:
                                    case ROOT:
                                        {
                                        alt59=1;
                                        }
                                        break;
                                }

                                switch (alt59) {
                                    case 1 :
                                        // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:441:6: ast_suffix
                                        {
                                        pushFollow(FOLLOW_ast_suffix_in_atom1697);
                                        ast_suffix();

                                        state._fsp--;


                                        }
                                        break;

                                }


                                match(input, Token.UP, null); 
                            }

                            }
                            break;
                        case 4 :
                            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:443:5: ^( STRING_LITERAL ( ast_suffix )? )
                            {
                            match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_atom1712); 

                            out(((GrammarAST)retval.start).toString());

                            if ( input.LA(1)==Token.DOWN ) {
                                match(input, Token.DOWN, null); 
                                // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:444:5: ( ast_suffix )?
                                int alt60=2;
                                switch ( input.LA(1) ) {
                                    case BANG:
                                    case ROOT:
                                        {
                                        alt60=1;
                                        }
                                        break;
                                }

                                switch (alt60) {
                                    case 1 :
                                        // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:444:6: ast_suffix
                                        {
                                        pushFollow(FOLLOW_ast_suffix_in_atom1721);
                                        ast_suffix();

                                        state._fsp--;


                                        }
                                        break;

                                }


                                match(input, Token.UP, null); 
                            }

                            }
                            break;
                        case 5 :
                            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:446:5: ^( WILDCARD ( ast_suffix )? )
                            {
                            match(input,WILDCARD,FOLLOW_WILDCARD_in_atom1736); 

                            out(((GrammarAST)retval.start).toString());

                            if ( input.LA(1)==Token.DOWN ) {
                                match(input, Token.DOWN, null); 
                                // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:447:5: ( ast_suffix )?
                                int alt61=2;
                                switch ( input.LA(1) ) {
                                    case BANG:
                                    case ROOT:
                                        {
                                        alt61=1;
                                        }
                                        break;
                                }

                                switch (alt61) {
                                    case 1 :
                                        // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:447:6: ast_suffix
                                        {
                                        pushFollow(FOLLOW_ast_suffix_in_atom1746);
                                        ast_suffix();

                                        state._fsp--;


                                        }
                                        break;

                                }


                                match(input, Token.UP, null); 
                            }

                            }
                            break;

                    }

                    out(" ");

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:451:4: LABEL
                    {
                    LABEL5=(GrammarAST)match(input,LABEL,FOLLOW_LABEL_in_atom1766); 
                    out(" $"+(LABEL5!=null?LABEL5.getText():null));

                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:452:4: ^( DOT ID atom )
                    {
                    match(input,DOT,FOLLOW_DOT_in_atom1775); 

                    match(input, Token.DOWN, null); 
                    ID6=(GrammarAST)match(input,ID,FOLLOW_ID_in_atom1777); 
                    out((ID6!=null?ID6.getText():null)+".");
                    pushFollow(FOLLOW_atom_in_atom1781);
                    atom();

                    state._fsp--;


                    match(input, Token.UP, null); 

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
    // $ANTLR end "atom"


    // $ANTLR start "ast_suffix"
    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:455:1: ast_suffix : ( ROOT | BANG );
    public final void ast_suffix() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:456:2: ( ROOT | BANG )
            int alt64=2;
            switch ( input.LA(1) ) {
            case ROOT:
                {
                alt64=1;
                }
                break;
            case BANG:
                {
                alt64=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:456:4: ROOT
                    {
                    match(input,ROOT,FOLLOW_ROOT_in_ast_suffix1794); 
                    out("^");

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLRTreePrinter.g:457:4: BANG
                    {
                    match(input,BANG,FOLLOW_BANG_in_ast_suffix1801); 
                    out("!");

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
    // $ANTLR end "ast_suffix"

    // Delegated rules


 

    public static final BitSet FOLLOW_grammar__in_toString67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule_in_toString73 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alternative_in_toString79 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_element_in_toString85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_single_rewrite_in_toString91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rewrite_in_toString97 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EOR_in_toString103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEXER_GRAMMAR_in_grammar_127 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_grammarSpec_in_grammar_129 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARSER_GRAMMAR_in_grammar_139 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_grammarSpec_in_grammar_141 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TREE_GRAMMAR_in_grammar_151 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_grammarSpec_in_grammar_153 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COMBINED_GRAMMAR_in_grammar_163 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_grammarSpec_in_grammar_165 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SCOPE_in_attrScope181 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_attrScope183 = new BitSet(new long[]{0x0024000000000000L});
    public static final BitSet FOLLOW_ruleAction_in_attrScope185 = new BitSet(new long[]{0x0024000000000000L});
    public static final BitSet FOLLOW_ACTION_in_attrScope188 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_grammarSpec204 = new BitSet(new long[]{0x80A80C0000018000L});
    public static final BitSet FOLLOW_DOC_COMMENT_in_grammarSpec213 = new BitSet(new long[]{0x80A80C0000018000L});
    public static final BitSet FOLLOW_optionsSpec_in_grammarSpec223 = new BitSet(new long[]{0x80A80C0000018000L});
    public static final BitSet FOLLOW_delegateGrammars_in_grammarSpec232 = new BitSet(new long[]{0x80A80C0000018000L});
    public static final BitSet FOLLOW_tokensSpec_in_grammarSpec239 = new BitSet(new long[]{0x80A80C0000018000L});
    public static final BitSet FOLLOW_attrScope_in_grammarSpec246 = new BitSet(new long[]{0x80A80C0000018000L});
    public static final BitSet FOLLOW_actions_in_grammarSpec253 = new BitSet(new long[]{0x80A80C0000018000L});
    public static final BitSet FOLLOW_rules_in_grammarSpec259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_action_in_actions272 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_AMPERSAND_in_action293 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_action297 = new BitSet(new long[]{0x0004000040000000L});
    public static final BitSet FOLLOW_ID_in_action306 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_ACTION_in_action310 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ACTION_in_action325 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OPTIONS_in_optionsSpec357 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_option_in_optionsSpec365 = new BitSet(new long[]{0x0200000000000008L});
    public static final BitSet FOLLOW_ASSIGN_in_option391 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_option395 = new BitSet(new long[]{0x1C00000040000000L});
    public static final BitSet FOLLOW_optionValue_in_option399 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_optionValue414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_optionValue434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_optionValue443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_optionValue454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_delegateGrammars484 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ASSIGN_in_delegateGrammars489 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_delegateGrammars491 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ID_in_delegateGrammars493 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_delegateGrammars498 = new BitSet(new long[]{0x0200000040000008L});
    public static final BitSet FOLLOW_TOKENS_in_tokensSpec515 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tokenSpec_in_tokensSpec517 = new BitSet(new long[]{0x0200000000000008L,0x0000000000000001L});
    public static final BitSet FOLLOW_TOKEN_REF_in_tokenSpec530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_tokenSpec537 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TOKEN_REF_in_tokenSpec539 = new BitSet(new long[]{0x0C00000000000000L});
    public static final BitSet FOLLOW_set_in_tokenSpec541 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rule_in_rules560 = new BitSet(new long[]{0x80A80C0000018002L});
    public static final BitSet FOLLOW_precRule_in_rules564 = new BitSet(new long[]{0x80A80C0000018002L});
    public static final BitSet FOLLOW_RULE_in_rule580 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_rule584 = new BitSet(new long[]{0x0000800080000E00L});
    public static final BitSet FOLLOW_modifier_in_rule590 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ARG_in_rule603 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_rule608 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RET_in_rule621 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_rule626 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_throwsSpec_in_rule639 = new BitSet(new long[]{0x00A0040000040000L});
    public static final BitSet FOLLOW_optionsSpec_in_rule647 = new BitSet(new long[]{0x00A0040000040000L});
    public static final BitSet FOLLOW_ruleScopeSpec_in_rule655 = new BitSet(new long[]{0x00A0040000040000L});
    public static final BitSet FOLLOW_ruleAction_in_rule663 = new BitSet(new long[]{0x00A0040000040000L});
    public static final BitSet FOLLOW_block_in_rule682 = new BitSet(new long[]{0x00000000080000C0L});
    public static final BitSet FOLLOW_exceptionGroup_in_rule689 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_EOR_in_rule696 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PREC_RULE_in_precRule715 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_precRule719 = new BitSet(new long[]{0x0000800080000E00L});
    public static final BitSet FOLLOW_modifier_in_precRule725 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ARG_in_precRule738 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_precRule743 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RET_in_precRule756 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_precRule761 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_throwsSpec_in_precRule774 = new BitSet(new long[]{0x00A0040000040000L});
    public static final BitSet FOLLOW_optionsSpec_in_precRule782 = new BitSet(new long[]{0x00A0040000040000L});
    public static final BitSet FOLLOW_ruleScopeSpec_in_precRule790 = new BitSet(new long[]{0x00A0040000040000L});
    public static final BitSet FOLLOW_ruleAction_in_precRule798 = new BitSet(new long[]{0x00A0040000040000L});
    public static final BitSet FOLLOW_block_in_precRule817 = new BitSet(new long[]{0x00000000080000C0L});
    public static final BitSet FOLLOW_exceptionGroup_in_precRule824 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_EOR_in_precRule831 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AMPERSAND_in_ruleAction849 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_ruleAction853 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_ACTION_in_ruleAction857 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_modifier0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THROWS_in_throwsSpec906 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_throwsSpec908 = new BitSet(new long[]{0x0000000040000008L});
    public static final BitSet FOLLOW_SCOPE_in_ruleScopeSpec923 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ruleAction_in_ruleScopeSpec925 = new BitSet(new long[]{0x0024000040000008L});
    public static final BitSet FOLLOW_ACTION_in_ruleScopeSpec929 = new BitSet(new long[]{0x0000000040000008L});
    public static final BitSet FOLLOW_ID_in_ruleScopeSpec935 = new BitSet(new long[]{0x0000000040000008L});
    public static final BitSet FOLLOW_BLOCK_in_block959 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_optionsSpec_in_block970 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_alternative_in_block980 = new BitSet(new long[]{0x0002000014000000L});
    public static final BitSet FOLLOW_rewrite_in_block982 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_alternative_in_block988 = new BitSet(new long[]{0x0002000014000000L});
    public static final BitSet FOLLOW_rewrite_in_block990 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_EOB_in_block998 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ALT_in_alternative1020 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_alternative1022 = new BitSet(new long[]{0x0EA5758023FC0000L,0x0000000000003EC3L});
    public static final BitSet FOLLOW_EOA_in_alternative1025 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_exceptionHandler_in_exceptionGroup1040 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_finallyClause_in_exceptionGroup1046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_finallyClause_in_exceptionGroup1053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CATCH_in_exceptionHandler1065 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_exceptionHandler1067 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_ACTION_in_exceptionHandler1069 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FINALLY_in_finallyClause1082 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ACTION_in_finallyClause1084 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REWRITES_in_rewrite1097 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_single_rewrite_in_rewrite1099 = new BitSet(new long[]{0x0000000000000008L,0x0000000000100000L});
    public static final BitSet FOLLOW_REWRITES_in_rewrite1106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REWRITE_in_single_rewrite1122 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SEMPRED_in_single_rewrite1131 = new BitSet(new long[]{0x0004020004000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_alternative_in_single_rewrite1146 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rewrite_template_in_single_rewrite1153 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ETC_in_single_rewrite1160 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ACTION_in_single_rewrite1169 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TEMPLATE_in_rewrite_template1193 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_rewrite_template1202 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_ACTION_in_rewrite_template1213 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_ARGLIST_in_rewrite_template1227 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_in_rewrite_template1243 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_rewrite_template1247 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_ACTION_in_rewrite_template1259 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOUBLE_QUOTE_STRING_LITERAL_in_rewrite_template1295 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOUBLE_ANGLE_STRING_LITERAL_in_rewrite_template1304 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ROOT_in_element1328 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_element1330 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BANG_in_element1339 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_element1341 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_atom_in_element1349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_element1355 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_element1359 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RANGE_in_element1366 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_atom_in_element1368 = new BitSet(new long[]{0x0C01010000000000L,0x0000000000000C01L});
    public static final BitSet FOLLOW_atom_in_element1372 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CHAR_RANGE_in_element1379 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_atom_in_element1381 = new BitSet(new long[]{0x0C01010000000000L,0x0000000000000C01L});
    public static final BitSet FOLLOW_atom_in_element1385 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSIGN_in_element1392 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_element1396 = new BitSet(new long[]{0x0EA5758023FC0000L,0x0000000000003EC3L});
    public static final BitSet FOLLOW_element_in_element1400 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_ASSIGN_in_element1407 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_element1411 = new BitSet(new long[]{0x0EA5758023FC0000L,0x0000000000003EC3L});
    public static final BitSet FOLLOW_element_in_element1415 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ebnf_in_element1421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tree__in_element1426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYNPRED_in_element1433 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_element1435 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ACTION_in_element1447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FORCED_ACTION_in_element1457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMPRED_in_element1467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYN_SEMPRED_in_element1478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BACKTRACK_SEMPRED_in_element1488 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_GATED_SEMPRED_in_element1500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EPSILON_in_element1509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_ebnf1520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPTIONAL_in_ebnf1530 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_ebnf1532 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CLOSURE_in_ebnf1544 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_ebnf1546 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POSITIVE_CLOSURE_in_ebnf1559 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_ebnf1561 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TREE_BEGIN_in_tree_1578 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_tree_1582 = new BitSet(new long[]{0x0EA5758023FC0008L,0x0000000000003EC3L});
    public static final BitSet FOLLOW_element_in_tree_1585 = new BitSet(new long[]{0x0EA5758023FC0008L,0x0000000000003EC3L});
    public static final BitSet FOLLOW_RULE_REF_in_atom1611 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_atom1623 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000202L});
    public static final BitSet FOLLOW_ast_suffix_in_atom1634 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TOKEN_REF_in_atom1649 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_atom1661 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000202L});
    public static final BitSet FOLLOW_ast_suffix_in_atom1673 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_atom1688 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ast_suffix_in_atom1697 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_atom1712 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ast_suffix_in_atom1721 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WILDCARD_in_atom1736 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ast_suffix_in_atom1746 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LABEL_in_atom1766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_atom1775 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_atom1777 = new BitSet(new long[]{0x0C01010000000000L,0x0000000000000C01L});
    public static final BitSet FOLLOW_atom_in_atom1781 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ROOT_in_ast_suffix1794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BANG_in_ast_suffix1801 = new BitSet(new long[]{0x0000000000000002L});

}