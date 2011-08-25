// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g 2011-08-25 17:56:54

package org.stringtemplate.v4.compiler;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.FailedPredicateException;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.RuleReturnScope;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.RewriteEarlyExitException;
import org.antlr.runtime.tree.RewriteRuleSubtreeStream;
import org.antlr.runtime.tree.RewriteRuleTokenStream;
import org.antlr.runtime.tree.TreeAdaptor;
import org.stringtemplate.v4.misc.ErrorManager;
import org.stringtemplate.v4.misc.ErrorType;

/** Build an AST from a single StringTemplate template */
public class STParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IF", "ELSE", "ELSEIF", "ENDIF", "SUPER", "SEMI", "BANG", "ELLIPSIS", "EQUALS", "COLON", "LPAREN", "RPAREN", "LBRACK", "RBRACK", "COMMA", "DOT", "LCURLY", "RCURLY", "TEXT", "LDELIM", "RDELIM", "ID", "STRING", "WS", "PIPE", "OR", "AND", "INDENT", "NEWLINE", "AT", "END", "TRUE", "FALSE", "COMMENT", "EXPR", "OPTIONS", "PROP", "PROP_IND", "INCLUDE", "INCLUDE_IND", "EXEC_FUNC", "INCLUDE_SUPER", "INCLUDE_SUPER_REGION", "INCLUDE_REGION", "TO_STR", "LIST", "MAP", "ZIP", "SUBTEMPLATE", "ARGS", "ELEMENTS", "REGION", "NULL", "INDENTED_EXPR"
    };
    public static final int EOF=-1;
    public static final int RBRACK=17;
    public static final int LBRACK=16;
    public static final int ELSE=5;
    public static final int ELLIPSIS=11;
    public static final int LCURLY=20;
    public static final int BANG=10;
    public static final int EQUALS=12;
    public static final int TEXT=22;
    public static final int ID=25;
    public static final int SEMI=9;
    public static final int LPAREN=14;
    public static final int IF=4;
    public static final int ELSEIF=6;
    public static final int COLON=13;
    public static final int RPAREN=15;
    public static final int WS=27;
    public static final int COMMA=18;
    public static final int RCURLY=21;
    public static final int ENDIF=7;
    public static final int RDELIM=24;
    public static final int SUPER=8;
    public static final int DOT=19;
    public static final int LDELIM=23;
    public static final int STRING=26;
    public static final int PIPE=28;
    public static final int OR=29;
    public static final int AND=30;
    public static final int INDENT=31;
    public static final int NEWLINE=32;
    public static final int AT=33;
    public static final int END=34;
    public static final int TRUE=35;
    public static final int FALSE=36;
    public static final int COMMENT=37;
    public static final int EXPR=38;
    public static final int OPTIONS=39;
    public static final int PROP=40;
    public static final int PROP_IND=41;
    public static final int INCLUDE=42;
    public static final int INCLUDE_IND=43;
    public static final int EXEC_FUNC=44;
    public static final int INCLUDE_SUPER=45;
    public static final int INCLUDE_SUPER_REGION=46;
    public static final int INCLUDE_REGION=47;
    public static final int TO_STR=48;
    public static final int LIST=49;
    public static final int MAP=50;
    public static final int ZIP=51;
    public static final int SUBTEMPLATE=52;
    public static final int ARGS=53;
    public static final int ELEMENTS=54;
    public static final int REGION=55;
    public static final int NULL=56;
    public static final int INDENTED_EXPR=57;

    // delegates
    // delegators


        public STParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public STParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return STParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g"; }


    ErrorManager errMgr;
    Token templateToken;
    public STParser(TokenStream input, ErrorManager errMgr, Token templateToken) {
    	this(input);
    	this.errMgr = errMgr;
    	this.templateToken = templateToken;
    }
    protected Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow)
    	throws RecognitionException
    {
    	throw new MismatchedTokenException(ttype, input);
    }


    public static class templateAndEOF_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "templateAndEOF"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:70:1: templateAndEOF : template EOF -> ( template )? ;
    public final STParser.templateAndEOF_return templateAndEOF() throws RecognitionException {
        STParser.templateAndEOF_return retval = new STParser.templateAndEOF_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonToken EOF2=null;
        STParser.template_return template1 = null;


        CommonTree EOF2_tree=null;
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleSubtreeStream stream_template=new RewriteRuleSubtreeStream(adaptor,"rule template");
        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:70:16: ( template EOF -> ( template )? )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:70:18: template EOF
            {
            pushFollow(FOLLOW_template_in_templateAndEOF133);
            template1=template();

            state._fsp--;

            stream_template.add(template1.getTree());
            EOF2=(CommonToken)match(input,EOF,FOLLOW_EOF_in_templateAndEOF135);  
            stream_EOF.add(EOF2);



            // AST REWRITE
            // elements: template
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 70:31: -> ( template )?
            {
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:70:34: ( template )?
                if ( stream_template.hasNext() ) {
                    adaptor.addChild(root_0, stream_template.nextTree());

                }
                stream_template.reset();

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

           catch (RecognitionException re) { throw re; }
        finally {
        }
        return retval;
    }
    // $ANTLR end "templateAndEOF"

    public static class template_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "template"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:72:1: template : ( element )* ;
    public final STParser.template_return template() throws RecognitionException {
        STParser.template_return retval = new STParser.template_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        STParser.element_return element3 = null;



        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:72:10: ( ( element )* )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:72:12: ( element )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:72:12: ( element )*
            loop1:
            do {
                int alt1=2;
                switch ( input.LA(1) ) {
                case INDENT:
                    {
                    int LA1_2 = input.LA(2);

                    if ( (LA1_2==LDELIM) ) {
                        int LA1_5 = input.LA(3);

                        if ( (LA1_5==IF||LA1_5==SUPER||LA1_5==LPAREN||LA1_5==LBRACK||LA1_5==LCURLY||(LA1_5>=ID && LA1_5<=STRING)||LA1_5==AT||(LA1_5>=TRUE && LA1_5<=FALSE)) ) {
                            alt1=1;
                        }


                    }
                    else if ( (LA1_2==TEXT||LA1_2==NEWLINE||LA1_2==COMMENT) ) {
                        alt1=1;
                    }


                    }
                    break;
                case LDELIM:
                    {
                    int LA1_3 = input.LA(2);

                    if ( (LA1_3==IF||LA1_3==SUPER||LA1_3==LPAREN||LA1_3==LBRACK||LA1_3==LCURLY||(LA1_3>=ID && LA1_3<=STRING)||LA1_3==AT||(LA1_3>=TRUE && LA1_3<=FALSE)) ) {
                        alt1=1;
                    }


                    }
                    break;
                case TEXT:
                case NEWLINE:
                case COMMENT:
                    {
                    alt1=1;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:72:12: element
            	    {
            	    pushFollow(FOLLOW_element_in_template149);
            	    element3=element();

            	    state._fsp--;

            	    adaptor.addChild(root_0, element3.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

           catch (RecognitionException re) { throw re; }
        finally {
        }
        return retval;
    }
    // $ANTLR end "template"

    public static class element_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "element"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:74:1: element : ({...}? ( INDENT )? COMMENT NEWLINE -> | INDENT singleElement -> ^( INDENTED_EXPR INDENT ( singleElement )? ) | singleElement | compoundElement );
    public final STParser.element_return element() throws RecognitionException {
        STParser.element_return retval = new STParser.element_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonToken INDENT4=null;
        CommonToken COMMENT5=null;
        CommonToken NEWLINE6=null;
        CommonToken INDENT7=null;
        STParser.singleElement_return singleElement8 = null;

        STParser.singleElement_return singleElement9 = null;

        STParser.compoundElement_return compoundElement10 = null;


        CommonTree INDENT4_tree=null;
        CommonTree COMMENT5_tree=null;
        CommonTree NEWLINE6_tree=null;
        CommonTree INDENT7_tree=null;
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_COMMENT=new RewriteRuleTokenStream(adaptor,"token COMMENT");
        RewriteRuleTokenStream stream_INDENT=new RewriteRuleTokenStream(adaptor,"token INDENT");
        RewriteRuleSubtreeStream stream_singleElement=new RewriteRuleSubtreeStream(adaptor,"rule singleElement");
        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:75:2: ({...}? ( INDENT )? COMMENT NEWLINE -> | INDENT singleElement -> ^( INDENTED_EXPR INDENT ( singleElement )? ) | singleElement | compoundElement )
            int alt3=4;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:75:4: {...}? ( INDENT )? COMMENT NEWLINE
                    {
                    if ( !((input.LT(1).getCharPositionInLine()==0)) ) {
                        throw new FailedPredicateException(input, "element", "input.LT(1).getCharPositionInLine()==0");
                    }
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:75:46: ( INDENT )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==INDENT) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:75:46: INDENT
                            {
                            INDENT4=(CommonToken)match(input,INDENT,FOLLOW_INDENT_in_element162);  
                            stream_INDENT.add(INDENT4);


                            }
                            break;

                    }

                    COMMENT5=(CommonToken)match(input,COMMENT,FOLLOW_COMMENT_in_element165);  
                    stream_COMMENT.add(COMMENT5);

                    NEWLINE6=(CommonToken)match(input,NEWLINE,FOLLOW_NEWLINE_in_element167);  
                    stream_NEWLINE.add(NEWLINE6);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 75:70: ->
                    {
                        root_0 = null;
                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:76:4: INDENT singleElement
                    {
                    INDENT7=(CommonToken)match(input,INDENT,FOLLOW_INDENT_in_element175);  
                    stream_INDENT.add(INDENT7);

                    pushFollow(FOLLOW_singleElement_in_element177);
                    singleElement8=singleElement();

                    state._fsp--;

                    stream_singleElement.add(singleElement8.getTree());


                    // AST REWRITE
                    // elements: INDENT, singleElement
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 76:25: -> ^( INDENTED_EXPR INDENT ( singleElement )? )
                    {
                        // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:76:28: ^( INDENTED_EXPR INDENT ( singleElement )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INDENTED_EXPR, "INDENTED_EXPR"), root_1);

                        adaptor.addChild(root_1, stream_INDENT.nextNode());
                        // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:76:51: ( singleElement )?
                        if ( stream_singleElement.hasNext() ) {
                            adaptor.addChild(root_1, stream_singleElement.nextTree());

                        }
                        stream_singleElement.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:77:4: singleElement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_singleElement_in_element194);
                    singleElement9=singleElement();

                    state._fsp--;

                    adaptor.addChild(root_0, singleElement9.getTree());

                    }
                    break;
                case 4 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:78:4: compoundElement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_compoundElement_in_element199);
                    compoundElement10=compoundElement();

                    state._fsp--;

                    adaptor.addChild(root_0, compoundElement10.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

           catch (RecognitionException re) { throw re; }
        finally {
        }
        return retval;
    }
    // $ANTLR end "element"

    public static class singleElement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "singleElement"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:81:1: singleElement : ( exprTag | TEXT | NEWLINE | COMMENT );
    public final STParser.singleElement_return singleElement() throws RecognitionException {
        STParser.singleElement_return retval = new STParser.singleElement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonToken TEXT12=null;
        CommonToken NEWLINE13=null;
        CommonToken COMMENT14=null;
        STParser.exprTag_return exprTag11 = null;


        CommonTree TEXT12_tree=null;
        CommonTree NEWLINE13_tree=null;
        CommonTree COMMENT14_tree=null;

        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:82:2: ( exprTag | TEXT | NEWLINE | COMMENT )
            int alt4=4;
            switch ( input.LA(1) ) {
            case LDELIM:
                {
                alt4=1;
                }
                break;
            case TEXT:
                {
                alt4=2;
                }
                break;
            case NEWLINE:
                {
                alt4=3;
                }
                break;
            case COMMENT:
                {
                alt4=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:82:4: exprTag
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_exprTag_in_singleElement210);
                    exprTag11=exprTag();

                    state._fsp--;

                    adaptor.addChild(root_0, exprTag11.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:83:4: TEXT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    TEXT12=(CommonToken)match(input,TEXT,FOLLOW_TEXT_in_singleElement215); 
                    TEXT12_tree = (CommonTree)adaptor.create(TEXT12);
                    adaptor.addChild(root_0, TEXT12_tree);


                    }
                    break;
                case 3 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:84:4: NEWLINE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    NEWLINE13=(CommonToken)match(input,NEWLINE,FOLLOW_NEWLINE_in_singleElement220); 
                    NEWLINE13_tree = (CommonTree)adaptor.create(NEWLINE13);
                    adaptor.addChild(root_0, NEWLINE13_tree);


                    }
                    break;
                case 4 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:85:4: COMMENT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    COMMENT14=(CommonToken)match(input,COMMENT,FOLLOW_COMMENT_in_singleElement225); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

           catch (RecognitionException re) { throw re; }
        finally {
        }
        return retval;
    }
    // $ANTLR end "singleElement"

    public static class compoundElement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "compoundElement"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:88:1: compoundElement : ( ifstat | region );
    public final STParser.compoundElement_return compoundElement() throws RecognitionException {
        STParser.compoundElement_return retval = new STParser.compoundElement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        STParser.ifstat_return ifstat15 = null;

        STParser.region_return region16 = null;



        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:89:2: ( ifstat | region )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==INDENT) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==LDELIM) ) {
                    int LA5_2 = input.LA(3);

                    if ( (LA5_2==IF) ) {
                        alt5=1;
                    }
                    else if ( (LA5_2==AT) ) {
                        alt5=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA5_0==LDELIM) ) {
                int LA5_2 = input.LA(2);

                if ( (LA5_2==IF) ) {
                    alt5=1;
                }
                else if ( (LA5_2==AT) ) {
                    alt5=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:89:4: ifstat
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_ifstat_in_compoundElement238);
                    ifstat15=ifstat();

                    state._fsp--;

                    adaptor.addChild(root_0, ifstat15.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:90:4: region
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_region_in_compoundElement243);
                    region16=region();

                    state._fsp--;

                    adaptor.addChild(root_0, region16.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

           catch (RecognitionException re) { throw re; }
        finally {
        }
        return retval;
    }
    // $ANTLR end "compoundElement"

    public static class exprTag_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "exprTag"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:93:1: exprTag : LDELIM expr ( ';' exprOptions )? RDELIM -> ^( EXPR[$LDELIM,\"EXPR\"] expr ( exprOptions )? ) ;
    public final STParser.exprTag_return exprTag() throws RecognitionException {
        STParser.exprTag_return retval = new STParser.exprTag_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonToken LDELIM17=null;
        CommonToken char_literal19=null;
        CommonToken RDELIM21=null;
        STParser.expr_return expr18 = null;

        STParser.exprOptions_return exprOptions20 = null;


        CommonTree LDELIM17_tree=null;
        CommonTree char_literal19_tree=null;
        CommonTree RDELIM21_tree=null;
        RewriteRuleTokenStream stream_RDELIM=new RewriteRuleTokenStream(adaptor,"token RDELIM");
        RewriteRuleTokenStream stream_LDELIM=new RewriteRuleTokenStream(adaptor,"token LDELIM");
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleSubtreeStream stream_exprOptions=new RewriteRuleSubtreeStream(adaptor,"rule exprOptions");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:94:2: ( LDELIM expr ( ';' exprOptions )? RDELIM -> ^( EXPR[$LDELIM,\"EXPR\"] expr ( exprOptions )? ) )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:94:4: LDELIM expr ( ';' exprOptions )? RDELIM
            {
            LDELIM17=(CommonToken)match(input,LDELIM,FOLLOW_LDELIM_in_exprTag254);  
            stream_LDELIM.add(LDELIM17);

            pushFollow(FOLLOW_expr_in_exprTag256);
            expr18=expr();

            state._fsp--;

            stream_expr.add(expr18.getTree());
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:94:16: ( ';' exprOptions )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==SEMI) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:94:18: ';' exprOptions
                    {
                    char_literal19=(CommonToken)match(input,SEMI,FOLLOW_SEMI_in_exprTag260);  
                    stream_SEMI.add(char_literal19);

                    pushFollow(FOLLOW_exprOptions_in_exprTag262);
                    exprOptions20=exprOptions();

                    state._fsp--;

                    stream_exprOptions.add(exprOptions20.getTree());

                    }
                    break;

            }

            RDELIM21=(CommonToken)match(input,RDELIM,FOLLOW_RDELIM_in_exprTag267);  
            stream_RDELIM.add(RDELIM21);



            // AST REWRITE
            // elements: expr, exprOptions
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 95:3: -> ^( EXPR[$LDELIM,\"EXPR\"] expr ( exprOptions )? )
            {
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:95:6: ^( EXPR[$LDELIM,\"EXPR\"] expr ( exprOptions )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXPR, LDELIM17, "EXPR"), root_1);

                adaptor.addChild(root_1, stream_expr.nextTree());
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:95:34: ( exprOptions )?
                if ( stream_exprOptions.hasNext() ) {
                    adaptor.addChild(root_1, stream_exprOptions.nextTree());

                }
                stream_exprOptions.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

           catch (RecognitionException re) { throw re; }
        finally {
        }
        return retval;
    }
    // $ANTLR end "exprTag"

    public static class region_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "region"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:98:1: region : (i= INDENT )? x= LDELIM '@' ID RDELIM template ( INDENT )? LDELIM '@end' RDELIM ({...}? => NEWLINE )? -> {indent!=null}? ^( INDENTED_EXPR $i ^( REGION[$x] ID ( template )? ) ) -> ^( REGION[$x] ID ( template )? ) ;
    public final STParser.region_return region() throws RecognitionException {
        STParser.region_return retval = new STParser.region_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonToken i=null;
        CommonToken x=null;
        CommonToken char_literal22=null;
        CommonToken ID23=null;
        CommonToken RDELIM24=null;
        CommonToken INDENT26=null;
        CommonToken LDELIM27=null;
        CommonToken string_literal28=null;
        CommonToken RDELIM29=null;
        CommonToken NEWLINE30=null;
        STParser.template_return template25 = null;


        CommonTree i_tree=null;
        CommonTree x_tree=null;
        CommonTree char_literal22_tree=null;
        CommonTree ID23_tree=null;
        CommonTree RDELIM24_tree=null;
        CommonTree INDENT26_tree=null;
        CommonTree LDELIM27_tree=null;
        CommonTree string_literal28_tree=null;
        CommonTree RDELIM29_tree=null;
        CommonTree NEWLINE30_tree=null;
        RewriteRuleTokenStream stream_AT=new RewriteRuleTokenStream(adaptor,"token AT");
        RewriteRuleTokenStream stream_RDELIM=new RewriteRuleTokenStream(adaptor,"token RDELIM");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_END=new RewriteRuleTokenStream(adaptor,"token END");
        RewriteRuleTokenStream stream_LDELIM=new RewriteRuleTokenStream(adaptor,"token LDELIM");
        RewriteRuleTokenStream stream_INDENT=new RewriteRuleTokenStream(adaptor,"token INDENT");
        RewriteRuleSubtreeStream stream_template=new RewriteRuleSubtreeStream(adaptor,"rule template");
        Token indent=null;
        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:100:2: ( (i= INDENT )? x= LDELIM '@' ID RDELIM template ( INDENT )? LDELIM '@end' RDELIM ({...}? => NEWLINE )? -> {indent!=null}? ^( INDENTED_EXPR $i ^( REGION[$x] ID ( template )? ) ) -> ^( REGION[$x] ID ( template )? ) )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:100:4: (i= INDENT )? x= LDELIM '@' ID RDELIM template ( INDENT )? LDELIM '@end' RDELIM ({...}? => NEWLINE )?
            {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:100:5: (i= INDENT )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==INDENT) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:100:5: i= INDENT
                    {
                    i=(CommonToken)match(input,INDENT,FOLLOW_INDENT_in_region299);  
                    stream_INDENT.add(i);


                    }
                    break;

            }

            x=(CommonToken)match(input,LDELIM,FOLLOW_LDELIM_in_region304);  
            stream_LDELIM.add(x);

            char_literal22=(CommonToken)match(input,AT,FOLLOW_AT_in_region306);  
            stream_AT.add(char_literal22);

            ID23=(CommonToken)match(input,ID,FOLLOW_ID_in_region308);  
            stream_ID.add(ID23);

            RDELIM24=(CommonToken)match(input,RDELIM,FOLLOW_RDELIM_in_region310);  
            stream_RDELIM.add(RDELIM24);

            if (input.LA(1)!=NEWLINE) indent=i;
            pushFollow(FOLLOW_template_in_region316);
            template25=template();

            state._fsp--;

            stream_template.add(template25.getTree());
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:102:3: ( INDENT )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==INDENT) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:102:3: INDENT
                    {
                    INDENT26=(CommonToken)match(input,INDENT,FOLLOW_INDENT_in_region320);  
                    stream_INDENT.add(INDENT26);


                    }
                    break;

            }

            LDELIM27=(CommonToken)match(input,LDELIM,FOLLOW_LDELIM_in_region323);  
            stream_LDELIM.add(LDELIM27);

            string_literal28=(CommonToken)match(input,END,FOLLOW_END_in_region325);  
            stream_END.add(string_literal28);

            RDELIM29=(CommonToken)match(input,RDELIM,FOLLOW_RDELIM_in_region327);  
            stream_RDELIM.add(RDELIM29);

            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:104:3: ({...}? => NEWLINE )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==NEWLINE) ) {
                int LA9_1 = input.LA(2);

                if ( ((((CommonToken)retval.start).getLine()!=input.LT(1).getLine())) ) {
                    alt9=1;
                }
            }
            switch (alt9) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:104:4: {...}? => NEWLINE
                    {
                    if ( !((((CommonToken)retval.start).getLine()!=input.LT(1).getLine())) ) {
                        throw new FailedPredicateException(input, "region", "$region.start.getLine()!=input.LT(1).getLine()");
                    }
                    NEWLINE30=(CommonToken)match(input,NEWLINE,FOLLOW_NEWLINE_in_region338);  
                    stream_NEWLINE.add(NEWLINE30);


                    }
                    break;

            }



            // AST REWRITE
            // elements: i, template, template, ID, ID
            // token labels: i
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 105:3: -> {indent!=null}? ^( INDENTED_EXPR $i ^( REGION[$x] ID ( template )? ) )
            if (indent!=null) {
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:106:6: ^( INDENTED_EXPR $i ^( REGION[$x] ID ( template )? ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INDENTED_EXPR, "INDENTED_EXPR"), root_1);

                adaptor.addChild(root_1, stream_i.nextNode());
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:106:25: ^( REGION[$x] ID ( template )? )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(REGION, x), root_2);

                adaptor.addChild(root_2, stream_ID.nextNode());
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:106:41: ( template )?
                if ( stream_template.hasNext() ) {
                    adaptor.addChild(root_2, stream_template.nextTree());

                }
                stream_template.reset();

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 107:3: -> ^( REGION[$x] ID ( template )? )
            {
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:107:25: ^( REGION[$x] ID ( template )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(REGION, x), root_1);

                adaptor.addChild(root_1, stream_ID.nextNode());
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:107:41: ( template )?
                if ( stream_template.hasNext() ) {
                    adaptor.addChild(root_1, stream_template.nextTree());

                }
                stream_template.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

           catch (RecognitionException re) { throw re; }
        finally {
        }
        return retval;
    }
    // $ANTLR end "region"

    public static class subtemplate_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "subtemplate"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:110:1: subtemplate : lc= '{' (ids+= ID ( ',' ids+= ID )* '|' )? template ( INDENT )? '}' -> ^( SUBTEMPLATE[$lc,\"SUBTEMPLATE\"] ( ^( ARGS $ids) )* ( template )? ) ;
    public final STParser.subtemplate_return subtemplate() throws RecognitionException {
        STParser.subtemplate_return retval = new STParser.subtemplate_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonToken lc=null;
        CommonToken char_literal31=null;
        CommonToken char_literal32=null;
        CommonToken INDENT34=null;
        CommonToken char_literal35=null;
        CommonToken ids=null;
        List list_ids=null;
        STParser.template_return template33 = null;


        CommonTree lc_tree=null;
        CommonTree char_literal31_tree=null;
        CommonTree char_literal32_tree=null;
        CommonTree INDENT34_tree=null;
        CommonTree char_literal35_tree=null;
        CommonTree ids_tree=null;
        RewriteRuleTokenStream stream_LCURLY=new RewriteRuleTokenStream(adaptor,"token LCURLY");
        RewriteRuleTokenStream stream_PIPE=new RewriteRuleTokenStream(adaptor,"token PIPE");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_INDENT=new RewriteRuleTokenStream(adaptor,"token INDENT");
        RewriteRuleTokenStream stream_RCURLY=new RewriteRuleTokenStream(adaptor,"token RCURLY");
        RewriteRuleSubtreeStream stream_template=new RewriteRuleSubtreeStream(adaptor,"rule template");
        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:111:2: (lc= '{' (ids+= ID ( ',' ids+= ID )* '|' )? template ( INDENT )? '}' -> ^( SUBTEMPLATE[$lc,\"SUBTEMPLATE\"] ( ^( ARGS $ids) )* ( template )? ) )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:111:4: lc= '{' (ids+= ID ( ',' ids+= ID )* '|' )? template ( INDENT )? '}'
            {
            lc=(CommonToken)match(input,LCURLY,FOLLOW_LCURLY_in_subtemplate414);  
            stream_LCURLY.add(lc);

            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:111:11: (ids+= ID ( ',' ids+= ID )* '|' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==ID) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:111:12: ids+= ID ( ',' ids+= ID )* '|'
                    {
                    ids=(CommonToken)match(input,ID,FOLLOW_ID_in_subtemplate420);  
                    stream_ID.add(ids);

                    if (list_ids==null) list_ids=new ArrayList();
                    list_ids.add(ids);

                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:111:21: ( ',' ids+= ID )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==COMMA) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:111:23: ',' ids+= ID
                    	    {
                    	    char_literal31=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_subtemplate424);  
                    	    stream_COMMA.add(char_literal31);

                    	    ids=(CommonToken)match(input,ID,FOLLOW_ID_in_subtemplate429);  
                    	    stream_ID.add(ids);

                    	    if (list_ids==null) list_ids=new ArrayList();
                    	    list_ids.add(ids);


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    char_literal32=(CommonToken)match(input,PIPE,FOLLOW_PIPE_in_subtemplate434);  
                    stream_PIPE.add(char_literal32);


                    }
                    break;

            }

            pushFollow(FOLLOW_template_in_subtemplate439);
            template33=template();

            state._fsp--;

            stream_template.add(template33.getTree());
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:111:55: ( INDENT )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==INDENT) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:111:55: INDENT
                    {
                    INDENT34=(CommonToken)match(input,INDENT,FOLLOW_INDENT_in_subtemplate441);  
                    stream_INDENT.add(INDENT34);


                    }
                    break;

            }

            char_literal35=(CommonToken)match(input,RCURLY,FOLLOW_RCURLY_in_subtemplate444);  
            stream_RCURLY.add(char_literal35);



            // AST REWRITE
            // elements: template, ids
            // token labels: 
            // rule labels: retval
            // token list labels: ids
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_ids=new RewriteRuleTokenStream(adaptor,"token ids", list_ids);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 113:3: -> ^( SUBTEMPLATE[$lc,\"SUBTEMPLATE\"] ( ^( ARGS $ids) )* ( template )? )
            {
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:113:6: ^( SUBTEMPLATE[$lc,\"SUBTEMPLATE\"] ( ^( ARGS $ids) )* ( template )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SUBTEMPLATE, lc, "SUBTEMPLATE"), root_1);

                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:113:39: ( ^( ARGS $ids) )*
                while ( stream_ids.hasNext() ) {
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:113:39: ^( ARGS $ids)
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARGS, "ARGS"), root_2);

                    adaptor.addChild(root_2, stream_ids.nextNode());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_ids.reset();
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:113:53: ( template )?
                if ( stream_template.hasNext() ) {
                    adaptor.addChild(root_1, stream_template.nextTree());

                }
                stream_template.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

           catch (RecognitionException re) { throw re; }
        finally {
        }
        return retval;
    }
    // $ANTLR end "subtemplate"

    public static class ifstat_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ifstat"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:116:1: ifstat : (i= INDENT )? LDELIM 'if' '(' c1= conditional ')' RDELIM t1= template ( ( INDENT )? LDELIM 'elseif' '(' c2+= conditional ')' RDELIM t2+= template )* ( ( INDENT )? LDELIM 'else' RDELIM t3= template )? ( INDENT )? endif= LDELIM 'endif' RDELIM ({...}? => NEWLINE )? -> {indent!=null}? ^( INDENTED_EXPR $i ^( 'if' $c1 ( $t1)? ( ^( 'elseif' $c2 $t2) )* ( ^( 'else' ( $t3)? ) )? ) ) -> ^( 'if' $c1 ( $t1)? ( ^( 'elseif' $c2 $t2) )* ( ^( 'else' ( $t3)? ) )? ) ;
    public final STParser.ifstat_return ifstat() throws RecognitionException {
        STParser.ifstat_return retval = new STParser.ifstat_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonToken i=null;
        CommonToken endif=null;
        CommonToken LDELIM36=null;
        CommonToken string_literal37=null;
        CommonToken char_literal38=null;
        CommonToken char_literal39=null;
        CommonToken RDELIM40=null;
        CommonToken INDENT41=null;
        CommonToken LDELIM42=null;
        CommonToken string_literal43=null;
        CommonToken char_literal44=null;
        CommonToken char_literal45=null;
        CommonToken RDELIM46=null;
        CommonToken INDENT47=null;
        CommonToken LDELIM48=null;
        CommonToken string_literal49=null;
        CommonToken RDELIM50=null;
        CommonToken INDENT51=null;
        CommonToken string_literal52=null;
        CommonToken RDELIM53=null;
        CommonToken NEWLINE54=null;
        List list_c2=null;
        List list_t2=null;
        STParser.conditional_return c1 = null;

        STParser.template_return t1 = null;

        STParser.template_return t3 = null;

        RuleReturnScope c2 = null;
        RuleReturnScope t2 = null;
        CommonTree i_tree=null;
        CommonTree endif_tree=null;
        CommonTree LDELIM36_tree=null;
        CommonTree string_literal37_tree=null;
        CommonTree char_literal38_tree=null;
        CommonTree char_literal39_tree=null;
        CommonTree RDELIM40_tree=null;
        CommonTree INDENT41_tree=null;
        CommonTree LDELIM42_tree=null;
        CommonTree string_literal43_tree=null;
        CommonTree char_literal44_tree=null;
        CommonTree char_literal45_tree=null;
        CommonTree RDELIM46_tree=null;
        CommonTree INDENT47_tree=null;
        CommonTree LDELIM48_tree=null;
        CommonTree string_literal49_tree=null;
        CommonTree RDELIM50_tree=null;
        CommonTree INDENT51_tree=null;
        CommonTree string_literal52_tree=null;
        CommonTree RDELIM53_tree=null;
        CommonTree NEWLINE54_tree=null;
        RewriteRuleTokenStream stream_ENDIF=new RewriteRuleTokenStream(adaptor,"token ENDIF");
        RewriteRuleTokenStream stream_RDELIM=new RewriteRuleTokenStream(adaptor,"token RDELIM");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_LDELIM=new RewriteRuleTokenStream(adaptor,"token LDELIM");
        RewriteRuleTokenStream stream_INDENT=new RewriteRuleTokenStream(adaptor,"token INDENT");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleTokenStream stream_IF=new RewriteRuleTokenStream(adaptor,"token IF");
        RewriteRuleTokenStream stream_ELSE=new RewriteRuleTokenStream(adaptor,"token ELSE");
        RewriteRuleTokenStream stream_ELSEIF=new RewriteRuleTokenStream(adaptor,"token ELSEIF");
        RewriteRuleSubtreeStream stream_template=new RewriteRuleSubtreeStream(adaptor,"rule template");
        RewriteRuleSubtreeStream stream_conditional=new RewriteRuleSubtreeStream(adaptor,"rule conditional");
        Token indent=null;
        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:118:2: ( (i= INDENT )? LDELIM 'if' '(' c1= conditional ')' RDELIM t1= template ( ( INDENT )? LDELIM 'elseif' '(' c2+= conditional ')' RDELIM t2+= template )* ( ( INDENT )? LDELIM 'else' RDELIM t3= template )? ( INDENT )? endif= LDELIM 'endif' RDELIM ({...}? => NEWLINE )? -> {indent!=null}? ^( INDENTED_EXPR $i ^( 'if' $c1 ( $t1)? ( ^( 'elseif' $c2 $t2) )* ( ^( 'else' ( $t3)? ) )? ) ) -> ^( 'if' $c1 ( $t1)? ( ^( 'elseif' $c2 $t2) )* ( ^( 'else' ( $t3)? ) )? ) )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:118:4: (i= INDENT )? LDELIM 'if' '(' c1= conditional ')' RDELIM t1= template ( ( INDENT )? LDELIM 'elseif' '(' c2+= conditional ')' RDELIM t2+= template )* ( ( INDENT )? LDELIM 'else' RDELIM t3= template )? ( INDENT )? endif= LDELIM 'endif' RDELIM ({...}? => NEWLINE )?
            {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:118:5: (i= INDENT )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==INDENT) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:118:5: i= INDENT
                    {
                    i=(CommonToken)match(input,INDENT,FOLLOW_INDENT_in_ifstat485);  
                    stream_INDENT.add(i);


                    }
                    break;

            }

            LDELIM36=(CommonToken)match(input,LDELIM,FOLLOW_LDELIM_in_ifstat488);  
            stream_LDELIM.add(LDELIM36);

            string_literal37=(CommonToken)match(input,IF,FOLLOW_IF_in_ifstat490);  
            stream_IF.add(string_literal37);

            char_literal38=(CommonToken)match(input,LPAREN,FOLLOW_LPAREN_in_ifstat492);  
            stream_LPAREN.add(char_literal38);

            pushFollow(FOLLOW_conditional_in_ifstat496);
            c1=conditional();

            state._fsp--;

            stream_conditional.add(c1.getTree());
            char_literal39=(CommonToken)match(input,RPAREN,FOLLOW_RPAREN_in_ifstat498);  
            stream_RPAREN.add(char_literal39);

            RDELIM40=(CommonToken)match(input,RDELIM,FOLLOW_RDELIM_in_ifstat500);  
            stream_RDELIM.add(RDELIM40);

            if (input.LA(1)!=NEWLINE) indent=i;
            pushFollow(FOLLOW_template_in_ifstat509);
            t1=template();

            state._fsp--;

            stream_template.add(t1.getTree());
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:120:4: ( ( INDENT )? LDELIM 'elseif' '(' c2+= conditional ')' RDELIM t2+= template )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==INDENT) ) {
                    int LA15_1 = input.LA(2);

                    if ( (LA15_1==LDELIM) ) {
                        int LA15_2 = input.LA(3);

                        if ( (LA15_2==ELSEIF) ) {
                            alt15=1;
                        }


                    }


                }
                else if ( (LA15_0==LDELIM) ) {
                    int LA15_2 = input.LA(2);

                    if ( (LA15_2==ELSEIF) ) {
                        alt15=1;
                    }


                }


                switch (alt15) {
            	case 1 :
            	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:120:6: ( INDENT )? LDELIM 'elseif' '(' c2+= conditional ')' RDELIM t2+= template
            	    {
            	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:120:6: ( INDENT )?
            	    int alt14=2;
            	    int LA14_0 = input.LA(1);

            	    if ( (LA14_0==INDENT) ) {
            	        alt14=1;
            	    }
            	    switch (alt14) {
            	        case 1 :
            	            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:120:6: INDENT
            	            {
            	            INDENT41=(CommonToken)match(input,INDENT,FOLLOW_INDENT_in_ifstat516);  
            	            stream_INDENT.add(INDENT41);


            	            }
            	            break;

            	    }

            	    LDELIM42=(CommonToken)match(input,LDELIM,FOLLOW_LDELIM_in_ifstat519);  
            	    stream_LDELIM.add(LDELIM42);

            	    string_literal43=(CommonToken)match(input,ELSEIF,FOLLOW_ELSEIF_in_ifstat521);  
            	    stream_ELSEIF.add(string_literal43);

            	    char_literal44=(CommonToken)match(input,LPAREN,FOLLOW_LPAREN_in_ifstat523);  
            	    stream_LPAREN.add(char_literal44);

            	    pushFollow(FOLLOW_conditional_in_ifstat527);
            	    c2=conditional();

            	    state._fsp--;

            	    stream_conditional.add(c2.getTree());
            	    if (list_c2==null) list_c2=new ArrayList();
            	    list_c2.add(c2.getTree());

            	    char_literal45=(CommonToken)match(input,RPAREN,FOLLOW_RPAREN_in_ifstat529);  
            	    stream_RPAREN.add(char_literal45);

            	    RDELIM46=(CommonToken)match(input,RDELIM,FOLLOW_RDELIM_in_ifstat531);  
            	    stream_RDELIM.add(RDELIM46);

            	    pushFollow(FOLLOW_template_in_ifstat535);
            	    t2=template();

            	    state._fsp--;

            	    stream_template.add(t2.getTree());
            	    if (list_t2==null) list_t2=new ArrayList();
            	    list_t2.add(t2.getTree());


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:121:4: ( ( INDENT )? LDELIM 'else' RDELIM t3= template )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==INDENT) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==LDELIM) ) {
                    int LA17_2 = input.LA(3);

                    if ( (LA17_2==ELSE) ) {
                        alt17=1;
                    }
                }
            }
            else if ( (LA17_0==LDELIM) ) {
                int LA17_2 = input.LA(2);

                if ( (LA17_2==ELSE) ) {
                    alt17=1;
                }
            }
            switch (alt17) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:121:6: ( INDENT )? LDELIM 'else' RDELIM t3= template
                    {
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:121:6: ( INDENT )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==INDENT) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:121:6: INDENT
                            {
                            INDENT47=(CommonToken)match(input,INDENT,FOLLOW_INDENT_in_ifstat545);  
                            stream_INDENT.add(INDENT47);


                            }
                            break;

                    }

                    LDELIM48=(CommonToken)match(input,LDELIM,FOLLOW_LDELIM_in_ifstat548);  
                    stream_LDELIM.add(LDELIM48);

                    string_literal49=(CommonToken)match(input,ELSE,FOLLOW_ELSE_in_ifstat550);  
                    stream_ELSE.add(string_literal49);

                    RDELIM50=(CommonToken)match(input,RDELIM,FOLLOW_RDELIM_in_ifstat552);  
                    stream_RDELIM.add(RDELIM50);

                    pushFollow(FOLLOW_template_in_ifstat556);
                    t3=template();

                    state._fsp--;

                    stream_template.add(t3.getTree());

                    }
                    break;

            }

            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:122:4: ( INDENT )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==INDENT) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:122:4: INDENT
                    {
                    INDENT51=(CommonToken)match(input,INDENT,FOLLOW_INDENT_in_ifstat564);  
                    stream_INDENT.add(INDENT51);


                    }
                    break;

            }

            endif=(CommonToken)match(input,LDELIM,FOLLOW_LDELIM_in_ifstat570);  
            stream_LDELIM.add(endif);

            string_literal52=(CommonToken)match(input,ENDIF,FOLLOW_ENDIF_in_ifstat572);  
            stream_ENDIF.add(string_literal52);

            RDELIM53=(CommonToken)match(input,RDELIM,FOLLOW_RDELIM_in_ifstat576);  
            stream_RDELIM.add(RDELIM53);

            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:125:3: ({...}? => NEWLINE )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==NEWLINE) ) {
                int LA19_1 = input.LA(2);

                if ( ((((CommonToken)retval.start).getLine()!=input.LT(1).getLine())) ) {
                    alt19=1;
                }
            }
            switch (alt19) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:125:4: {...}? => NEWLINE
                    {
                    if ( !((((CommonToken)retval.start).getLine()!=input.LT(1).getLine())) ) {
                        throw new FailedPredicateException(input, "ifstat", "$ifstat.start.getLine()!=input.LT(1).getLine()");
                    }
                    NEWLINE54=(CommonToken)match(input,NEWLINE,FOLLOW_NEWLINE_in_ifstat587);  
                    stream_NEWLINE.add(NEWLINE54);


                    }
                    break;

            }



            // AST REWRITE
            // elements: ELSEIF, c2, t2, c2, t2, t1, c1, t1, ELSE, ELSEIF, t3, t3, i, IF, ELSE, IF, c1
            // token labels: i
            // rule labels: t3, retval, t1, c1
            // token list labels: 
            // rule list labels: t2, c2
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
            RewriteRuleSubtreeStream stream_t3=new RewriteRuleSubtreeStream(adaptor,"rule t3",t3!=null?t3.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_t1=new RewriteRuleSubtreeStream(adaptor,"rule t1",t1!=null?t1.tree:null);
            RewriteRuleSubtreeStream stream_c1=new RewriteRuleSubtreeStream(adaptor,"rule c1",c1!=null?c1.tree:null);
            RewriteRuleSubtreeStream stream_t2=new RewriteRuleSubtreeStream(adaptor,"token t2",list_t2);
            RewriteRuleSubtreeStream stream_c2=new RewriteRuleSubtreeStream(adaptor,"token c2",list_c2);
            root_0 = (CommonTree)adaptor.nil();
            // 126:3: -> {indent!=null}? ^( INDENTED_EXPR $i ^( 'if' $c1 ( $t1)? ( ^( 'elseif' $c2 $t2) )* ( ^( 'else' ( $t3)? ) )? ) )
            if (indent!=null) {
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:127:6: ^( INDENTED_EXPR $i ^( 'if' $c1 ( $t1)? ( ^( 'elseif' $c2 $t2) )* ( ^( 'else' ( $t3)? ) )? ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INDENTED_EXPR, "INDENTED_EXPR"), root_1);

                adaptor.addChild(root_1, stream_i.nextNode());
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:127:25: ^( 'if' $c1 ( $t1)? ( ^( 'elseif' $c2 $t2) )* ( ^( 'else' ( $t3)? ) )? )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(stream_IF.nextNode(), root_2);

                adaptor.addChild(root_2, stream_c1.nextTree());
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:127:36: ( $t1)?
                if ( stream_t1.hasNext() ) {
                    adaptor.addChild(root_2, stream_t1.nextTree());

                }
                stream_t1.reset();
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:127:41: ( ^( 'elseif' $c2 $t2) )*
                while ( stream_ELSEIF.hasNext()||stream_t2.hasNext()||stream_c2.hasNext() ) {
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:127:41: ^( 'elseif' $c2 $t2)
                    {
                    CommonTree root_3 = (CommonTree)adaptor.nil();
                    root_3 = (CommonTree)adaptor.becomeRoot(stream_ELSEIF.nextNode(), root_3);

                    adaptor.addChild(root_3, stream_c2.nextTree());
                    adaptor.addChild(root_3, stream_t2.nextTree());

                    adaptor.addChild(root_2, root_3);
                    }

                }
                stream_ELSEIF.reset();
                stream_t2.reset();
                stream_c2.reset();
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:127:62: ( ^( 'else' ( $t3)? ) )?
                if ( stream_ELSE.hasNext()||stream_t3.hasNext() ) {
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:127:62: ^( 'else' ( $t3)? )
                    {
                    CommonTree root_3 = (CommonTree)adaptor.nil();
                    root_3 = (CommonTree)adaptor.becomeRoot(stream_ELSE.nextNode(), root_3);

                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:127:71: ( $t3)?
                    if ( stream_t3.hasNext() ) {
                        adaptor.addChild(root_3, stream_t3.nextTree());

                    }
                    stream_t3.reset();

                    adaptor.addChild(root_2, root_3);
                    }

                }
                stream_ELSE.reset();
                stream_t3.reset();

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 128:3: -> ^( 'if' $c1 ( $t1)? ( ^( 'elseif' $c2 $t2) )* ( ^( 'else' ( $t3)? ) )? )
            {
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:128:25: ^( 'if' $c1 ( $t1)? ( ^( 'elseif' $c2 $t2) )* ( ^( 'else' ( $t3)? ) )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_IF.nextNode(), root_1);

                adaptor.addChild(root_1, stream_c1.nextTree());
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:128:36: ( $t1)?
                if ( stream_t1.hasNext() ) {
                    adaptor.addChild(root_1, stream_t1.nextTree());

                }
                stream_t1.reset();
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:128:41: ( ^( 'elseif' $c2 $t2) )*
                while ( stream_ELSEIF.hasNext()||stream_c2.hasNext()||stream_t2.hasNext() ) {
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:128:41: ^( 'elseif' $c2 $t2)
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(stream_ELSEIF.nextNode(), root_2);

                    adaptor.addChild(root_2, stream_c2.nextTree());
                    adaptor.addChild(root_2, stream_t2.nextTree());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_ELSEIF.reset();
                stream_c2.reset();
                stream_t2.reset();
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:128:62: ( ^( 'else' ( $t3)? ) )?
                if ( stream_t3.hasNext()||stream_ELSE.hasNext() ) {
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:128:62: ^( 'else' ( $t3)? )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(stream_ELSE.nextNode(), root_2);

                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:128:71: ( $t3)?
                    if ( stream_t3.hasNext() ) {
                        adaptor.addChild(root_2, stream_t3.nextTree());

                    }
                    stream_t3.reset();

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_t3.reset();
                stream_ELSE.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

           catch (RecognitionException re) { throw re; }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ifstat"

    protected static class conditional_scope {
        boolean inside;
    }
    protected Stack conditional_stack = new Stack();

    public static class conditional_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "conditional"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:131:1: conditional : andConditional ( '||' andConditional )* ;
    public final STParser.conditional_return conditional() throws RecognitionException {
        conditional_stack.push(new conditional_scope());
        STParser.conditional_return retval = new STParser.conditional_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonToken string_literal56=null;
        STParser.andConditional_return andConditional55 = null;

        STParser.andConditional_return andConditional57 = null;


        CommonTree string_literal56_tree=null;

        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:135:2: ( andConditional ( '||' andConditional )* )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:135:4: andConditional ( '||' andConditional )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_andConditional_in_conditional707);
            andConditional55=andConditional();

            state._fsp--;

            adaptor.addChild(root_0, andConditional55.getTree());
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:135:19: ( '||' andConditional )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==OR) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:135:21: '||' andConditional
            	    {
            	    string_literal56=(CommonToken)match(input,OR,FOLLOW_OR_in_conditional711); 
            	    string_literal56_tree = (CommonTree)adaptor.create(string_literal56);
            	    root_0 = (CommonTree)adaptor.becomeRoot(string_literal56_tree, root_0);

            	    pushFollow(FOLLOW_andConditional_in_conditional714);
            	    andConditional57=andConditional();

            	    state._fsp--;

            	    adaptor.addChild(root_0, andConditional57.getTree());

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

           catch (RecognitionException re) { throw re; }
        finally {
            conditional_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "conditional"

    public static class andConditional_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "andConditional"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:138:1: andConditional : notConditional ( '&&' notConditional )* ;
    public final STParser.andConditional_return andConditional() throws RecognitionException {
        STParser.andConditional_return retval = new STParser.andConditional_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonToken string_literal59=null;
        STParser.notConditional_return notConditional58 = null;

        STParser.notConditional_return notConditional60 = null;


        CommonTree string_literal59_tree=null;

        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:138:16: ( notConditional ( '&&' notConditional )* )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:138:18: notConditional ( '&&' notConditional )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_notConditional_in_andConditional727);
            notConditional58=notConditional();

            state._fsp--;

            adaptor.addChild(root_0, notConditional58.getTree());
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:138:33: ( '&&' notConditional )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==AND) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:138:35: '&&' notConditional
            	    {
            	    string_literal59=(CommonToken)match(input,AND,FOLLOW_AND_in_andConditional731); 
            	    string_literal59_tree = (CommonTree)adaptor.create(string_literal59);
            	    root_0 = (CommonTree)adaptor.becomeRoot(string_literal59_tree, root_0);

            	    pushFollow(FOLLOW_notConditional_in_andConditional734);
            	    notConditional60=notConditional();

            	    state._fsp--;

            	    adaptor.addChild(root_0, notConditional60.getTree());

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

           catch (RecognitionException re) { throw re; }
        finally {
        }
        return retval;
    }
    // $ANTLR end "andConditional"

    public static class notConditional_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "notConditional"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:140:1: notConditional : ( '!' notConditional | memberExpr );
    public final STParser.notConditional_return notConditional() throws RecognitionException {
        STParser.notConditional_return retval = new STParser.notConditional_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonToken char_literal61=null;
        STParser.notConditional_return notConditional62 = null;

        STParser.memberExpr_return memberExpr63 = null;


        CommonTree char_literal61_tree=null;

        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:141:2: ( '!' notConditional | memberExpr )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==BANG) ) {
                alt22=1;
            }
            else if ( (LA22_0==SUPER||LA22_0==LBRACK||LA22_0==LCURLY||(LA22_0>=ID && LA22_0<=STRING)||LA22_0==AT||(LA22_0>=TRUE && LA22_0<=FALSE)) ) {
                alt22=2;
            }
            else if ( (LA22_0==LPAREN) && (((conditional_stack.size()==0)||(conditional_stack.size()>0)))) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:141:4: '!' notConditional
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal61=(CommonToken)match(input,BANG,FOLLOW_BANG_in_notConditional747); 
                    char_literal61_tree = (CommonTree)adaptor.create(char_literal61);
                    root_0 = (CommonTree)adaptor.becomeRoot(char_literal61_tree, root_0);

                    pushFollow(FOLLOW_notConditional_in_notConditional750);
                    notConditional62=notConditional();

                    state._fsp--;

                    adaptor.addChild(root_0, notConditional62.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:142:4: memberExpr
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_memberExpr_in_notConditional755);
                    memberExpr63=memberExpr();

                    state._fsp--;

                    adaptor.addChild(root_0, memberExpr63.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

           catch (RecognitionException re) { throw re; }
        finally {
        }
        return retval;
    }
    // $ANTLR end "notConditional"

    public static class notConditionalExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "notConditionalExpr"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:145:1: notConditionalExpr : ( ID -> ID ) (p= '.' prop= ID -> ^( PROP[$p,\"PROP\"] $notConditionalExpr $prop) | p= '.' '(' mapExpr ')' -> ^( PROP_IND[$p,\"PROP_IND\"] $notConditionalExpr mapExpr ) )* ;
    public final STParser.notConditionalExpr_return notConditionalExpr() throws RecognitionException {
        STParser.notConditionalExpr_return retval = new STParser.notConditionalExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonToken p=null;
        CommonToken prop=null;
        CommonToken ID64=null;
        CommonToken char_literal65=null;
        CommonToken char_literal67=null;
        STParser.mapExpr_return mapExpr66 = null;


        CommonTree p_tree=null;
        CommonTree prop_tree=null;
        CommonTree ID64_tree=null;
        CommonTree char_literal65_tree=null;
        CommonTree char_literal67_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_mapExpr=new RewriteRuleSubtreeStream(adaptor,"rule mapExpr");
        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:146:2: ( ( ID -> ID ) (p= '.' prop= ID -> ^( PROP[$p,\"PROP\"] $notConditionalExpr $prop) | p= '.' '(' mapExpr ')' -> ^( PROP_IND[$p,\"PROP_IND\"] $notConditionalExpr mapExpr ) )* )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:146:4: ( ID -> ID ) (p= '.' prop= ID -> ^( PROP[$p,\"PROP\"] $notConditionalExpr $prop) | p= '.' '(' mapExpr ')' -> ^( PROP_IND[$p,\"PROP_IND\"] $notConditionalExpr mapExpr ) )*
            {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:146:4: ( ID -> ID )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:146:5: ID
            {
            ID64=(CommonToken)match(input,ID,FOLLOW_ID_in_notConditionalExpr767);  
            stream_ID.add(ID64);



            // AST REWRITE
            // elements: ID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 146:7: -> ID
            {
                adaptor.addChild(root_0, stream_ID.nextNode());

            }

            retval.tree = root_0;
            }

            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:147:3: (p= '.' prop= ID -> ^( PROP[$p,\"PROP\"] $notConditionalExpr $prop) | p= '.' '(' mapExpr ')' -> ^( PROP_IND[$p,\"PROP_IND\"] $notConditionalExpr mapExpr ) )*
            loop23:
            do {
                int alt23=3;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==DOT) ) {
                    int LA23_2 = input.LA(2);

                    if ( (LA23_2==ID) ) {
                        alt23=1;
                    }
                    else if ( (LA23_2==LPAREN) ) {
                        alt23=2;
                    }


                }


                switch (alt23) {
            	case 1 :
            	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:147:5: p= '.' prop= ID
            	    {
            	    p=(CommonToken)match(input,DOT,FOLLOW_DOT_in_notConditionalExpr778);  
            	    stream_DOT.add(p);

            	    prop=(CommonToken)match(input,ID,FOLLOW_ID_in_notConditionalExpr782);  
            	    stream_ID.add(prop);



            	    // AST REWRITE
            	    // elements: notConditionalExpr, prop
            	    // token labels: prop
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    retval.tree = root_0;
            	    RewriteRuleTokenStream stream_prop=new RewriteRuleTokenStream(adaptor,"token prop",prop);
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 147:24: -> ^( PROP[$p,\"PROP\"] $notConditionalExpr $prop)
            	    {
            	        // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:147:27: ^( PROP[$p,\"PROP\"] $notConditionalExpr $prop)
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PROP, p, "PROP"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_prop.nextNode());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;
            	    }
            	    break;
            	case 2 :
            	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:148:5: p= '.' '(' mapExpr ')'
            	    {
            	    p=(CommonToken)match(input,DOT,FOLLOW_DOT_in_notConditionalExpr808);  
            	    stream_DOT.add(p);

            	    char_literal65=(CommonToken)match(input,LPAREN,FOLLOW_LPAREN_in_notConditionalExpr810);  
            	    stream_LPAREN.add(char_literal65);

            	    pushFollow(FOLLOW_mapExpr_in_notConditionalExpr812);
            	    mapExpr66=mapExpr();

            	    state._fsp--;

            	    stream_mapExpr.add(mapExpr66.getTree());
            	    char_literal67=(CommonToken)match(input,RPAREN,FOLLOW_RPAREN_in_notConditionalExpr814);  
            	    stream_RPAREN.add(char_literal67);



            	    // AST REWRITE
            	    // elements: mapExpr, notConditionalExpr
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 148:30: -> ^( PROP_IND[$p,\"PROP_IND\"] $notConditionalExpr mapExpr )
            	    {
            	        // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:148:33: ^( PROP_IND[$p,\"PROP_IND\"] $notConditionalExpr mapExpr )
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PROP_IND, p, "PROP_IND"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_mapExpr.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;
            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

           catch (RecognitionException re) { throw re; }
        finally {
        }
        return retval;
    }
    // $ANTLR end "notConditionalExpr"

    public static class exprOptions_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "exprOptions"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:152:1: exprOptions : option ( ',' option )* -> ^( OPTIONS ( option )* ) ;
    public final STParser.exprOptions_return exprOptions() throws RecognitionException {
        STParser.exprOptions_return retval = new STParser.exprOptions_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonToken char_literal69=null;
        STParser.option_return option68 = null;

        STParser.option_return option70 = null;


        CommonTree char_literal69_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_option=new RewriteRuleSubtreeStream(adaptor,"rule option");
        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:152:13: ( option ( ',' option )* -> ^( OPTIONS ( option )* ) )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:152:15: option ( ',' option )*
            {
            pushFollow(FOLLOW_option_in_exprOptions844);
            option68=option();

            state._fsp--;

            stream_option.add(option68.getTree());
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:152:22: ( ',' option )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==COMMA) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:152:24: ',' option
            	    {
            	    char_literal69=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_exprOptions848);  
            	    stream_COMMA.add(char_literal69);

            	    pushFollow(FOLLOW_option_in_exprOptions850);
            	    option70=option();

            	    state._fsp--;

            	    stream_option.add(option70.getTree());

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);



            // AST REWRITE
            // elements: option
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 152:38: -> ^( OPTIONS ( option )* )
            {
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:152:41: ^( OPTIONS ( option )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPTIONS, "OPTIONS"), root_1);

                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:152:51: ( option )*
                while ( stream_option.hasNext() ) {
                    adaptor.addChild(root_1, stream_option.nextTree());

                }
                stream_option.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

           catch (RecognitionException re) { throw re; }
        finally {
        }
        return retval;
    }
    // $ANTLR end "exprOptions"

    public static class option_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "option"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:154:1: option : ID ( '=' exprNoComma -> {validOption}? ^( '=' ID exprNoComma ) -> | -> {validOption&&defVal!=null}? ^( EQUALS[\"=\"] ID STRING[$ID,'\"'+defVal+'\"'] ) ->) ;
    public final STParser.option_return option() throws RecognitionException {
        STParser.option_return retval = new STParser.option_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonToken ID71=null;
        CommonToken char_literal72=null;
        STParser.exprNoComma_return exprNoComma73 = null;


        CommonTree ID71_tree=null;
        CommonTree char_literal72_tree=null;
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_exprNoComma=new RewriteRuleSubtreeStream(adaptor,"rule exprNoComma");

        	String id = input.LT(1).getText();
        	String defVal = Compiler.defaultOptionValues.get(id);
        	boolean validOption = Compiler.supportedOptions.get(id)!=null;

        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:160:2: ( ID ( '=' exprNoComma -> {validOption}? ^( '=' ID exprNoComma ) -> | -> {validOption&&defVal!=null}? ^( EQUALS[\"=\"] ID STRING[$ID,'\"'+defVal+'\"'] ) ->) )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:160:4: ID ( '=' exprNoComma -> {validOption}? ^( '=' ID exprNoComma ) -> | -> {validOption&&defVal!=null}? ^( EQUALS[\"=\"] ID STRING[$ID,'\"'+defVal+'\"'] ) ->)
            {
            ID71=(CommonToken)match(input,ID,FOLLOW_ID_in_option877);  
            stream_ID.add(ID71);


            		if ( !validOption ) {
                        errMgr.compileTimeError(ErrorType.NO_SUCH_OPTION, templateToken, ID71, (ID71!=null?ID71.getText():null));
            		}
            		
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:166:3: ( '=' exprNoComma -> {validOption}? ^( '=' ID exprNoComma ) -> | -> {validOption&&defVal!=null}? ^( EQUALS[\"=\"] ID STRING[$ID,'\"'+defVal+'\"'] ) ->)
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==EQUALS) ) {
                alt25=1;
            }
            else if ( (LA25_0==COMMA||LA25_0==RDELIM) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:166:5: '=' exprNoComma
                    {
                    char_literal72=(CommonToken)match(input,EQUALS,FOLLOW_EQUALS_in_option887);  
                    stream_EQUALS.add(char_literal72);

                    pushFollow(FOLLOW_exprNoComma_in_option889);
                    exprNoComma73=exprNoComma();

                    state._fsp--;

                    stream_exprNoComma.add(exprNoComma73.getTree());


                    // AST REWRITE
                    // elements: ID, exprNoComma, EQUALS
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 166:26: -> {validOption}? ^( '=' ID exprNoComma )
                    if (validOption) {
                        // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:166:44: ^( '=' ID exprNoComma )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_EQUALS.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        adaptor.addChild(root_1, stream_exprNoComma.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }
                    else // 167:13: ->
                    {
                        root_0 = null;
                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:168:5: 
                    {

                    			if ( defVal==null ) {
                    				errMgr.compileTimeError(ErrorType.NO_DEFAULT_VALUE, templateToken, ID71);
                    			}
                    			


                    // AST REWRITE
                    // elements: ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 173:13: -> {validOption&&defVal!=null}? ^( EQUALS[\"=\"] ID STRING[$ID,'\"'+defVal+'\"'] )
                    if (validOption&&defVal!=null) {
                        // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:174:16: ^( EQUALS[\"=\"] ID STRING[$ID,'\"'+defVal+'\"'] )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EQUALS, "="), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        adaptor.addChild(root_1, (CommonTree)adaptor.create(STRING, ID71, '"'+defVal+'"'));

                        adaptor.addChild(root_0, root_1);
                        }

                    }
                    else // 175:13: ->
                    {
                        root_0 = null;
                    }

                    retval.tree = root_0;
                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

           catch (RecognitionException re) { throw re; }
        finally {
        }
        return retval;
    }
    // $ANTLR end "option"

    public static class exprNoComma_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "exprNoComma"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:179:1: exprNoComma : memberExpr ( ':' mapTemplateRef -> ^( MAP memberExpr mapTemplateRef ) | -> memberExpr ) ;
    public final STParser.exprNoComma_return exprNoComma() throws RecognitionException {
        STParser.exprNoComma_return retval = new STParser.exprNoComma_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonToken char_literal75=null;
        STParser.memberExpr_return memberExpr74 = null;

        STParser.mapTemplateRef_return mapTemplateRef76 = null;


        CommonTree char_literal75_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleSubtreeStream stream_memberExpr=new RewriteRuleSubtreeStream(adaptor,"rule memberExpr");
        RewriteRuleSubtreeStream stream_mapTemplateRef=new RewriteRuleSubtreeStream(adaptor,"rule mapTemplateRef");
        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:180:2: ( memberExpr ( ':' mapTemplateRef -> ^( MAP memberExpr mapTemplateRef ) | -> memberExpr ) )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:180:4: memberExpr ( ':' mapTemplateRef -> ^( MAP memberExpr mapTemplateRef ) | -> memberExpr )
            {
            pushFollow(FOLLOW_memberExpr_in_exprNoComma996);
            memberExpr74=memberExpr();

            state._fsp--;

            stream_memberExpr.add(memberExpr74.getTree());
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:181:3: ( ':' mapTemplateRef -> ^( MAP memberExpr mapTemplateRef ) | -> memberExpr )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==COLON) ) {
                alt26=1;
            }
            else if ( (LA26_0==RPAREN||(LA26_0>=RBRACK && LA26_0<=COMMA)||LA26_0==RDELIM) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:181:5: ':' mapTemplateRef
                    {
                    char_literal75=(CommonToken)match(input,COLON,FOLLOW_COLON_in_exprNoComma1002);  
                    stream_COLON.add(char_literal75);

                    pushFollow(FOLLOW_mapTemplateRef_in_exprNoComma1004);
                    mapTemplateRef76=mapTemplateRef();

                    state._fsp--;

                    stream_mapTemplateRef.add(mapTemplateRef76.getTree());


                    // AST REWRITE
                    // elements: mapTemplateRef, memberExpr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 181:28: -> ^( MAP memberExpr mapTemplateRef )
                    {
                        // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:181:31: ^( MAP memberExpr mapTemplateRef )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(MAP, "MAP"), root_1);

                        adaptor.addChild(root_1, stream_memberExpr.nextTree());
                        adaptor.addChild(root_1, stream_mapTemplateRef.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:182:14: 
                    {

                    // AST REWRITE
                    // elements: memberExpr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 182:14: -> memberExpr
                    {
                        adaptor.addChild(root_0, stream_memberExpr.nextTree());

                    }

                    retval.tree = root_0;
                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

           catch (RecognitionException re) { throw re; }
        finally {
        }
        return retval;
    }
    // $ANTLR end "exprNoComma"

    public static class expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:186:1: expr : mapExpr ;
    public final STParser.expr_return expr() throws RecognitionException {
        STParser.expr_return retval = new STParser.expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        STParser.mapExpr_return mapExpr77 = null;



        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:186:6: ( mapExpr )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:186:8: mapExpr
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_mapExpr_in_expr1049);
            mapExpr77=mapExpr();

            state._fsp--;

            adaptor.addChild(root_0, mapExpr77.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

           catch (RecognitionException re) { throw re; }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expr"

    public static class mapExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mapExpr"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:190:1: mapExpr : memberExpr ( (c= ',' memberExpr )+ col= ':' mapTemplateRef -> ^( ZIP[$col] ^( ELEMENTS ( memberExpr )+ ) mapTemplateRef ) | -> memberExpr ) (col= ':' x+= mapTemplateRef ({...}? => ',' x+= mapTemplateRef )* -> ^( MAP[$col] $mapExpr ( $x)+ ) )* ;
    public final STParser.mapExpr_return mapExpr() throws RecognitionException {
        STParser.mapExpr_return retval = new STParser.mapExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonToken c=null;
        CommonToken col=null;
        CommonToken char_literal81=null;
        List list_x=null;
        STParser.memberExpr_return memberExpr78 = null;

        STParser.memberExpr_return memberExpr79 = null;

        STParser.mapTemplateRef_return mapTemplateRef80 = null;

        RuleReturnScope x = null;
        CommonTree c_tree=null;
        CommonTree col_tree=null;
        CommonTree char_literal81_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_memberExpr=new RewriteRuleSubtreeStream(adaptor,"rule memberExpr");
        RewriteRuleSubtreeStream stream_mapTemplateRef=new RewriteRuleSubtreeStream(adaptor,"rule mapTemplateRef");
        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:191:2: ( memberExpr ( (c= ',' memberExpr )+ col= ':' mapTemplateRef -> ^( ZIP[$col] ^( ELEMENTS ( memberExpr )+ ) mapTemplateRef ) | -> memberExpr ) (col= ':' x+= mapTemplateRef ({...}? => ',' x+= mapTemplateRef )* -> ^( MAP[$col] $mapExpr ( $x)+ ) )* )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:191:4: memberExpr ( (c= ',' memberExpr )+ col= ':' mapTemplateRef -> ^( ZIP[$col] ^( ELEMENTS ( memberExpr )+ ) mapTemplateRef ) | -> memberExpr ) (col= ':' x+= mapTemplateRef ({...}? => ',' x+= mapTemplateRef )* -> ^( MAP[$col] $mapExpr ( $x)+ ) )*
            {
            pushFollow(FOLLOW_memberExpr_in_mapExpr1061);
            memberExpr78=memberExpr();

            state._fsp--;

            stream_memberExpr.add(memberExpr78.getTree());
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:192:3: ( (c= ',' memberExpr )+ col= ':' mapTemplateRef -> ^( ZIP[$col] ^( ELEMENTS ( memberExpr )+ ) mapTemplateRef ) | -> memberExpr )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==COMMA) ) {
                alt28=1;
            }
            else if ( (LA28_0==SEMI||LA28_0==COLON||LA28_0==RPAREN||LA28_0==RDELIM) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:192:5: (c= ',' memberExpr )+ col= ':' mapTemplateRef
                    {
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:192:5: (c= ',' memberExpr )+
                    int cnt27=0;
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==COMMA) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:192:6: c= ',' memberExpr
                    	    {
                    	    c=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_mapExpr1070);  
                    	    stream_COMMA.add(c);

                    	    pushFollow(FOLLOW_memberExpr_in_mapExpr1072);
                    	    memberExpr79=memberExpr();

                    	    state._fsp--;

                    	    stream_memberExpr.add(memberExpr79.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt27 >= 1 ) break loop27;
                                EarlyExitException eee =
                                    new EarlyExitException(27, input);
                                throw eee;
                        }
                        cnt27++;
                    } while (true);

                    col=(CommonToken)match(input,COLON,FOLLOW_COLON_in_mapExpr1078);  
                    stream_COLON.add(col);

                    pushFollow(FOLLOW_mapTemplateRef_in_mapExpr1080);
                    mapTemplateRef80=mapTemplateRef();

                    state._fsp--;

                    stream_mapTemplateRef.add(mapTemplateRef80.getTree());


                    // AST REWRITE
                    // elements: memberExpr, mapTemplateRef
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 193:13: -> ^( ZIP[$col] ^( ELEMENTS ( memberExpr )+ ) mapTemplateRef )
                    {
                        // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:193:16: ^( ZIP[$col] ^( ELEMENTS ( memberExpr )+ ) mapTemplateRef )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ZIP, col), root_1);

                        // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:193:28: ^( ELEMENTS ( memberExpr )+ )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ELEMENTS, "ELEMENTS"), root_2);

                        if ( !(stream_memberExpr.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_memberExpr.hasNext() ) {
                            adaptor.addChild(root_2, stream_memberExpr.nextTree());

                        }
                        stream_memberExpr.reset();

                        adaptor.addChild(root_1, root_2);
                        }
                        adaptor.addChild(root_1, stream_mapTemplateRef.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:194:14: 
                    {

                    // AST REWRITE
                    // elements: memberExpr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 194:14: -> memberExpr
                    {
                        adaptor.addChild(root_0, stream_memberExpr.nextTree());

                    }

                    retval.tree = root_0;
                    }
                    break;

            }

            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:196:3: (col= ':' x+= mapTemplateRef ({...}? => ',' x+= mapTemplateRef )* -> ^( MAP[$col] $mapExpr ( $x)+ ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==COLON) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:196:5: col= ':' x+= mapTemplateRef ({...}? => ',' x+= mapTemplateRef )*
            	    {
            	    if (list_x!=null) list_x.clear();
            	    col=(CommonToken)match(input,COLON,FOLLOW_COLON_in_mapExpr1143);  
            	    stream_COLON.add(col);

            	    pushFollow(FOLLOW_mapTemplateRef_in_mapExpr1147);
            	    x=mapTemplateRef();

            	    state._fsp--;

            	    stream_mapTemplateRef.add(x.getTree());
            	    if (list_x==null) list_x=new ArrayList();
            	    list_x.add(x.getTree());

            	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:197:30: ({...}? => ',' x+= mapTemplateRef )*
            	    loop29:
            	    do {
            	        int alt29=2;
            	        int LA29_0 = input.LA(1);

            	        if ( (LA29_0==COMMA) && ((c==null))) {
            	            alt29=1;
            	        }


            	        switch (alt29) {
            	    	case 1 :
            	    	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:197:31: {...}? => ',' x+= mapTemplateRef
            	    	    {
            	    	    if ( !((c==null)) ) {
            	    	        throw new FailedPredicateException(input, "mapExpr", "$c==null");
            	    	    }
            	    	    char_literal81=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_mapExpr1153);  
            	    	    stream_COMMA.add(char_literal81);

            	    	    pushFollow(FOLLOW_mapTemplateRef_in_mapExpr1157);
            	    	    x=mapTemplateRef();

            	    	    state._fsp--;

            	    	    stream_mapTemplateRef.add(x.getTree());
            	    	    if (list_x==null) list_x=new ArrayList();
            	    	    list_x.add(x.getTree());


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop29;
            	        }
            	    } while (true);



            	    // AST REWRITE
            	    // elements: mapExpr, x
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: x
            	    // wildcard labels: 
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_x=new RewriteRuleSubtreeStream(adaptor,"token x",list_x);
            	    root_0 = (CommonTree)adaptor.nil();
            	    // 198:13: -> ^( MAP[$col] $mapExpr ( $x)+ )
            	    {
            	        // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:198:16: ^( MAP[$col] $mapExpr ( $x)+ )
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(MAP, col), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        if ( !(stream_x.hasNext()) ) {
            	            throw new RewriteEarlyExitException();
            	        }
            	        while ( stream_x.hasNext() ) {
            	            adaptor.addChild(root_1, stream_x.nextTree());

            	        }
            	        stream_x.reset();

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;
            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

           catch (RecognitionException re) { throw re; }
        finally {
        }
        return retval;
    }
    // $ANTLR end "mapExpr"

    public static class mapTemplateRef_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mapTemplateRef"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:202:1: mapTemplateRef : ( ID '(' args ')' -> ^( INCLUDE ID ( args )? ) | subtemplate | lp= '(' mapExpr rp= ')' '(' ( argExprList )? ')' -> ^( INCLUDE_IND mapExpr ( argExprList )? ) );
    public final STParser.mapTemplateRef_return mapTemplateRef() throws RecognitionException {
        STParser.mapTemplateRef_return retval = new STParser.mapTemplateRef_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonToken lp=null;
        CommonToken rp=null;
        CommonToken ID82=null;
        CommonToken char_literal83=null;
        CommonToken char_literal85=null;
        CommonToken char_literal88=null;
        CommonToken char_literal90=null;
        STParser.args_return args84 = null;

        STParser.subtemplate_return subtemplate86 = null;

        STParser.mapExpr_return mapExpr87 = null;

        STParser.argExprList_return argExprList89 = null;


        CommonTree lp_tree=null;
        CommonTree rp_tree=null;
        CommonTree ID82_tree=null;
        CommonTree char_literal83_tree=null;
        CommonTree char_literal85_tree=null;
        CommonTree char_literal88_tree=null;
        CommonTree char_literal90_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_argExprList=new RewriteRuleSubtreeStream(adaptor,"rule argExprList");
        RewriteRuleSubtreeStream stream_args=new RewriteRuleSubtreeStream(adaptor,"rule args");
        RewriteRuleSubtreeStream stream_mapExpr=new RewriteRuleSubtreeStream(adaptor,"rule mapExpr");
        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:208:2: ( ID '(' args ')' -> ^( INCLUDE ID ( args )? ) | subtemplate | lp= '(' mapExpr rp= ')' '(' ( argExprList )? ')' -> ^( INCLUDE_IND mapExpr ( argExprList )? ) )
            int alt32=3;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt32=1;
                }
                break;
            case LCURLY:
                {
                alt32=2;
                }
                break;
            case LPAREN:
                {
                alt32=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:208:4: ID '(' args ')'
                    {
                    ID82=(CommonToken)match(input,ID,FOLLOW_ID_in_mapTemplateRef1204);  
                    stream_ID.add(ID82);

                    char_literal83=(CommonToken)match(input,LPAREN,FOLLOW_LPAREN_in_mapTemplateRef1206);  
                    stream_LPAREN.add(char_literal83);

                    pushFollow(FOLLOW_args_in_mapTemplateRef1208);
                    args84=args();

                    state._fsp--;

                    stream_args.add(args84.getTree());
                    char_literal85=(CommonToken)match(input,RPAREN,FOLLOW_RPAREN_in_mapTemplateRef1210);  
                    stream_RPAREN.add(char_literal85);



                    // AST REWRITE
                    // elements: ID, args
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 208:26: -> ^( INCLUDE ID ( args )? )
                    {
                        // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:208:29: ^( INCLUDE ID ( args )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INCLUDE, "INCLUDE"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:208:42: ( args )?
                        if ( stream_args.hasNext() ) {
                            adaptor.addChild(root_1, stream_args.nextTree());

                        }
                        stream_args.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:209:4: subtemplate
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_subtemplate_in_mapTemplateRef1232);
                    subtemplate86=subtemplate();

                    state._fsp--;

                    adaptor.addChild(root_0, subtemplate86.getTree());

                    }
                    break;
                case 3 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:210:4: lp= '(' mapExpr rp= ')' '(' ( argExprList )? ')'
                    {
                    lp=(CommonToken)match(input,LPAREN,FOLLOW_LPAREN_in_mapTemplateRef1239);  
                    stream_LPAREN.add(lp);

                    pushFollow(FOLLOW_mapExpr_in_mapTemplateRef1241);
                    mapExpr87=mapExpr();

                    state._fsp--;

                    stream_mapExpr.add(mapExpr87.getTree());
                    rp=(CommonToken)match(input,RPAREN,FOLLOW_RPAREN_in_mapTemplateRef1245);  
                    stream_RPAREN.add(rp);

                    char_literal88=(CommonToken)match(input,LPAREN,FOLLOW_LPAREN_in_mapTemplateRef1247);  
                    stream_LPAREN.add(char_literal88);

                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:210:30: ( argExprList )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==SUPER||LA31_0==LBRACK||LA31_0==LCURLY||(LA31_0>=ID && LA31_0<=STRING)||LA31_0==AT||(LA31_0>=TRUE && LA31_0<=FALSE)) ) {
                        alt31=1;
                    }
                    else if ( (LA31_0==LPAREN) && (((conditional_stack.size()==0)||(conditional_stack.size()>0)))) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:210:30: argExprList
                            {
                            pushFollow(FOLLOW_argExprList_in_mapTemplateRef1249);
                            argExprList89=argExprList();

                            state._fsp--;

                            stream_argExprList.add(argExprList89.getTree());

                            }
                            break;

                    }

                    char_literal90=(CommonToken)match(input,RPAREN,FOLLOW_RPAREN_in_mapTemplateRef1252);  
                    stream_RPAREN.add(char_literal90);



                    // AST REWRITE
                    // elements: argExprList, mapExpr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 210:47: -> ^( INCLUDE_IND mapExpr ( argExprList )? )
                    {
                        // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:210:50: ^( INCLUDE_IND mapExpr ( argExprList )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INCLUDE_IND, "INCLUDE_IND"), root_1);

                        adaptor.addChild(root_1, stream_mapExpr.nextTree());
                        // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:210:72: ( argExprList )?
                        if ( stream_argExprList.hasNext() ) {
                            adaptor.addChild(root_1, stream_argExprList.nextTree());

                        }
                        stream_argExprList.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

           catch (RecognitionException re) { throw re; }
        finally {
        }
        return retval;
    }
    // $ANTLR end "mapTemplateRef"

    public static class memberExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "memberExpr"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:213:1: memberExpr : ( includeExpr -> includeExpr ) (p= '.' ID -> ^( PROP[$p,\"PROP\"] $memberExpr ID ) | p= '.' '(' mapExpr ')' -> ^( PROP_IND[$p,\"PROP_IND\"] $memberExpr mapExpr ) )* ;
    public final STParser.memberExpr_return memberExpr() throws RecognitionException {
        STParser.memberExpr_return retval = new STParser.memberExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonToken p=null;
        CommonToken ID92=null;
        CommonToken char_literal93=null;
        CommonToken char_literal95=null;
        STParser.includeExpr_return includeExpr91 = null;

        STParser.mapExpr_return mapExpr94 = null;


        CommonTree p_tree=null;
        CommonTree ID92_tree=null;
        CommonTree char_literal93_tree=null;
        CommonTree char_literal95_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_includeExpr=new RewriteRuleSubtreeStream(adaptor,"rule includeExpr");
        RewriteRuleSubtreeStream stream_mapExpr=new RewriteRuleSubtreeStream(adaptor,"rule mapExpr");
        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:214:2: ( ( includeExpr -> includeExpr ) (p= '.' ID -> ^( PROP[$p,\"PROP\"] $memberExpr ID ) | p= '.' '(' mapExpr ')' -> ^( PROP_IND[$p,\"PROP_IND\"] $memberExpr mapExpr ) )* )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:214:4: ( includeExpr -> includeExpr ) (p= '.' ID -> ^( PROP[$p,\"PROP\"] $memberExpr ID ) | p= '.' '(' mapExpr ')' -> ^( PROP_IND[$p,\"PROP_IND\"] $memberExpr mapExpr ) )*
            {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:214:4: ( includeExpr -> includeExpr )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:214:5: includeExpr
            {
            pushFollow(FOLLOW_includeExpr_in_memberExpr1275);
            includeExpr91=includeExpr();

            state._fsp--;

            stream_includeExpr.add(includeExpr91.getTree());


            // AST REWRITE
            // elements: includeExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 214:16: -> includeExpr
            {
                adaptor.addChild(root_0, stream_includeExpr.nextTree());

            }

            retval.tree = root_0;
            }

            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:215:3: (p= '.' ID -> ^( PROP[$p,\"PROP\"] $memberExpr ID ) | p= '.' '(' mapExpr ')' -> ^( PROP_IND[$p,\"PROP_IND\"] $memberExpr mapExpr ) )*
            loop33:
            do {
                int alt33=3;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==DOT) ) {
                    int LA33_2 = input.LA(2);

                    if ( (LA33_2==ID) ) {
                        alt33=1;
                    }
                    else if ( (LA33_2==LPAREN) ) {
                        alt33=2;
                    }


                }


                switch (alt33) {
            	case 1 :
            	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:215:5: p= '.' ID
            	    {
            	    p=(CommonToken)match(input,DOT,FOLLOW_DOT_in_memberExpr1286);  
            	    stream_DOT.add(p);

            	    ID92=(CommonToken)match(input,ID,FOLLOW_ID_in_memberExpr1288);  
            	    stream_ID.add(ID92);



            	    // AST REWRITE
            	    // elements: ID, memberExpr
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 215:20: -> ^( PROP[$p,\"PROP\"] $memberExpr ID )
            	    {
            	        // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:215:23: ^( PROP[$p,\"PROP\"] $memberExpr ID )
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PROP, p, "PROP"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_ID.nextNode());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;
            	    }
            	    break;
            	case 2 :
            	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:216:5: p= '.' '(' mapExpr ')'
            	    {
            	    p=(CommonToken)match(input,DOT,FOLLOW_DOT_in_memberExpr1314);  
            	    stream_DOT.add(p);

            	    char_literal93=(CommonToken)match(input,LPAREN,FOLLOW_LPAREN_in_memberExpr1316);  
            	    stream_LPAREN.add(char_literal93);

            	    pushFollow(FOLLOW_mapExpr_in_memberExpr1318);
            	    mapExpr94=mapExpr();

            	    state._fsp--;

            	    stream_mapExpr.add(mapExpr94.getTree());
            	    char_literal95=(CommonToken)match(input,RPAREN,FOLLOW_RPAREN_in_memberExpr1320);  
            	    stream_RPAREN.add(char_literal95);



            	    // AST REWRITE
            	    // elements: mapExpr, memberExpr
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 216:30: -> ^( PROP_IND[$p,\"PROP_IND\"] $memberExpr mapExpr )
            	    {
            	        // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:216:33: ^( PROP_IND[$p,\"PROP_IND\"] $memberExpr mapExpr )
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PROP_IND, p, "PROP_IND"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_mapExpr.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;
            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

           catch (RecognitionException re) { throw re; }
        finally {
        }
        return retval;
    }
    // $ANTLR end "memberExpr"

    public static class includeExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "includeExpr"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:220:1: includeExpr options {k=2; } : ({...}? ID '(' ( expr )? ')' -> ^( EXEC_FUNC ID ( expr )? ) | 'super' '.' ID '(' args ')' -> ^( INCLUDE_SUPER ID ( args )? ) | ID '(' args ')' -> ^( INCLUDE ID ( args )? ) | '@' 'super' '.' ID '(' rp= ')' -> ^( INCLUDE_SUPER_REGION ID ) | '@' ID '(' rp= ')' -> ^( INCLUDE_REGION ID ) | primary );
    public final STParser.includeExpr_return includeExpr() throws RecognitionException {
        STParser.includeExpr_return retval = new STParser.includeExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonToken rp=null;
        CommonToken ID96=null;
        CommonToken char_literal97=null;
        CommonToken char_literal99=null;
        CommonToken string_literal100=null;
        CommonToken char_literal101=null;
        CommonToken ID102=null;
        CommonToken char_literal103=null;
        CommonToken char_literal105=null;
        CommonToken ID106=null;
        CommonToken char_literal107=null;
        CommonToken char_literal109=null;
        CommonToken char_literal110=null;
        CommonToken string_literal111=null;
        CommonToken char_literal112=null;
        CommonToken ID113=null;
        CommonToken char_literal114=null;
        CommonToken char_literal115=null;
        CommonToken ID116=null;
        CommonToken char_literal117=null;
        STParser.expr_return expr98 = null;

        STParser.args_return args104 = null;

        STParser.args_return args108 = null;

        STParser.primary_return primary118 = null;


        CommonTree rp_tree=null;
        CommonTree ID96_tree=null;
        CommonTree char_literal97_tree=null;
        CommonTree char_literal99_tree=null;
        CommonTree string_literal100_tree=null;
        CommonTree char_literal101_tree=null;
        CommonTree ID102_tree=null;
        CommonTree char_literal103_tree=null;
        CommonTree char_literal105_tree=null;
        CommonTree ID106_tree=null;
        CommonTree char_literal107_tree=null;
        CommonTree char_literal109_tree=null;
        CommonTree char_literal110_tree=null;
        CommonTree string_literal111_tree=null;
        CommonTree char_literal112_tree=null;
        CommonTree ID113_tree=null;
        CommonTree char_literal114_tree=null;
        CommonTree char_literal115_tree=null;
        CommonTree ID116_tree=null;
        CommonTree char_literal117_tree=null;
        RewriteRuleTokenStream stream_AT=new RewriteRuleTokenStream(adaptor,"token AT");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_SUPER=new RewriteRuleTokenStream(adaptor,"token SUPER");
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_args=new RewriteRuleSubtreeStream(adaptor,"rule args");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:222:2: ({...}? ID '(' ( expr )? ')' -> ^( EXEC_FUNC ID ( expr )? ) | 'super' '.' ID '(' args ')' -> ^( INCLUDE_SUPER ID ( args )? ) | ID '(' args ')' -> ^( INCLUDE ID ( args )? ) | '@' 'super' '.' ID '(' rp= ')' -> ^( INCLUDE_SUPER_REGION ID ) | '@' ID '(' rp= ')' -> ^( INCLUDE_REGION ID ) | primary )
            int alt35=6;
            alt35 = dfa35.predict(input);
            switch (alt35) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:222:4: {...}? ID '(' ( expr )? ')'
                    {
                    if ( !((Compiler.funcs.containsKey(input.LT(1).getText()))) ) {
                        throw new FailedPredicateException(input, "includeExpr", "Compiler.funcs.containsKey(input.LT(1).getText())");
                    }
                    ID96=(CommonToken)match(input,ID,FOLLOW_ID_in_includeExpr1364);  
                    stream_ID.add(ID96);

                    char_literal97=(CommonToken)match(input,LPAREN,FOLLOW_LPAREN_in_includeExpr1366);  
                    stream_LPAREN.add(char_literal97);

                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:223:10: ( expr )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==SUPER||LA34_0==LBRACK||LA34_0==LCURLY||(LA34_0>=ID && LA34_0<=STRING)||LA34_0==AT||(LA34_0>=TRUE && LA34_0<=FALSE)) ) {
                        alt34=1;
                    }
                    else if ( (LA34_0==LPAREN) && (((conditional_stack.size()==0)||(conditional_stack.size()>0)))) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:223:10: expr
                            {
                            pushFollow(FOLLOW_expr_in_includeExpr1368);
                            expr98=expr();

                            state._fsp--;

                            stream_expr.add(expr98.getTree());

                            }
                            break;

                    }

                    char_literal99=(CommonToken)match(input,RPAREN,FOLLOW_RPAREN_in_includeExpr1371);  
                    stream_RPAREN.add(char_literal99);



                    // AST REWRITE
                    // elements: expr, ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 223:25: -> ^( EXEC_FUNC ID ( expr )? )
                    {
                        // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:223:28: ^( EXEC_FUNC ID ( expr )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXEC_FUNC, "EXEC_FUNC"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:223:43: ( expr )?
                        if ( stream_expr.hasNext() ) {
                            adaptor.addChild(root_1, stream_expr.nextTree());

                        }
                        stream_expr.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:224:4: 'super' '.' ID '(' args ')'
                    {
                    string_literal100=(CommonToken)match(input,SUPER,FOLLOW_SUPER_in_includeExpr1392);  
                    stream_SUPER.add(string_literal100);

                    char_literal101=(CommonToken)match(input,DOT,FOLLOW_DOT_in_includeExpr1394);  
                    stream_DOT.add(char_literal101);

                    ID102=(CommonToken)match(input,ID,FOLLOW_ID_in_includeExpr1396);  
                    stream_ID.add(ID102);

                    char_literal103=(CommonToken)match(input,LPAREN,FOLLOW_LPAREN_in_includeExpr1398);  
                    stream_LPAREN.add(char_literal103);

                    pushFollow(FOLLOW_args_in_includeExpr1400);
                    args104=args();

                    state._fsp--;

                    stream_args.add(args104.getTree());
                    char_literal105=(CommonToken)match(input,RPAREN,FOLLOW_RPAREN_in_includeExpr1402);  
                    stream_RPAREN.add(char_literal105);



                    // AST REWRITE
                    // elements: args, ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 224:35: -> ^( INCLUDE_SUPER ID ( args )? )
                    {
                        // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:224:38: ^( INCLUDE_SUPER ID ( args )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INCLUDE_SUPER, "INCLUDE_SUPER"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:224:57: ( args )?
                        if ( stream_args.hasNext() ) {
                            adaptor.addChild(root_1, stream_args.nextTree());

                        }
                        stream_args.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:225:4: ID '(' args ')'
                    {
                    ID106=(CommonToken)match(input,ID,FOLLOW_ID_in_includeExpr1421);  
                    stream_ID.add(ID106);

                    char_literal107=(CommonToken)match(input,LPAREN,FOLLOW_LPAREN_in_includeExpr1423);  
                    stream_LPAREN.add(char_literal107);

                    pushFollow(FOLLOW_args_in_includeExpr1425);
                    args108=args();

                    state._fsp--;

                    stream_args.add(args108.getTree());
                    char_literal109=(CommonToken)match(input,RPAREN,FOLLOW_RPAREN_in_includeExpr1427);  
                    stream_RPAREN.add(char_literal109);



                    // AST REWRITE
                    // elements: ID, args
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 225:26: -> ^( INCLUDE ID ( args )? )
                    {
                        // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:225:29: ^( INCLUDE ID ( args )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INCLUDE, "INCLUDE"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:225:42: ( args )?
                        if ( stream_args.hasNext() ) {
                            adaptor.addChild(root_1, stream_args.nextTree());

                        }
                        stream_args.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 4 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:226:4: '@' 'super' '.' ID '(' rp= ')'
                    {
                    char_literal110=(CommonToken)match(input,AT,FOLLOW_AT_in_includeExpr1449);  
                    stream_AT.add(char_literal110);

                    string_literal111=(CommonToken)match(input,SUPER,FOLLOW_SUPER_in_includeExpr1451);  
                    stream_SUPER.add(string_literal111);

                    char_literal112=(CommonToken)match(input,DOT,FOLLOW_DOT_in_includeExpr1453);  
                    stream_DOT.add(char_literal112);

                    ID113=(CommonToken)match(input,ID,FOLLOW_ID_in_includeExpr1455);  
                    stream_ID.add(ID113);

                    char_literal114=(CommonToken)match(input,LPAREN,FOLLOW_LPAREN_in_includeExpr1457);  
                    stream_LPAREN.add(char_literal114);

                    rp=(CommonToken)match(input,RPAREN,FOLLOW_RPAREN_in_includeExpr1461);  
                    stream_RPAREN.add(rp);



                    // AST REWRITE
                    // elements: ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 226:36: -> ^( INCLUDE_SUPER_REGION ID )
                    {
                        // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:226:39: ^( INCLUDE_SUPER_REGION ID )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INCLUDE_SUPER_REGION, "INCLUDE_SUPER_REGION"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 5 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:227:4: '@' ID '(' rp= ')'
                    {
                    char_literal115=(CommonToken)match(input,AT,FOLLOW_AT_in_includeExpr1476);  
                    stream_AT.add(char_literal115);

                    ID116=(CommonToken)match(input,ID,FOLLOW_ID_in_includeExpr1478);  
                    stream_ID.add(ID116);

                    char_literal117=(CommonToken)match(input,LPAREN,FOLLOW_LPAREN_in_includeExpr1480);  
                    stream_LPAREN.add(char_literal117);

                    rp=(CommonToken)match(input,RPAREN,FOLLOW_RPAREN_in_includeExpr1484);  
                    stream_RPAREN.add(rp);



                    // AST REWRITE
                    // elements: ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 227:27: -> ^( INCLUDE_REGION ID )
                    {
                        // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:227:30: ^( INCLUDE_REGION ID )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INCLUDE_REGION, "INCLUDE_REGION"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 6 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:228:4: primary
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_primary_in_includeExpr1502);
                    primary118=primary();

                    state._fsp--;

                    adaptor.addChild(root_0, primary118.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

           catch (RecognitionException re) { throw re; }
        finally {
        }
        return retval;
    }
    // $ANTLR end "includeExpr"

    public static class primary_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "primary"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:231:1: primary : ( ID | STRING | TRUE | FALSE | subtemplate | list | {...}? => '(' conditional ')' | {...}? =>lp= '(' expr ')' ( '(' ( argExprList )? ')' -> ^( INCLUDE_IND[$lp] expr ( argExprList )? ) | -> ^( TO_STR[$lp] expr ) ) );
    public final STParser.primary_return primary() throws RecognitionException {
        STParser.primary_return retval = new STParser.primary_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonToken lp=null;
        CommonToken ID119=null;
        CommonToken STRING120=null;
        CommonToken TRUE121=null;
        CommonToken FALSE122=null;
        CommonToken char_literal125=null;
        CommonToken char_literal127=null;
        CommonToken char_literal129=null;
        CommonToken char_literal130=null;
        CommonToken char_literal132=null;
        STParser.subtemplate_return subtemplate123 = null;

        STParser.list_return list124 = null;

        STParser.conditional_return conditional126 = null;

        STParser.expr_return expr128 = null;

        STParser.argExprList_return argExprList131 = null;


        CommonTree lp_tree=null;
        CommonTree ID119_tree=null;
        CommonTree STRING120_tree=null;
        CommonTree TRUE121_tree=null;
        CommonTree FALSE122_tree=null;
        CommonTree char_literal125_tree=null;
        CommonTree char_literal127_tree=null;
        CommonTree char_literal129_tree=null;
        CommonTree char_literal130_tree=null;
        CommonTree char_literal132_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_argExprList=new RewriteRuleSubtreeStream(adaptor,"rule argExprList");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:232:2: ( ID | STRING | TRUE | FALSE | subtemplate | list | {...}? => '(' conditional ')' | {...}? =>lp= '(' expr ')' ( '(' ( argExprList )? ')' -> ^( INCLUDE_IND[$lp] expr ( argExprList )? ) | -> ^( TO_STR[$lp] expr ) ) )
            int alt38=8;
            alt38 = dfa38.predict(input);
            switch (alt38) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:232:4: ID
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    ID119=(CommonToken)match(input,ID,FOLLOW_ID_in_primary1513); 
                    ID119_tree = (CommonTree)adaptor.create(ID119);
                    adaptor.addChild(root_0, ID119_tree);


                    }
                    break;
                case 2 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:233:4: STRING
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    STRING120=(CommonToken)match(input,STRING,FOLLOW_STRING_in_primary1518); 
                    STRING120_tree = (CommonTree)adaptor.create(STRING120);
                    adaptor.addChild(root_0, STRING120_tree);


                    }
                    break;
                case 3 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:234:4: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    TRUE121=(CommonToken)match(input,TRUE,FOLLOW_TRUE_in_primary1523); 
                    TRUE121_tree = (CommonTree)adaptor.create(TRUE121);
                    adaptor.addChild(root_0, TRUE121_tree);


                    }
                    break;
                case 4 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:235:4: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    FALSE122=(CommonToken)match(input,FALSE,FOLLOW_FALSE_in_primary1528); 
                    FALSE122_tree = (CommonTree)adaptor.create(FALSE122);
                    adaptor.addChild(root_0, FALSE122_tree);


                    }
                    break;
                case 5 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:236:4: subtemplate
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_subtemplate_in_primary1533);
                    subtemplate123=subtemplate();

                    state._fsp--;

                    adaptor.addChild(root_0, subtemplate123.getTree());

                    }
                    break;
                case 6 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:237:4: list
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_list_in_primary1538);
                    list124=list();

                    state._fsp--;

                    adaptor.addChild(root_0, list124.getTree());

                    }
                    break;
                case 7 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:238:4: {...}? => '(' conditional ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    if ( !((conditional_stack.size()>0)) ) {
                        throw new FailedPredicateException(input, "primary", "$conditional.size()>0");
                    }
                    char_literal125=(CommonToken)match(input,LPAREN,FOLLOW_LPAREN_in_primary1547); 
                    pushFollow(FOLLOW_conditional_in_primary1550);
                    conditional126=conditional();

                    state._fsp--;

                    adaptor.addChild(root_0, conditional126.getTree());
                    char_literal127=(CommonToken)match(input,RPAREN,FOLLOW_RPAREN_in_primary1552); 

                    }
                    break;
                case 8 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:239:4: {...}? =>lp= '(' expr ')' ( '(' ( argExprList )? ')' -> ^( INCLUDE_IND[$lp] expr ( argExprList )? ) | -> ^( TO_STR[$lp] expr ) )
                    {
                    if ( !((conditional_stack.size()==0)) ) {
                        throw new FailedPredicateException(input, "primary", "$conditional.size()==0");
                    }
                    lp=(CommonToken)match(input,LPAREN,FOLLOW_LPAREN_in_primary1563);  
                    stream_LPAREN.add(lp);

                    pushFollow(FOLLOW_expr_in_primary1565);
                    expr128=expr();

                    state._fsp--;

                    stream_expr.add(expr128.getTree());
                    char_literal129=(CommonToken)match(input,RPAREN,FOLLOW_RPAREN_in_primary1567);  
                    stream_RPAREN.add(char_literal129);

                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:240:3: ( '(' ( argExprList )? ')' -> ^( INCLUDE_IND[$lp] expr ( argExprList )? ) | -> ^( TO_STR[$lp] expr ) )
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==LPAREN) ) {
                        alt37=1;
                    }
                    else if ( (LA37_0==SEMI||LA37_0==COLON||LA37_0==RPAREN||(LA37_0>=RBRACK && LA37_0<=DOT)||LA37_0==RDELIM||(LA37_0>=OR && LA37_0<=AND)) ) {
                        alt37=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 37, 0, input);

                        throw nvae;
                    }
                    switch (alt37) {
                        case 1 :
                            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:240:5: '(' ( argExprList )? ')'
                            {
                            char_literal130=(CommonToken)match(input,LPAREN,FOLLOW_LPAREN_in_primary1573);  
                            stream_LPAREN.add(char_literal130);

                            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:240:9: ( argExprList )?
                            int alt36=2;
                            int LA36_0 = input.LA(1);

                            if ( (LA36_0==SUPER||LA36_0==LBRACK||LA36_0==LCURLY||(LA36_0>=ID && LA36_0<=STRING)||LA36_0==AT||(LA36_0>=TRUE && LA36_0<=FALSE)) ) {
                                alt36=1;
                            }
                            else if ( (LA36_0==LPAREN) && (((conditional_stack.size()==0)||(conditional_stack.size()>0)))) {
                                alt36=1;
                            }
                            switch (alt36) {
                                case 1 :
                                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:240:9: argExprList
                                    {
                                    pushFollow(FOLLOW_argExprList_in_primary1575);
                                    argExprList131=argExprList();

                                    state._fsp--;

                                    stream_argExprList.add(argExprList131.getTree());

                                    }
                                    break;

                            }

                            char_literal132=(CommonToken)match(input,RPAREN,FOLLOW_RPAREN_in_primary1578);  
                            stream_RPAREN.add(char_literal132);



                            // AST REWRITE
                            // elements: expr, argExprList
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (CommonTree)adaptor.nil();
                            // 240:35: -> ^( INCLUDE_IND[$lp] expr ( argExprList )? )
                            {
                                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:240:38: ^( INCLUDE_IND[$lp] expr ( argExprList )? )
                                {
                                CommonTree root_1 = (CommonTree)adaptor.nil();
                                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INCLUDE_IND, lp), root_1);

                                adaptor.addChild(root_1, stream_expr.nextTree());
                                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:240:62: ( argExprList )?
                                if ( stream_argExprList.hasNext() ) {
                                    adaptor.addChild(root_1, stream_argExprList.nextTree());

                                }
                                stream_argExprList.reset();

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;
                            }
                            break;
                        case 2 :
                            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:241:14: 
                            {

                            // AST REWRITE
                            // elements: expr
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (CommonTree)adaptor.nil();
                            // 241:14: -> ^( TO_STR[$lp] expr )
                            {
                                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:241:17: ^( TO_STR[$lp] expr )
                                {
                                CommonTree root_1 = (CommonTree)adaptor.nil();
                                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TO_STR, lp), root_1);

                                adaptor.addChild(root_1, stream_expr.nextTree());

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;
                            }
                            break;

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

           catch (RecognitionException re) { throw re; }
        finally {
        }
        return retval;
    }
    // $ANTLR end "primary"

    public static class args_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "args"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:245:1: args : ( argExprList | namedArg ( ',' namedArg )* ( ',' '...' )? -> ( namedArg )+ ( '...' )? | '...' | );
    public final STParser.args_return args() throws RecognitionException {
        STParser.args_return retval = new STParser.args_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonToken char_literal135=null;
        CommonToken char_literal137=null;
        CommonToken string_literal138=null;
        CommonToken string_literal139=null;
        STParser.argExprList_return argExprList133 = null;

        STParser.namedArg_return namedArg134 = null;

        STParser.namedArg_return namedArg136 = null;


        CommonTree char_literal135_tree=null;
        CommonTree char_literal137_tree=null;
        CommonTree string_literal138_tree=null;
        CommonTree string_literal139_tree=null;
        RewriteRuleTokenStream stream_ELLIPSIS=new RewriteRuleTokenStream(adaptor,"token ELLIPSIS");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_namedArg=new RewriteRuleSubtreeStream(adaptor,"rule namedArg");
        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:245:5: ( argExprList | namedArg ( ',' namedArg )* ( ',' '...' )? -> ( namedArg )+ ( '...' )? | '...' | )
            int alt41=4;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==ID) ) {
                int LA41_1 = input.LA(2);

                if ( ((LA41_1>=COLON && LA41_1<=RPAREN)||(LA41_1>=COMMA && LA41_1<=DOT)) ) {
                    alt41=1;
                }
                else if ( (LA41_1==EQUALS) ) {
                    alt41=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 41, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA41_0==SUPER||LA41_0==LBRACK||LA41_0==LCURLY||LA41_0==STRING||LA41_0==AT||(LA41_0>=TRUE && LA41_0<=FALSE)) ) {
                alt41=1;
            }
            else if ( (LA41_0==LPAREN) && (((conditional_stack.size()==0)||(conditional_stack.size()>0)))) {
                alt41=1;
            }
            else if ( (LA41_0==ELLIPSIS) ) {
                alt41=3;
            }
            else if ( (LA41_0==RPAREN) ) {
                alt41=4;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:245:7: argExprList
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_argExprList_in_args1634);
                    argExprList133=argExprList();

                    state._fsp--;

                    adaptor.addChild(root_0, argExprList133.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:246:4: namedArg ( ',' namedArg )* ( ',' '...' )?
                    {
                    pushFollow(FOLLOW_namedArg_in_args1639);
                    namedArg134=namedArg();

                    state._fsp--;

                    stream_namedArg.add(namedArg134.getTree());
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:246:13: ( ',' namedArg )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==COMMA) ) {
                            int LA39_1 = input.LA(2);

                            if ( (LA39_1==ID) ) {
                                alt39=1;
                            }


                        }


                        switch (alt39) {
                    	case 1 :
                    	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:246:15: ',' namedArg
                    	    {
                    	    char_literal135=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_args1643);  
                    	    stream_COMMA.add(char_literal135);

                    	    pushFollow(FOLLOW_namedArg_in_args1645);
                    	    namedArg136=namedArg();

                    	    state._fsp--;

                    	    stream_namedArg.add(namedArg136.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop39;
                        }
                    } while (true);

                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:246:31: ( ',' '...' )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==COMMA) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:246:32: ',' '...'
                            {
                            char_literal137=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_args1651);  
                            stream_COMMA.add(char_literal137);

                            string_literal138=(CommonToken)match(input,ELLIPSIS,FOLLOW_ELLIPSIS_in_args1653);  
                            stream_ELLIPSIS.add(string_literal138);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: namedArg, ELLIPSIS
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 246:44: -> ( namedArg )+ ( '...' )?
                    {
                        if ( !(stream_namedArg.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_namedArg.hasNext() ) {
                            adaptor.addChild(root_0, stream_namedArg.nextTree());

                        }
                        stream_namedArg.reset();
                        // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:246:57: ( '...' )?
                        if ( stream_ELLIPSIS.hasNext() ) {
                            adaptor.addChild(root_0, stream_ELLIPSIS.nextNode());

                        }
                        stream_ELLIPSIS.reset();

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:247:9: '...'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    string_literal139=(CommonToken)match(input,ELLIPSIS,FOLLOW_ELLIPSIS_in_args1673); 
                    string_literal139_tree = (CommonTree)adaptor.create(string_literal139);
                    adaptor.addChild(root_0, string_literal139_tree);


                    }
                    break;
                case 4 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:249:2: 
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

           catch (RecognitionException re) { throw re; }
        finally {
        }
        return retval;
    }
    // $ANTLR end "args"

    public static class argExprList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "argExprList"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:251:1: argExprList : arg ( ',' arg )* -> ( arg )+ ;
    public final STParser.argExprList_return argExprList() throws RecognitionException {
        STParser.argExprList_return retval = new STParser.argExprList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonToken char_literal141=null;
        STParser.arg_return arg140 = null;

        STParser.arg_return arg142 = null;


        CommonTree char_literal141_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_arg=new RewriteRuleSubtreeStream(adaptor,"rule arg");
        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:251:13: ( arg ( ',' arg )* -> ( arg )+ )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:251:15: arg ( ',' arg )*
            {
            pushFollow(FOLLOW_arg_in_argExprList1686);
            arg140=arg();

            state._fsp--;

            stream_arg.add(arg140.getTree());
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:251:19: ( ',' arg )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==COMMA) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:251:21: ',' arg
            	    {
            	    char_literal141=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_argExprList1690);  
            	    stream_COMMA.add(char_literal141);

            	    pushFollow(FOLLOW_arg_in_argExprList1692);
            	    arg142=arg();

            	    state._fsp--;

            	    stream_arg.add(arg142.getTree());

            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);



            // AST REWRITE
            // elements: arg
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 251:32: -> ( arg )+
            {
                if ( !(stream_arg.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_arg.hasNext() ) {
                    adaptor.addChild(root_0, stream_arg.nextTree());

                }
                stream_arg.reset();

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

           catch (RecognitionException re) { throw re; }
        finally {
        }
        return retval;
    }
    // $ANTLR end "argExprList"

    public static class arg_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arg"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:253:1: arg : exprNoComma ;
    public final STParser.arg_return arg() throws RecognitionException {
        STParser.arg_return retval = new STParser.arg_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        STParser.exprNoComma_return exprNoComma143 = null;



        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:253:5: ( exprNoComma )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:253:7: exprNoComma
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_exprNoComma_in_arg1709);
            exprNoComma143=exprNoComma();

            state._fsp--;

            adaptor.addChild(root_0, exprNoComma143.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

           catch (RecognitionException re) { throw re; }
        finally {
        }
        return retval;
    }
    // $ANTLR end "arg"

    public static class namedArg_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "namedArg"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:255:1: namedArg : ID '=' arg -> ^( '=' ID arg ) ;
    public final STParser.namedArg_return namedArg() throws RecognitionException {
        STParser.namedArg_return retval = new STParser.namedArg_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonToken ID144=null;
        CommonToken char_literal145=null;
        STParser.arg_return arg146 = null;


        CommonTree ID144_tree=null;
        CommonTree char_literal145_tree=null;
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_arg=new RewriteRuleSubtreeStream(adaptor,"rule arg");
        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:255:10: ( ID '=' arg -> ^( '=' ID arg ) )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:255:12: ID '=' arg
            {
            ID144=(CommonToken)match(input,ID,FOLLOW_ID_in_namedArg1718);  
            stream_ID.add(ID144);

            char_literal145=(CommonToken)match(input,EQUALS,FOLLOW_EQUALS_in_namedArg1720);  
            stream_EQUALS.add(char_literal145);

            pushFollow(FOLLOW_arg_in_namedArg1722);
            arg146=arg();

            state._fsp--;

            stream_arg.add(arg146.getTree());


            // AST REWRITE
            // elements: ID, EQUALS, arg
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 255:23: -> ^( '=' ID arg )
            {
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:255:26: ^( '=' ID arg )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_EQUALS.nextNode(), root_1);

                adaptor.addChild(root_1, stream_ID.nextNode());
                adaptor.addChild(root_1, stream_arg.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

           catch (RecognitionException re) { throw re; }
        finally {
        }
        return retval;
    }
    // $ANTLR end "namedArg"

    public static class list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "list"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:257:1: list : ({...}?lb= '[' ']' -> LIST[$lb] | lb= '[' listElement ( ',' listElement )* ']' -> ^( LIST[$lb] ( listElement )* ) );
    public final STParser.list_return list() throws RecognitionException {
        STParser.list_return retval = new STParser.list_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonToken lb=null;
        CommonToken char_literal147=null;
        CommonToken char_literal149=null;
        CommonToken char_literal151=null;
        STParser.listElement_return listElement148 = null;

        STParser.listElement_return listElement150 = null;


        CommonTree lb_tree=null;
        CommonTree char_literal147_tree=null;
        CommonTree char_literal149_tree=null;
        CommonTree char_literal151_tree=null;
        RewriteRuleTokenStream stream_RBRACK=new RewriteRuleTokenStream(adaptor,"token RBRACK");
        RewriteRuleTokenStream stream_LBRACK=new RewriteRuleTokenStream(adaptor,"token LBRACK");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_listElement=new RewriteRuleSubtreeStream(adaptor,"rule listElement");
        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:257:5: ({...}?lb= '[' ']' -> LIST[$lb] | lb= '[' listElement ( ',' listElement )* ']' -> ^( LIST[$lb] ( listElement )* ) )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==LBRACK) ) {
                int LA44_1 = input.LA(2);

                if ( (LA44_1==RBRACK) ) {
                    int LA44_2 = input.LA(3);

                    if ( ((input.LA(2)==RBRACK)) ) {
                        alt44=1;
                    }
                    else if ( (true) ) {
                        alt44=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 44, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA44_1==SUPER||LA44_1==LPAREN||LA44_1==LBRACK||LA44_1==COMMA||LA44_1==LCURLY||(LA44_1>=ID && LA44_1<=STRING)||LA44_1==AT||(LA44_1>=TRUE && LA44_1<=FALSE)) ) {
                    alt44=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:257:7: {...}?lb= '[' ']'
                    {
                    if ( !((input.LA(2)==RBRACK)) ) {
                        throw new FailedPredicateException(input, "list", "input.LA(2)==RBRACK");
                    }
                    lb=(CommonToken)match(input,LBRACK,FOLLOW_LBRACK_in_list1747);  
                    stream_LBRACK.add(lb);

                    char_literal147=(CommonToken)match(input,RBRACK,FOLLOW_RBRACK_in_list1749);  
                    stream_RBRACK.add(char_literal147);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 258:14: -> LIST[$lb]
                    {
                        adaptor.addChild(root_0, (CommonTree)adaptor.create(LIST, lb));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:259:4: lb= '[' listElement ( ',' listElement )* ']'
                    {
                    lb=(CommonToken)match(input,LBRACK,FOLLOW_LBRACK_in_list1761);  
                    stream_LBRACK.add(lb);

                    pushFollow(FOLLOW_listElement_in_list1763);
                    listElement148=listElement();

                    state._fsp--;

                    stream_listElement.add(listElement148.getTree());
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:259:23: ( ',' listElement )*
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==COMMA) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:259:25: ',' listElement
                    	    {
                    	    char_literal149=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_list1767);  
                    	    stream_COMMA.add(char_literal149);

                    	    pushFollow(FOLLOW_listElement_in_list1769);
                    	    listElement150=listElement();

                    	    state._fsp--;

                    	    stream_listElement.add(listElement150.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop43;
                        }
                    } while (true);

                    char_literal151=(CommonToken)match(input,RBRACK,FOLLOW_RBRACK_in_list1774);  
                    stream_RBRACK.add(char_literal151);



                    // AST REWRITE
                    // elements: listElement
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 259:48: -> ^( LIST[$lb] ( listElement )* )
                    {
                        // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:259:51: ^( LIST[$lb] ( listElement )* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST, lb), root_1);

                        // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:259:63: ( listElement )*
                        while ( stream_listElement.hasNext() ) {
                            adaptor.addChild(root_1, stream_listElement.nextTree());

                        }
                        stream_listElement.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

           catch (RecognitionException re) { throw re; }
        finally {
        }
        return retval;
    }
    // $ANTLR end "list"

    public static class listElement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "listElement"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:262:1: listElement : ( exprNoComma | -> NULL );
    public final STParser.listElement_return listElement() throws RecognitionException {
        STParser.listElement_return retval = new STParser.listElement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        STParser.exprNoComma_return exprNoComma152 = null;



        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:262:13: ( exprNoComma | -> NULL )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==SUPER||LA45_0==LBRACK||LA45_0==LCURLY||(LA45_0>=ID && LA45_0<=STRING)||LA45_0==AT||(LA45_0>=TRUE && LA45_0<=FALSE)) ) {
                alt45=1;
            }
            else if ( (LA45_0==LPAREN) && (((conditional_stack.size()==0)||(conditional_stack.size()>0)))) {
                alt45=1;
            }
            else if ( ((LA45_0>=RBRACK && LA45_0<=COMMA)) ) {
                alt45=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:262:15: exprNoComma
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_exprNoComma_in_listElement1794);
                    exprNoComma152=exprNoComma();

                    state._fsp--;

                    adaptor.addChild(root_0, exprNoComma152.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\STParser.g:262:29: 
                    {

                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 262:29: -> NULL
                    {
                        adaptor.addChild(root_0, (CommonTree)adaptor.create(NULL, "NULL"));

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

           catch (RecognitionException re) { throw re; }
        finally {
        }
        return retval;
    }
    // $ANTLR end "listElement"

    // Delegated rules


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA35 dfa35 = new DFA35(this);
    protected DFA38 dfa38 = new DFA38(this);
    static final String DFA3_eotS =
        "\20\uffff";
    static final String DFA3_eofS =
        "\2\uffff\1\4\2\uffff\1\7\12\uffff";
    static final String DFA3_minS =
        "\2\26\1\25\1\4\1\uffff\1\25\1\4\1\uffff\1\0\1\uffff\1\10\1\0\1"+
        "\10\1\uffff\2\16";
    static final String DFA3_maxS =
        "\3\45\1\44\1\uffff\1\45\1\44\1\uffff\1\0\1\uffff\1\31\1\0\1\31"+
        "\1\uffff\2\30";
    static final String DFA3_acceptS =
        "\4\uffff\1\3\2\uffff\1\2\1\uffff\1\4\3\uffff\1\1\2\uffff";
    static final String DFA3_specialS =
        "\10\uffff\1\1\2\uffff\1\0\4\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\4\1\3\7\uffff\1\1\1\4\4\uffff\1\2",
            "\1\7\1\6\10\uffff\1\7\4\uffff\1\5",
            "\3\4\7\uffff\1\4\1\10\4\uffff\1\4",
            "\1\11\3\uffff\1\4\5\uffff\1\4\1\uffff\1\4\3\uffff\1\4\4\uffff"+
            "\2\4\6\uffff\1\12\1\uffff\2\4",
            "",
            "\3\7\7\uffff\1\7\1\13\4\uffff\1\7",
            "\1\11\3\uffff\1\7\5\uffff\1\7\1\uffff\1\7\3\uffff\1\7\4\uffff"+
            "\2\7\6\uffff\1\14\1\uffff\2\7",
            "",
            "\1\uffff",
            "",
            "\1\4\20\uffff\1\16",
            "\1\uffff",
            "\1\7\20\uffff\1\17",
            "",
            "\1\4\11\uffff\1\11",
            "\1\7\11\uffff\1\11"
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "74:1: element : ({...}? ( INDENT )? COMMENT NEWLINE -> | INDENT singleElement -> ^( INDENTED_EXPR INDENT ( singleElement )? ) | singleElement | compoundElement );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA3_11 = input.LA(1);

                         
                        int index3_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((input.LT(1).getCharPositionInLine()==0)) ) {s = 13;}

                        else if ( (true) ) {s = 7;}

                         
                        input.seek(index3_11);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA3_8 = input.LA(1);

                         
                        int index3_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((input.LT(1).getCharPositionInLine()==0)) ) {s = 13;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index3_8);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 3, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA35_eotS =
        "\30\uffff";
    static final String DFA35_eofS =
        "\30\uffff";
    static final String DFA35_minS =
        "\1\10\1\11\1\uffff\1\10\6\uffff\1\0\15\uffff";
    static final String DFA35_maxS =
        "\1\44\1\36\1\uffff\1\31\6\uffff\1\0\15\uffff";
    static final String DFA35_acceptS =
        "\2\uffff\1\2\1\uffff\1\6\4\uffff\1\6\1\uffff\1\6\10\uffff\1\4\1"+
        "\5\1\1\1\3";
    static final String DFA35_specialS =
        "\1\0\11\uffff\1\1\15\uffff}>";
    static final String[] DFA35_transitionS = {
            "\1\2\5\uffff\1\11\1\uffff\1\4\3\uffff\1\4\4\uffff\1\1\1\4\6"+
            "\uffff\1\3\1\uffff\2\4",
            "\1\13\3\uffff\1\13\1\12\1\13\1\uffff\3\13\4\uffff\1\13\4\uffff"+
            "\2\13",
            "",
            "\1\24\20\uffff\1\25",
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
            ""
    };

    static final short[] DFA35_eot = DFA.unpackEncodedString(DFA35_eotS);
    static final short[] DFA35_eof = DFA.unpackEncodedString(DFA35_eofS);
    static final char[] DFA35_min = DFA.unpackEncodedStringToUnsignedChars(DFA35_minS);
    static final char[] DFA35_max = DFA.unpackEncodedStringToUnsignedChars(DFA35_maxS);
    static final short[] DFA35_accept = DFA.unpackEncodedString(DFA35_acceptS);
    static final short[] DFA35_special = DFA.unpackEncodedString(DFA35_specialS);
    static final short[][] DFA35_transition;

    static {
        int numStates = DFA35_transitionS.length;
        DFA35_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA35_transition[i] = DFA.unpackEncodedString(DFA35_transitionS[i]);
        }
    }

    class DFA35 extends DFA {

        public DFA35(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 35;
            this.eot = DFA35_eot;
            this.eof = DFA35_eof;
            this.min = DFA35_min;
            this.max = DFA35_max;
            this.accept = DFA35_accept;
            this.special = DFA35_special;
            this.transition = DFA35_transition;
        }
        public String getDescription() {
            return "220:1: includeExpr options {k=2; } : ({...}? ID '(' ( expr )? ')' -> ^( EXEC_FUNC ID ( expr )? ) | 'super' '.' ID '(' args ')' -> ^( INCLUDE_SUPER ID ( args )? ) | ID '(' args ')' -> ^( INCLUDE ID ( args )? ) | '@' 'super' '.' ID '(' rp= ')' -> ^( INCLUDE_SUPER_REGION ID ) | '@' ID '(' rp= ')' -> ^( INCLUDE_REGION ID ) | primary );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA35_0 = input.LA(1);

                         
                        int index35_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA35_0==ID) ) {s = 1;}

                        else if ( (LA35_0==SUPER) ) {s = 2;}

                        else if ( (LA35_0==AT) ) {s = 3;}

                        else if ( (LA35_0==LBRACK||LA35_0==LCURLY||LA35_0==STRING||(LA35_0>=TRUE && LA35_0<=FALSE)) ) {s = 4;}

                        else if ( (LA35_0==LPAREN) && (((conditional_stack.size()==0)||(conditional_stack.size()>0)))) {s = 9;}

                         
                        input.seek(index35_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA35_10 = input.LA(1);

                         
                        int index35_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((Compiler.funcs.containsKey(input.LT(1).getText()))) ) {s = 22;}

                        else if ( (true) ) {s = 23;}

                         
                        input.seek(index35_10);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 35, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA38_eotS =
        "\12\uffff";
    static final String DFA38_eofS =
        "\12\uffff";
    static final String DFA38_minS =
        "\1\16\6\uffff\1\0\2\uffff";
    static final String DFA38_maxS =
        "\1\44\6\uffff\1\0\2\uffff";
    static final String DFA38_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\7\1\10";
    static final String DFA38_specialS =
        "\1\0\6\uffff\1\1\2\uffff}>";
    static final String[] DFA38_transitionS = {
            "\1\7\1\uffff\1\6\3\uffff\1\5\4\uffff\1\1\1\2\10\uffff\1\3\1"+
            "\4",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
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
            return "231:1: primary : ( ID | STRING | TRUE | FALSE | subtemplate | list | {...}? => '(' conditional ')' | {...}? =>lp= '(' expr ')' ( '(' ( argExprList )? ')' -> ^( INCLUDE_IND[$lp] expr ( argExprList )? ) | -> ^( TO_STR[$lp] expr ) ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA38_0 = input.LA(1);

                         
                        int index38_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA38_0==ID) ) {s = 1;}

                        else if ( (LA38_0==STRING) ) {s = 2;}

                        else if ( (LA38_0==TRUE) ) {s = 3;}

                        else if ( (LA38_0==FALSE) ) {s = 4;}

                        else if ( (LA38_0==LCURLY) ) {s = 5;}

                        else if ( (LA38_0==LBRACK) ) {s = 6;}

                        else if ( (LA38_0==LPAREN) && (((conditional_stack.size()==0)||(conditional_stack.size()>0)))) {s = 7;}

                         
                        input.seek(index38_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA38_7 = input.LA(1);

                         
                        int index38_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((conditional_stack.size()>0)) ) {s = 8;}

                        else if ( ((conditional_stack.size()==0)) ) {s = 9;}

                         
                        input.seek(index38_7);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 38, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_template_in_templateAndEOF133 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_templateAndEOF135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_element_in_template149 = new BitSet(new long[]{0x0000002180C00002L});
    public static final BitSet FOLLOW_INDENT_in_element162 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_COMMENT_in_element165 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_NEWLINE_in_element167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INDENT_in_element175 = new BitSet(new long[]{0x0000002100C00000L});
    public static final BitSet FOLLOW_singleElement_in_element177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_singleElement_in_element194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compoundElement_in_element199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exprTag_in_singleElement210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_singleElement215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWLINE_in_singleElement220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMENT_in_singleElement225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifstat_in_compoundElement238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_region_in_compoundElement243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LDELIM_in_exprTag254 = new BitSet(new long[]{0x0000001A06114100L});
    public static final BitSet FOLLOW_expr_in_exprTag256 = new BitSet(new long[]{0x0000000001000200L});
    public static final BitSet FOLLOW_SEMI_in_exprTag260 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_exprOptions_in_exprTag262 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RDELIM_in_exprTag267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INDENT_in_region299 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_LDELIM_in_region304 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_AT_in_region306 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_ID_in_region308 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RDELIM_in_region310 = new BitSet(new long[]{0x0000002180C00000L});
    public static final BitSet FOLLOW_template_in_region316 = new BitSet(new long[]{0x0000000080800000L});
    public static final BitSet FOLLOW_INDENT_in_region320 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_LDELIM_in_region323 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_END_in_region325 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RDELIM_in_region327 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_NEWLINE_in_region338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURLY_in_subtemplate414 = new BitSet(new long[]{0x0000002182C00000L});
    public static final BitSet FOLLOW_ID_in_subtemplate420 = new BitSet(new long[]{0x0000000010040000L});
    public static final BitSet FOLLOW_COMMA_in_subtemplate424 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_ID_in_subtemplate429 = new BitSet(new long[]{0x0000000010040000L});
    public static final BitSet FOLLOW_PIPE_in_subtemplate434 = new BitSet(new long[]{0x0000002180C00000L});
    public static final BitSet FOLLOW_template_in_subtemplate439 = new BitSet(new long[]{0x0000000080200000L});
    public static final BitSet FOLLOW_INDENT_in_subtemplate441 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_RCURLY_in_subtemplate444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INDENT_in_ifstat485 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_LDELIM_in_ifstat488 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IF_in_ifstat490 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LPAREN_in_ifstat492 = new BitSet(new long[]{0x0000001A06114500L});
    public static final BitSet FOLLOW_conditional_in_ifstat496 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RPAREN_in_ifstat498 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RDELIM_in_ifstat500 = new BitSet(new long[]{0x0000002180C00000L});
    public static final BitSet FOLLOW_template_in_ifstat509 = new BitSet(new long[]{0x0000000080800000L});
    public static final BitSet FOLLOW_INDENT_in_ifstat516 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_LDELIM_in_ifstat519 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ELSEIF_in_ifstat521 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LPAREN_in_ifstat523 = new BitSet(new long[]{0x0000001A06114500L});
    public static final BitSet FOLLOW_conditional_in_ifstat527 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RPAREN_in_ifstat529 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RDELIM_in_ifstat531 = new BitSet(new long[]{0x0000002180C00000L});
    public static final BitSet FOLLOW_template_in_ifstat535 = new BitSet(new long[]{0x0000000080800000L});
    public static final BitSet FOLLOW_INDENT_in_ifstat545 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_LDELIM_in_ifstat548 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ELSE_in_ifstat550 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RDELIM_in_ifstat552 = new BitSet(new long[]{0x0000002180C00000L});
    public static final BitSet FOLLOW_template_in_ifstat556 = new BitSet(new long[]{0x0000000080800000L});
    public static final BitSet FOLLOW_INDENT_in_ifstat564 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_LDELIM_in_ifstat570 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ENDIF_in_ifstat572 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RDELIM_in_ifstat576 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_NEWLINE_in_ifstat587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_andConditional_in_conditional707 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_OR_in_conditional711 = new BitSet(new long[]{0x0000001A06114500L});
    public static final BitSet FOLLOW_andConditional_in_conditional714 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_notConditional_in_andConditional727 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_AND_in_andConditional731 = new BitSet(new long[]{0x0000001A06114500L});
    public static final BitSet FOLLOW_notConditional_in_andConditional734 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_BANG_in_notConditional747 = new BitSet(new long[]{0x0000001A06114500L});
    public static final BitSet FOLLOW_notConditional_in_notConditional750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_memberExpr_in_notConditional755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_notConditionalExpr767 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_DOT_in_notConditionalExpr778 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_ID_in_notConditionalExpr782 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_DOT_in_notConditionalExpr808 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LPAREN_in_notConditionalExpr810 = new BitSet(new long[]{0x0000001A06114100L});
    public static final BitSet FOLLOW_mapExpr_in_notConditionalExpr812 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RPAREN_in_notConditionalExpr814 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_option_in_exprOptions844 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_COMMA_in_exprOptions848 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_option_in_exprOptions850 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ID_in_option877 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_EQUALS_in_option887 = new BitSet(new long[]{0x0000001A06114100L});
    public static final BitSet FOLLOW_exprNoComma_in_option889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_memberExpr_in_exprNoComma996 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_COLON_in_exprNoComma1002 = new BitSet(new long[]{0x0000000002104000L});
    public static final BitSet FOLLOW_mapTemplateRef_in_exprNoComma1004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapExpr_in_expr1049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_memberExpr_in_mapExpr1061 = new BitSet(new long[]{0x0000000000042002L});
    public static final BitSet FOLLOW_COMMA_in_mapExpr1070 = new BitSet(new long[]{0x0000001A06114100L});
    public static final BitSet FOLLOW_memberExpr_in_mapExpr1072 = new BitSet(new long[]{0x0000000000042000L});
    public static final BitSet FOLLOW_COLON_in_mapExpr1078 = new BitSet(new long[]{0x0000000002104000L});
    public static final BitSet FOLLOW_mapTemplateRef_in_mapExpr1080 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_COLON_in_mapExpr1143 = new BitSet(new long[]{0x0000000002104000L});
    public static final BitSet FOLLOW_mapTemplateRef_in_mapExpr1147 = new BitSet(new long[]{0x0000000000042002L});
    public static final BitSet FOLLOW_COMMA_in_mapExpr1153 = new BitSet(new long[]{0x0000000002104000L});
    public static final BitSet FOLLOW_mapTemplateRef_in_mapExpr1157 = new BitSet(new long[]{0x0000000000042002L});
    public static final BitSet FOLLOW_ID_in_mapTemplateRef1204 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LPAREN_in_mapTemplateRef1206 = new BitSet(new long[]{0x0000001A0611C900L});
    public static final BitSet FOLLOW_args_in_mapTemplateRef1208 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RPAREN_in_mapTemplateRef1210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subtemplate_in_mapTemplateRef1232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_mapTemplateRef1239 = new BitSet(new long[]{0x0000001A06114100L});
    public static final BitSet FOLLOW_mapExpr_in_mapTemplateRef1241 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RPAREN_in_mapTemplateRef1245 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LPAREN_in_mapTemplateRef1247 = new BitSet(new long[]{0x0000001A0611C100L});
    public static final BitSet FOLLOW_argExprList_in_mapTemplateRef1249 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RPAREN_in_mapTemplateRef1252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_includeExpr_in_memberExpr1275 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_DOT_in_memberExpr1286 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_ID_in_memberExpr1288 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_DOT_in_memberExpr1314 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LPAREN_in_memberExpr1316 = new BitSet(new long[]{0x0000001A06114100L});
    public static final BitSet FOLLOW_mapExpr_in_memberExpr1318 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RPAREN_in_memberExpr1320 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ID_in_includeExpr1364 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LPAREN_in_includeExpr1366 = new BitSet(new long[]{0x0000001A0611C100L});
    public static final BitSet FOLLOW_expr_in_includeExpr1368 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RPAREN_in_includeExpr1371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUPER_in_includeExpr1392 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_DOT_in_includeExpr1394 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_ID_in_includeExpr1396 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LPAREN_in_includeExpr1398 = new BitSet(new long[]{0x0000001A0611C900L});
    public static final BitSet FOLLOW_args_in_includeExpr1400 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RPAREN_in_includeExpr1402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_includeExpr1421 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LPAREN_in_includeExpr1423 = new BitSet(new long[]{0x0000001A0611C900L});
    public static final BitSet FOLLOW_args_in_includeExpr1425 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RPAREN_in_includeExpr1427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_in_includeExpr1449 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SUPER_in_includeExpr1451 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_DOT_in_includeExpr1453 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_ID_in_includeExpr1455 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LPAREN_in_includeExpr1457 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RPAREN_in_includeExpr1461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_in_includeExpr1476 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_ID_in_includeExpr1478 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LPAREN_in_includeExpr1480 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RPAREN_in_includeExpr1484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_includeExpr1502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_primary1513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_primary1518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_primary1523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_primary1528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subtemplate_in_primary1533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_list_in_primary1538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primary1547 = new BitSet(new long[]{0x0000001A06114500L});
    public static final BitSet FOLLOW_conditional_in_primary1550 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RPAREN_in_primary1552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primary1563 = new BitSet(new long[]{0x0000001A06114100L});
    public static final BitSet FOLLOW_expr_in_primary1565 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RPAREN_in_primary1567 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_LPAREN_in_primary1573 = new BitSet(new long[]{0x0000001A0611C100L});
    public static final BitSet FOLLOW_argExprList_in_primary1575 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RPAREN_in_primary1578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argExprList_in_args1634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_namedArg_in_args1639 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_COMMA_in_args1643 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_namedArg_in_args1645 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_COMMA_in_args1651 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ELLIPSIS_in_args1653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELLIPSIS_in_args1673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arg_in_argExprList1686 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_COMMA_in_argExprList1690 = new BitSet(new long[]{0x0000001A06114100L});
    public static final BitSet FOLLOW_arg_in_argExprList1692 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_exprNoComma_in_arg1709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_namedArg1718 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_EQUALS_in_namedArg1720 = new BitSet(new long[]{0x0000001A06114100L});
    public static final BitSet FOLLOW_arg_in_namedArg1722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_in_list1747 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_RBRACK_in_list1749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_in_list1761 = new BitSet(new long[]{0x0000001A06174100L});
    public static final BitSet FOLLOW_listElement_in_list1763 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_COMMA_in_list1767 = new BitSet(new long[]{0x0000001A06174100L});
    public static final BitSet FOLLOW_listElement_in_list1769 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_RBRACK_in_list1774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exprNoComma_in_listElement1794 = new BitSet(new long[]{0x0000000000000002L});

}