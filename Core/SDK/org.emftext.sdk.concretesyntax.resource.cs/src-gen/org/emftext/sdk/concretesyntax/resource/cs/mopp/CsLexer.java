// $ANTLR 3.4

	package org.emftext.sdk.concretesyntax.resource.cs.mopp;
	
	import java.util.ArrayList;
import java.util.List;
import org.antlr.runtime3_4_0.ANTLRStringStream;
import org.antlr.runtime3_4_0.RecognitionException;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class CsLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int HEXNUMBER=4;
    public static final int LINEBREAK=5;
    public static final int ML_COMMENT=6;
    public static final int QUALIFIED_NAME=7;
    public static final int QUOTED_36_36=8;
    public static final int QUOTED_39_39_92=9;
    public static final int QUOTED_60_62=10;
    public static final int SL_COMMENT=11;
    public static final int STRING=12;
    public static final int TABNUMBER=13;
    public static final int WHITESPACE=14;

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

    public CsLexer() {} 
    public CsLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public CsLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "Cs.g"; }

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:20:7: ( '(' )
            // Cs.g:20:9: '('
            {
            match('('); 

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
            // Cs.g:21:7: ( ')' )
            // Cs.g:21:9: ')'
            {
            match(')'); 

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
            // Cs.g:22:7: ( '*' )
            // Cs.g:22:9: '*'
            {
            match('*'); 

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
            // Cs.g:23:7: ( '+' )
            // Cs.g:23:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:24:7: ( ',' )
            // Cs.g:24:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:25:7: ( ':' )
            // Cs.g:25:9: ':'
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
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:26:7: ( '::=' )
            // Cs.g:26:9: '::='
            {
            match("::="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:27:7: ( ';' )
            // Cs.g:27:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:28:7: ( '=' )
            // Cs.g:28:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:29:7: ( '?' )
            // Cs.g:29:9: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:30:7: ( '@' )
            // Cs.g:30:9: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:31:7: ( 'ABSTRACT' )
            // Cs.g:31:9: 'ABSTRACT'
            {
            match("ABSTRACT"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:32:7: ( 'AS' )
            // Cs.g:32:9: 'AS'
            {
            match("AS"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:33:7: ( 'COLLECT' )
            // Cs.g:33:9: 'COLLECT'
            {
            match("COLLECT"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:34:7: ( 'COLOR' )
            // Cs.g:34:9: 'COLOR'
            {
            match("COLOR"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:35:7: ( 'DEFINE' )
            // Cs.g:35:9: 'DEFINE'
            {
            match("DEFINE"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:36:7: ( 'FOR' )
            // Cs.g:36:9: 'FOR'
            {
            match("FOR"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:37:7: ( 'FRAGMENT' )
            // Cs.g:37:9: 'FRAGMENT'
            {
            match("FRAGMENT"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:38:7: ( 'IMPORTS' )
            // Cs.g:38:9: 'IMPORTS'
            {
            match("IMPORTS"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:39:7: ( 'IN' )
            // Cs.g:39:9: 'IN'
            {
            match("IN"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:40:7: ( 'OPTIONS' )
            // Cs.g:40:9: 'OPTIONS'
            {
            match("OPTIONS"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:41:7: ( 'PRIORITIZE' )
            // Cs.g:41:9: 'PRIORITIZE'
            {
            match("PRIORITIZE"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:42:7: ( 'REDEFINE' )
            // Cs.g:42:9: 'REDEFINE'
            {
            match("REDEFINE"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:43:7: ( 'RULES' )
            // Cs.g:43:9: 'RULES'
            {
            match("RULES"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:44:7: ( 'START' )
            // Cs.g:44:9: 'START'
            {
            match("START"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:45:7: ( 'SYNTAX' )
            // Cs.g:45:9: 'SYNTAX'
            {
            match("SYNTAX"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:46:7: ( 'SYNTAXDEF' )
            // Cs.g:46:9: 'SYNTAXDEF'
            {
            match("SYNTAXDEF"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:47:7: ( 'TOKENS' )
            // Cs.g:47:9: 'TOKENS'
            {
            match("TOKENS"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:48:7: ( 'TOKENSTYLES' )
            // Cs.g:48:9: 'TOKENSTYLES'
            {
            match("TOKENSTYLES"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:49:7: ( 'WITH' )
            // Cs.g:49:9: 'WITH'
            {
            match("WITH"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:50:7: ( '[' )
            // Cs.g:50:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:51:7: ( ']' )
            // Cs.g:51:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:52:7: ( '{' )
            // Cs.g:52:9: '{'
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
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:53:7: ( '|' )
            // Cs.g:53:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:54:7: ( '}' )
            // Cs.g:54:9: '}'
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
    // $ANTLR end "T__49"

    // $ANTLR start "SL_COMMENT"
    public final void mSL_COMMENT() throws RecognitionException {
        try {
            int _type = SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:6020:11: ( ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* ) )
            // Cs.g:6021:2: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            {
            // Cs.g:6021:2: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            // Cs.g:6021:3: '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            {
            match("//"); 



            // Cs.g:6021:7: (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '\u0000' && LA1_0 <= '\t')||(LA1_0 >= '\u000B' && LA1_0 <= '\f')||(LA1_0 >= '\u000E' && LA1_0 <= '\uFFFE')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Cs.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFE') ) {
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
            	    break loop1;
                }
            } while (true);


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
    // $ANTLR end "SL_COMMENT"

    // $ANTLR start "ML_COMMENT"
    public final void mML_COMMENT() throws RecognitionException {
        try {
            int _type = ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:6024:11: ( ( '/*' ( . )* '*/' ) )
            // Cs.g:6025:2: ( '/*' ( . )* '*/' )
            {
            // Cs.g:6025:2: ( '/*' ( . )* '*/' )
            // Cs.g:6025:3: '/*' ( . )* '*/'
            {
            match("/*"); 



            // Cs.g:6025:7: ( . )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='*') ) {
                    int LA2_1 = input.LA(2);

                    if ( (LA2_1=='/') ) {
                        alt2=2;
                    }
                    else if ( ((LA2_1 >= '\u0000' && LA2_1 <= '.')||(LA2_1 >= '0' && LA2_1 <= '\uFFFF')) ) {
                        alt2=1;
                    }


                }
                else if ( ((LA2_0 >= '\u0000' && LA2_0 <= ')')||(LA2_0 >= '+' && LA2_0 <= '\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Cs.g:6025:7: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            match("*/"); 



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
    // $ANTLR end "ML_COMMENT"

    // $ANTLR start "QUALIFIED_NAME"
    public final void mQUALIFIED_NAME() throws RecognitionException {
        try {
            int _type = QUALIFIED_NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:6028:15: ( ( ( 'A' .. 'Z' | 'a' .. 'z' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )* ( '.' ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )+ )* ) )
            // Cs.g:6029:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )* ( '.' ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )+ )* )
            {
            // Cs.g:6029:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )* ( '.' ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )+ )* )
            // Cs.g:6029:3: ( 'A' .. 'Z' | 'a' .. 'z' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )* ( '.' ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )+ )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // Cs.g:6029:26: ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='-'||(LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||LA3_0=='_'||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Cs.g:
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
            	    break loop3;
                }
            } while (true);


            // Cs.g:6029:63: ( '.' ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )+ )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='.') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Cs.g:6029:64: '.' ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )+
            	    {
            	    match('.'); 

            	    // Cs.g:6029:67: ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )+
            	    int cnt4=0;
            	    loop4:
            	    do {
            	        int alt4=2;
            	        int LA4_0 = input.LA(1);

            	        if ( (LA4_0=='-'||(LA4_0 >= '0' && LA4_0 <= '9')||(LA4_0 >= 'A' && LA4_0 <= 'Z')||LA4_0=='_'||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
            	            alt4=1;
            	        }


            	        switch (alt4) {
            	    	case 1 :
            	    	    // Cs.g:
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
            	    	    if ( cnt4 >= 1 ) break loop4;
            	                EarlyExitException eee =
            	                    new EarlyExitException(4, input);
            	                throw eee;
            	        }
            	        cnt4++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop5;
                }
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
    // $ANTLR end "QUALIFIED_NAME"

    // $ANTLR start "HEXNUMBER"
    public final void mHEXNUMBER() throws RecognitionException {
        try {
            int _type = HEXNUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:6031:10: ( ( '#' ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+ ) )
            // Cs.g:6032:2: ( '#' ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+ )
            {
            // Cs.g:6032:2: ( '#' ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+ )
            // Cs.g:6032:3: '#' ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+
            {
            match('#'); 

            // Cs.g:6032:6: ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'F')||(LA6_0 >= 'a' && LA6_0 <= 'f')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // Cs.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
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
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
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
    // $ANTLR end "HEXNUMBER"

    // $ANTLR start "TABNUMBER"
    public final void mTABNUMBER() throws RecognitionException {
        try {
            int _type = TABNUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:6034:10: ( ( '!' ( '0' .. '9' )+ ) )
            // Cs.g:6035:2: ( '!' ( '0' .. '9' )+ )
            {
            // Cs.g:6035:2: ( '!' ( '0' .. '9' )+ )
            // Cs.g:6035:3: '!' ( '0' .. '9' )+
            {
            match('!'); 

            // Cs.g:6035:6: ( '0' .. '9' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // Cs.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
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
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
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
    // $ANTLR end "TABNUMBER"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:6037:7: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ) | '\\\\' ( '0' .. '7' ) |~ ( '\\\\' | '\"' ) )* '\"' ) )
            // Cs.g:6038:2: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ) | '\\\\' ( '0' .. '7' ) |~ ( '\\\\' | '\"' ) )* '\"' )
            {
            // Cs.g:6038:2: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ) | '\\\\' ( '0' .. '7' ) |~ ( '\\\\' | '\"' ) )* '\"' )
            // Cs.g:6038:3: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ) | '\\\\' ( '0' .. '7' ) |~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 

            // Cs.g:6038:6: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ) | '\\\\' ( '0' .. '7' ) |~ ( '\\\\' | '\"' ) )*
            loop8:
            do {
                int alt8=5;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='\\') ) {
                    switch ( input.LA(2) ) {
                    case '\"':
                    case '\'':
                    case '\\':
                    case 'b':
                    case 'f':
                    case 'n':
                    case 'r':
                    case 't':
                        {
                        alt8=1;
                        }
                        break;
                    case 'u':
                        {
                        alt8=2;
                        }
                        break;
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                        {
                        alt8=3;
                        }
                        break;

                    }

                }
                else if ( ((LA8_0 >= '\u0000' && LA8_0 <= '!')||(LA8_0 >= '#' && LA8_0 <= '[')||(LA8_0 >= ']' && LA8_0 <= '\uFFFF')) ) {
                    alt8=4;
                }


                switch (alt8) {
            	case 1 :
            	    // Cs.g:6038:7: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
            	    {
            	    match('\\'); 

            	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;
            	case 2 :
            	    // Cs.g:6038:48: ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            	    {
            	    // Cs.g:6038:48: ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            	    // Cs.g:6038:49: '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            	    {
            	    match('\\'); 

            	    match('u'); 

            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // Cs.g:6038:170: '\\\\' ( '0' .. '7' )
            	    {
            	    match('\\'); 

            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;
            	case 4 :
            	    // Cs.g:6038:185: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
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
            	    break loop8;
                }
            } while (true);


            match('\"'); 

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:6040:11: ( ( ( ' ' | '\\t' | '\\f' ) ) )
            // Cs.g:6041:2: ( ( ' ' | '\\t' | '\\f' ) )
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
            // Cs.g:6044:10: ( ( ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // Cs.g:6045:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // Cs.g:6045:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Cs.g:6045:3: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Cs.g:6045:3: ( '\\r\\n' | '\\r' | '\\n' )
            int alt9=3;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\r') ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1=='\n') ) {
                    alt9=1;
                }
                else {
                    alt9=2;
                }
            }
            else if ( (LA9_0=='\n') ) {
                alt9=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }
            switch (alt9) {
                case 1 :
                    // Cs.g:6045:4: '\\r\\n'
                    {
                    match("\r\n"); 



                    }
                    break;
                case 2 :
                    // Cs.g:6045:11: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Cs.g:6045:16: '\\n'
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

    // $ANTLR start "QUOTED_60_62"
    public final void mQUOTED_60_62() throws RecognitionException {
        try {
            int _type = QUOTED_60_62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:6048:13: ( ( ( '<' ) (~ ( '>' ) )* ( '>' ) ) )
            // Cs.g:6049:2: ( ( '<' ) (~ ( '>' ) )* ( '>' ) )
            {
            // Cs.g:6049:2: ( ( '<' ) (~ ( '>' ) )* ( '>' ) )
            // Cs.g:6049:3: ( '<' ) (~ ( '>' ) )* ( '>' )
            {
            // Cs.g:6049:3: ( '<' )
            // Cs.g:6049:4: '<'
            {
            match('<'); 

            }


            // Cs.g:6049:8: (~ ( '>' ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0 >= '\u0000' && LA10_0 <= '=')||(LA10_0 >= '?' && LA10_0 <= '\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // Cs.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '=')||(input.LA(1) >= '?' && input.LA(1) <= '\uFFFF') ) {
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
            	    break loop10;
                }
            } while (true);


            // Cs.g:6049:17: ( '>' )
            // Cs.g:6049:18: '>'
            {
            match('>'); 

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
    // $ANTLR end "QUOTED_60_62"

    // $ANTLR start "QUOTED_39_39_92"
    public final void mQUOTED_39_39_92() throws RecognitionException {
        try {
            int _type = QUOTED_39_39_92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:6051:16: ( ( ( '\\'' ) ( ( '\\\\' '\\'' ) | ( '\\\\' '\\\\' ) | (~ ( '\\'' | '\\\\' ) ) )* ( '\\'' ) ) )
            // Cs.g:6052:2: ( ( '\\'' ) ( ( '\\\\' '\\'' ) | ( '\\\\' '\\\\' ) | (~ ( '\\'' | '\\\\' ) ) )* ( '\\'' ) )
            {
            // Cs.g:6052:2: ( ( '\\'' ) ( ( '\\\\' '\\'' ) | ( '\\\\' '\\\\' ) | (~ ( '\\'' | '\\\\' ) ) )* ( '\\'' ) )
            // Cs.g:6052:3: ( '\\'' ) ( ( '\\\\' '\\'' ) | ( '\\\\' '\\\\' ) | (~ ( '\\'' | '\\\\' ) ) )* ( '\\'' )
            {
            // Cs.g:6052:3: ( '\\'' )
            // Cs.g:6052:4: '\\''
            {
            match('\''); 

            }


            // Cs.g:6052:9: ( ( '\\\\' '\\'' ) | ( '\\\\' '\\\\' ) | (~ ( '\\'' | '\\\\' ) ) )*
            loop11:
            do {
                int alt11=4;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='\\') ) {
                    int LA11_2 = input.LA(2);

                    if ( (LA11_2=='\'') ) {
                        alt11=1;
                    }
                    else if ( (LA11_2=='\\') ) {
                        alt11=2;
                    }


                }
                else if ( ((LA11_0 >= '\u0000' && LA11_0 <= '&')||(LA11_0 >= '(' && LA11_0 <= '[')||(LA11_0 >= ']' && LA11_0 <= '\uFFFF')) ) {
                    alt11=3;
                }


                switch (alt11) {
            	case 1 :
            	    // Cs.g:6052:10: ( '\\\\' '\\'' )
            	    {
            	    // Cs.g:6052:10: ( '\\\\' '\\'' )
            	    // Cs.g:6052:11: '\\\\' '\\''
            	    {
            	    match('\\'); 

            	    match('\''); 

            	    }


            	    }
            	    break;
            	case 2 :
            	    // Cs.g:6052:21: ( '\\\\' '\\\\' )
            	    {
            	    // Cs.g:6052:21: ( '\\\\' '\\\\' )
            	    // Cs.g:6052:22: '\\\\' '\\\\'
            	    {
            	    match('\\'); 

            	    match('\\'); 

            	    }


            	    }
            	    break;
            	case 3 :
            	    // Cs.g:6052:32: (~ ( '\\'' | '\\\\' ) )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
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
            	    break loop11;
                }
            } while (true);


            // Cs.g:6052:48: ( '\\'' )
            // Cs.g:6052:49: '\\''
            {
            match('\''); 

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
    // $ANTLR end "QUOTED_39_39_92"

    // $ANTLR start "QUOTED_36_36"
    public final void mQUOTED_36_36() throws RecognitionException {
        try {
            int _type = QUOTED_36_36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cs.g:6054:13: ( ( ( '$' ) (~ ( '$' ) )* ( '$' ) ) )
            // Cs.g:6055:2: ( ( '$' ) (~ ( '$' ) )* ( '$' ) )
            {
            // Cs.g:6055:2: ( ( '$' ) (~ ( '$' ) )* ( '$' ) )
            // Cs.g:6055:3: ( '$' ) (~ ( '$' ) )* ( '$' )
            {
            // Cs.g:6055:3: ( '$' )
            // Cs.g:6055:4: '$'
            {
            match('$'); 

            }


            // Cs.g:6055:8: (~ ( '$' ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0 >= '\u0000' && LA12_0 <= '#')||(LA12_0 >= '%' && LA12_0 <= '\uFFFF')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // Cs.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '#')||(input.LA(1) >= '%' && input.LA(1) <= '\uFFFF') ) {
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
            	    break loop12;
                }
            } while (true);


            // Cs.g:6055:17: ( '$' )
            // Cs.g:6055:18: '$'
            {
            match('$'); 

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
    // $ANTLR end "QUOTED_36_36"

    public void mTokens() throws RecognitionException {
        // Cs.g:1:8: ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | SL_COMMENT | ML_COMMENT | QUALIFIED_NAME | HEXNUMBER | TABNUMBER | STRING | WHITESPACE | LINEBREAK | QUOTED_60_62 | QUOTED_39_39_92 | QUOTED_36_36 )
        int alt13=46;
        alt13 = dfa13.predict(input);
        switch (alt13) {
            case 1 :
                // Cs.g:1:10: T__15
                {
                mT__15(); 


                }
                break;
            case 2 :
                // Cs.g:1:16: T__16
                {
                mT__16(); 


                }
                break;
            case 3 :
                // Cs.g:1:22: T__17
                {
                mT__17(); 


                }
                break;
            case 4 :
                // Cs.g:1:28: T__18
                {
                mT__18(); 


                }
                break;
            case 5 :
                // Cs.g:1:34: T__19
                {
                mT__19(); 


                }
                break;
            case 6 :
                // Cs.g:1:40: T__20
                {
                mT__20(); 


                }
                break;
            case 7 :
                // Cs.g:1:46: T__21
                {
                mT__21(); 


                }
                break;
            case 8 :
                // Cs.g:1:52: T__22
                {
                mT__22(); 


                }
                break;
            case 9 :
                // Cs.g:1:58: T__23
                {
                mT__23(); 


                }
                break;
            case 10 :
                // Cs.g:1:64: T__24
                {
                mT__24(); 


                }
                break;
            case 11 :
                // Cs.g:1:70: T__25
                {
                mT__25(); 


                }
                break;
            case 12 :
                // Cs.g:1:76: T__26
                {
                mT__26(); 


                }
                break;
            case 13 :
                // Cs.g:1:82: T__27
                {
                mT__27(); 


                }
                break;
            case 14 :
                // Cs.g:1:88: T__28
                {
                mT__28(); 


                }
                break;
            case 15 :
                // Cs.g:1:94: T__29
                {
                mT__29(); 


                }
                break;
            case 16 :
                // Cs.g:1:100: T__30
                {
                mT__30(); 


                }
                break;
            case 17 :
                // Cs.g:1:106: T__31
                {
                mT__31(); 


                }
                break;
            case 18 :
                // Cs.g:1:112: T__32
                {
                mT__32(); 


                }
                break;
            case 19 :
                // Cs.g:1:118: T__33
                {
                mT__33(); 


                }
                break;
            case 20 :
                // Cs.g:1:124: T__34
                {
                mT__34(); 


                }
                break;
            case 21 :
                // Cs.g:1:130: T__35
                {
                mT__35(); 


                }
                break;
            case 22 :
                // Cs.g:1:136: T__36
                {
                mT__36(); 


                }
                break;
            case 23 :
                // Cs.g:1:142: T__37
                {
                mT__37(); 


                }
                break;
            case 24 :
                // Cs.g:1:148: T__38
                {
                mT__38(); 


                }
                break;
            case 25 :
                // Cs.g:1:154: T__39
                {
                mT__39(); 


                }
                break;
            case 26 :
                // Cs.g:1:160: T__40
                {
                mT__40(); 


                }
                break;
            case 27 :
                // Cs.g:1:166: T__41
                {
                mT__41(); 


                }
                break;
            case 28 :
                // Cs.g:1:172: T__42
                {
                mT__42(); 


                }
                break;
            case 29 :
                // Cs.g:1:178: T__43
                {
                mT__43(); 


                }
                break;
            case 30 :
                // Cs.g:1:184: T__44
                {
                mT__44(); 


                }
                break;
            case 31 :
                // Cs.g:1:190: T__45
                {
                mT__45(); 


                }
                break;
            case 32 :
                // Cs.g:1:196: T__46
                {
                mT__46(); 


                }
                break;
            case 33 :
                // Cs.g:1:202: T__47
                {
                mT__47(); 


                }
                break;
            case 34 :
                // Cs.g:1:208: T__48
                {
                mT__48(); 


                }
                break;
            case 35 :
                // Cs.g:1:214: T__49
                {
                mT__49(); 


                }
                break;
            case 36 :
                // Cs.g:1:220: SL_COMMENT
                {
                mSL_COMMENT(); 


                }
                break;
            case 37 :
                // Cs.g:1:231: ML_COMMENT
                {
                mML_COMMENT(); 


                }
                break;
            case 38 :
                // Cs.g:1:242: QUALIFIED_NAME
                {
                mQUALIFIED_NAME(); 


                }
                break;
            case 39 :
                // Cs.g:1:257: HEXNUMBER
                {
                mHEXNUMBER(); 


                }
                break;
            case 40 :
                // Cs.g:1:267: TABNUMBER
                {
                mTABNUMBER(); 


                }
                break;
            case 41 :
                // Cs.g:1:277: STRING
                {
                mSTRING(); 


                }
                break;
            case 42 :
                // Cs.g:1:284: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 43 :
                // Cs.g:1:295: LINEBREAK
                {
                mLINEBREAK(); 


                }
                break;
            case 44 :
                // Cs.g:1:305: QUOTED_60_62
                {
                mQUOTED_60_62(); 


                }
                break;
            case 45 :
                // Cs.g:1:318: QUOTED_39_39_92
                {
                mQUOTED_39_39_92(); 


                }
                break;
            case 46 :
                // Cs.g:1:334: QUOTED_36_36
                {
                mQUOTED_36_36(); 


                }
                break;

        }

    }


    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA13_eotS =
        "\6\uffff\1\46\4\uffff\13\34\21\uffff\1\34\1\72\5\34\1\100\10\34"+
        "\2\uffff\1\34\1\uffff\2\34\1\115\2\34\1\uffff\14\34\1\uffff\11\34"+
        "\1\145\2\34\1\150\6\34\1\157\1\160\2\34\1\uffff\2\34\1\uffff\1\165"+
        "\5\34\2\uffff\1\174\1\176\1\34\1\u0080\1\uffff\1\34\1\u0082\1\u0083"+
        "\3\34\1\uffff\1\34\1\uffff\1\u0088\1\uffff\1\u0089\2\uffff\1\34"+
        "\1\u008b\2\34\2\uffff\1\34\1\uffff\1\u008f\1\34\1\u0091\1\uffff"+
        "\1\34\1\uffff\1\u0093\1\uffff";
    static final String DFA13_eofS =
        "\u0094\uffff";
    static final String DFA13_minS =
        "\1\11\5\uffff\1\72\4\uffff\1\102\1\117\1\105\1\117\1\115\1\120\1"+
        "\122\1\105\1\124\1\117\1\111\5\uffff\1\52\13\uffff\1\123\1\55\1"+
        "\114\1\106\1\122\1\101\1\120\1\55\1\124\1\111\1\104\1\114\1\101"+
        "\1\116\1\113\1\124\2\uffff\1\124\1\uffff\1\114\1\111\1\55\1\107"+
        "\1\117\1\uffff\1\111\1\117\2\105\1\122\1\124\1\105\1\110\1\122\1"+
        "\105\1\122\1\116\1\uffff\1\115\1\122\1\117\1\122\1\106\1\123\1\124"+
        "\1\101\1\116\1\55\1\101\1\103\1\55\2\105\1\124\1\116\2\111\2\55"+
        "\1\130\1\123\1\uffff\1\103\1\124\1\uffff\1\55\1\116\2\123\1\124"+
        "\1\116\2\uffff\2\55\1\124\1\55\1\uffff\1\124\2\55\1\111\2\105\1"+
        "\uffff\1\131\1\uffff\1\55\1\uffff\1\55\2\uffff\1\132\1\55\1\106"+
        "\1\114\2\uffff\1\105\1\uffff\1\55\1\105\1\55\1\uffff\1\123\1\uffff"+
        "\1\55\1\uffff";
    static final String DFA13_maxS =
        "\1\175\5\uffff\1\72\4\uffff\1\123\1\117\1\105\1\122\1\116\1\120"+
        "\1\122\1\125\1\131\1\117\1\111\5\uffff\1\57\13\uffff\1\123\1\172"+
        "\1\114\1\106\1\122\1\101\1\120\1\172\1\124\1\111\1\104\1\114\1\101"+
        "\1\116\1\113\1\124\2\uffff\1\124\1\uffff\1\117\1\111\1\172\1\107"+
        "\1\117\1\uffff\1\111\1\117\2\105\1\122\1\124\1\105\1\110\1\122\1"+
        "\105\1\122\1\116\1\uffff\1\115\1\122\1\117\1\122\1\106\1\123\1\124"+
        "\1\101\1\116\1\172\1\101\1\103\1\172\2\105\1\124\1\116\2\111\2\172"+
        "\1\130\1\123\1\uffff\1\103\1\124\1\uffff\1\172\1\116\2\123\1\124"+
        "\1\116\2\uffff\2\172\1\124\1\172\1\uffff\1\124\2\172\1\111\2\105"+
        "\1\uffff\1\131\1\uffff\1\172\1\uffff\1\172\2\uffff\1\132\1\172\1"+
        "\106\1\114\2\uffff\1\105\1\uffff\1\172\1\105\1\172\1\uffff\1\123"+
        "\1\uffff\1\172\1\uffff";
    static final String DFA13_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\11\1\12\1\13\13\uffff"+
        "\1\37\1\40\1\41\1\42\1\43\1\uffff\1\46\1\47\1\50\1\51\1\52\1\53"+
        "\1\54\1\55\1\56\1\7\1\6\20\uffff\1\44\1\45\1\uffff\1\15\5\uffff"+
        "\1\24\14\uffff\1\21\27\uffff\1\36\2\uffff\1\17\6\uffff\1\30\1\31"+
        "\4\uffff\1\20\6\uffff\1\32\1\uffff\1\34\1\uffff\1\16\1\uffff\1\23"+
        "\1\25\4\uffff\1\14\1\22\1\uffff\1\27\3\uffff\1\33\1\uffff\1\26\1"+
        "\uffff\1\35";
    static final String DFA13_specialS =
        "\u0094\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\40\1\41\1\uffff\1\40\1\41\22\uffff\1\40\1\36\1\37\1\35\1"+
            "\44\2\uffff\1\43\1\1\1\2\1\3\1\4\1\5\2\uffff\1\33\12\uffff\1"+
            "\6\1\7\1\42\1\10\1\uffff\1\11\1\12\1\13\1\34\1\14\1\15\1\34"+
            "\1\16\2\34\1\17\5\34\1\20\1\21\1\34\1\22\1\23\1\24\2\34\1\25"+
            "\3\34\1\26\1\uffff\1\27\1\uffff\1\34\1\uffff\32\34\1\30\1\31"+
            "\1\32",
            "",
            "",
            "",
            "",
            "",
            "\1\45",
            "",
            "",
            "",
            "",
            "\1\47\20\uffff\1\50",
            "\1\51",
            "\1\52",
            "\1\53\2\uffff\1\54",
            "\1\55\1\56",
            "\1\57",
            "\1\60",
            "\1\61\17\uffff\1\62",
            "\1\63\4\uffff\1\64",
            "\1\65",
            "\1\66",
            "",
            "",
            "",
            "",
            "",
            "\1\70\4\uffff\1\67",
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
            "\1\71",
            "\2\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\2\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "",
            "",
            "\1\111",
            "",
            "\1\112\2\uffff\1\113",
            "\1\114",
            "\2\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\116",
            "\1\117",
            "",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\2\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\146",
            "\1\147",
            "\2\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\2\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\2\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\161",
            "\1\162",
            "",
            "\1\163",
            "\1\164",
            "",
            "\2\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "",
            "",
            "\2\34\1\uffff\12\34\7\uffff\3\34\1\173\26\34\4\uffff\1\34\1"+
            "\uffff\32\34",
            "\2\34\1\uffff\12\34\7\uffff\23\34\1\175\6\34\4\uffff\1\34\1"+
            "\uffff\32\34",
            "\1\177",
            "\2\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\1\u0081",
            "\2\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\2\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "",
            "\1\u0087",
            "",
            "\2\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\2\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "",
            "\1\u008a",
            "\2\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u008c",
            "\1\u008d",
            "",
            "",
            "\1\u008e",
            "",
            "\2\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u0090",
            "\2\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\1\u0092",
            "",
            "\2\34\1\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | SL_COMMENT | ML_COMMENT | QUALIFIED_NAME | HEXNUMBER | TABNUMBER | STRING | WHITESPACE | LINEBREAK | QUOTED_60_62 | QUOTED_39_39_92 | QUOTED_36_36 );";
        }
    }
 

}