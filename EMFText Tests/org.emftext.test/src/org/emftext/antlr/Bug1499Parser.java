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


import org.antlr.runtime3_4_0.BitSet;
import org.antlr.runtime3_4_0.RecognitionException;
import org.antlr.runtime3_4_0.RecognizerSharedState;
import org.antlr.runtime3_4_0.TokenStream;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class Bug1499Parser extends AbstractParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CHOICE", "LINEBREAKS", "WHITESPACE"
    };

    public static final int EOF=-1;
    public static final int CHOICE=4;
    public static final int LINEBREAKS=5;
    public static final int WHITESPACE=6;

    // delegates
    public AbstractParser[] getDelegates() {
        return new AbstractParser[] {};
    }

    // delegators


    public Bug1499Parser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public Bug1499Parser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return Bug1499Parser.tokenNames; }
    public String getGrammarFileName() { return "./src/org/emftext/antlr/Bug1499.g"; }


    	public java.util.List<RecognitionException> getErrors() {
    		java.util.List<RecognitionException> allErrors = new java.util.ArrayList<RecognitionException>();
    		allErrors.addAll(errors);
    		allErrors.addAll(((Bug1499Lexer) getTokenStream().getTokenSource()).lexerExceptions);
    		return allErrors;
    	}



    // $ANTLR start "root"
    // ./src/org/emftext/antlr/Bug1499.g:33:1: root returns [String s] : CHOICE ;
    public final String root() throws RecognitionException {
        String s = null;


        s = "";
        try {
            // ./src/org/emftext/antlr/Bug1499.g:34:16: ( CHOICE )
            // ./src/org/emftext/antlr/Bug1499.g:35:2: CHOICE
            {
            match(input,CHOICE,FOLLOW_CHOICE_in_root62); 

             s = "ok"; 

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

    // Delegated rules


 

    public static final BitSet FOLLOW_CHOICE_in_root62 = new BitSet(new long[]{0x0000000000000002L});

}
