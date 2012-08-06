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
// $ANTLR 3.4 ./src/org/emftext/antlr/Bug1492b.g 2011-08-25 22:31:31

	package org.emftext.antlr;


import org.antlr.runtime3_4_0.BaseRecognizer;
import org.antlr.runtime3_4_0.CharStream;
import org.antlr.runtime3_4_0.DFA;
import org.antlr.runtime3_4_0.EarlyExitException;
import org.antlr.runtime3_4_0.Lexer;
import org.antlr.runtime3_4_0.MismatchedSetException;
import org.antlr.runtime3_4_0.NoViableAltException;
import org.antlr.runtime3_4_0.RecognitionException;
import org.antlr.runtime3_4_0.RecognizerSharedState;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class Bug1492bLexer extends Lexer {
    public static final int EOF=-1;
    public static final int BOOLEAN=4;
    public static final int DATE=5;
    public static final int DOUBLE=6;
    public static final int EQUALS=7;
    public static final int IDENTIFIER=8;
    public static final int LINEBREAKS=9;
    public static final int LONG=10;
    public static final int PLUS_EQUALS=11;
    public static final int SL_COMMENT=12;
    public static final int STRING=13;
    public static final int WHITESPACE=14;

    	public java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions = new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>();
    	
    	public void reportError(org.antlr.runtime3_4_0.RecognitionException e) {
    		lexerExceptions.add(e);
    	}


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public Bug1492bLexer() {} 
    public Bug1492bLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public Bug1492bLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "./src/org/emftext/antlr/Bug1492b.g"; }

    // $ANTLR start "LONG"
    public final void mLONG() throws RecognitionException {
        try {
            int _type = LONG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./src/org/emftext/antlr/Bug1492b.g:40:5: ( ( ( '-' )? ( '0' .. '9' )+ ) )
            // ./src/org/emftext/antlr/Bug1492b.g:41:2: ( ( '-' )? ( '0' .. '9' )+ )
            {
            // ./src/org/emftext/antlr/Bug1492b.g:41:2: ( ( '-' )? ( '0' .. '9' )+ )
            // ./src/org/emftext/antlr/Bug1492b.g:41:3: ( '-' )? ( '0' .. '9' )+
            {
            // ./src/org/emftext/antlr/Bug1492b.g:41:3: ( '-' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='-') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ./src/org/emftext/antlr/Bug1492b.g:41:4: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            // ./src/org/emftext/antlr/Bug1492b.g:41:9: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ./src/org/emftext/antlr/Bug1492b.g:
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
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
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
    // $ANTLR end "LONG"

    // $ANTLR start "DOUBLE"
    public final void mDOUBLE() throws RecognitionException {
        try {
            int _type = DOUBLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./src/org/emftext/antlr/Bug1492b.g:43:7: ( ( ( '-' )? ( '0' .. '9' )+ '.' ( '0' .. '9' )+ ) )
            // ./src/org/emftext/antlr/Bug1492b.g:44:2: ( ( '-' )? ( '0' .. '9' )+ '.' ( '0' .. '9' )+ )
            {
            // ./src/org/emftext/antlr/Bug1492b.g:44:2: ( ( '-' )? ( '0' .. '9' )+ '.' ( '0' .. '9' )+ )
            // ./src/org/emftext/antlr/Bug1492b.g:44:3: ( '-' )? ( '0' .. '9' )+ '.' ( '0' .. '9' )+
            {
            // ./src/org/emftext/antlr/Bug1492b.g:44:3: ( '-' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='-') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ./src/org/emftext/antlr/Bug1492b.g:44:4: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            // ./src/org/emftext/antlr/Bug1492b.g:44:9: ( '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ./src/org/emftext/antlr/Bug1492b.g:
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
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            match('.'); 

            // ./src/org/emftext/antlr/Bug1492b.g:44:23: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ./src/org/emftext/antlr/Bug1492b.g:
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
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
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
    // $ANTLR end "DOUBLE"

    // $ANTLR start "DATE"
    public final void mDATE() throws RecognitionException {
        try {
            int _type = DATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./src/org/emftext/antlr/Bug1492b.g:46:5: ( ( ( '0' .. '1' ) '0' .. '9' '.' '0' .. '3' '0' .. '9' '.' '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' ) )
            // ./src/org/emftext/antlr/Bug1492b.g:47:2: ( ( '0' .. '1' ) '0' .. '9' '.' '0' .. '3' '0' .. '9' '.' '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' )
            {
            // ./src/org/emftext/antlr/Bug1492b.g:47:2: ( ( '0' .. '1' ) '0' .. '9' '.' '0' .. '3' '0' .. '9' '.' '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' )
            // ./src/org/emftext/antlr/Bug1492b.g:47:3: ( '0' .. '1' ) '0' .. '9' '.' '0' .. '3' '0' .. '9' '.' '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9'
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '1') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            matchRange('0','9'); 

            match('.'); 

            matchRange('0','3'); 

            matchRange('0','9'); 

            match('.'); 

            matchRange('0','9'); 

            matchRange('0','9'); 

            matchRange('0','9'); 

            matchRange('0','9'); 

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DATE"

    // $ANTLR start "PLUS_EQUALS"
    public final void mPLUS_EQUALS() throws RecognitionException {
        try {
            int _type = PLUS_EQUALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./src/org/emftext/antlr/Bug1492b.g:49:12: ( ( '+' '=' ) )
            // ./src/org/emftext/antlr/Bug1492b.g:50:2: ( '+' '=' )
            {
            // ./src/org/emftext/antlr/Bug1492b.g:50:2: ( '+' '=' )
            // ./src/org/emftext/antlr/Bug1492b.g:50:3: '+' '='
            {
            match('+'); 

            match('='); 

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PLUS_EQUALS"

    // $ANTLR start "EQUALS"
    public final void mEQUALS() throws RecognitionException {
        try {
            int _type = EQUALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./src/org/emftext/antlr/Bug1492b.g:52:7: ( ( '=' ) )
            // ./src/org/emftext/antlr/Bug1492b.g:53:2: ( '=' )
            {
            // ./src/org/emftext/antlr/Bug1492b.g:53:2: ( '=' )
            // ./src/org/emftext/antlr/Bug1492b.g:53:3: '='
            {
            match('='); 

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EQUALS"

    // $ANTLR start "BOOLEAN"
    public final void mBOOLEAN() throws RecognitionException {
        try {
            int _type = BOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./src/org/emftext/antlr/Bug1492b.g:55:8: ( ( 'true' | 'false' ) )
            // ./src/org/emftext/antlr/Bug1492b.g:56:2: ( 'true' | 'false' )
            {
            // ./src/org/emftext/antlr/Bug1492b.g:56:2: ( 'true' | 'false' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='t') ) {
                alt6=1;
            }
            else if ( (LA6_0=='f') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // ./src/org/emftext/antlr/Bug1492b.g:56:3: 'true'
                    {
                    match("true"); 



                    }
                    break;
                case 2 :
                    // ./src/org/emftext/antlr/Bug1492b.g:56:10: 'false'
                    {
                    match("false"); 



                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BOOLEAN"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./src/org/emftext/antlr/Bug1492b.g:58:7: ( ( ( '\"' ) ( ( '\\\\' '\"' ) | ( '\\\\' '\\\\' ) |~ ( '\"' | '\\\\' ) )* ( '\"' ) ) )
            // ./src/org/emftext/antlr/Bug1492b.g:59:2: ( ( '\"' ) ( ( '\\\\' '\"' ) | ( '\\\\' '\\\\' ) |~ ( '\"' | '\\\\' ) )* ( '\"' ) )
            {
            // ./src/org/emftext/antlr/Bug1492b.g:59:2: ( ( '\"' ) ( ( '\\\\' '\"' ) | ( '\\\\' '\\\\' ) |~ ( '\"' | '\\\\' ) )* ( '\"' ) )
            // ./src/org/emftext/antlr/Bug1492b.g:59:3: ( '\"' ) ( ( '\\\\' '\"' ) | ( '\\\\' '\\\\' ) |~ ( '\"' | '\\\\' ) )* ( '\"' )
            {
            // ./src/org/emftext/antlr/Bug1492b.g:59:3: ( '\"' )
            // ./src/org/emftext/antlr/Bug1492b.g:59:4: '\"'
            {
            match('\"'); 

            }


            // ./src/org/emftext/antlr/Bug1492b.g:59:8: ( ( '\\\\' '\"' ) | ( '\\\\' '\\\\' ) |~ ( '\"' | '\\\\' ) )*
            loop7:
            do {
                int alt7=4;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='\\') ) {
                    int LA7_2 = input.LA(2);

                    if ( (LA7_2=='\"') ) {
                        alt7=1;
                    }
                    else if ( (LA7_2=='\\') ) {
                        alt7=2;
                    }


                }
                else if ( ((LA7_0 >= '\u0000' && LA7_0 <= '!')||(LA7_0 >= '#' && LA7_0 <= '[')||(LA7_0 >= ']' && LA7_0 <= '\uFFFF')) ) {
                    alt7=3;
                }


                switch (alt7) {
            	case 1 :
            	    // ./src/org/emftext/antlr/Bug1492b.g:59:9: ( '\\\\' '\"' )
            	    {
            	    // ./src/org/emftext/antlr/Bug1492b.g:59:9: ( '\\\\' '\"' )
            	    // ./src/org/emftext/antlr/Bug1492b.g:59:10: '\\\\' '\"'
            	    {
            	    match('\\'); 

            	    match('\"'); 

            	    }


            	    }
            	    break;
            	case 2 :
            	    // ./src/org/emftext/antlr/Bug1492b.g:59:19: ( '\\\\' '\\\\' )
            	    {
            	    // ./src/org/emftext/antlr/Bug1492b.g:59:19: ( '\\\\' '\\\\' )
            	    // ./src/org/emftext/antlr/Bug1492b.g:59:20: '\\\\' '\\\\'
            	    {
            	    match('\\'); 

            	    match('\\'); 

            	    }


            	    }
            	    break;
            	case 3 :
            	    // ./src/org/emftext/antlr/Bug1492b.g:59:30: ~ ( '\"' | '\\\\' )
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
            	    break loop7;
                }
            } while (true);


            // ./src/org/emftext/antlr/Bug1492b.g:59:43: ( '\"' )
            // ./src/org/emftext/antlr/Bug1492b.g:59:44: '\"'
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
    // $ANTLR end "STRING"

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./src/org/emftext/antlr/Bug1492b.g:61:11: ( ( ( 'A' .. 'Z' | 'a' .. 'z' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )* ) )
            // ./src/org/emftext/antlr/Bug1492b.g:62:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )* )
            {
            // ./src/org/emftext/antlr/Bug1492b.g:62:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )* )
            // ./src/org/emftext/antlr/Bug1492b.g:62:3: ( 'A' .. 'Z' | 'a' .. 'z' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // ./src/org/emftext/antlr/Bug1492b.g:62:26: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='-'||(LA8_0 >= '0' && LA8_0 <= '9')||(LA8_0 >= 'A' && LA8_0 <= 'Z')||LA8_0=='_'||(LA8_0 >= 'a' && LA8_0 <= 'z')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ./src/org/emftext/antlr/Bug1492b.g:
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
            	    break loop8;
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
    // $ANTLR end "IDENTIFIER"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./src/org/emftext/antlr/Bug1492b.g:64:11: ( ( ( ' ' | '\\t' | '\\f' ) ) )
            // ./src/org/emftext/antlr/Bug1492b.g:65:2: ( ( ' ' | '\\t' | '\\f' ) )
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

    // $ANTLR start "LINEBREAKS"
    public final void mLINEBREAKS() throws RecognitionException {
        try {
            int _type = LINEBREAKS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./src/org/emftext/antlr/Bug1492b.g:69:11: ( ( ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // ./src/org/emftext/antlr/Bug1492b.g:70:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // ./src/org/emftext/antlr/Bug1492b.g:70:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // ./src/org/emftext/antlr/Bug1492b.g:70:3: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // ./src/org/emftext/antlr/Bug1492b.g:70:3: ( '\\r\\n' | '\\r' | '\\n' )
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
                    // ./src/org/emftext/antlr/Bug1492b.g:70:4: '\\r\\n'
                    {
                    match("\r\n"); 



                    }
                    break;
                case 2 :
                    // ./src/org/emftext/antlr/Bug1492b.g:70:11: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // ./src/org/emftext/antlr/Bug1492b.g:70:16: '\\n'
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
    // $ANTLR end "LINEBREAKS"

    // $ANTLR start "SL_COMMENT"
    public final void mSL_COMMENT() throws RecognitionException {
        try {
            int _type = SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./src/org/emftext/antlr/Bug1492b.g:74:11: ( ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* ) )
            // ./src/org/emftext/antlr/Bug1492b.g:75:2: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            {
            // ./src/org/emftext/antlr/Bug1492b.g:75:2: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            // ./src/org/emftext/antlr/Bug1492b.g:75:3: '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            {
            match("//"); 



            // ./src/org/emftext/antlr/Bug1492b.g:75:7: (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0 >= '\u0000' && LA10_0 <= '\t')||(LA10_0 >= '\u000B' && LA10_0 <= '\f')||(LA10_0 >= '\u000E' && LA10_0 <= '\uFFFE')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ./src/org/emftext/antlr/Bug1492b.g:
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
            	    break loop10;
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

    public void mTokens() throws RecognitionException {
        // ./src/org/emftext/antlr/Bug1492b.g:1:8: ( LONG | DOUBLE | DATE | PLUS_EQUALS | EQUALS | BOOLEAN | STRING | IDENTIFIER | WHITESPACE | LINEBREAKS | SL_COMMENT )
        int alt11=11;
        alt11 = dfa11.predict(input);
        switch (alt11) {
            case 1 :
                // ./src/org/emftext/antlr/Bug1492b.g:1:10: LONG
                {
                mLONG(); 


                }
                break;
            case 2 :
                // ./src/org/emftext/antlr/Bug1492b.g:1:15: DOUBLE
                {
                mDOUBLE(); 


                }
                break;
            case 3 :
                // ./src/org/emftext/antlr/Bug1492b.g:1:22: DATE
                {
                mDATE(); 


                }
                break;
            case 4 :
                // ./src/org/emftext/antlr/Bug1492b.g:1:27: PLUS_EQUALS
                {
                mPLUS_EQUALS(); 


                }
                break;
            case 5 :
                // ./src/org/emftext/antlr/Bug1492b.g:1:39: EQUALS
                {
                mEQUALS(); 


                }
                break;
            case 6 :
                // ./src/org/emftext/antlr/Bug1492b.g:1:46: BOOLEAN
                {
                mBOOLEAN(); 


                }
                break;
            case 7 :
                // ./src/org/emftext/antlr/Bug1492b.g:1:54: STRING
                {
                mSTRING(); 


                }
                break;
            case 8 :
                // ./src/org/emftext/antlr/Bug1492b.g:1:61: IDENTIFIER
                {
                mIDENTIFIER(); 


                }
                break;
            case 9 :
                // ./src/org/emftext/antlr/Bug1492b.g:1:72: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 10 :
                // ./src/org/emftext/antlr/Bug1492b.g:1:83: LINEBREAKS
                {
                mLINEBREAKS(); 


                }
                break;
            case 11 :
                // ./src/org/emftext/antlr/Bug1492b.g:1:94: SL_COMMENT
                {
                mSL_COMMENT(); 


                }
                break;

        }

    }


    protected DFA11 dfa11 = new DFA11(this);
    static final String DFA11_eotS =
        "\2\uffff\2\16\2\uffff\2\11\5\uffff\1\16\2\uffff\2\11\1\uffff\2\11"+
        "\1\17\1\31\1\11\1\17\1\uffff\1\31\1\uffff";
    static final String DFA11_eofS =
        "\34\uffff";
    static final String DFA11_minS =
        "\1\11\1\60\2\56\2\uffff\1\162\1\141\5\uffff\1\56\2\uffff\1\165\1"+
        "\154\1\60\1\145\1\163\1\60\1\55\1\145\1\56\1\uffff\1\55\1\uffff";
    static final String DFA11_maxS =
        "\1\172\3\71\2\uffff\1\162\1\141\5\uffff\1\71\2\uffff\1\165\1\154"+
        "\1\71\1\145\1\163\1\71\1\172\1\145\1\56\1\uffff\1\172\1\uffff";
    static final String DFA11_acceptS =
        "\4\uffff\1\4\1\5\2\uffff\1\7\1\10\1\11\1\12\1\13\1\uffff\1\1\1\2"+
        "\11\uffff\1\6\1\uffff\1\3";
    static final String DFA11_specialS =
        "\34\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\12\1\13\1\uffff\1\12\1\13\22\uffff\1\12\1\uffff\1\10\10\uffff"+
            "\1\4\1\uffff\1\1\1\uffff\1\14\2\2\10\3\3\uffff\1\5\3\uffff\32"+
            "\11\4\uffff\1\11\1\uffff\5\11\1\7\15\11\1\6\6\11",
            "\12\3",
            "\1\17\1\uffff\12\15",
            "\1\17\1\uffff\12\3",
            "",
            "",
            "\1\20",
            "\1\21",
            "",
            "",
            "",
            "",
            "",
            "\1\22\1\uffff\12\3",
            "",
            "",
            "\1\23",
            "\1\24",
            "\4\25\6\17",
            "\1\26",
            "\1\27",
            "\12\30",
            "\1\11\2\uffff\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
            "\1\32",
            "\1\33",
            "",
            "\1\11\2\uffff\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( LONG | DOUBLE | DATE | PLUS_EQUALS | EQUALS | BOOLEAN | STRING | IDENTIFIER | WHITESPACE | LINEBREAKS | SL_COMMENT );";
        }
    }
 

}
