// $ANTLR 3.3 Nov 30, 2010 12:46:29 org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g 2011-08-25 14:59:46

package org.antlr.grammar.v3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.analysis.Label;
import org.antlr.analysis.LookaheadSet;
import org.antlr.analysis.NFAState;
import org.antlr.codegen.CodeGenerator;
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
import org.antlr.runtime3_4_0.NoViableAltException;
import org.antlr.runtime3_4_0.RecognitionException;
import org.antlr.runtime3_4_0.RecognizerSharedState;
import org.antlr.runtime3_4_0.Token;
import org.antlr.runtime3_4_0.tree.TreeNodeStream;
import org.antlr.runtime3_4_0.tree.TreeParser;
import org.antlr.runtime3_4_0.tree.TreeRuleReturnScope;
import org.antlr.tool.ErrorManager;
import org.antlr.tool.Grammar;
import org.antlr.tool.GrammarAST;
import org.antlr.tool.Rule;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
/** Walk a grammar and generate code by gradually building up
 *  a bigger and bigger ST.
 *
 *  Terence Parr
 *  University of San Francisco
 *  June 15, 2004
 */
public class CodeGenTreeWalker extends TreeParser {
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


        public CodeGenTreeWalker(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public CodeGenTreeWalker(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return CodeGenTreeWalker.tokenNames; }
    public String getGrammarFileName() { return "org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g"; }


    protected static final int RULE_BLOCK_NESTING_LEVEL = 0;
    protected static final int OUTER_REWRITE_NESTING_LEVEL = 0;

    private String currentRuleName = null;
    protected int blockNestingLevel = 0;
    protected int rewriteBlockNestingLevel = 0;
    private int outerAltNum = 0;
    protected ST currentBlockST = null;
    protected boolean currentAltHasASTRewrite = false;
    protected int rewriteTreeNestingLevel = 0;
    protected HashSet<Object> rewriteRuleRefs = null;

    public String getCurrentRuleName() {
        return currentRuleName;
    }

    public void setCurrentRuleName(String value) {
        currentRuleName = value;
    }

    public int getOuterAltNum() {
        return outerAltNum;
    }

    public void setOuterAltNum(int value) {
        outerAltNum = value;
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
            "codegen: " + ex.toString(),
            ex );
    }

    public final void reportError(String s) {
        System.out.println("codegen: error: " + s);
    }

    protected CodeGenerator generator;
    protected Grammar grammar;
    protected STGroup templates;

    /** The overall lexer/parser template; simulate dynamically scoped
     *  attributes by making this an instance var of the walker.
     */
    protected ST recognizerST;

    protected ST outputFileST;
    protected ST headerFileST;

    protected String outputOption = "";

    protected final ST getWildcardST(GrammarAST elementAST, GrammarAST ast_suffix, String label) {
        String name = "wildcard";
        if (grammar.type == Grammar.LEXER) {
            name = "wildcardChar";
        }
        return getTokenElementST(name, name, elementAST, ast_suffix, label);
    }

    protected final ST getRuleElementST( String name,
                                              String ruleTargetName,
                                              GrammarAST elementAST,
                                              GrammarAST ast_suffix,
                                              String label ) {
    	Rule r = grammar.getRule( currentRuleName );
    	String suffix = getSTSuffix(elementAST, ast_suffix, label);
    	if ( !r.isSynPred ) {
    		name += suffix;
    	}
    	// if we're building trees and there is no label, gen a label
    	// unless we're in a synpred rule.
    	if ( ( grammar.buildAST() || suffix.length() > 0 ) && label == null &&
    		 ( r == null || !r.isSynPred ) ) {
    		// we will need a label to do the AST or tracking, make one
    		label = generator.createUniqueLabel( ruleTargetName );
    		CommonToken labelTok = new CommonToken( ANTLRParser.ID, label );
    		grammar.defineRuleRefLabel( currentRuleName, labelTok, elementAST );
    	}

    	ST elementST = templates.getInstanceOf( name );
    	if ( label != null ) {
    		elementST.add( "label", label );
    	}


    	return elementST;
    }

    protected final ST getTokenElementST( String name,
                                               String elementName,
                                               GrammarAST elementAST,
                                               GrammarAST ast_suffix,
                                               String label ) {
        boolean tryUnchecked = false;
        if (name == "matchSet" && elementAST.enclosingRuleName != null && elementAST.enclosingRuleName.length() > 0 && Rule.getRuleType(elementAST.enclosingRuleName) == Grammar.LEXER)
        {
            if ( ( elementAST.getParent().getType() == ANTLRLexer.ALT && elementAST.getParent().getParent().getParent().getType() == RULE && elementAST.getParent().getParent().getChildCount() == 2 )
                || ( elementAST.getParent().getType() == ANTLRLexer.NOT && elementAST.getParent().getParent().getParent().getParent().getType() == RULE && elementAST.getParent().getParent().getParent().getChildCount() == 2 ) ) {
                // single alt at the start of the rule needs to be checked
            } else {
                tryUnchecked = true;
            }
        }

        String suffix = getSTSuffix( elementAST, ast_suffix, label );
        // if we're building trees and there is no label, gen a label
        // unless we're in a synpred rule.
        Rule r = grammar.getRule( currentRuleName );
        if ( ( grammar.buildAST() || suffix.length() > 0 ) && label == null &&
             ( r == null || !r.isSynPred ) )
        {
            label = generator.createUniqueLabel( elementName );
            CommonToken labelTok = new CommonToken( ANTLRParser.ID, label );
            grammar.defineTokenRefLabel( currentRuleName, labelTok, elementAST );
        }

        ST elementST = null;
        if ( tryUnchecked && templates.isDefined( name + "Unchecked" + suffix ) )
            elementST = templates.getInstanceOf( name + "Unchecked" + suffix );
        if ( elementST == null )
            elementST = templates.getInstanceOf( name + suffix );

        if ( label != null )
        {
            elementST.add( "label", label );
        }
        return elementST;
    }

    public final boolean isListLabel(String label) {
        boolean hasListLabel = false;
        if ( label != null ) {
            Rule r = grammar.getRule( currentRuleName );
            //String stName = null;
            if ( r != null )
            {
                Grammar.LabelElementPair pair = r.getLabel( label );
                if ( pair != null &&
                     ( pair.type == Grammar.TOKEN_LIST_LABEL ||
                      pair.type == Grammar.RULE_LIST_LABEL ||
                      pair.type == Grammar.WILDCARD_TREE_LIST_LABEL ) )
                {
                    hasListLabel = true;
                }
            }
        }
        return hasListLabel;
    }

    /** Return a non-empty template name suffix if the token is to be
     *  tracked, added to a tree, or both.
     */
    protected final String getSTSuffix(GrammarAST elementAST, GrammarAST ast_suffix, String label) {
        if ( grammar.type == Grammar.LEXER )
        {
            return "";
        }
        // handle list label stuff; make element use "Track"

        String operatorPart = "";
        String rewritePart = "";
        String listLabelPart = "";
        Rule ruleDescr = grammar.getRule( currentRuleName );
        if ( ast_suffix != null && !ruleDescr.isSynPred )
        {
            if ( ast_suffix.getType() == ANTLRParser.ROOT )
            {
                operatorPart = "RuleRoot";
            }
            else if ( ast_suffix.getType() == ANTLRParser.BANG )
            {
                operatorPart = "Bang";
            }
        }
        if ( currentAltHasASTRewrite && elementAST.getType() != WILDCARD )
        {
            rewritePart = "Track";
        }
        if ( isListLabel( label ) )
        {
            listLabelPart = "AndListLabel";
        }
        String STsuffix = operatorPart + rewritePart + listLabelPart;
        //JSystem.@out.println("suffix = "+STsuffix);

        return STsuffix;
    }

    /** Convert rewrite AST lists to target labels list */
    protected final List<String> getTokenTypesAsTargetLabels(Collection<GrammarAST> refs)
    {
        if ( refs == null || refs.size() == 0 )
            return null;

        List<String> labels = new ArrayList<String>( refs.size() );
        for ( GrammarAST t : refs )
        {
            String label;
            if ( t.getType() == ANTLRParser.RULE_REF || t.getType() == ANTLRParser.TOKEN_REF || t.getType() == ANTLRParser.LABEL)
            {
                label = t.getText();
            }
            else
            {
                // must be char or String literal
                label = generator.getTokenTypeAsTargetLabel(grammar.getTokenType(t.getText()));
            }
            labels.add( label );
        }
        return labels;
    }

    public final void init( Grammar g ) {
        this.grammar = g;
        this.generator = grammar.getCodeGenerator();
        this.templates = generator.getTemplates();
    }



    // $ANTLR start "grammar_"
    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:296:1: public grammar_[Grammar g,\n\t\tST recognizerST,\n\t\tST outputFileST,\n\t\tST headerFileST] : ( ^( LEXER_GRAMMAR grammarSpec ) | ^( PARSER_GRAMMAR grammarSpec ) | ^( TREE_GRAMMAR grammarSpec ) | ^( COMBINED_GRAMMAR grammarSpec ) ) ;
    public final void grammar_(Grammar g, ST recognizerST, ST outputFileST, ST headerFileST) throws RecognitionException {

        	if ( state.backtracking == 0 )
        	{
        		init(g);
        		this.recognizerST = recognizerST;
        		this.outputFileST = outputFileST;
        		this.headerFileST = headerFileST;
        		String superClass = (String)g.getOption("superClass");
        		outputOption = (String)g.getOption("output");
        		if ( superClass!=null ) recognizerST.add("superClass", superClass);
        		if ( g.type!=Grammar.LEXER ) {
        		    Object lt = g.getOption("ASTLabelType");
        			if ( lt!=null ) recognizerST.add("ASTLabelType", lt);
        		}
        		if ( g.type==Grammar.TREE_PARSER && g.getOption("ASTLabelType")==null ) {
        			ErrorManager.grammarWarning(ErrorManager.MSG_MISSING_AST_TYPE_IN_TREE_GRAMMAR,
        									   g,
        									   null,
        									   g.name);
        		}
        		if ( g.type!=Grammar.TREE_PARSER ) {
        		    Object lt = g.getOption("TokenLabelType");
        			if ( lt!=null ) recognizerST.add("labelType", lt);
        		}
        		recognizerST.add("numRules", grammar.getRules().size());
        		outputFileST.add("numRules", grammar.getRules().size());
        		headerFileST.add("numRules", grammar.getRules().size());
        	}

        try {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:331:2: ( ( ^( LEXER_GRAMMAR grammarSpec ) | ^( PARSER_GRAMMAR grammarSpec ) | ^( TREE_GRAMMAR grammarSpec ) | ^( COMBINED_GRAMMAR grammarSpec ) ) )
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:331:4: ( ^( LEXER_GRAMMAR grammarSpec ) | ^( PARSER_GRAMMAR grammarSpec ) | ^( TREE_GRAMMAR grammarSpec ) | ^( COMBINED_GRAMMAR grammarSpec ) )
            {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:331:4: ( ^( LEXER_GRAMMAR grammarSpec ) | ^( PARSER_GRAMMAR grammarSpec ) | ^( TREE_GRAMMAR grammarSpec ) | ^( COMBINED_GRAMMAR grammarSpec ) )
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:331:6: ^( LEXER_GRAMMAR grammarSpec )
                    {
                    match(input,LEXER_GRAMMAR,FOLLOW_LEXER_GRAMMAR_in_grammar_61); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_grammarSpec_in_grammar_63);
                    grammarSpec();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:332:5: ^( PARSER_GRAMMAR grammarSpec )
                    {
                    match(input,PARSER_GRAMMAR,FOLLOW_PARSER_GRAMMAR_in_grammar_73); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_grammarSpec_in_grammar_75);
                    grammarSpec();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:333:5: ^( TREE_GRAMMAR grammarSpec )
                    {
                    match(input,TREE_GRAMMAR,FOLLOW_TREE_GRAMMAR_in_grammar_85); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_grammarSpec_in_grammar_87);
                    grammarSpec();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:334:5: ^( COMBINED_GRAMMAR grammarSpec )
                    {
                    match(input,COMBINED_GRAMMAR,FOLLOW_COMBINED_GRAMMAR_in_grammar_97); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_grammarSpec_in_grammar_99);
                    grammarSpec();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;

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
    // $ANTLR end "grammar_"


    // $ANTLR start "attrScope"
    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:338:1: attrScope : ^( 'scope' ID ( ^( AMPERSAND ( . )* ) )* ACTION ) ;
    public final void attrScope() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:339:2: ( ^( 'scope' ID ( ^( AMPERSAND ( . )* ) )* ACTION ) )
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:339:4: ^( 'scope' ID ( ^( AMPERSAND ( . )* ) )* ACTION )
            {
            match(input,SCOPE,FOLLOW_SCOPE_in_attrScope118); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            match(input,ID,FOLLOW_ID_in_attrScope120); if (state.failed) return ;
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:339:18: ( ^( AMPERSAND ( . )* ) )*
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
            	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:339:20: ^( AMPERSAND ( . )* )
            	    {
            	    match(input,AMPERSAND,FOLLOW_AMPERSAND_in_attrScope125); if (state.failed) return ;

            	    if ( input.LA(1)==Token.DOWN ) {
            	        match(input, Token.DOWN, null); if (state.failed) return ;
            	        // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:339:32: ( . )*
            	        loop2:
            	        do {
            	            int alt2=2;
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
            	                alt2=1;
            	                }
            	                break;
            	            case UP:
            	                {
            	                alt2=2;
            	                }
            	                break;

            	            }

            	            switch (alt2) {
            	        	case 1 :
            	        	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:339:32: .
            	        	    {
            	        	    matchAny(input); if (state.failed) return ;

            	        	    }
            	        	    break;

            	        	default :
            	        	    break loop2;
            	            }
            	        } while (true);


            	        match(input, Token.UP, null); if (state.failed) return ;
            	    }

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match(input,ACTION,FOLLOW_ACTION_in_attrScope134); if (state.failed) return ;

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
    // $ANTLR end "attrScope"


    // $ANTLR start "grammarSpec"
    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:342:1: grammarSpec : name= ID (cmt= DOC_COMMENT )? ( ^( OPTIONS ( . )* ) )? ( ^( IMPORT ( . )* ) )? ( ^( TOKENS ( . )* ) )? ( attrScope )* ( ^( AMPERSAND ( . )* ) )* rules[recognizerST] ;
    public final void grammarSpec() throws RecognitionException {
        GrammarAST name=null;
        GrammarAST cmt=null;

        try {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:343:2: (name= ID (cmt= DOC_COMMENT )? ( ^( OPTIONS ( . )* ) )? ( ^( IMPORT ( . )* ) )? ( ^( TOKENS ( . )* ) )? ( attrScope )* ( ^( AMPERSAND ( . )* ) )* rules[recognizerST] )
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:343:6: name= ID (cmt= DOC_COMMENT )? ( ^( OPTIONS ( . )* ) )? ( ^( IMPORT ( . )* ) )? ( ^( TOKENS ( . )* ) )? ( attrScope )* ( ^( AMPERSAND ( . )* ) )* rules[recognizerST]
            {
            name=(GrammarAST)match(input,ID,FOLLOW_ID_in_grammarSpec151); if (state.failed) return ;
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:344:3: (cmt= DOC_COMMENT )?
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
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:344:5: cmt= DOC_COMMENT
                    {
                    cmt=(GrammarAST)match(input,DOC_COMMENT,FOLLOW_DOC_COMMENT_in_grammarSpec159); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				outputFileST.add("docComment", (cmt!=null?cmt.getText():null));
                      				headerFileST.add("docComment", (cmt!=null?cmt.getText():null));
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			recognizerST.add("name", grammar.getRecognizerName());
              			outputFileST.add("name", grammar.getRecognizerName());
              			headerFileST.add("name", grammar.getRecognizerName());
              			recognizerST.add("scopes", grammar.getGlobalScopes());
              			headerFileST.add("scopes", grammar.getGlobalScopes());
              		
            }
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:357:3: ( ^( OPTIONS ( . )* ) )?
            int alt6=2;
            switch ( input.LA(1) ) {
                case OPTIONS:
                    {
                    alt6=1;
                    }
                    break;
            }

            switch (alt6) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:357:5: ^( OPTIONS ( . )* )
                    {
                    match(input,OPTIONS,FOLLOW_OPTIONS_in_grammarSpec180); if (state.failed) return ;

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return ;
                        // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:357:15: ( . )*
                        loop5:
                        do {
                            int alt5=2;
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
                                alt5=1;
                                }
                                break;
                            case UP:
                                {
                                alt5=2;
                                }
                                break;

                            }

                            switch (alt5) {
                        	case 1 :
                        	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:357:15: .
                        	    {
                        	    matchAny(input); if (state.failed) return ;

                        	    }
                        	    break;

                        	default :
                        	    break loop5;
                            }
                        } while (true);


                        match(input, Token.UP, null); if (state.failed) return ;
                    }

                    }
                    break;

            }

            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:358:3: ( ^( IMPORT ( . )* ) )?
            int alt8=2;
            switch ( input.LA(1) ) {
                case IMPORT:
                    {
                    alt8=1;
                    }
                    break;
            }

            switch (alt8) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:358:5: ^( IMPORT ( . )* )
                    {
                    match(input,IMPORT,FOLLOW_IMPORT_in_grammarSpec194); if (state.failed) return ;

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return ;
                        // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:358:14: ( . )*
                        loop7:
                        do {
                            int alt7=2;
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
                                alt7=1;
                                }
                                break;
                            case UP:
                                {
                                alt7=2;
                                }
                                break;

                            }

                            switch (alt7) {
                        	case 1 :
                        	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:358:14: .
                        	    {
                        	    matchAny(input); if (state.failed) return ;

                        	    }
                        	    break;

                        	default :
                        	    break loop7;
                            }
                        } while (true);


                        match(input, Token.UP, null); if (state.failed) return ;
                    }

                    }
                    break;

            }

            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:359:3: ( ^( TOKENS ( . )* ) )?
            int alt10=2;
            switch ( input.LA(1) ) {
                case TOKENS:
                    {
                    alt10=1;
                    }
                    break;
            }

            switch (alt10) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:359:5: ^( TOKENS ( . )* )
                    {
                    match(input,TOKENS,FOLLOW_TOKENS_in_grammarSpec208); if (state.failed) return ;

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return ;
                        // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:359:14: ( . )*
                        loop9:
                        do {
                            int alt9=2;
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
                                alt9=1;
                                }
                                break;
                            case UP:
                                {
                                alt9=2;
                                }
                                break;

                            }

                            switch (alt9) {
                        	case 1 :
                        	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:359:14: .
                        	    {
                        	    matchAny(input); if (state.failed) return ;

                        	    }
                        	    break;

                        	default :
                        	    break loop9;
                            }
                        } while (true);


                        match(input, Token.UP, null); if (state.failed) return ;
                    }

                    }
                    break;

            }

            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:360:3: ( attrScope )*
            loop11:
            do {
                int alt11=2;
                switch ( input.LA(1) ) {
                case SCOPE:
                    {
                    alt11=1;
                    }
                    break;

                }

                switch (alt11) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:360:4: attrScope
            	    {
            	    pushFollow(FOLLOW_attrScope_in_grammarSpec220);
            	    attrScope();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:361:3: ( ^( AMPERSAND ( . )* ) )*
            loop13:
            do {
                int alt13=2;
                switch ( input.LA(1) ) {
                case AMPERSAND:
                    {
                    alt13=1;
                    }
                    break;

                }

                switch (alt13) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:361:5: ^( AMPERSAND ( . )* )
            	    {
            	    match(input,AMPERSAND,FOLLOW_AMPERSAND_in_grammarSpec229); if (state.failed) return ;

            	    if ( input.LA(1)==Token.DOWN ) {
            	        match(input, Token.DOWN, null); if (state.failed) return ;
            	        // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:361:17: ( . )*
            	        loop12:
            	        do {
            	            int alt12=2;
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
            	                alt12=1;
            	                }
            	                break;
            	            case UP:
            	                {
            	                alt12=2;
            	                }
            	                break;

            	            }

            	            switch (alt12) {
            	        	case 1 :
            	        	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:361:17: .
            	        	    {
            	        	    matchAny(input); if (state.failed) return ;

            	        	    }
            	        	    break;

            	        	default :
            	        	    break loop12;
            	            }
            	        } while (true);


            	        match(input, Token.UP, null); if (state.failed) return ;
            	    }

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            pushFollow(FOLLOW_rules_in_grammarSpec240);
            rules(recognizerST);

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


    // $ANTLR start "rules"
    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:365:1: rules[ST recognizerST] : ( ( options {k=1; } : {...}? =>rST= rule | ^( RULE ( . )* ) | ^( PREC_RULE ( . )* ) ) )+ ;
    public final void rules(ST recognizerST) throws RecognitionException {
        CodeGenTreeWalker.rule_return rST = null;



        	String ruleName = ((GrammarAST)input.LT(1)).getChild(0).getText();
        	boolean generated = grammar.generateMethodForRule(ruleName);

        try {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:371:2: ( ( ( options {k=1; } : {...}? =>rST= rule | ^( RULE ( . )* ) | ^( PREC_RULE ( . )* ) ) )+ )
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:371:4: ( ( options {k=1; } : {...}? =>rST= rule | ^( RULE ( . )* ) | ^( PREC_RULE ( . )* ) ) )+
            {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:371:4: ( ( options {k=1; } : {...}? =>rST= rule | ^( RULE ( . )* ) | ^( PREC_RULE ( . )* ) ) )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                switch ( input.LA(1) ) {
                case RULE:
                case PREC_RULE:
                    {
                    alt17=1;
                    }
                    break;

                }

                switch (alt17) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:371:6: ( options {k=1; } : {...}? =>rST= rule | ^( RULE ( . )* ) | ^( PREC_RULE ( . )* ) )
            	    {
            	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:371:6: ( options {k=1; } : {...}? =>rST= rule | ^( RULE ( . )* ) | ^( PREC_RULE ( . )* ) )
            	    int alt16=3;
            	    switch ( input.LA(1) ) {
            	    case RULE:
            	        {
            	        int LA16_1 = input.LA(2);

            	        if ( ((generated)) ) {
            	            alt16=1;
            	        }
            	        else if ( (true) ) {
            	            alt16=2;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return ;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 16, 1, input);

            	            throw nvae;
            	        }
            	        }
            	        break;
            	    case PREC_RULE:
            	        {
            	        alt16=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 16, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt16) {
            	        case 1 :
            	            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:372:5: {...}? =>rST= rule
            	            {
            	            if ( !((generated)) ) {
            	                if (state.backtracking>0) {state.failed=true; return ;}
            	                throw new FailedPredicateException(input, "rules", "generated");
            	            }
            	            pushFollow(FOLLOW_rule_in_rules285);
            	            rST=rule();

            	            state._fsp--;
            	            if (state.failed) return ;
            	            if ( state.backtracking==0 ) {

            	              					if ( (rST!=null?rST.code:null) != null )
            	              					{
            	              						recognizerST.add("rules", (rST!=null?rST.code:null));
            	              						outputFileST.add("rules", (rST!=null?rST.code:null));
            	              						headerFileST.add("rules", (rST!=null?rST.code:null));
            	              					}
            	              				
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:382:6: ^( RULE ( . )* )
            	            {
            	            match(input,RULE,FOLLOW_RULE_in_rules299); if (state.failed) return ;

            	            if ( input.LA(1)==Token.DOWN ) {
            	                match(input, Token.DOWN, null); if (state.failed) return ;
            	                // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:382:13: ( . )*
            	                loop14:
            	                do {
            	                    int alt14=2;
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
            	                        alt14=1;
            	                        }
            	                        break;
            	                    case UP:
            	                        {
            	                        alt14=2;
            	                        }
            	                        break;

            	                    }

            	                    switch (alt14) {
            	                	case 1 :
            	                	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:382:13: .
            	                	    {
            	                	    matchAny(input); if (state.failed) return ;

            	                	    }
            	                	    break;

            	                	default :
            	                	    break loop14;
            	                    }
            	                } while (true);


            	                match(input, Token.UP, null); if (state.failed) return ;
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:383:6: ^( PREC_RULE ( . )* )
            	            {
            	            match(input,PREC_RULE,FOLLOW_PREC_RULE_in_rules311); if (state.failed) return ;

            	            if ( input.LA(1)==Token.DOWN ) {
            	                match(input, Token.DOWN, null); if (state.failed) return ;
            	                // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:383:18: ( . )*
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
            	                	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:383:18: .
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

            	    }


            	    				if ( input.LA(1) == RULE )
            	    				{
            	    					ruleName = ((GrammarAST)input.LT(1)).getChild(0).getText();
            	    					//System.Diagnostics.Debug.Assert( ruleName == ((GrammarAST)input.LT(1)).enclosingRuleName );
            	    					generated = grammar.generateMethodForRule(ruleName);
            	    				}
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
            	    if (state.backtracking>0) {state.failed=true; return ;}
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

    public static class rule_return extends TreeRuleReturnScope {
        public ST code=null;
    };

    // $ANTLR start "rule"
    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:396:1: rule returns [ST code=null] : ^( RULE id= ID (mod= modifier )? ^( ARG ( ARG_ACTION )? ) ^( RET ( ARG_ACTION )? ) ( throwsSpec )? ( ^( OPTIONS ( . )* ) )? ( ruleScopeSpec )? ( ^( AMPERSAND ( . )* ) )* b= block[\"ruleBlock\", dfa] ( exceptionGroup[$code] )? EOR ) ;
    public final CodeGenTreeWalker.rule_return rule() throws RecognitionException {
        CodeGenTreeWalker.rule_return retval = new CodeGenTreeWalker.rule_return();
        retval.start = input.LT(1);

        GrammarAST id=null;
        CodeGenTreeWalker.modifier_return mod = null;

        CodeGenTreeWalker.block_return b = null;



        	String initAction = null;
        	// get the dfa for the BLOCK
        	GrammarAST block2=(GrammarAST)((GrammarAST)retval.start).getFirstChildWithType(BLOCK);
        	org.antlr.analysis.DFA dfa = block2.getLookaheadDFA();
        	// init blockNestingLevel so it's block level RULE_BLOCK_NESTING_LEVEL
        	// for alts of rule
        	blockNestingLevel = RULE_BLOCK_NESTING_LEVEL-1;
        	Rule ruleDescr = grammar.getRule(((GrammarAST)retval.start).getChild(0).getText());
        	currentRuleName = ((GrammarAST)retval.start).getChild(0).getText();

        	// For syn preds, we don't want any AST code etc... in there.
        	// Save old templates ptr and restore later.  Base templates include Dbg.
        	STGroup saveGroup = templates;
        	if ( ruleDescr.isSynPred )
        	{
        		templates = generator.getBaseTemplates();
        	}

        	String description = "";

        try {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:419:2: ( ^( RULE id= ID (mod= modifier )? ^( ARG ( ARG_ACTION )? ) ^( RET ( ARG_ACTION )? ) ( throwsSpec )? ( ^( OPTIONS ( . )* ) )? ( ruleScopeSpec )? ( ^( AMPERSAND ( . )* ) )* b= block[\"ruleBlock\", dfa] ( exceptionGroup[$code] )? EOR ) )
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:419:4: ^( RULE id= ID (mod= modifier )? ^( ARG ( ARG_ACTION )? ) ^( RET ( ARG_ACTION )? ) ( throwsSpec )? ( ^( OPTIONS ( . )* ) )? ( ruleScopeSpec )? ( ^( AMPERSAND ( . )* ) )* b= block[\"ruleBlock\", dfa] ( exceptionGroup[$code] )? EOR )
            {
            match(input,RULE,FOLLOW_RULE_in_rule353); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            id=(GrammarAST)match(input,ID,FOLLOW_ID_in_rule357); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              assert currentRuleName == (id!=null?id.getText():null);
            }
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:421:4: (mod= modifier )?
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
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:421:5: mod= modifier
                    {
                    pushFollow(FOLLOW_modifier_in_rule370);
                    mod=modifier();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }

            match(input,ARG,FOLLOW_ARG_in_rule378); if (state.failed) return retval;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:422:10: ( ARG_ACTION )?
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
                        // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:422:11: ARG_ACTION
                        {
                        match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rule381); if (state.failed) return retval;

                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            match(input,RET,FOLLOW_RET_in_rule390); if (state.failed) return retval;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:423:10: ( ARG_ACTION )?
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
                        // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:423:11: ARG_ACTION
                        {
                        match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rule393); if (state.failed) return retval;

                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:424:4: ( throwsSpec )?
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
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:424:5: throwsSpec
                    {
                    pushFollow(FOLLOW_throwsSpec_in_rule402);
                    throwsSpec();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }

            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:425:4: ( ^( OPTIONS ( . )* ) )?
            int alt23=2;
            switch ( input.LA(1) ) {
                case OPTIONS:
                    {
                    alt23=1;
                    }
                    break;
            }

            switch (alt23) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:425:6: ^( OPTIONS ( . )* )
                    {
                    match(input,OPTIONS,FOLLOW_OPTIONS_in_rule412); if (state.failed) return retval;

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:425:16: ( . )*
                        loop22:
                        do {
                            int alt22=2;
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
                                alt22=1;
                                }
                                break;
                            case UP:
                                {
                                alt22=2;
                                }
                                break;

                            }

                            switch (alt22) {
                        	case 1 :
                        	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:425:16: .
                        	    {
                        	    matchAny(input); if (state.failed) return retval;

                        	    }
                        	    break;

                        	default :
                        	    break loop22;
                            }
                        } while (true);


                        match(input, Token.UP, null); if (state.failed) return retval;
                    }

                    }
                    break;

            }

            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:426:4: ( ruleScopeSpec )?
            int alt24=2;
            switch ( input.LA(1) ) {
                case SCOPE:
                    {
                    alt24=1;
                    }
                    break;
            }

            switch (alt24) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:426:5: ruleScopeSpec
                    {
                    pushFollow(FOLLOW_ruleScopeSpec_in_rule425);
                    ruleScopeSpec();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }

            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:427:4: ( ^( AMPERSAND ( . )* ) )*
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
            	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:427:6: ^( AMPERSAND ( . )* )
            	    {
            	    match(input,AMPERSAND,FOLLOW_AMPERSAND_in_rule435); if (state.failed) return retval;

            	    if ( input.LA(1)==Token.DOWN ) {
            	        match(input, Token.DOWN, null); if (state.failed) return retval;
            	        // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:427:18: ( . )*
            	        loop25:
            	        do {
            	            int alt25=2;
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
            	                alt25=1;
            	                }
            	                break;
            	            case UP:
            	                {
            	                alt25=2;
            	                }
            	                break;

            	            }

            	            switch (alt25) {
            	        	case 1 :
            	        	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:427:18: .
            	        	    {
            	        	    matchAny(input); if (state.failed) return retval;

            	        	    }
            	        	    break;

            	        	default :
            	        	    break loop25;
            	            }
            	        } while (true);


            	        match(input, Token.UP, null); if (state.failed) return retval;
            	    }

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            pushFollow(FOLLOW_block_in_rule449);
            b=block("ruleBlock", dfa);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {

              				description =
              					grammar.grammarTreeToString((GrammarAST)((GrammarAST)retval.start).getFirstChildWithType(BLOCK),
              												false);
              				description =
              					generator.target.getTargetStringLiteralFromString(description);
              				(b!=null?b.code:null).add("description", description);
              				// do not generate lexer rules in combined grammar
              				String stName = null;
              				if ( ruleDescr.isSynPred )
              				{
              					stName = "synpredRule";
              				}
              				else if ( grammar.type==Grammar.LEXER )
              				{
              					if ( currentRuleName.equals(Grammar.ARTIFICIAL_TOKENS_RULENAME) )
              					{
              						stName = "tokensRule";
              					}
              					else
              					{
              						stName = "lexerRule";
              					}
              				}
              				else
              				{
              					if ( !(grammar.type==Grammar.COMBINED &&
              						 Rule.getRuleType(currentRuleName) == Grammar.LEXER) )
              					{
              						stName = "rule";
              					}
              				}
              				retval.code = templates.getInstanceOf(stName);
              				if ( retval.code.getName().equals("/rule") )
              				{
              					retval.code.add("emptyRule", grammar.isEmptyRule(block2));
              				}
              				retval.code.add("ruleDescriptor", ruleDescr);
              				String memo = (String)grammar.getBlockOption(((GrammarAST)retval.start),"memoize");
              				if ( memo==null )
              				{
              					memo = (String)grammar.getOption("memoize");
              				}
              				if ( memo!=null && memo.equals("true") &&
              					 (stName.equals("rule")||stName.equals("lexerRule")) )
              				{
              					retval.code.add("memoize", memo!=null && memo.equals("true"));
              				}
              			
            }
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:479:4: ( exceptionGroup[$code] )?
            int alt27=2;
            switch ( input.LA(1) ) {
                case CATCH:
                case FINALLY:
                    {
                    alt27=1;
                    }
                    break;
            }

            switch (alt27) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:479:5: exceptionGroup[$code]
                    {
                    pushFollow(FOLLOW_exceptionGroup_in_rule462);
                    exceptionGroup(retval.code);

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }

            match(input,EOR,FOLLOW_EOR_in_rule470); if (state.failed) return retval;

            match(input, Token.UP, null); if (state.failed) return retval;
            if ( state.backtracking==0 ) {

              			if ( retval.code!=null )
              			{
              				if ( grammar.type==Grammar.LEXER )
              				{
              					boolean naked =
              						currentRuleName.equals(Grammar.ARTIFICIAL_TOKENS_RULENAME) ||
              						((mod!=null?((GrammarAST)mod.start):null)!=null&&(mod!=null?((GrammarAST)mod.start):null).getText().equals(Grammar.FRAGMENT_RULE_MODIFIER));
              					retval.code.add("nakedBlock", naked);
              				}
              				else
              				{
              					description = grammar.grammarTreeToString(((GrammarAST)retval.start),false);
              					description = generator.target.getTargetStringLiteralFromString(description);
              					retval.code.add("description", description);
              				}
              				Rule theRule = grammar.getRule(currentRuleName);
              				generator.translateActionAttributeReferencesForSingleScope(
              					theRule,
              					theRule.getActions()
              				);
              				retval.code.add("ruleName", currentRuleName);
              				retval.code.add("block", (b!=null?b.code:null));
              				if ( initAction!=null )
              				{
              					retval.code.add("initAction", initAction);
              				}
              			}
              		
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
             templates = saveGroup; 
        }
        return retval;
    }
    // $ANTLR end "rule"

    public static class modifier_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "modifier"
    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:514:1: modifier : ( 'protected' | 'public' | 'private' | 'fragment' );
    public final CodeGenTreeWalker.modifier_return modifier() throws RecognitionException {
        CodeGenTreeWalker.modifier_return retval = new CodeGenTreeWalker.modifier_return();
        retval.start = input.LT(1);

        try {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:515:2: ( 'protected' | 'public' | 'private' | 'fragment' )
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:
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
    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:521:1: throwsSpec : ^( 'throws' ( ID )+ ) ;
    public final void throwsSpec() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:522:2: ( ^( 'throws' ( ID )+ ) )
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:522:4: ^( 'throws' ( ID )+ )
            {
            match(input,THROWS,FOLLOW_THROWS_in_throwsSpec520); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:522:15: ( ID )+
            int cnt28=0;
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
            	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:522:15: ID
            	    {
            	    match(input,ID,FOLLOW_ID_in_throwsSpec522); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt28 >= 1 ) break loop28;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(28, input);
                        throw eee;
                }
                cnt28++;
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
    // $ANTLR end "throwsSpec"


    // $ANTLR start "ruleScopeSpec"
    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:525:1: ruleScopeSpec : ^( 'scope' ( ^( AMPERSAND ( . )* ) )* ( ACTION )? ( ID )* ) ;
    public final void ruleScopeSpec() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:526:2: ( ^( 'scope' ( ^( AMPERSAND ( . )* ) )* ( ACTION )? ( ID )* ) )
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:526:4: ^( 'scope' ( ^( AMPERSAND ( . )* ) )* ( ACTION )? ( ID )* )
            {
            match(input,SCOPE,FOLLOW_SCOPE_in_ruleScopeSpec537); if (state.failed) return ;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return ;
                // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:526:15: ( ^( AMPERSAND ( . )* ) )*
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
                	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:526:17: ^( AMPERSAND ( . )* )
                	    {
                	    match(input,AMPERSAND,FOLLOW_AMPERSAND_in_ruleScopeSpec542); if (state.failed) return ;

                	    if ( input.LA(1)==Token.DOWN ) {
                	        match(input, Token.DOWN, null); if (state.failed) return ;
                	        // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:526:29: ( . )*
                	        loop29:
                	        do {
                	            int alt29=2;
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
                	                alt29=1;
                	                }
                	                break;
                	            case UP:
                	                {
                	                alt29=2;
                	                }
                	                break;

                	            }

                	            switch (alt29) {
                	        	case 1 :
                	        	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:526:29: .
                	        	    {
                	        	    matchAny(input); if (state.failed) return ;

                	        	    }
                	        	    break;

                	        	default :
                	        	    break loop29;
                	            }
                	        } while (true);


                	        match(input, Token.UP, null); if (state.failed) return ;
                	    }

                	    }
                	    break;

                	default :
                	    break loop30;
                    }
                } while (true);

                // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:526:36: ( ACTION )?
                int alt31=2;
                switch ( input.LA(1) ) {
                    case ACTION:
                        {
                        alt31=1;
                        }
                        break;
                }

                switch (alt31) {
                    case 1 :
                        // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:526:37: ACTION
                        {
                        match(input,ACTION,FOLLOW_ACTION_in_ruleScopeSpec552); if (state.failed) return ;

                        }
                        break;

                }

                // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:526:46: ( ID )*
                loop32:
                do {
                    int alt32=2;
                    switch ( input.LA(1) ) {
                    case ID:
                        {
                        alt32=1;
                        }
                        break;

                    }

                    switch (alt32) {
                	case 1 :
                	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:526:48: ID
                	    {
                	    match(input,ID,FOLLOW_ID_in_ruleScopeSpec558); if (state.failed) return ;

                	    }
                	    break;

                	default :
                	    break loop32;
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
    // $ANTLR end "ruleScopeSpec"

    public static class block_return extends TreeRuleReturnScope {
        public ST code=null;
    };

    // $ANTLR start "block"
    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:529:1: block[String blockTemplateName, org.antlr.analysis.DFA dfa] returns [ST code=null] options {k=1; } : ({...}? => setBlock | ^( BLOCK ( ^( OPTIONS ( . )* ) )? (alt= alternative rew= rewrite )+ EOB ) );
    public final CodeGenTreeWalker.block_return block(String blockTemplateName, org.antlr.analysis.DFA dfa) throws RecognitionException {
        CodeGenTreeWalker.block_return retval = new CodeGenTreeWalker.block_return();
        retval.start = input.LT(1);

        CodeGenTreeWalker.alternative_return alt = null;

        CodeGenTreeWalker.rewrite_return rew = null;

        CodeGenTreeWalker.setBlock_return setBlock1 = null;



        	int altNum = 0;

        	blockNestingLevel++;
        	if ( state.backtracking == 0 )
        	{
        		ST decision = null;
        		if ( dfa != null )
        		{
        			retval.code = templates.getInstanceOf(blockTemplateName);
        			decision = generator.genLookaheadDecision(recognizerST,dfa);
        			retval.code.add("decision", decision);
        			retval.code.add("decisionNumber", dfa.getDecisionNumber());
        			retval.code.add("maxK",dfa.getMaxLookaheadDepth());
        			retval.code.add("maxAlt",dfa.getNumberOfAlts());
        		}
        		else
        		{
        			retval.code = templates.getInstanceOf(blockTemplateName+"SingleAlt");
        		}
        		retval.code.add("blockLevel", blockNestingLevel);
        		retval.code.add("enclosingBlockLevel", blockNestingLevel-1);
        		altNum = 1;
        		if ( this.blockNestingLevel==RULE_BLOCK_NESTING_LEVEL ) {
        			this.outerAltNum=1;
        		}
        	}

        try {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:561:2: ({...}? => setBlock | ^( BLOCK ( ^( OPTIONS ( . )* ) )? (alt= alternative rew= rewrite )+ EOB ) )
            int alt36=2;
            switch ( input.LA(1) ) {
            case BLOCK:
                {
                int LA36_1 = input.LA(2);

                if ( ((((GrammarAST)retval.start).getSetValue()!=null)) ) {
                    alt36=1;
                }
                else if ( (true) ) {
                    alt36=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 36, 1, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:561:4: {...}? => setBlock
                    {
                    if ( !((((GrammarAST)retval.start).getSetValue()!=null)) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "block", "$start.getSetValue()!=null");
                    }
                    pushFollow(FOLLOW_setBlock_in_block599);
                    setBlock1=setBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      			retval.code.add("alts",(setBlock1!=null?setBlock1.code:null));
                      		
                    }

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:566:4: ^( BLOCK ( ^( OPTIONS ( . )* ) )? (alt= alternative rew= rewrite )+ EOB )
                    {
                    match(input,BLOCK,FOLLOW_BLOCK_in_block612); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:567:4: ( ^( OPTIONS ( . )* ) )?
                    int alt34=2;
                    switch ( input.LA(1) ) {
                        case OPTIONS:
                            {
                            alt34=1;
                            }
                            break;
                    }

                    switch (alt34) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:567:6: ^( OPTIONS ( . )* )
                            {
                            match(input,OPTIONS,FOLLOW_OPTIONS_in_block620); if (state.failed) return retval;

                            if ( input.LA(1)==Token.DOWN ) {
                                match(input, Token.DOWN, null); if (state.failed) return retval;
                                // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:567:16: ( . )*
                                loop33:
                                do {
                                    int alt33=2;
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
                                        alt33=1;
                                        }
                                        break;
                                    case UP:
                                        {
                                        alt33=2;
                                        }
                                        break;

                                    }

                                    switch (alt33) {
                                	case 1 :
                                	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:567:16: .
                                	    {
                                	    matchAny(input); if (state.failed) return retval;

                                	    }
                                	    break;

                                	default :
                                	    break loop33;
                                    }
                                } while (true);


                                match(input, Token.UP, null); if (state.failed) return retval;
                            }

                            }
                            break;

                    }

                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:568:4: (alt= alternative rew= rewrite )+
                    int cnt35=0;
                    loop35:
                    do {
                        int alt35=2;
                        switch ( input.LA(1) ) {
                        case ALT:
                            {
                            alt35=1;
                            }
                            break;

                        }

                        switch (alt35) {
                    	case 1 :
                    	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:568:6: alt= alternative rew= rewrite
                    	    {
                    	    pushFollow(FOLLOW_alternative_in_block637);
                    	    alt=alternative();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    pushFollow(FOLLOW_rewrite_in_block641);
                    	    rew=rewrite();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {

                    	      					if ( this.blockNestingLevel==RULE_BLOCK_NESTING_LEVEL )
                    	      					{
                    	      						this.outerAltNum++;
                    	      					}
                    	      					// add the rewrite code as just another element in the alt :)
                    	      					// (unless it's a " -> ..." rewrite
                    	      					// ( -> ... )
                    	      					GrammarAST firstRewriteAST = (GrammarAST)(rew!=null?((GrammarAST)rew.start):null).findFirstType(REWRITE);
                    	      					boolean etc =
                    	      						(rew!=null?((GrammarAST)rew.start):null).getType()==REWRITES &&
                    	      						firstRewriteAST.getChild(0)!=null &&
                    	      						firstRewriteAST.getChild(0).getType()==ETC;
                    	      					if ( (rew!=null?rew.code:null)!=null && !etc )
                    	      					{
                    	      						(alt!=null?alt.code:null).add("rew", (rew!=null?rew.code:null));
                    	      					}
                    	      					// add this alt to the list of alts for this block
                    	      					retval.code.add("alts",(alt!=null?alt.code:null));
                    	      					(alt!=null?alt.code:null).add("altNum", altNum);
                    	      					(alt!=null?alt.code:null).add("outerAlt", blockNestingLevel==RULE_BLOCK_NESTING_LEVEL);
                    	      					altNum++;
                    	      				
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt35 >= 1 ) break loop35;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(35, input);
                                throw eee;
                        }
                        cnt35++;
                    } while (true);

                    match(input,EOB,FOLLOW_EOB_in_block658); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
             blockNestingLevel--; 
        }
        return retval;
    }
    // $ANTLR end "block"

    public static class setBlock_return extends TreeRuleReturnScope {
        public ST code=null;
    };

    // $ANTLR start "setBlock"
    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:598:1: setBlock returns [ST code=null] : ^(s= BLOCK ( . )* ) ;
    public final CodeGenTreeWalker.setBlock_return setBlock() throws RecognitionException {
        CodeGenTreeWalker.setBlock_return retval = new CodeGenTreeWalker.setBlock_return();
        retval.start = input.LT(1);

        GrammarAST s=null;


        	ST setcode = null;
        	if ( state.backtracking == 0 )
        	{
        		if ( blockNestingLevel==RULE_BLOCK_NESTING_LEVEL && grammar.buildAST() )
        		{
        			Rule r = grammar.getRule(currentRuleName);
        			currentAltHasASTRewrite = r.hasRewrite(outerAltNum);
        			if ( currentAltHasASTRewrite )
        			{
        				r.trackTokenReferenceInAlt(((GrammarAST)retval.start), outerAltNum);
        			}
        		}
        	}

        try {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:615:2: ( ^(s= BLOCK ( . )* ) )
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:615:4: ^(s= BLOCK ( . )* )
            {
            s=(GrammarAST)match(input,BLOCK,FOLLOW_BLOCK_in_setBlock690); if (state.failed) return retval;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:615:14: ( . )*
                loop37:
                do {
                    int alt37=2;
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
                        alt37=1;
                        }
                        break;
                    case UP:
                        {
                        alt37=2;
                        }
                        break;

                    }

                    switch (alt37) {
                	case 1 :
                	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:615:14: .
                	    {
                	    matchAny(input); if (state.failed) return retval;

                	    }
                	    break;

                	default :
                	    break loop37;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            if ( state.backtracking==0 ) {

              			int i = ((CommonToken)s.getToken()).getTokenIndex();
              			if ( blockNestingLevel==RULE_BLOCK_NESTING_LEVEL )
              			{
              				setcode = getTokenElementST("matchRuleBlockSet", "set", s, null, null);
              			}
              			else
              			{
              				setcode = getTokenElementST("matchSet", "set", s, null, null);
              			}
              			setcode.add("elementIndex", i);
              			//if ( grammar.type!=Grammar.LEXER )
              			//{
              			//	generator.generateLocalFOLLOW(s,"set",currentRuleName,i);
              			//}
              			setcode.add("s",
              				generator.genSetExpr(templates,s.getSetValue(),1,false));
              			ST altcode=templates.getInstanceOf("alt");
              			altcode.addAggr("elements.{el,line,pos}",
              								 setcode,
              								 s.getLine(),
              								 s.getCharPositionInLine() + 1
              								);
              			altcode.add("altNum", 1);
              			altcode.add("outerAlt", blockNestingLevel==RULE_BLOCK_NESTING_LEVEL);
              			if ( !currentAltHasASTRewrite && grammar.buildAST() )
              			{
              				altcode.add("autoAST", true);
              			}
              			altcode.add("treeLevel", rewriteTreeNestingLevel);
              			retval.code = altcode;
              		
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
    // $ANTLR end "setBlock"


    // $ANTLR start "setAlternative"
    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:650:1: setAlternative : ^( ALT ( setElement )+ EOA ) ;
    public final void setAlternative() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:651:2: ( ^( ALT ( setElement )+ EOA ) )
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:651:4: ^( ALT ( setElement )+ EOA )
            {
            match(input,ALT,FOLLOW_ALT_in_setAlternative710); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:651:10: ( setElement )+
            int cnt38=0;
            loop38:
            do {
                int alt38=2;
                switch ( input.LA(1) ) {
                case CHAR_RANGE:
                case STRING_LITERAL:
                case CHAR_LITERAL:
                case TOKEN_REF:
                    {
                    alt38=1;
                    }
                    break;

                }

                switch (alt38) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:651:10: setElement
            	    {
            	    pushFollow(FOLLOW_setElement_in_setAlternative712);
            	    setElement();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt38 >= 1 ) break loop38;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(38, input);
                        throw eee;
                }
                cnt38++;
            } while (true);

            match(input,EOA,FOLLOW_EOA_in_setAlternative715); if (state.failed) return ;

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
    // $ANTLR end "setAlternative"


    // $ANTLR start "exceptionGroup"
    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:654:1: exceptionGroup[ST ruleST] : ( ( exceptionHandler[$ruleST] )+ ( finallyClause[$ruleST] )? | finallyClause[$ruleST] );
    public final void exceptionGroup(ST ruleST) throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:655:2: ( ( exceptionHandler[$ruleST] )+ ( finallyClause[$ruleST] )? | finallyClause[$ruleST] )
            int alt41=2;
            switch ( input.LA(1) ) {
            case CATCH:
                {
                alt41=1;
                }
                break;
            case FINALLY:
                {
                alt41=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:655:4: ( exceptionHandler[$ruleST] )+ ( finallyClause[$ruleST] )?
                    {
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:655:4: ( exceptionHandler[$ruleST] )+
                    int cnt39=0;
                    loop39:
                    do {
                        int alt39=2;
                        switch ( input.LA(1) ) {
                        case CATCH:
                            {
                            alt39=1;
                            }
                            break;

                        }

                        switch (alt39) {
                    	case 1 :
                    	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:655:6: exceptionHandler[$ruleST]
                    	    {
                    	    pushFollow(FOLLOW_exceptionHandler_in_exceptionGroup730);
                    	    exceptionHandler(ruleST);

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt39 >= 1 ) break loop39;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(39, input);
                                throw eee;
                        }
                        cnt39++;
                    } while (true);

                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:655:35: ( finallyClause[$ruleST] )?
                    int alt40=2;
                    switch ( input.LA(1) ) {
                        case FINALLY:
                            {
                            alt40=1;
                            }
                            break;
                    }

                    switch (alt40) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:655:36: finallyClause[$ruleST]
                            {
                            pushFollow(FOLLOW_finallyClause_in_exceptionGroup737);
                            finallyClause(ruleST);

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:656:4: finallyClause[$ruleST]
                    {
                    pushFollow(FOLLOW_finallyClause_in_exceptionGroup745);
                    finallyClause(ruleST);

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
    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:659:1: exceptionHandler[ST ruleST] : ^( 'catch' ARG_ACTION ACTION ) ;
    public final void exceptionHandler(ST ruleST) throws RecognitionException {
        GrammarAST ACTION2=null;
        GrammarAST ARG_ACTION3=null;

        try {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:660:2: ( ^( 'catch' ARG_ACTION ACTION ) )
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:660:4: ^( 'catch' ARG_ACTION ACTION )
            {
            match(input,CATCH,FOLLOW_CATCH_in_exceptionHandler759); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            ARG_ACTION3=(GrammarAST)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_exceptionHandler761); if (state.failed) return ;
            ACTION2=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_exceptionHandler763); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			List chunks = generator.translateAction(currentRuleName,ACTION2);
              			ruleST.addAggr("exceptions.{decl,action}",(ARG_ACTION3!=null?ARG_ACTION3.getText():null),chunks);
              		
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
    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:667:1: finallyClause[ST ruleST] : ^( 'finally' ACTION ) ;
    public final void finallyClause(ST ruleST) throws RecognitionException {
        GrammarAST ACTION4=null;

        try {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:668:2: ( ^( 'finally' ACTION ) )
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:668:4: ^( 'finally' ACTION )
            {
            match(input,FINALLY,FOLLOW_FINALLY_in_finallyClause781); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            ACTION4=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_finallyClause783); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			List chunks = generator.translateAction(currentRuleName,ACTION4);
              			ruleST.add("finally",chunks);
              		
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

    public static class alternative_return extends TreeRuleReturnScope {
        public ST code;
    };

    // $ANTLR start "alternative"
    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:675:1: alternative returns [ST code] : ^(a= ALT (e= element[null,null] )+ EOA ) ;
    public final CodeGenTreeWalker.alternative_return alternative() throws RecognitionException {
        CodeGenTreeWalker.alternative_return retval = new CodeGenTreeWalker.alternative_return();
        retval.start = input.LT(1);

        GrammarAST a=null;
        CodeGenTreeWalker.element_return e = null;



        	if ( state.backtracking == 0 )
        	{
        		retval.code = templates.getInstanceOf("alt");
        		if ( blockNestingLevel==RULE_BLOCK_NESTING_LEVEL && grammar.buildAST() )
        		{
        			Rule r = grammar.getRule(currentRuleName);
        			currentAltHasASTRewrite = r.hasRewrite(outerAltNum);
        		}
        		String description = grammar.grammarTreeToString(((GrammarAST)retval.start), false);
        		description = generator.target.getTargetStringLiteralFromString(description);
        		retval.code.add("description", description);
        		retval.code.add("treeLevel", rewriteTreeNestingLevel);
        		if ( !currentAltHasASTRewrite && grammar.buildAST() )
        		{
        			retval.code.add("autoAST", true);
        		}
        	}

        try {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:696:2: ( ^(a= ALT (e= element[null,null] )+ EOA ) )
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:696:4: ^(a= ALT (e= element[null,null] )+ EOA )
            {
            a=(GrammarAST)match(input,ALT,FOLLOW_ALT_in_alternative812); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:697:4: (e= element[null,null] )+
            int cnt42=0;
            loop42:
            do {
                int alt42=2;
                switch ( input.LA(1) ) {
                case BLOCK:
                case OPTIONAL:
                case CLOSURE:
                case POSITIVE_CLOSURE:
                case SYNPRED:
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
                    alt42=1;
                    }
                    break;

                }

                switch (alt42) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:698:5: e= element[null,null]
            	    {
            	    pushFollow(FOLLOW_element_in_alternative825);
            	    e=element(null, null);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {

            	      					if (e != null && e.code != null)
            	      					{
            	      						retval.code.addAggr("elements.{el,line,pos}",
            	      										  (e!=null?e.code:null),
            	      										  (e!=null?((GrammarAST)e.start):null).getLine(),
            	      										  (e!=null?((GrammarAST)e.start):null).getCharPositionInLine() + 1
            	      										 );
            	      					}
            	      				
            	    }

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

            match(input,EOA,FOLLOW_EOA_in_alternative843); if (state.failed) return retval;

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
    // $ANTLR end "alternative"

    public static class element_return extends TreeRuleReturnScope {
        public ST code=null;
    };

    // $ANTLR start "element"
    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:714:1: element[GrammarAST label, GrammarAST astSuffix] returns [ST code=null] options {k=1; } : ( ^( ROOT e= element[label,$ROOT] ) | ^( BANG e= element[label,$BANG] ) | ^(n= NOT notElement[$n, $label, $astSuffix] ) | ^( ASSIGN alabel= ID e= element[$alabel,$astSuffix] ) | ^( PLUS_ASSIGN label2= ID e= element[$label2,$astSuffix] ) | ^( CHAR_RANGE a= CHAR_LITERAL b= CHAR_LITERAL ) | ({...}? ( BLOCK | OPTIONAL | CLOSURE | POSITIVE_CLOSURE ) )=> ebnf | atom[null, $label, $astSuffix] | tree_ | element_action | (sp= SEMPRED | sp= GATED_SEMPRED ) | SYN_SEMPRED | ^( SYNPRED ( . )* ) | ^( BACKTRACK_SEMPRED ( . )* ) | EPSILON );
    public final CodeGenTreeWalker.element_return element(GrammarAST label, GrammarAST astSuffix) throws RecognitionException {
        CodeGenTreeWalker.element_return retval = new CodeGenTreeWalker.element_return();
        retval.start = input.LT(1);

        GrammarAST n=null;
        GrammarAST alabel=null;
        GrammarAST label2=null;
        GrammarAST a=null;
        GrammarAST b=null;
        GrammarAST sp=null;
        GrammarAST ROOT5=null;
        GrammarAST BANG6=null;
        CodeGenTreeWalker.element_return e = null;

        ST notElement7 = null;

        CodeGenTreeWalker.ebnf_return ebnf8 = null;

        CodeGenTreeWalker.atom_return atom9 = null;

        CodeGenTreeWalker.tree__return tree_10 = null;

        CodeGenTreeWalker.element_action_return element_action11 = null;



        	IntSet elements=null;
        	GrammarAST ast = null;

        try {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:721:2: ( ^( ROOT e= element[label,$ROOT] ) | ^( BANG e= element[label,$BANG] ) | ^(n= NOT notElement[$n, $label, $astSuffix] ) | ^( ASSIGN alabel= ID e= element[$alabel,$astSuffix] ) | ^( PLUS_ASSIGN label2= ID e= element[$label2,$astSuffix] ) | ^( CHAR_RANGE a= CHAR_LITERAL b= CHAR_LITERAL ) | ({...}? ( BLOCK | OPTIONAL | CLOSURE | POSITIVE_CLOSURE ) )=> ebnf | atom[null, $label, $astSuffix] | tree_ | element_action | (sp= SEMPRED | sp= GATED_SEMPRED ) | SYN_SEMPRED | ^( SYNPRED ( . )* ) | ^( BACKTRACK_SEMPRED ( . )* ) | EPSILON )
            int alt46=15;
            alt46 = dfa46.predict(input);
            switch (alt46) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:721:4: ^( ROOT e= element[label,$ROOT] )
                    {
                    ROOT5=(GrammarAST)match(input,ROOT,FOLLOW_ROOT_in_element878); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_element_in_element882);
                    e=element(label, ROOT5);

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       retval.code = (e!=null?e.code:null); 
                    }

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:724:4: ^( BANG e= element[label,$BANG] )
                    {
                    BANG6=(GrammarAST)match(input,BANG,FOLLOW_BANG_in_element895); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_element_in_element899);
                    e=element(label, BANG6);

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       retval.code = (e!=null?e.code:null); 
                    }

                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:727:4: ^(n= NOT notElement[$n, $label, $astSuffix] )
                    {
                    n=(GrammarAST)match(input,NOT,FOLLOW_NOT_in_element915); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_notElement_in_element917);
                    notElement7=notElement(n, label, astSuffix);

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       retval.code = notElement7; 
                    }

                    }
                    break;
                case 4 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:730:4: ^( ASSIGN alabel= ID e= element[$alabel,$astSuffix] )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_element932); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    alabel=(GrammarAST)match(input,ID,FOLLOW_ID_in_element936); if (state.failed) return retval;
                    pushFollow(FOLLOW_element_in_element940);
                    e=element(alabel, astSuffix);

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       retval.code = (e!=null?e.code:null); 
                    }

                    }
                    break;
                case 5 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:733:4: ^( PLUS_ASSIGN label2= ID e= element[$label2,$astSuffix] )
                    {
                    match(input,PLUS_ASSIGN,FOLLOW_PLUS_ASSIGN_in_element955); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    label2=(GrammarAST)match(input,ID,FOLLOW_ID_in_element959); if (state.failed) return retval;
                    pushFollow(FOLLOW_element_in_element963);
                    e=element(label2, astSuffix);

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       retval.code = (e!=null?e.code:null); 
                    }

                    }
                    break;
                case 6 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:736:4: ^( CHAR_RANGE a= CHAR_LITERAL b= CHAR_LITERAL )
                    {
                    match(input,CHAR_RANGE,FOLLOW_CHAR_RANGE_in_element977); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    a=(GrammarAST)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_element981); if (state.failed) return retval;
                    b=(GrammarAST)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_element985); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      			retval.code = templates.getInstanceOf("charRangeRef");
                      			String low = generator.target.getTargetCharLiteralFromANTLRCharLiteral(generator,(a!=null?a.getText():null));
                      			String high = generator.target.getTargetCharLiteralFromANTLRCharLiteral(generator,(b!=null?b.getText():null));
                      			retval.code.add("a", low);
                      			retval.code.add("b", high);
                      			if ( label!=null )
                      			{
                      				retval.code.add("label", label.getText());
                      			}
                      		
                    }

                    }
                    break;
                case 7 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:749:4: ({...}? ( BLOCK | OPTIONAL | CLOSURE | POSITIVE_CLOSURE ) )=> ebnf
                    {
                    pushFollow(FOLLOW_ebnf_in_element1014);
                    ebnf8=ebnf();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       retval.code = (ebnf8!=null?ebnf8.code:null); 
                    }

                    }
                    break;
                case 8 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:752:4: atom[null, $label, $astSuffix]
                    {
                    pushFollow(FOLLOW_atom_in_element1024);
                    atom9=atom(null, label, astSuffix);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       retval.code = (atom9!=null?atom9.code:null); 
                    }

                    }
                    break;
                case 9 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:755:4: tree_
                    {
                    pushFollow(FOLLOW_tree__in_element1035);
                    tree_10=tree_();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       retval.code = (tree_10!=null?tree_10.code:null); 
                    }

                    }
                    break;
                case 10 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:758:4: element_action
                    {
                    pushFollow(FOLLOW_element_action_in_element1045);
                    element_action11=element_action();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       retval.code = (element_action11!=null?element_action11.code:null); 
                    }

                    }
                    break;
                case 11 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:761:6: (sp= SEMPRED | sp= GATED_SEMPRED )
                    {
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:761:6: (sp= SEMPRED | sp= GATED_SEMPRED )
                    int alt43=2;
                    switch ( input.LA(1) ) {
                    case SEMPRED:
                        {
                        alt43=1;
                        }
                        break;
                    case GATED_SEMPRED:
                        {
                        alt43=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 43, 0, input);

                        throw nvae;
                    }

                    switch (alt43) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:761:7: sp= SEMPRED
                            {
                            sp=(GrammarAST)match(input,SEMPRED,FOLLOW_SEMPRED_in_element1060); if (state.failed) return retval;

                            }
                            break;
                        case 2 :
                            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:761:18: sp= GATED_SEMPRED
                            {
                            sp=(GrammarAST)match(input,GATED_SEMPRED,FOLLOW_GATED_SEMPRED_in_element1064); if (state.failed) return retval;

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      			retval.code = templates.getInstanceOf("validateSemanticPredicate");
                      			retval.code.add("pred", generator.translateAction(currentRuleName,sp));
                      			String description = generator.target.getTargetStringLiteralFromString((sp!=null?sp.getText():null));
                      			retval.code.add("description", description);
                      		
                    }

                    }
                    break;
                case 12 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:769:4: SYN_SEMPRED
                    {
                    match(input,SYN_SEMPRED,FOLLOW_SYN_SEMPRED_in_element1075); if (state.failed) return retval;

                    }
                    break;
                case 13 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:771:4: ^( SYNPRED ( . )* )
                    {
                    match(input,SYNPRED,FOLLOW_SYNPRED_in_element1083); if (state.failed) return retval;

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:771:14: ( . )*
                        loop44:
                        do {
                            int alt44=2;
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
                                alt44=1;
                                }
                                break;
                            case UP:
                                {
                                alt44=2;
                                }
                                break;

                            }

                            switch (alt44) {
                        	case 1 :
                        	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:771:14: .
                        	    {
                        	    matchAny(input); if (state.failed) return retval;

                        	    }
                        	    break;

                        	default :
                        	    break loop44;
                            }
                        } while (true);


                        match(input, Token.UP, null); if (state.failed) return retval;
                    }

                    }
                    break;
                case 14 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:773:4: ^( BACKTRACK_SEMPRED ( . )* )
                    {
                    match(input,BACKTRACK_SEMPRED,FOLLOW_BACKTRACK_SEMPRED_in_element1094); if (state.failed) return retval;

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:773:24: ( . )*
                        loop45:
                        do {
                            int alt45=2;
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
                                alt45=1;
                                }
                                break;
                            case UP:
                                {
                                alt45=2;
                                }
                                break;

                            }

                            switch (alt45) {
                        	case 1 :
                        	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:773:24: .
                        	    {
                        	    matchAny(input); if (state.failed) return retval;

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
                case 15 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:775:6: EPSILON
                    {
                    match(input,EPSILON,FOLLOW_EPSILON_in_element1106); if (state.failed) return retval;

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

    public static class element_action_return extends TreeRuleReturnScope {
        public ST code=null;
    };

    // $ANTLR start "element_action"
    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:778:1: element_action returns [ST code=null] : (act= ACTION | act2= FORCED_ACTION );
    public final CodeGenTreeWalker.element_action_return element_action() throws RecognitionException {
        CodeGenTreeWalker.element_action_return retval = new CodeGenTreeWalker.element_action_return();
        retval.start = input.LT(1);

        GrammarAST act=null;
        GrammarAST act2=null;

        try {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:779:2: (act= ACTION | act2= FORCED_ACTION )
            int alt47=2;
            switch ( input.LA(1) ) {
            case ACTION:
                {
                alt47=1;
                }
                break;
            case FORCED_ACTION:
                {
                alt47=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:779:4: act= ACTION
                    {
                    act=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_element_action1123); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      			retval.code = templates.getInstanceOf("execAction");
                      			retval.code.add("action", generator.translateAction(currentRuleName,act));
                      		
                    }

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:784:4: act2= FORCED_ACTION
                    {
                    act2=(GrammarAST)match(input,FORCED_ACTION,FOLLOW_FORCED_ACTION_in_element_action1134); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      			retval.code = templates.getInstanceOf("execForcedAction");
                      			retval.code.add("action", generator.translateAction(currentRuleName,act2));
                      		
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
    // $ANTLR end "element_action"


    // $ANTLR start "notElement"
    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:791:1: notElement[GrammarAST n, GrammarAST label, GrammarAST astSuffix] returns [ST code=null] : (assign_c= CHAR_LITERAL | assign_s= STRING_LITERAL | assign_t= TOKEN_REF | ^(assign_st= BLOCK ( . )* ) ) ;
    public final ST notElement(GrammarAST n, GrammarAST label, GrammarAST astSuffix) throws RecognitionException {
        ST code = null;

        GrammarAST assign_c=null;
        GrammarAST assign_s=null;
        GrammarAST assign_t=null;
        GrammarAST assign_st=null;


        	IntSet elements=null;
        	String labelText = null;
        	if ( label!=null )
        	{
        		labelText = label.getText();
        	}

        try {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:801:2: ( (assign_c= CHAR_LITERAL | assign_s= STRING_LITERAL | assign_t= TOKEN_REF | ^(assign_st= BLOCK ( . )* ) ) )
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:801:4: (assign_c= CHAR_LITERAL | assign_s= STRING_LITERAL | assign_t= TOKEN_REF | ^(assign_st= BLOCK ( . )* ) )
            {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:801:4: (assign_c= CHAR_LITERAL | assign_s= STRING_LITERAL | assign_t= TOKEN_REF | ^(assign_st= BLOCK ( . )* ) )
            int alt49=4;
            switch ( input.LA(1) ) {
            case CHAR_LITERAL:
                {
                alt49=1;
                }
                break;
            case STRING_LITERAL:
                {
                alt49=2;
                }
                break;
            case TOKEN_REF:
                {
                alt49=3;
                }
                break;
            case BLOCK:
                {
                alt49=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return code;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:801:6: assign_c= CHAR_LITERAL
                    {
                    assign_c=(GrammarAST)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_notElement1163); if (state.failed) return code;
                    if ( state.backtracking==0 ) {

                      				int ttype=0;
                      				if ( grammar.type==Grammar.LEXER )
                      				{
                      					ttype = Grammar.getCharValueFromGrammarCharLiteral((assign_c!=null?assign_c.getText():null));
                      				}
                      				else
                      				{
                      					ttype = grammar.getTokenType((assign_c!=null?assign_c.getText():null));
                      				}
                      				elements = grammar.complement(ttype);
                      			
                    }

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:814:5: assign_s= STRING_LITERAL
                    {
                    assign_s=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_notElement1176); if (state.failed) return code;
                    if ( state.backtracking==0 ) {

                      				int ttype=0;
                      				if ( grammar.type==Grammar.LEXER )
                      				{
                      					// TODO: error!
                      				}
                      				else
                      				{
                      					ttype = grammar.getTokenType((assign_s!=null?assign_s.getText():null));
                      				}
                      				elements = grammar.complement(ttype);
                      			
                    }

                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:827:5: assign_t= TOKEN_REF
                    {
                    assign_t=(GrammarAST)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_notElement1189); if (state.failed) return code;
                    if ( state.backtracking==0 ) {

                      				int ttype = grammar.getTokenType((assign_t!=null?assign_t.getText():null));
                      				elements = grammar.complement(ttype);
                      			
                    }

                    }
                    break;
                case 4 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:832:5: ^(assign_st= BLOCK ( . )* )
                    {
                    assign_st=(GrammarAST)match(input,BLOCK,FOLLOW_BLOCK_in_notElement1203); if (state.failed) return code;

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return code;
                        // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:832:23: ( . )*
                        loop48:
                        do {
                            int alt48=2;
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
                                alt48=1;
                                }
                                break;
                            case UP:
                                {
                                alt48=2;
                                }
                                break;

                            }

                            switch (alt48) {
                        	case 1 :
                        	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:832:23: .
                        	    {
                        	    matchAny(input); if (state.failed) return code;

                        	    }
                        	    break;

                        	default :
                        	    break loop48;
                            }
                        } while (true);


                        match(input, Token.UP, null); if (state.failed) return code;
                    }
                    if ( state.backtracking==0 ) {

                      				elements = assign_st.getSetValue();
                      				elements = grammar.complement(elements);
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			code = getTokenElementST("matchSet",
              									 "set",
              									 (GrammarAST)n.getChild(0),
              									 astSuffix,
              									 labelText);
              			code.add("s",generator.genSetExpr(templates,elements,1,false));
              			int i = ((CommonToken)n.getToken()).getTokenIndex();
              			code.add("elementIndex", i);
              			if ( grammar.type!=Grammar.LEXER )
              			{
              				generator.generateLocalFOLLOW(n,"set",currentRuleName,i);
              			}
              		
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return code;
    }
    // $ANTLR end "notElement"

    public static class ebnf_return extends TreeRuleReturnScope {
        public ST code=null;
    };

    // $ANTLR start "ebnf"
    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:854:1: ebnf returns [ST code=null] : (blk= block[\"block\", dfa] | ^( OPTIONAL blk= block[\"optionalBlock\", dfa] ) | ^( CLOSURE blk= block[\"closureBlock\", dfa] ) | ^( POSITIVE_CLOSURE blk= block[\"positiveClosureBlock\", dfa] ) ) ;
    public final CodeGenTreeWalker.ebnf_return ebnf() throws RecognitionException {
        CodeGenTreeWalker.ebnf_return retval = new CodeGenTreeWalker.ebnf_return();
        retval.start = input.LT(1);

        CodeGenTreeWalker.block_return blk = null;



        	org.antlr.analysis.DFA dfa=null;
        	GrammarAST b = (GrammarAST)((GrammarAST)retval.start).getChild(0);
        	GrammarAST eob = (GrammarAST)b.getLastChild(); // loops will use EOB DFA

        try {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:861:2: ( (blk= block[\"block\", dfa] | ^( OPTIONAL blk= block[\"optionalBlock\", dfa] ) | ^( CLOSURE blk= block[\"closureBlock\", dfa] ) | ^( POSITIVE_CLOSURE blk= block[\"positiveClosureBlock\", dfa] ) ) )
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:861:4: (blk= block[\"block\", dfa] | ^( OPTIONAL blk= block[\"optionalBlock\", dfa] ) | ^( CLOSURE blk= block[\"closureBlock\", dfa] ) | ^( POSITIVE_CLOSURE blk= block[\"positiveClosureBlock\", dfa] ) )
            {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:861:4: (blk= block[\"block\", dfa] | ^( OPTIONAL blk= block[\"optionalBlock\", dfa] ) | ^( CLOSURE blk= block[\"closureBlock\", dfa] ) | ^( POSITIVE_CLOSURE blk= block[\"positiveClosureBlock\", dfa] ) )
            int alt50=4;
            switch ( input.LA(1) ) {
            case BLOCK:
                {
                alt50=1;
                }
                break;
            case OPTIONAL:
                {
                alt50=2;
                }
                break;
            case CLOSURE:
                {
                alt50=3;
                }
                break;
            case POSITIVE_CLOSURE:
                {
                alt50=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:861:6: blk= block[\"block\", dfa]
                    {
                    if ( state.backtracking==0 ) {
                       dfa = ((GrammarAST)retval.start).getLookaheadDFA(); 
                    }
                    pushFollow(FOLLOW_block_in_ebnf1249);
                    blk=block("block", dfa);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       retval.code = (blk!=null?blk.code:null); 
                    }

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:864:5: ^( OPTIONAL blk= block[\"optionalBlock\", dfa] )
                    {
                    if ( state.backtracking==0 ) {
                       dfa = ((GrammarAST)retval.start).getLookaheadDFA(); 
                    }
                    match(input,OPTIONAL,FOLLOW_OPTIONAL_in_ebnf1268); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_block_in_ebnf1272);
                    blk=block("optionalBlock", dfa);

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       retval.code = (blk!=null?blk.code:null); 
                    }

                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:867:5: ^( CLOSURE blk= block[\"closureBlock\", dfa] )
                    {
                    if ( state.backtracking==0 ) {
                       dfa = eob.getLookaheadDFA(); 
                    }
                    match(input,CLOSURE,FOLLOW_CLOSURE_in_ebnf1293); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_block_in_ebnf1297);
                    blk=block("closureBlock", dfa);

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       retval.code = (blk!=null?blk.code:null); 
                    }

                    }
                    break;
                case 4 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:870:5: ^( POSITIVE_CLOSURE blk= block[\"positiveClosureBlock\", dfa] )
                    {
                    if ( state.backtracking==0 ) {
                       dfa = eob.getLookaheadDFA(); 
                    }
                    match(input,POSITIVE_CLOSURE,FOLLOW_POSITIVE_CLOSURE_in_ebnf1318); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_block_in_ebnf1322);
                    blk=block("positiveClosureBlock", dfa);

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       retval.code = (blk!=null?blk.code:null); 
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			String description = grammar.grammarTreeToString(((GrammarAST)retval.start), false);
              			description = generator.target.getTargetStringLiteralFromString(description);
              			retval.code.add("description", description);
              		
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
    // $ANTLR end "ebnf"

    public static class tree__return extends TreeRuleReturnScope {
        public ST code;
    };

    // $ANTLR start "tree_"
    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:881:1: tree_ returns [ST code] : ^( TREE_BEGIN el= element[null,rootSuffix] ( ( element_action )=>act= element_action )* (el= element[null,null] )* ) ;
    public final CodeGenTreeWalker.tree__return tree_() throws RecognitionException {
        CodeGenTreeWalker.tree__return retval = new CodeGenTreeWalker.tree__return();
        retval.start = input.LT(1);

        CodeGenTreeWalker.element_return el = null;

        CodeGenTreeWalker.element_action_return act = null;



        	rewriteTreeNestingLevel++;
        	GrammarAST rootSuffix = null;
        	if ( state.backtracking == 0 )
        	{
        		retval.code = templates.getInstanceOf("tree");
        		NFAState afterDOWN = (NFAState)((GrammarAST)retval.start).NFATreeDownState.transition(0).target;
        		LookaheadSet s = grammar.LOOK(afterDOWN);
        		if ( s.member(Label.UP) ) {
        			// nullable child list if we can see the UP as the next token
        			// we need an "if ( input.LA(1)==Token.DOWN )" gate around
        			// the child list.
        			retval.code.add("nullableChildList", "true");
        		}
        		retval.code.add("enclosingTreeLevel", rewriteTreeNestingLevel-1);
        		retval.code.add("treeLevel", rewriteTreeNestingLevel);
        		Rule r = grammar.getRule(currentRuleName);
        		if ( grammar.buildAST() && !r.hasRewrite(outerAltNum) ) {
        			rootSuffix = new GrammarAST(ROOT,"ROOT");
        		}
        	}

        try {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:905:2: ( ^( TREE_BEGIN el= element[null,rootSuffix] ( ( element_action )=>act= element_action )* (el= element[null,null] )* ) )
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:905:4: ^( TREE_BEGIN el= element[null,rootSuffix] ( ( element_action )=>act= element_action )* (el= element[null,null] )* )
            {
            match(input,TREE_BEGIN,FOLLOW_TREE_BEGIN_in_tree_1360); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            pushFollow(FOLLOW_element_in_tree_1367);
            el=element(null, rootSuffix);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {

              				retval.code.addAggr("root.{el,line,pos}",
              								  (el!=null?el.code:null),
              								  (el!=null?((GrammarAST)el.start):null).getLine(),
              								  (el!=null?((GrammarAST)el.start):null).getCharPositionInLine() + 1
              								  );
              			
            }
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:917:4: ( ( element_action )=>act= element_action )*
            loop51:
            do {
                int alt51=2;
                switch ( input.LA(1) ) {
                case ACTION:
                    {
                    int LA51_2 = input.LA(2);

                    if ( (synpred2_CodeGenTreeWalker()) ) {
                        alt51=1;
                    }


                    }
                    break;
                case FORCED_ACTION:
                    {
                    int LA51_3 = input.LA(2);

                    if ( (synpred2_CodeGenTreeWalker()) ) {
                        alt51=1;
                    }


                    }
                    break;

                }

                switch (alt51) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:917:6: ( element_action )=>act= element_action
            	    {
            	    pushFollow(FOLLOW_element_action_in_tree_1404);
            	    act=element_action();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {

            	      					retval.code.addAggr("actionsAfterRoot.{el,line,pos}",
            	      									  (act!=null?act.code:null),
            	      									  (act!=null?((GrammarAST)act.start):null).getLine(),
            	      									  (act!=null?((GrammarAST)act.start):null).getCharPositionInLine() + 1
            	      									);
            	      				
            	    }

            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);

            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:927:4: (el= element[null,null] )*
            loop52:
            do {
                int alt52=2;
                switch ( input.LA(1) ) {
                case BLOCK:
                case OPTIONAL:
                case CLOSURE:
                case POSITIVE_CLOSURE:
                case SYNPRED:
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
                    alt52=1;
                    }
                    break;

                }

                switch (alt52) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:927:7: el= element[null,null]
            	    {
            	    pushFollow(FOLLOW_element_in_tree_1426);
            	    el=element(null, null);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {

            	      				 retval.code.addAggr("children.{el,line,pos}",
            	      								  (el!=null?el.code:null),
            	      								  (el!=null?((GrammarAST)el.start):null).getLine(),
            	      								  (el!=null?((GrammarAST)el.start):null).getCharPositionInLine() + 1
            	      								  );
            	      				 
            	    }

            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
             rewriteTreeNestingLevel--; 
        }
        return retval;
    }
    // $ANTLR end "tree_"

    public static class atom_return extends TreeRuleReturnScope {
        public ST code=null;
    };

    // $ANTLR start "atom"
    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:940:1: atom[GrammarAST scope, GrammarAST label, GrammarAST astSuffix] returns [ST code=null] : ( ^(r= RULE_REF (rarg= ARG_ACTION )? ) | ^(t= TOKEN_REF (targ= ARG_ACTION )? ) | c= CHAR_LITERAL | s= STRING_LITERAL | w= WILDCARD | ^( DOT ID a= atom[$ID, label, astSuffix] ) | set[label,astSuffix] );
    public final CodeGenTreeWalker.atom_return atom(GrammarAST scope, GrammarAST label, GrammarAST astSuffix) throws RecognitionException {
        CodeGenTreeWalker.atom_return retval = new CodeGenTreeWalker.atom_return();
        retval.start = input.LT(1);

        GrammarAST r=null;
        GrammarAST rarg=null;
        GrammarAST t=null;
        GrammarAST targ=null;
        GrammarAST c=null;
        GrammarAST s=null;
        GrammarAST w=null;
        GrammarAST ID12=null;
        CodeGenTreeWalker.atom_return a = null;

        ST set13 = null;



        	String labelText=null;
        	if ( state.backtracking == 0 )
        	{
        		if ( label!=null )
        		{
        			labelText = label.getText();
        		}
        		if ( grammar.type!=Grammar.LEXER &&
        			 (((GrammarAST)retval.start).getType()==RULE_REF||((GrammarAST)retval.start).getType()==TOKEN_REF||
        			  ((GrammarAST)retval.start).getType()==CHAR_LITERAL||((GrammarAST)retval.start).getType()==STRING_LITERAL) )
        		{
        			Rule encRule = grammar.getRule(((GrammarAST)((GrammarAST)retval.start)).enclosingRuleName);
        			if ( encRule!=null && encRule.hasRewrite(outerAltNum) && astSuffix!=null )
        			{
        				ErrorManager.grammarError(ErrorManager.MSG_AST_OP_IN_ALT_WITH_REWRITE,
        										  grammar,
        										  ((GrammarAST)((GrammarAST)retval.start)).getToken(),
        										  ((GrammarAST)((GrammarAST)retval.start)).enclosingRuleName,
        										  outerAltNum);
        				astSuffix = null;
        			}
        		}
        	}

        try {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:968:2: ( ^(r= RULE_REF (rarg= ARG_ACTION )? ) | ^(t= TOKEN_REF (targ= ARG_ACTION )? ) | c= CHAR_LITERAL | s= STRING_LITERAL | w= WILDCARD | ^( DOT ID a= atom[$ID, label, astSuffix] ) | set[label,astSuffix] )
            int alt55=7;
            switch ( input.LA(1) ) {
            case RULE_REF:
                {
                alt55=1;
                }
                break;
            case TOKEN_REF:
                {
                alt55=2;
                }
                break;
            case CHAR_LITERAL:
                {
                alt55=3;
                }
                break;
            case STRING_LITERAL:
                {
                alt55=4;
                }
                break;
            case WILDCARD:
                {
                alt55=5;
                }
                break;
            case DOT:
                {
                alt55=6;
                }
                break;
            case BLOCK:
                {
                alt55=7;
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
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:968:6: ^(r= RULE_REF (rarg= ARG_ACTION )? )
                    {
                    r=(GrammarAST)match(input,RULE_REF,FOLLOW_RULE_REF_in_atom1476); if (state.failed) return retval;

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:968:20: (rarg= ARG_ACTION )?
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
                                // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:968:21: rarg= ARG_ACTION
                                {
                                rarg=(GrammarAST)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_atom1481); if (state.failed) return retval;

                                }
                                break;

                        }


                        match(input, Token.UP, null); if (state.failed) return retval;
                    }
                    if ( state.backtracking==0 ) {

                      			grammar.checkRuleReference(scope, r, rarg, currentRuleName);
                      			String scopeName = null;
                      			if ( scope!=null ) {
                      				scopeName = scope.getText();
                      			}
                      			Rule rdef = grammar.getRule(scopeName, (r!=null?r.getText():null));
                      			// don't insert label=r() if label.attr not used, no ret value, ...
                      			if ( !rdef.getHasReturnValue() ) {
                      				labelText = null;
                      			}
                      			retval.code = getRuleElementST("ruleRef", (r!=null?r.getText():null), r, astSuffix, labelText);
                      			retval.code.add("rule", rdef);
                      			if ( scope!=null ) { // scoped rule ref
                      				Grammar scopeG = grammar.composite.getGrammar(scope.getText());
                      				retval.code.add("scope", scopeG);
                      			}
                      			else if ( rdef.grammar != this.grammar ) { // nonlocal
                      				// if rule definition is not in this grammar, it's nonlocal
                      				List<Grammar> rdefDelegates = rdef.grammar.getDelegates();
                      				if ( rdefDelegates.contains(this.grammar) ) {
                      					retval.code.add("scope", rdef.grammar);
                      				}
                      				else {
                      					// defining grammar is not a delegate, scope all the
                      					// back to root, which has delegate methods for all
                      					// rules.  Don't use scope if we are root.
                      					if ( this.grammar != rdef.grammar.composite.delegateGrammarTreeRoot.grammar ) {
                      						retval.code.add("scope",
                      										  rdef.grammar.composite.delegateGrammarTreeRoot.grammar);
                      					}
                      				}
                      			}

                      			if ( rarg!=null ) {
                      				List args = generator.translateAction(currentRuleName,rarg);
                      				retval.code.add("args", args);
                      			}
                      			int i = ((CommonToken)r.getToken()).getTokenIndex();
                      			retval.code.add("elementIndex", i);
                      			generator.generateLocalFOLLOW(r,(r!=null?r.getText():null),currentRuleName,i);
                      			r.code = retval.code;
                      		
                    }

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1013:4: ^(t= TOKEN_REF (targ= ARG_ACTION )? )
                    {
                    t=(GrammarAST)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_atom1499); if (state.failed) return retval;

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1013:19: (targ= ARG_ACTION )?
                        int alt54=2;
                        switch ( input.LA(1) ) {
                            case ARG_ACTION:
                                {
                                alt54=1;
                                }
                                break;
                        }

                        switch (alt54) {
                            case 1 :
                                // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1013:20: targ= ARG_ACTION
                                {
                                targ=(GrammarAST)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_atom1504); if (state.failed) return retval;

                                }
                                break;

                        }


                        match(input, Token.UP, null); if (state.failed) return retval;
                    }
                    if ( state.backtracking==0 ) {

                      			if ( currentAltHasASTRewrite && t.terminalOptions!=null &&
                      				t.terminalOptions.get(Grammar.defaultTokenOption)!=null )
                      			{
                      				ErrorManager.grammarError(ErrorManager.MSG_HETERO_ILLEGAL_IN_REWRITE_ALT,
                      										grammar,
                      										((GrammarAST)(t)).getToken(),
                      										(t!=null?t.getText():null));
                      			}
                      			grammar.checkRuleReference(scope, t, targ, currentRuleName);
                      			if ( grammar.type==Grammar.LEXER )
                      			{
                      				if ( grammar.getTokenType((t!=null?t.getText():null))==Label.EOF )
                      				{
                      					retval.code = templates.getInstanceOf("lexerMatchEOF");
                      				}
                      				else
                      				{
                      					retval.code = templates.getInstanceOf("lexerRuleRef");
                      					if ( isListLabel(labelText) )
                      					{
                      						retval.code = templates.getInstanceOf("lexerRuleRefAndListLabel");
                      					}
                      					String scopeName = null;
                      					if ( scope!=null )
                      					{
                      						scopeName = scope.getText();
                      					}
                      					Rule rdef2 = grammar.getRule(scopeName, (t!=null?t.getText():null));
                      					retval.code.add("rule", rdef2);
                      					if ( scope!=null )
                      					{ // scoped rule ref
                      						Grammar scopeG = grammar.composite.getGrammar(scope.getText());
                      						retval.code.add("scope", scopeG);
                      					}
                      					else if ( rdef2.grammar != this.grammar )
                      					{ // nonlocal
                      						// if rule definition is not in this grammar, it's nonlocal
                      						retval.code.add("scope", rdef2.grammar);
                      					}
                      					if ( targ!=null )
                      					{
                      						List args = generator.translateAction(currentRuleName,targ);
                      						retval.code.add("args", args);
                      					}
                      				}
                      				int i = ((CommonToken)t.getToken()).getTokenIndex();
                      				retval.code.add("elementIndex", i);
                      				if ( label!=null )
                      					retval.code.add("label", labelText);
                      			}
                      			else
                      			{
                      				retval.code = getTokenElementST("tokenRef", (t!=null?t.getText():null), t, astSuffix, labelText);
                      				String tokenLabel =
                      					generator.getTokenTypeAsTargetLabel(grammar.getTokenType(t.getText()));
                      				retval.code.add("token",tokenLabel);
                      				if ( !currentAltHasASTRewrite && t.terminalOptions!=null )
                      				{
                      					retval.code.add("terminalOptions", t.terminalOptions);
                      				}
                      				int i = ((CommonToken)t.getToken()).getTokenIndex();
                      				retval.code.add("elementIndex", i);
                      				generator.generateLocalFOLLOW(t,tokenLabel,currentRuleName,i);
                      			}
                      			t.code = retval.code;
                      		
                    }

                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1082:4: c= CHAR_LITERAL
                    {
                    c=(GrammarAST)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_atom1520); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      			if ( grammar.type==Grammar.LEXER )
                      			{
                      				retval.code = templates.getInstanceOf("charRef");
                      				retval.code.add("char",
                      				   generator.target.getTargetCharLiteralFromANTLRCharLiteral(generator,(c!=null?c.getText():null)));
                      				if ( label!=null )
                      				{
                      					retval.code.add("label", labelText);
                      				}
                      			}
                      			else { // else it's a token type reference
                      				retval.code = getTokenElementST("tokenRef", "char_literal", c, astSuffix, labelText);
                      				String tokenLabel = generator.getTokenTypeAsTargetLabel(grammar.getTokenType((c!=null?c.getText():null)));
                      				retval.code.add("token",tokenLabel);
                      				if ( c.terminalOptions!=null ) {
                      					retval.code.add("terminalOptions",c.terminalOptions);
                      				}
                      				int i = ((CommonToken)c.getToken()).getTokenIndex();
                      				retval.code.add("elementIndex", i);
                      				generator.generateLocalFOLLOW(c,tokenLabel,currentRuleName,i);
                      			}
                      		
                    }

                    }
                    break;
                case 4 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1107:4: s= STRING_LITERAL
                    {
                    s=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_atom1532); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      			int i = ((CommonToken)s.getToken()).getTokenIndex();
                      			if ( grammar.type==Grammar.LEXER )
                      			{
                      				retval.code = templates.getInstanceOf("lexerStringRef");
                      				retval.code.add("string",
                      					generator.target.getTargetStringLiteralFromANTLRStringLiteral(generator,(s!=null?s.getText():null)));
                      				retval.code.add("elementIndex", i);
                      				if ( label!=null )
                      				{
                      					retval.code.add("label", labelText);
                      				}
                      			}
                      			else
                      			{
                      				// else it's a token type reference
                      				retval.code = getTokenElementST("tokenRef", "string_literal", s, astSuffix, labelText);
                      				String tokenLabel =
                      					generator.getTokenTypeAsTargetLabel(grammar.getTokenType((s!=null?s.getText():null)));
                      				retval.code.add("token",tokenLabel);
                      				if ( s.terminalOptions!=null )
                      				{
                      					retval.code.add("terminalOptions",s.terminalOptions);
                      				}
                      				retval.code.add("elementIndex", i);
                      				generator.generateLocalFOLLOW(s,tokenLabel,currentRuleName,i);
                      			}
                      		
                    }

                    }
                    break;
                case 5 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1137:4: w= WILDCARD
                    {
                    w=(GrammarAST)match(input,WILDCARD,FOLLOW_WILDCARD_in_atom1544); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      			retval.code = getWildcardST(w,astSuffix,labelText);
                      			retval.code.add("elementIndex", ((CommonToken)w.getToken()).getTokenIndex());
                      		
                    }

                    }
                    break;
                case 6 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1143:4: ^( DOT ID a= atom[$ID, label, astSuffix] )
                    {
                    match(input,DOT,FOLLOW_DOT_in_atom1555); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    ID12=(GrammarAST)match(input,ID,FOLLOW_ID_in_atom1557); if (state.failed) return retval;
                    pushFollow(FOLLOW_atom_in_atom1561);
                    a=atom(ID12, label, astSuffix);

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       retval.code = (a!=null?a.code:null); 
                    }

                    }
                    break;
                case 7 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1146:4: set[label,astSuffix]
                    {
                    pushFollow(FOLLOW_set_in_atom1574);
                    set13=set(label, astSuffix);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       retval.code = set13; 
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
    // $ANTLR end "atom"


    // $ANTLR start "ast_suffix"
    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1150:1: ast_suffix : ( ROOT | BANG );
    public final void ast_suffix() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1151:2: ( ROOT | BANG )
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:
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


    // $ANTLR start "set"
    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1155:1: set[GrammarAST label, GrammarAST astSuffix] returns [ST code=null] : ^(s= BLOCK ( . )* ) ;
    public final ST set(GrammarAST label, GrammarAST astSuffix) throws RecognitionException {
        ST code = null;

        GrammarAST s=null;


        	String labelText=null;
        	if ( label!=null )
        	{
        		labelText = label.getText();
        	}

        try {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1164:2: ( ^(s= BLOCK ( . )* ) )
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1164:4: ^(s= BLOCK ( . )* )
            {
            s=(GrammarAST)match(input,BLOCK,FOLLOW_BLOCK_in_set1619); if (state.failed) return code;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return code;
                // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1164:14: ( . )*
                loop56:
                do {
                    int alt56=2;
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
                        alt56=1;
                        }
                        break;
                    case UP:
                        {
                        alt56=2;
                        }
                        break;

                    }

                    switch (alt56) {
                	case 1 :
                	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1164:14: .
                	    {
                	    matchAny(input); if (state.failed) return code;

                	    }
                	    break;

                	default :
                	    break loop56;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return code;
            }
            if ( state.backtracking==0 ) {

              			code = getTokenElementST("matchSet", "set", s, astSuffix, labelText);
              			int i = ((CommonToken)s.getToken()).getTokenIndex();
              			code.add("elementIndex", i);
              			if ( grammar.type!=Grammar.LEXER )
              			{
              				generator.generateLocalFOLLOW(s,"set",currentRuleName,i);
              			}
              			code.add("s", generator.genSetExpr(templates,s.getSetValue(),1,false));
              		
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return code;
    }
    // $ANTLR end "set"


    // $ANTLR start "setElement"
    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1177:1: setElement : ( CHAR_LITERAL | TOKEN_REF | STRING_LITERAL | ^( CHAR_RANGE CHAR_LITERAL CHAR_LITERAL ) );
    public final void setElement() throws RecognitionException {
        try {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1178:2: ( CHAR_LITERAL | TOKEN_REF | STRING_LITERAL | ^( CHAR_RANGE CHAR_LITERAL CHAR_LITERAL ) )
            int alt57=4;
            switch ( input.LA(1) ) {
            case CHAR_LITERAL:
                {
                alt57=1;
                }
                break;
            case TOKEN_REF:
                {
                alt57=2;
                }
                break;
            case STRING_LITERAL:
                {
                alt57=3;
                }
                break;
            case CHAR_RANGE:
                {
                alt57=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1178:4: CHAR_LITERAL
                    {
                    match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_setElement1639); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1179:4: TOKEN_REF
                    {
                    match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_setElement1644); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1180:4: STRING_LITERAL
                    {
                    match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_setElement1649); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1181:4: ^( CHAR_RANGE CHAR_LITERAL CHAR_LITERAL )
                    {
                    match(input,CHAR_RANGE,FOLLOW_CHAR_RANGE_in_setElement1655); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_setElement1657); if (state.failed) return ;
                    match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_setElement1659); if (state.failed) return ;

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
    // $ANTLR end "setElement"

    public static class rewrite_return extends TreeRuleReturnScope {
        public ST code=null;
    };

    // $ANTLR start "rewrite"
    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1186:1: rewrite returns [ST code=null] : ( ^( REWRITES ( ^(r= REWRITE (pred= SEMPRED )? alt= rewrite_alternative ) )* ) | );
    public final CodeGenTreeWalker.rewrite_return rewrite() throws RecognitionException {
        CodeGenTreeWalker.rewrite_return retval = new CodeGenTreeWalker.rewrite_return();
        retval.start = input.LT(1);

        GrammarAST r=null;
        GrammarAST pred=null;
        ST alt = null;



        	if ( state.backtracking == 0 )
        	{
        		if ( ((GrammarAST)retval.start).getType()==REWRITES )
        		{
        			if ( generator.grammar.buildTemplate() )
        			{
        				retval.code = templates.getInstanceOf("rewriteTemplate");
        			}
        			else
        			{
        				retval.code = templates.getInstanceOf("rewriteCode");
        				retval.code.add("treeLevel", OUTER_REWRITE_NESTING_LEVEL);
        				retval.code.add("rewriteBlockLevel", OUTER_REWRITE_NESTING_LEVEL);
        				retval.code.add("referencedElementsDeep",
        								  getTokenTypesAsTargetLabels(((GrammarAST)retval.start).rewriteRefsDeep));
        				Set<String> tokenLabels =
        					grammar.getLabels(((GrammarAST)retval.start).rewriteRefsDeep, Grammar.TOKEN_LABEL);
        				Set<String> tokenListLabels =
        					grammar.getLabels(((GrammarAST)retval.start).rewriteRefsDeep, Grammar.TOKEN_LIST_LABEL);
        				Set<String> ruleLabels =
        					grammar.getLabels(((GrammarAST)retval.start).rewriteRefsDeep, Grammar.RULE_LABEL);
        				Set<String> ruleListLabels =
        					grammar.getLabels(((GrammarAST)retval.start).rewriteRefsDeep, Grammar.RULE_LIST_LABEL);
        				Set<String> wildcardLabels =
        					grammar.getLabels(((GrammarAST)retval.start).rewriteRefsDeep, Grammar.WILDCARD_TREE_LABEL);
        				Set<String> wildcardListLabels =
        					grammar.getLabels(((GrammarAST)retval.start).rewriteRefsDeep, Grammar.WILDCARD_TREE_LIST_LABEL);
        				// just in case they ref r for "previous value", make a stream
        				// from retval.tree
        				ST retvalST = templates.getInstanceOf("prevRuleRootRef");
        				ruleLabels.add(retvalST.render());
        				retval.code.add("referencedTokenLabels", tokenLabels);
        				retval.code.add("referencedTokenListLabels", tokenListLabels);
        				retval.code.add("referencedRuleLabels", ruleLabels);
        				retval.code.add("referencedRuleListLabels", ruleListLabels);
        				retval.code.add("referencedWildcardLabels", wildcardLabels);
        				retval.code.add("referencedWildcardListLabels", wildcardListLabels);
        			}
        		}
        		else
        		{
        				retval.code = templates.getInstanceOf("noRewrite");
        				retval.code.add("treeLevel", OUTER_REWRITE_NESTING_LEVEL);
        				retval.code.add("rewriteBlockLevel", OUTER_REWRITE_NESTING_LEVEL);
        		}
        	}

        try {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1236:2: ( ^( REWRITES ( ^(r= REWRITE (pred= SEMPRED )? alt= rewrite_alternative ) )* ) | )
            int alt60=2;
            switch ( input.LA(1) ) {
            case REWRITES:
                {
                alt60=1;
                }
                break;
            case ALT:
            case EOB:
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
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1236:4: ^( REWRITES ( ^(r= REWRITE (pred= SEMPRED )? alt= rewrite_alternative ) )* )
                    {
                    match(input,REWRITES,FOLLOW_REWRITES_in_rewrite1684); if (state.failed) return retval;

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1237:4: ( ^(r= REWRITE (pred= SEMPRED )? alt= rewrite_alternative ) )*
                        loop59:
                        do {
                            int alt59=2;
                            switch ( input.LA(1) ) {
                            case REWRITE:
                                {
                                alt59=1;
                                }
                                break;

                            }

                            switch (alt59) {
                        	case 1 :
                        	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1238:5: ^(r= REWRITE (pred= SEMPRED )? alt= rewrite_alternative )
                        	    {
                        	    if ( state.backtracking==0 ) {
                        	      rewriteRuleRefs = new HashSet<Object>();
                        	    }
                        	    r=(GrammarAST)match(input,REWRITE,FOLLOW_REWRITE_in_rewrite1705); if (state.failed) return retval;

                        	    match(input, Token.DOWN, null); if (state.failed) return retval;
                        	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1239:18: (pred= SEMPRED )?
                        	    int alt58=2;
                        	    switch ( input.LA(1) ) {
                        	        case SEMPRED:
                        	            {
                        	            alt58=1;
                        	            }
                        	            break;
                        	    }

                        	    switch (alt58) {
                        	        case 1 :
                        	            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1239:19: pred= SEMPRED
                        	            {
                        	            pred=(GrammarAST)match(input,SEMPRED,FOLLOW_SEMPRED_in_rewrite1710); if (state.failed) return retval;

                        	            }
                        	            break;

                        	    }

                        	    pushFollow(FOLLOW_rewrite_alternative_in_rewrite1716);
                        	    alt=rewrite_alternative();

                        	    state._fsp--;
                        	    if (state.failed) return retval;

                        	    match(input, Token.UP, null); if (state.failed) return retval;
                        	    if ( state.backtracking==0 ) {

                        	      					rewriteBlockNestingLevel = OUTER_REWRITE_NESTING_LEVEL;
                        	      					List predChunks = null;
                        	      					if ( pred!=null )
                        	      					{
                        	      						//predText = #pred.getText();
                        	      						predChunks = generator.translateAction(currentRuleName,pred);
                        	      					}
                        	      					String description =
                        	      						grammar.grammarTreeToString(r,false);
                        	      					description = generator.target.getTargetStringLiteralFromString(description);
                        	      					retval.code.addAggr("alts.{pred,alt,description}",
                        	      									  predChunks,
                        	      									  alt,
                        	      									  description);
                        	      					pred=null;
                        	      				
                        	    }

                        	    }
                        	    break;

                        	default :
                        	    break loop59;
                            }
                        } while (true);


                        match(input, Token.UP, null); if (state.failed) return retval;
                    }

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1260:2: 
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


    // $ANTLR start "rewrite_block"
    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1262:1: rewrite_block[String blockTemplateName] returns [ST code=null] : ^( BLOCK alt= rewrite_alternative EOB ) ;
    public final ST rewrite_block(String blockTemplateName) throws RecognitionException {
        ST code = null;

        GrammarAST BLOCK14=null;
        ST alt = null;



        	rewriteBlockNestingLevel++;
        	ST save_currentBlockST = currentBlockST;
        	if ( state.backtracking == 0 )
        	{
        		code = templates.getInstanceOf(blockTemplateName);
        		currentBlockST = code;
        		code.add("rewriteBlockLevel", rewriteBlockNestingLevel);
        	}

        try {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1274:2: ( ^( BLOCK alt= rewrite_alternative EOB ) )
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1274:4: ^( BLOCK alt= rewrite_alternative EOB )
            {
            BLOCK14=(GrammarAST)match(input,BLOCK,FOLLOW_BLOCK_in_rewrite_block1759); if (state.failed) return code;

            if ( state.backtracking==0 ) {

              				currentBlockST.add("referencedElementsDeep",
              					getTokenTypesAsTargetLabels(BLOCK14.rewriteRefsDeep));
              				currentBlockST.add("referencedElements",
              					getTokenTypesAsTargetLabels(BLOCK14.rewriteRefsShallow));
              			
            }

            match(input, Token.DOWN, null); if (state.failed) return code;
            pushFollow(FOLLOW_rewrite_alternative_in_rewrite_block1771);
            alt=rewrite_alternative();

            state._fsp--;
            if (state.failed) return code;
            match(input,EOB,FOLLOW_EOB_in_rewrite_block1776); if (state.failed) return code;

            match(input, Token.UP, null); if (state.failed) return code;
            if ( state.backtracking==0 ) {

              			code.add("alt", alt);
              		
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
             rewriteBlockNestingLevel--; currentBlockST = save_currentBlockST; 
        }
        return code;
    }
    // $ANTLR end "rewrite_block"


    // $ANTLR start "rewrite_alternative"
    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1290:1: rewrite_alternative returns [ST code=null] : ({...}? ^(a= ALT ( (el= rewrite_element )+ | EPSILON ) EOA ) | {...}? rewrite_template | ETC );
    public final ST rewrite_alternative() throws RecognitionException {
        ST code = null;

        GrammarAST a=null;
        CodeGenTreeWalker.rewrite_element_return el = null;

        ST rewrite_template15 = null;


        try {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1291:2: ({...}? ^(a= ALT ( (el= rewrite_element )+ | EPSILON ) EOA ) | {...}? rewrite_template | ETC )
            int alt63=3;
            switch ( input.LA(1) ) {
            case ALT:
                {
                switch ( input.LA(2) ) {
                case DOWN:
                    {
                    switch ( input.LA(3) ) {
                    case EPSILON:
                        {
                        switch ( input.LA(4) ) {
                        case EOA:
                            {
                            switch ( input.LA(5) ) {
                            case UP:
                                {
                                int LA63_8 = input.LA(6);

                                if ( ((generator.grammar.buildAST())) ) {
                                    alt63=1;
                                }
                                else if ( ((generator.grammar.buildTemplate())) ) {
                                    alt63=2;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return code;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 63, 8, input);

                                    throw nvae;
                                }
                                }
                                break;
                            default:
                                if (state.backtracking>0) {state.failed=true; return code;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 63, 7, input);

                                throw nvae;
                            }

                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return code;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 63, 5, input);

                            throw nvae;
                        }

                        }
                        break;
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
                        alt63=1;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return code;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 63, 4, input);

                        throw nvae;
                    }

                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return code;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 63, 1, input);

                    throw nvae;
                }

                }
                break;
            case TEMPLATE:
            case ACTION:
                {
                alt63=2;
                }
                break;
            case ETC:
                {
                alt63=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return code;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }

            switch (alt63) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1291:4: {...}? ^(a= ALT ( (el= rewrite_element )+ | EPSILON ) EOA )
                    {
                    if ( !((generator.grammar.buildAST())) ) {
                        if (state.backtracking>0) {state.failed=true; return code;}
                        throw new FailedPredicateException(input, "rewrite_alternative", "generator.grammar.buildAST()");
                    }
                    a=(GrammarAST)match(input,ALT,FOLLOW_ALT_in_rewrite_alternative1811); if (state.failed) return code;

                    if ( state.backtracking==0 ) {
                      code =templates.getInstanceOf("rewriteElementList");
                    }

                    match(input, Token.DOWN, null); if (state.failed) return code;
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1293:4: ( (el= rewrite_element )+ | EPSILON )
                    int alt62=2;
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
                        alt62=1;
                        }
                        break;
                    case EPSILON:
                        {
                        alt62=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return code;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 62, 0, input);

                        throw nvae;
                    }

                    switch (alt62) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1293:6: (el= rewrite_element )+
                            {
                            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1293:6: (el= rewrite_element )+
                            int cnt61=0;
                            loop61:
                            do {
                                int alt61=2;
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
                                    alt61=1;
                                    }
                                    break;

                                }

                                switch (alt61) {
                            	case 1 :
                            	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1294:6: el= rewrite_element
                            	    {
                            	    pushFollow(FOLLOW_rewrite_element_in_rewrite_alternative1829);
                            	    el=rewrite_element();

                            	    state._fsp--;
                            	    if (state.failed) return code;
                            	    if ( state.backtracking==0 ) {
                            	      code.addAggr("elements.{el,line,pos}",
                            	      										(el!=null?el.code:null),
                            	      										(el!=null?((GrammarAST)el.start):null).getLine(),
                            	      										(el!=null?((GrammarAST)el.start):null).getCharPositionInLine() + 1
                            	      										);
                            	      					
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt61 >= 1 ) break loop61;
                            	    if (state.backtracking>0) {state.failed=true; return code;}
                                        EarlyExitException eee =
                                            new EarlyExitException(61, input);
                                        throw eee;
                                }
                                cnt61++;
                            } while (true);


                            }
                            break;
                        case 2 :
                            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1302:6: EPSILON
                            {
                            match(input,EPSILON,FOLLOW_EPSILON_in_rewrite_alternative1850); if (state.failed) return code;
                            if ( state.backtracking==0 ) {
                              code.addAggr("elements.{el,line,pos}",
                              								   templates.getInstanceOf("rewriteEmptyAlt"),
                              								   a.getLine(),
                              								   a.getCharPositionInLine() + 1
                              								   );
                              				
                            }

                            }
                            break;

                    }

                    match(input,EOA,FOLLOW_EOA_in_rewrite_alternative1866); if (state.failed) return code;

                    match(input, Token.UP, null); if (state.failed) return code;

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1313:4: {...}? rewrite_template
                    {
                    if ( !((generator.grammar.buildTemplate())) ) {
                        if (state.backtracking>0) {state.failed=true; return code;}
                        throw new FailedPredicateException(input, "rewrite_alternative", "generator.grammar.buildTemplate()");
                    }
                    pushFollow(FOLLOW_rewrite_template_in_rewrite_alternative1879);
                    rewrite_template15=rewrite_template();

                    state._fsp--;
                    if (state.failed) return code;
                    if ( state.backtracking==0 ) {
                       code = rewrite_template15; 
                    }

                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1317:3: ETC
                    {
                    match(input,ETC,FOLLOW_ETC_in_rewrite_alternative1892); if (state.failed) return code;

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
        return code;
    }
    // $ANTLR end "rewrite_alternative"

    public static class rewrite_element_return extends TreeRuleReturnScope {
        public ST code=null;
    };

    // $ANTLR start "rewrite_element"
    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1320:1: rewrite_element returns [ST code=null] : ( rewrite_atom[false] | rewrite_ebnf | rewrite_tree );
    public final CodeGenTreeWalker.rewrite_element_return rewrite_element() throws RecognitionException {
        CodeGenTreeWalker.rewrite_element_return retval = new CodeGenTreeWalker.rewrite_element_return();
        retval.start = input.LT(1);

        CodeGenTreeWalker.rewrite_atom_return rewrite_atom16 = null;

        CodeGenTreeWalker.rewrite_ebnf_return rewrite_ebnf17 = null;

        CodeGenTreeWalker.rewrite_tree_return rewrite_tree18 = null;



        	IntSet elements=null;
        	GrammarAST ast = null;

        try {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1326:2: ( rewrite_atom[false] | rewrite_ebnf | rewrite_tree )
            int alt64=3;
            switch ( input.LA(1) ) {
            case LABEL:
            case ACTION:
            case STRING_LITERAL:
            case CHAR_LITERAL:
            case TOKEN_REF:
            case RULE_REF:
                {
                alt64=1;
                }
                break;
            case OPTIONAL:
            case CLOSURE:
            case POSITIVE_CLOSURE:
                {
                alt64=2;
                }
                break;
            case TREE_BEGIN:
                {
                alt64=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1326:4: rewrite_atom[false]
                    {
                    pushFollow(FOLLOW_rewrite_atom_in_rewrite_element1912);
                    rewrite_atom16=rewrite_atom(false);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       retval.code = (rewrite_atom16!=null?rewrite_atom16.code:null); 
                    }

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1328:4: rewrite_ebnf
                    {
                    pushFollow(FOLLOW_rewrite_ebnf_in_rewrite_element1922);
                    rewrite_ebnf17=rewrite_ebnf();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       retval.code = (rewrite_ebnf17!=null?rewrite_ebnf17.code:null); 
                    }

                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1330:4: rewrite_tree
                    {
                    pushFollow(FOLLOW_rewrite_tree_in_rewrite_element1931);
                    rewrite_tree18=rewrite_tree();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       retval.code = (rewrite_tree18!=null?rewrite_tree18.code:null); 
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
    // $ANTLR end "rewrite_element"

    public static class rewrite_ebnf_return extends TreeRuleReturnScope {
        public ST code=null;
    };

    // $ANTLR start "rewrite_ebnf"
    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1334:1: rewrite_ebnf returns [ST code=null] : ( ^( OPTIONAL rewrite_block[\"rewriteOptionalBlock\"] ) | ^( CLOSURE rewrite_block[\"rewriteClosureBlock\"] ) | ^( POSITIVE_CLOSURE rewrite_block[\"rewritePositiveClosureBlock\"] ) );
    public final CodeGenTreeWalker.rewrite_ebnf_return rewrite_ebnf() throws RecognitionException {
        CodeGenTreeWalker.rewrite_ebnf_return retval = new CodeGenTreeWalker.rewrite_ebnf_return();
        retval.start = input.LT(1);

        ST rewrite_block19 = null;

        ST rewrite_block20 = null;

        ST rewrite_block21 = null;


        try {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1335:2: ( ^( OPTIONAL rewrite_block[\"rewriteOptionalBlock\"] ) | ^( CLOSURE rewrite_block[\"rewriteClosureBlock\"] ) | ^( POSITIVE_CLOSURE rewrite_block[\"rewritePositiveClosureBlock\"] ) )
            int alt65=3;
            switch ( input.LA(1) ) {
            case OPTIONAL:
                {
                alt65=1;
                }
                break;
            case CLOSURE:
                {
                alt65=2;
                }
                break;
            case POSITIVE_CLOSURE:
                {
                alt65=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }

            switch (alt65) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1335:4: ^( OPTIONAL rewrite_block[\"rewriteOptionalBlock\"] )
                    {
                    match(input,OPTIONAL,FOLLOW_OPTIONAL_in_rewrite_ebnf1952); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_rewrite_block_in_rewrite_ebnf1954);
                    rewrite_block19=rewrite_block("rewriteOptionalBlock");

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       retval.code = rewrite_block19; 
                    }
                    if ( state.backtracking==0 ) {

                      			String description = grammar.grammarTreeToString(((GrammarAST)retval.start), false);
                      			description = generator.target.getTargetStringLiteralFromString(description);
                      			retval.code.add("description", description);
                      		
                    }

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1342:4: ^( CLOSURE rewrite_block[\"rewriteClosureBlock\"] )
                    {
                    match(input,CLOSURE,FOLLOW_CLOSURE_in_rewrite_ebnf1972); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_rewrite_block_in_rewrite_ebnf1974);
                    rewrite_block20=rewrite_block("rewriteClosureBlock");

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       retval.code = rewrite_block20; 
                    }
                    if ( state.backtracking==0 ) {

                      			String description = grammar.grammarTreeToString(((GrammarAST)retval.start), false);
                      			description = generator.target.getTargetStringLiteralFromString(description);
                      			retval.code.add("description", description);
                      		
                    }

                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1349:4: ^( POSITIVE_CLOSURE rewrite_block[\"rewritePositiveClosureBlock\"] )
                    {
                    match(input,POSITIVE_CLOSURE,FOLLOW_POSITIVE_CLOSURE_in_rewrite_ebnf1992); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_rewrite_block_in_rewrite_ebnf1994);
                    rewrite_block21=rewrite_block("rewritePositiveClosureBlock");

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       retval.code = rewrite_block21; 
                    }
                    if ( state.backtracking==0 ) {

                      			String description = grammar.grammarTreeToString(((GrammarAST)retval.start), false);
                      			description = generator.target.getTargetStringLiteralFromString(description);
                      			retval.code.add("description", description);
                      		
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
    // $ANTLR end "rewrite_ebnf"

    public static class rewrite_tree_return extends TreeRuleReturnScope {
        public ST code;
    };

    // $ANTLR start "rewrite_tree"
    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1358:1: rewrite_tree returns [ST code] : ^( TREE_BEGIN r= rewrite_atom[true] (el= rewrite_element )* ) ;
    public final CodeGenTreeWalker.rewrite_tree_return rewrite_tree() throws RecognitionException {
        CodeGenTreeWalker.rewrite_tree_return retval = new CodeGenTreeWalker.rewrite_tree_return();
        retval.start = input.LT(1);

        CodeGenTreeWalker.rewrite_atom_return r = null;

        CodeGenTreeWalker.rewrite_element_return el = null;



        	rewriteTreeNestingLevel++;
        	if ( state.backtracking == 0 )
        	{
        		retval.code = templates.getInstanceOf("rewriteTree");
        		retval.code.add("treeLevel", rewriteTreeNestingLevel);
        		retval.code.add("enclosingTreeLevel", rewriteTreeNestingLevel-1);
        	}

        try {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1369:2: ( ^( TREE_BEGIN r= rewrite_atom[true] (el= rewrite_element )* ) )
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1369:4: ^( TREE_BEGIN r= rewrite_atom[true] (el= rewrite_element )* )
            {
            match(input,TREE_BEGIN,FOLLOW_TREE_BEGIN_in_rewrite_tree2027); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            pushFollow(FOLLOW_rewrite_atom_in_rewrite_tree2034);
            r=rewrite_atom(true);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {

              				retval.code.addAggr("root.{el,line,pos}",
              								   (r!=null?r.code:null),
              								   (r!=null?((GrammarAST)r.start):null).getLine(),
              								   (r!=null?((GrammarAST)r.start):null).getCharPositionInLine() + 1
              								  );
              			
            }
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1378:4: (el= rewrite_element )*
            loop66:
            do {
                int alt66=2;
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
                    alt66=1;
                    }
                    break;

                }

                switch (alt66) {
            	case 1 :
            	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1379:6: el= rewrite_element
            	    {
            	    pushFollow(FOLLOW_rewrite_element_in_rewrite_tree2054);
            	    el=rewrite_element();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {

            	      				retval.code.addAggr("children.{el,line,pos}",
            	      									(el!=null?el.code:null),
            	      									(el!=null?((GrammarAST)el.start):null).getLine(),
            	      									(el!=null?((GrammarAST)el.start):null).getCharPositionInLine() + 1
            	      									);
            	      			  
            	    }

            	    }
            	    break;

            	default :
            	    break loop66;
                }
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            if ( state.backtracking==0 ) {

              			String description = grammar.grammarTreeToString(((GrammarAST)retval.start), false);
              			description = generator.target.getTargetStringLiteralFromString(description);
              			retval.code.add("description", description);
              		
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
             rewriteTreeNestingLevel--; 
        }
        return retval;
    }
    // $ANTLR end "rewrite_tree"

    public static class rewrite_atom_return extends TreeRuleReturnScope {
        public ST code=null;
    };

    // $ANTLR start "rewrite_atom"
    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1397:1: rewrite_atom[boolean isRoot] returns [ST code=null] : (r= RULE_REF | ( ^(tk= TOKEN_REF (arg= ARG_ACTION )? ) | cl= CHAR_LITERAL | sl= STRING_LITERAL ) | LABEL | ACTION );
    public final CodeGenTreeWalker.rewrite_atom_return rewrite_atom(boolean isRoot) throws RecognitionException {
        CodeGenTreeWalker.rewrite_atom_return retval = new CodeGenTreeWalker.rewrite_atom_return();
        retval.start = input.LT(1);

        GrammarAST r=null;
        GrammarAST tk=null;
        GrammarAST arg=null;
        GrammarAST cl=null;
        GrammarAST sl=null;
        GrammarAST LABEL22=null;
        GrammarAST ACTION23=null;

        try {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1398:2: (r= RULE_REF | ( ^(tk= TOKEN_REF (arg= ARG_ACTION )? ) | cl= CHAR_LITERAL | sl= STRING_LITERAL ) | LABEL | ACTION )
            int alt69=4;
            switch ( input.LA(1) ) {
            case RULE_REF:
                {
                alt69=1;
                }
                break;
            case STRING_LITERAL:
            case CHAR_LITERAL:
            case TOKEN_REF:
                {
                alt69=2;
                }
                break;
            case LABEL:
                {
                alt69=3;
                }
                break;
            case ACTION:
                {
                alt69=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }

            switch (alt69) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1398:6: r= RULE_REF
                    {
                    r=(GrammarAST)match(input,RULE_REF,FOLLOW_RULE_REF_in_rewrite_atom2099); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      			String ruleRefName = (r!=null?r.getText():null);
                      			String stName = "rewriteRuleRef";
                      			if ( isRoot )
                      			{
                      				stName += "Root";
                      			}
                      			retval.code = templates.getInstanceOf(stName);
                      			retval.code.add("rule", ruleRefName);
                      			if ( grammar.getRule(ruleRefName)==null )
                      			{
                      				ErrorManager.grammarError(ErrorManager.MSG_UNDEFINED_RULE_REF,
                      										  grammar,
                      										  ((GrammarAST)(r)).getToken(),
                      										  ruleRefName);
                      				retval.code = new ST(""); // blank; no code gen
                      			}
                      			else if ( grammar.getRule(currentRuleName)
                      						 .getRuleRefsInAlt(ruleRefName,outerAltNum)==null )
                      			{
                      				ErrorManager.grammarError(ErrorManager.MSG_REWRITE_ELEMENT_NOT_PRESENT_ON_LHS,
                      										  grammar,
                      										  ((GrammarAST)(r)).getToken(),
                      										  ruleRefName);
                      				retval.code = new ST(""); // blank; no code gen
                      			}
                      			else
                      			{
                      				// track all rule refs as we must copy 2nd ref to rule and beyond
                      				if ( !rewriteRuleRefs.contains(ruleRefName) )
                      				{
                      					rewriteRuleRefs.add(ruleRefName);
                      				}
                      			}
                      		
                    }

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1436:3: ( ^(tk= TOKEN_REF (arg= ARG_ACTION )? ) | cl= CHAR_LITERAL | sl= STRING_LITERAL )
                    {
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1436:3: ( ^(tk= TOKEN_REF (arg= ARG_ACTION )? ) | cl= CHAR_LITERAL | sl= STRING_LITERAL )
                    int alt68=3;
                    switch ( input.LA(1) ) {
                    case TOKEN_REF:
                        {
                        alt68=1;
                        }
                        break;
                    case CHAR_LITERAL:
                        {
                        alt68=2;
                        }
                        break;
                    case STRING_LITERAL:
                        {
                        alt68=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 68, 0, input);

                        throw nvae;
                    }

                    switch (alt68) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1436:5: ^(tk= TOKEN_REF (arg= ARG_ACTION )? )
                            {
                            tk=(GrammarAST)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_rewrite_atom2116); if (state.failed) return retval;

                            if ( input.LA(1)==Token.DOWN ) {
                                match(input, Token.DOWN, null); if (state.failed) return retval;
                                // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1436:20: (arg= ARG_ACTION )?
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
                                        // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1436:21: arg= ARG_ACTION
                                        {
                                        arg=(GrammarAST)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rewrite_atom2121); if (state.failed) return retval;

                                        }
                                        break;

                                }


                                match(input, Token.UP, null); if (state.failed) return retval;
                            }

                            }
                            break;
                        case 2 :
                            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1437:5: cl= CHAR_LITERAL
                            {
                            cl=(GrammarAST)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_rewrite_atom2132); if (state.failed) return retval;

                            }
                            break;
                        case 3 :
                            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1438:5: sl= STRING_LITERAL
                            {
                            sl=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_rewrite_atom2140); if (state.failed) return retval;

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      			GrammarAST term = tk;
                      			if (term == null) term = cl;
                      			if (term == null) term = sl;
                      			String tokenName = ((GrammarAST)retval.start).getToken().getText();
                      			String stName = "rewriteTokenRef";
                      			Rule rule = grammar.getRule(currentRuleName);
                      			Collection<String> tokenRefsInAlt = rule.getTokenRefsInAlt(outerAltNum);
                      			boolean createNewNode = !tokenRefsInAlt.contains(tokenName) || arg!=null;
                      			if ( createNewNode )
                      			{
                      				stName = "rewriteImaginaryTokenRef";
                      			}
                      			if ( isRoot )
                      			{
                      				stName += "Root";
                      			}
                      			retval.code = templates.getInstanceOf(stName);
                      			retval.code.add("terminalOptions",term.terminalOptions);
                      			if ( arg!=null )
                      			{
                      				List args = generator.translateAction(currentRuleName,arg);
                      				retval.code.add("args", args);
                      			}
                      			retval.code.add("elementIndex", ((CommonToken)((GrammarAST)retval.start).getToken()).getTokenIndex());
                      			int ttype = grammar.getTokenType(tokenName);
                      			String tok = generator.getTokenTypeAsTargetLabel(ttype);
                      			retval.code.add("token", tok);
                      			if ( grammar.getTokenType(tokenName)==Label.INVALID )
                      			{
                      				ErrorManager.grammarError(ErrorManager.MSG_UNDEFINED_TOKEN_REF_IN_REWRITE,
                      										  grammar,
                      										  ((GrammarAST)(((GrammarAST)retval.start))).getToken(),
                      										  tokenName);
                      				retval.code = new ST(""); // blank; no code gen
                      			}
                      		
                    }

                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1478:4: LABEL
                    {
                    LABEL22=(GrammarAST)match(input,LABEL,FOLLOW_LABEL_in_rewrite_atom2154); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      			String labelName = (LABEL22!=null?LABEL22.getText():null);
                      			Rule rule = grammar.getRule(currentRuleName);
                      			Grammar.LabelElementPair pair = rule.getLabel(labelName);
                      			if ( labelName.equals(currentRuleName) )
                      			{
                      				// special case; ref to old value via $ rule
                      				if ( rule.hasRewrite(outerAltNum) &&
                      					 rule.getRuleRefsInAlt(outerAltNum).contains(labelName) )
                      				{
                      					ErrorManager.grammarError(ErrorManager.MSG_RULE_REF_AMBIG_WITH_RULE_IN_ALT,
                      											  grammar,
                      											  ((GrammarAST)(LABEL22)).getToken(),
                      											  labelName);
                      				}
                      				ST labelST = templates.getInstanceOf("prevRuleRootRef");
                      				retval.code = templates.getInstanceOf("rewriteRuleLabelRef"+(isRoot?"Root":""));
                      				retval.code.add("label", labelST);
                      			}
                      			else if ( pair==null )
                      			{
                      				ErrorManager.grammarError(ErrorManager.MSG_UNDEFINED_LABEL_REF_IN_REWRITE,
                      										  grammar,
                      										  ((GrammarAST)(LABEL22)).getToken(),
                      										  labelName);
                      				retval.code = new ST("");
                      			}
                      			else
                      			{
                      				String stName = null;
                      				switch ( pair.type )
                      				{
                      				case Grammar.TOKEN_LABEL :
                      					stName = "rewriteTokenLabelRef";
                      					break;
                      				case Grammar.WILDCARD_TREE_LABEL :
                      					stName = "rewriteWildcardLabelRef";
                      					break;
                      				case Grammar.WILDCARD_TREE_LIST_LABEL:
                      					stName = "rewriteRuleListLabelRef"; // acts like rule ref list for ref
                      					break;
                      				case Grammar.RULE_LABEL :
                      					stName = "rewriteRuleLabelRef";
                      					break;
                      				case Grammar.TOKEN_LIST_LABEL :
                      					stName = "rewriteTokenListLabelRef";
                      					break;
                      				case Grammar.RULE_LIST_LABEL :
                      					stName = "rewriteRuleListLabelRef";
                      					break;
                      				}
                      				if ( isRoot )
                      				{
                      					stName += "Root";
                      				}
                      				retval.code = templates.getInstanceOf(stName);
                      				retval.code.add("label", labelName);
                      			}
                      		
                    }

                    }
                    break;
                case 4 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1539:4: ACTION
                    {
                    ACTION23=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_rewrite_atom2164); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      			// actions in rewrite rules yield a tree object
                      			String actText = (ACTION23!=null?ACTION23.getText():null);
                      			List chunks = generator.translateAction(currentRuleName,ACTION23);
                      			retval.code = templates.getInstanceOf("rewriteNodeAction"+(isRoot?"Root":""));
                      			retval.code.add("action", chunks);
                      		
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
    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1549:1: public rewrite_template returns [ST code=null] : ( ^( ALT EPSILON EOA ) | ^( TEMPLATE (id= ID | ind= ACTION ) ^( ARGLIST ( ^( ARG arg= ID a= ACTION ) )* ) ( DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL )? ) | act= ACTION );
    public final ST rewrite_template() throws RecognitionException {
        ST code = null;

        GrammarAST id=null;
        GrammarAST ind=null;
        GrammarAST arg=null;
        GrammarAST a=null;
        GrammarAST act=null;
        GrammarAST DOUBLE_QUOTE_STRING_LITERAL24=null;
        GrammarAST DOUBLE_ANGLE_STRING_LITERAL25=null;

        try {
            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1551:2: ( ^( ALT EPSILON EOA ) | ^( TEMPLATE (id= ID | ind= ACTION ) ^( ARGLIST ( ^( ARG arg= ID a= ACTION ) )* ) ( DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL )? ) | act= ACTION )
            int alt73=3;
            switch ( input.LA(1) ) {
            case ALT:
                {
                alt73=1;
                }
                break;
            case TEMPLATE:
                {
                alt73=2;
                }
                break;
            case ACTION:
                {
                alt73=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return code;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }

            switch (alt73) {
                case 1 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1551:4: ^( ALT EPSILON EOA )
                    {
                    match(input,ALT,FOLLOW_ALT_in_rewrite_template2187); if (state.failed) return code;

                    match(input, Token.DOWN, null); if (state.failed) return code;
                    match(input,EPSILON,FOLLOW_EPSILON_in_rewrite_template2189); if (state.failed) return code;
                    match(input,EOA,FOLLOW_EOA_in_rewrite_template2191); if (state.failed) return code;

                    match(input, Token.UP, null); if (state.failed) return code;
                    if ( state.backtracking==0 ) {
                      code =templates.getInstanceOf("rewriteEmptyTemplate");
                    }

                    }
                    break;
                case 2 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1552:4: ^( TEMPLATE (id= ID | ind= ACTION ) ^( ARGLIST ( ^( ARG arg= ID a= ACTION ) )* ) ( DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL )? )
                    {
                    match(input,TEMPLATE,FOLLOW_TEMPLATE_in_rewrite_template2202); if (state.failed) return code;

                    match(input, Token.DOWN, null); if (state.failed) return code;
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1552:16: (id= ID | ind= ACTION )
                    int alt70=2;
                    switch ( input.LA(1) ) {
                    case ID:
                        {
                        alt70=1;
                        }
                        break;
                    case ACTION:
                        {
                        alt70=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return code;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 70, 0, input);

                        throw nvae;
                    }

                    switch (alt70) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1552:17: id= ID
                            {
                            id=(GrammarAST)match(input,ID,FOLLOW_ID_in_rewrite_template2207); if (state.failed) return code;

                            }
                            break;
                        case 2 :
                            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1552:23: ind= ACTION
                            {
                            ind=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_rewrite_template2211); if (state.failed) return code;

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				if ( id!=null && (id!=null?id.getText():null).equals("template") )
                      				{
                      						code = templates.getInstanceOf("rewriteInlineTemplate");
                      				}
                      				else if ( id!=null )
                      				{
                      						code = templates.getInstanceOf("rewriteExternalTemplate");
                      						code.add("name", (id!=null?id.getText():null));
                      				}
                      				else if ( ind!=null )
                      				{ // must be %({expr})(args)
                      					code = templates.getInstanceOf("rewriteIndirectTemplate");
                      					List chunks=generator.translateAction(currentRuleName,ind);
                      					code.add("expr", chunks);
                      				}
                      			
                    }
                    match(input,ARGLIST,FOLLOW_ARGLIST_in_rewrite_template2224); if (state.failed) return code;

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return code;
                        // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1571:5: ( ^( ARG arg= ID a= ACTION ) )*
                        loop71:
                        do {
                            int alt71=2;
                            switch ( input.LA(1) ) {
                            case ARG:
                                {
                                alt71=1;
                                }
                                break;

                            }

                            switch (alt71) {
                        	case 1 :
                        	    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1571:7: ^( ARG arg= ID a= ACTION )
                        	    {
                        	    match(input,ARG,FOLLOW_ARG_in_rewrite_template2234); if (state.failed) return code;

                        	    match(input, Token.DOWN, null); if (state.failed) return code;
                        	    arg=(GrammarAST)match(input,ID,FOLLOW_ID_in_rewrite_template2238); if (state.failed) return code;
                        	    a=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_rewrite_template2242); if (state.failed) return code;
                        	    if ( state.backtracking==0 ) {

                        	      						// must set alt num here rather than in define.g
                        	      						// because actions like %foo(name={$ID.text}) aren't
                        	      						// broken up yet into trees.
                        	      						a.outerAltNum = this.outerAltNum;
                        	      						List chunks = generator.translateAction(currentRuleName,a);
                        	      						code.addAggr("args.{name,value}", (arg!=null?arg.getText():null), chunks);
                        	      					
                        	    }

                        	    match(input, Token.UP, null); if (state.failed) return code;

                        	    }
                        	    break;

                        	default :
                        	    break loop71;
                            }
                        } while (true);


                        match(input, Token.UP, null); if (state.failed) return code;
                    }
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1583:4: ( DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL )?
                    int alt72=3;
                    switch ( input.LA(1) ) {
                        case DOUBLE_QUOTE_STRING_LITERAL:
                            {
                            alt72=1;
                            }
                            break;
                        case DOUBLE_ANGLE_STRING_LITERAL:
                            {
                            alt72=2;
                            }
                            break;
                    }

                    switch (alt72) {
                        case 1 :
                            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1583:6: DOUBLE_QUOTE_STRING_LITERAL
                            {
                            DOUBLE_QUOTE_STRING_LITERAL24=(GrammarAST)match(input,DOUBLE_QUOTE_STRING_LITERAL,FOLLOW_DOUBLE_QUOTE_STRING_LITERAL_in_rewrite_template2275); if (state.failed) return code;
                            if ( state.backtracking==0 ) {

                              					String sl = (DOUBLE_QUOTE_STRING_LITERAL24!=null?DOUBLE_QUOTE_STRING_LITERAL24.getText():null);
                              					String t = sl.substring( 1, sl.length() - 1 ); // strip quotes
                              					t = generator.target.getTargetStringLiteralFromString(t);
                              					code.add("template",t);
                              				
                            }

                            }
                            break;
                        case 2 :
                            // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1590:6: DOUBLE_ANGLE_STRING_LITERAL
                            {
                            DOUBLE_ANGLE_STRING_LITERAL25=(GrammarAST)match(input,DOUBLE_ANGLE_STRING_LITERAL,FOLLOW_DOUBLE_ANGLE_STRING_LITERAL_in_rewrite_template2288); if (state.failed) return code;
                            if ( state.backtracking==0 ) {

                              					String sl = (DOUBLE_ANGLE_STRING_LITERAL25!=null?DOUBLE_ANGLE_STRING_LITERAL25.getText():null);
                              					String t = sl.substring( 2, sl.length() - 2 ); // strip double angle quotes
                              					t = generator.target.getTargetStringLiteralFromString(t);
                              					code.add("template",t);
                              				
                            }

                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return code;

                    }
                    break;
                case 3 :
                    // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:1600:4: act= ACTION
                    {
                    act=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_rewrite_template2312); if (state.failed) return code;
                    if ( state.backtracking==0 ) {

                      			// set alt num for same reason as ARGLIST above
                      			act.outerAltNum = this.outerAltNum;
                      			code =templates.getInstanceOf("rewriteAction");
                      			code.add("action",
                      							  generator.translateAction(currentRuleName,act));
                      		
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
        return code;
    }
    // $ANTLR end "rewrite_template"

    // $ANTLR start synpred1_CodeGenTreeWalker
    public final void synpred1_CodeGenTreeWalker_fragment() throws RecognitionException {   
        // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:749:4: ({...}? ( BLOCK | OPTIONAL | CLOSURE | POSITIVE_CLOSURE ) )
        // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:749:5: {...}? ( BLOCK | OPTIONAL | CLOSURE | POSITIVE_CLOSURE )
        {
        if ( !((((GrammarAST)input.LT(1)).getSetValue()==null)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred1_CodeGenTreeWalker", "((GrammarAST)input.LT(1)).getSetValue()==null");
        }
        if ( (input.LA(1)>=BLOCK && input.LA(1)<=POSITIVE_CLOSURE) ) {
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
    // $ANTLR end synpred1_CodeGenTreeWalker

    // $ANTLR start synpred2_CodeGenTreeWalker
    public final void synpred2_CodeGenTreeWalker_fragment() throws RecognitionException {   
        // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:917:6: ( element_action )
        // org\\antlr\\grammar\\v3\\CodeGenTreeWalker.g:917:7: element_action
        {
        pushFollow(FOLLOW_element_action_in_synpred2_CodeGenTreeWalker1393);
        element_action();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_CodeGenTreeWalker

    // Delegated rules

    public final boolean synpred1_CodeGenTreeWalker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_CodeGenTreeWalker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_CodeGenTreeWalker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_CodeGenTreeWalker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA46 dfa46 = new DFA46(this);
    static final String DFA46_eotS =
        "\32\uffff";
    static final String DFA46_eofS =
        "\32\uffff";
    static final String DFA46_minS =
        "\1\22\6\uffff\1\0\22\uffff";
    static final String DFA46_maxS =
        "\1\115\6\uffff\1\0\22\uffff";
    static final String DFA46_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\3\7\1\10\5\uffff\1\11"+
        "\1\12\1\uffff\1\13\1\uffff\1\14\1\15\1\16\1\17";
    static final String DFA46_specialS =
        "\1\0\6\uffff\1\1\22\uffff}>";
    static final String[] DFA46_transitionS = {
            "\1\7\1\10\1\11\1\12\1\27\1\uffff\1\6\1\31\15\uffff\1\22\4\uffff"+
            "\1\24\1\26\1\30\1\uffff\1\13\1\uffff\1\22\6\uffff\1\4\2\13\4"+
            "\uffff\1\13\1\2\4\uffff\1\5\1\24\1\uffff\1\1\2\13\1\3\1\21",
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

    static final short[] DFA46_eot = DFA.unpackEncodedString(DFA46_eotS);
    static final short[] DFA46_eof = DFA.unpackEncodedString(DFA46_eofS);
    static final char[] DFA46_min = DFA.unpackEncodedStringToUnsignedChars(DFA46_minS);
    static final char[] DFA46_max = DFA.unpackEncodedStringToUnsignedChars(DFA46_maxS);
    static final short[] DFA46_accept = DFA.unpackEncodedString(DFA46_acceptS);
    static final short[] DFA46_special = DFA.unpackEncodedString(DFA46_specialS);
    static final short[][] DFA46_transition;

    static {
        int numStates = DFA46_transitionS.length;
        DFA46_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA46_transition[i] = DFA.unpackEncodedString(DFA46_transitionS[i]);
        }
    }

    class DFA46 extends DFA {

        public DFA46(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 46;
            this.eot = DFA46_eot;
            this.eof = DFA46_eof;
            this.min = DFA46_min;
            this.max = DFA46_max;
            this.accept = DFA46_accept;
            this.special = DFA46_special;
            this.transition = DFA46_transition;
        }
        public String getDescription() {
            return "714:1: element[GrammarAST label, GrammarAST astSuffix] returns [ST code=null] options {k=1; } : ( ^( ROOT e= element[label,$ROOT] ) | ^( BANG e= element[label,$BANG] ) | ^(n= NOT notElement[$n, $label, $astSuffix] ) | ^( ASSIGN alabel= ID e= element[$alabel,$astSuffix] ) | ^( PLUS_ASSIGN label2= ID e= element[$label2,$astSuffix] ) | ^( CHAR_RANGE a= CHAR_LITERAL b= CHAR_LITERAL ) | ({...}? ( BLOCK | OPTIONAL | CLOSURE | POSITIVE_CLOSURE ) )=> ebnf | atom[null, $label, $astSuffix] | tree_ | element_action | (sp= SEMPRED | sp= GATED_SEMPRED ) | SYN_SEMPRED | ^( SYNPRED ( . )* ) | ^( BACKTRACK_SEMPRED ( . )* ) | EPSILON );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TreeNodeStream input = (TreeNodeStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA46_0 = input.LA(1);

                         
                        int index46_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA46_0==ROOT) ) {s = 1;}

                        else if ( (LA46_0==BANG) ) {s = 2;}

                        else if ( (LA46_0==NOT) ) {s = 3;}

                        else if ( (LA46_0==ASSIGN) ) {s = 4;}

                        else if ( (LA46_0==PLUS_ASSIGN) ) {s = 5;}

                        else if ( (LA46_0==CHAR_RANGE) ) {s = 6;}

                        else if ( (LA46_0==BLOCK) ) {s = 7;}

                        else if ( (LA46_0==OPTIONAL) && (synpred1_CodeGenTreeWalker())) {s = 8;}

                        else if ( (LA46_0==CLOSURE) && (synpred1_CodeGenTreeWalker())) {s = 9;}

                        else if ( (LA46_0==POSITIVE_CLOSURE) && (synpred1_CodeGenTreeWalker())) {s = 10;}

                        else if ( (LA46_0==DOT||(LA46_0>=STRING_LITERAL && LA46_0<=CHAR_LITERAL)||LA46_0==TOKEN_REF||(LA46_0>=WILDCARD && LA46_0<=RULE_REF)) ) {s = 11;}

                        else if ( (LA46_0==TREE_BEGIN) ) {s = 17;}

                        else if ( (LA46_0==FORCED_ACTION||LA46_0==ACTION) ) {s = 18;}

                        else if ( (LA46_0==GATED_SEMPRED||LA46_0==SEMPRED) ) {s = 20;}

                        else if ( (LA46_0==SYN_SEMPRED) ) {s = 22;}

                        else if ( (LA46_0==SYNPRED) ) {s = 23;}

                        else if ( (LA46_0==BACKTRACK_SEMPRED) ) {s = 24;}

                        else if ( (LA46_0==EPSILON) ) {s = 25;}

                         
                        input.seek(index46_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA46_7 = input.LA(1);

                         
                        int index46_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_CodeGenTreeWalker()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index46_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 46, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_LEXER_GRAMMAR_in_grammar_61 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_grammarSpec_in_grammar_63 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARSER_GRAMMAR_in_grammar_73 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_grammarSpec_in_grammar_75 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TREE_GRAMMAR_in_grammar_85 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_grammarSpec_in_grammar_87 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COMBINED_GRAMMAR_in_grammar_97 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_grammarSpec_in_grammar_99 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SCOPE_in_attrScope118 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_attrScope120 = new BitSet(new long[]{0x0024000000000000L});
    public static final BitSet FOLLOW_AMPERSAND_in_attrScope125 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ACTION_in_attrScope134 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_grammarSpec151 = new BitSet(new long[]{0x80A80C0000018000L});
    public static final BitSet FOLLOW_DOC_COMMENT_in_grammarSpec159 = new BitSet(new long[]{0x80A80C0000018000L});
    public static final BitSet FOLLOW_OPTIONS_in_grammarSpec180 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IMPORT_in_grammarSpec194 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TOKENS_in_grammarSpec208 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attrScope_in_grammarSpec220 = new BitSet(new long[]{0x80A80C0000018000L});
    public static final BitSet FOLLOW_AMPERSAND_in_grammarSpec229 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rules_in_grammarSpec240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule_in_rules285 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_RULE_in_rules299 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PREC_RULE_in_rules311 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_RULE_in_rule353 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_rule357 = new BitSet(new long[]{0x0000800080000E00L});
    public static final BitSet FOLLOW_modifier_in_rule370 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ARG_in_rule378 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_rule381 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RET_in_rule390 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_rule393 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_throwsSpec_in_rule402 = new BitSet(new long[]{0x00A0040000040000L});
    public static final BitSet FOLLOW_OPTIONS_in_rule412 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ruleScopeSpec_in_rule425 = new BitSet(new long[]{0x00A0040000040000L});
    public static final BitSet FOLLOW_AMPERSAND_in_rule435 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_rule449 = new BitSet(new long[]{0x00000000080000C0L});
    public static final BitSet FOLLOW_exceptionGroup_in_rule462 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_EOR_in_rule470 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_modifier0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THROWS_in_throwsSpec520 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_throwsSpec522 = new BitSet(new long[]{0x0000000040000008L});
    public static final BitSet FOLLOW_SCOPE_in_ruleScopeSpec537 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_AMPERSAND_in_ruleScopeSpec542 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ACTION_in_ruleScopeSpec552 = new BitSet(new long[]{0x0000000040000008L});
    public static final BitSet FOLLOW_ID_in_ruleScopeSpec558 = new BitSet(new long[]{0x0000000040000008L});
    public static final BitSet FOLLOW_setBlock_in_block599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLOCK_in_block612 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_OPTIONS_in_block620 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alternative_in_block637 = new BitSet(new long[]{0x0002000014000000L});
    public static final BitSet FOLLOW_rewrite_in_block641 = new BitSet(new long[]{0x0002000014000000L});
    public static final BitSet FOLLOW_EOB_in_block658 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BLOCK_in_setBlock690 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ALT_in_setAlternative710 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_setElement_in_setAlternative712 = new BitSet(new long[]{0x0C00000021000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_EOA_in_setAlternative715 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_exceptionHandler_in_exceptionGroup730 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_finallyClause_in_exceptionGroup737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_finallyClause_in_exceptionGroup745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CATCH_in_exceptionHandler759 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_exceptionHandler761 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_ACTION_in_exceptionHandler763 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FINALLY_in_finallyClause781 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ACTION_in_finallyClause783 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ALT_in_alternative812 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_alternative825 = new BitSet(new long[]{0x0EA57480237C0000L,0x0000000000003EC3L});
    public static final BitSet FOLLOW_EOA_in_alternative843 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ROOT_in_element878 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_element882 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BANG_in_element895 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_element899 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_element915 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_notElement_in_element917 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSIGN_in_element932 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_element936 = new BitSet(new long[]{0x0EA57480237C0000L,0x0000000000003EC3L});
    public static final BitSet FOLLOW_element_in_element940 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_ASSIGN_in_element955 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_element959 = new BitSet(new long[]{0x0EA57480237C0000L,0x0000000000003EC3L});
    public static final BitSet FOLLOW_element_in_element963 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CHAR_RANGE_in_element977 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_element981 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_element985 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ebnf_in_element1014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_element1024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tree__in_element1035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_element_action_in_element1045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMPRED_in_element1060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GATED_SEMPRED_in_element1064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYN_SEMPRED_in_element1075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYNPRED_in_element1083 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BACKTRACK_SEMPRED_in_element1094 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EPSILON_in_element1106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_element_action1123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FORCED_ACTION_in_element_action1134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_notElement1163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_notElement1176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOKEN_REF_in_notElement1189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLOCK_in_notElement1203 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_ebnf1249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPTIONAL_in_ebnf1268 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_ebnf1272 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CLOSURE_in_ebnf1293 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_ebnf1297 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POSITIVE_CLOSURE_in_ebnf1318 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_ebnf1322 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TREE_BEGIN_in_tree_1360 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_tree_1367 = new BitSet(new long[]{0x0EA57480237C0008L,0x0000000000003EC3L});
    public static final BitSet FOLLOW_element_action_in_tree_1404 = new BitSet(new long[]{0x0EA57480237C0008L,0x0000000000003EC3L});
    public static final BitSet FOLLOW_element_in_tree_1426 = new BitSet(new long[]{0x0EA57480237C0008L,0x0000000000003EC3L});
    public static final BitSet FOLLOW_RULE_REF_in_atom1476 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_atom1481 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TOKEN_REF_in_atom1499 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_atom1504 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_atom1520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_atom1532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WILDCARD_in_atom1544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_atom1555 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_atom1557 = new BitSet(new long[]{0x0C01000000040000L,0x0000000000000C01L});
    public static final BitSet FOLLOW_atom_in_atom1561 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_atom1574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_ast_suffix0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLOCK_in_set1619 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_setElement1639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOKEN_REF_in_setElement1644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_setElement1649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_RANGE_in_setElement1655 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_setElement1657 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_setElement1659 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REWRITES_in_rewrite1684 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_REWRITE_in_rewrite1705 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SEMPRED_in_rewrite1710 = new BitSet(new long[]{0x0004020004000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_rewrite_alternative_in_rewrite1716 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BLOCK_in_rewrite_block1759 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rewrite_alternative_in_rewrite_block1771 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_EOB_in_rewrite_block1776 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ALT_in_rewrite_alternative1811 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rewrite_element_in_rewrite_alternative1829 = new BitSet(new long[]{0x0C04010020380000L,0x0000000000002801L});
    public static final BitSet FOLLOW_EPSILON_in_rewrite_alternative1850 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_EOA_in_rewrite_alternative1866 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rewrite_template_in_rewrite_alternative1879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ETC_in_rewrite_alternative1892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rewrite_atom_in_rewrite_element1912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rewrite_ebnf_in_rewrite_element1922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rewrite_tree_in_rewrite_element1931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPTIONAL_in_rewrite_ebnf1952 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rewrite_block_in_rewrite_ebnf1954 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CLOSURE_in_rewrite_ebnf1972 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rewrite_block_in_rewrite_ebnf1974 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POSITIVE_CLOSURE_in_rewrite_ebnf1992 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rewrite_block_in_rewrite_ebnf1994 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TREE_BEGIN_in_rewrite_tree2027 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rewrite_atom_in_rewrite_tree2034 = new BitSet(new long[]{0x0C04010020380008L,0x0000000000002801L});
    public static final BitSet FOLLOW_rewrite_element_in_rewrite_tree2054 = new BitSet(new long[]{0x0C04010020380008L,0x0000000000002801L});
    public static final BitSet FOLLOW_RULE_REF_in_rewrite_atom2099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOKEN_REF_in_rewrite_atom2116 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_rewrite_atom2121 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_rewrite_atom2132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_rewrite_atom2140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LABEL_in_rewrite_atom2154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_rewrite_atom2164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALT_in_rewrite_template2187 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EPSILON_in_rewrite_template2189 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_EOA_in_rewrite_template2191 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TEMPLATE_in_rewrite_template2202 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_rewrite_template2207 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_ACTION_in_rewrite_template2211 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_ARGLIST_in_rewrite_template2224 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_in_rewrite_template2234 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_rewrite_template2238 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_ACTION_in_rewrite_template2242 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOUBLE_QUOTE_STRING_LITERAL_in_rewrite_template2275 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOUBLE_ANGLE_STRING_LITERAL_in_rewrite_template2288 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ACTION_in_rewrite_template2312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred1_CodeGenTreeWalker999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_element_action_in_synpred2_CodeGenTreeWalker1393 = new BitSet(new long[]{0x0000000000000002L});

}