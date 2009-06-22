// $ANTLR 3.1.1 /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g 2009-06-22 16:01:58

	package org.emftext.sdk.concretesyntax.resource.cs;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class CsLexer extends Lexer {
    public static final int T__42=42;
    public static final int T__28=28;
    public static final int T__23=23;
    public static final int NUMBER=9;
    public static final int T__21=21;
    public static final int HEXNUMBER=8;
    public static final int T__19=19;
    public static final int COMMENTS=11;
    public static final int T__39=39;
    public static final int T__30=30;
    public static final int T__46=46;
    public static final int T__17=17;
    public static final int T__27=27;
    public static final int T__24=24;
    public static final int QUALIFIED_NAME=4;
    public static final int QUOTED_39_39=7;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int QUOTED_36_36=10;
    public static final int T__20=20;
    public static final int T__44=44;
    public static final int T__14=14;
    public static final int T__33=33;
    public static final int T__22=22;
    public static final int QUOTED_60_62=5;
    public static final int WHITESPACE=12;
    public static final int T__29=29;
    public static final int T__45=45;
    public static final int T__43=43;
    public static final int T__31=31;
    public static final int T__40=40;
    public static final int EOF=-1;
    public static final int T__16=16;
    public static final int T__32=32;
    public static final int T__38=38;
    public static final int LINEBREAK=13;
    public static final int T__37=37;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__41=41;
    public static final int T__18=18;
    public static final int QUOTED_34_34=6;

    	public java.util.List<org.antlr.runtime.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime.RecognitionException>();
    	public java.util.List<java.lang.Integer> lexerExceptionsPosition       = new java.util.ArrayList<java.lang.Integer>();
    	
    	public void reportError(org.antlr.runtime.RecognitionException e) {
    		lexerExceptions.add(e);
    		lexerExceptionsPosition.add(((org.antlr.runtime.ANTLRStringStream) input).index());
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
    public String getGrammarFileName() { return "/Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g"; }

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:16:7: ( 'SYNTAXDEF' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:16:9: 'SYNTAXDEF'
            {
            match("SYNTAXDEF"); 


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
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:17:7: ( 'FOR' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:17:9: 'FOR'
            {
            match("FOR"); 


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
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:18:7: ( 'START' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:18:9: 'START'
            {
            match("START"); 


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
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:19:7: ( ',' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:19:9: ','
            {
            match(','); 

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
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:20:7: ( 'IMPORTS' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:20:9: 'IMPORTS'
            {
            match("IMPORTS"); 


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
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:21:7: ( '{' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:21:9: '{'
            {
            match('{'); 

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
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:22:7: ( '}' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:22:9: '}'
            {
            match('}'); 

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
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:23:7: ( 'OPTIONS' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:23:9: 'OPTIONS'
            {
            match("OPTIONS"); 


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
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:24:7: ( ';' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:24:9: ';'
            {
            match(';'); 

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
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:25:7: ( 'TOKENS' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:25:9: 'TOKENS'
            {
            match("TOKENS"); 


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
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:26:7: ( 'TOKENSTYLES' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:26:9: 'TOKENSTYLES'
            {
            match("TOKENSTYLES"); 


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
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:27:7: ( 'RULES' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:27:9: 'RULES'
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
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:28:7: ( ':' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:28:9: ':'
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
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:29:7: ( 'WITH' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:29:9: 'WITH'
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
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:30:7: ( 'SYNTAX' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:30:9: 'SYNTAX'
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
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:31:7: ( '=' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:31:9: '='
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
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:32:7: ( '::=' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:32:9: '::='
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
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:33:7: ( '|' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:33:9: '|'
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
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:34:7: ( '[' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:34:9: '['
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
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:35:7: ( ']' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:35:9: ']'
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
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:36:7: ( '(' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:36:9: '('
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
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:37:7: ( ')' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:37:9: ')'
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
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:38:7: ( '!' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:38:9: '!'
            {
            match('!'); 

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
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:39:7: ( 'DEFINE' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:39:9: 'DEFINE'
            {
            match("DEFINE"); 


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
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:40:7: ( 'COLLECT' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:40:9: 'COLLECT'
            {
            match("COLLECT"); 


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
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:41:7: ( 'IN' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:41:9: 'IN'
            {
            match("IN"); 


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
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:42:7: ( 'PRIORITIZE' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:42:9: 'PRIORITIZE'
            {
            match("PRIORITIZE"); 


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
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:43:7: ( '+' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:43:9: '+'
            {
            match('+'); 

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
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:44:7: ( '*' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:44:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:45:7: ( '?' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:45:9: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:46:7: ( 'ABSTRACT' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:46:9: 'ABSTRACT'
            {
            match("ABSTRACT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:47:7: ( 'COLOR' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:47:9: 'COLOR'
            {
            match("COLOR"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:48:7: ( '@' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:48:9: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "COMMENTS"
    public final void mCOMMENTS() throws RecognitionException {
        try {
            int _type = COMMENTS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2435:9: ( '//' (~ ( '\\n' | '\\r' ) )* )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2436:2: '//' (~ ( '\\n' | '\\r' ) )*
            {
            match("//"); 

            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2436:6: (~ ( '\\n' | '\\r' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2436:7: ~ ( '\\n' | '\\r' )
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

    // $ANTLR start "QUALIFIED_NAME"
    public final void mQUALIFIED_NAME() throws RecognitionException {
        try {
            int _type = QUALIFIED_NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2439:15: ( ( 'A' .. 'Z' | 'a' .. 'z' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )* ( '.' ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )+ )* )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2440:2: ( 'A' .. 'Z' | 'a' .. 'z' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )* ( '.' ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )+ )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2440:25: ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='-'||(LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:
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
            	    break loop2;
                }
            } while (true);

            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2440:62: ( '.' ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )+ )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='.') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2440:63: '.' ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )+
            	    {
            	    match('.'); 
            	    // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2440:66: ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )+
            	    int cnt3=0;
            	    loop3:
            	    do {
            	        int alt3=2;
            	        int LA3_0 = input.LA(1);

            	        if ( (LA3_0=='-'||(LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
            	            alt3=1;
            	        }


            	        switch (alt3) {
            	    	case 1 :
            	    	    // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:
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
            	    	    if ( cnt3 >= 1 ) break loop3;
            	                EarlyExitException eee =
            	                    new EarlyExitException(3, input);
            	                throw eee;
            	        }
            	        cnt3++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QUALIFIED_NAME"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2441:7: ( ( '0' .. '9' )+ )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2442:2: ( '0' .. '9' )+
            {
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2442:2: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2442:3: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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
    // $ANTLR end "NUMBER"

    // $ANTLR start "HEXNUMBER"
    public final void mHEXNUMBER() throws RecognitionException {
        try {
            int _type = HEXNUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2443:10: ( '#' ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+ )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2444:2: '#' ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+
            {
            match('#'); 
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2444:5: ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')||(LA6_0>='A' && LA6_0<='F')||(LA6_0>='a' && LA6_0<='f')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
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
    // $ANTLR end "HEXNUMBER"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2445:11: ( ( ' ' | '\\t' | '\\f' ) )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2446:2: ( ' ' | '\\t' | '\\f' )
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
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "LINEBREAK"
    public final void mLINEBREAK() throws RecognitionException {
        try {
            int _type = LINEBREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2449:10: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2450:2: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2450:2: ( '\\r\\n' | '\\r' | '\\n' )
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
                    // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2450:3: '\\r\\n'
                    {
                    match("\r\n"); 


                    }
                    break;
                case 2 :
                    // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2450:10: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2450:15: '\\n'
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
    // $ANTLR end "LINEBREAK"

    // $ANTLR start "QUOTED_60_62"
    public final void mQUOTED_60_62() throws RecognitionException {
        try {
            int _type = QUOTED_60_62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2453:13: ( ( '<' ) (~ ( '>' ) | ( '\\\\' '>' ) )* ( '>' ) )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2454:2: ( '<' ) (~ ( '>' ) | ( '\\\\' '>' ) )* ( '>' )
            {
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2454:2: ( '<' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2454:3: '<'
            {
            match('<'); 

            }

            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2454:7: (~ ( '>' ) | ( '\\\\' '>' ) )*
            loop8:
            do {
                int alt8=3;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='\\') ) {
                    int LA8_2 = input.LA(2);

                    if ( (LA8_2=='>') ) {
                        int LA8_4 = input.LA(3);

                        if ( ((LA8_4>='\u0000' && LA8_4<='\uFFFF')) ) {
                            alt8=2;
                        }

                        else {
                            alt8=1;
                        }

                    }
                    else if ( ((LA8_2>='\u0000' && LA8_2<='=')||(LA8_2>='?' && LA8_2<='\uFFFF')) ) {
                        alt8=1;
                    }


                }
                else if ( ((LA8_0>='\u0000' && LA8_0<='=')||(LA8_0>='?' && LA8_0<='[')||(LA8_0>=']' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2454:8: ~ ( '>' )
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
            	    // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2454:15: ( '\\\\' '>' )
            	    {
            	    // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2454:15: ( '\\\\' '>' )
            	    // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2454:16: '\\\\' '>'
            	    {
            	    match('\\'); 
            	    match('>'); 

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2454:26: ( '>' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2454:27: '>'
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

    // $ANTLR start "QUOTED_34_34"
    public final void mQUOTED_34_34() throws RecognitionException {
        try {
            int _type = QUOTED_34_34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2456:13: ( ( '\"' ) (~ ( '\"' ) | ( '\\\\' '\"' ) )* ( '\"' ) )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2457:2: ( '\"' ) (~ ( '\"' ) | ( '\\\\' '\"' ) )* ( '\"' )
            {
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2457:2: ( '\"' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2457:3: '\"'
            {
            match('\"'); 

            }

            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2457:7: (~ ( '\"' ) | ( '\\\\' '\"' ) )*
            loop9:
            do {
                int alt9=3;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='\\') ) {
                    int LA9_2 = input.LA(2);

                    if ( (LA9_2=='\"') ) {
                        int LA9_4 = input.LA(3);

                        if ( ((LA9_4>='\u0000' && LA9_4<='\uFFFF')) ) {
                            alt9=2;
                        }

                        else {
                            alt9=1;
                        }

                    }
                    else if ( ((LA9_2>='\u0000' && LA9_2<='!')||(LA9_2>='#' && LA9_2<='\uFFFF')) ) {
                        alt9=1;
                    }


                }
                else if ( ((LA9_0>='\u0000' && LA9_0<='!')||(LA9_0>='#' && LA9_0<='[')||(LA9_0>=']' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2457:8: ~ ( '\"' )
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
            	    // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2457:15: ( '\\\\' '\"' )
            	    {
            	    // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2457:15: ( '\\\\' '\"' )
            	    // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2457:16: '\\\\' '\"'
            	    {
            	    match('\\'); 
            	    match('\"'); 

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2457:26: ( '\"' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2457:27: '\"'
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

    // $ANTLR start "QUOTED_39_39"
    public final void mQUOTED_39_39() throws RecognitionException {
        try {
            int _type = QUOTED_39_39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2459:13: ( ( '\\'' ) (~ ( '\\'' ) | ( '\\\\' '\\'' ) )* ( '\\'' ) )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2460:2: ( '\\'' ) (~ ( '\\'' ) | ( '\\\\' '\\'' ) )* ( '\\'' )
            {
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2460:2: ( '\\'' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2460:3: '\\''
            {
            match('\''); 

            }

            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2460:8: (~ ( '\\'' ) | ( '\\\\' '\\'' ) )*
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
            	    // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2460:9: ~ ( '\\'' )
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
            	    // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2460:17: ( '\\\\' '\\'' )
            	    {
            	    // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2460:17: ( '\\\\' '\\'' )
            	    // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2460:18: '\\\\' '\\''
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

            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2460:29: ( '\\'' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2460:30: '\\''
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
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2462:13: ( ( '$' ) (~ ( '$' ) | ( '\\\\' '$' ) )* ( '$' ) )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2463:2: ( '$' ) (~ ( '$' ) | ( '\\\\' '$' ) )* ( '$' )
            {
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2463:2: ( '$' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2463:3: '$'
            {
            match('$'); 

            }

            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2463:7: (~ ( '$' ) | ( '\\\\' '$' ) )*
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
            	    // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2463:8: ~ ( '$' )
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
            	    // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2463:15: ( '\\\\' '$' )
            	    {
            	    // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2463:15: ( '\\\\' '$' )
            	    // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2463:16: '\\\\' '$'
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

            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2463:26: ( '$' )
            // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:2463:27: '$'
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

    public void mTokens() throws RecognitionException {
        // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:8: ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | COMMENTS | QUALIFIED_NAME | NUMBER | HEXNUMBER | WHITESPACE | LINEBREAK | QUOTED_60_62 | QUOTED_34_34 | QUOTED_39_39 | QUOTED_36_36 )
        int alt12=43;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:10: T__14
                {
                mT__14(); 

                }
                break;
            case 2 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:16: T__15
                {
                mT__15(); 

                }
                break;
            case 3 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:22: T__16
                {
                mT__16(); 

                }
                break;
            case 4 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:28: T__17
                {
                mT__17(); 

                }
                break;
            case 5 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:34: T__18
                {
                mT__18(); 

                }
                break;
            case 6 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:40: T__19
                {
                mT__19(); 

                }
                break;
            case 7 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:46: T__20
                {
                mT__20(); 

                }
                break;
            case 8 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:52: T__21
                {
                mT__21(); 

                }
                break;
            case 9 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:58: T__22
                {
                mT__22(); 

                }
                break;
            case 10 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:64: T__23
                {
                mT__23(); 

                }
                break;
            case 11 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:70: T__24
                {
                mT__24(); 

                }
                break;
            case 12 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:76: T__25
                {
                mT__25(); 

                }
                break;
            case 13 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:82: T__26
                {
                mT__26(); 

                }
                break;
            case 14 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:88: T__27
                {
                mT__27(); 

                }
                break;
            case 15 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:94: T__28
                {
                mT__28(); 

                }
                break;
            case 16 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:100: T__29
                {
                mT__29(); 

                }
                break;
            case 17 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:106: T__30
                {
                mT__30(); 

                }
                break;
            case 18 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:112: T__31
                {
                mT__31(); 

                }
                break;
            case 19 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:118: T__32
                {
                mT__32(); 

                }
                break;
            case 20 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:124: T__33
                {
                mT__33(); 

                }
                break;
            case 21 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:130: T__34
                {
                mT__34(); 

                }
                break;
            case 22 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:136: T__35
                {
                mT__35(); 

                }
                break;
            case 23 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:142: T__36
                {
                mT__36(); 

                }
                break;
            case 24 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:148: T__37
                {
                mT__37(); 

                }
                break;
            case 25 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:154: T__38
                {
                mT__38(); 

                }
                break;
            case 26 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:160: T__39
                {
                mT__39(); 

                }
                break;
            case 27 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:166: T__40
                {
                mT__40(); 

                }
                break;
            case 28 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:172: T__41
                {
                mT__41(); 

                }
                break;
            case 29 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:178: T__42
                {
                mT__42(); 

                }
                break;
            case 30 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:184: T__43
                {
                mT__43(); 

                }
                break;
            case 31 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:190: T__44
                {
                mT__44(); 

                }
                break;
            case 32 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:196: T__45
                {
                mT__45(); 

                }
                break;
            case 33 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:202: T__46
                {
                mT__46(); 

                }
                break;
            case 34 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:208: COMMENTS
                {
                mCOMMENTS(); 

                }
                break;
            case 35 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:217: QUALIFIED_NAME
                {
                mQUALIFIED_NAME(); 

                }
                break;
            case 36 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:232: NUMBER
                {
                mNUMBER(); 

                }
                break;
            case 37 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:239: HEXNUMBER
                {
                mHEXNUMBER(); 

                }
                break;
            case 38 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:249: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;
            case 39 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:260: LINEBREAK
                {
                mLINEBREAK(); 

                }
                break;
            case 40 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:270: QUOTED_60_62
                {
                mQUOTED_60_62(); 

                }
                break;
            case 41 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:283: QUOTED_34_34
                {
                mQUOTED_34_34(); 

                }
                break;
            case 42 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:296: QUOTED_39_39
                {
                mQUOTED_39_39(); 

                }
                break;
            case 43 :
                // /Users/cwende/data/svn/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1:309: QUOTED_36_36
                {
                mQUOTED_36_36(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\2\35\1\uffff\1\35\2\uffff\1\35\1\uffff\2\35\1\57\1\35\7"+
        "\uffff\3\35\3\uffff\1\35\13\uffff\4\35\1\71\3\35\2\uffff\7\35\1"+
        "\104\1\35\1\uffff\12\35\1\uffff\4\35\1\125\6\35\1\134\3\35\1\140"+
        "\1\uffff\2\35\1\143\2\35\1\147\1\uffff\2\35\1\153\1\uffff\1\154"+
        "\1\35\1\uffff\3\35\1\uffff\1\161\1\162\1\35\2\uffff\1\164\3\35\2"+
        "\uffff\1\35\1\uffff\1\35\1\172\1\173\2\35\2\uffff\1\35\1\177\1\u0080"+
        "\2\uffff";
    static final String DFA12_eofS =
        "\u0081\uffff";
    static final String DFA12_minS =
        "\1\11\1\124\1\117\1\uffff\1\115\2\uffff\1\120\1\uffff\1\117\1\125"+
        "\1\72\1\111\7\uffff\1\105\1\117\1\122\3\uffff\1\102\13\uffff\1\116"+
        "\1\101\1\122\1\120\1\55\1\124\1\113\1\114\2\uffff\1\124\1\106\1"+
        "\114\1\111\1\123\1\124\1\122\1\55\1\117\1\uffff\1\111\2\105\1\110"+
        "\1\111\1\114\1\117\1\124\1\101\1\124\1\uffff\1\122\1\117\1\116\1"+
        "\123\1\55\1\116\1\105\3\122\1\130\1\55\1\124\1\116\1\123\1\55\1"+
        "\uffff\1\105\1\103\1\55\1\111\1\101\1\55\1\uffff\2\123\1\55\1\uffff"+
        "\1\55\1\124\1\uffff\1\124\1\103\1\105\1\uffff\2\55\1\131\2\uffff"+
        "\1\55\1\111\1\124\1\106\2\uffff\1\114\1\uffff\1\132\2\55\2\105\2"+
        "\uffff\1\123\2\55\2\uffff";
    static final String DFA12_maxS =
        "\1\175\1\131\1\117\1\uffff\1\116\2\uffff\1\120\1\uffff\1\117\1\125"+
        "\1\72\1\111\7\uffff\1\105\1\117\1\122\3\uffff\1\102\13\uffff\1\116"+
        "\1\101\1\122\1\120\1\172\1\124\1\113\1\114\2\uffff\1\124\1\106\1"+
        "\114\1\111\1\123\1\124\1\122\1\172\1\117\1\uffff\1\111\2\105\1\110"+
        "\1\111\2\117\1\124\1\101\1\124\1\uffff\1\122\1\117\1\116\1\123\1"+
        "\172\1\116\1\105\3\122\1\130\1\172\1\124\1\116\1\123\1\172\1\uffff"+
        "\1\105\1\103\1\172\1\111\1\101\1\172\1\uffff\2\123\1\172\1\uffff"+
        "\1\172\1\124\1\uffff\1\124\1\103\1\105\1\uffff\2\172\1\131\2\uffff"+
        "\1\172\1\111\1\124\1\106\2\uffff\1\114\1\uffff\1\132\2\172\2\105"+
        "\2\uffff\1\123\2\172\2\uffff";
    static final String DFA12_acceptS =
        "\3\uffff\1\4\1\uffff\1\6\1\7\1\uffff\1\11\4\uffff\1\20\1\22\1\23"+
        "\1\24\1\25\1\26\1\27\3\uffff\1\34\1\35\1\36\1\uffff\1\41\1\42\1"+
        "\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\10\uffff\1\21\1\15\11"+
        "\uffff\1\32\12\uffff\1\2\20\uffff\1\16\6\uffff\1\3\3\uffff\1\14"+
        "\2\uffff\1\40\3\uffff\1\17\3\uffff\1\12\1\30\4\uffff\1\5\1\10\1"+
        "\uffff\1\31\5\uffff\1\37\1\1\3\uffff\1\33\1\13";
    static final String DFA12_specialS =
        "\u0081\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\40\1\41\1\uffff\1\40\1\41\22\uffff\1\40\1\23\1\43\1\37\1"+
            "\45\2\uffff\1\44\1\21\1\22\1\30\1\27\1\3\2\uffff\1\34\12\36"+
            "\1\13\1\10\1\42\1\15\1\uffff\1\31\1\33\1\32\1\35\1\25\1\24\1"+
            "\35\1\2\2\35\1\4\5\35\1\7\1\26\1\35\1\12\1\1\1\11\2\35\1\14"+
            "\3\35\1\17\1\uffff\1\20\1\uffff\1\35\1\uffff\32\35\1\5\1\16"+
            "\1\6",
            "\1\47\4\uffff\1\46",
            "\1\50",
            "",
            "\1\51\1\52",
            "",
            "",
            "\1\53",
            "",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\60",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\61",
            "\1\62",
            "\1\63",
            "",
            "",
            "",
            "\1\64",
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
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\2\35\1\uffff\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\72",
            "\1\73",
            "\1\74",
            "",
            "",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\2\35\1\uffff\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\105",
            "",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113\2\uffff\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\2\35\1\uffff\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\2\35\1\uffff\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\135",
            "\1\136",
            "\1\137",
            "\2\35\1\uffff\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "",
            "\1\141",
            "\1\142",
            "\2\35\1\uffff\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\144",
            "\1\145",
            "\2\35\1\uffff\12\35\7\uffff\3\35\1\146\26\35\4\uffff\1\35\1"+
            "\uffff\32\35",
            "",
            "\1\150",
            "\1\151",
            "\2\35\1\uffff\12\35\7\uffff\23\35\1\152\6\35\4\uffff\1\35\1"+
            "\uffff\32\35",
            "",
            "\2\35\1\uffff\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\155",
            "",
            "\1\156",
            "\1\157",
            "\1\160",
            "",
            "\2\35\1\uffff\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\2\35\1\uffff\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\163",
            "",
            "",
            "\2\35\1\uffff\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\165",
            "\1\166",
            "\1\167",
            "",
            "",
            "\1\170",
            "",
            "\1\171",
            "\2\35\1\uffff\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\2\35\1\uffff\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\174",
            "\1\175",
            "",
            "",
            "\1\176",
            "\2\35\1\uffff\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\2\35\1\uffff\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | COMMENTS | QUALIFIED_NAME | NUMBER | HEXNUMBER | WHITESPACE | LINEBREAK | QUOTED_60_62 | QUOTED_34_34 | QUOTED_39_39 | QUOTED_36_36 );";
        }
    }
 

}