// $ANTLR 3.1.1 D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g 2009-02-19 13:23:43

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "QUALIFIED_NAME", "QUOTED_60_62", "QUOTED_34_34", "QUOTED_39_39", "NUMBER", "QUOTED_36_36", "COMMENTS", "WHITESPACE", "LINEBREAK", "'SYNTAXDEF'", "'FOR'", "'START'", "','", "'IMPORTS'", "'{'", "'}'", "'OPTIONS'", "';'", "'TOKENS'", "'RULES'", "':'", "'WITH'", "'SYNTAX'", "'='", "'::='", "'|'", "'['", "']'", "'('", "')'", "'+'", "'*'", "'?'", "'#'", "'!'", "'DEFINE'", "'COLLECT'", "'IN'", "'PREDEFINED'", "'ABSTRACT'"
    };
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int QUOTED_39_39=7;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int COMMENTS=10;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int QUOTED_36_36=9;
    public static final int LINEBREAK=12;
    public static final int QUALIFIED_NAME=4;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int NUMBER=8;
    public static final int WHITESPACE=11;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int QUOTED_60_62=5;
    public static final int QUOTED_34_34=6;

    // delegates
    // delegators


        public CsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public CsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[61+1];
             
             
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
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:67:1: concretesyntax returns [org.emftext.sdk.concretesyntax.ConcreteSyntax element = null] : ( (a0_0= keywordabstract ) )? a1= 'SYNTAXDEF' (a2= QUALIFIED_NAME ) a3= 'FOR' (a4= QUOTED_60_62 ) ( ( (a5= QUOTED_60_62 ) ) )? ( (a6= 'START' ( (a7= QUALIFIED_NAME ) ) ( (a8= ',' ( (a9= QUALIFIED_NAME ) ) ) )* ) )? ( (a10= 'IMPORTS' a11= '{' ( ( (a12_0= keywordimport ) ) )* a13= '}' ) )? ( (a14= 'OPTIONS' a15= '{' ( ( (a16_0= option ) a17= ';' ) )* a18= '}' ) )? ( (a19= 'TOKENS' a20= '{' ( ( (a21_0= tokendefinition ) a22= ';' ) )* a23= '}' ) )? a24= 'RULES' a25= '{' ( ( (a26_0= rule ) )+ ) a27= '}' ;
    public final org.emftext.sdk.concretesyntax.ConcreteSyntax concretesyntax() throws RecognitionException {
        org.emftext.sdk.concretesyntax.ConcreteSyntax element =  null;
        int concretesyntax_StartIndex = input.index();
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
        Token a13=null;
        Token a14=null;
        Token a15=null;
        Token a17=null;
        Token a18=null;
        Token a19=null;
        Token a20=null;
        Token a22=null;
        Token a23=null;
        Token a24=null;
        Token a25=null;
        Token a27=null;
        org.emftext.sdk.concretesyntax.Abstract a0_0 = null;

        org.emftext.sdk.concretesyntax.Import a12_0 = null;

        org.emftext.sdk.concretesyntax.Option a16_0 = null;

        org.emftext.sdk.concretesyntax.TokenDefinition a21_0 = null;

        org.emftext.sdk.concretesyntax.Rule a26_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:70:1: ( ( (a0_0= keywordabstract ) )? a1= 'SYNTAXDEF' (a2= QUALIFIED_NAME ) a3= 'FOR' (a4= QUOTED_60_62 ) ( ( (a5= QUOTED_60_62 ) ) )? ( (a6= 'START' ( (a7= QUALIFIED_NAME ) ) ( (a8= ',' ( (a9= QUALIFIED_NAME ) ) ) )* ) )? ( (a10= 'IMPORTS' a11= '{' ( ( (a12_0= keywordimport ) ) )* a13= '}' ) )? ( (a14= 'OPTIONS' a15= '{' ( ( (a16_0= option ) a17= ';' ) )* a18= '}' ) )? ( (a19= 'TOKENS' a20= '{' ( ( (a21_0= tokendefinition ) a22= ';' ) )* a23= '}' ) )? a24= 'RULES' a25= '{' ( ( (a26_0= rule ) )+ ) a27= '}' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:71:2: ( (a0_0= keywordabstract ) )? a1= 'SYNTAXDEF' (a2= QUALIFIED_NAME ) a3= 'FOR' (a4= QUOTED_60_62 ) ( ( (a5= QUOTED_60_62 ) ) )? ( (a6= 'START' ( (a7= QUALIFIED_NAME ) ) ( (a8= ',' ( (a9= QUALIFIED_NAME ) ) ) )* ) )? ( (a10= 'IMPORTS' a11= '{' ( ( (a12_0= keywordimport ) ) )* a13= '}' ) )? ( (a14= 'OPTIONS' a15= '{' ( ( (a16_0= option ) a17= ';' ) )* a18= '}' ) )? ( (a19= 'TOKENS' a20= '{' ( ( (a21_0= tokendefinition ) a22= ';' ) )* a23= '}' ) )? a24= 'RULES' a25= '{' ( ( (a26_0= rule ) )+ ) a27= '}'
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:71:2: ( (a0_0= keywordabstract ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==43) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:72:3: (a0_0= keywordabstract )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:72:3: (a0_0= keywordabstract )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:72:4: a0_0= keywordabstract
                    {
                    pushFollow(FOLLOW_keywordabstract_in_concretesyntax111);
                    a0_0=keywordabstract();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) {
                      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); 
                      }

                      if (a0_0 != null) {
                      element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__MODIFIER), a0_0); 
                      }
                      collectHiddenTokens(element, a0_0);
                      copyLocalizationInfos(a0_0, element); 

                    }

                    }


                    }
                    break;

            }

            a1=(Token)match(input,13,FOLLOW_13_in_concretesyntax125); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:85:2: (a2= QUALIFIED_NAME )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:85:3: a2= QUALIFIED_NAME
            {
            a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_concretesyntax134); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) {
              	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); 
              }
              org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
              tokenResolver.setOptions(getOptions());
              org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME), result);
              Object resolvedObject = result.getResolvedToken();
              if (resolvedObject == null) {
              	getResource().addError(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
              }
              	java.lang.String resolved = (java.lang.String)resolvedObject;

              if (resolved != null) {
              element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME), resolved); 
              }
              collectHiddenTokens(element, resolved);
              copyLocalizationInfos((CommonToken) a2, element); 

            }

            }

            a3=(Token)match(input,14,FOLLOW_14_in_concretesyntax144); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:106:2: (a4= QUOTED_60_62 )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:106:3: a4= QUOTED_60_62
            {
            a4=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_concretesyntax153); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) {
              	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); 
              }
              org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
              tokenResolver.setOptions(getOptions());
              org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
              tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), result);
              Object resolvedObject = result.getResolvedToken();
              if (resolvedObject == null) {
              	getResource().addError(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
              }
              String resolved = (String) resolvedObject;
              org.eclipse.emf.codegen.ecore.genmodel.GenPackage proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenPackage();
              collectHiddenTokens(element, proxy);
              getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), resolved, proxy);

              if (proxy != null) {
              element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), proxy); 
              }
              collectHiddenTokens(element, proxy);
              copyLocalizationInfos((CommonToken) a4, element); 
              copyLocalizationInfos((CommonToken) a4, proxy); 

            }

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:130:2: ( ( (a5= QUOTED_60_62 ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==QUOTED_60_62) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:131:3: ( (a5= QUOTED_60_62 ) )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:131:3: ( (a5= QUOTED_60_62 ) )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:132:4: (a5= QUOTED_60_62 )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:132:4: (a5= QUOTED_60_62 )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:132:5: a5= QUOTED_60_62
                    {
                    a5=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_concretesyntax173); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) {
                      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); 
                      }
                      org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
                      tokenResolver.setOptions(getOptions());
                      org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
                      tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE_LOCATION_HINT), result);
                      Object resolvedObject = result.getResolvedToken();
                      if (resolvedObject == null) {
                      	getResource().addError(result.getErrorMessage(), ((CommonToken) a5).getLine(), ((CommonToken) a5).getCharPositionInLine(), ((CommonToken) a5).getStartIndex(), ((CommonToken) a5).getStopIndex());
                      }
                      	java.lang.String resolved = (java.lang.String)resolvedObject;

                      if (resolved != null) {
                      element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE_LOCATION_HINT), resolved); 
                      }
                      collectHiddenTokens(element, resolved);
                      copyLocalizationInfos((CommonToken) a5, element); 

                    }

                    }


                    }


                    }
                    break;

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:154:2: ( (a6= 'START' ( (a7= QUALIFIED_NAME ) ) ( (a8= ',' ( (a9= QUALIFIED_NAME ) ) ) )* ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:155:3: (a6= 'START' ( (a7= QUALIFIED_NAME ) ) ( (a8= ',' ( (a9= QUALIFIED_NAME ) ) ) )* )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:155:3: (a6= 'START' ( (a7= QUALIFIED_NAME ) ) ( (a8= ',' ( (a9= QUALIFIED_NAME ) ) ) )* )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:156:4: a6= 'START' ( (a7= QUALIFIED_NAME ) ) ( (a8= ',' ( (a9= QUALIFIED_NAME ) ) ) )*
                    {
                    a6=(Token)match(input,15,FOLLOW_15_in_concretesyntax200); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a6);copyLocalizationInfos((CommonToken)a6, element); 
                    }
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:157:4: ( (a7= QUALIFIED_NAME ) )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:158:5: (a7= QUALIFIED_NAME )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:158:5: (a7= QUALIFIED_NAME )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:158:6: a7= QUALIFIED_NAME
                    {
                    a7=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_concretesyntax217); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) {
                      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); 
                      }
                      org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
                      tokenResolver.setOptions(getOptions());
                      org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
                      tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), result);
                      Object resolvedObject = result.getResolvedToken();
                      if (resolvedObject == null) {
                      	getResource().addError(result.getErrorMessage(), ((CommonToken) a7).getLine(), ((CommonToken) a7).getCharPositionInLine(), ((CommonToken) a7).getStartIndex(), ((CommonToken) a7).getStopIndex());
                      }
                      String resolved = (String) resolvedObject;
                      org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();
                      collectHiddenTokens(element, proxy);
                      getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), resolved, proxy);

                      if (proxy != null) {
                      addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS, proxy); 
                      }
                      collectHiddenTokens(element, proxy);
                      copyLocalizationInfos((CommonToken) a7, element); 
                      copyLocalizationInfos((CommonToken) a7, proxy); 

                    }

                    }


                    }

                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:183:4: ( (a8= ',' ( (a9= QUALIFIED_NAME ) ) ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==16) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:184:5: (a8= ',' ( (a9= QUALIFIED_NAME ) ) )
                    	    {
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:184:5: (a8= ',' ( (a9= QUALIFIED_NAME ) ) )
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:185:6: a8= ',' ( (a9= QUALIFIED_NAME ) )
                    	    {
                    	    a8=(Token)match(input,16,FOLLOW_16_in_concretesyntax247); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a8);copyLocalizationInfos((CommonToken)a8, element); 
                    	    }
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:186:6: ( (a9= QUALIFIED_NAME ) )
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:187:7: (a9= QUALIFIED_NAME )
                    	    {
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:187:7: (a9= QUALIFIED_NAME )
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:187:8: a9= QUALIFIED_NAME
                    	    {
                    	    a9=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_concretesyntax268); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	      if (element == null) {
                    	      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); 
                    	      }
                    	      org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
                    	      tokenResolver.setOptions(getOptions());
                    	      org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
                    	      tokenResolver.resolve(a9.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), result);
                    	      Object resolvedObject = result.getResolvedToken();
                    	      if (resolvedObject == null) {
                    	      	getResource().addError(result.getErrorMessage(), ((CommonToken) a9).getLine(), ((CommonToken) a9).getCharPositionInLine(), ((CommonToken) a9).getStartIndex(), ((CommonToken) a9).getStopIndex());
                    	      }
                    	      String resolved = (String) resolvedObject;
                    	      org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();
                    	      collectHiddenTokens(element, proxy);
                    	      getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), resolved, proxy);

                    	      if (proxy != null) {
                    	      addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS, proxy); 
                    	      }
                    	      collectHiddenTokens(element, proxy);
                    	      copyLocalizationInfos((CommonToken) a9, element); 
                    	      copyLocalizationInfos((CommonToken) a9, proxy); 

                    	    }

                    	    }


                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:216:2: ( (a10= 'IMPORTS' a11= '{' ( ( (a12_0= keywordimport ) ) )* a13= '}' ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:217:3: (a10= 'IMPORTS' a11= '{' ( ( (a12_0= keywordimport ) ) )* a13= '}' )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:217:3: (a10= 'IMPORTS' a11= '{' ( ( (a12_0= keywordimport ) ) )* a13= '}' )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:218:4: a10= 'IMPORTS' a11= '{' ( ( (a12_0= keywordimport ) ) )* a13= '}'
                    {
                    a10=(Token)match(input,17,FOLLOW_17_in_concretesyntax314); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a10);copyLocalizationInfos((CommonToken)a10, element); 
                    }
                    a11=(Token)match(input,18,FOLLOW_18_in_concretesyntax324); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a11);copyLocalizationInfos((CommonToken)a11, element); 
                    }
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:220:4: ( ( (a12_0= keywordimport ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==QUALIFIED_NAME) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:221:5: ( (a12_0= keywordimport ) )
                    	    {
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:221:5: ( (a12_0= keywordimport ) )
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:222:6: (a12_0= keywordimport )
                    	    {
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:222:6: (a12_0= keywordimport )
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:222:7: a12_0= keywordimport
                    	    {
                    	    pushFollow(FOLLOW_keywordimport_in_concretesyntax348);
                    	    a12_0=keywordimport();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	      if (element == null) {
                    	      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); 
                    	      }

                    	      if (a12_0 != null) {
                    	      addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__IMPORTS, a12_0); 
                    	      }
                    	      collectHiddenTokens(element, a12_0);
                    	      copyLocalizationInfos(a12_0, element); 

                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    a13=(Token)match(input,19,FOLLOW_19_in_concretesyntax372); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a13);copyLocalizationInfos((CommonToken)a13, element); 
                    }

                    }


                    }
                    break;

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:238:2: ( (a14= 'OPTIONS' a15= '{' ( ( (a16_0= option ) a17= ';' ) )* a18= '}' ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:239:3: (a14= 'OPTIONS' a15= '{' ( ( (a16_0= option ) a17= ';' ) )* a18= '}' )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:239:3: (a14= 'OPTIONS' a15= '{' ( ( (a16_0= option ) a17= ';' ) )* a18= '}' )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:240:4: a14= 'OPTIONS' a15= '{' ( ( (a16_0= option ) a17= ';' ) )* a18= '}'
                    {
                    a14=(Token)match(input,20,FOLLOW_20_in_concretesyntax397); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a14);copyLocalizationInfos((CommonToken)a14, element); 
                    }
                    a15=(Token)match(input,18,FOLLOW_18_in_concretesyntax407); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a15);copyLocalizationInfos((CommonToken)a15, element); 
                    }
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:242:4: ( ( (a16_0= option ) a17= ';' ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==QUALIFIED_NAME) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:243:5: ( (a16_0= option ) a17= ';' )
                    	    {
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:243:5: ( (a16_0= option ) a17= ';' )
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:244:6: (a16_0= option ) a17= ';'
                    	    {
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:244:6: (a16_0= option )
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:244:7: a16_0= option
                    	    {
                    	    pushFollow(FOLLOW_option_in_concretesyntax431);
                    	    a16_0=option();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	      if (element == null) {
                    	      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); 
                    	      }

                    	      if (a16_0 != null) {
                    	      addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__OPTIONS, a16_0); 
                    	      }
                    	      collectHiddenTokens(element, a16_0);
                    	      copyLocalizationInfos(a16_0, element); 

                    	    }

                    	    }

                    	    a17=(Token)match(input,21,FOLLOW_21_in_concretesyntax445); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a17);copyLocalizationInfos((CommonToken)a17, element); 
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    a18=(Token)match(input,19,FOLLOW_19_in_concretesyntax467); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a18);copyLocalizationInfos((CommonToken)a18, element); 
                    }

                    }


                    }
                    break;

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:261:2: ( (a19= 'TOKENS' a20= '{' ( ( (a21_0= tokendefinition ) a22= ';' ) )* a23= '}' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==22) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:262:3: (a19= 'TOKENS' a20= '{' ( ( (a21_0= tokendefinition ) a22= ';' ) )* a23= '}' )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:262:3: (a19= 'TOKENS' a20= '{' ( ( (a21_0= tokendefinition ) a22= ';' ) )* a23= '}' )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:263:4: a19= 'TOKENS' a20= '{' ( ( (a21_0= tokendefinition ) a22= ';' ) )* a23= '}'
                    {
                    a19=(Token)match(input,22,FOLLOW_22_in_concretesyntax492); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a19);copyLocalizationInfos((CommonToken)a19, element); 
                    }
                    a20=(Token)match(input,18,FOLLOW_18_in_concretesyntax502); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a20);copyLocalizationInfos((CommonToken)a20, element); 
                    }
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:265:4: ( ( (a21_0= tokendefinition ) a22= ';' ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==39||LA9_0==42) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:266:5: ( (a21_0= tokendefinition ) a22= ';' )
                    	    {
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:266:5: ( (a21_0= tokendefinition ) a22= ';' )
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:267:6: (a21_0= tokendefinition ) a22= ';'
                    	    {
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:267:6: (a21_0= tokendefinition )
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:267:7: a21_0= tokendefinition
                    	    {
                    	    pushFollow(FOLLOW_tokendefinition_in_concretesyntax526);
                    	    a21_0=tokendefinition();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	      if (element == null) {
                    	      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); 
                    	      }

                    	      if (a21_0 != null) {
                    	      addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKENS, a21_0); 
                    	      }
                    	      collectHiddenTokens(element, a21_0);
                    	      copyLocalizationInfos(a21_0, element); 

                    	    }

                    	    }

                    	    a22=(Token)match(input,21,FOLLOW_21_in_concretesyntax540); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a22);copyLocalizationInfos((CommonToken)a22, element); 
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    a23=(Token)match(input,19,FOLLOW_19_in_concretesyntax562); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a23);copyLocalizationInfos((CommonToken)a23, element); 
                    }

                    }


                    }
                    break;

            }

            a24=(Token)match(input,23,FOLLOW_23_in_concretesyntax578); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a24);copyLocalizationInfos((CommonToken)a24, element); 
            }
            a25=(Token)match(input,18,FOLLOW_18_in_concretesyntax586); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a25);copyLocalizationInfos((CommonToken)a25, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:286:2: ( ( (a26_0= rule ) )+ )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:287:3: ( (a26_0= rule ) )+
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:287:3: ( (a26_0= rule ) )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==QUALIFIED_NAME) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:288:4: (a26_0= rule )
            	    {
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:288:4: (a26_0= rule )
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:288:5: a26_0= rule
            	    {
            	    pushFollow(FOLLOW_rule_in_concretesyntax604);
            	    a26_0=rule();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {
            	      if (element == null) {
            	      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); 
            	      }

            	      if (a26_0 != null) {
            	      addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES, a26_0); 
            	      }
            	      collectHiddenTokens(element, a26_0);
            	      copyLocalizationInfos(a26_0, element); 

            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }

            a27=(Token)match(input,19,FOLLOW_19_in_concretesyntax622); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a27);copyLocalizationInfos((CommonToken)a27, element); 
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
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:304:1: keywordimport returns [org.emftext.sdk.concretesyntax.Import element = null] : (a0= QUALIFIED_NAME ) a1= ':' (a2= QUOTED_60_62 ) ( ( (a3= QUOTED_60_62 ) ) )? ( (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? ) )? ;
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
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:307:1: ( (a0= QUALIFIED_NAME ) a1= ':' (a2= QUOTED_60_62 ) ( ( (a3= QUOTED_60_62 ) ) )? ( (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? ) )? )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:308:2: (a0= QUALIFIED_NAME ) a1= ':' (a2= QUOTED_60_62 ) ( ( (a3= QUOTED_60_62 ) ) )? ( (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? ) )?
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:308:2: (a0= QUALIFIED_NAME )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:308:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_keywordimport646); if (state.failed) return element;
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

            }

            a1=(Token)match(input,24,FOLLOW_24_in_keywordimport656); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:329:2: (a2= QUOTED_60_62 )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:329:3: a2= QUOTED_60_62
            {
            a2=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_keywordimport665); if (state.failed) return element;
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

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:353:2: ( ( (a3= QUOTED_60_62 ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==QUOTED_60_62) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:354:3: ( (a3= QUOTED_60_62 ) )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:354:3: ( (a3= QUOTED_60_62 ) )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:355:4: (a3= QUOTED_60_62 )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:355:4: (a3= QUOTED_60_62 )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:355:5: a3= QUOTED_60_62
                    {
                    a3=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_keywordimport685); if (state.failed) return element;
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


                    }
                    break;

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:377:2: ( (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==25) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:378:3: (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:378:3: (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:379:4: a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )?
                    {
                    a4=(Token)match(input,25,FOLLOW_25_in_keywordimport712); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport();} collectHiddenTokens(element, (CommonToken)a4);copyLocalizationInfos((CommonToken)a4, element); 
                    }
                    a5=(Token)match(input,26,FOLLOW_26_in_keywordimport722); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport();} collectHiddenTokens(element, (CommonToken)a5);copyLocalizationInfos((CommonToken)a5, element); 
                    }
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:381:4: (a6= QUALIFIED_NAME )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:381:5: a6= QUALIFIED_NAME
                    {
                    a6=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_keywordimport733); if (state.failed) return element;
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

                    }

                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:405:4: ( ( (a7= QUOTED_60_62 ) ) )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==QUOTED_60_62) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:406:5: ( (a7= QUOTED_60_62 ) )
                            {
                            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:406:5: ( (a7= QUOTED_60_62 ) )
                            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:407:6: (a7= QUOTED_60_62 )
                            {
                            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:407:6: (a7= QUOTED_60_62 )
                            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:407:7: a7= QUOTED_60_62
                            {
                            a7=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_keywordimport759); if (state.failed) return element;
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
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:433:1: option returns [org.emftext.sdk.concretesyntax.Option element = null] : (a0= QUALIFIED_NAME ) a1= '=' (a2= QUOTED_34_34 ) ;
    public final org.emftext.sdk.concretesyntax.Option option() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Option element =  null;
        int option_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:436:1: ( (a0= QUALIFIED_NAME ) a1= '=' (a2= QUOTED_34_34 ) )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:437:2: (a0= QUALIFIED_NAME ) a1= '=' (a2= QUOTED_34_34 )
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:437:2: (a0= QUALIFIED_NAME )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:437:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_option805); if (state.failed) return element;
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

            }

            a1=(Token)match(input,27,FOLLOW_27_in_option815); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createOption();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:458:2: (a2= QUOTED_34_34 )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:458:3: a2= QUOTED_34_34
            {
            a2=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_option824); if (state.failed) return element;
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
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:480:1: rule returns [org.emftext.sdk.concretesyntax.Rule element = null] : ( (a0= QUALIFIED_NAME ) ) a1= '::=' (a2_0= choice ) a3= ';' ;
    public final org.emftext.sdk.concretesyntax.Rule rule() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Rule element =  null;
        int rule_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a3=null;
        org.emftext.sdk.concretesyntax.Choice a2_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:483:1: ( ( (a0= QUALIFIED_NAME ) ) a1= '::=' (a2_0= choice ) a3= ';' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:484:2: ( (a0= QUALIFIED_NAME ) ) a1= '::=' (a2_0= choice ) a3= ';'
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:484:2: ( (a0= QUALIFIED_NAME ) )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:485:3: (a0= QUALIFIED_NAME )
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:485:3: (a0= QUALIFIED_NAME )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:485:4: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_rule854); if (state.failed) return element;
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


            }

            a1=(Token)match(input,28,FOLLOW_28_in_rule867); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createRule();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:511:2: (a2_0= choice )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:511:3: a2_0= choice
            {
            pushFollow(FOLLOW_choice_in_rule876);
            a2_0=choice();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) {
              	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createRule(); 
              }

              if (a2_0 != null) {
              element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__DEFINITION), a2_0); 
              }
              collectHiddenTokens(element, a2_0);
              copyLocalizationInfos(a2_0, element); 

            }

            }

            a3=(Token)match(input,21,FOLLOW_21_in_rule886); if (state.failed) return element;
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
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:525:1: sequence returns [org.emftext.sdk.concretesyntax.Sequence element = null] : ( (a0_0= definition ) )+ ;
    public final org.emftext.sdk.concretesyntax.Sequence sequence() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Sequence element =  null;
        int sequence_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.Definition a0_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:528:1: ( ( (a0_0= definition ) )+ )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:529:2: ( (a0_0= definition ) )+
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:529:2: ( (a0_0= definition ) )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==QUALIFIED_NAME||LA15_0==QUOTED_34_34||LA15_0==32||(LA15_0>=37 && LA15_0<=38)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:530:3: (a0_0= definition )
            	    {
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:530:3: (a0_0= definition )
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:530:4: a0_0= definition
            	    {
            	    pushFollow(FOLLOW_definition_in_sequence914);
            	    a0_0=definition();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {
            	      if (element == null) {
            	      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createSequence(); 
            	      }

            	      if (a0_0 != null) {
            	      addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.SEQUENCE__PARTS, a0_0); 
            	      }
            	      collectHiddenTokens(element, a0_0);
            	      copyLocalizationInfos(a0_0, element); 

            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
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
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:544:1: choice returns [org.emftext.sdk.concretesyntax.Choice element = null] : (a0_0= sequence ) ( (a1= '|' (a2_0= sequence ) ) )* ;
    public final org.emftext.sdk.concretesyntax.Choice choice() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Choice element =  null;
        int choice_StartIndex = input.index();
        Token a1=null;
        org.emftext.sdk.concretesyntax.Sequence a0_0 = null;

        org.emftext.sdk.concretesyntax.Sequence a2_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:547:1: ( (a0_0= sequence ) ( (a1= '|' (a2_0= sequence ) ) )* )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:548:2: (a0_0= sequence ) ( (a1= '|' (a2_0= sequence ) ) )*
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:548:2: (a0_0= sequence )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:548:3: a0_0= sequence
            {
            pushFollow(FOLLOW_sequence_in_choice944);
            a0_0=sequence();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) {
              	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createChoice(); 
              }

              if (a0_0 != null) {
              addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CHOICE__OPTIONS, a0_0); 
              }
              collectHiddenTokens(element, a0_0);
              copyLocalizationInfos(a0_0, element); 

            }

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:559:2: ( (a1= '|' (a2_0= sequence ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==29) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:560:3: (a1= '|' (a2_0= sequence ) )
            	    {
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:560:3: (a1= '|' (a2_0= sequence ) )
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:561:4: a1= '|' (a2_0= sequence )
            	    {
            	    a1=(Token)match(input,29,FOLLOW_29_in_choice963); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {
            	       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createChoice();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            	    }
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:562:4: (a2_0= sequence )
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:562:5: a2_0= sequence
            	    {
            	    pushFollow(FOLLOW_sequence_in_choice974);
            	    a2_0=sequence();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {
            	      if (element == null) {
            	      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createChoice(); 
            	      }

            	      if (a2_0 != null) {
            	      addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CHOICE__OPTIONS, a2_0); 
            	      }
            	      collectHiddenTokens(element, a2_0);
            	      copyLocalizationInfos(a2_0, element); 

            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
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
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:577:1: csstring returns [org.emftext.sdk.concretesyntax.CsString element = null] : (a0= QUOTED_34_34 ) ;
    public final org.emftext.sdk.concretesyntax.CsString csstring() throws RecognitionException {
        org.emftext.sdk.concretesyntax.CsString element =  null;
        int csstring_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:580:1: ( (a0= QUOTED_34_34 ) )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:581:2: (a0= QUOTED_34_34 )
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:581:2: (a0= QUOTED_34_34 )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:581:3: a0= QUOTED_34_34
            {
            a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_csstring1008); if (state.failed) return element;
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
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:603:1: definedplaceholder returns [org.emftext.sdk.concretesyntax.DefinedPlaceholder element = null] : (a0= QUALIFIED_NAME ) a1= '[' (a2= QUALIFIED_NAME ) a3= ']' ( (a4_0= cardinality ) )? ;
    public final org.emftext.sdk.concretesyntax.DefinedPlaceholder definedplaceholder() throws RecognitionException {
        org.emftext.sdk.concretesyntax.DefinedPlaceholder element =  null;
        int definedplaceholder_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        org.emftext.sdk.concretesyntax.Cardinality a4_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:606:1: ( (a0= QUALIFIED_NAME ) a1= '[' (a2= QUALIFIED_NAME ) a3= ']' ( (a4_0= cardinality ) )? )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:607:2: (a0= QUALIFIED_NAME ) a1= '[' (a2= QUALIFIED_NAME ) a3= ']' ( (a4_0= cardinality ) )?
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:607:2: (a0= QUALIFIED_NAME )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:607:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_definedplaceholder1034); if (state.failed) return element;
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

            }

            a1=(Token)match(input,30,FOLLOW_30_in_definedplaceholder1044); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDefinedPlaceholder();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:632:2: (a2= QUALIFIED_NAME )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:632:3: a2= QUALIFIED_NAME
            {
            a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_definedplaceholder1053); if (state.failed) return element;
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

            }

            a3=(Token)match(input,31,FOLLOW_31_in_definedplaceholder1063); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDefinedPlaceholder();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:657:2: ( (a4_0= cardinality ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=34 && LA17_0<=36)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:658:3: (a4_0= cardinality )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:658:3: (a4_0= cardinality )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:658:4: a4_0= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_definedplaceholder1076);
                    a4_0=cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) {
                      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDefinedPlaceholder(); 
                      }

                      if (a4_0 != null) {
                      element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DEFINED_PLACEHOLDER__CARDINALITY), a4_0); 
                      }
                      collectHiddenTokens(element, a4_0);
                      copyLocalizationInfos(a4_0, element); 

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
            if ( state.backtracking>0 ) { memoize(input, 9, definedplaceholder_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "definedplaceholder"


    // $ANTLR start "derivedplaceholder"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:672:1: derivedplaceholder returns [org.emftext.sdk.concretesyntax.DerivedPlaceholder element = null] : (a0= QUALIFIED_NAME ) a1= '[' ( ( (a2= QUOTED_39_39 ) ( (a3= ',' (a4= QUOTED_39_39 ) ) )? ) )? a5= ']' ( (a6_0= cardinality ) )? ;
    public final org.emftext.sdk.concretesyntax.DerivedPlaceholder derivedplaceholder() throws RecognitionException {
        org.emftext.sdk.concretesyntax.DerivedPlaceholder element =  null;
        int derivedplaceholder_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        org.emftext.sdk.concretesyntax.Cardinality a6_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:675:1: ( (a0= QUALIFIED_NAME ) a1= '[' ( ( (a2= QUOTED_39_39 ) ( (a3= ',' (a4= QUOTED_39_39 ) ) )? ) )? a5= ']' ( (a6_0= cardinality ) )? )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:676:2: (a0= QUALIFIED_NAME ) a1= '[' ( ( (a2= QUOTED_39_39 ) ( (a3= ',' (a4= QUOTED_39_39 ) ) )? ) )? a5= ']' ( (a6_0= cardinality ) )?
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:676:2: (a0= QUALIFIED_NAME )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:676:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_derivedplaceholder1106); if (state.failed) return element;
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

            }

            a1=(Token)match(input,30,FOLLOW_30_in_derivedplaceholder1116); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:701:2: ( ( (a2= QUOTED_39_39 ) ( (a3= ',' (a4= QUOTED_39_39 ) ) )? ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==QUOTED_39_39) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:702:3: ( (a2= QUOTED_39_39 ) ( (a3= ',' (a4= QUOTED_39_39 ) ) )? )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:702:3: ( (a2= QUOTED_39_39 ) ( (a3= ',' (a4= QUOTED_39_39 ) ) )? )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:703:4: (a2= QUOTED_39_39 ) ( (a3= ',' (a4= QUOTED_39_39 ) ) )?
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:703:4: (a2= QUOTED_39_39 )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:703:5: a2= QUOTED_39_39
                    {
                    a2=(Token)match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_derivedplaceholder1134); if (state.failed) return element;
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

                    }

                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:723:4: ( (a3= ',' (a4= QUOTED_39_39 ) ) )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==16) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:724:5: (a3= ',' (a4= QUOTED_39_39 ) )
                            {
                            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:724:5: (a3= ',' (a4= QUOTED_39_39 ) )
                            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:725:6: a3= ',' (a4= QUOTED_39_39 )
                            {
                            a3=(Token)match(input,16,FOLLOW_16_in_derivedplaceholder1159); if (state.failed) return element;
                            if ( state.backtracking==0 ) {
                               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); 
                            }
                            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:726:6: (a4= QUOTED_39_39 )
                            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:726:7: a4= QUOTED_39_39
                            {
                            a4=(Token)match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_derivedplaceholder1172); if (state.failed) return element;
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


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            a5=(Token)match(input,31,FOLLOW_31_in_derivedplaceholder1202); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder();} collectHiddenTokens(element, (CommonToken)a5);copyLocalizationInfos((CommonToken)a5, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:751:2: ( (a6_0= cardinality ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=34 && LA20_0<=36)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:752:3: (a6_0= cardinality )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:752:3: (a6_0= cardinality )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:752:4: a6_0= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_derivedplaceholder1215);
                    a6_0=cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) {
                      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder(); 
                      }

                      if (a6_0 != null) {
                      element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DERIVED_PLACEHOLDER__CARDINALITY), a6_0); 
                      }
                      collectHiddenTokens(element, a6_0);
                      copyLocalizationInfos(a6_0, element); 

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
            if ( state.backtracking>0 ) { memoize(input, 10, derivedplaceholder_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "derivedplaceholder"


    // $ANTLR start "containment"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:766:1: containment returns [org.emftext.sdk.concretesyntax.Containment element = null] : (a0= QUALIFIED_NAME ) ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )? ( (a5_0= cardinality ) )? ;
    public final org.emftext.sdk.concretesyntax.Containment containment() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Containment element =  null;
        int containment_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        org.emftext.sdk.concretesyntax.Cardinality a5_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:769:1: ( (a0= QUALIFIED_NAME ) ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )? ( (a5_0= cardinality ) )? )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:770:2: (a0= QUALIFIED_NAME ) ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )? ( (a5_0= cardinality ) )?
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:770:2: (a0= QUALIFIED_NAME )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:770:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_containment1245); if (state.failed) return element;
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

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:794:2: ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==24) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:795:3: (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:795:3: (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:796:4: a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )*
                    {
                    a1=(Token)match(input,24,FOLLOW_24_in_containment1264); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createContainment();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
                    }
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:797:4: (a2= QUALIFIED_NAME )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:797:5: a2= QUALIFIED_NAME
                    {
                    a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_containment1275); if (state.failed) return element;
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

                    }

                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:821:4: ( (a3= ',' (a4= QUALIFIED_NAME ) ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==16) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:822:5: (a3= ',' (a4= QUALIFIED_NAME ) )
                    	    {
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:822:5: (a3= ',' (a4= QUALIFIED_NAME ) )
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:823:6: a3= ',' (a4= QUALIFIED_NAME )
                    	    {
                    	    a3=(Token)match(input,16,FOLLOW_16_in_containment1300); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createContainment();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); 
                    	    }
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:824:6: (a4= QUALIFIED_NAME )
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:824:7: a4= QUALIFIED_NAME
                    	    {
                    	    a4=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_containment1313); if (state.failed) return element;
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


                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:852:2: ( (a5_0= cardinality ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=34 && LA23_0<=36)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:853:3: (a5_0= cardinality )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:853:3: (a5_0= cardinality )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:853:4: a5_0= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_containment1348);
                    a5_0=cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) {
                      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createContainment(); 
                      }

                      if (a5_0 != null) {
                      element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__CARDINALITY), a5_0); 
                      }
                      collectHiddenTokens(element, a5_0);
                      copyLocalizationInfos(a5_0, element); 

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
            if ( state.backtracking>0 ) { memoize(input, 11, containment_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "containment"


    // $ANTLR start "compounddefinition"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:867:1: compounddefinition returns [org.emftext.sdk.concretesyntax.CompoundDefinition element = null] : a0= '(' (a1_0= choice ) a2= ')' ( (a3_0= cardinality ) )? ;
    public final org.emftext.sdk.concretesyntax.CompoundDefinition compounddefinition() throws RecognitionException {
        org.emftext.sdk.concretesyntax.CompoundDefinition element =  null;
        int compounddefinition_StartIndex = input.index();
        Token a0=null;
        Token a2=null;
        org.emftext.sdk.concretesyntax.Choice a1_0 = null;

        org.emftext.sdk.concretesyntax.Cardinality a3_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:870:1: (a0= '(' (a1_0= choice ) a2= ')' ( (a3_0= cardinality ) )? )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:871:2: a0= '(' (a1_0= choice ) a2= ')' ( (a3_0= cardinality ) )?
            {
            a0=(Token)match(input,32,FOLLOW_32_in_compounddefinition1377); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createCompoundDefinition();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:872:2: (a1_0= choice )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:872:3: a1_0= choice
            {
            pushFollow(FOLLOW_choice_in_compounddefinition1386);
            a1_0=choice();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) {
              	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createCompoundDefinition(); 
              }

              if (a1_0 != null) {
              element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__DEFINITIONS), a1_0); 
              }
              collectHiddenTokens(element, a1_0);
              copyLocalizationInfos(a1_0, element); 

            }

            }

            a2=(Token)match(input,33,FOLLOW_33_in_compounddefinition1396); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createCompoundDefinition();} collectHiddenTokens(element, (CommonToken)a2);copyLocalizationInfos((CommonToken)a2, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:884:2: ( (a3_0= cardinality ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=34 && LA24_0<=36)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:885:3: (a3_0= cardinality )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:885:3: (a3_0= cardinality )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:885:4: a3_0= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_compounddefinition1409);
                    a3_0=cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) {
                      	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createCompoundDefinition(); 
                      }

                      if (a3_0 != null) {
                      element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CARDINALITY), a3_0); 
                      }
                      collectHiddenTokens(element, a3_0);
                      copyLocalizationInfos(a3_0, element); 

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
            if ( state.backtracking>0 ) { memoize(input, 12, compounddefinition_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "compounddefinition"


    // $ANTLR start "plus"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:899:1: plus returns [org.emftext.sdk.concretesyntax.PLUS element = null] : a0= '+' ;
    public final org.emftext.sdk.concretesyntax.PLUS plus() throws RecognitionException {
        org.emftext.sdk.concretesyntax.PLUS element =  null;
        int plus_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:902:1: (a0= '+' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:903:2: a0= '+'
            {
            a0=(Token)match(input,34,FOLLOW_34_in_plus1438); if (state.failed) return element;
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
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:906:1: star returns [org.emftext.sdk.concretesyntax.STAR element = null] : a0= '*' ;
    public final org.emftext.sdk.concretesyntax.STAR star() throws RecognitionException {
        org.emftext.sdk.concretesyntax.STAR element =  null;
        int star_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:909:1: (a0= '*' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:910:2: a0= '*'
            {
            a0=(Token)match(input,35,FOLLOW_35_in_star1461); if (state.failed) return element;
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
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:913:1: questionmark returns [org.emftext.sdk.concretesyntax.QUESTIONMARK element = null] : a0= '?' ;
    public final org.emftext.sdk.concretesyntax.QUESTIONMARK questionmark() throws RecognitionException {
        org.emftext.sdk.concretesyntax.QUESTIONMARK element =  null;
        int questionmark_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:916:1: (a0= '?' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:917:2: a0= '?'
            {
            a0=(Token)match(input,36,FOLLOW_36_in_questionmark1484); if (state.failed) return element;
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
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:920:1: whitespaces returns [org.emftext.sdk.concretesyntax.WhiteSpaces element = null] : a0= '#' (a1= NUMBER ) ;
    public final org.emftext.sdk.concretesyntax.WhiteSpaces whitespaces() throws RecognitionException {
        org.emftext.sdk.concretesyntax.WhiteSpaces element =  null;
        int whitespaces_StartIndex = input.index();
        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:923:1: (a0= '#' (a1= NUMBER ) )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:924:2: a0= '#' (a1= NUMBER )
            {
            a0=(Token)match(input,37,FOLLOW_37_in_whitespaces1507); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createWhiteSpaces();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:925:2: (a1= NUMBER )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:925:3: a1= NUMBER
            {
            a1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_whitespaces1516); if (state.failed) return element;
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
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:947:1: linebreak returns [org.emftext.sdk.concretesyntax.LineBreak element = null] : a0= '!' (a1= NUMBER ) ;
    public final org.emftext.sdk.concretesyntax.LineBreak linebreak() throws RecognitionException {
        org.emftext.sdk.concretesyntax.LineBreak element =  null;
        int linebreak_StartIndex = input.index();
        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:950:1: (a0= '!' (a1= NUMBER ) )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:951:2: a0= '!' (a1= NUMBER )
            {
            a0=(Token)match(input,38,FOLLOW_38_in_linebreak1541); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createLineBreak();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:952:2: (a1= NUMBER )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:952:3: a1= NUMBER
            {
            a1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_linebreak1550); if (state.failed) return element;
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
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:974:1: normaltoken returns [org.emftext.sdk.concretesyntax.NormalToken element = null] : a0= 'DEFINE' (a1= QUALIFIED_NAME ) (a2= QUOTED_36_36 ) ( (a3= 'COLLECT' a4= 'IN' (a5= QUALIFIED_NAME ) ) )? ;
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
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:977:1: (a0= 'DEFINE' (a1= QUALIFIED_NAME ) (a2= QUOTED_36_36 ) ( (a3= 'COLLECT' a4= 'IN' (a5= QUALIFIED_NAME ) ) )? )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:978:2: a0= 'DEFINE' (a1= QUALIFIED_NAME ) (a2= QUOTED_36_36 ) ( (a3= 'COLLECT' a4= 'IN' (a5= QUALIFIED_NAME ) ) )?
            {
            a0=(Token)match(input,39,FOLLOW_39_in_normaltoken1575); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:979:2: (a1= QUALIFIED_NAME )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:979:3: a1= QUALIFIED_NAME
            {
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_normaltoken1584); if (state.failed) return element;
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

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:999:2: (a2= QUOTED_36_36 )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:999:3: a2= QUOTED_36_36
            {
            a2=(Token)match(input,QUOTED_36_36,FOLLOW_QUOTED_36_36_in_normaltoken1595); if (state.failed) return element;
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

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1019:2: ( (a3= 'COLLECT' a4= 'IN' (a5= QUALIFIED_NAME ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==40) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1020:3: (a3= 'COLLECT' a4= 'IN' (a5= QUALIFIED_NAME ) )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1020:3: (a3= 'COLLECT' a4= 'IN' (a5= QUALIFIED_NAME ) )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1021:4: a3= 'COLLECT' a4= 'IN' (a5= QUALIFIED_NAME )
                    {
                    a3=(Token)match(input,40,FOLLOW_40_in_normaltoken1614); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); 
                    }
                    a4=(Token)match(input,41,FOLLOW_41_in_normaltoken1624); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken();} collectHiddenTokens(element, (CommonToken)a4);copyLocalizationInfos((CommonToken)a4, element); 
                    }
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1023:4: (a5= QUALIFIED_NAME )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1023:5: a5= QUALIFIED_NAME
                    {
                    a5=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_normaltoken1635); if (state.failed) return element;
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
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1047:1: decoratedtoken returns [org.emftext.sdk.concretesyntax.DecoratedToken element = null] : a0= 'DEFINE' (a1= QUALIFIED_NAME ) (a2= '[' ( (a3= QUOTED_39_39 ) ) a4= ']' ) (a5= QUOTED_36_36 ) (a6= '[' ( (a7= QUOTED_39_39 ) ) a8= ']' ) ( (a9= 'COLLECT' a10= 'IN' (a11= QUALIFIED_NAME ) ) )? ;
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
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1050:1: (a0= 'DEFINE' (a1= QUALIFIED_NAME ) (a2= '[' ( (a3= QUOTED_39_39 ) ) a4= ']' ) (a5= QUOTED_36_36 ) (a6= '[' ( (a7= QUOTED_39_39 ) ) a8= ']' ) ( (a9= 'COLLECT' a10= 'IN' (a11= QUALIFIED_NAME ) ) )? )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1051:2: a0= 'DEFINE' (a1= QUALIFIED_NAME ) (a2= '[' ( (a3= QUOTED_39_39 ) ) a4= ']' ) (a5= QUOTED_36_36 ) (a6= '[' ( (a7= QUOTED_39_39 ) ) a8= ']' ) ( (a9= 'COLLECT' a10= 'IN' (a11= QUALIFIED_NAME ) ) )?
            {
            a0=(Token)match(input,39,FOLLOW_39_in_decoratedtoken1668); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1052:2: (a1= QUALIFIED_NAME )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1052:3: a1= QUALIFIED_NAME
            {
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_decoratedtoken1677); if (state.failed) return element;
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

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1072:2: (a2= '[' ( (a3= QUOTED_39_39 ) ) a4= ']' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1073:3: a2= '[' ( (a3= QUOTED_39_39 ) ) a4= ']'
            {
            a2=(Token)match(input,30,FOLLOW_30_in_decoratedtoken1691); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a2);copyLocalizationInfos((CommonToken)a2, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1074:3: ( (a3= QUOTED_39_39 ) )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1075:4: (a3= QUOTED_39_39 )
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1075:4: (a3= QUOTED_39_39 )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1075:5: a3= QUOTED_39_39
            {
            a3=(Token)match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_decoratedtoken1706); if (state.failed) return element;
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


            }

            a4=(Token)match(input,31,FOLLOW_31_in_decoratedtoken1721); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a4);copyLocalizationInfos((CommonToken)a4, element); 
            }

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1098:2: (a5= QUOTED_36_36 )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1098:3: a5= QUOTED_36_36
            {
            a5=(Token)match(input,QUOTED_36_36,FOLLOW_QUOTED_36_36_in_decoratedtoken1733); if (state.failed) return element;
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

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1118:2: (a6= '[' ( (a7= QUOTED_39_39 ) ) a8= ']' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1119:3: a6= '[' ( (a7= QUOTED_39_39 ) ) a8= ']'
            {
            a6=(Token)match(input,30,FOLLOW_30_in_decoratedtoken1747); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a6);copyLocalizationInfos((CommonToken)a6, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1120:3: ( (a7= QUOTED_39_39 ) )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1121:4: (a7= QUOTED_39_39 )
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1121:4: (a7= QUOTED_39_39 )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1121:5: a7= QUOTED_39_39
            {
            a7=(Token)match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_decoratedtoken1762); if (state.failed) return element;
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


            }

            a8=(Token)match(input,31,FOLLOW_31_in_decoratedtoken1777); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a8);copyLocalizationInfos((CommonToken)a8, element); 
            }

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1144:2: ( (a9= 'COLLECT' a10= 'IN' (a11= QUALIFIED_NAME ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==40) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1145:3: (a9= 'COLLECT' a10= 'IN' (a11= QUALIFIED_NAME ) )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1145:3: (a9= 'COLLECT' a10= 'IN' (a11= QUALIFIED_NAME ) )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1146:4: a9= 'COLLECT' a10= 'IN' (a11= QUALIFIED_NAME )
                    {
                    a9=(Token)match(input,40,FOLLOW_40_in_decoratedtoken1797); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a9);copyLocalizationInfos((CommonToken)a9, element); 
                    }
                    a10=(Token)match(input,41,FOLLOW_41_in_decoratedtoken1807); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a10);copyLocalizationInfos((CommonToken)a10, element); 
                    }
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1148:4: (a11= QUALIFIED_NAME )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1148:5: a11= QUALIFIED_NAME
                    {
                    a11=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_decoratedtoken1818); if (state.failed) return element;
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
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1172:1: predefinedtoken returns [org.emftext.sdk.concretesyntax.PreDefinedToken element = null] : a0= 'PREDEFINED' (a1= QUALIFIED_NAME ) ( (a2= 'COLLECT' a3= 'IN' (a4= QUALIFIED_NAME ) ) )? ;
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
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1175:1: (a0= 'PREDEFINED' (a1= QUALIFIED_NAME ) ( (a2= 'COLLECT' a3= 'IN' (a4= QUALIFIED_NAME ) ) )? )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1176:2: a0= 'PREDEFINED' (a1= QUALIFIED_NAME ) ( (a2= 'COLLECT' a3= 'IN' (a4= QUALIFIED_NAME ) ) )?
            {
            a0=(Token)match(input,42,FOLLOW_42_in_predefinedtoken1851); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1177:2: (a1= QUALIFIED_NAME )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1177:3: a1= QUALIFIED_NAME
            {
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_predefinedtoken1860); if (state.failed) return element;
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

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1197:2: ( (a2= 'COLLECT' a3= 'IN' (a4= QUALIFIED_NAME ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==40) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1198:3: (a2= 'COLLECT' a3= 'IN' (a4= QUALIFIED_NAME ) )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1198:3: (a2= 'COLLECT' a3= 'IN' (a4= QUALIFIED_NAME ) )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1199:4: a2= 'COLLECT' a3= 'IN' (a4= QUALIFIED_NAME )
                    {
                    a2=(Token)match(input,40,FOLLOW_40_in_predefinedtoken1879); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken();} collectHiddenTokens(element, (CommonToken)a2);copyLocalizationInfos((CommonToken)a2, element); 
                    }
                    a3=(Token)match(input,41,FOLLOW_41_in_predefinedtoken1889); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); 
                    }
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1201:4: (a4= QUALIFIED_NAME )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1201:5: a4= QUALIFIED_NAME
                    {
                    a4=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_predefinedtoken1900); if (state.failed) return element;
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


    // $ANTLR start "keywordabstract"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1225:1: keywordabstract returns [org.emftext.sdk.concretesyntax.Abstract element = null] : a0= 'ABSTRACT' ;
    public final org.emftext.sdk.concretesyntax.Abstract keywordabstract() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Abstract element =  null;
        int keywordabstract_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1228:1: (a0= 'ABSTRACT' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1229:2: a0= 'ABSTRACT'
            {
            a0=(Token)match(input,43,FOLLOW_43_in_keywordabstract1933); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createAbstract();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 21, keywordabstract_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "keywordabstract"


    // $ANTLR start "tokendefinition"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1232:1: tokendefinition returns [org.emftext.sdk.concretesyntax.TokenDefinition element = null] : (c0= normaltoken | c1= decoratedtoken | c2= predefinedtoken );
    public final org.emftext.sdk.concretesyntax.TokenDefinition tokendefinition() throws RecognitionException {
        org.emftext.sdk.concretesyntax.TokenDefinition element =  null;
        int tokendefinition_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.NormalToken c0 = null;

        org.emftext.sdk.concretesyntax.DecoratedToken c1 = null;

        org.emftext.sdk.concretesyntax.PreDefinedToken c2 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1234:1: (c0= normaltoken | c1= decoratedtoken | c2= predefinedtoken )
            int alt28=3;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==39) ) {
                int LA28_1 = input.LA(2);

                if ( (LA28_1==QUALIFIED_NAME) ) {
                    int LA28_3 = input.LA(3);

                    if ( (LA28_3==QUOTED_36_36) ) {
                        alt28=1;
                    }
                    else if ( (LA28_3==30) ) {
                        alt28=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 28, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA28_0==42) ) {
                alt28=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1235:2: c0= normaltoken
                    {
                    pushFollow(FOLLOW_normaltoken_in_tokendefinition1952);
                    c0=normaltoken();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1236:2: c1= decoratedtoken
                    {
                    pushFollow(FOLLOW_decoratedtoken_in_tokendefinition1962);
                    c1=decoratedtoken();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1237:2: c2= predefinedtoken
                    {
                    pushFollow(FOLLOW_predefinedtoken_in_tokendefinition1972);
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
            if ( state.backtracking>0 ) { memoize(input, 22, tokendefinition_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "tokendefinition"


    // $ANTLR start "definition"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1240:1: definition returns [org.emftext.sdk.concretesyntax.Definition element = null] : (c0= csstring | c1= definedplaceholder | c2= derivedplaceholder | c3= containment | c4= compounddefinition | c5= whitespaces | c6= linebreak );
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1242:1: (c0= csstring | c1= definedplaceholder | c2= derivedplaceholder | c3= containment | c4= compounddefinition | c5= whitespaces | c6= linebreak )
            int alt29=7;
            alt29 = dfa29.predict(input);
            switch (alt29) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1243:2: c0= csstring
                    {
                    pushFollow(FOLLOW_csstring_in_definition1991);
                    c0=csstring();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1244:2: c1= definedplaceholder
                    {
                    pushFollow(FOLLOW_definedplaceholder_in_definition2001);
                    c1=definedplaceholder();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1245:2: c2= derivedplaceholder
                    {
                    pushFollow(FOLLOW_derivedplaceholder_in_definition2011);
                    c2=derivedplaceholder();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; 
                    }

                    }
                    break;
                case 4 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1246:2: c3= containment
                    {
                    pushFollow(FOLLOW_containment_in_definition2021);
                    c3=containment();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c3; 
                    }

                    }
                    break;
                case 5 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1247:2: c4= compounddefinition
                    {
                    pushFollow(FOLLOW_compounddefinition_in_definition2031);
                    c4=compounddefinition();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c4; 
                    }

                    }
                    break;
                case 6 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1248:2: c5= whitespaces
                    {
                    pushFollow(FOLLOW_whitespaces_in_definition2041);
                    c5=whitespaces();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c5; 
                    }

                    }
                    break;
                case 7 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1249:2: c6= linebreak
                    {
                    pushFollow(FOLLOW_linebreak_in_definition2051);
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
            if ( state.backtracking>0 ) { memoize(input, 23, definition_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "definition"


    // $ANTLR start "cardinality"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1252:1: cardinality returns [org.emftext.sdk.concretesyntax.Cardinality element = null] : (c0= plus | c1= star | c2= questionmark );
    public final org.emftext.sdk.concretesyntax.Cardinality cardinality() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Cardinality element =  null;
        int cardinality_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.PLUS c0 = null;

        org.emftext.sdk.concretesyntax.STAR c1 = null;

        org.emftext.sdk.concretesyntax.QUESTIONMARK c2 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return element; }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1254:1: (c0= plus | c1= star | c2= questionmark )
            int alt30=3;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt30=1;
                }
                break;
            case 35:
                {
                alt30=2;
                }
                break;
            case 36:
                {
                alt30=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1255:2: c0= plus
                    {
                    pushFollow(FOLLOW_plus_in_cardinality2070);
                    c0=plus();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1256:2: c1= star
                    {
                    pushFollow(FOLLOW_star_in_cardinality2080);
                    c1=star();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1257:2: c2= questionmark
                    {
                    pushFollow(FOLLOW_questionmark_in_cardinality2090);
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
            if ( state.backtracking>0 ) { memoize(input, 24, cardinality_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "cardinality"

    // Delegated rules


    protected DFA29 dfa29 = new DFA29(this);
    static final String DFA29_eotS =
        "\12\uffff";
    static final String DFA29_eofS =
        "\2\uffff\1\6\7\uffff";
    static final String DFA29_minS =
        "\1\4\1\uffff\1\4\4\uffff\1\4\2\uffff";
    static final String DFA29_maxS =
        "\1\46\1\uffff\1\46\4\uffff\1\37\2\uffff";
    static final String DFA29_acceptS =
        "\1\uffff\1\1\1\uffff\1\5\1\6\1\7\1\4\1\uffff\1\2\1\3";
    static final String DFA29_specialS =
        "\12\uffff}>";
    static final String[] DFA29_transitionS = {
            "\1\2\1\uffff\1\1\31\uffff\1\3\4\uffff\1\4\1\5",
            "",
            "\1\6\1\uffff\1\6\16\uffff\1\6\2\uffff\1\6\4\uffff\1\6\1\7"+
            "\1\uffff\7\6",
            "",
            "",
            "",
            "",
            "\1\10\2\uffff\1\11\27\uffff\1\11",
            "",
            ""
    };

    static final short[] DFA29_eot = DFA.unpackEncodedString(DFA29_eotS);
    static final short[] DFA29_eof = DFA.unpackEncodedString(DFA29_eofS);
    static final char[] DFA29_min = DFA.unpackEncodedStringToUnsignedChars(DFA29_minS);
    static final char[] DFA29_max = DFA.unpackEncodedStringToUnsignedChars(DFA29_maxS);
    static final short[] DFA29_accept = DFA.unpackEncodedString(DFA29_acceptS);
    static final short[] DFA29_special = DFA.unpackEncodedString(DFA29_specialS);
    static final short[][] DFA29_transition;

    static {
        int numStates = DFA29_transitionS.length;
        DFA29_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA29_transition[i] = DFA.unpackEncodedString(DFA29_transitionS[i]);
        }
    }

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = DFA29_eot;
            this.eof = DFA29_eof;
            this.min = DFA29_min;
            this.max = DFA29_max;
            this.accept = DFA29_accept;
            this.special = DFA29_special;
            this.transition = DFA29_transition;
        }
        public String getDescription() {
            return "1240:1: definition returns [org.emftext.sdk.concretesyntax.Definition element = null] : (c0= csstring | c1= definedplaceholder | c2= derivedplaceholder | c3= containment | c4= compounddefinition | c5= whitespaces | c6= linebreak );";
        }
    }
 

    public static final BitSet FOLLOW_concretesyntax_in_start76 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_keywordabstract_in_concretesyntax111 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_concretesyntax125 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_concretesyntax134 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_concretesyntax144 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_concretesyntax153 = new BitSet(new long[]{0x0000000000D28020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_concretesyntax173 = new BitSet(new long[]{0x0000000000D28000L});
    public static final BitSet FOLLOW_15_in_concretesyntax200 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_concretesyntax217 = new BitSet(new long[]{0x0000000000D30000L});
    public static final BitSet FOLLOW_16_in_concretesyntax247 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_concretesyntax268 = new BitSet(new long[]{0x0000000000D30000L});
    public static final BitSet FOLLOW_17_in_concretesyntax314 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_concretesyntax324 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_keywordimport_in_concretesyntax348 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_19_in_concretesyntax372 = new BitSet(new long[]{0x0000000000D00000L});
    public static final BitSet FOLLOW_20_in_concretesyntax397 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_concretesyntax407 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_option_in_concretesyntax431 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_concretesyntax445 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_19_in_concretesyntax467 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_22_in_concretesyntax492 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_concretesyntax502 = new BitSet(new long[]{0x0000048000080000L});
    public static final BitSet FOLLOW_tokendefinition_in_concretesyntax526 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_concretesyntax540 = new BitSet(new long[]{0x0000048000080000L});
    public static final BitSet FOLLOW_19_in_concretesyntax562 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_concretesyntax578 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_concretesyntax586 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule_in_concretesyntax604 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_19_in_concretesyntax622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_keywordimport646 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_keywordimport656 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_keywordimport665 = new BitSet(new long[]{0x0000000002000022L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_keywordimport685 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_keywordimport712 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_keywordimport722 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_keywordimport733 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_keywordimport759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_option805 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_option815 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_option824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_rule854 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_rule867 = new BitSet(new long[]{0x0000006100000050L});
    public static final BitSet FOLLOW_choice_in_rule876 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_rule886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definition_in_sequence914 = new BitSet(new long[]{0x0000006100000052L});
    public static final BitSet FOLLOW_sequence_in_choice944 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_choice963 = new BitSet(new long[]{0x0000006100000050L});
    public static final BitSet FOLLOW_sequence_in_choice974 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_csstring1008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_definedplaceholder1034 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_definedplaceholder1044 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_definedplaceholder1053 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_definedplaceholder1063 = new BitSet(new long[]{0x0000001C00000002L});
    public static final BitSet FOLLOW_cardinality_in_definedplaceholder1076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_derivedplaceholder1106 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_derivedplaceholder1116 = new BitSet(new long[]{0x0000000080000080L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_derivedplaceholder1134 = new BitSet(new long[]{0x0000000080010000L});
    public static final BitSet FOLLOW_16_in_derivedplaceholder1159 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_derivedplaceholder1172 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_derivedplaceholder1202 = new BitSet(new long[]{0x0000001C00000002L});
    public static final BitSet FOLLOW_cardinality_in_derivedplaceholder1215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_containment1245 = new BitSet(new long[]{0x0000001C01000002L});
    public static final BitSet FOLLOW_24_in_containment1264 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_containment1275 = new BitSet(new long[]{0x0000001C00010002L});
    public static final BitSet FOLLOW_16_in_containment1300 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_containment1313 = new BitSet(new long[]{0x0000001C00010002L});
    public static final BitSet FOLLOW_cardinality_in_containment1348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_compounddefinition1377 = new BitSet(new long[]{0x0000006100000050L});
    public static final BitSet FOLLOW_choice_in_compounddefinition1386 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_compounddefinition1396 = new BitSet(new long[]{0x0000001C00000002L});
    public static final BitSet FOLLOW_cardinality_in_compounddefinition1409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_plus1438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_star1461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_questionmark1484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_whitespaces1507 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_NUMBER_in_whitespaces1516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_linebreak1541 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_NUMBER_in_linebreak1550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_normaltoken1575 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_normaltoken1584 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTED_36_36_in_normaltoken1595 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_normaltoken1614 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_normaltoken1624 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_normaltoken1635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_decoratedtoken1668 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_decoratedtoken1677 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_decoratedtoken1691 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_decoratedtoken1706 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_decoratedtoken1721 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTED_36_36_in_decoratedtoken1733 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_decoratedtoken1747 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_decoratedtoken1762 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_decoratedtoken1777 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_decoratedtoken1797 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_decoratedtoken1807 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_decoratedtoken1818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_predefinedtoken1851 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_predefinedtoken1860 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_predefinedtoken1879 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_predefinedtoken1889 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_predefinedtoken1900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_keywordabstract1933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normaltoken_in_tokendefinition1952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decoratedtoken_in_tokendefinition1962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predefinedtoken_in_tokendefinition1972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_csstring_in_definition1991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definedplaceholder_in_definition2001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_derivedplaceholder_in_definition2011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_containment_in_definition2021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compounddefinition_in_definition2031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whitespaces_in_definition2041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_linebreak_in_definition2051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_plus_in_cardinality2070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_star_in_cardinality2080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_questionmark_in_cardinality2090 = new BitSet(new long[]{0x0000000000000002L});

}