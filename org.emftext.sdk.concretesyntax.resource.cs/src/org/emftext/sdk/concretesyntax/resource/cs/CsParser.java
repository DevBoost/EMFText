// $ANTLR 3.1.1 D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g 2009-01-14 23:19:11

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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.emftext.runtime.resource.impl.AbstractEMFTextParser;
public class CsParser extends AbstractEMFTextParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "TEXT", "QUOTED_60_62", "QNAME", "QUOTED_34_34", "QUOTED_39_39", "TEXT_35_", "TEXT_33_", "QUOTED_36_36", "COMMENTS", "LB", "WS", "'SYNTAXDEF'", "'FOR'", "'START'", "','", "'IMPORTS'", "'{'", "'}'", "'OPTIONS'", "';'", "'TOKENS'", "'RULES'", "':'", "'WITH'", "'SYNTAX'", "'='", "'::='", "'|'", "'['", "']'", "'('", "')'", "'+'", "'*'", "'?'", "'DEFINE'", "'COLLECT'", "'IN'", "'PREDEFINED'"
    };
    public static final int T__42=42;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int QUOTED_39_39=8;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int TEXT_35_=9;
    public static final int TEXT=4;
    public static final int EOF=-1;
    public static final int TEXT_33_=10;
    public static final int T__19=19;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int WS=14;
    public static final int QNAME=6;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int COMMENTS=12;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int QUOTED_36_36=11;
    public static final int LB=13;
    public static final int QUOTED_60_62=5;
    public static final int QUOTED_34_34=7;

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
    	private boolean addProxy(org.eclipse.emf.ecore.EObject element, java.lang.String featureName, org.eclipse.emf.ecore.EObject proxy) {
    		return ((java.util.List<java.lang.Object>) element.eGet(element.eClass().getEStructuralFeature(featureName))).add(proxy);
    	}

    	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element, Object o) {
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
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:66:1: start returns [ EObject element = null] : (c0= concretesyntax | c1= concretesyntax EOF );
    public final EObject start() throws RecognitionException {
        EObject element =  null;

        org.emftext.sdk.concretesyntax.ConcreteSyntax c0 = null;

        org.emftext.sdk.concretesyntax.ConcreteSyntax c1 = null;


        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:68:1: (c0= concretesyntax | c1= concretesyntax EOF )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==15) ) {
                input.LA(2);

                if ( (synpred1_Cs()) ) {
                    alt1=1;
                }
                else if ( (true) ) {
                    alt1=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:69:1: c0= concretesyntax
                    {
                    pushFollow(FOLLOW_concretesyntax_in_start65);
                    c0=concretesyntax();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:71:1: c1= concretesyntax EOF
                    {
                    pushFollow(FOLLOW_concretesyntax_in_start77);
                    c1=concretesyntax();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; 
                    }
                    match(input,EOF,FOLLOW_EOF_in_start81); if (state.failed) return element;

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
    // $ANTLR end "start"


    // $ANTLR start "concretesyntax"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:76:1: concretesyntax returns [org.emftext.sdk.concretesyntax.ConcreteSyntax element = null] : a0= 'SYNTAXDEF' a1= TEXT a2= 'FOR' a3= QUOTED_60_62 a4= 'START' (a5= TEXT | a6= QNAME ) ( (a7= ',' (a8= TEXT | a9= QNAME ) ) )* ( (a10= 'IMPORTS' a11= '{' ( (a12= keywordimport ) )* a13= '}' ) )? ( (a14= 'OPTIONS' a15= '{' ( (a16= option a17= ';' ) )* a18= '}' ) )? ( (a19= 'TOKENS' a20= '{' ( (a21= tokendefinition a22= ';' ) )* a23= '}' ) )? a24= 'RULES' a25= '{' ( (a26= rule )+ ) a27= '}' ;
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
        org.emftext.sdk.concretesyntax.Import a12 = null;

        org.emftext.sdk.concretesyntax.Option a16 = null;

        org.emftext.sdk.concretesyntax.TokenDefinition a21 = null;

        org.emftext.sdk.concretesyntax.Rule a26 = null;




        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:79:1: (a0= 'SYNTAXDEF' a1= TEXT a2= 'FOR' a3= QUOTED_60_62 a4= 'START' (a5= TEXT | a6= QNAME ) ( (a7= ',' (a8= TEXT | a9= QNAME ) ) )* ( (a10= 'IMPORTS' a11= '{' ( (a12= keywordimport ) )* a13= '}' ) )? ( (a14= 'OPTIONS' a15= '{' ( (a16= option a17= ';' ) )* a18= '}' ) )? ( (a19= 'TOKENS' a20= '{' ( (a21= tokendefinition a22= ';' ) )* a23= '}' ) )? a24= 'RULES' a25= '{' ( (a26= rule )+ ) a27= '}' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:80:2: a0= 'SYNTAXDEF' a1= TEXT a2= 'FOR' a3= QUOTED_60_62 a4= 'START' (a5= TEXT | a6= QNAME ) ( (a7= ',' (a8= TEXT | a9= QNAME ) ) )* ( (a10= 'IMPORTS' a11= '{' ( (a12= keywordimport ) )* a13= '}' ) )? ( (a14= 'OPTIONS' a15= '{' ( (a16= option a17= ';' ) )* a18= '}' ) )? ( (a19= 'TOKENS' a20= '{' ( (a21= tokendefinition a22= ';' ) )* a23= '}' ) )? a24= 'RULES' a25= '{' ( (a26= rule )+ ) a27= '}'
            {
            a0=(Token)match(input,15,FOLLOW_15_in_concretesyntax104); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_concretesyntax112); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a1, element); 
            }
            a2=(Token)match(input,16,FOLLOW_16_in_concretesyntax120); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a2);copyLocalizationInfos((CommonToken)a2, element); 
            }
            a3=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_concretesyntax128); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("package"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a3,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenPackage proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenPackage();collectHiddenTokens(element, proxy); ((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("package"), proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a3, element); copyLocalizationInfos((CommonToken) a3, proxy); 
            }
            a4=(Token)match(input,17,FOLLOW_17_in_concretesyntax136); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a4);copyLocalizationInfos((CommonToken)a4, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:85:2: (a5= TEXT | a6= QNAME )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==TEXT) ) {
                alt2=1;
            }
            else if ( (LA2_0==QNAME) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:86:3: a5= TEXT
                    {
                    a5=(Token)match(input,TEXT,FOLLOW_TEXT_in_concretesyntax148); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a5,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();collectHiddenTokens(element, proxy); ((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); addProxy(element, "startSymbols", proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a5, element); copyLocalizationInfos((CommonToken) a5, proxy); 
                    }

                    }
                    break;
                case 2 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:89:3: a6= QNAME
                    {
                    a6=(Token)match(input,QNAME,FOLLOW_QNAME_in_concretesyntax162); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QNAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a6.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a6,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();collectHiddenTokens(element, proxy); ((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); addProxy(element, "startSymbols", proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a6, element); copyLocalizationInfos((CommonToken) a6, proxy); 
                    }

                    }
                    break;

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:91:2: ( (a7= ',' (a8= TEXT | a9= QNAME ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==18) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:92:3: (a7= ',' (a8= TEXT | a9= QNAME ) )
            	    {
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:92:3: (a7= ',' (a8= TEXT | a9= QNAME ) )
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:93:4: a7= ',' (a8= TEXT | a9= QNAME )
            	    {
            	    a7=(Token)match(input,18,FOLLOW_18_in_concretesyntax182); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {
            	       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a7);copyLocalizationInfos((CommonToken)a7, element); 
            	    }
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:94:4: (a8= TEXT | a9= QNAME )
            	    int alt3=2;
            	    int LA3_0 = input.LA(1);

            	    if ( (LA3_0==TEXT) ) {
            	        alt3=1;
            	    }
            	    else if ( (LA3_0==QNAME) ) {
            	        alt3=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 3, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt3) {
            	        case 1 :
            	            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:95:5: a8= TEXT
            	            {
            	            a8=(Token)match(input,TEXT,FOLLOW_TEXT_in_concretesyntax198); if (state.failed) return element;
            	            if ( state.backtracking==0 ) {
            	              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a8.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a8,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();collectHiddenTokens(element, proxy); ((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); addProxy(element, "startSymbols", proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a8, element); copyLocalizationInfos((CommonToken) a8, proxy); 
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:98:5: a9= QNAME
            	            {
            	            a9=(Token)match(input,QNAME,FOLLOW_QNAME_in_concretesyntax216); if (state.failed) return element;
            	            if ( state.backtracking==0 ) {
            	              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QNAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a9.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a9,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();collectHiddenTokens(element, proxy); ((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); addProxy(element, "startSymbols", proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a9, element); copyLocalizationInfos((CommonToken) a9, proxy); 
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:102:2: ( (a10= 'IMPORTS' a11= '{' ( (a12= keywordimport ) )* a13= '}' ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==19) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:103:3: (a10= 'IMPORTS' a11= '{' ( (a12= keywordimport ) )* a13= '}' )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:103:3: (a10= 'IMPORTS' a11= '{' ( (a12= keywordimport ) )* a13= '}' )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:104:4: a10= 'IMPORTS' a11= '{' ( (a12= keywordimport ) )* a13= '}'
                    {
                    a10=(Token)match(input,19,FOLLOW_19_in_concretesyntax246); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a10);copyLocalizationInfos((CommonToken)a10, element); 
                    }
                    a11=(Token)match(input,20,FOLLOW_20_in_concretesyntax256); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a11);copyLocalizationInfos((CommonToken)a11, element); 
                    }
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:106:4: ( (a12= keywordimport ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==TEXT) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:107:5: (a12= keywordimport )
                    	    {
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:107:5: (a12= keywordimport )
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:108:6: a12= keywordimport
                    	    {
                    	    pushFollow(FOLLOW_keywordimport_in_concretesyntax279);
                    	    a12=keywordimport();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); addProxy(element, "imports", a12); collectHiddenTokens(element, a12);copyLocalizationInfos(a12, element); 
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    a13=(Token)match(input,21,FOLLOW_21_in_concretesyntax301); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a13);copyLocalizationInfos((CommonToken)a13, element); 
                    }

                    }


                    }
                    break;

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:114:2: ( (a14= 'OPTIONS' a15= '{' ( (a16= option a17= ';' ) )* a18= '}' ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==22) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:115:3: (a14= 'OPTIONS' a15= '{' ( (a16= option a17= ';' ) )* a18= '}' )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:115:3: (a14= 'OPTIONS' a15= '{' ( (a16= option a17= ';' ) )* a18= '}' )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:116:4: a14= 'OPTIONS' a15= '{' ( (a16= option a17= ';' ) )* a18= '}'
                    {
                    a14=(Token)match(input,22,FOLLOW_22_in_concretesyntax326); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a14);copyLocalizationInfos((CommonToken)a14, element); 
                    }
                    a15=(Token)match(input,20,FOLLOW_20_in_concretesyntax336); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a15);copyLocalizationInfos((CommonToken)a15, element); 
                    }
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:118:4: ( (a16= option a17= ';' ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==TEXT) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:119:5: (a16= option a17= ';' )
                    	    {
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:119:5: (a16= option a17= ';' )
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:120:6: a16= option a17= ';'
                    	    {
                    	    pushFollow(FOLLOW_option_in_concretesyntax359);
                    	    a16=option();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); addProxy(element, "options", a16); collectHiddenTokens(element, a16);copyLocalizationInfos(a16, element); 
                    	    }
                    	    a17=(Token)match(input,23,FOLLOW_23_in_concretesyntax371); if (state.failed) return element;
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

                    a18=(Token)match(input,21,FOLLOW_21_in_concretesyntax393); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a18);copyLocalizationInfos((CommonToken)a18, element); 
                    }

                    }


                    }
                    break;

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:127:2: ( (a19= 'TOKENS' a20= '{' ( (a21= tokendefinition a22= ';' ) )* a23= '}' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==24) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:128:3: (a19= 'TOKENS' a20= '{' ( (a21= tokendefinition a22= ';' ) )* a23= '}' )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:128:3: (a19= 'TOKENS' a20= '{' ( (a21= tokendefinition a22= ';' ) )* a23= '}' )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:129:4: a19= 'TOKENS' a20= '{' ( (a21= tokendefinition a22= ';' ) )* a23= '}'
                    {
                    a19=(Token)match(input,24,FOLLOW_24_in_concretesyntax418); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a19);copyLocalizationInfos((CommonToken)a19, element); 
                    }
                    a20=(Token)match(input,20,FOLLOW_20_in_concretesyntax428); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a20);copyLocalizationInfos((CommonToken)a20, element); 
                    }
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:131:4: ( (a21= tokendefinition a22= ';' ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==39||LA9_0==42) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:132:5: (a21= tokendefinition a22= ';' )
                    	    {
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:132:5: (a21= tokendefinition a22= ';' )
                    	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:133:6: a21= tokendefinition a22= ';'
                    	    {
                    	    pushFollow(FOLLOW_tokendefinition_in_concretesyntax451);
                    	    a21=tokendefinition();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); addProxy(element, "tokens", a21); collectHiddenTokens(element, a21);copyLocalizationInfos(a21, element); 
                    	    }
                    	    a22=(Token)match(input,23,FOLLOW_23_in_concretesyntax463); if (state.failed) return element;
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

                    a23=(Token)match(input,21,FOLLOW_21_in_concretesyntax485); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a23);copyLocalizationInfos((CommonToken)a23, element); 
                    }

                    }


                    }
                    break;

            }

            a24=(Token)match(input,25,FOLLOW_25_in_concretesyntax501); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a24);copyLocalizationInfos((CommonToken)a24, element); 
            }
            a25=(Token)match(input,20,FOLLOW_20_in_concretesyntax509); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a25);copyLocalizationInfos((CommonToken)a25, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:142:2: ( (a26= rule )+ )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:143:3: (a26= rule )+
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:143:3: (a26= rule )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==TEXT||LA11_0==QNAME) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:144:4: a26= rule
            	    {
            	    pushFollow(FOLLOW_rule_in_concretesyntax526);
            	    a26=rule();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {
            	      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); addProxy(element, "rules", a26); collectHiddenTokens(element, a26);copyLocalizationInfos(a26, element); 
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

            a27=(Token)match(input,21,FOLLOW_21_in_concretesyntax542); if (state.failed) return element;
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
        }
        return element;
    }
    // $ANTLR end "concretesyntax"


    // $ANTLR start "keywordimport"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:150:1: keywordimport returns [org.emftext.sdk.concretesyntax.Import element = null] : a0= TEXT a1= ':' a2= QUOTED_60_62 ( (a3= 'WITH' a4= 'SYNTAX' a5= TEXT ) )? ;
    public final org.emftext.sdk.concretesyntax.Import keywordimport() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Import element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;



        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:153:1: (a0= TEXT a1= ':' a2= QUOTED_60_62 ( (a3= 'WITH' a4= 'SYNTAX' a5= TEXT ) )? )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:154:2: a0= TEXT a1= ':' a2= QUOTED_60_62 ( (a3= 'WITH' a4= 'SYNTAX' a5= TEXT ) )?
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_keywordimport565); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("prefix"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("prefix"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a0, element); 
            }
            a1=(Token)match(input,26,FOLLOW_26_in_keywordimport573); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            }
            a2=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_keywordimport581); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("package"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a2,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenPackage proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenPackage();collectHiddenTokens(element, proxy); ((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("package"), proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a2, element); copyLocalizationInfos((CommonToken) a2, proxy); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:157:2: ( (a3= 'WITH' a4= 'SYNTAX' a5= TEXT ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==27) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:158:3: (a3= 'WITH' a4= 'SYNTAX' a5= TEXT )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:158:3: (a3= 'WITH' a4= 'SYNTAX' a5= TEXT )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:159:4: a3= 'WITH' a4= 'SYNTAX' a5= TEXT
                    {
                    a3=(Token)match(input,27,FOLLOW_27_in_keywordimport598); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); 
                    }
                    a4=(Token)match(input,28,FOLLOW_28_in_keywordimport608); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport();} collectHiddenTokens(element, (CommonToken)a4);copyLocalizationInfos((CommonToken)a4, element); 
                    }
                    a5=(Token)match(input,TEXT,FOLLOW_TEXT_in_keywordimport618); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("concreteSyntax"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a5,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.emftext.sdk.concretesyntax.ConcreteSyntax proxy = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();collectHiddenTokens(element, proxy); ((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("concreteSyntax"), proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a5, element); copyLocalizationInfos((CommonToken) a5, proxy); 
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
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:166:1: option returns [org.emftext.sdk.concretesyntax.Option element = null] : a0= TEXT a1= '=' a2= TEXT ;
    public final org.emftext.sdk.concretesyntax.Option option() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Option element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:169:1: (a0= TEXT a1= '=' a2= TEXT )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:170:2: a0= TEXT a1= '=' a2= TEXT
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_option649); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createOption(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a0, element); 
            }
            a1=(Token)match(input,29,FOLLOW_29_in_option657); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createOption();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            }
            a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_option665); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createOption(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("value"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a2, element); 
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
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:175:1: rule returns [org.emftext.sdk.concretesyntax.Rule element = null] : (a0= TEXT | a1= QNAME ) a2= '::=' a3= choice a4= ';' ;
    public final org.emftext.sdk.concretesyntax.Rule rule() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Rule element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        org.emftext.sdk.concretesyntax.Choice a3 = null;




        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:178:1: ( (a0= TEXT | a1= QNAME ) a2= '::=' a3= choice a4= ';' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:179:2: (a0= TEXT | a1= QNAME ) a2= '::=' a3= choice a4= ';'
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:179:2: (a0= TEXT | a1= QNAME )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==TEXT) ) {
                alt13=1;
            }
            else if ( (LA13_0==QNAME) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:180:3: a0= TEXT
                    {
                    a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_rule692); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createRule(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("metaclass"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();collectHiddenTokens(element, proxy); ((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("metaclass"), proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); 
                    }

                    }
                    break;
                case 2 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:183:3: a1= QNAME
                    {
                    a1=(Token)match(input,QNAME,FOLLOW_QNAME_in_rule706); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createRule(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QNAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("metaclass"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a1,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();collectHiddenTokens(element, proxy); ((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("metaclass"), proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a1, element); copyLocalizationInfos((CommonToken) a1, proxy); 
                    }

                    }
                    break;

            }

            a2=(Token)match(input,30,FOLLOW_30_in_rule717); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createRule();} collectHiddenTokens(element, (CommonToken)a2);copyLocalizationInfos((CommonToken)a2, element); 
            }
            pushFollow(FOLLOW_choice_in_rule725);
            a3=choice();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createRule(); element.eSet(element.eClass().getEStructuralFeature("definition"), a3); collectHiddenTokens(element, a3);copyLocalizationInfos(a3, element); 
            }
            a4=(Token)match(input,23,FOLLOW_23_in_rule733); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createRule();} collectHiddenTokens(element, (CommonToken)a4);copyLocalizationInfos((CommonToken)a4, element); 
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
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:190:1: sequence returns [org.emftext.sdk.concretesyntax.Sequence element = null] : (a0= definition )+ ;
    public final org.emftext.sdk.concretesyntax.Sequence sequence() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Sequence element =  null;

        org.emftext.sdk.concretesyntax.Definition a0 = null;




        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:193:1: ( (a0= definition )+ )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:194:2: (a0= definition )+
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:194:2: (a0= definition )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==TEXT||LA14_0==QUOTED_34_34||(LA14_0>=TEXT_35_ && LA14_0<=TEXT_33_)||LA14_0==34) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:195:3: a0= definition
            	    {
            	    pushFollow(FOLLOW_definition_in_sequence760);
            	    a0=definition();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {
            	      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createSequence(); addProxy(element, "parts", a0); collectHiddenTokens(element, a0);copyLocalizationInfos(a0, element); 
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
        }
        return element;
    }
    // $ANTLR end "sequence"


    // $ANTLR start "choice"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:199:1: choice returns [org.emftext.sdk.concretesyntax.Choice element = null] : a0= sequence ( (a1= '|' a2= sequence ) )* ;
    public final org.emftext.sdk.concretesyntax.Choice choice() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Choice element =  null;

        Token a1=null;
        org.emftext.sdk.concretesyntax.Sequence a0 = null;

        org.emftext.sdk.concretesyntax.Sequence a2 = null;




        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:202:1: (a0= sequence ( (a1= '|' a2= sequence ) )* )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:203:2: a0= sequence ( (a1= '|' a2= sequence ) )*
            {
            pushFollow(FOLLOW_sequence_in_choice787);
            a0=sequence();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createChoice(); addProxy(element, "options", a0); collectHiddenTokens(element, a0);copyLocalizationInfos(a0, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:204:2: ( (a1= '|' a2= sequence ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==31) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:205:3: (a1= '|' a2= sequence )
            	    {
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:205:3: (a1= '|' a2= sequence )
            	    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:206:4: a1= '|' a2= sequence
            	    {
            	    a1=(Token)match(input,31,FOLLOW_31_in_choice804); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {
            	       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createChoice();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            	    }
            	    pushFollow(FOLLOW_sequence_in_choice814);
            	    a2=sequence();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {
            	      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createChoice(); addProxy(element, "options", a2); collectHiddenTokens(element, a2);copyLocalizationInfos(a2, element); 
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
        }
        return element;
    }
    // $ANTLR end "choice"


    // $ANTLR start "csstring"
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:212:1: csstring returns [org.emftext.sdk.concretesyntax.CsString element = null] : a0= QUOTED_34_34 ;
    public final org.emftext.sdk.concretesyntax.CsString csstring() throws RecognitionException {
        org.emftext.sdk.concretesyntax.CsString element =  null;

        Token a0=null;



        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:215:1: (a0= QUOTED_34_34 )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:216:2: a0= QUOTED_34_34
            {
            a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_csstring845); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createCsString(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("value"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a0, element); 
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
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:219:1: definedplaceholder returns [org.emftext.sdk.concretesyntax.DefinedPlaceholder element = null] : a0= TEXT a1= '[' a2= TEXT a3= ']' (a4= cardinality )? ;
    public final org.emftext.sdk.concretesyntax.DefinedPlaceholder definedplaceholder() throws RecognitionException {
        org.emftext.sdk.concretesyntax.DefinedPlaceholder element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        org.emftext.sdk.concretesyntax.Cardinality a4 = null;




        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:222:1: (a0= TEXT a1= '[' a2= TEXT a3= ']' (a4= cardinality )? )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:223:2: a0= TEXT a1= '[' a2= TEXT a3= ']' (a4= cardinality )?
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_definedplaceholder868); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDefinedPlaceholder(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenFeature();collectHiddenTokens(element, proxy); ((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("feature"), proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); 
            }
            a1=(Token)match(input,32,FOLLOW_32_in_definedplaceholder876); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDefinedPlaceholder();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            }
            a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_definedplaceholder884); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDefinedPlaceholder(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("token"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a2,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.emftext.sdk.concretesyntax.NormalToken proxy = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken();collectHiddenTokens(element, proxy); ((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("token"), proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a2, element); copyLocalizationInfos((CommonToken) a2, proxy); 
            }
            a3=(Token)match(input,33,FOLLOW_33_in_definedplaceholder892); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDefinedPlaceholder();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:227:2: (a4= cardinality )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=36 && LA16_0<=38)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:228:3: a4= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_definedplaceholder904);
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
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:232:1: derivedplaceholder returns [org.emftext.sdk.concretesyntax.DerivedPlaceholder element = null] : a0= TEXT a1= '[' ( (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? ) )? a5= ']' (a6= cardinality )? ;
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
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:235:1: (a0= TEXT a1= '[' ( (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? ) )? a5= ']' (a6= cardinality )? )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:236:2: a0= TEXT a1= '[' ( (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? ) )? a5= ']' (a6= cardinality )?
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_derivedplaceholder931); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenFeature();collectHiddenTokens(element, proxy); ((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("feature"), proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); 
            }
            a1=(Token)match(input,32,FOLLOW_32_in_derivedplaceholder939); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:238:2: ( (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==QUOTED_39_39) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:239:3: (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:239:3: (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:240:4: a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )?
                    {
                    a2=(Token)match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_derivedplaceholder956); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("prefix"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("prefix"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a2, element); 
                    }
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:241:4: ( (a3= ',' a4= QUOTED_39_39 ) )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==18) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:242:5: (a3= ',' a4= QUOTED_39_39 )
                            {
                            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:242:5: (a3= ',' a4= QUOTED_39_39 )
                            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:243:6: a3= ',' a4= QUOTED_39_39
                            {
                            a3=(Token)match(input,18,FOLLOW_18_in_derivedplaceholder979); if (state.failed) return element;
                            if ( state.backtracking==0 ) {
                               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); 
                            }
                            a4=(Token)match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_derivedplaceholder991); if (state.failed) return element;
                            if ( state.backtracking==0 ) {
                              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("suffix"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suffix"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a4, element); 
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            a5=(Token)match(input,33,FOLLOW_33_in_derivedplaceholder1019); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder();} collectHiddenTokens(element, (CommonToken)a5);copyLocalizationInfos((CommonToken)a5, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:250:2: (a6= cardinality )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=36 && LA19_0<=38)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:251:3: a6= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_derivedplaceholder1031);
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
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:255:1: containment returns [org.emftext.sdk.concretesyntax.Containment element = null] : (a0= TEXT a1= cardinality | a2= TEXT ) ;
    public final org.emftext.sdk.concretesyntax.Containment containment() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Containment element =  null;

        Token a0=null;
        Token a2=null;
        org.emftext.sdk.concretesyntax.Cardinality a1 = null;




        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:258:1: ( (a0= TEXT a1= cardinality | a2= TEXT ) )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:259:2: (a0= TEXT a1= cardinality | a2= TEXT )
            {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:259:2: (a0= TEXT a1= cardinality | a2= TEXT )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==TEXT) ) {
                int LA20_1 = input.LA(2);

                if ( ((LA20_1>=36 && LA20_1<=38)) ) {
                    alt20=1;
                }
                else if ( (LA20_1==EOF||LA20_1==TEXT||LA20_1==QUOTED_34_34||(LA20_1>=TEXT_35_ && LA20_1<=TEXT_33_)||LA20_1==23||LA20_1==31||(LA20_1>=34 && LA20_1<=35)) ) {
                    alt20=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:260:3: a0= TEXT a1= cardinality
                    {
                    a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_containment1062); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createContainment(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenFeature();collectHiddenTokens(element, proxy); ((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("feature"), proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); 
                    }
                    pushFollow(FOLLOW_cardinality_in_containment1071);
                    a1=cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createContainment(); element.eSet(element.eClass().getEStructuralFeature("cardinality"), a1); collectHiddenTokens(element, a1);copyLocalizationInfos(a1, element); 
                    }

                    }
                    break;
                case 2 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:264:3: a2= TEXT
                    {
                    a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_containment1085); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createContainment(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a2,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenFeature();collectHiddenTokens(element, proxy); ((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("feature"), proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a2, element); copyLocalizationInfos((CommonToken) a2, proxy); 
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
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:268:1: compounddefinition returns [org.emftext.sdk.concretesyntax.CompoundDefinition element = null] : a0= '(' a1= choice a2= ')' (a3= cardinality )? ;
    public final org.emftext.sdk.concretesyntax.CompoundDefinition compounddefinition() throws RecognitionException {
        org.emftext.sdk.concretesyntax.CompoundDefinition element =  null;

        Token a0=null;
        Token a2=null;
        org.emftext.sdk.concretesyntax.Choice a1 = null;

        org.emftext.sdk.concretesyntax.Cardinality a3 = null;




        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:271:1: (a0= '(' a1= choice a2= ')' (a3= cardinality )? )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:272:2: a0= '(' a1= choice a2= ')' (a3= cardinality )?
            {
            a0=(Token)match(input,34,FOLLOW_34_in_compounddefinition1111); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createCompoundDefinition();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            pushFollow(FOLLOW_choice_in_compounddefinition1119);
            a1=choice();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createCompoundDefinition(); element.eSet(element.eClass().getEStructuralFeature("definitions"), a1); collectHiddenTokens(element, a1);copyLocalizationInfos(a1, element); 
            }
            a2=(Token)match(input,35,FOLLOW_35_in_compounddefinition1127); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createCompoundDefinition();} collectHiddenTokens(element, (CommonToken)a2);copyLocalizationInfos((CommonToken)a2, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:275:2: (a3= cardinality )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=36 && LA21_0<=38)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:276:3: a3= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_compounddefinition1139);
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
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:280:1: plus returns [org.emftext.sdk.concretesyntax.PLUS element = null] : a0= '+' ;
    public final org.emftext.sdk.concretesyntax.PLUS plus() throws RecognitionException {
        org.emftext.sdk.concretesyntax.PLUS element =  null;

        Token a0=null;



        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:283:1: (a0= '+' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:284:2: a0= '+'
            {
            a0=(Token)match(input,36,FOLLOW_36_in_plus1166); if (state.failed) return element;
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
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:287:1: star returns [org.emftext.sdk.concretesyntax.STAR element = null] : a0= '*' ;
    public final org.emftext.sdk.concretesyntax.STAR star() throws RecognitionException {
        org.emftext.sdk.concretesyntax.STAR element =  null;

        Token a0=null;



        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:290:1: (a0= '*' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:291:2: a0= '*'
            {
            a0=(Token)match(input,37,FOLLOW_37_in_star1189); if (state.failed) return element;
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
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:294:1: questionmark returns [org.emftext.sdk.concretesyntax.QUESTIONMARK element = null] : a0= '?' ;
    public final org.emftext.sdk.concretesyntax.QUESTIONMARK questionmark() throws RecognitionException {
        org.emftext.sdk.concretesyntax.QUESTIONMARK element =  null;

        Token a0=null;



        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:297:1: (a0= '?' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:298:2: a0= '?'
            {
            a0=(Token)match(input,38,FOLLOW_38_in_questionmark1212); if (state.failed) return element;
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
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:301:1: whitespaces returns [org.emftext.sdk.concretesyntax.WhiteSpaces element = null] : a0= TEXT_35_ ;
    public final org.emftext.sdk.concretesyntax.WhiteSpaces whitespaces() throws RecognitionException {
        org.emftext.sdk.concretesyntax.WhiteSpaces element =  null;

        Token a0=null;



        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:304:1: (a0= TEXT_35_ )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:305:2: a0= TEXT_35_
            {
            a0=(Token)match(input,TEXT_35_,FOLLOW_TEXT_35__in_whitespaces1235); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createWhiteSpaces(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT_35_");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("amount"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.Integer resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("amount"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a0, element); 
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
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:308:1: linebreak returns [org.emftext.sdk.concretesyntax.LineBreak element = null] : a0= TEXT_33_ ;
    public final org.emftext.sdk.concretesyntax.LineBreak linebreak() throws RecognitionException {
        org.emftext.sdk.concretesyntax.LineBreak element =  null;

        Token a0=null;



        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:311:1: (a0= TEXT_33_ )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:312:2: a0= TEXT_33_
            {
            a0=(Token)match(input,TEXT_33_,FOLLOW_TEXT_33__in_linebreak1258); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createLineBreak(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT_33_");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("tab"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.Integer resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("tab"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a0, element); 
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
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:315:1: normaltoken returns [org.emftext.sdk.concretesyntax.NormalToken element = null] : a0= 'DEFINE' a1= TEXT a2= QUOTED_36_36 ( (a3= 'COLLECT' a4= 'IN' a5= TEXT ) )? ;
    public final org.emftext.sdk.concretesyntax.NormalToken normaltoken() throws RecognitionException {
        org.emftext.sdk.concretesyntax.NormalToken element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;



        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:318:1: (a0= 'DEFINE' a1= TEXT a2= QUOTED_36_36 ( (a3= 'COLLECT' a4= 'IN' a5= TEXT ) )? )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:319:2: a0= 'DEFINE' a1= TEXT a2= QUOTED_36_36 ( (a3= 'COLLECT' a4= 'IN' a5= TEXT ) )?
            {
            a0=(Token)match(input,39,FOLLOW_39_in_normaltoken1281); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_normaltoken1289); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a1, element); 
            }
            a2=(Token)match(input,QUOTED_36_36,FOLLOW_QUOTED_36_36_in_normaltoken1297); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_36_36");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("regex"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("regex"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a2, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:322:2: ( (a3= 'COLLECT' a4= 'IN' a5= TEXT ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==40) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:323:3: (a3= 'COLLECT' a4= 'IN' a5= TEXT )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:323:3: (a3= 'COLLECT' a4= 'IN' a5= TEXT )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:324:4: a3= 'COLLECT' a4= 'IN' a5= TEXT
                    {
                    a3=(Token)match(input,40,FOLLOW_40_in_normaltoken1314); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); 
                    }
                    a4=(Token)match(input,41,FOLLOW_41_in_normaltoken1324); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken();} collectHiddenTokens(element, (CommonToken)a4);copyLocalizationInfos((CommonToken)a4, element); 
                    }
                    a5=(Token)match(input,TEXT,FOLLOW_TEXT_in_normaltoken1334); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("attributeName"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("attributeName"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a5, element); 
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
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:331:1: decoratedtoken returns [org.emftext.sdk.concretesyntax.DecoratedToken element = null] : a0= 'DEFINE' a1= TEXT (a2= '[' (a3= QUOTED_39_39 ) a4= ']' ) a5= QUOTED_36_36 (a6= '[' (a7= QUOTED_39_39 ) a8= ']' ) ( (a9= 'COLLECT' a10= 'IN' a11= TEXT ) )? ;
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
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:334:1: (a0= 'DEFINE' a1= TEXT (a2= '[' (a3= QUOTED_39_39 ) a4= ']' ) a5= QUOTED_36_36 (a6= '[' (a7= QUOTED_39_39 ) a8= ']' ) ( (a9= 'COLLECT' a10= 'IN' a11= TEXT ) )? )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:335:2: a0= 'DEFINE' a1= TEXT (a2= '[' (a3= QUOTED_39_39 ) a4= ']' ) a5= QUOTED_36_36 (a6= '[' (a7= QUOTED_39_39 ) a8= ']' ) ( (a9= 'COLLECT' a10= 'IN' a11= TEXT ) )?
            {
            a0=(Token)match(input,39,FOLLOW_39_in_decoratedtoken1365); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_decoratedtoken1373); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a1, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:337:2: (a2= '[' (a3= QUOTED_39_39 ) a4= ']' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:338:3: a2= '[' (a3= QUOTED_39_39 ) a4= ']'
            {
            a2=(Token)match(input,32,FOLLOW_32_in_decoratedtoken1385); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a2);copyLocalizationInfos((CommonToken)a2, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:339:3: (a3= QUOTED_39_39 )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:340:4: a3= QUOTED_39_39
            {
            a3=(Token)match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_decoratedtoken1399); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("prefix"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a3,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("prefix"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a3, element); 
            }

            }

            a4=(Token)match(input,33,FOLLOW_33_in_decoratedtoken1412); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a4);copyLocalizationInfos((CommonToken)a4, element); 
            }

            }

            a5=(Token)match(input,QUOTED_36_36,FOLLOW_QUOTED_36_36_in_decoratedtoken1423); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_36_36");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("regex"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("regex"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a5, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:345:2: (a6= '[' (a7= QUOTED_39_39 ) a8= ']' )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:346:3: a6= '[' (a7= QUOTED_39_39 ) a8= ']'
            {
            a6=(Token)match(input,32,FOLLOW_32_in_decoratedtoken1435); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a6);copyLocalizationInfos((CommonToken)a6, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:347:3: (a7= QUOTED_39_39 )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:348:4: a7= QUOTED_39_39
            {
            a7=(Token)match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_decoratedtoken1449); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a7.getText(),element.eClass().getEStructuralFeature("suffix"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a7,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suffix"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a7, element); 
            }

            }

            a8=(Token)match(input,33,FOLLOW_33_in_decoratedtoken1462); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a8);copyLocalizationInfos((CommonToken)a8, element); 
            }

            }

            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:352:2: ( (a9= 'COLLECT' a10= 'IN' a11= TEXT ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==40) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:353:3: (a9= 'COLLECT' a10= 'IN' a11= TEXT )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:353:3: (a9= 'COLLECT' a10= 'IN' a11= TEXT )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:354:4: a9= 'COLLECT' a10= 'IN' a11= TEXT
                    {
                    a9=(Token)match(input,40,FOLLOW_40_in_decoratedtoken1482); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a9);copyLocalizationInfos((CommonToken)a9, element); 
                    }
                    a10=(Token)match(input,41,FOLLOW_41_in_decoratedtoken1492); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a10);copyLocalizationInfos((CommonToken)a10, element); 
                    }
                    a11=(Token)match(input,TEXT,FOLLOW_TEXT_in_decoratedtoken1502); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a11.getText(),element.eClass().getEStructuralFeature("attributeName"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a11,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("attributeName"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a11, element); 
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
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:361:1: predefinedtoken returns [org.emftext.sdk.concretesyntax.PreDefinedToken element = null] : a0= 'PREDEFINED' a1= TEXT ( (a2= 'COLLECT' a3= 'IN' a4= TEXT ) )? ;
    public final org.emftext.sdk.concretesyntax.PreDefinedToken predefinedtoken() throws RecognitionException {
        org.emftext.sdk.concretesyntax.PreDefinedToken element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;



        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:364:1: (a0= 'PREDEFINED' a1= TEXT ( (a2= 'COLLECT' a3= 'IN' a4= TEXT ) )? )
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:365:2: a0= 'PREDEFINED' a1= TEXT ( (a2= 'COLLECT' a3= 'IN' a4= TEXT ) )?
            {
            a0=(Token)match(input,42,FOLLOW_42_in_predefinedtoken1533); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_predefinedtoken1541); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a1, element); 
            }
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:367:2: ( (a2= 'COLLECT' a3= 'IN' a4= TEXT ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==40) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:368:3: (a2= 'COLLECT' a3= 'IN' a4= TEXT )
                    {
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:368:3: (a2= 'COLLECT' a3= 'IN' a4= TEXT )
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:369:4: a2= 'COLLECT' a3= 'IN' a4= TEXT
                    {
                    a2=(Token)match(input,40,FOLLOW_40_in_predefinedtoken1558); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken();} collectHiddenTokens(element, (CommonToken)a2);copyLocalizationInfos((CommonToken)a2, element); 
                    }
                    a3=(Token)match(input,41,FOLLOW_41_in_predefinedtoken1568); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); 
                    }
                    a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_predefinedtoken1578); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("attributeName"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("attributeName"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a4, element); 
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
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:376:1: tokendefinition returns [org.emftext.sdk.concretesyntax.TokenDefinition element = null] : (c0= normaltoken | c1= decoratedtoken | c2= predefinedtoken );
    public final org.emftext.sdk.concretesyntax.TokenDefinition tokendefinition() throws RecognitionException {
        org.emftext.sdk.concretesyntax.TokenDefinition element =  null;

        org.emftext.sdk.concretesyntax.NormalToken c0 = null;

        org.emftext.sdk.concretesyntax.DecoratedToken c1 = null;

        org.emftext.sdk.concretesyntax.PreDefinedToken c2 = null;


        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:378:1: (c0= normaltoken | c1= decoratedtoken | c2= predefinedtoken )
            int alt25=3;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==39) ) {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==TEXT) ) {
                    int LA25_3 = input.LA(3);

                    if ( (LA25_3==32) ) {
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
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:379:2: c0= normaltoken
                    {
                    pushFollow(FOLLOW_normaltoken_in_tokendefinition1605);
                    c0=normaltoken();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:380:2: c1= decoratedtoken
                    {
                    pushFollow(FOLLOW_decoratedtoken_in_tokendefinition1615);
                    c1=decoratedtoken();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:381:2: c2= predefinedtoken
                    {
                    pushFollow(FOLLOW_predefinedtoken_in_tokendefinition1625);
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
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:384:1: definition returns [org.emftext.sdk.concretesyntax.Definition element = null] : (c0= csstring | c1= definedplaceholder | c2= derivedplaceholder | c3= containment | c4= compounddefinition | c5= whitespaces | c6= linebreak );
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
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:386:1: (c0= csstring | c1= definedplaceholder | c2= derivedplaceholder | c3= containment | c4= compounddefinition | c5= whitespaces | c6= linebreak )
            int alt26=7;
            alt26 = dfa26.predict(input);
            switch (alt26) {
                case 1 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:387:2: c0= csstring
                    {
                    pushFollow(FOLLOW_csstring_in_definition1644);
                    c0=csstring();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:388:2: c1= definedplaceholder
                    {
                    pushFollow(FOLLOW_definedplaceholder_in_definition1654);
                    c1=definedplaceholder();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:389:2: c2= derivedplaceholder
                    {
                    pushFollow(FOLLOW_derivedplaceholder_in_definition1664);
                    c2=derivedplaceholder();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; 
                    }

                    }
                    break;
                case 4 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:390:2: c3= containment
                    {
                    pushFollow(FOLLOW_containment_in_definition1674);
                    c3=containment();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c3; 
                    }

                    }
                    break;
                case 5 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:391:2: c4= compounddefinition
                    {
                    pushFollow(FOLLOW_compounddefinition_in_definition1684);
                    c4=compounddefinition();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c4; 
                    }

                    }
                    break;
                case 6 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:392:2: c5= whitespaces
                    {
                    pushFollow(FOLLOW_whitespaces_in_definition1694);
                    c5=whitespaces();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c5; 
                    }

                    }
                    break;
                case 7 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:393:2: c6= linebreak
                    {
                    pushFollow(FOLLOW_linebreak_in_definition1704);
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
    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:396:1: cardinality returns [org.emftext.sdk.concretesyntax.Cardinality element = null] : (c0= plus | c1= star | c2= questionmark );
    public final org.emftext.sdk.concretesyntax.Cardinality cardinality() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Cardinality element =  null;

        org.emftext.sdk.concretesyntax.PLUS c0 = null;

        org.emftext.sdk.concretesyntax.STAR c1 = null;

        org.emftext.sdk.concretesyntax.QUESTIONMARK c2 = null;


        try {
            // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:398:1: (c0= plus | c1= star | c2= questionmark )
            int alt27=3;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt27=1;
                }
                break;
            case 37:
                {
                alt27=2;
                }
                break;
            case 38:
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
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:399:2: c0= plus
                    {
                    pushFollow(FOLLOW_plus_in_cardinality1723);
                    c0=plus();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:400:2: c1= star
                    {
                    pushFollow(FOLLOW_star_in_cardinality1733);
                    c1=star();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:401:2: c2= questionmark
                    {
                    pushFollow(FOLLOW_questionmark_in_cardinality1743);
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

    // $ANTLR start synpred1_Cs
    public final void synpred1_Cs_fragment() throws RecognitionException {   
        // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:69:1: (c0= concretesyntax )
        // D:\\Projekte\\Eclipse Workspaces\\EMFText Languages DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:69:1: c0= concretesyntax
        {
        pushFollow(FOLLOW_concretesyntax_in_synpred1_Cs65);
        concretesyntax();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_Cs

    // Delegated rules

    public final boolean synpred1_Cs() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_Cs_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA26 dfa26 = new DFA26(this);
    static final String DFA26_eotS =
        "\12\uffff";
    static final String DFA26_eofS =
        "\2\uffff\1\7\7\uffff";
    static final String DFA26_minS =
        "\1\4\1\uffff\1\4\3\uffff\1\4\3\uffff";
    static final String DFA26_maxS =
        "\1\42\1\uffff\1\46\3\uffff\1\41\3\uffff";
    static final String DFA26_acceptS =
        "\1\uffff\1\1\1\uffff\1\5\1\6\1\7\1\uffff\1\4\1\3\1\2";
    static final String DFA26_specialS =
        "\12\uffff}>";
    static final String[] DFA26_transitionS = {
            "\1\2\2\uffff\1\1\1\uffff\1\4\1\5\27\uffff\1\3",
            "",
            "\1\7\2\uffff\1\7\1\uffff\2\7\14\uffff\1\7\7\uffff\1\7\1\6"+
            "\1\uffff\5\7",
            "",
            "",
            "",
            "\1\11\3\uffff\1\10\30\uffff\1\10",
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
            return "384:1: definition returns [org.emftext.sdk.concretesyntax.Definition element = null] : (c0= csstring | c1= definedplaceholder | c2= derivedplaceholder | c3= containment | c4= compounddefinition | c5= whitespaces | c6= linebreak );";
        }
    }
 

    public static final BitSet FOLLOW_concretesyntax_in_start65 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_concretesyntax_in_start77 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_concretesyntax104 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_concretesyntax112 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_concretesyntax120 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_concretesyntax128 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_concretesyntax136 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_TEXT_in_concretesyntax148 = new BitSet(new long[]{0x00000000034C0000L});
    public static final BitSet FOLLOW_QNAME_in_concretesyntax162 = new BitSet(new long[]{0x00000000034C0000L});
    public static final BitSet FOLLOW_18_in_concretesyntax182 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_TEXT_in_concretesyntax198 = new BitSet(new long[]{0x00000000034C0000L});
    public static final BitSet FOLLOW_QNAME_in_concretesyntax216 = new BitSet(new long[]{0x00000000034C0000L});
    public static final BitSet FOLLOW_19_in_concretesyntax246 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_concretesyntax256 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_keywordimport_in_concretesyntax279 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_21_in_concretesyntax301 = new BitSet(new long[]{0x0000000003400000L});
    public static final BitSet FOLLOW_22_in_concretesyntax326 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_concretesyntax336 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_option_in_concretesyntax359 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_concretesyntax371 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_21_in_concretesyntax393 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_concretesyntax418 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_concretesyntax428 = new BitSet(new long[]{0x0000048000200000L});
    public static final BitSet FOLLOW_tokendefinition_in_concretesyntax451 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_concretesyntax463 = new BitSet(new long[]{0x0000048000200000L});
    public static final BitSet FOLLOW_21_in_concretesyntax485 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_concretesyntax501 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_concretesyntax509 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_rule_in_concretesyntax526 = new BitSet(new long[]{0x0000000000200050L});
    public static final BitSet FOLLOW_21_in_concretesyntax542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_keywordimport565 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_keywordimport573 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_keywordimport581 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_keywordimport598 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_keywordimport608 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_keywordimport618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_option649 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_option657 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_option665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_rule692 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_QNAME_in_rule706 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_rule717 = new BitSet(new long[]{0x0000000400000690L});
    public static final BitSet FOLLOW_choice_in_rule725 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_rule733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definition_in_sequence760 = new BitSet(new long[]{0x0000000400000692L});
    public static final BitSet FOLLOW_sequence_in_choice787 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_choice804 = new BitSet(new long[]{0x0000000400000690L});
    public static final BitSet FOLLOW_sequence_in_choice814 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_csstring845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_definedplaceholder868 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_definedplaceholder876 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_definedplaceholder884 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_definedplaceholder892 = new BitSet(new long[]{0x0000007000000002L});
    public static final BitSet FOLLOW_cardinality_in_definedplaceholder904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_derivedplaceholder931 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_derivedplaceholder939 = new BitSet(new long[]{0x0000000200000100L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_derivedplaceholder956 = new BitSet(new long[]{0x0000000200040000L});
    public static final BitSet FOLLOW_18_in_derivedplaceholder979 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_derivedplaceholder991 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_derivedplaceholder1019 = new BitSet(new long[]{0x0000007000000002L});
    public static final BitSet FOLLOW_cardinality_in_derivedplaceholder1031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_containment1062 = new BitSet(new long[]{0x0000007000000000L});
    public static final BitSet FOLLOW_cardinality_in_containment1071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_containment1085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_compounddefinition1111 = new BitSet(new long[]{0x0000000400000690L});
    public static final BitSet FOLLOW_choice_in_compounddefinition1119 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_compounddefinition1127 = new BitSet(new long[]{0x0000007000000002L});
    public static final BitSet FOLLOW_cardinality_in_compounddefinition1139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_plus1166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_star1189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_questionmark1212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_35__in_whitespaces1235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_33__in_linebreak1258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_normaltoken1281 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_normaltoken1289 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_QUOTED_36_36_in_normaltoken1297 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_normaltoken1314 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_normaltoken1324 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_normaltoken1334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_decoratedtoken1365 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_decoratedtoken1373 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_decoratedtoken1385 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_decoratedtoken1399 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_decoratedtoken1412 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_QUOTED_36_36_in_decoratedtoken1423 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_decoratedtoken1435 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_decoratedtoken1449 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_decoratedtoken1462 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_decoratedtoken1482 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_decoratedtoken1492 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_decoratedtoken1502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_predefinedtoken1533 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_predefinedtoken1541 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_predefinedtoken1558 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_predefinedtoken1568 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_predefinedtoken1578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normaltoken_in_tokendefinition1605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decoratedtoken_in_tokendefinition1615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predefinedtoken_in_tokendefinition1625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_csstring_in_definition1644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definedplaceholder_in_definition1654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_derivedplaceholder_in_definition1664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_containment_in_definition1674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compounddefinition_in_definition1684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whitespaces_in_definition1694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_linebreak_in_definition1704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_plus_in_cardinality1723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_star_in_cardinality1733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_questionmark_in_cardinality1743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_concretesyntax_in_synpred1_Cs65 = new BitSet(new long[]{0x0000000000000002L});

}