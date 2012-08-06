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
// $ANTLR 3.4 ./src/org/emftext/antlr/Bug1492a.g 2011-08-25 22:31:30

	package org.emftext.antlr;


import org.antlr.runtime3_4_0.CharStream;
import org.antlr.runtime3_4_0.Lexer;
import org.antlr.runtime3_4_0.MismatchedSetException;
import org.antlr.runtime3_4_0.NoViableAltException;
import org.antlr.runtime3_4_0.RecognitionException;
import org.antlr.runtime3_4_0.RecognizerSharedState;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class Bug1492aLexer extends Lexer {
    public static final int EOF=-1;
    public static final int IDENTIFIER=4;
    public static final int WHITESPACE=5;

    	public java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions = new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>();
    	
    	public void reportError(org.antlr.runtime3_4_0.RecognitionException e) {
    		lexerExceptions.add(e);
    	}


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public Bug1492aLexer() {} 
    public Bug1492aLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public Bug1492aLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "./src/org/emftext/antlr/Bug1492a.g"; }

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./src/org/emftext/antlr/Bug1492a.g:40:11: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( ( 'a' .. 'z' | 'A' .. 'Z' ) | ( '0' .. '9' ) )* )
            // ./src/org/emftext/antlr/Bug1492a.g:41:2: ( 'a' .. 'z' | 'A' .. 'Z' ) ( ( 'a' .. 'z' | 'A' .. 'Z' ) | ( '0' .. '9' ) )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // ./src/org/emftext/antlr/Bug1492a.g:41:20: ( ( 'a' .. 'z' | 'A' .. 'Z' ) | ( '0' .. '9' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src/org/emftext/antlr/Bug1492a.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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
            // ./src/org/emftext/antlr/Bug1492a.g:46:11: ( ( ' ' | '\\t' | '\\f' ) )
            // ./src/org/emftext/antlr/Bug1492a.g:47:2: ( ' ' | '\\t' | '\\f' )
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

    public void mTokens() throws RecognitionException {
        // ./src/org/emftext/antlr/Bug1492a.g:1:8: ( IDENTIFIER | WHITESPACE )
        int alt2=2;
        int LA2_0 = input.LA(1);

        if ( ((LA2_0 >= 'A' && LA2_0 <= 'Z')||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
            alt2=1;
        }
        else if ( (LA2_0=='\t'||LA2_0=='\f'||LA2_0==' ') ) {
            alt2=2;
        }
        else {
            NoViableAltException nvae =
                new NoViableAltException("", 2, 0, input);

            throw nvae;

        }
        switch (alt2) {
            case 1 :
                // ./src/org/emftext/antlr/Bug1492a.g:1:10: IDENTIFIER
                {
                mIDENTIFIER(); 


                }
                break;
            case 2 :
                // ./src/org/emftext/antlr/Bug1492a.g:1:21: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;

        }

    }


 

}
