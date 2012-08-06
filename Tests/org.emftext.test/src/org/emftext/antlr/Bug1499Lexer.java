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
// $ANTLR 3.4 ./src/org/emftext/antlr/Bug1499.g 2011-08-25 22:31:31

	package org.emftext.antlr;


import org.antlr.runtime3_4_0.CharStream;
import org.antlr.runtime3_4_0.Lexer;
import org.antlr.runtime3_4_0.MismatchedSetException;
import org.antlr.runtime3_4_0.NoViableAltException;
import org.antlr.runtime3_4_0.RecognitionException;
import org.antlr.runtime3_4_0.RecognizerSharedState;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class Bug1499Lexer extends Lexer {
    public static final int EOF=-1;
    public static final int CHOICE=4;
    public static final int LINEBREAKS=5;
    public static final int WHITESPACE=6;

    	public java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions = new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>();
    	
    	public void reportError(org.antlr.runtime3_4_0.RecognitionException e) {
    		lexerExceptions.add(e);
    	}


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public Bug1499Lexer() {} 
    public Bug1499Lexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public Bug1499Lexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "./src/org/emftext/antlr/Bug1499.g"; }

    // $ANTLR start "CHOICE"
    public final void mCHOICE() throws RecognitionException {
        try {
            int _type = CHOICE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./src/org/emftext/antlr/Bug1499.g:40:7: ( ( ( '[]' | ( '|' '~' '|' ) ) ) )
            // ./src/org/emftext/antlr/Bug1499.g:41:2: ( ( '[]' | ( '|' '~' '|' ) ) )
            {
            // ./src/org/emftext/antlr/Bug1499.g:41:2: ( ( '[]' | ( '|' '~' '|' ) ) )
            // ./src/org/emftext/antlr/Bug1499.g:41:3: ( '[]' | ( '|' '~' '|' ) )
            {
            // ./src/org/emftext/antlr/Bug1499.g:41:3: ( '[]' | ( '|' '~' '|' ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='[') ) {
                alt1=1;
            }
            else if ( (LA1_0=='|') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // ./src/org/emftext/antlr/Bug1499.g:41:4: '[]'
                    {
                    match("[]"); 



                    }
                    break;
                case 2 :
                    // ./src/org/emftext/antlr/Bug1499.g:41:9: ( '|' '~' '|' )
                    {
                    // ./src/org/emftext/antlr/Bug1499.g:41:9: ( '|' '~' '|' )
                    // ./src/org/emftext/antlr/Bug1499.g:41:10: '|' '~' '|'
                    {
                    match('|'); 

                    match('~'); 

                    match('|'); 

                    }


                    }
                    break;

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
    // $ANTLR end "CHOICE"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./src/org/emftext/antlr/Bug1499.g:44:11: ( ( ( ' ' | '\\t' | '\\f' ) ) )
            // ./src/org/emftext/antlr/Bug1499.g:45:2: ( ( ' ' | '\\t' | '\\f' ) )
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
            // ./src/org/emftext/antlr/Bug1499.g:50:11: ( ( ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // ./src/org/emftext/antlr/Bug1499.g:51:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // ./src/org/emftext/antlr/Bug1499.g:51:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // ./src/org/emftext/antlr/Bug1499.g:51:3: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // ./src/org/emftext/antlr/Bug1499.g:51:3: ( '\\r\\n' | '\\r' | '\\n' )
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
                    // ./src/org/emftext/antlr/Bug1499.g:51:4: '\\r\\n'
                    {
                    match("\r\n"); 



                    }
                    break;
                case 2 :
                    // ./src/org/emftext/antlr/Bug1499.g:51:11: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // ./src/org/emftext/antlr/Bug1499.g:51:16: '\\n'
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

    public void mTokens() throws RecognitionException {
        // ./src/org/emftext/antlr/Bug1499.g:1:8: ( CHOICE | WHITESPACE | LINEBREAKS )
        int alt3=3;
        switch ( input.LA(1) ) {
        case '[':
        case '|':
            {
            alt3=1;
            }
            break;
        case '\t':
        case '\f':
        case ' ':
            {
            alt3=2;
            }
            break;
        case '\n':
        case '\r':
            {
            alt3=3;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 3, 0, input);

            throw nvae;

        }

        switch (alt3) {
            case 1 :
                // ./src/org/emftext/antlr/Bug1499.g:1:10: CHOICE
                {
                mCHOICE(); 


                }
                break;
            case 2 :
                // ./src/org/emftext/antlr/Bug1499.g:1:17: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 3 :
                // ./src/org/emftext/antlr/Bug1499.g:1:28: LINEBREAKS
                {
                mLINEBREAKS(); 


                }
                break;

        }

    }


 

}
