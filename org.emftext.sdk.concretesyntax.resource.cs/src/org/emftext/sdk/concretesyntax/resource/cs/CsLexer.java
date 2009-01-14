// $ANTLR 3.1.1 D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g 2009-01-14 23:19:12

package org.emftext.sdk.concretesyntax.resource.cs;



import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;

public class CsLexer extends Lexer {
    public static final int T__42=42;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int QUOTED_39_39=8;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int TEXT_35_=9;
    public static final int TEXT=4;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int TEXT_33_=10;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__16=16;
    public static final int T__33=33;
    public static final int QNAME=6;
    public static final int WS=14;
    public static final int T__15=15;
    public static final int T__34=34;
    public static final int T__18=18;
    public static final int T__35=35;
    public static final int COMMENTS=12;
    public static final int T__17=17;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int QUOTED_36_36=11;
    public static final int LB=13;
    public static final int QUOTED_60_62=5;
    public static final int QUOTED_34_34=7;

    	public java.util.List<org.antlr.runtime.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime.RecognitionException>();
    	public java.util.List<java.lang.Integer> lexerExceptionsPosition       = new java.util.ArrayList<java.lang.Integer>();

    	public void reportError(org.antlr.runtime.RecognitionException e) {
    		lexerExceptions.add(e);

    		lexerExceptionsPosition.add(((org.antlr.runtime.ANTLRStringStream)input).index());
    	}


    // delegates
    // delegators

    public CsLexer() {;} 
    public CsLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public CsLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g"; }

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:18:7: ( 'SYNTAXDEF' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:18:9: 'SYNTAXDEF'
            {
            match("SYNTAXDEF"); 


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
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:19:7: ( 'FOR' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:19:9: 'FOR'
            {
            match("FOR"); 


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
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:20:7: ( 'START' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:20:9: 'START'
            {
            match("START"); 


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
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:21:7: ( ',' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:21:9: ','
            {
            match(','); 

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
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:22:7: ( 'IMPORTS' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:22:9: 'IMPORTS'
            {
            match("IMPORTS"); 


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
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:23:7: ( '{' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:23:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:24:7: ( '}' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:24:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:25:7: ( 'OPTIONS' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:25:9: 'OPTIONS'
            {
            match("OPTIONS"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:26:7: ( ';' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:26:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:27:7: ( 'TOKENS' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:27:9: 'TOKENS'
            {
            match("TOKENS"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:28:7: ( 'RULES' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:28:9: 'RULES'
            {
            match("RULES"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:29:7: ( ':' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:29:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:30:7: ( 'WITH' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:30:9: 'WITH'
            {
            match("WITH"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:31:7: ( 'SYNTAX' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:31:9: 'SYNTAX'
            {
            match("SYNTAX"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:32:7: ( '=' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:32:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:33:7: ( '::=' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:33:9: '::='
            {
            match("::="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:34:7: ( '|' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:34:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:35:7: ( '[' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:35:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:36:7: ( ']' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:36:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:37:7: ( '(' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:37:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:38:7: ( ')' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:38:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:39:7: ( '+' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:39:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:40:7: ( '*' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:40:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:41:7: ( '?' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:41:9: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:42:7: ( 'DEFINE' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:42:9: 'DEFINE'
            {
            match("DEFINE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:43:7: ( 'COLLECT' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:43:9: 'COLLECT'
            {
            match("COLLECT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:44:7: ( 'IN' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:44:9: 'IN'
            {
            match("IN"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:45:7: ( 'PREDEFINED' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:45:9: 'PREDEFINED'
            {
            match("PREDEFINED"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "COMMENTS"
    public final void mCOMMENTS() throws RecognitionException {
        try {
            int _type = COMMENTS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:405:1: ( '//' (~ ( '\\n' | '\\r' ) )* )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:406:2: '//' (~ ( '\\n' | '\\r' ) )*
            {
            match("//"); 

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:406:6: (~ ( '\\n' | '\\r' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:406:7: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENTS"

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:409:1: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:410:2: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:410:2: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='-'||(LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:
            	    {
            	    if ( input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TEXT"

    // $ANTLR start "QNAME"
    public final void mQNAME() throws RecognitionException {
        try {
            int _type = QNAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:413:1: ( ( 'A' .. 'Z' | 'a' .. 'z' | '_' )+ ( '.' ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )+ )+ )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:414:2: ( 'A' .. 'Z' | 'a' .. 'z' | '_' )+ ( '.' ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )+ )+
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:414:2: ( 'A' .. 'Z' | 'a' .. 'z' | '_' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:
            	    {
            	    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:414:26: ( '.' ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )+ )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='.') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:414:27: '.' ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )+
            	    {
            	    match('.'); 
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:414:30: ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )+
            	    int cnt4=0;
            	    loop4:
            	    do {
            	        int alt4=2;
            	        int LA4_0 = input.LA(1);

            	        if ( (LA4_0=='-'||(LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
            	            alt4=1;
            	        }


            	        switch (alt4) {
            	    	case 1 :
            	    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:
            	    	    {
            	    	    if ( input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	    	        input.consume();

            	    	    }
            	    	    else {
            	    	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	    	        recover(mse);
            	    	        throw mse;}


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
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QNAME"

    // $ANTLR start "TEXT_33_"
    public final void mTEXT_33_() throws RecognitionException {
        try {
            int _type = TEXT_33_;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:417:1: ( ( '!' ) ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:418:2: ( '!' ) ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:418:2: ( '!' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:418:3: '!'
            {
            match('!'); 

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:418:7: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='-'||(LA6_0>='0' && LA6_0<='9')||(LA6_0>='A' && LA6_0<='Z')||LA6_0=='_'||(LA6_0>='a' && LA6_0<='z')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:
            	    {
            	    if ( input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TEXT_33_"

    // $ANTLR start "LB"
    public final void mLB() throws RecognitionException {
        try {
            int _type = LB;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:421:1: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:422:2: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:422:2: ( '\\r\\n' | '\\r' | '\\n' )
            int alt7=3;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\r') ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1=='\n') ) {
                    alt7=1;
                }
                else {
                    alt7=2;}
            }
            else if ( (LA7_0=='\n') ) {
                alt7=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:422:3: '\\r\\n'
                    {
                    match("\r\n"); 


                    }
                    break;
                case 2 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:422:12: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:422:19: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }

             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LB"

    // $ANTLR start "TEXT_35_"
    public final void mTEXT_35_() throws RecognitionException {
        try {
            int _type = TEXT_35_;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:425:1: ( ( '#' ) ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:426:2: ( '#' ) ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:426:2: ( '#' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:426:3: '#'
            {
            match('#'); 

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:426:7: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='-'||(LA8_0>='0' && LA8_0<='9')||(LA8_0>='A' && LA8_0<='Z')||LA8_0=='_'||(LA8_0>='a' && LA8_0<='z')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:
            	    {
            	    if ( input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TEXT_35_"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:429:1: ( ( ' ' | '\\t' | '\\f' ) )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:430:2: ( ' ' | '\\t' | '\\f' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "QUOTED_60_62"
    public final void mQUOTED_60_62() throws RecognitionException {
        try {
            int _type = QUOTED_60_62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:433:1: ( ( '<' ) (~ ( '>' ) | ( '\\\\' '>' ) )* ( '>' ) )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:434:2: ( '<' ) (~ ( '>' ) | ( '\\\\' '>' ) )* ( '>' )
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:434:2: ( '<' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:434:3: '<'
            {
            match('<'); 

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:434:7: (~ ( '>' ) | ( '\\\\' '>' ) )*
            loop9:
            do {
                int alt9=3;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='\\') ) {
                    int LA9_2 = input.LA(2);

                    if ( (LA9_2=='>') ) {
                        int LA9_4 = input.LA(3);

                        if ( ((LA9_4>='\u0000' && LA9_4<='\uFFFF')) ) {
                            alt9=2;
                        }

                        else {
                            alt9=1;
                        }

                    }
                    else if ( ((LA9_2>='\u0000' && LA9_2<='=')||(LA9_2>='?' && LA9_2<='\uFFFF')) ) {
                        alt9=1;
                    }


                }
                else if ( ((LA9_0>='\u0000' && LA9_0<='=')||(LA9_0>='?' && LA9_0<='[')||(LA9_0>=']' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:434:8: ~ ( '>' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='=')||(input.LA(1)>='?' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;
            	case 2 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:434:15: ( '\\\\' '>' )
            	    {
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:434:15: ( '\\\\' '>' )
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:434:16: '\\\\' '>'
            	    {
            	    match('\\'); 
            	    match('>'); 

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:434:26: ( '>' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:434:27: '>'
            {
            match('>'); 

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QUOTED_60_62"

    // $ANTLR start "QUOTED_39_39"
    public final void mQUOTED_39_39() throws RecognitionException {
        try {
            int _type = QUOTED_39_39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:437:1: ( ( '\\'' ) (~ ( '\\'' ) | ( '\\\\' '\\'' ) )* ( '\\'' ) )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:438:2: ( '\\'' ) (~ ( '\\'' ) | ( '\\\\' '\\'' ) )* ( '\\'' )
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:438:2: ( '\\'' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:438:3: '\\''
            {
            match('\''); 

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:438:8: (~ ( '\\'' ) | ( '\\\\' '\\'' ) )*
            loop10:
            do {
                int alt10=3;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='\\') ) {
                    int LA10_2 = input.LA(2);

                    if ( (LA10_2=='\'') ) {
                        int LA10_4 = input.LA(3);

                        if ( ((LA10_4>='\u0000' && LA10_4<='\uFFFF')) ) {
                            alt10=2;
                        }

                        else {
                            alt10=1;
                        }

                    }
                    else if ( ((LA10_2>='\u0000' && LA10_2<='&')||(LA10_2>='(' && LA10_2<='\uFFFF')) ) {
                        alt10=1;
                    }


                }
                else if ( ((LA10_0>='\u0000' && LA10_0<='&')||(LA10_0>='(' && LA10_0<='[')||(LA10_0>=']' && LA10_0<='\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:438:9: ~ ( '\\'' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;
            	case 2 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:438:17: ( '\\\\' '\\'' )
            	    {
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:438:17: ( '\\\\' '\\'' )
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:438:18: '\\\\' '\\''
            	    {
            	    match('\\'); 
            	    match('\''); 

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:438:29: ( '\\'' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:438:30: '\\''
            {
            match('\''); 

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QUOTED_39_39"

    // $ANTLR start "QUOTED_36_36"
    public final void mQUOTED_36_36() throws RecognitionException {
        try {
            int _type = QUOTED_36_36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:441:1: ( ( '$' ) (~ ( '$' ) | ( '\\\\' '$' ) )* ( '$' ) )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:442:2: ( '$' ) (~ ( '$' ) | ( '\\\\' '$' ) )* ( '$' )
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:442:2: ( '$' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:442:3: '$'
            {
            match('$'); 

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:442:7: (~ ( '$' ) | ( '\\\\' '$' ) )*
            loop11:
            do {
                int alt11=3;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='\\') ) {
                    int LA11_2 = input.LA(2);

                    if ( (LA11_2=='$') ) {
                        int LA11_4 = input.LA(3);

                        if ( ((LA11_4>='\u0000' && LA11_4<='\uFFFF')) ) {
                            alt11=2;
                        }

                        else {
                            alt11=1;
                        }

                    }
                    else if ( ((LA11_2>='\u0000' && LA11_2<='#')||(LA11_2>='%' && LA11_2<='\uFFFF')) ) {
                        alt11=1;
                    }


                }
                else if ( ((LA11_0>='\u0000' && LA11_0<='#')||(LA11_0>='%' && LA11_0<='[')||(LA11_0>=']' && LA11_0<='\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:442:8: ~ ( '$' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='#')||(input.LA(1)>='%' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;
            	case 2 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:442:15: ( '\\\\' '$' )
            	    {
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:442:15: ( '\\\\' '$' )
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:442:16: '\\\\' '$'
            	    {
            	    match('\\'); 
            	    match('$'); 

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:442:26: ( '$' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:442:27: '$'
            {
            match('$'); 

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QUOTED_36_36"

    // $ANTLR start "QUOTED_34_34"
    public final void mQUOTED_34_34() throws RecognitionException {
        try {
            int _type = QUOTED_34_34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:445:1: ( ( '\"' ) (~ ( '\"' ) | ( '\\\\' '\"' ) )* ( '\"' ) )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:446:2: ( '\"' ) (~ ( '\"' ) | ( '\\\\' '\"' ) )* ( '\"' )
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:446:2: ( '\"' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:446:3: '\"'
            {
            match('\"'); 

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:446:7: (~ ( '\"' ) | ( '\\\\' '\"' ) )*
            loop12:
            do {
                int alt12=3;
                int LA12_0 = input.LA(1);

                if ( (LA12_0=='\\') ) {
                    int LA12_2 = input.LA(2);

                    if ( (LA12_2=='\"') ) {
                        int LA12_4 = input.LA(3);

                        if ( ((LA12_4>='\u0000' && LA12_4<='\uFFFF')) ) {
                            alt12=2;
                        }

                        else {
                            alt12=1;
                        }

                    }
                    else if ( ((LA12_2>='\u0000' && LA12_2<='!')||(LA12_2>='#' && LA12_2<='\uFFFF')) ) {
                        alt12=1;
                    }


                }
                else if ( ((LA12_0>='\u0000' && LA12_0<='!')||(LA12_0>='#' && LA12_0<='[')||(LA12_0>=']' && LA12_0<='\uFFFF')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:446:8: ~ ( '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;
            	case 2 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:446:15: ( '\\\\' '\"' )
            	    {
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:446:15: ( '\\\\' '\"' )
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:446:16: '\\\\' '\"'
            	    {
            	    match('\\'); 
            	    match('\"'); 

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:446:26: ( '\"' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:446:27: '\"'
            {
            match('\"'); 

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QUOTED_34_34"

    public void mTokens() throws RecognitionException {
        // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:8: ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | COMMENTS | TEXT | QNAME | TEXT_33_ | LB | TEXT_35_ | WS | QUOTED_60_62 | QUOTED_39_39 | QUOTED_36_36 | QUOTED_34_34 )
        int alt13=39;
        alt13 = dfa13.predict(input);
        switch (alt13) {
            case 1 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:10: T__15
                {
                mT__15(); 

                }
                break;
            case 2 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:16: T__16
                {
                mT__16(); 

                }
                break;
            case 3 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:22: T__17
                {
                mT__17(); 

                }
                break;
            case 4 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:28: T__18
                {
                mT__18(); 

                }
                break;
            case 5 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:34: T__19
                {
                mT__19(); 

                }
                break;
            case 6 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:40: T__20
                {
                mT__20(); 

                }
                break;
            case 7 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:46: T__21
                {
                mT__21(); 

                }
                break;
            case 8 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:52: T__22
                {
                mT__22(); 

                }
                break;
            case 9 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:58: T__23
                {
                mT__23(); 

                }
                break;
            case 10 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:64: T__24
                {
                mT__24(); 

                }
                break;
            case 11 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:70: T__25
                {
                mT__25(); 

                }
                break;
            case 12 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:76: T__26
                {
                mT__26(); 

                }
                break;
            case 13 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:82: T__27
                {
                mT__27(); 

                }
                break;
            case 14 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:88: T__28
                {
                mT__28(); 

                }
                break;
            case 15 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:94: T__29
                {
                mT__29(); 

                }
                break;
            case 16 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:100: T__30
                {
                mT__30(); 

                }
                break;
            case 17 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:106: T__31
                {
                mT__31(); 

                }
                break;
            case 18 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:112: T__32
                {
                mT__32(); 

                }
                break;
            case 19 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:118: T__33
                {
                mT__33(); 

                }
                break;
            case 20 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:124: T__34
                {
                mT__34(); 

                }
                break;
            case 21 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:130: T__35
                {
                mT__35(); 

                }
                break;
            case 22 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:136: T__36
                {
                mT__36(); 

                }
                break;
            case 23 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:142: T__37
                {
                mT__37(); 

                }
                break;
            case 24 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:148: T__38
                {
                mT__38(); 

                }
                break;
            case 25 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:154: T__39
                {
                mT__39(); 

                }
                break;
            case 26 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:160: T__40
                {
                mT__40(); 

                }
                break;
            case 27 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:166: T__41
                {
                mT__41(); 

                }
                break;
            case 28 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:172: T__42
                {
                mT__42(); 

                }
                break;
            case 29 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:178: COMMENTS
                {
                mCOMMENTS(); 

                }
                break;
            case 30 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:187: TEXT
                {
                mTEXT(); 

                }
                break;
            case 31 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:192: QNAME
                {
                mQNAME(); 

                }
                break;
            case 32 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:198: TEXT_33_
                {
                mTEXT_33_(); 

                }
                break;
            case 33 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:207: LB
                {
                mLB(); 

                }
                break;
            case 34 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:210: TEXT_35_
                {
                mTEXT_35_(); 

                }
                break;
            case 35 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:219: WS
                {
                mWS(); 

                }
                break;
            case 36 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:222: QUOTED_60_62
                {
                mQUOTED_60_62(); 

                }
                break;
            case 37 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:235: QUOTED_39_39
                {
                mQUOTED_39_39(); 

                }
                break;
            case 38 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:248: QUOTED_36_36
                {
                mQUOTED_36_36(); 

                }
                break;
            case 39 :
                // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1:261: QUOTED_34_34
                {
                mQUOTED_34_34(); 

                }
                break;

        }

    }


    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA13_eotS =
        "\1\uffff\2\33\1\uffff\1\33\2\uffff\1\33\1\uffff\2\33\1\56\1\33"+
        "\11\uffff\3\33\1\uffff\1\33\11\uffff\2\33\1\uffff\2\33\1\67\3\33"+
        "\2\uffff\6\33\1\101\1\33\1\uffff\11\33\1\uffff\4\33\1\120\4\33\1"+
        "\125\3\33\1\131\1\uffff\3\33\1\136\1\uffff\2\33\1\141\1\uffff\1"+
        "\142\3\33\1\uffff\1\146\1\147\2\uffff\1\150\2\33\3\uffff\1\33\1"+
        "\154\1\33\1\uffff\1\156\1\uffff";
    static final String DFA13_eofS =
        "\157\uffff";
    static final String DFA13_minS =
        "\1\11\2\56\1\uffff\1\56\2\uffff\1\56\1\uffff\2\56\1\72\1\56\11"+
        "\uffff\3\56\1\uffff\1\56\11\uffff\2\56\1\uffff\2\56\1\55\3\56\2"+
        "\uffff\6\56\1\55\1\56\1\uffff\11\56\1\uffff\4\56\1\55\4\56\1\55"+
        "\3\56\1\55\1\uffff\3\56\1\55\1\uffff\2\56\1\55\1\uffff\1\55\3\56"+
        "\1\uffff\2\55\2\uffff\1\55\2\56\3\uffff\1\56\1\55\1\56\1\uffff\1"+
        "\55\1\uffff";
    static final String DFA13_maxS =
        "\1\175\2\172\1\uffff\1\172\2\uffff\1\172\1\uffff\2\172\1\72\1\172"+
        "\11\uffff\3\172\1\uffff\1\172\11\uffff\2\172\1\uffff\6\172\2\uffff"+
        "\10\172\1\uffff\11\172\1\uffff\16\172\1\uffff\4\172\1\uffff\3\172"+
        "\1\uffff\4\172\1\uffff\2\172\2\uffff\3\172\3\uffff\3\172\1\uffff"+
        "\1\172\1\uffff";
    static final String DFA13_acceptS =
        "\3\uffff\1\4\1\uffff\1\6\1\7\1\uffff\1\11\4\uffff\1\17\1\21\1\22"+
        "\1\23\1\24\1\25\1\26\1\27\1\30\3\uffff\1\35\1\uffff\1\36\1\40\1"+
        "\41\1\42\1\43\1\44\1\45\1\46\1\47\2\uffff\1\37\6\uffff\1\20\1\14"+
        "\10\uffff\1\33\11\uffff\1\2\16\uffff\1\15\4\uffff\1\3\3\uffff\1"+
        "\13\4\uffff\1\16\2\uffff\1\12\1\31\3\uffff\1\5\1\10\1\32\3\uffff"+
        "\1\1\1\uffff\1\34";
    static final String DFA13_specialS =
        "\157\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\37\1\35\1\uffff\1\37\1\35\22\uffff\1\37\1\34\1\43\1\36\1"+
            "\42\2\uffff\1\41\1\21\1\22\1\24\1\23\1\3\1\33\1\uffff\1\31\12"+
            "\33\1\13\1\10\1\40\1\15\1\uffff\1\25\1\uffff\2\32\1\27\1\26"+
            "\1\32\1\2\2\32\1\4\5\32\1\7\1\30\1\32\1\12\1\1\1\11\2\32\1\14"+
            "\3\32\1\17\1\uffff\1\20\1\uffff\1\32\1\uffff\32\32\1\5\1\16"+
            "\1\6",
            "\1\46\22\uffff\23\32\1\45\4\32\1\44\1\32\4\uffff\1\32\1\uffff"+
            "\32\32",
            "\1\46\22\uffff\16\32\1\47\13\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "\1\46\22\uffff\14\32\1\50\1\51\14\32\4\uffff\1\32\1\uffff"+
            "\32\32",
            "",
            "",
            "\1\46\22\uffff\17\32\1\52\12\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "\1\46\22\uffff\16\32\1\53\13\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\24\32\1\54\5\32\4\uffff\1\32\1\uffff\32\32",
            "\1\55",
            "\1\46\22\uffff\10\32\1\57\21\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\46\22\uffff\4\32\1\60\25\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\16\32\1\61\13\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\21\32\1\62\10\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "\1\46\22\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\46\22\uffff\15\32\1\63\14\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\1\64\31\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "\1\46\22\uffff\21\32\1\65\10\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\17\32\1\66\12\32\4\uffff\1\32\1\uffff\32\32",
            "\1\33\1\46\1\uffff\12\33\7\uffff\32\32\4\uffff\1\32\1\uffff"+
            "\32\32",
            "\1\46\22\uffff\23\32\1\70\6\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\12\32\1\71\17\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\13\32\1\72\16\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "",
            "\1\46\22\uffff\23\32\1\73\6\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\5\32\1\74\24\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\13\32\1\75\16\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\4\32\1\76\25\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\23\32\1\77\6\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\21\32\1\100\10\32\4\uffff\1\32\1\uffff\32\32",
            "\1\33\1\46\1\uffff\12\33\7\uffff\32\32\4\uffff\1\32\1\uffff"+
            "\32\32",
            "\1\46\22\uffff\16\32\1\102\13\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "\1\46\22\uffff\10\32\1\103\21\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\4\32\1\104\25\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\4\32\1\105\25\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\7\32\1\106\22\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\10\32\1\107\21\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\13\32\1\110\16\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\3\32\1\111\26\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\1\112\31\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\23\32\1\113\6\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "\1\46\22\uffff\21\32\1\114\10\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\16\32\1\115\13\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\15\32\1\116\14\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\22\32\1\117\7\32\4\uffff\1\32\1\uffff\32\32",
            "\1\33\1\46\1\uffff\12\33\7\uffff\32\32\4\uffff\1\32\1\uffff"+
            "\32\32",
            "\1\46\22\uffff\15\32\1\121\14\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\4\32\1\122\25\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\4\32\1\123\25\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\27\32\1\124\2\32\4\uffff\1\32\1\uffff\32\32",
            "\1\33\1\46\1\uffff\12\33\7\uffff\32\32\4\uffff\1\32\1\uffff"+
            "\32\32",
            "\1\46\22\uffff\23\32\1\126\6\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\15\32\1\127\14\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\22\32\1\130\7\32\4\uffff\1\32\1\uffff\32\32",
            "\1\33\1\46\1\uffff\12\33\7\uffff\32\32\4\uffff\1\32\1\uffff"+
            "\32\32",
            "",
            "\1\46\22\uffff\4\32\1\132\25\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\2\32\1\133\27\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\5\32\1\134\24\32\4\uffff\1\32\1\uffff\32\32",
            "\1\33\1\46\1\uffff\12\33\7\uffff\3\32\1\135\26\32\4\uffff"+
            "\1\32\1\uffff\32\32",
            "",
            "\1\46\22\uffff\22\32\1\137\7\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\22\32\1\140\7\32\4\uffff\1\32\1\uffff\32\32",
            "\1\33\1\46\1\uffff\12\33\7\uffff\32\32\4\uffff\1\32\1\uffff"+
            "\32\32",
            "",
            "\1\33\1\46\1\uffff\12\33\7\uffff\32\32\4\uffff\1\32\1\uffff"+
            "\32\32",
            "\1\46\22\uffff\23\32\1\143\6\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\10\32\1\144\21\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\4\32\1\145\25\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "\1\33\1\46\1\uffff\12\33\7\uffff\32\32\4\uffff\1\32\1\uffff"+
            "\32\32",
            "\1\33\1\46\1\uffff\12\33\7\uffff\32\32\4\uffff\1\32\1\uffff"+
            "\32\32",
            "",
            "",
            "\1\33\1\46\1\uffff\12\33\7\uffff\32\32\4\uffff\1\32\1\uffff"+
            "\32\32",
            "\1\46\22\uffff\15\32\1\151\14\32\4\uffff\1\32\1\uffff\32\32",
            "\1\46\22\uffff\5\32\1\152\24\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "",
            "",
            "\1\46\22\uffff\4\32\1\153\25\32\4\uffff\1\32\1\uffff\32\32",
            "\1\33\1\46\1\uffff\12\33\7\uffff\32\32\4\uffff\1\32\1\uffff"+
            "\32\32",
            "\1\46\22\uffff\3\32\1\155\26\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "\1\33\1\46\1\uffff\12\33\7\uffff\32\32\4\uffff\1\32\1\uffff"+
            "\32\32",
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
            return "1:1: Tokens : ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | COMMENTS | TEXT | QNAME | TEXT_33_ | LB | TEXT_35_ | WS | QUOTED_60_62 | QUOTED_39_39 | QUOTED_36_36 | QUOTED_34_34 );";
        }
    }
 

}