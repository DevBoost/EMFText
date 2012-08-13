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


import org.antlr.runtime3_4_0.BitSet;
import org.antlr.runtime3_4_0.RecognitionException;
import org.antlr.runtime3_4_0.RecognizerSharedState;
import org.antlr.runtime3_4_0.TokenStream;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class Bug1492aParser extends AbstractParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENTIFIER", "WHITESPACE"
    };

    public static final int EOF=-1;
    public static final int IDENTIFIER=4;
    public static final int WHITESPACE=5;

    // delegates
    public AbstractParser[] getDelegates() {
        return new AbstractParser[] {};
    }

    // delegators


    public Bug1492aParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public Bug1492aParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return Bug1492aParser.tokenNames; }
    public String getGrammarFileName() { return "./src/org/emftext/antlr/Bug1492a.g"; }


    	public java.util.List<RecognitionException> getErrors() {
    		java.util.List<RecognitionException> allErrors = new java.util.ArrayList<RecognitionException>();
    		allErrors.addAll(errors);
    		allErrors.addAll(((Bug1492aLexer) getTokenStream().getTokenSource()).lexerExceptions);
    		return allErrors;
    	}



    // $ANTLR start "root"
    // ./src/org/emftext/antlr/Bug1492a.g:33:1: root returns [String s] : IDENTIFIER IDENTIFIER ;
    public final String root() throws RecognitionException {
        String s = null;


        s = "";
        try {
            // ./src/org/emftext/antlr/Bug1492a.g:34:16: ( IDENTIFIER IDENTIFIER )
            // ./src/org/emftext/antlr/Bug1492a.g:35:2: IDENTIFIER IDENTIFIER
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_root62); 

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_root64); 

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


 

    public static final BitSet FOLLOW_IDENTIFIER_in_root62 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENTIFIER_in_root64 = new BitSet(new long[]{0x0000000000000002L});

}
