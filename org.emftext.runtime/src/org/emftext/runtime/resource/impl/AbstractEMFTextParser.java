/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.runtime.resource.impl;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.FailedPredicateException;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.MismatchedNotSetException;
import org.antlr.runtime.MismatchedRangeException;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.MismatchedTreeNodeException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.runtime.resource.ITextParser;
import org.emftext.runtime.resource.ITextResource;

/**
 * Base implementation for all generated ANTLR parsers. 
 * It implements the specifications from {@link ITextParser}.
 * 
 * @author Jendrik Johannes
 */
public abstract class AbstractEMFTextParser extends Parser implements ITextParser {    
    
	private int mismatchedTokenRecoveryTries = 0;
	private Map<?, ?> options;
	
	public void setOptions(Map<?,?> options) {
		this.options = options;
	}
	
	protected Map<?,?> getOptions() {
		return options;
	}
	
	protected void addMapEntry(EObject element, EStructuralFeature structuralFeature, DummyEObject dummy) {
		Object value = element.eGet(structuralFeature);
		Object mapKey = dummy.getValueByName("key");
		Object mapValue = dummy.getValueByName("value");
		if (value instanceof EMap<?, ?>) {
			EMap<Object, Object> valueMap = castToMap(value);
			if (mapKey != null && mapValue != null) {
				valueMap.put(mapKey, mapValue);
			}
		}
	}

	/**
	 * This method encapsulate an unchecked cast from Object to
	 * EMap<Object, Object>. This case can not be performed type
	 * safe, because type parameters are not available for
	 * reflective access to Ecore models.
	 * 
	 * TODO mseifert: move to some utility class
	 * 
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private EMap<Object, Object> castToMap(Object value) {
		return (EMap<Object,Object>) value;
	}
	
	protected EObject apply(EObject target, List<EObject> dummyEObjects) {
		EObject currentTarget = target;
		
		for (EObject object : dummyEObjects) {
			assert(object instanceof DummyEObject);
			DummyEObject dummy = (DummyEObject) object;
			EObject newEObject = dummy.applyTo(currentTarget);
			
			currentTarget = newEObject;
		}
		
		return currentTarget;
	}
	
	/**
	 * Use this no-arguments constructor to create
	 * a dummy parser and call createInstance() to
	 * obtain a real parser.
	 */
	public AbstractEMFTextParser() {
		super(null);
	}
	
    public AbstractEMFTextParser(TokenStream input) {
    	super(input);
    }
    
    public AbstractEMFTextParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	private ITextResource resource;
    
    public void setResource(ITextResource resource) {
        this.resource = resource;    	
    }
    
    public ITextResource getResource() {
    	return resource;
    }

    //helper lists to allow a lexer to pass errors to its parser
    protected List<RecognitionException> lexerExceptions = Collections.synchronizedList(new ArrayList<RecognitionException>());
    protected List<Integer>              lexerExceptionsPosition = Collections.synchronizedList(new ArrayList<Integer>());
    
    /**
     * This method must be overridden by generated subclasses.
     */
    protected abstract EObject doParse() throws RecognitionException;
    
    /**
     * Implementation that calls {@link #doParse()}  and handles the thrown
     * <code>RecognitionException</code>s.
     */
    public EObject parse() {
        
        try {
            EObject result =  doParse();
            if (lexerExceptions.isEmpty()) {
            	return result;
            }
        } catch (RecognitionException re) {
            reportError(re);
        } catch (IllegalArgumentException iae) {
        	if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
                //? can be caused if a null is set on EMF models where not allowed;
                //? this will just happen if other errors occurred before
        	} else {
        		iae.printStackTrace();
        	}
        }
        for (RecognitionException re : lexerExceptions) {
        	reportLexicalError(re);
        }
        return null;
    }
    
    
    /**
     * Translates errors thrown by the parser into human readable messages.
     * 
     * @param e A RecognitionException.
     */
    @Override
    public void reportError(RecognitionException e)  {
        String message = e.getMessage();
        
        if ( e instanceof MismatchedTokenException ) {
            MismatchedTokenException mte = (MismatchedTokenException)e;
            String tokenName="<unknown>";
            if ( mte.expecting==Token.EOF ) {
                tokenName = "EOF";
            }
            else {
                tokenName = getTokenNames()[mte.expecting];
                tokenName = formatTokenName(tokenName);
            }
            message = "Syntax error on token \"" + e.token.getText()
            			+ "\", \"" + tokenName + "\" expected";
            
            /* message = "mismatched token: "+
                               e.token+
                               "; expecting "+
                               tokenName; */
        }
        else if ( e instanceof MismatchedTreeNodeException ) {
            MismatchedTreeNodeException mtne = (MismatchedTreeNodeException)e;
            String tokenName="<unknown>";
            if ( mtne.expecting==Token.EOF ) {
                tokenName = "EOF";
            }
            else {
                tokenName = getTokenNames()[mtne.expecting];
            }
            message = "mismatched tree node: "+
                               "xxx" +
                               "; expecting "+
                               tokenName;
        }
        else if ( e instanceof NoViableAltException ) {
            //NoViableAltException nvae = (NoViableAltException)e;
            message = "Syntax error on token \"" + e.token.getText() + "\", check following tokens";
            
            /*message = //"decision=<<"+nvae.grammarDecisionDescription+">>"+
                               "state "+nvae.stateNumber+
                               " (decision="+nvae.decisionNumber+
                               ") no viable alt; token="+
                               e.token; */
        }
        else if ( e instanceof EarlyExitException ) {
            //EarlyExitException eee = (EarlyExitException) e;
            message = "Syntax error on token \"" + e.token.getText() + "\", delete this token";
            /*message = "required (...)+ loop (decision="+
                               eee.decisionNumber+
                               ") did not match anything; token="+
                               e.token;*/
        }
        else if ( e instanceof MismatchedSetException ) {
            MismatchedSetException mse = (MismatchedSetException)e;
            message = "mismatched token: "+
                               e.token+
                               "; expecting set "+mse.expecting;
        }
        else if ( e instanceof MismatchedNotSetException ) {
            MismatchedNotSetException mse = (MismatchedNotSetException)e;
            message = "mismatched token: "+
                               e.token+
                               "; expecting set "+mse.expecting;
        }
        else if ( e instanceof FailedPredicateException ) {
            FailedPredicateException fpe = (FailedPredicateException)e;
            message = "rule "+fpe.ruleName+" failed predicate: {"+
                               fpe.predicateText+"}?";
        }

        // the resource may be null if the parse is used for code completion
        if (resource != null) {
	        if (e.token instanceof CommonToken) {
	            CommonToken ct = (CommonToken) e.token;
	            resource.addError(message, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());
	        } 
	        else {
	            resource.addError(message, e.token.getCharPositionInLine(), e.token.getLine(),1,5);
	        }
        }
    }

	public static String formatTokenName(String tokenName) {
		if (tokenName.length() > 0 && tokenName.charAt(0) == '\'') {
			tokenName = tokenName.substring(1, tokenName.length());
		}
		if (tokenName.length() > 0 && tokenName.charAt(tokenName.length() - 1) == '\'') {
			tokenName = tokenName.substring(0, tokenName.length() - 1);
		}
		return tokenName;
	}

    /**
     * Translates errors thrown by the lexer into human readable messages.
     * 
     * @param e A RecognitionException.
     */
    public void reportLexicalError(RecognitionException e)  {
        String message = "";

        if (e instanceof MismatchedTokenException) {
            MismatchedTokenException mte = (MismatchedTokenException) e;
            message = "Syntax error on token \"" + ((char) e.c)
			          + "\", \"" + (char) mte.expecting + "\" expected";
            /*message= "mismatched char: '" + ((char) e.c)
                    + "' on line " + e.line + "; expecting char '"
                    + (char) mte.expecting + "'";*/
        } else if (e instanceof NoViableAltException) {
            //NoViableAltException nvae = (NoViableAltException) e;
            message = "Syntax error on token \"" + ((char) e.c) + "\", delete this token";
            /*message =nvae.grammarDecisionDescription + " state "
                    + nvae.stateNumber + " (decision=" + nvae.decisionNumber
                    + ") no viable alt line " + e.line + ":"
                    + e.charPositionInLine + "; char='" + ((char) e.c) + "'";*/
        } else if (e instanceof EarlyExitException) {
            EarlyExitException eee = (EarlyExitException) e;
            message ="required (...)+ loop (decision="
                    + eee.decisionNumber + ") did not match anything; on line "
                    + e.line + ":" + e.charPositionInLine + " char="
                    + ((char) e.c) + "'";
        } else if (e instanceof MismatchedSetException) {
            MismatchedSetException mse = (MismatchedSetException) e;
            message ="mismatched char: '" + ((char) e.c)
                    + "' on line " + e.line + ":" + e.charPositionInLine
                    + "; expecting set " + mse.expecting;
        } else if (e instanceof MismatchedNotSetException) {
            MismatchedSetException mse = (MismatchedSetException) e;
            message ="mismatched char: '" + ((char) e.c)
                    + "' on line " + e.line + ":" + e.charPositionInLine
                    + "; expecting set " + mse.expecting;
        } else if (e instanceof MismatchedRangeException) {
            MismatchedRangeException mre = (MismatchedRangeException) e;
            message ="mismatched char: '" + ((char) e.c)
                    + "' on line " + e.line + ":" + e.charPositionInLine
                    + "; expecting set '" + (char) mre.a + "'..'"
                    + (char) mre.b + "'";
        } else if (e instanceof FailedPredicateException) {
            FailedPredicateException fpe = (FailedPredicateException) e;
            message ="rule " + fpe.ruleName + " failed predicate: {"
                    + fpe.predicateText + "}?";
        }

    	resource.addError(message, e.index,e.line,lexerExceptionsPosition.get(lexerExceptions.indexOf(e)),lexerExceptionsPosition.get(lexerExceptions.indexOf(e)));
    }

	@Override
	public Object getMissingSymbol(IntStream arg0,
			RecognitionException arg1, int arg2, BitSet arg3) {
		mismatchedTokenRecoveryTries++;
		// redirect error stream to suppress 'BR.recoverFromMismatchedToken' message
		PrintStream originalErr = System.err;
		try{
			System.setErr(new PrintStream(new ByteArrayOutputStream()));
			return super.getMissingSymbol(arg0, arg1, arg2, arg3);			
		}
		finally{
			System.setErr(originalErr);			
		}
	}

	public int getMismatchedTokenRecoveryTries() {
		return mismatchedTokenRecoveryTries;
	}	
}
