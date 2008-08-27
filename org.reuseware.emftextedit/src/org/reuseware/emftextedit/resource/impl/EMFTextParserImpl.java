package org.reuseware.emftextedit.resource.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.impl.EClassifierImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStructuralFeatureImpl;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.FailedPredicateException;
import org.antlr.runtime.MismatchedNotSetException;
import org.antlr.runtime.MismatchedRangeException;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.MismatchedTreeNodeException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.reuseware.emftextedit.resource.EMFTextParser;
import org.reuseware.emftextedit.resource.TextResource;
import org.reuseware.emftextedit.resource.TokenConversionException;

/**
 * Base implementation for all generated ANTLR parsers. 
 * It implements the specifications from {@link EMFTextParser}.
 * 
 * @author Jendrik Johannes
 */
public abstract class EMFTextParserImpl extends Parser implements EMFTextParser {    
    
	
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
	
	public class DummyEStructuralFeature extends EStructuralFeatureImpl {
		private String dummyName;
		
		public DummyEStructuralFeature(String name) {
			this.dummyName = name;
		}
		
		public String getName() {
			return dummyName;
		}
	
	}

	public class DummyEClass extends EClassImpl {
				
		// dummy method
		public EStructuralFeature getEStructuralFeature(String name) {
			return new DummyEStructuralFeature(name);
		}
	}

	public class DummyEObject extends EObjectImpl  {
		private Map<EStructuralFeature, Object> keyValueMap;
		private String recurseFeatureName;
		private String typeName;

		public DummyEObject(String typeName, String recurseFeatureName) {
			this.recurseFeatureName = recurseFeatureName;
			this.typeName = typeName;
			keyValueMap = new HashMap<EStructuralFeature, Object>();
		}

		public EObject applyTo(EObject currentTarget) {
			EStructuralFeature recurseFeature = currentTarget.eClass().getEStructuralFeature(this.recurseFeatureName);
			EClass type = (EClass) currentTarget.eClass().getEPackage().getEClassifier(typeName);
			EObject newEObject = currentTarget.eClass().getEPackage().getEFactoryInstance().create(type);
			for (EStructuralFeature f : keyValueMap.keySet()) {
				EStructuralFeature structuralFeature = newEObject.eClass().getEStructuralFeature(f.getName());
				newEObject.eSet(structuralFeature, keyValueMap.get(f));
			}
			
			newEObject.eSet(recurseFeature, currentTarget);
			return newEObject;
		}

		// dummy method
		public EClass eClass() {
			return new DummyEClass();
		}
		

		public void eSet(EStructuralFeature structuralFeature, Object a0) {
			this.keyValueMap.put(structuralFeature, a0);
			
		}
		
		public String toString() {
			String keyValuePairs = recurseFeatureName + ": ";
			for (EStructuralFeature f : keyValueMap.keySet()) {
				keyValuePairs += f.getName() + " = " + keyValueMap.get(f) + "\n";
			}
			return keyValuePairs;
		}
	}

	
	
    public EMFTextParserImpl(TokenStream input) {
    	super(input);
    }
    
    protected TextResource resource;
    
    public void setResource(TextResource resource) {
        this.resource = resource;    	
    }
    
    public TextResource getResource() {
    	return this.resource;
    }

    //helper lists to allow a lexer to pass errors to its parser
    protected List<RecognitionException> lexerExceptions = Collections.synchronizedList(new ArrayList<RecognitionException>());
    protected List<Integer>              lexerExceptionsPosition = Collections.synchronizedList(new ArrayList<Integer>());
    
    /**
     * This method should will be overridden by generated subclasses.
     * This implementation does nothing.
     */
    protected  EObject doParse() throws RecognitionException { return null; };
    
    /**
     * Implementation that calls {@link #doParse()}  and handles the thrown
     * <code>RecognitionException</code>s.
     */
    public EObject parse()  {
        
        try {
            EObject result =  doParse();
            if(lexerExceptions.isEmpty())
            	return result;

        } catch (RecognitionException re) {
            reportError(re);
        } catch (IllegalArgumentException e) {
        	e.printStackTrace();
            //? can be caused if a null is set on EMF models where not allowed;
            //? this will just happen if other errors occurred before
        }
        for(RecognitionException re: lexerExceptions){
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
        String message = "";
        
        if( e instanceof TokenConversionException){
        	message = e.getMessage();
        }
        else if ( e instanceof MismatchedTokenException ) {
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

        
        if (e.token instanceof CommonToken) {
            CommonToken ct = (CommonToken) e.token;
            resource.addError(message, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());
        } 
        else {
            resource.addError(message, e.token.getCharPositionInLine(), e.token.getLine(),1,5);
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
    
    
    
}
