/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
// $ANTLR ${project.version} ${buildNumber}

package org.emftext.sdk.regex; 


import org.antlr.runtime3_4_0.*;

/** ANTLR pure ebnf/regex grammar extracted from ANTLRv3 grammar.
Needs to be further testing since antlr uses the same sublanguage for ebnf and regex!*/
@SuppressWarnings("unused")
public class AutomatonRexpParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CHAR_LITERAL", "STRING_LITERAL", "LITERAL_CHAR", "ESC", "XDIGIT", "WS", "'|'", "'?'", "'*'", "'+'", "'^'", "'!'", "'..'", "'.'", "'('", "')'", "'~'"
    };
    public static final int EOF=-1;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int CHAR_LITERAL=4;
    public static final int STRING_LITERAL=5;
    public static final int LITERAL_CHAR=6;
    public static final int ESC=7;
    public static final int XDIGIT=8;
    public static final int WS=9;

    // delegates
    // delegators


        public AutomatonRexpParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public AutomatonRexpParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return AutomatonRexpParser.tokenNames; }
    public String getGrammarFileName() { return "AutomatonRexp.g"; }


     private StringBuffer regExpression = new StringBuffer();
     
     public String getRegExpressionString() {
     		return regExpression.toString();
     }
     
     private String transformIntoRegExpQuotes(String st) {
     	return org.emftext.sdk.regex.AutomatonRexpUtil.escapeToAutomatonSyntax(st);
     }
     
     private String removeTicks(String st) {
     		String test = st;
    		String subString = test.substring(1, test.length()-1);
    		return subString;
     }
     
     public java.util.List<RecognitionException> recExceptions = ((AutomatonRexpLexer)getTokenStream().getTokenSource()).lexerExceptions;





    // $ANTLR start "root"
    // AutomatonRexp.g:77:1: root returns [StringBuffer buf] : alternative1= alternative ( '|' alternative2= alternative )* EOF ;
    public final StringBuffer root() throws RecognitionException {
        StringBuffer buf = null;

        StringBuffer alternative1 = null;

        StringBuffer alternative2 = null;



        	buf = new StringBuffer();

        try {
            // AutomatonRexp.g:83:1: (alternative1= alternative ( '|' alternative2= alternative )* EOF )
            // AutomatonRexp.g:83:3: alternative1= alternative ( '|' alternative2= alternative )* EOF
            {
            pushFollow(FOLLOW_alternative_in_root67);
            alternative1=alternative();

            state._fsp--;

            buf.append(alternative1);
            // AutomatonRexp.g:83:63: ( '|' alternative2= alternative )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==10) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // AutomatonRexp.g:83:65: '|' alternative2= alternative
            	    {
            	    match(input,10,FOLLOW_10_in_root73); 
            	    pushFollow(FOLLOW_alternative_in_root79);
            	    alternative2=alternative();

            	    state._fsp--;

            	    buf.append("|" + alternative2);

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match(input,EOF,FOLLOW_EOF_in_root85); 

            }

        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return buf;
    }
    // $ANTLR end "root"


    // $ANTLR start "ebnf"
    // AutomatonRexp.g:87:1: ebnf returns [StringBuffer buf] : bl= block (sign= '?' | sign= '*' | sign= '+' | sign= '^' | sign= '!' )? ;
    public final StringBuffer ebnf() throws RecognitionException {
        StringBuffer buf = null;

        Token sign=null;
        StringBuffer bl = null;



        	buf = new StringBuffer();

        try {
            // AutomatonRexp.g:92:1: (bl= block (sign= '?' | sign= '*' | sign= '+' | sign= '^' | sign= '!' )? )
            // AutomatonRexp.g:92:3: bl= block (sign= '?' | sign= '*' | sign= '+' | sign= '^' | sign= '!' )?
            {
            pushFollow(FOLLOW_block_in_ebnf110);
            bl=block();

            state._fsp--;

            buf.append(bl);
            // AutomatonRexp.g:92:38: (sign= '?' | sign= '*' | sign= '+' | sign= '^' | sign= '!' )?
            int alt2=6;
            switch ( input.LA(1) ) {
                case 11:
                    {
                    alt2=1;
                    }
                    break;
                case 12:
                    {
                    alt2=2;
                    }
                    break;
                case 13:
                    {
                    alt2=3;
                    }
                    break;
                case 14:
                    {
                    alt2=4;
                    }
                    break;
                case 15:
                    {
                    alt2=5;
                    }
                    break;
            }

            switch (alt2) {
                case 1 :
                    // AutomatonRexp.g:92:40: sign= '?'
                    {
                    sign=(Token)match(input,11,FOLLOW_11_in_ebnf119); 

                    }
                    break;
                case 2 :
                    // AutomatonRexp.g:92:53: sign= '*'
                    {
                    sign=(Token)match(input,12,FOLLOW_12_in_ebnf127); 

                    }
                    break;
                case 3 :
                    // AutomatonRexp.g:92:64: sign= '+'
                    {
                    sign=(Token)match(input,13,FOLLOW_13_in_ebnf133); 

                    }
                    break;
                case 4 :
                    // AutomatonRexp.g:92:78: sign= '^'
                    {
                    sign=(Token)match(input,14,FOLLOW_14_in_ebnf142); 

                    }
                    break;
                case 5 :
                    // AutomatonRexp.g:92:91: sign= '!'
                    {
                    sign=(Token)match(input,15,FOLLOW_15_in_ebnf150); 

                    }
                    break;

            }


            if (sign != null) {
            	buf.append((sign!=null?sign.getText():null));
            }


            }

        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return buf;
    }
    // $ANTLR end "ebnf"


    // $ANTLR start "range"
    // AutomatonRexp.g:100:1: range returns [StringBuffer buf] : first= CHAR_LITERAL '..' second= CHAR_LITERAL ;
    public final StringBuffer range() throws RecognitionException {
        StringBuffer buf = null;

        Token first=null;
        Token second=null;


        	buf = new StringBuffer();

        try {
            // AutomatonRexp.g:106:2: (first= CHAR_LITERAL '..' second= CHAR_LITERAL )
            // AutomatonRexp.g:106:4: first= CHAR_LITERAL '..' second= CHAR_LITERAL
            {
            first=(Token)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_range178); 
            match(input,16,FOLLOW_16_in_range180); 
            second=(Token)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_range184); 

            	buf.append("["); buf.append(removeTicks((first!=null?first.getText():null))); buf.append("-"); buf.append(removeTicks((second!=null?second.getText():null))); buf.append("]");


            }

        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return buf;
    }
    // $ANTLR end "range"


    // $ANTLR start "terminal"
    // AutomatonRexp.g:114:1: terminal returns [StringBuffer buf] : (signTerminal= CHAR_LITERAL | signTerminal= STRING_LITERAL | signTerminalDot= '.' ) ;
    public final StringBuffer terminal() throws RecognitionException {
        StringBuffer buf = null;

        Token signTerminal=null;
        Token signTerminalDot=null;


        	buf = new StringBuffer();

        try {
            // AutomatonRexp.g:120:1: ( (signTerminal= CHAR_LITERAL | signTerminal= STRING_LITERAL | signTerminalDot= '.' ) )
            // AutomatonRexp.g:120:5: (signTerminal= CHAR_LITERAL | signTerminal= STRING_LITERAL | signTerminalDot= '.' )
            {
            // AutomatonRexp.g:120:5: (signTerminal= CHAR_LITERAL | signTerminal= STRING_LITERAL | signTerminalDot= '.' )
            int alt3=3;
            switch ( input.LA(1) ) {
            case CHAR_LITERAL:
                {
                alt3=1;
                }
                break;
            case STRING_LITERAL:
                {
                alt3=2;
                }
                break;
            case 17:
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
                    // AutomatonRexp.g:120:7: signTerminal= CHAR_LITERAL
                    {
                    signTerminal=(Token)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_terminal220); 

                    }
                    break;
                case 2 :
                    // AutomatonRexp.g:120:39: signTerminal= STRING_LITERAL
                    {
                    signTerminal=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_terminal230); 

                    }
                    break;
                case 3 :
                    // AutomatonRexp.g:120:73: signTerminalDot= '.'
                    {
                    signTerminalDot=(Token)match(input,17,FOLLOW_17_in_terminal240); 

                    }
                    break;

            }


            	if (signTerminal != null) {
            		String resultString = transformIntoRegExpQuotes((signTerminal!=null?signTerminal.getText():null));
            		buf.append(resultString);
            	} else if (signTerminalDot != null) {
            		buf.append((signTerminalDot!=null?signTerminalDot.getText():null));
            	}


            }

        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return buf;
    }
    // $ANTLR end "terminal"


    // $ANTLR start "ebnfSuffix"
    // AutomatonRexp.g:131:1: ebnfSuffix returns [StringBuffer buf] : (sign= '?' | sign= '*' | sign= '+' ) ;
    public final StringBuffer ebnfSuffix() throws RecognitionException {
        StringBuffer buf = null;

        Token sign=null;


        	buf = new StringBuffer();

        try {
            // AutomatonRexp.g:140:1: ( (sign= '?' | sign= '*' | sign= '+' ) )
            // AutomatonRexp.g:140:3: (sign= '?' | sign= '*' | sign= '+' )
            {
            // AutomatonRexp.g:140:3: (sign= '?' | sign= '*' | sign= '+' )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt4=1;
                }
                break;
            case 12:
                {
                alt4=2;
                }
                break;
            case 13:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // AutomatonRexp.g:140:4: sign= '?'
                    {
                    sign=(Token)match(input,11,FOLLOW_11_in_ebnfSuffix275); 

                    }
                    break;
                case 2 :
                    // AutomatonRexp.g:140:15: sign= '*'
                    {
                    sign=(Token)match(input,12,FOLLOW_12_in_ebnfSuffix281); 

                    }
                    break;
                case 3 :
                    // AutomatonRexp.g:140:25: sign= '+'
                    {
                    sign=(Token)match(input,13,FOLLOW_13_in_ebnfSuffix286); 

                    }
                    break;

            }


            buf.append((sign!=null?sign.getText():null));


            }


            	return buf;

        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return buf;
    }
    // $ANTLR end "ebnfSuffix"


    // $ANTLR start "block"
    // AutomatonRexp.g:146:1: block returns [StringBuffer buf] : '(' alternative1= alternative ( '|' alternative2= alternative )* ')' ;
    public final StringBuffer block() throws RecognitionException {
        StringBuffer buf = null;

        StringBuffer alternative1 = null;

        StringBuffer alternative2 = null;



        	buf = new StringBuffer();

        try {
            // AutomatonRexp.g:152:1: ( '(' alternative1= alternative ( '|' alternative2= alternative )* ')' )
            // AutomatonRexp.g:152:5: '(' alternative1= alternative ( '|' alternative2= alternative )* ')'
            {
            match(input,18,FOLLOW_18_in_block313); 
            pushFollow(FOLLOW_alternative_in_block317);
            alternative1=alternative();

            state._fsp--;

            buf.append("(" + alternative1);
            // AutomatonRexp.g:152:75: ( '|' alternative2= alternative )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==10) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // AutomatonRexp.g:152:77: '|' alternative2= alternative
            	    {
            	    match(input,10,FOLLOW_10_in_block325); 
            	    pushFollow(FOLLOW_alternative_in_block330);
            	    alternative2=alternative();

            	    state._fsp--;

            	    buf.append("|" + alternative2);

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match(input,19,FOLLOW_19_in_block338); 
            buf.append(")");

            }

        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return buf;
    }
    // $ANTLR end "block"


    // $ANTLR start "alternative"
    // AutomatonRexp.g:154:1: alternative returns [StringBuffer buf] : (ele= element )* ;
    public final StringBuffer alternative() throws RecognitionException {
        StringBuffer buf = null;

        StringBuffer ele = null;



        	buf = new StringBuffer();

        try {
            // AutomatonRexp.g:159:1: ( (ele= element )* )
            // AutomatonRexp.g:159:3: (ele= element )*
            {
            // AutomatonRexp.g:159:3: (ele= element )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=CHAR_LITERAL && LA6_0<=STRING_LITERAL)||(LA6_0>=17 && LA6_0<=18)||LA6_0==20) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // AutomatonRexp.g:159:5: ele= element
            	    {
            	    pushFollow(FOLLOW_element_in_alternative366);
            	    ele=element();

            	    state._fsp--;

            	    buf.append(ele);

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return buf;
    }
    // $ANTLR end "alternative"


    // $ANTLR start "element"
    // AutomatonRexp.g:162:1: element returns [StringBuffer buf] : ele= elementNoOptionSpec ;
    public final StringBuffer element() throws RecognitionException {
        StringBuffer buf = null;

        StringBuffer ele = null;



        	buf = new StringBuffer();

        try {
            // AutomatonRexp.g:167:2: (ele= elementNoOptionSpec )
            // AutomatonRexp.g:167:4: ele= elementNoOptionSpec
            {
            pushFollow(FOLLOW_elementNoOptionSpec_in_element396);
            ele=elementNoOptionSpec();

            state._fsp--;


            buf.append(ele);


            }

        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return buf;
    }
    // $ANTLR end "element"


    // $ANTLR start "elementNoOptionSpec"
    // AutomatonRexp.g:173:1: elementNoOptionSpec returns [StringBuffer buf] : (at= atom (suf= ebnfSuffix )? | eb= ebnf );
    public final StringBuffer elementNoOptionSpec() throws RecognitionException {
        StringBuffer buf = null;

        StringBuffer at = null;

        StringBuffer suf = null;

        StringBuffer eb = null;



        	buf = new StringBuffer();

        try {
            // AutomatonRexp.g:177:1: (at= atom (suf= ebnfSuffix )? | eb= ebnf )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=CHAR_LITERAL && LA8_0<=STRING_LITERAL)||LA8_0==17||LA8_0==20) ) {
                alt8=1;
            }
            else if ( (LA8_0==18) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // AutomatonRexp.g:177:3: at= atom (suf= ebnfSuffix )?
                    {
                    pushFollow(FOLLOW_atom_in_elementNoOptionSpec421);
                    at=atom();

                    state._fsp--;

                    // AutomatonRexp.g:177:14: (suf= ebnfSuffix )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( ((LA7_0>=11 && LA7_0<=13)) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // AutomatonRexp.g:177:16: suf= ebnfSuffix
                            {
                            pushFollow(FOLLOW_ebnfSuffix_in_elementNoOptionSpec430);
                            suf=ebnfSuffix();

                            state._fsp--;


                            }
                            break;

                    }


                    buf.append(at);
                    if (suf != null) {
                    buf.append(suf);
                    }


                    }
                    break;
                case 2 :
                    // AutomatonRexp.g:184:3: eb= ebnf
                    {
                    pushFollow(FOLLOW_ebnf_in_elementNoOptionSpec445);
                    eb=ebnf();

                    state._fsp--;


                    buf.append(eb);


                    }
                    break;

            }
        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return buf;
    }
    // $ANTLR end "elementNoOptionSpec"


    // $ANTLR start "atom"
    // AutomatonRexp.g:190:1: atom returns [StringBuffer buf] : (exp= range | exp= terminal | exp= notSet ) (sign= '^' | sign= '!' )? ;
    public final StringBuffer atom() throws RecognitionException {
        StringBuffer buf = null;

        Token sign=null;
        StringBuffer exp = null;



        	buf = new StringBuffer();

        try {
            // AutomatonRexp.g:195:1: ( (exp= range | exp= terminal | exp= notSet ) (sign= '^' | sign= '!' )? )
            // AutomatonRexp.g:195:3: (exp= range | exp= terminal | exp= notSet ) (sign= '^' | sign= '!' )?
            {
            // AutomatonRexp.g:195:3: (exp= range | exp= terminal | exp= notSet )
            int alt9=3;
            switch ( input.LA(1) ) {
            case CHAR_LITERAL:
                {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==16) ) {
                    alt9=1;
                }
                else if ( (LA9_1==EOF||(LA9_1>=CHAR_LITERAL && LA9_1<=STRING_LITERAL)||(LA9_1>=10 && LA9_1<=15)||(LA9_1>=17 && LA9_1<=20)) ) {
                    alt9=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
                }
                break;
            case STRING_LITERAL:
            case 17:
                {
                alt9=2;
                }
                break;
            case 20:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // AutomatonRexp.g:195:5: exp= range
                    {
                    pushFollow(FOLLOW_range_in_atom473);
                    exp=range();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // AutomatonRexp.g:195:23: exp= terminal
                    {
                    pushFollow(FOLLOW_terminal_in_atom484);
                    exp=terminal();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // AutomatonRexp.g:195:42: exp= notSet
                    {
                    pushFollow(FOLLOW_notSet_in_atom494);
                    exp=notSet();

                    state._fsp--;


                    }
                    break;

            }

            // AutomatonRexp.g:195:59: (sign= '^' | sign= '!' )?
            int alt10=3;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==14) ) {
                alt10=1;
            }
            else if ( (LA10_0==15) ) {
                alt10=2;
            }
            switch (alt10) {
                case 1 :
                    // AutomatonRexp.g:195:60: sign= '^'
                    {
                    sign=(Token)match(input,14,FOLLOW_14_in_atom504); 

                    }
                    break;
                case 2 :
                    // AutomatonRexp.g:195:72: sign= '!'
                    {
                    sign=(Token)match(input,15,FOLLOW_15_in_atom513); 

                    }
                    break;

            }


            buf.append(exp);
            if (sign != null) {
            	buf.append((sign!=null?sign.getText():null));
            }


            }

        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return buf;
    }
    // $ANTLR end "atom"


    // $ANTLR start "notSet"
    // AutomatonRexp.g:204:1: notSet returns [StringBuffer buf] : sign= '~' (bl= block ) ;
    public final StringBuffer notSet() throws RecognitionException {
        StringBuffer buf = null;

        Token sign=null;
        StringBuffer bl = null;



        	buf = new StringBuffer();

        try {
            // AutomatonRexp.g:209:1: (sign= '~' (bl= block ) )
            // AutomatonRexp.g:209:3: sign= '~' (bl= block )
            {
            sign=(Token)match(input,20,FOLLOW_20_in_notSet545); 
            // AutomatonRexp.g:209:15: (bl= block )
            // AutomatonRexp.g:209:17: bl= block
            {
            pushFollow(FOLLOW_block_in_notSet554);
            bl=block();

            state._fsp--;


            }

            buf.append("~(()|");
            buf.append(bl);
            buf.append(")");
            return buf;


            }

        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return buf;
    }
    // $ANTLR end "notSet"

    // Delegated rules


 

    public static final BitSet FOLLOW_alternative_in_root67 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_root73 = new BitSet(new long[]{0x0000000000160430L});
    public static final BitSet FOLLOW_alternative_in_root79 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EOF_in_root85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_ebnf110 = new BitSet(new long[]{0x000000000000F802L});
    public static final BitSet FOLLOW_11_in_ebnf119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ebnf127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ebnf133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ebnf142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ebnf150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_range178 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_range180 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_range184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_terminal220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_terminal230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_terminal240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ebnfSuffix275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ebnfSuffix281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ebnfSuffix286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_block313 = new BitSet(new long[]{0x00000000001E0430L});
    public static final BitSet FOLLOW_alternative_in_block317 = new BitSet(new long[]{0x0000000000080400L});
    public static final BitSet FOLLOW_10_in_block325 = new BitSet(new long[]{0x00000000001E0430L});
    public static final BitSet FOLLOW_alternative_in_block330 = new BitSet(new long[]{0x0000000000080400L});
    public static final BitSet FOLLOW_19_in_block338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_element_in_alternative366 = new BitSet(new long[]{0x0000000000160032L});
    public static final BitSet FOLLOW_elementNoOptionSpec_in_element396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_elementNoOptionSpec421 = new BitSet(new long[]{0x0000000000003802L});
    public static final BitSet FOLLOW_ebnfSuffix_in_elementNoOptionSpec430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ebnf_in_elementNoOptionSpec445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_range_in_atom473 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_terminal_in_atom484 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_notSet_in_atom494 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_14_in_atom504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_atom513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_notSet545 = new BitSet(new long[]{0x0000000000160030L});
    public static final BitSet FOLLOW_block_in_notSet554 = new BitSet(new long[]{0x0000000000000002L});

}
