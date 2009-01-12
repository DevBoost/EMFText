// $ANTLR 3.1.1 ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g 2009-01-12 12:43:14

package org.emftext.sdk.concretesyntax.resource.cs;

import java.util.List;

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
import org.emftext.runtime.resource.impl.EMFTextParserImpl;
public class CsParser extends EMFTextParserImpl {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "TEXT", "QUOTED_60_62", "QNAME", "QUOTED_34_34", "QUOTED_39_39", "TEXT_35_", "TEXT_33_", "QUOTED_36_36", "COMMENTS", "LB", "WS", "'SYNTAXDEF'", "'FOR'", "'START'", "','", "'IMPORTS'", "'{'", "'}'", "'OPTIONS'", "';'", "'TOKENS'", "'RULES'", "':'", "'WITH'", "'SYNTAX'", "'='", "'::='", "'|'", "'['", "']'", "'('", "')'", "'+'", "'*'", "'?'", "'DEFINE'", "'COLLECT'", "'IN'", "'PREDEFINED'"
    };
    public static final int T__42=42;
    public static final int T__35=35;
    public static final int T__28=28;
    public static final int T__23=23;
    public static final int QUOTED_36_36=11;
    public static final int T__36=36;
    public static final int T__20=20;
    public static final int WS=14;
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
    public static final int LB=13;
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
    public String getGrammarFileName() { return "./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g"; }


    	private org.emftext.runtime.resource.ITokenResolverFactory tokenResolverFactory = new CsTokenResolverFactory();
    	private int lastPosition;

    	protected EObject doParse() throws RecognitionException {
    	lastPosition = 0;
    		((CsLexer)getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((CsLexer)getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		return start();
    	}

    	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element) {
    		int currentPos = getTokenStream().index();
    		for (int pos = lastPosition; pos < currentPos; pos++) {
    			Token token = getTokenStream().get(pos);
    			int channel = token.getChannel();
    			if (channel == 99) {
    			}
    		}
    		lastPosition = currentPos;
    	}



    // $ANTLR start "start"
    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:53:1: start returns [ EObject element = null] : c0= concretesyntax EOF ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;

        org.emftext.sdk.concretesyntax.ConcreteSyntax c0 = null;


        try {
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:55:1: (c0= concretesyntax EOF )
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:56:1: c0= concretesyntax EOF
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
    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:61:1: concretesyntax returns [org.emftext.sdk.concretesyntax.ConcreteSyntax element = null] : a0= 'SYNTAXDEF' a1= TEXT a2= 'FOR' a3= QUOTED_60_62 a4= 'START' (a5= TEXT | a6= QNAME ) ( (a7= ',' (a8= TEXT | a9= QNAME ) ) )* ( (a10= 'IMPORTS' a11= '{' ( (a12= keywordimport ) )* a13= '}' ) )? ( (a14= 'OPTIONS' a15= '{' ( (a16= option a17= ';' ) )* a18= '}' ) )? ( (a19= 'TOKENS' a20= '{' ( (a21= tokendefinition a22= ';' ) )* a23= '}' ) )? a24= 'RULES' a25= '{' ( (a26= rule )+ ) a27= '}' ;
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
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:64:1: (a0= 'SYNTAXDEF' a1= TEXT a2= 'FOR' a3= QUOTED_60_62 a4= 'START' (a5= TEXT | a6= QNAME ) ( (a7= ',' (a8= TEXT | a9= QNAME ) ) )* ( (a10= 'IMPORTS' a11= '{' ( (a12= keywordimport ) )* a13= '}' ) )? ( (a14= 'OPTIONS' a15= '{' ( (a16= option a17= ';' ) )* a18= '}' ) )? ( (a19= 'TOKENS' a20= '{' ( (a21= tokendefinition a22= ';' ) )* a23= '}' ) )? a24= 'RULES' a25= '{' ( (a26= rule )+ ) a27= '}' )
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:65:2: a0= 'SYNTAXDEF' a1= TEXT a2= 'FOR' a3= QUOTED_60_62 a4= 'START' (a5= TEXT | a6= QNAME ) ( (a7= ',' (a8= TEXT | a9= QNAME ) ) )* ( (a10= 'IMPORTS' a11= '{' ( (a12= keywordimport ) )* a13= '}' ) )? ( (a14= 'OPTIONS' a15= '{' ( (a16= option a17= ';' ) )* a18= '}' ) )? ( (a19= 'TOKENS' a20= '{' ( (a21= tokendefinition a22= ';' ) )* a23= '}' ) )? a24= 'RULES' a25= '{' ( (a26= rule )+ ) a27= '}'
            {
            a0=(Token)match(input,15,FOLLOW_15_in_concretesyntax92); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_concretesyntax100); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();collectHiddenTokens(element); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a1, element); 
            }
            a2=(Token)match(input,16,FOLLOW_16_in_concretesyntax108); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a2, element); 
            }
            a3=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_concretesyntax116); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();collectHiddenTokens(element); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("package"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a3,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenPackage proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenPackage();collectHiddenTokens(element);((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("package"), proxy); copyLocalizationInfos((CommonToken) a3, element); copyLocalizationInfos((CommonToken) a3, proxy); 
            }
            a4=(Token)match(input,17,FOLLOW_17_in_concretesyntax124); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a4, element); 
            }
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:70:2: (a5= TEXT | a6= QNAME )
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
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:71:3: a5= TEXT
                    {
                    a5=(Token)match(input,TEXT,FOLLOW_TEXT_in_concretesyntax136); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();collectHiddenTokens(element); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a5,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();collectHiddenTokens(element);((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("startSymbols"))).add(proxy); copyLocalizationInfos((CommonToken) a5, element); copyLocalizationInfos((CommonToken) a5, proxy); 
                    }

                    }
                    break;
                case 2 :
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:74:3: a6= QNAME
                    {
                    a6=(Token)match(input,QNAME,FOLLOW_QNAME_in_concretesyntax150); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();collectHiddenTokens(element); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QNAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a6.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a6,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();collectHiddenTokens(element);((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("startSymbols"))).add(proxy); copyLocalizationInfos((CommonToken) a6, element); copyLocalizationInfos((CommonToken) a6, proxy); 
                    }

                    }
                    break;

            }

            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:76:2: ( (a7= ',' (a8= TEXT | a9= QNAME ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==18) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:77:3: (a7= ',' (a8= TEXT | a9= QNAME ) )
            	    {
            	    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:77:3: (a7= ',' (a8= TEXT | a9= QNAME ) )
            	    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:78:4: a7= ',' (a8= TEXT | a9= QNAME )
            	    {
            	    a7=(Token)match(input,18,FOLLOW_18_in_concretesyntax170); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {
            	       if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a7, element); 
            	    }
            	    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:79:4: (a8= TEXT | a9= QNAME )
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
            	            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:80:5: a8= TEXT
            	            {
            	            a8=(Token)match(input,TEXT,FOLLOW_TEXT_in_concretesyntax186); if (state.failed) return element;
            	            if ( state.backtracking==0 ) {
            	              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();collectHiddenTokens(element); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a8.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a8,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();collectHiddenTokens(element);((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("startSymbols"))).add(proxy); copyLocalizationInfos((CommonToken) a8, element); copyLocalizationInfos((CommonToken) a8, proxy); 
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:83:5: a9= QNAME
            	            {
            	            a9=(Token)match(input,QNAME,FOLLOW_QNAME_in_concretesyntax204); if (state.failed) return element;
            	            if ( state.backtracking==0 ) {
            	              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();collectHiddenTokens(element); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QNAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a9.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a9,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();collectHiddenTokens(element);((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("startSymbols"))).add(proxy); copyLocalizationInfos((CommonToken) a9, element); copyLocalizationInfos((CommonToken) a9, proxy); 
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

            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:87:2: ( (a10= 'IMPORTS' a11= '{' ( (a12= keywordimport ) )* a13= '}' ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==19) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:88:3: (a10= 'IMPORTS' a11= '{' ( (a12= keywordimport ) )* a13= '}' )
                    {
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:88:3: (a10= 'IMPORTS' a11= '{' ( (a12= keywordimport ) )* a13= '}' )
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:89:4: a10= 'IMPORTS' a11= '{' ( (a12= keywordimport ) )* a13= '}'
                    {
                    a10=(Token)match(input,19,FOLLOW_19_in_concretesyntax234); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a10, element); 
                    }
                    a11=(Token)match(input,20,FOLLOW_20_in_concretesyntax244); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a11, element); 
                    }
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:91:4: ( (a12= keywordimport ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==TEXT) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:92:5: (a12= keywordimport )
                    	    {
                    	    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:92:5: (a12= keywordimport )
                    	    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:93:6: a12= keywordimport
                    	    {
                    	    pushFollow(FOLLOW_keywordimport_in_concretesyntax267);
                    	    a12=keywordimport();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();collectHiddenTokens(element); ((List) element.eGet(element.eClass().getEStructuralFeature("imports"))).add(a12); copyLocalizationInfos(a12, element); 
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
                       if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a13, element); 
                    }

                    }


                    }
                    break;

            }

            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:99:2: ( (a14= 'OPTIONS' a15= '{' ( (a16= option a17= ';' ) )* a18= '}' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==22) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:100:3: (a14= 'OPTIONS' a15= '{' ( (a16= option a17= ';' ) )* a18= '}' )
                    {
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:100:3: (a14= 'OPTIONS' a15= '{' ( (a16= option a17= ';' ) )* a18= '}' )
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:101:4: a14= 'OPTIONS' a15= '{' ( (a16= option a17= ';' ) )* a18= '}'
                    {
                    a14=(Token)match(input,22,FOLLOW_22_in_concretesyntax314); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a14, element); 
                    }
                    a15=(Token)match(input,20,FOLLOW_20_in_concretesyntax324); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a15, element); 
                    }
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:103:4: ( (a16= option a17= ';' ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==TEXT) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:104:5: (a16= option a17= ';' )
                    	    {
                    	    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:104:5: (a16= option a17= ';' )
                    	    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:105:6: a16= option a17= ';'
                    	    {
                    	    pushFollow(FOLLOW_option_in_concretesyntax347);
                    	    a16=option();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();collectHiddenTokens(element); ((List) element.eGet(element.eClass().getEStructuralFeature("options"))).add(a16); copyLocalizationInfos(a16, element); 
                    	    }
                    	    a17=(Token)match(input,23,FOLLOW_23_in_concretesyntax359); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	       if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a17, element); 
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
                       if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a18, element); 
                    }

                    }


                    }
                    break;

            }

            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:112:2: ( (a19= 'TOKENS' a20= '{' ( (a21= tokendefinition a22= ';' ) )* a23= '}' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==24) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:113:3: (a19= 'TOKENS' a20= '{' ( (a21= tokendefinition a22= ';' ) )* a23= '}' )
                    {
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:113:3: (a19= 'TOKENS' a20= '{' ( (a21= tokendefinition a22= ';' ) )* a23= '}' )
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:114:4: a19= 'TOKENS' a20= '{' ( (a21= tokendefinition a22= ';' ) )* a23= '}'
                    {
                    a19=(Token)match(input,24,FOLLOW_24_in_concretesyntax406); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a19, element); 
                    }
                    a20=(Token)match(input,20,FOLLOW_20_in_concretesyntax416); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a20, element); 
                    }
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:116:4: ( (a21= tokendefinition a22= ';' ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==39||LA8_0==42) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:117:5: (a21= tokendefinition a22= ';' )
                    	    {
                    	    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:117:5: (a21= tokendefinition a22= ';' )
                    	    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:118:6: a21= tokendefinition a22= ';'
                    	    {
                    	    pushFollow(FOLLOW_tokendefinition_in_concretesyntax439);
                    	    a21=tokendefinition();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();collectHiddenTokens(element); ((List) element.eGet(element.eClass().getEStructuralFeature("tokens"))).add(a21); copyLocalizationInfos(a21, element); 
                    	    }
                    	    a22=(Token)match(input,23,FOLLOW_23_in_concretesyntax451); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {
                    	       if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a22, element); 
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
                       if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a23, element); 
                    }

                    }


                    }
                    break;

            }

            a24=(Token)match(input,25,FOLLOW_25_in_concretesyntax489); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a24, element); 
            }
            a25=(Token)match(input,20,FOLLOW_20_in_concretesyntax497); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a25, element); 
            }
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:127:2: ( (a26= rule )+ )
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:128:3: (a26= rule )+
            {
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:128:3: (a26= rule )+
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
            	    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:129:4: a26= rule
            	    {
            	    pushFollow(FOLLOW_rule_in_concretesyntax514);
            	    a26=rule();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {
            	      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();collectHiddenTokens(element); ((List) element.eGet(element.eClass().getEStructuralFeature("rules"))).add(a26); copyLocalizationInfos(a26, element); 
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
               if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a27, element); 
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
    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:135:1: keywordimport returns [org.emftext.sdk.concretesyntax.Import element = null] : a0= TEXT a1= ':' a2= QUOTED_60_62 ( (a3= 'WITH' a4= 'SYNTAX' a5= TEXT ) )? ;
    public final org.emftext.sdk.concretesyntax.Import keywordimport() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Import element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;



        try {
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:138:1: (a0= TEXT a1= ':' a2= QUOTED_60_62 ( (a3= 'WITH' a4= 'SYNTAX' a5= TEXT ) )? )
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:139:2: a0= TEXT a1= ':' a2= QUOTED_60_62 ( (a3= 'WITH' a4= 'SYNTAX' a5= TEXT ) )?
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_keywordimport553); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport();collectHiddenTokens(element); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("prefix"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("prefix"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
            }
            a1=(Token)match(input,26,FOLLOW_26_in_keywordimport561); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a1, element); 
            }
            a2=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_keywordimport569); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport();collectHiddenTokens(element); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("package"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a2,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenPackage proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenPackage();collectHiddenTokens(element);((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("package"), proxy); copyLocalizationInfos((CommonToken) a2, element); copyLocalizationInfos((CommonToken) a2, proxy); 
            }
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:142:2: ( (a3= 'WITH' a4= 'SYNTAX' a5= TEXT ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==27) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:143:3: (a3= 'WITH' a4= 'SYNTAX' a5= TEXT )
                    {
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:143:3: (a3= 'WITH' a4= 'SYNTAX' a5= TEXT )
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:144:4: a3= 'WITH' a4= 'SYNTAX' a5= TEXT
                    {
                    a3=(Token)match(input,27,FOLLOW_27_in_keywordimport586); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a3, element); 
                    }
                    a4=(Token)match(input,28,FOLLOW_28_in_keywordimport596); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a4, element); 
                    }
                    a5=(Token)match(input,TEXT,FOLLOW_TEXT_in_keywordimport606); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport();collectHiddenTokens(element); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("concreteSyntax"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a5,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.emftext.sdk.concretesyntax.ConcreteSyntax proxy = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();collectHiddenTokens(element);((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("concreteSyntax"), proxy); copyLocalizationInfos((CommonToken) a5, element); copyLocalizationInfos((CommonToken) a5, proxy); 
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
    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:151:1: option returns [org.emftext.sdk.concretesyntax.Option element = null] : a0= TEXT a1= '=' a2= TEXT ;
    public final org.emftext.sdk.concretesyntax.Option option() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Option element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:154:1: (a0= TEXT a1= '=' a2= TEXT )
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:155:2: a0= TEXT a1= '=' a2= TEXT
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_option637); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createOption();collectHiddenTokens(element); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
            }
            a1=(Token)match(input,29,FOLLOW_29_in_option645); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createOption();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a1, element); 
            }
            a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_option653); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createOption();collectHiddenTokens(element); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("value"), resolved); copyLocalizationInfos((CommonToken) a2, element); 
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
    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:160:1: rule returns [org.emftext.sdk.concretesyntax.Rule element = null] : (a0= TEXT | a1= QNAME ) a2= '::=' a3= choice a4= ';' ;
    public final org.emftext.sdk.concretesyntax.Rule rule() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Rule element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        org.emftext.sdk.concretesyntax.Choice a3 = null;




        try {
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:163:1: ( (a0= TEXT | a1= QNAME ) a2= '::=' a3= choice a4= ';' )
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:164:2: (a0= TEXT | a1= QNAME ) a2= '::=' a3= choice a4= ';'
            {
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:164:2: (a0= TEXT | a1= QNAME )
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
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:165:3: a0= TEXT
                    {
                    a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_rule680); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createRule();collectHiddenTokens(element); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("metaclass"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();collectHiddenTokens(element);((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("metaclass"), proxy); copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); 
                    }

                    }
                    break;
                case 2 :
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:168:3: a1= QNAME
                    {
                    a1=(Token)match(input,QNAME,FOLLOW_QNAME_in_rule694); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createRule();collectHiddenTokens(element); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QNAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("metaclass"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a1,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();collectHiddenTokens(element);((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("metaclass"), proxy); copyLocalizationInfos((CommonToken) a1, element); copyLocalizationInfos((CommonToken) a1, proxy); 
                    }

                    }
                    break;

            }

            a2=(Token)match(input,30,FOLLOW_30_in_rule705); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createRule();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a2, element); 
            }
            pushFollow(FOLLOW_choice_in_rule713);
            a3=choice();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createRule();collectHiddenTokens(element); element.eSet(element.eClass().getEStructuralFeature("definition"), a3); copyLocalizationInfos(a3, element); 
            }
            a4=(Token)match(input,23,FOLLOW_23_in_rule721); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createRule();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a4, element); 
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
    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:175:1: sequence returns [org.emftext.sdk.concretesyntax.Sequence element = null] : (a0= definition )+ ;
    public final org.emftext.sdk.concretesyntax.Sequence sequence() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Sequence element =  null;

        org.emftext.sdk.concretesyntax.Definition a0 = null;




        try {
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:178:1: ( (a0= definition )+ )
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:179:2: (a0= definition )+
            {
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:179:2: (a0= definition )+
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
            	    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:180:3: a0= definition
            	    {
            	    pushFollow(FOLLOW_definition_in_sequence748);
            	    a0=definition();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {
            	      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createSequence();collectHiddenTokens(element); ((List) element.eGet(element.eClass().getEStructuralFeature("parts"))).add(a0); copyLocalizationInfos(a0, element); 
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
    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:184:1: choice returns [org.emftext.sdk.concretesyntax.Choice element = null] : a0= sequence ( (a1= '|' a2= sequence ) )* ;
    public final org.emftext.sdk.concretesyntax.Choice choice() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Choice element =  null;

        Token a1=null;
        org.emftext.sdk.concretesyntax.Sequence a0 = null;

        org.emftext.sdk.concretesyntax.Sequence a2 = null;




        try {
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:187:1: (a0= sequence ( (a1= '|' a2= sequence ) )* )
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:188:2: a0= sequence ( (a1= '|' a2= sequence ) )*
            {
            pushFollow(FOLLOW_sequence_in_choice775);
            a0=sequence();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createChoice();collectHiddenTokens(element); ((List) element.eGet(element.eClass().getEStructuralFeature("options"))).add(a0); copyLocalizationInfos(a0, element); 
            }
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:189:2: ( (a1= '|' a2= sequence ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==31) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:190:3: (a1= '|' a2= sequence )
            	    {
            	    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:190:3: (a1= '|' a2= sequence )
            	    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:191:4: a1= '|' a2= sequence
            	    {
            	    a1=(Token)match(input,31,FOLLOW_31_in_choice792); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {
            	       if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createChoice();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a1, element); 
            	    }
            	    pushFollow(FOLLOW_sequence_in_choice802);
            	    a2=sequence();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {
            	      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createChoice();collectHiddenTokens(element); ((List) element.eGet(element.eClass().getEStructuralFeature("options"))).add(a2); copyLocalizationInfos(a2, element); 
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
    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:197:1: csstring returns [org.emftext.sdk.concretesyntax.CsString element = null] : a0= QUOTED_34_34 ;
    public final org.emftext.sdk.concretesyntax.CsString csstring() throws RecognitionException {
        org.emftext.sdk.concretesyntax.CsString element =  null;

        Token a0=null;



        try {
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:200:1: (a0= QUOTED_34_34 )
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:201:2: a0= QUOTED_34_34
            {
            a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_csstring833); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createCsString();collectHiddenTokens(element); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("value"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
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
    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:204:1: definedplaceholder returns [org.emftext.sdk.concretesyntax.DefinedPlaceholder element = null] : a0= TEXT a1= '[' a2= TEXT a3= ']' (a4= cardinality )? ;
    public final org.emftext.sdk.concretesyntax.DefinedPlaceholder definedplaceholder() throws RecognitionException {
        org.emftext.sdk.concretesyntax.DefinedPlaceholder element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        org.emftext.sdk.concretesyntax.Cardinality a4 = null;




        try {
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:207:1: (a0= TEXT a1= '[' a2= TEXT a3= ']' (a4= cardinality )? )
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:208:2: a0= TEXT a1= '[' a2= TEXT a3= ']' (a4= cardinality )?
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_definedplaceholder856); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDefinedPlaceholder();collectHiddenTokens(element); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenFeature();collectHiddenTokens(element);((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("feature"), proxy); copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); 
            }
            a1=(Token)match(input,32,FOLLOW_32_in_definedplaceholder864); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDefinedPlaceholder();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a1, element); 
            }
            a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_definedplaceholder872); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDefinedPlaceholder();collectHiddenTokens(element); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("token"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a2,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.emftext.sdk.concretesyntax.NormalToken proxy = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken();collectHiddenTokens(element);((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("token"), proxy); copyLocalizationInfos((CommonToken) a2, element); copyLocalizationInfos((CommonToken) a2, proxy); 
            }
            a3=(Token)match(input,33,FOLLOW_33_in_definedplaceholder880); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDefinedPlaceholder();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a3, element); 
            }
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:212:2: (a4= cardinality )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=36 && LA15_0<=38)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:213:3: a4= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_definedplaceholder892);
                    a4=cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDefinedPlaceholder();collectHiddenTokens(element); element.eSet(element.eClass().getEStructuralFeature("cardinality"), a4); copyLocalizationInfos(a4, element); 
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
    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:217:1: derivedplaceholder returns [org.emftext.sdk.concretesyntax.DerivedPlaceholder element = null] : a0= TEXT a1= '[' ( (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? ) )? a5= ']' (a6= cardinality )? ;
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
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:220:1: (a0= TEXT a1= '[' ( (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? ) )? a5= ']' (a6= cardinality )? )
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:221:2: a0= TEXT a1= '[' ( (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? ) )? a5= ']' (a6= cardinality )?
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_derivedplaceholder919); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder();collectHiddenTokens(element); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenFeature();collectHiddenTokens(element);((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("feature"), proxy); copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); 
            }
            a1=(Token)match(input,32,FOLLOW_32_in_derivedplaceholder927); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a1, element); 
            }
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:223:2: ( (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==QUOTED_39_39) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:224:3: (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? )
                    {
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:224:3: (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? )
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:225:4: a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )?
                    {
                    a2=(Token)match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_derivedplaceholder944); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder();collectHiddenTokens(element); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("prefix"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("prefix"), resolved); copyLocalizationInfos((CommonToken) a2, element); 
                    }
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:226:4: ( (a3= ',' a4= QUOTED_39_39 ) )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==18) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:227:5: (a3= ',' a4= QUOTED_39_39 )
                            {
                            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:227:5: (a3= ',' a4= QUOTED_39_39 )
                            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:228:6: a3= ',' a4= QUOTED_39_39
                            {
                            a3=(Token)match(input,18,FOLLOW_18_in_derivedplaceholder967); if (state.failed) return element;
                            if ( state.backtracking==0 ) {
                               if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a3, element); 
                            }
                            a4=(Token)match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_derivedplaceholder979); if (state.failed) return element;
                            if ( state.backtracking==0 ) {
                              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder();collectHiddenTokens(element); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("suffix"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suffix"), resolved); copyLocalizationInfos((CommonToken) a4, element); 
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
               if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a5, element); 
            }
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:235:2: (a6= cardinality )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=36 && LA18_0<=38)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:236:3: a6= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_derivedplaceholder1019);
                    a6=cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder();collectHiddenTokens(element); element.eSet(element.eClass().getEStructuralFeature("cardinality"), a6); copyLocalizationInfos(a6, element); 
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
    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:240:1: containment returns [org.emftext.sdk.concretesyntax.Containment element = null] : (a0= TEXT a1= cardinality | a2= TEXT ) ;
    public final org.emftext.sdk.concretesyntax.Containment containment() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Containment element =  null;

        Token a0=null;
        Token a2=null;
        org.emftext.sdk.concretesyntax.Cardinality a1 = null;




        try {
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:243:1: ( (a0= TEXT a1= cardinality | a2= TEXT ) )
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:244:2: (a0= TEXT a1= cardinality | a2= TEXT )
            {
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:244:2: (a0= TEXT a1= cardinality | a2= TEXT )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==TEXT) ) {
                int LA19_1 = input.LA(2);

                if ( (LA19_1==EOF||LA19_1==TEXT||LA19_1==QUOTED_34_34||(LA19_1>=TEXT_35_ && LA19_1<=TEXT_33_)||LA19_1==23||LA19_1==31||(LA19_1>=34 && LA19_1<=35)) ) {
                    alt19=2;
                }
                else if ( ((LA19_1>=36 && LA19_1<=38)) ) {
                    alt19=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:245:3: a0= TEXT a1= cardinality
                    {
                    a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_containment1050); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createContainment();collectHiddenTokens(element); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenFeature();collectHiddenTokens(element);((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("feature"), proxy); copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); 
                    }
                    pushFollow(FOLLOW_cardinality_in_containment1059);
                    a1=cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createContainment();collectHiddenTokens(element); element.eSet(element.eClass().getEStructuralFeature("cardinality"), a1); copyLocalizationInfos(a1, element); 
                    }

                    }
                    break;
                case 2 :
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:249:3: a2= TEXT
                    {
                    a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_containment1073); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createContainment();collectHiddenTokens(element); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a2,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenFeature();collectHiddenTokens(element);((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("feature"), proxy); copyLocalizationInfos((CommonToken) a2, element); copyLocalizationInfos((CommonToken) a2, proxy); 
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
    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:253:1: compounddefinition returns [org.emftext.sdk.concretesyntax.CompoundDefinition element = null] : a0= '(' a1= choice a2= ')' (a3= cardinality )? ;
    public final org.emftext.sdk.concretesyntax.CompoundDefinition compounddefinition() throws RecognitionException {
        org.emftext.sdk.concretesyntax.CompoundDefinition element =  null;

        Token a0=null;
        Token a2=null;
        org.emftext.sdk.concretesyntax.Choice a1 = null;

        org.emftext.sdk.concretesyntax.Cardinality a3 = null;




        try {
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:256:1: (a0= '(' a1= choice a2= ')' (a3= cardinality )? )
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:257:2: a0= '(' a1= choice a2= ')' (a3= cardinality )?
            {
            a0=(Token)match(input,34,FOLLOW_34_in_compounddefinition1099); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createCompoundDefinition();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a0, element); 
            }
            pushFollow(FOLLOW_choice_in_compounddefinition1107);
            a1=choice();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createCompoundDefinition();collectHiddenTokens(element); element.eSet(element.eClass().getEStructuralFeature("definitions"), a1); copyLocalizationInfos(a1, element); 
            }
            a2=(Token)match(input,35,FOLLOW_35_in_compounddefinition1115); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createCompoundDefinition();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a2, element); 
            }
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:260:2: (a3= cardinality )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=36 && LA20_0<=38)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:261:3: a3= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_compounddefinition1127);
                    a3=cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createCompoundDefinition();collectHiddenTokens(element); element.eSet(element.eClass().getEStructuralFeature("cardinality"), a3); copyLocalizationInfos(a3, element); 
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
    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:265:1: plus returns [org.emftext.sdk.concretesyntax.PLUS element = null] : a0= '+' ;
    public final org.emftext.sdk.concretesyntax.PLUS plus() throws RecognitionException {
        org.emftext.sdk.concretesyntax.PLUS element =  null;

        Token a0=null;



        try {
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:268:1: (a0= '+' )
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:269:2: a0= '+'
            {
            a0=(Token)match(input,36,FOLLOW_36_in_plus1154); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPLUS();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a0, element); 
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
    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:272:1: star returns [org.emftext.sdk.concretesyntax.STAR element = null] : a0= '*' ;
    public final org.emftext.sdk.concretesyntax.STAR star() throws RecognitionException {
        org.emftext.sdk.concretesyntax.STAR element =  null;

        Token a0=null;



        try {
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:275:1: (a0= '*' )
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:276:2: a0= '*'
            {
            a0=(Token)match(input,37,FOLLOW_37_in_star1177); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createSTAR();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a0, element); 
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
    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:279:1: questionmark returns [org.emftext.sdk.concretesyntax.QUESTIONMARK element = null] : a0= '?' ;
    public final org.emftext.sdk.concretesyntax.QUESTIONMARK questionmark() throws RecognitionException {
        org.emftext.sdk.concretesyntax.QUESTIONMARK element =  null;

        Token a0=null;



        try {
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:282:1: (a0= '?' )
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:283:2: a0= '?'
            {
            a0=(Token)match(input,38,FOLLOW_38_in_questionmark1200); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createQUESTIONMARK();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a0, element); 
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
    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:286:1: whitespaces returns [org.emftext.sdk.concretesyntax.WhiteSpaces element = null] : a0= TEXT_35_ ;
    public final org.emftext.sdk.concretesyntax.WhiteSpaces whitespaces() throws RecognitionException {
        org.emftext.sdk.concretesyntax.WhiteSpaces element =  null;

        Token a0=null;



        try {
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:289:1: (a0= TEXT_35_ )
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:290:2: a0= TEXT_35_
            {
            a0=(Token)match(input,TEXT_35_,FOLLOW_TEXT_35__in_whitespaces1223); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createWhiteSpaces();collectHiddenTokens(element); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT_35_");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("amount"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a0,resolvedResolver.getErrorMessage());int resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("amount"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
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
    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:293:1: linebreak returns [org.emftext.sdk.concretesyntax.LineBreak element = null] : a0= TEXT_33_ ;
    public final org.emftext.sdk.concretesyntax.LineBreak linebreak() throws RecognitionException {
        org.emftext.sdk.concretesyntax.LineBreak element =  null;

        Token a0=null;



        try {
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:296:1: (a0= TEXT_33_ )
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:297:2: a0= TEXT_33_
            {
            a0=(Token)match(input,TEXT_33_,FOLLOW_TEXT_33__in_linebreak1246); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createLineBreak();collectHiddenTokens(element); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT_33_");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("tab"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a0,resolvedResolver.getErrorMessage());int resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("tab"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
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
    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:300:1: normaltoken returns [org.emftext.sdk.concretesyntax.NormalToken element = null] : a0= 'DEFINE' a1= TEXT a2= QUOTED_36_36 ( (a3= 'COLLECT' a4= 'IN' a5= TEXT ) )? ;
    public final org.emftext.sdk.concretesyntax.NormalToken normaltoken() throws RecognitionException {
        org.emftext.sdk.concretesyntax.NormalToken element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;



        try {
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:303:1: (a0= 'DEFINE' a1= TEXT a2= QUOTED_36_36 ( (a3= 'COLLECT' a4= 'IN' a5= TEXT ) )? )
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:304:2: a0= 'DEFINE' a1= TEXT a2= QUOTED_36_36 ( (a3= 'COLLECT' a4= 'IN' a5= TEXT ) )?
            {
            a0=(Token)match(input,39,FOLLOW_39_in_normaltoken1269); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_normaltoken1277); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken();collectHiddenTokens(element); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a1, element); 
            }
            a2=(Token)match(input,QUOTED_36_36,FOLLOW_QUOTED_36_36_in_normaltoken1285); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken();collectHiddenTokens(element); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_36_36");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("regex"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("regex"), resolved); copyLocalizationInfos((CommonToken) a2, element); 
            }
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:307:2: ( (a3= 'COLLECT' a4= 'IN' a5= TEXT ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==40) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:308:3: (a3= 'COLLECT' a4= 'IN' a5= TEXT )
                    {
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:308:3: (a3= 'COLLECT' a4= 'IN' a5= TEXT )
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:309:4: a3= 'COLLECT' a4= 'IN' a5= TEXT
                    {
                    a3=(Token)match(input,40,FOLLOW_40_in_normaltoken1302); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a3, element); 
                    }
                    a4=(Token)match(input,41,FOLLOW_41_in_normaltoken1312); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a4, element); 
                    }
                    a5=(Token)match(input,TEXT,FOLLOW_TEXT_in_normaltoken1322); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken();collectHiddenTokens(element); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("attributeName"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("attributeName"), resolved); copyLocalizationInfos((CommonToken) a5, element); 
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
    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:316:1: decoratedtoken returns [org.emftext.sdk.concretesyntax.DecoratedToken element = null] : a0= 'DEFINE' a1= TEXT (a2= '[' (a3= QUOTED_39_39 ) a4= ']' ) a5= QUOTED_36_36 (a6= '[' (a7= QUOTED_39_39 ) a8= ']' ) ( (a9= 'COLLECT' a10= 'IN' a11= TEXT ) )? ;
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
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:319:1: (a0= 'DEFINE' a1= TEXT (a2= '[' (a3= QUOTED_39_39 ) a4= ']' ) a5= QUOTED_36_36 (a6= '[' (a7= QUOTED_39_39 ) a8= ']' ) ( (a9= 'COLLECT' a10= 'IN' a11= TEXT ) )? )
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:320:2: a0= 'DEFINE' a1= TEXT (a2= '[' (a3= QUOTED_39_39 ) a4= ']' ) a5= QUOTED_36_36 (a6= '[' (a7= QUOTED_39_39 ) a8= ']' ) ( (a9= 'COLLECT' a10= 'IN' a11= TEXT ) )?
            {
            a0=(Token)match(input,39,FOLLOW_39_in_decoratedtoken1353); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_decoratedtoken1361); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();collectHiddenTokens(element); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a1, element); 
            }
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:322:2: (a2= '[' (a3= QUOTED_39_39 ) a4= ']' )
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:323:3: a2= '[' (a3= QUOTED_39_39 ) a4= ']'
            {
            a2=(Token)match(input,32,FOLLOW_32_in_decoratedtoken1373); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a2, element); 
            }
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:324:3: (a3= QUOTED_39_39 )
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:325:4: a3= QUOTED_39_39
            {
            a3=(Token)match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_decoratedtoken1387); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();collectHiddenTokens(element); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("prefix"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a3,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("prefix"), resolved); copyLocalizationInfos((CommonToken) a3, element); 
            }

            }

            a4=(Token)match(input,33,FOLLOW_33_in_decoratedtoken1400); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a4, element); 
            }

            }

            a5=(Token)match(input,QUOTED_36_36,FOLLOW_QUOTED_36_36_in_decoratedtoken1411); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();collectHiddenTokens(element); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_36_36");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("regex"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("regex"), resolved); copyLocalizationInfos((CommonToken) a5, element); 
            }
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:330:2: (a6= '[' (a7= QUOTED_39_39 ) a8= ']' )
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:331:3: a6= '[' (a7= QUOTED_39_39 ) a8= ']'
            {
            a6=(Token)match(input,32,FOLLOW_32_in_decoratedtoken1423); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a6, element); 
            }
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:332:3: (a7= QUOTED_39_39 )
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:333:4: a7= QUOTED_39_39
            {
            a7=(Token)match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_decoratedtoken1437); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();collectHiddenTokens(element); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a7.getText(),element.eClass().getEStructuralFeature("suffix"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a7,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suffix"), resolved); copyLocalizationInfos((CommonToken) a7, element); 
            }

            }

            a8=(Token)match(input,33,FOLLOW_33_in_decoratedtoken1450); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a8, element); 
            }

            }

            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:337:2: ( (a9= 'COLLECT' a10= 'IN' a11= TEXT ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==40) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:338:3: (a9= 'COLLECT' a10= 'IN' a11= TEXT )
                    {
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:338:3: (a9= 'COLLECT' a10= 'IN' a11= TEXT )
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:339:4: a9= 'COLLECT' a10= 'IN' a11= TEXT
                    {
                    a9=(Token)match(input,40,FOLLOW_40_in_decoratedtoken1470); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a9, element); 
                    }
                    a10=(Token)match(input,41,FOLLOW_41_in_decoratedtoken1480); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a10, element); 
                    }
                    a11=(Token)match(input,TEXT,FOLLOW_TEXT_in_decoratedtoken1490); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();collectHiddenTokens(element); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a11.getText(),element.eClass().getEStructuralFeature("attributeName"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a11,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("attributeName"), resolved); copyLocalizationInfos((CommonToken) a11, element); 
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
    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:346:1: predefinedtoken returns [org.emftext.sdk.concretesyntax.PreDefinedToken element = null] : a0= 'PREDEFINED' a1= TEXT ( (a2= 'COLLECT' a3= 'IN' a4= TEXT ) )? ;
    public final org.emftext.sdk.concretesyntax.PreDefinedToken predefinedtoken() throws RecognitionException {
        org.emftext.sdk.concretesyntax.PreDefinedToken element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;



        try {
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:349:1: (a0= 'PREDEFINED' a1= TEXT ( (a2= 'COLLECT' a3= 'IN' a4= TEXT ) )? )
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:350:2: a0= 'PREDEFINED' a1= TEXT ( (a2= 'COLLECT' a3= 'IN' a4= TEXT ) )?
            {
            a0=(Token)match(input,42,FOLLOW_42_in_predefinedtoken1521); if (state.failed) return element;
            if ( state.backtracking==0 ) {
               if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_predefinedtoken1529); if (state.failed) return element;
            if ( state.backtracking==0 ) {
              if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken();collectHiddenTokens(element); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a1, element); 
            }
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:352:2: ( (a2= 'COLLECT' a3= 'IN' a4= TEXT ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==40) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:353:3: (a2= 'COLLECT' a3= 'IN' a4= TEXT )
                    {
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:353:3: (a2= 'COLLECT' a3= 'IN' a4= TEXT )
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:354:4: a2= 'COLLECT' a3= 'IN' a4= TEXT
                    {
                    a2=(Token)match(input,40,FOLLOW_40_in_predefinedtoken1546); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a2, element); 
                    }
                    a3=(Token)match(input,41,FOLLOW_41_in_predefinedtoken1556); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken();collectHiddenTokens(element); copyLocalizationInfos((CommonToken)a3, element); 
                    }
                    a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_predefinedtoken1566); if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                      if (element == null) element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken();collectHiddenTokens(element); org.emftext.runtime.resource.ITokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("attributeName"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("attributeName"), resolved); copyLocalizationInfos((CommonToken) a4, element); 
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
    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:361:1: tokendefinition returns [org.emftext.sdk.concretesyntax.TokenDefinition element = null] : (c0= normaltoken | c1= decoratedtoken | c2= predefinedtoken );
    public final org.emftext.sdk.concretesyntax.TokenDefinition tokendefinition() throws RecognitionException {
        org.emftext.sdk.concretesyntax.TokenDefinition element =  null;

        org.emftext.sdk.concretesyntax.NormalToken c0 = null;

        org.emftext.sdk.concretesyntax.DecoratedToken c1 = null;

        org.emftext.sdk.concretesyntax.PreDefinedToken c2 = null;


        try {
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:363:1: (c0= normaltoken | c1= decoratedtoken | c2= predefinedtoken )
            int alt24=3;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==39) ) {
                int LA24_1 = input.LA(2);

                if ( (LA24_1==TEXT) ) {
                    int LA24_3 = input.LA(3);

                    if ( (LA24_3==32) ) {
                        alt24=2;
                    }
                    else if ( (LA24_3==QUOTED_36_36) ) {
                        alt24=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 24, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 24, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA24_0==42) ) {
                alt24=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:364:2: c0= normaltoken
                    {
                    pushFollow(FOLLOW_normaltoken_in_tokendefinition1593);
                    c0=normaltoken();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:365:2: c1= decoratedtoken
                    {
                    pushFollow(FOLLOW_decoratedtoken_in_tokendefinition1603);
                    c1=decoratedtoken();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:366:2: c2= predefinedtoken
                    {
                    pushFollow(FOLLOW_predefinedtoken_in_tokendefinition1613);
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
    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:369:1: definition returns [org.emftext.sdk.concretesyntax.Definition element = null] : (c0= csstring | c1= definedplaceholder | c2= derivedplaceholder | c3= containment | c4= compounddefinition | c5= whitespaces | c6= linebreak );
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
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:371:1: (c0= csstring | c1= definedplaceholder | c2= derivedplaceholder | c3= containment | c4= compounddefinition | c5= whitespaces | c6= linebreak )
            int alt25=7;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:372:2: c0= csstring
                    {
                    pushFollow(FOLLOW_csstring_in_definition1632);
                    c0=csstring();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:373:2: c1= definedplaceholder
                    {
                    pushFollow(FOLLOW_definedplaceholder_in_definition1642);
                    c1=definedplaceholder();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:374:2: c2= derivedplaceholder
                    {
                    pushFollow(FOLLOW_derivedplaceholder_in_definition1652);
                    c2=derivedplaceholder();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; 
                    }

                    }
                    break;
                case 4 :
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:375:2: c3= containment
                    {
                    pushFollow(FOLLOW_containment_in_definition1662);
                    c3=containment();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c3; 
                    }

                    }
                    break;
                case 5 :
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:376:2: c4= compounddefinition
                    {
                    pushFollow(FOLLOW_compounddefinition_in_definition1672);
                    c4=compounddefinition();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c4; 
                    }

                    }
                    break;
                case 6 :
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:377:2: c5= whitespaces
                    {
                    pushFollow(FOLLOW_whitespaces_in_definition1682);
                    c5=whitespaces();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c5; 
                    }

                    }
                    break;
                case 7 :
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:378:2: c6= linebreak
                    {
                    pushFollow(FOLLOW_linebreak_in_definition1692);
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
    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:381:1: cardinality returns [org.emftext.sdk.concretesyntax.Cardinality element = null] : (c0= plus | c1= star | c2= questionmark );
    public final org.emftext.sdk.concretesyntax.Cardinality cardinality() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Cardinality element =  null;

        org.emftext.sdk.concretesyntax.PLUS c0 = null;

        org.emftext.sdk.concretesyntax.STAR c1 = null;

        org.emftext.sdk.concretesyntax.QUESTIONMARK c2 = null;


        try {
            // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:383:1: (c0= plus | c1= star | c2= questionmark )
            int alt26=3;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt26=1;
                }
                break;
            case 37:
                {
                alt26=2;
                }
                break;
            case 38:
                {
                alt26=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:384:2: c0= plus
                    {
                    pushFollow(FOLLOW_plus_in_cardinality1711);
                    c0=plus();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:385:2: c1= star
                    {
                    pushFollow(FOLLOW_star_in_cardinality1721);
                    c1=star();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // ./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g:386:2: c2= questionmark
                    {
                    pushFollow(FOLLOW_questionmark_in_cardinality1731);
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


    protected DFA25 dfa25 = new DFA25(this);
    static final String DFA25_eotS =
        "\12\uffff";
    static final String DFA25_eofS =
        "\2\uffff\1\7\7\uffff";
    static final String DFA25_minS =
        "\1\4\1\uffff\1\4\3\uffff\1\4\3\uffff";
    static final String DFA25_maxS =
        "\1\42\1\uffff\1\46\3\uffff\1\41\3\uffff";
    static final String DFA25_acceptS =
        "\1\uffff\1\1\1\uffff\1\5\1\6\1\7\1\uffff\1\4\1\2\1\3";
    static final String DFA25_specialS =
        "\12\uffff}>";
    static final String[] DFA25_transitionS = {
            "\1\2\2\uffff\1\1\1\uffff\1\4\1\5\27\uffff\1\3",
            "",
            "\1\7\2\uffff\1\7\1\uffff\2\7\14\uffff\1\7\7\uffff\1\7\1\6"+
            "\1\uffff\5\7",
            "",
            "",
            "",
            "\1\10\3\uffff\1\11\30\uffff\1\11",
            "",
            "",
            ""
    };

    static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
    static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
    static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
    static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
    static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
    static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
    static final short[][] DFA25_transition;

    static {
        int numStates = DFA25_transitionS.length;
        DFA25_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = DFA25_eot;
            this.eof = DFA25_eof;
            this.min = DFA25_min;
            this.max = DFA25_max;
            this.accept = DFA25_accept;
            this.special = DFA25_special;
            this.transition = DFA25_transition;
        }
        public String getDescription() {
            return "369:1: definition returns [org.emftext.sdk.concretesyntax.Definition element = null] : (c0= csstring | c1= definedplaceholder | c2= derivedplaceholder | c3= containment | c4= compounddefinition | c5= whitespaces | c6= linebreak );";
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
    public static final BitSet FOLLOW_TEXT_in_containment1050 = new BitSet(new long[]{0x0000007000000000L});
    public static final BitSet FOLLOW_cardinality_in_containment1059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_containment1073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_compounddefinition1099 = new BitSet(new long[]{0x0000000400000690L});
    public static final BitSet FOLLOW_choice_in_compounddefinition1107 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_compounddefinition1115 = new BitSet(new long[]{0x0000007000000002L});
    public static final BitSet FOLLOW_cardinality_in_compounddefinition1127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_plus1154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_star1177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_questionmark1200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_35__in_whitespaces1223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_33__in_linebreak1246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_normaltoken1269 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_normaltoken1277 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_QUOTED_36_36_in_normaltoken1285 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_normaltoken1302 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_normaltoken1312 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_normaltoken1322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_decoratedtoken1353 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_decoratedtoken1361 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_decoratedtoken1373 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_decoratedtoken1387 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_decoratedtoken1400 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_QUOTED_36_36_in_decoratedtoken1411 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_decoratedtoken1423 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_decoratedtoken1437 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_decoratedtoken1450 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_decoratedtoken1470 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_decoratedtoken1480 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_decoratedtoken1490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_predefinedtoken1521 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_predefinedtoken1529 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_predefinedtoken1546 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_predefinedtoken1556 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_predefinedtoken1566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normaltoken_in_tokendefinition1593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decoratedtoken_in_tokendefinition1603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predefinedtoken_in_tokendefinition1613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_csstring_in_definition1632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definedplaceholder_in_definition1642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_derivedplaceholder_in_definition1652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_containment_in_definition1662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compounddefinition_in_definition1672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whitespaces_in_definition1682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_linebreak_in_definition1692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_plus_in_cardinality1711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_star_in_cardinality1721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_questionmark_in_cardinality1731 = new BitSet(new long[]{0x0000000000000002L});

}