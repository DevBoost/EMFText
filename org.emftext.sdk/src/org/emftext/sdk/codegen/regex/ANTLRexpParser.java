/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
// $ANTLR 3.1.1 ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g 2009-01-12 11:36:47

package org.emftext.sdk.codegen.regex; 


import org.antlr.runtime.BitSet;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.TokenStream;

/** ANTLR pure ebnf/regex grammar extracted from ANTLRv3 grammar.
Needs to be further testing since antlr uses the same sublanguage for ebnf and regex!*/
public class ANTLRexpParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CHAR_LITERAL", "STRING_LITERAL", "LITERAL_CHAR", "ESC", "XDIGIT", "WS", "'|'", "'?'", "'*'", "'+'", "'^'", "'!'", "'..'", "'.'", "'('", "')'", "'~'"
    };
    public static final int T__12=12;
    public static final int T__20=20;
    public static final int WS=9;
    public static final int T__13=13;
    public static final int T__19=19;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int ESC=7;
    public static final int XDIGIT=8;
    public static final int T__17=17;
    public static final int CHAR_LITERAL=4;
    public static final int EOF=-1;
    public static final int STRING_LITERAL=5;
    public static final int T__16=16;
    public static final int T__10=10;
    public static final int LITERAL_CHAR=6;
    public static final int T__18=18;
    public static final int T__15=15;

    // delegates
    // delegators


        public ANTLRexpParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public ANTLRexpParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return ANTLRexpParser.tokenNames; }
    public String getGrammarFileName() { return "./src/org/emftext/sdk/codegen/regex/ANTLRexp.g"; }


     public java.util.List<RecognitionException> recExceptions = ((ANTLRexpLexer)getTokenStream().getTokenSource()).lexerExceptions;




    // $ANTLR start "root"
    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:60:1: root : alternative ( '|' alternative )* ;
    public final void root() throws RecognitionException {
        try {
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:61:6: ( alternative ( '|' alternative )* )
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:61:8: alternative ( '|' alternative )*
            {
            pushFollow(FOLLOW_alternative_in_root52);
            alternative();

            state._fsp--;

            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:61:20: ( '|' alternative )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==10) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:61:22: '|' alternative
            	    {
            	    match(input,10,FOLLOW_10_in_root56); 
            	    pushFollow(FOLLOW_alternative_in_root58);
            	    alternative();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return ;
    }
    // $ANTLR end "root"


    // $ANTLR start "ebnf"
    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:63:1: ebnf : block ( '?' | '*' | '+' | '^' | '!' )? ;
    public final void ebnf() throws RecognitionException {
        try {
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:63:6: ( block ( '?' | '*' | '+' | '^' | '!' )? )
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:63:8: block ( '?' | '*' | '+' | '^' | '!' )?
            {
            pushFollow(FOLLOW_block_in_ebnf69);
            block();

            state._fsp--;

            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:63:15: ( '?' | '*' | '+' | '^' | '!' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=11 && LA2_0<=15)) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:
                    {
                    if ( (input.LA(1)>=11 && input.LA(1)<=15) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;

            }


            }

        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return ;
    }
    // $ANTLR end "ebnf"


    // $ANTLR start "range"
    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:65:1: range : CHAR_LITERAL '..' CHAR_LITERAL ;
    public final void range() throws RecognitionException {
        try {
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:65:7: ( CHAR_LITERAL '..' CHAR_LITERAL )
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:65:9: CHAR_LITERAL '..' CHAR_LITERAL
            {
            match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_range108); 
            match(input,16,FOLLOW_16_in_range110); 
            match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_range112); 

            }

        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return ;
    }
    // $ANTLR end "range"


    // $ANTLR start "terminal"
    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:67:1: terminal : ( CHAR_LITERAL | STRING_LITERAL | '.' ) ;
    public final void terminal() throws RecognitionException {
        try {
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:67:13: ( ( CHAR_LITERAL | STRING_LITERAL | '.' ) )
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:67:17: ( CHAR_LITERAL | STRING_LITERAL | '.' )
            {
            if ( (input.LA(1)>=CHAR_LITERAL && input.LA(1)<=STRING_LITERAL)||input.LA(1)==17 ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return ;
    }
    // $ANTLR end "terminal"


    // $ANTLR start "ebnfSuffix"
    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:69:1: ebnfSuffix : ( '?' | '*' | '+' );
    public final void ebnfSuffix() throws RecognitionException {
        try {
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:69:12: ( '?' | '*' | '+' )
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:
            {
            if ( (input.LA(1)>=11 && input.LA(1)<=13) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return ;
    }
    // $ANTLR end "ebnfSuffix"


    // $ANTLR start "block"
    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:71:1: block : '(' alternative ( '|' alternative )* ')' ;
    public final void block() throws RecognitionException {
        try {
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:71:8: ( '(' alternative ( '|' alternative )* ')' )
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:71:12: '(' alternative ( '|' alternative )* ')'
            {
            match(input,18,FOLLOW_18_in_block169); 
            pushFollow(FOLLOW_alternative_in_block171);
            alternative();

            state._fsp--;

            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:71:27: ( '|' alternative )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==10) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:71:29: '|' alternative
            	    {
            	    match(input,10,FOLLOW_10_in_block174); 
            	    pushFollow(FOLLOW_alternative_in_block176);
            	    alternative();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match(input,19,FOLLOW_19_in_block181); 

            }

        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return ;
    }
    // $ANTLR end "block"


    // $ANTLR start "alternative"
    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:73:1: alternative : ( element )* ;
    public final void alternative() throws RecognitionException {
        try {
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:73:13: ( ( element )* )
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:73:15: ( element )*
            {
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:73:15: ( element )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=CHAR_LITERAL && LA4_0<=STRING_LITERAL)||(LA4_0>=17 && LA4_0<=18)||LA4_0==20) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:73:15: element
            	    {
            	    pushFollow(FOLLOW_element_in_alternative190);
            	    element();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return ;
    }
    // $ANTLR end "alternative"


    // $ANTLR start "element"
    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:75:1: element : elementNoOptionSpec ;
    public final void element() throws RecognitionException {
        try {
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:75:9: ( elementNoOptionSpec )
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:75:11: elementNoOptionSpec
            {
            pushFollow(FOLLOW_elementNoOptionSpec_in_element201);
            elementNoOptionSpec();

            state._fsp--;


            }

        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return ;
    }
    // $ANTLR end "element"


    // $ANTLR start "elementNoOptionSpec"
    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:77:1: elementNoOptionSpec : ( atom ( ebnfSuffix )? | ebnf );
    public final void elementNoOptionSpec() throws RecognitionException {
        try {
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:77:21: ( atom ( ebnfSuffix )? | ebnf )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=CHAR_LITERAL && LA6_0<=STRING_LITERAL)||LA6_0==17||LA6_0==20) ) {
                alt6=1;
            }
            else if ( (LA6_0==18) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:77:23: atom ( ebnfSuffix )?
                    {
                    pushFollow(FOLLOW_atom_in_elementNoOptionSpec209);
                    atom();

                    state._fsp--;

                    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:77:29: ( ebnfSuffix )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( ((LA5_0>=11 && LA5_0<=13)) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:77:31: ebnfSuffix
                            {
                            pushFollow(FOLLOW_ebnfSuffix_in_elementNoOptionSpec214);
                            ebnfSuffix();

                            state._fsp--;


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:77:48: ebnf
                    {
                    pushFollow(FOLLOW_ebnf_in_elementNoOptionSpec222);
                    ebnf();

                    state._fsp--;


                    }
                    break;

            }
        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return ;
    }
    // $ANTLR end "elementNoOptionSpec"


    // $ANTLR start "atom"
    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:79:1: atom : ( range | terminal | notSet ) ( '^' | '!' )? ;
    public final void atom() throws RecognitionException {
        try {
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:79:5: ( ( range | terminal | notSet ) ( '^' | '!' )? )
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:79:8: ( range | terminal | notSet ) ( '^' | '!' )?
            {
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:79:8: ( range | terminal | notSet )
            int alt7=3;
            switch ( input.LA(1) ) {
            case CHAR_LITERAL:
                {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==16) ) {
                    alt7=1;
                }
                else if ( (LA7_1==EOF||(LA7_1>=CHAR_LITERAL && LA7_1<=STRING_LITERAL)||(LA7_1>=10 && LA7_1<=15)||(LA7_1>=17 && LA7_1<=20)) ) {
                    alt7=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
                }
                break;
            case STRING_LITERAL:
            case 17:
                {
                alt7=2;
                }
                break;
            case 20:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:79:11: range
                    {
                    pushFollow(FOLLOW_range_in_atom233);
                    range();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:79:23: terminal
                    {
                    pushFollow(FOLLOW_terminal_in_atom241);
                    terminal();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:79:36: notSet
                    {
                    pushFollow(FOLLOW_notSet_in_atom247);
                    notSet();

                    state._fsp--;


                    }
                    break;

            }

            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:79:47: ( '^' | '!' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=14 && LA8_0<=15)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:
                    {
                    if ( (input.LA(1)>=14 && input.LA(1)<=15) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;

            }


            }

        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return ;
    }
    // $ANTLR end "atom"


    // $ANTLR start "notSet"
    // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:81:1: notSet : '~' ( block ) ;
    public final void notSet() throws RecognitionException {
        try {
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:81:7: ( '~' ( block ) )
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:81:9: '~' ( block )
            {
            match(input,20,FOLLOW_20_in_notSet273); 
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:81:14: ( block )
            // ./src/org/emftext/sdk/codegen/regex/ANTLRexp.g:81:16: block
            {
            pushFollow(FOLLOW_block_in_notSet278);
            block();

            state._fsp--;


            }


            }

        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return ;
    }
    // $ANTLR end "notSet"

    // Delegated rules


 

    public static final BitSet FOLLOW_alternative_in_root52 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_10_in_root56 = new BitSet(new long[]{0x0000000000160430L});
    public static final BitSet FOLLOW_alternative_in_root58 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_block_in_ebnf69 = new BitSet(new long[]{0x000000000000F802L});
    public static final BitSet FOLLOW_set_in_ebnf72 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_range108 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_range110 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_range112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_terminal125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_ebnfSuffix0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_block169 = new BitSet(new long[]{0x00000000001E0430L});
    public static final BitSet FOLLOW_alternative_in_block171 = new BitSet(new long[]{0x0000000000080400L});
    public static final BitSet FOLLOW_10_in_block174 = new BitSet(new long[]{0x00000000001E0430L});
    public static final BitSet FOLLOW_alternative_in_block176 = new BitSet(new long[]{0x0000000000080400L});
    public static final BitSet FOLLOW_19_in_block181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_element_in_alternative190 = new BitSet(new long[]{0x0000000000160032L});
    public static final BitSet FOLLOW_elementNoOptionSpec_in_element201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_elementNoOptionSpec209 = new BitSet(new long[]{0x0000000000003802L});
    public static final BitSet FOLLOW_ebnfSuffix_in_elementNoOptionSpec214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ebnf_in_elementNoOptionSpec222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_range_in_atom233 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_terminal_in_atom241 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_notSet_in_atom247 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_set_in_atom253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_notSet273 = new BitSet(new long[]{0x0000000000160030L});
    public static final BitSet FOLLOW_block_in_notSet278 = new BitSet(new long[]{0x0000000000000002L});

}
