// $ANTLR 3.0.1 src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g 2008-04-30 20:00:16

package org.reuseware.emftextedit.sdk.codegen.regex; 


import org.antlr.runtime.BitSet;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

/** ANTLR pure ebnf/regex grammar extracted from ANTLRv3 grammar.
Needs to be further testing since antlr uses the same sublanguage for ebnf and regex!*/
public class ANTLRexpParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CHAR_LITERAL", "STRING_LITERAL", "LITERAL_CHAR", "ESC", "XDIGIT", "WS", "'|'", "'?'", "'*'", "'+'", "'^'", "'!'", "'..'", "'.'", "'('", "')'", "'~'"
    };
    public static final int WS=9;
    public static final int STRING_LITERAL=5;
    public static final int CHAR_LITERAL=4;
    public static final int ESC=7;
    public static final int XDIGIT=8;
    public static final int LITERAL_CHAR=6;
    public static final int EOF=-1;

        public ANTLRexpParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g"; }

    
     public java.util.List<RecognitionException> recExceptions = ((ANTLRexpLexer)getTokenStream().getTokenSource()).lexerExceptions;
    
    public void recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow)
      throws RecognitionException
    {
    }
    



    // $ANTLR start root
    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:65:1: root : alternative ( '|' alternative )* ;
    public final void root() throws RecognitionException {
        try {
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:66:6: ( alternative ( '|' alternative )* )
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:66:8: alternative ( '|' alternative )*
            {
            pushFollow(FOLLOW_alternative_in_root52);
            alternative();
            _fsp--;

            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:66:20: ( '|' alternative )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==10) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:66:22: '|' alternative
            	    {
            	    match(input,10,FOLLOW_10_in_root56); 
            	    pushFollow(FOLLOW_alternative_in_root58);
            	    alternative();
            	    _fsp--;


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
    // $ANTLR end root


    // $ANTLR start ebnf
    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:68:1: ebnf : block ( '?' | '*' | '+' | '^' | '!' )? ;
    public final void ebnf() throws RecognitionException {
        try {
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:68:6: ( block ( '?' | '*' | '+' | '^' | '!' )? )
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:68:8: block ( '?' | '*' | '+' | '^' | '!' )?
            {
            pushFollow(FOLLOW_block_in_ebnf69);
            block();
            _fsp--;

            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:68:15: ( '?' | '*' | '+' | '^' | '!' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=11 && LA2_0<=15)) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:
                    {
                    if ( (input.LA(1)>=11 && input.LA(1)<=15) ) {
                        input.consume();
                        errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_ebnf72);    throw mse;
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
    // $ANTLR end ebnf


    // $ANTLR start range
    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:70:1: range : CHAR_LITERAL '..' CHAR_LITERAL ;
    public final void range() throws RecognitionException {
        try {
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:70:7: ( CHAR_LITERAL '..' CHAR_LITERAL )
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:70:9: CHAR_LITERAL '..' CHAR_LITERAL
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
    // $ANTLR end range


    // $ANTLR start terminal
    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:72:1: terminal : ( CHAR_LITERAL | STRING_LITERAL | '.' ) ;
    public final void terminal() throws RecognitionException {
        try {
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:72:13: ( ( CHAR_LITERAL | STRING_LITERAL | '.' ) )
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:72:17: ( CHAR_LITERAL | STRING_LITERAL | '.' )
            {
            if ( (input.LA(1)>=CHAR_LITERAL && input.LA(1)<=STRING_LITERAL)||input.LA(1)==17 ) {
                input.consume();
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_terminal125);    throw mse;
            }


            }

        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return ;
    }
    // $ANTLR end terminal


    // $ANTLR start ebnfSuffix
    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:74:1: ebnfSuffix : ( '?' | '*' | '+' );
    public final void ebnfSuffix() throws RecognitionException {
        try {
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:74:12: ( '?' | '*' | '+' )
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:
            {
            if ( (input.LA(1)>=11 && input.LA(1)<=13) ) {
                input.consume();
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_ebnfSuffix0);    throw mse;
            }


            }

        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return ;
    }
    // $ANTLR end ebnfSuffix


    // $ANTLR start block
    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:76:1: block : '(' alternative ( '|' alternative )* ')' ;
    public final void block() throws RecognitionException {
        try {
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:76:8: ( '(' alternative ( '|' alternative )* ')' )
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:76:12: '(' alternative ( '|' alternative )* ')'
            {
            match(input,18,FOLLOW_18_in_block169); 
            pushFollow(FOLLOW_alternative_in_block171);
            alternative();
            _fsp--;

            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:76:27: ( '|' alternative )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==10) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:76:29: '|' alternative
            	    {
            	    match(input,10,FOLLOW_10_in_block174); 
            	    pushFollow(FOLLOW_alternative_in_block176);
            	    alternative();
            	    _fsp--;


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
    // $ANTLR end block


    // $ANTLR start alternative
    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:78:1: alternative : ( element )* ;
    public final void alternative() throws RecognitionException {
        try {
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:78:13: ( ( element )* )
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:78:15: ( element )*
            {
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:78:15: ( element )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=CHAR_LITERAL && LA4_0<=STRING_LITERAL)||(LA4_0>=17 && LA4_0<=18)||LA4_0==20) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:78:15: element
            	    {
            	    pushFollow(FOLLOW_element_in_alternative190);
            	    element();
            	    _fsp--;


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
    // $ANTLR end alternative


    // $ANTLR start element
    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:80:1: element : elementNoOptionSpec ;
    public final void element() throws RecognitionException {
        try {
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:80:9: ( elementNoOptionSpec )
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:80:11: elementNoOptionSpec
            {
            pushFollow(FOLLOW_elementNoOptionSpec_in_element201);
            elementNoOptionSpec();
            _fsp--;


            }

        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return ;
    }
    // $ANTLR end element


    // $ANTLR start elementNoOptionSpec
    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:82:1: elementNoOptionSpec : ( atom ( ebnfSuffix )? | ebnf );
    public final void elementNoOptionSpec() throws RecognitionException {
        try {
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:82:21: ( atom ( ebnfSuffix )? | ebnf )
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
                    new NoViableAltException("82:1: elementNoOptionSpec : ( atom ( ebnfSuffix )? | ebnf );", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:82:23: atom ( ebnfSuffix )?
                    {
                    pushFollow(FOLLOW_atom_in_elementNoOptionSpec209);
                    atom();
                    _fsp--;

                    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:82:29: ( ebnfSuffix )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( ((LA5_0>=11 && LA5_0<=13)) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:82:31: ebnfSuffix
                            {
                            pushFollow(FOLLOW_ebnfSuffix_in_elementNoOptionSpec214);
                            ebnfSuffix();
                            _fsp--;


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:82:48: ebnf
                    {
                    pushFollow(FOLLOW_ebnf_in_elementNoOptionSpec222);
                    ebnf();
                    _fsp--;


                    }
                    break;

            }
        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return ;
    }
    // $ANTLR end elementNoOptionSpec


    // $ANTLR start atom
    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:84:1: atom : ( range | terminal | notSet ) ( '^' | '!' )? ;
    public final void atom() throws RecognitionException {
        try {
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:84:5: ( ( range | terminal | notSet ) ( '^' | '!' )? )
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:84:8: ( range | terminal | notSet ) ( '^' | '!' )?
            {
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:84:8: ( range | terminal | notSet )
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
                        new NoViableAltException("84:8: ( range | terminal | notSet )", 7, 1, input);

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
                    new NoViableAltException("84:8: ( range | terminal | notSet )", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:84:11: range
                    {
                    pushFollow(FOLLOW_range_in_atom233);
                    range();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:84:23: terminal
                    {
                    pushFollow(FOLLOW_terminal_in_atom241);
                    terminal();
                    _fsp--;


                    }
                    break;
                case 3 :
                    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:84:36: notSet
                    {
                    pushFollow(FOLLOW_notSet_in_atom247);
                    notSet();
                    _fsp--;


                    }
                    break;

            }

            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:84:47: ( '^' | '!' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=14 && LA8_0<=15)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:
                    {
                    if ( (input.LA(1)>=14 && input.LA(1)<=15) ) {
                        input.consume();
                        errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_atom253);    throw mse;
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
    // $ANTLR end atom


    // $ANTLR start notSet
    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:86:1: notSet : '~' ( block ) ;
    public final void notSet() throws RecognitionException {
        try {
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:86:7: ( '~' ( block ) )
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:86:9: '~' ( block )
            {
            match(input,20,FOLLOW_20_in_notSet273); 
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:86:14: ( block )
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:86:16: block
            {
            pushFollow(FOLLOW_block_in_notSet278);
            block();
            _fsp--;


            }


            }

        }
         catch (RecognitionException e) { recExceptions.add(e); }     finally {
        }
        return ;
    }
    // $ANTLR end notSet


 

    public static final BitSet FOLLOW_alternative_in_root52 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_10_in_root56 = new BitSet(new long[]{0x0000000000160432L});
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
    public static final BitSet FOLLOW_20_in_notSet273 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_block_in_notSet278 = new BitSet(new long[]{0x0000000000000002L});

}