// $ANTLR 3.1.1 D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g 2009-02-18 21:16:42

package org.emftext.sdk.concretesyntax.resource.cs;

import java.util.HashMap;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.impl.AbstractEMFTextParser;
public class CsParser extends AbstractEMFTextParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "QUALIFIED_NAME", "QUOTED_60_62", "QUOTED_34_34", "QUOTED_39_39", "NUMBER", "QUOTED_36_36", "COMMENTS", "WHITESPACE", "LINEBREAK", "'SYNTAXDEF'", "'FOR'", "'START'", "','", "'IMPORTS'", "'{'", "'}'", "'OPTIONS'", "';'", "'TOKENS'", "'RULES'", "':'", "'WITH'", "'SYNTAX'", "'='", "'::='", "'|'", "'['", "']'", "'('", "')'", "'+'", "'*'", "'?'", "'#'", "'!'", "'DEFINE'", "'COLLECT'", "'IN'", "'PREDEFINED'"
    };
    public static final int T__42=42;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int QUOTED_39_39=7;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int NUMBER=8;
    public static final int WHITESPACE=11;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int COMMENTS=10;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__14=14;
    public static final int QUOTED_36_36=9;
    public static final int T__13=13;
    public static final int QUOTED_60_62=5;
    public static final int QUOTED_34_34=6;
    public static final int LINEBREAK=12;
    public static final int QUALIFIED_NAME=4;

    // delegates
    // delegators


        public CsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public CsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[57+1];
             
             
        }
        

    public String[] getTokenNames() { return CsParser.tokenNames; }
    public String getGrammarFileName() { return "D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g"; }


    	private org.emftext.runtime.resource.ITokenResolverFactory tokenResolverFactory = new CsTokenResolverFactory();
    	private org.emftext.runtime.resource.impl.TokenResolveResult tokenResolveResult = new org.emftext.runtime.resource.impl.TokenResolveResult();

    	protected EObject doParse() throws RecognitionException {
    		((CsLexer)getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((CsLexer)getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		return start();
    	}

    	@SuppressWarnings("unchecked")
    	private boolean addObjectToList(org.eclipse.emf.ecore.EObject element, int featureID, java.lang.Object proxy) {
    		return ((java.util.List<java.lang.Object>) element.eGet(element.eClass().getEStructuralFeature(featureID))).add(proxy);
    	}

    	private org.emftext.runtime.resource.impl.TokenResolveResult getFreshTokenResolveResult() {
    		tokenResolveResult.clear();
    		return tokenResolveResult;
    	}

    	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element, Object o) {
    	}



    // $ANTLR start "start"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:57:1: start returns [ EObject element = null] : (c0= concretesyntax ) EOF ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;
        int start_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.ConcreteSyntax c0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:59:1: ( (c0= concretesyntax ) EOF )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:60:2: (c0= concretesyntax ) EOF
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:60:2: (c0= concretesyntax )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:61:1: c0= concretesyntax
            {
            pushFollow(FOLLOW_concretesyntax_in_start76);
            c0=concretesyntax();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
               element = c0; 
            }

            }

            match(input,EOF,FOLLOW_EOF_in_start83); if (state.failed) return element;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 1, start_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "start"


    // $ANTLR start "concretesyntax"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:67:1: concretesyntax returns [org.emftext.sdk.concretesyntax.ConcreteSyntax element = null] : a0= 'SYNTAXDEF' a1= QUALIFIED_NAME a2= 'FOR' a3= QUOTED_60_62 ( (a4= QUOTED_60_62 ) )? a5= 'START' (a6= QUALIFIED_NAME ) ( (a7= ',' (a8= QUALIFIED_NAME ) ) )* ( (a9= 'IMPORTS' a10= '{' ( (a11= keywordimport ) )* a12= '}' ) )? ( (a13= 'OPTIONS' a14= '{' ( (a15= option a16= ';' ) )* a17= '}' ) )? ( (a18= 'TOKENS' a19= '{' ( (a20= tokendefinition a21= ';' ) )* a22= '}' ) )? a23= 'RULES' a24= '{' ( (a25= rule )+ ) a26= '}' ;
    public final org.emftext.sdk.concretesyntax.ConcreteSyntax concretesyntax() throws RecognitionException {
        org.emftext.sdk.concretesyntax.ConcreteSyntax element =  null;
        int concretesyntax_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        Token a9=null;
        Token a10=null;
        Token a12=null;
        Token a13=null;
        Token a14=null;
        Token a16=null;
        Token a17=null;
        Token a18=null;
        Token a19=null;
        Token a21=null;
        Token a22=null;
        Token a23=null;
        Token a24=null;
        Token a26=null;
        org.emftext.sdk.concretesyntax.Import a11 = null;

        org.emftext.sdk.concretesyntax.Option a15 = null;

        org.emftext.sdk.concretesyntax.TokenDefinition a20 = null;

        org.emftext.sdk.concretesyntax.Rule a25 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:70:1: (a0= 'SYNTAXDEF' a1= QUALIFIED_NAME a2= 'FOR' a3= QUOTED_60_62 ( (a4= QUOTED_60_62 ) )? a5= 'START' (a6= QUALIFIED_NAME ) ( (a7= ',' (a8= QUALIFIED_NAME ) ) )* ( (a9= 'IMPORTS' a10= '{' ( (a11= keywordimport ) )* a12= '}' ) )? ( (a13= 'OPTIONS' a14= '{' ( (a15= option a16= ';' ) )* a17= '}' ) )? ( (a18= 'TOKENS' a19= '{' ( (a20= tokendefinition a21= ';' ) )* a22= '}' ) )? a23= 'RULES' a24= '{' ( (a25= rule )+ ) a26= '}' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:71:2: a0= 'SYNTAXDEF' a1= QUALIFIED_NAME a2= 'FOR' a3= QUOTED_60_62 ( (a4= QUOTED_60_62 ) )? a5= 'START' (a6= QUALIFIED_NAME ) ( (a7= ',' (a8= QUALIFIED_NAME ) ) )* ( (a9= 'IMPORTS' a10= '{' ( (a11= keywordimport ) )* a12= '}' ) )? ( (a13= 'OPTIONS' a14= '{' ( (a15= option a16= ';' ) )* a17= '}' ) )? ( (a18= 'TOKENS' a19= '{' ( (a20= tokendefinition a21= ';' ) )* a22= '}' ) )? a23= 'RULES' a24= '{' ( (a25= rule )+ ) a26= '}'
            {
            a0=(Token)match(input,13,FOLLOW_13_in_concretesyntax106); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_concretesyntax114); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) {
              	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); 
              }
              org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
              tokenResolver.setOptions(getOptions());
              org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME), result);
              Object resolvedObject = result.getResolvedToken();
              if (resolvedObject == null) {
              	getResource().addError(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
              }
              	java.lang.String resolved = (java.lang.String)resolvedObject;

              if (resolved != null) {
              element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME), resolved); 
              }
              collectHiddenTokens(element, resolved);
              copyLocalizationInfos((CommonToken) a1, element); 

            }
            a2=(Token)match(input,14,FOLLOW_14_in_concretesyntax123); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a2);copyLocalizationInfos((CommonToken)a2, element); 
            }
            a3=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_concretesyntax131); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) {
              	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); 
              }
              org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
              tokenResolver.setOptions(getOptions());
              org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), result);
              Object resolvedObject = result.getResolvedToken();
              if (resolvedObject == null) {
              	getResource().addError(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
              }
              String resolved = (String) resolvedObject;
              org.eclipse.emf.codegen.ecore.genmodel.GenPackage proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenPackage();
              collectHiddenTokens(element, proxy);
              getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), resolved, proxy);

              if (proxy != null) {
              element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), proxy); 
              }
              collectHiddenTokens(element, proxy);
              copyLocalizationInfos((CommonToken) a3, element); 
              copyLocalizationInfos((CommonToken) a3, proxy); 

            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:117:2: ( (a4= QUOTED_60_62 ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==QUOTED_60_62) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:118:3: (a4= QUOTED_60_62 )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:118:3: (a4= QUOTED_60_62 )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:119:4: a4= QUOTED_60_62
                    {
                    a4=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_concretesyntax149); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) {
                      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); 
                      }
                      org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
                      tokenResolver.setOptions(getOptions());
                      org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
                      tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE_LOCATION_HINT), result);
                      Object resolvedObject = result.getResolvedToken();
                      if (resolvedObject == null) {
                      	getResource().addError(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
                      }
                      	java.lang.String resolved = (java.lang.String)resolvedObject;

                      if (resolved != null) {
                      element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE_LOCATION_HINT), resolved); 
                      }
                      collectHiddenTokens(element, resolved);
                      copyLocalizationInfos((CommonToken) a4, element); 

                    }

                    }


                    }
                    break;

            }

            a5=(Token)match(input,15,FOLLOW_15_in_concretesyntax166); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a5);copyLocalizationInfos((CommonToken)a5, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:142:2: (a6= QUALIFIED_NAME )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:143:3: a6= QUALIFIED_NAME
            {
            a6=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_concretesyntax178); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) {
              	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); 
              }
              org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
              tokenResolver.setOptions(getOptions());
              org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), result);
              Object resolvedObject = result.getResolvedToken();
              if (resolvedObject == null) {
              	getResource().addError(result.getErrorMessage(), ((CommonToken) a6).getLine(), ((CommonToken) a6).getCharPositionInLine(), ((CommonToken) a6).getStartIndex(), ((CommonToken) a6).getStopIndex());
              }
              String resolved = (String) resolvedObject;
              org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();
              collectHiddenTokens(element, proxy);
              getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), resolved, proxy);

              if (proxy != null) {
              addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS, proxy); 
              }
              collectHiddenTokens(element, proxy);
              copyLocalizationInfos((CommonToken) a6, element); 
              copyLocalizationInfos((CommonToken) a6, proxy); 

            }

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:168:2: ( (a7= ',' (a8= QUALIFIED_NAME ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==16) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:169:3: (a7= ',' (a8= QUALIFIED_NAME ) )
            	    {
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:169:3: (a7= ',' (a8= QUALIFIED_NAME ) )
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:170:4: a7= ',' (a8= QUALIFIED_NAME )
            	    {
            	    a7=(Token)match(input,16,FOLLOW_16_in_concretesyntax199); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {
            	       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a7);copyLocalizationInfos((CommonToken)a7, element); 
            	    }
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:171:4: (a8= QUALIFIED_NAME )
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:172:5: a8= QUALIFIED_NAME
            	    {
            	    a8=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_concretesyntax215); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {
            	      if (element == null) {
            	      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); 
            	      }
            	      org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
            	      tokenResolver.setOptions(getOptions());
            	      org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
            	      tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), result);
            	      Object resolvedObject = result.getResolvedToken();
            	      if (resolvedObject == null) {
            	      	getResource().addError(result.getErrorMessage(), ((CommonToken) a8).getLine(), ((CommonToken) a8).getCharPositionInLine(), ((CommonToken) a8).getStartIndex(), ((CommonToken) a8).getStopIndex());
            	      }
            	      String resolved = (String) resolvedObject;
            	      org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();
            	      collectHiddenTokens(element, proxy);
            	      getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), resolved, proxy);

            	      if (proxy != null) {
            	      addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS, proxy); 
            	      }
            	      collectHiddenTokens(element, proxy);
            	      copyLocalizationInfos((CommonToken) a8, element); 
            	      copyLocalizationInfos((CommonToken) a8, proxy); 

            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:199:2: ( (a9= 'IMPORTS' a10= '{' ( (a11= keywordimport ) )* a12= '}' ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==17) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:200:3: (a9= 'IMPORTS' a10= '{' ( (a11= keywordimport ) )* a12= '}' )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:200:3: (a9= 'IMPORTS' a10= '{' ( (a11= keywordimport ) )* a12= '}' )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:201:4: a9= 'IMPORTS' a10= '{' ( (a11= keywordimport ) )* a12= '}'
                    {
                    a9=(Token)match(input,17,FOLLOW_17_in_concretesyntax246); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a9);copyLocalizationInfos((CommonToken)a9, element); 
                    }
                    a10=(Token)match(input,18,FOLLOW_18_in_concretesyntax256); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a10);copyLocalizationInfos((CommonToken)a10, element); 
                    }
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:203:4: ( (a11= keywordimport ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==QUALIFIED_NAME) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:204:5: (a11= keywordimport )
                    	    {
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:204:5: (a11= keywordimport )
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:205:6: a11= keywordimport
                    	    {
                    	    pushFollow(FOLLOW_keywordimport_in_concretesyntax279);
                    	    a11=keywordimport();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	      if (element == null) {
                    	      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); 
                    	      }

                    	      if (a11 != null) {
                    	      addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__IMPORTS, a11); 
                    	      }
                    	      collectHiddenTokens(element, a11);
                    	      copyLocalizationInfos(a11, element); 

                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    a12=(Token)match(input,19,FOLLOW_19_in_concretesyntax302); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a12);copyLocalizationInfos((CommonToken)a12, element); 
                    }

                    }


                    }
                    break;

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:221:2: ( (a13= 'OPTIONS' a14= '{' ( (a15= option a16= ';' ) )* a17= '}' ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==20) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:222:3: (a13= 'OPTIONS' a14= '{' ( (a15= option a16= ';' ) )* a17= '}' )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:222:3: (a13= 'OPTIONS' a14= '{' ( (a15= option a16= ';' ) )* a17= '}' )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:223:4: a13= 'OPTIONS' a14= '{' ( (a15= option a16= ';' ) )* a17= '}'
                    {
                    a13=(Token)match(input,20,FOLLOW_20_in_concretesyntax327); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a13);copyLocalizationInfos((CommonToken)a13, element); 
                    }
                    a14=(Token)match(input,18,FOLLOW_18_in_concretesyntax337); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a14);copyLocalizationInfos((CommonToken)a14, element); 
                    }
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:225:4: ( (a15= option a16= ';' ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==QUALIFIED_NAME) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:226:5: (a15= option a16= ';' )
                    	    {
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:226:5: (a15= option a16= ';' )
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:227:6: a15= option a16= ';'
                    	    {
                    	    pushFollow(FOLLOW_option_in_concretesyntax360);
                    	    a15=option();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	      if (element == null) {
                    	      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); 
                    	      }

                    	      if (a15 != null) {
                    	      addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__OPTIONS, a15); 
                    	      }
                    	      collectHiddenTokens(element, a15);
                    	      copyLocalizationInfos(a15, element); 

                    	    }
                    	    a16=(Token)match(input,21,FOLLOW_21_in_concretesyntax373); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a16);copyLocalizationInfos((CommonToken)a16, element); 
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    a17=(Token)match(input,19,FOLLOW_19_in_concretesyntax395); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a17);copyLocalizationInfos((CommonToken)a17, element); 
                    }

                    }


                    }
                    break;

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:244:2: ( (a18= 'TOKENS' a19= '{' ( (a20= tokendefinition a21= ';' ) )* a22= '}' ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==22) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:245:3: (a18= 'TOKENS' a19= '{' ( (a20= tokendefinition a21= ';' ) )* a22= '}' )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:245:3: (a18= 'TOKENS' a19= '{' ( (a20= tokendefinition a21= ';' ) )* a22= '}' )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:246:4: a18= 'TOKENS' a19= '{' ( (a20= tokendefinition a21= ';' ) )* a22= '}'
                    {
                    a18=(Token)match(input,22,FOLLOW_22_in_concretesyntax420); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a18);copyLocalizationInfos((CommonToken)a18, element); 
                    }
                    a19=(Token)match(input,18,FOLLOW_18_in_concretesyntax430); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a19);copyLocalizationInfos((CommonToken)a19, element); 
                    }
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:248:4: ( (a20= tokendefinition a21= ';' ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==39||LA7_0==42) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:249:5: (a20= tokendefinition a21= ';' )
                    	    {
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:249:5: (a20= tokendefinition a21= ';' )
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:250:6: a20= tokendefinition a21= ';'
                    	    {
                    	    pushFollow(FOLLOW_tokendefinition_in_concretesyntax453);
                    	    a20=tokendefinition();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	      if (element == null) {
                    	      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); 
                    	      }

                    	      if (a20 != null) {
                    	      addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKENS, a20); 
                    	      }
                    	      collectHiddenTokens(element, a20);
                    	      copyLocalizationInfos(a20, element); 

                    	    }
                    	    a21=(Token)match(input,21,FOLLOW_21_in_concretesyntax466); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a21);copyLocalizationInfos((CommonToken)a21, element); 
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    a22=(Token)match(input,19,FOLLOW_19_in_concretesyntax488); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a22);copyLocalizationInfos((CommonToken)a22, element); 
                    }

                    }


                    }
                    break;

            }

            a23=(Token)match(input,23,FOLLOW_23_in_concretesyntax504); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a23);copyLocalizationInfos((CommonToken)a23, element); 
            }
            a24=(Token)match(input,18,FOLLOW_18_in_concretesyntax512); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a24);copyLocalizationInfos((CommonToken)a24, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:269:2: ( (a25= rule )+ )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:270:3: (a25= rule )+
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:270:3: (a25= rule )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==QUALIFIED_NAME) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:271:4: a25= rule
            	    {
            	    pushFollow(FOLLOW_rule_in_concretesyntax529);
            	    a25=rule();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {
            	      if (element == null) {
            	      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); 
            	      }

            	      if (a25 != null) {
            	      addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES, a25); 
            	      }
            	      collectHiddenTokens(element, a25);
            	      copyLocalizationInfos(a25, element); 

            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            }

            a26=(Token)match(input,19,FOLLOW_19_in_concretesyntax546); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a26);copyLocalizationInfos((CommonToken)a26, element); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, concretesyntax_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "concretesyntax"


    // $ANTLR start "keywordimport"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:287:1: keywordimport returns [org.emftext.sdk.concretesyntax.Import element = null] : a0= QUALIFIED_NAME a1= ':' a2= QUOTED_60_62 ( (a3= QUOTED_60_62 ) )? ( (a4= 'WITH' a5= 'SYNTAX' a6= QUALIFIED_NAME ( (a7= QUOTED_60_62 ) )? ) )? ;
    public final org.emftext.sdk.concretesyntax.Import keywordimport() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Import element =  null;
        int keywordimport_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:290:1: (a0= QUALIFIED_NAME a1= ':' a2= QUOTED_60_62 ( (a3= QUOTED_60_62 ) )? ( (a4= 'WITH' a5= 'SYNTAX' a6= QUALIFIED_NAME ( (a7= QUOTED_60_62 ) )? ) )? )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:291:2: a0= QUALIFIED_NAME a1= ':' a2= QUOTED_60_62 ( (a3= QUOTED_60_62 ) )? ( (a4= 'WITH' a5= 'SYNTAX' a6= QUALIFIED_NAME ( (a7= QUOTED_60_62 ) )? ) )?
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_keywordimport569); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) {
              	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport(); 
              }
              org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
              tokenResolver.setOptions(getOptions());
              org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PREFIX), result);
              Object resolvedObject = result.getResolvedToken();
              if (resolvedObject == null) {
              	getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
              }
              	java.lang.String resolved = (java.lang.String)resolvedObject;

              if (resolved != null) {
              element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PREFIX), resolved); 
              }
              collectHiddenTokens(element, resolved);
              copyLocalizationInfos((CommonToken) a0, element); 

            }
            a1=(Token)match(input,24,FOLLOW_24_in_keywordimport578); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            }
            a2=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_keywordimport586); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) {
              	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport(); 
              }
              org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
              tokenResolver.setOptions(getOptions());
              org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), result);
              Object resolvedObject = result.getResolvedToken();
              if (resolvedObject == null) {
              	getResource().addError(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
              }
              String resolved = (String) resolvedObject;
              org.eclipse.emf.codegen.ecore.genmodel.GenPackage proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenPackage();
              collectHiddenTokens(element, proxy);
              getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), resolved, proxy);

              if (proxy != null) {
              element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), proxy); 
              }
              collectHiddenTokens(element, proxy);
              copyLocalizationInfos((CommonToken) a2, element); 
              copyLocalizationInfos((CommonToken) a2, proxy); 

            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:336:2: ( (a3= QUOTED_60_62 ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==QUOTED_60_62) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:337:3: (a3= QUOTED_60_62 )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:337:3: (a3= QUOTED_60_62 )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:338:4: a3= QUOTED_60_62
                    {
                    a3=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_keywordimport604); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) {
                      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport(); 
                      }
                      org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
                      tokenResolver.setOptions(getOptions());
                      org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
                      tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE_LOCATION_HINT), result);
                      Object resolvedObject = result.getResolvedToken();
                      if (resolvedObject == null) {
                      	getResource().addError(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
                      }
                      	java.lang.String resolved = (java.lang.String)resolvedObject;

                      if (resolved != null) {
                      element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE_LOCATION_HINT), resolved); 
                      }
                      collectHiddenTokens(element, resolved);
                      copyLocalizationInfos((CommonToken) a3, element); 

                    }

                    }


                    }
                    break;

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:360:2: ( (a4= 'WITH' a5= 'SYNTAX' a6= QUALIFIED_NAME ( (a7= QUOTED_60_62 ) )? ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==25) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:361:3: (a4= 'WITH' a5= 'SYNTAX' a6= QUALIFIED_NAME ( (a7= QUOTED_60_62 ) )? )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:361:3: (a4= 'WITH' a5= 'SYNTAX' a6= QUALIFIED_NAME ( (a7= QUOTED_60_62 ) )? )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:362:4: a4= 'WITH' a5= 'SYNTAX' a6= QUALIFIED_NAME ( (a7= QUOTED_60_62 ) )?
                    {
                    a4=(Token)match(input,25,FOLLOW_25_in_keywordimport630); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport();} collectHiddenTokens(element, (CommonToken)a4);copyLocalizationInfos((CommonToken)a4, element); 
                    }
                    a5=(Token)match(input,26,FOLLOW_26_in_keywordimport640); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport();} collectHiddenTokens(element, (CommonToken)a5);copyLocalizationInfos((CommonToken)a5, element); 
                    }
                    a6=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_keywordimport650); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) {
                      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport(); 
                      }
                      org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
                      tokenResolver.setOptions(getOptions());
                      org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
                      tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), result);
                      Object resolvedObject = result.getResolvedToken();
                      if (resolvedObject == null) {
                      	getResource().addError(result.getErrorMessage(), ((CommonToken) a6).getLine(), ((CommonToken) a6).getCharPositionInLine(), ((CommonToken) a6).getStartIndex(), ((CommonToken) a6).getStopIndex());
                      }
                      String resolved = (String) resolvedObject;
                      org.emftext.sdk.concretesyntax.ConcreteSyntax proxy = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();
                      collectHiddenTokens(element, proxy);
                      getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), resolved, proxy);

                      if (proxy != null) {
                      element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), proxy); 
                      }
                      collectHiddenTokens(element, proxy);
                      copyLocalizationInfos((CommonToken) a6, element); 
                      copyLocalizationInfos((CommonToken) a6, proxy); 

                    }
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:388:4: ( (a7= QUOTED_60_62 ) )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==QUOTED_60_62) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:389:5: (a7= QUOTED_60_62 )
                            {
                            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:389:5: (a7= QUOTED_60_62 )
                            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:390:6: a7= QUOTED_60_62
                            {
                            a7=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_keywordimport674); if (state.failed) return element;
                            if ( state.backtracking==0 ) {
                              if (element == null) {
                              	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport(); 
                              }
                              org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
                              tokenResolver.setOptions(getOptions());
                              org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
                              tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CS_LOCATION_HINT), result);
                              Object resolvedObject = result.getResolvedToken();
                              if (resolvedObject == null) {
                              	getResource().addError(result.getErrorMessage(), ((CommonToken) a7).getLine(), ((CommonToken) a7).getCharPositionInLine(), ((CommonToken) a7).getStartIndex(), ((CommonToken) a7).getStopIndex());
                              }
                              	java.lang.String resolved = (java.lang.String)resolvedObject;

                              if (resolved != null) {
                              element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CS_LOCATION_HINT), resolved); 
                              }
                              collectHiddenTokens(element, resolved);
                              copyLocalizationInfos((CommonToken) a7, element); 

                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, keywordimport_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "keywordimport"


    // $ANTLR start "option"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:416:1: option returns [org.emftext.sdk.concretesyntax.Option element = null] : a0= QUALIFIED_NAME a1= '=' a2= QUOTED_34_34 ;
    public final org.emftext.sdk.concretesyntax.Option option() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Option element =  null;
        int option_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:419:1: (a0= QUALIFIED_NAME a1= '=' a2= QUOTED_34_34 )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:420:2: a0= QUALIFIED_NAME a1= '=' a2= QUOTED_34_34
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_option718); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) {
              	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createOption(); 
              }
              org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
              tokenResolver.setOptions(getOptions());
              org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__NAME), result);
              Object resolvedObject = result.getResolvedToken();
              if (resolvedObject == null) {
              	getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
              }
              	java.lang.String resolved = (java.lang.String)resolvedObject;

              if (resolved != null) {
              element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__NAME), resolved); 
              }
              collectHiddenTokens(element, resolved);
              copyLocalizationInfos((CommonToken) a0, element); 

            }
            a1=(Token)match(input,27,FOLLOW_27_in_option727); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createOption();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            }
            a2=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_option735); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) {
              	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createOption(); 
              }
              org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
              tokenResolver.setOptions(getOptions());
              org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__VALUE), result);
              Object resolvedObject = result.getResolvedToken();
              if (resolvedObject == null) {
              	getResource().addError(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
              }
              	java.lang.String resolved = (java.lang.String)resolvedObject;

              if (resolved != null) {
              element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__VALUE), resolved); 
              }
              collectHiddenTokens(element, resolved);
              copyLocalizationInfos((CommonToken) a2, element); 

            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, option_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "option"


    // $ANTLR start "rule"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:463:1: rule returns [org.emftext.sdk.concretesyntax.Rule element = null] : (a0= QUALIFIED_NAME ) a1= '::=' a2= choice a3= ';' ;
    public final org.emftext.sdk.concretesyntax.Rule rule() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Rule element =  null;
        int rule_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a3=null;
        org.emftext.sdk.concretesyntax.Choice a2 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:466:1: ( (a0= QUALIFIED_NAME ) a1= '::=' a2= choice a3= ';' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:467:2: (a0= QUALIFIED_NAME ) a1= '::=' a2= choice a3= ';'
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:467:2: (a0= QUALIFIED_NAME )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:468:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_rule763); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) {
              	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createRule(); 
              }
              org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
              tokenResolver.setOptions(getOptions());
              org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), result);
              Object resolvedObject = result.getResolvedToken();
              if (resolvedObject == null) {
              	getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
              }
              String resolved = (String) resolvedObject;
              org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();
              collectHiddenTokens(element, proxy);
              getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), resolved, proxy);

              if (proxy != null) {
              element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), proxy); 
              }
              collectHiddenTokens(element, proxy);
              copyLocalizationInfos((CommonToken) a0, element); 
              copyLocalizationInfos((CommonToken) a0, proxy); 

            }

            }

            a1=(Token)match(input,28,FOLLOW_28_in_rule775); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createRule();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            }
            pushFollow(FOLLOW_choice_in_rule783);
            a2=choice();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) {
              	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createRule(); 
              }

              if (a2 != null) {
              element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__DEFINITION), a2); 
              }
              collectHiddenTokens(element, a2);
              copyLocalizationInfos(a2, element); 

            }
            a3=(Token)match(input,21,FOLLOW_21_in_rule792); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createRule();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, rule_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "rule"


    // $ANTLR start "sequence"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:508:1: sequence returns [org.emftext.sdk.concretesyntax.Sequence element = null] : (a0= definition )+ ;
    public final org.emftext.sdk.concretesyntax.Sequence sequence() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Sequence element =  null;
        int sequence_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.Definition a0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:511:1: ( (a0= definition )+ )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:512:2: (a0= definition )+
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:512:2: (a0= definition )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==QUALIFIED_NAME||LA13_0==QUOTED_34_34||LA13_0==32||(LA13_0>=37 && LA13_0<=38)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:513:3: a0= definition
            	    {
            	    pushFollow(FOLLOW_definition_in_sequence819);
            	    a0=definition();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {
            	      if (element == null) {
            	      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createSequence(); 
            	      }

            	      if (a0 != null) {
            	      addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.SEQUENCE__PARTS, a0); 
            	      }
            	      collectHiddenTokens(element, a0);
            	      copyLocalizationInfos(a0, element); 

            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, sequence_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "sequence"


    // $ANTLR start "choice"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:527:1: choice returns [org.emftext.sdk.concretesyntax.Choice element = null] : a0= sequence ( (a1= '|' a2= sequence ) )* ;
    public final org.emftext.sdk.concretesyntax.Choice choice() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Choice element =  null;
        int choice_StartIndex = input.index();
        Token a1=null;
        org.emftext.sdk.concretesyntax.Sequence a0 = null;

        org.emftext.sdk.concretesyntax.Sequence a2 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:530:1: (a0= sequence ( (a1= '|' a2= sequence ) )* )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:531:2: a0= sequence ( (a1= '|' a2= sequence ) )*
            {
            pushFollow(FOLLOW_sequence_in_choice847);
            a0=sequence();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) {
              	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createChoice(); 
              }

              if (a0 != null) {
              addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CHOICE__OPTIONS, a0); 
              }
              collectHiddenTokens(element, a0);
              copyLocalizationInfos(a0, element); 

            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:542:2: ( (a1= '|' a2= sequence ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==29) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:543:3: (a1= '|' a2= sequence )
            	    {
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:543:3: (a1= '|' a2= sequence )
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:544:4: a1= '|' a2= sequence
            	    {
            	    a1=(Token)match(input,29,FOLLOW_29_in_choice865); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {
            	       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createChoice();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            	    }
            	    pushFollow(FOLLOW_sequence_in_choice875);
            	    a2=sequence();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {
            	      if (element == null) {
            	      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createChoice(); 
            	      }

            	      if (a2 != null) {
            	      addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CHOICE__OPTIONS, a2); 
            	      }
            	      collectHiddenTokens(element, a2);
            	      copyLocalizationInfos(a2, element); 

            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, choice_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "choice"


    // $ANTLR start "csstring"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:560:1: csstring returns [org.emftext.sdk.concretesyntax.CsString element = null] : a0= QUOTED_34_34 ;
    public final org.emftext.sdk.concretesyntax.CsString csstring() throws RecognitionException {
        org.emftext.sdk.concretesyntax.CsString element =  null;
        int csstring_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:563:1: (a0= QUOTED_34_34 )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:564:2: a0= QUOTED_34_34
            {
            a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_csstring907); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) {
              	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createCsString(); 
              }
              org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
              tokenResolver.setOptions(getOptions());
              org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CS_STRING__VALUE), result);
              Object resolvedObject = result.getResolvedToken();
              if (resolvedObject == null) {
              	getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
              }
              	java.lang.String resolved = (java.lang.String)resolvedObject;

              if (resolved != null) {
              element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CS_STRING__VALUE), resolved); 
              }
              collectHiddenTokens(element, resolved);
              copyLocalizationInfos((CommonToken) a0, element); 

            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, csstring_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "csstring"


    // $ANTLR start "definedplaceholder"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:586:1: definedplaceholder returns [org.emftext.sdk.concretesyntax.DefinedPlaceholder element = null] : a0= QUALIFIED_NAME a1= '[' a2= QUALIFIED_NAME a3= ']' (a4= cardinality )? ;
    public final org.emftext.sdk.concretesyntax.DefinedPlaceholder definedplaceholder() throws RecognitionException {
        org.emftext.sdk.concretesyntax.DefinedPlaceholder element =  null;
        int definedplaceholder_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        org.emftext.sdk.concretesyntax.Cardinality a4 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:589:1: (a0= QUALIFIED_NAME a1= '[' a2= QUALIFIED_NAME a3= ']' (a4= cardinality )? )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:590:2: a0= QUALIFIED_NAME a1= '[' a2= QUALIFIED_NAME a3= ']' (a4= cardinality )?
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_definedplaceholder931); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) {
              	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDefinedPlaceholder(); 
              }
              org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
              tokenResolver.setOptions(getOptions());
              org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DEFINED_PLACEHOLDER__FEATURE), result);
              Object resolvedObject = result.getResolvedToken();
              if (resolvedObject == null) {
              	getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
              }
              String resolved = (String) resolvedObject;
              org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenFeature();
              collectHiddenTokens(element, proxy);
              getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DEFINED_PLACEHOLDER__FEATURE), resolved, proxy);

              if (proxy != null) {
              element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DEFINED_PLACEHOLDER__FEATURE), proxy); 
              }
              collectHiddenTokens(element, proxy);
              copyLocalizationInfos((CommonToken) a0, element); 
              copyLocalizationInfos((CommonToken) a0, proxy); 

            }
            a1=(Token)match(input,30,FOLLOW_30_in_definedplaceholder940); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDefinedPlaceholder();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            }
            a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_definedplaceholder948); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) {
              	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDefinedPlaceholder(); 
              }
              org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
              tokenResolver.setOptions(getOptions());
              org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DEFINED_PLACEHOLDER__TOKEN), result);
              Object resolvedObject = result.getResolvedToken();
              if (resolvedObject == null) {
              	getResource().addError(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
              }
              String resolved = (String) resolvedObject;
              org.emftext.sdk.concretesyntax.PreDefinedToken proxy = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken();
              collectHiddenTokens(element, proxy);
              getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DEFINED_PLACEHOLDER__TOKEN), resolved, proxy);

              if (proxy != null) {
              element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DEFINED_PLACEHOLDER__TOKEN), proxy); 
              }
              collectHiddenTokens(element, proxy);
              copyLocalizationInfos((CommonToken) a2, element); 
              copyLocalizationInfos((CommonToken) a2, proxy); 

            }
            a3=(Token)match(input,31,FOLLOW_31_in_definedplaceholder957); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDefinedPlaceholder();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:640:2: (a4= cardinality )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=34 && LA15_0<=36)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:641:3: a4= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_definedplaceholder969);
                    a4=cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) {
                      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDefinedPlaceholder(); 
                      }

                      if (a4 != null) {
                      element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DEFINED_PLACEHOLDER__CARDINALITY), a4); 
                      }
                      collectHiddenTokens(element, a4);
                      copyLocalizationInfos(a4, element); 

                    }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, definedplaceholder_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "definedplaceholder"


    // $ANTLR start "derivedplaceholder"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:655:1: derivedplaceholder returns [org.emftext.sdk.concretesyntax.DerivedPlaceholder element = null] : a0= QUALIFIED_NAME a1= '[' ( (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? ) )? a5= ']' (a6= cardinality )? ;
    public final org.emftext.sdk.concretesyntax.DerivedPlaceholder derivedplaceholder() throws RecognitionException {
        org.emftext.sdk.concretesyntax.DerivedPlaceholder element =  null;
        int derivedplaceholder_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        org.emftext.sdk.concretesyntax.Cardinality a6 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:658:1: (a0= QUALIFIED_NAME a1= '[' ( (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? ) )? a5= ']' (a6= cardinality )? )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:659:2: a0= QUALIFIED_NAME a1= '[' ( (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? ) )? a5= ']' (a6= cardinality )?
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_derivedplaceholder997); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) {
              	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder(); 
              }
              org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
              tokenResolver.setOptions(getOptions());
              org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DERIVED_PLACEHOLDER__FEATURE), result);
              Object resolvedObject = result.getResolvedToken();
              if (resolvedObject == null) {
              	getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
              }
              String resolved = (String) resolvedObject;
              org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenFeature();
              collectHiddenTokens(element, proxy);
              getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DERIVED_PLACEHOLDER__FEATURE), resolved, proxy);

              if (proxy != null) {
              element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DERIVED_PLACEHOLDER__FEATURE), proxy); 
              }
              collectHiddenTokens(element, proxy);
              copyLocalizationInfos((CommonToken) a0, element); 
              copyLocalizationInfos((CommonToken) a0, proxy); 

            }
            a1=(Token)match(input,30,FOLLOW_30_in_derivedplaceholder1006); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:684:2: ( (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==QUOTED_39_39) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:685:3: (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:685:3: (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:686:4: a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )?
                    {
                    a2=(Token)match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_derivedplaceholder1023); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) {
                      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder(); 
                      }
                      org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");
                      tokenResolver.setOptions(getOptions());
                      org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
                      tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DERIVED_PLACEHOLDER__PREFIX), result);
                      Object resolvedObject = result.getResolvedToken();
                      if (resolvedObject == null) {
                      	getResource().addError(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
                      }
                      	java.lang.String resolved = (java.lang.String)resolvedObject;

                      if (resolved != null) {
                      element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DERIVED_PLACEHOLDER__PREFIX), resolved); 
                      }
                      collectHiddenTokens(element, resolved);
                      copyLocalizationInfos((CommonToken) a2, element); 

                    }
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:706:4: ( (a3= ',' a4= QUOTED_39_39 ) )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==16) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:707:5: (a3= ',' a4= QUOTED_39_39 )
                            {
                            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:707:5: (a3= ',' a4= QUOTED_39_39 )
                            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:708:6: a3= ',' a4= QUOTED_39_39
                            {
                            a3=(Token)match(input,16,FOLLOW_16_in_derivedplaceholder1047); if (state.failed) return element;
                            if ( state.backtracking==0 ) {
                               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); 
                            }
                            a4=(Token)match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_derivedplaceholder1059); if (state.failed) return element;
                            if ( state.backtracking==0 ) {
                              if (element == null) {
                              	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder(); 
                              }
                              org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");
                              tokenResolver.setOptions(getOptions());
                              org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
                              tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DERIVED_PLACEHOLDER__SUFFIX), result);
                              Object resolvedObject = result.getResolvedToken();
                              if (resolvedObject == null) {
                              	getResource().addError(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
                              }
                              	java.lang.String resolved = (java.lang.String)resolvedObject;

                              if (resolved != null) {
                              element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DERIVED_PLACEHOLDER__SUFFIX), resolved); 
                              }
                              collectHiddenTokens(element, resolved);
                              copyLocalizationInfos((CommonToken) a4, element); 

                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            a5=(Token)match(input,31,FOLLOW_31_in_derivedplaceholder1088); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder();} collectHiddenTokens(element, (CommonToken)a5);copyLocalizationInfos((CommonToken)a5, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:734:2: (a6= cardinality )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=34 && LA18_0<=36)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:735:3: a6= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_derivedplaceholder1100);
                    a6=cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) {
                      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder(); 
                      }

                      if (a6 != null) {
                      element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DERIVED_PLACEHOLDER__CARDINALITY), a6); 
                      }
                      collectHiddenTokens(element, a6);
                      copyLocalizationInfos(a6, element); 

                    }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 10, derivedplaceholder_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "derivedplaceholder"


    // $ANTLR start "containment"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:749:1: containment returns [org.emftext.sdk.concretesyntax.Containment element = null] : a0= QUALIFIED_NAME ( (a1= ':' a2= QUALIFIED_NAME ) )? (a3= cardinality )? ;
    public final org.emftext.sdk.concretesyntax.Containment containment() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Containment element =  null;
        int containment_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        org.emftext.sdk.concretesyntax.Cardinality a3 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:752:1: (a0= QUALIFIED_NAME ( (a1= ':' a2= QUALIFIED_NAME ) )? (a3= cardinality )? )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:753:2: a0= QUALIFIED_NAME ( (a1= ':' a2= QUALIFIED_NAME ) )? (a3= cardinality )?
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_containment1128); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) {
              	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createContainment(); 
              }
              org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
              tokenResolver.setOptions(getOptions());
              org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), result);
              Object resolvedObject = result.getResolvedToken();
              if (resolvedObject == null) {
              	getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
              }
              String resolved = (String) resolvedObject;
              org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenFeature();
              collectHiddenTokens(element, proxy);
              getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), resolved, proxy);

              if (proxy != null) {
              element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), proxy); 
              }
              collectHiddenTokens(element, proxy);
              copyLocalizationInfos((CommonToken) a0, element); 
              copyLocalizationInfos((CommonToken) a0, proxy); 

            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:777:2: ( (a1= ':' a2= QUALIFIED_NAME ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==24) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:778:3: (a1= ':' a2= QUALIFIED_NAME )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:778:3: (a1= ':' a2= QUALIFIED_NAME )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:779:4: a1= ':' a2= QUALIFIED_NAME
                    {
                    a1=(Token)match(input,24,FOLLOW_24_in_containment1146); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createContainment();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
                    }
                    a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_containment1156); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) {
                      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createContainment(); 
                      }
                      org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
                      tokenResolver.setOptions(getOptions());
                      org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
                      tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPE), result);
                      Object resolvedObject = result.getResolvedToken();
                      if (resolvedObject == null) {
                      	getResource().addError(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
                      }
                      String resolved = (String) resolvedObject;
                      org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();
                      collectHiddenTokens(element, proxy);
                      getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPE), resolved, proxy);

                      if (proxy != null) {
                      element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPE), proxy); 
                      }
                      collectHiddenTokens(element, proxy);
                      copyLocalizationInfos((CommonToken) a2, element); 
                      copyLocalizationInfos((CommonToken) a2, proxy); 

                    }

                    }


                    }
                    break;

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:806:2: (a3= cardinality )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=34 && LA20_0<=36)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:807:3: a3= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_containment1177);
                    a3=cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) {
                      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createContainment(); 
                      }

                      if (a3 != null) {
                      element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__CARDINALITY), a3); 
                      }
                      collectHiddenTokens(element, a3);
                      copyLocalizationInfos(a3, element); 

                    }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 11, containment_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "containment"


    // $ANTLR start "compounddefinition"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:821:1: compounddefinition returns [org.emftext.sdk.concretesyntax.CompoundDefinition element = null] : a0= '(' a1= choice a2= ')' (a3= cardinality )? ;
    public final org.emftext.sdk.concretesyntax.CompoundDefinition compounddefinition() throws RecognitionException {
        org.emftext.sdk.concretesyntax.CompoundDefinition element =  null;
        int compounddefinition_StartIndex = input.index();
        Token a0=null;
        Token a2=null;
        org.emftext.sdk.concretesyntax.Choice a1 = null;

        org.emftext.sdk.concretesyntax.Cardinality a3 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:824:1: (a0= '(' a1= choice a2= ')' (a3= cardinality )? )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:825:2: a0= '(' a1= choice a2= ')' (a3= cardinality )?
            {
            a0=(Token)match(input,32,FOLLOW_32_in_compounddefinition1205); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createCompoundDefinition();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            pushFollow(FOLLOW_choice_in_compounddefinition1213);
            a1=choice();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) {
              	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createCompoundDefinition(); 
              }

              if (a1 != null) {
              element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__DEFINITIONS), a1); 
              }
              collectHiddenTokens(element, a1);
              copyLocalizationInfos(a1, element); 

            }
            a2=(Token)match(input,33,FOLLOW_33_in_compounddefinition1222); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createCompoundDefinition();} collectHiddenTokens(element, (CommonToken)a2);copyLocalizationInfos((CommonToken)a2, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:838:2: (a3= cardinality )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=34 && LA21_0<=36)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:839:3: a3= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_compounddefinition1234);
                    a3=cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) {
                      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createCompoundDefinition(); 
                      }

                      if (a3 != null) {
                      element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CARDINALITY), a3); 
                      }
                      collectHiddenTokens(element, a3);
                      copyLocalizationInfos(a3, element); 

                    }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 12, compounddefinition_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "compounddefinition"


    // $ANTLR start "plus"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:853:1: plus returns [org.emftext.sdk.concretesyntax.PLUS element = null] : a0= '+' ;
    public final org.emftext.sdk.concretesyntax.PLUS plus() throws RecognitionException {
        org.emftext.sdk.concretesyntax.PLUS element =  null;
        int plus_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:856:1: (a0= '+' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:857:2: a0= '+'
            {
            a0=(Token)match(input,34,FOLLOW_34_in_plus1262); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPLUS();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 13, plus_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "plus"


    // $ANTLR start "star"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:860:1: star returns [org.emftext.sdk.concretesyntax.STAR element = null] : a0= '*' ;
    public final org.emftext.sdk.concretesyntax.STAR star() throws RecognitionException {
        org.emftext.sdk.concretesyntax.STAR element =  null;
        int star_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:863:1: (a0= '*' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:864:2: a0= '*'
            {
            a0=(Token)match(input,35,FOLLOW_35_in_star1285); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createSTAR();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 14, star_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "star"


    // $ANTLR start "questionmark"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:867:1: questionmark returns [org.emftext.sdk.concretesyntax.QUESTIONMARK element = null] : a0= '?' ;
    public final org.emftext.sdk.concretesyntax.QUESTIONMARK questionmark() throws RecognitionException {
        org.emftext.sdk.concretesyntax.QUESTIONMARK element =  null;
        int questionmark_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:870:1: (a0= '?' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:871:2: a0= '?'
            {
            a0=(Token)match(input,36,FOLLOW_36_in_questionmark1308); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createQUESTIONMARK();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 15, questionmark_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "questionmark"


    // $ANTLR start "whitespaces"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:874:1: whitespaces returns [org.emftext.sdk.concretesyntax.WhiteSpaces element = null] : a0= '#' a1= NUMBER ;
    public final org.emftext.sdk.concretesyntax.WhiteSpaces whitespaces() throws RecognitionException {
        org.emftext.sdk.concretesyntax.WhiteSpaces element =  null;
        int whitespaces_StartIndex = input.index();
        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:877:1: (a0= '#' a1= NUMBER )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:878:2: a0= '#' a1= NUMBER
            {
            a0=(Token)match(input,37,FOLLOW_37_in_whitespaces1331); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createWhiteSpaces();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_whitespaces1339); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) {
              	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createWhiteSpaces(); 
              }
              org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NUMBER");
              tokenResolver.setOptions(getOptions());
              org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.WHITE_SPACES__AMOUNT), result);
              Object resolvedObject = result.getResolvedToken();
              if (resolvedObject == null) {
              	getResource().addError(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
              }
              	java.lang.Integer resolved = (java.lang.Integer)resolvedObject;

              if (resolved != null) {
              element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.WHITE_SPACES__AMOUNT), resolved); 
              }
              collectHiddenTokens(element, resolved);
              copyLocalizationInfos((CommonToken) a1, element); 

            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 16, whitespaces_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "whitespaces"


    // $ANTLR start "linebreak"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:901:1: linebreak returns [org.emftext.sdk.concretesyntax.LineBreak element = null] : a0= '!' a1= NUMBER ;
    public final org.emftext.sdk.concretesyntax.LineBreak linebreak() throws RecognitionException {
        org.emftext.sdk.concretesyntax.LineBreak element =  null;
        int linebreak_StartIndex = input.index();
        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:904:1: (a0= '!' a1= NUMBER )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:905:2: a0= '!' a1= NUMBER
            {
            a0=(Token)match(input,38,FOLLOW_38_in_linebreak1363); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createLineBreak();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_linebreak1371); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) {
              	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createLineBreak(); 
              }
              org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NUMBER");
              tokenResolver.setOptions(getOptions());
              org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.LINE_BREAK__TAB), result);
              Object resolvedObject = result.getResolvedToken();
              if (resolvedObject == null) {
              	getResource().addError(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
              }
              	java.lang.Integer resolved = (java.lang.Integer)resolvedObject;

              if (resolved != null) {
              element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.LINE_BREAK__TAB), resolved); 
              }
              collectHiddenTokens(element, resolved);
              copyLocalizationInfos((CommonToken) a1, element); 

            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 17, linebreak_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "linebreak"


    // $ANTLR start "normaltoken"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:928:1: normaltoken returns [org.emftext.sdk.concretesyntax.NormalToken element = null] : a0= 'DEFINE' a1= QUALIFIED_NAME a2= QUOTED_36_36 ( (a3= 'COLLECT' a4= 'IN' a5= QUALIFIED_NAME ) )? ;
    public final org.emftext.sdk.concretesyntax.NormalToken normaltoken() throws RecognitionException {
        org.emftext.sdk.concretesyntax.NormalToken element =  null;
        int normaltoken_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:931:1: (a0= 'DEFINE' a1= QUALIFIED_NAME a2= QUOTED_36_36 ( (a3= 'COLLECT' a4= 'IN' a5= QUALIFIED_NAME ) )? )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:932:2: a0= 'DEFINE' a1= QUALIFIED_NAME a2= QUOTED_36_36 ( (a3= 'COLLECT' a4= 'IN' a5= QUALIFIED_NAME ) )?
            {
            a0=(Token)match(input,39,FOLLOW_39_in_normaltoken1395); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_normaltoken1403); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) {
              	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken(); 
              }
              org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
              tokenResolver.setOptions(getOptions());
              org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__NAME), result);
              Object resolvedObject = result.getResolvedToken();
              if (resolvedObject == null) {
              	getResource().addError(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
              }
              	java.lang.String resolved = (java.lang.String)resolvedObject;

              if (resolved != null) {
              element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__NAME), resolved); 
              }
              collectHiddenTokens(element, resolved);
              copyLocalizationInfos((CommonToken) a1, element); 

            }
            a2=(Token)match(input,QUOTED_36_36,FOLLOW_QUOTED_36_36_in_normaltoken1412); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) {
              	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken(); 
              }
              org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_36_36");
              tokenResolver.setOptions(getOptions());
              org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__REGEX), result);
              Object resolvedObject = result.getResolvedToken();
              if (resolvedObject == null) {
              	getResource().addError(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
              }
              	java.lang.String resolved = (java.lang.String)resolvedObject;

              if (resolved != null) {
              element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__REGEX), resolved); 
              }
              collectHiddenTokens(element, resolved);
              copyLocalizationInfos((CommonToken) a2, element); 

            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:973:2: ( (a3= 'COLLECT' a4= 'IN' a5= QUALIFIED_NAME ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==40) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:974:3: (a3= 'COLLECT' a4= 'IN' a5= QUALIFIED_NAME )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:974:3: (a3= 'COLLECT' a4= 'IN' a5= QUALIFIED_NAME )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:975:4: a3= 'COLLECT' a4= 'IN' a5= QUALIFIED_NAME
                    {
                    a3=(Token)match(input,40,FOLLOW_40_in_normaltoken1430); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); 
                    }
                    a4=(Token)match(input,41,FOLLOW_41_in_normaltoken1440); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken();} collectHiddenTokens(element, (CommonToken)a4);copyLocalizationInfos((CommonToken)a4, element); 
                    }
                    a5=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_normaltoken1450); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) {
                      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken(); 
                      }
                      org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
                      tokenResolver.setOptions(getOptions());
                      org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
                      tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__ATTRIBUTE_NAME), result);
                      Object resolvedObject = result.getResolvedToken();
                      if (resolvedObject == null) {
                      	getResource().addError(result.getErrorMessage(), ((CommonToken) a5).getLine(), ((CommonToken) a5).getCharPositionInLine(), ((CommonToken) a5).getStartIndex(), ((CommonToken) a5).getStopIndex());
                      }
                      	java.lang.String resolved = (java.lang.String)resolvedObject;

                      if (resolved != null) {
                      element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__ATTRIBUTE_NAME), resolved); 
                      }
                      collectHiddenTokens(element, resolved);
                      copyLocalizationInfos((CommonToken) a5, element); 

                    }

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 18, normaltoken_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "normaltoken"


    // $ANTLR start "decoratedtoken"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1001:1: decoratedtoken returns [org.emftext.sdk.concretesyntax.DecoratedToken element = null] : a0= 'DEFINE' a1= QUALIFIED_NAME (a2= '[' (a3= QUOTED_39_39 ) a4= ']' ) a5= QUOTED_36_36 (a6= '[' (a7= QUOTED_39_39 ) a8= ']' ) ( (a9= 'COLLECT' a10= 'IN' a11= QUALIFIED_NAME ) )? ;
    public final org.emftext.sdk.concretesyntax.DecoratedToken decoratedtoken() throws RecognitionException {
        org.emftext.sdk.concretesyntax.DecoratedToken element =  null;
        int decoratedtoken_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        Token a9=null;
        Token a10=null;
        Token a11=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1004:1: (a0= 'DEFINE' a1= QUALIFIED_NAME (a2= '[' (a3= QUOTED_39_39 ) a4= ']' ) a5= QUOTED_36_36 (a6= '[' (a7= QUOTED_39_39 ) a8= ']' ) ( (a9= 'COLLECT' a10= 'IN' a11= QUALIFIED_NAME ) )? )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1005:2: a0= 'DEFINE' a1= QUALIFIED_NAME (a2= '[' (a3= QUOTED_39_39 ) a4= ']' ) a5= QUOTED_36_36 (a6= '[' (a7= QUOTED_39_39 ) a8= ']' ) ( (a9= 'COLLECT' a10= 'IN' a11= QUALIFIED_NAME ) )?
            {
            a0=(Token)match(input,39,FOLLOW_39_in_decoratedtoken1482); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_decoratedtoken1490); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) {
              	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken(); 
              }
              org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
              tokenResolver.setOptions(getOptions());
              org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DECORATED_TOKEN__NAME), result);
              Object resolvedObject = result.getResolvedToken();
              if (resolvedObject == null) {
              	getResource().addError(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
              }
              	java.lang.String resolved = (java.lang.String)resolvedObject;

              if (resolved != null) {
              element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DECORATED_TOKEN__NAME), resolved); 
              }
              collectHiddenTokens(element, resolved);
              copyLocalizationInfos((CommonToken) a1, element); 

            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1026:2: (a2= '[' (a3= QUOTED_39_39 ) a4= ']' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1027:3: a2= '[' (a3= QUOTED_39_39 ) a4= ']'
            {
            a2=(Token)match(input,30,FOLLOW_30_in_decoratedtoken1503); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a2);copyLocalizationInfos((CommonToken)a2, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1028:3: (a3= QUOTED_39_39 )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1029:4: a3= QUOTED_39_39
            {
            a3=(Token)match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_decoratedtoken1517); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) {
              	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken(); 
              }
              org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");
              tokenResolver.setOptions(getOptions());
              org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DECORATED_TOKEN__PREFIX), result);
              Object resolvedObject = result.getResolvedToken();
              if (resolvedObject == null) {
              	getResource().addError(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
              }
              	java.lang.String resolved = (java.lang.String)resolvedObject;

              if (resolved != null) {
              element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DECORATED_TOKEN__PREFIX), resolved); 
              }
              collectHiddenTokens(element, resolved);
              copyLocalizationInfos((CommonToken) a3, element); 

            }

            }

            a4=(Token)match(input,31,FOLLOW_31_in_decoratedtoken1531); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a4);copyLocalizationInfos((CommonToken)a4, element); 
            }

            }

            a5=(Token)match(input,QUOTED_36_36,FOLLOW_QUOTED_36_36_in_decoratedtoken1542); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) {
              	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken(); 
              }
              org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_36_36");
              tokenResolver.setOptions(getOptions());
              org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DECORATED_TOKEN__REGEX), result);
              Object resolvedObject = result.getResolvedToken();
              if (resolvedObject == null) {
              	getResource().addError(result.getErrorMessage(), ((CommonToken) a5).getLine(), ((CommonToken) a5).getCharPositionInLine(), ((CommonToken) a5).getStartIndex(), ((CommonToken) a5).getStopIndex());
              }
              	java.lang.String resolved = (java.lang.String)resolvedObject;

              if (resolved != null) {
              element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DECORATED_TOKEN__REGEX), resolved); 
              }
              collectHiddenTokens(element, resolved);
              copyLocalizationInfos((CommonToken) a5, element); 

            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1072:2: (a6= '[' (a7= QUOTED_39_39 ) a8= ']' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1073:3: a6= '[' (a7= QUOTED_39_39 ) a8= ']'
            {
            a6=(Token)match(input,30,FOLLOW_30_in_decoratedtoken1555); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a6);copyLocalizationInfos((CommonToken)a6, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1074:3: (a7= QUOTED_39_39 )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1075:4: a7= QUOTED_39_39
            {
            a7=(Token)match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_decoratedtoken1569); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) {
              	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken(); 
              }
              org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");
              tokenResolver.setOptions(getOptions());
              org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DECORATED_TOKEN__SUFFIX), result);
              Object resolvedObject = result.getResolvedToken();
              if (resolvedObject == null) {
              	getResource().addError(result.getErrorMessage(), ((CommonToken) a7).getLine(), ((CommonToken) a7).getCharPositionInLine(), ((CommonToken) a7).getStartIndex(), ((CommonToken) a7).getStopIndex());
              }
              	java.lang.String resolved = (java.lang.String)resolvedObject;

              if (resolved != null) {
              element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DECORATED_TOKEN__SUFFIX), resolved); 
              }
              collectHiddenTokens(element, resolved);
              copyLocalizationInfos((CommonToken) a7, element); 

            }

            }

            a8=(Token)match(input,31,FOLLOW_31_in_decoratedtoken1583); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a8);copyLocalizationInfos((CommonToken)a8, element); 
            }

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1098:2: ( (a9= 'COLLECT' a10= 'IN' a11= QUALIFIED_NAME ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==40) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1099:3: (a9= 'COLLECT' a10= 'IN' a11= QUALIFIED_NAME )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1099:3: (a9= 'COLLECT' a10= 'IN' a11= QUALIFIED_NAME )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1100:4: a9= 'COLLECT' a10= 'IN' a11= QUALIFIED_NAME
                    {
                    a9=(Token)match(input,40,FOLLOW_40_in_decoratedtoken1603); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a9);copyLocalizationInfos((CommonToken)a9, element); 
                    }
                    a10=(Token)match(input,41,FOLLOW_41_in_decoratedtoken1613); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a10);copyLocalizationInfos((CommonToken)a10, element); 
                    }
                    a11=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_decoratedtoken1623); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) {
                      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken(); 
                      }
                      org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
                      tokenResolver.setOptions(getOptions());
                      org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
                      tokenResolver.resolve(a11.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DECORATED_TOKEN__ATTRIBUTE_NAME), result);
                      Object resolvedObject = result.getResolvedToken();
                      if (resolvedObject == null) {
                      	getResource().addError(result.getErrorMessage(), ((CommonToken) a11).getLine(), ((CommonToken) a11).getCharPositionInLine(), ((CommonToken) a11).getStartIndex(), ((CommonToken) a11).getStopIndex());
                      }
                      	java.lang.String resolved = (java.lang.String)resolvedObject;

                      if (resolved != null) {
                      element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DECORATED_TOKEN__ATTRIBUTE_NAME), resolved); 
                      }
                      collectHiddenTokens(element, resolved);
                      copyLocalizationInfos((CommonToken) a11, element); 

                    }

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 19, decoratedtoken_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "decoratedtoken"


    // $ANTLR start "predefinedtoken"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1126:1: predefinedtoken returns [org.emftext.sdk.concretesyntax.PreDefinedToken element = null] : a0= 'PREDEFINED' a1= QUALIFIED_NAME ( (a2= 'COLLECT' a3= 'IN' a4= QUALIFIED_NAME ) )? ;
    public final org.emftext.sdk.concretesyntax.PreDefinedToken predefinedtoken() throws RecognitionException {
        org.emftext.sdk.concretesyntax.PreDefinedToken element =  null;
        int predefinedtoken_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1129:1: (a0= 'PREDEFINED' a1= QUALIFIED_NAME ( (a2= 'COLLECT' a3= 'IN' a4= QUALIFIED_NAME ) )? )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1130:2: a0= 'PREDEFINED' a1= QUALIFIED_NAME ( (a2= 'COLLECT' a3= 'IN' a4= QUALIFIED_NAME ) )?
            {
            a0=(Token)match(input,42,FOLLOW_42_in_predefinedtoken1655); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_predefinedtoken1663); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) {
              	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken(); 
              }
              org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
              tokenResolver.setOptions(getOptions());
              org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PRE_DEFINED_TOKEN__NAME), result);
              Object resolvedObject = result.getResolvedToken();
              if (resolvedObject == null) {
              	getResource().addError(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
              }
              	java.lang.String resolved = (java.lang.String)resolvedObject;

              if (resolved != null) {
              element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PRE_DEFINED_TOKEN__NAME), resolved); 
              }
              collectHiddenTokens(element, resolved);
              copyLocalizationInfos((CommonToken) a1, element); 

            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1151:2: ( (a2= 'COLLECT' a3= 'IN' a4= QUALIFIED_NAME ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==40) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1152:3: (a2= 'COLLECT' a3= 'IN' a4= QUALIFIED_NAME )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1152:3: (a2= 'COLLECT' a3= 'IN' a4= QUALIFIED_NAME )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1153:4: a2= 'COLLECT' a3= 'IN' a4= QUALIFIED_NAME
                    {
                    a2=(Token)match(input,40,FOLLOW_40_in_predefinedtoken1681); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken();} collectHiddenTokens(element, (CommonToken)a2);copyLocalizationInfos((CommonToken)a2, element); 
                    }
                    a3=(Token)match(input,41,FOLLOW_41_in_predefinedtoken1691); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); 
                    }
                    a4=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_predefinedtoken1701); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) {
                      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken(); 
                      }
                      org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
                      tokenResolver.setOptions(getOptions());
                      org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
                      tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PRE_DEFINED_TOKEN__ATTRIBUTE_NAME), result);
                      Object resolvedObject = result.getResolvedToken();
                      if (resolvedObject == null) {
                      	getResource().addError(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
                      }
                      	java.lang.String resolved = (java.lang.String)resolvedObject;

                      if (resolved != null) {
                      element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PRE_DEFINED_TOKEN__ATTRIBUTE_NAME), resolved); 
                      }
                      collectHiddenTokens(element, resolved);
                      copyLocalizationInfos((CommonToken) a4, element); 

                    }

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 20, predefinedtoken_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "predefinedtoken"


    // $ANTLR start "tokendefinition"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1179:1: tokendefinition returns [org.emftext.sdk.concretesyntax.TokenDefinition element = null] : (c0= normaltoken | c1= decoratedtoken | c2= predefinedtoken );
    public final org.emftext.sdk.concretesyntax.TokenDefinition tokendefinition() throws RecognitionException {
        org.emftext.sdk.concretesyntax.TokenDefinition element =  null;
        int tokendefinition_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.NormalToken c0 = null;

        org.emftext.sdk.concretesyntax.DecoratedToken c1 = null;

        org.emftext.sdk.concretesyntax.PreDefinedToken c2 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1181:1: (c0= normaltoken | c1= decoratedtoken | c2= predefinedtoken )
            int alt25=3;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==39) ) {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==QUALIFIED_NAME) ) {
                    int LA25_3 = input.LA(3);

                    if ( (LA25_3==30) ) {
                        alt25=2;
                    }
                    else if ( (LA25_3==QUOTED_36_36) ) {
                        alt25=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 25, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA25_0==42) ) {
                alt25=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1182:2: c0= normaltoken
                    {
                    pushFollow(FOLLOW_normaltoken_in_tokendefinition1729);
                    c0=normaltoken();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1183:2: c1= decoratedtoken
                    {
                    pushFollow(FOLLOW_decoratedtoken_in_tokendefinition1739);
                    c1=decoratedtoken();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1184:2: c2= predefinedtoken
                    {
                    pushFollow(FOLLOW_predefinedtoken_in_tokendefinition1749);
                    c2=predefinedtoken();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 21, tokendefinition_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "tokendefinition"


    // $ANTLR start "definition"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1187:1: definition returns [org.emftext.sdk.concretesyntax.Definition element = null] : (c0= csstring | c1= definedplaceholder | c2= derivedplaceholder | c3= containment | c4= compounddefinition | c5= whitespaces | c6= linebreak );
    public final org.emftext.sdk.concretesyntax.Definition definition() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Definition element =  null;
        int definition_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.CsString c0 = null;

        org.emftext.sdk.concretesyntax.DefinedPlaceholder c1 = null;

        org.emftext.sdk.concretesyntax.DerivedPlaceholder c2 = null;

        org.emftext.sdk.concretesyntax.Containment c3 = null;

        org.emftext.sdk.concretesyntax.CompoundDefinition c4 = null;

        org.emftext.sdk.concretesyntax.WhiteSpaces c5 = null;

        org.emftext.sdk.concretesyntax.LineBreak c6 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1189:1: (c0= csstring | c1= definedplaceholder | c2= derivedplaceholder | c3= containment | c4= compounddefinition | c5= whitespaces | c6= linebreak )
            int alt26=7;
            alt26 = dfa26.predict(input);
            switch (alt26) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1190:2: c0= csstring
                    {
                    pushFollow(FOLLOW_csstring_in_definition1768);
                    c0=csstring();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1191:2: c1= definedplaceholder
                    {
                    pushFollow(FOLLOW_definedplaceholder_in_definition1778);
                    c1=definedplaceholder();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1192:2: c2= derivedplaceholder
                    {
                    pushFollow(FOLLOW_derivedplaceholder_in_definition1788);
                    c2=derivedplaceholder();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; 
                    }

                    }
                    break;
                case 4 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1193:2: c3= containment
                    {
                    pushFollow(FOLLOW_containment_in_definition1798);
                    c3=containment();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c3; 
                    }

                    }
                    break;
                case 5 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1194:2: c4= compounddefinition
                    {
                    pushFollow(FOLLOW_compounddefinition_in_definition1808);
                    c4=compounddefinition();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c4; 
                    }

                    }
                    break;
                case 6 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1195:2: c5= whitespaces
                    {
                    pushFollow(FOLLOW_whitespaces_in_definition1818);
                    c5=whitespaces();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c5; 
                    }

                    }
                    break;
                case 7 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1196:2: c6= linebreak
                    {
                    pushFollow(FOLLOW_linebreak_in_definition1828);
                    c6=linebreak();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c6; 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 22, definition_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "definition"


    // $ANTLR start "cardinality"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1199:1: cardinality returns [org.emftext.sdk.concretesyntax.Cardinality element = null] : (c0= plus | c1= star | c2= questionmark );
    public final org.emftext.sdk.concretesyntax.Cardinality cardinality() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Cardinality element =  null;
        int cardinality_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.PLUS c0 = null;

        org.emftext.sdk.concretesyntax.STAR c1 = null;

        org.emftext.sdk.concretesyntax.QUESTIONMARK c2 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1201:1: (c0= plus | c1= star | c2= questionmark )
            int alt27=3;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt27=1;
                }
                break;
            case 35:
                {
                alt27=2;
                }
                break;
            case 36:
                {
                alt27=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1202:2: c0= plus
                    {
                    pushFollow(FOLLOW_plus_in_cardinality1847);
                    c0=plus();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1203:2: c1= star
                    {
                    pushFollow(FOLLOW_star_in_cardinality1857);
                    c1=star();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1204:2: c2= questionmark
                    {
                    pushFollow(FOLLOW_questionmark_in_cardinality1867);
                    c2=questionmark();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 23, cardinality_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "cardinality"

    // Delegated rules


    protected DFA26 dfa26 = new DFA26(this);
    static final String DFA26_eotS =
        "\12\uffff";
    static final String DFA26_eofS =
        "\2\uffff\1\7\7\uffff";
    static final String DFA26_minS =
        "\1\4\1\uffff\1\4\3\uffff\1\4\3\uffff";
    static final String DFA26_maxS =
        "\1\46\1\uffff\1\46\3\uffff\1\37\3\uffff";
    static final String DFA26_acceptS =
        "\1\uffff\1\1\1\uffff\1\5\1\6\1\7\1\uffff\1\4\1\2\1\3";
    static final String DFA26_specialS =
        "\12\uffff}>";
    static final String[] DFA26_transitionS = {
            "\1\2\1\uffff\1\1\31\uffff\1\3\4\uffff\1\4\1\5",
            "",
            "\1\7\1\uffff\1\7\16\uffff\1\7\2\uffff\1\7\4\uffff\1\7\1\6"+
            "\1\uffff\7\7",
            "",
            "",
            "",
            "\1\10\2\uffff\1\11\27\uffff\1\11",
            "",
            "",
            ""
    };

    static final short[] DFA26_eot = DFA.unpackEncodedString(DFA26_eotS);
    static final short[] DFA26_eof = DFA.unpackEncodedString(DFA26_eofS);
    static final char[] DFA26_min = DFA.unpackEncodedStringToUnsignedChars(DFA26_minS);
    static final char[] DFA26_max = DFA.unpackEncodedStringToUnsignedChars(DFA26_maxS);
    static final short[] DFA26_accept = DFA.unpackEncodedString(DFA26_acceptS);
    static final short[] DFA26_special = DFA.unpackEncodedString(DFA26_specialS);
    static final short[][] DFA26_transition;

    static {
        int numStates = DFA26_transitionS.length;
        DFA26_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA26_transition[i] = DFA.unpackEncodedString(DFA26_transitionS[i]);
        }
    }

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = DFA26_eot;
            this.eof = DFA26_eof;
            this.min = DFA26_min;
            this.max = DFA26_max;
            this.accept = DFA26_accept;
            this.special = DFA26_special;
            this.transition = DFA26_transition;
        }
        public String getDescription() {
            return "1187:1: definition returns [org.emftext.sdk.concretesyntax.Definition element = null] : (c0= csstring | c1= definedplaceholder | c2= derivedplaceholder | c3= containment | c4= compounddefinition | c5= whitespaces | c6= linebreak );";
        }
    }
 

    public static final BitSet FOLLOW_concretesyntax_in_start76 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_concretesyntax106 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_concretesyntax114 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_concretesyntax123 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_concretesyntax131 = new BitSet(new long[]{0x0000000000008020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_concretesyntax149 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_concretesyntax166 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_concretesyntax178 = new BitSet(new long[]{0x0000000000D30000L});
    public static final BitSet FOLLOW_16_in_concretesyntax199 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_concretesyntax215 = new BitSet(new long[]{0x0000000000D30000L});
    public static final BitSet FOLLOW_17_in_concretesyntax246 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_concretesyntax256 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_keywordimport_in_concretesyntax279 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_19_in_concretesyntax302 = new BitSet(new long[]{0x0000000000D00000L});
    public static final BitSet FOLLOW_20_in_concretesyntax327 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_concretesyntax337 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_option_in_concretesyntax360 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_concretesyntax373 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_19_in_concretesyntax395 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_22_in_concretesyntax420 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_concretesyntax430 = new BitSet(new long[]{0x0000048000080000L});
    public static final BitSet FOLLOW_tokendefinition_in_concretesyntax453 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_concretesyntax466 = new BitSet(new long[]{0x0000048000080000L});
    public static final BitSet FOLLOW_19_in_concretesyntax488 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_concretesyntax504 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_concretesyntax512 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule_in_concretesyntax529 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_19_in_concretesyntax546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_keywordimport569 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_keywordimport578 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_keywordimport586 = new BitSet(new long[]{0x0000000002000022L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_keywordimport604 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_keywordimport630 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_keywordimport640 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_keywordimport650 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_keywordimport674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_option718 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_option727 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_option735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_rule763 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_rule775 = new BitSet(new long[]{0x0000006100000050L});
    public static final BitSet FOLLOW_choice_in_rule783 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_rule792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definition_in_sequence819 = new BitSet(new long[]{0x0000006100000052L});
    public static final BitSet FOLLOW_sequence_in_choice847 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_choice865 = new BitSet(new long[]{0x0000006100000050L});
    public static final BitSet FOLLOW_sequence_in_choice875 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_csstring907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_definedplaceholder931 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_definedplaceholder940 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_definedplaceholder948 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_definedplaceholder957 = new BitSet(new long[]{0x0000001C00000002L});
    public static final BitSet FOLLOW_cardinality_in_definedplaceholder969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_derivedplaceholder997 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_derivedplaceholder1006 = new BitSet(new long[]{0x0000000080000080L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_derivedplaceholder1023 = new BitSet(new long[]{0x0000000080010000L});
    public static final BitSet FOLLOW_16_in_derivedplaceholder1047 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_derivedplaceholder1059 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_derivedplaceholder1088 = new BitSet(new long[]{0x0000001C00000002L});
    public static final BitSet FOLLOW_cardinality_in_derivedplaceholder1100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_containment1128 = new BitSet(new long[]{0x0000001C01000002L});
    public static final BitSet FOLLOW_24_in_containment1146 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_containment1156 = new BitSet(new long[]{0x0000001C00000002L});
    public static final BitSet FOLLOW_cardinality_in_containment1177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_compounddefinition1205 = new BitSet(new long[]{0x0000006100000050L});
    public static final BitSet FOLLOW_choice_in_compounddefinition1213 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_compounddefinition1222 = new BitSet(new long[]{0x0000001C00000002L});
    public static final BitSet FOLLOW_cardinality_in_compounddefinition1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_plus1262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_star1285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_questionmark1308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_whitespaces1331 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_NUMBER_in_whitespaces1339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_linebreak1363 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_NUMBER_in_linebreak1371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_normaltoken1395 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_normaltoken1403 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTED_36_36_in_normaltoken1412 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_normaltoken1430 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_normaltoken1440 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_normaltoken1450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_decoratedtoken1482 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_decoratedtoken1490 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_decoratedtoken1503 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_decoratedtoken1517 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_decoratedtoken1531 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTED_36_36_in_decoratedtoken1542 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_decoratedtoken1555 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_decoratedtoken1569 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_decoratedtoken1583 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_decoratedtoken1603 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_decoratedtoken1613 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_decoratedtoken1623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_predefinedtoken1655 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_predefinedtoken1663 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_predefinedtoken1681 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_predefinedtoken1691 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_predefinedtoken1701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normaltoken_in_tokendefinition1729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decoratedtoken_in_tokendefinition1739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predefinedtoken_in_tokendefinition1749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_csstring_in_definition1768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definedplaceholder_in_definition1778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_derivedplaceholder_in_definition1788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_containment_in_definition1798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compounddefinition_in_definition1808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whitespaces_in_definition1818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_linebreak_in_definition1828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_plus_in_cardinality1847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_star_in_cardinality1857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_questionmark_in_cardinality1867 = new BitSet(new long[]{0x0000000000000002L});

}