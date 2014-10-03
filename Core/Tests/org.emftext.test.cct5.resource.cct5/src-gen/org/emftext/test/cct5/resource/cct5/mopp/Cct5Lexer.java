// $ANTLR 3.4

	package org.emftext.test.cct5.resource.cct5.mopp;
	
	import java.util.ArrayList;
import java.util.List;
import org.antlr.runtime3_4_0.ANTLRStringStream;
import org.antlr.runtime3_4_0.RecognitionException;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class Cct5Lexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__8=8;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int LINEBREAK=4;
    public static final int QUOTED_34_34=5;
    public static final int TEXT=6;
    public static final int WHITESPACE=7;

    	public List<RecognitionException> lexerExceptions  = new ArrayList<RecognitionException>();
    	public List<Integer> lexerExceptionPositions = new ArrayList<Integer>();
    	
    	public void reportError(RecognitionException e) {
    		lexerExceptions.add(e);
    		lexerExceptionPositions.add(((ANTLRStringStream) input).index());
    	}


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public Cct5Lexer() {} 
    public Cct5Lexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public Cct5Lexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "Cct5.g"; }

    // $ANTLR start "T__8"
    public final void mT__8() throws RecognitionException {
        try {
            int _type = T__8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cct5.g:20:6: ( ':' )
            // Cct5.g:20:8: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__8"

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cct5.g:21:6: ( 'BEGIN_ANIMAL' )
            // Cct5.g:21:8: 'BEGIN_ANIMAL'
            {
            match("BEGIN_ANIMAL"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cct5.g:22:7: ( 'BEGIN_FARMER' )
            // Cct5.g:22:9: 'BEGIN_FARMER'
            {
            match("BEGIN_FARMER"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cct5.g:23:7: ( 'Diet' )
            // Cct5.g:23:9: 'Diet'
            {
            match("Diet"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cct5.g:24:7: ( 'END_ANIMAL' )
            // Cct5.g:24:9: 'END_ANIMAL'
            {
            match("END_ANIMAL"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cct5.g:25:7: ( 'END_FARMER' )
            // Cct5.g:25:9: 'END_FARMER'
            {
            match("END_FARMER"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cct5.g:26:7: ( 'Farm' )
            // Cct5.g:26:9: 'Farm'
            {
            match("Farm"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cct5.g:27:7: ( 'FeedingInstruction' )
            // Cct5.g:27:9: 'FeedingInstruction'
            {
            match("FeedingInstruction"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cct5.g:28:7: ( 'favored' )
            // Cct5.g:28:9: 'favored'
            {
            match("favored"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cct5.g:29:7: ( '{' )
            // Cct5.g:29:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cct5.g:30:7: ( '}' )
            // Cct5.g:30:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cct5.g:990:5: ( ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ ) )
            // Cct5.g:991:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            {
            // Cct5.g:991:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            // Cct5.g:991:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            {
            // Cct5.g:991:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='-'||(LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Cct5.g:
            	    {
            	    if ( input.LA(1)=='-'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TEXT"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cct5.g:993:11: ( ( ( ' ' | '\\t' | '\\f' ) ) )
            // Cct5.g:994:2: ( ( ' ' | '\\t' | '\\f' ) )
            {
            if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "LINEBREAK"
    public final void mLINEBREAK() throws RecognitionException {
        try {
            int _type = LINEBREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cct5.g:997:10: ( ( ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // Cct5.g:998:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // Cct5.g:998:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Cct5.g:998:3: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Cct5.g:998:3: ( '\\r\\n' | '\\r' | '\\n' )
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1=='\n') ) {
                    alt2=1;
                }
                else {
                    alt2=2;
                }
            }
            else if ( (LA2_0=='\n') ) {
                alt2=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // Cct5.g:998:4: '\\r\\n'
                    {
                    match("\r\n"); 



                    }
                    break;
                case 2 :
                    // Cct5.g:998:13: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Cct5.g:998:20: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }


            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LINEBREAK"

    // $ANTLR start "QUOTED_34_34"
    public final void mQUOTED_34_34() throws RecognitionException {
        try {
            int _type = QUOTED_34_34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cct5.g:1001:13: ( ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) ) )
            // Cct5.g:1002:2: ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) )
            {
            // Cct5.g:1002:2: ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) )
            // Cct5.g:1002:3: ( '\"' ) (~ ( '\"' ) )* ( '\"' )
            {
            // Cct5.g:1002:3: ( '\"' )
            // Cct5.g:1002:4: '\"'
            {
            match('\"'); 

            }


            // Cct5.g:1002:8: (~ ( '\"' ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '\u0000' && LA3_0 <= '!')||(LA3_0 >= '#' && LA3_0 <= '\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Cct5.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            // Cct5.g:1002:17: ( '\"' )
            // Cct5.g:1002:18: '\"'
            {
            match('\"'); 

            }


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUOTED_34_34"

    public void mTokens() throws RecognitionException {
        // Cct5.g:1:8: ( T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | TEXT | WHITESPACE | LINEBREAK | QUOTED_34_34 )
        int alt4=15;
        alt4 = dfa4.predict(input);
        switch (alt4) {
            case 1 :
                // Cct5.g:1:10: T__8
                {
                mT__8(); 


                }
                break;
            case 2 :
                // Cct5.g:1:15: T__9
                {
                mT__9(); 


                }
                break;
            case 3 :
                // Cct5.g:1:20: T__10
                {
                mT__10(); 


                }
                break;
            case 4 :
                // Cct5.g:1:26: T__11
                {
                mT__11(); 


                }
                break;
            case 5 :
                // Cct5.g:1:32: T__12
                {
                mT__12(); 


                }
                break;
            case 6 :
                // Cct5.g:1:38: T__13
                {
                mT__13(); 


                }
                break;
            case 7 :
                // Cct5.g:1:44: T__14
                {
                mT__14(); 


                }
                break;
            case 8 :
                // Cct5.g:1:50: T__15
                {
                mT__15(); 


                }
                break;
            case 9 :
                // Cct5.g:1:56: T__16
                {
                mT__16(); 


                }
                break;
            case 10 :
                // Cct5.g:1:62: T__17
                {
                mT__17(); 


                }
                break;
            case 11 :
                // Cct5.g:1:68: T__18
                {
                mT__18(); 


                }
                break;
            case 12 :
                // Cct5.g:1:74: TEXT
                {
                mTEXT(); 


                }
                break;
            case 13 :
                // Cct5.g:1:79: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 14 :
                // Cct5.g:1:90: LINEBREAK
                {
                mLINEBREAK(); 


                }
                break;
            case 15 :
                // Cct5.g:1:100: QUOTED_34_34
                {
                mQUOTED_34_34(); 


                }
                break;

        }

    }


    protected DFA4 dfa4 = new DFA4(this);
    static final String DFA4_eotS =
        "\2\uffff\5\11\6\uffff\15\11\1\40\1\11\1\43\3\11\1\uffff\2\11\1\uffff"+
        "\14\11\1\66\5\11\1\uffff\7\11\1\103\1\104\3\11\2\uffff\1\11\1\111"+
        "\1\112\1\11\2\uffff\5\11\1\121\1\uffff";
    static final String DFA4_eofS =
        "\122\uffff";
    static final String DFA4_minS =
        "\1\11\1\uffff\1\105\1\151\1\116\2\141\6\uffff\1\107\1\145\1\104"+
        "\1\162\1\145\1\166\1\111\1\164\1\137\1\155\1\144\1\157\1\116\1\55"+
        "\1\101\1\55\1\151\1\162\1\137\1\uffff\1\116\1\101\1\uffff\1\156"+
        "\1\145\1\101\1\111\1\122\1\147\1\144\1\116\1\101\2\115\1\111\1\55"+
        "\1\111\1\122\1\101\1\105\1\156\1\uffff\2\115\1\114\1\122\1\163\1"+
        "\101\1\105\2\55\1\164\1\114\1\122\2\uffff\1\162\2\55\1\165\2\uffff"+
        "\1\143\1\164\1\151\1\157\1\156\1\55\1\uffff";
    static final String DFA4_maxS =
        "\1\175\1\uffff\1\105\1\151\1\116\1\145\1\141\6\uffff\1\107\1\145"+
        "\1\104\1\162\1\145\1\166\1\111\1\164\1\137\1\155\1\144\1\157\1\116"+
        "\1\172\1\106\1\172\1\151\1\162\1\137\1\uffff\1\116\1\101\1\uffff"+
        "\1\156\1\145\1\106\1\111\1\122\1\147\1\144\1\116\1\101\2\115\1\111"+
        "\1\172\1\111\1\122\1\101\1\105\1\156\1\uffff\2\115\1\114\1\122\1"+
        "\163\1\101\1\105\2\172\1\164\1\114\1\122\2\uffff\1\162\2\172\1\165"+
        "\2\uffff\1\143\1\164\1\151\1\157\1\156\1\172\1\uffff";
    static final String DFA4_acceptS =
        "\1\uffff\1\1\5\uffff\1\12\1\13\1\14\1\15\1\16\1\17\23\uffff\1\4"+
        "\2\uffff\1\7\22\uffff\1\11\14\uffff\1\5\1\6\4\uffff\1\2\1\3\6\uffff"+
        "\1\10";
    static final String DFA4_specialS =
        "\122\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\12\1\13\1\uffff\1\12\1\13\22\uffff\1\12\1\uffff\1\14\12\uffff"+
            "\1\11\2\uffff\12\11\1\1\6\uffff\1\11\1\2\1\11\1\3\1\4\1\5\24"+
            "\11\4\uffff\1\11\1\uffff\5\11\1\6\24\11\1\7\1\uffff\1\10",
            "",
            "\1\15",
            "\1\16",
            "\1\17",
            "\1\20\3\uffff\1\21",
            "\1\22",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\23",
            "\1\24",
            "\1\25",
            "\1\26",
            "\1\27",
            "\1\30",
            "\1\31",
            "\1\32",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\36",
            "\1\37",
            "\1\11\2\uffff\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
            "\1\41\4\uffff\1\42",
            "\1\11\2\uffff\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
            "\1\44",
            "\1\45",
            "\1\46",
            "",
            "\1\47",
            "\1\50",
            "",
            "\1\51",
            "\1\52",
            "\1\53\4\uffff\1\54",
            "\1\55",
            "\1\56",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\11\2\uffff\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\11\2\uffff\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
            "\1\11\2\uffff\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
            "\1\105",
            "\1\106",
            "\1\107",
            "",
            "",
            "\1\110",
            "\1\11\2\uffff\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
            "\1\11\2\uffff\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
            "\1\113",
            "",
            "",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\11\2\uffff\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
            ""
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | TEXT | WHITESPACE | LINEBREAK | QUOTED_34_34 );";
        }
    }
 

}