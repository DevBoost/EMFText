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



import org.antlr.runtime3_3_0.*;

public class ANTLRexpLexer extends Lexer {
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

      public java.util.List<RecognitionException> lexerExceptions  = new java.util.ArrayList<RecognitionException>();

      public void reportError(RecognitionException e) {
         lexerExceptions.add(e);
    	}
    	
     


    // delegates
    // delegators

    public ANTLRexpLexer() {;} 
    public ANTLRexpLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public ANTLRexpLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "ANTLRexp.g"; }

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRexp.g:17:7: ( '|' )
            // ANTLRexp.g:17:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRexp.g:18:7: ( '?' )
            // ANTLRexp.g:18:9: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRexp.g:19:7: ( '*' )
            // ANTLRexp.g:19:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRexp.g:20:7: ( '+' )
            // ANTLRexp.g:20:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRexp.g:21:7: ( '^' )
            // ANTLRexp.g:21:9: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRexp.g:22:7: ( '!' )
            // ANTLRexp.g:22:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRexp.g:23:7: ( '..' )
            // ANTLRexp.g:23:9: '..'
            {
            match(".."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRexp.g:24:7: ( '.' )
            // ANTLRexp.g:24:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRexp.g:25:7: ( '(' )
            // ANTLRexp.g:25:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRexp.g:26:7: ( ')' )
            // ANTLRexp.g:26:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRexp.g:27:7: ( '~' )
            // ANTLRexp.g:27:9: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "CHAR_LITERAL"
    public final void mCHAR_LITERAL() throws RecognitionException {
        try {
            int _type = CHAR_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRexp.g:258:14: ( '\\'' LITERAL_CHAR '\\'' )
            // ANTLRexp.g:258:16: '\\'' LITERAL_CHAR '\\''
            {
            match('\''); 
            mLITERAL_CHAR(); 
            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CHAR_LITERAL"

    // $ANTLR start "STRING_LITERAL"
    public final void mSTRING_LITERAL() throws RecognitionException {
        try {
            int _type = STRING_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRexp.g:260:16: ( '\\'' LITERAL_CHAR ( LITERAL_CHAR )* '\\'' )
            // ANTLRexp.g:260:18: '\\'' LITERAL_CHAR ( LITERAL_CHAR )* '\\''
            {
            match('\''); 
            mLITERAL_CHAR(); 
            // ANTLRexp.g:260:36: ( LITERAL_CHAR )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='&')||(LA1_0>='(' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ANTLRexp.g:260:36: LITERAL_CHAR
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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING_LITERAL"

    // $ANTLR start "LITERAL_CHAR"
    public final void mLITERAL_CHAR() throws RecognitionException {
        try {
            // ANTLRexp.g:262:23: ( ESC | ~ ( '\\'' | '\\\\' ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\\') ) {
                alt2=1;
            }
            else if ( ((LA2_0>='\u0000' && LA2_0<='&')||(LA2_0>='(' && LA2_0<='[')||(LA2_0>=']' && LA2_0<='\uFFFF')) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ANTLRexp.g:262:25: ESC
                    {
                    mESC(); 

                    }
                    break;
                case 2 :
                    // ANTLRexp.g:262:32: ~ ( '\\'' | '\\\\' )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "LITERAL_CHAR"

    // $ANTLR start "ESC"
    public final void mESC() throws RecognitionException {
        try {
            // ANTLRexp.g:264:14: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | '>' | 'u' XDIGIT XDIGIT XDIGIT XDIGIT | . ) )
            // ANTLRexp.g:264:16: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | '>' | 'u' XDIGIT XDIGIT XDIGIT XDIGIT | . )
            {
            match('\\'); 
            // ANTLRexp.g:264:21: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | '>' | 'u' XDIGIT XDIGIT XDIGIT XDIGIT | . )
            int alt3=11;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // ANTLRexp.g:264:23: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 2 :
                    // ANTLRexp.g:264:30: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 3 :
                    // ANTLRexp.g:264:37: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 4 :
                    // ANTLRexp.g:264:45: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // ANTLRexp.g:264:51: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // ANTLRexp.g:264:57: '\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 7 :
                    // ANTLRexp.g:264:62: '\\''
                    {
                    match('\''); 

                    }
                    break;
                case 8 :
                    // ANTLRexp.g:264:69: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 9 :
                    // ANTLRexp.g:264:76: '>'
                    {
                    match('>'); 

                    }
                    break;
                case 10 :
                    // ANTLRexp.g:264:82: 'u' XDIGIT XDIGIT XDIGIT XDIGIT
                    {
                    match('u'); 
                    mXDIGIT(); 
                    mXDIGIT(); 
                    mXDIGIT(); 
                    mXDIGIT(); 

                    }
                    break;
                case 11 :
                    // ANTLRexp.g:264:116: .
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
    // $ANTLR end "ESC"

    // $ANTLR start "XDIGIT"
    public final void mXDIGIT() throws RecognitionException {
        try {
            // ANTLRexp.g:266:17: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            // ANTLRexp.g:
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "XDIGIT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRexp.g:268:4: ( ( ' ' | '\\t' | ( '\\r' )? '\\n' )+ )
            // ANTLRexp.g:268:6: ( ' ' | '\\t' | ( '\\r' )? '\\n' )+
            {
            // ANTLRexp.g:268:6: ( ' ' | '\\t' | ( '\\r' )? '\\n' )+
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
            	    // ANTLRexp.g:268:8: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;
            	case 2 :
            	    // ANTLRexp.g:268:14: '\\t'
            	    {
            	    match('\t'); 

            	    }
            	    break;
            	case 3 :
            	    // ANTLRexp.g:268:20: ( '\\r' )? '\\n'
            	    {
            	    // ANTLRexp.g:268:20: ( '\\r' )?
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0=='\r') ) {
            	        alt4=1;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // ANTLRexp.g:268:20: '\\r'
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

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // ANTLRexp.g:1:8: ( T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | CHAR_LITERAL | STRING_LITERAL | WS )
        int alt6=14;
        alt6 = dfa6.predict(input);
        switch (alt6) {
            case 1 :
                // ANTLRexp.g:1:10: T__10
                {
                mT__10(); 

                }
                break;
            case 2 :
                // ANTLRexp.g:1:16: T__11
                {
                mT__11(); 

                }
                break;
            case 3 :
                // ANTLRexp.g:1:22: T__12
                {
                mT__12(); 

                }
                break;
            case 4 :
                // ANTLRexp.g:1:28: T__13
                {
                mT__13(); 

                }
                break;
            case 5 :
                // ANTLRexp.g:1:34: T__14
                {
                mT__14(); 

                }
                break;
            case 6 :
                // ANTLRexp.g:1:40: T__15
                {
                mT__15(); 

                }
                break;
            case 7 :
                // ANTLRexp.g:1:46: T__16
                {
                mT__16(); 

                }
                break;
            case 8 :
                // ANTLRexp.g:1:52: T__17
                {
                mT__17(); 

                }
                break;
            case 9 :
                // ANTLRexp.g:1:58: T__18
                {
                mT__18(); 

                }
                break;
            case 10 :
                // ANTLRexp.g:1:64: T__19
                {
                mT__19(); 

                }
                break;
            case 11 :
                // ANTLRexp.g:1:70: T__20
                {
                mT__20(); 

                }
                break;
            case 12 :
                // ANTLRexp.g:1:76: CHAR_LITERAL
                {
                mCHAR_LITERAL(); 

                }
                break;
            case 13 :
                // ANTLRexp.g:1:89: STRING_LITERAL
                {
                mSTRING_LITERAL(); 

                }
                break;
            case 14 :
                // ANTLRexp.g:1:104: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA3_eotS =
        "\12\uffff\1\13\2\uffff";
    static final String DFA3_eofS =
        "\15\uffff";
    static final String DFA3_minS =
        "\1\0\11\uffff\1\60\2\uffff";
    static final String DFA3_maxS =
        "\1\uffff\11\uffff\1\146\2\uffff";
    static final String DFA3_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\uffff\1\13\1\12";
    static final String DFA3_specialS =
        "\1\0\14\uffff}>";
    static final String[] DFA3_transitionS = {
            "\42\13\1\6\4\13\1\7\26\13\1\11\35\13\1\10\5\13\1\4\3\13\1\5"+
            "\7\13\1\1\3\13\1\2\1\13\1\3\1\12\uff8a\13",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\14\7\uffff\6\14\32\uffff\6\14",
            "",
            ""
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
            return "264:21: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | '>' | 'u' XDIGIT XDIGIT XDIGIT XDIGIT | . )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA3_0 = input.LA(1);

                        s = -1;
                        if ( (LA3_0=='n') ) {s = 1;}

                        else if ( (LA3_0=='r') ) {s = 2;}

                        else if ( (LA3_0=='t') ) {s = 3;}

                        else if ( (LA3_0=='b') ) {s = 4;}

                        else if ( (LA3_0=='f') ) {s = 5;}

                        else if ( (LA3_0=='\"') ) {s = 6;}

                        else if ( (LA3_0=='\'') ) {s = 7;}

                        else if ( (LA3_0=='\\') ) {s = 8;}

                        else if ( (LA3_0=='>') ) {s = 9;}

                        else if ( (LA3_0=='u') ) {s = 10;}

                        else if ( ((LA3_0>='\u0000' && LA3_0<='!')||(LA3_0>='#' && LA3_0<='&')||(LA3_0>='(' && LA3_0<='=')||(LA3_0>='?' && LA3_0<='[')||(LA3_0>=']' && LA3_0<='a')||(LA3_0>='c' && LA3_0<='e')||(LA3_0>='g' && LA3_0<='m')||(LA3_0>='o' && LA3_0<='q')||LA3_0=='s'||(LA3_0>='v' && LA3_0<='\uFFFF')) ) {s = 11;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 3, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA6_eotS =
        "\7\uffff\1\16\33\uffff";
    static final String DFA6_eofS =
        "\43\uffff";
    static final String DFA6_minS =
        "\1\11\6\uffff\1\56\3\uffff\1\0\3\uffff\15\0\2\uffff\1\0\1\uffff"+
        "\3\0";
    static final String DFA6_maxS =
        "\1\176\6\uffff\1\56\3\uffff\1\uffff\3\uffff\15\uffff\2\uffff\1\uffff"+
        "\1\uffff\3\uffff";
    static final String DFA6_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\11\1\12\1\13\1\uffff"+
        "\1\16\1\7\1\10\15\uffff\1\14\1\15\1\uffff\1\14\3\uffff";
    static final String DFA6_specialS =
        "\13\uffff\1\12\3\uffff\1\7\1\11\1\14\1\16\1\15\1\21\1\17\1\3\1\1"+
        "\1\6\1\4\1\20\1\10\2\uffff\1\5\1\uffff\1\0\1\2\1\13}>";
    static final String[] DFA6_transitionS = {
            "\2\14\2\uffff\1\14\22\uffff\1\14\1\6\5\uffff\1\13\1\10\1\11"+
            "\1\3\1\4\2\uffff\1\7\20\uffff\1\2\36\uffff\1\5\35\uffff\1\1"+
            "\1\uffff\1\12",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\15",
            "",
            "",
            "",
            "\47\20\1\uffff\64\20\1\17\uffa3\20",
            "",
            "",
            "",
            "\42\33\1\26\4\33\1\27\26\33\1\31\35\33\1\30\5\33\1\24\3\33"+
            "\1\25\7\33\1\21\3\33\1\22\1\33\1\23\1\32\uff8a\33",
            "\47\35\1\34\uffd8\35",
            "\47\35\1\34\uffd8\35",
            "\47\35\1\34\uffd8\35",
            "\47\35\1\34\uffd8\35",
            "\47\35\1\34\uffd8\35",
            "\47\35\1\34\uffd8\35",
            "\47\35\1\34\uffd8\35",
            "\47\35\1\34\uffd8\35",
            "\47\35\1\34\uffd8\35",
            "\47\35\1\34\uffd8\35",
            "\47\35\1\34\10\35\12\36\7\35\6\36\32\35\6\36\uff99\35",
            "\47\35\1\34\uffd8\35",
            "",
            "",
            "\60\35\12\40\7\35\6\40\32\35\6\40\uff99\35",
            "",
            "\60\35\12\41\7\35\6\41\32\35\6\41\uff99\35",
            "\60\35\12\42\7\35\6\42\32\35\6\42\uff99\35",
            "\47\35\1\34\uffd8\35"
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | CHAR_LITERAL | STRING_LITERAL | WS );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA6_32 = input.LA(1);

                        s = -1;
                        if ( ((LA6_32>='0' && LA6_32<='9')||(LA6_32>='A' && LA6_32<='F')||(LA6_32>='a' && LA6_32<='f')) ) {s = 33;}

                        else if ( ((LA6_32>='\u0000' && LA6_32<='/')||(LA6_32>=':' && LA6_32<='@')||(LA6_32>='G' && LA6_32<='`')||(LA6_32>='g' && LA6_32<='\uFFFF')) ) {s = 29;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA6_23 = input.LA(1);

                        s = -1;
                        if ( (LA6_23=='\'') ) {s = 28;}

                        else if ( ((LA6_23>='\u0000' && LA6_23<='&')||(LA6_23>='(' && LA6_23<='\uFFFF')) ) {s = 29;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA6_33 = input.LA(1);

                        s = -1;
                        if ( ((LA6_33>='0' && LA6_33<='9')||(LA6_33>='A' && LA6_33<='F')||(LA6_33>='a' && LA6_33<='f')) ) {s = 34;}

                        else if ( ((LA6_33>='\u0000' && LA6_33<='/')||(LA6_33>=':' && LA6_33<='@')||(LA6_33>='G' && LA6_33<='`')||(LA6_33>='g' && LA6_33<='\uFFFF')) ) {s = 29;}

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA6_22 = input.LA(1);

                        s = -1;
                        if ( (LA6_22=='\'') ) {s = 28;}

                        else if ( ((LA6_22>='\u0000' && LA6_22<='&')||(LA6_22>='(' && LA6_22<='\uFFFF')) ) {s = 29;}

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA6_25 = input.LA(1);

                        s = -1;
                        if ( (LA6_25=='\'') ) {s = 28;}

                        else if ( ((LA6_25>='\u0000' && LA6_25<='&')||(LA6_25>='(' && LA6_25<='\uFFFF')) ) {s = 29;}

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA6_30 = input.LA(1);

                        s = -1;
                        if ( ((LA6_30>='0' && LA6_30<='9')||(LA6_30>='A' && LA6_30<='F')||(LA6_30>='a' && LA6_30<='f')) ) {s = 32;}

                        else if ( ((LA6_30>='\u0000' && LA6_30<='/')||(LA6_30>=':' && LA6_30<='@')||(LA6_30>='G' && LA6_30<='`')||(LA6_30>='g' && LA6_30<='\uFFFF')) ) {s = 29;}

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA6_24 = input.LA(1);

                        s = -1;
                        if ( (LA6_24=='\'') ) {s = 28;}

                        else if ( ((LA6_24>='\u0000' && LA6_24<='&')||(LA6_24>='(' && LA6_24<='\uFFFF')) ) {s = 29;}

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA6_15 = input.LA(1);

                        s = -1;
                        if ( (LA6_15=='n') ) {s = 17;}

                        else if ( (LA6_15=='r') ) {s = 18;}

                        else if ( (LA6_15=='t') ) {s = 19;}

                        else if ( (LA6_15=='b') ) {s = 20;}

                        else if ( (LA6_15=='f') ) {s = 21;}

                        else if ( (LA6_15=='\"') ) {s = 22;}

                        else if ( (LA6_15=='\'') ) {s = 23;}

                        else if ( (LA6_15=='\\') ) {s = 24;}

                        else if ( (LA6_15=='>') ) {s = 25;}

                        else if ( (LA6_15=='u') ) {s = 26;}

                        else if ( ((LA6_15>='\u0000' && LA6_15<='!')||(LA6_15>='#' && LA6_15<='&')||(LA6_15>='(' && LA6_15<='=')||(LA6_15>='?' && LA6_15<='[')||(LA6_15>=']' && LA6_15<='a')||(LA6_15>='c' && LA6_15<='e')||(LA6_15>='g' && LA6_15<='m')||(LA6_15>='o' && LA6_15<='q')||LA6_15=='s'||(LA6_15>='v' && LA6_15<='\uFFFF')) ) {s = 27;}

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA6_27 = input.LA(1);

                        s = -1;
                        if ( (LA6_27=='\'') ) {s = 28;}

                        else if ( ((LA6_27>='\u0000' && LA6_27<='&')||(LA6_27>='(' && LA6_27<='\uFFFF')) ) {s = 29;}

                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA6_16 = input.LA(1);

                        s = -1;
                        if ( (LA6_16=='\'') ) {s = 28;}

                        else if ( ((LA6_16>='\u0000' && LA6_16<='&')||(LA6_16>='(' && LA6_16<='\uFFFF')) ) {s = 29;}

                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA6_11 = input.LA(1);

                        s = -1;
                        if ( (LA6_11=='\\') ) {s = 15;}

                        else if ( ((LA6_11>='\u0000' && LA6_11<='&')||(LA6_11>='(' && LA6_11<='[')||(LA6_11>=']' && LA6_11<='\uFFFF')) ) {s = 16;}

                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA6_34 = input.LA(1);

                        s = -1;
                        if ( (LA6_34=='\'') ) {s = 28;}

                        else if ( ((LA6_34>='\u0000' && LA6_34<='&')||(LA6_34>='(' && LA6_34<='\uFFFF')) ) {s = 29;}

                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA6_17 = input.LA(1);

                        s = -1;
                        if ( (LA6_17=='\'') ) {s = 28;}

                        else if ( ((LA6_17>='\u0000' && LA6_17<='&')||(LA6_17>='(' && LA6_17<='\uFFFF')) ) {s = 29;}

                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA6_19 = input.LA(1);

                        s = -1;
                        if ( (LA6_19=='\'') ) {s = 28;}

                        else if ( ((LA6_19>='\u0000' && LA6_19<='&')||(LA6_19>='(' && LA6_19<='\uFFFF')) ) {s = 29;}

                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA6_18 = input.LA(1);

                        s = -1;
                        if ( (LA6_18=='\'') ) {s = 28;}

                        else if ( ((LA6_18>='\u0000' && LA6_18<='&')||(LA6_18>='(' && LA6_18<='\uFFFF')) ) {s = 29;}

                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA6_21 = input.LA(1);

                        s = -1;
                        if ( (LA6_21=='\'') ) {s = 28;}

                        else if ( ((LA6_21>='\u0000' && LA6_21<='&')||(LA6_21>='(' && LA6_21<='\uFFFF')) ) {s = 29;}

                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA6_26 = input.LA(1);

                        s = -1;
                        if ( ((LA6_26>='0' && LA6_26<='9')||(LA6_26>='A' && LA6_26<='F')||(LA6_26>='a' && LA6_26<='f')) ) {s = 30;}

                        else if ( (LA6_26=='\'') ) {s = 28;}

                        else if ( ((LA6_26>='\u0000' && LA6_26<='&')||(LA6_26>='(' && LA6_26<='/')||(LA6_26>=':' && LA6_26<='@')||(LA6_26>='G' && LA6_26<='`')||(LA6_26>='g' && LA6_26<='\uFFFF')) ) {s = 29;}

                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA6_20 = input.LA(1);

                        s = -1;
                        if ( (LA6_20=='\'') ) {s = 28;}

                        else if ( ((LA6_20>='\u0000' && LA6_20<='&')||(LA6_20>='(' && LA6_20<='\uFFFF')) ) {s = 29;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 6, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}
