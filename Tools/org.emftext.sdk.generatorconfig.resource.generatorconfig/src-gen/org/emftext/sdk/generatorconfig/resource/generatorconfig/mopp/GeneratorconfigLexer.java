/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
// $ANTLR ${project.version} ${buildNumber}

	package org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp;


import org.antlr.runtime3_2_0.*;

public class GeneratorconfigLexer extends Lexer {
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__51=51;
    public static final int T__16=16;
    public static final int T__52=52;
    public static final int T__15=15;
    public static final int COMMENTS=11;
    public static final int T__18=18;
    public static final int T__53=53;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int QUOTED_36_36=10;
    public static final int QUOTED_39_39_92=7;
    public static final int T__50=50;
    public static final int LINEBREAK=13;
    public static final int HEXNUMBER=8;
    public static final int QUALIFIED_NAME=4;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int NUMBER=9;
    public static final int WHITESPACE=12;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int QUOTED_34_34_92=6;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int QUOTED_60_62=5;

    	public java.util.List<org.antlr.runtime3_2_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_2_0.RecognitionException>();
    	public java.util.List<java.lang.Integer> lexerExceptionsPosition = new java.util.ArrayList<java.lang.Integer>();
    	
    	public void reportError(org.antlr.runtime3_2_0.RecognitionException e) {
    		lexerExceptions.add(e);
    		lexerExceptionsPosition.add(((org.antlr.runtime3_2_0.ANTLRStringStream) input).index());
    	}


    // delegates
    // delegators

    public GeneratorconfigLexer() {;} 
    public GeneratorconfigLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public GeneratorconfigLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "Generatorconfig.g"; }

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Generatorconfig.g:16:7: ( '::=' )
            // Generatorconfig.g:16:9: '::='
            {
            match("::="); 


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
            // Generatorconfig.g:17:7: ( ';' )
            // Generatorconfig.g:17:9: ';'
            {
            match(';'); 

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
            // Generatorconfig.g:18:7: ( 'ClassRule' )
            // Generatorconfig.g:18:9: 'ClassRule'
            {
            match("ClassRule"); 


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
            // Generatorconfig.g:19:7: ( 'FeatureRule' )
            // Generatorconfig.g:19:9: 'FeatureRule'
            {
            match("FeatureRule"); 


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
            // Generatorconfig.g:20:7: ( 'FEATURE' )
            // Generatorconfig.g:20:9: 'FEATURE'
            {
            match("FEATURE"); 


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
            // Generatorconfig.g:21:7: ( '(' )
            // Generatorconfig.g:21:9: '('
            {
            match('('); 

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
            // Generatorconfig.g:22:7: ( ')' )
            // Generatorconfig.g:22:9: ')'
            {
            match(')'); 

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
            // Generatorconfig.g:23:7: ( 'CLASSNAME' )
            // Generatorconfig.g:23:9: 'CLASSNAME'
            {
            match("CLASSNAME"); 


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
            // Generatorconfig.g:24:7: ( 'FEATURES' )
            // Generatorconfig.g:24:9: 'FEATURES'
            {
            match("FEATURES"); 


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
            // Generatorconfig.g:25:7: ( 'FEATURENAME' )
            // Generatorconfig.g:25:9: 'FEATURENAME'
            {
            match("FEATURENAME"); 


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
            // Generatorconfig.g:26:7: ( 'SYNTAXDEF' )
            // Generatorconfig.g:26:9: 'SYNTAXDEF'
            {
            match("SYNTAXDEF"); 


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
            // Generatorconfig.g:27:7: ( 'FOR' )
            // Generatorconfig.g:27:9: 'FOR'
            {
            match("FOR"); 


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
            // Generatorconfig.g:28:7: ( 'START' )
            // Generatorconfig.g:28:9: 'START'
            {
            match("START"); 


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
            // Generatorconfig.g:29:7: ( ',' )
            // Generatorconfig.g:29:9: ','
            {
            match(','); 

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
            // Generatorconfig.g:30:7: ( 'IMPORTS' )
            // Generatorconfig.g:30:9: 'IMPORTS'
            {
            match("IMPORTS"); 


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
            // Generatorconfig.g:31:7: ( '{' )
            // Generatorconfig.g:31:9: '{'
            {
            match('{'); 

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
            // Generatorconfig.g:32:7: ( '}' )
            // Generatorconfig.g:32:9: '}'
            {
            match('}'); 

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
            // Generatorconfig.g:33:7: ( 'OPTIONS' )
            // Generatorconfig.g:33:9: 'OPTIONS'
            {
            match("OPTIONS"); 


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
            // Generatorconfig.g:34:7: ( 'TOKENS' )
            // Generatorconfig.g:34:9: 'TOKENS'
            {
            match("TOKENS"); 


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
            // Generatorconfig.g:35:7: ( 'TOKENSTYLES' )
            // Generatorconfig.g:35:9: 'TOKENSTYLES'
            {
            match("TOKENSTYLES"); 


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
            // Generatorconfig.g:36:7: ( 'RULES' )
            // Generatorconfig.g:36:9: 'RULES'
            {
            match("RULES"); 


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
            // Generatorconfig.g:37:7: ( ':' )
            // Generatorconfig.g:37:9: ':'
            {
            match(':'); 

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
            // Generatorconfig.g:38:7: ( 'WITH' )
            // Generatorconfig.g:38:9: 'WITH'
            {
            match("WITH"); 


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
            // Generatorconfig.g:39:7: ( 'SYNTAX' )
            // Generatorconfig.g:39:9: 'SYNTAX'
            {
            match("SYNTAX"); 


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
            // Generatorconfig.g:40:7: ( '=' )
            // Generatorconfig.g:40:9: '='
            {
            match('='); 

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
            // Generatorconfig.g:41:7: ( '|' )
            // Generatorconfig.g:41:9: '|'
            {
            match('|'); 

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
            // Generatorconfig.g:42:7: ( '[' )
            // Generatorconfig.g:42:9: '['
            {
            match('['); 

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
            // Generatorconfig.g:43:7: ( ']' )
            // Generatorconfig.g:43:9: ']'
            {
            match(']'); 

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
            // Generatorconfig.g:44:7: ( '!' )
            // Generatorconfig.g:44:9: '!'
            {
            match('!'); 

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
            // Generatorconfig.g:45:7: ( 'DEFINE' )
            // Generatorconfig.g:45:9: 'DEFINE'
            {
            match("DEFINE"); 


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
            // Generatorconfig.g:46:7: ( '+' )
            // Generatorconfig.g:46:9: '+'
            {
            match('+'); 

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
            // Generatorconfig.g:47:7: ( 'COLLECT' )
            // Generatorconfig.g:47:9: 'COLLECT'
            {
            match("COLLECT"); 


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
            // Generatorconfig.g:48:7: ( 'IN' )
            // Generatorconfig.g:48:9: 'IN'
            {
            match("IN"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Generatorconfig.g:49:7: ( 'FRAGMENT' )
            // Generatorconfig.g:49:9: 'FRAGMENT'
            {
            match("FRAGMENT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Generatorconfig.g:50:7: ( 'PRIORITIZE' )
            // Generatorconfig.g:50:9: 'PRIORITIZE'
            {
            match("PRIORITIZE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Generatorconfig.g:51:7: ( '*' )
            // Generatorconfig.g:51:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Generatorconfig.g:52:7: ( '?' )
            // Generatorconfig.g:52:9: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Generatorconfig.g:53:7: ( 'ABSTRACT' )
            // Generatorconfig.g:53:9: 'ABSTRACT'
            {
            match("ABSTRACT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Generatorconfig.g:54:7: ( 'COLOR' )
            // Generatorconfig.g:54:9: 'COLOR'
            {
            match("COLOR"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Generatorconfig.g:55:7: ( '@' )
            // Generatorconfig.g:55:9: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "COMMENTS"
    public final void mCOMMENTS() throws RecognitionException {
        try {
            int _type = COMMENTS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Generatorconfig.g:5926:9: ( '//' (~ ( '\\n' | '\\r' ) )* )
            // Generatorconfig.g:5927:2: '//' (~ ( '\\n' | '\\r' ) )*
            {
            match("//"); 

            // Generatorconfig.g:5927:6: (~ ( '\\n' | '\\r' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Generatorconfig.g:5927:7: ~ ( '\\n' | '\\r' )
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
            // Generatorconfig.g:5930:15: ( ( 'A' .. 'Z' | 'a' .. 'z' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )* ( '.' ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )+ )* )
            // Generatorconfig.g:5931:2: ( 'A' .. 'Z' | 'a' .. 'z' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )* ( '.' ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )+ )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // Generatorconfig.g:5931:25: ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='-'||(LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Generatorconfig.g:
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

            // Generatorconfig.g:5931:62: ( '.' ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )+ )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='.') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Generatorconfig.g:5931:63: '.' ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )+
            	    {
            	    match('.'); 
            	    // Generatorconfig.g:5931:66: ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '-' | '0' .. '9' )+
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
            	    	    // Generatorconfig.g:
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
            // Generatorconfig.g:5932:7: ( ( '0' .. '9' )+ )
            // Generatorconfig.g:5933:2: ( '0' .. '9' )+
            {
            // Generatorconfig.g:5933:2: ( '0' .. '9' )+
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
            	    // Generatorconfig.g:5933:3: '0' .. '9'
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
            // Generatorconfig.g:5934:10: ( '#' ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+ )
            // Generatorconfig.g:5935:2: '#' ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+
            {
            match('#'); 
            // Generatorconfig.g:5935:5: ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+
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
            	    // Generatorconfig.g:
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
            // Generatorconfig.g:5936:11: ( ( ' ' | '\\t' | '\\f' ) )
            // Generatorconfig.g:5937:2: ( ' ' | '\\t' | '\\f' )
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
            // Generatorconfig.g:5940:10: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Generatorconfig.g:5941:2: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Generatorconfig.g:5941:2: ( '\\r\\n' | '\\r' | '\\n' )
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
                    // Generatorconfig.g:5941:3: '\\r\\n'
                    {
                    match("\r\n"); 


                    }
                    break;
                case 2 :
                    // Generatorconfig.g:5941:10: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Generatorconfig.g:5941:15: '\\n'
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
            // Generatorconfig.g:5944:13: ( ( '<' ) (~ ( '>' ) )* ( '>' ) )
            // Generatorconfig.g:5945:2: ( '<' ) (~ ( '>' ) )* ( '>' )
            {
            // Generatorconfig.g:5945:2: ( '<' )
            // Generatorconfig.g:5945:3: '<'
            {
            match('<'); 

            }

            // Generatorconfig.g:5945:7: (~ ( '>' ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='=')||(LA8_0>='?' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // Generatorconfig.g:5945:8: ~ ( '>' )
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

            	default :
            	    break loop8;
                }
            } while (true);

            // Generatorconfig.g:5945:16: ( '>' )
            // Generatorconfig.g:5945:17: '>'
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

    // $ANTLR start "QUOTED_34_34_92"
    public final void mQUOTED_34_34_92() throws RecognitionException {
        try {
            int _type = QUOTED_34_34_92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Generatorconfig.g:5947:16: ( ( '\"' ) ( ( '\\\\' '\"' ) | ( '\\\\' '\\\\' ) | ~ ( '\"' | '\\\\' ) )* ( '\"' ) )
            // Generatorconfig.g:5948:2: ( '\"' ) ( ( '\\\\' '\"' ) | ( '\\\\' '\\\\' ) | ~ ( '\"' | '\\\\' ) )* ( '\"' )
            {
            // Generatorconfig.g:5948:2: ( '\"' )
            // Generatorconfig.g:5948:3: '\"'
            {
            match('\"'); 

            }

            // Generatorconfig.g:5948:7: ( ( '\\\\' '\"' ) | ( '\\\\' '\\\\' ) | ~ ( '\"' | '\\\\' ) )*
            loop9:
            do {
                int alt9=4;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='\\') ) {
                    int LA9_2 = input.LA(2);

                    if ( (LA9_2=='\"') ) {
                        alt9=1;
                    }
                    else if ( (LA9_2=='\\') ) {
                        alt9=2;
                    }


                }
                else if ( ((LA9_0>='\u0000' && LA9_0<='!')||(LA9_0>='#' && LA9_0<='[')||(LA9_0>=']' && LA9_0<='\uFFFF')) ) {
                    alt9=3;
                }


                switch (alt9) {
            	case 1 :
            	    // Generatorconfig.g:5948:8: ( '\\\\' '\"' )
            	    {
            	    // Generatorconfig.g:5948:8: ( '\\\\' '\"' )
            	    // Generatorconfig.g:5948:9: '\\\\' '\"'
            	    {
            	    match('\\'); 
            	    match('\"'); 

            	    }


            	    }
            	    break;
            	case 2 :
            	    // Generatorconfig.g:5948:18: ( '\\\\' '\\\\' )
            	    {
            	    // Generatorconfig.g:5948:18: ( '\\\\' '\\\\' )
            	    // Generatorconfig.g:5948:19: '\\\\' '\\\\'
            	    {
            	    match('\\'); 
            	    match('\\'); 

            	    }


            	    }
            	    break;
            	case 3 :
            	    // Generatorconfig.g:5948:29: ~ ( '\"' | '\\\\' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // Generatorconfig.g:5948:42: ( '\"' )
            // Generatorconfig.g:5948:43: '\"'
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
    // $ANTLR end "QUOTED_34_34_92"

    // $ANTLR start "QUOTED_39_39_92"
    public final void mQUOTED_39_39_92() throws RecognitionException {
        try {
            int _type = QUOTED_39_39_92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Generatorconfig.g:5950:16: ( ( '\\'' ) ( ( '\\\\' '\\'' ) | ( '\\\\' '\\\\' ) | ~ ( '\\'' | '\\\\' ) )* ( '\\'' ) )
            // Generatorconfig.g:5951:2: ( '\\'' ) ( ( '\\\\' '\\'' ) | ( '\\\\' '\\\\' ) | ~ ( '\\'' | '\\\\' ) )* ( '\\'' )
            {
            // Generatorconfig.g:5951:2: ( '\\'' )
            // Generatorconfig.g:5951:3: '\\''
            {
            match('\''); 

            }

            // Generatorconfig.g:5951:8: ( ( '\\\\' '\\'' ) | ( '\\\\' '\\\\' ) | ~ ( '\\'' | '\\\\' ) )*
            loop10:
            do {
                int alt10=4;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='\\') ) {
                    int LA10_2 = input.LA(2);

                    if ( (LA10_2=='\'') ) {
                        alt10=1;
                    }
                    else if ( (LA10_2=='\\') ) {
                        alt10=2;
                    }


                }
                else if ( ((LA10_0>='\u0000' && LA10_0<='&')||(LA10_0>='(' && LA10_0<='[')||(LA10_0>=']' && LA10_0<='\uFFFF')) ) {
                    alt10=3;
                }


                switch (alt10) {
            	case 1 :
            	    // Generatorconfig.g:5951:9: ( '\\\\' '\\'' )
            	    {
            	    // Generatorconfig.g:5951:9: ( '\\\\' '\\'' )
            	    // Generatorconfig.g:5951:10: '\\\\' '\\''
            	    {
            	    match('\\'); 
            	    match('\''); 

            	    }


            	    }
            	    break;
            	case 2 :
            	    // Generatorconfig.g:5951:20: ( '\\\\' '\\\\' )
            	    {
            	    // Generatorconfig.g:5951:20: ( '\\\\' '\\\\' )
            	    // Generatorconfig.g:5951:21: '\\\\' '\\\\'
            	    {
            	    match('\\'); 
            	    match('\\'); 

            	    }


            	    }
            	    break;
            	case 3 :
            	    // Generatorconfig.g:5951:31: ~ ( '\\'' | '\\\\' )
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

            	default :
            	    break loop10;
                }
            } while (true);

            // Generatorconfig.g:5951:45: ( '\\'' )
            // Generatorconfig.g:5951:46: '\\''
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
    // $ANTLR end "QUOTED_39_39_92"

    // $ANTLR start "QUOTED_36_36"
    public final void mQUOTED_36_36() throws RecognitionException {
        try {
            int _type = QUOTED_36_36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Generatorconfig.g:5953:13: ( ( '$' ) (~ ( '$' ) )* ( '$' ) )
            // Generatorconfig.g:5954:2: ( '$' ) (~ ( '$' ) )* ( '$' )
            {
            // Generatorconfig.g:5954:2: ( '$' )
            // Generatorconfig.g:5954:3: '$'
            {
            match('$'); 

            }

            // Generatorconfig.g:5954:7: (~ ( '$' ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\u0000' && LA11_0<='#')||(LA11_0>='%' && LA11_0<='\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // Generatorconfig.g:5954:8: ~ ( '$' )
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

            	default :
            	    break loop11;
                }
            } while (true);

            // Generatorconfig.g:5954:16: ( '$' )
            // Generatorconfig.g:5954:17: '$'
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
        // Generatorconfig.g:1:8: ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | COMMENTS | QUALIFIED_NAME | NUMBER | HEXNUMBER | WHITESPACE | LINEBREAK | QUOTED_60_62 | QUOTED_34_34_92 | QUOTED_39_39_92 | QUOTED_36_36 )
        int alt12=50;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // Generatorconfig.g:1:10: T__14
                {
                mT__14(); 

                }
                break;
            case 2 :
                // Generatorconfig.g:1:16: T__15
                {
                mT__15(); 

                }
                break;
            case 3 :
                // Generatorconfig.g:1:22: T__16
                {
                mT__16(); 

                }
                break;
            case 4 :
                // Generatorconfig.g:1:28: T__17
                {
                mT__17(); 

                }
                break;
            case 5 :
                // Generatorconfig.g:1:34: T__18
                {
                mT__18(); 

                }
                break;
            case 6 :
                // Generatorconfig.g:1:40: T__19
                {
                mT__19(); 

                }
                break;
            case 7 :
                // Generatorconfig.g:1:46: T__20
                {
                mT__20(); 

                }
                break;
            case 8 :
                // Generatorconfig.g:1:52: T__21
                {
                mT__21(); 

                }
                break;
            case 9 :
                // Generatorconfig.g:1:58: T__22
                {
                mT__22(); 

                }
                break;
            case 10 :
                // Generatorconfig.g:1:64: T__23
                {
                mT__23(); 

                }
                break;
            case 11 :
                // Generatorconfig.g:1:70: T__24
                {
                mT__24(); 

                }
                break;
            case 12 :
                // Generatorconfig.g:1:76: T__25
                {
                mT__25(); 

                }
                break;
            case 13 :
                // Generatorconfig.g:1:82: T__26
                {
                mT__26(); 

                }
                break;
            case 14 :
                // Generatorconfig.g:1:88: T__27
                {
                mT__27(); 

                }
                break;
            case 15 :
                // Generatorconfig.g:1:94: T__28
                {
                mT__28(); 

                }
                break;
            case 16 :
                // Generatorconfig.g:1:100: T__29
                {
                mT__29(); 

                }
                break;
            case 17 :
                // Generatorconfig.g:1:106: T__30
                {
                mT__30(); 

                }
                break;
            case 18 :
                // Generatorconfig.g:1:112: T__31
                {
                mT__31(); 

                }
                break;
            case 19 :
                // Generatorconfig.g:1:118: T__32
                {
                mT__32(); 

                }
                break;
            case 20 :
                // Generatorconfig.g:1:124: T__33
                {
                mT__33(); 

                }
                break;
            case 21 :
                // Generatorconfig.g:1:130: T__34
                {
                mT__34(); 

                }
                break;
            case 22 :
                // Generatorconfig.g:1:136: T__35
                {
                mT__35(); 

                }
                break;
            case 23 :
                // Generatorconfig.g:1:142: T__36
                {
                mT__36(); 

                }
                break;
            case 24 :
                // Generatorconfig.g:1:148: T__37
                {
                mT__37(); 

                }
                break;
            case 25 :
                // Generatorconfig.g:1:154: T__38
                {
                mT__38(); 

                }
                break;
            case 26 :
                // Generatorconfig.g:1:160: T__39
                {
                mT__39(); 

                }
                break;
            case 27 :
                // Generatorconfig.g:1:166: T__40
                {
                mT__40(); 

                }
                break;
            case 28 :
                // Generatorconfig.g:1:172: T__41
                {
                mT__41(); 

                }
                break;
            case 29 :
                // Generatorconfig.g:1:178: T__42
                {
                mT__42(); 

                }
                break;
            case 30 :
                // Generatorconfig.g:1:184: T__43
                {
                mT__43(); 

                }
                break;
            case 31 :
                // Generatorconfig.g:1:190: T__44
                {
                mT__44(); 

                }
                break;
            case 32 :
                // Generatorconfig.g:1:196: T__45
                {
                mT__45(); 

                }
                break;
            case 33 :
                // Generatorconfig.g:1:202: T__46
                {
                mT__46(); 

                }
                break;
            case 34 :
                // Generatorconfig.g:1:208: T__47
                {
                mT__47(); 

                }
                break;
            case 35 :
                // Generatorconfig.g:1:214: T__48
                {
                mT__48(); 

                }
                break;
            case 36 :
                // Generatorconfig.g:1:220: T__49
                {
                mT__49(); 

                }
                break;
            case 37 :
                // Generatorconfig.g:1:226: T__50
                {
                mT__50(); 

                }
                break;
            case 38 :
                // Generatorconfig.g:1:232: T__51
                {
                mT__51(); 

                }
                break;
            case 39 :
                // Generatorconfig.g:1:238: T__52
                {
                mT__52(); 

                }
                break;
            case 40 :
                // Generatorconfig.g:1:244: T__53
                {
                mT__53(); 

                }
                break;
            case 41 :
                // Generatorconfig.g:1:250: COMMENTS
                {
                mCOMMENTS(); 

                }
                break;
            case 42 :
                // Generatorconfig.g:1:259: QUALIFIED_NAME
                {
                mQUALIFIED_NAME(); 

                }
                break;
            case 43 :
                // Generatorconfig.g:1:274: NUMBER
                {
                mNUMBER(); 

                }
                break;
            case 44 :
                // Generatorconfig.g:1:281: HEXNUMBER
                {
                mHEXNUMBER(); 

                }
                break;
            case 45 :
                // Generatorconfig.g:1:291: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;
            case 46 :
                // Generatorconfig.g:1:302: LINEBREAK
                {
                mLINEBREAK(); 

                }
                break;
            case 47 :
                // Generatorconfig.g:1:312: QUOTED_60_62
                {
                mQUOTED_60_62(); 

                }
                break;
            case 48 :
                // Generatorconfig.g:1:325: QUOTED_34_34_92
                {
                mQUOTED_34_34_92(); 

                }
                break;
            case 49 :
                // Generatorconfig.g:1:341: QUOTED_39_39_92
                {
                mQUOTED_39_39_92(); 

                }
                break;
            case 50 :
                // Generatorconfig.g:1:357: QUOTED_36_36
                {
                mQUOTED_36_36(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\1\47\1\uffff\2\35\2\uffff\1\35\1\uffff\1\35\2\uffff\4"+
        "\35\5\uffff\1\35\1\uffff\1\35\2\uffff\1\35\15\uffff\12\35\1\104"+
        "\14\35\1\122\4\35\1\uffff\15\35\1\uffff\7\35\1\153\6\35\1\162\4"+
        "\35\1\167\3\35\1\173\1\uffff\6\35\1\uffff\3\35\1\u0086\1\uffff\2"+
        "\35\1\u008a\1\uffff\1\u008b\4\35\1\u0090\1\35\1\u0094\2\35\1\uffff"+
        "\1\u0097\1\u0098\1\35\2\uffff\4\35\1\uffff\1\35\1\u009f\1\35\1\uffff"+
        "\1\u00a1\1\35\2\uffff\2\35\1\u00a5\1\u00a6\1\u00a7\1\35\1\uffff"+
        "\1\35\1\uffff\1\u00aa\2\35\3\uffff\2\35\1\uffff\1\35\1\u00b0\1\u00b1"+
        "\1\u00b2\1\u00b3\4\uffff";
    static final String DFA12_eofS =
        "\u00b4\uffff";
    static final String DFA12_minS =
        "\1\11\1\72\1\uffff\1\114\1\105\2\uffff\1\124\1\uffff\1\115\2\uffff"+
        "\1\120\1\117\1\125\1\111\5\uffff\1\105\1\uffff\1\122\2\uffff\1\102"+
        "\15\uffff\1\141\1\101\1\114\1\141\1\101\1\122\1\101\1\116\1\101"+
        "\1\120\1\55\1\124\1\113\1\114\1\124\1\106\1\111\1\123\1\163\1\123"+
        "\1\114\1\164\1\124\1\55\1\107\1\124\1\122\1\117\1\uffff\1\111\2"+
        "\105\1\110\1\111\1\117\1\124\1\163\1\123\1\105\1\122\1\165\1\125"+
        "\1\uffff\1\115\1\101\1\124\1\122\1\117\1\116\1\123\1\55\1\116\3"+
        "\122\1\116\1\103\1\55\1\162\1\122\1\105\1\130\1\55\1\124\1\116\1"+
        "\123\1\55\1\uffff\1\105\1\111\1\101\1\165\1\101\1\124\1\uffff\1"+
        "\145\1\105\1\116\1\55\1\uffff\2\123\1\55\1\uffff\1\55\1\124\1\103"+
        "\1\154\1\115\1\55\1\122\1\55\1\124\1\105\1\uffff\2\55\1\131\2\uffff"+
        "\1\111\1\124\1\145\1\105\1\uffff\1\165\1\55\1\101\1\uffff\1\55\1"+
        "\106\2\uffff\1\114\1\132\3\55\1\154\1\uffff\1\115\1\uffff\1\55\2"+
        "\105\3\uffff\1\145\1\105\1\uffff\1\123\4\55\4\uffff";
    static final String DFA12_maxS =
        "\1\175\1\72\1\uffff\1\154\1\145\2\uffff\1\131\1\uffff\1\116\2\uffff"+
        "\1\120\1\117\1\125\1\111\5\uffff\1\105\1\uffff\1\122\2\uffff\1\102"+
        "\15\uffff\1\141\1\101\1\114\1\141\1\101\1\122\1\101\1\116\1\101"+
        "\1\120\1\172\1\124\1\113\1\114\1\124\1\106\1\111\1\123\1\163\1\123"+
        "\1\117\1\164\1\124\1\172\1\107\1\124\1\122\1\117\1\uffff\1\111\2"+
        "\105\1\110\1\111\1\117\1\124\1\163\1\123\1\105\1\122\1\165\1\125"+
        "\1\uffff\1\115\1\101\1\124\1\122\1\117\1\116\1\123\1\172\1\116\3"+
        "\122\1\116\1\103\1\172\1\162\1\122\1\105\1\130\1\172\1\124\1\116"+
        "\1\123\1\172\1\uffff\1\105\1\111\1\101\1\165\1\101\1\124\1\uffff"+
        "\1\145\1\105\1\116\1\172\1\uffff\2\123\1\172\1\uffff\1\172\1\124"+
        "\1\103\1\154\1\115\1\172\1\122\1\172\1\124\1\105\1\uffff\2\172\1"+
        "\131\2\uffff\1\111\1\124\1\145\1\105\1\uffff\1\165\1\172\1\101\1"+
        "\uffff\1\172\1\106\2\uffff\1\114\1\132\3\172\1\154\1\uffff\1\115"+
        "\1\uffff\1\172\2\105\3\uffff\1\145\1\105\1\uffff\1\123\4\172\4\uffff";
    static final String DFA12_acceptS =
        "\2\uffff\1\2\2\uffff\1\6\1\7\1\uffff\1\16\1\uffff\1\20\1\21\4\uffff"+
        "\1\31\1\32\1\33\1\34\1\35\1\uffff\1\37\1\uffff\1\44\1\45\1\uffff"+
        "\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\1\1\26"+
        "\34\uffff\1\41\15\uffff\1\14\30\uffff\1\27\6\uffff\1\47\4\uffff"+
        "\1\15\3\uffff\1\25\12\uffff\1\30\3\uffff\1\23\1\36\4\uffff\1\40"+
        "\3\uffff\1\5\2\uffff\1\17\1\22\6\uffff\1\11\1\uffff\1\42\3\uffff"+
        "\1\46\1\3\1\10\2\uffff\1\13\5\uffff\1\43\1\4\1\12\1\24";
    static final String DFA12_specialS =
        "\u00b4\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\40\1\41\1\uffff\1\40\1\41\22\uffff\1\40\1\24\1\43\1\37\1"+
            "\45\2\uffff\1\44\1\5\1\6\1\30\1\26\1\10\2\uffff\1\34\12\36\1"+
            "\1\1\2\1\42\1\20\1\uffff\1\31\1\33\1\32\1\35\1\3\1\25\1\35\1"+
            "\4\2\35\1\11\5\35\1\14\1\27\1\35\1\16\1\7\1\15\2\35\1\17\3\35"+
            "\1\22\1\uffff\1\23\1\uffff\1\35\1\uffff\32\35\1\12\1\21\1\13",
            "\1\46",
            "",
            "\1\51\2\uffff\1\52\34\uffff\1\50",
            "\1\54\11\uffff\1\55\2\uffff\1\56\22\uffff\1\53",
            "",
            "",
            "\1\60\4\uffff\1\57",
            "",
            "\1\61\1\62",
            "",
            "",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "",
            "",
            "",
            "",
            "",
            "\1\67",
            "",
            "\1\70",
            "",
            "",
            "\1\71",
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
            "",
            "",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\2\35\1\uffff\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32"+
            "\35",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116\2\uffff\1\117",
            "\1\120",
            "\1\121",
            "\2\35\1\uffff\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32"+
            "\35",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\2\35\1\uffff\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32"+
            "\35",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "\2\35\1\uffff\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32"+
            "\35",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\2\35\1\uffff\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32"+
            "\35",
            "\1\170",
            "\1\171",
            "\1\172",
            "\2\35\1\uffff\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32"+
            "\35",
            "",
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\2\35\1\uffff\12\35\7\uffff\3\35\1\u0085\26\35\4\uffff\1\35"+
            "\1\uffff\32\35",
            "",
            "\1\u0087",
            "\1\u0088",
            "\2\35\1\uffff\12\35\7\uffff\23\35\1\u0089\6\35\4\uffff\1\35"+
            "\1\uffff\32\35",
            "",
            "\2\35\1\uffff\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32"+
            "\35",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\2\35\1\uffff\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32"+
            "\35",
            "\1\u0091",
            "\2\35\1\uffff\12\35\7\uffff\15\35\1\u0093\4\35\1\u0092\7\35"+
            "\4\uffff\1\35\1\uffff\32\35",
            "\1\u0095",
            "\1\u0096",
            "",
            "\2\35\1\uffff\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32"+
            "\35",
            "\2\35\1\uffff\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32"+
            "\35",
            "\1\u0099",
            "",
            "",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "",
            "\1\u009e",
            "\2\35\1\uffff\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32"+
            "\35",
            "\1\u00a0",
            "",
            "\2\35\1\uffff\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32"+
            "\35",
            "\1\u00a2",
            "",
            "",
            "\1\u00a3",
            "\1\u00a4",
            "\2\35\1\uffff\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32"+
            "\35",
            "\2\35\1\uffff\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32"+
            "\35",
            "\2\35\1\uffff\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32"+
            "\35",
            "\1\u00a8",
            "",
            "\1\u00a9",
            "",
            "\2\35\1\uffff\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32"+
            "\35",
            "\1\u00ab",
            "\1\u00ac",
            "",
            "",
            "",
            "\1\u00ad",
            "\1\u00ae",
            "",
            "\1\u00af",
            "\2\35\1\uffff\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32"+
            "\35",
            "\2\35\1\uffff\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32"+
            "\35",
            "\2\35\1\uffff\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32"+
            "\35",
            "\2\35\1\uffff\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32"+
            "\35",
            "",
            "",
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
            return "1:1: Tokens : ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | COMMENTS | QUALIFIED_NAME | NUMBER | HEXNUMBER | WHITESPACE | LINEBREAK | QUOTED_60_62 | QUOTED_34_34_92 | QUOTED_39_39_92 | QUOTED_36_36 );";
        }
    }
 

}
