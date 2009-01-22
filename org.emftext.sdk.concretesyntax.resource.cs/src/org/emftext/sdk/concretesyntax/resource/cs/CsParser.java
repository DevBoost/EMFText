// $ANTLR 3.1.1 /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g 2009-01-20 00:44:48

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "TEXT", "QUOTED_60_62", "QNAME", "QUOTED_34_34", "QUOTED_39_39", "TEXT_35_", "TEXT_33_", "QUOTED_36_36", "COMMENTS", "WS", "LB", "'SYNTAXDEF'", "'FOR'", "'START'", "','", "'IMPORTS'", "'{'", "'}'", "'OPTIONS'", "';'", "'TOKENS'", "'RULES'", "':'", "'WITH'", "'SYNTAX'", "'='", "'::='", "'|'", "'['", "']'", "'('", "')'", "'+'", "'*'", "'?'", "'DEFINE'", "'COLLECT'", "'IN'", "'PREDEFINED'"
    };
    public static final int T__42=42;
    public static final int T__35=35;
    public static final int T__28=28;
    public static final int T__23=23;
    public static final int QUOTED_36_36=11;
    public static final int T__36=36;
    public static final int T__20=20;
    public static final int WS=13;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int COMMENTS=12;
    public static final int T__33=33;
    public static final int QUOTED_60_62=5;
    public static final int T__22=22;
    public static final int TEXT_35_=9;
    public static final int T__29=29;
    public static final int T__39=39;
    public static final int T__30=30;
    public static final int T__17=17;
    public static final int T__31=31;
    public static final int T__40=40;
    public static final int EOF=-1;
    public static final int LB=14;
    public static final int T__27=27;
    public static final int T__32=32;
    public static final int T__16=16;
    public static final int TEXT=4;
    public static final int T__38=38;
    public static final int T__24=24;
    public static final int T__37=37;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int TEXT_33_=10;
    public static final int QUOTED_39_39=8;
    public static final int T__34=34;
    public static final int T__41=41;
    public static final int T__18=18;
    public static final int QUOTED_34_34=7;
    public static final int QNAME=6;
    public static final int T__15=15;

    // delegates
    // delegators


        public CsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public CsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return CsParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g"; }


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
    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:66:1: start returns [ EObject element = null] : c0= concretesyntax EOF ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;

        org.emftext.sdk.concretesyntax.ConcreteSyntax c0 = null;


        try {
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:68:1: (c0= concretesyntax EOF )
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:69:1: c0= concretesyntax EOF
            {
            pushFollow(FOLLOW_concretesyntax_in_start65);
            c0=concretesyntax();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
               element = c0; 
            }
            match(input,EOF,FOLLOW_EOF_in_start69); if (state.failed) return element;

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
    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:74:1: concretesyntax returns [org.emftext.sdk.concretesyntax.ConcreteSyntax element = null] : a0= 'SYNTAXDEF' a1= TEXT a2= 'FOR' a3= QUOTED_60_62 a4= 'START' (a5= TEXT | a6= QNAME ) ( (a7= ',' (a8= TEXT | a9= QNAME ) ) )* ( (a10= 'IMPORTS' a11= '{' ( (a12= keywordimport ) )* a13= '}' ) )? ( (a14= 'OPTIONS' a15= '{' ( (a16= option a17= ';' ) )* a18= '}' ) )? ( (a19= 'TOKENS' a20= '{' ( (a21= tokendefinition a22= ';' ) )* a23= '}' ) )? a24= 'RULES' a25= '{' ( (a26= rule )+ ) a27= '}' ;
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
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:77:1: (a0= 'SYNTAXDEF' a1= TEXT a2= 'FOR' a3= QUOTED_60_62 a4= 'START' (a5= TEXT | a6= QNAME ) ( (a7= ',' (a8= TEXT | a9= QNAME ) ) )* ( (a10= 'IMPORTS' a11= '{' ( (a12= keywordimport ) )* a13= '}' ) )? ( (a14= 'OPTIONS' a15= '{' ( (a16= option a17= ';' ) )* a18= '}' ) )? ( (a19= 'TOKENS' a20= '{' ( (a21= tokendefinition a22= ';' ) )* a23= '}' ) )? a24= 'RULES' a25= '{' ( (a26= rule )+ ) a27= '}' )
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:78:2: a0= 'SYNTAXDEF' a1= TEXT a2= 'FOR' a3= QUOTED_60_62 a4= 'START' (a5= TEXT | a6= QNAME ) ( (a7= ',' (a8= TEXT | a9= QNAME ) ) )* ( (a10= 'IMPORTS' a11= '{' ( (a12= keywordimport ) )* a13= '}' ) )? ( (a14= 'OPTIONS' a15= '{' ( (a16= option a17= ';' ) )* a18= '}' ) )? ( (a19= 'TOKENS' a20= '{' ( (a21= tokendefinition a22= ';' ) )* a23= '}' ) )? a24= 'RULES' a25= '{' ( (a26= rule )+ ) a27= '}'
            {
            a0=(Token)match(input,15,FOLLOW_15_in_concretesyntax92); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_concretesyntax100); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a1, element); 
            }
            a2=(Token)match(input,16,FOLLOW_16_in_concretesyntax108); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a2);copyLocalizationInfos((CommonToken)a2, element); 
            }
            a3=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_concretesyntax116); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("package"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a3,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenPackage proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenPackage();collectHiddenTokens(element, proxy); getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature("package"), resolved, proxy);element.eSet(element.eClass().getEStructuralFeature("package"), proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a3, element); copyLocalizationInfos((CommonToken) a3, proxy); 
            }
            a4=(Token)match(input,17,FOLLOW_17_in_concretesyntax124); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a4);copyLocalizationInfos((CommonToken)a4, element); 
            }
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:83:2: (a5= TEXT | a6= QNAME )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==TEXT) ) {
                alt1=1;
            }
            else if ( (LA1_0==QNAME) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:84:3: a5= TEXT
                    {
                    a5=(Token)match(input,TEXT,FOLLOW_TEXT_in_concretesyntax136); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a5,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();collectHiddenTokens(element, proxy); getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature("startSymbols"), resolved, proxy);addObjectToList(element, "startSymbols", proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a5, element); copyLocalizationInfos((CommonToken) a5, proxy); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:87:3: a6= QNAME
                    {
                    a6=(Token)match(input,QNAME,FOLLOW_QNAME_in_concretesyntax150); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QNAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a6.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a6,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();collectHiddenTokens(element, proxy); getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature("startSymbols"), resolved, proxy);addObjectToList(element, "startSymbols", proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a6, element); copyLocalizationInfos((CommonToken) a6, proxy); 
                    }

                    }
                    break;

            }

            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:89:2: ( (a7= ',' (a8= TEXT | a9= QNAME ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==18) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:90:3: (a7= ',' (a8= TEXT | a9= QNAME ) )
            	    {
            	    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:90:3: (a7= ',' (a8= TEXT | a9= QNAME ) )
            	    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:91:4: a7= ',' (a8= TEXT | a9= QNAME )
            	    {
            	    a7=(Token)match(input,18,FOLLOW_18_in_concretesyntax170); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {
            	       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a7);copyLocalizationInfos((CommonToken)a7, element); 
            	    }
            	    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:92:4: (a8= TEXT | a9= QNAME )
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
            	            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:93:5: a8= TEXT
            	            {
            	            a8=(Token)match(input,TEXT,FOLLOW_TEXT_in_concretesyntax186); if (state.failed) return element;
            	            if ( state.backtracking==0 ) {
            	              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a8.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a8,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();collectHiddenTokens(element, proxy); getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature("startSymbols"), resolved, proxy);addObjectToList(element, "startSymbols", proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a8, element); copyLocalizationInfos((CommonToken) a8, proxy); 
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:96:5: a9= QNAME
            	            {
            	            a9=(Token)match(input,QNAME,FOLLOW_QNAME_in_concretesyntax204); if (state.failed) return element;
            	            if ( state.backtracking==0 ) {
            	              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QNAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a9.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a9,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();collectHiddenTokens(element, proxy); getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature("startSymbols"), resolved, proxy);addObjectToList(element, "startSymbols", proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a9, element); copyLocalizationInfos((CommonToken) a9, proxy); 
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:100:2: ( (a10= 'IMPORTS' a11= '{' ( (a12= keywordimport ) )* a13= '}' ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==19) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:101:3: (a10= 'IMPORTS' a11= '{' ( (a12= keywordimport ) )* a13= '}' )
                    {
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:101:3: (a10= 'IMPORTS' a11= '{' ( (a12= keywordimport ) )* a13= '}' )
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:102:4: a10= 'IMPORTS' a11= '{' ( (a12= keywordimport ) )* a13= '}'
                    {
                    a10=(Token)match(input,19,FOLLOW_19_in_concretesyntax234); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a10);copyLocalizationInfos((CommonToken)a10, element); 
                    }
                    a11=(Token)match(input,20,FOLLOW_20_in_concretesyntax244); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a11);copyLocalizationInfos((CommonToken)a11, element); 
                    }
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:104:4: ( (a12= keywordimport ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==TEXT) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:105:5: (a12= keywordimport )
                    	    {
                    	    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:105:5: (a12= keywordimport )
                    	    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:106:6: a12= keywordimport
                    	    {
                    	    pushFollow(FOLLOW_keywordimport_in_concretesyntax267);
                    	    a12=keywordimport();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); addObjectToList(element, "imports", a12); collectHiddenTokens(element, a12);copyLocalizationInfos(a12, element); 
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    a13=(Token)match(input,21,FOLLOW_21_in_concretesyntax289); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a13);copyLocalizationInfos((CommonToken)a13, element); 
                    }

                    }


                    }
                    break;

            }

            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:112:2: ( (a14= 'OPTIONS' a15= '{' ( (a16= option a17= ';' ) )* a18= '}' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==22) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:113:3: (a14= 'OPTIONS' a15= '{' ( (a16= option a17= ';' ) )* a18= '}' )
                    {
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:113:3: (a14= 'OPTIONS' a15= '{' ( (a16= option a17= ';' ) )* a18= '}' )
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:114:4: a14= 'OPTIONS' a15= '{' ( (a16= option a17= ';' ) )* a18= '}'
                    {
                    a14=(Token)match(input,22,FOLLOW_22_in_concretesyntax314); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a14);copyLocalizationInfos((CommonToken)a14, element); 
                    }
                    a15=(Token)match(input,20,FOLLOW_20_in_concretesyntax324); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a15);copyLocalizationInfos((CommonToken)a15, element); 
                    }
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:116:4: ( (a16= option a17= ';' ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==TEXT) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:117:5: (a16= option a17= ';' )
                    	    {
                    	    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:117:5: (a16= option a17= ';' )
                    	    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:118:6: a16= option a17= ';'
                    	    {
                    	    pushFollow(FOLLOW_option_in_concretesyntax347);
                    	    a16=option();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); addObjectToList(element, "options", a16); collectHiddenTokens(element, a16);copyLocalizationInfos(a16, element); 
                    	    }
                    	    a17=(Token)match(input,23,FOLLOW_23_in_concretesyntax359); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a17);copyLocalizationInfos((CommonToken)a17, element); 
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    a18=(Token)match(input,21,FOLLOW_21_in_concretesyntax381); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a18);copyLocalizationInfos((CommonToken)a18, element); 
                    }

                    }


                    }
                    break;

            }

            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:125:2: ( (a19= 'TOKENS' a20= '{' ( (a21= tokendefinition a22= ';' ) )* a23= '}' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==24) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:126:3: (a19= 'TOKENS' a20= '{' ( (a21= tokendefinition a22= ';' ) )* a23= '}' )
                    {
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:126:3: (a19= 'TOKENS' a20= '{' ( (a21= tokendefinition a22= ';' ) )* a23= '}' )
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:127:4: a19= 'TOKENS' a20= '{' ( (a21= tokendefinition a22= ';' ) )* a23= '}'
                    {
                    a19=(Token)match(input,24,FOLLOW_24_in_concretesyntax406); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a19);copyLocalizationInfos((CommonToken)a19, element); 
                    }
                    a20=(Token)match(input,20,FOLLOW_20_in_concretesyntax416); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a20);copyLocalizationInfos((CommonToken)a20, element); 
                    }
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:129:4: ( (a21= tokendefinition a22= ';' ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==39||LA8_0==42) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:130:5: (a21= tokendefinition a22= ';' )
                    	    {
                    	    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:130:5: (a21= tokendefinition a22= ';' )
                    	    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:131:6: a21= tokendefinition a22= ';'
                    	    {
                    	    pushFollow(FOLLOW_tokendefinition_in_concretesyntax439);
                    	    a21=tokendefinition();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); addObjectToList(element, "tokens", a21); collectHiddenTokens(element, a21);copyLocalizationInfos(a21, element); 
                    	    }
                    	    a22=(Token)match(input,23,FOLLOW_23_in_concretesyntax451); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a22);copyLocalizationInfos((CommonToken)a22, element); 
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    a23=(Token)match(input,21,FOLLOW_21_in_concretesyntax473); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a23);copyLocalizationInfos((CommonToken)a23, element); 
                    }

                    }


                    }
                    break;

            }

            a24=(Token)match(input,25,FOLLOW_25_in_concretesyntax489); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a24);copyLocalizationInfos((CommonToken)a24, element); 
            }
            a25=(Token)match(input,20,FOLLOW_20_in_concretesyntax497); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a25);copyLocalizationInfos((CommonToken)a25, element); 
            }
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:140:2: ( (a26= rule )+ )
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:141:3: (a26= rule )+
            {
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:141:3: (a26= rule )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==TEXT||LA10_0==QNAME) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:142:4: a26= rule
            	    {
            	    pushFollow(FOLLOW_rule_in_concretesyntax514);
            	    a26=rule();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {
            	      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); addObjectToList(element, "rules", a26); collectHiddenTokens(element, a26);copyLocalizationInfos(a26, element); 
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

            a27=(Token)match(input,21,FOLLOW_21_in_concretesyntax530); if (state.failed) return element;
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
    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:148:1: keywordimport returns [org.emftext.sdk.concretesyntax.Import element = null] : a0= TEXT a1= ':' a2= QUOTED_60_62 ( (a3= 'WITH' a4= 'SYNTAX' a5= TEXT ) )? ;
    public final org.emftext.sdk.concretesyntax.Import keywordimport() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Import element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;



        try {
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:151:1: (a0= TEXT a1= ':' a2= QUOTED_60_62 ( (a3= 'WITH' a4= 'SYNTAX' a5= TEXT ) )? )
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:152:2: a0= TEXT a1= ':' a2= QUOTED_60_62 ( (a3= 'WITH' a4= 'SYNTAX' a5= TEXT ) )?
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_keywordimport553); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("prefix"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("prefix"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a0, element); 
            }
            a1=(Token)match(input,26,FOLLOW_26_in_keywordimport561); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            }
            a2=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_keywordimport569); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("package"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a2,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenPackage proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenPackage();collectHiddenTokens(element, proxy); getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature("package"), resolved, proxy);element.eSet(element.eClass().getEStructuralFeature("package"), proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a2, element); copyLocalizationInfos((CommonToken) a2, proxy); 
            }
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:155:2: ( (a3= 'WITH' a4= 'SYNTAX' a5= TEXT ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==27) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:156:3: (a3= 'WITH' a4= 'SYNTAX' a5= TEXT )
                    {
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:156:3: (a3= 'WITH' a4= 'SYNTAX' a5= TEXT )
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:157:4: a3= 'WITH' a4= 'SYNTAX' a5= TEXT
                    {
                    a3=(Token)match(input,27,FOLLOW_27_in_keywordimport586); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); 
                    }
                    a4=(Token)match(input,28,FOLLOW_28_in_keywordimport596); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport();} collectHiddenTokens(element, (CommonToken)a4);copyLocalizationInfos((CommonToken)a4, element); 
                    }
                    a5=(Token)match(input,TEXT,FOLLOW_TEXT_in_keywordimport606); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("concreteSyntax"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a5,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.emftext.sdk.concretesyntax.ConcreteSyntax proxy = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();collectHiddenTokens(element, proxy); getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature("concreteSyntax"), resolved, proxy);element.eSet(element.eClass().getEStructuralFeature("concreteSyntax"), proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a5, element); copyLocalizationInfos((CommonToken) a5, proxy); 
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
    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:164:1: option returns [org.emftext.sdk.concretesyntax.Option element = null] : a0= TEXT a1= '=' a2= TEXT ;
    public final org.emftext.sdk.concretesyntax.Option option() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Option element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:167:1: (a0= TEXT a1= '=' a2= TEXT )
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:168:2: a0= TEXT a1= '=' a2= TEXT
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_option637); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createOption(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a0, element); 
            }
            a1=(Token)match(input,29,FOLLOW_29_in_option645); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createOption();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            }
            a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_option653); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createOption(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("value"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a2, element); 
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
    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:173:1: rule returns [org.emftext.sdk.concretesyntax.Rule element = null] : (a0= TEXT | a1= QNAME ) a2= '::=' a3= choice a4= ';' ;
    public final org.emftext.sdk.concretesyntax.Rule rule() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Rule element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        org.emftext.sdk.concretesyntax.Choice a3 = null;




        try {
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:176:1: ( (a0= TEXT | a1= QNAME ) a2= '::=' a3= choice a4= ';' )
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:177:2: (a0= TEXT | a1= QNAME ) a2= '::=' a3= choice a4= ';'
            {
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:177:2: (a0= TEXT | a1= QNAME )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==TEXT) ) {
                alt12=1;
            }
            else if ( (LA12_0==QNAME) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:178:3: a0= TEXT
                    {
                    a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_rule680); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createRule(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("metaclass"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();collectHiddenTokens(element, proxy); getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature("metaclass"), resolved, proxy);element.eSet(element.eClass().getEStructuralFeature("metaclass"), proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:181:3: a1= QNAME
                    {
                    a1=(Token)match(input,QNAME,FOLLOW_QNAME_in_rule694); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createRule(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QNAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("metaclass"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a1,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();collectHiddenTokens(element, proxy); getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature("metaclass"), resolved, proxy);element.eSet(element.eClass().getEStructuralFeature("metaclass"), proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a1, element); copyLocalizationInfos((CommonToken) a1, proxy); 
                    }

                    }
                    break;

            }

            a2=(Token)match(input,30,FOLLOW_30_in_rule705); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createRule();} collectHiddenTokens(element, (CommonToken)a2);copyLocalizationInfos((CommonToken)a2, element); 
            }
            pushFollow(FOLLOW_choice_in_rule713);
            a3=choice();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createRule(); element.eSet(element.eClass().getEStructuralFeature("definition"), a3); collectHiddenTokens(element, a3);copyLocalizationInfos(a3, element); 
            }
            a4=(Token)match(input,23,FOLLOW_23_in_rule721); if (state.failed) return element;
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
    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:188:1: sequence returns [org.emftext.sdk.concretesyntax.Sequence element = null] : (a0= definition )+ ;
    public final org.emftext.sdk.concretesyntax.Sequence sequence() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Sequence element =  null;

        org.emftext.sdk.concretesyntax.Definition a0 = null;




        try {
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:191:1: ( (a0= definition )+ )
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:192:2: (a0= definition )+
            {
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:192:2: (a0= definition )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==TEXT||LA13_0==QUOTED_34_34||(LA13_0>=TEXT_35_ && LA13_0<=TEXT_33_)||LA13_0==34) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:193:3: a0= definition
            	    {
            	    pushFollow(FOLLOW_definition_in_sequence748);
            	    a0=definition();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {
            	      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createSequence(); addObjectToList(element, "parts", a0); collectHiddenTokens(element, a0);copyLocalizationInfos(a0, element); 
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
        }
        return element;
    }
    // $ANTLR end "sequence"


    // $ANTLR start "choice"
    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:197:1: choice returns [org.emftext.sdk.concretesyntax.Choice element = null] : a0= sequence ( (a1= '|' a2= sequence ) )* ;
    public final org.emftext.sdk.concretesyntax.Choice choice() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Choice element =  null;

        Token a1=null;
        org.emftext.sdk.concretesyntax.Sequence a0 = null;

        org.emftext.sdk.concretesyntax.Sequence a2 = null;




        try {
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:200:1: (a0= sequence ( (a1= '|' a2= sequence ) )* )
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:201:2: a0= sequence ( (a1= '|' a2= sequence ) )*
            {
            pushFollow(FOLLOW_sequence_in_choice775);
            a0=sequence();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createChoice(); addObjectToList(element, "options", a0); collectHiddenTokens(element, a0);copyLocalizationInfos(a0, element); 
            }
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:202:2: ( (a1= '|' a2= sequence ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==31) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:203:3: (a1= '|' a2= sequence )
            	    {
            	    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:203:3: (a1= '|' a2= sequence )
            	    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:204:4: a1= '|' a2= sequence
            	    {
            	    a1=(Token)match(input,31,FOLLOW_31_in_choice792); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {
            	       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createChoice();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            	    }
            	    pushFollow(FOLLOW_sequence_in_choice802);
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
        }
        return element;
    }
    // $ANTLR end "choice"


    // $ANTLR start "csstring"
    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:210:1: csstring returns [org.emftext.sdk.concretesyntax.CsString element = null] : a0= QUOTED_34_34 ;
    public final org.emftext.sdk.concretesyntax.CsString csstring() throws RecognitionException {
        org.emftext.sdk.concretesyntax.CsString element =  null;

        Token a0=null;



        try {
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:213:1: (a0= QUOTED_34_34 )
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:214:2: a0= QUOTED_34_34
            {
            a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_csstring833); if (state.failed) return element;
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
    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:217:1: definedplaceholder returns [org.emftext.sdk.concretesyntax.DefinedPlaceholder element = null] : a0= TEXT a1= '[' a2= TEXT a3= ']' (a4= cardinality )? ;
    public final org.emftext.sdk.concretesyntax.DefinedPlaceholder definedplaceholder() throws RecognitionException {
        org.emftext.sdk.concretesyntax.DefinedPlaceholder element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        org.emftext.sdk.concretesyntax.Cardinality a4 = null;




        try {
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:220:1: (a0= TEXT a1= '[' a2= TEXT a3= ']' (a4= cardinality )? )
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:221:2: a0= TEXT a1= '[' a2= TEXT a3= ']' (a4= cardinality )?
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_definedplaceholder856); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDefinedPlaceholder(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenFeature();collectHiddenTokens(element, proxy); getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature("feature"), resolved, proxy);element.eSet(element.eClass().getEStructuralFeature("feature"), proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); 
            }
            a1=(Token)match(input,32,FOLLOW_32_in_definedplaceholder864); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDefinedPlaceholder();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            }
            a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_definedplaceholder872); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDefinedPlaceholder(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("token"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a2,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.emftext.sdk.concretesyntax.NormalToken proxy = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken();collectHiddenTokens(element, proxy); getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature("token"), resolved, proxy);element.eSet(element.eClass().getEStructuralFeature("token"), proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a2, element); copyLocalizationInfos((CommonToken) a2, proxy); 
            }
            a3=(Token)match(input,33,FOLLOW_33_in_definedplaceholder880); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDefinedPlaceholder();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); 
            }
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:225:2: (a4= cardinality )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=36 && LA15_0<=38)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:226:3: a4= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_definedplaceholder892);
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
    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:230:1: derivedplaceholder returns [org.emftext.sdk.concretesyntax.DerivedPlaceholder element = null] : a0= TEXT a1= '[' ( (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? ) )? a5= ']' (a6= cardinality )? ;
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
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:233:1: (a0= TEXT a1= '[' ( (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? ) )? a5= ']' (a6= cardinality )? )
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:234:2: a0= TEXT a1= '[' ( (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? ) )? a5= ']' (a6= cardinality )?
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_derivedplaceholder919); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenFeature();collectHiddenTokens(element, proxy); getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature("feature"), resolved, proxy);element.eSet(element.eClass().getEStructuralFeature("feature"), proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); 
            }
            a1=(Token)match(input,32,FOLLOW_32_in_derivedplaceholder927); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
            }
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:236:2: ( (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==QUOTED_39_39) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:237:3: (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? )
                    {
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:237:3: (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? )
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:238:4: a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )?
                    {
                    a2=(Token)match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_derivedplaceholder944); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("prefix"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("prefix"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a2, element); 
                    }
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:239:4: ( (a3= ',' a4= QUOTED_39_39 ) )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==18) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:240:5: (a3= ',' a4= QUOTED_39_39 )
                            {
                            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:240:5: (a3= ',' a4= QUOTED_39_39 )
                            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:241:6: a3= ',' a4= QUOTED_39_39
                            {
                            a3=(Token)match(input,18,FOLLOW_18_in_derivedplaceholder967); if (state.failed) return element;
                            if ( state.backtracking==0 ) {
                               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); 
                            }
                            a4=(Token)match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_derivedplaceholder979); if (state.failed) return element;
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

            a5=(Token)match(input,33,FOLLOW_33_in_derivedplaceholder1007); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder();} collectHiddenTokens(element, (CommonToken)a5);copyLocalizationInfos((CommonToken)a5, element); 
            }
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:248:2: (a6= cardinality )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=36 && LA18_0<=38)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:249:3: a6= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_derivedplaceholder1019);
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
    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:253:1: containment returns [org.emftext.sdk.concretesyntax.Containment element = null] : a0= TEXT ( (a1= ':' (a2= TEXT | a3= QNAME ) ) )? (a4= cardinality )? ;
    public final org.emftext.sdk.concretesyntax.Containment containment() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Containment element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        org.emftext.sdk.concretesyntax.Cardinality a4 = null;




        try {
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:256:1: (a0= TEXT ( (a1= ':' (a2= TEXT | a3= QNAME ) ) )? (a4= cardinality )? )
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:257:2: a0= TEXT ( (a1= ':' (a2= TEXT | a3= QNAME ) ) )? (a4= cardinality )?
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_containment1046); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createContainment(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenFeature();collectHiddenTokens(element, proxy); getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature("feature"), resolved, proxy);element.eSet(element.eClass().getEStructuralFeature("feature"), proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); 
            }
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:258:2: ( (a1= ':' (a2= TEXT | a3= QNAME ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==26) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:259:3: (a1= ':' (a2= TEXT | a3= QNAME ) )
                    {
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:259:3: (a1= ':' (a2= TEXT | a3= QNAME ) )
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:260:4: a1= ':' (a2= TEXT | a3= QNAME )
                    {
                    a1=(Token)match(input,26,FOLLOW_26_in_containment1063); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createContainment();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); 
                    }
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:261:4: (a2= TEXT | a3= QNAME )
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==TEXT) ) {
                        alt19=1;
                    }
                    else if ( (LA19_0==QNAME) ) {
                        alt19=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 0, input);

                        throw nvae;
                    }
                    switch (alt19) {
                        case 1 :
                            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:262:5: a2= TEXT
                            {
                            a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_containment1079); if (state.failed) return element;
                            if ( state.backtracking==0 ) {
                              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createContainment(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("type"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a2,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();collectHiddenTokens(element, proxy); getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature("type"), resolved, proxy);element.eSet(element.eClass().getEStructuralFeature("type"), proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a2, element); copyLocalizationInfos((CommonToken) a2, proxy); 
                            }

                            }
                            break;
                        case 2 :
                            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:265:5: a3= QNAME
                            {
                            a3=(Token)match(input,QNAME,FOLLOW_QNAME_in_containment1097); if (state.failed) return element;
                            if ( state.backtracking==0 ) {
                              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createContainment(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QNAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("type"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a3,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();collectHiddenTokens(element, proxy); getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature("type"), resolved, proxy);element.eSet(element.eClass().getEStructuralFeature("type"), proxy); collectHiddenTokens(element, proxy);copyLocalizationInfos((CommonToken) a3, element); copyLocalizationInfos((CommonToken) a3, proxy); 
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:269:2: (a4= cardinality )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=36 && LA21_0<=38)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:270:3: a4= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_containment1122);
                    a4=cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createContainment(); element.eSet(element.eClass().getEStructuralFeature("cardinality"), a4); collectHiddenTokens(element, a4);copyLocalizationInfos(a4, element); 
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
    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:274:1: compounddefinition returns [org.emftext.sdk.concretesyntax.CompoundDefinition element = null] : a0= '(' a1= choice a2= ')' (a3= cardinality )? ;
    public final org.emftext.sdk.concretesyntax.CompoundDefinition compounddefinition() throws RecognitionException {
        org.emftext.sdk.concretesyntax.CompoundDefinition element =  null;

        Token a0=null;
        Token a2=null;
        org.emftext.sdk.concretesyntax.Choice a1 = null;

        org.emftext.sdk.concretesyntax.Cardinality a3 = null;




        try {
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:277:1: (a0= '(' a1= choice a2= ')' (a3= cardinality )? )
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:278:2: a0= '(' a1= choice a2= ')' (a3= cardinality )?
            {
            a0=(Token)match(input,34,FOLLOW_34_in_compounddefinition1149); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createCompoundDefinition();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            pushFollow(FOLLOW_choice_in_compounddefinition1157);
            a1=choice();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createCompoundDefinition(); element.eSet(element.eClass().getEStructuralFeature("definitions"), a1); collectHiddenTokens(element, a1);copyLocalizationInfos(a1, element); 
            }
            a2=(Token)match(input,35,FOLLOW_35_in_compounddefinition1165); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createCompoundDefinition();} collectHiddenTokens(element, (CommonToken)a2);copyLocalizationInfos((CommonToken)a2, element); 
            }
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:281:2: (a3= cardinality )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=36 && LA22_0<=38)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:282:3: a3= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_compounddefinition1177);
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
    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:286:1: plus returns [org.emftext.sdk.concretesyntax.PLUS element = null] : a0= '+' ;
    public final org.emftext.sdk.concretesyntax.PLUS plus() throws RecognitionException {
        org.emftext.sdk.concretesyntax.PLUS element =  null;

        Token a0=null;



        try {
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:289:1: (a0= '+' )
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:290:2: a0= '+'
            {
            a0=(Token)match(input,36,FOLLOW_36_in_plus1204); if (state.failed) return element;
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
    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:293:1: star returns [org.emftext.sdk.concretesyntax.STAR element = null] : a0= '*' ;
    public final org.emftext.sdk.concretesyntax.STAR star() throws RecognitionException {
        org.emftext.sdk.concretesyntax.STAR element =  null;

        Token a0=null;



        try {
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:296:1: (a0= '*' )
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:297:2: a0= '*'
            {
            a0=(Token)match(input,37,FOLLOW_37_in_star1227); if (state.failed) return element;
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
    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:300:1: questionmark returns [org.emftext.sdk.concretesyntax.QUESTIONMARK element = null] : a0= '?' ;
    public final org.emftext.sdk.concretesyntax.QUESTIONMARK questionmark() throws RecognitionException {
        org.emftext.sdk.concretesyntax.QUESTIONMARK element =  null;

        Token a0=null;



        try {
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:303:1: (a0= '?' )
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:304:2: a0= '?'
            {
            a0=(Token)match(input,38,FOLLOW_38_in_questionmark1250); if (state.failed) return element;
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
    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:307:1: whitespaces returns [org.emftext.sdk.concretesyntax.WhiteSpaces element = null] : a0= TEXT_35_ ;
    public final org.emftext.sdk.concretesyntax.WhiteSpaces whitespaces() throws RecognitionException {
        org.emftext.sdk.concretesyntax.WhiteSpaces element =  null;

        Token a0=null;



        try {
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:310:1: (a0= TEXT_35_ )
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:311:2: a0= TEXT_35_
            {
            a0=(Token)match(input,TEXT_35_,FOLLOW_TEXT_35__in_whitespaces1273); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createWhiteSpaces(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT_35_");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("amount"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.Integer resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("amount"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a0, element); 
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
    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:314:1: linebreak returns [org.emftext.sdk.concretesyntax.LineBreak element = null] : a0= TEXT_33_ ;
    public final org.emftext.sdk.concretesyntax.LineBreak linebreak() throws RecognitionException {
        org.emftext.sdk.concretesyntax.LineBreak element =  null;

        Token a0=null;



        try {
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:317:1: (a0= TEXT_33_ )
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:318:2: a0= TEXT_33_
            {
            a0=(Token)match(input,TEXT_33_,FOLLOW_TEXT_33__in_linebreak1296); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createLineBreak(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT_33_");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("tab"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.Integer resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("tab"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a0, element); 
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
    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:321:1: normaltoken returns [org.emftext.sdk.concretesyntax.NormalToken element = null] : a0= 'DEFINE' a1= TEXT a2= QUOTED_36_36 ( (a3= 'COLLECT' a4= 'IN' a5= TEXT ) )? ;
    public final org.emftext.sdk.concretesyntax.NormalToken normaltoken() throws RecognitionException {
        org.emftext.sdk.concretesyntax.NormalToken element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;



        try {
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:324:1: (a0= 'DEFINE' a1= TEXT a2= QUOTED_36_36 ( (a3= 'COLLECT' a4= 'IN' a5= TEXT ) )? )
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:325:2: a0= 'DEFINE' a1= TEXT a2= QUOTED_36_36 ( (a3= 'COLLECT' a4= 'IN' a5= TEXT ) )?
            {
            a0=(Token)match(input,39,FOLLOW_39_in_normaltoken1319); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_normaltoken1327); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a1, element); 
            }
            a2=(Token)match(input,QUOTED_36_36,FOLLOW_QUOTED_36_36_in_normaltoken1335); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_36_36");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("regex"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("regex"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a2, element); 
            }
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:328:2: ( (a3= 'COLLECT' a4= 'IN' a5= TEXT ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==40) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:329:3: (a3= 'COLLECT' a4= 'IN' a5= TEXT )
                    {
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:329:3: (a3= 'COLLECT' a4= 'IN' a5= TEXT )
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:330:4: a3= 'COLLECT' a4= 'IN' a5= TEXT
                    {
                    a3=(Token)match(input,40,FOLLOW_40_in_normaltoken1352); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); 
                    }
                    a4=(Token)match(input,41,FOLLOW_41_in_normaltoken1362); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken();} collectHiddenTokens(element, (CommonToken)a4);copyLocalizationInfos((CommonToken)a4, element); 
                    }
                    a5=(Token)match(input,TEXT,FOLLOW_TEXT_in_normaltoken1372); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("attributeName"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("attributeName"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a5, element); 
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
    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:337:1: decoratedtoken returns [org.emftext.sdk.concretesyntax.DecoratedToken element = null] : a0= 'DEFINE' a1= TEXT (a2= '[' (a3= QUOTED_39_39 ) a4= ']' ) a5= QUOTED_36_36 (a6= '[' (a7= QUOTED_39_39 ) a8= ']' ) ( (a9= 'COLLECT' a10= 'IN' a11= TEXT ) )? ;
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
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:340:1: (a0= 'DEFINE' a1= TEXT (a2= '[' (a3= QUOTED_39_39 ) a4= ']' ) a5= QUOTED_36_36 (a6= '[' (a7= QUOTED_39_39 ) a8= ']' ) ( (a9= 'COLLECT' a10= 'IN' a11= TEXT ) )? )
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:341:2: a0= 'DEFINE' a1= TEXT (a2= '[' (a3= QUOTED_39_39 ) a4= ']' ) a5= QUOTED_36_36 (a6= '[' (a7= QUOTED_39_39 ) a8= ']' ) ( (a9= 'COLLECT' a10= 'IN' a11= TEXT ) )?
            {
            a0=(Token)match(input,39,FOLLOW_39_in_decoratedtoken1403); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_decoratedtoken1411); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a1, element); 
            }
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:343:2: (a2= '[' (a3= QUOTED_39_39 ) a4= ']' )
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:344:3: a2= '[' (a3= QUOTED_39_39 ) a4= ']'
            {
            a2=(Token)match(input,32,FOLLOW_32_in_decoratedtoken1423); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a2);copyLocalizationInfos((CommonToken)a2, element); 
            }
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:345:3: (a3= QUOTED_39_39 )
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:346:4: a3= QUOTED_39_39
            {
            a3=(Token)match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_decoratedtoken1437); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("prefix"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a3,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("prefix"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a3, element); 
            }

            }

            a4=(Token)match(input,33,FOLLOW_33_in_decoratedtoken1450); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a4);copyLocalizationInfos((CommonToken)a4, element); 
            }

            }

            a5=(Token)match(input,QUOTED_36_36,FOLLOW_QUOTED_36_36_in_decoratedtoken1461); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_36_36");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("regex"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("regex"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a5, element); 
            }
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:351:2: (a6= '[' (a7= QUOTED_39_39 ) a8= ']' )
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:352:3: a6= '[' (a7= QUOTED_39_39 ) a8= ']'
            {
            a6=(Token)match(input,32,FOLLOW_32_in_decoratedtoken1473); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a6);copyLocalizationInfos((CommonToken)a6, element); 
            }
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:353:3: (a7= QUOTED_39_39 )
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:354:4: a7= QUOTED_39_39
            {
            a7=(Token)match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_decoratedtoken1487); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a7.getText(),element.eClass().getEStructuralFeature("suffix"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a7,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suffix"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a7, element); 
            }

            }

            a8=(Token)match(input,33,FOLLOW_33_in_decoratedtoken1500); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a8);copyLocalizationInfos((CommonToken)a8, element); 
            }

            }

            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:358:2: ( (a9= 'COLLECT' a10= 'IN' a11= TEXT ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==40) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:359:3: (a9= 'COLLECT' a10= 'IN' a11= TEXT )
                    {
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:359:3: (a9= 'COLLECT' a10= 'IN' a11= TEXT )
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:360:4: a9= 'COLLECT' a10= 'IN' a11= TEXT
                    {
                    a9=(Token)match(input,40,FOLLOW_40_in_decoratedtoken1520); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a9);copyLocalizationInfos((CommonToken)a9, element); 
                    }
                    a10=(Token)match(input,41,FOLLOW_41_in_decoratedtoken1530); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a10);copyLocalizationInfos((CommonToken)a10, element); 
                    }
                    a11=(Token)match(input,TEXT,FOLLOW_TEXT_in_decoratedtoken1540); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a11.getText(),element.eClass().getEStructuralFeature("attributeName"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a11,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("attributeName"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a11, element); 
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
    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:367:1: predefinedtoken returns [org.emftext.sdk.concretesyntax.PreDefinedToken element = null] : a0= 'PREDEFINED' a1= TEXT ( (a2= 'COLLECT' a3= 'IN' a4= TEXT ) )? ;
    public final org.emftext.sdk.concretesyntax.PreDefinedToken predefinedtoken() throws RecognitionException {
        org.emftext.sdk.concretesyntax.PreDefinedToken element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;



        try {
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:370:1: (a0= 'PREDEFINED' a1= TEXT ( (a2= 'COLLECT' a3= 'IN' a4= TEXT ) )? )
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:371:2: a0= 'PREDEFINED' a1= TEXT ( (a2= 'COLLECT' a3= 'IN' a4= TEXT ) )?
            {
            a0=(Token)match(input,42,FOLLOW_42_in_predefinedtoken1571); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_predefinedtoken1579); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a1, element); 
            }
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:373:2: ( (a2= 'COLLECT' a3= 'IN' a4= TEXT ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==40) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:374:3: (a2= 'COLLECT' a3= 'IN' a4= TEXT )
                    {
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:374:3: (a2= 'COLLECT' a3= 'IN' a4= TEXT )
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:375:4: a2= 'COLLECT' a3= 'IN' a4= TEXT
                    {
                    a2=(Token)match(input,40,FOLLOW_40_in_predefinedtoken1596); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken();} collectHiddenTokens(element, (CommonToken)a2);copyLocalizationInfos((CommonToken)a2, element); 
                    }
                    a3=(Token)match(input,41,FOLLOW_41_in_predefinedtoken1606); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); 
                    }
                    a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_predefinedtoken1616); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken(); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("attributeName"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.impl.TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("attributeName"), resolved); collectHiddenTokens(element, resolved);copyLocalizationInfos((CommonToken) a4, element); 
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
    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:382:1: tokendefinition returns [org.emftext.sdk.concretesyntax.TokenDefinition element = null] : (c0= normaltoken | c1= decoratedtoken | c2= predefinedtoken );
    public final org.emftext.sdk.concretesyntax.TokenDefinition tokendefinition() throws RecognitionException {
        org.emftext.sdk.concretesyntax.TokenDefinition element =  null;

        org.emftext.sdk.concretesyntax.NormalToken c0 = null;

        org.emftext.sdk.concretesyntax.DecoratedToken c1 = null;

        org.emftext.sdk.concretesyntax.PreDefinedToken c2 = null;


        try {
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:384:1: (c0= normaltoken | c1= decoratedtoken | c2= predefinedtoken )
            int alt26=3;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==39) ) {
                int LA26_1 = input.LA(2);

                if ( (LA26_1==TEXT) ) {
                    int LA26_3 = input.LA(3);

                    if ( (LA26_3==QUOTED_36_36) ) {
                        alt26=1;
                    }
                    else if ( (LA26_3==32) ) {
                        alt26=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA26_0==42) ) {
                alt26=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:385:2: c0= normaltoken
                    {
                    pushFollow(FOLLOW_normaltoken_in_tokendefinition1643);
                    c0=normaltoken();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:386:2: c1= decoratedtoken
                    {
                    pushFollow(FOLLOW_decoratedtoken_in_tokendefinition1653);
                    c1=decoratedtoken();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:387:2: c2= predefinedtoken
                    {
                    pushFollow(FOLLOW_predefinedtoken_in_tokendefinition1663);
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
    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:390:1: definition returns [org.emftext.sdk.concretesyntax.Definition element = null] : (c0= csstring | c1= definedplaceholder | c2= derivedplaceholder | c3= containment | c4= compounddefinition | c5= whitespaces | c6= linebreak );
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
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:392:1: (c0= csstring | c1= definedplaceholder | c2= derivedplaceholder | c3= containment | c4= compounddefinition | c5= whitespaces | c6= linebreak )
            int alt27=7;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:393:2: c0= csstring
                    {
                    pushFollow(FOLLOW_csstring_in_definition1682);
                    c0=csstring();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:394:2: c1= definedplaceholder
                    {
                    pushFollow(FOLLOW_definedplaceholder_in_definition1692);
                    c1=definedplaceholder();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:395:2: c2= derivedplaceholder
                    {
                    pushFollow(FOLLOW_derivedplaceholder_in_definition1702);
                    c2=derivedplaceholder();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; 
                    }

                    }
                    break;
                case 4 :
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:396:2: c3= containment
                    {
                    pushFollow(FOLLOW_containment_in_definition1712);
                    c3=containment();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c3; 
                    }

                    }
                    break;
                case 5 :
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:397:2: c4= compounddefinition
                    {
                    pushFollow(FOLLOW_compounddefinition_in_definition1722);
                    c4=compounddefinition();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c4; 
                    }

                    }
                    break;
                case 6 :
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:398:2: c5= whitespaces
                    {
                    pushFollow(FOLLOW_whitespaces_in_definition1732);
                    c5=whitespaces();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c5; 
                    }

                    }
                    break;
                case 7 :
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:399:2: c6= linebreak
                    {
                    pushFollow(FOLLOW_linebreak_in_definition1742);
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
    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:402:1: cardinality returns [org.emftext.sdk.concretesyntax.Cardinality element = null] : (c0= plus | c1= star | c2= questionmark );
    public final org.emftext.sdk.concretesyntax.Cardinality cardinality() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Cardinality element =  null;

        org.emftext.sdk.concretesyntax.PLUS c0 = null;

        org.emftext.sdk.concretesyntax.STAR c1 = null;

        org.emftext.sdk.concretesyntax.QUESTIONMARK c2 = null;


        try {
            // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:404:1: (c0= plus | c1= star | c2= questionmark )
            int alt28=3;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt28=1;
                }
                break;
            case 37:
                {
                alt28=2;
                }
                break;
            case 38:
                {
                alt28=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:405:2: c0= plus
                    {
                    pushFollow(FOLLOW_plus_in_cardinality1761);
                    c0=plus();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:406:2: c1= star
                    {
                    pushFollow(FOLLOW_star_in_cardinality1771);
                    c1=star();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // /Users/jj2/workspaces/ReusewareDevelopment/org.emftext.sdk.concretesyntax.resource.cs/src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:407:2: c2= questionmark
                    {
                    pushFollow(FOLLOW_questionmark_in_cardinality1781);
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


    protected DFA27 dfa27 = new DFA27(this);
    static final String DFA27_eotS =
        "\12\uffff";
    static final String DFA27_eofS =
        "\2\uffff\1\6\7\uffff";
    static final String DFA27_minS =
        "\1\4\1\uffff\1\4\4\uffff\1\4\2\uffff";
    static final String DFA27_maxS =
        "\1\42\1\uffff\1\46\4\uffff\1\41\2\uffff";
    static final String DFA27_acceptS =
        "\1\uffff\1\1\1\uffff\1\5\1\6\1\7\1\4\1\uffff\1\3\1\2";
    static final String DFA27_specialS =
        "\12\uffff}>";
    static final String[] DFA27_transitionS = {
            "\1\2\2\uffff\1\1\1\uffff\1\4\1\5\27\uffff\1\3",
            "",
            "\1\6\2\uffff\1\6\1\uffff\2\6\14\uffff\1\6\2\uffff\1\6\4\uffff"+
            "\1\6\1\7\1\uffff\5\6",
            "",
            "",
            "",
            "",
            "\1\11\3\uffff\1\10\30\uffff\1\10",
            "",
            ""
    };

    static final short[] DFA27_eot = DFA.unpackEncodedString(DFA27_eotS);
    static final short[] DFA27_eof = DFA.unpackEncodedString(DFA27_eofS);
    static final char[] DFA27_min = DFA.unpackEncodedStringToUnsignedChars(DFA27_minS);
    static final char[] DFA27_max = DFA.unpackEncodedStringToUnsignedChars(DFA27_maxS);
    static final short[] DFA27_accept = DFA.unpackEncodedString(DFA27_acceptS);
    static final short[] DFA27_special = DFA.unpackEncodedString(DFA27_specialS);
    static final short[][] DFA27_transition;

    static {
        int numStates = DFA27_transitionS.length;
        DFA27_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA27_transition[i] = DFA.unpackEncodedString(DFA27_transitionS[i]);
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = DFA27_eot;
            this.eof = DFA27_eof;
            this.min = DFA27_min;
            this.max = DFA27_max;
            this.accept = DFA27_accept;
            this.special = DFA27_special;
            this.transition = DFA27_transition;
        }
        public String getDescription() {
            return "390:1: definition returns [org.emftext.sdk.concretesyntax.Definition element = null] : (c0= csstring | c1= definedplaceholder | c2= derivedplaceholder | c3= containment | c4= compounddefinition | c5= whitespaces | c6= linebreak );";
        }
    }
 

    public static final BitSet FOLLOW_concretesyntax_in_start65 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_concretesyntax92 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_concretesyntax100 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_concretesyntax108 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_concretesyntax116 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_concretesyntax124 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_TEXT_in_concretesyntax136 = new BitSet(new long[]{0x00000000034C0000L});
    public static final BitSet FOLLOW_QNAME_in_concretesyntax150 = new BitSet(new long[]{0x00000000034C0000L});
    public static final BitSet FOLLOW_18_in_concretesyntax170 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_TEXT_in_concretesyntax186 = new BitSet(new long[]{0x00000000034C0000L});
    public static final BitSet FOLLOW_QNAME_in_concretesyntax204 = new BitSet(new long[]{0x00000000034C0000L});
    public static final BitSet FOLLOW_19_in_concretesyntax234 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_concretesyntax244 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_keywordimport_in_concretesyntax267 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_21_in_concretesyntax289 = new BitSet(new long[]{0x0000000003400000L});
    public static final BitSet FOLLOW_22_in_concretesyntax314 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_concretesyntax324 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_option_in_concretesyntax347 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_concretesyntax359 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_21_in_concretesyntax381 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_concretesyntax406 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_concretesyntax416 = new BitSet(new long[]{0x0000048000200000L});
    public static final BitSet FOLLOW_tokendefinition_in_concretesyntax439 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_concretesyntax451 = new BitSet(new long[]{0x0000048000200000L});
    public static final BitSet FOLLOW_21_in_concretesyntax473 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_concretesyntax489 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_concretesyntax497 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_rule_in_concretesyntax514 = new BitSet(new long[]{0x0000000000200050L});
    public static final BitSet FOLLOW_21_in_concretesyntax530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_keywordimport553 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_keywordimport561 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_keywordimport569 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_keywordimport586 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_keywordimport596 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_keywordimport606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_option637 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_option645 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_option653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_rule680 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_QNAME_in_rule694 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_rule705 = new BitSet(new long[]{0x0000000400000690L});
    public static final BitSet FOLLOW_choice_in_rule713 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_rule721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definition_in_sequence748 = new BitSet(new long[]{0x0000000400000692L});
    public static final BitSet FOLLOW_sequence_in_choice775 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_choice792 = new BitSet(new long[]{0x0000000400000690L});
    public static final BitSet FOLLOW_sequence_in_choice802 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_csstring833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_definedplaceholder856 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_definedplaceholder864 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_definedplaceholder872 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_definedplaceholder880 = new BitSet(new long[]{0x0000007000000002L});
    public static final BitSet FOLLOW_cardinality_in_definedplaceholder892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_derivedplaceholder919 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_derivedplaceholder927 = new BitSet(new long[]{0x0000000200000100L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_derivedplaceholder944 = new BitSet(new long[]{0x0000000200040000L});
    public static final BitSet FOLLOW_18_in_derivedplaceholder967 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_derivedplaceholder979 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_derivedplaceholder1007 = new BitSet(new long[]{0x0000007000000002L});
    public static final BitSet FOLLOW_cardinality_in_derivedplaceholder1019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_containment1046 = new BitSet(new long[]{0x0000007004000002L});
    public static final BitSet FOLLOW_26_in_containment1063 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_TEXT_in_containment1079 = new BitSet(new long[]{0x0000007000000002L});
    public static final BitSet FOLLOW_QNAME_in_containment1097 = new BitSet(new long[]{0x0000007000000002L});
    public static final BitSet FOLLOW_cardinality_in_containment1122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_compounddefinition1149 = new BitSet(new long[]{0x0000000400000690L});
    public static final BitSet FOLLOW_choice_in_compounddefinition1157 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_compounddefinition1165 = new BitSet(new long[]{0x0000007000000002L});
    public static final BitSet FOLLOW_cardinality_in_compounddefinition1177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_plus1204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_star1227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_questionmark1250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_35__in_whitespaces1273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_33__in_linebreak1296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_normaltoken1319 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_normaltoken1327 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_QUOTED_36_36_in_normaltoken1335 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_normaltoken1352 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_normaltoken1362 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_normaltoken1372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_decoratedtoken1403 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_decoratedtoken1411 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_decoratedtoken1423 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_decoratedtoken1437 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_decoratedtoken1450 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_QUOTED_36_36_in_decoratedtoken1461 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_decoratedtoken1473 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_decoratedtoken1487 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_decoratedtoken1500 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_decoratedtoken1520 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_decoratedtoken1530 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_decoratedtoken1540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_predefinedtoken1571 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_predefinedtoken1579 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_predefinedtoken1596 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_predefinedtoken1606 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_predefinedtoken1616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normaltoken_in_tokendefinition1643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decoratedtoken_in_tokendefinition1653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predefinedtoken_in_tokendefinition1663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_csstring_in_definition1682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definedplaceholder_in_definition1692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_derivedplaceholder_in_definition1702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_containment_in_definition1712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compounddefinition_in_definition1722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whitespaces_in_definition1732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_linebreak_in_definition1742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_plus_in_cardinality1761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_star_in_cardinality1771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_questionmark_in_cardinality1781 = new BitSet(new long[]{0x0000000000000002L});

}