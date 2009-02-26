package org.emftext.runtime.resource.impl;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.emftext.runtime.resource.ITextParser;
import org.emftext.runtime.resource.ILocationMap;
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
		if (value instanceof EMap){
			EMap valueMap = (EMap) value;
			if (mapKey != null && mapValue != null) {
				valueMap.put(mapKey, mapValue);
			}
		}
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
	 * The DummyEObject is used to build a stack of dummy objects when descending 
	 * by tail recursion into left recursive rules. They cache the setting 
	 * information for initializing concrete EObject instances.
 	 *
	 * When the tail descent is finished this stack is reduced in reverse order. The
	 * EObjects are created using the setting informations and a containment hierarchy 
	 * is build using the left recursive EStructuralFeature.
	 */
	public class DummyEObject extends EObjectImpl  {
		private Map<EStructuralFeature, Object> keyValueMap;
		private String recurseFeatureName;
		private EClass type;

		public DummyEObject(EClass type, String recurseFeatureName) {
			this.recurseFeatureName = recurseFeatureName;
			this.type = type;
			keyValueMap = new HashMap<EStructuralFeature, Object>();
		}

		public EObject applyTo(EObject currentTarget) {
			EStructuralFeature recurseFeature = currentTarget.eClass().getEStructuralFeature(this.recurseFeatureName);
			EObject newEObject = currentTarget.eClass().getEPackage().getEFactoryInstance().create(type);
			for (EStructuralFeature f : keyValueMap.keySet()) {
				EStructuralFeature structuralFeature = newEObject.eClass().getEStructuralFeature(f.getName());
				newEObject.eSet(structuralFeature, keyValueMap.get(f));
			}
			
			newEObject.eSet(recurseFeature, currentTarget);
			return newEObject;
		}

		public Object getValueByName(String name) {
			for(EStructuralFeature f : this.keyValueMap.keySet()) {
				if (f.getName().equals(name)) return this.keyValueMap.get(f);
			}
			return null;
 		}
		
		// proxy method
		public EClass eClass() {
			return type;
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

	
	
    public AbstractEMFTextParser(TokenStream input) {
    	super(input);
    }
    
    
    public AbstractEMFTextParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected ITextResource resource;
    
    public void setResource(ITextResource resource) {
        this.resource = resource;    	
    }
    
    public ITextResource getResource() {
    	return resource;
    }
    
    protected void copyLocalizationInfos(EObject source, EObject target) {
        final ILocationMap locationsMap = getResource().getLocationMap();
		locationsMap.setCharStart(target, locationsMap.getCharStart(source)); 
        locationsMap.setCharEnd(target, locationsMap.getCharEnd(source)); 
        locationsMap.setColumn(target, locationsMap.getColumn(source)); 
        locationsMap.setLine(target, locationsMap.getLine(source));
    }
    
    protected void copyLocalizationInfos(CommonToken source, EObject target) {
        final ILocationMap locationsMap = getResource().getLocationMap();
        locationsMap.setCharStart(target, source.getStartIndex()); 
        locationsMap.setCharEnd(target, source.getStopIndex());    
        locationsMap.setColumn(target, source.getCharPositionInLine());    
        locationsMap.setLine(target, source.getLine());
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
    public EObject parse()  {
        
        try {
            EObject result =  doParse();
            if(lexerExceptions.isEmpty())
            	return result;

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
