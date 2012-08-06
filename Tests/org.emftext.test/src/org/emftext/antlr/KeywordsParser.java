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


import org.antlr.runtime3_4_0.BitSet;
import org.antlr.runtime3_4_0.NoViableAltException;
import org.antlr.runtime3_4_0.RecognitionException;
import org.antlr.runtime3_4_0.RecognizerSharedState;
import org.antlr.runtime3_4_0.TokenStream;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class KeywordsParser extends AbstractParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "T_BRACKETS", "T_IDENTIFIER", "'['", "'keyword'"
    };

    public static final int EOF=-1;
    public static final int T__6=6;
    public static final int T__7=7;
    public static final int T_BRACKETS=4;
    public static final int T_IDENTIFIER=5;

    // delegates
    public AbstractParser[] getDelegates() {
        return new AbstractParser[] {};
    }

    // delegators


    public KeywordsParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public KeywordsParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return KeywordsParser.tokenNames; }
    public String getGrammarFileName() { return "./src/org/emftext/antlr/Keywords.g"; }


    	public java.util.List<RecognitionException> getErrors() {
    		java.util.List<RecognitionException> allErrors = new java.util.ArrayList<RecognitionException>();
    		allErrors.addAll(errors);
    		allErrors.addAll(((KeywordsLexer) getTokenStream().getTokenSource()).lexerExceptions);
    		return allErrors;
    	}



    // $ANTLR start "root"
    // ./src/org/emftext/antlr/Keywords.g:33:1: root returns [String s] : (r1= rule1 |r2= rule2 );
    public final String root() throws RecognitionException {
        String s = null;


        String r1 =null;

        String r2 =null;


        s = "";
        try {
            // ./src/org/emftext/antlr/Keywords.g:34:16: (r1= rule1 |r2= rule2 )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==6) ) {
                alt1=1;
            }
            else if ( (LA1_0==7) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // ./src/org/emftext/antlr/Keywords.g:35:2: r1= rule1
                    {
                    pushFollow(FOLLOW_rule1_in_root66);
                    r1=rule1();

                    state._fsp--;



                    	s += (r1 == null ? "" : r1);


                    }
                    break;
                case 2 :
                    // ./src/org/emftext/antlr/Keywords.g:39:4: r2= rule2
                    {
                    pushFollow(FOLLOW_rule2_in_root79);
                    r2=rule2();

                    state._fsp--;



                    	s += (r2 == null ? "" : r2);


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return s;
    }
    // $ANTLR end "root"



    // $ANTLR start "rule1"
    // ./src/org/emftext/antlr/Keywords.g:44:1: rule1 returns [String s] : '[' ;
    public final String rule1() throws RecognitionException {
        String s = null;


        s = "r1";
        try {
            // ./src/org/emftext/antlr/Keywords.g:45:18: ( '[' )
            // ./src/org/emftext/antlr/Keywords.g:45:20: '['
            {
            match(input,6,FOLLOW_6_in_rule197); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return s;
    }
    // $ANTLR end "rule1"



    // $ANTLR start "rule2"
    // ./src/org/emftext/antlr/Keywords.g:47:1: rule2 returns [String s] : 'keyword' ;
    public final String rule2() throws RecognitionException {
        String s = null;


        s = "r2";
        try {
            // ./src/org/emftext/antlr/Keywords.g:48:18: ( 'keyword' )
            // ./src/org/emftext/antlr/Keywords.g:48:20: 'keyword'
            {
            match(input,7,FOLLOW_7_in_rule2113); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return s;
    }
    // $ANTLR end "rule2"

    // Delegated rules


 

    public static final BitSet FOLLOW_rule1_in_root66 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule2_in_root79 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_6_in_rule197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_7_in_rule2113 = new BitSet(new long[]{0x0000000000000002L});

}
