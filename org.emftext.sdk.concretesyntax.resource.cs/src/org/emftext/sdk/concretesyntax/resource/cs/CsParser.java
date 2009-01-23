// $ANTLR 3.1.1 D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g 2009-01-23 00:52:15

package org.emftext.sdk.concretesyntax.resource.cs;

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
             
        }
        

    public String[] getTokenNames() { return CsParser.tokenNames; }
    public String getGrammarFileName() { return "D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g"; }


    	private org.emftext.runtime.resource.ITokenResolverFactory tokenResolverFactory = new CsTokenResolverFactory();
    	private int lastPosition;

    	protected EObject doParse() throws RecognitionException {
    	lastPosition = 0;
    		((CsLexer)getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((CsLexer)getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		return start();
    	}

    	@SuppressWarnings("unchecked")
    	private boolean addObjectToList(org.eclipse.emf.ecore.EObject element, java.lang.String featureName, java.lang.Object proxy) {
    		return ((java.util.List<java.lang.Object>) element.eGet(element.eClass().getEStructuralFeature(featureName))).add(proxy);
    	}

    	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element, Object o) throws org.emftext.runtime.resource.impl.TokenConversionException {
    		int currentPos = getTokenStream().index();
    		int endPos = currentPos - 1;
    		for (; endPos >= lastPosition; endPos--) {
    			org.antlr.runtime.Token token = getTokenStream().get(endPos);
    			int _channel = token.getChannel();
    			if (_channel != 99) {
    				break;
    			}
    		}
    		for (int pos = lastPosition; pos < endPos; pos++) {
    			org.antlr.runtime.Token token = getTokenStream().get(pos);
    			int _channel = token.getChannel();
    			if (_channel == 99) {
    			}
    		}
    		lastPosition = endPos;
    	}



    // $ANTLR start "start"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:66:1: start returns [ EObject element = null] : (c0= concretesyntax ) EOF ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;

        org.emftext.sdk.concretesyntax.ConcreteSyntax c0 = null;


        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:68:1: ( (c0= concretesyntax ) EOF )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:69:2: (c0= concretesyntax ) EOF
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:69:2: (c0= concretesyntax )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:70:1: c0= concretesyntax
            {
            pushFollow(FOLLOW_concretesyntax_in_start68);
            c0=concretesyntax();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
               element = c0; 
            }

            }

            match(input,EOF,FOLLOW_EOF_in_start75); if (state.failed) return element;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return element;
    }
    // $ANTLR end "start"


    // $ANTLR start "concretesyntax"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:76:1: concretesyntax returns [org.emftext.sdk.concretesyntax.ConcreteSyntax element = null] : a0= 'SYNTAXDEF' a1= QUALIFIED_NAME a2= 'FOR' a3= QUOTED_60_62 a4= 'START' (a5= QUALIFIED_NAME ) ( (a6= ',' (a7= QUALIFIED_NAME ) ) )* ( (a8= 'IMPORTS' a9= '{' ( (a10= keywordimport ) )* a11= '}' ) )? ( (a12= 'OPTIONS' a13= '{' ( (a14= option a15= ';' ) )* a16= '}' ) )? ( (a17= 'TOKENS' a18= '{' ( (a19= tokendefinition a20= ';' ) )* a21= '}' ) )? a22= 'RULES' a23= '{' ( (a24= rule )+ ) a25= '}' ;
    public final org.emftext.sdk.concretesyntax.ConcreteSyntax concretesyntax() throws RecognitionException {
        org.emftext.sdk.concretesyntax.ConcreteSyntax element =  null;

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
        Token a11=null;
        Token a12=null;
        Token a13=null;
        Token a15=null;
        Token a16=null;
        Token a17=null;
        Token a18=null;
        Token a20=null;
        Token a21=null;
        Token a22=null;
        Token a23=null;
        Token a25=null;
        org.emftext.sdk.concretesyntax.Import a10 = null;

        org.emftext.sdk.concretesyntax.Option a14 = null;

        org.emftext.sdk.concretesyntax.TokenDefinition a19 = null;

        org.emftext.sdk.concretesyntax.Rule a24 = null;




        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:79:1: (a0= 'SYNTAXDEF' a1= QUALIFIED_NAME a2= 'FOR' a3= QUOTED_60_62 a4= 'START' (a5= QUALIFIED_NAME ) ( (a6= ',' (a7= QUALIFIED_NAME ) ) )* ( (a8= 'IMPORTS' a9= '{' ( (a10= keywordimport ) )* a11= '}' ) )? ( (a12= 'OPTIONS' a13= '{' ( (a14= option a15= ';' ) )* a16= '}' ) )? ( (a17= 'TOKENS' a18= '{' ( (a19= tokendefinition a20= ';' ) )* a21= '}' ) )? a22= 'RULES' a23= '{' ( (a24= rule )+ ) a25= '}' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:80:2: a0= 'SYNTAXDEF' a1= QUALIFIED_NAME a2= 'FOR' a3= QUOTED_60_62 a4= 'START' (a5= QUALIFIED_NAME ) ( (a6= ',' (a7= QUALIFIED_NAME ) ) )* ( (a8= 'IMPORTS' a9= '{' ( (a10= keywordimport ) )* a11= '}' ) )? ( (a12= 'OPTIONS' a13= '{' ( (a14= option a15= ';' ) )* a16= '}' ) )? ( (a17= 'TOKENS' a18= '{' ( (a19= tokendefinition a20= ';' ) )* a21= '}' ) )? a22= 'RULES' a23= '{' ( (a24= rule )+ ) a25= '}'
            {
            a0=(Token)match(input,13,FOLLOW_13_in_concretesyntax98); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_concretesyntax106); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a1, element); 
            }
            a2=(Token)match(input,14,FOLLOW_14_in_concretesyntax114); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a2);copyLocalizationInfos((CommonToken)a2, element); 
            }
            a3=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_concretesyntax122); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("package"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a3,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenPackage proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenPackage();collectHiddenTokens(element, proxy); getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature("package"), resolved, proxy);element.eSet(element.eClass().getEStructuralFeature("package"), proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a3, element); copyLocalizationInfos((CommonToken) a3, proxy); 
            }
            a4=(Token)match(input,15,FOLLOW_15_in_concretesyntax130); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a4);copyLocalizationInfos((CommonToken)a4, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:85:2: (a5= QUALIFIED_NAME )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:86:3: a5= QUALIFIED_NAME
            {
            a5=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_concretesyntax142); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a5,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();collectHiddenTokens(element, proxy); getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature("startSymbols"), resolved, proxy);addObjectToList(element, "startSymbols", proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a5, element); copyLocalizationInfos((CommonToken) a5, proxy); 
            }

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:88:2: ( (a6= ',' (a7= QUALIFIED_NAME ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==16) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:89:3: (a6= ',' (a7= QUALIFIED_NAME ) )
            	    {
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:89:3: (a6= ',' (a7= QUALIFIED_NAME ) )
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:90:4: a6= ',' (a7= QUALIFIED_NAME )
            	    {
            	    a6=(Token)match(input,16,FOLLOW_16_in_concretesyntax162); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {
            	       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a6);copyLocalizationInfos((CommonToken)a6, element); 
            	    }
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:91:4: (a7= QUALIFIED_NAME )
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:92:5: a7= QUALIFIED_NAME
            	    {
            	    a7=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_concretesyntax178); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {
            	      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a7.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a7,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();collectHiddenTokens(element, proxy); getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature("startSymbols"), resolved, proxy);addObjectToList(element, "startSymbols", proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a7, element); copyLocalizationInfos((CommonToken) a7, proxy); 
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:96:2: ( (a8= 'IMPORTS' a9= '{' ( (a10= keywordimport ) )* a11= '}' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==17) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:97:3: (a8= 'IMPORTS' a9= '{' ( (a10= keywordimport ) )* a11= '}' )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:97:3: (a8= 'IMPORTS' a9= '{' ( (a10= keywordimport ) )* a11= '}' )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:98:4: a8= 'IMPORTS' a9= '{' ( (a10= keywordimport ) )* a11= '}'
                    {
                    a8=(Token)match(input,17,FOLLOW_17_in_concretesyntax208); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a8);copyLocalizationInfos((CommonToken)a8, element); 
                    }
                    a9=(Token)match(input,18,FOLLOW_18_in_concretesyntax218); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a9);copyLocalizationInfos((CommonToken)a9, element); 
                    }
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:100:4: ( (a10= keywordimport ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==QUALIFIED_NAME) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:101:5: (a10= keywordimport )
                    	    {
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:101:5: (a10= keywordimport )
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:102:6: a10= keywordimport
                    	    {
                    	    pushFollow(FOLLOW_keywordimport_in_concretesyntax241);
                    	    a10=keywordimport();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); addObjectToList(element, "imports", a10); collectHiddenTokens(element, a10);copyLocalizationInfos(a10, element); 
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    a11=(Token)match(input,19,FOLLOW_19_in_concretesyntax263); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a11);copyLocalizationInfos((CommonToken)a11, element); 
                    }

                    }


                    }
                    break;

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:108:2: ( (a12= 'OPTIONS' a13= '{' ( (a14= option a15= ';' ) )* a16= '}' ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==20) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:109:3: (a12= 'OPTIONS' a13= '{' ( (a14= option a15= ';' ) )* a16= '}' )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:109:3: (a12= 'OPTIONS' a13= '{' ( (a14= option a15= ';' ) )* a16= '}' )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:110:4: a12= 'OPTIONS' a13= '{' ( (a14= option a15= ';' ) )* a16= '}'
                    {
                    a12=(Token)match(input,20,FOLLOW_20_in_concretesyntax288); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a12);copyLocalizationInfos((CommonToken)a12, element); 
                    }
                    a13=(Token)match(input,18,FOLLOW_18_in_concretesyntax298); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a13);copyLocalizationInfos((CommonToken)a13, element); 
                    }
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:112:4: ( (a14= option a15= ';' ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==QUALIFIED_NAME) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:113:5: (a14= option a15= ';' )
                    	    {
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:113:5: (a14= option a15= ';' )
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:114:6: a14= option a15= ';'
                    	    {
                    	    pushFollow(FOLLOW_option_in_concretesyntax321);
                    	    a14=option();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); addObjectToList(element, "options", a14); collectHiddenTokens(element, a14);copyLocalizationInfos(a14, element); 
                    	    }
                    	    a15=(Token)match(input,21,FOLLOW_21_in_concretesyntax333); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a15);copyLocalizationInfos((CommonToken)a15, element); 
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    a16=(Token)match(input,19,FOLLOW_19_in_concretesyntax355); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a16);copyLocalizationInfos((CommonToken)a16, element); 
                    }

                    }


                    }
                    break;

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:121:2: ( (a17= 'TOKENS' a18= '{' ( (a19= tokendefinition a20= ';' ) )* a21= '}' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==22) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:122:3: (a17= 'TOKENS' a18= '{' ( (a19= tokendefinition a20= ';' ) )* a21= '}' )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:122:3: (a17= 'TOKENS' a18= '{' ( (a19= tokendefinition a20= ';' ) )* a21= '}' )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:123:4: a17= 'TOKENS' a18= '{' ( (a19= tokendefinition a20= ';' ) )* a21= '}'
                    {
                    a17=(Token)match(input,22,FOLLOW_22_in_concretesyntax380); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a17);copyLocalizationInfos((CommonToken)a17, element); 
                    }
                    a18=(Token)match(input,18,FOLLOW_18_in_concretesyntax390); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a18);copyLocalizationInfos((CommonToken)a18, element); 
                    }
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:125:4: ( (a19= tokendefinition a20= ';' ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==39||LA6_0==42) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:126:5: (a19= tokendefinition a20= ';' )
                    	    {
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:126:5: (a19= tokendefinition a20= ';' )
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:127:6: a19= tokendefinition a20= ';'
                    	    {
                    	    pushFollow(FOLLOW_tokendefinition_in_concretesyntax413);
                    	    a19=tokendefinition();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); addObjectToList(element, "tokens", a19); collectHiddenTokens(element, a19);copyLocalizationInfos(a19, element); 
                    	    }
                    	    a20=(Token)match(input,21,FOLLOW_21_in_concretesyntax425); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a20);copyLocalizationInfos((CommonToken)a20, element); 
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    a21=(Token)match(input,19,FOLLOW_19_in_concretesyntax447); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a21);copyLocalizationInfos((CommonToken)a21, element); 
                    }

                    }


                    }
                    break;

            }

            a22=(Token)match(input,23,FOLLOW_23_in_concretesyntax463); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a22);copyLocalizationInfos((CommonToken)a22, element); 
            }
            a23=(Token)match(input,18,FOLLOW_18_in_concretesyntax471); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a23);copyLocalizationInfos((CommonToken)a23, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:136:2: ( (a24= rule )+ )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:137:3: (a24= rule )+
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:137:3: (a24= rule )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==QUALIFIED_NAME) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:138:4: a24= rule
            	    {
            	    pushFollow(FOLLOW_rule_in_concretesyntax488);
            	    a24=rule();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {
            	      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); addObjectToList(element, "rules", a24); collectHiddenTokens(element, a24);copyLocalizationInfos(a24, element); 
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }

            a25=(Token)match(input,19,FOLLOW_19_in_concretesyntax504); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a25);copyLocalizationInfos((CommonToken)a25, element); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return element;
    }
    // $ANTLR end "concretesyntax"


    // $ANTLR start "keywordimport"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:144:1: keywordimport returns [org.emftext.sdk.concretesyntax.Import element = null] : a0= QUALIFIED_NAME a1= ':' a2= QUOTED_60_62 ( (a3= 'WITH' a4= 'SYNTAX' a5= QUALIFIED_NAME ) )? ;
    public final org.emftext.sdk.concretesyntax.Import keywordimport() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Import element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;



        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:147:1: (a0= QUALIFIED_NAME a1= ':' a2= QUOTED_60_62 ( (a3= 'WITH' a4= 'SYNTAX' a5= QUALIFIED_NAME ) )? )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:148:2: a0= QUALIFIED_NAME a1= ':' a2= QUOTED_60_62 ( (a3= 'WITH' a4= 'SYNTAX' a5= QUALIFIED_NAME ) )?
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_keywordimport527); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("prefix"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("prefix"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a0, element); 
            }
            a1=(Token)match(input,24,FOLLOW_24_in_keywordimport535); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            }
            a2=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_keywordimport543); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("package"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a2,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenPackage proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenPackage();collectHiddenTokens(element, proxy); getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature("package"), resolved, proxy);element.eSet(element.eClass().getEStructuralFeature("package"), proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a2, element); copyLocalizationInfos((CommonToken) a2, proxy); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:151:2: ( (a3= 'WITH' a4= 'SYNTAX' a5= QUALIFIED_NAME ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==25) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:152:3: (a3= 'WITH' a4= 'SYNTAX' a5= QUALIFIED_NAME )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:152:3: (a3= 'WITH' a4= 'SYNTAX' a5= QUALIFIED_NAME )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:153:4: a3= 'WITH' a4= 'SYNTAX' a5= QUALIFIED_NAME
                    {
                    a3=(Token)match(input,25,FOLLOW_25_in_keywordimport560); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); 
                    }
                    a4=(Token)match(input,26,FOLLOW_26_in_keywordimport570); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport();} collectHiddenTokens(element, (CommonToken)a4);copyLocalizationInfos((CommonToken)a4, element); 
                    }
                    a5=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_keywordimport580); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("concreteSyntax"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a5,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.emftext.sdk.concretesyntax.ConcreteSyntax proxy = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();collectHiddenTokens(element, proxy); getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature("concreteSyntax"), resolved, proxy);element.eSet(element.eClass().getEStructuralFeature("concreteSyntax"), proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a5, element); copyLocalizationInfos((CommonToken) a5, proxy); 
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
        }
        return element;
    }
    // $ANTLR end "keywordimport"


    // $ANTLR start "option"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:160:1: option returns [org.emftext.sdk.concretesyntax.Option element = null] : a0= QUALIFIED_NAME a1= '=' a2= QUOTED_34_34 ;
    public final org.emftext.sdk.concretesyntax.Option option() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Option element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:163:1: (a0= QUALIFIED_NAME a1= '=' a2= QUOTED_34_34 )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:164:2: a0= QUALIFIED_NAME a1= '=' a2= QUOTED_34_34
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_option611); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createOption(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a0, element); 
            }
            a1=(Token)match(input,27,FOLLOW_27_in_option619); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createOption();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            }
            a2=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_option627); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createOption(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("value"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a2, element); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return element;
    }
    // $ANTLR end "option"


    // $ANTLR start "rule"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:169:1: rule returns [org.emftext.sdk.concretesyntax.Rule element = null] : (a0= QUALIFIED_NAME ) a1= '::=' a2= choice a3= ';' ;
    public final org.emftext.sdk.concretesyntax.Rule rule() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Rule element =  null;

        Token a0=null;
        Token a1=null;
        Token a3=null;
        org.emftext.sdk.concretesyntax.Choice a2 = null;




        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:172:1: ( (a0= QUALIFIED_NAME ) a1= '::=' a2= choice a3= ';' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:173:2: (a0= QUALIFIED_NAME ) a1= '::=' a2= choice a3= ';'
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:173:2: (a0= QUALIFIED_NAME )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:174:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_rule654); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createRule(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("metaclass"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();collectHiddenTokens(element, proxy); getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature("metaclass"), resolved, proxy);element.eSet(element.eClass().getEStructuralFeature("metaclass"), proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); 
            }

            }

            a1=(Token)match(input,28,FOLLOW_28_in_rule665); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createRule();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            }
            pushFollow(FOLLOW_choice_in_rule673);
            a2=choice();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createRule(); element.eSet(element.eClass().getEStructuralFeature("definition"), a2); collectHiddenTokens(element, a2);copyLocalizationInfos(a2, element); 
            }
            a3=(Token)match(input,21,FOLLOW_21_in_rule681); if (state.failed) return element;
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
        }
        return element;
    }
    // $ANTLR end "rule"


    // $ANTLR start "sequence"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:181:1: sequence returns [org.emftext.sdk.concretesyntax.Sequence element = null] : (a0= definition )+ ;
    public final org.emftext.sdk.concretesyntax.Sequence sequence() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Sequence element =  null;

        org.emftext.sdk.concretesyntax.Definition a0 = null;




        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:184:1: ( (a0= definition )+ )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:185:2: (a0= definition )+
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:185:2: (a0= definition )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==QUALIFIED_NAME||LA10_0==QUOTED_34_34||LA10_0==32||(LA10_0>=37 && LA10_0<=38)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:186:3: a0= definition
            	    {
            	    pushFollow(FOLLOW_definition_in_sequence708);
            	    a0=definition();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {
            	      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createSequence(); addObjectToList(element, "parts", a0); collectHiddenTokens(element, a0);copyLocalizationInfos(a0, element); 
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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return element;
    }
    // $ANTLR end "sequence"


    // $ANTLR start "choice"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:190:1: choice returns [org.emftext.sdk.concretesyntax.Choice element = null] : a0= sequence ( (a1= '|' a2= sequence ) )* ;
    public final org.emftext.sdk.concretesyntax.Choice choice() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Choice element =  null;

        Token a1=null;
        org.emftext.sdk.concretesyntax.Sequence a0 = null;

        org.emftext.sdk.concretesyntax.Sequence a2 = null;




        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:193:1: (a0= sequence ( (a1= '|' a2= sequence ) )* )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:194:2: a0= sequence ( (a1= '|' a2= sequence ) )*
            {
            pushFollow(FOLLOW_sequence_in_choice735);
            a0=sequence();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createChoice(); addObjectToList(element, "options", a0); collectHiddenTokens(element, a0);copyLocalizationInfos(a0, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:195:2: ( (a1= '|' a2= sequence ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==29) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:196:3: (a1= '|' a2= sequence )
            	    {
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:196:3: (a1= '|' a2= sequence )
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:197:4: a1= '|' a2= sequence
            	    {
            	    a1=(Token)match(input,29,FOLLOW_29_in_choice752); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {
            	       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createChoice();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            	    }
            	    pushFollow(FOLLOW_sequence_in_choice762);
            	    a2=sequence();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {
            	      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createChoice(); addObjectToList(element, "options", a2); collectHiddenTokens(element, a2);copyLocalizationInfos(a2, element); 
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return element;
    }
    // $ANTLR end "choice"


    // $ANTLR start "csstring"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:203:1: csstring returns [org.emftext.sdk.concretesyntax.CsString element = null] : a0= QUOTED_34_34 ;
    public final org.emftext.sdk.concretesyntax.CsString csstring() throws RecognitionException {
        org.emftext.sdk.concretesyntax.CsString element =  null;

        Token a0=null;



        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:206:1: (a0= QUOTED_34_34 )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:207:2: a0= QUOTED_34_34
            {
            a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_csstring793); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createCsString(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("value"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a0, element); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return element;
    }
    // $ANTLR end "csstring"


    // $ANTLR start "definedplaceholder"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:210:1: definedplaceholder returns [org.emftext.sdk.concretesyntax.DefinedPlaceholder element = null] : a0= QUALIFIED_NAME a1= '[' a2= QUALIFIED_NAME a3= ']' (a4= cardinality )? ;
    public final org.emftext.sdk.concretesyntax.DefinedPlaceholder definedplaceholder() throws RecognitionException {
        org.emftext.sdk.concretesyntax.DefinedPlaceholder element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        org.emftext.sdk.concretesyntax.Cardinality a4 = null;




        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:213:1: (a0= QUALIFIED_NAME a1= '[' a2= QUALIFIED_NAME a3= ']' (a4= cardinality )? )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:214:2: a0= QUALIFIED_NAME a1= '[' a2= QUALIFIED_NAME a3= ']' (a4= cardinality )?
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_definedplaceholder816); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDefinedPlaceholder(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenFeature();collectHiddenTokens(element, proxy); getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature("feature"), resolved, proxy);element.eSet(element.eClass().getEStructuralFeature("feature"), proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); 
            }
            a1=(Token)match(input,30,FOLLOW_30_in_definedplaceholder824); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDefinedPlaceholder();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            }
            a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_definedplaceholder832); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDefinedPlaceholder(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("token"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a2,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.emftext.sdk.concretesyntax.NormalToken proxy = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken();collectHiddenTokens(element, proxy); getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature("token"), resolved, proxy);element.eSet(element.eClass().getEStructuralFeature("token"), proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a2, element); copyLocalizationInfos((CommonToken) a2, proxy); 
            }
            a3=(Token)match(input,31,FOLLOW_31_in_definedplaceholder840); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDefinedPlaceholder();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:218:2: (a4= cardinality )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=34 && LA12_0<=36)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:219:3: a4= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_definedplaceholder852);
                    a4=cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDefinedPlaceholder(); element.eSet(element.eClass().getEStructuralFeature("cardinality"), a4); collectHiddenTokens(element, a4);copyLocalizationInfos(a4, element); 
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
        }
        return element;
    }
    // $ANTLR end "definedplaceholder"


    // $ANTLR start "derivedplaceholder"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:223:1: derivedplaceholder returns [org.emftext.sdk.concretesyntax.DerivedPlaceholder element = null] : a0= QUALIFIED_NAME a1= '[' ( (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? ) )? a5= ']' (a6= cardinality )? ;
    public final org.emftext.sdk.concretesyntax.DerivedPlaceholder derivedplaceholder() throws RecognitionException {
        org.emftext.sdk.concretesyntax.DerivedPlaceholder element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        org.emftext.sdk.concretesyntax.Cardinality a6 = null;




        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:226:1: (a0= QUALIFIED_NAME a1= '[' ( (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? ) )? a5= ']' (a6= cardinality )? )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:227:2: a0= QUALIFIED_NAME a1= '[' ( (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? ) )? a5= ']' (a6= cardinality )?
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_derivedplaceholder879); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenFeature();collectHiddenTokens(element, proxy); getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature("feature"), resolved, proxy);element.eSet(element.eClass().getEStructuralFeature("feature"), proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); 
            }
            a1=(Token)match(input,30,FOLLOW_30_in_derivedplaceholder887); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:229:2: ( (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==QUOTED_39_39) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:230:3: (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:230:3: (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:231:4: a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )?
                    {
                    a2=(Token)match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_derivedplaceholder904); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("prefix"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("prefix"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a2, element); 
                    }
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:232:4: ( (a3= ',' a4= QUOTED_39_39 ) )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==16) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:233:5: (a3= ',' a4= QUOTED_39_39 )
                            {
                            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:233:5: (a3= ',' a4= QUOTED_39_39 )
                            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:234:6: a3= ',' a4= QUOTED_39_39
                            {
                            a3=(Token)match(input,16,FOLLOW_16_in_derivedplaceholder927); if (state.failed) return element;
                            if ( state.backtracking==0 ) {
                               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); 
                            }
                            a4=(Token)match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_derivedplaceholder939); if (state.failed) return element;
                            if ( state.backtracking==0 ) {
                              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("suffix"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suffix"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a4, element); 
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            a5=(Token)match(input,31,FOLLOW_31_in_derivedplaceholder967); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder();} collectHiddenTokens(element, (CommonToken)a5);copyLocalizationInfos((CommonToken)a5, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:241:2: (a6= cardinality )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=34 && LA15_0<=36)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:242:3: a6= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_derivedplaceholder979);
                    a6=cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder(); element.eSet(element.eClass().getEStructuralFeature("cardinality"), a6); collectHiddenTokens(element, a6);copyLocalizationInfos(a6, element); 
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
        }
        return element;
    }
    // $ANTLR end "derivedplaceholder"


    // $ANTLR start "containment"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:246:1: containment returns [org.emftext.sdk.concretesyntax.Containment element = null] : a0= QUALIFIED_NAME ( (a1= ':' a2= QUALIFIED_NAME ) )? (a3= cardinality )? ;
    public final org.emftext.sdk.concretesyntax.Containment containment() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Containment element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        org.emftext.sdk.concretesyntax.Cardinality a3 = null;




        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:249:1: (a0= QUALIFIED_NAME ( (a1= ':' a2= QUALIFIED_NAME ) )? (a3= cardinality )? )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:250:2: a0= QUALIFIED_NAME ( (a1= ':' a2= QUALIFIED_NAME ) )? (a3= cardinality )?
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_containment1006); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createContainment(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenFeature();collectHiddenTokens(element, proxy); getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature("feature"), resolved, proxy);element.eSet(element.eClass().getEStructuralFeature("feature"), proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:251:2: ( (a1= ':' a2= QUALIFIED_NAME ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==24) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:252:3: (a1= ':' a2= QUALIFIED_NAME )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:252:3: (a1= ':' a2= QUALIFIED_NAME )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:253:4: a1= ':' a2= QUALIFIED_NAME
                    {
                    a1=(Token)match(input,24,FOLLOW_24_in_containment1023); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createContainment();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
                    }
                    a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_containment1033); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createContainment(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("type"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a2,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();collectHiddenTokens(element, proxy); getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature("type"), resolved, proxy);element.eSet(element.eClass().getEStructuralFeature("type"), proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a2, element); copyLocalizationInfos((CommonToken) a2, proxy); 
                    }

                    }


                    }
                    break;

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:257:2: (a3= cardinality )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=34 && LA17_0<=36)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:258:3: a3= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_containment1053);
                    a3=cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createContainment(); element.eSet(element.eClass().getEStructuralFeature("cardinality"), a3); collectHiddenTokens(element, a3);copyLocalizationInfos(a3, element); 
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
        }
        return element;
    }
    // $ANTLR end "containment"


    // $ANTLR start "compounddefinition"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:262:1: compounddefinition returns [org.emftext.sdk.concretesyntax.CompoundDefinition element = null] : a0= '(' a1= choice a2= ')' (a3= cardinality )? ;
    public final org.emftext.sdk.concretesyntax.CompoundDefinition compounddefinition() throws RecognitionException {
        org.emftext.sdk.concretesyntax.CompoundDefinition element =  null;

        Token a0=null;
        Token a2=null;
        org.emftext.sdk.concretesyntax.Choice a1 = null;

        org.emftext.sdk.concretesyntax.Cardinality a3 = null;




        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:265:1: (a0= '(' a1= choice a2= ')' (a3= cardinality )? )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:266:2: a0= '(' a1= choice a2= ')' (a3= cardinality )?
            {
            a0=(Token)match(input,32,FOLLOW_32_in_compounddefinition1080); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createCompoundDefinition();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            pushFollow(FOLLOW_choice_in_compounddefinition1088);
            a1=choice();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createCompoundDefinition(); element.eSet(element.eClass().getEStructuralFeature("definitions"), a1); collectHiddenTokens(element, a1);copyLocalizationInfos(a1, element); 
            }
            a2=(Token)match(input,33,FOLLOW_33_in_compounddefinition1096); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createCompoundDefinition();} collectHiddenTokens(element, (CommonToken)a2);copyLocalizationInfos((CommonToken)a2, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:269:2: (a3= cardinality )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=34 && LA18_0<=36)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:270:3: a3= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_compounddefinition1108);
                    a3=cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createCompoundDefinition(); element.eSet(element.eClass().getEStructuralFeature("cardinality"), a3); collectHiddenTokens(element, a3);copyLocalizationInfos(a3, element); 
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
        }
        return element;
    }
    // $ANTLR end "compounddefinition"


    // $ANTLR start "plus"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:274:1: plus returns [org.emftext.sdk.concretesyntax.PLUS element = null] : a0= '+' ;
    public final org.emftext.sdk.concretesyntax.PLUS plus() throws RecognitionException {
        org.emftext.sdk.concretesyntax.PLUS element =  null;

        Token a0=null;



        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:277:1: (a0= '+' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:278:2: a0= '+'
            {
            a0=(Token)match(input,34,FOLLOW_34_in_plus1135); if (state.failed) return element;
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
        }
        return element;
    }
    // $ANTLR end "plus"


    // $ANTLR start "star"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:281:1: star returns [org.emftext.sdk.concretesyntax.STAR element = null] : a0= '*' ;
    public final org.emftext.sdk.concretesyntax.STAR star() throws RecognitionException {
        org.emftext.sdk.concretesyntax.STAR element =  null;

        Token a0=null;



        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:284:1: (a0= '*' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:285:2: a0= '*'
            {
            a0=(Token)match(input,35,FOLLOW_35_in_star1158); if (state.failed) return element;
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
        }
        return element;
    }
    // $ANTLR end "star"


    // $ANTLR start "questionmark"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:288:1: questionmark returns [org.emftext.sdk.concretesyntax.QUESTIONMARK element = null] : a0= '?' ;
    public final org.emftext.sdk.concretesyntax.QUESTIONMARK questionmark() throws RecognitionException {
        org.emftext.sdk.concretesyntax.QUESTIONMARK element =  null;

        Token a0=null;



        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:291:1: (a0= '?' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:292:2: a0= '?'
            {
            a0=(Token)match(input,36,FOLLOW_36_in_questionmark1181); if (state.failed) return element;
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
        }
        return element;
    }
    // $ANTLR end "questionmark"


    // $ANTLR start "whitespaces"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:295:1: whitespaces returns [org.emftext.sdk.concretesyntax.WhiteSpaces element = null] : a0= '#' a1= NUMBER ;
    public final org.emftext.sdk.concretesyntax.WhiteSpaces whitespaces() throws RecognitionException {
        org.emftext.sdk.concretesyntax.WhiteSpaces element =  null;

        Token a0=null;
        Token a1=null;



        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:298:1: (a0= '#' a1= NUMBER )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:299:2: a0= '#' a1= NUMBER
            {
            a0=(Token)match(input,37,FOLLOW_37_in_whitespaces1204); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createWhiteSpaces();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_whitespaces1212); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createWhiteSpaces(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("NUMBER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("amount"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.Integer resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("amount"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a1, element); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return element;
    }
    // $ANTLR end "whitespaces"


    // $ANTLR start "linebreak"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:303:1: linebreak returns [org.emftext.sdk.concretesyntax.LineBreak element = null] : a0= '!' a1= NUMBER ;
    public final org.emftext.sdk.concretesyntax.LineBreak linebreak() throws RecognitionException {
        org.emftext.sdk.concretesyntax.LineBreak element =  null;

        Token a0=null;
        Token a1=null;



        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:306:1: (a0= '!' a1= NUMBER )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:307:2: a0= '!' a1= NUMBER
            {
            a0=(Token)match(input,38,FOLLOW_38_in_linebreak1235); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createLineBreak();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_linebreak1243); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createLineBreak(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("NUMBER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("tab"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.Integer resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("tab"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a1, element); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return element;
    }
    // $ANTLR end "linebreak"


    // $ANTLR start "normaltoken"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:311:1: normaltoken returns [org.emftext.sdk.concretesyntax.NormalToken element = null] : a0= 'DEFINE' a1= QUALIFIED_NAME a2= QUOTED_36_36 ( (a3= 'COLLECT' a4= 'IN' a5= QUALIFIED_NAME ) )? ;
    public final org.emftext.sdk.concretesyntax.NormalToken normaltoken() throws RecognitionException {
        org.emftext.sdk.concretesyntax.NormalToken element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;



        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:314:1: (a0= 'DEFINE' a1= QUALIFIED_NAME a2= QUOTED_36_36 ( (a3= 'COLLECT' a4= 'IN' a5= QUALIFIED_NAME ) )? )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:315:2: a0= 'DEFINE' a1= QUALIFIED_NAME a2= QUOTED_36_36 ( (a3= 'COLLECT' a4= 'IN' a5= QUALIFIED_NAME ) )?
            {
            a0=(Token)match(input,39,FOLLOW_39_in_normaltoken1266); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_normaltoken1274); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a1, element); 
            }
            a2=(Token)match(input,QUOTED_36_36,FOLLOW_QUOTED_36_36_in_normaltoken1282); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_36_36");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("regex"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("regex"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a2, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:318:2: ( (a3= 'COLLECT' a4= 'IN' a5= QUALIFIED_NAME ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==40) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:319:3: (a3= 'COLLECT' a4= 'IN' a5= QUALIFIED_NAME )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:319:3: (a3= 'COLLECT' a4= 'IN' a5= QUALIFIED_NAME )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:320:4: a3= 'COLLECT' a4= 'IN' a5= QUALIFIED_NAME
                    {
                    a3=(Token)match(input,40,FOLLOW_40_in_normaltoken1299); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); 
                    }
                    a4=(Token)match(input,41,FOLLOW_41_in_normaltoken1309); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken();} collectHiddenTokens(element, (CommonToken)a4);copyLocalizationInfos((CommonToken)a4, element); 
                    }
                    a5=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_normaltoken1319); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("attributeName"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("attributeName"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a5, element); 
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
        }
        return element;
    }
    // $ANTLR end "normaltoken"


    // $ANTLR start "decoratedtoken"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:327:1: decoratedtoken returns [org.emftext.sdk.concretesyntax.DecoratedToken element = null] : a0= 'DEFINE' a1= QUALIFIED_NAME (a2= '[' (a3= QUOTED_39_39 ) a4= ']' ) a5= QUOTED_36_36 (a6= '[' (a7= QUOTED_39_39 ) a8= ']' ) ( (a9= 'COLLECT' a10= 'IN' a11= QUALIFIED_NAME ) )? ;
    public final org.emftext.sdk.concretesyntax.DecoratedToken decoratedtoken() throws RecognitionException {
        org.emftext.sdk.concretesyntax.DecoratedToken element =  null;

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
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:330:1: (a0= 'DEFINE' a1= QUALIFIED_NAME (a2= '[' (a3= QUOTED_39_39 ) a4= ']' ) a5= QUOTED_36_36 (a6= '[' (a7= QUOTED_39_39 ) a8= ']' ) ( (a9= 'COLLECT' a10= 'IN' a11= QUALIFIED_NAME ) )? )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:331:2: a0= 'DEFINE' a1= QUALIFIED_NAME (a2= '[' (a3= QUOTED_39_39 ) a4= ']' ) a5= QUOTED_36_36 (a6= '[' (a7= QUOTED_39_39 ) a8= ']' ) ( (a9= 'COLLECT' a10= 'IN' a11= QUALIFIED_NAME ) )?
            {
            a0=(Token)match(input,39,FOLLOW_39_in_decoratedtoken1350); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_decoratedtoken1358); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a1, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:333:2: (a2= '[' (a3= QUOTED_39_39 ) a4= ']' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:334:3: a2= '[' (a3= QUOTED_39_39 ) a4= ']'
            {
            a2=(Token)match(input,30,FOLLOW_30_in_decoratedtoken1370); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a2);copyLocalizationInfos((CommonToken)a2, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:335:3: (a3= QUOTED_39_39 )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:336:4: a3= QUOTED_39_39
            {
            a3=(Token)match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_decoratedtoken1384); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("prefix"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a3,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("prefix"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a3, element); 
            }

            }

            a4=(Token)match(input,31,FOLLOW_31_in_decoratedtoken1397); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a4);copyLocalizationInfos((CommonToken)a4, element); 
            }

            }

            a5=(Token)match(input,QUOTED_36_36,FOLLOW_QUOTED_36_36_in_decoratedtoken1408); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_36_36");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("regex"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("regex"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a5, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:341:2: (a6= '[' (a7= QUOTED_39_39 ) a8= ']' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:342:3: a6= '[' (a7= QUOTED_39_39 ) a8= ']'
            {
            a6=(Token)match(input,30,FOLLOW_30_in_decoratedtoken1420); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a6);copyLocalizationInfos((CommonToken)a6, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:343:3: (a7= QUOTED_39_39 )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:344:4: a7= QUOTED_39_39
            {
            a7=(Token)match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_decoratedtoken1434); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a7.getText(),element.eClass().getEStructuralFeature("suffix"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a7,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suffix"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a7, element); 
            }

            }

            a8=(Token)match(input,31,FOLLOW_31_in_decoratedtoken1447); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a8);copyLocalizationInfos((CommonToken)a8, element); 
            }

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:348:2: ( (a9= 'COLLECT' a10= 'IN' a11= QUALIFIED_NAME ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==40) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:349:3: (a9= 'COLLECT' a10= 'IN' a11= QUALIFIED_NAME )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:349:3: (a9= 'COLLECT' a10= 'IN' a11= QUALIFIED_NAME )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:350:4: a9= 'COLLECT' a10= 'IN' a11= QUALIFIED_NAME
                    {
                    a9=(Token)match(input,40,FOLLOW_40_in_decoratedtoken1467); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a9);copyLocalizationInfos((CommonToken)a9, element); 
                    }
                    a10=(Token)match(input,41,FOLLOW_41_in_decoratedtoken1477); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a10);copyLocalizationInfos((CommonToken)a10, element); 
                    }
                    a11=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_decoratedtoken1487); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a11.getText(),element.eClass().getEStructuralFeature("attributeName"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a11,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("attributeName"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a11, element); 
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
        }
        return element;
    }
    // $ANTLR end "decoratedtoken"


    // $ANTLR start "predefinedtoken"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:357:1: predefinedtoken returns [org.emftext.sdk.concretesyntax.PreDefinedToken element = null] : a0= 'PREDEFINED' a1= QUALIFIED_NAME ( (a2= 'COLLECT' a3= 'IN' a4= QUALIFIED_NAME ) )? ;
    public final org.emftext.sdk.concretesyntax.PreDefinedToken predefinedtoken() throws RecognitionException {
        org.emftext.sdk.concretesyntax.PreDefinedToken element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;



        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:360:1: (a0= 'PREDEFINED' a1= QUALIFIED_NAME ( (a2= 'COLLECT' a3= 'IN' a4= QUALIFIED_NAME ) )? )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:361:2: a0= 'PREDEFINED' a1= QUALIFIED_NAME ( (a2= 'COLLECT' a3= 'IN' a4= QUALIFIED_NAME ) )?
            {
            a0=(Token)match(input,42,FOLLOW_42_in_predefinedtoken1518); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_predefinedtoken1526); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a1, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:363:2: ( (a2= 'COLLECT' a3= 'IN' a4= QUALIFIED_NAME ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==40) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:364:3: (a2= 'COLLECT' a3= 'IN' a4= QUALIFIED_NAME )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:364:3: (a2= 'COLLECT' a3= 'IN' a4= QUALIFIED_NAME )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:365:4: a2= 'COLLECT' a3= 'IN' a4= QUALIFIED_NAME
                    {
                    a2=(Token)match(input,40,FOLLOW_40_in_predefinedtoken1543); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken();} collectHiddenTokens(element, (CommonToken)a2);copyLocalizationInfos((CommonToken)a2, element); 
                    }
                    a3=(Token)match(input,41,FOLLOW_41_in_predefinedtoken1553); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); 
                    }
                    a4=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_predefinedtoken1563); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("attributeName"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("attributeName"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a4, element); 
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
        }
        return element;
    }
    // $ANTLR end "predefinedtoken"


    // $ANTLR start "tokendefinition"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:372:1: tokendefinition returns [org.emftext.sdk.concretesyntax.TokenDefinition element = null] : (c0= normaltoken | c1= decoratedtoken | c2= predefinedtoken );
    public final org.emftext.sdk.concretesyntax.TokenDefinition tokendefinition() throws RecognitionException {
        org.emftext.sdk.concretesyntax.TokenDefinition element =  null;

        org.emftext.sdk.concretesyntax.NormalToken c0 = null;

        org.emftext.sdk.concretesyntax.DecoratedToken c1 = null;

        org.emftext.sdk.concretesyntax.PreDefinedToken c2 = null;


        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:374:1: (c0= normaltoken | c1= decoratedtoken | c2= predefinedtoken )
            int alt22=3;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==39) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==QUALIFIED_NAME) ) {
                    int LA22_3 = input.LA(3);

                    if ( (LA22_3==QUOTED_36_36) ) {
                        alt22=1;
                    }
                    else if ( (LA22_3==30) ) {
                        alt22=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 22, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA22_0==42) ) {
                alt22=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:375:2: c0= normaltoken
                    {
                    pushFollow(FOLLOW_normaltoken_in_tokendefinition1590);
                    c0=normaltoken();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:376:2: c1= decoratedtoken
                    {
                    pushFollow(FOLLOW_decoratedtoken_in_tokendefinition1600);
                    c1=decoratedtoken();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:377:2: c2= predefinedtoken
                    {
                    pushFollow(FOLLOW_predefinedtoken_in_tokendefinition1610);
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
        }
        return element;
    }
    // $ANTLR end "tokendefinition"


    // $ANTLR start "definition"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:380:1: definition returns [org.emftext.sdk.concretesyntax.Definition element = null] : (c0= csstring | c1= definedplaceholder | c2= derivedplaceholder | c3= containment | c4= compounddefinition | c5= whitespaces | c6= linebreak );
    public final org.emftext.sdk.concretesyntax.Definition definition() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Definition element =  null;

        org.emftext.sdk.concretesyntax.CsString c0 = null;

        org.emftext.sdk.concretesyntax.DefinedPlaceholder c1 = null;

        org.emftext.sdk.concretesyntax.DerivedPlaceholder c2 = null;

        org.emftext.sdk.concretesyntax.Containment c3 = null;

        org.emftext.sdk.concretesyntax.CompoundDefinition c4 = null;

        org.emftext.sdk.concretesyntax.WhiteSpaces c5 = null;

        org.emftext.sdk.concretesyntax.LineBreak c6 = null;


        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:382:1: (c0= csstring | c1= definedplaceholder | c2= derivedplaceholder | c3= containment | c4= compounddefinition | c5= whitespaces | c6= linebreak )
            int alt23=7;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:383:2: c0= csstring
                    {
                    pushFollow(FOLLOW_csstring_in_definition1629);
                    c0=csstring();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:384:2: c1= definedplaceholder
                    {
                    pushFollow(FOLLOW_definedplaceholder_in_definition1639);
                    c1=definedplaceholder();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:385:2: c2= derivedplaceholder
                    {
                    pushFollow(FOLLOW_derivedplaceholder_in_definition1649);
                    c2=derivedplaceholder();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; 
                    }

                    }
                    break;
                case 4 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:386:2: c3= containment
                    {
                    pushFollow(FOLLOW_containment_in_definition1659);
                    c3=containment();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c3; 
                    }

                    }
                    break;
                case 5 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:387:2: c4= compounddefinition
                    {
                    pushFollow(FOLLOW_compounddefinition_in_definition1669);
                    c4=compounddefinition();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c4; 
                    }

                    }
                    break;
                case 6 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:388:2: c5= whitespaces
                    {
                    pushFollow(FOLLOW_whitespaces_in_definition1679);
                    c5=whitespaces();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c5; 
                    }

                    }
                    break;
                case 7 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:389:2: c6= linebreak
                    {
                    pushFollow(FOLLOW_linebreak_in_definition1689);
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
        }
        return element;
    }
    // $ANTLR end "definition"


    // $ANTLR start "cardinality"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:392:1: cardinality returns [org.emftext.sdk.concretesyntax.Cardinality element = null] : (c0= plus | c1= star | c2= questionmark );
    public final org.emftext.sdk.concretesyntax.Cardinality cardinality() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Cardinality element =  null;

        org.emftext.sdk.concretesyntax.PLUS c0 = null;

        org.emftext.sdk.concretesyntax.STAR c1 = null;

        org.emftext.sdk.concretesyntax.QUESTIONMARK c2 = null;


        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:394:1: (c0= plus | c1= star | c2= questionmark )
            int alt24=3;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt24=1;
                }
                break;
            case 35:
                {
                alt24=2;
                }
                break;
            case 36:
                {
                alt24=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:395:2: c0= plus
                    {
                    pushFollow(FOLLOW_plus_in_cardinality1708);
                    c0=plus();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:396:2: c1= star
                    {
                    pushFollow(FOLLOW_star_in_cardinality1718);
                    c1=star();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:397:2: c2= questionmark
                    {
                    pushFollow(FOLLOW_questionmark_in_cardinality1728);
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
        }
        return element;
    }
    // $ANTLR end "cardinality"

    // Delegated rules


    protected DFA23 dfa23 = new DFA23(this);
    static final String DFA23_eotS =
        "\12\uffff";
    static final String DFA23_eofS =
        "\2\uffff\1\7\7\uffff";
    static final String DFA23_minS =
        "\1\4\1\uffff\1\4\3\uffff\1\4\3\uffff";
    static final String DFA23_maxS =
        "\1\46\1\uffff\1\46\3\uffff\1\37\3\uffff";
    static final String DFA23_acceptS =
        "\1\uffff\1\1\1\uffff\1\5\1\6\1\7\1\uffff\1\4\1\2\1\3";
    static final String DFA23_specialS =
        "\12\uffff}>";
    static final String[] DFA23_transitionS = {
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

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "380:1: definition returns [org.emftext.sdk.concretesyntax.Definition element = null] : (c0= csstring | c1= definedplaceholder | c2= derivedplaceholder | c3= containment | c4= compounddefinition | c5= whitespaces | c6= linebreak );";
        }
    }
 

    public static final BitSet FOLLOW_concretesyntax_in_start68 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start75 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_concretesyntax98 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_concretesyntax106 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_concretesyntax114 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_concretesyntax122 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_concretesyntax130 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_concretesyntax142 = new BitSet(new long[]{0x0000000000D30000L});
    public static final BitSet FOLLOW_16_in_concretesyntax162 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_concretesyntax178 = new BitSet(new long[]{0x0000000000D30000L});
    public static final BitSet FOLLOW_17_in_concretesyntax208 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_concretesyntax218 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_keywordimport_in_concretesyntax241 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_19_in_concretesyntax263 = new BitSet(new long[]{0x0000000000D00000L});
    public static final BitSet FOLLOW_20_in_concretesyntax288 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_concretesyntax298 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_option_in_concretesyntax321 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_concretesyntax333 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_19_in_concretesyntax355 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_22_in_concretesyntax380 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_concretesyntax390 = new BitSet(new long[]{0x0000048000080000L});
    public static final BitSet FOLLOW_tokendefinition_in_concretesyntax413 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_concretesyntax425 = new BitSet(new long[]{0x0000048000080000L});
    public static final BitSet FOLLOW_19_in_concretesyntax447 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_concretesyntax463 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_concretesyntax471 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule_in_concretesyntax488 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_19_in_concretesyntax504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_keywordimport527 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_keywordimport535 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_keywordimport543 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_keywordimport560 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_keywordimport570 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_keywordimport580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_option611 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_option619 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_option627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_rule654 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_rule665 = new BitSet(new long[]{0x0000006100000050L});
    public static final BitSet FOLLOW_choice_in_rule673 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_rule681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definition_in_sequence708 = new BitSet(new long[]{0x0000006100000052L});
    public static final BitSet FOLLOW_sequence_in_choice735 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_choice752 = new BitSet(new long[]{0x0000006100000050L});
    public static final BitSet FOLLOW_sequence_in_choice762 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_csstring793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_definedplaceholder816 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_definedplaceholder824 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_definedplaceholder832 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_definedplaceholder840 = new BitSet(new long[]{0x0000001C00000002L});
    public static final BitSet FOLLOW_cardinality_in_definedplaceholder852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_derivedplaceholder879 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_derivedplaceholder887 = new BitSet(new long[]{0x0000000080000080L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_derivedplaceholder904 = new BitSet(new long[]{0x0000000080010000L});
    public static final BitSet FOLLOW_16_in_derivedplaceholder927 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_derivedplaceholder939 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_derivedplaceholder967 = new BitSet(new long[]{0x0000001C00000002L});
    public static final BitSet FOLLOW_cardinality_in_derivedplaceholder979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_containment1006 = new BitSet(new long[]{0x0000001C01000002L});
    public static final BitSet FOLLOW_24_in_containment1023 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_containment1033 = new BitSet(new long[]{0x0000001C00000002L});
    public static final BitSet FOLLOW_cardinality_in_containment1053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_compounddefinition1080 = new BitSet(new long[]{0x0000006100000050L});
    public static final BitSet FOLLOW_choice_in_compounddefinition1088 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_compounddefinition1096 = new BitSet(new long[]{0x0000001C00000002L});
    public static final BitSet FOLLOW_cardinality_in_compounddefinition1108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_plus1135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_star1158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_questionmark1181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_whitespaces1204 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_NUMBER_in_whitespaces1212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_linebreak1235 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_NUMBER_in_linebreak1243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_normaltoken1266 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_normaltoken1274 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTED_36_36_in_normaltoken1282 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_normaltoken1299 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_normaltoken1309 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_normaltoken1319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_decoratedtoken1350 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_decoratedtoken1358 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_decoratedtoken1370 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_decoratedtoken1384 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_decoratedtoken1397 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTED_36_36_in_decoratedtoken1408 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_decoratedtoken1420 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_decoratedtoken1434 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_decoratedtoken1447 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_decoratedtoken1467 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_decoratedtoken1477 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_decoratedtoken1487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_predefinedtoken1518 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_predefinedtoken1526 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_predefinedtoken1543 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_predefinedtoken1553 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_predefinedtoken1563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normaltoken_in_tokendefinition1590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decoratedtoken_in_tokendefinition1600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predefinedtoken_in_tokendefinition1610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_csstring_in_definition1629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definedplaceholder_in_definition1639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_derivedplaceholder_in_definition1649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_containment_in_definition1659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compounddefinition_in_definition1669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whitespaces_in_definition1679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_linebreak_in_definition1689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_plus_in_cardinality1708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_star_in_cardinality1718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_questionmark_in_cardinality1728 = new BitSet(new long[]{0x0000000000000002L});

}