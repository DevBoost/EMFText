// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g 2011-08-25 17:56:52

/*
 * [The "BSD license"]
 *  Copyright (c) 2011 Terence Parr
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions
 *  are met:
 *  1. Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *  3. The name of the author may not be used to endorse or promote products
 *     derived from this software without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 *  IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 *  OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 *  IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 *  INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 *  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 *  DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 *  THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 *  THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.stringtemplate.v4.compiler;
import java.io.File;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.DFA;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.misc.ErrorType;

public class GroupLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__14=14;
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
    public static final int TRUE=4;
    public static final int FALSE=5;
    public static final int STRING=6;
    public static final int ID=7;
    public static final int BIGSTRING=8;
    public static final int BIGSTRING_NO_NL=9;
    public static final int ANONYMOUS_TEMPLATE=10;
    public static final int COMMENT=11;
    public static final int LINE_COMMENT=12;
    public static final int WS=13;

    public STGroup group;

    public void reportError(RecognitionException e) {
        String msg = null;
        if ( e instanceof NoViableAltException ) {
            msg = "invalid character '"+(char)input.LA(1)+"'";
        }
        else if ( e instanceof MismatchedTokenException && ((MismatchedTokenException)e).expecting=='"' ) {
            msg = "unterminated string";
        }
        else {
            msg = getErrorMessage(e, getTokenNames());
        }
        group.errMgr.groupSyntaxError(ErrorType.SYNTAX_ERROR, getSourceName(), e, msg);
    }
    public String getSourceName() {
        String fullFileName = super.getSourceName();
        File f = new File(fullFileName); // strip to simple name
        return f.getName();
    }


    // delegates
    // delegators

    public GroupLexer() {;} 
    public GroupLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public GroupLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g"; }

    // $ANTLR start "TRUE"
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:59:6: ( 'true' )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:59:8: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TRUE"

    // $ANTLR start "FALSE"
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:60:7: ( 'false' )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:60:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FALSE"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:61:7: ( 'import' )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:61:9: 'import'
            {
            match("import"); 


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
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:62:7: ( '.' )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:62:9: '.'
            {
            match('.'); 

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
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:63:7: ( 'group' )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:63:9: 'group'
            {
            match("group"); 


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
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:64:7: ( ':' )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:64:9: ':'
            {
            match(':'); 

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
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:65:7: ( 'implements' )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:65:9: 'implements'
            {
            match("implements"); 


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
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:66:7: ( ',' )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:66:9: ','
            {
            match(','); 

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
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:67:7: ( ';' )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:67:9: ';'
            {
            match(';'); 

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
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:68:7: ( 'delimiters' )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:68:9: 'delimiters'
            {
            match("delimiters"); 


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
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:69:7: ( '@' )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:69:9: '@'
            {
            match('@'); 

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
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:70:7: ( '(' )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:70:9: '('
            {
            match('('); 

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
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:71:7: ( ')' )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:71:9: ')'
            {
            match(')'); 

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
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:72:7: ( '::=' )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:72:9: '::='
            {
            match("::="); 


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
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:73:7: ( '=' )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:73:9: '='
            {
            match('='); 

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
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:74:7: ( '[' )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:74:9: '['
            {
            match('['); 

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
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:75:7: ( ']' )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:75:9: ']'
            {
            match(']'); 

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
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:76:7: ( 'default' )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:76:9: 'default'
            {
            match("default"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:312:4: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '-' | '_' )* )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:312:6: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '-' | '_' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:312:30: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '-' | '_' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='-'||(LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:
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
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:316:2: ( '\"' ( '\\\\' '\"' | '\\\\' ~ '\"' | '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )* '\"' )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:316:4: '\"' ( '\\\\' '\"' | '\\\\' ~ '\"' | '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )* '\"'
            {
            match('\"'); 
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:317:3: ( '\\\\' '\"' | '\\\\' ~ '\"' | '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )*
            loop2:
            do {
                int alt2=5;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='\\') ) {
                    int LA2_2 = input.LA(2);

                    if ( (LA2_2=='\"') ) {
                        alt2=1;
                    }
                    else if ( ((LA2_2>='\u0000' && LA2_2<='!')||(LA2_2>='#' && LA2_2<='\uFFFF')) ) {
                        alt2=2;
                    }


                }
                else if ( (LA2_0=='\n') ) {
                    alt2=3;
                }
                else if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='!')||(LA2_0>='#' && LA2_0<='[')||(LA2_0>=']' && LA2_0<='\uFFFF')) ) {
                    alt2=4;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:317:5: '\\\\' '\"'
            	    {
            	    match('\\'); 
            	    match('\"'); 

            	    }
            	    break;
            	case 2 :
            	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:318:5: '\\\\' ~ '\"'
            	    {
            	    match('\\'); 
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;
            	case 3 :
            	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:319:5: '\\n'
            	    {

            	    			String msg = "\\n in string";
            	        		NoViableAltException e = new NoViableAltException("", 0, 0, input);
            	    			group.errMgr.groupLexerError(ErrorType.SYNTAX_ERROR, getSourceName(), e, msg);
            	    			
            	    match('\n'); 

            	    }
            	    break;
            	case 4 :
            	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:325:5: ~ ( '\\\\' | '\"' | '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
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

            match('\"'); 

                    String txt = getText().replaceAll("\\\\\"","\"");
            		setText(txt);
            		

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "BIGSTRING_NO_NL"
    public final void mBIGSTRING_NO_NL() throws RecognitionException {
        try {
            int _type = BIGSTRING_NO_NL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:335:2: ( '<%' ( options {greedy=false; } : . )* '%>' )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:335:4: '<%' ( options {greedy=false; } : . )* '%>'
            {
            match("<%"); 

            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:335:9: ( options {greedy=false; } : . )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='%') ) {
                    int LA3_1 = input.LA(2);

                    if ( (LA3_1=='>') ) {
                        alt3=2;
                    }
                    else if ( ((LA3_1>='\u0000' && LA3_1<='=')||(LA3_1>='?' && LA3_1<='\uFFFF')) ) {
                        alt3=1;
                    }


                }
                else if ( ((LA3_0>='\u0000' && LA3_0<='$')||(LA3_0>='&' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:335:36: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match("%>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BIGSTRING_NO_NL"

    // $ANTLR start "BIGSTRING"
    public final void mBIGSTRING() throws RecognitionException {
        try {
            int _type = BIGSTRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:339:2: ( '<<' ( options {greedy=false; } : '\\\\' '>' | '\\\\' ~ '>' | ~ '\\\\' )* '>>' )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:339:4: '<<' ( options {greedy=false; } : '\\\\' '>' | '\\\\' ~ '>' | ~ '\\\\' )* '>>'
            {
            match("<<"); 

            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:340:3: ( options {greedy=false; } : '\\\\' '>' | '\\\\' ~ '>' | ~ '\\\\' )*
            loop4:
            do {
                int alt4=4;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='>') ) {
                    int LA4_1 = input.LA(2);

                    if ( (LA4_1=='>') ) {
                        alt4=4;
                    }
                    else if ( ((LA4_1>='\u0000' && LA4_1<='=')||(LA4_1>='?' && LA4_1<='\uFFFF')) ) {
                        alt4=3;
                    }


                }
                else if ( (LA4_0=='\\') ) {
                    int LA4_2 = input.LA(2);

                    if ( (LA4_2=='>') ) {
                        alt4=1;
                    }
                    else if ( ((LA4_2>='\u0000' && LA4_2<='=')||(LA4_2>='?' && LA4_2<='\uFFFF')) ) {
                        alt4=2;
                    }


                }
                else if ( ((LA4_0>='\u0000' && LA4_0<='=')||(LA4_0>='?' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFF')) ) {
                    alt4=3;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:341:5: '\\\\' '>'
            	    {
            	    match('\\'); 
            	    match('>'); 

            	    }
            	    break;
            	case 2 :
            	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:342:5: '\\\\' ~ '>'
            	    {
            	    match('\\'); 
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='=')||(input.LA(1)>='?' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;
            	case 3 :
            	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:343:5: ~ '\\\\'
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match(">>"); 


                    String txt = getText().replaceAll("\\\\>",">");;
            		setText(txt);
            		

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BIGSTRING"

    // $ANTLR start "ANONYMOUS_TEMPLATE"
    public final void mANONYMOUS_TEMPLATE() throws RecognitionException {
        try {
            int _type = ANONYMOUS_TEMPLATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:353:5: ( '{' )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:353:7: '{'
            {
            match('{'); 

            		Token templateToken = new CommonToken(input, ANONYMOUS_TEMPLATE, 0, getCharIndex(), getCharIndex());
            		STLexer lexer =
            			new STLexer(group.errMgr, input, templateToken, group.delimiterStartChar, group.delimiterStopChar);
            		lexer.subtemplateDepth = 1;
            		Token t = lexer.nextToken();
            		while ( lexer.subtemplateDepth>=1 || t.getType()!=STLexer.RCURLY ) {
            			if ( t.getType()==STLexer.EOF_TYPE ) {
                        	MismatchedTokenException e = new MismatchedTokenException('}', input);
            				String msg = "missing final '}' in {...} anonymous template";
                			group.errMgr.groupLexerError(ErrorType.SYNTAX_ERROR, getSourceName(), e, msg);
            				break;
            			}
            			t = lexer.nextToken();
            		}
            		

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ANONYMOUS_TEMPLATE"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:375:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:375:9: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:375:14: ( options {greedy=false; } : . )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='*') ) {
                    int LA5_1 = input.LA(2);

                    if ( (LA5_1=='/') ) {
                        alt5=2;
                    }
                    else if ( ((LA5_1>='\u0000' && LA5_1<='.')||(LA5_1>='0' && LA5_1<='\uFFFF')) ) {
                        alt5=1;
                    }


                }
                else if ( ((LA5_0>='\u0000' && LA5_0<=')')||(LA5_0>='+' && LA5_0<='\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:375:42: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match("*/"); 

            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "LINE_COMMENT"
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:379:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:379:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:379:12: (~ ( '\\n' | '\\r' ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\u0000' && LA6_0<='\t')||(LA6_0>='\u000B' && LA6_0<='\f')||(LA6_0>='\u000E' && LA6_0<='\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:379:12: ~ ( '\\n' | '\\r' )
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
            	    break loop6;
                }
            } while (true);

            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:379:26: ( '\\r' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\r') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:379:26: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 
            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LINE_COMMENT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:382:5: ( ( ' ' | '\\r' | '\\t' | '\\n' ) )
            // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:382:7: ( ' ' | '\\r' | '\\t' | '\\n' )
            {
            if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:1:8: ( TRUE | FALSE | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | ID | STRING | BIGSTRING_NO_NL | BIGSTRING | ANONYMOUS_TEMPLATE | COMMENT | LINE_COMMENT | WS )
        int alt8=26;
        alt8 = dfa8.predict(input);
        switch (alt8) {
            case 1 :
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:1:10: TRUE
                {
                mTRUE(); 

                }
                break;
            case 2 :
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:1:15: FALSE
                {
                mFALSE(); 

                }
                break;
            case 3 :
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:1:21: T__14
                {
                mT__14(); 

                }
                break;
            case 4 :
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:1:27: T__15
                {
                mT__15(); 

                }
                break;
            case 5 :
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:1:33: T__16
                {
                mT__16(); 

                }
                break;
            case 6 :
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:1:39: T__17
                {
                mT__17(); 

                }
                break;
            case 7 :
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:1:45: T__18
                {
                mT__18(); 

                }
                break;
            case 8 :
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:1:51: T__19
                {
                mT__19(); 

                }
                break;
            case 9 :
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:1:57: T__20
                {
                mT__20(); 

                }
                break;
            case 10 :
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:1:63: T__21
                {
                mT__21(); 

                }
                break;
            case 11 :
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:1:69: T__22
                {
                mT__22(); 

                }
                break;
            case 12 :
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:1:75: T__23
                {
                mT__23(); 

                }
                break;
            case 13 :
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:1:81: T__24
                {
                mT__24(); 

                }
                break;
            case 14 :
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:1:87: T__25
                {
                mT__25(); 

                }
                break;
            case 15 :
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:1:93: T__26
                {
                mT__26(); 

                }
                break;
            case 16 :
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:1:99: T__27
                {
                mT__27(); 

                }
                break;
            case 17 :
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:1:105: T__28
                {
                mT__28(); 

                }
                break;
            case 18 :
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:1:111: T__29
                {
                mT__29(); 

                }
                break;
            case 19 :
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:1:117: ID
                {
                mID(); 

                }
                break;
            case 20 :
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:1:120: STRING
                {
                mSTRING(); 

                }
                break;
            case 21 :
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:1:127: BIGSTRING_NO_NL
                {
                mBIGSTRING_NO_NL(); 

                }
                break;
            case 22 :
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:1:143: BIGSTRING
                {
                mBIGSTRING(); 

                }
                break;
            case 23 :
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:1:153: ANONYMOUS_TEMPLATE
                {
                mANONYMOUS_TEMPLATE(); 

                }
                break;
            case 24 :
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:1:172: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 25 :
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:1:180: LINE_COMMENT
                {
                mLINE_COMMENT(); 

                }
                break;
            case 26 :
                // C:\\Projects\\ST-4.0.4\\src\\org\\stringtemplate\\v4\\compiler\\Group.g:1:193: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\1\uffff\3\20\1\uffff\1\20\1\33\2\uffff\1\20\14\uffff\4\20\2\uffff"+
        "\1\20\4\uffff\6\20\1\56\6\20\1\uffff\1\65\2\20\1\70\2\20\1\uffff"+
        "\1\73\1\20\1\uffff\2\20\1\uffff\2\20\1\101\2\20\1\uffff\2\20\1\106"+
        "\1\107\2\uffff";
    static final String DFA8_eofS =
        "\110\uffff";
    static final String DFA8_minS =
        "\1\11\1\162\1\141\1\155\1\uffff\1\162\1\72\2\uffff\1\145\10\uffff"+
        "\1\45\1\uffff\1\52\1\uffff\1\165\1\154\1\160\1\157\2\uffff\1\146"+
        "\4\uffff\1\145\1\163\1\154\1\165\1\151\1\141\1\55\1\145\1\162\1"+
        "\145\1\160\1\155\1\165\1\uffff\1\55\1\164\1\155\1\55\1\151\1\154"+
        "\1\uffff\1\55\1\145\1\uffff\2\164\1\uffff\1\156\1\145\1\55\1\164"+
        "\1\162\1\uffff\2\163\2\55\2\uffff";
    static final String DFA8_maxS =
        "\1\173\1\162\1\141\1\155\1\uffff\1\162\1\72\2\uffff\1\145\10\uffff"+
        "\1\74\1\uffff\1\57\1\uffff\1\165\1\154\1\160\1\157\2\uffff\1\154"+
        "\4\uffff\1\145\1\163\1\157\1\165\1\151\1\141\1\172\1\145\1\162\1"+
        "\145\1\160\1\155\1\165\1\uffff\1\172\1\164\1\155\1\172\1\151\1\154"+
        "\1\uffff\1\172\1\145\1\uffff\2\164\1\uffff\1\156\1\145\1\172\1\164"+
        "\1\162\1\uffff\2\163\2\172\2\uffff";
    static final String DFA8_acceptS =
        "\4\uffff\1\4\2\uffff\1\10\1\11\1\uffff\1\13\1\14\1\15\1\17\1\20"+
        "\1\21\1\23\1\24\1\uffff\1\27\1\uffff\1\32\4\uffff\1\16\1\6\1\uffff"+
        "\1\25\1\26\1\30\1\31\15\uffff\1\1\6\uffff\1\2\2\uffff\1\5\2\uffff"+
        "\1\3\5\uffff\1\22\4\uffff\1\7\1\12";
    static final String DFA8_specialS =
        "\110\uffff}>";
    static final String[] DFA8_transitionS = {
            "\2\25\2\uffff\1\25\22\uffff\1\25\1\uffff\1\21\5\uffff\1\13"+
            "\1\14\2\uffff\1\7\1\uffff\1\4\1\24\12\uffff\1\6\1\10\1\22\1"+
            "\15\2\uffff\1\12\32\20\1\16\1\uffff\1\17\1\uffff\1\20\1\uffff"+
            "\3\20\1\11\1\20\1\2\1\5\1\20\1\3\12\20\1\1\6\20\1\23",
            "\1\26",
            "\1\27",
            "\1\30",
            "",
            "\1\31",
            "\1\32",
            "",
            "",
            "\1\34",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\35\26\uffff\1\36",
            "",
            "\1\37\4\uffff\1\40",
            "",
            "\1\41",
            "\1\42",
            "\1\43",
            "\1\44",
            "",
            "",
            "\1\46\5\uffff\1\45",
            "",
            "",
            "",
            "",
            "\1\47",
            "\1\50",
            "\1\52\2\uffff\1\51",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\20\2\uffff\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32"+
            "\20",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "",
            "\1\20\2\uffff\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32"+
            "\20",
            "\1\66",
            "\1\67",
            "\1\20\2\uffff\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32"+
            "\20",
            "\1\71",
            "\1\72",
            "",
            "\1\20\2\uffff\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32"+
            "\20",
            "\1\74",
            "",
            "\1\75",
            "\1\76",
            "",
            "\1\77",
            "\1\100",
            "\1\20\2\uffff\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32"+
            "\20",
            "\1\102",
            "\1\103",
            "",
            "\1\104",
            "\1\105",
            "\1\20\2\uffff\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32"+
            "\20",
            "\1\20\2\uffff\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32"+
            "\20",
            "",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( TRUE | FALSE | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | ID | STRING | BIGSTRING_NO_NL | BIGSTRING | ANONYMOUS_TEMPLATE | COMMENT | LINE_COMMENT | WS );";
        }
    }
 

}