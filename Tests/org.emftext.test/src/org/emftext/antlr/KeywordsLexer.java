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
// $ANTLR 3.4 ./src/org/emftext/antlr/Keywords.g 2011-08-25 22:31:30

	package org.emftext.antlr;


import org.antlr.runtime3_4_0.CharStream;
import org.antlr.runtime3_4_0.EarlyExitException;
import org.antlr.runtime3_4_0.Lexer;
import org.antlr.runtime3_4_0.MismatchedSetException;
import org.antlr.runtime3_4_0.NoViableAltException;
import org.antlr.runtime3_4_0.RecognitionException;
import org.antlr.runtime3_4_0.RecognizerSharedState;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class KeywordsLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__6=6;
    public static final int T__7=7;
    public static final int T_BRACKETS=4;
    public static final int T_IDENTIFIER=5;

    	public java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions = new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>();
    	
    	public void reportError(org.antlr.runtime3_4_0.RecognitionException e) {
    		lexerExceptions.add(e);
    	}


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public KeywordsLexer() {} 
    public KeywordsLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public KeywordsLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "./src/org/emftext/antlr/Keywords.g"; }

    // $ANTLR start "T__6"
    public final void mT__6() throws RecognitionException {
        try {
            int _type = T__6;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./src/org/emftext/antlr/Keywords.g:13:6: ( '[' )
            // ./src/org/emftext/antlr/Keywords.g:13:8: '['
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
    // $ANTLR end "T__6"

    // $ANTLR start "T__7"
    public final void mT__7() throws RecognitionException {
        try {
            int _type = T__7;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./src/org/emftext/antlr/Keywords.g:14:6: ( 'keyword' )
            // ./src/org/emftext/antlr/Keywords.g:14:8: 'keyword'
            {
            match("keyword"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__7"

    // $ANTLR start "T_BRACKETS"
    public final void mT_BRACKETS() throws RecognitionException {
        try {
            int _type = T_BRACKETS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./src/org/emftext/antlr/Keywords.g:52:12: ( '[' ']' )
            // ./src/org/emftext/antlr/Keywords.g:52:14: '[' ']'
            {
            match('['); 

            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T_BRACKETS"

    // $ANTLR start "T_IDENTIFIER"
    public final void mT_IDENTIFIER() throws RecognitionException {
        try {
            int _type = T_IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./src/org/emftext/antlr/Keywords.g:53:13: ( ( 'a' .. 'z' )+ )
            // ./src/org/emftext/antlr/Keywords.g:53:15: ( 'a' .. 'z' )+
            {
            // ./src/org/emftext/antlr/Keywords.g:53:15: ( 'a' .. 'z' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src/org/emftext/antlr/Keywords.g:
            	    {
            	    if ( (input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T_IDENTIFIER"

    public void mTokens() throws RecognitionException {
        // ./src/org/emftext/antlr/Keywords.g:1:8: ( T__6 | T__7 | T_BRACKETS | T_IDENTIFIER )
        int alt2=4;
        switch ( input.LA(1) ) {
        case '[':
            {
            int LA2_1 = input.LA(2);

            if ( (LA2_1==']') ) {
                alt2=3;
            }
            else {
                alt2=1;
            }
            }
            break;
        case 'k':
            {
            int LA2_2 = input.LA(2);

            if ( (LA2_2=='e') ) {
                int LA2_6 = input.LA(3);

                if ( (LA2_6=='y') ) {
                    int LA2_7 = input.LA(4);

                    if ( (LA2_7=='w') ) {
                        int LA2_8 = input.LA(5);

                        if ( (LA2_8=='o') ) {
                            int LA2_9 = input.LA(6);

                            if ( (LA2_9=='r') ) {
                                int LA2_10 = input.LA(7);

                                if ( (LA2_10=='d') ) {
                                    int LA2_11 = input.LA(8);

                                    if ( ((LA2_11 >= 'a' && LA2_11 <= 'z')) ) {
                                        alt2=4;
                                    }
                                    else {
                                        alt2=2;
                                    }
                                }
                                else {
                                    alt2=4;
                                }
                            }
                            else {
                                alt2=4;
                            }
                        }
                        else {
                            alt2=4;
                        }
                    }
                    else {
                        alt2=4;
                    }
                }
                else {
                    alt2=4;
                }
            }
            else {
                alt2=4;
            }
            }
            break;
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt2=4;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 2, 0, input);

            throw nvae;

        }

        switch (alt2) {
            case 1 :
                // ./src/org/emftext/antlr/Keywords.g:1:10: T__6
                {
                mT__6(); 


                }
                break;
            case 2 :
                // ./src/org/emftext/antlr/Keywords.g:1:15: T__7
                {
                mT__7(); 


                }
                break;
            case 3 :
                // ./src/org/emftext/antlr/Keywords.g:1:20: T_BRACKETS
                {
                mT_BRACKETS(); 


                }
                break;
            case 4 :
                // ./src/org/emftext/antlr/Keywords.g:1:31: T_IDENTIFIER
                {
                mT_IDENTIFIER(); 


                }
                break;

        }

    }


 

}
