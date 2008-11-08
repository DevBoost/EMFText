// $ANTLR 3.0.1 src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g 2008-04-30 20:00:16

package org.reuseware.emftextedit.codegen.regex; 



import org.antlr.runtime.CharStream;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;

public class ANTLRexpLexer extends Lexer {
    public static final int ESC=7;
    public static final int LITERAL_CHAR=6;
    public static final int Tokens=21;
    public static final int EOF=-1;
    public static final int T20=20;
    public static final int STRING_LITERAL=5;
    public static final int WS=9;
    public static final int CHAR_LITERAL=4;
    public static final int XDIGIT=8;
    public static final int T10=10;
    public static final int T11=11;
    public static final int T12=12;
    public static final int T13=13;
    public static final int T14=14;
    public static final int T15=15;
    public static final int T16=16;
    public static final int T17=17;
    public static final int T18=18;
    public static final int T19=19;
    
      public java.util.List<RecognitionException> lexerExceptions  = new java.util.ArrayList<RecognitionException>();
    
      public void reportError(RecognitionException e) {
         lexerExceptions.add(e);
    	}
    	
     

    public ANTLRexpLexer() {;} 
    public ANTLRexpLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g"; }

    // $ANTLR start T10
    public final void mT10() throws RecognitionException {
        try {
            int _type = T10;
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:16:5: ( '|' )
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:16:7: '|'
            {
            match('|'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T10

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:17:5: ( '?' )
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:17:7: '?'
            {
            match('?'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T11

    // $ANTLR start T12
    public final void mT12() throws RecognitionException {
        try {
            int _type = T12;
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:18:5: ( '*' )
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:18:7: '*'
            {
            match('*'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T12

    // $ANTLR start T13
    public final void mT13() throws RecognitionException {
        try {
            int _type = T13;
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:19:5: ( '+' )
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:19:7: '+'
            {
            match('+'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T13

    // $ANTLR start T14
    public final void mT14() throws RecognitionException {
        try {
            int _type = T14;
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:20:5: ( '^' )
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:20:7: '^'
            {
            match('^'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T14

    // $ANTLR start T15
    public final void mT15() throws RecognitionException {
        try {
            int _type = T15;
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:21:5: ( '!' )
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:21:7: '!'
            {
            match('!'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T15

    // $ANTLR start T16
    public final void mT16() throws RecognitionException {
        try {
            int _type = T16;
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:22:5: ( '..' )
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:22:7: '..'
            {
            match(".."); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T16

    // $ANTLR start T17
    public final void mT17() throws RecognitionException {
        try {
            int _type = T17;
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:23:5: ( '.' )
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:23:7: '.'
            {
            match('.'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T17

    // $ANTLR start T18
    public final void mT18() throws RecognitionException {
        try {
            int _type = T18;
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:24:5: ( '(' )
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:24:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T18

    // $ANTLR start T19
    public final void mT19() throws RecognitionException {
        try {
            int _type = T19;
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:25:5: ( ')' )
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:25:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T19

    // $ANTLR start T20
    public final void mT20() throws RecognitionException {
        try {
            int _type = T20;
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:26:5: ( '~' )
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:26:7: '~'
            {
            match('~'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T20

    // $ANTLR start CHAR_LITERAL
    public final void mCHAR_LITERAL() throws RecognitionException {
        try {
            int _type = CHAR_LITERAL;
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:91:14: ( '\\'' LITERAL_CHAR '\\'' )
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:91:16: '\\'' LITERAL_CHAR '\\''
            {
            match('\''); 
            mLITERAL_CHAR(); 
            match('\''); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end CHAR_LITERAL

    // $ANTLR start STRING_LITERAL
    public final void mSTRING_LITERAL() throws RecognitionException {
        try {
            int _type = STRING_LITERAL;
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:93:16: ( '\\'' LITERAL_CHAR ( LITERAL_CHAR )* '\\'' )
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:93:18: '\\'' LITERAL_CHAR ( LITERAL_CHAR )* '\\''
            {
            match('\''); 
            mLITERAL_CHAR(); 
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:93:36: ( LITERAL_CHAR )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='&')||(LA1_0>='(' && LA1_0<='\uFFFE')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:93:36: LITERAL_CHAR
            	    {
            	    mLITERAL_CHAR(); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match('\''); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end STRING_LITERAL

    // $ANTLR start LITERAL_CHAR
    public final void mLITERAL_CHAR() throws RecognitionException {
        try {
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:95:23: ( ESC | ~ ( '\\'' | '\\\\' ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\\') ) {
                alt2=1;
            }
            else if ( ((LA2_0>='\u0000' && LA2_0<='&')||(LA2_0>='(' && LA2_0<='[')||(LA2_0>=']' && LA2_0<='\uFFFE')) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("95:10: fragment LITERAL_CHAR : ( ESC | ~ ( '\\'' | '\\\\' ) );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:95:25: ESC
                    {
                    mESC(); 

                    }
                    break;
                case 2 :
                    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:95:32: ~ ( '\\'' | '\\\\' )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end LITERAL_CHAR

    // $ANTLR start ESC
    public final void mESC() throws RecognitionException {
        try {
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:97:14: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | '>' | 'u' XDIGIT XDIGIT XDIGIT XDIGIT | . ) )
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:97:16: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | '>' | 'u' XDIGIT XDIGIT XDIGIT XDIGIT | . )
            {
            match('\\'); 
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:97:21: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | '>' | 'u' XDIGIT XDIGIT XDIGIT XDIGIT | . )
            int alt3=11;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='n') ) {
                alt3=1;
            }
            else if ( (LA3_0=='r') ) {
                alt3=2;
            }
            else if ( (LA3_0=='t') ) {
                alt3=3;
            }
            else if ( (LA3_0=='b') ) {
                alt3=4;
            }
            else if ( (LA3_0=='f') ) {
                alt3=5;
            }
            else if ( (LA3_0=='\"') ) {
                alt3=6;
            }
            else if ( (LA3_0=='\'') ) {
                alt3=7;
            }
            else if ( (LA3_0=='\\') ) {
                alt3=8;
            }
            else if ( (LA3_0=='>') ) {
                alt3=9;
            }
            else if ( (LA3_0=='u') ) {
                int LA3_10 = input.LA(2);

                if ( ((LA3_10>='0' && LA3_10<='9')||(LA3_10>='A' && LA3_10<='F')||(LA3_10>='a' && LA3_10<='f')) ) {
                    alt3=10;
                }
                else {
                    alt3=11;}
            }
            else if ( ((LA3_0>='\u0000' && LA3_0<='!')||(LA3_0>='#' && LA3_0<='&')||(LA3_0>='(' && LA3_0<='=')||(LA3_0>='?' && LA3_0<='[')||(LA3_0>=']' && LA3_0<='a')||(LA3_0>='c' && LA3_0<='e')||(LA3_0>='g' && LA3_0<='m')||(LA3_0>='o' && LA3_0<='q')||LA3_0=='s'||(LA3_0>='v' && LA3_0<='\uFFFE')) ) {
                alt3=11;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("97:21: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | '>' | 'u' XDIGIT XDIGIT XDIGIT XDIGIT | . )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:97:23: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 2 :
                    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:97:30: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 3 :
                    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:97:37: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 4 :
                    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:97:45: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:97:51: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:97:57: '\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 7 :
                    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:97:62: '\\''
                    {
                    match('\''); 

                    }
                    break;
                case 8 :
                    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:97:69: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 9 :
                    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:97:76: '>'
                    {
                    match('>'); 

                    }
                    break;
                case 10 :
                    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:97:82: 'u' XDIGIT XDIGIT XDIGIT XDIGIT
                    {
                    match('u'); 
                    mXDIGIT(); 
                    mXDIGIT(); 
                    mXDIGIT(); 
                    mXDIGIT(); 

                    }
                    break;
                case 11 :
                    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:97:116: .
                    {
                    matchAny(); 

                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end ESC

    // $ANTLR start XDIGIT
    public final void mXDIGIT() throws RecognitionException {
        try {
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:99:17: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end XDIGIT

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:101:4: ( ( ' ' | '\\t' | ( '\\r' )? '\\n' )+ )
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:101:6: ( ' ' | '\\t' | ( '\\r' )? '\\n' )+
            {
            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:101:6: ( ' ' | '\\t' | ( '\\r' )? '\\n' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=4;
                switch ( input.LA(1) ) {
                case ' ':
                    {
                    alt5=1;
                    }
                    break;
                case '\t':
                    {
                    alt5=2;
                    }
                    break;
                case '\n':
                case '\r':
                    {
                    alt5=3;
                    }
                    break;

                }

                switch (alt5) {
            	case 1 :
            	    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:101:8: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;
            	case 2 :
            	    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:101:14: '\\t'
            	    {
            	    match('\t'); 

            	    }
            	    break;
            	case 3 :
            	    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:101:20: ( '\\r' )? '\\n'
            	    {
            	    // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:101:20: ( '\\r' )?
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0=='\r') ) {
            	        alt4=1;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:101:20: '\\r'
            	            {
            	            match('\r'); 

            	            }
            	            break;

            	    }

            	    match('\n'); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            channel=HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WS

    public void mTokens() throws RecognitionException {
        // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:1:8: ( T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | CHAR_LITERAL | STRING_LITERAL | WS )
        int alt6=14;
        switch ( input.LA(1) ) {
        case '|':
            {
            alt6=1;
            }
            break;
        case '?':
            {
            alt6=2;
            }
            break;
        case '*':
            {
            alt6=3;
            }
            break;
        case '+':
            {
            alt6=4;
            }
            break;
        case '^':
            {
            alt6=5;
            }
            break;
        case '!':
            {
            alt6=6;
            }
            break;
        case '.':
            {
            int LA6_7 = input.LA(2);

            if ( (LA6_7=='.') ) {
                alt6=7;
            }
            else {
                alt6=8;}
            }
            break;
        case '(':
            {
            alt6=9;
            }
            break;
        case ')':
            {
            alt6=10;
            }
            break;
        case '~':
            {
            alt6=11;
            }
            break;
        case '\'':
            {
            int LA6_11 = input.LA(2);

            if ( (LA6_11=='\\') ) {
                int LA6_15 = input.LA(3);

                if ( (LA6_15=='n') ) {
                    int LA6_17 = input.LA(4);

                    if ( (LA6_17=='\'') ) {
                        alt6=12;
                    }
                    else if ( ((LA6_17>='\u0000' && LA6_17<='&')||(LA6_17>='(' && LA6_17<='\uFFFE')) ) {
                        alt6=13;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1:1: Tokens : ( T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | CHAR_LITERAL | STRING_LITERAL | WS );", 6, 17, input);

                        throw nvae;
                    }
                }
                else if ( (LA6_15=='r') ) {
                    int LA6_18 = input.LA(4);

                    if ( ((LA6_18>='\u0000' && LA6_18<='&')||(LA6_18>='(' && LA6_18<='\uFFFE')) ) {
                        alt6=13;
                    }
                    else if ( (LA6_18=='\'') ) {
                        alt6=12;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1:1: Tokens : ( T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | CHAR_LITERAL | STRING_LITERAL | WS );", 6, 18, input);

                        throw nvae;
                    }
                }
                else if ( (LA6_15=='t') ) {
                    int LA6_19 = input.LA(4);

                    if ( ((LA6_19>='\u0000' && LA6_19<='&')||(LA6_19>='(' && LA6_19<='\uFFFE')) ) {
                        alt6=13;
                    }
                    else if ( (LA6_19=='\'') ) {
                        alt6=12;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1:1: Tokens : ( T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | CHAR_LITERAL | STRING_LITERAL | WS );", 6, 19, input);

                        throw nvae;
                    }
                }
                else if ( (LA6_15=='b') ) {
                    int LA6_20 = input.LA(4);

                    if ( ((LA6_20>='\u0000' && LA6_20<='&')||(LA6_20>='(' && LA6_20<='\uFFFE')) ) {
                        alt6=13;
                    }
                    else if ( (LA6_20=='\'') ) {
                        alt6=12;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1:1: Tokens : ( T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | CHAR_LITERAL | STRING_LITERAL | WS );", 6, 20, input);

                        throw nvae;
                    }
                }
                else if ( (LA6_15=='f') ) {
                    int LA6_21 = input.LA(4);

                    if ( (LA6_21=='\'') ) {
                        alt6=12;
                    }
                    else if ( ((LA6_21>='\u0000' && LA6_21<='&')||(LA6_21>='(' && LA6_21<='\uFFFE')) ) {
                        alt6=13;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1:1: Tokens : ( T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | CHAR_LITERAL | STRING_LITERAL | WS );", 6, 21, input);

                        throw nvae;
                    }
                }
                else if ( (LA6_15=='\"') ) {
                    int LA6_22 = input.LA(4);

                    if ( (LA6_22=='\'') ) {
                        alt6=12;
                    }
                    else if ( ((LA6_22>='\u0000' && LA6_22<='&')||(LA6_22>='(' && LA6_22<='\uFFFE')) ) {
                        alt6=13;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1:1: Tokens : ( T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | CHAR_LITERAL | STRING_LITERAL | WS );", 6, 22, input);

                        throw nvae;
                    }
                }
                else if ( (LA6_15=='\'') ) {
                    int LA6_23 = input.LA(4);

                    if ( (LA6_23=='\'') ) {
                        alt6=12;
                    }
                    else if ( ((LA6_23>='\u0000' && LA6_23<='&')||(LA6_23>='(' && LA6_23<='\uFFFE')) ) {
                        alt6=13;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1:1: Tokens : ( T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | CHAR_LITERAL | STRING_LITERAL | WS );", 6, 23, input);

                        throw nvae;
                    }
                }
                else if ( (LA6_15=='\\') ) {
                    int LA6_24 = input.LA(4);

                    if ( (LA6_24=='\'') ) {
                        alt6=12;
                    }
                    else if ( ((LA6_24>='\u0000' && LA6_24<='&')||(LA6_24>='(' && LA6_24<='\uFFFE')) ) {
                        alt6=13;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1:1: Tokens : ( T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | CHAR_LITERAL | STRING_LITERAL | WS );", 6, 24, input);

                        throw nvae;
                    }
                }
                else if ( (LA6_15=='>') ) {
                    int LA6_25 = input.LA(4);

                    if ( (LA6_25=='\'') ) {
                        alt6=12;
                    }
                    else if ( ((LA6_25>='\u0000' && LA6_25<='&')||(LA6_25>='(' && LA6_25<='\uFFFE')) ) {
                        alt6=13;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1:1: Tokens : ( T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | CHAR_LITERAL | STRING_LITERAL | WS );", 6, 25, input);

                        throw nvae;
                    }
                }
                else if ( (LA6_15=='u') ) {
                    int LA6_26 = input.LA(4);

                    if ( ((LA6_26>='0' && LA6_26<='9')||(LA6_26>='A' && LA6_26<='F')||(LA6_26>='a' && LA6_26<='f')) ) {
                        int LA6_30 = input.LA(5);

                        if ( ((LA6_30>='0' && LA6_30<='9')||(LA6_30>='A' && LA6_30<='F')||(LA6_30>='a' && LA6_30<='f')) ) {
                            int LA6_32 = input.LA(6);

                            if ( ((LA6_32>='0' && LA6_32<='9')||(LA6_32>='A' && LA6_32<='F')||(LA6_32>='a' && LA6_32<='f')) ) {
                                int LA6_33 = input.LA(7);

                                if ( ((LA6_33>='0' && LA6_33<='9')||(LA6_33>='A' && LA6_33<='F')||(LA6_33>='a' && LA6_33<='f')) ) {
                                    int LA6_34 = input.LA(8);

                                    if ( (LA6_34=='\'') ) {
                                        alt6=12;
                                    }
                                    else if ( ((LA6_34>='\u0000' && LA6_34<='&')||(LA6_34>='(' && LA6_34<='\uFFFE')) ) {
                                        alt6=13;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("1:1: Tokens : ( T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | CHAR_LITERAL | STRING_LITERAL | WS );", 6, 34, input);

                                        throw nvae;
                                    }
                                }
                                else if ( ((LA6_33>='\u0000' && LA6_33<='/')||(LA6_33>=':' && LA6_33<='@')||(LA6_33>='G' && LA6_33<='`')||(LA6_33>='g' && LA6_33<='\uFFFE')) ) {
                                    alt6=13;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("1:1: Tokens : ( T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | CHAR_LITERAL | STRING_LITERAL | WS );", 6, 33, input);

                                    throw nvae;
                                }
                            }
                            else if ( ((LA6_32>='\u0000' && LA6_32<='/')||(LA6_32>=':' && LA6_32<='@')||(LA6_32>='G' && LA6_32<='`')||(LA6_32>='g' && LA6_32<='\uFFFE')) ) {
                                alt6=13;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1:1: Tokens : ( T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | CHAR_LITERAL | STRING_LITERAL | WS );", 6, 32, input);

                                throw nvae;
                            }
                        }
                        else if ( ((LA6_30>='\u0000' && LA6_30<='/')||(LA6_30>=':' && LA6_30<='@')||(LA6_30>='G' && LA6_30<='`')||(LA6_30>='g' && LA6_30<='\uFFFE')) ) {
                            alt6=13;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("1:1: Tokens : ( T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | CHAR_LITERAL | STRING_LITERAL | WS );", 6, 30, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA6_26=='\'') ) {
                        alt6=12;
                    }
                    else if ( ((LA6_26>='\u0000' && LA6_26<='&')||(LA6_26>='(' && LA6_26<='/')||(LA6_26>=':' && LA6_26<='@')||(LA6_26>='G' && LA6_26<='`')||(LA6_26>='g' && LA6_26<='\uFFFE')) ) {
                        alt6=13;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1:1: Tokens : ( T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | CHAR_LITERAL | STRING_LITERAL | WS );", 6, 26, input);

                        throw nvae;
                    }
                }
                else if ( ((LA6_15>='\u0000' && LA6_15<='!')||(LA6_15>='#' && LA6_15<='&')||(LA6_15>='(' && LA6_15<='=')||(LA6_15>='?' && LA6_15<='[')||(LA6_15>=']' && LA6_15<='a')||(LA6_15>='c' && LA6_15<='e')||(LA6_15>='g' && LA6_15<='m')||(LA6_15>='o' && LA6_15<='q')||LA6_15=='s'||(LA6_15>='v' && LA6_15<='\uFFFE')) ) {
                    int LA6_27 = input.LA(4);

                    if ( (LA6_27=='\'') ) {
                        alt6=12;
                    }
                    else if ( ((LA6_27>='\u0000' && LA6_27<='&')||(LA6_27>='(' && LA6_27<='\uFFFE')) ) {
                        alt6=13;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1:1: Tokens : ( T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | CHAR_LITERAL | STRING_LITERAL | WS );", 6, 27, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1:1: Tokens : ( T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | CHAR_LITERAL | STRING_LITERAL | WS );", 6, 15, input);

                    throw nvae;
                }
            }
            else if ( ((LA6_11>='\u0000' && LA6_11<='&')||(LA6_11>='(' && LA6_11<='[')||(LA6_11>=']' && LA6_11<='\uFFFE')) ) {
                int LA6_16 = input.LA(3);

                if ( ((LA6_16>='\u0000' && LA6_16<='&')||(LA6_16>='(' && LA6_16<='\uFFFE')) ) {
                    alt6=13;
                }
                else if ( (LA6_16=='\'') ) {
                    alt6=12;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1:1: Tokens : ( T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | CHAR_LITERAL | STRING_LITERAL | WS );", 6, 16, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1:1: Tokens : ( T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | CHAR_LITERAL | STRING_LITERAL | WS );", 6, 11, input);

                throw nvae;
            }
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt6=14;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | CHAR_LITERAL | STRING_LITERAL | WS );", 6, 0, input);

            throw nvae;
        }

        switch (alt6) {
            case 1 :
                // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:1:10: T10
                {
                mT10(); 

                }
                break;
            case 2 :
                // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:1:14: T11
                {
                mT11(); 

                }
                break;
            case 3 :
                // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:1:18: T12
                {
                mT12(); 

                }
                break;
            case 4 :
                // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:1:22: T13
                {
                mT13(); 

                }
                break;
            case 5 :
                // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:1:26: T14
                {
                mT14(); 

                }
                break;
            case 6 :
                // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:1:30: T15
                {
                mT15(); 

                }
                break;
            case 7 :
                // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:1:34: T16
                {
                mT16(); 

                }
                break;
            case 8 :
                // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:1:38: T17
                {
                mT17(); 

                }
                break;
            case 9 :
                // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:1:42: T18
                {
                mT18(); 

                }
                break;
            case 10 :
                // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:1:46: T19
                {
                mT19(); 

                }
                break;
            case 11 :
                // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:1:50: T20
                {
                mT20(); 

                }
                break;
            case 12 :
                // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:1:54: CHAR_LITERAL
                {
                mCHAR_LITERAL(); 

                }
                break;
            case 13 :
                // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:1:67: STRING_LITERAL
                {
                mSTRING_LITERAL(); 

                }
                break;
            case 14 :
                // src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g:1:82: WS
                {
                mWS(); 

                }
                break;

        }

    }


 

}