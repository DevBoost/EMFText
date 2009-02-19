// $ANTLR 3.1.1 /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g 2009-02-19 09:21:18

package org.emftext.sdk.concretesyntax.resource.cs;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.common.util.URI;
import org.emftext.runtime.resource.impl.AbstractEMFTextParser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class CsParser extends AbstractEMFTextParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "QUALIFIED_NAME", "QUOTED_60_62", "QUOTED_34_34", "QUOTED_39_39", "NUMBER", "QUOTED_36_36", "COMMENTS", "WHITESPACE", "LINEBREAK", "'SYNTAXDEF'", "'FOR'", "'START'", "','", "'IMPORTS'", "'{'", "'}'", "'OPTIONS'", "';'", "'TOKENS'", "'RULES'", "':'", "'WITH'", "'SYNTAX'", "'='", "'::='", "'|'", "'['", "']'", "'('", "')'", "'+'", "'*'", "'?'", "'#'", "'!'", "'DEFINE'", "'COLLECT'", "'IN'", "'PREDEFINED'"
    };
    public static final int T__42=42;
    public static final int T__35=35;
    public static final int T__28=28;
    public static final int T__23=23;
    public static final int QUOTED_36_36=9;
    public static final int T__36=36;
    public static final int T__20=20;
    public static final int NUMBER=8;
    public static final int T__13=13;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int COMMENTS=10;
    public static final int T__33=33;
    public static final int T__14=14;
    public static final int QUOTED_60_62=5;
    public static final int T__22=22;
    public static final int WHITESPACE=11;
    public static final int T__29=29;
    public static final int T__39=39;
    public static final int T__30=30;
    public static final int T__17=17;
    public static final int T__31=31;
    public static final int T__40=40;
    public static final int EOF=-1;
    public static final int T__27=27;
    public static final int T__32=32;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__24=24;
    public static final int LINEBREAK=12;
    public static final int T__37=37;
    public static final int T__26=26;
    public static final int QUALIFIED_NAME=4;
    public static final int T__25=25;
    public static final int QUOTED_39_39=7;
    public static final int T__34=34;
    public static final int T__41=41;
    public static final int T__18=18;
    public static final int QUOTED_34_34=6;
    public static final int T__15=15;

    // delegates
    // delegators


        public CsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public CsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[59+1];
             
             
        }
        

    public String[] getTokenNames() { return CsParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g"; }


    	private org.emftext.runtime.resource.ITokenResolverFactory tokenResolverFactory = new CsTokenResolverFactory();
    	private int lastPosition;
    	private org.emftext.runtime.resource.impl.TokenResolveResult tokenResolveResult = new org.emftext.runtime.resource.impl.TokenResolveResult();

    	protected EObject doParse() throws RecognitionException {
    	lastPosition = 0;
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
    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:57:1: start returns [ EObject element = null] : (c0= concretesyntax ) EOF ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;
        int start_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.ConcreteSyntax c0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:59:1: ( (c0= concretesyntax ) EOF )
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:60:2: (c0= concretesyntax ) EOF
            {
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:60:2: (c0= concretesyntax )
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:61:1: c0= concretesyntax
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
    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:67:1: concretesyntax returns [org.emftext.sdk.concretesyntax.ConcreteSyntax element = null] : a0= 'SYNTAXDEF' a1= QUALIFIED_NAME a2= 'FOR' a3= QUOTED_60_62 ( (a4= QUOTED_60_62 ) )? ( (a5= 'START' (a6= QUALIFIED_NAME ) ( (a7= ',' (a8= QUALIFIED_NAME ) ) )* ) )? ( (a9= 'IMPORTS' a10= '{' ( (a11= keywordimport ) )* a12= '}' ) )? ( (a13= 'OPTIONS' a14= '{' ( (a15= option a16= ';' ) )* a17= '}' ) )? ( (a18= 'TOKENS' a19= '{' ( (a20= tokendefinition a21= ';' ) )* a22= '}' ) )? a23= 'RULES' a24= '{' ( (a25= rule )+ ) a26= '}' ;
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
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:70:1: (a0= 'SYNTAXDEF' a1= QUALIFIED_NAME a2= 'FOR' a3= QUOTED_60_62 ( (a4= QUOTED_60_62 ) )? ( (a5= 'START' (a6= QUALIFIED_NAME ) ( (a7= ',' (a8= QUALIFIED_NAME ) ) )* ) )? ( (a9= 'IMPORTS' a10= '{' ( (a11= keywordimport ) )* a12= '}' ) )? ( (a13= 'OPTIONS' a14= '{' ( (a15= option a16= ';' ) )* a17= '}' ) )? ( (a18= 'TOKENS' a19= '{' ( (a20= tokendefinition a21= ';' ) )* a22= '}' ) )? a23= 'RULES' a24= '{' ( (a25= rule )+ ) a26= '}' )
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:71:2: a0= 'SYNTAXDEF' a1= QUALIFIED_NAME a2= 'FOR' a3= QUOTED_60_62 ( (a4= QUOTED_60_62 ) )? ( (a5= 'START' (a6= QUALIFIED_NAME ) ( (a7= ',' (a8= QUALIFIED_NAME ) ) )* ) )? ( (a9= 'IMPORTS' a10= '{' ( (a11= keywordimport ) )* a12= '}' ) )? ( (a13= 'OPTIONS' a14= '{' ( (a15= option a16= ';' ) )* a17= '}' ) )? ( (a18= 'TOKENS' a19= '{' ( (a20= tokendefinition a21= ';' ) )* a22= '}' ) )? a23= 'RULES' a24= '{' ( (a25= rule )+ ) a26= '}'
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
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:117:2: ( (a4= QUOTED_60_62 ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==QUOTED_60_62) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:118:3: (a4= QUOTED_60_62 )
                    {
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:118:3: (a4= QUOTED_60_62 )
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:119:4: a4= QUOTED_60_62
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

            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:141:2: ( (a5= 'START' (a6= QUALIFIED_NAME ) ( (a7= ',' (a8= QUALIFIED_NAME ) ) )* ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==15) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:142:3: (a5= 'START' (a6= QUALIFIED_NAME ) ( (a7= ',' (a8= QUALIFIED_NAME ) ) )* )
                    {
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:142:3: (a5= 'START' (a6= QUALIFIED_NAME ) ( (a7= ',' (a8= QUALIFIED_NAME ) ) )* )
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:143:4: a5= 'START' (a6= QUALIFIED_NAME ) ( (a7= ',' (a8= QUALIFIED_NAME ) ) )*
                    {
                    a5=(Token)match(input,15,FOLLOW_15_in_concretesyntax175); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a5);copyLocalizationInfos((CommonToken)a5, element); 
                    }
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:144:4: (a6= QUALIFIED_NAME )
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:145:5: a6= QUALIFIED_NAME
                    {
                    a6=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_concretesyntax191); if (state.failed) return element;
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

                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:170:4: ( (a7= ',' (a8= QUALIFIED_NAME ) ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==16) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:171:5: (a7= ',' (a8= QUALIFIED_NAME ) )
                    	    {
                    	    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:171:5: (a7= ',' (a8= QUALIFIED_NAME ) )
                    	    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:172:6: a7= ',' (a8= QUALIFIED_NAME )
                    	    {
                    	    a7=(Token)match(input,16,FOLLOW_16_in_concretesyntax220); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a7);copyLocalizationInfos((CommonToken)a7, element); 
                    	    }
                    	    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:173:6: (a8= QUALIFIED_NAME )
                    	    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:174:7: a8= QUALIFIED_NAME
                    	    {
                    	    a8=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_concretesyntax240); if (state.failed) return element;
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


                    }


                    }
                    break;

            }

            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:203:2: ( (a9= 'IMPORTS' a10= '{' ( (a11= keywordimport ) )* a12= '}' ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:204:3: (a9= 'IMPORTS' a10= '{' ( (a11= keywordimport ) )* a12= '}' )
                    {
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:204:3: (a9= 'IMPORTS' a10= '{' ( (a11= keywordimport ) )* a12= '}' )
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:205:4: a9= 'IMPORTS' a10= '{' ( (a11= keywordimport ) )* a12= '}'
                    {
                    a9=(Token)match(input,17,FOLLOW_17_in_concretesyntax285); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a9);copyLocalizationInfos((CommonToken)a9, element); 
                    }
                    a10=(Token)match(input,18,FOLLOW_18_in_concretesyntax295); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a10);copyLocalizationInfos((CommonToken)a10, element); 
                    }
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:207:4: ( (a11= keywordimport ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==QUALIFIED_NAME) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:208:5: (a11= keywordimport )
                    	    {
                    	    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:208:5: (a11= keywordimport )
                    	    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:209:6: a11= keywordimport
                    	    {
                    	    pushFollow(FOLLOW_keywordimport_in_concretesyntax318);
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
                    	    break loop4;
                        }
                    } while (true);

                    a12=(Token)match(input,19,FOLLOW_19_in_concretesyntax341); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a12);copyLocalizationInfos((CommonToken)a12, element); 
                    }

                    }


                    }
                    break;

            }

            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:225:2: ( (a13= 'OPTIONS' a14= '{' ( (a15= option a16= ';' ) )* a17= '}' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==20) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:226:3: (a13= 'OPTIONS' a14= '{' ( (a15= option a16= ';' ) )* a17= '}' )
                    {
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:226:3: (a13= 'OPTIONS' a14= '{' ( (a15= option a16= ';' ) )* a17= '}' )
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:227:4: a13= 'OPTIONS' a14= '{' ( (a15= option a16= ';' ) )* a17= '}'
                    {
                    a13=(Token)match(input,20,FOLLOW_20_in_concretesyntax366); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a13);copyLocalizationInfos((CommonToken)a13, element); 
                    }
                    a14=(Token)match(input,18,FOLLOW_18_in_concretesyntax376); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a14);copyLocalizationInfos((CommonToken)a14, element); 
                    }
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:229:4: ( (a15= option a16= ';' ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==QUALIFIED_NAME) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:230:5: (a15= option a16= ';' )
                    	    {
                    	    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:230:5: (a15= option a16= ';' )
                    	    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:231:6: a15= option a16= ';'
                    	    {
                    	    pushFollow(FOLLOW_option_in_concretesyntax399);
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
                    	    a16=(Token)match(input,21,FOLLOW_21_in_concretesyntax412); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a16);copyLocalizationInfos((CommonToken)a16, element); 
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    a17=(Token)match(input,19,FOLLOW_19_in_concretesyntax434); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a17);copyLocalizationInfos((CommonToken)a17, element); 
                    }

                    }


                    }
                    break;

            }

            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:248:2: ( (a18= 'TOKENS' a19= '{' ( (a20= tokendefinition a21= ';' ) )* a22= '}' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==22) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:249:3: (a18= 'TOKENS' a19= '{' ( (a20= tokendefinition a21= ';' ) )* a22= '}' )
                    {
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:249:3: (a18= 'TOKENS' a19= '{' ( (a20= tokendefinition a21= ';' ) )* a22= '}' )
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:250:4: a18= 'TOKENS' a19= '{' ( (a20= tokendefinition a21= ';' ) )* a22= '}'
                    {
                    a18=(Token)match(input,22,FOLLOW_22_in_concretesyntax459); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a18);copyLocalizationInfos((CommonToken)a18, element); 
                    }
                    a19=(Token)match(input,18,FOLLOW_18_in_concretesyntax469); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a19);copyLocalizationInfos((CommonToken)a19, element); 
                    }
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:252:4: ( (a20= tokendefinition a21= ';' ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==39||LA8_0==42) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:253:5: (a20= tokendefinition a21= ';' )
                    	    {
                    	    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:253:5: (a20= tokendefinition a21= ';' )
                    	    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:254:6: a20= tokendefinition a21= ';'
                    	    {
                    	    pushFollow(FOLLOW_tokendefinition_in_concretesyntax492);
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
                    	    a21=(Token)match(input,21,FOLLOW_21_in_concretesyntax505); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a21);copyLocalizationInfos((CommonToken)a21, element); 
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    a22=(Token)match(input,19,FOLLOW_19_in_concretesyntax527); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a22);copyLocalizationInfos((CommonToken)a22, element); 
                    }

                    }


                    }
                    break;

            }

            a23=(Token)match(input,23,FOLLOW_23_in_concretesyntax543); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a23);copyLocalizationInfos((CommonToken)a23, element); 
            }
            a24=(Token)match(input,18,FOLLOW_18_in_concretesyntax551); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a24);copyLocalizationInfos((CommonToken)a24, element); 
            }
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:273:2: ( (a25= rule )+ )
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:274:3: (a25= rule )+
            {
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:274:3: (a25= rule )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==QUALIFIED_NAME) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:275:4: a25= rule
            	    {
            	    pushFollow(FOLLOW_rule_in_concretesyntax568);
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
            	    if ( cnt10 >= 1 ) break loop10;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            }

            a26=(Token)match(input,19,FOLLOW_19_in_concretesyntax585); if (state.failed) return element;
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
    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:291:1: keywordimport returns [org.emftext.sdk.concretesyntax.Import element = null] : a0= QUALIFIED_NAME a1= ':' a2= QUOTED_60_62 ( (a3= QUOTED_60_62 ) )? ( (a4= 'WITH' a5= 'SYNTAX' a6= QUALIFIED_NAME ( (a7= QUOTED_60_62 ) )? ) )? ;
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
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:294:1: (a0= QUALIFIED_NAME a1= ':' a2= QUOTED_60_62 ( (a3= QUOTED_60_62 ) )? ( (a4= 'WITH' a5= 'SYNTAX' a6= QUALIFIED_NAME ( (a7= QUOTED_60_62 ) )? ) )? )
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:295:2: a0= QUALIFIED_NAME a1= ':' a2= QUOTED_60_62 ( (a3= QUOTED_60_62 ) )? ( (a4= 'WITH' a5= 'SYNTAX' a6= QUALIFIED_NAME ( (a7= QUOTED_60_62 ) )? ) )?
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_keywordimport608); if (state.failed) return element;
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
            a1=(Token)match(input,24,FOLLOW_24_in_keywordimport617); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            }
            a2=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_keywordimport625); if (state.failed) return element;
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
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:340:2: ( (a3= QUOTED_60_62 ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==QUOTED_60_62) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:341:3: (a3= QUOTED_60_62 )
                    {
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:341:3: (a3= QUOTED_60_62 )
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:342:4: a3= QUOTED_60_62
                    {
                    a3=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_keywordimport643); if (state.failed) return element;
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

            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:364:2: ( (a4= 'WITH' a5= 'SYNTAX' a6= QUALIFIED_NAME ( (a7= QUOTED_60_62 ) )? ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==25) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:365:3: (a4= 'WITH' a5= 'SYNTAX' a6= QUALIFIED_NAME ( (a7= QUOTED_60_62 ) )? )
                    {
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:365:3: (a4= 'WITH' a5= 'SYNTAX' a6= QUALIFIED_NAME ( (a7= QUOTED_60_62 ) )? )
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:366:4: a4= 'WITH' a5= 'SYNTAX' a6= QUALIFIED_NAME ( (a7= QUOTED_60_62 ) )?
                    {
                    a4=(Token)match(input,25,FOLLOW_25_in_keywordimport669); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport();} collectHiddenTokens(element, (CommonToken)a4);copyLocalizationInfos((CommonToken)a4, element); 
                    }
                    a5=(Token)match(input,26,FOLLOW_26_in_keywordimport679); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport();} collectHiddenTokens(element, (CommonToken)a5);copyLocalizationInfos((CommonToken)a5, element); 
                    }
                    a6=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_keywordimport689); if (state.failed) return element;
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
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:392:4: ( (a7= QUOTED_60_62 ) )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==QUOTED_60_62) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:393:5: (a7= QUOTED_60_62 )
                            {
                            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:393:5: (a7= QUOTED_60_62 )
                            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:394:6: a7= QUOTED_60_62
                            {
                            a7=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_keywordimport713); if (state.failed) return element;
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
    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:420:1: option returns [org.emftext.sdk.concretesyntax.Option element = null] : a0= QUALIFIED_NAME a1= '=' a2= QUOTED_34_34 ;
    public final org.emftext.sdk.concretesyntax.Option option() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Option element =  null;
        int option_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:423:1: (a0= QUALIFIED_NAME a1= '=' a2= QUOTED_34_34 )
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:424:2: a0= QUALIFIED_NAME a1= '=' a2= QUOTED_34_34
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_option757); if (state.failed) return element;
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
            a1=(Token)match(input,27,FOLLOW_27_in_option766); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createOption();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            }
            a2=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_option774); if (state.failed) return element;
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
    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:467:1: rule returns [org.emftext.sdk.concretesyntax.Rule element = null] : (a0= QUALIFIED_NAME ) a1= '::=' a2= choice a3= ';' ;
    public final org.emftext.sdk.concretesyntax.Rule rule() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Rule element =  null;
        int rule_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a3=null;
        org.emftext.sdk.concretesyntax.Choice a2 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:470:1: ( (a0= QUALIFIED_NAME ) a1= '::=' a2= choice a3= ';' )
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:471:2: (a0= QUALIFIED_NAME ) a1= '::=' a2= choice a3= ';'
            {
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:471:2: (a0= QUALIFIED_NAME )
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:472:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_rule802); if (state.failed) return element;
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

            a1=(Token)match(input,28,FOLLOW_28_in_rule814); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createRule();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            }
            pushFollow(FOLLOW_choice_in_rule822);
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
            a3=(Token)match(input,21,FOLLOW_21_in_rule831); if (state.failed) return element;
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
    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:512:1: sequence returns [org.emftext.sdk.concretesyntax.Sequence element = null] : (a0= definition )+ ;
    public final org.emftext.sdk.concretesyntax.Sequence sequence() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Sequence element =  null;
        int sequence_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.Definition a0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:515:1: ( (a0= definition )+ )
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:516:2: (a0= definition )+
            {
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:516:2: (a0= definition )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==QUALIFIED_NAME||LA14_0==QUOTED_34_34||LA14_0==32||(LA14_0>=37 && LA14_0<=38)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:517:3: a0= definition
            	    {
            	    pushFollow(FOLLOW_definition_in_sequence858);
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
            	    if ( cnt14 >= 1 ) break loop14;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
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
    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:531:1: choice returns [org.emftext.sdk.concretesyntax.Choice element = null] : a0= sequence ( (a1= '|' a2= sequence ) )* ;
    public final org.emftext.sdk.concretesyntax.Choice choice() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Choice element =  null;
        int choice_StartIndex = input.index();
        Token a1=null;
        org.emftext.sdk.concretesyntax.Sequence a0 = null;

        org.emftext.sdk.concretesyntax.Sequence a2 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:534:1: (a0= sequence ( (a1= '|' a2= sequence ) )* )
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:535:2: a0= sequence ( (a1= '|' a2= sequence ) )*
            {
            pushFollow(FOLLOW_sequence_in_choice886);
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
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:546:2: ( (a1= '|' a2= sequence ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==29) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:547:3: (a1= '|' a2= sequence )
            	    {
            	    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:547:3: (a1= '|' a2= sequence )
            	    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:548:4: a1= '|' a2= sequence
            	    {
            	    a1=(Token)match(input,29,FOLLOW_29_in_choice904); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {
            	       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createChoice();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            	    }
            	    pushFollow(FOLLOW_sequence_in_choice914);
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
            	    break loop15;
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
    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:564:1: csstring returns [org.emftext.sdk.concretesyntax.CsString element = null] : a0= QUOTED_34_34 ;
    public final org.emftext.sdk.concretesyntax.CsString csstring() throws RecognitionException {
        org.emftext.sdk.concretesyntax.CsString element =  null;
        int csstring_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:567:1: (a0= QUOTED_34_34 )
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:568:2: a0= QUOTED_34_34
            {
            a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_csstring946); if (state.failed) return element;
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
    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:590:1: definedplaceholder returns [org.emftext.sdk.concretesyntax.DefinedPlaceholder element = null] : a0= QUALIFIED_NAME a1= '[' a2= QUALIFIED_NAME a3= ']' (a4= cardinality )? ;
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
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:593:1: (a0= QUALIFIED_NAME a1= '[' a2= QUALIFIED_NAME a3= ']' (a4= cardinality )? )
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:594:2: a0= QUALIFIED_NAME a1= '[' a2= QUALIFIED_NAME a3= ']' (a4= cardinality )?
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_definedplaceholder970); if (state.failed) return element;
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
            a1=(Token)match(input,30,FOLLOW_30_in_definedplaceholder979); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDefinedPlaceholder();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            }
            a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_definedplaceholder987); if (state.failed) return element;
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
            a3=(Token)match(input,31,FOLLOW_31_in_definedplaceholder996); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDefinedPlaceholder();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); 
            }
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:644:2: (a4= cardinality )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=34 && LA16_0<=36)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:645:3: a4= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_definedplaceholder1008);
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
    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:659:1: derivedplaceholder returns [org.emftext.sdk.concretesyntax.DerivedPlaceholder element = null] : a0= QUALIFIED_NAME a1= '[' ( (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? ) )? a5= ']' (a6= cardinality )? ;
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
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:662:1: (a0= QUALIFIED_NAME a1= '[' ( (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? ) )? a5= ']' (a6= cardinality )? )
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:663:2: a0= QUALIFIED_NAME a1= '[' ( (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? ) )? a5= ']' (a6= cardinality )?
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_derivedplaceholder1036); if (state.failed) return element;
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
            a1=(Token)match(input,30,FOLLOW_30_in_derivedplaceholder1045); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            }
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:688:2: ( (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==QUOTED_39_39) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:689:3: (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? )
                    {
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:689:3: (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? )
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:690:4: a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )?
                    {
                    a2=(Token)match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_derivedplaceholder1062); if (state.failed) return element;
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
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:710:4: ( (a3= ',' a4= QUOTED_39_39 ) )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==16) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:711:5: (a3= ',' a4= QUOTED_39_39 )
                            {
                            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:711:5: (a3= ',' a4= QUOTED_39_39 )
                            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:712:6: a3= ',' a4= QUOTED_39_39
                            {
                            a3=(Token)match(input,16,FOLLOW_16_in_derivedplaceholder1086); if (state.failed) return element;
                            if ( state.backtracking==0 ) {
                               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); 
                            }
                            a4=(Token)match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_derivedplaceholder1098); if (state.failed) return element;
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

            a5=(Token)match(input,31,FOLLOW_31_in_derivedplaceholder1127); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder();} collectHiddenTokens(element, (CommonToken)a5);copyLocalizationInfos((CommonToken)a5, element); 
            }
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:738:2: (a6= cardinality )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=34 && LA19_0<=36)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:739:3: a6= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_derivedplaceholder1139);
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
    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:753:1: containment returns [org.emftext.sdk.concretesyntax.Containment element = null] : a0= QUALIFIED_NAME ( (a1= ':' a2= QUALIFIED_NAME ( (a3= ',' a4= QUALIFIED_NAME ) )* ) )? (a5= cardinality )? ;
    public final org.emftext.sdk.concretesyntax.Containment containment() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Containment element =  null;
        int containment_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        org.emftext.sdk.concretesyntax.Cardinality a5 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:756:1: (a0= QUALIFIED_NAME ( (a1= ':' a2= QUALIFIED_NAME ( (a3= ',' a4= QUALIFIED_NAME ) )* ) )? (a5= cardinality )? )
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:757:2: a0= QUALIFIED_NAME ( (a1= ':' a2= QUALIFIED_NAME ( (a3= ',' a4= QUALIFIED_NAME ) )* ) )? (a5= cardinality )?
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_containment1167); if (state.failed) return element;
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
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:781:2: ( (a1= ':' a2= QUALIFIED_NAME ( (a3= ',' a4= QUALIFIED_NAME ) )* ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==24) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:782:3: (a1= ':' a2= QUALIFIED_NAME ( (a3= ',' a4= QUALIFIED_NAME ) )* )
                    {
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:782:3: (a1= ':' a2= QUALIFIED_NAME ( (a3= ',' a4= QUALIFIED_NAME ) )* )
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:783:4: a1= ':' a2= QUALIFIED_NAME ( (a3= ',' a4= QUALIFIED_NAME ) )*
                    {
                    a1=(Token)match(input,24,FOLLOW_24_in_containment1185); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createContainment();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
                    }
                    a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_containment1195); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) {
                      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createContainment(); 
                      }
                      org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
                      tokenResolver.setOptions(getOptions());
                      org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
                      tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), result);
                      Object resolvedObject = result.getResolvedToken();
                      if (resolvedObject == null) {
                      	getResource().addError(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
                      }
                      String resolved = (String) resolvedObject;
                      org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();
                      collectHiddenTokens(element, proxy);
                      getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), resolved, proxy);

                      if (proxy != null) {
                      addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES, proxy); 
                      }
                      collectHiddenTokens(element, proxy);
                      copyLocalizationInfos((CommonToken) a2, element); 
                      copyLocalizationInfos((CommonToken) a2, proxy); 

                    }
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:808:4: ( (a3= ',' a4= QUALIFIED_NAME ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==16) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:809:5: (a3= ',' a4= QUALIFIED_NAME )
                    	    {
                    	    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:809:5: (a3= ',' a4= QUALIFIED_NAME )
                    	    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:810:6: a3= ',' a4= QUALIFIED_NAME
                    	    {
                    	    a3=(Token)match(input,16,FOLLOW_16_in_containment1219); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createContainment();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); 
                    	    }
                    	    a4=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_containment1231); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	      if (element == null) {
                    	      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createContainment(); 
                    	      }
                    	      org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
                    	      tokenResolver.setOptions(getOptions());
                    	      org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
                    	      tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), result);
                    	      Object resolvedObject = result.getResolvedToken();
                    	      if (resolvedObject == null) {
                    	      	getResource().addError(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
                    	      }
                    	      String resolved = (String) resolvedObject;
                    	      org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();
                    	      collectHiddenTokens(element, proxy);
                    	      getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), resolved, proxy);

                    	      if (proxy != null) {
                    	      addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES, proxy); 
                    	      }
                    	      collectHiddenTokens(element, proxy);
                    	      copyLocalizationInfos((CommonToken) a4, element); 
                    	      copyLocalizationInfos((CommonToken) a4, proxy); 

                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:839:2: (a5= cardinality )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=34 && LA22_0<=36)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:840:3: a5= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_containment1264);
                    a5=cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) {
                      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createContainment(); 
                      }

                      if (a5 != null) {
                      element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__CARDINALITY), a5); 
                      }
                      collectHiddenTokens(element, a5);
                      copyLocalizationInfos(a5, element); 

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
    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:854:1: compounddefinition returns [org.emftext.sdk.concretesyntax.CompoundDefinition element = null] : a0= '(' a1= choice a2= ')' (a3= cardinality )? ;
    public final org.emftext.sdk.concretesyntax.CompoundDefinition compounddefinition() throws RecognitionException {
        org.emftext.sdk.concretesyntax.CompoundDefinition element =  null;
        int compounddefinition_StartIndex = input.index();
        Token a0=null;
        Token a2=null;
        org.emftext.sdk.concretesyntax.Choice a1 = null;

        org.emftext.sdk.concretesyntax.Cardinality a3 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:857:1: (a0= '(' a1= choice a2= ')' (a3= cardinality )? )
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:858:2: a0= '(' a1= choice a2= ')' (a3= cardinality )?
            {
            a0=(Token)match(input,32,FOLLOW_32_in_compounddefinition1292); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createCompoundDefinition();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            pushFollow(FOLLOW_choice_in_compounddefinition1300);
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
            a2=(Token)match(input,33,FOLLOW_33_in_compounddefinition1309); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createCompoundDefinition();} collectHiddenTokens(element, (CommonToken)a2);copyLocalizationInfos((CommonToken)a2, element); 
            }
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:871:2: (a3= cardinality )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=34 && LA23_0<=36)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:872:3: a3= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_compounddefinition1321);
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
    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:886:1: plus returns [org.emftext.sdk.concretesyntax.PLUS element = null] : a0= '+' ;
    public final org.emftext.sdk.concretesyntax.PLUS plus() throws RecognitionException {
        org.emftext.sdk.concretesyntax.PLUS element =  null;
        int plus_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:889:1: (a0= '+' )
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:890:2: a0= '+'
            {
            a0=(Token)match(input,34,FOLLOW_34_in_plus1349); if (state.failed) return element;
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
    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:893:1: star returns [org.emftext.sdk.concretesyntax.STAR element = null] : a0= '*' ;
    public final org.emftext.sdk.concretesyntax.STAR star() throws RecognitionException {
        org.emftext.sdk.concretesyntax.STAR element =  null;
        int star_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:896:1: (a0= '*' )
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:897:2: a0= '*'
            {
            a0=(Token)match(input,35,FOLLOW_35_in_star1372); if (state.failed) return element;
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
    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:900:1: questionmark returns [org.emftext.sdk.concretesyntax.QUESTIONMARK element = null] : a0= '?' ;
    public final org.emftext.sdk.concretesyntax.QUESTIONMARK questionmark() throws RecognitionException {
        org.emftext.sdk.concretesyntax.QUESTIONMARK element =  null;
        int questionmark_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:903:1: (a0= '?' )
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:904:2: a0= '?'
            {
            a0=(Token)match(input,36,FOLLOW_36_in_questionmark1395); if (state.failed) return element;
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
    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:907:1: whitespaces returns [org.emftext.sdk.concretesyntax.WhiteSpaces element = null] : a0= '#' a1= NUMBER ;
    public final org.emftext.sdk.concretesyntax.WhiteSpaces whitespaces() throws RecognitionException {
        org.emftext.sdk.concretesyntax.WhiteSpaces element =  null;
        int whitespaces_StartIndex = input.index();
        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return element; }
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:910:1: (a0= '#' a1= NUMBER )
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:911:2: a0= '#' a1= NUMBER
            {
            a0=(Token)match(input,37,FOLLOW_37_in_whitespaces1418); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createWhiteSpaces();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_whitespaces1426); if (state.failed) return element;
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
    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:934:1: linebreak returns [org.emftext.sdk.concretesyntax.LineBreak element = null] : a0= '!' a1= NUMBER ;
    public final org.emftext.sdk.concretesyntax.LineBreak linebreak() throws RecognitionException {
        org.emftext.sdk.concretesyntax.LineBreak element =  null;
        int linebreak_StartIndex = input.index();
        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return element; }
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:937:1: (a0= '!' a1= NUMBER )
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:938:2: a0= '!' a1= NUMBER
            {
            a0=(Token)match(input,38,FOLLOW_38_in_linebreak1450); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createLineBreak();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_linebreak1458); if (state.failed) return element;
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
    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:961:1: normaltoken returns [org.emftext.sdk.concretesyntax.NormalToken element = null] : a0= 'DEFINE' a1= QUALIFIED_NAME a2= QUOTED_36_36 ( (a3= 'COLLECT' a4= 'IN' a5= QUALIFIED_NAME ) )? ;
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
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:964:1: (a0= 'DEFINE' a1= QUALIFIED_NAME a2= QUOTED_36_36 ( (a3= 'COLLECT' a4= 'IN' a5= QUALIFIED_NAME ) )? )
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:965:2: a0= 'DEFINE' a1= QUALIFIED_NAME a2= QUOTED_36_36 ( (a3= 'COLLECT' a4= 'IN' a5= QUALIFIED_NAME ) )?
            {
            a0=(Token)match(input,39,FOLLOW_39_in_normaltoken1482); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_normaltoken1490); if (state.failed) return element;
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
            a2=(Token)match(input,QUOTED_36_36,FOLLOW_QUOTED_36_36_in_normaltoken1499); if (state.failed) return element;
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
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1006:2: ( (a3= 'COLLECT' a4= 'IN' a5= QUALIFIED_NAME ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==40) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1007:3: (a3= 'COLLECT' a4= 'IN' a5= QUALIFIED_NAME )
                    {
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1007:3: (a3= 'COLLECT' a4= 'IN' a5= QUALIFIED_NAME )
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1008:4: a3= 'COLLECT' a4= 'IN' a5= QUALIFIED_NAME
                    {
                    a3=(Token)match(input,40,FOLLOW_40_in_normaltoken1517); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); 
                    }
                    a4=(Token)match(input,41,FOLLOW_41_in_normaltoken1527); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken();} collectHiddenTokens(element, (CommonToken)a4);copyLocalizationInfos((CommonToken)a4, element); 
                    }
                    a5=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_normaltoken1537); if (state.failed) return element;
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
    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1034:1: decoratedtoken returns [org.emftext.sdk.concretesyntax.DecoratedToken element = null] : a0= 'DEFINE' a1= QUALIFIED_NAME (a2= '[' (a3= QUOTED_39_39 ) a4= ']' ) a5= QUOTED_36_36 (a6= '[' (a7= QUOTED_39_39 ) a8= ']' ) ( (a9= 'COLLECT' a10= 'IN' a11= QUALIFIED_NAME ) )? ;
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
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1037:1: (a0= 'DEFINE' a1= QUALIFIED_NAME (a2= '[' (a3= QUOTED_39_39 ) a4= ']' ) a5= QUOTED_36_36 (a6= '[' (a7= QUOTED_39_39 ) a8= ']' ) ( (a9= 'COLLECT' a10= 'IN' a11= QUALIFIED_NAME ) )? )
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1038:2: a0= 'DEFINE' a1= QUALIFIED_NAME (a2= '[' (a3= QUOTED_39_39 ) a4= ']' ) a5= QUOTED_36_36 (a6= '[' (a7= QUOTED_39_39 ) a8= ']' ) ( (a9= 'COLLECT' a10= 'IN' a11= QUALIFIED_NAME ) )?
            {
            a0=(Token)match(input,39,FOLLOW_39_in_decoratedtoken1569); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_decoratedtoken1577); if (state.failed) return element;
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
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1059:2: (a2= '[' (a3= QUOTED_39_39 ) a4= ']' )
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1060:3: a2= '[' (a3= QUOTED_39_39 ) a4= ']'
            {
            a2=(Token)match(input,30,FOLLOW_30_in_decoratedtoken1590); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a2);copyLocalizationInfos((CommonToken)a2, element); 
            }
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1061:3: (a3= QUOTED_39_39 )
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1062:4: a3= QUOTED_39_39
            {
            a3=(Token)match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_decoratedtoken1604); if (state.failed) return element;
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

            a4=(Token)match(input,31,FOLLOW_31_in_decoratedtoken1618); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a4);copyLocalizationInfos((CommonToken)a4, element); 
            }

            }

            a5=(Token)match(input,QUOTED_36_36,FOLLOW_QUOTED_36_36_in_decoratedtoken1629); if (state.failed) return element;
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
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1105:2: (a6= '[' (a7= QUOTED_39_39 ) a8= ']' )
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1106:3: a6= '[' (a7= QUOTED_39_39 ) a8= ']'
            {
            a6=(Token)match(input,30,FOLLOW_30_in_decoratedtoken1642); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a6);copyLocalizationInfos((CommonToken)a6, element); 
            }
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1107:3: (a7= QUOTED_39_39 )
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1108:4: a7= QUOTED_39_39
            {
            a7=(Token)match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_decoratedtoken1656); if (state.failed) return element;
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

            a8=(Token)match(input,31,FOLLOW_31_in_decoratedtoken1670); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a8);copyLocalizationInfos((CommonToken)a8, element); 
            }

            }

            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1131:2: ( (a9= 'COLLECT' a10= 'IN' a11= QUALIFIED_NAME ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==40) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1132:3: (a9= 'COLLECT' a10= 'IN' a11= QUALIFIED_NAME )
                    {
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1132:3: (a9= 'COLLECT' a10= 'IN' a11= QUALIFIED_NAME )
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1133:4: a9= 'COLLECT' a10= 'IN' a11= QUALIFIED_NAME
                    {
                    a9=(Token)match(input,40,FOLLOW_40_in_decoratedtoken1690); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a9);copyLocalizationInfos((CommonToken)a9, element); 
                    }
                    a10=(Token)match(input,41,FOLLOW_41_in_decoratedtoken1700); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a10);copyLocalizationInfos((CommonToken)a10, element); 
                    }
                    a11=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_decoratedtoken1710); if (state.failed) return element;
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
    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1159:1: predefinedtoken returns [org.emftext.sdk.concretesyntax.PreDefinedToken element = null] : a0= 'PREDEFINED' a1= QUALIFIED_NAME ( (a2= 'COLLECT' a3= 'IN' a4= QUALIFIED_NAME ) )? ;
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
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1162:1: (a0= 'PREDEFINED' a1= QUALIFIED_NAME ( (a2= 'COLLECT' a3= 'IN' a4= QUALIFIED_NAME ) )? )
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1163:2: a0= 'PREDEFINED' a1= QUALIFIED_NAME ( (a2= 'COLLECT' a3= 'IN' a4= QUALIFIED_NAME ) )?
            {
            a0=(Token)match(input,42,FOLLOW_42_in_predefinedtoken1742); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_predefinedtoken1750); if (state.failed) return element;
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
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1184:2: ( (a2= 'COLLECT' a3= 'IN' a4= QUALIFIED_NAME ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==40) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1185:3: (a2= 'COLLECT' a3= 'IN' a4= QUALIFIED_NAME )
                    {
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1185:3: (a2= 'COLLECT' a3= 'IN' a4= QUALIFIED_NAME )
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1186:4: a2= 'COLLECT' a3= 'IN' a4= QUALIFIED_NAME
                    {
                    a2=(Token)match(input,40,FOLLOW_40_in_predefinedtoken1768); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken();} collectHiddenTokens(element, (CommonToken)a2);copyLocalizationInfos((CommonToken)a2, element); 
                    }
                    a3=(Token)match(input,41,FOLLOW_41_in_predefinedtoken1778); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); 
                    }
                    a4=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_predefinedtoken1788); if (state.failed) return element;
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
    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1212:1: tokendefinition returns [org.emftext.sdk.concretesyntax.TokenDefinition element = null] : (c0= normaltoken | c1= decoratedtoken | c2= predefinedtoken );
    public final org.emftext.sdk.concretesyntax.TokenDefinition tokendefinition() throws RecognitionException {
        org.emftext.sdk.concretesyntax.TokenDefinition element =  null;
        int tokendefinition_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.NormalToken c0 = null;

        org.emftext.sdk.concretesyntax.DecoratedToken c1 = null;

        org.emftext.sdk.concretesyntax.PreDefinedToken c2 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return element; }
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1214:1: (c0= normaltoken | c1= decoratedtoken | c2= predefinedtoken )
            int alt27=3;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==39) ) {
                int LA27_1 = input.LA(2);

                if ( (LA27_1==QUALIFIED_NAME) ) {
                    int LA27_3 = input.LA(3);

                    if ( (LA27_3==30) ) {
                        alt27=2;
                    }
                    else if ( (LA27_3==QUOTED_36_36) ) {
                        alt27=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 27, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 27, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA27_0==42) ) {
                alt27=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1215:2: c0= normaltoken
                    {
                    pushFollow(FOLLOW_normaltoken_in_tokendefinition1816);
                    c0=normaltoken();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1216:2: c1= decoratedtoken
                    {
                    pushFollow(FOLLOW_decoratedtoken_in_tokendefinition1826);
                    c1=decoratedtoken();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1217:2: c2= predefinedtoken
                    {
                    pushFollow(FOLLOW_predefinedtoken_in_tokendefinition1836);
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
    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1220:1: definition returns [org.emftext.sdk.concretesyntax.Definition element = null] : (c0= csstring | c1= definedplaceholder | c2= derivedplaceholder | c3= containment | c4= compounddefinition | c5= whitespaces | c6= linebreak );
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
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1222:1: (c0= csstring | c1= definedplaceholder | c2= derivedplaceholder | c3= containment | c4= compounddefinition | c5= whitespaces | c6= linebreak )
            int alt28=7;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1223:2: c0= csstring
                    {
                    pushFollow(FOLLOW_csstring_in_definition1855);
                    c0=csstring();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1224:2: c1= definedplaceholder
                    {
                    pushFollow(FOLLOW_definedplaceholder_in_definition1865);
                    c1=definedplaceholder();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1225:2: c2= derivedplaceholder
                    {
                    pushFollow(FOLLOW_derivedplaceholder_in_definition1875);
                    c2=derivedplaceholder();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; 
                    }

                    }
                    break;
                case 4 :
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1226:2: c3= containment
                    {
                    pushFollow(FOLLOW_containment_in_definition1885);
                    c3=containment();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c3; 
                    }

                    }
                    break;
                case 5 :
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1227:2: c4= compounddefinition
                    {
                    pushFollow(FOLLOW_compounddefinition_in_definition1895);
                    c4=compounddefinition();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c4; 
                    }

                    }
                    break;
                case 6 :
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1228:2: c5= whitespaces
                    {
                    pushFollow(FOLLOW_whitespaces_in_definition1905);
                    c5=whitespaces();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c5; 
                    }

                    }
                    break;
                case 7 :
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1229:2: c6= linebreak
                    {
                    pushFollow(FOLLOW_linebreak_in_definition1915);
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
    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1232:1: cardinality returns [org.emftext.sdk.concretesyntax.Cardinality element = null] : (c0= plus | c1= star | c2= questionmark );
    public final org.emftext.sdk.concretesyntax.Cardinality cardinality() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Cardinality element =  null;
        int cardinality_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.PLUS c0 = null;

        org.emftext.sdk.concretesyntax.STAR c1 = null;

        org.emftext.sdk.concretesyntax.QUESTIONMARK c2 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return element; }
            // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1234:1: (c0= plus | c1= star | c2= questionmark )
            int alt29=3;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt29=1;
                }
                break;
            case 35:
                {
                alt29=2;
                }
                break;
            case 36:
                {
                alt29=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1235:2: c0= plus
                    {
                    pushFollow(FOLLOW_plus_in_cardinality1934);
                    c0=plus();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1236:2: c1= star
                    {
                    pushFollow(FOLLOW_star_in_cardinality1944);
                    c1=star();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // /Users/jj2/workspaces/Reuseware09/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:1237:2: c2= questionmark
                    {
                    pushFollow(FOLLOW_questionmark_in_cardinality1954);
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


    protected DFA28 dfa28 = new DFA28(this);
    static final String DFA28_eotS =
        "\12\uffff";
    static final String DFA28_eofS =
        "\2\uffff\1\6\7\uffff";
    static final String DFA28_minS =
        "\1\4\1\uffff\1\4\4\uffff\1\4\2\uffff";
    static final String DFA28_maxS =
        "\1\46\1\uffff\1\46\4\uffff\1\37\2\uffff";
    static final String DFA28_acceptS =
        "\1\uffff\1\1\1\uffff\1\5\1\6\1\7\1\4\1\uffff\1\2\1\3";
    static final String DFA28_specialS =
        "\12\uffff}>";
    static final String[] DFA28_transitionS = {
            "\1\2\1\uffff\1\1\31\uffff\1\3\4\uffff\1\4\1\5",
            "",
            "\1\6\1\uffff\1\6\16\uffff\1\6\2\uffff\1\6\4\uffff\1\6\1\7\1"+
            "\uffff\7\6",
            "",
            "",
            "",
            "",
            "\1\10\2\uffff\1\11\27\uffff\1\11",
            "",
            ""
    };

    static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
    static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
    static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
    static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
    static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
    static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
    static final short[][] DFA28_transition;

    static {
        int numStates = DFA28_transitionS.length;
        DFA28_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = DFA28_eot;
            this.eof = DFA28_eof;
            this.min = DFA28_min;
            this.max = DFA28_max;
            this.accept = DFA28_accept;
            this.special = DFA28_special;
            this.transition = DFA28_transition;
        }
        public String getDescription() {
            return "1220:1: definition returns [org.emftext.sdk.concretesyntax.Definition element = null] : (c0= csstring | c1= definedplaceholder | c2= derivedplaceholder | c3= containment | c4= compounddefinition | c5= whitespaces | c6= linebreak );";
        }
    }
 

    public static final BitSet FOLLOW_concretesyntax_in_start76 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_concretesyntax106 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_concretesyntax114 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_concretesyntax123 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_concretesyntax131 = new BitSet(new long[]{0x0000000000D28020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_concretesyntax149 = new BitSet(new long[]{0x0000000000D28000L});
    public static final BitSet FOLLOW_15_in_concretesyntax175 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_concretesyntax191 = new BitSet(new long[]{0x0000000000D30000L});
    public static final BitSet FOLLOW_16_in_concretesyntax220 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_concretesyntax240 = new BitSet(new long[]{0x0000000000D30000L});
    public static final BitSet FOLLOW_17_in_concretesyntax285 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_concretesyntax295 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_keywordimport_in_concretesyntax318 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_19_in_concretesyntax341 = new BitSet(new long[]{0x0000000000D00000L});
    public static final BitSet FOLLOW_20_in_concretesyntax366 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_concretesyntax376 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_option_in_concretesyntax399 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_concretesyntax412 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_19_in_concretesyntax434 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_22_in_concretesyntax459 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_concretesyntax469 = new BitSet(new long[]{0x0000048000080000L});
    public static final BitSet FOLLOW_tokendefinition_in_concretesyntax492 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_concretesyntax505 = new BitSet(new long[]{0x0000048000080000L});
    public static final BitSet FOLLOW_19_in_concretesyntax527 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_concretesyntax543 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_concretesyntax551 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule_in_concretesyntax568 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_19_in_concretesyntax585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_keywordimport608 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_keywordimport617 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_keywordimport625 = new BitSet(new long[]{0x0000000002000022L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_keywordimport643 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_keywordimport669 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_keywordimport679 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_keywordimport689 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_keywordimport713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_option757 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_option766 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_option774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_rule802 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_rule814 = new BitSet(new long[]{0x0000006100000050L});
    public static final BitSet FOLLOW_choice_in_rule822 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_rule831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definition_in_sequence858 = new BitSet(new long[]{0x0000006100000052L});
    public static final BitSet FOLLOW_sequence_in_choice886 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_choice904 = new BitSet(new long[]{0x0000006100000050L});
    public static final BitSet FOLLOW_sequence_in_choice914 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_csstring946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_definedplaceholder970 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_definedplaceholder979 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_definedplaceholder987 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_definedplaceholder996 = new BitSet(new long[]{0x0000001C00000002L});
    public static final BitSet FOLLOW_cardinality_in_definedplaceholder1008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_derivedplaceholder1036 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_derivedplaceholder1045 = new BitSet(new long[]{0x0000000080000080L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_derivedplaceholder1062 = new BitSet(new long[]{0x0000000080010000L});
    public static final BitSet FOLLOW_16_in_derivedplaceholder1086 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_derivedplaceholder1098 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_derivedplaceholder1127 = new BitSet(new long[]{0x0000001C00000002L});
    public static final BitSet FOLLOW_cardinality_in_derivedplaceholder1139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_containment1167 = new BitSet(new long[]{0x0000001C01000002L});
    public static final BitSet FOLLOW_24_in_containment1185 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_containment1195 = new BitSet(new long[]{0x0000001C00010002L});
    public static final BitSet FOLLOW_16_in_containment1219 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_containment1231 = new BitSet(new long[]{0x0000001C00010002L});
    public static final BitSet FOLLOW_cardinality_in_containment1264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_compounddefinition1292 = new BitSet(new long[]{0x0000006100000050L});
    public static final BitSet FOLLOW_choice_in_compounddefinition1300 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_compounddefinition1309 = new BitSet(new long[]{0x0000001C00000002L});
    public static final BitSet FOLLOW_cardinality_in_compounddefinition1321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_plus1349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_star1372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_questionmark1395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_whitespaces1418 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_NUMBER_in_whitespaces1426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_linebreak1450 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_NUMBER_in_linebreak1458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_normaltoken1482 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_normaltoken1490 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTED_36_36_in_normaltoken1499 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_normaltoken1517 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_normaltoken1527 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_normaltoken1537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_decoratedtoken1569 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_decoratedtoken1577 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_decoratedtoken1590 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_decoratedtoken1604 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_decoratedtoken1618 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTED_36_36_in_decoratedtoken1629 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_decoratedtoken1642 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_decoratedtoken1656 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_decoratedtoken1670 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_decoratedtoken1690 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_decoratedtoken1700 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_decoratedtoken1710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_predefinedtoken1742 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_predefinedtoken1750 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_predefinedtoken1768 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_predefinedtoken1778 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_predefinedtoken1788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normaltoken_in_tokendefinition1816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decoratedtoken_in_tokendefinition1826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predefinedtoken_in_tokendefinition1836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_csstring_in_definition1855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definedplaceholder_in_definition1865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_derivedplaceholder_in_definition1875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_containment_in_definition1885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compounddefinition_in_definition1895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whitespaces_in_definition1905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_linebreak_in_definition1915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_plus_in_cardinality1934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_star_in_cardinality1944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_questionmark_in_cardinality1954 = new BitSet(new long[]{0x0000000000000002L});

}