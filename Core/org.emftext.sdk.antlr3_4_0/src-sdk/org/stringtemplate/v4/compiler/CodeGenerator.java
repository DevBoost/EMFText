// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g 2011-08-25 17:56:57

/*
 * [The "BSD license"]
 *  Copyright (c) 2011 Terence Parr
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions
 *  are met:
 *  1. Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *  3. The name of the author may not be used to endorse or promote products
 *     derived from this software without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 *  IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 *  OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 *  IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 *  INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 *  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 *  DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 *  THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 *  THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.stringtemplate.v4.compiler;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.TreeNodeStream;
import org.antlr.runtime.tree.TreeParser;
import org.antlr.runtime.tree.TreeRuleReturnScope;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.misc.ErrorManager;
import org.stringtemplate.v4.misc.ErrorType;
import org.stringtemplate.v4.misc.Misc;

public class CodeGenerator extends TreeParser {
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


        public CodeGenerator(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public CodeGenerator(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return CodeGenerator.tokenNames; }
    public String getGrammarFileName() { return "C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g"; }


    	String outermostTemplateName;	// name of overall template
    	CompiledST outermostImpl;
    	Token templateToken;			// overall template token
    	String template;  				// overall template text
    	ErrorManager errMgr;
    	public CodeGenerator(TreeNodeStream input, ErrorManager errMgr, String name, String template, Token templateToken) {
    		this(input, new RecognizerSharedState());
    		this.errMgr = errMgr;
    		this.outermostTemplateName = name;
    		this.template = template;
    		this.templateToken = templateToken;
    	}

    	// convience funcs to hide offensive sending of emit messages to
    	// CompilationState temp data object.

    	public void emit1(CommonTree opAST, short opcode, int arg) {
    		((template_scope)template_stack.peek()).state.emit1(opAST, opcode, arg);
    	}
    	public void emit1(CommonTree opAST, short opcode, String arg) {
    		((template_scope)template_stack.peek()).state.emit1(opAST, opcode, arg);
    	}
    	public void emit2(CommonTree opAST, short opcode, int arg, int arg2) {
    		((template_scope)template_stack.peek()).state.emit2(opAST, opcode, arg, arg2);
    	}
    	public void emit2(CommonTree opAST, short opcode, String s, int arg2) {
    		((template_scope)template_stack.peek()).state.emit2(opAST, opcode, s, arg2);
    	}
    	public void emit(short opcode) {
    		((template_scope)template_stack.peek()).state.emit(opcode);
        }
        public void emit(CommonTree opAST, short opcode) {
    		((template_scope)template_stack.peek()).state.emit(opAST, opcode);
    	}
    	public void insert(int addr, short opcode, String s) {
    		((template_scope)template_stack.peek()).state.insert(addr, opcode, s);
    	}
    	public void setOption(CommonTree id) {
    		((template_scope)template_stack.peek()).state.setOption(id);
    	}
    	public void write(int addr, short value) {
    		((template_scope)template_stack.peek()).state.write(addr,value);
    	}
    	public int address() { return ((template_scope)template_stack.peek()).state.ip; }
    	public void func(CommonTree id) { ((template_scope)template_stack.peek()).state.func(templateToken, id); }
    	public void refAttr(CommonTree id) { ((template_scope)template_stack.peek()).state.refAttr(templateToken, id); }
    	public int defineString(String s) { return ((template_scope)template_stack.peek()).state.defineString(s); }



    // $ANTLR start "templateAndEOF"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:119:1: templateAndEOF : template[null,null] EOF ;
    public final void templateAndEOF() throws RecognitionException {
        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:119:16: ( template[null,null] EOF )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:119:18: template[null,null] EOF
            {
            pushFollow(FOLLOW_template_in_templateAndEOF44);
            template(null, null);

            state._fsp--;

            match(input,EOF,FOLLOW_EOF_in_templateAndEOF47); 

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
    // $ANTLR end "templateAndEOF"

    protected static class template_scope {
        CompilationState state;
    }
    protected Stack template_stack = new Stack();


    // $ANTLR start "template"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:121:1: template[String name, List<FormalArgument> args] returns [CompiledST impl] : chunk ;
    public final CompiledST template(String name, List<FormalArgument> args) throws RecognitionException {
        template_stack.push(new template_scope());
        CompiledST impl = null;


         	((template_scope)template_stack.peek()).state = new CompilationState(errMgr, name, input.getTokenStream());
        	impl = ((template_scope)template_stack.peek()).state.impl;
         	if ( template_stack.size() == 1 ) outermostImpl = impl;
        	impl.defineFormalArgs(args); // make sure args are defined prior to compilation
        	if ( name!=null && name.startsWith(Compiler.SUBTEMPLATE_PREFIX) ) {
        	    impl.addArg(new FormalArgument("i"));
        	    impl.addArg(new FormalArgument("i0"));
            }
        	impl.template = template; // always forget the entire template; char indexes are relative to it

        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:136:2: ( chunk )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:136:4: chunk
            {
            pushFollow(FOLLOW_chunk_in_template71);
            chunk();

            state._fsp--;

             // finish off the CompiledST result
                    if ( ((template_scope)template_stack.peek()).state.stringtable!=null ) impl.strings = ((template_scope)template_stack.peek()).state.stringtable.toArray();
                    impl.codeSize = ((template_scope)template_stack.peek()).state.ip;
            		

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            template_stack.pop();
        }
        return impl;
    }
    // $ANTLR end "template"


    // $ANTLR start "chunk"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:143:1: chunk : ( element )* ;
    public final void chunk() throws RecognitionException {
        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:144:2: ( ( element )* )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:144:4: ( element )*
            {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:144:4: ( element )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==IF||LA1_0==TEXT||LA1_0==NEWLINE||LA1_0==EXPR||LA1_0==REGION||LA1_0==INDENTED_EXPR) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:144:4: element
            	    {
            	    pushFollow(FOLLOW_element_in_chunk86);
            	    element();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
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
    // $ANTLR end "chunk"


    // $ANTLR start "element"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:147:1: element : ( ^( INDENTED_EXPR INDENT compoundElement[$INDENT] ) | compoundElement[null] | ^( INDENTED_EXPR INDENT singleElement ) | singleElement );
    public final void element() throws RecognitionException {
        CommonTree INDENT1=null;
        CommonTree INDENT2=null;

        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:148:2: ( ^( INDENTED_EXPR INDENT compoundElement[$INDENT] ) | compoundElement[null] | ^( INDENTED_EXPR INDENT singleElement ) | singleElement )
            int alt2=4;
            switch ( input.LA(1) ) {
            case INDENTED_EXPR:
                {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==DOWN) ) {
                    int LA2_4 = input.LA(3);

                    if ( (LA2_4==INDENT) ) {
                        int LA2_5 = input.LA(4);

                        if ( (LA2_5==IF||LA2_5==REGION) ) {
                            alt2=1;
                        }
                        else if ( (LA2_5==TEXT||LA2_5==NEWLINE||LA2_5==EXPR) ) {
                            alt2=3;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 2, 5, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 4, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
                }
                break;
            case IF:
            case REGION:
                {
                alt2=2;
                }
                break;
            case TEXT:
            case NEWLINE:
            case EXPR:
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
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:148:4: ^( INDENTED_EXPR INDENT compoundElement[$INDENT] )
                    {
                    match(input,INDENTED_EXPR,FOLLOW_INDENTED_EXPR_in_element99); 

                    match(input, Token.DOWN, null); 
                    INDENT1=(CommonTree)match(input,INDENT,FOLLOW_INDENT_in_element101); 
                    pushFollow(FOLLOW_compoundElement_in_element103);
                    compoundElement(INDENT1);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:149:4: compoundElement[null]
                    {
                    pushFollow(FOLLOW_compoundElement_in_element111);
                    compoundElement(null);

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:150:4: ^( INDENTED_EXPR INDENT singleElement )
                    {
                    match(input,INDENTED_EXPR,FOLLOW_INDENTED_EXPR_in_element118); 

                    match(input, Token.DOWN, null); 
                    INDENT2=(CommonTree)match(input,INDENT,FOLLOW_INDENT_in_element120); 
                    ((template_scope)template_stack.peek()).state.indent(INDENT2);
                    pushFollow(FOLLOW_singleElement_in_element124);
                    singleElement();

                    state._fsp--;

                    ((template_scope)template_stack.peek()).state.emit(Bytecode.INSTR_DEDENT);

                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:151:4: singleElement
                    {
                    pushFollow(FOLLOW_singleElement_in_element132);
                    singleElement();

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
    // $ANTLR end "element"


    // $ANTLR start "singleElement"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:154:1: singleElement : ( exprElement | TEXT | NEWLINE );
    public final void singleElement() throws RecognitionException {
        CommonTree TEXT3=null;

        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:155:2: ( exprElement | TEXT | NEWLINE )
            int alt3=3;
            switch ( input.LA(1) ) {
            case EXPR:
                {
                alt3=1;
                }
                break;
            case TEXT:
                {
                alt3=2;
                }
                break;
            case NEWLINE:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:155:4: exprElement
                    {
                    pushFollow(FOLLOW_exprElement_in_singleElement143);
                    exprElement();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:156:4: TEXT
                    {
                    TEXT3=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_singleElement148); 

                    		if ( (TEXT3!=null?TEXT3.getText():null).length()>0 ) {
                    			emit1(TEXT3,Bytecode.INSTR_WRITE_STR, (TEXT3!=null?TEXT3.getText():null));
                    		}
                    		

                    }
                    break;
                case 3 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:163:4: NEWLINE
                    {
                    match(input,NEWLINE,FOLLOW_NEWLINE_in_singleElement158); 
                    emit(Bytecode.INSTR_NEWLINE);

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
    // $ANTLR end "singleElement"


    // $ANTLR start "compoundElement"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:166:1: compoundElement[CommonTree indent] : ( ifstat[indent] | region[indent] );
    public final void compoundElement(CommonTree indent) throws RecognitionException {
        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:167:2: ( ifstat[indent] | region[indent] )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==IF) ) {
                alt4=1;
            }
            else if ( (LA4_0==REGION) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:167:4: ifstat[indent]
                    {
                    pushFollow(FOLLOW_ifstat_in_compoundElement172);
                    ifstat(indent);

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:168:4: region[indent]
                    {
                    pushFollow(FOLLOW_region_in_compoundElement178);
                    region(indent);

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
    // $ANTLR end "compoundElement"


    // $ANTLR start "exprElement"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:171:1: exprElement : ^( EXPR expr ( exprOptions )? ) ;
    public final void exprElement() throws RecognitionException {
        CommonTree EXPR4=null;

         short op = Bytecode.INSTR_WRITE; 
        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:173:2: ( ^( EXPR expr ( exprOptions )? ) )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:173:4: ^( EXPR expr ( exprOptions )? )
            {
            EXPR4=(CommonTree)match(input,EXPR,FOLLOW_EXPR_in_exprElement197); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expr_in_exprElement199);
            expr();

            state._fsp--;

            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:173:17: ( exprOptions )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==OPTIONS) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:173:18: exprOptions
                    {
                    pushFollow(FOLLOW_exprOptions_in_exprElement202);
                    exprOptions();

                    state._fsp--;

                    op=Bytecode.INSTR_WRITE_OPT;

                    }
                    break;

            }


            match(input, Token.UP, null); 

            		/*
            		CompilationState state = ((template_scope)template_stack.peek()).state;
            		CompiledST impl = state.impl;
            		if ( impl.instrs[state.ip-1] == Bytecode.INSTR_LOAD_LOCAL ) {
            			impl.instrs[state.ip-1] = Bytecode.INSTR_WRITE_LOCAL;
            		}
            		else {
            			emit(EXPR4, op);
            		}
            		*/
            		emit(EXPR4, op);
            		

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
    // $ANTLR end "exprElement"

    public static class region_return extends TreeRuleReturnScope {
        public String name;
    };

    // $ANTLR start "region"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:189:1: region[CommonTree indent] returns [String name] : ^( REGION ID template[$name,null] ) ;
    public final CodeGenerator.region_return region(CommonTree indent) throws RecognitionException {
        CodeGenerator.region_return retval = new CodeGenerator.region_return();
        retval.start = input.LT(1);

        CommonTree ID5=null;
        CompiledST template6 = null;



        	if ( indent!=null ) ((template_scope)template_stack.peek()).state.indent(indent);

        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:196:2: ( ^( REGION ID template[$name,null] ) )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:196:4: ^( REGION ID template[$name,null] )
            {
            match(input,REGION,FOLLOW_REGION_in_region240); 

            match(input, Token.DOWN, null); 
            ID5=(CommonTree)match(input,ID,FOLLOW_ID_in_region242); 
            retval.name = STGroup.getMangledRegionName(outermostTemplateName, (ID5!=null?ID5.getText():null));
            pushFollow(FOLLOW_template_in_region252);
            template6=template(retval.name, null);

            state._fsp--;


            			CompiledST sub = template6;
            	        sub.isRegion = true;
            	        sub.regionDefType = ST.RegionType.EMBEDDED;
            	        sub.templateDefStartToken = ID5.token;
            			//sub.dump();
            			outermostImpl.addImplicitlyDefinedTemplate(sub);
            			emit2(((CommonTree)retval.start), Bytecode.INSTR_NEW, retval.name, 0);
            			emit(((CommonTree)retval.start), Bytecode.INSTR_WRITE);
            			

            match(input, Token.UP, null); 

            }


            	if ( indent!=null ) ((template_scope)template_stack.peek()).state.emit(Bytecode.INSTR_DEDENT);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "region"

    public static class subtemplate_return extends TreeRuleReturnScope {
        public String name;
        public int nargs;
    };

    // $ANTLR start "subtemplate"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:212:1: subtemplate returns [String name, int nargs] : ( ^( SUBTEMPLATE ( ^( ARGS ( ID )+ ) )* template[$name,args] ) | SUBTEMPLATE );
    public final CodeGenerator.subtemplate_return subtemplate() throws RecognitionException {
        CodeGenerator.subtemplate_return retval = new CodeGenerator.subtemplate_return();
        retval.start = input.LT(1);

        CommonTree ID7=null;
        CommonTree SUBTEMPLATE9=null;
        CommonTree SUBTEMPLATE10=null;
        CompiledST template8 = null;



            retval.name = Compiler.getNewSubtemplateName();
        	List<FormalArgument> args = new ArrayList<FormalArgument>();

        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:217:2: ( ^( SUBTEMPLATE ( ^( ARGS ( ID )+ ) )* template[$name,args] ) | SUBTEMPLATE )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==SUBTEMPLATE) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==DOWN) ) {
                    alt8=1;
                }
                else if ( ((LA8_1>=UP && LA8_1<=ELSEIF)||(LA8_1>=BANG && LA8_1<=EQUALS)||LA8_1==TEXT||(LA8_1>=ID && LA8_1<=STRING)||(LA8_1>=OR && LA8_1<=AND)||LA8_1==NEWLINE||(LA8_1>=TRUE && LA8_1<=FALSE)||(LA8_1>=EXPR && LA8_1<=SUBTEMPLATE)||(LA8_1>=REGION && LA8_1<=INDENTED_EXPR)) ) {
                    alt8=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:217:4: ^( SUBTEMPLATE ( ^( ARGS ( ID )+ ) )* template[$name,args] )
                    {
                    SUBTEMPLATE9=(CommonTree)match(input,SUBTEMPLATE,FOLLOW_SUBTEMPLATE_in_subtemplate285); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:218:4: ( ^( ARGS ( ID )+ ) )*
                        loop7:
                        do {
                            int alt7=2;
                            int LA7_0 = input.LA(1);

                            if ( (LA7_0==ARGS) ) {
                                alt7=1;
                            }


                            switch (alt7) {
                        	case 1 :
                        	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:218:5: ^( ARGS ( ID )+ )
                        	    {
                        	    match(input,ARGS,FOLLOW_ARGS_in_subtemplate292); 

                        	    match(input, Token.DOWN, null); 
                        	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:218:12: ( ID )+
                        	    int cnt6=0;
                        	    loop6:
                        	    do {
                        	        int alt6=2;
                        	        int LA6_0 = input.LA(1);

                        	        if ( (LA6_0==ID) ) {
                        	            alt6=1;
                        	        }


                        	        switch (alt6) {
                        	    	case 1 :
                        	    	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:218:13: ID
                        	    	    {
                        	    	    ID7=(CommonTree)match(input,ID,FOLLOW_ID_in_subtemplate295); 
                        	    	    args.add(new FormalArgument((ID7!=null?ID7.getText():null)));

                        	    	    }
                        	    	    break;

                        	    	default :
                        	    	    if ( cnt6 >= 1 ) break loop6;
                        	                EarlyExitException eee =
                        	                    new EarlyExitException(6, input);
                        	                throw eee;
                        	        }
                        	        cnt6++;
                        	    } while (true);


                        	    match(input, Token.UP, null); 

                        	    }
                        	    break;

                        	default :
                        	    break loop7;
                            }
                        } while (true);

                        retval.nargs = args.size();
                        pushFollow(FOLLOW_template_in_subtemplate312);
                        template8=template(retval.name, args);

                        state._fsp--;


                        			CompiledST sub = template8;
                        			sub.isAnonSubtemplate = true;
                        	        sub.templateDefStartToken = SUBTEMPLATE9.token;
                                    sub.ast = SUBTEMPLATE9;
                                    sub.ast.setUnknownTokenBoundaries();
                                    sub.tokens = input.getTokenStream();
                        			//sub.dump();
                        			outermostImpl.addImplicitlyDefinedTemplate(sub);
                        			

                        match(input, Token.UP, null); 
                    }

                    }
                    break;
                case 2 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:232:4: SUBTEMPLATE
                    {
                    SUBTEMPLATE10=(CommonTree)match(input,SUBTEMPLATE,FOLLOW_SUBTEMPLATE_in_subtemplate328); 

                    			CompiledST sub = new CompiledST();
                    			sub.name = retval.name;
                    			sub.template = "";
                    			sub.addArg(new FormalArgument("i"));
                    			sub.addArg(new FormalArgument("i0"));
                    			sub.isAnonSubtemplate = true;
                    	        sub.templateDefStartToken = SUBTEMPLATE10.token;
                                sub.ast = SUBTEMPLATE10;
                                sub.ast.setUnknownTokenBoundaries();
                                sub.tokens = input.getTokenStream();
                    			//sub.dump();
                    			outermostImpl.addImplicitlyDefinedTemplate(sub);
                    			

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
    // $ANTLR end "subtemplate"


    // $ANTLR start "ifstat"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:249:1: ifstat[CommonTree indent] : ^(i= 'if' conditional chunk ( ^(eif= 'elseif' ec= conditional chunk ) )* ( ^(el= 'else' chunk ) )? ) ;
    public final void ifstat(CommonTree indent) throws RecognitionException {
        CommonTree i=null;
        CommonTree eif=null;
        CommonTree el=null;
        CodeGenerator.conditional_return ec = null;



            /** Tracks address of branch operand (in code block).  It's how
             *  we backpatch forward references when generating code for IFs.
             */
            int prevBranchOperand = -1;
            /** Branch instruction operands that are forward refs to end of IF.
             *  We need to update them once we see the endif.
             */
            List<Integer> endRefs = new ArrayList<Integer>();
            if ( indent!=null ) ((template_scope)template_stack.peek()).state.indent(indent);

        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:264:2: ( ^(i= 'if' conditional chunk ( ^(eif= 'elseif' ec= conditional chunk ) )* ( ^(el= 'else' chunk ) )? ) )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:264:4: ^(i= 'if' conditional chunk ( ^(eif= 'elseif' ec= conditional chunk ) )* ( ^(el= 'else' chunk ) )? )
            {
            i=(CommonTree)match(input,IF,FOLLOW_IF_in_ifstat360); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_conditional_in_ifstat362);
            conditional();

            state._fsp--;


            	        prevBranchOperand = address()+1;
            	        emit1(i,Bytecode.INSTR_BRF, -1); // write placeholder as branch target
            			
            pushFollow(FOLLOW_chunk_in_ifstat372);
            chunk();

            state._fsp--;

            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:270:4: ( ^(eif= 'elseif' ec= conditional chunk ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==ELSEIF) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:270:6: ^(eif= 'elseif' ec= conditional chunk )
            	    {
            	    eif=(CommonTree)match(input,ELSEIF,FOLLOW_ELSEIF_in_ifstat382); 


            	    				endRefs.add(address()+1);
            	    				emit1(eif,Bytecode.INSTR_BR, -1); // br end
            	    				// update previous branch instruction
            	    				write(prevBranchOperand, (short)address());
            	    				prevBranchOperand = -1;
            	    				

            	    match(input, Token.DOWN, null); 
            	    pushFollow(FOLLOW_conditional_in_ifstat396);
            	    ec=conditional();

            	    state._fsp--;


            	    		       	prevBranchOperand = address()+1;
            	    		       	// write placeholder as branch target
            	    		       	emit1((ec!=null?((CommonTree)ec.start):null), Bytecode.INSTR_BRF, -1);
            	    				
            	    pushFollow(FOLLOW_chunk_in_ifstat408);
            	    chunk();

            	    state._fsp--;


            	    match(input, Token.UP, null); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:287:4: ( ^(el= 'else' chunk ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==ELSE) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:287:6: ^(el= 'else' chunk )
                    {
                    el=(CommonTree)match(input,ELSE,FOLLOW_ELSE_in_ifstat431); 


                    					endRefs.add(address()+1);
                    					emit1(el, Bytecode.INSTR_BR, -1); // br end
                    					// update previous branch instruction
                    					write(prevBranchOperand, (short)address());
                    					prevBranchOperand = -1;
                    					

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        pushFollow(FOLLOW_chunk_in_ifstat445);
                        chunk();

                        state._fsp--;


                        match(input, Token.UP, null); 
                    }

                    }
                    break;

            }


            match(input, Token.UP, null); 

            		if ( prevBranchOperand>=0 ) {
            			write(prevBranchOperand, (short)address());
            		}
                    for (int opnd : endRefs) write(opnd, (short)address());
            		

            }


            	if ( indent!=null ) ((template_scope)template_stack.peek()).state.emit(Bytecode.INSTR_DEDENT);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ifstat"

    public static class conditional_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "conditional"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:307:1: conditional : ( ^( '||' conditional conditional ) | ^( '&&' conditional conditional ) | ^( '!' conditional ) | expr );
    public final CodeGenerator.conditional_return conditional() throws RecognitionException {
        CodeGenerator.conditional_return retval = new CodeGenerator.conditional_return();
        retval.start = input.LT(1);

        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:308:2: ( ^( '||' conditional conditional ) | ^( '&&' conditional conditional ) | ^( '!' conditional ) | expr )
            int alt11=4;
            switch ( input.LA(1) ) {
            case OR:
                {
                alt11=1;
                }
                break;
            case AND:
                {
                alt11=2;
                }
                break;
            case BANG:
                {
                alt11=3;
                }
                break;
            case ID:
            case STRING:
            case TRUE:
            case FALSE:
            case PROP:
            case PROP_IND:
            case INCLUDE:
            case INCLUDE_IND:
            case EXEC_FUNC:
            case INCLUDE_SUPER:
            case INCLUDE_SUPER_REGION:
            case INCLUDE_REGION:
            case TO_STR:
            case LIST:
            case MAP:
            case ZIP:
            case SUBTEMPLATE:
                {
                alt11=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:308:4: ^( '||' conditional conditional )
                    {
                    match(input,OR,FOLLOW_OR_in_conditional479); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_conditional_in_conditional481);
                    conditional();

                    state._fsp--;

                    pushFollow(FOLLOW_conditional_in_conditional483);
                    conditional();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    emit(Bytecode.INSTR_OR);

                    }
                    break;
                case 2 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:309:4: ^( '&&' conditional conditional )
                    {
                    match(input,AND,FOLLOW_AND_in_conditional493); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_conditional_in_conditional495);
                    conditional();

                    state._fsp--;

                    pushFollow(FOLLOW_conditional_in_conditional497);
                    conditional();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    emit(Bytecode.INSTR_AND);

                    }
                    break;
                case 3 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:310:4: ^( '!' conditional )
                    {
                    match(input,BANG,FOLLOW_BANG_in_conditional507); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_conditional_in_conditional509);
                    conditional();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    emit(Bytecode.INSTR_NOT);

                    }
                    break;
                case 4 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:311:4: expr
                    {
                    pushFollow(FOLLOW_expr_in_conditional521);
                    expr();

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
        return retval;
    }
    // $ANTLR end "conditional"


    // $ANTLR start "exprOptions"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:314:1: exprOptions : ^( OPTIONS ( option )* ) ;
    public final void exprOptions() throws RecognitionException {
        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:314:13: ( ^( OPTIONS ( option )* ) )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:314:15: ^( OPTIONS ( option )* )
            {
            emit(Bytecode.INSTR_OPTIONS);
            match(input,OPTIONS,FOLLOW_OPTIONS_in_exprOptions535); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:314:57: ( option )*
                loop12:
                do {
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==EQUALS) ) {
                        alt12=1;
                    }


                    switch (alt12) {
                	case 1 :
                	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:314:57: option
                	    {
                	    pushFollow(FOLLOW_option_in_exprOptions537);
                	    option();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop12;
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
    // $ANTLR end "exprOptions"


    // $ANTLR start "option"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:316:1: option : ^( '=' ID expr ) ;
    public final void option() throws RecognitionException {
        CommonTree ID11=null;

        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:316:8: ( ^( '=' ID expr ) )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:316:10: ^( '=' ID expr )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_option549); 

            match(input, Token.DOWN, null); 
            ID11=(CommonTree)match(input,ID,FOLLOW_ID_in_option551); 
            pushFollow(FOLLOW_expr_in_option553);
            expr();

            state._fsp--;


            match(input, Token.UP, null); 
            setOption(ID11);

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


    // $ANTLR start "expr"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:318:1: expr : ( ^( ZIP ^( ELEMENTS ( expr )+ ) mapTemplateRef[ne] ) | ^( MAP expr ( mapTemplateRef[1] )+ ) | prop | includeExpr );
    public final void expr() throws RecognitionException {
        CommonTree ZIP12=null;
        CommonTree MAP13=null;

        int nt = 0, ne = 0;
        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:320:2: ( ^( ZIP ^( ELEMENTS ( expr )+ ) mapTemplateRef[ne] ) | ^( MAP expr ( mapTemplateRef[1] )+ ) | prop | includeExpr )
            int alt15=4;
            switch ( input.LA(1) ) {
            case ZIP:
                {
                alt15=1;
                }
                break;
            case MAP:
                {
                alt15=2;
                }
                break;
            case PROP:
            case PROP_IND:
                {
                alt15=3;
                }
                break;
            case ID:
            case STRING:
            case TRUE:
            case FALSE:
            case INCLUDE:
            case INCLUDE_IND:
            case EXEC_FUNC:
            case INCLUDE_SUPER:
            case INCLUDE_SUPER_REGION:
            case INCLUDE_REGION:
            case TO_STR:
            case LIST:
            case SUBTEMPLATE:
                {
                alt15=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:320:4: ^( ZIP ^( ELEMENTS ( expr )+ ) mapTemplateRef[ne] )
                    {
                    ZIP12=(CommonTree)match(input,ZIP,FOLLOW_ZIP_in_expr572); 

                    match(input, Token.DOWN, null); 
                    match(input,ELEMENTS,FOLLOW_ELEMENTS_in_expr575); 

                    match(input, Token.DOWN, null); 
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:320:21: ( expr )+
                    int cnt13=0;
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0>=ID && LA13_0<=STRING)||(LA13_0>=TRUE && LA13_0<=FALSE)||(LA13_0>=PROP && LA13_0<=SUBTEMPLATE)) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:320:22: expr
                    	    {
                    	    pushFollow(FOLLOW_expr_in_expr578);
                    	    expr();

                    	    state._fsp--;

                    	    ne++;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt13 >= 1 ) break loop13;
                                EarlyExitException eee =
                                    new EarlyExitException(13, input);
                                throw eee;
                        }
                        cnt13++;
                    } while (true);


                    match(input, Token.UP, null); 
                    pushFollow(FOLLOW_mapTemplateRef_in_expr585);
                    mapTemplateRef(ne);

                    state._fsp--;


                    match(input, Token.UP, null); 
                    emit1(ZIP12, Bytecode.INSTR_ZIP_MAP, ne);

                    }
                    break;
                case 2 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:322:4: ^( MAP expr ( mapTemplateRef[1] )+ )
                    {
                    MAP13=(CommonTree)match(input,MAP,FOLLOW_MAP_in_expr597); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr599);
                    expr();

                    state._fsp--;

                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:322:15: ( mapTemplateRef[1] )+
                    int cnt14=0;
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>=INCLUDE && LA14_0<=INCLUDE_IND)||LA14_0==SUBTEMPLATE) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:322:16: mapTemplateRef[1]
                    	    {
                    	    pushFollow(FOLLOW_mapTemplateRef_in_expr602);
                    	    mapTemplateRef(1);

                    	    state._fsp--;

                    	    nt++;

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

                    		if ( nt>1 ) emit1(MAP13, nt>1?Bytecode.INSTR_ROT_MAP:Bytecode.INSTR_MAP, nt);
                    		else emit(MAP13, Bytecode.INSTR_MAP);
                    		

                    }
                    break;
                case 3 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:327:4: prop
                    {
                    pushFollow(FOLLOW_prop_in_expr617);
                    prop();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:328:4: includeExpr
                    {
                    pushFollow(FOLLOW_includeExpr_in_expr622);
                    includeExpr();

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
    // $ANTLR end "expr"


    // $ANTLR start "prop"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:331:1: prop : ( ^( PROP expr ID ) | ^( PROP_IND expr expr ) );
    public final void prop() throws RecognitionException {
        CommonTree PROP14=null;
        CommonTree ID15=null;
        CommonTree PROP_IND16=null;

        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:331:5: ( ^( PROP expr ID ) | ^( PROP_IND expr expr ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==PROP) ) {
                alt16=1;
            }
            else if ( (LA16_0==PROP_IND) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:331:7: ^( PROP expr ID )
                    {
                    PROP14=(CommonTree)match(input,PROP,FOLLOW_PROP_in_prop632); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_prop634);
                    expr();

                    state._fsp--;

                    ID15=(CommonTree)match(input,ID,FOLLOW_ID_in_prop636); 

                    match(input, Token.UP, null); 
                    emit1(PROP14, Bytecode.INSTR_LOAD_PROP, (ID15!=null?ID15.getText():null));

                    }
                    break;
                case 2 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:332:4: ^( PROP_IND expr expr )
                    {
                    PROP_IND16=(CommonTree)match(input,PROP_IND,FOLLOW_PROP_IND_in_prop650); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_prop652);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_prop654);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    emit(PROP_IND16, Bytecode.INSTR_LOAD_PROP_IND);

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
    // $ANTLR end "prop"

    public static class mapTemplateRef_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "mapTemplateRef"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:335:1: mapTemplateRef[int num_exprs] : ( ^( INCLUDE ID args ) | subtemplate | ^( INCLUDE_IND expr args ) );
    public final CodeGenerator.mapTemplateRef_return mapTemplateRef(int num_exprs) throws RecognitionException {
        CodeGenerator.mapTemplateRef_return retval = new CodeGenerator.mapTemplateRef_return();
        retval.start = input.LT(1);

        CommonTree INCLUDE17=null;
        CommonTree ID19=null;
        CommonTree INCLUDE_IND21=null;
        CodeGenerator.args_return args18 = null;

        CodeGenerator.subtemplate_return subtemplate20 = null;

        CodeGenerator.args_return args22 = null;


        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:336:2: ( ^( INCLUDE ID args ) | subtemplate | ^( INCLUDE_IND expr args ) )
            int alt17=3;
            switch ( input.LA(1) ) {
            case INCLUDE:
                {
                alt17=1;
                }
                break;
            case SUBTEMPLATE:
                {
                alt17=2;
                }
                break;
            case INCLUDE_IND:
                {
                alt17=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:336:4: ^( INCLUDE ID args )
                    {
                    INCLUDE17=(CommonTree)match(input,INCLUDE,FOLLOW_INCLUDE_in_mapTemplateRef674); 

                    match(input, Token.DOWN, null); 
                    ID19=(CommonTree)match(input,ID,FOLLOW_ID_in_mapTemplateRef676); 
                    for (int i=1; i<=num_exprs; i++) emit(INCLUDE17,Bytecode.INSTR_NULL);
                    pushFollow(FOLLOW_args_in_mapTemplateRef686);
                    args18=args();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    		if ( (args18!=null?args18.passThru:false) ) emit1(((CommonTree)retval.start), Bytecode.INSTR_PASSTHRU, (ID19!=null?ID19.getText():null));
                    		if ( (args18!=null?args18.namedArgs:false) ) emit1(INCLUDE17, Bytecode.INSTR_NEW_BOX_ARGS, (ID19!=null?ID19.getText():null));
                    		else emit2(INCLUDE17, Bytecode.INSTR_NEW, (ID19!=null?ID19.getText():null), (args18!=null?args18.n:0)+num_exprs);
                    		

                    }
                    break;
                case 2 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:345:4: subtemplate
                    {
                    pushFollow(FOLLOW_subtemplate_in_mapTemplateRef699);
                    subtemplate20=subtemplate();

                    state._fsp--;


                    		if ( (subtemplate20!=null?subtemplate20.nargs:0) != num_exprs ) {
                                errMgr.compileTimeError(ErrorType.ANON_ARGUMENT_MISMATCH,
                                						templateToken, (subtemplate20!=null?((CommonTree)subtemplate20.start):null).token, (subtemplate20!=null?subtemplate20.nargs:0), num_exprs);
                    		}
                    		for (int i=1; i<=num_exprs; i++) emit((subtemplate20!=null?((CommonTree)subtemplate20.start):null),Bytecode.INSTR_NULL);
                            emit2((subtemplate20!=null?((CommonTree)subtemplate20.start):null), Bytecode.INSTR_NEW,
                    	              (subtemplate20!=null?subtemplate20.name:null),
                    	              num_exprs);
                    		

                    }
                    break;
                case 3 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:357:4: ^( INCLUDE_IND expr args )
                    {
                    INCLUDE_IND21=(CommonTree)match(input,INCLUDE_IND,FOLLOW_INCLUDE_IND_in_mapTemplateRef711); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_mapTemplateRef713);
                    expr();

                    state._fsp--;


                    			emit(INCLUDE_IND21,Bytecode.INSTR_TOSTR);
                    			for (int i=1; i<=num_exprs; i++) emit(INCLUDE_IND21,Bytecode.INSTR_NULL);
                    			
                    pushFollow(FOLLOW_args_in_mapTemplateRef723);
                    args22=args();

                    state._fsp--;


                    			emit1(INCLUDE_IND21, Bytecode.INSTR_NEW_IND, (args22!=null?args22.n:0)+num_exprs);
                    			

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
    // $ANTLR end "mapTemplateRef"

    public static class includeExpr_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "includeExpr"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:369:1: includeExpr : ( ^( EXEC_FUNC ID ( expr )? ) | ^( INCLUDE ID args ) | ^( INCLUDE_SUPER ID args ) | ^( INCLUDE_REGION ID ) | ^( INCLUDE_SUPER_REGION ID ) | primary );
    public final CodeGenerator.includeExpr_return includeExpr() throws RecognitionException {
        CodeGenerator.includeExpr_return retval = new CodeGenerator.includeExpr_return();
        retval.start = input.LT(1);

        CommonTree ID23=null;
        CommonTree ID25=null;
        CommonTree INCLUDE26=null;
        CommonTree ID28=null;
        CommonTree INCLUDE_SUPER29=null;
        CommonTree ID30=null;
        CommonTree INCLUDE_REGION31=null;
        CommonTree ID32=null;
        CommonTree INCLUDE_SUPER_REGION33=null;
        CodeGenerator.args_return args24 = null;

        CodeGenerator.args_return args27 = null;


        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:370:2: ( ^( EXEC_FUNC ID ( expr )? ) | ^( INCLUDE ID args ) | ^( INCLUDE_SUPER ID args ) | ^( INCLUDE_REGION ID ) | ^( INCLUDE_SUPER_REGION ID ) | primary )
            int alt19=6;
            switch ( input.LA(1) ) {
            case EXEC_FUNC:
                {
                alt19=1;
                }
                break;
            case INCLUDE:
                {
                alt19=2;
                }
                break;
            case INCLUDE_SUPER:
                {
                alt19=3;
                }
                break;
            case INCLUDE_REGION:
                {
                alt19=4;
                }
                break;
            case INCLUDE_SUPER_REGION:
                {
                alt19=5;
                }
                break;
            case ID:
            case STRING:
            case TRUE:
            case FALSE:
            case INCLUDE_IND:
            case TO_STR:
            case LIST:
            case SUBTEMPLATE:
                {
                alt19=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:370:4: ^( EXEC_FUNC ID ( expr )? )
                    {
                    match(input,EXEC_FUNC,FOLLOW_EXEC_FUNC_in_includeExpr745); 

                    match(input, Token.DOWN, null); 
                    ID23=(CommonTree)match(input,ID,FOLLOW_ID_in_includeExpr747); 
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:370:19: ( expr )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( ((LA18_0>=ID && LA18_0<=STRING)||(LA18_0>=TRUE && LA18_0<=FALSE)||(LA18_0>=PROP && LA18_0<=SUBTEMPLATE)) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:370:19: expr
                            {
                            pushFollow(FOLLOW_expr_in_includeExpr749);
                            expr();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 
                    func(ID23);

                    }
                    break;
                case 2 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:371:4: ^( INCLUDE ID args )
                    {
                    INCLUDE26=(CommonTree)match(input,INCLUDE,FOLLOW_INCLUDE_in_includeExpr760); 

                    match(input, Token.DOWN, null); 
                    ID25=(CommonTree)match(input,ID,FOLLOW_ID_in_includeExpr762); 
                    pushFollow(FOLLOW_args_in_includeExpr764);
                    args24=args();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    		if ( (args24!=null?args24.passThru:false) ) emit1(((CommonTree)retval.start), Bytecode.INSTR_PASSTHRU, (ID25!=null?ID25.getText():null));
                    		if ( (args24!=null?args24.namedArgs:false) ) emit1(INCLUDE26, Bytecode.INSTR_NEW_BOX_ARGS, (ID25!=null?ID25.getText():null));
                    		else emit2(INCLUDE26, Bytecode.INSTR_NEW, (ID25!=null?ID25.getText():null), (args24!=null?args24.n:0));
                    		

                    }
                    break;
                case 3 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:377:4: ^( INCLUDE_SUPER ID args )
                    {
                    INCLUDE_SUPER29=(CommonTree)match(input,INCLUDE_SUPER,FOLLOW_INCLUDE_SUPER_in_includeExpr775); 

                    match(input, Token.DOWN, null); 
                    ID28=(CommonTree)match(input,ID,FOLLOW_ID_in_includeExpr777); 
                    pushFollow(FOLLOW_args_in_includeExpr779);
                    args27=args();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    		if ( (args27!=null?args27.passThru:false) ) emit1(((CommonTree)retval.start), Bytecode.INSTR_PASSTHRU, (ID28!=null?ID28.getText():null));
                    		if ( (args27!=null?args27.namedArgs:false) ) emit1(INCLUDE_SUPER29, Bytecode.INSTR_SUPER_NEW_BOX_ARGS, (ID28!=null?ID28.getText():null));
                    		else emit2(INCLUDE_SUPER29, Bytecode.INSTR_SUPER_NEW, (ID28!=null?ID28.getText():null), (args27!=null?args27.n:0));
                    		

                    }
                    break;
                case 4 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:383:4: ^( INCLUDE_REGION ID )
                    {
                    INCLUDE_REGION31=(CommonTree)match(input,INCLUDE_REGION,FOLLOW_INCLUDE_REGION_in_includeExpr790); 

                    match(input, Token.DOWN, null); 
                    ID30=(CommonTree)match(input,ID,FOLLOW_ID_in_includeExpr792); 

                    match(input, Token.UP, null); 

                    									CompiledST impl =
                    										Compiler.defineBlankRegion(outermostImpl, ID30.token);
                    									//impl.dump();
                    									emit2(INCLUDE_REGION31,Bytecode.INSTR_NEW,impl.name,0);
                    									

                    }
                    break;
                case 5 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:389:4: ^( INCLUDE_SUPER_REGION ID )
                    {
                    INCLUDE_SUPER_REGION33=(CommonTree)match(input,INCLUDE_SUPER_REGION,FOLLOW_INCLUDE_SUPER_REGION_in_includeExpr802); 

                    match(input, Token.DOWN, null); 
                    ID32=(CommonTree)match(input,ID,FOLLOW_ID_in_includeExpr804); 

                    match(input, Token.UP, null); 

                    		                            String mangled =
                    		                                STGroup.getMangledRegionName(outermostImpl.name, (ID32!=null?ID32.getText():null));
                    									emit2(INCLUDE_SUPER_REGION33,Bytecode.INSTR_SUPER_NEW,mangled,0);
                    									

                    }
                    break;
                case 6 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:394:4: primary
                    {
                    pushFollow(FOLLOW_primary_in_includeExpr812);
                    primary();

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
        return retval;
    }
    // $ANTLR end "includeExpr"

    public static class primary_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "primary"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:397:1: primary : ( ID | STRING | TRUE | FALSE | subtemplate | list | ^( INCLUDE_IND expr args ) | ^( TO_STR expr ) );
    public final CodeGenerator.primary_return primary() throws RecognitionException {
        CodeGenerator.primary_return retval = new CodeGenerator.primary_return();
        retval.start = input.LT(1);

        CommonTree ID34=null;
        CommonTree STRING35=null;
        CommonTree TRUE36=null;
        CommonTree FALSE37=null;
        CommonTree INCLUDE_IND39=null;
        CommonTree TO_STR41=null;
        CodeGenerator.subtemplate_return subtemplate38 = null;

        CodeGenerator.args_return args40 = null;


        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:398:2: ( ID | STRING | TRUE | FALSE | subtemplate | list | ^( INCLUDE_IND expr args ) | ^( TO_STR expr ) )
            int alt20=8;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt20=1;
                }
                break;
            case STRING:
                {
                alt20=2;
                }
                break;
            case TRUE:
                {
                alt20=3;
                }
                break;
            case FALSE:
                {
                alt20=4;
                }
                break;
            case SUBTEMPLATE:
                {
                alt20=5;
                }
                break;
            case LIST:
                {
                alt20=6;
                }
                break;
            case INCLUDE_IND:
                {
                alt20=7;
                }
                break;
            case TO_STR:
                {
                alt20=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:398:4: ID
                    {
                    ID34=(CommonTree)match(input,ID,FOLLOW_ID_in_primary823); 
                    refAttr(ID34);

                    }
                    break;
                case 2 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:399:4: STRING
                    {
                    STRING35=(CommonTree)match(input,STRING,FOLLOW_STRING_in_primary833); 
                    emit1(STRING35,Bytecode.INSTR_LOAD_STR, Misc.strip((STRING35!=null?STRING35.getText():null),1));

                    }
                    break;
                case 3 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:400:4: TRUE
                    {
                    TRUE36=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_primary842); 
                    emit(TRUE36, Bytecode.INSTR_TRUE);

                    }
                    break;
                case 4 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:401:4: FALSE
                    {
                    FALSE37=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_primary851); 
                    emit(FALSE37, Bytecode.INSTR_FALSE);

                    }
                    break;
                case 5 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:402:4: subtemplate
                    {
                    pushFollow(FOLLOW_subtemplate_in_primary860);
                    subtemplate38=subtemplate();

                    state._fsp--;

                    emit2(((CommonTree)retval.start),Bytecode.INSTR_NEW, (subtemplate38!=null?subtemplate38.name:null), 0);

                    }
                    break;
                case 6 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:404:4: list
                    {
                    pushFollow(FOLLOW_list_in_primary887);
                    list();

                    state._fsp--;


                    }
                    break;
                case 7 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:405:4: ^( INCLUDE_IND expr args )
                    {
                    INCLUDE_IND39=(CommonTree)match(input,INCLUDE_IND,FOLLOW_INCLUDE_IND_in_primary894); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_primary899);
                    expr();

                    state._fsp--;

                    emit(INCLUDE_IND39, Bytecode.INSTR_TOSTR);
                    pushFollow(FOLLOW_args_in_primary908);
                    args40=args();

                    state._fsp--;

                    emit1(INCLUDE_IND39, Bytecode.INSTR_NEW_IND, (args40!=null?args40.n:0));

                    match(input, Token.UP, null); 

                    }
                    break;
                case 8 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:409:4: ^( TO_STR expr )
                    {
                    TO_STR41=(CommonTree)match(input,TO_STR,FOLLOW_TO_STR_in_primary928); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_primary930);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    emit(TO_STR41, Bytecode.INSTR_TOSTR);

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
    // $ANTLR end "primary"


    // $ANTLR start "arg"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:412:1: arg : expr ;
    public final void arg() throws RecognitionException {
        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:412:5: ( expr )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:412:7: expr
            {
            pushFollow(FOLLOW_expr_in_arg943);
            expr();

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
    // $ANTLR end "arg"

    public static class args_return extends TreeRuleReturnScope {
        public int n=0;
        public boolean namedArgs=false;
        public boolean passThru;
    };

    // $ANTLR start "args"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:414:1: args returns [int n=0, boolean namedArgs=false, boolean passThru] : ( ( arg )+ | ( ^(eq= '=' ID expr ) )+ ( '...' )? | '...' | );
    public final CodeGenerator.args_return args() throws RecognitionException {
        CodeGenerator.args_return retval = new CodeGenerator.args_return();
        retval.start = input.LT(1);

        CommonTree eq=null;
        CommonTree ID42=null;

        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:415:2: ( ( arg )+ | ( ^(eq= '=' ID expr ) )+ ( '...' )? | '...' | )
            int alt24=4;
            switch ( input.LA(1) ) {
            case ID:
            case STRING:
            case TRUE:
            case FALSE:
            case PROP:
            case PROP_IND:
            case INCLUDE:
            case INCLUDE_IND:
            case EXEC_FUNC:
            case INCLUDE_SUPER:
            case INCLUDE_SUPER_REGION:
            case INCLUDE_REGION:
            case TO_STR:
            case LIST:
            case MAP:
            case ZIP:
            case SUBTEMPLATE:
                {
                alt24=1;
                }
                break;
            case EQUALS:
                {
                alt24=2;
                }
                break;
            case ELLIPSIS:
                {
                alt24=3;
                }
                break;
            case UP:
                {
                alt24=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:415:4: ( arg )+
                    {
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:415:4: ( arg )+
                    int cnt21=0;
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( ((LA21_0>=ID && LA21_0<=STRING)||(LA21_0>=TRUE && LA21_0<=FALSE)||(LA21_0>=PROP && LA21_0<=SUBTEMPLATE)) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:415:6: arg
                    	    {
                    	    pushFollow(FOLLOW_arg_in_args959);
                    	    arg();

                    	    state._fsp--;

                    	    retval.n++;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt21 >= 1 ) break loop21;
                                EarlyExitException eee =
                                    new EarlyExitException(21, input);
                                throw eee;
                        }
                        cnt21++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:416:4: ( ^(eq= '=' ID expr ) )+ ( '...' )?
                    {
                    emit(((CommonTree)retval.start), Bytecode.INSTR_ARGS); retval.namedArgs =true;
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:417:3: ( ^(eq= '=' ID expr ) )+
                    int cnt22=0;
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==EQUALS) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:417:5: ^(eq= '=' ID expr )
                    	    {
                    	    eq=(CommonTree)match(input,EQUALS,FOLLOW_EQUALS_in_args978); 

                    	    match(input, Token.DOWN, null); 
                    	    ID42=(CommonTree)match(input,ID,FOLLOW_ID_in_args980); 
                    	    pushFollow(FOLLOW_expr_in_args982);
                    	    expr();

                    	    state._fsp--;


                    	    match(input, Token.UP, null); 
                    	    retval.n++; emit1(eq, Bytecode.INSTR_STORE_ARG, defineString((ID42!=null?ID42.getText():null)));

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt22 >= 1 ) break loop22;
                                EarlyExitException eee =
                                    new EarlyExitException(22, input);
                                throw eee;
                        }
                        cnt22++;
                    } while (true);

                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:420:3: ( '...' )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==ELLIPSIS) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:420:5: '...'
                            {
                            match(input,ELLIPSIS,FOLLOW_ELLIPSIS_in_args999); 
                            retval.passThru =true;

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:421:9: '...'
                    {
                    match(input,ELLIPSIS,FOLLOW_ELLIPSIS_in_args1014); 
                    retval.passThru =true; emit(((CommonTree)retval.start), Bytecode.INSTR_ARGS); retval.namedArgs =true;

                    }
                    break;
                case 4 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:423:3: 
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
    // $ANTLR end "args"


    // $ANTLR start "list"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:425:1: list : ^( LIST ( listElement )* ) ;
    public final void list() throws RecognitionException {
        CodeGenerator.listElement_return listElement43 = null;


        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:425:5: ( ^( LIST ( listElement )* ) )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:425:7: ^( LIST ( listElement )* )
            {
            emit(Bytecode.INSTR_LIST);
            match(input,LIST,FOLLOW_LIST_in_list1034); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:426:10: ( listElement )*
                loop25:
                do {
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( ((LA25_0>=ID && LA25_0<=STRING)||(LA25_0>=TRUE && LA25_0<=FALSE)||(LA25_0>=PROP && LA25_0<=SUBTEMPLATE)||LA25_0==NULL) ) {
                        alt25=1;
                    }


                    switch (alt25) {
                	case 1 :
                	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:426:11: listElement
                	    {
                	    pushFollow(FOLLOW_listElement_in_list1037);
                	    listElement43=listElement();

                	    state._fsp--;

                	    emit((listElement43!=null?((CommonTree)listElement43.start):null), Bytecode.INSTR_ADD);

                	    }
                	    break;

                	default :
                	    break loop25;
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
    // $ANTLR end "list"

    public static class listElement_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "listElement"
    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:429:1: listElement : ( expr | NULL );
    public final CodeGenerator.listElement_return listElement() throws RecognitionException {
        CodeGenerator.listElement_return retval = new CodeGenerator.listElement_return();
        retval.start = input.LT(1);

        CommonTree NULL44=null;

        try {
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:429:13: ( expr | NULL )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=ID && LA26_0<=STRING)||(LA26_0>=TRUE && LA26_0<=FALSE)||(LA26_0>=PROP && LA26_0<=SUBTEMPLATE)) ) {
                alt26=1;
            }
            else if ( (LA26_0==NULL) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:429:15: expr
                    {
                    pushFollow(FOLLOW_expr_in_listElement1053);
                    expr();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\CodeGenerator.g:429:22: NULL
                    {
                    NULL44=(CommonTree)match(input,NULL,FOLLOW_NULL_in_listElement1057); 
                    emit(NULL44,Bytecode.INSTR_NULL);

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
    // $ANTLR end "listElement"

    // Delegated rules


 

    public static final BitSet FOLLOW_template_in_templateAndEOF44 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_templateAndEOF47 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_chunk_in_template71 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_element_in_chunk86 = new BitSet(new long[]{0x0280004100400012L});
    public static final BitSet FOLLOW_INDENTED_EXPR_in_element99 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INDENT_in_element101 = new BitSet(new long[]{0x0080000000000010L});
    public static final BitSet FOLLOW_compoundElement_in_element103 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_compoundElement_in_element111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INDENTED_EXPR_in_element118 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INDENT_in_element120 = new BitSet(new long[]{0x0280004100400018L});
    public static final BitSet FOLLOW_singleElement_in_element124 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_singleElement_in_element132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exprElement_in_singleElement143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_singleElement148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWLINE_in_singleElement158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifstat_in_compoundElement172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_region_in_compoundElement178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXPR_in_exprElement197 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_exprElement199 = new BitSet(new long[]{0x0000008000000008L});
    public static final BitSet FOLLOW_exprOptions_in_exprElement202 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REGION_in_region240 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_region242 = new BitSet(new long[]{0x0280004100400010L});
    public static final BitSet FOLLOW_template_in_region252 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SUBTEMPLATE_in_subtemplate285 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARGS_in_subtemplate292 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_subtemplate295 = new BitSet(new long[]{0x0000000002000008L});
    public static final BitSet FOLLOW_template_in_subtemplate312 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SUBTEMPLATE_in_subtemplate328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_ifstat360 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_conditional_in_ifstat362 = new BitSet(new long[]{0x0280004100400010L});
    public static final BitSet FOLLOW_chunk_in_ifstat372 = new BitSet(new long[]{0x0000000000000068L});
    public static final BitSet FOLLOW_ELSEIF_in_ifstat382 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_conditional_in_ifstat396 = new BitSet(new long[]{0x0280004100400010L});
    public static final BitSet FOLLOW_chunk_in_ifstat408 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ELSE_in_ifstat431 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_chunk_in_ifstat445 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_conditional479 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_conditional_in_conditional481 = new BitSet(new long[]{0x001FFF1866000400L});
    public static final BitSet FOLLOW_conditional_in_conditional483 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_conditional493 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_conditional_in_conditional495 = new BitSet(new long[]{0x001FFF1866000400L});
    public static final BitSet FOLLOW_conditional_in_conditional497 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BANG_in_conditional507 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_conditional_in_conditional509 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_conditional521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPTIONS_in_exprOptions535 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_option_in_exprOptions537 = new BitSet(new long[]{0x0000000000001008L});
    public static final BitSet FOLLOW_EQUALS_in_option549 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_option551 = new BitSet(new long[]{0x001FFF1866000400L});
    public static final BitSet FOLLOW_expr_in_option553 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ZIP_in_expr572 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ELEMENTS_in_expr575 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr578 = new BitSet(new long[]{0x001FFF1866000408L});
    public static final BitSet FOLLOW_mapTemplateRef_in_expr585 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAP_in_expr597 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr599 = new BitSet(new long[]{0x00100C0000000000L});
    public static final BitSet FOLLOW_mapTemplateRef_in_expr602 = new BitSet(new long[]{0x00100C0000000008L});
    public static final BitSet FOLLOW_prop_in_expr617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_includeExpr_in_expr622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROP_in_prop632 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_prop634 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_ID_in_prop636 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PROP_IND_in_prop650 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_prop652 = new BitSet(new long[]{0x001FFF1866000400L});
    public static final BitSet FOLLOW_expr_in_prop654 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCLUDE_in_mapTemplateRef674 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_mapTemplateRef676 = new BitSet(new long[]{0x001FFF1866001C08L});
    public static final BitSet FOLLOW_args_in_mapTemplateRef686 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_subtemplate_in_mapTemplateRef699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCLUDE_IND_in_mapTemplateRef711 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_mapTemplateRef713 = new BitSet(new long[]{0x001FFF1866001C08L});
    public static final BitSet FOLLOW_args_in_mapTemplateRef723 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXEC_FUNC_in_includeExpr745 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_includeExpr747 = new BitSet(new long[]{0x001FFF1866000408L});
    public static final BitSet FOLLOW_expr_in_includeExpr749 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCLUDE_in_includeExpr760 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_includeExpr762 = new BitSet(new long[]{0x001FFF1866001C08L});
    public static final BitSet FOLLOW_args_in_includeExpr764 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCLUDE_SUPER_in_includeExpr775 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_includeExpr777 = new BitSet(new long[]{0x001FFF1866001C08L});
    public static final BitSet FOLLOW_args_in_includeExpr779 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCLUDE_REGION_in_includeExpr790 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_includeExpr792 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INCLUDE_SUPER_REGION_in_includeExpr802 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_includeExpr804 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_primary_in_includeExpr812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_primary823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_primary833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_primary842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_primary851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subtemplate_in_primary860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_list_in_primary887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCLUDE_IND_in_primary894 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_primary899 = new BitSet(new long[]{0x001FFF1866001C08L});
    public static final BitSet FOLLOW_args_in_primary908 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TO_STR_in_primary928 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_primary930 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_arg943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arg_in_args959 = new BitSet(new long[]{0x001FFF1866000402L});
    public static final BitSet FOLLOW_EQUALS_in_args978 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_args980 = new BitSet(new long[]{0x001FFF1866000400L});
    public static final BitSet FOLLOW_expr_in_args982 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ELLIPSIS_in_args999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELLIPSIS_in_args1014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LIST_in_list1034 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_listElement_in_list1037 = new BitSet(new long[]{0x011FFF1866000408L});
    public static final BitSet FOLLOW_expr_in_listElement1053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_listElement1057 = new BitSet(new long[]{0x0000000000000002L});

}