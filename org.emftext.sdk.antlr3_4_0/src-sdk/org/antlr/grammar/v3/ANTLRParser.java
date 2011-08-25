// $ANTLR 3.3 Nov 30, 2010 12:46:29 org\\antlr\\grammar\\v3\\ANTLR.g 2011-08-25 14:59:43

package org.antlr.grammar.v3;
import java.util.HashMap;
import java.util.Map;

import org.antlr.misc.IntSet;
import org.antlr.runtime3_4_0.BaseRecognizer;
import org.antlr.runtime3_4_0.BitSet;
import org.antlr.runtime3_4_0.CommonToken;
import org.antlr.runtime3_4_0.DFA;
import org.antlr.runtime3_4_0.EarlyExitException;
import org.antlr.runtime3_4_0.FailedPredicateException;
import org.antlr.runtime3_4_0.IntStream;
import org.antlr.runtime3_4_0.MismatchedSetException;
import org.antlr.runtime3_4_0.MismatchedTokenException;
import org.antlr.runtime3_4_0.MissingTokenException;
import org.antlr.runtime3_4_0.NoViableAltException;
import org.antlr.runtime3_4_0.Parser;
import org.antlr.runtime3_4_0.ParserRuleReturnScope;
import org.antlr.runtime3_4_0.RecognitionException;
import org.antlr.runtime3_4_0.RecognizerSharedState;
import org.antlr.runtime3_4_0.Token;
import org.antlr.runtime3_4_0.TokenStream;
import org.antlr.runtime3_4_0.UnwantedTokenException;
import org.antlr.runtime3_4_0.tree.CommonTreeAdaptor;
import org.antlr.runtime3_4_0.tree.RewriteEarlyExitException;
import org.antlr.runtime3_4_0.tree.RewriteRuleSubtreeStream;
import org.antlr.runtime3_4_0.tree.RewriteRuleTokenStream;
import org.antlr.runtime3_4_0.tree.Tree;
import org.antlr.runtime3_4_0.tree.TreeAdaptor;
import org.antlr.runtime3_4_0.tree.TreeNodeStream;
import org.antlr.tool.ErrorManager;
import org.antlr.tool.Grammar;
import org.antlr.tool.GrammarAST;
import org.antlr.tool.Rule;

/** Read in an ANTLR grammar and build an AST.  Try not to do
 *  any actions, just build the tree.
 *
 *  The phases are:
 *
 *		antlr.g (this file)
 *		assign.types.g
 *		define.g
 *		buildnfa.g
 *		antlr.print.g (optional)
 *		codegen.g
 *
 *  Terence Parr
 *  University of San Francisco
 *  2005
 */
public class ANTLRParser extends Parser {
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


        public ANTLRParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public ANTLRParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return ANTLRParser.tokenNames; }
    public String getGrammarFileName() { return "org\\antlr\\grammar\\v3\\ANTLR.g"; }


    protected String currentRuleName = null;
    protected GrammarAST currentBlockAST = null;
    protected boolean atTreeRoot; // are we matching a tree root in tree grammar?

    public static ANTLRParser createParser(TokenStream input) {
        ANTLRParser parser = new ANTLRParser(input);
        parser.adaptor = new grammar_Adaptor(parser);
        return parser;
    }

    private static class GrammarASTErrorNode extends GrammarAST {
        public IntStream input;
        public Token start;
        public Token stop;
        public RecognitionException trappedException;

        public GrammarASTErrorNode(TokenStream input, Token start, Token stop, RecognitionException e) {
            super(stop);
            //Console.Out.WriteLine( "start: " + start + ", stop: " + stop );
            if ( stop == null ||
                 ( stop.getTokenIndex() < start.getTokenIndex() &&
                  stop.getType() != Token.EOF) ) {
                // sometimes resync does not consume a token (when LT(1) is
                // in follow set.  So, stop will be 1 to left to start. adjust.
                // Also handle case where start is the first token and no token
                // is consumed during recovery; LT(-1) will return null.
                stop = start;
            }
            this.input = input;
            this.start = start;
            this.stop = stop;
            this.trappedException = e;
        }

        @Override
        public boolean isNil() { return false; }

        @Override
        public String getText()
        {
            String badText = null;
            if (start instanceof Token) {
                int i = ((Token)start).getTokenIndex();
                int j = ((Token)stop).getTokenIndex();
                if (((Token)stop).getType() == Token.EOF) {
                    j = ((TokenStream)input).size();
                }
                badText = ((TokenStream)input).toString(i, j);
            } else if (start instanceof Tree) {
                badText = ((TreeNodeStream)input).toString(start, stop);
            } else {
                // people should subclass if they alter the tree type so this
                // next one is for sure correct.
                badText = "<unknown>";
            }
            return badText;
        }

        @Override
        public void setText(String value) { }

        @Override
        public int getType() { return Token.INVALID_TOKEN_TYPE; }

        @Override
        public void setType(int value) { }

        @Override
        public String toString()
        {
            if (trappedException instanceof MissingTokenException)
            {
                return "<missing type: " +
                       ( (MissingTokenException)trappedException ).getMissingType() +
                       ">";
            } else if (trappedException instanceof UnwantedTokenException) {
                return "<extraneous: " +
                       ( (UnwantedTokenException)trappedException ).getUnexpectedToken() +
                       ", resync=" + getText() + ">";
            } else if (trappedException instanceof MismatchedTokenException) {
                return "<mismatched token: " + trappedException.token + ", resync=" + getText() + ">";
            } else if (trappedException instanceof NoViableAltException) {
                return "<unexpected: " + trappedException.token +
                       ", resync=" + getText() + ">";
            }
            return "<error: " + getText() + ">";
        }
    }

    static class grammar_Adaptor extends CommonTreeAdaptor {
        ANTLRParser _outer;

        public grammar_Adaptor(ANTLRParser outer) {
            _outer = outer;
        }

        @Override
        public Object create(Token payload) {
            GrammarAST t = new GrammarAST( payload );
            if (_outer != null)
                t.enclosingRuleName = _outer.currentRuleName;
            return t;
        }

        @Override
        public Object errorNode(TokenStream input, Token start, Token stop, RecognitionException e) {
            GrammarAST t = new GrammarASTErrorNode(input, start, stop, e);
            if (_outer != null)
                t.enclosingRuleName = _outer.currentRuleName;
            return t;
        }
    }

    private Grammar grammar;
    private int grammarType;
    private String fileName;

    public Grammar getGrammar() {
        return grammar;
    }

    public void setGrammar(Grammar value) {
        grammar = value;
    }

    public int getGrammarType() {
        return grammarType;
    }

    public void setGrammarType(int value) {
        grammarType = value;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String value) {
        fileName = value;
    }

    private final int LA(int i) { return input.LA( i ); }

    private final Token LT(int k) { return input.LT( k ); }

    /*partial void createTreeAdaptor(ref ITreeAdaptor adaptor)
    {
        adaptor = new grammar_Adaptor(this);
    }*/

    protected GrammarAST setToBlockWithSet(GrammarAST b) {
        /*
         * alt = ^(ALT["ALT"] {b} EOA["EOA"])
         * prefixWithSynpred( alt )
         * return ^(BLOCK["BLOCK"] {alt} EOB["<end-of-block>"])
         */
        GrammarAST alt = (GrammarAST)adaptor.create(ALT, "ALT");
        adaptor.addChild(alt, b);
        adaptor.addChild(alt, adaptor.create(EOA, "<end-of-alt>"));

        prefixWithSynPred(alt);

        GrammarAST block = (GrammarAST)adaptor.create(BLOCK, b.getToken(), "BLOCK");
        adaptor.addChild(block, alt);
        adaptor.addChild(alt, adaptor.create(EOB, "<end-of-block>"));

        return block;
    }

    /** Create a copy of the alt and make it into a BLOCK; all actions,
     *  labels, tree operators, rewrites are removed.
     */
    protected GrammarAST createBlockFromDupAlt(GrammarAST alt) {
        /*
         * ^(BLOCK["BLOCK"] {GrammarAST.dupTreeNoActions(alt)} EOB["<end-of-block>"])
         */
        GrammarAST nalt = GrammarAST.dupTreeNoActions(alt, null);

        GrammarAST block = (GrammarAST)adaptor.create(BLOCK, alt.getToken(), "BLOCK");
        adaptor.addChild( block, nalt );
        adaptor.addChild( block, adaptor.create( EOB, "<end-of-block>" ) );

        return block;
    }

    /** Rewrite alt to have a synpred as first element;
     *  (xxx)=>xxx
     *  but only if they didn't specify one manually.
     */
    protected void prefixWithSynPred( GrammarAST alt ) {
        // if they want backtracking and it's not a lexer rule in combined grammar
        String autoBacktrack = (String)grammar.getBlockOption( currentBlockAST, "backtrack" );
        if ( autoBacktrack == null )
        {
            autoBacktrack = (String)grammar.getOption( "backtrack" );
        }
        if ( autoBacktrack != null && autoBacktrack.equals( "true" ) &&
             !( grammarType == Grammar.COMBINED &&
             Rule.getRuleType(currentRuleName) == Grammar.LEXER) &&
             alt.getChild( 0 ).getType() != SYN_SEMPRED )
        {
            // duplicate alt and make a synpred block around that dup'd alt
            GrammarAST synpredBlockAST = createBlockFromDupAlt( alt );

            // Create a BACKTRACK_SEMPRED node as if user had typed this in
            // Effectively we replace (xxx)=>xxx with {synpredxxx}? xxx
            GrammarAST synpredAST = createSynSemPredFromBlock( synpredBlockAST,
                                                              BACKTRACK_SEMPRED );

            // insert BACKTRACK_SEMPRED as first element of alt
            //synpredAST.getLastSibling().setNextSibling( alt.getFirstChild() );
            //synpredAST.addChild( alt.getFirstChild() );
            //alt.setFirstChild( synpredAST );
            GrammarAST[] children = alt.getChildrenAsArray();
            adaptor.setChild( alt, 0, synpredAST );
            for ( int i = 0; i < children.length; i++ )
            {
                if ( i < children.length - 1 )
                    adaptor.setChild( alt, i + 1, children[i] );
                else
                    adaptor.addChild( alt, children[i] );
            }
        }
    }

    protected GrammarAST createSynSemPredFromBlock( GrammarAST synpredBlockAST, int synpredTokenType ) {
        // add grammar fragment to a list so we can make fake rules for them later.
        String predName = grammar.defineSyntacticPredicate( synpredBlockAST, currentRuleName );
        // convert (alpha)=> into {synpredN}? where N is some pred count
        // during code gen we convert to function call with templates
        String synpredinvoke = predName;
        GrammarAST p = (GrammarAST)adaptor.create( synpredTokenType, synpredinvoke );
        // track how many decisions have synpreds
        grammar.blocksWithSynPreds.add( currentBlockAST );
        return p;
    }

    public static GrammarAST createSimpleRuleAST( String name, GrammarAST block, boolean fragment ) {
        TreeAdaptor adaptor = new grammar_Adaptor(null);

        GrammarAST modifier = null;
        if ( fragment )
        {
            modifier = (GrammarAST)adaptor.create( FRAGMENT, "fragment" );
        }

        /*
         * EOBAST = block.getLastChild()
         * ^(RULE[block,"rule"] ID["name"] {modifier} ARG["ARG"] RET["RET"] SCOPE["scope"] {block} EOR[EOBAST,"<end-of-rule>"])
         */
        GrammarAST rule = (GrammarAST)adaptor.create( RULE, block.getToken(), "rule" );

        adaptor.addChild( rule, adaptor.create( ID, name ) );
        if ( modifier != null )
            adaptor.addChild( rule, modifier );
        adaptor.addChild( rule, adaptor.create( ARG, "ARG" ) );
        adaptor.addChild( rule, adaptor.create( RET, "RET" ) );
        adaptor.addChild( rule, adaptor.create( SCOPE, "scope" ) );
        adaptor.addChild( rule, block );
        adaptor.addChild( rule, adaptor.create( EOR, block.getLastChild().getToken(), "<end-of-rule>" ) );

        return rule;
    }

    @Override
    public void reportError(RecognitionException ex)
    {
        //Token token = null;
        //try
        //{
        //    token = LT( 1 );
        //}
        //catch ( TokenStreamException tse )
        //{
        //    ErrorManager.internalError( "can't get token???", tse );
        //}
        Token token = ex.token;
        ErrorManager.syntaxError(
            ErrorManager.MSG_SYNTAX_ERROR,
            grammar,
            token,
            "antlr: " + ex.toString(),
            ex );
    }

    public void cleanup( GrammarAST root )
    {
        if ( grammarType == Grammar.LEXER )
        {
            String filter = (String)grammar.getOption( "filter" );
            GrammarAST tokensRuleAST =
                grammar.addArtificialMatchTokensRule(
                    root,
                    grammar.lexerRuleNamesInCombined,
                    grammar.getDelegateNames(),
                    filter != null && filter.equals( "true" ) );
        }
    }


    public static class grammar__return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "grammar_"
    // org\\antlr\\grammar\\v3\\ANTLR.g:440:1: public grammar_[Grammar g] : ( ACTION )? (cmt= DOC_COMMENT )? gr= grammarType gid= id SEMI ( optionsSpec )? (ig= delegateGrammars )? (ts= tokensSpec )? scopes= attrScopes (a= actions )? r= rules EOF -> ^( $gr $gid ( $cmt)? ( optionsSpec )? ( $ig)? ( $ts)? ( $scopes)? ( $a)? $r) ;
    public final ANTLRParser.grammar__return grammar_(Grammar g) throws RecognitionException {
        ANTLRParser.grammar__return retval = new ANTLRParser.grammar__return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token cmt=null;
        Token ACTION1=null;
        Token SEMI2=null;
        Token EOF4=null;
        ANTLRParser.grammarType_return gr = null;

        ANTLRParser.id_return gid = null;

        ANTLRParser.delegateGrammars_return ig = null;

        ANTLRParser.tokensSpec_return ts = null;

        ANTLRParser.attrScopes_return scopes = null;

        ANTLRParser.actions_return a = null;

        ANTLRParser.rules_return r = null;

        ANTLRParser.optionsSpec_return optionsSpec3 = null;


        GrammarAST cmt_tree=null;
        GrammarAST ACTION1_tree=null;
        GrammarAST SEMI2_tree=null;
        GrammarAST EOF4_tree=null;
        RewriteRuleTokenStream stream_DOC_COMMENT=new RewriteRuleTokenStream(adaptor,"token DOC_COMMENT");
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleTokenStream stream_ACTION=new RewriteRuleTokenStream(adaptor,"token ACTION");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_tokensSpec=new RewriteRuleSubtreeStream(adaptor,"rule tokensSpec");
        RewriteRuleSubtreeStream stream_attrScopes=new RewriteRuleSubtreeStream(adaptor,"rule attrScopes");
        RewriteRuleSubtreeStream stream_optionsSpec=new RewriteRuleSubtreeStream(adaptor,"rule optionsSpec");
        RewriteRuleSubtreeStream stream_delegateGrammars=new RewriteRuleSubtreeStream(adaptor,"rule delegateGrammars");
        RewriteRuleSubtreeStream stream_grammarType=new RewriteRuleSubtreeStream(adaptor,"rule grammarType");
        RewriteRuleSubtreeStream stream_actions=new RewriteRuleSubtreeStream(adaptor,"rule actions");
        RewriteRuleSubtreeStream stream_rules=new RewriteRuleSubtreeStream(adaptor,"rule rules");

        	this.grammar = g;
        	Map<String, Object> opts;

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:451:2: ( ( ACTION )? (cmt= DOC_COMMENT )? gr= grammarType gid= id SEMI ( optionsSpec )? (ig= delegateGrammars )? (ts= tokensSpec )? scopes= attrScopes (a= actions )? r= rules EOF -> ^( $gr $gid ( $cmt)? ( optionsSpec )? ( $ig)? ( $ts)? ( $scopes)? ( $a)? $r) )
            // org\\antlr\\grammar\\v3\\ANTLR.g:452:3: ( ACTION )? (cmt= DOC_COMMENT )? gr= grammarType gid= id SEMI ( optionsSpec )? (ig= delegateGrammars )? (ts= tokensSpec )? scopes= attrScopes (a= actions )? r= rules EOF
            {
            // org\\antlr\\grammar\\v3\\ANTLR.g:452:3: ( ACTION )?
            int alt1=2;
            switch ( input.LA(1) ) {
                case ACTION:
                    {
                    alt1=1;
                    }
                    break;
            }

            switch (alt1) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:452:5: ACTION
                    {
                    ACTION1=(Token)match(input,ACTION,FOLLOW_ACTION_in_grammar_318); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ACTION.add(ACTION1);


                    }
                    break;

            }

            // org\\antlr\\grammar\\v3\\ANTLR.g:453:3: (cmt= DOC_COMMENT )?
            int alt2=2;
            switch ( input.LA(1) ) {
                case DOC_COMMENT:
                    {
                    alt2=1;
                    }
                    break;
            }

            switch (alt2) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:453:5: cmt= DOC_COMMENT
                    {
                    cmt=(Token)match(input,DOC_COMMENT,FOLLOW_DOC_COMMENT_in_grammar_329); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOC_COMMENT.add(cmt);


                    }
                    break;

            }

            pushFollow(FOLLOW_grammarType_in_grammar_339);
            gr=grammarType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_grammarType.add(gr.getTree());
            pushFollow(FOLLOW_id_in_grammar_343);
            gid=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(gid.getTree());
            if ( state.backtracking==0 ) {
              grammar.setName((gid!=null?input.toString(gid.start,gid.stop):null));
            }
            SEMI2=(Token)match(input,SEMI,FOLLOW_SEMI_in_grammar_347); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMI.add(SEMI2);

            // org\\antlr\\grammar\\v3\\ANTLR.g:455:3: ( optionsSpec )?
            int alt3=2;
            switch ( input.LA(1) ) {
                case OPTIONS:
                    {
                    alt3=1;
                    }
                    break;
            }

            switch (alt3) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:455:5: optionsSpec
                    {
                    pushFollow(FOLLOW_optionsSpec_in_grammar_353);
                    optionsSpec3=optionsSpec();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_optionsSpec.add(optionsSpec3.getTree());
                    if ( state.backtracking==0 ) {
                      opts = (optionsSpec3!=null?optionsSpec3.opts:null); grammar.setOptions(opts, (optionsSpec3!=null?((Token)optionsSpec3.start):null));
                    }

                    }
                    break;

            }

            // org\\antlr\\grammar\\v3\\ANTLR.g:457:3: (ig= delegateGrammars )?
            int alt4=2;
            switch ( input.LA(1) ) {
                case IMPORT:
                    {
                    alt4=1;
                    }
                    break;
            }

            switch (alt4) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:457:4: ig= delegateGrammars
                    {
                    pushFollow(FOLLOW_delegateGrammars_in_grammar_367);
                    ig=delegateGrammars();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_delegateGrammars.add(ig.getTree());

                    }
                    break;

            }

            // org\\antlr\\grammar\\v3\\ANTLR.g:458:3: (ts= tokensSpec )?
            int alt5=2;
            switch ( input.LA(1) ) {
                case TOKENS:
                    {
                    alt5=1;
                    }
                    break;
            }

            switch (alt5) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:458:4: ts= tokensSpec
                    {
                    pushFollow(FOLLOW_tokensSpec_in_grammar_376);
                    ts=tokensSpec();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_tokensSpec.add(ts.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_attrScopes_in_grammar_384);
            scopes=attrScopes();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_attrScopes.add(scopes.getTree());
            // org\\antlr\\grammar\\v3\\ANTLR.g:460:3: (a= actions )?
            int alt6=2;
            switch ( input.LA(1) ) {
                case AMPERSAND:
                    {
                    alt6=1;
                    }
                    break;
            }

            switch (alt6) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:460:4: a= actions
                    {
                    pushFollow(FOLLOW_actions_in_grammar_391);
                    a=actions();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_actions.add(a.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_rules_in_grammar_399);
            r=rules();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rules.add(r.getTree());
            EOF4=(Token)match(input,EOF,FOLLOW_EOF_in_grammar_403); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOF.add(EOF4);



            // AST REWRITE
            // elements: gid, a, ig, ts, r, gr, cmt, scopes, optionsSpec
            // token labels: cmt
            // rule labels: scopes, retval, ts, r, ig, a, gid, gr
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_cmt=new RewriteRuleTokenStream(adaptor,"token cmt",cmt);
            RewriteRuleSubtreeStream stream_scopes=new RewriteRuleSubtreeStream(adaptor,"rule scopes",scopes!=null?scopes.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_ts=new RewriteRuleSubtreeStream(adaptor,"rule ts",ts!=null?ts.tree:null);
            RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"rule r",r!=null?r.tree:null);
            RewriteRuleSubtreeStream stream_ig=new RewriteRuleSubtreeStream(adaptor,"rule ig",ig!=null?ig.tree:null);
            RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.tree:null);
            RewriteRuleSubtreeStream stream_gid=new RewriteRuleSubtreeStream(adaptor,"rule gid",gid!=null?gid.tree:null);
            RewriteRuleSubtreeStream stream_gr=new RewriteRuleSubtreeStream(adaptor,"rule gr",gr!=null?gr.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 463:3: -> ^( $gr $gid ( $cmt)? ( optionsSpec )? ( $ig)? ( $ts)? ( $scopes)? ( $a)? $r)
            {
                // org\\antlr\\grammar\\v3\\ANTLR.g:463:6: ^( $gr $gid ( $cmt)? ( optionsSpec )? ( $ig)? ( $ts)? ( $scopes)? ( $a)? $r)
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot(stream_gr.nextNode(), root_1);

                adaptor.addChild(root_1, stream_gid.nextTree());
                // org\\antlr\\grammar\\v3\\ANTLR.g:463:17: ( $cmt)?
                if ( stream_cmt.hasNext() ) {
                    adaptor.addChild(root_1, stream_cmt.nextNode());

                }
                stream_cmt.reset();
                // org\\antlr\\grammar\\v3\\ANTLR.g:463:23: ( optionsSpec )?
                if ( stream_optionsSpec.hasNext() ) {
                    adaptor.addChild(root_1, stream_optionsSpec.nextTree());

                }
                stream_optionsSpec.reset();
                // org\\antlr\\grammar\\v3\\ANTLR.g:463:36: ( $ig)?
                if ( stream_ig.hasNext() ) {
                    adaptor.addChild(root_1, stream_ig.nextTree());

                }
                stream_ig.reset();
                // org\\antlr\\grammar\\v3\\ANTLR.g:463:41: ( $ts)?
                if ( stream_ts.hasNext() ) {
                    adaptor.addChild(root_1, stream_ts.nextTree());

                }
                stream_ts.reset();
                // org\\antlr\\grammar\\v3\\ANTLR.g:463:46: ( $scopes)?
                if ( stream_scopes.hasNext() ) {
                    adaptor.addChild(root_1, stream_scopes.nextTree());

                }
                stream_scopes.reset();
                // org\\antlr\\grammar\\v3\\ANTLR.g:463:55: ( $a)?
                if ( stream_a.hasNext() ) {
                    adaptor.addChild(root_1, stream_a.nextTree());

                }
                stream_a.reset();
                adaptor.addChild(root_1, stream_r.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

              	cleanup( ((GrammarAST)retval.tree) );

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "grammar_"

    public static class grammarType_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "grammarType"
    // org\\antlr\\grammar\\v3\\ANTLR.g:466:1: grammarType : ( 'lexer' gr= 'grammar' -> LEXER_GRAMMAR[$gr] | 'parser' gr= 'grammar' -> PARSER_GRAMMAR[$gr] | 'tree' gr= 'grammar' -> TREE_GRAMMAR[$gr] | gr= 'grammar' -> COMBINED_GRAMMAR[$gr] ) ;
    public final ANTLRParser.grammarType_return grammarType() throws RecognitionException {
        ANTLRParser.grammarType_return retval = new ANTLRParser.grammarType_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token gr=null;
        Token string_literal5=null;
        Token string_literal6=null;
        Token string_literal7=null;

        GrammarAST gr_tree=null;
        GrammarAST string_literal5_tree=null;
        GrammarAST string_literal6_tree=null;
        GrammarAST string_literal7_tree=null;
        RewriteRuleTokenStream stream_TREE=new RewriteRuleTokenStream(adaptor,"token TREE");
        RewriteRuleTokenStream stream_PARSER=new RewriteRuleTokenStream(adaptor,"token PARSER");
        RewriteRuleTokenStream stream_LEXER=new RewriteRuleTokenStream(adaptor,"token LEXER");
        RewriteRuleTokenStream stream_GRAMMAR=new RewriteRuleTokenStream(adaptor,"token GRAMMAR");

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:467:2: ( ( 'lexer' gr= 'grammar' -> LEXER_GRAMMAR[$gr] | 'parser' gr= 'grammar' -> PARSER_GRAMMAR[$gr] | 'tree' gr= 'grammar' -> TREE_GRAMMAR[$gr] | gr= 'grammar' -> COMBINED_GRAMMAR[$gr] ) )
            // org\\antlr\\grammar\\v3\\ANTLR.g:467:4: ( 'lexer' gr= 'grammar' -> LEXER_GRAMMAR[$gr] | 'parser' gr= 'grammar' -> PARSER_GRAMMAR[$gr] | 'tree' gr= 'grammar' -> TREE_GRAMMAR[$gr] | gr= 'grammar' -> COMBINED_GRAMMAR[$gr] )
            {
            // org\\antlr\\grammar\\v3\\ANTLR.g:467:4: ( 'lexer' gr= 'grammar' -> LEXER_GRAMMAR[$gr] | 'parser' gr= 'grammar' -> PARSER_GRAMMAR[$gr] | 'tree' gr= 'grammar' -> TREE_GRAMMAR[$gr] | gr= 'grammar' -> COMBINED_GRAMMAR[$gr] )
            int alt7=4;
            switch ( input.LA(1) ) {
            case LEXER:
                {
                alt7=1;
                }
                break;
            case PARSER:
                {
                alt7=2;
                }
                break;
            case TREE:
                {
                alt7=3;
                }
                break;
            case GRAMMAR:
                {
                alt7=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:467:6: 'lexer' gr= 'grammar'
                    {
                    string_literal5=(Token)match(input,LEXER,FOLLOW_LEXER_in_grammarType454); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LEXER.add(string_literal5);

                    gr=(Token)match(input,GRAMMAR,FOLLOW_GRAMMAR_in_grammarType459); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GRAMMAR.add(gr);

                    if ( state.backtracking==0 ) {
                      grammarType=Grammar.LEXER; grammar.type = Grammar.LEXER;
                    }


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 468:4: -> LEXER_GRAMMAR[$gr]
                    {
                        adaptor.addChild(root_0, (GrammarAST)adaptor.create(LEXER_GRAMMAR, gr));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:469:5: 'parser' gr= 'grammar'
                    {
                    string_literal6=(Token)match(input,PARSER,FOLLOW_PARSER_in_grammarType482); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PARSER.add(string_literal6);

                    gr=(Token)match(input,GRAMMAR,FOLLOW_GRAMMAR_in_grammarType486); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GRAMMAR.add(gr);

                    if ( state.backtracking==0 ) {
                      grammarType=Grammar.PARSER; grammar.type = Grammar.PARSER;
                    }


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 470:4: -> PARSER_GRAMMAR[$gr]
                    {
                        adaptor.addChild(root_0, (GrammarAST)adaptor.create(PARSER_GRAMMAR, gr));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:471:5: 'tree' gr= 'grammar'
                    {
                    string_literal7=(Token)match(input,TREE,FOLLOW_TREE_in_grammarType507); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_TREE.add(string_literal7);

                    gr=(Token)match(input,GRAMMAR,FOLLOW_GRAMMAR_in_grammarType513); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GRAMMAR.add(gr);

                    if ( state.backtracking==0 ) {
                      grammarType=Grammar.TREE_PARSER; grammar.type = Grammar.TREE_PARSER;
                    }


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 472:4: -> TREE_GRAMMAR[$gr]
                    {
                        adaptor.addChild(root_0, (GrammarAST)adaptor.create(TREE_GRAMMAR, gr));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:473:8: gr= 'grammar'
                    {
                    gr=(Token)match(input,GRAMMAR,FOLLOW_GRAMMAR_in_grammarType536); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GRAMMAR.add(gr);

                    if ( state.backtracking==0 ) {
                      grammarType=Grammar.COMBINED; grammar.type = Grammar.COMBINED;
                    }


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 474:4: -> COMBINED_GRAMMAR[$gr]
                    {
                        adaptor.addChild(root_0, (GrammarAST)adaptor.create(COMBINED_GRAMMAR, gr));

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "grammarType"

    public static class actions_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "actions"
    // org\\antlr\\grammar\\v3\\ANTLR.g:478:1: actions : ( action )+ ;
    public final ANTLRParser.actions_return actions() throws RecognitionException {
        ANTLRParser.actions_return retval = new ANTLRParser.actions_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        ANTLRParser.action_return action8 = null;



        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:479:2: ( ( action )+ )
            // org\\antlr\\grammar\\v3\\ANTLR.g:479:4: ( action )+
            {
            root_0 = (GrammarAST)adaptor.nil();

            // org\\antlr\\grammar\\v3\\ANTLR.g:479:4: ( action )+
            int cnt8=0;
            loop8:
            do {
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
            	    // org\\antlr\\grammar\\v3\\ANTLR.g:479:5: action
            	    {
            	    pushFollow(FOLLOW_action_in_actions563);
            	    action8=action();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, action8.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "actions"

    public static class action_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "action"
    // org\\antlr\\grammar\\v3\\ANTLR.g:482:1: action : AMPERSAND ( actionScopeName COLON COLON )? id ACTION ;
    public final ANTLRParser.action_return action() throws RecognitionException {
        ANTLRParser.action_return retval = new ANTLRParser.action_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token AMPERSAND9=null;
        Token COLON11=null;
        Token COLON12=null;
        Token ACTION14=null;
        ANTLRParser.actionScopeName_return actionScopeName10 = null;

        ANTLRParser.id_return id13 = null;


        GrammarAST AMPERSAND9_tree=null;
        GrammarAST COLON11_tree=null;
        GrammarAST COLON12_tree=null;
        GrammarAST ACTION14_tree=null;

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:484:2: ( AMPERSAND ( actionScopeName COLON COLON )? id ACTION )
            // org\\antlr\\grammar\\v3\\ANTLR.g:484:4: AMPERSAND ( actionScopeName COLON COLON )? id ACTION
            {
            root_0 = (GrammarAST)adaptor.nil();

            AMPERSAND9=(Token)match(input,AMPERSAND,FOLLOW_AMPERSAND_in_action578); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            AMPERSAND9_tree = (GrammarAST)adaptor.create(AMPERSAND9);
            root_0 = (GrammarAST)adaptor.becomeRoot(AMPERSAND9_tree, root_0);
            }
            // org\\antlr\\grammar\\v3\\ANTLR.g:484:15: ( actionScopeName COLON COLON )?
            int alt9=2;
            switch ( input.LA(1) ) {
                case TOKEN_REF:
                    {
                    switch ( input.LA(2) ) {
                        case COLON:
                            {
                            alt9=1;
                            }
                            break;
                    }

                    }
                    break;
                case RULE_REF:
                    {
                    switch ( input.LA(2) ) {
                        case COLON:
                            {
                            alt9=1;
                            }
                            break;
                    }

                    }
                    break;
                case LEXER:
                case PARSER:
                    {
                    alt9=1;
                    }
                    break;
            }

            switch (alt9) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:484:16: actionScopeName COLON COLON
                    {
                    pushFollow(FOLLOW_actionScopeName_in_action582);
                    actionScopeName10=actionScopeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, actionScopeName10.getTree());
                    COLON11=(Token)match(input,COLON,FOLLOW_COLON_in_action584); if (state.failed) return retval;
                    COLON12=(Token)match(input,COLON,FOLLOW_COLON_in_action587); if (state.failed) return retval;

                    }
                    break;

            }

            pushFollow(FOLLOW_id_in_action592);
            id13=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, id13.getTree());
            ACTION14=(Token)match(input,ACTION,FOLLOW_ACTION_in_action594); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ACTION14_tree = (GrammarAST)adaptor.create(ACTION14);
            adaptor.addChild(root_0, ACTION14_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "action"

    public static class actionScopeName_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "actionScopeName"
    // org\\antlr\\grammar\\v3\\ANTLR.g:487:1: actionScopeName : ( id | l= 'lexer' -> ID[$l] | p= 'parser' -> ID[$p] );
    public final ANTLRParser.actionScopeName_return actionScopeName() throws RecognitionException {
        ANTLRParser.actionScopeName_return retval = new ANTLRParser.actionScopeName_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token l=null;
        Token p=null;
        ANTLRParser.id_return id15 = null;


        GrammarAST l_tree=null;
        GrammarAST p_tree=null;
        RewriteRuleTokenStream stream_PARSER=new RewriteRuleTokenStream(adaptor,"token PARSER");
        RewriteRuleTokenStream stream_LEXER=new RewriteRuleTokenStream(adaptor,"token LEXER");

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:491:2: ( id | l= 'lexer' -> ID[$l] | p= 'parser' -> ID[$p] )
            int alt10=3;
            switch ( input.LA(1) ) {
            case TOKEN_REF:
            case RULE_REF:
                {
                alt10=1;
                }
                break;
            case LEXER:
                {
                alt10=2;
                }
                break;
            case PARSER:
                {
                alt10=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:491:4: id
                    {
                    root_0 = (GrammarAST)adaptor.nil();

                    pushFollow(FOLLOW_id_in_actionScopeName607);
                    id15=id();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, id15.getTree());

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:492:4: l= 'lexer'
                    {
                    l=(Token)match(input,LEXER,FOLLOW_LEXER_in_actionScopeName614); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LEXER.add(l);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 493:3: -> ID[$l]
                    {
                        adaptor.addChild(root_0, (GrammarAST)adaptor.create(ID, l));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:494:4: p= 'parser'
                    {
                    p=(Token)match(input,PARSER,FOLLOW_PARSER_in_actionScopeName628); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PARSER.add(p);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 495:3: -> ID[$p]
                    {
                        adaptor.addChild(root_0, (GrammarAST)adaptor.create(ID, p));

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "actionScopeName"

    public static class optionsSpec_return extends ParserRuleReturnScope {
        public Map<String, Object> opts=new HashMap<String, Object>();
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "optionsSpec"
    // org\\antlr\\grammar\\v3\\ANTLR.g:498:1: optionsSpec returns [Map<String, Object> opts=new HashMap<String, Object>()] : OPTIONS ( option[$opts] SEMI )+ RCURLY ;
    public final ANTLRParser.optionsSpec_return optionsSpec() throws RecognitionException {
        ANTLRParser.optionsSpec_return retval = new ANTLRParser.optionsSpec_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token OPTIONS16=null;
        Token SEMI18=null;
        Token RCURLY19=null;
        ANTLRParser.option_return option17 = null;


        GrammarAST OPTIONS16_tree=null;
        GrammarAST SEMI18_tree=null;
        GrammarAST RCURLY19_tree=null;

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:499:2: ( OPTIONS ( option[$opts] SEMI )+ RCURLY )
            // org\\antlr\\grammar\\v3\\ANTLR.g:499:4: OPTIONS ( option[$opts] SEMI )+ RCURLY
            {
            root_0 = (GrammarAST)adaptor.nil();

            OPTIONS16=(Token)match(input,OPTIONS,FOLLOW_OPTIONS_in_optionsSpec650); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OPTIONS16_tree = (GrammarAST)adaptor.create(OPTIONS16);
            root_0 = (GrammarAST)adaptor.becomeRoot(OPTIONS16_tree, root_0);
            }
            // org\\antlr\\grammar\\v3\\ANTLR.g:499:13: ( option[$opts] SEMI )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                switch ( input.LA(1) ) {
                case TOKEN_REF:
                case RULE_REF:
                    {
                    alt11=1;
                    }
                    break;

                }

                switch (alt11) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\ANTLR.g:499:14: option[$opts] SEMI
            	    {
            	    pushFollow(FOLLOW_option_in_optionsSpec654);
            	    option17=option(retval.opts);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, option17.getTree());
            	    SEMI18=(Token)match(input,SEMI,FOLLOW_SEMI_in_optionsSpec657); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);

            RCURLY19=(Token)match(input,RCURLY,FOLLOW_RCURLY_in_optionsSpec662); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "optionsSpec"

    public static class option_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "option"
    // org\\antlr\\grammar\\v3\\ANTLR.g:502:1: option[Map<String, Object> opts] : id ASSIGN optionValue ;
    public final ANTLRParser.option_return option(Map<String, Object> opts) throws RecognitionException {
        ANTLRParser.option_return retval = new ANTLRParser.option_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token ASSIGN21=null;
        ANTLRParser.id_return id20 = null;

        ANTLRParser.optionValue_return optionValue22 = null;


        GrammarAST ASSIGN21_tree=null;

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:503:2: ( id ASSIGN optionValue )
            // org\\antlr\\grammar\\v3\\ANTLR.g:503:4: id ASSIGN optionValue
            {
            root_0 = (GrammarAST)adaptor.nil();

            pushFollow(FOLLOW_id_in_option675);
            id20=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, id20.getTree());
            ASSIGN21=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_option677); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ASSIGN21_tree = (GrammarAST)adaptor.create(ASSIGN21);
            root_0 = (GrammarAST)adaptor.becomeRoot(ASSIGN21_tree, root_0);
            }
            pushFollow(FOLLOW_optionValue_in_option680);
            optionValue22=optionValue();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, optionValue22.getTree());
            if ( state.backtracking==0 ) {

              			opts.put((id20!=null?input.toString(id20.start,id20.stop):null), (optionValue22!=null?optionValue22.value:null));
              		
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "option"

    public static class optionValue_return extends ParserRuleReturnScope {
        public Object value = null;
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "optionValue"
    // org\\antlr\\grammar\\v3\\ANTLR.g:509:1: optionValue returns [Object value = null] : (x= id | s= STRING_LITERAL | c= CHAR_LITERAL | i= INT | ss= STAR -> STRING_LITERAL[$ss] );
    public final ANTLRParser.optionValue_return optionValue() throws RecognitionException {
        ANTLRParser.optionValue_return retval = new ANTLRParser.optionValue_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token s=null;
        Token c=null;
        Token i=null;
        Token ss=null;
        ANTLRParser.id_return x = null;


        GrammarAST s_tree=null;
        GrammarAST c_tree=null;
        GrammarAST i_tree=null;
        GrammarAST ss_tree=null;
        RewriteRuleTokenStream stream_STAR=new RewriteRuleTokenStream(adaptor,"token STAR");

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:510:2: (x= id | s= STRING_LITERAL | c= CHAR_LITERAL | i= INT | ss= STAR -> STRING_LITERAL[$ss] )
            int alt12=5;
            switch ( input.LA(1) ) {
            case TOKEN_REF:
            case RULE_REF:
                {
                alt12=1;
                }
                break;
            case STRING_LITERAL:
                {
                alt12=2;
                }
                break;
            case CHAR_LITERAL:
                {
                alt12=3;
                }
                break;
            case INT:
                {
                alt12=4;
                }
                break;
            case STAR:
                {
                alt12=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:510:4: x= id
                    {
                    root_0 = (GrammarAST)adaptor.nil();

                    pushFollow(FOLLOW_id_in_optionValue701);
                    x=id();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
                    if ( state.backtracking==0 ) {
                      retval.value = (x!=null?input.toString(x.start,x.stop):null);
                    }

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:511:4: s= STRING_LITERAL
                    {
                    root_0 = (GrammarAST)adaptor.nil();

                    s=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_optionValue713); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    s_tree = (GrammarAST)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);
                    }
                    if ( state.backtracking==0 ) {
                      String vs = (s!=null?s.getText():null);
                      						  // remove the quotes:
                      						  retval.value =vs.substring(1,vs.length()-1);
                    }

                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:514:4: c= CHAR_LITERAL
                    {
                    root_0 = (GrammarAST)adaptor.nil();

                    c=(Token)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_optionValue722); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    c_tree = (GrammarAST)adaptor.create(c);
                    adaptor.addChild(root_0, c_tree);
                    }
                    if ( state.backtracking==0 ) {
                      String vs = (c!=null?c.getText():null);
                      						  // remove the quotes:
                      						  retval.value =vs.substring(1,vs.length()-1);
                    }

                    }
                    break;
                case 4 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:517:4: i= INT
                    {
                    root_0 = (GrammarAST)adaptor.nil();

                    i=(Token)match(input,INT,FOLLOW_INT_in_optionValue733); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    i_tree = (GrammarAST)adaptor.create(i);
                    adaptor.addChild(root_0, i_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = Integer.parseInt((i!=null?i.getText():null));
                    }

                    }
                    break;
                case 5 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:518:4: ss= STAR
                    {
                    ss=(Token)match(input,STAR,FOLLOW_STAR_in_optionValue753); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STAR.add(ss);

                    if ( state.backtracking==0 ) {
                      retval.value = "*";
                    }


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 519:3: -> STRING_LITERAL[$ss]
                    {
                        adaptor.addChild(root_0, (GrammarAST)adaptor.create(STRING_LITERAL, ss));

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "optionValue"

    public static class delegateGrammars_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "delegateGrammars"
    // org\\antlr\\grammar\\v3\\ANTLR.g:523:1: delegateGrammars : 'import' delegateGrammar ( COMMA delegateGrammar )* SEMI ;
    public final ANTLRParser.delegateGrammars_return delegateGrammars() throws RecognitionException {
        ANTLRParser.delegateGrammars_return retval = new ANTLRParser.delegateGrammars_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token string_literal23=null;
        Token COMMA25=null;
        Token SEMI27=null;
        ANTLRParser.delegateGrammar_return delegateGrammar24 = null;

        ANTLRParser.delegateGrammar_return delegateGrammar26 = null;


        GrammarAST string_literal23_tree=null;
        GrammarAST COMMA25_tree=null;
        GrammarAST SEMI27_tree=null;

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:524:2: ( 'import' delegateGrammar ( COMMA delegateGrammar )* SEMI )
            // org\\antlr\\grammar\\v3\\ANTLR.g:524:4: 'import' delegateGrammar ( COMMA delegateGrammar )* SEMI
            {
            root_0 = (GrammarAST)adaptor.nil();

            string_literal23=(Token)match(input,IMPORT,FOLLOW_IMPORT_in_delegateGrammars778); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal23_tree = (GrammarAST)adaptor.create(string_literal23);
            root_0 = (GrammarAST)adaptor.becomeRoot(string_literal23_tree, root_0);
            }
            pushFollow(FOLLOW_delegateGrammar_in_delegateGrammars781);
            delegateGrammar24=delegateGrammar();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, delegateGrammar24.getTree());
            // org\\antlr\\grammar\\v3\\ANTLR.g:524:30: ( COMMA delegateGrammar )*
            loop13:
            do {
                int alt13=2;
                switch ( input.LA(1) ) {
                case COMMA:
                    {
                    alt13=1;
                    }
                    break;

                }

                switch (alt13) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\ANTLR.g:524:31: COMMA delegateGrammar
            	    {
            	    COMMA25=(Token)match(input,COMMA,FOLLOW_COMMA_in_delegateGrammars784); if (state.failed) return retval;
            	    pushFollow(FOLLOW_delegateGrammar_in_delegateGrammars787);
            	    delegateGrammar26=delegateGrammar();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, delegateGrammar26.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            SEMI27=(Token)match(input,SEMI,FOLLOW_SEMI_in_delegateGrammars791); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "delegateGrammars"

    public static class delegateGrammar_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "delegateGrammar"
    // org\\antlr\\grammar\\v3\\ANTLR.g:527:1: delegateGrammar : (lab= id ASSIGN g= id | g2= id );
    public final ANTLRParser.delegateGrammar_return delegateGrammar() throws RecognitionException {
        ANTLRParser.delegateGrammar_return retval = new ANTLRParser.delegateGrammar_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token ASSIGN28=null;
        ANTLRParser.id_return lab = null;

        ANTLRParser.id_return g = null;

        ANTLRParser.id_return g2 = null;


        GrammarAST ASSIGN28_tree=null;

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:528:2: (lab= id ASSIGN g= id | g2= id )
            int alt14=2;
            switch ( input.LA(1) ) {
            case TOKEN_REF:
                {
                switch ( input.LA(2) ) {
                case ASSIGN:
                    {
                    alt14=1;
                    }
                    break;
                case SEMI:
                case COMMA:
                    {
                    alt14=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    throw nvae;
                }

                }
                break;
            case RULE_REF:
                {
                switch ( input.LA(2) ) {
                case ASSIGN:
                    {
                    alt14=1;
                    }
                    break;
                case SEMI:
                case COMMA:
                    {
                    alt14=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 2, input);

                    throw nvae;
                }

                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:528:4: lab= id ASSIGN g= id
                    {
                    root_0 = (GrammarAST)adaptor.nil();

                    pushFollow(FOLLOW_id_in_delegateGrammar805);
                    lab=id();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, lab.getTree());
                    ASSIGN28=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_delegateGrammar807); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASSIGN28_tree = (GrammarAST)adaptor.create(ASSIGN28);
                    root_0 = (GrammarAST)adaptor.becomeRoot(ASSIGN28_tree, root_0);
                    }
                    pushFollow(FOLLOW_id_in_delegateGrammar812);
                    g=id();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, g.getTree());
                    if ( state.backtracking==0 ) {
                      grammar.importGrammar((g!=null?((GrammarAST)g.tree):null), (lab!=null?input.toString(lab.start,lab.stop):null));
                    }

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:529:4: g2= id
                    {
                    root_0 = (GrammarAST)adaptor.nil();

                    pushFollow(FOLLOW_id_in_delegateGrammar821);
                    g2=id();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, g2.getTree());
                    if ( state.backtracking==0 ) {
                      grammar.importGrammar((g2!=null?((GrammarAST)g2.tree):null),null);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "delegateGrammar"

    public static class tokensSpec_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "tokensSpec"
    // org\\antlr\\grammar\\v3\\ANTLR.g:532:1: tokensSpec : TOKENS ( tokenSpec )* RCURLY ;
    public final ANTLRParser.tokensSpec_return tokensSpec() throws RecognitionException {
        ANTLRParser.tokensSpec_return retval = new ANTLRParser.tokensSpec_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token TOKENS29=null;
        Token RCURLY31=null;
        ANTLRParser.tokenSpec_return tokenSpec30 = null;


        GrammarAST TOKENS29_tree=null;
        GrammarAST RCURLY31_tree=null;

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:533:2: ( TOKENS ( tokenSpec )* RCURLY )
            // org\\antlr\\grammar\\v3\\ANTLR.g:533:4: TOKENS ( tokenSpec )* RCURLY
            {
            root_0 = (GrammarAST)adaptor.nil();

            TOKENS29=(Token)match(input,TOKENS,FOLLOW_TOKENS_in_tokensSpec848); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TOKENS29_tree = (GrammarAST)adaptor.create(TOKENS29);
            root_0 = (GrammarAST)adaptor.becomeRoot(TOKENS29_tree, root_0);
            }
            // org\\antlr\\grammar\\v3\\ANTLR.g:534:4: ( tokenSpec )*
            loop15:
            do {
                int alt15=2;
                switch ( input.LA(1) ) {
                case TOKEN_REF:
                    {
                    alt15=1;
                    }
                    break;

                }

                switch (alt15) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\ANTLR.g:534:4: tokenSpec
            	    {
            	    pushFollow(FOLLOW_tokenSpec_in_tokensSpec854);
            	    tokenSpec30=tokenSpec();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, tokenSpec30.getTree());

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            RCURLY31=(Token)match(input,RCURLY,FOLLOW_RCURLY_in_tokensSpec859); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "tokensSpec"

    public static class tokenSpec_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "tokenSpec"
    // org\\antlr\\grammar\\v3\\ANTLR.g:538:1: tokenSpec : TOKEN_REF ( ASSIGN ( STRING_LITERAL | CHAR_LITERAL ) )? SEMI ;
    public final ANTLRParser.tokenSpec_return tokenSpec() throws RecognitionException {
        ANTLRParser.tokenSpec_return retval = new ANTLRParser.tokenSpec_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token TOKEN_REF32=null;
        Token ASSIGN33=null;
        Token set34=null;
        Token SEMI35=null;

        GrammarAST TOKEN_REF32_tree=null;
        GrammarAST ASSIGN33_tree=null;
        GrammarAST set34_tree=null;
        GrammarAST SEMI35_tree=null;

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:539:2: ( TOKEN_REF ( ASSIGN ( STRING_LITERAL | CHAR_LITERAL ) )? SEMI )
            // org\\antlr\\grammar\\v3\\ANTLR.g:539:4: TOKEN_REF ( ASSIGN ( STRING_LITERAL | CHAR_LITERAL ) )? SEMI
            {
            root_0 = (GrammarAST)adaptor.nil();

            TOKEN_REF32=(Token)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_tokenSpec871); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TOKEN_REF32_tree = (GrammarAST)adaptor.create(TOKEN_REF32);
            adaptor.addChild(root_0, TOKEN_REF32_tree);
            }
            // org\\antlr\\grammar\\v3\\ANTLR.g:539:14: ( ASSIGN ( STRING_LITERAL | CHAR_LITERAL ) )?
            int alt16=2;
            switch ( input.LA(1) ) {
                case ASSIGN:
                    {
                    alt16=1;
                    }
                    break;
            }

            switch (alt16) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:539:16: ASSIGN ( STRING_LITERAL | CHAR_LITERAL )
                    {
                    ASSIGN33=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_tokenSpec875); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASSIGN33_tree = (GrammarAST)adaptor.create(ASSIGN33);
                    root_0 = (GrammarAST)adaptor.becomeRoot(ASSIGN33_tree, root_0);
                    }
                    set34=(Token)input.LT(1);
                    if ( (input.LA(1)>=STRING_LITERAL && input.LA(1)<=CHAR_LITERAL) ) {
                        input.consume();
                        if ( state.backtracking==0 ) adaptor.addChild(root_0, (GrammarAST)adaptor.create(set34));
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;

            }

            SEMI35=(Token)match(input,SEMI,FOLLOW_SEMI_in_tokenSpec887); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "tokenSpec"

    public static class attrScopes_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attrScopes"
    // org\\antlr\\grammar\\v3\\ANTLR.g:542:1: attrScopes : ( attrScope )* ;
    public final ANTLRParser.attrScopes_return attrScopes() throws RecognitionException {
        ANTLRParser.attrScopes_return retval = new ANTLRParser.attrScopes_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        ANTLRParser.attrScope_return attrScope36 = null;



        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:543:2: ( ( attrScope )* )
            // org\\antlr\\grammar\\v3\\ANTLR.g:543:4: ( attrScope )*
            {
            root_0 = (GrammarAST)adaptor.nil();

            // org\\antlr\\grammar\\v3\\ANTLR.g:543:4: ( attrScope )*
            loop17:
            do {
                int alt17=2;
                switch ( input.LA(1) ) {
                case SCOPE:
                    {
                    alt17=1;
                    }
                    break;

                }

                switch (alt17) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\ANTLR.g:543:5: attrScope
            	    {
            	    pushFollow(FOLLOW_attrScope_in_attrScopes900);
            	    attrScope36=attrScope();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, attrScope36.getTree());

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "attrScopes"

    public static class attrScope_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attrScope"
    // org\\antlr\\grammar\\v3\\ANTLR.g:546:1: attrScope : 'scope' id ( ruleActions )? ACTION ;
    public final ANTLRParser.attrScope_return attrScope() throws RecognitionException {
        ANTLRParser.attrScope_return retval = new ANTLRParser.attrScope_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token string_literal37=null;
        Token ACTION40=null;
        ANTLRParser.id_return id38 = null;

        ANTLRParser.ruleActions_return ruleActions39 = null;


        GrammarAST string_literal37_tree=null;
        GrammarAST ACTION40_tree=null;

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:547:2: ( 'scope' id ( ruleActions )? ACTION )
            // org\\antlr\\grammar\\v3\\ANTLR.g:547:4: 'scope' id ( ruleActions )? ACTION
            {
            root_0 = (GrammarAST)adaptor.nil();

            string_literal37=(Token)match(input,SCOPE,FOLLOW_SCOPE_in_attrScope913); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal37_tree = (GrammarAST)adaptor.create(string_literal37);
            root_0 = (GrammarAST)adaptor.becomeRoot(string_literal37_tree, root_0);
            }
            pushFollow(FOLLOW_id_in_attrScope916);
            id38=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, id38.getTree());
            // org\\antlr\\grammar\\v3\\ANTLR.g:547:16: ( ruleActions )?
            int alt18=2;
            switch ( input.LA(1) ) {
                case AMPERSAND:
                    {
                    alt18=1;
                    }
                    break;
            }

            switch (alt18) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:547:16: ruleActions
                    {
                    pushFollow(FOLLOW_ruleActions_in_attrScope918);
                    ruleActions39=ruleActions();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ruleActions39.getTree());

                    }
                    break;

            }

            ACTION40=(Token)match(input,ACTION,FOLLOW_ACTION_in_attrScope921); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ACTION40_tree = (GrammarAST)adaptor.create(ACTION40);
            adaptor.addChild(root_0, ACTION40_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "attrScope"

    public static class rules_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rules"
    // org\\antlr\\grammar\\v3\\ANTLR.g:550:1: rules : ( rule )+ ;
    public final ANTLRParser.rules_return rules() throws RecognitionException {
        ANTLRParser.rules_return retval = new ANTLRParser.rules_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        ANTLRParser.rule_return rule41 = null;



        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:551:2: ( ( rule )+ )
            // org\\antlr\\grammar\\v3\\ANTLR.g:551:4: ( rule )+
            {
            root_0 = (GrammarAST)adaptor.nil();

            // org\\antlr\\grammar\\v3\\ANTLR.g:551:4: ( rule )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                switch ( input.LA(1) ) {
                case PRIVATE:
                case PROTECTED:
                case PUBLIC:
                case FRAGMENT:
                case DOC_COMMENT:
                case TOKEN_REF:
                case RULE_REF:
                    {
                    alt19=1;
                    }
                    break;

                }

                switch (alt19) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\ANTLR.g:551:6: rule
            	    {
            	    pushFollow(FOLLOW_rule_in_rules934);
            	    rule41=rule();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, rule41.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rules"

    public static class rule_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rule"
    // org\\antlr\\grammar\\v3\\ANTLR.g:555:1: public rule : ( (d= DOC_COMMENT )? (p1= 'protected' | p2= 'public' | p3= 'private' | p4= 'fragment' )? ruleName= id ( BANG )? (aa= ARG_ACTION )? ( 'returns' rt= ARG_ACTION )? ( throwsSpec )? ( optionsSpec )? scopes= ruleScopeSpec ( ruleActions )? COLON ruleAltList[$optionsSpec.opts] SEMI (ex= exceptionGroup )? -> ^( RULE[$ruleName.start, \"rule\"] $ruleName ( $p1)? ( $p2)? ( $p3)? ( $p4)? ^( ARG[\"ARG\"] ( $aa)? ) ^( RET[\"RET\"] ( $rt)? ) ( throwsSpec )? ( optionsSpec )? $scopes ( ruleActions )? ruleAltList ( $ex)? EOR[$SEMI,\"<end-of-rule>\"] ) ) ;
    public final ANTLRParser.rule_return rule() throws RecognitionException {
        ANTLRParser.rule_return retval = new ANTLRParser.rule_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token d=null;
        Token p1=null;
        Token p2=null;
        Token p3=null;
        Token p4=null;
        Token aa=null;
        Token rt=null;
        Token BANG42=null;
        Token string_literal43=null;
        Token COLON47=null;
        Token SEMI49=null;
        ANTLRParser.id_return ruleName = null;

        ANTLRParser.ruleScopeSpec_return scopes = null;

        ANTLRParser.exceptionGroup_return ex = null;

        ANTLRParser.throwsSpec_return throwsSpec44 = null;

        ANTLRParser.optionsSpec_return optionsSpec45 = null;

        ANTLRParser.ruleActions_return ruleActions46 = null;

        ANTLRParser.ruleAltList_return ruleAltList48 = null;


        GrammarAST d_tree=null;
        GrammarAST p1_tree=null;
        GrammarAST p2_tree=null;
        GrammarAST p3_tree=null;
        GrammarAST p4_tree=null;
        GrammarAST aa_tree=null;
        GrammarAST rt_tree=null;
        GrammarAST BANG42_tree=null;
        GrammarAST string_literal43_tree=null;
        GrammarAST COLON47_tree=null;
        GrammarAST SEMI49_tree=null;
        RewriteRuleTokenStream stream_DOC_COMMENT=new RewriteRuleTokenStream(adaptor,"token DOC_COMMENT");
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_PROTECTED=new RewriteRuleTokenStream(adaptor,"token PROTECTED");
        RewriteRuleTokenStream stream_BANG=new RewriteRuleTokenStream(adaptor,"token BANG");
        RewriteRuleTokenStream stream_PUBLIC=new RewriteRuleTokenStream(adaptor,"token PUBLIC");
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleTokenStream stream_PRIVATE=new RewriteRuleTokenStream(adaptor,"token PRIVATE");
        RewriteRuleTokenStream stream_FRAGMENT=new RewriteRuleTokenStream(adaptor,"token FRAGMENT");
        RewriteRuleTokenStream stream_RETURNS=new RewriteRuleTokenStream(adaptor,"token RETURNS");
        RewriteRuleTokenStream stream_ARG_ACTION=new RewriteRuleTokenStream(adaptor,"token ARG_ACTION");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_ruleAltList=new RewriteRuleSubtreeStream(adaptor,"rule ruleAltList");
        RewriteRuleSubtreeStream stream_exceptionGroup=new RewriteRuleSubtreeStream(adaptor,"rule exceptionGroup");
        RewriteRuleSubtreeStream stream_throwsSpec=new RewriteRuleSubtreeStream(adaptor,"rule throwsSpec");
        RewriteRuleSubtreeStream stream_ruleScopeSpec=new RewriteRuleSubtreeStream(adaptor,"rule ruleScopeSpec");
        RewriteRuleSubtreeStream stream_optionsSpec=new RewriteRuleSubtreeStream(adaptor,"rule optionsSpec");
        RewriteRuleSubtreeStream stream_ruleActions=new RewriteRuleSubtreeStream(adaptor,"rule ruleActions");

        	GrammarAST eob=null;
        	CommonToken start = (CommonToken)LT(1);
        	int startLine = LT(1).getLine();

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:563:2: ( ( (d= DOC_COMMENT )? (p1= 'protected' | p2= 'public' | p3= 'private' | p4= 'fragment' )? ruleName= id ( BANG )? (aa= ARG_ACTION )? ( 'returns' rt= ARG_ACTION )? ( throwsSpec )? ( optionsSpec )? scopes= ruleScopeSpec ( ruleActions )? COLON ruleAltList[$optionsSpec.opts] SEMI (ex= exceptionGroup )? -> ^( RULE[$ruleName.start, \"rule\"] $ruleName ( $p1)? ( $p2)? ( $p3)? ( $p4)? ^( ARG[\"ARG\"] ( $aa)? ) ^( RET[\"RET\"] ( $rt)? ) ( throwsSpec )? ( optionsSpec )? $scopes ( ruleActions )? ruleAltList ( $ex)? EOR[$SEMI,\"<end-of-rule>\"] ) ) )
            // org\\antlr\\grammar\\v3\\ANTLR.g:564:2: ( (d= DOC_COMMENT )? (p1= 'protected' | p2= 'public' | p3= 'private' | p4= 'fragment' )? ruleName= id ( BANG )? (aa= ARG_ACTION )? ( 'returns' rt= ARG_ACTION )? ( throwsSpec )? ( optionsSpec )? scopes= ruleScopeSpec ( ruleActions )? COLON ruleAltList[$optionsSpec.opts] SEMI (ex= exceptionGroup )? -> ^( RULE[$ruleName.start, \"rule\"] $ruleName ( $p1)? ( $p2)? ( $p3)? ( $p4)? ^( ARG[\"ARG\"] ( $aa)? ) ^( RET[\"RET\"] ( $rt)? ) ( throwsSpec )? ( optionsSpec )? $scopes ( ruleActions )? ruleAltList ( $ex)? EOR[$SEMI,\"<end-of-rule>\"] ) )
            {
            // org\\antlr\\grammar\\v3\\ANTLR.g:564:2: ( (d= DOC_COMMENT )? (p1= 'protected' | p2= 'public' | p3= 'private' | p4= 'fragment' )? ruleName= id ( BANG )? (aa= ARG_ACTION )? ( 'returns' rt= ARG_ACTION )? ( throwsSpec )? ( optionsSpec )? scopes= ruleScopeSpec ( ruleActions )? COLON ruleAltList[$optionsSpec.opts] SEMI (ex= exceptionGroup )? -> ^( RULE[$ruleName.start, \"rule\"] $ruleName ( $p1)? ( $p2)? ( $p3)? ( $p4)? ^( ARG[\"ARG\"] ( $aa)? ) ^( RET[\"RET\"] ( $rt)? ) ( throwsSpec )? ( optionsSpec )? $scopes ( ruleActions )? ruleAltList ( $ex)? EOR[$SEMI,\"<end-of-rule>\"] ) )
            // org\\antlr\\grammar\\v3\\ANTLR.g:564:4: (d= DOC_COMMENT )? (p1= 'protected' | p2= 'public' | p3= 'private' | p4= 'fragment' )? ruleName= id ( BANG )? (aa= ARG_ACTION )? ( 'returns' rt= ARG_ACTION )? ( throwsSpec )? ( optionsSpec )? scopes= ruleScopeSpec ( ruleActions )? COLON ruleAltList[$optionsSpec.opts] SEMI (ex= exceptionGroup )?
            {
            // org\\antlr\\grammar\\v3\\ANTLR.g:564:4: (d= DOC_COMMENT )?
            int alt20=2;
            switch ( input.LA(1) ) {
                case DOC_COMMENT:
                    {
                    alt20=1;
                    }
                    break;
            }

            switch (alt20) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:564:6: d= DOC_COMMENT
                    {
                    d=(Token)match(input,DOC_COMMENT,FOLLOW_DOC_COMMENT_in_rule964); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOC_COMMENT.add(d);


                    }
                    break;

            }

            // org\\antlr\\grammar\\v3\\ANTLR.g:566:3: (p1= 'protected' | p2= 'public' | p3= 'private' | p4= 'fragment' )?
            int alt21=5;
            switch ( input.LA(1) ) {
                case PROTECTED:
                    {
                    alt21=1;
                    }
                    break;
                case PUBLIC:
                    {
                    alt21=2;
                    }
                    break;
                case PRIVATE:
                    {
                    alt21=3;
                    }
                    break;
                case FRAGMENT:
                    {
                    alt21=4;
                    }
                    break;
            }

            switch (alt21) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:566:5: p1= 'protected'
                    {
                    p1=(Token)match(input,PROTECTED,FOLLOW_PROTECTED_in_rule977); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PROTECTED.add(p1);


                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:567:5: p2= 'public'
                    {
                    p2=(Token)match(input,PUBLIC,FOLLOW_PUBLIC_in_rule986); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PUBLIC.add(p2);


                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:568:5: p3= 'private'
                    {
                    p3=(Token)match(input,PRIVATE,FOLLOW_PRIVATE_in_rule996); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PRIVATE.add(p3);


                    }
                    break;
                case 4 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:569:5: p4= 'fragment'
                    {
                    p4=(Token)match(input,FRAGMENT,FOLLOW_FRAGMENT_in_rule1005); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FRAGMENT.add(p4);


                    }
                    break;

            }

            pushFollow(FOLLOW_id_in_rule1017);
            ruleName=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(ruleName.getTree());
            if ( state.backtracking==0 ) {

              			currentRuleName=(ruleName!=null?input.toString(ruleName.start,ruleName.stop):null);
              			if ( grammarType==Grammar.LEXER && p4==null )
              				grammar.lexerRuleNamesInCombined.add(currentRuleName);
              		
            }
            // org\\antlr\\grammar\\v3\\ANTLR.g:577:3: ( BANG )?
            int alt22=2;
            switch ( input.LA(1) ) {
                case BANG:
                    {
                    alt22=1;
                    }
                    break;
            }

            switch (alt22) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:577:5: BANG
                    {
                    BANG42=(Token)match(input,BANG,FOLLOW_BANG_in_rule1027); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_BANG.add(BANG42);


                    }
                    break;

            }

            // org\\antlr\\grammar\\v3\\ANTLR.g:578:3: (aa= ARG_ACTION )?
            int alt23=2;
            switch ( input.LA(1) ) {
                case ARG_ACTION:
                    {
                    alt23=1;
                    }
                    break;
            }

            switch (alt23) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:578:5: aa= ARG_ACTION
                    {
                    aa=(Token)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rule1038); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ARG_ACTION.add(aa);


                    }
                    break;

            }

            // org\\antlr\\grammar\\v3\\ANTLR.g:579:3: ( 'returns' rt= ARG_ACTION )?
            int alt24=2;
            switch ( input.LA(1) ) {
                case RETURNS:
                    {
                    alt24=1;
                    }
                    break;
            }

            switch (alt24) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:579:5: 'returns' rt= ARG_ACTION
                    {
                    string_literal43=(Token)match(input,RETURNS,FOLLOW_RETURNS_in_rule1047); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RETURNS.add(string_literal43);

                    rt=(Token)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rule1051); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ARG_ACTION.add(rt);


                    }
                    break;

            }

            // org\\antlr\\grammar\\v3\\ANTLR.g:580:3: ( throwsSpec )?
            int alt25=2;
            switch ( input.LA(1) ) {
                case THROWS:
                    {
                    alt25=1;
                    }
                    break;
            }

            switch (alt25) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:580:5: throwsSpec
                    {
                    pushFollow(FOLLOW_throwsSpec_in_rule1061);
                    throwsSpec44=throwsSpec();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_throwsSpec.add(throwsSpec44.getTree());

                    }
                    break;

            }

            // org\\antlr\\grammar\\v3\\ANTLR.g:581:3: ( optionsSpec )?
            int alt26=2;
            switch ( input.LA(1) ) {
                case OPTIONS:
                    {
                    alt26=1;
                    }
                    break;
            }

            switch (alt26) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:581:5: optionsSpec
                    {
                    pushFollow(FOLLOW_optionsSpec_in_rule1070);
                    optionsSpec45=optionsSpec();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_optionsSpec.add(optionsSpec45.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_ruleScopeSpec_in_rule1079);
            scopes=ruleScopeSpec();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_ruleScopeSpec.add(scopes.getTree());
            // org\\antlr\\grammar\\v3\\ANTLR.g:583:3: ( ruleActions )?
            int alt27=2;
            switch ( input.LA(1) ) {
                case AMPERSAND:
                    {
                    alt27=1;
                    }
                    break;
            }

            switch (alt27) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:583:4: ruleActions
                    {
                    pushFollow(FOLLOW_ruleActions_in_rule1084);
                    ruleActions46=ruleActions();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_ruleActions.add(ruleActions46.getTree());

                    }
                    break;

            }

            COLON47=(Token)match(input,COLON,FOLLOW_COLON_in_rule1090); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON47);

            pushFollow(FOLLOW_ruleAltList_in_rule1094);
            ruleAltList48=ruleAltList((optionsSpec45!=null?optionsSpec45.opts:null));

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_ruleAltList.add(ruleAltList48.getTree());
            SEMI49=(Token)match(input,SEMI,FOLLOW_SEMI_in_rule1099); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMI.add(SEMI49);

            // org\\antlr\\grammar\\v3\\ANTLR.g:587:3: (ex= exceptionGroup )?
            int alt28=2;
            switch ( input.LA(1) ) {
                case CATCH:
                case FINALLY:
                    {
                    alt28=1;
                    }
                    break;
            }

            switch (alt28) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:587:5: ex= exceptionGroup
                    {
                    pushFollow(FOLLOW_exceptionGroup_in_rule1107);
                    ex=exceptionGroup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_exceptionGroup.add(ex.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: ruleActions, p3, ex, aa, rt, p2, scopes, p4, ruleName, p1, optionsSpec, ruleAltList, throwsSpec
            // token labels: p4, p3, p2, p1, rt, aa
            // rule labels: scopes, ex, retval, ruleName
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_p4=new RewriteRuleTokenStream(adaptor,"token p4",p4);
            RewriteRuleTokenStream stream_p3=new RewriteRuleTokenStream(adaptor,"token p3",p3);
            RewriteRuleTokenStream stream_p2=new RewriteRuleTokenStream(adaptor,"token p2",p2);
            RewriteRuleTokenStream stream_p1=new RewriteRuleTokenStream(adaptor,"token p1",p1);
            RewriteRuleTokenStream stream_rt=new RewriteRuleTokenStream(adaptor,"token rt",rt);
            RewriteRuleTokenStream stream_aa=new RewriteRuleTokenStream(adaptor,"token aa",aa);
            RewriteRuleSubtreeStream stream_scopes=new RewriteRuleSubtreeStream(adaptor,"rule scopes",scopes!=null?scopes.tree:null);
            RewriteRuleSubtreeStream stream_ex=new RewriteRuleSubtreeStream(adaptor,"rule ex",ex!=null?ex.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_ruleName=new RewriteRuleSubtreeStream(adaptor,"rule ruleName",ruleName!=null?ruleName.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 588:3: -> ^( RULE[$ruleName.start, \"rule\"] $ruleName ( $p1)? ( $p2)? ( $p3)? ( $p4)? ^( ARG[\"ARG\"] ( $aa)? ) ^( RET[\"RET\"] ( $rt)? ) ( throwsSpec )? ( optionsSpec )? $scopes ( ruleActions )? ruleAltList ( $ex)? EOR[$SEMI,\"<end-of-rule>\"] )
            {
                // org\\antlr\\grammar\\v3\\ANTLR.g:588:6: ^( RULE[$ruleName.start, \"rule\"] $ruleName ( $p1)? ( $p2)? ( $p3)? ( $p4)? ^( ARG[\"ARG\"] ( $aa)? ) ^( RET[\"RET\"] ( $rt)? ) ( throwsSpec )? ( optionsSpec )? $scopes ( ruleActions )? ruleAltList ( $ex)? EOR[$SEMI,\"<end-of-rule>\"] )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(RULE, (ruleName!=null?((Token)ruleName.start):null), "rule"), root_1);

                adaptor.addChild(root_1, stream_ruleName.nextTree());
                // org\\antlr\\grammar\\v3\\ANTLR.g:591:5: ( $p1)?
                if ( stream_p1.hasNext() ) {
                    adaptor.addChild(root_1, stream_p1.nextNode());

                }
                stream_p1.reset();
                // org\\antlr\\grammar\\v3\\ANTLR.g:591:10: ( $p2)?
                if ( stream_p2.hasNext() ) {
                    adaptor.addChild(root_1, stream_p2.nextNode());

                }
                stream_p2.reset();
                // org\\antlr\\grammar\\v3\\ANTLR.g:591:15: ( $p3)?
                if ( stream_p3.hasNext() ) {
                    adaptor.addChild(root_1, stream_p3.nextNode());

                }
                stream_p3.reset();
                // org\\antlr\\grammar\\v3\\ANTLR.g:591:20: ( $p4)?
                if ( stream_p4.hasNext() ) {
                    adaptor.addChild(root_1, stream_p4.nextNode());

                }
                stream_p4.reset();
                // org\\antlr\\grammar\\v3\\ANTLR.g:592:5: ^( ARG[\"ARG\"] ( $aa)? )
                {
                GrammarAST root_2 = (GrammarAST)adaptor.nil();
                root_2 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(ARG, "ARG"), root_2);

                // org\\antlr\\grammar\\v3\\ANTLR.g:592:18: ( $aa)?
                if ( stream_aa.hasNext() ) {
                    adaptor.addChild(root_2, stream_aa.nextNode());

                }
                stream_aa.reset();

                adaptor.addChild(root_1, root_2);
                }
                // org\\antlr\\grammar\\v3\\ANTLR.g:593:5: ^( RET[\"RET\"] ( $rt)? )
                {
                GrammarAST root_2 = (GrammarAST)adaptor.nil();
                root_2 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(RET, "RET"), root_2);

                // org\\antlr\\grammar\\v3\\ANTLR.g:593:18: ( $rt)?
                if ( stream_rt.hasNext() ) {
                    adaptor.addChild(root_2, stream_rt.nextNode());

                }
                stream_rt.reset();

                adaptor.addChild(root_1, root_2);
                }
                // org\\antlr\\grammar\\v3\\ANTLR.g:594:5: ( throwsSpec )?
                if ( stream_throwsSpec.hasNext() ) {
                    adaptor.addChild(root_1, stream_throwsSpec.nextTree());

                }
                stream_throwsSpec.reset();
                // org\\antlr\\grammar\\v3\\ANTLR.g:595:5: ( optionsSpec )?
                if ( stream_optionsSpec.hasNext() ) {
                    adaptor.addChild(root_1, stream_optionsSpec.nextTree());

                }
                stream_optionsSpec.reset();
                adaptor.addChild(root_1, stream_scopes.nextTree());
                // org\\antlr\\grammar\\v3\\ANTLR.g:597:5: ( ruleActions )?
                if ( stream_ruleActions.hasNext() ) {
                    adaptor.addChild(root_1, stream_ruleActions.nextTree());

                }
                stream_ruleActions.reset();
                adaptor.addChild(root_1, stream_ruleAltList.nextTree());
                // org\\antlr\\grammar\\v3\\ANTLR.g:599:5: ( $ex)?
                if ( stream_ex.hasNext() ) {
                    adaptor.addChild(root_1, stream_ex.nextTree());

                }
                stream_ex.reset();
                adaptor.addChild(root_1, (GrammarAST)adaptor.create(EOR, SEMI49, "<end-of-rule>"));

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            if ( state.backtracking==0 ) {

              		((GrammarAST)retval.tree).setTreeEnclosingRuleNameDeeply(currentRuleName);
              		((GrammarAST)((GrammarAST)retval.tree).getChild(0)).setBlockOptions((optionsSpec45!=null?optionsSpec45.opts:null));
              	
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rule"

    public static class ruleActions_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ruleActions"
    // org\\antlr\\grammar\\v3\\ANTLR.g:608:1: ruleActions : ( ruleAction )+ ;
    public final ANTLRParser.ruleActions_return ruleActions() throws RecognitionException {
        ANTLRParser.ruleActions_return retval = new ANTLRParser.ruleActions_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        ANTLRParser.ruleAction_return ruleAction50 = null;



        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:609:2: ( ( ruleAction )+ )
            // org\\antlr\\grammar\\v3\\ANTLR.g:609:4: ( ruleAction )+
            {
            root_0 = (GrammarAST)adaptor.nil();

            // org\\antlr\\grammar\\v3\\ANTLR.g:609:4: ( ruleAction )+
            int cnt29=0;
            loop29:
            do {
                int alt29=2;
                switch ( input.LA(1) ) {
                case AMPERSAND:
                    {
                    alt29=1;
                    }
                    break;

                }

                switch (alt29) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\ANTLR.g:609:5: ruleAction
            	    {
            	    pushFollow(FOLLOW_ruleAction_in_ruleActions1245);
            	    ruleAction50=ruleAction();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, ruleAction50.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt29 >= 1 ) break loop29;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(29, input);
                        throw eee;
                }
                cnt29++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ruleActions"

    public static class ruleAction_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ruleAction"
    // org\\antlr\\grammar\\v3\\ANTLR.g:612:1: ruleAction : AMPERSAND id ACTION ;
    public final ANTLRParser.ruleAction_return ruleAction() throws RecognitionException {
        ANTLRParser.ruleAction_return retval = new ANTLRParser.ruleAction_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token AMPERSAND51=null;
        Token ACTION53=null;
        ANTLRParser.id_return id52 = null;


        GrammarAST AMPERSAND51_tree=null;
        GrammarAST ACTION53_tree=null;

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:614:2: ( AMPERSAND id ACTION )
            // org\\antlr\\grammar\\v3\\ANTLR.g:614:4: AMPERSAND id ACTION
            {
            root_0 = (GrammarAST)adaptor.nil();

            AMPERSAND51=(Token)match(input,AMPERSAND,FOLLOW_AMPERSAND_in_ruleAction1260); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            AMPERSAND51_tree = (GrammarAST)adaptor.create(AMPERSAND51);
            root_0 = (GrammarAST)adaptor.becomeRoot(AMPERSAND51_tree, root_0);
            }
            pushFollow(FOLLOW_id_in_ruleAction1263);
            id52=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, id52.getTree());
            ACTION53=(Token)match(input,ACTION,FOLLOW_ACTION_in_ruleAction1265); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ACTION53_tree = (GrammarAST)adaptor.create(ACTION53);
            adaptor.addChild(root_0, ACTION53_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ruleAction"

    public static class throwsSpec_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "throwsSpec"
    // org\\antlr\\grammar\\v3\\ANTLR.g:617:1: throwsSpec : 'throws' id ( COMMA id )* ;
    public final ANTLRParser.throwsSpec_return throwsSpec() throws RecognitionException {
        ANTLRParser.throwsSpec_return retval = new ANTLRParser.throwsSpec_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token string_literal54=null;
        Token COMMA56=null;
        ANTLRParser.id_return id55 = null;

        ANTLRParser.id_return id57 = null;


        GrammarAST string_literal54_tree=null;
        GrammarAST COMMA56_tree=null;

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:618:2: ( 'throws' id ( COMMA id )* )
            // org\\antlr\\grammar\\v3\\ANTLR.g:618:4: 'throws' id ( COMMA id )*
            {
            root_0 = (GrammarAST)adaptor.nil();

            string_literal54=(Token)match(input,THROWS,FOLLOW_THROWS_in_throwsSpec1276); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal54_tree = (GrammarAST)adaptor.create(string_literal54);
            root_0 = (GrammarAST)adaptor.becomeRoot(string_literal54_tree, root_0);
            }
            pushFollow(FOLLOW_id_in_throwsSpec1279);
            id55=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, id55.getTree());
            // org\\antlr\\grammar\\v3\\ANTLR.g:618:17: ( COMMA id )*
            loop30:
            do {
                int alt30=2;
                switch ( input.LA(1) ) {
                case COMMA:
                    {
                    alt30=1;
                    }
                    break;

                }

                switch (alt30) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\ANTLR.g:618:19: COMMA id
            	    {
            	    COMMA56=(Token)match(input,COMMA,FOLLOW_COMMA_in_throwsSpec1283); if (state.failed) return retval;
            	    pushFollow(FOLLOW_id_in_throwsSpec1286);
            	    id57=id();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, id57.getTree());

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "throwsSpec"

    public static class ruleScopeSpec_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ruleScopeSpec"
    // org\\antlr\\grammar\\v3\\ANTLR.g:621:1: ruleScopeSpec : ( 'scope' ( ruleActions )? ACTION )? ( 'scope' idList SEMI )* -> ^( SCOPE[$start,\"scope\"] ( ruleActions )? ( ACTION )? ( idList )* ) ;
    public final ANTLRParser.ruleScopeSpec_return ruleScopeSpec() throws RecognitionException {
        ANTLRParser.ruleScopeSpec_return retval = new ANTLRParser.ruleScopeSpec_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token string_literal58=null;
        Token ACTION60=null;
        Token string_literal61=null;
        Token SEMI63=null;
        ANTLRParser.ruleActions_return ruleActions59 = null;

        ANTLRParser.idList_return idList62 = null;


        GrammarAST string_literal58_tree=null;
        GrammarAST ACTION60_tree=null;
        GrammarAST string_literal61_tree=null;
        GrammarAST SEMI63_tree=null;
        RewriteRuleTokenStream stream_SCOPE=new RewriteRuleTokenStream(adaptor,"token SCOPE");
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleTokenStream stream_ACTION=new RewriteRuleTokenStream(adaptor,"token ACTION");
        RewriteRuleSubtreeStream stream_ruleActions=new RewriteRuleSubtreeStream(adaptor,"rule ruleActions");
        RewriteRuleSubtreeStream stream_idList=new RewriteRuleSubtreeStream(adaptor,"rule idList");
        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:622:2: ( ( 'scope' ( ruleActions )? ACTION )? ( 'scope' idList SEMI )* -> ^( SCOPE[$start,\"scope\"] ( ruleActions )? ( ACTION )? ( idList )* ) )
            // org\\antlr\\grammar\\v3\\ANTLR.g:622:4: ( 'scope' ( ruleActions )? ACTION )? ( 'scope' idList SEMI )*
            {
            // org\\antlr\\grammar\\v3\\ANTLR.g:622:4: ( 'scope' ( ruleActions )? ACTION )?
            int alt32=2;
            switch ( input.LA(1) ) {
                case SCOPE:
                    {
                    switch ( input.LA(2) ) {
                        case ACTION:
                        case AMPERSAND:
                            {
                            alt32=1;
                            }
                            break;
                    }

                    }
                    break;
            }

            switch (alt32) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:622:6: 'scope' ( ruleActions )? ACTION
                    {
                    string_literal58=(Token)match(input,SCOPE,FOLLOW_SCOPE_in_ruleScopeSpec1302); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SCOPE.add(string_literal58);

                    // org\\antlr\\grammar\\v3\\ANTLR.g:622:14: ( ruleActions )?
                    int alt31=2;
                    switch ( input.LA(1) ) {
                        case AMPERSAND:
                            {
                            alt31=1;
                            }
                            break;
                    }

                    switch (alt31) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:622:14: ruleActions
                            {
                            pushFollow(FOLLOW_ruleActions_in_ruleScopeSpec1304);
                            ruleActions59=ruleActions();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_ruleActions.add(ruleActions59.getTree());

                            }
                            break;

                    }

                    ACTION60=(Token)match(input,ACTION,FOLLOW_ACTION_in_ruleScopeSpec1307); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ACTION.add(ACTION60);


                    }
                    break;

            }

            // org\\antlr\\grammar\\v3\\ANTLR.g:623:3: ( 'scope' idList SEMI )*
            loop33:
            do {
                int alt33=2;
                switch ( input.LA(1) ) {
                case SCOPE:
                    {
                    alt33=1;
                    }
                    break;

                }

                switch (alt33) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\ANTLR.g:623:5: 'scope' idList SEMI
            	    {
            	    string_literal61=(Token)match(input,SCOPE,FOLLOW_SCOPE_in_ruleScopeSpec1316); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_SCOPE.add(string_literal61);

            	    pushFollow(FOLLOW_idList_in_ruleScopeSpec1318);
            	    idList62=idList();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_idList.add(idList62.getTree());
            	    SEMI63=(Token)match(input,SEMI,FOLLOW_SEMI_in_ruleScopeSpec1320); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_SEMI.add(SEMI63);


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);



            // AST REWRITE
            // elements: ruleActions, ACTION, idList
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 624:3: -> ^( SCOPE[$start,\"scope\"] ( ruleActions )? ( ACTION )? ( idList )* )
            {
                // org\\antlr\\grammar\\v3\\ANTLR.g:624:6: ^( SCOPE[$start,\"scope\"] ( ruleActions )? ( ACTION )? ( idList )* )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(SCOPE, ((Token)retval.start), "scope"), root_1);

                // org\\antlr\\grammar\\v3\\ANTLR.g:624:30: ( ruleActions )?
                if ( stream_ruleActions.hasNext() ) {
                    adaptor.addChild(root_1, stream_ruleActions.nextTree());

                }
                stream_ruleActions.reset();
                // org\\antlr\\grammar\\v3\\ANTLR.g:624:43: ( ACTION )?
                if ( stream_ACTION.hasNext() ) {
                    adaptor.addChild(root_1, stream_ACTION.nextNode());

                }
                stream_ACTION.reset();
                // org\\antlr\\grammar\\v3\\ANTLR.g:624:51: ( idList )*
                while ( stream_idList.hasNext() ) {
                    adaptor.addChild(root_1, stream_idList.nextTree());

                }
                stream_idList.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ruleScopeSpec"

    public static class ruleAltList_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ruleAltList"
    // org\\antlr\\grammar\\v3\\ANTLR.g:627:1: ruleAltList[Map<String, Object> opts] : ( -> BLOCK[input.LT(-1),\"BLOCK\"] ) (a1= alternative r1= rewrite -> $a1 ( $r1)? ) ( ( OR a2= alternative r2= rewrite -> $ruleAltList $a2 ( $r2)? )+ | ) -> ^( $ruleAltList EOB[\"<end-of-block>\"] ) ;
    public final ANTLRParser.ruleAltList_return ruleAltList(Map<String, Object> opts) throws RecognitionException {
        ANTLRParser.ruleAltList_return retval = new ANTLRParser.ruleAltList_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token OR64=null;
        ANTLRParser.alternative_return a1 = null;

        ANTLRParser.rewrite_return r1 = null;

        ANTLRParser.alternative_return a2 = null;

        ANTLRParser.rewrite_return r2 = null;


        GrammarAST OR64_tree=null;
        RewriteRuleTokenStream stream_OR=new RewriteRuleTokenStream(adaptor,"token OR");
        RewriteRuleSubtreeStream stream_rewrite=new RewriteRuleSubtreeStream(adaptor,"rule rewrite");
        RewriteRuleSubtreeStream stream_alternative=new RewriteRuleSubtreeStream(adaptor,"rule alternative");

        	GrammarAST blkRoot = null;
        	GrammarAST save = currentBlockAST;

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:633:2: ( ( -> BLOCK[input.LT(-1),\"BLOCK\"] ) (a1= alternative r1= rewrite -> $a1 ( $r1)? ) ( ( OR a2= alternative r2= rewrite -> $ruleAltList $a2 ( $r2)? )+ | ) -> ^( $ruleAltList EOB[\"<end-of-block>\"] ) )
            // org\\antlr\\grammar\\v3\\ANTLR.g:633:4: ( -> BLOCK[input.LT(-1),\"BLOCK\"] ) (a1= alternative r1= rewrite -> $a1 ( $r1)? ) ( ( OR a2= alternative r2= rewrite -> $ruleAltList $a2 ( $r2)? )+ | )
            {
            // org\\antlr\\grammar\\v3\\ANTLR.g:633:4: ( -> BLOCK[input.LT(-1),\"BLOCK\"] )
            // org\\antlr\\grammar\\v3\\ANTLR.g:633:6: 
            {

            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 633:6: -> BLOCK[input.LT(-1),\"BLOCK\"]
            {
                adaptor.addChild(root_0, (GrammarAST)adaptor.create(BLOCK, input.LT(-1), "BLOCK"));

            }

            retval.tree = root_0;}
            }

            if ( state.backtracking==0 ) {

              			blkRoot = (GrammarAST)((GrammarAST)retval.tree).getChild(0);
              			blkRoot.setBlockOptions(opts);
              			currentBlockAST = blkRoot;
              		
            }
            // org\\antlr\\grammar\\v3\\ANTLR.g:639:3: (a1= alternative r1= rewrite -> $a1 ( $r1)? )
            // org\\antlr\\grammar\\v3\\ANTLR.g:639:5: a1= alternative r1= rewrite
            {
            pushFollow(FOLLOW_alternative_in_ruleAltList1377);
            a1=alternative();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_alternative.add(a1.getTree());
            pushFollow(FOLLOW_rewrite_in_ruleAltList1381);
            r1=rewrite();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rewrite.add(r1.getTree());
            if ( state.backtracking==0 ) {
              if (LA(1)==OR||(LA(2)==QUESTION||LA(2)==PLUS||LA(2)==STAR)) prefixWithSynPred((a1!=null?((GrammarAST)a1.tree):null));
            }


            // AST REWRITE
            // elements: a1, r1
            // token labels: 
            // rule labels: retval, a1, r1
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_a1=new RewriteRuleSubtreeStream(adaptor,"rule a1",a1!=null?a1.tree:null);
            RewriteRuleSubtreeStream stream_r1=new RewriteRuleSubtreeStream(adaptor,"rule r1",r1!=null?r1.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 641:4: -> $a1 ( $r1)?
            {
                adaptor.addChild(root_0, stream_a1.nextTree());
                // org\\antlr\\grammar\\v3\\ANTLR.g:641:11: ( $r1)?
                if ( stream_r1.hasNext() ) {
                    adaptor.addChild(root_0, stream_r1.nextTree());

                }
                stream_r1.reset();

            }

            retval.tree = root_0;}
            }

            // org\\antlr\\grammar\\v3\\ANTLR.g:643:3: ( ( OR a2= alternative r2= rewrite -> $ruleAltList $a2 ( $r2)? )+ | )
            int alt35=2;
            switch ( input.LA(1) ) {
            case OR:
                {
                alt35=1;
                }
                break;
            case SEMI:
                {
                alt35=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:643:5: ( OR a2= alternative r2= rewrite -> $ruleAltList $a2 ( $r2)? )+
                    {
                    // org\\antlr\\grammar\\v3\\ANTLR.g:643:5: ( OR a2= alternative r2= rewrite -> $ruleAltList $a2 ( $r2)? )+
                    int cnt34=0;
                    loop34:
                    do {
                        int alt34=2;
                        switch ( input.LA(1) ) {
                        case OR:
                            {
                            alt34=1;
                            }
                            break;

                        }

                        switch (alt34) {
                    	case 1 :
                    	    // org\\antlr\\grammar\\v3\\ANTLR.g:643:7: OR a2= alternative r2= rewrite
                    	    {
                    	    OR64=(Token)match(input,OR,FOLLOW_OR_in_ruleAltList1410); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_OR.add(OR64);

                    	    pushFollow(FOLLOW_alternative_in_ruleAltList1414);
                    	    a2=alternative();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_alternative.add(a2.getTree());
                    	    pushFollow(FOLLOW_rewrite_in_ruleAltList1418);
                    	    r2=rewrite();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_rewrite.add(r2.getTree());
                    	    if ( state.backtracking==0 ) {
                    	      if (LA(1)==OR||(LA(2)==QUESTION||LA(2)==PLUS||LA(2)==STAR)) prefixWithSynPred((a2!=null?((GrammarAST)a2.tree):null));
                    	    }


                    	    // AST REWRITE
                    	    // elements: ruleAltList, a2, r2
                    	    // token labels: 
                    	    // rule labels: retval, a2, r2
                    	    // token list labels: 
                    	    // rule list labels: 
                    	    // wildcard labels: 
                    	    if ( state.backtracking==0 ) {
                    	    retval.tree = root_0;
                    	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    	    RewriteRuleSubtreeStream stream_a2=new RewriteRuleSubtreeStream(adaptor,"rule a2",a2!=null?a2.tree:null);
                    	    RewriteRuleSubtreeStream stream_r2=new RewriteRuleSubtreeStream(adaptor,"rule r2",r2!=null?r2.tree:null);

                    	    root_0 = (GrammarAST)adaptor.nil();
                    	    // 645:5: -> $ruleAltList $a2 ( $r2)?
                    	    {
                    	        adaptor.addChild(root_0, stream_retval.nextTree());
                    	        adaptor.addChild(root_0, stream_a2.nextTree());
                    	        // org\\antlr\\grammar\\v3\\ANTLR.g:645:25: ( $r2)?
                    	        if ( stream_r2.hasNext() ) {
                    	            adaptor.addChild(root_0, stream_r2.nextTree());

                    	        }
                    	        stream_r2.reset();

                    	    }

                    	    retval.tree = root_0;}
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt34 >= 1 ) break loop34;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(34, input);
                                throw eee;
                        }
                        cnt34++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:648:3: 
                    {
                    }
                    break;

            }



            // AST REWRITE
            // elements: ruleAltList
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 649:3: -> ^( $ruleAltList EOB[\"<end-of-block>\"] )
            {
                // org\\antlr\\grammar\\v3\\ANTLR.g:649:6: ^( $ruleAltList EOB[\"<end-of-block>\"] )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot(blkRoot, root_1);

                adaptor.addChild(root_1, stream_retval.nextTree());
                adaptor.addChild(root_1, (GrammarAST)adaptor.create(EOB, "<end-of-block>"));

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
             currentBlockAST = save; 
        }
        return retval;
    }
    // $ANTLR end "ruleAltList"

    public static class block_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "block"
    // org\\antlr\\grammar\\v3\\ANTLR.g:653:1: block : (lp= LPAREN -> BLOCK[$lp,\"BLOCK\"] ) ( ( optionsSpec )? ( ruleActions )? COLON | ACTION COLON )? a= alternative r= rewrite ( OR a= alternative r= rewrite )* rp= RPAREN -> ^( $block ( optionsSpec )? ( ruleActions )? ( ACTION )? ( alternative )+ EOB[$rp,\"<end-of-block>\"] ) ;
    public final ANTLRParser.block_return block() throws RecognitionException {
        ANTLRParser.block_return retval = new ANTLRParser.block_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token lp=null;
        Token rp=null;
        Token COLON67=null;
        Token ACTION68=null;
        Token COLON69=null;
        Token OR70=null;
        ANTLRParser.alternative_return a = null;

        ANTLRParser.rewrite_return r = null;

        ANTLRParser.optionsSpec_return optionsSpec65 = null;

        ANTLRParser.ruleActions_return ruleActions66 = null;


        GrammarAST lp_tree=null;
        GrammarAST rp_tree=null;
        GrammarAST COLON67_tree=null;
        GrammarAST ACTION68_tree=null;
        GrammarAST COLON69_tree=null;
        GrammarAST OR70_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_ACTION=new RewriteRuleTokenStream(adaptor,"token ACTION");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleTokenStream stream_OR=new RewriteRuleTokenStream(adaptor,"token OR");
        RewriteRuleSubtreeStream stream_rewrite=new RewriteRuleSubtreeStream(adaptor,"rule rewrite");
        RewriteRuleSubtreeStream stream_alternative=new RewriteRuleSubtreeStream(adaptor,"rule alternative");
        RewriteRuleSubtreeStream stream_optionsSpec=new RewriteRuleSubtreeStream(adaptor,"rule optionsSpec");
        RewriteRuleSubtreeStream stream_ruleActions=new RewriteRuleSubtreeStream(adaptor,"rule ruleActions");

        	GrammarAST save = currentBlockAST;

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:659:2: ( (lp= LPAREN -> BLOCK[$lp,\"BLOCK\"] ) ( ( optionsSpec )? ( ruleActions )? COLON | ACTION COLON )? a= alternative r= rewrite ( OR a= alternative r= rewrite )* rp= RPAREN -> ^( $block ( optionsSpec )? ( ruleActions )? ( ACTION )? ( alternative )+ EOB[$rp,\"<end-of-block>\"] ) )
            // org\\antlr\\grammar\\v3\\ANTLR.g:659:4: (lp= LPAREN -> BLOCK[$lp,\"BLOCK\"] ) ( ( optionsSpec )? ( ruleActions )? COLON | ACTION COLON )? a= alternative r= rewrite ( OR a= alternative r= rewrite )* rp= RPAREN
            {
            // org\\antlr\\grammar\\v3\\ANTLR.g:659:4: (lp= LPAREN -> BLOCK[$lp,\"BLOCK\"] )
            // org\\antlr\\grammar\\v3\\ANTLR.g:659:6: lp= LPAREN
            {
            lp=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_block1494); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(lp);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 660:4: -> BLOCK[$lp,\"BLOCK\"]
            {
                adaptor.addChild(root_0, (GrammarAST)adaptor.create(BLOCK, lp, "BLOCK"));

            }

            retval.tree = root_0;}
            }

            if ( state.backtracking==0 ) {
              currentBlockAST = (GrammarAST)((GrammarAST)retval.tree).getChild(0);
            }
            // org\\antlr\\grammar\\v3\\ANTLR.g:663:3: ( ( optionsSpec )? ( ruleActions )? COLON | ACTION COLON )?
            int alt38=3;
            switch ( input.LA(1) ) {
                case AMPERSAND:
                case COLON:
                case OPTIONS:
                    {
                    alt38=1;
                    }
                    break;
                case ACTION:
                    {
                    switch ( input.LA(2) ) {
                        case COLON:
                            {
                            alt38=2;
                            }
                            break;
                    }

                    }
                    break;
            }

            switch (alt38) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:667:4: ( optionsSpec )? ( ruleActions )? COLON
                    {
                    // org\\antlr\\grammar\\v3\\ANTLR.g:667:4: ( optionsSpec )?
                    int alt36=2;
                    switch ( input.LA(1) ) {
                        case OPTIONS:
                            {
                            alt36=1;
                            }
                            break;
                    }

                    switch (alt36) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:667:5: optionsSpec
                            {
                            pushFollow(FOLLOW_optionsSpec_in_block1532);
                            optionsSpec65=optionsSpec();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_optionsSpec.add(optionsSpec65.getTree());
                            if ( state.backtracking==0 ) {
                              ((GrammarAST)((GrammarAST)retval.tree).getChild(0)).setOptions(grammar,(optionsSpec65!=null?optionsSpec65.opts:null));
                            }

                            }
                            break;

                    }

                    // org\\antlr\\grammar\\v3\\ANTLR.g:668:4: ( ruleActions )?
                    int alt37=2;
                    switch ( input.LA(1) ) {
                        case AMPERSAND:
                            {
                            alt37=1;
                            }
                            break;
                    }

                    switch (alt37) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:668:6: ruleActions
                            {
                            pushFollow(FOLLOW_ruleActions_in_block1543);
                            ruleActions66=ruleActions();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_ruleActions.add(ruleActions66.getTree());

                            }
                            break;

                    }

                    COLON67=(Token)match(input,COLON,FOLLOW_COLON_in_block1551); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON67);


                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:670:5: ACTION COLON
                    {
                    ACTION68=(Token)match(input,ACTION,FOLLOW_ACTION_in_block1557); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ACTION.add(ACTION68);

                    COLON69=(Token)match(input,COLON,FOLLOW_COLON_in_block1559); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON69);


                    }
                    break;

            }

            pushFollow(FOLLOW_alternative_in_block1571);
            a=alternative();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_alternative.add(a.getTree());
            pushFollow(FOLLOW_rewrite_in_block1575);
            r=rewrite();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rewrite.add(r.getTree());
            if ( state.backtracking==0 ) {

              			stream_alternative.add( (r!=null?((GrammarAST)r.tree):null) );
              			if ( LA(1)==OR || (LA(2)==QUESTION||LA(2)==PLUS||LA(2)==STAR) )
              				prefixWithSynPred((a!=null?((GrammarAST)a.tree):null));
              		
            }
            // org\\antlr\\grammar\\v3\\ANTLR.g:679:3: ( OR a= alternative r= rewrite )*
            loop39:
            do {
                int alt39=2;
                switch ( input.LA(1) ) {
                case OR:
                    {
                    alt39=1;
                    }
                    break;

                }

                switch (alt39) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\ANTLR.g:679:5: OR a= alternative r= rewrite
            	    {
            	    OR70=(Token)match(input,OR,FOLLOW_OR_in_block1585); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_OR.add(OR70);

            	    pushFollow(FOLLOW_alternative_in_block1589);
            	    a=alternative();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_alternative.add(a.getTree());
            	    pushFollow(FOLLOW_rewrite_in_block1593);
            	    r=rewrite();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_rewrite.add(r.getTree());
            	    if ( state.backtracking==0 ) {

            	      				stream_alternative.add( (r!=null?((GrammarAST)r.tree):null) );
            	      				if (LA(1)==OR||(LA(2)==QUESTION||LA(2)==PLUS||LA(2)==STAR))
            	      					prefixWithSynPred((a!=null?((GrammarAST)a.tree):null));
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

            rp=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_block1610); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(rp);



            // AST REWRITE
            // elements: block, ACTION, optionsSpec, ruleActions, alternative
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 688:3: -> ^( $block ( optionsSpec )? ( ruleActions )? ( ACTION )? ( alternative )+ EOB[$rp,\"<end-of-block>\"] )
            {
                // org\\antlr\\grammar\\v3\\ANTLR.g:688:6: ^( $block ( optionsSpec )? ( ruleActions )? ( ACTION )? ( alternative )+ EOB[$rp,\"<end-of-block>\"] )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot(stream_retval.nextNode(), root_1);

                // org\\antlr\\grammar\\v3\\ANTLR.g:688:15: ( optionsSpec )?
                if ( stream_optionsSpec.hasNext() ) {
                    adaptor.addChild(root_1, stream_optionsSpec.nextTree());

                }
                stream_optionsSpec.reset();
                // org\\antlr\\grammar\\v3\\ANTLR.g:688:28: ( ruleActions )?
                if ( stream_ruleActions.hasNext() ) {
                    adaptor.addChild(root_1, stream_ruleActions.nextTree());

                }
                stream_ruleActions.reset();
                // org\\antlr\\grammar\\v3\\ANTLR.g:688:41: ( ACTION )?
                if ( stream_ACTION.hasNext() ) {
                    adaptor.addChild(root_1, stream_ACTION.nextNode());

                }
                stream_ACTION.reset();
                if ( !(stream_alternative.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_alternative.hasNext() ) {
                    adaptor.addChild(root_1, stream_alternative.nextTree());

                }
                stream_alternative.reset();
                adaptor.addChild(root_1, (GrammarAST)adaptor.create(EOB, rp, "<end-of-block>"));

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
             currentBlockAST = save; 
        }
        return retval;
    }
    // $ANTLR end "block"

    public static class alternative_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "alternative"
    // org\\antlr\\grammar\\v3\\ANTLR.g:693:1: alternative : ( ( element )+ -> ^( ALT[$start,\"ALT\"] ( element )+ EOA[input.LT(-1),\"<end-of-alt>\"] ) | -> ^( ALT[$start,\"ALT\"] EPSILON[input.LT(-1),\"epsilon\"] EOA[input.LT(-1),\"<end-of-alt>\"] ) );
    public final ANTLRParser.alternative_return alternative() throws RecognitionException {
        ANTLRParser.alternative_return retval = new ANTLRParser.alternative_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        ANTLRParser.element_return element71 = null;


        RewriteRuleSubtreeStream stream_element=new RewriteRuleSubtreeStream(adaptor,"rule element");
        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:694:2: ( ( element )+ -> ^( ALT[$start,\"ALT\"] ( element )+ EOA[input.LT(-1),\"<end-of-alt>\"] ) | -> ^( ALT[$start,\"ALT\"] EPSILON[input.LT(-1),\"epsilon\"] EOA[input.LT(-1),\"<end-of-alt>\"] ) )
            int alt41=2;
            switch ( input.LA(1) ) {
            case FORCED_ACTION:
            case ACTION:
            case STRING_LITERAL:
            case CHAR_LITERAL:
            case TOKEN_REF:
            case LPAREN:
            case SEMPRED:
            case WILDCARD:
            case RULE_REF:
            case NOT:
            case TREE_BEGIN:
                {
                alt41=1;
                }
                break;
            case SEMI:
            case OR:
            case RPAREN:
            case REWRITE:
                {
                alt41=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:694:4: ( element )+
                    {
                    // org\\antlr\\grammar\\v3\\ANTLR.g:694:4: ( element )+
                    int cnt40=0;
                    loop40:
                    do {
                        int alt40=2;
                        switch ( input.LA(1) ) {
                        case FORCED_ACTION:
                        case ACTION:
                        case STRING_LITERAL:
                        case CHAR_LITERAL:
                        case TOKEN_REF:
                        case LPAREN:
                        case SEMPRED:
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
                    	    // org\\antlr\\grammar\\v3\\ANTLR.g:694:4: element
                    	    {
                    	    pushFollow(FOLLOW_element_in_alternative1650);
                    	    element71=element();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_element.add(element71.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt40 >= 1 ) break loop40;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(40, input);
                                throw eee;
                        }
                        cnt40++;
                    } while (true);



                    // AST REWRITE
                    // elements: element
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 695:3: -> ^( ALT[$start,\"ALT\"] ( element )+ EOA[input.LT(-1),\"<end-of-alt>\"] )
                    {
                        // org\\antlr\\grammar\\v3\\ANTLR.g:695:6: ^( ALT[$start,\"ALT\"] ( element )+ EOA[input.LT(-1),\"<end-of-alt>\"] )
                        {
                        GrammarAST root_1 = (GrammarAST)adaptor.nil();
                        root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(ALT, ((Token)retval.start), "ALT"), root_1);

                        if ( !(stream_element.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_element.hasNext() ) {
                            adaptor.addChild(root_1, stream_element.nextTree());

                        }
                        stream_element.reset();
                        adaptor.addChild(root_1, (GrammarAST)adaptor.create(EOA, input.LT(-1), "<end-of-alt>"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:697:3: 
                    {

                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 697:3: -> ^( ALT[$start,\"ALT\"] EPSILON[input.LT(-1),\"epsilon\"] EOA[input.LT(-1),\"<end-of-alt>\"] )
                    {
                        // org\\antlr\\grammar\\v3\\ANTLR.g:697:6: ^( ALT[$start,\"ALT\"] EPSILON[input.LT(-1),\"epsilon\"] EOA[input.LT(-1),\"<end-of-alt>\"] )
                        {
                        GrammarAST root_1 = (GrammarAST)adaptor.nil();
                        root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(ALT, ((Token)retval.start), "ALT"), root_1);

                        adaptor.addChild(root_1, (GrammarAST)adaptor.create(EPSILON, input.LT(-1), "epsilon"));
                        adaptor.addChild(root_1, (GrammarAST)adaptor.create(EOA, input.LT(-1), "<end-of-alt>"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "alternative"

    public static class exceptionGroup_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "exceptionGroup"
    // org\\antlr\\grammar\\v3\\ANTLR.g:700:1: exceptionGroup : ( ( exceptionHandler )+ ( finallyClause )? | finallyClause );
    public final ANTLRParser.exceptionGroup_return exceptionGroup() throws RecognitionException {
        ANTLRParser.exceptionGroup_return retval = new ANTLRParser.exceptionGroup_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        ANTLRParser.exceptionHandler_return exceptionHandler72 = null;

        ANTLRParser.finallyClause_return finallyClause73 = null;

        ANTLRParser.finallyClause_return finallyClause74 = null;



        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:701:2: ( ( exceptionHandler )+ ( finallyClause )? | finallyClause )
            int alt44=2;
            switch ( input.LA(1) ) {
            case CATCH:
                {
                alt44=1;
                }
                break;
            case FINALLY:
                {
                alt44=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:701:4: ( exceptionHandler )+ ( finallyClause )?
                    {
                    root_0 = (GrammarAST)adaptor.nil();

                    // org\\antlr\\grammar\\v3\\ANTLR.g:701:4: ( exceptionHandler )+
                    int cnt42=0;
                    loop42:
                    do {
                        int alt42=2;
                        switch ( input.LA(1) ) {
                        case CATCH:
                            {
                            alt42=1;
                            }
                            break;

                        }

                        switch (alt42) {
                    	case 1 :
                    	    // org\\antlr\\grammar\\v3\\ANTLR.g:701:4: exceptionHandler
                    	    {
                    	    pushFollow(FOLLOW_exceptionHandler_in_exceptionGroup1696);
                    	    exceptionHandler72=exceptionHandler();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, exceptionHandler72.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt42 >= 1 ) break loop42;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(42, input);
                                throw eee;
                        }
                        cnt42++;
                    } while (true);

                    // org\\antlr\\grammar\\v3\\ANTLR.g:701:22: ( finallyClause )?
                    int alt43=2;
                    switch ( input.LA(1) ) {
                        case FINALLY:
                            {
                            alt43=1;
                            }
                            break;
                    }

                    switch (alt43) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:701:22: finallyClause
                            {
                            pushFollow(FOLLOW_finallyClause_in_exceptionGroup1699);
                            finallyClause73=finallyClause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, finallyClause73.getTree());

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:702:4: finallyClause
                    {
                    root_0 = (GrammarAST)adaptor.nil();

                    pushFollow(FOLLOW_finallyClause_in_exceptionGroup1705);
                    finallyClause74=finallyClause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, finallyClause74.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "exceptionGroup"

    public static class exceptionHandler_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "exceptionHandler"
    // org\\antlr\\grammar\\v3\\ANTLR.g:705:1: exceptionHandler : 'catch' ARG_ACTION ACTION ;
    public final ANTLRParser.exceptionHandler_return exceptionHandler() throws RecognitionException {
        ANTLRParser.exceptionHandler_return retval = new ANTLRParser.exceptionHandler_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token string_literal75=null;
        Token ARG_ACTION76=null;
        Token ACTION77=null;

        GrammarAST string_literal75_tree=null;
        GrammarAST ARG_ACTION76_tree=null;
        GrammarAST ACTION77_tree=null;

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:706:2: ( 'catch' ARG_ACTION ACTION )
            // org\\antlr\\grammar\\v3\\ANTLR.g:706:4: 'catch' ARG_ACTION ACTION
            {
            root_0 = (GrammarAST)adaptor.nil();

            string_literal75=(Token)match(input,CATCH,FOLLOW_CATCH_in_exceptionHandler1716); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal75_tree = (GrammarAST)adaptor.create(string_literal75);
            root_0 = (GrammarAST)adaptor.becomeRoot(string_literal75_tree, root_0);
            }
            ARG_ACTION76=(Token)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_exceptionHandler1719); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ARG_ACTION76_tree = (GrammarAST)adaptor.create(ARG_ACTION76);
            adaptor.addChild(root_0, ARG_ACTION76_tree);
            }
            ACTION77=(Token)match(input,ACTION,FOLLOW_ACTION_in_exceptionHandler1721); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ACTION77_tree = (GrammarAST)adaptor.create(ACTION77);
            adaptor.addChild(root_0, ACTION77_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "exceptionHandler"

    public static class finallyClause_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "finallyClause"
    // org\\antlr\\grammar\\v3\\ANTLR.g:709:1: finallyClause : 'finally' ACTION ;
    public final ANTLRParser.finallyClause_return finallyClause() throws RecognitionException {
        ANTLRParser.finallyClause_return retval = new ANTLRParser.finallyClause_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token string_literal78=null;
        Token ACTION79=null;

        GrammarAST string_literal78_tree=null;
        GrammarAST ACTION79_tree=null;

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:710:2: ( 'finally' ACTION )
            // org\\antlr\\grammar\\v3\\ANTLR.g:710:4: 'finally' ACTION
            {
            root_0 = (GrammarAST)adaptor.nil();

            string_literal78=(Token)match(input,FINALLY,FOLLOW_FINALLY_in_finallyClause1732); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal78_tree = (GrammarAST)adaptor.create(string_literal78);
            root_0 = (GrammarAST)adaptor.becomeRoot(string_literal78_tree, root_0);
            }
            ACTION79=(Token)match(input,ACTION,FOLLOW_ACTION_in_finallyClause1735); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ACTION79_tree = (GrammarAST)adaptor.create(ACTION79);
            adaptor.addChild(root_0, ACTION79_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "finallyClause"

    public static class element_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "element"
    // org\\antlr\\grammar\\v3\\ANTLR.g:713:1: element : elementNoOptionSpec ;
    public final ANTLRParser.element_return element() throws RecognitionException {
        ANTLRParser.element_return retval = new ANTLRParser.element_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        ANTLRParser.elementNoOptionSpec_return elementNoOptionSpec80 = null;



        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:714:2: ( elementNoOptionSpec )
            // org\\antlr\\grammar\\v3\\ANTLR.g:714:4: elementNoOptionSpec
            {
            root_0 = (GrammarAST)adaptor.nil();

            pushFollow(FOLLOW_elementNoOptionSpec_in_element1746);
            elementNoOptionSpec80=elementNoOptionSpec();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementNoOptionSpec80.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "element"

    public static class elementNoOptionSpec_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementNoOptionSpec"
    // org\\antlr\\grammar\\v3\\ANTLR.g:717:1: elementNoOptionSpec : ( ( id ( ASSIGN | PLUS_ASSIGN ) ( atom | block ) ) (sub= ebnfSuffix[root_0,false] )? | a= atom (sub2= ebnfSuffix[$a.tree,false] )? | ebnf | FORCED_ACTION | ACTION | p= SEMPRED ( IMPLIES )? | t3= tree_ ) ;
    public final ANTLRParser.elementNoOptionSpec_return elementNoOptionSpec() throws RecognitionException {
        ANTLRParser.elementNoOptionSpec_return retval = new ANTLRParser.elementNoOptionSpec_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token p=null;
        Token ASSIGN82=null;
        Token PLUS_ASSIGN83=null;
        Token FORCED_ACTION87=null;
        Token ACTION88=null;
        Token IMPLIES89=null;
        ANTLRParser.ebnfSuffix_return sub = null;

        ANTLRParser.atom_return a = null;

        ANTLRParser.ebnfSuffix_return sub2 = null;

        ANTLRParser.tree__return t3 = null;

        ANTLRParser.id_return id81 = null;

        ANTLRParser.atom_return atom84 = null;

        ANTLRParser.block_return block85 = null;

        ANTLRParser.ebnf_return ebnf86 = null;


        GrammarAST p_tree=null;
        GrammarAST ASSIGN82_tree=null;
        GrammarAST PLUS_ASSIGN83_tree=null;
        GrammarAST FORCED_ACTION87_tree=null;
        GrammarAST ACTION88_tree=null;
        GrammarAST IMPLIES89_tree=null;


        	IntSet elements=null;

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:722:2: ( ( ( id ( ASSIGN | PLUS_ASSIGN ) ( atom | block ) ) (sub= ebnfSuffix[root_0,false] )? | a= atom (sub2= ebnfSuffix[$a.tree,false] )? | ebnf | FORCED_ACTION | ACTION | p= SEMPRED ( IMPLIES )? | t3= tree_ ) )
            // org\\antlr\\grammar\\v3\\ANTLR.g:722:4: ( ( id ( ASSIGN | PLUS_ASSIGN ) ( atom | block ) ) (sub= ebnfSuffix[root_0,false] )? | a= atom (sub2= ebnfSuffix[$a.tree,false] )? | ebnf | FORCED_ACTION | ACTION | p= SEMPRED ( IMPLIES )? | t3= tree_ )
            {
            root_0 = (GrammarAST)adaptor.nil();

            // org\\antlr\\grammar\\v3\\ANTLR.g:722:4: ( ( id ( ASSIGN | PLUS_ASSIGN ) ( atom | block ) ) (sub= ebnfSuffix[root_0,false] )? | a= atom (sub2= ebnfSuffix[$a.tree,false] )? | ebnf | FORCED_ACTION | ACTION | p= SEMPRED ( IMPLIES )? | t3= tree_ )
            int alt50=7;
            alt50 = dfa50.predict(input);
            switch (alt50) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:722:6: ( id ( ASSIGN | PLUS_ASSIGN ) ( atom | block ) ) (sub= ebnfSuffix[root_0,false] )?
                    {
                    // org\\antlr\\grammar\\v3\\ANTLR.g:722:6: ( id ( ASSIGN | PLUS_ASSIGN ) ( atom | block ) )
                    // org\\antlr\\grammar\\v3\\ANTLR.g:722:8: id ( ASSIGN | PLUS_ASSIGN ) ( atom | block )
                    {
                    pushFollow(FOLLOW_id_in_elementNoOptionSpec1766);
                    id81=id();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, id81.getTree());
                    // org\\antlr\\grammar\\v3\\ANTLR.g:722:11: ( ASSIGN | PLUS_ASSIGN )
                    int alt45=2;
                    switch ( input.LA(1) ) {
                    case ASSIGN:
                        {
                        alt45=1;
                        }
                        break;
                    case PLUS_ASSIGN:
                        {
                        alt45=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 45, 0, input);

                        throw nvae;
                    }

                    switch (alt45) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:722:12: ASSIGN
                            {
                            ASSIGN82=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_elementNoOptionSpec1769); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASSIGN82_tree = (GrammarAST)adaptor.create(ASSIGN82);
                            root_0 = (GrammarAST)adaptor.becomeRoot(ASSIGN82_tree, root_0);
                            }

                            }
                            break;
                        case 2 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:722:20: PLUS_ASSIGN
                            {
                            PLUS_ASSIGN83=(Token)match(input,PLUS_ASSIGN,FOLLOW_PLUS_ASSIGN_in_elementNoOptionSpec1772); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            PLUS_ASSIGN83_tree = (GrammarAST)adaptor.create(PLUS_ASSIGN83);
                            root_0 = (GrammarAST)adaptor.becomeRoot(PLUS_ASSIGN83_tree, root_0);
                            }

                            }
                            break;

                    }

                    // org\\antlr\\grammar\\v3\\ANTLR.g:722:34: ( atom | block )
                    int alt46=2;
                    switch ( input.LA(1) ) {
                    case STRING_LITERAL:
                    case CHAR_LITERAL:
                    case TOKEN_REF:
                    case WILDCARD:
                    case RULE_REF:
                    case NOT:
                        {
                        alt46=1;
                        }
                        break;
                    case LPAREN:
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
                            // org\\antlr\\grammar\\v3\\ANTLR.g:722:35: atom
                            {
                            pushFollow(FOLLOW_atom_in_elementNoOptionSpec1777);
                            atom84=atom();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, atom84.getTree());

                            }
                            break;
                        case 2 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:722:40: block
                            {
                            pushFollow(FOLLOW_block_in_elementNoOptionSpec1779);
                            block85=block();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, block85.getTree());

                            }
                            break;

                    }


                    }

                    // org\\antlr\\grammar\\v3\\ANTLR.g:724:4: (sub= ebnfSuffix[root_0,false] )?
                    int alt47=2;
                    switch ( input.LA(1) ) {
                        case STAR:
                        case QUESTION:
                        case PLUS:
                            {
                            alt47=1;
                            }
                            break;
                    }

                    switch (alt47) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:724:6: sub= ebnfSuffix[root_0,false]
                            {
                            pushFollow(FOLLOW_ebnfSuffix_in_elementNoOptionSpec1794);
                            sub=ebnfSuffix(root_0, false);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                              root_0 = (sub!=null?((GrammarAST)sub.tree):null);
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:726:5: a= atom (sub2= ebnfSuffix[$a.tree,false] )?
                    {
                    pushFollow(FOLLOW_atom_in_elementNoOptionSpec1812);
                    a=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, a.getTree());
                    // org\\antlr\\grammar\\v3\\ANTLR.g:727:4: (sub2= ebnfSuffix[$a.tree,false] )?
                    int alt48=2;
                    switch ( input.LA(1) ) {
                        case STAR:
                        case QUESTION:
                        case PLUS:
                            {
                            alt48=1;
                            }
                            break;
                    }

                    switch (alt48) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:727:6: sub2= ebnfSuffix[$a.tree,false]
                            {
                            pushFollow(FOLLOW_ebnfSuffix_in_elementNoOptionSpec1821);
                            sub2=ebnfSuffix((a!=null?((GrammarAST)a.tree):null), false);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                              root_0=(sub2!=null?((GrammarAST)sub2.tree):null);
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:729:5: ebnf
                    {
                    pushFollow(FOLLOW_ebnf_in_elementNoOptionSpec1837);
                    ebnf86=ebnf();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ebnf86.getTree());

                    }
                    break;
                case 4 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:730:5: FORCED_ACTION
                    {
                    FORCED_ACTION87=(Token)match(input,FORCED_ACTION,FOLLOW_FORCED_ACTION_in_elementNoOptionSpec1843); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FORCED_ACTION87_tree = (GrammarAST)adaptor.create(FORCED_ACTION87);
                    adaptor.addChild(root_0, FORCED_ACTION87_tree);
                    }

                    }
                    break;
                case 5 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:731:5: ACTION
                    {
                    ACTION88=(Token)match(input,ACTION,FOLLOW_ACTION_in_elementNoOptionSpec1849); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ACTION88_tree = (GrammarAST)adaptor.create(ACTION88);
                    adaptor.addChild(root_0, ACTION88_tree);
                    }

                    }
                    break;
                case 6 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:732:5: p= SEMPRED ( IMPLIES )?
                    {
                    p=(Token)match(input,SEMPRED,FOLLOW_SEMPRED_in_elementNoOptionSpec1857); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    p_tree = (GrammarAST)adaptor.create(p);
                    adaptor.addChild(root_0, p_tree);
                    }
                    // org\\antlr\\grammar\\v3\\ANTLR.g:732:15: ( IMPLIES )?
                    int alt49=2;
                    switch ( input.LA(1) ) {
                        case IMPLIES:
                            {
                            alt49=1;
                            }
                            break;
                    }

                    switch (alt49) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:732:17: IMPLIES
                            {
                            IMPLIES89=(Token)match(input,IMPLIES,FOLLOW_IMPLIES_in_elementNoOptionSpec1861); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                              p.setType(GATED_SEMPRED);
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      			grammar.blocksWithSemPreds.add(currentBlockAST);
                      			
                    }

                    }
                    break;
                case 7 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:736:5: t3= tree_
                    {
                    pushFollow(FOLLOW_tree__in_elementNoOptionSpec1880);
                    t3=tree_();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t3.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "elementNoOptionSpec"

    public static class atom_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atom"
    // org\\antlr\\grammar\\v3\\ANTLR.g:740:1: atom : ( range ( ROOT | BANG )? | ( ({...}? id WILDCARD ( terminal | ruleref ) )=> id w= WILDCARD ( terminal | ruleref ) | terminal | ruleref ) | notSet ( ROOT | BANG )? );
    public final ANTLRParser.atom_return atom() throws RecognitionException {
        ANTLRParser.atom_return retval = new ANTLRParser.atom_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token w=null;
        Token ROOT91=null;
        Token BANG92=null;
        Token ROOT99=null;
        Token BANG100=null;
        ANTLRParser.range_return range90 = null;

        ANTLRParser.id_return id93 = null;

        ANTLRParser.terminal_return terminal94 = null;

        ANTLRParser.ruleref_return ruleref95 = null;

        ANTLRParser.terminal_return terminal96 = null;

        ANTLRParser.ruleref_return ruleref97 = null;

        ANTLRParser.notSet_return notSet98 = null;


        GrammarAST w_tree=null;
        GrammarAST ROOT91_tree=null;
        GrammarAST BANG92_tree=null;
        GrammarAST ROOT99_tree=null;
        GrammarAST BANG100_tree=null;

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:741:2: ( range ( ROOT | BANG )? | ( ({...}? id WILDCARD ( terminal | ruleref ) )=> id w= WILDCARD ( terminal | ruleref ) | terminal | ruleref ) | notSet ( ROOT | BANG )? )
            int alt55=3;
            switch ( input.LA(1) ) {
            case CHAR_LITERAL:
                {
                switch ( input.LA(2) ) {
                case RANGE:
                    {
                    alt55=1;
                    }
                    break;
                case FORCED_ACTION:
                case ACTION:
                case SEMI:
                case STRING_LITERAL:
                case CHAR_LITERAL:
                case STAR:
                case TOKEN_REF:
                case BANG:
                case OR:
                case LPAREN:
                case RPAREN:
                case SEMPRED:
                case ROOT:
                case WILDCARD:
                case RULE_REF:
                case NOT:
                case TREE_BEGIN:
                case QUESTION:
                case PLUS:
                case OPEN_ELEMENT_OPTION:
                case REWRITE:
                    {
                    alt55=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 55, 1, input);

                    throw nvae;
                }

                }
                break;
            case STRING_LITERAL:
            case TOKEN_REF:
            case WILDCARD:
            case RULE_REF:
                {
                alt55=2;
                }
                break;
            case NOT:
                {
                alt55=3;
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
                    // org\\antlr\\grammar\\v3\\ANTLR.g:741:4: range ( ROOT | BANG )?
                    {
                    root_0 = (GrammarAST)adaptor.nil();

                    pushFollow(FOLLOW_range_in_atom1895);
                    range90=range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, range90.getTree());
                    // org\\antlr\\grammar\\v3\\ANTLR.g:741:10: ( ROOT | BANG )?
                    int alt51=3;
                    switch ( input.LA(1) ) {
                        case ROOT:
                            {
                            alt51=1;
                            }
                            break;
                        case BANG:
                            {
                            alt51=2;
                            }
                            break;
                    }

                    switch (alt51) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:741:11: ROOT
                            {
                            ROOT91=(Token)match(input,ROOT,FOLLOW_ROOT_in_atom1898); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ROOT91_tree = (GrammarAST)adaptor.create(ROOT91);
                            root_0 = (GrammarAST)adaptor.becomeRoot(ROOT91_tree, root_0);
                            }

                            }
                            break;
                        case 2 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:741:17: BANG
                            {
                            BANG92=(Token)match(input,BANG,FOLLOW_BANG_in_atom1901); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            BANG92_tree = (GrammarAST)adaptor.create(BANG92);
                            root_0 = (GrammarAST)adaptor.becomeRoot(BANG92_tree, root_0);
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:742:4: ( ({...}? id WILDCARD ( terminal | ruleref ) )=> id w= WILDCARD ( terminal | ruleref ) | terminal | ruleref )
                    {
                    root_0 = (GrammarAST)adaptor.nil();

                    // org\\antlr\\grammar\\v3\\ANTLR.g:742:4: ( ({...}? id WILDCARD ( terminal | ruleref ) )=> id w= WILDCARD ( terminal | ruleref ) | terminal | ruleref )
                    int alt53=3;
                    alt53 = dfa53.predict(input);
                    switch (alt53) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:745:4: ({...}? id WILDCARD ( terminal | ruleref ) )=> id w= WILDCARD ( terminal | ruleref )
                            {
                            pushFollow(FOLLOW_id_in_atom1941);
                            id93=id();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, id93.getTree());
                            w=(Token)match(input,WILDCARD,FOLLOW_WILDCARD_in_atom1945); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            w_tree = (GrammarAST)adaptor.create(w);
                            root_0 = (GrammarAST)adaptor.becomeRoot(w_tree, root_0);
                            }
                            // org\\antlr\\grammar\\v3\\ANTLR.g:747:19: ( terminal | ruleref )
                            int alt52=2;
                            switch ( input.LA(1) ) {
                            case STRING_LITERAL:
                            case CHAR_LITERAL:
                            case TOKEN_REF:
                            case WILDCARD:
                                {
                                alt52=1;
                                }
                                break;
                            case RULE_REF:
                                {
                                alt52=2;
                                }
                                break;
                            default:
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 52, 0, input);

                                throw nvae;
                            }

                            switch (alt52) {
                                case 1 :
                                    // org\\antlr\\grammar\\v3\\ANTLR.g:747:20: terminal
                                    {
                                    pushFollow(FOLLOW_terminal_in_atom1949);
                                    terminal94=terminal();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) adaptor.addChild(root_0, terminal94.getTree());

                                    }
                                    break;
                                case 2 :
                                    // org\\antlr\\grammar\\v3\\ANTLR.g:747:29: ruleref
                                    {
                                    pushFollow(FOLLOW_ruleref_in_atom1951);
                                    ruleref95=ruleref();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ruleref95.getTree());

                                    }
                                    break;

                            }

                            if ( state.backtracking==0 ) {
                              w.setType(DOT);
                            }

                            }
                            break;
                        case 2 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:748:5: terminal
                            {
                            pushFollow(FOLLOW_terminal_in_atom1960);
                            terminal96=terminal();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, terminal96.getTree());

                            }
                            break;
                        case 3 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:749:5: ruleref
                            {
                            pushFollow(FOLLOW_ruleref_in_atom1966);
                            ruleref97=ruleref();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, ruleref97.getTree());

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:751:4: notSet ( ROOT | BANG )?
                    {
                    root_0 = (GrammarAST)adaptor.nil();

                    pushFollow(FOLLOW_notSet_in_atom1975);
                    notSet98=notSet();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, notSet98.getTree());
                    // org\\antlr\\grammar\\v3\\ANTLR.g:751:11: ( ROOT | BANG )?
                    int alt54=3;
                    switch ( input.LA(1) ) {
                        case ROOT:
                            {
                            alt54=1;
                            }
                            break;
                        case BANG:
                            {
                            alt54=2;
                            }
                            break;
                    }

                    switch (alt54) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:751:12: ROOT
                            {
                            ROOT99=(Token)match(input,ROOT,FOLLOW_ROOT_in_atom1978); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ROOT99_tree = (GrammarAST)adaptor.create(ROOT99);
                            root_0 = (GrammarAST)adaptor.becomeRoot(ROOT99_tree, root_0);
                            }

                            }
                            break;
                        case 2 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:751:18: BANG
                            {
                            BANG100=(Token)match(input,BANG,FOLLOW_BANG_in_atom1981); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            BANG100_tree = (GrammarAST)adaptor.create(BANG100);
                            root_0 = (GrammarAST)adaptor.becomeRoot(BANG100_tree, root_0);
                            }

                            }
                            break;

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "atom"

    public static class ruleref_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ruleref"
    // org\\antlr\\grammar\\v3\\ANTLR.g:754:1: ruleref : RULE_REF ( ARG_ACTION )? ( ROOT | BANG )? ;
    public final ANTLRParser.ruleref_return ruleref() throws RecognitionException {
        ANTLRParser.ruleref_return retval = new ANTLRParser.ruleref_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token RULE_REF101=null;
        Token ARG_ACTION102=null;
        Token ROOT103=null;
        Token BANG104=null;

        GrammarAST RULE_REF101_tree=null;
        GrammarAST ARG_ACTION102_tree=null;
        GrammarAST ROOT103_tree=null;
        GrammarAST BANG104_tree=null;

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:755:2: ( RULE_REF ( ARG_ACTION )? ( ROOT | BANG )? )
            // org\\antlr\\grammar\\v3\\ANTLR.g:755:4: RULE_REF ( ARG_ACTION )? ( ROOT | BANG )?
            {
            root_0 = (GrammarAST)adaptor.nil();

            RULE_REF101=(Token)match(input,RULE_REF,FOLLOW_RULE_REF_in_ruleref1995); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RULE_REF101_tree = (GrammarAST)adaptor.create(RULE_REF101);
            root_0 = (GrammarAST)adaptor.becomeRoot(RULE_REF101_tree, root_0);
            }
            // org\\antlr\\grammar\\v3\\ANTLR.g:755:14: ( ARG_ACTION )?
            int alt56=2;
            switch ( input.LA(1) ) {
                case ARG_ACTION:
                    {
                    alt56=1;
                    }
                    break;
            }

            switch (alt56) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:755:14: ARG_ACTION
                    {
                    ARG_ACTION102=(Token)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_ruleref1998); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ARG_ACTION102_tree = (GrammarAST)adaptor.create(ARG_ACTION102);
                    adaptor.addChild(root_0, ARG_ACTION102_tree);
                    }

                    }
                    break;

            }

            // org\\antlr\\grammar\\v3\\ANTLR.g:755:26: ( ROOT | BANG )?
            int alt57=3;
            switch ( input.LA(1) ) {
                case ROOT:
                    {
                    alt57=1;
                    }
                    break;
                case BANG:
                    {
                    alt57=2;
                    }
                    break;
            }

            switch (alt57) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:755:27: ROOT
                    {
                    ROOT103=(Token)match(input,ROOT,FOLLOW_ROOT_in_ruleref2002); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ROOT103_tree = (GrammarAST)adaptor.create(ROOT103);
                    root_0 = (GrammarAST)adaptor.becomeRoot(ROOT103_tree, root_0);
                    }

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:755:33: BANG
                    {
                    BANG104=(Token)match(input,BANG,FOLLOW_BANG_in_ruleref2005); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BANG104_tree = (GrammarAST)adaptor.create(BANG104);
                    root_0 = (GrammarAST)adaptor.becomeRoot(BANG104_tree, root_0);
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ruleref"

    public static class notSet_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "notSet"
    // org\\antlr\\grammar\\v3\\ANTLR.g:758:1: notSet : NOT ( notTerminal | block ) ;
    public final ANTLRParser.notSet_return notSet() throws RecognitionException {
        ANTLRParser.notSet_return retval = new ANTLRParser.notSet_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token NOT105=null;
        ANTLRParser.notTerminal_return notTerminal106 = null;

        ANTLRParser.block_return block107 = null;


        GrammarAST NOT105_tree=null;

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:759:2: ( NOT ( notTerminal | block ) )
            // org\\antlr\\grammar\\v3\\ANTLR.g:759:4: NOT ( notTerminal | block )
            {
            root_0 = (GrammarAST)adaptor.nil();

            NOT105=(Token)match(input,NOT,FOLLOW_NOT_in_notSet2019); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NOT105_tree = (GrammarAST)adaptor.create(NOT105);
            root_0 = (GrammarAST)adaptor.becomeRoot(NOT105_tree, root_0);
            }
            // org\\antlr\\grammar\\v3\\ANTLR.g:760:3: ( notTerminal | block )
            int alt58=2;
            switch ( input.LA(1) ) {
            case STRING_LITERAL:
            case CHAR_LITERAL:
            case TOKEN_REF:
                {
                alt58=1;
                }
                break;
            case LPAREN:
                {
                alt58=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }

            switch (alt58) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:760:5: notTerminal
                    {
                    pushFollow(FOLLOW_notTerminal_in_notSet2026);
                    notTerminal106=notTerminal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, notTerminal106.getTree());

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:761:5: block
                    {
                    pushFollow(FOLLOW_block_in_notSet2032);
                    block107=block();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, block107.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "notSet"

    public static class treeRoot_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "treeRoot"
    // org\\antlr\\grammar\\v3\\ANTLR.g:765:1: treeRoot : ( id ( ASSIGN | PLUS_ASSIGN ) ( atom | block ) | atom | block );
    public final ANTLRParser.treeRoot_return treeRoot() throws RecognitionException {
        ANTLRParser.treeRoot_return retval = new ANTLRParser.treeRoot_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token ASSIGN109=null;
        Token PLUS_ASSIGN110=null;
        ANTLRParser.id_return id108 = null;

        ANTLRParser.atom_return atom111 = null;

        ANTLRParser.block_return block112 = null;

        ANTLRParser.atom_return atom113 = null;

        ANTLRParser.block_return block114 = null;


        GrammarAST ASSIGN109_tree=null;
        GrammarAST PLUS_ASSIGN110_tree=null;

        atTreeRoot=true;
        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:768:2: ( id ( ASSIGN | PLUS_ASSIGN ) ( atom | block ) | atom | block )
            int alt61=3;
            switch ( input.LA(1) ) {
            case TOKEN_REF:
                {
                switch ( input.LA(2) ) {
                case ASSIGN:
                case PLUS_ASSIGN:
                    {
                    alt61=1;
                    }
                    break;
                case FORCED_ACTION:
                case ACTION:
                case STRING_LITERAL:
                case CHAR_LITERAL:
                case TOKEN_REF:
                case BANG:
                case ARG_ACTION:
                case LPAREN:
                case SEMPRED:
                case ROOT:
                case WILDCARD:
                case RULE_REF:
                case NOT:
                case TREE_BEGIN:
                case OPEN_ELEMENT_OPTION:
                    {
                    alt61=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 61, 1, input);

                    throw nvae;
                }

                }
                break;
            case RULE_REF:
                {
                switch ( input.LA(2) ) {
                case ASSIGN:
                case PLUS_ASSIGN:
                    {
                    alt61=1;
                    }
                    break;
                case FORCED_ACTION:
                case ACTION:
                case STRING_LITERAL:
                case CHAR_LITERAL:
                case TOKEN_REF:
                case BANG:
                case ARG_ACTION:
                case LPAREN:
                case SEMPRED:
                case ROOT:
                case WILDCARD:
                case RULE_REF:
                case NOT:
                case TREE_BEGIN:
                    {
                    alt61=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 61, 2, input);

                    throw nvae;
                }

                }
                break;
            case STRING_LITERAL:
            case CHAR_LITERAL:
            case WILDCARD:
            case NOT:
                {
                alt61=2;
                }
                break;
            case LPAREN:
                {
                alt61=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }

            switch (alt61) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:768:4: id ( ASSIGN | PLUS_ASSIGN ) ( atom | block )
                    {
                    root_0 = (GrammarAST)adaptor.nil();

                    pushFollow(FOLLOW_id_in_treeRoot2055);
                    id108=id();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, id108.getTree());
                    // org\\antlr\\grammar\\v3\\ANTLR.g:768:7: ( ASSIGN | PLUS_ASSIGN )
                    int alt59=2;
                    switch ( input.LA(1) ) {
                    case ASSIGN:
                        {
                        alt59=1;
                        }
                        break;
                    case PLUS_ASSIGN:
                        {
                        alt59=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 59, 0, input);

                        throw nvae;
                    }

                    switch (alt59) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:768:8: ASSIGN
                            {
                            ASSIGN109=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_treeRoot2058); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASSIGN109_tree = (GrammarAST)adaptor.create(ASSIGN109);
                            root_0 = (GrammarAST)adaptor.becomeRoot(ASSIGN109_tree, root_0);
                            }

                            }
                            break;
                        case 2 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:768:16: PLUS_ASSIGN
                            {
                            PLUS_ASSIGN110=(Token)match(input,PLUS_ASSIGN,FOLLOW_PLUS_ASSIGN_in_treeRoot2061); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            PLUS_ASSIGN110_tree = (GrammarAST)adaptor.create(PLUS_ASSIGN110);
                            root_0 = (GrammarAST)adaptor.becomeRoot(PLUS_ASSIGN110_tree, root_0);
                            }

                            }
                            break;

                    }

                    // org\\antlr\\grammar\\v3\\ANTLR.g:768:30: ( atom | block )
                    int alt60=2;
                    switch ( input.LA(1) ) {
                    case STRING_LITERAL:
                    case CHAR_LITERAL:
                    case TOKEN_REF:
                    case WILDCARD:
                    case RULE_REF:
                    case NOT:
                        {
                        alt60=1;
                        }
                        break;
                    case LPAREN:
                        {
                        alt60=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 60, 0, input);

                        throw nvae;
                    }

                    switch (alt60) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:768:31: atom
                            {
                            pushFollow(FOLLOW_atom_in_treeRoot2066);
                            atom111=atom();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, atom111.getTree());

                            }
                            break;
                        case 2 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:768:36: block
                            {
                            pushFollow(FOLLOW_block_in_treeRoot2068);
                            block112=block();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, block112.getTree());

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:769:4: atom
                    {
                    root_0 = (GrammarAST)adaptor.nil();

                    pushFollow(FOLLOW_atom_in_treeRoot2074);
                    atom113=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, atom113.getTree());

                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:770:4: block
                    {
                    root_0 = (GrammarAST)adaptor.nil();

                    pushFollow(FOLLOW_block_in_treeRoot2079);
                    block114=block();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, block114.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              atTreeRoot=false;
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "treeRoot"

    public static class tree__return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "tree_"
    // org\\antlr\\grammar\\v3\\ANTLR.g:773:1: tree_ : TREE_BEGIN treeRoot ( element )+ RPAREN ;
    public final ANTLRParser.tree__return tree_() throws RecognitionException {
        ANTLRParser.tree__return retval = new ANTLRParser.tree__return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token TREE_BEGIN115=null;
        Token RPAREN118=null;
        ANTLRParser.treeRoot_return treeRoot116 = null;

        ANTLRParser.element_return element117 = null;


        GrammarAST TREE_BEGIN115_tree=null;
        GrammarAST RPAREN118_tree=null;

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:774:2: ( TREE_BEGIN treeRoot ( element )+ RPAREN )
            // org\\antlr\\grammar\\v3\\ANTLR.g:774:4: TREE_BEGIN treeRoot ( element )+ RPAREN
            {
            root_0 = (GrammarAST)adaptor.nil();

            TREE_BEGIN115=(Token)match(input,TREE_BEGIN,FOLLOW_TREE_BEGIN_in_tree_2090); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TREE_BEGIN115_tree = (GrammarAST)adaptor.create(TREE_BEGIN115);
            root_0 = (GrammarAST)adaptor.becomeRoot(TREE_BEGIN115_tree, root_0);
            }
            pushFollow(FOLLOW_treeRoot_in_tree_2095);
            treeRoot116=treeRoot();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, treeRoot116.getTree());
            // org\\antlr\\grammar\\v3\\ANTLR.g:775:12: ( element )+
            int cnt62=0;
            loop62:
            do {
                int alt62=2;
                switch ( input.LA(1) ) {
                case FORCED_ACTION:
                case ACTION:
                case STRING_LITERAL:
                case CHAR_LITERAL:
                case TOKEN_REF:
                case LPAREN:
                case SEMPRED:
                case WILDCARD:
                case RULE_REF:
                case NOT:
                case TREE_BEGIN:
                    {
                    alt62=1;
                    }
                    break;

                }

                switch (alt62) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\ANTLR.g:775:12: element
            	    {
            	    pushFollow(FOLLOW_element_in_tree_2097);
            	    element117=element();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, element117.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt62 >= 1 ) break loop62;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(62, input);
                        throw eee;
                }
                cnt62++;
            } while (true);

            RPAREN118=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_tree_2102); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "tree_"

    public static class ebnf_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ebnf"
    // org\\antlr\\grammar\\v3\\ANTLR.g:779:1: ebnf : block ( QUESTION -> ^( OPTIONAL[$start,\"?\"] block ) | STAR -> ^( CLOSURE[$start,\"*\"] block ) | PLUS -> ^( POSITIVE_CLOSURE[$start,\"+\"] block ) | IMPLIES -> {grammarType == Grammar.COMBINED && Rule.getRuleType(currentRuleName) == Grammar.LEXER}? ^( SYNPRED[$start,\"=>\"] block ) -> | ROOT -> ^( ROOT block ) | BANG -> ^( BANG block ) | -> block ) ;
    public final ANTLRParser.ebnf_return ebnf() throws RecognitionException {
        ANTLRParser.ebnf_return retval = new ANTLRParser.ebnf_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token QUESTION120=null;
        Token STAR121=null;
        Token PLUS122=null;
        Token IMPLIES123=null;
        Token ROOT124=null;
        Token BANG125=null;
        ANTLRParser.block_return block119 = null;


        GrammarAST QUESTION120_tree=null;
        GrammarAST STAR121_tree=null;
        GrammarAST PLUS122_tree=null;
        GrammarAST IMPLIES123_tree=null;
        GrammarAST ROOT124_tree=null;
        GrammarAST BANG125_tree=null;
        RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");
        RewriteRuleTokenStream stream_STAR=new RewriteRuleTokenStream(adaptor,"token STAR");
        RewriteRuleTokenStream stream_BANG=new RewriteRuleTokenStream(adaptor,"token BANG");
        RewriteRuleTokenStream stream_IMPLIES=new RewriteRuleTokenStream(adaptor,"token IMPLIES");
        RewriteRuleTokenStream stream_QUESTION=new RewriteRuleTokenStream(adaptor,"token QUESTION");
        RewriteRuleTokenStream stream_ROOT=new RewriteRuleTokenStream(adaptor,"token ROOT");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:781:2: ( block ( QUESTION -> ^( OPTIONAL[$start,\"?\"] block ) | STAR -> ^( CLOSURE[$start,\"*\"] block ) | PLUS -> ^( POSITIVE_CLOSURE[$start,\"+\"] block ) | IMPLIES -> {grammarType == Grammar.COMBINED && Rule.getRuleType(currentRuleName) == Grammar.LEXER}? ^( SYNPRED[$start,\"=>\"] block ) -> | ROOT -> ^( ROOT block ) | BANG -> ^( BANG block ) | -> block ) )
            // org\\antlr\\grammar\\v3\\ANTLR.g:781:4: block ( QUESTION -> ^( OPTIONAL[$start,\"?\"] block ) | STAR -> ^( CLOSURE[$start,\"*\"] block ) | PLUS -> ^( POSITIVE_CLOSURE[$start,\"+\"] block ) | IMPLIES -> {grammarType == Grammar.COMBINED && Rule.getRuleType(currentRuleName) == Grammar.LEXER}? ^( SYNPRED[$start,\"=>\"] block ) -> | ROOT -> ^( ROOT block ) | BANG -> ^( BANG block ) | -> block )
            {
            pushFollow(FOLLOW_block_in_ebnf2116);
            block119=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block119.getTree());
            // org\\antlr\\grammar\\v3\\ANTLR.g:782:3: ( QUESTION -> ^( OPTIONAL[$start,\"?\"] block ) | STAR -> ^( CLOSURE[$start,\"*\"] block ) | PLUS -> ^( POSITIVE_CLOSURE[$start,\"+\"] block ) | IMPLIES -> {grammarType == Grammar.COMBINED && Rule.getRuleType(currentRuleName) == Grammar.LEXER}? ^( SYNPRED[$start,\"=>\"] block ) -> | ROOT -> ^( ROOT block ) | BANG -> ^( BANG block ) | -> block )
            int alt63=7;
            switch ( input.LA(1) ) {
            case QUESTION:
                {
                alt63=1;
                }
                break;
            case STAR:
                {
                alt63=2;
                }
                break;
            case PLUS:
                {
                alt63=3;
                }
                break;
            case IMPLIES:
                {
                alt63=4;
                }
                break;
            case ROOT:
                {
                alt63=5;
                }
                break;
            case BANG:
                {
                alt63=6;
                }
                break;
            case FORCED_ACTION:
            case ACTION:
            case SEMI:
            case STRING_LITERAL:
            case CHAR_LITERAL:
            case TOKEN_REF:
            case OR:
            case LPAREN:
            case RPAREN:
            case SEMPRED:
            case WILDCARD:
            case RULE_REF:
            case NOT:
            case TREE_BEGIN:
            case REWRITE:
                {
                alt63=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }

            switch (alt63) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:782:5: QUESTION
                    {
                    QUESTION120=(Token)match(input,QUESTION,FOLLOW_QUESTION_in_ebnf2122); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_QUESTION.add(QUESTION120);



                    // AST REWRITE
                    // elements: block
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 783:4: -> ^( OPTIONAL[$start,\"?\"] block )
                    {
                        // org\\antlr\\grammar\\v3\\ANTLR.g:783:7: ^( OPTIONAL[$start,\"?\"] block )
                        {
                        GrammarAST root_1 = (GrammarAST)adaptor.nil();
                        root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(OPTIONAL, ((Token)retval.start), "?"), root_1);

                        adaptor.addChild(root_1, stream_block.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:784:5: STAR
                    {
                    STAR121=(Token)match(input,STAR,FOLLOW_STAR_in_ebnf2140); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STAR.add(STAR121);



                    // AST REWRITE
                    // elements: block
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 785:4: -> ^( CLOSURE[$start,\"*\"] block )
                    {
                        // org\\antlr\\grammar\\v3\\ANTLR.g:785:7: ^( CLOSURE[$start,\"*\"] block )
                        {
                        GrammarAST root_1 = (GrammarAST)adaptor.nil();
                        root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(CLOSURE, ((Token)retval.start), "*"), root_1);

                        adaptor.addChild(root_1, stream_block.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:786:5: PLUS
                    {
                    PLUS122=(Token)match(input,PLUS,FOLLOW_PLUS_in_ebnf2158); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PLUS.add(PLUS122);



                    // AST REWRITE
                    // elements: block
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 787:4: -> ^( POSITIVE_CLOSURE[$start,\"+\"] block )
                    {
                        // org\\antlr\\grammar\\v3\\ANTLR.g:787:7: ^( POSITIVE_CLOSURE[$start,\"+\"] block )
                        {
                        GrammarAST root_1 = (GrammarAST)adaptor.nil();
                        root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(POSITIVE_CLOSURE, ((Token)retval.start), "+"), root_1);

                        adaptor.addChild(root_1, stream_block.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:788:5: IMPLIES
                    {
                    IMPLIES123=(Token)match(input,IMPLIES,FOLLOW_IMPLIES_in_ebnf2176); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IMPLIES.add(IMPLIES123);



                    // AST REWRITE
                    // elements: block
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 790:4: -> {grammarType == Grammar.COMBINED && Rule.getRuleType(currentRuleName) == Grammar.LEXER}? ^( SYNPRED[$start,\"=>\"] block )
                    if (grammarType == Grammar.COMBINED && Rule.getRuleType(currentRuleName) == Grammar.LEXER) {
                        // org\\antlr\\grammar\\v3\\ANTLR.g:790:96: ^( SYNPRED[$start,\"=>\"] block )
                        {
                        GrammarAST root_1 = (GrammarAST)adaptor.nil();
                        root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(SYNPRED, ((Token)retval.start), "=>"), root_1);

                        adaptor.addChild(root_1, stream_block.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }
                    else // 792:4: ->
                    {
                        adaptor.addChild(root_0, createSynSemPredFromBlock((block119!=null?((GrammarAST)block119.tree):null), SYN_SEMPRED));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:793:5: ROOT
                    {
                    ROOT124=(Token)match(input,ROOT,FOLLOW_ROOT_in_ebnf2212); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ROOT.add(ROOT124);



                    // AST REWRITE
                    // elements: ROOT, block
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 794:4: -> ^( ROOT block )
                    {
                        // org\\antlr\\grammar\\v3\\ANTLR.g:794:7: ^( ROOT block )
                        {
                        GrammarAST root_1 = (GrammarAST)adaptor.nil();
                        root_1 = (GrammarAST)adaptor.becomeRoot(stream_ROOT.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_block.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:795:5: BANG
                    {
                    BANG125=(Token)match(input,BANG,FOLLOW_BANG_in_ebnf2229); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_BANG.add(BANG125);



                    // AST REWRITE
                    // elements: block, BANG
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 796:4: -> ^( BANG block )
                    {
                        // org\\antlr\\grammar\\v3\\ANTLR.g:796:7: ^( BANG block )
                        {
                        GrammarAST root_1 = (GrammarAST)adaptor.nil();
                        root_1 = (GrammarAST)adaptor.becomeRoot(stream_BANG.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_block.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 7 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:798:4: 
                    {

                    // AST REWRITE
                    // elements: block
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 798:4: -> block
                    {
                        adaptor.addChild(root_0, stream_block.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ebnf"

    public static class range_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "range"
    // org\\antlr\\grammar\\v3\\ANTLR.g:802:1: range : c1= CHAR_LITERAL RANGE c2= CHAR_LITERAL -> ^( CHAR_RANGE[$c1,\"..\"] $c1 $c2) ;
    public final ANTLRParser.range_return range() throws RecognitionException {
        ANTLRParser.range_return retval = new ANTLRParser.range_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token c1=null;
        Token c2=null;
        Token RANGE126=null;

        GrammarAST c1_tree=null;
        GrammarAST c2_tree=null;
        GrammarAST RANGE126_tree=null;
        RewriteRuleTokenStream stream_RANGE=new RewriteRuleTokenStream(adaptor,"token RANGE");
        RewriteRuleTokenStream stream_CHAR_LITERAL=new RewriteRuleTokenStream(adaptor,"token CHAR_LITERAL");

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:803:2: (c1= CHAR_LITERAL RANGE c2= CHAR_LITERAL -> ^( CHAR_RANGE[$c1,\"..\"] $c1 $c2) )
            // org\\antlr\\grammar\\v3\\ANTLR.g:803:4: c1= CHAR_LITERAL RANGE c2= CHAR_LITERAL
            {
            c1=(Token)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_range2268); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CHAR_LITERAL.add(c1);

            RANGE126=(Token)match(input,RANGE,FOLLOW_RANGE_in_range2270); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RANGE.add(RANGE126);

            c2=(Token)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_range2274); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CHAR_LITERAL.add(c2);



            // AST REWRITE
            // elements: c1, c2
            // token labels: c1, c2
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_c1=new RewriteRuleTokenStream(adaptor,"token c1",c1);
            RewriteRuleTokenStream stream_c2=new RewriteRuleTokenStream(adaptor,"token c2",c2);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 804:3: -> ^( CHAR_RANGE[$c1,\"..\"] $c1 $c2)
            {
                // org\\antlr\\grammar\\v3\\ANTLR.g:804:6: ^( CHAR_RANGE[$c1,\"..\"] $c1 $c2)
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(CHAR_RANGE, c1, ".."), root_1);

                adaptor.addChild(root_1, stream_c1.nextNode());
                adaptor.addChild(root_1, stream_c2.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "range"

    public static class terminal_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "terminal"
    // org\\antlr\\grammar\\v3\\ANTLR.g:807:1: terminal : (cl= CHAR_LITERAL ( elementOptions[$cl.tree] )? ( ROOT | BANG )? | tr= TOKEN_REF ( elementOptions[$tr.tree] )? ( ARG_ACTION )? ( ROOT | BANG )? | sl= STRING_LITERAL ( elementOptions[$sl.tree] )? ( ROOT | BANG )? | wi= WILDCARD ( ROOT | BANG )? );
    public final ANTLRParser.terminal_return terminal() throws RecognitionException {
        ANTLRParser.terminal_return retval = new ANTLRParser.terminal_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token cl=null;
        Token tr=null;
        Token sl=null;
        Token wi=null;
        Token ROOT128=null;
        Token BANG129=null;
        Token ARG_ACTION131=null;
        Token ROOT132=null;
        Token BANG133=null;
        Token ROOT135=null;
        Token BANG136=null;
        Token ROOT137=null;
        Token BANG138=null;
        ANTLRParser.elementOptions_return elementOptions127 = null;

        ANTLRParser.elementOptions_return elementOptions130 = null;

        ANTLRParser.elementOptions_return elementOptions134 = null;


        GrammarAST cl_tree=null;
        GrammarAST tr_tree=null;
        GrammarAST sl_tree=null;
        GrammarAST wi_tree=null;
        GrammarAST ROOT128_tree=null;
        GrammarAST BANG129_tree=null;
        GrammarAST ARG_ACTION131_tree=null;
        GrammarAST ROOT132_tree=null;
        GrammarAST BANG133_tree=null;
        GrammarAST ROOT135_tree=null;
        GrammarAST BANG136_tree=null;
        GrammarAST ROOT137_tree=null;
        GrammarAST BANG138_tree=null;

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:808:2: (cl= CHAR_LITERAL ( elementOptions[$cl.tree] )? ( ROOT | BANG )? | tr= TOKEN_REF ( elementOptions[$tr.tree] )? ( ARG_ACTION )? ( ROOT | BANG )? | sl= STRING_LITERAL ( elementOptions[$sl.tree] )? ( ROOT | BANG )? | wi= WILDCARD ( ROOT | BANG )? )
            int alt72=4;
            switch ( input.LA(1) ) {
            case CHAR_LITERAL:
                {
                alt72=1;
                }
                break;
            case TOKEN_REF:
                {
                alt72=2;
                }
                break;
            case STRING_LITERAL:
                {
                alt72=3;
                }
                break;
            case WILDCARD:
                {
                alt72=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }

            switch (alt72) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:808:4: cl= CHAR_LITERAL ( elementOptions[$cl.tree] )? ( ROOT | BANG )?
                    {
                    root_0 = (GrammarAST)adaptor.nil();

                    cl=(Token)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_terminal2302); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    cl_tree = (GrammarAST)adaptor.create(cl);
                    root_0 = (GrammarAST)adaptor.becomeRoot(cl_tree, root_0);
                    }
                    // org\\antlr\\grammar\\v3\\ANTLR.g:808:21: ( elementOptions[$cl.tree] )?
                    int alt64=2;
                    switch ( input.LA(1) ) {
                        case OPEN_ELEMENT_OPTION:
                            {
                            alt64=1;
                            }
                            break;
                    }

                    switch (alt64) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:808:23: elementOptions[$cl.tree]
                            {
                            pushFollow(FOLLOW_elementOptions_in_terminal2307);
                            elementOptions127=elementOptions(cl_tree);

                            state._fsp--;
                            if (state.failed) return retval;

                            }
                            break;

                    }

                    // org\\antlr\\grammar\\v3\\ANTLR.g:808:52: ( ROOT | BANG )?
                    int alt65=3;
                    switch ( input.LA(1) ) {
                        case ROOT:
                            {
                            alt65=1;
                            }
                            break;
                        case BANG:
                            {
                            alt65=2;
                            }
                            break;
                    }

                    switch (alt65) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:808:53: ROOT
                            {
                            ROOT128=(Token)match(input,ROOT,FOLLOW_ROOT_in_terminal2315); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ROOT128_tree = (GrammarAST)adaptor.create(ROOT128);
                            root_0 = (GrammarAST)adaptor.becomeRoot(ROOT128_tree, root_0);
                            }

                            }
                            break;
                        case 2 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:808:59: BANG
                            {
                            BANG129=(Token)match(input,BANG,FOLLOW_BANG_in_terminal2318); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            BANG129_tree = (GrammarAST)adaptor.create(BANG129);
                            root_0 = (GrammarAST)adaptor.becomeRoot(BANG129_tree, root_0);
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:810:4: tr= TOKEN_REF ( elementOptions[$tr.tree] )? ( ARG_ACTION )? ( ROOT | BANG )?
                    {
                    root_0 = (GrammarAST)adaptor.nil();

                    tr=(Token)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_terminal2329); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    tr_tree = (GrammarAST)adaptor.create(tr);
                    root_0 = (GrammarAST)adaptor.becomeRoot(tr_tree, root_0);
                    }
                    // org\\antlr\\grammar\\v3\\ANTLR.g:811:3: ( elementOptions[$tr.tree] )?
                    int alt66=2;
                    switch ( input.LA(1) ) {
                        case OPEN_ELEMENT_OPTION:
                            {
                            alt66=1;
                            }
                            break;
                    }

                    switch (alt66) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:811:5: elementOptions[$tr.tree]
                            {
                            pushFollow(FOLLOW_elementOptions_in_terminal2336);
                            elementOptions130=elementOptions(tr_tree);

                            state._fsp--;
                            if (state.failed) return retval;

                            }
                            break;

                    }

                    // org\\antlr\\grammar\\v3\\ANTLR.g:812:3: ( ARG_ACTION )?
                    int alt67=2;
                    switch ( input.LA(1) ) {
                        case ARG_ACTION:
                            {
                            alt67=1;
                            }
                            break;
                    }

                    switch (alt67) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:812:5: ARG_ACTION
                            {
                            ARG_ACTION131=(Token)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_terminal2347); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ARG_ACTION131_tree = (GrammarAST)adaptor.create(ARG_ACTION131);
                            adaptor.addChild(root_0, ARG_ACTION131_tree);
                            }

                            }
                            break;

                    }

                    // org\\antlr\\grammar\\v3\\ANTLR.g:813:3: ( ROOT | BANG )?
                    int alt68=3;
                    switch ( input.LA(1) ) {
                        case ROOT:
                            {
                            alt68=1;
                            }
                            break;
                        case BANG:
                            {
                            alt68=2;
                            }
                            break;
                    }

                    switch (alt68) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:813:4: ROOT
                            {
                            ROOT132=(Token)match(input,ROOT,FOLLOW_ROOT_in_terminal2356); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ROOT132_tree = (GrammarAST)adaptor.create(ROOT132);
                            root_0 = (GrammarAST)adaptor.becomeRoot(ROOT132_tree, root_0);
                            }

                            }
                            break;
                        case 2 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:813:10: BANG
                            {
                            BANG133=(Token)match(input,BANG,FOLLOW_BANG_in_terminal2359); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            BANG133_tree = (GrammarAST)adaptor.create(BANG133);
                            root_0 = (GrammarAST)adaptor.becomeRoot(BANG133_tree, root_0);
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:815:4: sl= STRING_LITERAL ( elementOptions[$sl.tree] )? ( ROOT | BANG )?
                    {
                    root_0 = (GrammarAST)adaptor.nil();

                    sl=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_terminal2370); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    sl_tree = (GrammarAST)adaptor.create(sl);
                    root_0 = (GrammarAST)adaptor.becomeRoot(sl_tree, root_0);
                    }
                    // org\\antlr\\grammar\\v3\\ANTLR.g:815:23: ( elementOptions[$sl.tree] )?
                    int alt69=2;
                    switch ( input.LA(1) ) {
                        case OPEN_ELEMENT_OPTION:
                            {
                            alt69=1;
                            }
                            break;
                    }

                    switch (alt69) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:815:25: elementOptions[$sl.tree]
                            {
                            pushFollow(FOLLOW_elementOptions_in_terminal2375);
                            elementOptions134=elementOptions(sl_tree);

                            state._fsp--;
                            if (state.failed) return retval;

                            }
                            break;

                    }

                    // org\\antlr\\grammar\\v3\\ANTLR.g:815:54: ( ROOT | BANG )?
                    int alt70=3;
                    switch ( input.LA(1) ) {
                        case ROOT:
                            {
                            alt70=1;
                            }
                            break;
                        case BANG:
                            {
                            alt70=2;
                            }
                            break;
                    }

                    switch (alt70) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:815:55: ROOT
                            {
                            ROOT135=(Token)match(input,ROOT,FOLLOW_ROOT_in_terminal2383); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ROOT135_tree = (GrammarAST)adaptor.create(ROOT135);
                            root_0 = (GrammarAST)adaptor.becomeRoot(ROOT135_tree, root_0);
                            }

                            }
                            break;
                        case 2 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:815:61: BANG
                            {
                            BANG136=(Token)match(input,BANG,FOLLOW_BANG_in_terminal2386); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            BANG136_tree = (GrammarAST)adaptor.create(BANG136);
                            root_0 = (GrammarAST)adaptor.becomeRoot(BANG136_tree, root_0);
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:817:4: wi= WILDCARD ( ROOT | BANG )?
                    {
                    root_0 = (GrammarAST)adaptor.nil();

                    wi=(Token)match(input,WILDCARD,FOLLOW_WILDCARD_in_terminal2397); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    wi_tree = (GrammarAST)adaptor.create(wi);
                    adaptor.addChild(root_0, wi_tree);
                    }
                    // org\\antlr\\grammar\\v3\\ANTLR.g:817:16: ( ROOT | BANG )?
                    int alt71=3;
                    switch ( input.LA(1) ) {
                        case ROOT:
                            {
                            alt71=1;
                            }
                            break;
                        case BANG:
                            {
                            alt71=2;
                            }
                            break;
                    }

                    switch (alt71) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:817:17: ROOT
                            {
                            ROOT137=(Token)match(input,ROOT,FOLLOW_ROOT_in_terminal2400); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ROOT137_tree = (GrammarAST)adaptor.create(ROOT137);
                            root_0 = (GrammarAST)adaptor.becomeRoot(ROOT137_tree, root_0);
                            }

                            }
                            break;
                        case 2 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:817:23: BANG
                            {
                            BANG138=(Token)match(input,BANG,FOLLOW_BANG_in_terminal2403); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            BANG138_tree = (GrammarAST)adaptor.create(BANG138);
                            root_0 = (GrammarAST)adaptor.becomeRoot(BANG138_tree, root_0);
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      			if ( atTreeRoot )
                      			{
                      				ErrorManager.syntaxError(
                      					ErrorManager.MSG_WILDCARD_AS_ROOT,grammar,wi,null,null);
                      			}
                      		
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "terminal"

    public static class elementOptions_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementOptions"
    // org\\antlr\\grammar\\v3\\ANTLR.g:827:1: elementOptions[GrammarAST terminalAST] : ( OPEN_ELEMENT_OPTION defaultNodeOption[terminalAST] CLOSE_ELEMENT_OPTION | OPEN_ELEMENT_OPTION elementOption[terminalAST] ( SEMI elementOption[terminalAST] )* CLOSE_ELEMENT_OPTION );
    public final ANTLRParser.elementOptions_return elementOptions(GrammarAST terminalAST) throws RecognitionException {
        ANTLRParser.elementOptions_return retval = new ANTLRParser.elementOptions_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token OPEN_ELEMENT_OPTION139=null;
        Token CLOSE_ELEMENT_OPTION141=null;
        Token OPEN_ELEMENT_OPTION142=null;
        Token SEMI144=null;
        Token CLOSE_ELEMENT_OPTION146=null;
        ANTLRParser.defaultNodeOption_return defaultNodeOption140 = null;

        ANTLRParser.elementOption_return elementOption143 = null;

        ANTLRParser.elementOption_return elementOption145 = null;


        GrammarAST OPEN_ELEMENT_OPTION139_tree=null;
        GrammarAST CLOSE_ELEMENT_OPTION141_tree=null;
        GrammarAST OPEN_ELEMENT_OPTION142_tree=null;
        GrammarAST SEMI144_tree=null;
        GrammarAST CLOSE_ELEMENT_OPTION146_tree=null;

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:828:2: ( OPEN_ELEMENT_OPTION defaultNodeOption[terminalAST] CLOSE_ELEMENT_OPTION | OPEN_ELEMENT_OPTION elementOption[terminalAST] ( SEMI elementOption[terminalAST] )* CLOSE_ELEMENT_OPTION )
            int alt74=2;
            switch ( input.LA(1) ) {
            case OPEN_ELEMENT_OPTION:
                {
                switch ( input.LA(2) ) {
                case TOKEN_REF:
                    {
                    switch ( input.LA(3) ) {
                    case WILDCARD:
                    case CLOSE_ELEMENT_OPTION:
                        {
                        alt74=1;
                        }
                        break;
                    case ASSIGN:
                        {
                        alt74=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 74, 2, input);

                        throw nvae;
                    }

                    }
                    break;
                case RULE_REF:
                    {
                    switch ( input.LA(3) ) {
                    case WILDCARD:
                    case CLOSE_ELEMENT_OPTION:
                        {
                        alt74=1;
                        }
                        break;
                    case ASSIGN:
                        {
                        alt74=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 74, 3, input);

                        throw nvae;
                    }

                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 74, 1, input);

                    throw nvae;
                }

                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }

            switch (alt74) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:828:4: OPEN_ELEMENT_OPTION defaultNodeOption[terminalAST] CLOSE_ELEMENT_OPTION
                    {
                    root_0 = (GrammarAST)adaptor.nil();

                    OPEN_ELEMENT_OPTION139=(Token)match(input,OPEN_ELEMENT_OPTION,FOLLOW_OPEN_ELEMENT_OPTION_in_elementOptions2422); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OPEN_ELEMENT_OPTION139_tree = (GrammarAST)adaptor.create(OPEN_ELEMENT_OPTION139);
                    root_0 = (GrammarAST)adaptor.becomeRoot(OPEN_ELEMENT_OPTION139_tree, root_0);
                    }
                    pushFollow(FOLLOW_defaultNodeOption_in_elementOptions2425);
                    defaultNodeOption140=defaultNodeOption(terminalAST);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, defaultNodeOption140.getTree());
                    CLOSE_ELEMENT_OPTION141=(Token)match(input,CLOSE_ELEMENT_OPTION,FOLLOW_CLOSE_ELEMENT_OPTION_in_elementOptions2428); if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:829:4: OPEN_ELEMENT_OPTION elementOption[terminalAST] ( SEMI elementOption[terminalAST] )* CLOSE_ELEMENT_OPTION
                    {
                    root_0 = (GrammarAST)adaptor.nil();

                    OPEN_ELEMENT_OPTION142=(Token)match(input,OPEN_ELEMENT_OPTION,FOLLOW_OPEN_ELEMENT_OPTION_in_elementOptions2434); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OPEN_ELEMENT_OPTION142_tree = (GrammarAST)adaptor.create(OPEN_ELEMENT_OPTION142);
                    root_0 = (GrammarAST)adaptor.becomeRoot(OPEN_ELEMENT_OPTION142_tree, root_0);
                    }
                    pushFollow(FOLLOW_elementOption_in_elementOptions2437);
                    elementOption143=elementOption(terminalAST);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementOption143.getTree());
                    // org\\antlr\\grammar\\v3\\ANTLR.g:829:52: ( SEMI elementOption[terminalAST] )*
                    loop73:
                    do {
                        int alt73=2;
                        switch ( input.LA(1) ) {
                        case SEMI:
                            {
                            alt73=1;
                            }
                            break;

                        }

                        switch (alt73) {
                    	case 1 :
                    	    // org\\antlr\\grammar\\v3\\ANTLR.g:829:53: SEMI elementOption[terminalAST]
                    	    {
                    	    SEMI144=(Token)match(input,SEMI,FOLLOW_SEMI_in_elementOptions2441); if (state.failed) return retval;
                    	    pushFollow(FOLLOW_elementOption_in_elementOptions2444);
                    	    elementOption145=elementOption(terminalAST);

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementOption145.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop73;
                        }
                    } while (true);

                    CLOSE_ELEMENT_OPTION146=(Token)match(input,CLOSE_ELEMENT_OPTION,FOLLOW_CLOSE_ELEMENT_OPTION_in_elementOptions2449); if (state.failed) return retval;

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "elementOptions"

    public static class defaultNodeOption_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "defaultNodeOption"
    // org\\antlr\\grammar\\v3\\ANTLR.g:832:1: defaultNodeOption[GrammarAST terminalAST] : elementOptionId ;
    public final ANTLRParser.defaultNodeOption_return defaultNodeOption(GrammarAST terminalAST) throws RecognitionException {
        ANTLRParser.defaultNodeOption_return retval = new ANTLRParser.defaultNodeOption_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        ANTLRParser.elementOptionId_return elementOptionId147 = null;



        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:833:2: ( elementOptionId )
            // org\\antlr\\grammar\\v3\\ANTLR.g:833:4: elementOptionId
            {
            root_0 = (GrammarAST)adaptor.nil();

            pushFollow(FOLLOW_elementOptionId_in_defaultNodeOption2462);
            elementOptionId147=elementOptionId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementOptionId147.getTree());
            if ( state.backtracking==0 ) {
              terminalAST.setTerminalOption(grammar,Grammar.defaultTokenOption,(elementOptionId147!=null?elementOptionId147.qid:null));
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "defaultNodeOption"

    public static class elementOption_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementOption"
    // org\\antlr\\grammar\\v3\\ANTLR.g:837:1: elementOption[GrammarAST terminalAST] : id ASSIGN ( elementOptionId | (t= STRING_LITERAL | t= DOUBLE_QUOTE_STRING_LITERAL | t= DOUBLE_ANGLE_STRING_LITERAL ) ) ;
    public final ANTLRParser.elementOption_return elementOption(GrammarAST terminalAST) throws RecognitionException {
        ANTLRParser.elementOption_return retval = new ANTLRParser.elementOption_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token t=null;
        Token ASSIGN149=null;
        ANTLRParser.id_return id148 = null;

        ANTLRParser.elementOptionId_return elementOptionId150 = null;


        GrammarAST t_tree=null;
        GrammarAST ASSIGN149_tree=null;

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:838:2: ( id ASSIGN ( elementOptionId | (t= STRING_LITERAL | t= DOUBLE_QUOTE_STRING_LITERAL | t= DOUBLE_ANGLE_STRING_LITERAL ) ) )
            // org\\antlr\\grammar\\v3\\ANTLR.g:838:4: id ASSIGN ( elementOptionId | (t= STRING_LITERAL | t= DOUBLE_QUOTE_STRING_LITERAL | t= DOUBLE_ANGLE_STRING_LITERAL ) )
            {
            root_0 = (GrammarAST)adaptor.nil();

            pushFollow(FOLLOW_id_in_elementOption2478);
            id148=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, id148.getTree());
            ASSIGN149=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_elementOption2480); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ASSIGN149_tree = (GrammarAST)adaptor.create(ASSIGN149);
            root_0 = (GrammarAST)adaptor.becomeRoot(ASSIGN149_tree, root_0);
            }
            // org\\antlr\\grammar\\v3\\ANTLR.g:839:3: ( elementOptionId | (t= STRING_LITERAL | t= DOUBLE_QUOTE_STRING_LITERAL | t= DOUBLE_ANGLE_STRING_LITERAL ) )
            int alt76=2;
            switch ( input.LA(1) ) {
            case TOKEN_REF:
            case RULE_REF:
                {
                alt76=1;
                }
                break;
            case STRING_LITERAL:
            case DOUBLE_QUOTE_STRING_LITERAL:
            case DOUBLE_ANGLE_STRING_LITERAL:
                {
                alt76=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }

            switch (alt76) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:839:5: elementOptionId
                    {
                    pushFollow(FOLLOW_elementOptionId_in_elementOption2487);
                    elementOptionId150=elementOptionId();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementOptionId150.getTree());
                    if ( state.backtracking==0 ) {
                      terminalAST.setTerminalOption(grammar,(id148!=null?input.toString(id148.start,id148.stop):null),(elementOptionId150!=null?elementOptionId150.qid:null));
                    }

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:841:5: (t= STRING_LITERAL | t= DOUBLE_QUOTE_STRING_LITERAL | t= DOUBLE_ANGLE_STRING_LITERAL )
                    {
                    // org\\antlr\\grammar\\v3\\ANTLR.g:841:5: (t= STRING_LITERAL | t= DOUBLE_QUOTE_STRING_LITERAL | t= DOUBLE_ANGLE_STRING_LITERAL )
                    int alt75=3;
                    switch ( input.LA(1) ) {
                    case STRING_LITERAL:
                        {
                        alt75=1;
                        }
                        break;
                    case DOUBLE_QUOTE_STRING_LITERAL:
                        {
                        alt75=2;
                        }
                        break;
                    case DOUBLE_ANGLE_STRING_LITERAL:
                        {
                        alt75=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 75, 0, input);

                        throw nvae;
                    }

                    switch (alt75) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:841:6: t= STRING_LITERAL
                            {
                            t=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_elementOption2501); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            t_tree = (GrammarAST)adaptor.create(t);
                            adaptor.addChild(root_0, t_tree);
                            }

                            }
                            break;
                        case 2 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:841:23: t= DOUBLE_QUOTE_STRING_LITERAL
                            {
                            t=(Token)match(input,DOUBLE_QUOTE_STRING_LITERAL,FOLLOW_DOUBLE_QUOTE_STRING_LITERAL_in_elementOption2505); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            t_tree = (GrammarAST)adaptor.create(t);
                            adaptor.addChild(root_0, t_tree);
                            }

                            }
                            break;
                        case 3 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:841:53: t= DOUBLE_ANGLE_STRING_LITERAL
                            {
                            t=(Token)match(input,DOUBLE_ANGLE_STRING_LITERAL,FOLLOW_DOUBLE_ANGLE_STRING_LITERAL_in_elementOption2509); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            t_tree = (GrammarAST)adaptor.create(t);
                            adaptor.addChild(root_0, t_tree);
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                      terminalAST.setTerminalOption(grammar,(id148!=null?input.toString(id148.start,id148.stop):null),(t!=null?t.getText():null));
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "elementOption"

    public static class elementOptionId_return extends ParserRuleReturnScope {
        public String qid;
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementOptionId"
    // org\\antlr\\grammar\\v3\\ANTLR.g:846:1: elementOptionId returns [String qid] : i= id ( '.' i= id )* ;
    public final ANTLRParser.elementOptionId_return elementOptionId() throws RecognitionException {
        ANTLRParser.elementOptionId_return retval = new ANTLRParser.elementOptionId_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token char_literal151=null;
        ANTLRParser.id_return i = null;


        GrammarAST char_literal151_tree=null;

        StringBuffer buf = new StringBuffer();
        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:848:2: (i= id ( '.' i= id )* )
            // org\\antlr\\grammar\\v3\\ANTLR.g:848:4: i= id ( '.' i= id )*
            {
            root_0 = (GrammarAST)adaptor.nil();

            pushFollow(FOLLOW_id_in_elementOptionId2540);
            i=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, i.getTree());
            if ( state.backtracking==0 ) {
              buf.append((i!=null?input.toString(i.start,i.stop):null));
            }
            // org\\antlr\\grammar\\v3\\ANTLR.g:848:32: ( '.' i= id )*
            loop77:
            do {
                int alt77=2;
                switch ( input.LA(1) ) {
                case WILDCARD:
                    {
                    alt77=1;
                    }
                    break;

                }

                switch (alt77) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\ANTLR.g:848:33: '.' i= id
            	    {
            	    char_literal151=(Token)match(input,WILDCARD,FOLLOW_WILDCARD_in_elementOptionId2545); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal151_tree = (GrammarAST)adaptor.create(char_literal151);
            	    adaptor.addChild(root_0, char_literal151_tree);
            	    }
            	    pushFollow(FOLLOW_id_in_elementOptionId2549);
            	    i=id();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, i.getTree());
            	    if ( state.backtracking==0 ) {
            	      buf.append("." + (i!=null?input.toString(i.start,i.stop):null));
            	    }

            	    }
            	    break;

            	default :
            	    break loop77;
                }
            } while (true);

            if ( state.backtracking==0 ) {
              retval.qid = buf.toString();
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "elementOptionId"

    public static class ebnfSuffix_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ebnfSuffix"
    // org\\antlr\\grammar\\v3\\ANTLR.g:852:1: ebnfSuffix[GrammarAST elemAST, boolean inRewrite] : ( -> BLOCK[$elemAST.getToken(), \"BLOCK\"] ) ( -> ^( ALT[$elemAST.getToken(), \"ALT\"] EOA[\"<end-of-alt>\"] ) ) ( QUESTION -> OPTIONAL[$elemAST.getToken(),\"?\"] | STAR -> CLOSURE[$elemAST.getToken(),\"*\"] | PLUS -> POSITIVE_CLOSURE[$elemAST.getToken(),\"+\"] ) -> ^( $ebnfSuffix ^( EOB[$elemAST.getToken(), \"<end-of-block>\"] ) ) ;
    public final ANTLRParser.ebnfSuffix_return ebnfSuffix(GrammarAST elemAST, boolean inRewrite) throws RecognitionException {
        ANTLRParser.ebnfSuffix_return retval = new ANTLRParser.ebnfSuffix_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token QUESTION152=null;
        Token STAR153=null;
        Token PLUS154=null;

        GrammarAST QUESTION152_tree=null;
        GrammarAST STAR153_tree=null;
        GrammarAST PLUS154_tree=null;
        RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");
        RewriteRuleTokenStream stream_STAR=new RewriteRuleTokenStream(adaptor,"token STAR");
        RewriteRuleTokenStream stream_QUESTION=new RewriteRuleTokenStream(adaptor,"token QUESTION");


        GrammarAST blkRoot=null;
        GrammarAST alt=null;
        GrammarAST save = currentBlockAST;

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:863:2: ( ( -> BLOCK[$elemAST.getToken(), \"BLOCK\"] ) ( -> ^( ALT[$elemAST.getToken(), \"ALT\"] EOA[\"<end-of-alt>\"] ) ) ( QUESTION -> OPTIONAL[$elemAST.getToken(),\"?\"] | STAR -> CLOSURE[$elemAST.getToken(),\"*\"] | PLUS -> POSITIVE_CLOSURE[$elemAST.getToken(),\"+\"] ) -> ^( $ebnfSuffix ^( EOB[$elemAST.getToken(), \"<end-of-block>\"] ) ) )
            // org\\antlr\\grammar\\v3\\ANTLR.g:863:4: ( -> BLOCK[$elemAST.getToken(), \"BLOCK\"] ) ( -> ^( ALT[$elemAST.getToken(), \"ALT\"] EOA[\"<end-of-alt>\"] ) ) ( QUESTION -> OPTIONAL[$elemAST.getToken(),\"?\"] | STAR -> CLOSURE[$elemAST.getToken(),\"*\"] | PLUS -> POSITIVE_CLOSURE[$elemAST.getToken(),\"+\"] )
            {
            // org\\antlr\\grammar\\v3\\ANTLR.g:863:4: ( -> BLOCK[$elemAST.getToken(), \"BLOCK\"] )
            // org\\antlr\\grammar\\v3\\ANTLR.g:863:6: 
            {

            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 863:6: -> BLOCK[$elemAST.getToken(), \"BLOCK\"]
            {
                adaptor.addChild(root_0, (GrammarAST)adaptor.create(BLOCK, elemAST.getToken(), "BLOCK"));

            }

            retval.tree = root_0;}
            }

            if ( state.backtracking==0 ) {
               blkRoot = (GrammarAST)((GrammarAST)retval.tree).getChild(0); currentBlockAST = blkRoot; 
            }
            // org\\antlr\\grammar\\v3\\ANTLR.g:866:3: ( -> ^( ALT[$elemAST.getToken(), \"ALT\"] EOA[\"<end-of-alt>\"] ) )
            // org\\antlr\\grammar\\v3\\ANTLR.g:867:4: 
            {

            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 867:4: -> ^( ALT[$elemAST.getToken(), \"ALT\"] EOA[\"<end-of-alt>\"] )
            {
                // org\\antlr\\grammar\\v3\\ANTLR.g:867:7: ^( ALT[$elemAST.getToken(), \"ALT\"] EOA[\"<end-of-alt>\"] )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(ALT, elemAST.getToken(), "ALT"), root_1);

                adaptor.addChild(root_1, elemAST);
                adaptor.addChild(root_1, (GrammarAST)adaptor.create(EOA, "<end-of-alt>"));

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            if ( state.backtracking==0 ) {

              			alt = (GrammarAST)((GrammarAST)retval.tree).getChild(0);
              			if ( !inRewrite )
              				prefixWithSynPred(alt);
              		
            }
            // org\\antlr\\grammar\\v3\\ANTLR.g:874:3: ( QUESTION -> OPTIONAL[$elemAST.getToken(),\"?\"] | STAR -> CLOSURE[$elemAST.getToken(),\"*\"] | PLUS -> POSITIVE_CLOSURE[$elemAST.getToken(),\"+\"] )
            int alt78=3;
            switch ( input.LA(1) ) {
            case QUESTION:
                {
                alt78=1;
                }
                break;
            case STAR:
                {
                alt78=2;
                }
                break;
            case PLUS:
                {
                alt78=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }

            switch (alt78) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:874:5: QUESTION
                    {
                    QUESTION152=(Token)match(input,QUESTION,FOLLOW_QUESTION_in_ebnfSuffix2626); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_QUESTION.add(QUESTION152);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 875:4: -> OPTIONAL[$elemAST.getToken(),\"?\"]
                    {
                        adaptor.addChild(root_0, (GrammarAST)adaptor.create(OPTIONAL, elemAST.getToken(), "?"));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:876:5: STAR
                    {
                    STAR153=(Token)match(input,STAR,FOLLOW_STAR_in_ebnfSuffix2640); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STAR.add(STAR153);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 877:4: -> CLOSURE[$elemAST.getToken(),\"*\"]
                    {
                        adaptor.addChild(root_0, (GrammarAST)adaptor.create(CLOSURE, elemAST.getToken(), "*"));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:878:5: PLUS
                    {
                    PLUS154=(Token)match(input,PLUS,FOLLOW_PLUS_in_ebnfSuffix2654); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PLUS.add(PLUS154);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 879:4: -> POSITIVE_CLOSURE[$elemAST.getToken(),\"+\"]
                    {
                        adaptor.addChild(root_0, (GrammarAST)adaptor.create(POSITIVE_CLOSURE, elemAST.getToken(), "+"));

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }



            // AST REWRITE
            // elements: ebnfSuffix
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 881:3: -> ^( $ebnfSuffix ^( EOB[$elemAST.getToken(), \"<end-of-block>\"] ) )
            {
                // org\\antlr\\grammar\\v3\\ANTLR.g:881:6: ^( $ebnfSuffix ^( EOB[$elemAST.getToken(), \"<end-of-block>\"] ) )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot(stream_retval.nextNode(), root_1);

                // org\\antlr\\grammar\\v3\\ANTLR.g:881:20: ^( EOB[$elemAST.getToken(), \"<end-of-block>\"] )
                {
                GrammarAST root_2 = (GrammarAST)adaptor.nil();
                root_2 = (GrammarAST)adaptor.becomeRoot(blkRoot, root_2);

                adaptor.addChild(root_2, alt);
                adaptor.addChild(root_2, (GrammarAST)adaptor.create(EOB, elemAST.getToken(), "<end-of-block>"));

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

              currentBlockAST = save;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ebnfSuffix"

    public static class notTerminal_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "notTerminal"
    // org\\antlr\\grammar\\v3\\ANTLR.g:884:1: notTerminal : ( CHAR_LITERAL | TOKEN_REF | STRING_LITERAL );
    public final ANTLRParser.notTerminal_return notTerminal() throws RecognitionException {
        ANTLRParser.notTerminal_return retval = new ANTLRParser.notTerminal_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token set155=null;

        GrammarAST set155_tree=null;

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:885:2: ( CHAR_LITERAL | TOKEN_REF | STRING_LITERAL )
            // org\\antlr\\grammar\\v3\\ANTLR.g:
            {
            root_0 = (GrammarAST)adaptor.nil();

            set155=(Token)input.LT(1);
            if ( (input.LA(1)>=STRING_LITERAL && input.LA(1)<=CHAR_LITERAL)||input.LA(1)==TOKEN_REF ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (GrammarAST)adaptor.create(set155));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "notTerminal"

    public static class idList_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "idList"
    // org\\antlr\\grammar\\v3\\ANTLR.g:890:1: idList : id ( COMMA id )* ;
    public final ANTLRParser.idList_return idList() throws RecognitionException {
        ANTLRParser.idList_return retval = new ANTLRParser.idList_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token COMMA157=null;
        ANTLRParser.id_return id156 = null;

        ANTLRParser.id_return id158 = null;


        GrammarAST COMMA157_tree=null;

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:891:2: ( id ( COMMA id )* )
            // org\\antlr\\grammar\\v3\\ANTLR.g:891:4: id ( COMMA id )*
            {
            root_0 = (GrammarAST)adaptor.nil();

            pushFollow(FOLLOW_id_in_idList2716);
            id156=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, id156.getTree());
            // org\\antlr\\grammar\\v3\\ANTLR.g:891:7: ( COMMA id )*
            loop79:
            do {
                int alt79=2;
                switch ( input.LA(1) ) {
                case COMMA:
                    {
                    alt79=1;
                    }
                    break;

                }

                switch (alt79) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\ANTLR.g:891:8: COMMA id
            	    {
            	    COMMA157=(Token)match(input,COMMA,FOLLOW_COMMA_in_idList2719); if (state.failed) return retval;
            	    pushFollow(FOLLOW_id_in_idList2722);
            	    id158=id();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, id158.getTree());

            	    }
            	    break;

            	default :
            	    break loop79;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "idList"

    public static class id_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "id"
    // org\\antlr\\grammar\\v3\\ANTLR.g:894:1: id : ( TOKEN_REF -> ID[$TOKEN_REF] | RULE_REF -> ID[$RULE_REF] );
    public final ANTLRParser.id_return id() throws RecognitionException {
        ANTLRParser.id_return retval = new ANTLRParser.id_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token TOKEN_REF159=null;
        Token RULE_REF160=null;

        GrammarAST TOKEN_REF159_tree=null;
        GrammarAST RULE_REF160_tree=null;
        RewriteRuleTokenStream stream_RULE_REF=new RewriteRuleTokenStream(adaptor,"token RULE_REF");
        RewriteRuleTokenStream stream_TOKEN_REF=new RewriteRuleTokenStream(adaptor,"token TOKEN_REF");

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:895:2: ( TOKEN_REF -> ID[$TOKEN_REF] | RULE_REF -> ID[$RULE_REF] )
            int alt80=2;
            switch ( input.LA(1) ) {
            case TOKEN_REF:
                {
                alt80=1;
                }
                break;
            case RULE_REF:
                {
                alt80=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }

            switch (alt80) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:895:4: TOKEN_REF
                    {
                    TOKEN_REF159=(Token)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_id2735); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_TOKEN_REF.add(TOKEN_REF159);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 896:3: -> ID[$TOKEN_REF]
                    {
                        adaptor.addChild(root_0, (GrammarAST)adaptor.create(ID, TOKEN_REF159));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:897:4: RULE_REF
                    {
                    RULE_REF160=(Token)match(input,RULE_REF,FOLLOW_RULE_REF_in_id2747); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RULE_REF.add(RULE_REF160);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 898:3: -> ID[$RULE_REF]
                    {
                        adaptor.addChild(root_0, (GrammarAST)adaptor.create(ID, RULE_REF160));

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "id"

    public static class rewrite_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rewrite"
    // org\\antlr\\grammar\\v3\\ANTLR.g:903:1: rewrite : ( ( rewrite_with_sempred )* REWRITE rewrite_alternative -> ^( REWRITES ( rewrite_with_sempred )* ^( REWRITE rewrite_alternative ) ) | );
    public final ANTLRParser.rewrite_return rewrite() throws RecognitionException {
        ANTLRParser.rewrite_return retval = new ANTLRParser.rewrite_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token REWRITE162=null;
        ANTLRParser.rewrite_with_sempred_return rewrite_with_sempred161 = null;

        ANTLRParser.rewrite_alternative_return rewrite_alternative163 = null;


        GrammarAST REWRITE162_tree=null;
        RewriteRuleTokenStream stream_REWRITE=new RewriteRuleTokenStream(adaptor,"token REWRITE");
        RewriteRuleSubtreeStream stream_rewrite_with_sempred=new RewriteRuleSubtreeStream(adaptor,"rule rewrite_with_sempred");
        RewriteRuleSubtreeStream stream_rewrite_alternative=new RewriteRuleSubtreeStream(adaptor,"rule rewrite_alternative");
        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:904:2: ( ( rewrite_with_sempred )* REWRITE rewrite_alternative -> ^( REWRITES ( rewrite_with_sempred )* ^( REWRITE rewrite_alternative ) ) | )
            int alt82=2;
            switch ( input.LA(1) ) {
            case REWRITE:
                {
                alt82=1;
                }
                break;
            case SEMI:
            case OR:
            case RPAREN:
                {
                alt82=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }

            switch (alt82) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:904:4: ( rewrite_with_sempred )* REWRITE rewrite_alternative
                    {
                    // org\\antlr\\grammar\\v3\\ANTLR.g:904:4: ( rewrite_with_sempred )*
                    loop81:
                    do {
                        int alt81=2;
                        switch ( input.LA(1) ) {
                        case REWRITE:
                            {
                            switch ( input.LA(2) ) {
                            case SEMPRED:
                                {
                                alt81=1;
                                }
                                break;

                            }

                            }
                            break;

                        }

                        switch (alt81) {
                    	case 1 :
                    	    // org\\antlr\\grammar\\v3\\ANTLR.g:904:4: rewrite_with_sempred
                    	    {
                    	    pushFollow(FOLLOW_rewrite_with_sempred_in_rewrite2767);
                    	    rewrite_with_sempred161=rewrite_with_sempred();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_rewrite_with_sempred.add(rewrite_with_sempred161.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop81;
                        }
                    } while (true);

                    REWRITE162=(Token)match(input,REWRITE,FOLLOW_REWRITE_in_rewrite2772); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_REWRITE.add(REWRITE162);

                    pushFollow(FOLLOW_rewrite_alternative_in_rewrite2774);
                    rewrite_alternative163=rewrite_alternative();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_rewrite_alternative.add(rewrite_alternative163.getTree());


                    // AST REWRITE
                    // elements: rewrite_with_sempred, rewrite_alternative, REWRITE
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 906:3: -> ^( REWRITES ( rewrite_with_sempred )* ^( REWRITE rewrite_alternative ) )
                    {
                        // org\\antlr\\grammar\\v3\\ANTLR.g:906:6: ^( REWRITES ( rewrite_with_sempred )* ^( REWRITE rewrite_alternative ) )
                        {
                        GrammarAST root_1 = (GrammarAST)adaptor.nil();
                        root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(REWRITES, "REWRITES"), root_1);

                        // org\\antlr\\grammar\\v3\\ANTLR.g:906:17: ( rewrite_with_sempred )*
                        while ( stream_rewrite_with_sempred.hasNext() ) {
                            adaptor.addChild(root_1, stream_rewrite_with_sempred.nextTree());

                        }
                        stream_rewrite_with_sempred.reset();
                        // org\\antlr\\grammar\\v3\\ANTLR.g:906:39: ^( REWRITE rewrite_alternative )
                        {
                        GrammarAST root_2 = (GrammarAST)adaptor.nil();
                        root_2 = (GrammarAST)adaptor.becomeRoot(stream_REWRITE.nextNode(), root_2);

                        adaptor.addChild(root_2, stream_rewrite_alternative.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:908:2: 
                    {
                    root_0 = (GrammarAST)adaptor.nil();

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rewrite"

    public static class rewrite_with_sempred_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rewrite_with_sempred"
    // org\\antlr\\grammar\\v3\\ANTLR.g:910:1: rewrite_with_sempred : REWRITE SEMPRED rewrite_alternative ;
    public final ANTLRParser.rewrite_with_sempred_return rewrite_with_sempred() throws RecognitionException {
        ANTLRParser.rewrite_with_sempred_return retval = new ANTLRParser.rewrite_with_sempred_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token REWRITE164=null;
        Token SEMPRED165=null;
        ANTLRParser.rewrite_alternative_return rewrite_alternative166 = null;


        GrammarAST REWRITE164_tree=null;
        GrammarAST SEMPRED165_tree=null;

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:911:2: ( REWRITE SEMPRED rewrite_alternative )
            // org\\antlr\\grammar\\v3\\ANTLR.g:911:4: REWRITE SEMPRED rewrite_alternative
            {
            root_0 = (GrammarAST)adaptor.nil();

            REWRITE164=(Token)match(input,REWRITE,FOLLOW_REWRITE_in_rewrite_with_sempred2805); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REWRITE164_tree = (GrammarAST)adaptor.create(REWRITE164);
            root_0 = (GrammarAST)adaptor.becomeRoot(REWRITE164_tree, root_0);
            }
            SEMPRED165=(Token)match(input,SEMPRED,FOLLOW_SEMPRED_in_rewrite_with_sempred2808); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMPRED165_tree = (GrammarAST)adaptor.create(SEMPRED165);
            adaptor.addChild(root_0, SEMPRED165_tree);
            }
            pushFollow(FOLLOW_rewrite_alternative_in_rewrite_with_sempred2810);
            rewrite_alternative166=rewrite_alternative();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, rewrite_alternative166.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rewrite_with_sempred"

    public static class rewrite_block_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rewrite_block"
    // org\\antlr\\grammar\\v3\\ANTLR.g:914:1: rewrite_block : LPAREN rewrite_alternative RPAREN -> ^( BLOCK[$LPAREN,\"BLOCK\"] rewrite_alternative EOB[$RPAREN,\"<end-of-block>\"] ) ;
    public final ANTLRParser.rewrite_block_return rewrite_block() throws RecognitionException {
        ANTLRParser.rewrite_block_return retval = new ANTLRParser.rewrite_block_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token LPAREN167=null;
        Token RPAREN169=null;
        ANTLRParser.rewrite_alternative_return rewrite_alternative168 = null;


        GrammarAST LPAREN167_tree=null;
        GrammarAST RPAREN169_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_rewrite_alternative=new RewriteRuleSubtreeStream(adaptor,"rule rewrite_alternative");
        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:915:2: ( LPAREN rewrite_alternative RPAREN -> ^( BLOCK[$LPAREN,\"BLOCK\"] rewrite_alternative EOB[$RPAREN,\"<end-of-block>\"] ) )
            // org\\antlr\\grammar\\v3\\ANTLR.g:915:4: LPAREN rewrite_alternative RPAREN
            {
            LPAREN167=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_rewrite_block2821); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN167);

            pushFollow(FOLLOW_rewrite_alternative_in_rewrite_block2825);
            rewrite_alternative168=rewrite_alternative();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rewrite_alternative.add(rewrite_alternative168.getTree());
            RPAREN169=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_rewrite_block2829); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN169);



            // AST REWRITE
            // elements: rewrite_alternative
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 918:3: -> ^( BLOCK[$LPAREN,\"BLOCK\"] rewrite_alternative EOB[$RPAREN,\"<end-of-block>\"] )
            {
                // org\\antlr\\grammar\\v3\\ANTLR.g:918:6: ^( BLOCK[$LPAREN,\"BLOCK\"] rewrite_alternative EOB[$RPAREN,\"<end-of-block>\"] )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(BLOCK, LPAREN167, "BLOCK"), root_1);

                adaptor.addChild(root_1, stream_rewrite_alternative.nextTree());
                adaptor.addChild(root_1, (GrammarAST)adaptor.create(EOB, RPAREN169, "<end-of-block>"));

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rewrite_block"

    public static class rewrite_alternative_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rewrite_alternative"
    // org\\antlr\\grammar\\v3\\ANTLR.g:921:1: rewrite_alternative options {k=1; } : ({...}? => rewrite_template | {...}? => ( rewrite_element )+ -> {!stream_rewrite_element.hasNext()}? ^( ALT[LT(1),\"ALT\"] EPSILON[\"epsilon\"] EOA[\"<end-of-alt>\"] ) -> ^( ALT[LT(1),\"ALT\"] ( rewrite_element )+ EOA[\"<end-of-alt>\"] ) | -> ^( ALT[LT(1),\"ALT\"] EPSILON[\"epsilon\"] EOA[\"<end-of-alt>\"] ) | {...}? ETC );
    public final ANTLRParser.rewrite_alternative_return rewrite_alternative() throws RecognitionException {
        ANTLRParser.rewrite_alternative_return retval = new ANTLRParser.rewrite_alternative_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token ETC172=null;
        ANTLRParser.rewrite_template_return rewrite_template170 = null;

        ANTLRParser.rewrite_element_return rewrite_element171 = null;


        GrammarAST ETC172_tree=null;
        RewriteRuleSubtreeStream stream_rewrite_element=new RewriteRuleSubtreeStream(adaptor,"rule rewrite_element");
        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:923:2: ({...}? => rewrite_template | {...}? => ( rewrite_element )+ -> {!stream_rewrite_element.hasNext()}? ^( ALT[LT(1),\"ALT\"] EPSILON[\"epsilon\"] EOA[\"<end-of-alt>\"] ) -> ^( ALT[LT(1),\"ALT\"] ( rewrite_element )+ EOA[\"<end-of-alt>\"] ) | -> ^( ALT[LT(1),\"ALT\"] EPSILON[\"epsilon\"] EOA[\"<end-of-alt>\"] ) | {...}? ETC )
            int alt84=4;
            alt84 = dfa84.predict(input);
            switch (alt84) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:923:4: {...}? => rewrite_template
                    {
                    root_0 = (GrammarAST)adaptor.nil();

                    if ( !((grammar.buildTemplate())) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "rewrite_alternative", "grammar.buildTemplate()");
                    }
                    pushFollow(FOLLOW_rewrite_template_in_rewrite_alternative2865);
                    rewrite_template170=rewrite_template();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, rewrite_template170.getTree());

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:925:4: {...}? => ( rewrite_element )+
                    {
                    if ( !((grammar.buildAST())) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "rewrite_alternative", "grammar.buildAST()");
                    }
                    // org\\antlr\\grammar\\v3\\ANTLR.g:925:29: ( rewrite_element )+
                    int cnt83=0;
                    loop83:
                    do {
                        int alt83=2;
                        switch ( input.LA(1) ) {
                        case ACTION:
                        case STRING_LITERAL:
                        case CHAR_LITERAL:
                        case TOKEN_REF:
                        case LPAREN:
                        case RULE_REF:
                        case TREE_BEGIN:
                        case DOLLAR:
                            {
                            alt83=1;
                            }
                            break;

                        }

                        switch (alt83) {
                    	case 1 :
                    	    // org\\antlr\\grammar\\v3\\ANTLR.g:925:31: rewrite_element
                    	    {
                    	    pushFollow(FOLLOW_rewrite_element_in_rewrite_alternative2877);
                    	    rewrite_element171=rewrite_element();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_rewrite_element.add(rewrite_element171.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt83 >= 1 ) break loop83;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(83, input);
                                throw eee;
                        }
                        cnt83++;
                    } while (true);



                    // AST REWRITE
                    // elements: rewrite_element
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 926:3: -> {!stream_rewrite_element.hasNext()}? ^( ALT[LT(1),\"ALT\"] EPSILON[\"epsilon\"] EOA[\"<end-of-alt>\"] )
                    if (!stream_rewrite_element.hasNext()) {
                        // org\\antlr\\grammar\\v3\\ANTLR.g:926:43: ^( ALT[LT(1),\"ALT\"] EPSILON[\"epsilon\"] EOA[\"<end-of-alt>\"] )
                        {
                        GrammarAST root_1 = (GrammarAST)adaptor.nil();
                        root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(ALT, LT(1), "ALT"), root_1);

                        adaptor.addChild(root_1, (GrammarAST)adaptor.create(EPSILON, "epsilon"));
                        adaptor.addChild(root_1, (GrammarAST)adaptor.create(EOA, "<end-of-alt>"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }
                    else // 927:3: -> ^( ALT[LT(1),\"ALT\"] ( rewrite_element )+ EOA[\"<end-of-alt>\"] )
                    {
                        // org\\antlr\\grammar\\v3\\ANTLR.g:927:6: ^( ALT[LT(1),\"ALT\"] ( rewrite_element )+ EOA[\"<end-of-alt>\"] )
                        {
                        GrammarAST root_1 = (GrammarAST)adaptor.nil();
                        root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(ALT, LT(1), "ALT"), root_1);

                        if ( !(stream_rewrite_element.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_rewrite_element.hasNext() ) {
                            adaptor.addChild(root_1, stream_rewrite_element.nextTree());

                        }
                        stream_rewrite_element.reset();
                        adaptor.addChild(root_1, (GrammarAST)adaptor.create(EOA, "<end-of-alt>"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:930:3: 
                    {

                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 930:3: -> ^( ALT[LT(1),\"ALT\"] EPSILON[\"epsilon\"] EOA[\"<end-of-alt>\"] )
                    {
                        // org\\antlr\\grammar\\v3\\ANTLR.g:930:6: ^( ALT[LT(1),\"ALT\"] EPSILON[\"epsilon\"] EOA[\"<end-of-alt>\"] )
                        {
                        GrammarAST root_1 = (GrammarAST)adaptor.nil();
                        root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(ALT, LT(1), "ALT"), root_1);

                        adaptor.addChild(root_1, (GrammarAST)adaptor.create(EPSILON, "epsilon"));
                        adaptor.addChild(root_1, (GrammarAST)adaptor.create(EOA, "<end-of-alt>"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:931:4: {...}? ETC
                    {
                    root_0 = (GrammarAST)adaptor.nil();

                    if ( !((grammar.buildAST())) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "rewrite_alternative", "grammar.buildAST()");
                    }
                    ETC172=(Token)match(input,ETC,FOLLOW_ETC_in_rewrite_alternative2938); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ETC172_tree = (GrammarAST)adaptor.create(ETC172);
                    adaptor.addChild(root_0, ETC172_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rewrite_alternative"

    public static class rewrite_element_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rewrite_element"
    // org\\antlr\\grammar\\v3\\ANTLR.g:934:1: rewrite_element : ( (t= rewrite_atom -> $t) (subrule= ebnfSuffix[$t.tree,true] -> $subrule)? | rewrite_ebnf | (tr= rewrite_tree -> $tr) (subrule= ebnfSuffix[$tr.tree,true] -> $subrule)? );
    public final ANTLRParser.rewrite_element_return rewrite_element() throws RecognitionException {
        ANTLRParser.rewrite_element_return retval = new ANTLRParser.rewrite_element_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        ANTLRParser.rewrite_atom_return t = null;

        ANTLRParser.ebnfSuffix_return subrule = null;

        ANTLRParser.rewrite_tree_return tr = null;

        ANTLRParser.rewrite_ebnf_return rewrite_ebnf173 = null;


        RewriteRuleSubtreeStream stream_rewrite_tree=new RewriteRuleSubtreeStream(adaptor,"rule rewrite_tree");
        RewriteRuleSubtreeStream stream_ebnfSuffix=new RewriteRuleSubtreeStream(adaptor,"rule ebnfSuffix");
        RewriteRuleSubtreeStream stream_rewrite_atom=new RewriteRuleSubtreeStream(adaptor,"rule rewrite_atom");
        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:935:2: ( (t= rewrite_atom -> $t) (subrule= ebnfSuffix[$t.tree,true] -> $subrule)? | rewrite_ebnf | (tr= rewrite_tree -> $tr) (subrule= ebnfSuffix[$tr.tree,true] -> $subrule)? )
            int alt87=3;
            switch ( input.LA(1) ) {
            case ACTION:
            case STRING_LITERAL:
            case CHAR_LITERAL:
            case TOKEN_REF:
            case RULE_REF:
            case DOLLAR:
                {
                alt87=1;
                }
                break;
            case LPAREN:
                {
                alt87=2;
                }
                break;
            case TREE_BEGIN:
                {
                alt87=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }

            switch (alt87) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:935:4: (t= rewrite_atom -> $t) (subrule= ebnfSuffix[$t.tree,true] -> $subrule)?
                    {
                    // org\\antlr\\grammar\\v3\\ANTLR.g:935:4: (t= rewrite_atom -> $t)
                    // org\\antlr\\grammar\\v3\\ANTLR.g:935:6: t= rewrite_atom
                    {
                    pushFollow(FOLLOW_rewrite_atom_in_rewrite_element2953);
                    t=rewrite_atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_rewrite_atom.add(t.getTree());


                    // AST REWRITE
                    // elements: t
                    // token labels: 
                    // rule labels: retval, t
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_t=new RewriteRuleSubtreeStream(adaptor,"rule t",t!=null?t.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 936:4: -> $t
                    {
                        adaptor.addChild(root_0, stream_t.nextTree());

                    }

                    retval.tree = root_0;}
                    }

                    // org\\antlr\\grammar\\v3\\ANTLR.g:938:3: (subrule= ebnfSuffix[$t.tree,true] -> $subrule)?
                    int alt85=2;
                    switch ( input.LA(1) ) {
                        case STAR:
                        case QUESTION:
                        case PLUS:
                            {
                            alt85=1;
                            }
                            break;
                    }

                    switch (alt85) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:938:5: subrule= ebnfSuffix[$t.tree,true]
                            {
                            pushFollow(FOLLOW_ebnfSuffix_in_rewrite_element2973);
                            subrule=ebnfSuffix((t!=null?((GrammarAST)t.tree):null), true);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_ebnfSuffix.add(subrule.getTree());


                            // AST REWRITE
                            // elements: subrule
                            // token labels: 
                            // rule labels: retval, subrule
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                            RewriteRuleSubtreeStream stream_subrule=new RewriteRuleSubtreeStream(adaptor,"rule subrule",subrule!=null?subrule.tree:null);

                            root_0 = (GrammarAST)adaptor.nil();
                            // 939:4: -> $subrule
                            {
                                adaptor.addChild(root_0, stream_subrule.nextTree());

                            }

                            retval.tree = root_0;}
                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:941:4: rewrite_ebnf
                    {
                    root_0 = (GrammarAST)adaptor.nil();

                    pushFollow(FOLLOW_rewrite_ebnf_in_rewrite_element2992);
                    rewrite_ebnf173=rewrite_ebnf();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, rewrite_ebnf173.getTree());

                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:942:4: (tr= rewrite_tree -> $tr) (subrule= ebnfSuffix[$tr.tree,true] -> $subrule)?
                    {
                    // org\\antlr\\grammar\\v3\\ANTLR.g:942:4: (tr= rewrite_tree -> $tr)
                    // org\\antlr\\grammar\\v3\\ANTLR.g:942:6: tr= rewrite_tree
                    {
                    pushFollow(FOLLOW_rewrite_tree_in_rewrite_element3001);
                    tr=rewrite_tree();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_rewrite_tree.add(tr.getTree());


                    // AST REWRITE
                    // elements: tr
                    // token labels: 
                    // rule labels: retval, tr
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_tr=new RewriteRuleSubtreeStream(adaptor,"rule tr",tr!=null?tr.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 943:4: -> $tr
                    {
                        adaptor.addChild(root_0, stream_tr.nextTree());

                    }

                    retval.tree = root_0;}
                    }

                    // org\\antlr\\grammar\\v3\\ANTLR.g:945:3: (subrule= ebnfSuffix[$tr.tree,true] -> $subrule)?
                    int alt86=2;
                    switch ( input.LA(1) ) {
                        case STAR:
                        case QUESTION:
                        case PLUS:
                            {
                            alt86=1;
                            }
                            break;
                    }

                    switch (alt86) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:945:5: subrule= ebnfSuffix[$tr.tree,true]
                            {
                            pushFollow(FOLLOW_ebnfSuffix_in_rewrite_element3021);
                            subrule=ebnfSuffix((tr!=null?((GrammarAST)tr.tree):null), true);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_ebnfSuffix.add(subrule.getTree());


                            // AST REWRITE
                            // elements: subrule
                            // token labels: 
                            // rule labels: retval, subrule
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                            RewriteRuleSubtreeStream stream_subrule=new RewriteRuleSubtreeStream(adaptor,"rule subrule",subrule!=null?subrule.tree:null);

                            root_0 = (GrammarAST)adaptor.nil();
                            // 946:4: -> $subrule
                            {
                                adaptor.addChild(root_0, stream_subrule.nextTree());

                            }

                            retval.tree = root_0;}
                            }
                            break;

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rewrite_element"

    public static class rewrite_atom_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rewrite_atom"
    // org\\antlr\\grammar\\v3\\ANTLR.g:950:1: rewrite_atom : (tr= TOKEN_REF ( elementOptions[$tr.tree] )? ( ARG_ACTION )? | RULE_REF | cl= CHAR_LITERAL ( elementOptions[$cl.tree] )? | sl= STRING_LITERAL ( elementOptions[$sl.tree] )? | DOLLAR label | ACTION );
    public final ANTLRParser.rewrite_atom_return rewrite_atom() throws RecognitionException {
        ANTLRParser.rewrite_atom_return retval = new ANTLRParser.rewrite_atom_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token tr=null;
        Token cl=null;
        Token sl=null;
        Token ARG_ACTION175=null;
        Token RULE_REF176=null;
        Token DOLLAR179=null;
        Token ACTION181=null;
        ANTLRParser.elementOptions_return elementOptions174 = null;

        ANTLRParser.elementOptions_return elementOptions177 = null;

        ANTLRParser.elementOptions_return elementOptions178 = null;

        ANTLRParser.label_return label180 = null;


        GrammarAST tr_tree=null;
        GrammarAST cl_tree=null;
        GrammarAST sl_tree=null;
        GrammarAST ARG_ACTION175_tree=null;
        GrammarAST RULE_REF176_tree=null;
        GrammarAST DOLLAR179_tree=null;
        GrammarAST ACTION181_tree=null;

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:951:2: (tr= TOKEN_REF ( elementOptions[$tr.tree] )? ( ARG_ACTION )? | RULE_REF | cl= CHAR_LITERAL ( elementOptions[$cl.tree] )? | sl= STRING_LITERAL ( elementOptions[$sl.tree] )? | DOLLAR label | ACTION )
            int alt92=6;
            switch ( input.LA(1) ) {
            case TOKEN_REF:
                {
                alt92=1;
                }
                break;
            case RULE_REF:
                {
                alt92=2;
                }
                break;
            case CHAR_LITERAL:
                {
                alt92=3;
                }
                break;
            case STRING_LITERAL:
                {
                alt92=4;
                }
                break;
            case DOLLAR:
                {
                alt92=5;
                }
                break;
            case ACTION:
                {
                alt92=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;
            }

            switch (alt92) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:951:4: tr= TOKEN_REF ( elementOptions[$tr.tree] )? ( ARG_ACTION )?
                    {
                    root_0 = (GrammarAST)adaptor.nil();

                    tr=(Token)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_rewrite_atom3048); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    tr_tree = (GrammarAST)adaptor.create(tr);
                    root_0 = (GrammarAST)adaptor.becomeRoot(tr_tree, root_0);
                    }
                    // org\\antlr\\grammar\\v3\\ANTLR.g:951:42: ( elementOptions[$tr.tree] )?
                    int alt88=2;
                    switch ( input.LA(1) ) {
                        case OPEN_ELEMENT_OPTION:
                            {
                            alt88=1;
                            }
                            break;
                    }

                    switch (alt88) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:951:42: elementOptions[$tr.tree]
                            {
                            pushFollow(FOLLOW_elementOptions_in_rewrite_atom3051);
                            elementOptions174=elementOptions(tr_tree);

                            state._fsp--;
                            if (state.failed) return retval;

                            }
                            break;

                    }

                    // org\\antlr\\grammar\\v3\\ANTLR.g:951:45: ( ARG_ACTION )?
                    int alt89=2;
                    switch ( input.LA(1) ) {
                        case ARG_ACTION:
                            {
                            alt89=1;
                            }
                            break;
                    }

                    switch (alt89) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:951:45: ARG_ACTION
                            {
                            ARG_ACTION175=(Token)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rewrite_atom3056); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ARG_ACTION175_tree = (GrammarAST)adaptor.create(ARG_ACTION175);
                            adaptor.addChild(root_0, ARG_ACTION175_tree);
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:952:4: RULE_REF
                    {
                    root_0 = (GrammarAST)adaptor.nil();

                    RULE_REF176=(Token)match(input,RULE_REF,FOLLOW_RULE_REF_in_rewrite_atom3063); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RULE_REF176_tree = (GrammarAST)adaptor.create(RULE_REF176);
                    adaptor.addChild(root_0, RULE_REF176_tree);
                    }

                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:953:4: cl= CHAR_LITERAL ( elementOptions[$cl.tree] )?
                    {
                    root_0 = (GrammarAST)adaptor.nil();

                    cl=(Token)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_rewrite_atom3070); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    cl_tree = (GrammarAST)adaptor.create(cl);
                    adaptor.addChild(root_0, cl_tree);
                    }
                    // org\\antlr\\grammar\\v3\\ANTLR.g:953:44: ( elementOptions[$cl.tree] )?
                    int alt90=2;
                    switch ( input.LA(1) ) {
                        case OPEN_ELEMENT_OPTION:
                            {
                            alt90=1;
                            }
                            break;
                    }

                    switch (alt90) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:953:44: elementOptions[$cl.tree]
                            {
                            pushFollow(FOLLOW_elementOptions_in_rewrite_atom3072);
                            elementOptions177=elementOptions(cl_tree);

                            state._fsp--;
                            if (state.failed) return retval;

                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:954:4: sl= STRING_LITERAL ( elementOptions[$sl.tree] )?
                    {
                    root_0 = (GrammarAST)adaptor.nil();

                    sl=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_rewrite_atom3082); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    sl_tree = (GrammarAST)adaptor.create(sl);
                    adaptor.addChild(root_0, sl_tree);
                    }
                    // org\\antlr\\grammar\\v3\\ANTLR.g:954:46: ( elementOptions[$sl.tree] )?
                    int alt91=2;
                    switch ( input.LA(1) ) {
                        case OPEN_ELEMENT_OPTION:
                            {
                            alt91=1;
                            }
                            break;
                    }

                    switch (alt91) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:954:46: elementOptions[$sl.tree]
                            {
                            pushFollow(FOLLOW_elementOptions_in_rewrite_atom3084);
                            elementOptions178=elementOptions(sl_tree);

                            state._fsp--;
                            if (state.failed) return retval;

                            }
                            break;

                    }


                    }
                    break;
                case 5 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:955:4: DOLLAR label
                    {
                    root_0 = (GrammarAST)adaptor.nil();

                    DOLLAR179=(Token)match(input,DOLLAR,FOLLOW_DOLLAR_in_rewrite_atom3092); if (state.failed) return retval;
                    pushFollow(FOLLOW_label_in_rewrite_atom3095);
                    label180=label();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, label180.getTree());

                    }
                    break;
                case 6 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:956:4: ACTION
                    {
                    root_0 = (GrammarAST)adaptor.nil();

                    ACTION181=(Token)match(input,ACTION,FOLLOW_ACTION_in_rewrite_atom3101); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ACTION181_tree = (GrammarAST)adaptor.create(ACTION181);
                    adaptor.addChild(root_0, ACTION181_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rewrite_atom"

    public static class label_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "label"
    // org\\antlr\\grammar\\v3\\ANTLR.g:959:1: label : ( TOKEN_REF -> LABEL[$TOKEN_REF] | RULE_REF -> LABEL[$RULE_REF] );
    public final ANTLRParser.label_return label() throws RecognitionException {
        ANTLRParser.label_return retval = new ANTLRParser.label_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token TOKEN_REF182=null;
        Token RULE_REF183=null;

        GrammarAST TOKEN_REF182_tree=null;
        GrammarAST RULE_REF183_tree=null;
        RewriteRuleTokenStream stream_RULE_REF=new RewriteRuleTokenStream(adaptor,"token RULE_REF");
        RewriteRuleTokenStream stream_TOKEN_REF=new RewriteRuleTokenStream(adaptor,"token TOKEN_REF");

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:960:2: ( TOKEN_REF -> LABEL[$TOKEN_REF] | RULE_REF -> LABEL[$RULE_REF] )
            int alt93=2;
            switch ( input.LA(1) ) {
            case TOKEN_REF:
                {
                alt93=1;
                }
                break;
            case RULE_REF:
                {
                alt93=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;
            }

            switch (alt93) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:960:4: TOKEN_REF
                    {
                    TOKEN_REF182=(Token)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_label3112); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_TOKEN_REF.add(TOKEN_REF182);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 960:14: -> LABEL[$TOKEN_REF]
                    {
                        adaptor.addChild(root_0, (GrammarAST)adaptor.create(LABEL, TOKEN_REF182));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:961:4: RULE_REF
                    {
                    RULE_REF183=(Token)match(input,RULE_REF,FOLLOW_RULE_REF_in_label3122); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RULE_REF.add(RULE_REF183);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 961:13: -> LABEL[$RULE_REF]
                    {
                        adaptor.addChild(root_0, (GrammarAST)adaptor.create(LABEL, RULE_REF183));

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "label"

    public static class rewrite_ebnf_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rewrite_ebnf"
    // org\\antlr\\grammar\\v3\\ANTLR.g:964:1: rewrite_ebnf : b= rewrite_block ( QUESTION -> ^( OPTIONAL[$b.start,\"?\"] $b) | STAR -> ^( CLOSURE[$b.start,\"*\"] $b) | PLUS -> ^( POSITIVE_CLOSURE[$b.start,\"+\"] $b) ) ;
    public final ANTLRParser.rewrite_ebnf_return rewrite_ebnf() throws RecognitionException {
        ANTLRParser.rewrite_ebnf_return retval = new ANTLRParser.rewrite_ebnf_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token QUESTION184=null;
        Token STAR185=null;
        Token PLUS186=null;
        ANTLRParser.rewrite_block_return b = null;


        GrammarAST QUESTION184_tree=null;
        GrammarAST STAR185_tree=null;
        GrammarAST PLUS186_tree=null;
        RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");
        RewriteRuleTokenStream stream_STAR=new RewriteRuleTokenStream(adaptor,"token STAR");
        RewriteRuleTokenStream stream_QUESTION=new RewriteRuleTokenStream(adaptor,"token QUESTION");
        RewriteRuleSubtreeStream stream_rewrite_block=new RewriteRuleSubtreeStream(adaptor,"rule rewrite_block");
        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:965:2: (b= rewrite_block ( QUESTION -> ^( OPTIONAL[$b.start,\"?\"] $b) | STAR -> ^( CLOSURE[$b.start,\"*\"] $b) | PLUS -> ^( POSITIVE_CLOSURE[$b.start,\"+\"] $b) ) )
            // org\\antlr\\grammar\\v3\\ANTLR.g:965:4: b= rewrite_block ( QUESTION -> ^( OPTIONAL[$b.start,\"?\"] $b) | STAR -> ^( CLOSURE[$b.start,\"*\"] $b) | PLUS -> ^( POSITIVE_CLOSURE[$b.start,\"+\"] $b) )
            {
            pushFollow(FOLLOW_rewrite_block_in_rewrite_ebnf3140);
            b=rewrite_block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rewrite_block.add(b.getTree());
            // org\\antlr\\grammar\\v3\\ANTLR.g:966:3: ( QUESTION -> ^( OPTIONAL[$b.start,\"?\"] $b) | STAR -> ^( CLOSURE[$b.start,\"*\"] $b) | PLUS -> ^( POSITIVE_CLOSURE[$b.start,\"+\"] $b) )
            int alt94=3;
            switch ( input.LA(1) ) {
            case QUESTION:
                {
                alt94=1;
                }
                break;
            case STAR:
                {
                alt94=2;
                }
                break;
            case PLUS:
                {
                alt94=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;
            }

            switch (alt94) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:966:5: QUESTION
                    {
                    QUESTION184=(Token)match(input,QUESTION,FOLLOW_QUESTION_in_rewrite_ebnf3146); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_QUESTION.add(QUESTION184);



                    // AST REWRITE
                    // elements: b
                    // token labels: 
                    // rule labels: retval, b
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 967:4: -> ^( OPTIONAL[$b.start,\"?\"] $b)
                    {
                        // org\\antlr\\grammar\\v3\\ANTLR.g:967:7: ^( OPTIONAL[$b.start,\"?\"] $b)
                        {
                        GrammarAST root_1 = (GrammarAST)adaptor.nil();
                        root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(OPTIONAL, (b!=null?((Token)b.start):null), "?"), root_1);

                        adaptor.addChild(root_1, stream_b.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:968:5: STAR
                    {
                    STAR185=(Token)match(input,STAR,FOLLOW_STAR_in_rewrite_ebnf3165); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STAR.add(STAR185);



                    // AST REWRITE
                    // elements: b
                    // token labels: 
                    // rule labels: retval, b
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 969:4: -> ^( CLOSURE[$b.start,\"*\"] $b)
                    {
                        // org\\antlr\\grammar\\v3\\ANTLR.g:969:7: ^( CLOSURE[$b.start,\"*\"] $b)
                        {
                        GrammarAST root_1 = (GrammarAST)adaptor.nil();
                        root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(CLOSURE, (b!=null?((Token)b.start):null), "*"), root_1);

                        adaptor.addChild(root_1, stream_b.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:970:5: PLUS
                    {
                    PLUS186=(Token)match(input,PLUS,FOLLOW_PLUS_in_rewrite_ebnf3184); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PLUS.add(PLUS186);



                    // AST REWRITE
                    // elements: b
                    // token labels: 
                    // rule labels: retval, b
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 971:4: -> ^( POSITIVE_CLOSURE[$b.start,\"+\"] $b)
                    {
                        // org\\antlr\\grammar\\v3\\ANTLR.g:971:7: ^( POSITIVE_CLOSURE[$b.start,\"+\"] $b)
                        {
                        GrammarAST root_1 = (GrammarAST)adaptor.nil();
                        root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(POSITIVE_CLOSURE, (b!=null?((Token)b.start):null), "+"), root_1);

                        adaptor.addChild(root_1, stream_b.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rewrite_ebnf"

    public static class rewrite_tree_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rewrite_tree"
    // org\\antlr\\grammar\\v3\\ANTLR.g:975:1: rewrite_tree : TREE_BEGIN rewrite_atom ( rewrite_element )* RPAREN ;
    public final ANTLRParser.rewrite_tree_return rewrite_tree() throws RecognitionException {
        ANTLRParser.rewrite_tree_return retval = new ANTLRParser.rewrite_tree_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token TREE_BEGIN187=null;
        Token RPAREN190=null;
        ANTLRParser.rewrite_atom_return rewrite_atom188 = null;

        ANTLRParser.rewrite_element_return rewrite_element189 = null;


        GrammarAST TREE_BEGIN187_tree=null;
        GrammarAST RPAREN190_tree=null;

        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:976:2: ( TREE_BEGIN rewrite_atom ( rewrite_element )* RPAREN )
            // org\\antlr\\grammar\\v3\\ANTLR.g:976:4: TREE_BEGIN rewrite_atom ( rewrite_element )* RPAREN
            {
            root_0 = (GrammarAST)adaptor.nil();

            TREE_BEGIN187=(Token)match(input,TREE_BEGIN,FOLLOW_TREE_BEGIN_in_rewrite_tree3212); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TREE_BEGIN187_tree = (GrammarAST)adaptor.create(TREE_BEGIN187);
            root_0 = (GrammarAST)adaptor.becomeRoot(TREE_BEGIN187_tree, root_0);
            }
            pushFollow(FOLLOW_rewrite_atom_in_rewrite_tree3218);
            rewrite_atom188=rewrite_atom();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, rewrite_atom188.getTree());
            // org\\antlr\\grammar\\v3\\ANTLR.g:977:17: ( rewrite_element )*
            loop95:
            do {
                int alt95=2;
                switch ( input.LA(1) ) {
                case ACTION:
                case STRING_LITERAL:
                case CHAR_LITERAL:
                case TOKEN_REF:
                case LPAREN:
                case RULE_REF:
                case TREE_BEGIN:
                case DOLLAR:
                    {
                    alt95=1;
                    }
                    break;

                }

                switch (alt95) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\ANTLR.g:977:17: rewrite_element
            	    {
            	    pushFollow(FOLLOW_rewrite_element_in_rewrite_tree3220);
            	    rewrite_element189=rewrite_element();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, rewrite_element189.getTree());

            	    }
            	    break;

            	default :
            	    break loop95;
                }
            } while (true);

            RPAREN190=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_rewrite_tree3225); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rewrite_tree"

    public static class rewrite_template_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rewrite_template"
    // org\\antlr\\grammar\\v3\\ANTLR.g:981:1: public rewrite_template options {k=1; } : ({...}? => ( rewrite_template_head -> rewrite_template_head ) (st= DOUBLE_QUOTE_STRING_LITERAL | st= DOUBLE_ANGLE_STRING_LITERAL ) | rewrite_template_head | rewrite_indirect_template_head | ACTION );
    public final ANTLRParser.rewrite_template_return rewrite_template() throws RecognitionException {
        ANTLRParser.rewrite_template_return retval = new ANTLRParser.rewrite_template_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token st=null;
        Token ACTION194=null;
        ANTLRParser.rewrite_template_head_return rewrite_template_head191 = null;

        ANTLRParser.rewrite_template_head_return rewrite_template_head192 = null;

        ANTLRParser.rewrite_indirect_template_head_return rewrite_indirect_template_head193 = null;


        GrammarAST st_tree=null;
        GrammarAST ACTION194_tree=null;
        RewriteRuleTokenStream stream_DOUBLE_QUOTE_STRING_LITERAL=new RewriteRuleTokenStream(adaptor,"token DOUBLE_QUOTE_STRING_LITERAL");
        RewriteRuleTokenStream stream_DOUBLE_ANGLE_STRING_LITERAL=new RewriteRuleTokenStream(adaptor,"token DOUBLE_ANGLE_STRING_LITERAL");
        RewriteRuleSubtreeStream stream_rewrite_template_head=new RewriteRuleSubtreeStream(adaptor,"rule rewrite_template_head");
        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:995:2: ({...}? => ( rewrite_template_head -> rewrite_template_head ) (st= DOUBLE_QUOTE_STRING_LITERAL | st= DOUBLE_ANGLE_STRING_LITERAL ) | rewrite_template_head | rewrite_indirect_template_head | ACTION )
            int alt97=4;
            switch ( input.LA(1) ) {
            case TOKEN_REF:
                {
                int LA97_1 = input.LA(2);

                if ( ((LT(1).getText().equals("template"))) ) {
                    alt97=1;
                }
                else if ( (true) ) {
                    alt97=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 97, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_REF:
                {
                int LA97_2 = input.LA(2);

                if ( ((LT(1).getText().equals("template"))) ) {
                    alt97=1;
                }
                else if ( (true) ) {
                    alt97=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 97, 2, input);

                    throw nvae;
                }
                }
                break;
            case LPAREN:
                {
                alt97=3;
                }
                break;
            case ACTION:
                {
                alt97=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 97, 0, input);

                throw nvae;
            }

            switch (alt97) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:996:3: {...}? => ( rewrite_template_head -> rewrite_template_head ) (st= DOUBLE_QUOTE_STRING_LITERAL | st= DOUBLE_ANGLE_STRING_LITERAL )
                    {
                    if ( !((LT(1).getText().equals("template"))) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "rewrite_template", "LT(1).getText().equals(\"template\")");
                    }
                    // org\\antlr\\grammar\\v3\\ANTLR.g:997:3: ( rewrite_template_head -> rewrite_template_head )
                    // org\\antlr\\grammar\\v3\\ANTLR.g:997:5: rewrite_template_head
                    {
                    pushFollow(FOLLOW_rewrite_template_head_in_rewrite_template3260);
                    rewrite_template_head191=rewrite_template_head();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_rewrite_template_head.add(rewrite_template_head191.getTree());


                    // AST REWRITE
                    // elements: rewrite_template_head
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 998:4: -> rewrite_template_head
                    {
                        adaptor.addChild(root_0, stream_rewrite_template_head.nextTree());

                    }

                    retval.tree = root_0;}
                    }

                    // org\\antlr\\grammar\\v3\\ANTLR.g:1000:3: (st= DOUBLE_QUOTE_STRING_LITERAL | st= DOUBLE_ANGLE_STRING_LITERAL )
                    int alt96=2;
                    switch ( input.LA(1) ) {
                    case DOUBLE_QUOTE_STRING_LITERAL:
                        {
                        alt96=1;
                        }
                        break;
                    case DOUBLE_ANGLE_STRING_LITERAL:
                        {
                        alt96=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 96, 0, input);

                        throw nvae;
                    }

                    switch (alt96) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:1000:5: st= DOUBLE_QUOTE_STRING_LITERAL
                            {
                            st=(Token)match(input,DOUBLE_QUOTE_STRING_LITERAL,FOLLOW_DOUBLE_QUOTE_STRING_LITERAL_in_rewrite_template3279); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_DOUBLE_QUOTE_STRING_LITERAL.add(st);


                            }
                            break;
                        case 2 :
                            // org\\antlr\\grammar\\v3\\ANTLR.g:1000:38: st= DOUBLE_ANGLE_STRING_LITERAL
                            {
                            st=(Token)match(input,DOUBLE_ANGLE_STRING_LITERAL,FOLLOW_DOUBLE_ANGLE_STRING_LITERAL_in_rewrite_template3285); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_DOUBLE_ANGLE_STRING_LITERAL.add(st);


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                       adaptor.addChild( ((GrammarAST)retval.tree).getChild(0), adaptor.create(st) ); 
                    }

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:1004:3: rewrite_template_head
                    {
                    root_0 = (GrammarAST)adaptor.nil();

                    pushFollow(FOLLOW_rewrite_template_head_in_rewrite_template3300);
                    rewrite_template_head192=rewrite_template_head();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, rewrite_template_head192.getTree());

                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:1007:3: rewrite_indirect_template_head
                    {
                    root_0 = (GrammarAST)adaptor.nil();

                    pushFollow(FOLLOW_rewrite_indirect_template_head_in_rewrite_template3309);
                    rewrite_indirect_template_head193=rewrite_indirect_template_head();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, rewrite_indirect_template_head193.getTree());

                    }
                    break;
                case 4 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:1010:3: ACTION
                    {
                    root_0 = (GrammarAST)adaptor.nil();

                    ACTION194=(Token)match(input,ACTION,FOLLOW_ACTION_in_rewrite_template3318); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ACTION194_tree = (GrammarAST)adaptor.create(ACTION194);
                    adaptor.addChild(root_0, ACTION194_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rewrite_template"

    public static class rewrite_template_head_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rewrite_template_head"
    // org\\antlr\\grammar\\v3\\ANTLR.g:1013:1: rewrite_template_head : id lp= LPAREN rewrite_template_args RPAREN -> ^( TEMPLATE[$lp,\"TEMPLATE\"] id rewrite_template_args ) ;
    public final ANTLRParser.rewrite_template_head_return rewrite_template_head() throws RecognitionException {
        ANTLRParser.rewrite_template_head_return retval = new ANTLRParser.rewrite_template_head_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token lp=null;
        Token RPAREN197=null;
        ANTLRParser.id_return id195 = null;

        ANTLRParser.rewrite_template_args_return rewrite_template_args196 = null;


        GrammarAST lp_tree=null;
        GrammarAST RPAREN197_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_rewrite_template_args=new RewriteRuleSubtreeStream(adaptor,"rule rewrite_template_args");
        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:1015:2: ( id lp= LPAREN rewrite_template_args RPAREN -> ^( TEMPLATE[$lp,\"TEMPLATE\"] id rewrite_template_args ) )
            // org\\antlr\\grammar\\v3\\ANTLR.g:1015:4: id lp= LPAREN rewrite_template_args RPAREN
            {
            pushFollow(FOLLOW_id_in_rewrite_template_head3331);
            id195=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id195.getTree());
            lp=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_rewrite_template_head3335); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(lp);

            pushFollow(FOLLOW_rewrite_template_args_in_rewrite_template_head3339);
            rewrite_template_args196=rewrite_template_args();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rewrite_template_args.add(rewrite_template_args196.getTree());
            RPAREN197=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_rewrite_template_head3343); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN197);



            // AST REWRITE
            // elements: rewrite_template_args, id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 1018:3: -> ^( TEMPLATE[$lp,\"TEMPLATE\"] id rewrite_template_args )
            {
                // org\\antlr\\grammar\\v3\\ANTLR.g:1018:6: ^( TEMPLATE[$lp,\"TEMPLATE\"] id rewrite_template_args )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(TEMPLATE, lp, "TEMPLATE"), root_1);

                adaptor.addChild(root_1, stream_id.nextTree());
                adaptor.addChild(root_1, stream_rewrite_template_args.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rewrite_template_head"

    public static class rewrite_indirect_template_head_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rewrite_indirect_template_head"
    // org\\antlr\\grammar\\v3\\ANTLR.g:1021:1: rewrite_indirect_template_head : lp= LPAREN ACTION RPAREN LPAREN rewrite_template_args RPAREN -> ^( TEMPLATE[$lp,\"TEMPLATE\"] ACTION rewrite_template_args ) ;
    public final ANTLRParser.rewrite_indirect_template_head_return rewrite_indirect_template_head() throws RecognitionException {
        ANTLRParser.rewrite_indirect_template_head_return retval = new ANTLRParser.rewrite_indirect_template_head_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token lp=null;
        Token ACTION198=null;
        Token RPAREN199=null;
        Token LPAREN200=null;
        Token RPAREN202=null;
        ANTLRParser.rewrite_template_args_return rewrite_template_args201 = null;


        GrammarAST lp_tree=null;
        GrammarAST ACTION198_tree=null;
        GrammarAST RPAREN199_tree=null;
        GrammarAST LPAREN200_tree=null;
        GrammarAST RPAREN202_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_ACTION=new RewriteRuleTokenStream(adaptor,"token ACTION");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_rewrite_template_args=new RewriteRuleSubtreeStream(adaptor,"rule rewrite_template_args");
        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:1023:2: (lp= LPAREN ACTION RPAREN LPAREN rewrite_template_args RPAREN -> ^( TEMPLATE[$lp,\"TEMPLATE\"] ACTION rewrite_template_args ) )
            // org\\antlr\\grammar\\v3\\ANTLR.g:1023:4: lp= LPAREN ACTION RPAREN LPAREN rewrite_template_args RPAREN
            {
            lp=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_rewrite_indirect_template_head3371); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(lp);

            ACTION198=(Token)match(input,ACTION,FOLLOW_ACTION_in_rewrite_indirect_template_head3375); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ACTION.add(ACTION198);

            RPAREN199=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_rewrite_indirect_template_head3379); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN199);

            LPAREN200=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_rewrite_indirect_template_head3383); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN200);

            pushFollow(FOLLOW_rewrite_template_args_in_rewrite_indirect_template_head3385);
            rewrite_template_args201=rewrite_template_args();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rewrite_template_args.add(rewrite_template_args201.getTree());
            RPAREN202=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_rewrite_indirect_template_head3387); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN202);



            // AST REWRITE
            // elements: ACTION, rewrite_template_args
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 1027:3: -> ^( TEMPLATE[$lp,\"TEMPLATE\"] ACTION rewrite_template_args )
            {
                // org\\antlr\\grammar\\v3\\ANTLR.g:1027:6: ^( TEMPLATE[$lp,\"TEMPLATE\"] ACTION rewrite_template_args )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(TEMPLATE, lp, "TEMPLATE"), root_1);

                adaptor.addChild(root_1, stream_ACTION.nextNode());
                adaptor.addChild(root_1, stream_rewrite_template_args.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rewrite_indirect_template_head"

    public static class rewrite_template_args_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rewrite_template_args"
    // org\\antlr\\grammar\\v3\\ANTLR.g:1030:1: rewrite_template_args : ( rewrite_template_arg ( COMMA rewrite_template_arg )* -> ^( ARGLIST[\"ARGLIST\"] ( rewrite_template_arg )+ ) | -> ARGLIST[\"ARGLIST\"] );
    public final ANTLRParser.rewrite_template_args_return rewrite_template_args() throws RecognitionException {
        ANTLRParser.rewrite_template_args_return retval = new ANTLRParser.rewrite_template_args_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token COMMA204=null;
        ANTLRParser.rewrite_template_arg_return rewrite_template_arg203 = null;

        ANTLRParser.rewrite_template_arg_return rewrite_template_arg205 = null;


        GrammarAST COMMA204_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_rewrite_template_arg=new RewriteRuleSubtreeStream(adaptor,"rule rewrite_template_arg");
        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:1031:2: ( rewrite_template_arg ( COMMA rewrite_template_arg )* -> ^( ARGLIST[\"ARGLIST\"] ( rewrite_template_arg )+ ) | -> ARGLIST[\"ARGLIST\"] )
            int alt99=2;
            switch ( input.LA(1) ) {
            case TOKEN_REF:
            case RULE_REF:
                {
                alt99=1;
                }
                break;
            case RPAREN:
                {
                alt99=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 99, 0, input);

                throw nvae;
            }

            switch (alt99) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:1031:4: rewrite_template_arg ( COMMA rewrite_template_arg )*
                    {
                    pushFollow(FOLLOW_rewrite_template_arg_in_rewrite_template_args3411);
                    rewrite_template_arg203=rewrite_template_arg();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_rewrite_template_arg.add(rewrite_template_arg203.getTree());
                    // org\\antlr\\grammar\\v3\\ANTLR.g:1031:25: ( COMMA rewrite_template_arg )*
                    loop98:
                    do {
                        int alt98=2;
                        switch ( input.LA(1) ) {
                        case COMMA:
                            {
                            alt98=1;
                            }
                            break;

                        }

                        switch (alt98) {
                    	case 1 :
                    	    // org\\antlr\\grammar\\v3\\ANTLR.g:1031:26: COMMA rewrite_template_arg
                    	    {
                    	    COMMA204=(Token)match(input,COMMA,FOLLOW_COMMA_in_rewrite_template_args3414); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA204);

                    	    pushFollow(FOLLOW_rewrite_template_arg_in_rewrite_template_args3416);
                    	    rewrite_template_arg205=rewrite_template_arg();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_rewrite_template_arg.add(rewrite_template_arg205.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop98;
                        }
                    } while (true);



                    // AST REWRITE
                    // elements: rewrite_template_arg
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 1032:3: -> ^( ARGLIST[\"ARGLIST\"] ( rewrite_template_arg )+ )
                    {
                        // org\\antlr\\grammar\\v3\\ANTLR.g:1032:6: ^( ARGLIST[\"ARGLIST\"] ( rewrite_template_arg )+ )
                        {
                        GrammarAST root_1 = (GrammarAST)adaptor.nil();
                        root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(ARGLIST, "ARGLIST"), root_1);

                        if ( !(stream_rewrite_template_arg.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_rewrite_template_arg.hasNext() ) {
                            adaptor.addChild(root_1, stream_rewrite_template_arg.nextTree());

                        }
                        stream_rewrite_template_arg.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\ANTLR.g:1034:3: 
                    {

                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 1034:3: -> ARGLIST[\"ARGLIST\"]
                    {
                        adaptor.addChild(root_0, (GrammarAST)adaptor.create(ARGLIST, "ARGLIST"));

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rewrite_template_args"

    public static class rewrite_template_arg_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rewrite_template_arg"
    // org\\antlr\\grammar\\v3\\ANTLR.g:1037:1: rewrite_template_arg : id a= ASSIGN ACTION -> ^( ARG[$a,\"ARG\"] id ACTION ) ;
    public final ANTLRParser.rewrite_template_arg_return rewrite_template_arg() throws RecognitionException {
        ANTLRParser.rewrite_template_arg_return retval = new ANTLRParser.rewrite_template_arg_return();
        retval.start = input.LT(1);

        GrammarAST root_0 = null;

        Token a=null;
        Token ACTION207=null;
        ANTLRParser.id_return id206 = null;


        GrammarAST a_tree=null;
        GrammarAST ACTION207_tree=null;
        RewriteRuleTokenStream stream_ACTION=new RewriteRuleTokenStream(adaptor,"token ACTION");
        RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        try {
            // org\\antlr\\grammar\\v3\\ANTLR.g:1038:2: ( id a= ASSIGN ACTION -> ^( ARG[$a,\"ARG\"] id ACTION ) )
            // org\\antlr\\grammar\\v3\\ANTLR.g:1038:4: id a= ASSIGN ACTION
            {
            pushFollow(FOLLOW_id_in_rewrite_template_arg3451);
            id206=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id206.getTree());
            a=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_rewrite_template_arg3455); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ASSIGN.add(a);

            ACTION207=(Token)match(input,ACTION,FOLLOW_ACTION_in_rewrite_template_arg3457); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ACTION.add(ACTION207);



            // AST REWRITE
            // elements: id, ACTION
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 1039:3: -> ^( ARG[$a,\"ARG\"] id ACTION )
            {
                // org\\antlr\\grammar\\v3\\ANTLR.g:1039:6: ^( ARG[$a,\"ARG\"] id ACTION )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot((GrammarAST)adaptor.create(ARG, a, "ARG"), root_1);

                adaptor.addChild(root_1, stream_id.nextTree());
                adaptor.addChild(root_1, stream_ACTION.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rewrite_template_arg"

    // $ANTLR start synpred1_ANTLR
    public final void synpred1_ANTLR_fragment() throws RecognitionException {   
        // org\\antlr\\grammar\\v3\\ANTLR.g:745:4: ({...}? id WILDCARD ( terminal | ruleref ) )
        // org\\antlr\\grammar\\v3\\ANTLR.g:745:5: {...}? id WILDCARD ( terminal | ruleref )
        {
        if ( !((LT(1).getCharPositionInLine()+LT(1).getText().length()==LT(2).getCharPositionInLine()&&
        			 LT(2).getCharPositionInLine()+1==LT(3).getCharPositionInLine())) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred1_ANTLR", "LT(1).getCharPositionInLine()+LT(1).getText().length()==LT(2).getCharPositionInLine()&&\n\t\t\t LT(2).getCharPositionInLine()+1==LT(3).getCharPositionInLine()");
        }
        pushFollow(FOLLOW_id_in_synpred1_ANTLR1925);
        id();

        state._fsp--;
        if (state.failed) return ;
        match(input,WILDCARD,FOLLOW_WILDCARD_in_synpred1_ANTLR1927); if (state.failed) return ;
        // org\\antlr\\grammar\\v3\\ANTLR.g:746:82: ( terminal | ruleref )
        int alt100=2;
        switch ( input.LA(1) ) {
        case STRING_LITERAL:
        case CHAR_LITERAL:
        case TOKEN_REF:
        case WILDCARD:
            {
            alt100=1;
            }
            break;
        case RULE_REF:
            {
            alt100=2;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 100, 0, input);

            throw nvae;
        }

        switch (alt100) {
            case 1 :
                // org\\antlr\\grammar\\v3\\ANTLR.g:746:83: terminal
                {
                pushFollow(FOLLOW_terminal_in_synpred1_ANTLR1930);
                terminal();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 2 :
                // org\\antlr\\grammar\\v3\\ANTLR.g:746:92: ruleref
                {
                pushFollow(FOLLOW_ruleref_in_synpred1_ANTLR1932);
                ruleref();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred1_ANTLR

    // Delegated rules

    public final boolean synpred1_ANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_ANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA50 dfa50 = new DFA50(this);
    protected DFA53 dfa53 = new DFA53(this);
    protected DFA84 dfa84 = new DFA84(this);
    static final String DFA50_eotS =
        "\12\uffff";
    static final String DFA50_eofS =
        "\12\uffff";
    static final String DFA50_minS =
        "\3\47\7\uffff";
    static final String DFA50_maxS =
        "\1\115\2\124\7\uffff";
    static final String DFA50_acceptS =
        "\3\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\1";
    static final String DFA50_specialS =
        "\12\uffff}>";
    static final String[] DFA50_transitionS = {
            "\1\5\12\uffff\1\6\7\uffff\2\3\4\uffff\1\1\3\uffff\1\4\2\uffff"+
            "\1\7\2\uffff\1\3\1\2\1\3\1\10",
            "\1\3\12\uffff\1\3\1\uffff\1\3\4\uffff\1\11\2\3\1\uffff\1\3"+
            "\2\uffff\6\3\1\11\1\3\1\uffff\10\3\3\uffff\1\3",
            "\1\3\12\uffff\1\3\1\uffff\1\3\4\uffff\1\11\2\3\1\uffff\1\3"+
            "\2\uffff\6\3\1\11\1\3\1\uffff\7\3\4\uffff\1\3",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA50_eot = DFA.unpackEncodedString(DFA50_eotS);
    static final short[] DFA50_eof = DFA.unpackEncodedString(DFA50_eofS);
    static final char[] DFA50_min = DFA.unpackEncodedStringToUnsignedChars(DFA50_minS);
    static final char[] DFA50_max = DFA.unpackEncodedStringToUnsignedChars(DFA50_maxS);
    static final short[] DFA50_accept = DFA.unpackEncodedString(DFA50_acceptS);
    static final short[] DFA50_special = DFA.unpackEncodedString(DFA50_specialS);
    static final short[][] DFA50_transition;

    static {
        int numStates = DFA50_transitionS.length;
        DFA50_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA50_transition[i] = DFA.unpackEncodedString(DFA50_transitionS[i]);
        }
    }

    class DFA50 extends DFA {

        public DFA50(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 50;
            this.eot = DFA50_eot;
            this.eof = DFA50_eof;
            this.min = DFA50_min;
            this.max = DFA50_max;
            this.accept = DFA50_accept;
            this.special = DFA50_special;
            this.transition = DFA50_transition;
        }
        public String getDescription() {
            return "722:4: ( ( id ( ASSIGN | PLUS_ASSIGN ) ( atom | block ) ) (sub= ebnfSuffix[root_0,false] )? | a= atom (sub2= ebnfSuffix[$a.tree,false] )? | ebnf | FORCED_ACTION | ACTION | p= SEMPRED ( IMPLIES )? | t3= tree_ )";
        }
    }
    static final String DFA53_eotS =
        "\22\uffff";
    static final String DFA53_eofS =
        "\22\uffff";
    static final String DFA53_minS =
        "\1\72\2\47\1\uffff\2\47\1\uffff\12\0\1\uffff";
    static final String DFA53_maxS =
        "\1\113\2\124\1\uffff\2\124\1\uffff\12\0\1\uffff";
    static final String DFA53_acceptS =
        "\3\uffff\1\2\2\uffff\1\3\12\uffff\1\1";
    static final String DFA53_specialS =
        "\7\uffff\1\3\1\0\1\10\1\7\1\11\1\2\1\6\1\1\1\4\1\5\1\uffff}>";
    static final String[] DFA53_transitionS = {
            "\2\3\4\uffff\1\1\11\uffff\1\3\1\2",
            "\1\3\12\uffff\1\3\1\uffff\1\3\5\uffff\2\3\1\uffff\1\3\2\uffff"+
            "\6\3\1\uffff\1\3\1\uffff\1\3\1\4\6\3\3\uffff\1\3",
            "\1\6\12\uffff\1\6\1\uffff\1\6\5\uffff\2\6\1\uffff\1\6\2\uffff"+
            "\6\6\1\uffff\1\6\1\uffff\1\6\1\5\5\6\4\uffff\1\6",
            "",
            "\1\3\12\uffff\1\3\1\uffff\1\3\5\uffff\1\11\1\7\1\uffff\1\3"+
            "\2\uffff\1\10\1\3\1\uffff\3\3\1\uffff\1\3\1\uffff\1\3\1\12\1"+
            "\13\4\3\4\uffff\1\3",
            "\1\6\12\uffff\1\6\1\uffff\1\6\5\uffff\1\16\1\14\1\uffff\1"+
            "\6\2\uffff\1\15\1\6\1\uffff\3\6\1\uffff\1\6\1\uffff\1\6\1\17"+
            "\1\20\4\6\4\uffff\1\6",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            ""
    };

    static final short[] DFA53_eot = DFA.unpackEncodedString(DFA53_eotS);
    static final short[] DFA53_eof = DFA.unpackEncodedString(DFA53_eofS);
    static final char[] DFA53_min = DFA.unpackEncodedStringToUnsignedChars(DFA53_minS);
    static final char[] DFA53_max = DFA.unpackEncodedStringToUnsignedChars(DFA53_maxS);
    static final short[] DFA53_accept = DFA.unpackEncodedString(DFA53_acceptS);
    static final short[] DFA53_special = DFA.unpackEncodedString(DFA53_specialS);
    static final short[][] DFA53_transition;

    static {
        int numStates = DFA53_transitionS.length;
        DFA53_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA53_transition[i] = DFA.unpackEncodedString(DFA53_transitionS[i]);
        }
    }

    class DFA53 extends DFA {

        public DFA53(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 53;
            this.eot = DFA53_eot;
            this.eof = DFA53_eof;
            this.min = DFA53_min;
            this.max = DFA53_max;
            this.accept = DFA53_accept;
            this.special = DFA53_special;
            this.transition = DFA53_transition;
        }
        public String getDescription() {
            return "742:4: ( ({...}? id WILDCARD ( terminal | ruleref ) )=> id w= WILDCARD ( terminal | ruleref ) | terminal | ruleref )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA53_8 = input.LA(1);

                         
                        int index53_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_ANTLR()) ) {s = 17;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index53_8);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA53_14 = input.LA(1);

                         
                        int index53_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_ANTLR()) ) {s = 17;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index53_14);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA53_12 = input.LA(1);

                         
                        int index53_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_ANTLR()) ) {s = 17;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index53_12);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA53_7 = input.LA(1);

                         
                        int index53_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_ANTLR()) ) {s = 17;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index53_7);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA53_15 = input.LA(1);

                         
                        int index53_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_ANTLR()) ) {s = 17;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index53_15);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA53_16 = input.LA(1);

                         
                        int index53_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_ANTLR()) ) {s = 17;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index53_16);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA53_13 = input.LA(1);

                         
                        int index53_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_ANTLR()) ) {s = 17;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index53_13);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA53_10 = input.LA(1);

                         
                        int index53_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_ANTLR()) ) {s = 17;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index53_10);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA53_9 = input.LA(1);

                         
                        int index53_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_ANTLR()) ) {s = 17;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index53_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA53_11 = input.LA(1);

                         
                        int index53_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_ANTLR()) ) {s = 17;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index53_11);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 53, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA84_eotS =
        "\17\uffff";
    static final String DFA84_eofS =
        "\17\uffff";
    static final String DFA84_minS =
        "\1\62\4\0\12\uffff";
    static final String DFA84_maxS =
        "\1\126\4\0\12\uffff";
    static final String DFA84_acceptS =
        "\5\uffff\1\2\3\uffff\1\3\3\uffff\1\4\1\1";
    static final String DFA84_specialS =
        "\1\0\1\1\1\2\1\3\1\4\12\uffff}>";
    static final String[] DFA84_transitionS = {
            "\1\4\1\uffff\1\11\5\uffff\2\5\4\uffff\1\1\2\uffff\1\11\1\3"+
            "\1\11\5\uffff\1\2\1\uffff\1\5\6\uffff\1\11\1\15\1\5",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            ""
    };

    static final short[] DFA84_eot = DFA.unpackEncodedString(DFA84_eotS);
    static final short[] DFA84_eof = DFA.unpackEncodedString(DFA84_eofS);
    static final char[] DFA84_min = DFA.unpackEncodedStringToUnsignedChars(DFA84_minS);
    static final char[] DFA84_max = DFA.unpackEncodedStringToUnsignedChars(DFA84_maxS);
    static final short[] DFA84_accept = DFA.unpackEncodedString(DFA84_acceptS);
    static final short[] DFA84_special = DFA.unpackEncodedString(DFA84_specialS);
    static final short[][] DFA84_transition;

    static {
        int numStates = DFA84_transitionS.length;
        DFA84_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA84_transition[i] = DFA.unpackEncodedString(DFA84_transitionS[i]);
        }
    }

    class DFA84 extends DFA {

        public DFA84(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 84;
            this.eot = DFA84_eot;
            this.eof = DFA84_eof;
            this.min = DFA84_min;
            this.max = DFA84_max;
            this.accept = DFA84_accept;
            this.special = DFA84_special;
            this.transition = DFA84_transition;
        }
        public String getDescription() {
            return "921:1: rewrite_alternative options {k=1; } : ({...}? => rewrite_template | {...}? => ( rewrite_element )+ -> {!stream_rewrite_element.hasNext()}? ^( ALT[LT(1),\"ALT\"] EPSILON[\"epsilon\"] EOA[\"<end-of-alt>\"] ) -> ^( ALT[LT(1),\"ALT\"] ( rewrite_element )+ EOA[\"<end-of-alt>\"] ) | -> ^( ALT[LT(1),\"ALT\"] EPSILON[\"epsilon\"] EOA[\"<end-of-alt>\"] ) | {...}? ETC );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA84_0 = input.LA(1);

                         
                        int index84_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA84_0==TOKEN_REF) && ((((grammar.buildTemplate())&&(LT(1).getText().equals("template")))||((grammar.buildTemplate())&&(LT(1).getText().equals("template")))||((grammar.buildTemplate())&&(LT(1).getText().equals("template")))||(grammar.buildAST())||(grammar.buildTemplate())||((grammar.buildTemplate())&&(LT(1).getText().equals("template")))))) {s = 1;}

                        else if ( (LA84_0==RULE_REF) && ((((grammar.buildTemplate())&&(LT(1).getText().equals("template")))||(grammar.buildAST())||(grammar.buildTemplate())||((grammar.buildTemplate())&&(LT(1).getText().equals("template")))||((grammar.buildTemplate())&&(LT(1).getText().equals("template")))||((grammar.buildTemplate())&&(LT(1).getText().equals("template")))))) {s = 2;}

                        else if ( (LA84_0==LPAREN) && (((grammar.buildAST())||(grammar.buildTemplate())))) {s = 3;}

                        else if ( (LA84_0==ACTION) && (((grammar.buildAST())||(grammar.buildTemplate())))) {s = 4;}

                        else if ( ((LA84_0>=STRING_LITERAL && LA84_0<=CHAR_LITERAL)||LA84_0==TREE_BEGIN||LA84_0==DOLLAR) && ((grammar.buildAST()))) {s = 5;}

                        else if ( (LA84_0==SEMI||LA84_0==OR||LA84_0==RPAREN||LA84_0==REWRITE) ) {s = 9;}

                        else if ( (LA84_0==ETC) ) {s = 13;}

                         
                        input.seek(index84_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA84_1 = input.LA(1);

                         
                        int index84_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((grammar.buildTemplate())&&(LT(1).getText().equals("template")))||(grammar.buildTemplate()))) ) {s = 14;}

                        else if ( ((grammar.buildAST())) ) {s = 5;}

                         
                        input.seek(index84_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA84_2 = input.LA(1);

                         
                        int index84_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((grammar.buildTemplate())&&(LT(1).getText().equals("template")))||(grammar.buildTemplate()))) ) {s = 14;}

                        else if ( ((grammar.buildAST())) ) {s = 5;}

                         
                        input.seek(index84_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA84_3 = input.LA(1);

                         
                        int index84_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((grammar.buildTemplate())) ) {s = 14;}

                        else if ( ((grammar.buildAST())) ) {s = 5;}

                         
                        input.seek(index84_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA84_4 = input.LA(1);

                         
                        int index84_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((grammar.buildTemplate())) ) {s = 14;}

                        else if ( ((grammar.buildAST())) ) {s = 5;}

                         
                        input.seek(index84_4);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 84, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ACTION_in_grammar_318 = new BitSet(new long[]{0x0008000000004130L});
    public static final BitSet FOLLOW_DOC_COMMENT_in_grammar_329 = new BitSet(new long[]{0x0008000000004130L});
    public static final BitSet FOLLOW_grammarType_in_grammar_339 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000801L});
    public static final BitSet FOLLOW_id_in_grammar_343 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_SEMI_in_grammar_347 = new BitSet(new long[]{0x80A88C0000000E00L,0x0000000000000801L});
    public static final BitSet FOLLOW_optionsSpec_in_grammar_353 = new BitSet(new long[]{0x80A88C0000000E00L,0x0000000000000801L});
    public static final BitSet FOLLOW_delegateGrammars_in_grammar_367 = new BitSet(new long[]{0x80A88C0000000E00L,0x0000000000000801L});
    public static final BitSet FOLLOW_tokensSpec_in_grammar_376 = new BitSet(new long[]{0x80A88C0000000E00L,0x0000000000000801L});
    public static final BitSet FOLLOW_attrScopes_in_grammar_384 = new BitSet(new long[]{0x80A88C0000000E00L,0x0000000000000801L});
    public static final BitSet FOLLOW_actions_in_grammar_391 = new BitSet(new long[]{0x80A88C0000000E00L,0x0000000000000801L});
    public static final BitSet FOLLOW_rules_in_grammar_399 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_grammar_403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEXER_in_grammarType454 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_GRAMMAR_in_grammarType459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARSER_in_grammarType482 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_GRAMMAR_in_grammarType486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TREE_in_grammarType507 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_GRAMMAR_in_grammarType513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GRAMMAR_in_grammarType536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_action_in_actions563 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_AMPERSAND_in_action578 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000801L});
    public static final BitSet FOLLOW_actionScopeName_in_action582 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_COLON_in_action584 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_COLON_in_action587 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000801L});
    public static final BitSet FOLLOW_id_in_action592 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_ACTION_in_action594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_actionScopeName607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEXER_in_actionScopeName614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARSER_in_actionScopeName628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPTIONS_in_optionsSpec650 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000801L});
    public static final BitSet FOLLOW_option_in_optionsSpec654 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_SEMI_in_optionsSpec657 = new BitSet(new long[]{0x0100000000000000L,0x0000000000000801L});
    public static final BitSet FOLLOW_RCURLY_in_optionsSpec662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_option675 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_ASSIGN_in_option677 = new BitSet(new long[]{0x3C00000000000000L,0x0000000000000801L});
    public static final BitSet FOLLOW_optionValue_in_option680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_optionValue701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_optionValue713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_optionValue722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_optionValue733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_optionValue753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_delegateGrammars778 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000801L});
    public static final BitSet FOLLOW_delegateGrammar_in_delegateGrammars781 = new BitSet(new long[]{0x4010000000000000L});
    public static final BitSet FOLLOW_COMMA_in_delegateGrammars784 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000801L});
    public static final BitSet FOLLOW_delegateGrammar_in_delegateGrammars787 = new BitSet(new long[]{0x4010000000000000L});
    public static final BitSet FOLLOW_SEMI_in_delegateGrammars791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_delegateGrammar805 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_ASSIGN_in_delegateGrammar807 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000801L});
    public static final BitSet FOLLOW_id_in_delegateGrammar812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_delegateGrammar821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOKENS_in_tokensSpec848 = new BitSet(new long[]{0x0100000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_tokenSpec_in_tokensSpec854 = new BitSet(new long[]{0x0100000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_RCURLY_in_tokensSpec859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOKEN_REF_in_tokenSpec871 = new BitSet(new long[]{0x0210000000000000L});
    public static final BitSet FOLLOW_ASSIGN_in_tokenSpec875 = new BitSet(new long[]{0x0C00000000000000L});
    public static final BitSet FOLLOW_set_in_tokenSpec878 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_SEMI_in_tokenSpec887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attrScope_in_attrScopes900 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_SCOPE_in_attrScope913 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000801L});
    public static final BitSet FOLLOW_id_in_attrScope916 = new BitSet(new long[]{0x0024000000000000L});
    public static final BitSet FOLLOW_ruleActions_in_attrScope918 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_ACTION_in_attrScope921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule_in_rules934 = new BitSet(new long[]{0x80A88C0000000E02L,0x0000000000000801L});
    public static final BitSet FOLLOW_DOC_COMMENT_in_rule964 = new BitSet(new long[]{0x0000800000000E00L,0x0000000000000801L});
    public static final BitSet FOLLOW_PROTECTED_in_rule977 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000801L});
    public static final BitSet FOLLOW_PUBLIC_in_rule986 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000801L});
    public static final BitSet FOLLOW_PRIVATE_in_rule996 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000801L});
    public static final BitSet FOLLOW_FRAGMENT_in_rule1005 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000801L});
    public static final BitSet FOLLOW_id_in_rule1017 = new BitSet(new long[]{0x00E0040000003000L,0x0000000000000006L});
    public static final BitSet FOLLOW_BANG_in_rule1027 = new BitSet(new long[]{0x00E0040000003000L,0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_rule1038 = new BitSet(new long[]{0x00E0040000003000L});
    public static final BitSet FOLLOW_RETURNS_in_rule1047 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_rule1051 = new BitSet(new long[]{0x00E0040000002000L});
    public static final BitSet FOLLOW_throwsSpec_in_rule1061 = new BitSet(new long[]{0x00E0040000000000L});
    public static final BitSet FOLLOW_optionsSpec_in_rule1070 = new BitSet(new long[]{0x0060040000000000L});
    public static final BitSet FOLLOW_ruleScopeSpec_in_rule1079 = new BitSet(new long[]{0x0060000000000000L});
    public static final BitSet FOLLOW_ruleActions_in_rule1084 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_COLON_in_rule1090 = new BitSet(new long[]{0x0C04008000000000L,0x0000000000103C99L});
    public static final BitSet FOLLOW_ruleAltList_in_rule1094 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_SEMI_in_rule1099 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_exceptionGroup_in_rule1107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAction_in_ruleActions1245 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_AMPERSAND_in_ruleAction1260 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000801L});
    public static final BitSet FOLLOW_id_in_ruleAction1263 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_ACTION_in_ruleAction1265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THROWS_in_throwsSpec1276 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000801L});
    public static final BitSet FOLLOW_id_in_throwsSpec1279 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_throwsSpec1283 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000801L});
    public static final BitSet FOLLOW_id_in_throwsSpec1286 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_SCOPE_in_ruleScopeSpec1302 = new BitSet(new long[]{0x0024000000000000L});
    public static final BitSet FOLLOW_ruleActions_in_ruleScopeSpec1304 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_ACTION_in_ruleScopeSpec1307 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_SCOPE_in_ruleScopeSpec1316 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000801L});
    public static final BitSet FOLLOW_idList_in_ruleScopeSpec1318 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_SEMI_in_ruleScopeSpec1320 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_alternative_in_ruleAltList1377 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100008L});
    public static final BitSet FOLLOW_rewrite_in_ruleAltList1381 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_ruleAltList1410 = new BitSet(new long[]{0x0C04008000000000L,0x0000000000103C99L});
    public static final BitSet FOLLOW_alternative_in_ruleAltList1414 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100008L});
    public static final BitSet FOLLOW_rewrite_in_ruleAltList1418 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_LPAREN_in_block1494 = new BitSet(new long[]{0x0CE4008000000000L,0x0000000000103CB9L});
    public static final BitSet FOLLOW_optionsSpec_in_block1532 = new BitSet(new long[]{0x0060000000000000L});
    public static final BitSet FOLLOW_ruleActions_in_block1543 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_COLON_in_block1551 = new BitSet(new long[]{0x0C04008000000000L,0x0000000000103CB9L});
    public static final BitSet FOLLOW_ACTION_in_block1557 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_COLON_in_block1559 = new BitSet(new long[]{0x0C04008000000000L,0x0000000000103CB9L});
    public static final BitSet FOLLOW_alternative_in_block1571 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100028L});
    public static final BitSet FOLLOW_rewrite_in_block1575 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000028L});
    public static final BitSet FOLLOW_OR_in_block1585 = new BitSet(new long[]{0x0C04008000000000L,0x0000000000103CB9L});
    public static final BitSet FOLLOW_alternative_in_block1589 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100028L});
    public static final BitSet FOLLOW_rewrite_in_block1593 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000028L});
    public static final BitSet FOLLOW_RPAREN_in_block1610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_element_in_alternative1650 = new BitSet(new long[]{0x0C04008000000002L,0x0000000000003C91L});
    public static final BitSet FOLLOW_exceptionHandler_in_exceptionGroup1696 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_finallyClause_in_exceptionGroup1699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_finallyClause_in_exceptionGroup1705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CATCH_in_exceptionHandler1716 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_exceptionHandler1719 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_ACTION_in_exceptionHandler1721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FINALLY_in_finallyClause1732 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_ACTION_in_finallyClause1735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elementNoOptionSpec_in_element1746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_elementNoOptionSpec1766 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_ASSIGN_in_elementNoOptionSpec1769 = new BitSet(new long[]{0x0C00000000000000L,0x0000000000001C11L});
    public static final BitSet FOLLOW_PLUS_ASSIGN_in_elementNoOptionSpec1772 = new BitSet(new long[]{0x0C00000000000000L,0x0000000000001C11L});
    public static final BitSet FOLLOW_atom_in_elementNoOptionSpec1777 = new BitSet(new long[]{0x2000000000000002L,0x000000000000C000L});
    public static final BitSet FOLLOW_block_in_elementNoOptionSpec1779 = new BitSet(new long[]{0x2000000000000002L,0x000000000000C000L});
    public static final BitSet FOLLOW_ebnfSuffix_in_elementNoOptionSpec1794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_elementNoOptionSpec1812 = new BitSet(new long[]{0x2000000000000002L,0x000000000000C000L});
    public static final BitSet FOLLOW_ebnfSuffix_in_elementNoOptionSpec1821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ebnf_in_elementNoOptionSpec1837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FORCED_ACTION_in_elementNoOptionSpec1843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_elementNoOptionSpec1849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMPRED_in_elementNoOptionSpec1857 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_IMPLIES_in_elementNoOptionSpec1861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tree__in_elementNoOptionSpec1880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_range_in_atom1895 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000202L});
    public static final BitSet FOLLOW_ROOT_in_atom1898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BANG_in_atom1901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_atom1941 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_WILDCARD_in_atom1945 = new BitSet(new long[]{0x0C00000000000000L,0x0000000000000C01L});
    public static final BitSet FOLLOW_terminal_in_atom1949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleref_in_atom1951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_terminal_in_atom1960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleref_in_atom1966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_notSet_in_atom1975 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000202L});
    public static final BitSet FOLLOW_ROOT_in_atom1978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BANG_in_atom1981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REF_in_ruleref1995 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000206L});
    public static final BitSet FOLLOW_ARG_ACTION_in_ruleref1998 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000202L});
    public static final BitSet FOLLOW_ROOT_in_ruleref2002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BANG_in_ruleref2005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_notSet2019 = new BitSet(new long[]{0x0C00000000000000L,0x0000000000000011L});
    public static final BitSet FOLLOW_notTerminal_in_notSet2026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_notSet2032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_treeRoot2055 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_ASSIGN_in_treeRoot2058 = new BitSet(new long[]{0x0C00000000000000L,0x0000000000001C11L});
    public static final BitSet FOLLOW_PLUS_ASSIGN_in_treeRoot2061 = new BitSet(new long[]{0x0C00000000000000L,0x0000000000001C11L});
    public static final BitSet FOLLOW_atom_in_treeRoot2066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_treeRoot2068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_treeRoot2074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_treeRoot2079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TREE_BEGIN_in_tree_2090 = new BitSet(new long[]{0x0C00000000000000L,0x0000000000001C11L});
    public static final BitSet FOLLOW_treeRoot_in_tree_2095 = new BitSet(new long[]{0x0C04008000000000L,0x0000000000003C91L});
    public static final BitSet FOLLOW_element_in_tree_2097 = new BitSet(new long[]{0x0C04008000000000L,0x0000000000003CB1L});
    public static final BitSet FOLLOW_RPAREN_in_tree_2102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_ebnf2116 = new BitSet(new long[]{0x2000000000000002L,0x000000000000C302L});
    public static final BitSet FOLLOW_QUESTION_in_ebnf2122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_ebnf2140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_ebnf2158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPLIES_in_ebnf2176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROOT_in_ebnf2212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BANG_in_ebnf2229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_range2268 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_RANGE_in_range2270 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_range2274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_terminal2302 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010202L});
    public static final BitSet FOLLOW_elementOptions_in_terminal2307 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000202L});
    public static final BitSet FOLLOW_ROOT_in_terminal2315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BANG_in_terminal2318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOKEN_REF_in_terminal2329 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010206L});
    public static final BitSet FOLLOW_elementOptions_in_terminal2336 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000206L});
    public static final BitSet FOLLOW_ARG_ACTION_in_terminal2347 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000202L});
    public static final BitSet FOLLOW_ROOT_in_terminal2356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BANG_in_terminal2359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_terminal2370 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010202L});
    public static final BitSet FOLLOW_elementOptions_in_terminal2375 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000202L});
    public static final BitSet FOLLOW_ROOT_in_terminal2383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BANG_in_terminal2386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WILDCARD_in_terminal2397 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000202L});
    public static final BitSet FOLLOW_ROOT_in_terminal2400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BANG_in_terminal2403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_ELEMENT_OPTION_in_elementOptions2422 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000801L});
    public static final BitSet FOLLOW_defaultNodeOption_in_elementOptions2425 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_CLOSE_ELEMENT_OPTION_in_elementOptions2428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_ELEMENT_OPTION_in_elementOptions2434 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000801L});
    public static final BitSet FOLLOW_elementOption_in_elementOptions2437 = new BitSet(new long[]{0x0010000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_SEMI_in_elementOptions2441 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000801L});
    public static final BitSet FOLLOW_elementOption_in_elementOptions2444 = new BitSet(new long[]{0x0010000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_CLOSE_ELEMENT_OPTION_in_elementOptions2449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elementOptionId_in_defaultNodeOption2462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_elementOption2478 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_ASSIGN_in_elementOption2480 = new BitSet(new long[]{0x0400000000000000L,0x00000000000C0801L});
    public static final BitSet FOLLOW_elementOptionId_in_elementOption2487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_elementOption2501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_QUOTE_STRING_LITERAL_in_elementOption2505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_ANGLE_STRING_LITERAL_in_elementOption2509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_elementOptionId2540 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_WILDCARD_in_elementOptionId2545 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000801L});
    public static final BitSet FOLLOW_id_in_elementOptionId2549 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_QUESTION_in_ebnfSuffix2626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_ebnfSuffix2640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_ebnfSuffix2654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_notTerminal0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_idList2716 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_idList2719 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000801L});
    public static final BitSet FOLLOW_id_in_idList2722 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_TOKEN_REF_in_id2735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REF_in_id2747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rewrite_with_sempred_in_rewrite2767 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_REWRITE_in_rewrite2772 = new BitSet(new long[]{0x0C04000000000000L,0x0000000000602811L});
    public static final BitSet FOLLOW_rewrite_alternative_in_rewrite2774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REWRITE_in_rewrite_with_sempred2805 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_SEMPRED_in_rewrite_with_sempred2808 = new BitSet(new long[]{0x0C04000000000000L,0x0000000000602811L});
    public static final BitSet FOLLOW_rewrite_alternative_in_rewrite_with_sempred2810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_rewrite_block2821 = new BitSet(new long[]{0x0C04000000000000L,0x0000000000602831L});
    public static final BitSet FOLLOW_rewrite_alternative_in_rewrite_block2825 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RPAREN_in_rewrite_block2829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rewrite_template_in_rewrite_alternative2865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rewrite_element_in_rewrite_alternative2877 = new BitSet(new long[]{0x0C04000000000002L,0x0000000000402811L});
    public static final BitSet FOLLOW_ETC_in_rewrite_alternative2938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rewrite_atom_in_rewrite_element2953 = new BitSet(new long[]{0x2000000000000002L,0x000000000000C000L});
    public static final BitSet FOLLOW_ebnfSuffix_in_rewrite_element2973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rewrite_ebnf_in_rewrite_element2992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rewrite_tree_in_rewrite_element3001 = new BitSet(new long[]{0x2000000000000002L,0x000000000000C000L});
    public static final BitSet FOLLOW_ebnfSuffix_in_rewrite_element3021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOKEN_REF_in_rewrite_atom3048 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010004L});
    public static final BitSet FOLLOW_elementOptions_in_rewrite_atom3051 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_rewrite_atom3056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REF_in_rewrite_atom3063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_rewrite_atom3070 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_elementOptions_in_rewrite_atom3072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_rewrite_atom3082 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_elementOptions_in_rewrite_atom3084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLAR_in_rewrite_atom3092 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000801L});
    public static final BitSet FOLLOW_label_in_rewrite_atom3095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_rewrite_atom3101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOKEN_REF_in_label3112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REF_in_label3122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rewrite_block_in_rewrite_ebnf3140 = new BitSet(new long[]{0x2000000000000000L,0x000000000000C000L});
    public static final BitSet FOLLOW_QUESTION_in_rewrite_ebnf3146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_rewrite_ebnf3165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_rewrite_ebnf3184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TREE_BEGIN_in_rewrite_tree3212 = new BitSet(new long[]{0x0C04000000000000L,0x0000000000400801L});
    public static final BitSet FOLLOW_rewrite_atom_in_rewrite_tree3218 = new BitSet(new long[]{0x0C04000000000000L,0x0000000000402831L});
    public static final BitSet FOLLOW_rewrite_element_in_rewrite_tree3220 = new BitSet(new long[]{0x0C04000000000000L,0x0000000000402831L});
    public static final BitSet FOLLOW_RPAREN_in_rewrite_tree3225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rewrite_template_head_in_rewrite_template3260 = new BitSet(new long[]{0x0000000000000000L,0x00000000000C0000L});
    public static final BitSet FOLLOW_DOUBLE_QUOTE_STRING_LITERAL_in_rewrite_template3279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_ANGLE_STRING_LITERAL_in_rewrite_template3285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rewrite_template_head_in_rewrite_template3300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rewrite_indirect_template_head_in_rewrite_template3309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_rewrite_template3318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_rewrite_template_head3331 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_LPAREN_in_rewrite_template_head3335 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000821L});
    public static final BitSet FOLLOW_rewrite_template_args_in_rewrite_template_head3339 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RPAREN_in_rewrite_template_head3343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_rewrite_indirect_template_head3371 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_ACTION_in_rewrite_indirect_template_head3375 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RPAREN_in_rewrite_indirect_template_head3379 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_LPAREN_in_rewrite_indirect_template_head3383 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000821L});
    public static final BitSet FOLLOW_rewrite_template_args_in_rewrite_indirect_template_head3385 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RPAREN_in_rewrite_indirect_template_head3387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rewrite_template_arg_in_rewrite_template_args3411 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_rewrite_template_args3414 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000801L});
    public static final BitSet FOLLOW_rewrite_template_arg_in_rewrite_template_args3416 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_id_in_rewrite_template_arg3451 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_ASSIGN_in_rewrite_template_arg3455 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_ACTION_in_rewrite_template_arg3457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_synpred1_ANTLR1925 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_WILDCARD_in_synpred1_ANTLR1927 = new BitSet(new long[]{0x0C00000000000000L,0x0000000000000C01L});
    public static final BitSet FOLLOW_terminal_in_synpred1_ANTLR1930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleref_in_synpred1_ANTLR1932 = new BitSet(new long[]{0x0000000000000002L});

}